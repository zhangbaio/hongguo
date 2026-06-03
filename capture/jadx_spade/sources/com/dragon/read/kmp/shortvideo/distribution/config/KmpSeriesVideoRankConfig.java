package com.dragon.read.kmp.shortvideo.distribution.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import com.dragon.read.kmp.shortvideo.distribution.config.KmpSeriesVideoRankConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpSeriesVideoRankConfig {
    public static final a a;
    private static final KmpSeriesVideoRankConfig b;
    private static final Lazy<Boolean> c;

    @SerializedName("custom_fling_behavior")
    public final boolean customFlingBehavior;

    @SerializedName("first_fling_factor")
    public final float firstFlingFactor;

    @SerializedName("first_global_fling_factor")
    public final float firstGlobalFlingFactor;

    @SerializedName("fling_factor")
    public final float flingFactor;

    @SerializedName("is_enable")
    public final boolean isEnable;

    @SerializedName("use_new_fling_behavior")
    public final boolean useNewFlingBehavior;

    public KmpSeriesVideoRankConfig() {
        this(false, false, 0.0f, 0.0f, 0.0f, false, 63, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609008);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            return ((Boolean) KmpSeriesVideoRankConfig.c.getValue()).booleanValue();
        }

        public final KmpSeriesVideoRankConfig a() {
            Object aBValue = SsConfigMgr.getABValue("kmp_series_video_rank_config_v689", KmpSeriesVideoRankConfig.b);
            Intrinsics.checkNotNullExpressionValue(aBValue, "getABValue(...)");
            return (KmpSeriesVideoRankConfig) aBValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d() {
        return a.a().isEnable;
    }

    static {
        Lazy<Boolean> lazy;
        Covode.recordClassIndex(609007);
        a = new a(null);
        SsConfigMgr.prepareAB("kmp_series_video_rank_config_v689", KmpSeriesVideoRankConfig.class, IKmpSeriesVideoRankConfig.class);
        b = new KmpSeriesVideoRankConfig(false, false, 0.0f, 0.0f, 0.0f, false, 63, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: do4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean d;
                d = KmpSeriesVideoRankConfig.d();
                return Boolean.valueOf(d);
            }
        });
        c = lazy;
    }

    public KmpSeriesVideoRankConfig(boolean z, boolean z2, float f, float f2, float f3, boolean z3) {
        this.isEnable = z;
        this.customFlingBehavior = z2;
        this.firstGlobalFlingFactor = f;
        this.firstFlingFactor = f2;
        this.flingFactor = f3;
        this.useNewFlingBehavior = z3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ KmpSeriesVideoRankConfig(boolean r6, boolean r7, float r8, float r9, float r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L7
            r13 = 0
            goto L8
        L7:
            r13 = r6
        L8:
            r6 = r12 & 2
            if (r6 == 0) goto Le
            r1 = 0
            goto Lf
        Le:
            r1 = r7
        Lf:
            r6 = r12 & 4
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L18
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L19
        L18:
            r2 = r8
        L19:
            r6 = r12 & 8
            if (r6 == 0) goto L20
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L21
        L20:
            r3 = r9
        L21:
            r6 = r12 & 16
            if (r6 == 0) goto L28
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L29
        L28:
            r4 = r10
        L29:
            r6 = r12 & 32
            if (r6 == 0) goto L2f
            r12 = 0
            goto L30
        L2f:
            r12 = r11
        L30:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.config.KmpSeriesVideoRankConfig.<init>(boolean, boolean, float, float, float, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
