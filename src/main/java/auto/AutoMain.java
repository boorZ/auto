package auto;

import auto.bean.utils.BeanUtils;
import auto.freemarker.JpaUtils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/29
 * 版 本: v1.0
 **/
public class AutoMain {
    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
        jpa();
        BeanUtils.openFileDirectory(BeanConfig.JPA_CLASS_PATH);
    }

    public static void jpa() throws PropertyVetoException, SQLException {
        JpaUtils.jpaBase("bean.ftl", BeanConfig.JPA_IMPORTS_BEAN, "Entity", "bean");
        JpaUtils.jpaBase("bean_vo.ftl", BeanConfig.JPA_IMPORTS_BEAN_VO, "VO", "vo");
        JpaUtils.jpaBase("repository.ftl", BeanConfig.JPA_IMPORTS_REPOSITORY, "Repository", "repository");
        JpaUtils.jpaBase("service.ftl", BeanConfig.JPA_IMPORTS_SERVICE, "Service", "service");
        JpaUtils.jpaBase("service_impl.ftl", BeanConfig.JPA_IMPORTS_SERVICE_IMPL, "ServiceImpl", "service//impl");
        JpaUtils.jpaBase("controller.ftl", BeanConfig.JPA_IMPORTS_CONTROLLER, "Controller", "controller");
    }
}
