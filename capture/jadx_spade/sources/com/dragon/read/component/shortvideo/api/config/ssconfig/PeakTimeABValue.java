package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PeakTimeABValue {
    public static final a a;
    private static final Lazy<PeakTimeABValue> b;

    @SerializedName("enable_low_time")
    public final boolean enableLowTime;

    @SerializedName("low_end")
    public final String lowEnd;

    @SerializedName("low_random_range_min")
    public final int lowRandomRangeMin;

    @SerializedName("low_start")
    public final String lowStart;

    @SerializedName("peak_end")
    public final String peakEnd;

    @SerializedName("peak_random_range_min")
    public final int peakRandomRangeMin;

    @SerializedName("peak_start")
    public final String peekStart;

    @SerializedName("suppress_random")
    public final int suppressRandom;

    @SerializedName("suppress_range")
    public final int suppressRange;

    public PeakTimeABValue() {
        this(null, null, 0, 0, 0, false, null, null, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598403);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PeakTimeABValue a() {
            return (PeakTimeABValue) PeakTimeABValue.b.getValue();
        }
    }

    static {
        Lazy<PeakTimeABValue> lazy;
        Covode.recordClassIndex(598402);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PeakTimeABValue c;
                c = PeakTimeABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PeakTimeABValue c() {
        return (PeakTimeABValue) qq3.a.c("peak_time_v629", new PeakTimeABValue(null, null, 0, 0, 0, false, null, null, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null), false, 4, null);
    }

    public PeakTimeABValue(String peekStart, String peakEnd, int i, int i2, int i3, boolean z, String lowStart, String lowEnd, int i4) {
        Intrinsics.checkNotNullParameter(peekStart, "peekStart");
        Intrinsics.checkNotNullParameter(peakEnd, "peakEnd");
        Intrinsics.checkNotNullParameter(lowStart, "lowStart");
        Intrinsics.checkNotNullParameter(lowEnd, "lowEnd");
        this.peekStart = peekStart;
        this.peakEnd = peakEnd;
        this.peakRandomRangeMin = i;
        this.suppressRange = i2;
        this.suppressRandom = i3;
        this.enableLowTime = z;
        this.lowStart = lowStart;
        this.lowEnd = lowEnd;
        this.lowRandomRangeMin = i4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PeakTimeABValue(java.lang.String r11, java.lang.String r12, int r13, int r14, int r15, boolean r16, java.lang.String r17, java.lang.String r18, int r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            if (r1 == 0) goto L9
            java.lang.String r1 = "20:30"
            goto La
        L9:
            r1 = r11
        La:
            r2 = r0 & 2
            if (r2 == 0) goto L11
            java.lang.String r2 = "22:30"
            goto L12
        L11:
            r2 = r12
        L12:
            r3 = r0 & 4
            r4 = 30
            if (r3 == 0) goto L1b
            r3 = 30
            goto L1c
        L1b:
            r3 = r13
        L1c:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L23
            r5 = 0
            goto L24
        L23:
            r5 = r14
        L24:
            r7 = r0 & 16
            if (r7 == 0) goto L2a
            r7 = 0
            goto L2b
        L2a:
            r7 = r15
        L2b:
            r8 = r0 & 32
            if (r8 == 0) goto L30
            goto L32
        L30:
            r6 = r16
        L32:
            r8 = r0 & 64
            if (r8 == 0) goto L39
            java.lang.String r8 = "06:00"
            goto L3b
        L39:
            r8 = r17
        L3b:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L42
            java.lang.String r9 = "20:00"
            goto L44
        L42:
            r9 = r18
        L44:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L49
            goto L4b
        L49:
            r4 = r19
        L4b:
            r11 = r10
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r5
            r16 = r7
            r17 = r6
            r18 = r8
            r19 = r9
            r20 = r4
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.PeakTimeABValue.<init>(java.lang.String, java.lang.String, int, int, int, boolean, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
