package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoCommonABValue {
    public static final a a;
    private static final Lazy<VideoCommonABValue> b;

    @SerializedName("dash_exchange_url_when_retry")
    public final boolean dashExchangeUrlWhenRetry;

    @SerializedName("enable_https")
    public final boolean enableHttps;

    @SerializedName("native_render_opt")
    public final boolean nativeRenderOpt;

    @SerializedName("native_render_rotate_adapt")
    public final boolean nativeRenderRotateAdapt;

    @SerializedName("native_render_yv12")
    public final boolean nativeRenderYV12;

    @SerializedName("refresh_surface")
    public final boolean refreshSurface;

    @SerializedName("render_type")
    public final int renderType;

    @SerializedName("surface_view_recreate_when_refresh")
    public final boolean surfaceViewRecreateWhenRefresh;

    public VideoCommonABValue() {
        this(false, false, 0, false, false, false, false, false, 255, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598552);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoCommonABValue a() {
            return b();
        }

        private final VideoCommonABValue b() {
            return (VideoCommonABValue) VideoCommonABValue.b.getValue();
        }
    }

    static {
        Lazy<VideoCommonABValue> lazy;
        Covode.recordClassIndex(598551);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.p2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoCommonABValue c;
                c = VideoCommonABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoCommonABValue c() {
        return (VideoCommonABValue) qq3.a.a("video_common_config_v639", new VideoCommonABValue(false, false, 0, false, false, false, false, false, 255, null), true);
    }

    public VideoCommonABValue(boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.dashExchangeUrlWhenRetry = z;
        this.enableHttps = z2;
        this.renderType = i;
        this.nativeRenderRotateAdapt = z3;
        this.nativeRenderYV12 = z4;
        this.nativeRenderOpt = z5;
        this.refreshSurface = z6;
        this.surfaceViewRecreateWhenRefresh = z7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoCommonABValue(boolean r10, boolean r11, int r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = r10
        L9:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L10
            r2 = 0
            goto L11
        L10:
            r2 = r11
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = 3
            goto L18
        L17:
            r4 = r12
        L18:
            r5 = r0 & 8
            if (r5 == 0) goto L1e
            r5 = 0
            goto L1f
        L1e:
            r5 = r13
        L1f:
            r6 = r0 & 16
            if (r6 == 0) goto L25
            r6 = 0
            goto L26
        L25:
            r6 = r14
        L26:
            r7 = r0 & 32
            if (r7 == 0) goto L2c
            r7 = 0
            goto L2d
        L2c:
            r7 = r15
        L2d:
            r8 = r0 & 64
            if (r8 == 0) goto L33
            r8 = 0
            goto L35
        L33:
            r8 = r16
        L35:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L3a
            goto L3c
        L3a:
            r3 = r17
        L3c:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoCommonABValue.<init>(boolean, boolean, int, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
