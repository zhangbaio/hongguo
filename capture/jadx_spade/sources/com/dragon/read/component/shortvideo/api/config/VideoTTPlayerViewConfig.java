package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoTTPlayerViewConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoTTPlayerViewConfig {
    public static final a a;
    private static final Lazy<VideoTTPlayerViewConfig> b;

    @SerializedName("death_check_interval")
    public final int deathCheckInterval;

    @SerializedName("death_timeout")
    public final int deathTimeout;

    @SerializedName("enable_auto_recovery")
    public final boolean enableAutoRecovery;

    @SerializedName("enable_config")
    public final boolean enableConfig;

    @SerializedName("enable_death_check")
    public final boolean enableDetachCheck;

    @SerializedName("enable_mc_monitor")
    public final boolean enableMcMonitor;

    @SerializedName("enable_refactor")
    public final boolean enableRefactor;

    @SerializedName("enable_ttplayer_view")
    public final boolean enableTTPlayerView;

    @SerializedName("mediacodec_frame_nums")
    public final int mediacodecFrameNums;

    @SerializedName("mediacodec_pipeline")
    public final boolean mediacodecPipeline;

    @SerializedName("moderate_to_Loose_Thresh")
    public final int moderateToLooseThresh;

    @SerializedName("only_surface_view")
    public final boolean onlySurfaceView;

    @SerializedName("strict_to_moderate_thresh")
    public final int strictToModerateThresh;

    public VideoTTPlayerViewConfig() {
        this(false, false, false, false, false, false, false, 0, 0, false, 0, 0, 0, 8191, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598300);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoTTPlayerViewConfig a() {
            return (VideoTTPlayerViewConfig) VideoTTPlayerViewConfig.b.getValue();
        }
    }

    static {
        Lazy<VideoTTPlayerViewConfig> lazy;
        Covode.recordClassIndex(598299);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoTTPlayerViewConfig c;
                c = VideoTTPlayerViewConfig.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoTTPlayerViewConfig c() {
        return (VideoTTPlayerViewConfig) qq3.a.a("video_ttplayer_view", new VideoTTPlayerViewConfig(false, false, false, false, false, false, false, 0, 0, false, 0, 0, 0, 8191, null), true);
    }

    public VideoTTPlayerViewConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, int i2, boolean z8, int i3, int i4, int i5) {
        this.enableTTPlayerView = z;
        this.onlySurfaceView = z2;
        this.enableConfig = z3;
        this.enableRefactor = z4;
        this.enableAutoRecovery = z5;
        this.enableDetachCheck = z6;
        this.enableMcMonitor = z7;
        this.deathCheckInterval = i;
        this.deathTimeout = i2;
        this.mediacodecPipeline = z8;
        this.mediacodecFrameNums = i3;
        this.strictToModerateThresh = i4;
        this.moderateToLooseThresh = i5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoTTPlayerViewConfig(boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, int r22, int r23, boolean r24, int r25, int r26, int r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r15
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 1
            goto L12
        L10:
            r3 = r16
        L12:
            r4 = r0 & 4
            if (r4 == 0) goto L18
            r4 = 0
            goto L1a
        L18:
            r4 = r17
        L1a:
            r5 = r0 & 8
            if (r5 == 0) goto L20
            r5 = 0
            goto L22
        L20:
            r5 = r18
        L22:
            r6 = r0 & 16
            if (r6 == 0) goto L28
            r6 = 0
            goto L2a
        L28:
            r6 = r19
        L2a:
            r7 = r0 & 32
            if (r7 == 0) goto L30
            r7 = 0
            goto L32
        L30:
            r7 = r20
        L32:
            r8 = r0 & 64
            if (r8 == 0) goto L38
            r8 = 0
            goto L3a
        L38:
            r8 = r21
        L3a:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L41
            r9 = 100
            goto L43
        L41:
            r9 = r22
        L43:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L4a
            r10 = 1000(0x3e8, float:1.401E-42)
            goto L4c
        L4a:
            r10 = r23
        L4c:
            r11 = r0 & 512(0x200, float:7.17E-43)
            if (r11 == 0) goto L51
            goto L53
        L51:
            r2 = r24
        L53:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            r12 = -1
            if (r11 == 0) goto L5a
            r11 = -1
            goto L5c
        L5a:
            r11 = r25
        L5c:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L62
            r13 = -1
            goto L64
        L62:
            r13 = r26
        L64:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L69
            goto L6b
        L69:
            r12 = r27
        L6b:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r2
            r26 = r11
            r27 = r13
            r28 = r12
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.VideoTTPlayerViewConfig.<init>(boolean, boolean, boolean, boolean, boolean, boolean, boolean, int, int, boolean, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
