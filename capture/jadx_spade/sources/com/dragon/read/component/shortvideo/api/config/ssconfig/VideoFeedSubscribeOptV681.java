package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedSubscribeOptV681 {
    public static final a a;
    private static final Lazy<VideoFeedSubscribeOptV681> b;

    @SerializedName("enable")
    public final boolean enable;

    public VideoFeedSubscribeOptV681() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598569);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VideoFeedSubscribeOptV681 a() {
            return (VideoFeedSubscribeOptV681) VideoFeedSubscribeOptV681.b.getValue();
        }

        public final boolean b() {
            if (a().enable && ((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).n4()) {
                return true;
            }
            return false;
        }
    }

    static {
        Lazy<VideoFeedSubscribeOptV681> lazy;
        Covode.recordClassIndex(598568);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.w2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedSubscribeOptV681 c;
                c = VideoFeedSubscribeOptV681.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoFeedSubscribeOptV681 c() {
        return (VideoFeedSubscribeOptV681) qq3.a.c("video_feed_subscribe_opt_v681", new VideoFeedSubscribeOptV681(false, 1, null), false, 4, null);
    }

    public VideoFeedSubscribeOptV681(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoFeedSubscribeOptV681(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
