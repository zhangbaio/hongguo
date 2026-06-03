package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesReturnVisitPrefetchOptABValue {
    public static final a a;
    private static final Lazy<SeriesReturnVisitPrefetchOptABValue> b;

    @SerializedName("enable_recent_watch_model_disk")
    public final boolean enableRecentWatchModelDisk;

    @SerializedName("enable_scroll_prefetch")
    public final boolean enableScrollPrefetch;

    @SerializedName("pre_produce_player")
    public final boolean preProducePlayerEnable;

    @SerializedName("reserve_count")
    public final int reserveCount;

    public SeriesReturnVisitPrefetchOptABValue() {
        this(false, false, 0, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598500);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b().enableRecentWatchModelDisk;
        }

        public final int c() {
            return b().reserveCount;
        }

        public final boolean d() {
            return b().preProducePlayerEnable;
        }

        private final SeriesReturnVisitPrefetchOptABValue b() {
            return (SeriesReturnVisitPrefetchOptABValue) SeriesReturnVisitPrefetchOptABValue.b.getValue();
        }
    }

    static {
        Lazy<SeriesReturnVisitPrefetchOptABValue> lazy;
        Covode.recordClassIndex(598499);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.u1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesReturnVisitPrefetchOptABValue c;
                c = SeriesReturnVisitPrefetchOptABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesReturnVisitPrefetchOptABValue c() {
        return (SeriesReturnVisitPrefetchOptABValue) qq3.a.a("series_return_visit_prefetch_opt_v655", new SeriesReturnVisitPrefetchOptABValue(false, false, 0, false, 15, null), true);
    }

    public SeriesReturnVisitPrefetchOptABValue(boolean z, boolean z2, int i, boolean z3) {
        this.enableScrollPrefetch = z;
        this.enableRecentWatchModelDisk = z2;
        this.reserveCount = i;
        this.preProducePlayerEnable = z3;
    }

    public /* synthetic */ SeriesReturnVisitPrefetchOptABValue(boolean z, boolean z2, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? 5 : i, (i2 & 8) != 0 ? false : z3);
    }
}
