package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoFeedTabManualRefreshOptV687;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedTabManualRefreshOptV687 {
    public static final a a;
    private static final VideoFeedTabManualRefreshOptV687 b;
    private static final Lazy<VideoFeedTabManualRefreshOptV687> c;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("refresh_type")
    public final int refreshType;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoFeedTabManualRefreshOptV687() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static final boolean d() {
        return a.b();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598285);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            return a().enable;
        }

        private final VideoFeedTabManualRefreshOptV687 a() {
            return (VideoFeedTabManualRefreshOptV687) VideoFeedTabManualRefreshOptV687.c.getValue();
        }

        public final boolean c() {
            if (b() && a().refreshType == 2) {
                return true;
            }
            return false;
        }

        public final boolean d() {
            if (b() && a().refreshType == 1) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoFeedTabManualRefreshOptV687 c() {
        return (VideoFeedTabManualRefreshOptV687) qq3.a.c("video_feed_tab_refresh_opt_v687", b, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Lazy<VideoFeedTabManualRefreshOptV687> lazy;
        Covode.recordClassIndex(598284);
        DefaultConstructorMarker defaultConstructorMarker = null;
        a = new a(defaultConstructorMarker);
        b = new VideoFeedTabManualRefreshOptV687(false, 0 == true ? 1 : 0, 3, defaultConstructorMarker);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedTabManualRefreshOptV687 c2;
                c2 = VideoFeedTabManualRefreshOptV687.c();
                return c2;
            }
        });
        c = lazy;
    }

    public VideoFeedTabManualRefreshOptV687(boolean z, int i) {
        this.enable = z;
        this.refreshType = i;
    }

    public /* synthetic */ VideoFeedTabManualRefreshOptV687(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }
}
