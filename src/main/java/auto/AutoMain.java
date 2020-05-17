package auto;

import auto.bean.utils.BeanUtils;
import auto.freemarker.FreemarkerUtils;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/29
 * 版 本: v1.0
 **/
public class AutoMain {
//    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
//        jpa();
//        BeanUtils.openFileDirectory(BeanConfig.JPA_CLASS_PATH);
//    }
//
//    public static void jpa() throws PropertyVetoException, SQLException {
//        JpaUtils.commonDataBase("bean.mysql", BeanConfig.JPA_IMPORTS_BEAN, "Entity", "bean");
//        JpaUtils.commonDataBase("bean_vo.mysql", BeanConfig.JPA_IMPORTS_BEAN_VO, "VO", "vo");
//        JpaUtils.commonDataBase("repository.mysql", BeanConfig.JPA_IMPORTS_REPOSITORY, "Repository", "repository");
//        JpaUtils.commonDataBase("service.mysql", BeanConfig.JPA_IMPORTS_SERVICE, "Service", "service");
//        JpaUtils.commonDataBase("service_impl.mysql", BeanConfig.JPA_IMPORTS_SERVICE_IMPL, "ServiceImpl", "service//impl");
//        JpaUtils.commonDataBase("controller.mysql", BeanConfig.JPA_IMPORTS_CONTROLLER, "Controller", "controller");
//    }

    public static void main(String[] args) {
        FreemarkerUtils freemarkerUtils = new FreemarkerUtils();
        freemarkerUtils.commonDataBase("bean.ftl", "Entity", "bean");
        BeanUtils.openFileDirectory(BeanConfig.JPA_CLASS_PATH);
    }
}
