package auto.c3p0.pojo;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/28
 * 版 本: v1.0
 **/
public class ColumnPOJO {
    // 列名
    private Object conlumName;
    // 驼峰列名
    private Object humpConlumName;
    // 列类型
    private Object conlumTypeName;

    public Object getConlumName() {
        return conlumName;
    }

    public Object getHumpConlumName() {
        return humpConlumName;
    }

    public void setHumpConlumName(Object humpConlumName) {
        this.humpConlumName = humpConlumName;
    }

    public void setConlumName(Object conlumName) {
        this.conlumName = conlumName;
    }

    public Object getConlumTypeName() {
        switch (conlumTypeName.toString()) {
            case "INT":
                return "int";
            case "VARCHAR":
                return "String";
            default:
                return "";
        }
    }

    public void setConlumTypeName(Object conlumTypeName) {
        this.conlumTypeName = conlumTypeName;
    }

    public ColumnPOJO() {
    }

    public ColumnPOJO(Object conlumName, Object humpConlumName, Object conlumTypeName) {
        this.conlumName = conlumName;
        this.humpConlumName = humpConlumName;
        this.conlumTypeName = conlumTypeName;
    }

    public ColumnPOJO(Object conlumName, Object conlumTypeName) {
        this.conlumName = conlumName;
        this.conlumTypeName = conlumTypeName;
    }

    @Override
    public String toString() {
        return "ColumnPOJO{" +
                "conlumName=" + conlumName +
                ", humpConlumName=" + humpConlumName +
                ", conlumTypeName=" + conlumTypeName +
                '}';
    }
}
