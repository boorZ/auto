package com.auto.utils;

import com.auto.BeanConfig;
import com.auto.entities.ColumnBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhou lin
 * @description Bean工具类
 * @create 2020-06-07 17:15
 */
public class BeanUtils {

    private Logger log = LoggerFactory.getLogger(BeanUtils.class);
    private final static String UNDERLINE = "_";

    /**
     * 转成驼峰命名规则
     *
     * @param para                下划线命名的字符串
     * @param isInitialToggleCase 是否首字母大写
     */
    public static String toggleCase(String para, boolean isInitialToggleCase) {
        // 转小写
        para = para.toLowerCase();
        // 以下划线分割
        String[] paraSplits = para.split(UNDERLINE);
        StringBuilder result = new StringBuilder();
        for (String paraSplit : paraSplits) {
            // 首字母
            String initialToggleCase = paraSplit.substring(0, 1);
            result.append(isInitialToggleCase ? initialToggleCase.toUpperCase() : initialToggleCase.toLowerCase());
            result.append(paraSplit, 1, paraSplit.length());
            isInitialToggleCase = true;
        }
        return result.toString();
    }

    /**
     * 打开文件目录
     *
     * @param url
     * @throws IOException
     */
    public static void openFileDirectory(String url) {
        try {
            if (url != null && !"".equals(url)) {
                Runtime.getRuntime().exec(String.valueOf(Arrays.asList("cmd", "/c", "start", " ", url)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 过滤忽略字段
     *
     * @param columnBoList 列名集
     * @return 过滤忽略字段后的列名集
     */
    private static List<ColumnBO> filtration(List<ColumnBO> columnBoList) {
        return columnBoList.stream().filter(columnBO ->
                !BeanConfig.NEGLECT_FIELDS.contains((CharSequence) columnBO.getColumnName()))
                .collect(Collectors.toList());
    }
}
