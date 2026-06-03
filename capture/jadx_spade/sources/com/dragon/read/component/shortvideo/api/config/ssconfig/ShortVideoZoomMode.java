package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortVideoZoomMode {
    public static final a a;
    private static final Lazy<ShortVideoZoomMode> b;
    private static final Lazy<ShortVideoZoomMode> c;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("guide_max_y")
    public final int guideMaxY;

    @SerializedName("max_scale")
    public final float maxScale;

    @SerializedName("min_scale")
    public final float minScale;

    @SerializedName("scale_ev_keep_ms")
    public final long scaleEvKeepMs;

    @SerializedName("scale_opt1_gap")
    public final float scaleOpt1Gap;

    @SerializedName("scale_value_opt")
    public final int scaleValueOpt;

    @SerializedName("snap_gap")
    public final int snapGap;

    @SerializedName("snap_retry")
    public final int snapRetry;

    public ShortVideoZoomMode() {
        this(false, 0.0f, 0.0f, 0L, 0, 0.0f, 0, 0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598528);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortVideoZoomMode a() {
            return (ShortVideoZoomMode) ShortVideoZoomMode.c.getValue();
        }

        public final ShortVideoZoomMode b() {
            return (ShortVideoZoomMode) ShortVideoZoomMode.b.getValue();
        }
    }

    public final boolean g() {
        if ((this.scaleValueOpt & 1) != 0) {
            return true;
        }
        return false;
    }

    static {
        Lazy<ShortVideoZoomMode> lazy;
        Lazy<ShortVideoZoomMode> lazy2;
        Covode.recordClassIndex(598527);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.d2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoZoomMode f;
                f = ShortVideoZoomMode.f();
                return f;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.e2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoZoomMode e;
                e = ShortVideoZoomMode.e();
                return e;
            }
        });
        c = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoZoomMode e() {
        return (ShortVideoZoomMode) ISeriesAbValueApi.Companion.c().getABValue2("short_video_enable_player_zoom_in_mode_v707", new ShortVideoZoomMode(false, 0.0f, 0.0f, 0L, 0, 0.0f, 0, 0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoZoomMode f() {
        return (ShortVideoZoomMode) ISeriesAbValueApi.Companion.c().getABValue2("short_video_enable_player_zoom_in_mode_v707", new ShortVideoZoomMode(false, 0.0f, 0.0f, 0L, 0, 0.0f, 0, 0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null), false);
    }

    public final boolean h(int i) {
        if (i != 0 && (this.scaleValueOpt & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean i(int i) {
        if (i != 0 && (this.scaleValueOpt & 2) != 0) {
            return true;
        }
        return false;
    }

    public ShortVideoZoomMode(boolean z, float f, float f2, long j, int i, float f3, int i2, int i3, int i4) {
        this.enable = z;
        this.minScale = f;
        this.maxScale = f2;
        this.scaleEvKeepMs = j;
        this.scaleValueOpt = i;
        this.scaleOpt1Gap = f3;
        this.snapGap = i2;
        this.snapRetry = i3;
        this.guideMaxY = i4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ShortVideoZoomMode(boolean r13, float r14, float r15, long r16, int r18, float r19, int r20, int r21, int r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r12 = this;
            r0 = r23
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r13
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L11
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L12
        L11:
            r3 = r14
        L12:
            r4 = r0 & 4
            if (r4 == 0) goto L19
            r4 = 1077936128(0x40400000, float:3.0)
            goto L1a
        L19:
            r4 = r15
        L1a:
            r5 = r0 & 8
            if (r5 == 0) goto L21
            r5 = 500(0x1f4, double:2.47E-321)
            goto L23
        L21:
            r5 = r16
        L23:
            r7 = r0 & 16
            if (r7 == 0) goto L29
            r7 = 6
            goto L2b
        L29:
            r7 = r18
        L2b:
            r8 = r0 & 32
            if (r8 == 0) goto L33
            r8 = 1028443341(0x3d4ccccd, float:0.05)
            goto L35
        L33:
            r8 = r19
        L35:
            r9 = r0 & 64
            r10 = 2
            if (r9 == 0) goto L3c
            r9 = 2
            goto L3e
        L3c:
            r9 = r20
        L3e:
            r11 = r0 & 128(0x80, float:1.8E-43)
            if (r11 == 0) goto L43
            goto L45
        L43:
            r10 = r21
        L45:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L4a
            goto L4c
        L4a:
            r2 = r22
        L4c:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r2
            r13.<init>(r14, r15, r16, r17, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.ShortVideoZoomMode.<init>(boolean, float, float, long, int, float, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
