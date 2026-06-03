package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRamOptV711 {
    public static final a a;
    private static final Lazy<SeriesRamOptV711> b;

    @SerializedName("enable_new_cache")
    public final boolean enableNewCache;

    @SerializedName("video_detail_config")
    public final PrefetchCacheConfig videoDetailConfig;

    @SerializedName("video_model_config")
    public final PrefetchCacheConfig videoModelConfig;

    public SeriesRamOptV711() {
        this(false, null, null, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598489);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesRamOptV711 b() {
            return (SeriesRamOptV711) SeriesRamOptV711.b.getValue();
        }

        public final PrefetchCacheConfig a() {
            if (b().videoDetailConfig.unlimited) {
                return new PrefetchCacheConfig(false, null, null, null, null, 31, null);
            }
            return b().videoDetailConfig;
        }

        public final PrefetchCacheConfig c() {
            if (b().videoModelConfig.unlimited) {
                return new PrefetchCacheConfig(false, null, null, null, null, 31, null);
            }
            return b().videoModelConfig;
        }
    }

    static {
        Lazy<SeriesRamOptV711> lazy;
        Covode.recordClassIndex(598488);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.p1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesRamOptV711 c;
                c = SeriesRamOptV711.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesRamOptV711 c() {
        return (SeriesRamOptV711) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "series_ram_opt_v711", new SeriesRamOptV711(false, null, null, 7, null), false, 4, null);
    }

    public SeriesRamOptV711(boolean z, PrefetchCacheConfig videoDetailConfig, PrefetchCacheConfig videoModelConfig) {
        Intrinsics.checkNotNullParameter(videoDetailConfig, "videoDetailConfig");
        Intrinsics.checkNotNullParameter(videoModelConfig, "videoModelConfig");
        this.enableNewCache = z;
        this.videoDetailConfig = videoDetailConfig;
        this.videoModelConfig = videoModelConfig;
    }

    public /* synthetic */ SeriesRamOptV711(boolean z, PrefetchCacheConfig prefetchCacheConfig, PrefetchCacheConfig prefetchCacheConfig2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new PrefetchCacheConfig(false, null, null, null, null, 31, null) : prefetchCacheConfig, (i & 4) != 0 ? new PrefetchCacheConfig(false, null, null, null, null, 31, null) : prefetchCacheConfig2);
    }
}
