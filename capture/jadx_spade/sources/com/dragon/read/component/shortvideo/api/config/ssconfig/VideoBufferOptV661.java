package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoBufferOptV661 {
    public static final a a;
    private static final Lazy<VideoBufferOptV661> b;

    @SerializedName("buffer_directly")
    public final boolean bufferDirectly;

    @SerializedName("buffering_data")
    public final int bufferingData;

    @SerializedName("buffering_max_data")
    public final int bufferingMaxData;

    public VideoBufferOptV661() {
        this(false, 0, 0, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598547);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoBufferOptV661 a() {
            return (VideoBufferOptV661) VideoBufferOptV661.b.getValue();
        }
    }

    static {
        Lazy<VideoBufferOptV661> lazy;
        Covode.recordClassIndex(598546);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.n2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoBufferOptV661 c;
                c = VideoBufferOptV661.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoBufferOptV661 c() {
        return (VideoBufferOptV661) qq3.a.c("video_buffer_opt_661", new VideoBufferOptV661(false, 0, 0, 7, null), false, 4, null);
    }

    public VideoBufferOptV661(boolean z, int i, int i2) {
        this.bufferDirectly = z;
        this.bufferingData = i;
        this.bufferingMaxData = i2;
    }

    public /* synthetic */ VideoBufferOptV661(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 1000 : i, (i3 & 4) != 0 ? 5000 : i2);
    }
}
