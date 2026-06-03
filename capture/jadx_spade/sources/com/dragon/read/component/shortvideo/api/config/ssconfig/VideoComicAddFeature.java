package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoComicAddFeature {
    public static final a a;
    private static final Lazy<VideoComicAddFeature> b;

    @SerializedName("enable")
    public final boolean enable;

    public VideoComicAddFeature() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598549);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoComicAddFeature a() {
            return b();
        }

        private final VideoComicAddFeature b() {
            return (VideoComicAddFeature) VideoComicAddFeature.b.getValue();
        }
    }

    static {
        Lazy<VideoComicAddFeature> lazy;
        Covode.recordClassIndex(598548);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.o2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoComicAddFeature c;
                c = VideoComicAddFeature.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoComicAddFeature c() {
        return (VideoComicAddFeature) qq3.a.c("video_comic_add_feature_v701", new VideoComicAddFeature(false, 1, null), false, 4, null);
    }

    public VideoComicAddFeature(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoComicAddFeature(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
