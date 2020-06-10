package com.auto.entities.ftl.mysql.puls;

import com.auto.entities.ColumnBO;
import lombok.Data;

import java.util.List;

/**
 * @author zhou lin
 * @description MySqlPlus实体类
 * @create 2020-06-07 17:15
 */
@Data
public class MySqlPlusBO {
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
    private String fieName;
    /**
     * 列名集
     */
    private List<ColumnBO> columnList;
    /**
     * 实体类
     */
    private String bo;
//    /**
//     * 类路径
//     */
//    private String classPath;


}
