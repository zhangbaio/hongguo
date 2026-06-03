package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoDetailTransformOptV693 {
    public static final a a;
    private static final Lazy<VideoDetailTransformOptV693> b;

    @SerializedName("enable")
    public final boolean enable;

    public VideoDetailTransformOptV693() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598560);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoDetailTransformOptV693 a() {
            return (VideoDetailTransformOptV693) VideoDetailTransformOptV693.b.getValue();
        }
    }

    static {
        Lazy<VideoDetailTransformOptV693> lazy;
        Covode.recordClassIndex(598559);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.s2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoDetailTransformOptV693 c;
                c = VideoDetailTransformOptV693.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailTransformOptV693 c() {
        return (VideoDetailTransformOptV693) qq3.a.b("video_detail_transform_opt_v693", new VideoDetailTransformOptV693(false, 1, null), true);
    }

    public VideoDetailTransformOptV693(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoDetailTransformOptV693(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
