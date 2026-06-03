package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedTabRefreshLatestImpressionGidsV687 {
    public static final a a;
    private static final Lazy<VideoFeedTabRefreshLatestImpressionGidsV687> b;

    @SerializedName("max_size")
    public final int maxSize;

    public VideoFeedTabRefreshLatestImpressionGidsV687() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598571);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b() {
            return a().maxSize;
        }

        private final VideoFeedTabRefreshLatestImpressionGidsV687 a() {
            return (VideoFeedTabRefreshLatestImpressionGidsV687) VideoFeedTabRefreshLatestImpressionGidsV687.b.getValue();
        }
    }

    static {
        Lazy<VideoFeedTabRefreshLatestImpressionGidsV687> lazy;
        Covode.recordClassIndex(598570);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.x2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedTabRefreshLatestImpressionGidsV687 c;
                c = VideoFeedTabRefreshLatestImpressionGidsV687.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoFeedTabRefreshLatestImpressionGidsV687 c() {
        return (VideoFeedTabRefreshLatestImpressionGidsV687) qq3.a.c("video_series_tab_refresh_latest_impression_gids_v687", new VideoFeedTabRefreshLatestImpressionGidsV687(0, 1, null), false, 4, null);
    }

    public VideoFeedTabRefreshLatestImpressionGidsV687(int i) {
        this.maxSize = i;
    }

    public /* synthetic */ VideoFeedTabRefreshLatestImpressionGidsV687(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
