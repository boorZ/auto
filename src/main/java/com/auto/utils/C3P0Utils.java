package com.auto.utils;

import com.auto.BeanConfig;
import com.auto.entities.ColumnBO;
import com.auto.entities.TableBO;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhou lin
 * @description 数据库C3P0工具实体类
 * @create 2020-06-07 17:15
 */
@Slf4j
public class C3P0Utils {

    private static ComboPooledDataSource cpds;
    private static Connection con;
    private static Statement sta;
    private static DatabaseMetaData dbMetaData;

    /*
     * 只执行一次,可以通过Class.forName("classPath")的方式唤醒代码的static代码块,但是也执行一次。
     */
    static {
        getConnection();
    }

    /**
     * 获取Connection
     */
    private static void getConnection() {
        try {
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://" + BeanConfig.DB_IP + "/" + BeanConfig.DB_DATABASE +
                    "?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
            cpds.setUser(BeanConfig.DB_USER);
            cpds.setPassword(BeanConfig.DB_PASSWORD);
            // 得到一个Connection
            con = cpds.getConnection();
            // 获取数据库元数据
            dbMetaData = con.getMetaData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据Sql获取数据库结果集
     *
     * @param sql Sql语句
     */
    public static ResultSet getConnection(String sql) {
        ResultSet rs = null;
        try {
            sta = con.createStatement();
            rs = sta.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs == null) {
            log.info("Sql错误，无法获取数据库结果集");
        }
        return rs;
    }

    /**
     * 获得数据库的一些相关信息
     */
    public void getDataBaseInfo() {
        ResultSet rs = null;
        try {
            log.info("数据库已知的用户: " + dbMetaData.getUserName());
            log.info("数据库的系统函数的逗号分隔列表: " + dbMetaData.getSystemFunctions());
            log.info("数据库的时间和日期函数的逗号分隔列表: " + dbMetaData.getTimeDateFunctions());
            log.info("数据库的字符串函数的逗号分隔列表: " + dbMetaData.getStringFunctions());
            log.info("数据库供应商用于 'schema' 的首选术语: " + dbMetaData.getSchemaTerm());
            log.info("数据库URL: " + dbMetaData.getURL());
            log.info("是否允许只读:" + dbMetaData.isReadOnly());
            log.info("数据库的产品名称:" + dbMetaData.getDatabaseProductName());
            log.info("数据库的版本:" + dbMetaData.getDatabaseProductVersion());
            log.info("驱动程序的名称:" + dbMetaData.getDriverName());
            log.info("驱动程序的版本:" + dbMetaData.getDriverVersion());

            log.info("-数据库中使用的表类型-");
            rs = dbMetaData.getTableTypes();
            while (rs.next()) {
                log.info(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeRs(rs);
        }
    }

    /**
     * 获得一个表的主键信息
     *
     * @param schemaName 模式名称
     * @param tableName  表名
     * @return 该表的主键名称
     */
    public static String getAllPrimaryKey(String schemaName, String tableName) {
        List<String> primaryNames = new LinkedList<>();
        ResultSet rs = null;
        try {
            rs = dbMetaData.getPrimaryKeys(null, schemaName, tableName);
            while (rs.next()) {
                //列名
                String columnName = rs.getString("COLUMN_NAME");
//                //序列号(主键内值1表示第一列的主键，值2代表主键内的第二列)
//                short keySeq = rs.getShort("KEY_SEQ");
//                //主键名称
//                String pkName = rs.getString("PK_NAME");
//                log.info(columnName + "-" + keySeq + "-" + pkName);
                primaryNames.add(columnName);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeRs(rs);
        }
        if (CollectionUtils.isNotEmpty(primaryNames) && primaryNames.size() > 1) {
            log.info(tableName + "表存在多个主键");
            return "";
        }
        return primaryNames.get(0);
    }

    /**
     * 获取表名、列名、列类型
     *
     * @return 封装表名、列名、列类型
     */
    public static List<TableBO> tableColumnType() {
        List<TableBO> tableList = new ArrayList<>();
        ResultSet rs = getConnection("show tables");
        try {
            while (rs.next()) {
                // 表名
                Object tableName = rs.getObject(1);
                // 根据表名获取对应列名和列类型
                TableBO tableBO = new TableBO(tableName, getColumn(tableName));
                tableList.add(tableBO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeRs(rs);
        }
        return tableList;
    }

    /**
     * 根据表名来返回该表对应列名和列类型
     *
     * @param tableName 表名
     * @return 该表对应列名和列类型
     */
    private static List<ColumnBO> getColumn(Object tableName) {
        ResultSet rs = getConnection("select * from " + tableName);
        // 主键
        String primaryKeys = getAllPrimaryKey(null, tableName.toString());
        // 字段对象集
        List<ColumnBO> columnList = new ArrayList<>();
        try {
            // 获取表结构
            ResultSetMetaData rsmd = rs.getMetaData();
            // 字段总数
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                // 字段名称
                String columnName = rsmd.getColumnName(i);
                // 字段类型名称
                String columnTypeName = rsmd.getColumnTypeName(i);
                // 将字段名转成驼峰命名
                String columnNameToggleCase = BeanUtils.toggleCase(columnName, true);
                // 存入字段对象
                ColumnBO columnBO = new ColumnBO(columnName, columnNameToggleCase, columnTypeName);
                columnList.add(columnBO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeRs(rs);
        }
        return columnList;
    }

    public void close() {
        Optional.ofNullable(sta).ifPresent(r -> {
            try {
                r.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        Optional.ofNullable(con).ifPresent(r -> {
            try {
                r.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        Optional.ofNullable(cpds).ifPresent(AbstractPoolBackedDataSource::close);
    }

    private static void closeRs(ResultSet rs) {
        Optional.ofNullable(rs).ifPresent(r -> {
            try {
                r.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
