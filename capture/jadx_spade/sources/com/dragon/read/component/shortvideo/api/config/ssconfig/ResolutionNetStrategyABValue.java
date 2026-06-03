package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResolutionNetStrategyABValue {
    public static final a a;
    private static final Lazy<ResolutionNetStrategyABValue> b;

    @SerializedName("enable_net_resolution")
    public final boolean enableNetResolution;

    @SerializedName("lower_time_preload_best_quality")
    public final boolean lowerTimePreloadBestQuality;

    @SerializedName("net_speed_type")
    public final int netSpeedType;

    @SerializedName("not_match_use_smallest")
    public final boolean notMatchUseSmallest;

    public ResolutionNetStrategyABValue() {
        this(false, false, false, 0, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598463);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResolutionNetStrategyABValue a() {
            return (ResolutionNetStrategyABValue) ResolutionNetStrategyABValue.b.getValue();
        }
    }

    static {
        Lazy<ResolutionNetStrategyABValue> lazy;
        Covode.recordClassIndex(598462);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.g1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ResolutionNetStrategyABValue c;
                c = ResolutionNetStrategyABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ResolutionNetStrategyABValue c() {
        return (ResolutionNetStrategyABValue) qq3.a.a("resolution_net_strategy_v649", new ResolutionNetStrategyABValue(false, false, false, 0, 15, null), true);
    }

    public ResolutionNetStrategyABValue(boolean z, boolean z2, boolean z3, int i) {
        this.enableNetResolution = z;
        this.lowerTimePreloadBestQuality = z2;
        this.notMatchUseSmallest = z3;
        this.netSpeedType = i;
    }

    public /* synthetic */ ResolutionNetStrategyABValue(boolean z, boolean z2, boolean z3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? 1 : i);
    }
}
