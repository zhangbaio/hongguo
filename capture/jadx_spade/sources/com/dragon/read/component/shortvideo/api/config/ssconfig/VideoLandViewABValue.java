package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoLandViewABValue {
    public static final a a;
    private static final Lazy<VideoLandViewABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public static final class a {
        static {
            Covode.recordClassIndex(598581);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VideoLandViewABValue() {
        this(false, 1, null);
    }

    static {
        Lazy<VideoLandViewABValue> lazy;
        Covode.recordClassIndex(598580);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.b3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoLandViewABValue b2;
                b2 = VideoLandViewABValue.b();
                return b2;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoLandViewABValue b() {
        return (VideoLandViewABValue) qq3.a.a("video_land_part2_v613", new VideoLandViewABValue(false, 1, null), true);
    }

    public VideoLandViewABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoLandViewABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
