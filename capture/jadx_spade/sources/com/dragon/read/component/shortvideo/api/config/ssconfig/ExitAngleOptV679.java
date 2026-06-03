package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ExitAngleOptV679 {
    public static final a a;
    private static final Lazy<ExitAngleOptV679> b;

    @SerializedName("enable_angle_opt")
    public final boolean enableAngleOpt;

    @SerializedName("vertical_angle")
    public final Integer verticalAngle;

    /* JADX WARN: Multi-variable type inference failed */
    public ExitAngleOptV679() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598351);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExitAngleOptV679 a() {
            return (ExitAngleOptV679) ExitAngleOptV679.b.getValue();
        }
    }

    static {
        Lazy<ExitAngleOptV679> lazy;
        Covode.recordClassIndex(598350);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ExitAngleOptV679 c;
                c = ExitAngleOptV679.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ExitAngleOptV679 c() {
        return (ExitAngleOptV679) qq3.a.c("short_video_exit_angle_opt_v679", new ExitAngleOptV679(false, null, 3, 0 == true ? 1 : 0), false, 4, null);
    }

    public ExitAngleOptV679(boolean z, Integer num) {
        this.enableAngleOpt = z;
        this.verticalAngle = num;
    }

    public /* synthetic */ ExitAngleOptV679(boolean z, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num);
    }
}
