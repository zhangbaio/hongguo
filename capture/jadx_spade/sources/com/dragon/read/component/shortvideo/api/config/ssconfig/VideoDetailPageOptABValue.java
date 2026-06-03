package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoDetailPageOptABValue {
    public static final a a;
    private static final Lazy<VideoDetailPageOptABValue> b;

    @SerializedName("style")
    public final int style;

    @SerializedName("use_new_style")
    public final boolean useNewStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoDetailPageOptABValue() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598558);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoDetailPageOptABValue a() {
            return (VideoDetailPageOptABValue) VideoDetailPageOptABValue.b.getValue();
        }
    }

    static {
        Lazy<VideoDetailPageOptABValue> lazy;
        Covode.recordClassIndex(598557);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.r2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoDetailPageOptABValue c;
                c = VideoDetailPageOptABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final VideoDetailPageOptABValue c() {
        return (VideoDetailPageOptABValue) qq3.a.b("video_detail_page_opt_v665", new VideoDetailPageOptABValue(false, 0 == true ? 1 : 0, 3, null), true);
    }

    public VideoDetailPageOptABValue(boolean z, int i) {
        this.useNewStyle = z;
        this.style = i;
    }

    public /* synthetic */ VideoDetailPageOptABValue(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }
}
