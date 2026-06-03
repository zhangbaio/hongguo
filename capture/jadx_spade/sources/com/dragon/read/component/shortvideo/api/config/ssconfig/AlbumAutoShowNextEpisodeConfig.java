package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AlbumAutoShowNextEpisodeConfig {
    public static final a a;
    private static final Lazy<AlbumAutoShowNextEpisodeConfig> b;

    @SerializedName("enable")
    public final boolean enable;

    public AlbumAutoShowNextEpisodeConfig() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598310);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AlbumAutoShowNextEpisodeConfig a() {
            return (AlbumAutoShowNextEpisodeConfig) AlbumAutoShowNextEpisodeConfig.b.getValue();
        }

        public final boolean b() {
            if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).n4() && a().enable) {
                return true;
            }
            return false;
        }
    }

    static {
        Lazy<AlbumAutoShowNextEpisodeConfig> lazy;
        Covode.recordClassIndex(598309);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AlbumAutoShowNextEpisodeConfig c;
                c = AlbumAutoShowNextEpisodeConfig.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlbumAutoShowNextEpisodeConfig c() {
        return (AlbumAutoShowNextEpisodeConfig) qq3.a.c("album_auto_show_nextepisode_config", new AlbumAutoShowNextEpisodeConfig(false, 1, null), false, 4, null);
    }

    public AlbumAutoShowNextEpisodeConfig(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ AlbumAutoShowNextEpisodeConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
