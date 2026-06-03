package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedProgressSyncConfigV691 {
    public static final a a;
    private static final Lazy<VideoFeedProgressSyncConfigV691> b;

    @SerializedName("config")
    public final int config;

    public VideoFeedProgressSyncConfigV691() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598567);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean d() {
            return !j();
        }

        public final boolean f() {
            return h();
        }

        public final boolean k() {
            return j();
        }

        private final boolean h() {
            if (a().config == 2) {
                return true;
            }
            return false;
        }

        private final boolean i() {
            if (a().config == 3) {
                return true;
            }
            return false;
        }

        private final boolean j() {
            if (a().config == 1) {
                return true;
            }
            return false;
        }

        public final VideoFeedProgressSyncConfigV691 a() {
            return (VideoFeedProgressSyncConfigV691) VideoFeedProgressSyncConfigV691.b.getValue();
        }

        public final boolean b() {
            if (a().config != 0) {
                return true;
            }
            return false;
        }

        public final boolean e() {
            if (!j() && !i()) {
                return true;
            }
            return false;
        }

        public final boolean c() {
            if (!h() && !i()) {
                return false;
            }
            return true;
        }

        public final boolean g() {
            if (!h() && !i()) {
                return false;
            }
            return true;
        }
    }

    static {
        Lazy<VideoFeedProgressSyncConfigV691> lazy;
        Covode.recordClassIndex(598566);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.v2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedProgressSyncConfigV691 c;
                c = VideoFeedProgressSyncConfigV691.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoFeedProgressSyncConfigV691 c() {
        return (VideoFeedProgressSyncConfigV691) qq3.a.c("video_feed_progress_sync_config_v691", new VideoFeedProgressSyncConfigV691(0, 1, null), false, 4, null);
    }

    public VideoFeedProgressSyncConfigV691(int i) {
        this.config = i;
    }

    public /* synthetic */ VideoFeedProgressSyncConfigV691(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
