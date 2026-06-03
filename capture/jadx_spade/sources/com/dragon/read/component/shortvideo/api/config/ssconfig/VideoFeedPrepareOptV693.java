package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedPrepareOptV693 {
    public static final a a;
    private static final Lazy<VideoFeedPrepareOptV693> b;

    @SerializedName("prepare_first_video")
    public final boolean prepareFirstVideo;

    @SerializedName("prepare_first_video_delay")
    public final long prepareFirstVideoInVisible;

    @SerializedName("prepare_load_more_video")
    public final boolean prepareLoadMoreVideo;

    public VideoFeedPrepareOptV693() {
        this(false, false, 0L, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598565);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long b() {
            return a().prepareFirstVideoInVisible;
        }

        public final boolean c() {
            return a().prepareFirstVideo;
        }

        public final boolean d() {
            return a().prepareLoadMoreVideo;
        }

        private final VideoFeedPrepareOptV693 a() {
            return (VideoFeedPrepareOptV693) VideoFeedPrepareOptV693.b.getValue();
        }
    }

    static {
        Lazy<VideoFeedPrepareOptV693> lazy;
        Covode.recordClassIndex(598564);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.u2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedPrepareOptV693 c;
                c = VideoFeedPrepareOptV693.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoFeedPrepareOptV693 c() {
        return (VideoFeedPrepareOptV693) qq3.a.c("video_feed_prepare_opt_v693", new VideoFeedPrepareOptV693(false, false, 0L, 7, null), false, 4, null);
    }

    public VideoFeedPrepareOptV693(boolean z, boolean z2, long j) {
        this.prepareFirstVideo = z;
        this.prepareLoadMoreVideo = z2;
        this.prepareFirstVideoInVisible = j;
    }

    public /* synthetic */ VideoFeedPrepareOptV693(boolean z, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 0L : j);
    }
}
