package com.auto.entities;

import lombok.Data;

/**
 * @author zhou lin
 * @description 数据库列实体类
 * @create 2020-06-07 17:15
 */
@Data
public class ColumnBO {
    /**
     * 列名
     **/
    private Object columnName;
    /**
     * 驼峰列名
     **/
    private Object humpColumnName;
    /**
     * 列类型
     **/
    private Object columnTypeName;

    public ColumnBO() {
    }

    public ColumnBO(Object columnName, Object humpColumnName, Object columnTypeName) {
        this.columnName = columnName;
        this.humpColumnName = humpColumnName;
        this.columnTypeName = columnTypeName;
    }
}
