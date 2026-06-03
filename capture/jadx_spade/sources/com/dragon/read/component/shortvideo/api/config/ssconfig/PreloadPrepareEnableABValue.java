package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.util.kotlin.NumberKt;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PreloadPrepareEnableABValue {
    public static final a b;
    private static final Lazy<PreloadPrepareEnableABValue> c;
    private final Lazy a;

    @SerializedName("buffer_trigger_percent")
    public final int bufferTriggerPercent;

    @SerializedName("dynamic_buffer_upper_bound")
    public final int dynamicBufferUpperBound;

    @SerializedName("first_frame_prepare_timeout")
    public final int firstFramePrepareTimeout;

    @SerializedName("preload_hot_time_num")
    public final int preloadHotTimeNum;

    @SerializedName("preload_hot_time_size")
    public final long preloadHotTimeSize;

    @SerializedName("preload_low_num")
    public final int preloadLowNum;

    @SerializedName("preload_low_num_wifi")
    public final int preloadLowNumWifi;

    @SerializedName("preload_low_size")
    public final long preloadLowSize;

    @SerializedName("preload_low_size_wifi")
    public final long preloadLowSizeWifi;

    @SerializedName("preload_num")
    public final int preloadNum;

    @SerializedName("preload_size")
    public final long preloadSize;

    @SerializedName("preload_suppress")
    public final List<String> preloadSuppress;

    @SerializedName("prepare_hot_time_range")
    public final int prepareHotTimeRange;

    @SerializedName("prepare_need_size")
    public final long prepareNeedSize;

    @SerializedName("prepare_range")
    public final int prepareRange;

    public PreloadPrepareEnableABValue() {
        this(0, 0, 0, 0, 0L, 0, 0L, null, 0, 0L, 0, 0L, 0L, 0, 0, 32767, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598428);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PreloadPrepareEnableABValue a() {
            return (PreloadPrepareEnableABValue) PreloadPrepareEnableABValue.c.getValue();
        }
    }

    public final List<Pair<Integer, Long>> e() {
        return (List) this.a.getValue();
    }

    static {
        Lazy<PreloadPrepareEnableABValue> lazy;
        Covode.recordClassIndex(598427);
        b = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PreloadPrepareEnableABValue d;
                d = PreloadPrepareEnableABValue.d();
                return d;
            }
        });
        c = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadPrepareEnableABValue d() {
        return (PreloadPrepareEnableABValue) qq3.a.a("video_preload_prepare_v619", new PreloadPrepareEnableABValue(0, 0, 0, 0, 0L, 0, 0L, null, 0, 0L, 0, 0L, 0L, 0, 0, 32767, null), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(PreloadPrepareEnableABValue preloadPrepareEnableABValue) {
        List<String> list = preloadPrepareEnableABValue.preloadSuppress;
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                List split = StringsKt__StringsKt.split((CharSequence) it2.next(), new char[]{'x'}, true, 2);
                arrayList.add(TuplesKt.to(Integer.valueOf(NumberKt.toSafeInt((String) split.get(0), 0)), Long.valueOf(NumberKt.toSafeLong((String) split.get(1), 0L))));
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public PreloadPrepareEnableABValue(int i, int i2, int i3, int i4, long j, int i5, long j2, List<String> list, int i6, long j3, int i7, long j4, long j5, int i8, int i9) {
        Lazy lazy;
        this.prepareRange = i;
        this.prepareHotTimeRange = i2;
        this.dynamicBufferUpperBound = i3;
        this.preloadNum = i4;
        this.preloadSize = j;
        this.preloadHotTimeNum = i5;
        this.preloadHotTimeSize = j2;
        this.preloadSuppress = list;
        this.preloadLowNumWifi = i6;
        this.preloadLowSizeWifi = j3;
        this.preloadLowNum = i7;
        this.preloadLowSize = j4;
        this.prepareNeedSize = j5;
        this.bufferTriggerPercent = i8;
        this.firstFramePrepareTimeout = i9;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List f;
                f = PreloadPrepareEnableABValue.f(PreloadPrepareEnableABValue.this);
                return f;
            }
        });
        this.a = lazy;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PreloadPrepareEnableABValue(int r22, int r23, int r24, int r25, long r26, int r28, long r29, java.util.List r31, int r32, long r33, int r35, long r36, long r38, int r40, int r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto La
            r1 = 512000(0x7d000, float:7.17465E-40)
            goto Lc
        La:
            r1 = r22
        Lc:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L13
            r2 = 0
            goto L15
        L13:
            r2 = r23
        L15:
            r4 = r0 & 4
            if (r4 == 0) goto L1c
            r4 = 20
            goto L1e
        L1c:
            r4 = r24
        L1e:
            r5 = r0 & 8
            if (r5 == 0) goto L24
            r5 = 3
            goto L26
        L24:
            r5 = r25
        L26:
            r7 = r0 & 16
            if (r7 == 0) goto L2e
            r7 = 5242880(0x500000, double:2.590327E-317)
            goto L30
        L2e:
            r7 = r26
        L30:
            r9 = r0 & 32
            if (r9 == 0) goto L35
            goto L37
        L35:
            r3 = r28
        L37:
            r9 = r0 & 64
            if (r9 == 0) goto L3f
            r12 = 1048576(0x100000, double:5.180654E-318)
            goto L41
        L3f:
            r12 = r29
        L41:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L47
            r9 = 0
            goto L49
        L47:
            r9 = r31
        L49:
            r14 = r0 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L4f
            r14 = 3
            goto L51
        L4f:
            r14 = r32
        L51:
            r15 = r0 & 512(0x200, float:7.17E-43)
            if (r15 == 0) goto L59
            r15 = 1048576(0x100000, double:5.180654E-318)
            goto L5b
        L59:
            r15 = r33
        L5b:
            r6 = r0 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L61
            r6 = 3
            goto L63
        L61:
            r6 = r35
        L63:
            r10 = r0 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L6b
            r10 = 1048576(0x100000, double:5.180654E-318)
            goto L6d
        L6b:
            r10 = r36
        L6d:
            r17 = r10
            r10 = r0 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L77
            r10 = 512000(0x7d000, double:2.529616E-318)
            goto L79
        L77:
            r10 = r38
        L79:
            r19 = r10
            r10 = r0 & 8192(0x2000, float:1.148E-41)
            if (r10 == 0) goto L82
            r10 = 90
            goto L84
        L82:
            r10 = r40
        L84:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L8b
            r0 = 300(0x12c, float:4.2E-43)
            goto L8d
        L8b:
            r0 = r41
        L8d:
            r22 = r21
            r23 = r1
            r24 = r2
            r25 = r4
            r26 = r5
            r27 = r7
            r29 = r3
            r30 = r12
            r32 = r9
            r33 = r14
            r34 = r15
            r36 = r6
            r37 = r17
            r39 = r19
            r41 = r10
            r42 = r0
            r22.<init>(r23, r24, r25, r26, r27, r29, r30, r32, r33, r34, r36, r37, r39, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.PreloadPrepareEnableABValue.<init>(int, int, int, int, long, int, long, java.util.List, int, long, int, long, long, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
