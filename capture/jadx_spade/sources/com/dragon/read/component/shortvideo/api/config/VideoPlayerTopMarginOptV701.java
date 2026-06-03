package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoPlayerTopMarginOptV701;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoPlayerTopMarginOptV701 {
    public static final a a;
    private static final Lazy<VideoPlayerTopMarginOptV701> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("top_padding_height_percent")
    public final float paddingPercent;

    public VideoPlayerTopMarginOptV701() {
        this(false, 0.0f, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598296);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b().enable;
        }

        public final float c() {
            return b().paddingPercent;
        }

        private final VideoPlayerTopMarginOptV701 b() {
            return (VideoPlayerTopMarginOptV701) VideoPlayerTopMarginOptV701.b.getValue();
        }
    }

    static {
        Lazy<VideoPlayerTopMarginOptV701> lazy;
        Covode.recordClassIndex(598295);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPlayerTopMarginOptV701 c;
                c = VideoPlayerTopMarginOptV701.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlayerTopMarginOptV701 c() {
        return (VideoPlayerTopMarginOptV701) qq3.a.c("video_player_top_padding_opt", new VideoPlayerTopMarginOptV701(false, 0.0f, 3, null), false, 4, null);
    }

    public VideoPlayerTopMarginOptV701(boolean z, float f) {
        this.enable = z;
        this.paddingPercent = f;
    }

    public /* synthetic */ VideoPlayerTopMarginOptV701(boolean z, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0.36f : f);
    }
}
