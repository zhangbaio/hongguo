package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LikeVideosOptimizationV657 {
    public static final a a;
    private static final Lazy<LikeVideosOptimizationV657> b;

    @SerializedName("enable")
    public final boolean enable;

    public LikeVideosOptimizationV657() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598384);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            return a().enable;
        }

        private final LikeVideosOptimizationV657 a() {
            return (LikeVideosOptimizationV657) LikeVideosOptimizationV657.b.getValue();
        }
    }

    static {
        Lazy<LikeVideosOptimizationV657> lazy;
        Covode.recordClassIndex(598383);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LikeVideosOptimizationV657 c;
                c = LikeVideosOptimizationV657.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LikeVideosOptimizationV657 c() {
        return (LikeVideosOptimizationV657) qq3.a.c("like_videoes_optimization_v657", new LikeVideosOptimizationV657(false, 1, null), false, 4, null);
    }

    public LikeVideosOptimizationV657(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ LikeVideosOptimizationV657(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
