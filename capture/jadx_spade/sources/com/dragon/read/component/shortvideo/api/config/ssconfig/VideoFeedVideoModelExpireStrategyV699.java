package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedVideoModelExpireStrategyV699 {
    public static final a a;
    private static final Lazy<VideoFeedVideoModelExpireStrategyV699> b;

    @SerializedName("advance_request_time")
    public final long advanceRequestTime;

    @SerializedName("enable_extend_expire_time")
    public final boolean enableExtendExpireTime;

    public VideoFeedVideoModelExpireStrategyV699() {
        this(false, 0L, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598573);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return c().advanceRequestTime;
        }

        public final boolean b() {
            return c().enableExtendExpireTime;
        }

        private final VideoFeedVideoModelExpireStrategyV699 c() {
            return (VideoFeedVideoModelExpireStrategyV699) VideoFeedVideoModelExpireStrategyV699.b.getValue();
        }
    }

    static {
        Lazy<VideoFeedVideoModelExpireStrategyV699> lazy;
        Covode.recordClassIndex(598572);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.y2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedVideoModelExpireStrategyV699 c;
                c = VideoFeedVideoModelExpireStrategyV699.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoFeedVideoModelExpireStrategyV699 c() {
        return (VideoFeedVideoModelExpireStrategyV699) qq3.a.c("video_feed_video_model_expire_strategy_699", new VideoFeedVideoModelExpireStrategyV699(false, 0L, 3, null), false, 4, null);
    }

    public VideoFeedVideoModelExpireStrategyV699(boolean z, long j) {
        this.enableExtendExpireTime = z;
        this.advanceRequestTime = j;
    }

    public /* synthetic */ VideoFeedVideoModelExpireStrategyV699(boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? -1L : j);
    }
}
