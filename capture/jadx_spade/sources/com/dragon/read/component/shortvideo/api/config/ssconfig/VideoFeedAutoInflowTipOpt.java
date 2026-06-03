package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedAutoInflowTipOpt {
    public static final a a;
    private static final Lazy<VideoFeedAutoInflowTipOpt> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("time")
    public final int time;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoFeedAutoInflowTipOpt() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598563);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VideoFeedAutoInflowTipOpt a() {
            return (VideoFeedAutoInflowTipOpt) VideoFeedAutoInflowTipOpt.b.getValue();
        }

        public final int b() {
            if (!c()) {
                return 0;
            }
            return a().time;
        }

        public final boolean c() {
            if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).n4() && a().enable) {
                return true;
            }
            return false;
        }
    }

    static {
        Lazy<VideoFeedAutoInflowTipOpt> lazy;
        Covode.recordClassIndex(598562);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.t2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedAutoInflowTipOpt c;
                c = VideoFeedAutoInflowTipOpt.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final VideoFeedAutoInflowTipOpt c() {
        return (VideoFeedAutoInflowTipOpt) qq3.a.c("video_feed_auto_inflow_tip_opt_v679", new VideoFeedAutoInflowTipOpt(false, 0 == true ? 1 : 0, 3, null), false, 4, null);
    }

    public VideoFeedAutoInflowTipOpt(boolean z, int i) {
        this.enable = z;
        this.time = i;
    }

    public /* synthetic */ VideoFeedAutoInflowTipOpt(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }
}
