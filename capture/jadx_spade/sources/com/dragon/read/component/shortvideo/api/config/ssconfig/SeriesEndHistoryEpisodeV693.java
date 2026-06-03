package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesEndHistoryEpisodeV693 {
    public static final a a;
    private static final Lazy<SeriesEndHistoryEpisodeV693> b;

    @SerializedName("enable")
    public final boolean enable;

    public SeriesEndHistoryEpisodeV693() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598479);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesEndHistoryEpisodeV693 a() {
            return (SeriesEndHistoryEpisodeV693) SeriesEndHistoryEpisodeV693.b.getValue();
        }
    }

    static {
        Lazy<SeriesEndHistoryEpisodeV693> lazy;
        Covode.recordClassIndex(598478);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.m1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesEndHistoryEpisodeV693 c;
                c = SeriesEndHistoryEpisodeV693.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesEndHistoryEpisodeV693 c() {
        return (SeriesEndHistoryEpisodeV693) qq3.a.b("fqv_short_video_series_end_history_episode_v693", new SeriesEndHistoryEpisodeV693(false, 1, null), true);
    }

    public SeriesEndHistoryEpisodeV693(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ SeriesEndHistoryEpisodeV693(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
