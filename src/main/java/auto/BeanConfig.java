package auto;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/29
 * 版 本: v1.0
 **/
public class BeanConfig {
    /** 数据库用户 **/
    public static String JPA_USER = "root";
    /** 数据库密码 **/
    public static String JPA_PASSWORD = "123456";
    /** 数据库 **/
    public static String JPA_DATABASE = "zl";
    /** 忽略字段 **/
    public static String JPA_NEGLECT_FIELDS = "id";
    /** ftl模板所在目录 **/
    public static String JPA_TEMPLATE_PATH = "src/main/java/auto/freemarker/templates/jpa/";
    /** 生成文件路径 **/
    public static String JPA_CLASS_PATH = "C:\\Users\\Administrator\\Desktop\\autoCode\\";

    /** 不同文件导入的包 **/
    public static String JPA_IMPORTS_BEAN = "import common.model.BaseEntity;\nimport javax.persistence.Column;\nimport javax.persistence.Entity;\nimport javax.persistence.Table;";
    public static String JPA_IMPORTS_BEAN_VO = "import common.model.BaseEntity;";
    public static String JPA_IMPORTS_REPOSITORY = "import common.repository.CommonRepository;\nimport org.springframework.data.repository.NoRepositoryBean;";
    public static String JPA_IMPORTS_SERVICE = "import common.service.SimpCommonService;";
    public static String JPA_IMPORTS_SERVICE_IMPL = "import common.repository.CommonRepository;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Service;";
    public static String JPA_IMPORTS_CONTROLLER = "import org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RestController;";
}
