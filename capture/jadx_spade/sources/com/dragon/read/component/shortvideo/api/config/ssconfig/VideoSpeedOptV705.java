package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoSpeedOptV705 {
    public static final a a;
    private static final Lazy<VideoSpeedOptV705> b;

    @SerializedName("outter_enable")
    public final boolean outerEnable;

    @SerializedName("single_feed_enable")
    public final boolean singleFeedEnable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public VideoSpeedOptV705() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoSpeedOptV705.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598597);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoSpeedOptV705 a() {
            return (VideoSpeedOptV705) VideoSpeedOptV705.b.getValue();
        }
    }

    static {
        Lazy<VideoSpeedOptV705> lazy;
        Covode.recordClassIndex(598596);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.g3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoSpeedOptV705 c;
                c = VideoSpeedOptV705.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoSpeedOptV705 c() {
        boolean z = false;
        return (VideoSpeedOptV705) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "playrate_click_switch_v705", new VideoSpeedOptV705(z, z, 3, null), false, 4, null);
    }

    public VideoSpeedOptV705(boolean z, boolean z2) {
        this.singleFeedEnable = z;
        this.outerEnable = z2;
    }

    public /* synthetic */ VideoSpeedOptV705(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
