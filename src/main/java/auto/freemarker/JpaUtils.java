package auto.freemarker;

import auto.BeanConfig;
import auto.bean.utils.BeanUtils;
import auto.c3p0.C3P0Utils;
import auto.c3p0.pojo.ColumnPOJO;
import auto.c3p0.pojo.TablePOJO;
import auto.freemarker.templates.ftlutils.FreemarkerUtils;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/29
 * 版 本: v1.0
 **/
public class JpaUtils {

//    public static Map<String, Object> jpaBase(TablePOJO table, String dir, String imports, String fileName) throws PropertyVetoException, SQLException {
//        Map<String, Object> map = new HashMap<>();
//        map.put("imports", imports);
//        map.put("className", table.getTableName());
//        map.put("fileName", fileName);
//        map.put("newMember", filtration(table.getColumnCountList()));
//        String hump = BeanUtils.toHump((String) table.getTableName(), 1);
//        map.put("T", hump + "Entity");
//        map.put("Service", hump + "Service");
//        map.put("Repository", hump + "Repository");
//        return map;
//    }

    /**
     *
     * @param ftlName
     * @param beanConfig
     * @param javaPostfix
     * @param fileName
     * @throws PropertyVetoException
     * @throws SQLException
     */
    public static void jpaBase(String ftlName, String beanConfig, String javaPostfix, String fileName) throws PropertyVetoException, SQLException {

        List<TablePOJO> tableList = C3P0Utils.tableColumnType();
        for (TablePOJO table : tableList) {
            String hump = BeanUtils.toHump((String) table.getTableName(), 1);
            String java = hump + javaPostfix;

            Map<String, Object> map = new HashMap<>();

            String classPath = BeanConfig.JPA_CLASS_PATH;
            if (classPath.contains("src/main/java")) {
                classPath = classPath.split("src/main/java/")[1].replace("/", ".");
                classPath += fileName;
            } else {
                classPath = null;
            }
            map.put("classPath", classPath);
            map.put("imports", beanConfig);
            map.put("className", table.getTableName());
            map.put("fileName", java);
            map.put("newMember", filtration(table.getColumnCountList()));
            map.put("T", hump + "Entity");
            map.put("Service", hump + "Service");
            map.put("Repository", hump + "Repository");
            map.put("mapping", javaPostfix);
            FreemarkerUtils.base(map, ftlName, fileName, java+".java");
        }
    }

    /** 过滤 **/
    private static List<ColumnPOJO> filtration(List<ColumnPOJO> columnPOJOList) {
        List<ColumnPOJO> columnCountList = new ArrayList<>();
        for (ColumnPOJO columnPOJO : columnPOJOList) {
            if (!BeanConfig.JPA_NEGLECT_FIELDS.contains((CharSequence) columnPOJO.getConlumName())) {
                columnCountList.add(columnPOJO);
            }
        }
        return columnCountList;
    }
}
