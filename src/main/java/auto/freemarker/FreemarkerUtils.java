package auto.freemarker;

import auto.BeanConfig;
import auto.c3p0.C3P0Utils;
import auto.c3p0.entities.TableBO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static auto.bean.utils.BeanUtils.toggleCase;

/**
 * 描 述: Freemarker工具类
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2020/5/12
 * 版 本: v1.0
 **/
public class FreemarkerUtils {
    private Logger log = LoggerFactory.getLogger(FreemarkerUtils.class);

    private final static String UNDERLINE = "_";

    static {

    }

    public static void main(String[] args) {
//        C3P0Utils.getDataBaseInfo();

//        Connection conn = C3P0Utils.getConnection();
//
//        DatabaseMetaData metaData = conn.getMetaData();
//        ResultSet rs = metaData.getPrimaryKeys(null, "", "t_user");
//        while (rs.next()) {
//            // 列名
//            String columnName = rs.getString("COLUMN_NAME");
//            // 序列号(主键内值1表示第一列的主键，值2代表主键内的第二列)
//            short keySeq = rs.getShort("KEY_SEQ");
//            // 主键名称
//            String pkName = rs.getString("PK_NAME");
//            System.out.println(columnName + "-" + keySeq + "-" + pkName);
//        }
//        rs.close();
//        conn.close();
//        C3P0Utils.close();

        C3P0Utils c3P0Utils = new C3P0Utils();
        List<TableBO> tableBOS = c3P0Utils.tableColumnType();
        for (TableBO tableBO : tableBOS) {
            System.out.println();
            List<String> allPrimaryKeys = c3P0Utils.getAllPrimaryKeys(null, tableBO.getTableName().toString());
            System.out.println(allPrimaryKeys);
            System.out.println(tableBO);
        }
        c3P0Utils.close();
    }

    /**
     * @param dataMap     生成文件所需数据
     * @param ftlName     ftl文件名称
     * @param fileDir     文件路径
     * @param fileName 生成文件新名称
     */
    public void commonFreeMarkerBase(Map<String, Object> dataMap, String ftlName, String fileDir, String fileName) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(BeanConfig.JPA_TEMPLATE_PATH));
            // step3 创建数据模型
            // step4 加载模版文件
            Template template = configuration.getTemplate(ftlName);
            // step5 生成数据
            File newFileDir = new File(BeanConfig.JPA_CLASS_PATH + fileDir);
            File newFile = new File(newFileDir, fileName);
            if (!newFileDir.exists()) {
                newFileDir.mkdirs();
                newFile.createNewFile();
            }
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
            // step6 输出文件
            template.process(dataMap, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param ftlName     ftl文件名称
     * @param javaPostfix 生成Java文件后缀名
     * @param fileDir     文件路径
     */
    public void commonDataBase(String ftlName, String javaPostfix, String fileDir) {
        C3P0Utils c3P0Utils = new C3P0Utils();
        // 获取表名、列名、列类型
        List<TableBO> tableList = c3P0Utils.tableColumnType();
        for (TableBO table : tableList) {
            // 表名转成驼峰命名
            String hump = toggleCase((String) table.getTableName(), true);
            // 生成文件名称
            String java = hump + javaPostfix;
//            // 生成文件路径
//            String classPath = BeanConfig.JPA_CLASS_PATH;
//            if (classPath.contains("src/main/java")) {
//                classPath = classPath.split("src/main/java/")[1].replace("/", ".");
//                classPath += fileDir;
//            } else {
//                classPath = null;
//            }

            Map<String, Object> map = new HashMap<>();
//            map.put("classPath", classPath);
            map.put("className", table.getTableName());
            map.put("fileName", java);
            map.put("newMember", table.getColumnCountList());
            map.put("T", hump + "Entity");
            map.put("Service", hump + "Service");
            map.put("Repository", hump + "Repository");
            map.put("mapping", javaPostfix);

            commonFreeMarkerBase(map, ftlName, fileDir, java + ".java");
        }
        c3P0Utils.close();
    }
}
