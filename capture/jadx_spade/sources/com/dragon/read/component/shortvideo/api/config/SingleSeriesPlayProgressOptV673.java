package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.SingleSeriesPlayProgressOptV673;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SingleSeriesPlayProgressOptV673 {
    public static final a a;
    private static final Lazy<SingleSeriesPlayProgressOptV673> b;

    @SerializedName("style")
    public final int style;

    public SingleSeriesPlayProgressOptV673() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598269);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SingleSeriesPlayProgressOptV673 a() {
            return (SingleSeriesPlayProgressOptV673) SingleSeriesPlayProgressOptV673.b.getValue();
        }
    }

    static {
        Lazy<SingleSeriesPlayProgressOptV673> lazy;
        Covode.recordClassIndex(598268);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleSeriesPlayProgressOptV673 c;
                c = SingleSeriesPlayProgressOptV673.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSeriesPlayProgressOptV673 c() {
        return (SingleSeriesPlayProgressOptV673) qq3.a.c("single_series_play_progress_opt_673", new SingleSeriesPlayProgressOptV673(0, 1, null), false, 4, null);
    }

    public SingleSeriesPlayProgressOptV673(int i) {
        this.style = i;
    }

    public /* synthetic */ SingleSeriesPlayProgressOptV673(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
