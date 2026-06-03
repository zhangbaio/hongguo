package com.dragon.read.nuwa.tools.monitor;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NuwaObjectMonitor {
    public static final NuwaObjectMonitor INSTANCE;
    private static final ConcurrentHashMap<Class<?>, ObjectMonitor> clazzMap;
    private static boolean enable;
    private static boolean weakRef;

    private NuwaObjectMonitor() {
    }

    public static final boolean enable() {
        return enable;
    }

    public static final boolean weakRef() {
        return weakRef;
    }

    static {
        Covode.recordClassIndex(612618);
        INSTANCE = new NuwaObjectMonitor();
        enable = true;
        weakRef = true;
        clazzMap = new ConcurrentHashMap<>();
    }

    public final synchronized void clearAll() {
        try {
            Result.Companion companion = Result.Companion;
            Iterator<Map.Entry<Class<?>, ObjectMonitor>> it2 = clazzMap.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().clearAll();
                it2.remove();
            }
            Result.m773constructorimpl(Unit.INSTANCE);
        } finally {
        }
    }

    public static final void setEnable(boolean z) {
        enable = z;
    }

    public static final void setWeakRef(boolean z) {
        weakRef = z;
    }

    public final synchronized void clearClass(Class<Object> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ObjectMonitor remove = clazzMap.remove(clazz);
        if (remove != null) {
            remove.clearAll();
        }
    }

    public final synchronized void clearInstance(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        ObjectMonitor objectMonitor = clazzMap.get(instance.getClass());
        if (objectMonitor != null) {
            objectMonitor.clear(instance);
        }
    }

    public final synchronized ObjectMonitorException dumpInstance(Object instance, boolean z) {
        ObjectMonitorException objectMonitorException;
        Intrinsics.checkNotNullParameter(instance, "instance");
        ObjectMonitor objectMonitor = clazzMap.get(instance.getClass());
        if (objectMonitor != null) {
            objectMonitorException = objectMonitor.dumpInstance(instance, z);
        } else {
            objectMonitorException = null;
        }
        return objectMonitorException;
    }

    public final synchronized Map<Class<?>, List<ObjectMonitorException>> dumpAll(boolean z, boolean z2) {
        HashMap hashMap;
        ObjectMonitor objectMonitor;
        List<ObjectMonitorException> list;
        hashMap = new HashMap();
        Set<Class<?>> keySet = clazzMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "clazzMap.keys");
        Iterator<T> it2 = keySet.iterator();
        while (it2.hasNext()) {
            Class it4 = (Class) it2.next();
            Intrinsics.checkNotNullExpressionValue(it4, "it");
            if (z) {
                objectMonitor = clazzMap.remove(it4);
            } else {
                objectMonitor = clazzMap.get(it4);
            }
            ObjectMonitor objectMonitor2 = objectMonitor;
            if (objectMonitor2 != null) {
                list = objectMonitor2.dumpAllInstance(z, z2);
            } else {
                list = null;
            }
            hashMap.put(it4, list);
        }
        return hashMap;
    }

    public final synchronized void onDestroy(Object instance, ObjectMonitorException objectMonitorException, String str) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        ObjectMonitor objectMonitor = clazzMap.get(instance.getClass());
        if (objectMonitor != null) {
            objectMonitor.onDestroy(instance, objectMonitorException, str);
        }
    }

    public final synchronized List<ObjectMonitorException> dumpByClass(Class<?> clazz, boolean z, boolean z2) {
        ObjectMonitor objectMonitor;
        List<ObjectMonitorException> list;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (z) {
            objectMonitor = clazzMap.remove(clazz);
        } else {
            objectMonitor = clazzMap.get(clazz);
        }
        ObjectMonitor objectMonitor2 = objectMonitor;
        if (objectMonitor2 != null) {
            list = objectMonitor2.dumpAllInstance(z, z2);
        } else {
            list = null;
        }
        return list;
    }

    public final synchronized List<ObjectMonitorException> dumpByClassName(String clazzName, boolean z, boolean z2) {
        ObjectMonitor objectMonitor;
        List<ObjectMonitorException> list;
        Intrinsics.checkNotNullParameter(clazzName, "clazzName");
        if (z) {
            objectMonitor = clazzMap.remove(a.q(clazzName));
        } else {
            objectMonitor = clazzMap.get(a.q(clazzName));
        }
        ObjectMonitor objectMonitor2 = objectMonitor;
        if (objectMonitor2 != null) {
            list = objectMonitor2.dumpAllInstance(z, z2);
        } else {
            list = null;
        }
        return list;
    }

    public final synchronized void onLoad(Object instance, ObjectMonitorException loadStack, boolean z, String str) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(loadStack, "loadStack");
        if (!enable()) {
            return;
        }
        ConcurrentHashMap<Class<?>, ObjectMonitor> concurrentHashMap = clazzMap;
        ObjectMonitor objectMonitor = concurrentHashMap.get(instance.getClass());
        if (objectMonitor != null) {
            objectMonitor.onLoad(instance, loadStack, z, str);
        } else {
            Class<?> cls = instance.getClass();
            ObjectMonitor objectMonitor2 = new ObjectMonitor();
            objectMonitor2.onLoad(instance, loadStack, z, str);
            Unit unit = Unit.INSTANCE;
            concurrentHashMap.put(cls, objectMonitor2);
        }
    }

    public static /* synthetic */ Map dumpAll$default(NuwaObjectMonitor nuwaObjectMonitor, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return nuwaObjectMonitor.dumpAll(z, z2);
    }

    public static /* synthetic */ ObjectMonitorException dumpInstance$default(NuwaObjectMonitor nuwaObjectMonitor, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = false;
        }
        return nuwaObjectMonitor.dumpInstance(obj, z);
    }

    public static /* synthetic */ List dumpByClass$default(NuwaObjectMonitor nuwaObjectMonitor, Class cls, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return nuwaObjectMonitor.dumpByClass(cls, z, z2);
    }

    public static /* synthetic */ List dumpByClassName$default(NuwaObjectMonitor nuwaObjectMonitor, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return nuwaObjectMonitor.dumpByClassName(str, z, z2);
    }

    public static /* synthetic */ void onDestroy$default(NuwaObjectMonitor nuwaObjectMonitor, Object obj, ObjectMonitorException objectMonitorException, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            objectMonitorException = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        nuwaObjectMonitor.onDestroy(obj, objectMonitorException, str);
    }

    public static /* synthetic */ void onLoad$default(NuwaObjectMonitor nuwaObjectMonitor, Object obj, ObjectMonitorException objectMonitorException, boolean z, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        nuwaObjectMonitor.onLoad(obj, objectMonitorException, z, str);
    }
}
