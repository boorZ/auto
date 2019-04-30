package auto.freemarker.templates.ftlutils;

import auto.BeanConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/28
 * 版 本: v1.0
 **/
public class FreemarkerUtils {

    public static void base(Map<String, Object> dataMap, String ftlName, String dir, String newFileName) {
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
            File newDir=new File(BeanConfig.JPA_CLASS_PATH + dir);
            File newFile = new File(newDir,newFileName);
            if (!newDir.exists()) {
                newDir.mkdirs();
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
