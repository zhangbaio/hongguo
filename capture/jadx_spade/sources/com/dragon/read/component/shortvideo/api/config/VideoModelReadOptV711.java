package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoModelReadOptV711;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoModelReadOptV711 {
    public static final a a;
    private static final Lazy<VideoModelReadOptV711> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("enable_render_start_save")
    public final boolean enableRenderStartSave;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public VideoModelReadOptV711() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.VideoModelReadOptV711.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598292);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoModelReadOptV711 a() {
            return (VideoModelReadOptV711) VideoModelReadOptV711.b.getValue();
        }
    }

    static {
        Lazy<VideoModelReadOptV711> lazy;
        Covode.recordClassIndex(598291);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoModelReadOptV711 c;
                c = VideoModelReadOptV711.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoModelReadOptV711 c() {
        boolean z = false;
        return (VideoModelReadOptV711) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "video_model_read_opt", new VideoModelReadOptV711(z, z, 3, null), false, 4, null);
    }

    public VideoModelReadOptV711(boolean z, boolean z2) {
        this.enable = z;
        this.enableRenderStartSave = z2;
    }

    public /* synthetic */ VideoModelReadOptV711(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
