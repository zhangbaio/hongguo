package com.dragon.read.nuwa.base.extension;

import com.bytedance.covode.number.Covode;
import com.dragon.read.nuwa.base.extension.ThrowableEx;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ThrowableExKt {
    static {
        Covode.recordClassIndex(612593);
    }

    public static final void insertTrace(Throwable insertTrace, StackTraceElement traceElement) {
        Object obj;
        Intrinsics.checkNotNullParameter(insertTrace, "$this$insertTrace");
        Intrinsics.checkNotNullParameter(traceElement, "traceElement");
        ThrowableEx.Companion companion = ThrowableEx.Companion;
        Field stackTraceField = companion.getStackTraceField();
        Object obj2 = null;
        if (stackTraceField != null) {
            obj = stackTraceField.get(insertTrace);
        } else {
            obj = null;
        }
        if (obj instanceof Object[]) {
            obj2 = obj;
        }
        Object[] objArr = (Object[]) obj2;
        if (objArr != null) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[objArr.length + 1];
            stackTraceElementArr[0] = traceElement;
            System.arraycopy(objArr, 0, stackTraceElementArr, 1, objArr.length);
            Field stackTraceField2 = companion.getStackTraceField();
            if (stackTraceField2 != null) {
                stackTraceField2.set(insertTrace, stackTraceElementArr);
            }
        }
    }
}
