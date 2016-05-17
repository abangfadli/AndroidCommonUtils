//package com.abangfadli.commonutils;
//
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//
//import com.abangfadli.commonutils.function.Function1;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//
///**
// * Created by ahmadfadli on 4/5/16.
// */
//public class ListUtil {
//    public static <T> boolean contains(@NonNull List<T> list, Function1<T, Boolean> predicate) {
//        for (T t : list) {
//            if(predicate.call(t)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static <T> T find(@NonNull List<T> list, Function1<T, Boolean> predicate) {
//        for (T t : list) {
//            if(predicate.call(t)) {
//                return t;
//            }
//        }
//
//        throw new NoSuchElementException("Did not found any element matching predicate function");
//    }
//
//    public static <T> T firstOrDefault(List<T> list, @Nullable T defaultValue) {
//        try {
//            if(isNullOrEmpty(list)) {
//                return defaultValue;
//            }
//            return find(list, i -> true);
//        } catch (NoSuchElementException ex) {
//            return defaultValue;
//        }
//    }
//
//    public static <T> void addIfNotExist(@NonNull List<T> list, T item, Function1<T, Boolean> predicate) {
//        if(!contains(list, predicate)) {
//            list.add(item);
//        }
//    }
//
//    public static <T> boolean remove(@NonNull List<T> list, Function1<T, Boolean> predicate) {
//        for (int i = 0, listSize = list.size(); i < listSize; i++) {
//            T t = list.get(i);
//            if (predicate.call(t)) {
//                list.remove(i);
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//
//    public static <T, S> List<S> collectProperty(@NonNull List<T> list, Function1<T, S> predicate) {
//        List<S> result = new ArrayList<>(list.size());
//        for (T t : list) {
//            result.add(predicate.call(t));
//        }
//
//        return result;
//    }
//
//    public static boolean isNullOrEmpty(List<?> list) {
//        return list == null || list.size() == 0;
//    }
//}
