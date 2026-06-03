package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoPlayerLandscapeBtnOptV701;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoPlayerLandscapeBtnOptV701 {
    public static final a a;
    private static final Lazy<VideoPlayerLandscapeBtnOptV701> b;

    @SerializedName("enable")
    public final boolean enable;

    public VideoPlayerLandscapeBtnOptV701() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598294);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b().enable;
        }

        private final VideoPlayerLandscapeBtnOptV701 b() {
            return (VideoPlayerLandscapeBtnOptV701) VideoPlayerLandscapeBtnOptV701.b.getValue();
        }
    }

    static {
        Lazy<VideoPlayerLandscapeBtnOptV701> lazy;
        Covode.recordClassIndex(598293);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPlayerLandscapeBtnOptV701 c;
                c = VideoPlayerLandscapeBtnOptV701.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlayerLandscapeBtnOptV701 c() {
        return (VideoPlayerLandscapeBtnOptV701) qq3.a.c("video_player_landscape_btn_opt", new VideoPlayerLandscapeBtnOptV701(false, 1, null), false, 4, null);
    }

    public VideoPlayerLandscapeBtnOptV701(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoPlayerLandscapeBtnOptV701(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
