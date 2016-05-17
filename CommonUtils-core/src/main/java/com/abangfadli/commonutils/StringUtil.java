package com.abangfadli.commonutils;

import java.util.List;

/**
 * Created by ahmadfadli on 4/14/16.
 */
public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    static public String join(List<String> list, String conjunction) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        if(list == null) {
            return sb.toString();
        }

        for (String item : list)
        {
            if (first)
                first = false;
            else
                sb.append(conjunction);
            sb.append(item);
        }
        return sb.toString();
    }
}
