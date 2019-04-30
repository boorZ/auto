package auto.c3p0;

import auto.BeanConfig;
import auto.bean.utils.BeanUtils;
import auto.c3p0.pojo.ColumnPOJO;
import auto.c3p0.pojo.TablePOJO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/28
 * 版 本: v1.0
 **/
public class C3P0Utils {

    private static  ComboPooledDataSource cpds;
    private static Connection con;
    private static Statement sta;
    private static ResultSet rs;

    /**
     * 获取Connection
     * @return
     * @throws SQLException
     * @throws PropertyVetoException
     */
    public static Connection getconnection() throws SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql:///"+BeanConfig.JPA_DATABASE+"?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
        cpds.setUser(BeanConfig.JPA_USER);
        cpds.setPassword(BeanConfig.JPA_PASSWORD);
        // 得到一个Connection
        con = cpds.getConnection();
        return con;
    }
    public static ResultSet getConnection(String sql) throws SQLException, PropertyVetoException {
        con = getconnection();
        sta = con.createStatement();
        rs = sta.executeQuery(sql);
        return rs;
    }
    public static void close() throws SQLException {
        rs.close();
        sta.close();
        con.close();
        cpds.close();
    }

    /**
     * 封装表名、列名、列类型
     * @return
     * @throws PropertyVetoException
     * @throws SQLException
     */
    public static List<TablePOJO> tableColumnType() throws PropertyVetoException, SQLException {
        List<TablePOJO> tableList = new ArrayList<>();
        ResultSet rs = getConnection("show tables");
        while (rs.next()) {
            // 表名
            Object tableName = rs.getObject(1);
            tableList.add(new TablePOJO(tableName, getColumn(tableName)));
        }
        rs.close();
        close();
        return tableList;
    }

    /**
     * 根据表名来返回该表对应列名和列类型
     * @param table
     * @return
     * @throws SQLException
     * @throws PropertyVetoException
     */
    public static List<ColumnPOJO> getColumn(Object table) throws SQLException, PropertyVetoException {
        List<ColumnPOJO> columnList = new ArrayList<>();
        ResultSet tableName = C3P0Utils.getConnection("select * from "+table);
        ResultSetMetaData rsmd = tableName.getMetaData();
        // 字段总数
        int columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String humpConlumName = BeanUtils.toHump(rsmd.getColumnName(i), 1);
            columnList.add(new ColumnPOJO(rsmd.getColumnName(i), humpConlumName, rsmd.getColumnTypeName(i)));
        }
        return columnList;
    }
}
