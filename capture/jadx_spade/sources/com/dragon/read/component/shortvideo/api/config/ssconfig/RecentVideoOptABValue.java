package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RecentVideoOptABValue {
    public static final a a;
    private static final Lazy<RecentVideoOptABValue> b;

    @SerializedName("early_prefetch")
    public final boolean earlyPrefetch;

    @SerializedName("prefetch_single_model")
    public final boolean prefetchSingleModel;

    @SerializedName("wait_detail_entrance_list")
    public final List<Integer> waitDetailEntranceList;

    @SerializedName("wait_detail_time")
    public final long waitDetailTime;

    @SerializedName("wait_model_entrance_list")
    public final List<Integer> waitModelEntranceList;

    @SerializedName("wait_model_time")
    public final long waitModelTime;

    @SerializedName("wait_video_detail")
    public final boolean waitVideoDetail;

    @SerializedName("wait_video_model")
    public final boolean waitVideoModel;

    public RecentVideoOptABValue() {
        this(false, false, false, null, 0L, false, null, 0L, 255, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598448);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecentVideoOptABValue a() {
            return (RecentVideoOptABValue) RecentVideoOptABValue.b.getValue();
        }
    }

    static {
        Lazy<RecentVideoOptABValue> lazy;
        Covode.recordClassIndex(598447);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.c1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RecentVideoOptABValue c;
                c = RecentVideoOptABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecentVideoOptABValue c() {
        return (RecentVideoOptABValue) qq3.a.a("recent_read_video_opt_v653", new RecentVideoOptABValue(false, false, false, null, 0L, false, null, 0L, 255, null), true);
    }

    public RecentVideoOptABValue(boolean z, boolean z2, boolean z3, List<Integer> waitDetailEntranceList, long j, boolean z4, List<Integer> waitModelEntranceList, long j2) {
        Intrinsics.checkNotNullParameter(waitDetailEntranceList, "waitDetailEntranceList");
        Intrinsics.checkNotNullParameter(waitModelEntranceList, "waitModelEntranceList");
        this.earlyPrefetch = z;
        this.prefetchSingleModel = z2;
        this.waitVideoDetail = z3;
        this.waitDetailEntranceList = waitDetailEntranceList;
        this.waitDetailTime = j;
        this.waitVideoModel = z4;
        this.waitModelEntranceList = waitModelEntranceList;
        this.waitModelTime = j2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ RecentVideoOptABValue(boolean r12, boolean r13, boolean r14, java.util.List r15, long r16, boolean r18, java.util.List r19, long r20, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
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
            if (r5 == 0) goto L21
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            goto L22
        L21:
            r5 = r15
        L22:
            r6 = r0 & 16
            r7 = 1200(0x4b0, double:5.93E-321)
            if (r6 == 0) goto L2a
            r9 = r7
            goto L2c
        L2a:
            r9 = r16
        L2c:
            r6 = r0 & 32
            if (r6 == 0) goto L31
            goto L33
        L31:
            r2 = r18
        L33:
            r6 = r0 & 64
            if (r6 == 0) goto L3c
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            goto L3e
        L3c:
            r6 = r19
        L3e:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L43
            goto L45
        L43:
            r7 = r20
        L45:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r9
            r19 = r2
            r20 = r6
            r21 = r7
            r12.<init>(r13, r14, r15, r16, r17, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.RecentVideoOptABValue.<init>(boolean, boolean, boolean, java.util.List, long, boolean, java.util.List, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
