package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoCpuABValue {
    public static final a a;
    private static final Lazy<VideoCpuABValue> b;

    @SerializedName("audio_calibration_opt")
    public final int audioCalibrationOpt;

    @SerializedName("audio_mem_integration")
    public final int audioMemIntegration;

    @SerializedName("audio_render_time_report_opt")
    public final int audioRenderTimeReportOpt;

    @SerializedName("audio_use_direct_buffer")
    public final int audioUseDirectBuffer;

    @SerializedName("buffering_end_interval_opt")
    public final int bufferingEndIntervalOpt;

    @SerializedName("buffering_sleep_max_time")
    public final int bufferingSleepMaxTime;

    @SerializedName("buffering_sleep_min_time_opt")
    public final int bufferingSleepMinTimeOpt;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("format_sleep_duration")
    public final int formatSleepDuration;

    @SerializedName("prepared_player_sleep_interval")
    public final int preparedPlayerSleepInterval;

    public VideoCpuABValue() {
        this(false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598555);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoCpuABValue a() {
            return (VideoCpuABValue) VideoCpuABValue.b.getValue();
        }
    }

    static {
        Lazy<VideoCpuABValue> lazy;
        Covode.recordClassIndex(598554);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.q2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoCpuABValue c;
                c = VideoCpuABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoCpuABValue c() {
        return (VideoCpuABValue) qq3.a.a("video_cpu_v637", new VideoCpuABValue(false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null), true);
    }

    public VideoCpuABValue(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.enable = z;
        this.audioUseDirectBuffer = i;
        this.audioMemIntegration = i2;
        this.audioRenderTimeReportOpt = i3;
        this.bufferingEndIntervalOpt = i4;
        this.formatSleepDuration = i5;
        this.audioCalibrationOpt = i6;
        this.bufferingSleepMinTimeOpt = i7;
        this.bufferingSleepMaxTime = i8;
        this.preparedPlayerSleepInterval = i9;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoCpuABValue(boolean r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r12
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 0
            goto L11
        L10:
            r3 = r13
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = 0
            goto L18
        L17:
            r4 = r14
        L18:
            r5 = r0 & 8
            if (r5 == 0) goto L1e
            r5 = 0
            goto L1f
        L1e:
            r5 = r15
        L1f:
            r6 = r0 & 16
            if (r6 == 0) goto L25
            r6 = 0
            goto L27
        L25:
            r6 = r16
        L27:
            r7 = r0 & 32
            if (r7 == 0) goto L2d
            r7 = 0
            goto L2f
        L2d:
            r7 = r17
        L2f:
            r8 = r0 & 64
            if (r8 == 0) goto L35
            r8 = 0
            goto L37
        L35:
            r8 = r18
        L37:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3d
            r9 = 0
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L45
            r10 = 0
            goto L47
        L45:
            r10 = r20
        L47:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L4c
            goto L4e
        L4c:
            r2 = r21
        L4e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoCpuABValue.<init>(boolean, int, int, int, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
