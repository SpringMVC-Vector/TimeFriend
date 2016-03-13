package com.vector.tfriend.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: vector.huang
 * date：2016/3/2 22:54
 */
public final class ResultUtils {

    /**
     * 将一个list 组合成一个符合格式的map 对象返回
     *
     * @param arrayKey
     * @param ts
     * @param callback
     * @param <T>
     * @return
     * @deprecated
     */
    public static <T> Map<String, Object> setArrayResult(String arrayKey, List<T> ts, Callback callback) {
        Map<String, Object> data = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        data.put(arrayKey, list);
        for (T t : ts) {
            Map<String, Object> map = new HashMap<String, Object>();
            callback.call(map, t);
            list.add(map);
        }
        return data;
    }

    /**
     * 将一个list 组合成一个符合格式的map 对象返回
     *
     * @param arrayKey
     * @param pageSize
     * @param ts
     * @param callback
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> setArrayResult(String arrayKey, int pageSize, List<T> ts, Callback callback) {
        Map<String, Object> data = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        data.put(arrayKey, list);
        int resultSize = ts.size();
        long maxId = 0;
        for (int i = 0; i < pageSize && i < resultSize; i++) {
            T t = ts.get(i);
            Map<String, Object> map = new HashMap<String, Object>();
            maxId = callback.call(map, t);
            list.add(map);
        }
        data.put("canLoadMore", resultSize > pageSize);
        data.put("maxId", maxId);
        return data;
    }

    public interface Callback<T> {
        long call(Map<String, Object> map, T t);
    }
}
