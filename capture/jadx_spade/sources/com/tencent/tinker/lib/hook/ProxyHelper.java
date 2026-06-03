package com.tencent.tinker.lib.hook;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ProxyHelper {
    static {
        Covode.recordClassIndex(653771);
    }

    private static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static Object createProxy(Object obj, InvocationHandler invocationHandler) {
        Class[] clsArr;
        List<Class<?>> allInterfaces = getAllInterfaces(obj.getClass());
        if (allInterfaces != null && allInterfaces.size() > 0) {
            clsArr = (Class[]) allInterfaces.toArray(new Class[allInterfaces.size()]);
        } else {
            clsArr = new Class[0];
        }
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), clsArr, invocationHandler);
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
