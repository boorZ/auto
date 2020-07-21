package com.auto.entities.ftl.mysql.puls;

import com.auto.entities.ColumnBO;
import lombok.Data;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author zhou lin
 * @description MySqlPlus响应类
 * @create 2020-06-07 17:15
 */
@Data
public class MySqlPlusResBO {
    /**
     * 类名
     */
    private String className;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 类路径
     */
    private String classPath;
    /**
     * 文件名
     */
    @Deprecated
    private String fileName;
    /**
     * 列名集
     */
    private List<ColumnBO> columns;
    /**
     * dao类名
     */
    private String daoName;
    /**
     * service类名
     */
    private String serviceName;
    /**
     * serviceImpl类名
     */
    private String serviceImplName;

    public static MySqlPlusResBO create(final Supplier<MySqlPlusResBO> supplier) {
        return supplier.get();
    }
}
