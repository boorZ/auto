package auto.c3p0.entities;

import lombok.Data;

import java.util.List;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/28
 * 版 本: v1.0
 **/
@Data
public class TableBO {
    /**
     * 表名
     **/
    private Object tableName;
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
