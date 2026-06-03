package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoLandStyleABValue {
    public static final a a;
    private static final Lazy<VideoLandStyleABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public static final class a {
        static {
            Covode.recordClassIndex(598578);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VideoLandStyleABValue() {
        this(false, 1, null);
    }

    static {
        Lazy<VideoLandStyleABValue> lazy;
        Covode.recordClassIndex(598577);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.a3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoLandStyleABValue b2;
                b2 = VideoLandStyleABValue.b();
                return b2;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoLandStyleABValue b() {
        return (VideoLandStyleABValue) qq3.a.a("video_landscape_style_609", new VideoLandStyleABValue(false, 1, null), true);
    }

    public VideoLandStyleABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoLandStyleABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
