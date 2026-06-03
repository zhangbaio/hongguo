package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProgressStyleLottieV701 {
    public static final a a;
    private static final Lazy<ProgressStyleLottieV701> b;

    @SerializedName("enable")
    public final boolean enable;

    public ProgressStyleLottieV701() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598442);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProgressStyleLottieV701 a() {
            return (ProgressStyleLottieV701) ProgressStyleLottieV701.b.getValue();
        }
    }

    static {
        Lazy<ProgressStyleLottieV701> lazy;
        Covode.recordClassIndex(598441);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProgressStyleLottieV701 c;
                c = ProgressStyleLottieV701.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressStyleLottieV701 c() {
        return (ProgressStyleLottieV701) qq3.a.c("progress_style_lottie_v701", new ProgressStyleLottieV701(false, 1, null), false, 4, null);
    }

    public ProgressStyleLottieV701(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ ProgressStyleLottieV701(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
