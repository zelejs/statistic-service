package com.jfeat.am.module.statistics.services.crud;

import java.util.Map;

public interface SQLSearchLabelService {
    StringBuilder getSQL(Map<String,String[]> requestMap,StringBuilder sql);
    StringBuilder ifSQL(Map<String,String[]> requestMap,StringBuilder sql);

    /**
     * 给定一个区间 返回中间的内容 删除左右匹配字符
     * @param String left
     * @param String right
     * @param StringBuilder stringBuilder
     * @return String
     */
     String range(String left,String right,StringBuilder stringBuilder);

    /**
     *  给定一个区间 删除中间的内容
     * @param String  left
     * @param String  right
     * @param StringBuilder
     * @return StringBuilder
     */
     StringBuilder deleteRange(String left,String right,StringBuilder stringBuilder);
}
