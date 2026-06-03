package com.dragon.read.nuwa.base.extension;

import com.bytedance.covode.number.Covode;
import com.dragon.read.nuwa.base.util.FieldUtils;
import java.lang.reflect.Field;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ThrowableEx {
    public static final Companion Companion;
    private static final Field causeField;
    private static final Field stackTraceField;

    public static final Field getCauseField() {
        return causeField;
    }

    public static final class Companion {
        static {
            Covode.recordClassIndex(612592);
        }

        private Companion() {
        }

        public static /* synthetic */ void getCauseField$annotations() {
        }

        public final Field getCauseField() {
            return ThrowableEx.causeField;
        }

        public final Field getStackTraceField() {
            return ThrowableEx.stackTraceField;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Covode.recordClassIndex(612591);
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
}
