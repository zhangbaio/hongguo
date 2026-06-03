package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortVideoCropConfig {
    public static final a a;
    private static final Lazy<ShortVideoCropConfig> b;

    @SerializedName("crop_threshold")
    public final float cropThreshold;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("force_wide_screen_suit")
    public final boolean forceWideScreenSuit;

    @SerializedName("landscape_ratio")
    public final float landscapeRatio;

    @SerializedName("wide_screen_boundary")
    public final float wideScreenBoundary;

    public ShortVideoCropConfig() {
        this(false, 0.0f, false, 0.0f, 0.0f, 31, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598516);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortVideoCropConfig a() {
            return (ShortVideoCropConfig) ShortVideoCropConfig.b.getValue();
        }
    }

    static {
        Lazy<ShortVideoCropConfig> lazy;
        Covode.recordClassIndex(598515);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.y1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoCropConfig d;
                d = ShortVideoCropConfig.d();
                return d;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoCropConfig d() {
        return (ShortVideoCropConfig) ISeriesAbValueApi.Companion.c().getABValue2("short_video_enable_player_canvas_crop_opt_v707", new ShortVideoCropConfig(false, 0.0f, false, 0.0f, 0.0f, 31, null), true);
    }

    public final boolean c(float f) {
        if (f > this.wideScreenBoundary) {
            return true;
        }
        return false;
    }

    public ShortVideoCropConfig(boolean z, float f, boolean z2, float f2, float f3) {
        this.enable = z;
        this.cropThreshold = f;
        this.forceWideScreenSuit = z2;
        this.wideScreenBoundary = f2;
        this.landscapeRatio = f3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ShortVideoCropConfig(boolean r4, float r5, boolean r6, float r7, float r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L7
            r10 = 0
            goto L8
        L7:
            r10 = r4
        L8:
            r4 = r9 & 2
            if (r4 == 0) goto Lf
            r5 = 0
            r1 = 0
            goto L10
        Lf:
            r1 = r5
        L10:
            r4 = r9 & 4
            if (r4 == 0) goto L15
            goto L16
        L15:
            r0 = r6
        L16:
            r4 = r9 & 8
            if (r4 == 0) goto L21
            r7 = 1061997773(0x3f4ccccd, float:0.8)
            r2 = 1061997773(0x3f4ccccd, float:0.8)
            goto L22
        L21:
            r2 = r7
        L22:
            r4 = r9 & 16
            if (r4 == 0) goto L2d
            r8 = 1070940029(0x3fd53f7d, float:1.666)
            r9 = 1070940029(0x3fd53f7d, float:1.666)
            goto L2e
        L2d:
            r9 = r8
        L2e:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r0
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.ShortVideoCropConfig.<init>(boolean, float, boolean, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
