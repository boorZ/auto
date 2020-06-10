package com.auto.entities;

import lombok.Data;
import java.util.List;

/**
 * @author zhou lin
 * @description 数据库表实体类
 * @create 2020-06-07 17:15
 */
@Data
public class TableBO {
    /**
     * 表名
     **/
    private Object tableName;
    /**
     * 主键
     **/
    private ColumnBO primaryKey;
    /**
     * 列名集
     **/
    private List<ColumnBO> columnCountList;

    public TableBO() {
    }

    public TableBO(Object tableName, List<ColumnBO> columnCountList) {
        this.tableName = tableName;
        this.columnCountList = columnCountList;
    }
}
