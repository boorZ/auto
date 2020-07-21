package com.auto.entities.ftl.mysql.puls;

import lombok.Data;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author zhou lin
 * @description MySqlPlus请求类
 * @create 2020-06-07 17:15
 */
@Data
public class MySqlPlusReqBO {
    /**
     * ftl文件
     */
    private List<FtlEntity> ftlEntityList;

    public static MySqlPlusReqBO create(final Supplier<MySqlPlusReqBO> supplier) {
        return supplier.get();
    }
}
