package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoIpDirectABValue;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoIpDirectABValue {
    public static final a a;
    private static final Lazy<VideoIpDirectABValue> b;

    @SerializedName("cold_stage_time")
    public final int coldStageTime;

    @SerializedName("enable_cold_stage")
    public final boolean enableColdStage;

    @SerializedName("enable_single_tag")
    public final boolean enableSingleTab;

    public VideoIpDirectABValue() {
        this(false, 0, false, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598289);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoIpDirectABValue a() {
            return (VideoIpDirectABValue) VideoIpDirectABValue.b.getValue();
        }
    }

    static {
        Lazy<VideoIpDirectABValue> lazy;
        Covode.recordClassIndex(598288);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoIpDirectABValue c;
                c = VideoIpDirectABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoIpDirectABValue c() {
        return (VideoIpDirectABValue) qq3.a.a("video_ip_direct_v699", new VideoIpDirectABValue(false, 0, false, 7, null), true);
    }

    public VideoIpDirectABValue(boolean z, int i, boolean z2) {
        this.enableColdStage = z;
        this.coldStageTime = i;
        this.enableSingleTab = z2;
    }

    public /* synthetic */ VideoIpDirectABValue(boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 30000 : i, (i2 & 4) != 0 ? false : z2);
    }
}
