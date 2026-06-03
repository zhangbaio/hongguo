package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PreloadStrategyReduceTopABValue {
    public static final a a;
    private static final Lazy<PreloadStrategyReduceTopABValue> b;
    private static final Lazy<PreloadStrategyReduceTopABValue> c;

    @SerializedName("strategy")
    public final int strategy;

    public PreloadStrategyReduceTopABValue() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598431);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PreloadStrategyReduceTopABValue a() {
            return (PreloadStrategyReduceTopABValue) PreloadStrategyReduceTopABValue.b.getValue();
        }

        public final PreloadStrategyReduceTopABValue b() {
            return (PreloadStrategyReduceTopABValue) PreloadStrategyReduceTopABValue.c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadStrategyReduceTopABValue e() {
        return (PreloadStrategyReduceTopABValue) qq3.a.a("peak_time_video_preload_opt_v605", new PreloadStrategyReduceTopABValue(0, 1, null), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadStrategyReduceTopABValue f() {
        return (PreloadStrategyReduceTopABValue) qq3.a.a("peak_time_video_preload_opt_v605", new PreloadStrategyReduceTopABValue(0, 1, null), true);
    }

    static {
        Lazy<PreloadStrategyReduceTopABValue> lazy;
        Lazy<PreloadStrategyReduceTopABValue> lazy2;
        Covode.recordClassIndex(598430);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PreloadStrategyReduceTopABValue f;
                f = PreloadStrategyReduceTopABValue.f();
                return f;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PreloadStrategyReduceTopABValue e;
                e = PreloadStrategyReduceTopABValue.e();
                return e;
            }
        });
        c = lazy2;
    }

    public PreloadStrategyReduceTopABValue(int i) {
        this.strategy = i;
    }

    public /* synthetic */ PreloadStrategyReduceTopABValue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
