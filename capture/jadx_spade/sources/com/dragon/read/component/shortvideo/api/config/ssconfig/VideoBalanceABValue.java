package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoBalanceABValue {
    public static final a a;
    private static final Lazy<VideoBalanceABValue> b;

    @SerializedName("ae_config_json_str")
    public final JsonObject aeConfigJsonStr;

    @SerializedName("enable_block_size_opt")
    public final boolean enableBlockSizeOpt;

    @SerializedName("enable_opt")
    public final boolean enableOpt;

    @SerializedName("forbid_compressor")
    public final boolean forbidCompressor;

    @SerializedName("force_back_compressor")
    public final boolean forceBackCompressor;

    @SerializedName("pre_delay")
    public final float preDelay;

    @SerializedName("pre_gain")
    public final float preGain;

    @SerializedName("ratio")
    public final float ratio;

    @SerializedName("read_info_from_stream")
    public final boolean readInfoFromStream;

    @SerializedName("target_loudness")
    public final float targetLoudness;

    @SerializedName("threshold")
    public final float threshold;

    @SerializedName("type")
    public final int type;

    public VideoBalanceABValue() {
        this(0, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, null, false, false, false, 4095, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598544);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoBalanceABValue a() {
            return (VideoBalanceABValue) VideoBalanceABValue.b.getValue();
        }
    }

    static {
        Lazy<VideoBalanceABValue> lazy;
        Covode.recordClassIndex(598543);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.m2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoBalanceABValue c;
                c = VideoBalanceABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoBalanceABValue c() {
        return (VideoBalanceABValue) qq3.a.a("video_balance_opt_v635", new VideoBalanceABValue(0, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, null, false, false, false, 4095, null), true);
    }

    public VideoBalanceABValue(int i, boolean z, float f, float f2, float f3, float f4, float f5, boolean z2, JsonObject aeConfigJsonStr, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(aeConfigJsonStr, "aeConfigJsonStr");
        this.type = i;
        this.enableOpt = z;
        this.preGain = f;
        this.ratio = f2;
        this.threshold = f3;
        this.preDelay = f4;
        this.targetLoudness = f5;
        this.forbidCompressor = z2;
        this.aeConfigJsonStr = aeConfigJsonStr;
        this.readInfoFromStream = z3;
        this.enableBlockSizeOpt = z4;
        this.forceBackCompressor = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoBalanceABValue(int r14, boolean r15, float r16, float r17, float r18, float r19, float r20, boolean r21, com.google.gson.JsonObject r22, boolean r23, boolean r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r14
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 0
            goto L11
        L10:
            r3 = r15
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L18
            r4 = 1048576000(0x3e800000, float:0.25)
            goto L1a
        L18:
            r4 = r16
        L1a:
            r5 = r0 & 8
            if (r5 == 0) goto L21
            r5 = 1090519040(0x41000000, float:8.0)
            goto L23
        L21:
            r5 = r17
        L23:
            r6 = r0 & 16
            if (r6 == 0) goto L2a
            r6 = -1047527424(0xffffffffc1900000, float:-18.0)
            goto L2c
        L2a:
            r6 = r18
        L2c:
            r7 = r0 & 32
            if (r7 == 0) goto L34
            r7 = 1004888130(0x3be56042, float:0.007)
            goto L36
        L34:
            r7 = r19
        L36:
            r8 = r0 & 64
            if (r8 == 0) goto L3c
            r8 = 0
            goto L3e
        L3c:
            r8 = r20
        L3e:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L44
            r9 = 0
            goto L46
        L44:
            r9 = r21
        L46:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L50
            com.google.gson.JsonObject r10 = new com.google.gson.JsonObject
            r10.<init>()
            goto L52
        L50:
            r10 = r22
        L52:
            r11 = r0 & 512(0x200, float:7.17E-43)
            if (r11 == 0) goto L58
            r11 = 0
            goto L5a
        L58:
            r11 = r23
        L5a:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L60
            r12 = 0
            goto L62
        L60:
            r12 = r24
        L62:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L67
            goto L69
        L67:
            r2 = r25
        L69:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoBalanceABValue.<init>(int, boolean, float, float, float, float, float, boolean, com.google.gson.JsonObject, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
