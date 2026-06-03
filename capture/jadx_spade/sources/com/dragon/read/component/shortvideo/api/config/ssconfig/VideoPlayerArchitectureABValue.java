package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoPlayerArchitectureABValue {

    @SerializedName("architecture")
    private final int architecture;

    @SerializedName("bind_big_core")
    private final boolean bindCore;

    @SerializedName("layout_opt")
    private final boolean layoutOpt;

    @SerializedName("max_pool_thread")
    private final int maxPoolThread;

    @SerializedName("pool_thread_priority")
    private final int threadPriority;

    static {
        Covode.recordClassIndex(598592);
    }

    public VideoPlayerArchitectureABValue() {
        this(0, 0, 0, false, false, 31, null);
    }

    public final int a() {
        if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).enableVideoLandingOpt()) {
            return 6;
        }
        return this.architecture;
    }

    public final int b() {
        if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).enableVideoLandingOpt()) {
            return 4;
        }
        return this.maxPoolThread;
    }

    public final int c() {
        if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).enableVideoLandingOpt()) {
            return -20;
        }
        return this.threadPriority;
    }

    public final boolean d() {
        if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).enableVideoLandingOpt()) {
            return false;
        }
        return this.bindCore;
    }

    public final boolean e() {
        if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).enableVideoLandingOpt()) {
            return true;
        }
        return this.layoutOpt;
    }

    public VideoPlayerArchitectureABValue(int i, int i2, int i3, boolean z, boolean z2) {
        this.architecture = i;
        this.maxPoolThread = i2;
        this.threadPriority = i3;
        this.bindCore = z;
        this.layoutOpt = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoPlayerArchitectureABValue(int r4, int r5, int r6, boolean r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L5
            r4 = 6
        L5:
            r10 = r9 & 2
            if (r10 == 0) goto Lc
            r5 = 4
            r10 = 4
            goto Ld
        Lc:
            r10 = r5
        Ld:
            r5 = r9 & 4
            if (r5 == 0) goto L16
            r6 = -20
            r0 = -20
            goto L17
        L16:
            r0 = r6
        L17:
            r5 = r9 & 8
            r6 = 0
            if (r5 == 0) goto L1e
            r1 = 0
            goto L1f
        L1e:
            r1 = r7
        L1f:
            r5 = r9 & 16
            if (r5 == 0) goto L25
            r2 = 0
            goto L26
        L25:
            r2 = r8
        L26:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoPlayerArchitectureABValue.<init>(int, int, int, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
