package com.dragon.read.nuwa.tools.monitor;

import com.bytedance.covode.number.Covode;
import com.dragon.read.nuwa.base.extension.ThrowableExKt;
import com.dragon.read.nuwa.base.util.FieldUtils;
import com.dragon.read.nuwa.base.util.TimeUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ObjectMonitor {
    public static final Companion Companion;
    private static final Field causeField;
    private static final Field stackTraceField;
    private final Map<Object, ObjectMonitorException> objectMap;

    public final void clearAll() {
        this.objectMap.clear();
    }

    public ObjectMonitor() {
        Map hashMap;
        if (NuwaObjectMonitor.weakRef()) {
            hashMap = new WeakHashMap();
        } else {
            hashMap = new HashMap();
        }
        Map<Object, ObjectMonitorException> synchronizedMap = Collections.synchronizedMap(hashMap);
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "Collections.synchronized…HashMap() else HashMap())");
        this.objectMap = synchronizedMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Covode.recordClassIndex(612619);
        Field field = null;
        Companion = new Companion(0 == true ? 1 : 0);
        Field field2 = FieldUtils.getField(Throwable.class, "stackTrace");
        if (field2 != null) {
            field2.setAccessible(true);
        } else {
            field2 = null;
        }
        stackTraceField = field2;
        Field field3 = FieldUtils.getField(Throwable.class, "cause");
        if (field3 != null) {
            field3.setAccessible(true);
            field = field3;
        }
        causeField = field;
    }

    public static final class Companion {
        static {
            Covode.recordClassIndex(612620);
        }

        private Companion() {
        }

        private static /* synthetic */ void getCauseField$annotations() {
        }

        private static /* synthetic */ void getStackTraceField$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void clear(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.objectMap.remove(instance);
    }

    public final ObjectMonitorException dumpInstance(Object instance, boolean z) {
        ObjectMonitorException objectMonitorException;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (z) {
            objectMonitorException = this.objectMap.remove(instance);
        } else {
            objectMonitorException = this.objectMap.get(instance);
        }
        return objectMonitorException;
    }

    public final List<ObjectMonitorException> dumpAllInstance(boolean z, boolean z2) {
        Object firstOrNull;
        Object m773constructorimpl;
        if (!z2) {
            List<ObjectMonitorException> list = CollectionsKt___CollectionsKt.toList(this.objectMap.values());
            if (z) {
                clearAll();
            }
            return list;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(this.objectMap.values());
        ObjectMonitorException objectMonitorException = (ObjectMonitorException) firstOrNull;
        ArrayList arrayList = new ArrayList();
        if (objectMonitorException != null) {
            try {
                Result.Companion companion = Result.Companion;
                int i = 0;
                for (Object obj : this.objectMap.values()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    ObjectMonitorException objectMonitorException2 = (ObjectMonitorException) obj;
                    if (i % 10 != 0) {
                        Field field = causeField;
                        if (field != null) {
                            field.set(objectMonitorException, objectMonitorException2);
                        }
                    } else {
                        arrayList.add(objectMonitorException2);
                    }
                    objectMonitorException = objectMonitorException2;
                    i = i2;
                }
                int i3 = 0;
                for (Object obj2 : arrayList) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("监控类:%s,dump时间:%s,共%d组数据,当前是第%d组", Arrays.copyOf(new Object[]{CollectionsKt___CollectionsKt.first(this.objectMap.keySet()).getClass().getName(), TimeUtils.getCurrentFormatTime(), Integer.valueOf(arrayList.size()), Integer.valueOf(i4)}, 4));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    ThrowableExKt.insertTrace((ObjectMonitorException) obj2, new StackTraceElement(format, "", "", -1));
                    i3 = i4;
                }
                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            Result.m772boximpl(m773constructorimpl);
        }
        if (z) {
            clearAll();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final void onDestroy(Object instance, ObjectMonitorException objectMonitorException, String str) {
        Object m773constructorimpl;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (objectMonitorException != null) {
            try {
                Result.Companion companion = Result.Companion;
                objectMonitorException.getStackTrace();
                ThrowableExKt.insertTrace(objectMonitorException, new StackTraceElement("NuwaObjectMonitor onDestroy: object=" + instance + ", destroy_time=" + TimeUtils.getCurrentFormatTime() + ",extra:" + str, "", "", -1));
                this.objectMap.put(instance, objectMonitorException);
                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
            if (m776exceptionOrNullimpl != null) {
                m776exceptionOrNullimpl.printStackTrace();
            }
            Result.m772boximpl(m773constructorimpl);
            return;
        }
        this.objectMap.remove(instance);
    }

    public final void onLoad(Object instance, ObjectMonitorException loadStack, boolean z, String str) {
        Object m773constructorimpl;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(loadStack, "loadStack");
        if (z) {
            try {
                Result.Companion companion = Result.Companion;
                loadStack.getStackTrace();
                ThrowableExKt.insertTrace(loadStack, new StackTraceElement("NuwaObjectMonitor onLoad: object=" + instance + ", load_time=" + TimeUtils.getCurrentFormatTime() + ",extra:" + str + "  ", "", "", -1));
                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
            if (m776exceptionOrNullimpl != null) {
                m776exceptionOrNullimpl.printStackTrace();
            }
        }
        this.objectMap.put(instance, loadStack);
    }

    public static /* synthetic */ List dumpAllInstance$default(ObjectMonitor objectMonitor, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return objectMonitor.dumpAllInstance(z, z2);
    }

    public static /* synthetic */ ObjectMonitorException dumpInstance$default(ObjectMonitor objectMonitor, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = false;
        }
        return objectMonitor.dumpInstance(obj, z);
    }

    public static /* synthetic */ void onDestroy$default(ObjectMonitor objectMonitor, Object obj, ObjectMonitorException objectMonitorException, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = null;
        }
        objectMonitor.onDestroy(obj, objectMonitorException, str);
    }

    public static /* synthetic */ void onLoad$default(ObjectMonitor objectMonitor, Object obj, ObjectMonitorException objectMonitorException, boolean z, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        objectMonitor.onLoad(obj, objectMonitorException, z, str);
    }
}
