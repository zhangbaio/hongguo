package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesSwipeBackFixABValue {
    public static final a a;
    private static final Lazy<SeriesSwipeBackFixABValue> b;

    @SerializedName("block_animating")
    public final boolean blockAnimating;

    @SerializedName("block_insert")
    public final boolean blockInsert;

    @SerializedName("catch")
    public final boolean catchEnable;

    @SerializedName("clean")
    public final boolean clean;

    @SerializedName("remove_early")
    public final boolean removeEarly;

    @SerializedName("swipe_only")
    public final boolean swipeOnly;

    public SeriesSwipeBackFixABValue() {
        this(false, false, false, false, false, false, 63, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598505);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesSwipeBackFixABValue a() {
            return (SeriesSwipeBackFixABValue) SeriesSwipeBackFixABValue.b.getValue();
        }
    }

    static {
        Lazy<SeriesSwipeBackFixABValue> lazy;
        Covode.recordClassIndex(598504);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.v1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesSwipeBackFixABValue c;
                c = SeriesSwipeBackFixABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesSwipeBackFixABValue c() {
        return (SeriesSwipeBackFixABValue) qq3.a.a("series_swipe_back_fix_v661", new SeriesSwipeBackFixABValue(false, false, false, false, false, false, 63, null), true);
    }

    public SeriesSwipeBackFixABValue(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.clean = z;
        this.swipeOnly = z2;
        this.removeEarly = z3;
        this.blockAnimating = z4;
        this.catchEnable = z5;
        this.blockInsert = z6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SeriesSwipeBackFixABValue(boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L7
            r13 = 0
            goto L8
        L7:
            r13 = r6
        L8:
            r6 = r12 & 2
            if (r6 == 0) goto Le
            r1 = 0
            goto Lf
        Le:
            r1 = r7
        Lf:
            r6 = r12 & 4
            if (r6 == 0) goto L15
            r2 = 0
            goto L16
        L15:
            r2 = r8
        L16:
            r6 = r12 & 8
            if (r6 == 0) goto L1c
            r3 = 0
            goto L1d
        L1c:
            r3 = r9
        L1d:
            r6 = r12 & 16
            if (r6 == 0) goto L23
            r4 = 0
            goto L24
        L23:
            r4 = r10
        L24:
            r6 = r12 & 32
            if (r6 == 0) goto L2a
            r12 = 0
            goto L2b
        L2a:
            r12 = r11
        L2b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.SeriesSwipeBackFixABValue.<init>(boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
