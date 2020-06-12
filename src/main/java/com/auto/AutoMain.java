package com.auto;

import com.auto.entities.TableBO;
import com.auto.utils.C3P0Utils;
import com.auto.utils.FreemarkerUtils;

import java.util.List;

/**
 * @author zhou lin
 * @description 项目入口
 * @create 2020-06-07 17:15
 */
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
//        FreemarkerUtils freemarkerUtils = new FreemarkerUtils();
//        freemarkerUtils.commonDataBase("bean.ftl", "Entity", "bean");
//        BeanUtils.openFileDirectory(BeanConfig.JPA_CLASS_PATH);

//        String s = null;
//        Optional<String> empty = Optional.ofNullable(s);
//        System.out.println("是否有值："+ empty.isPresent());
//        empty.ifPresent(x -> System.out.println(x));
//        System.out.println(empty.equals("1"));
//        System.out.println(empty.equals(Optional.of("11")));
//        System.out.println(empty.orElse("111"));
//        System.out.println(s.equals("1"));
        FreemarkerUtils freemarkerUtils = new FreemarkerUtils();
        freemarkerUtils.commonDataBase("bean.ftl", "Entity", "bean");
//        List<TableBO> tableBOS = C3P0Utils.tableColumnType();
//        tableBOS.forEach(System.out::println);
    }
}
