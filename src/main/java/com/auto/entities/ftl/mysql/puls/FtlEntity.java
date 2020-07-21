package com.auto.entities.ftl.mysql.puls;

import lombok.Data;

/**
 * @author zhou lin
 * @description ftl实体类
 * @create 2020-06-15 11:36
 */
@Data
public class FtlEntity {
    /**
     * ftl文件名称
     */
    private String ftlName;
    /**
     * ftl文件
     */
    private String ftlPath;
    /**
     * ftl文件后缀
     */
    private String ftlPostfix;
}
