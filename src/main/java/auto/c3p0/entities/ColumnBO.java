package auto.c3p0.entities;

import lombok.Data;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/28
 * 版 本: v1.0
 **/
@Data
public class ColumnBO {
    /**
     * 列名
     **/
    private Object conlumName;
    /**
     * 驼峰列名
     **/
    private Object humpConlumName;
    /**
     * 列类型
     **/
    private Object conlumTypeName;

    public ColumnBO() {
    }

    public ColumnBO(Object conlumName, Object humpConlumName, Object conlumTypeName) {
        this.conlumName = conlumName;
        this.humpConlumName = humpConlumName;
        this.conlumTypeName = conlumTypeName;
    }
}
