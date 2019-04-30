package auto.c3p0.pojo;

import java.util.List;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/28
 * 版 本: v1.0
 **/
public class TablePOJO {
    // 表名
    private Object tableName;
    // 列名集
    private List<ColumnPOJO> columnCountList;

    public Object getTableName() {
        return tableName;
    }

    public void setTableName(Object tableName) {
        this.tableName = tableName;
    }

    public List<ColumnPOJO> getColumnCountList() {
        return columnCountList;
    }

    public void setColumnCountList(List<ColumnPOJO> columnCountList) {
        this.columnCountList = columnCountList;
    }

    public TablePOJO() {
    }

    public TablePOJO(Object tableName, List<ColumnPOJO> columnCountList) {
        this.tableName = tableName;
        this.columnCountList = columnCountList;
    }

    @Override
    public String toString() {
        return "TablePOJO{" +
                "tableName=" + tableName +
                ", columnCountList=" + columnCountList +
                '}';
    }
}
