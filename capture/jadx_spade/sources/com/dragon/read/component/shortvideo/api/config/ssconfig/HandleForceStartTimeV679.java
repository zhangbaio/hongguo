package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HandleForceStartTimeV679 {
    public static final a a;
    private static final Lazy<HandleForceStartTimeV679> b;

    @SerializedName("enable")
    public final boolean enable;

    public HandleForceStartTimeV679() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598362);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HandleForceStartTimeV679 a() {
            return (HandleForceStartTimeV679) HandleForceStartTimeV679.b.getValue();
        }
    }

    static {
        Lazy<HandleForceStartTimeV679> lazy;
        Covode.recordClassIndex(598361);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                HandleForceStartTimeV679 c;
                c = HandleForceStartTimeV679.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HandleForceStartTimeV679 c() {
        return (HandleForceStartTimeV679) qq3.a.c("handle_force_start_time_v679", new HandleForceStartTimeV679(false, 1, null), false, 4, null);
    }

    public HandleForceStartTimeV679(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ HandleForceStartTimeV679(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
