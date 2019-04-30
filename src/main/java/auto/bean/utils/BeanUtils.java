package auto.bean.utils;

import java.io.IOException;

/**
 * 描 述: 请描述功能
 * 作 者: ZhouLin
 * 日 期: 创建时间: 2019/4/29
 * 版 本: v1.0
 **/
public class BeanUtils {
    /**
     * 转成驼峰命名规则
     * yOrn: 1（首字母大写）
     * yOrn: 0（首字母不大写）
     */
    public static String toHump(String s, Integer yOrn){
        s = s.toLowerCase();
        String[] split = s.split("_");
        String ss = "";
        for (int i = 0; i < split.length; i++) {
            String s0 = "";
            if (i == 0) {
                if (yOrn == 0) {
                    s0 = split[i].substring(0, 1);
                } else if (yOrn == 1) {
                    s0 = split[i].substring(0, 1).toUpperCase();
                }
            } else {
                s0 = split[i].substring(0, 1).toUpperCase();
            }
            ss += s0 + split[i].substring(1);
        }
        return ss;
    }

    public static void openFileDirectory(String url) throws IOException {
        if (url != null && !"".equals(url)) {
            String[] cmd = new String[5];
            cmd[0] = "cmd";
            cmd[1] = "/c";
            cmd[2] = "start";
            cmd[3] = " ";
            cmd[4] = url;
            Runtime.getRuntime().exec(cmd);
        }
    }
}
