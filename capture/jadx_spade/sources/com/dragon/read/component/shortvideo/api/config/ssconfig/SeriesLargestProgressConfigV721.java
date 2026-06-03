package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesLargestProgressConfigV721 {
    public static final a a;
    private static final Lazy<SeriesLargestProgressConfigV721> b;

    @SerializedName("enable")
    public final boolean enable;

    public SeriesLargestProgressConfigV721() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598487);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesLargestProgressConfigV721 a() {
            return (SeriesLargestProgressConfigV721) SeriesLargestProgressConfigV721.b.getValue();
        }
    }

    static {
        Lazy<SeriesLargestProgressConfigV721> lazy;
        Covode.recordClassIndex(598486);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.o1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesLargestProgressConfigV721 c;
                c = SeriesLargestProgressConfigV721.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesLargestProgressConfigV721 c() {
        return (SeriesLargestProgressConfigV721) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "series_largest_progress_config", new SeriesLargestProgressConfigV721(false, 1, null), false, 4, null);
    }

    public SeriesLargestProgressConfigV721(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ SeriesLargestProgressConfigV721(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
