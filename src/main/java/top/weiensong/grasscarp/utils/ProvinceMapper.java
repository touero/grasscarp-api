package top.weiensong.grasscarp.utils;

import java.util.HashMap;
import java.util.Map;

public class ProvinceMapper {

    private static final Map<String, String> MAP = new HashMap<>();

    static {
        MAP.put("11", "北京");
        MAP.put("12", "天津");
        MAP.put("13", "河北");
        MAP.put("14", "山西");
        MAP.put("15", "内蒙古");

        MAP.put("21", "辽宁");
        MAP.put("22", "吉林");
        MAP.put("23", "黑龙江");

        MAP.put("31", "上海");
        MAP.put("32", "江苏");
        MAP.put("33", "浙江");
        MAP.put("34", "安徽");
        MAP.put("35", "福建");
        MAP.put("36", "江西");
        MAP.put("37", "山东");

        MAP.put("41", "河南");
        MAP.put("42", "湖北");
        MAP.put("43", "湖南");
        MAP.put("44", "广东");
        MAP.put("45", "广西");
        MAP.put("46", "海南");

        MAP.put("50", "重庆");
        MAP.put("51", "四川");
        MAP.put("52", "贵州");
        MAP.put("53", "云南");
        MAP.put("54", "西藏");

        MAP.put("61", "陕西");
        MAP.put("62", "甘肃");
        MAP.put("63", "青海");
        MAP.put("64", "宁夏");
        MAP.put("65", "新疆");

        MAP.put("81", "香港");
        MAP.put("82", "澳门");
    }

    public static String getName(String provinceId) {
        return MAP.get(provinceId);
    }
}