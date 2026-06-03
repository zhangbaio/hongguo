package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class OpenInnerSeriesPagePrepareV699 {
    public static final a a;
    private static final Lazy<OpenInnerSeriesPagePrepareV699> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("enable_open_frequency")
    public final boolean enableOpenFrequency;

    @SerializedName("enable_open_frequency_for_result")
    public final boolean enableOpenFrequencyForResult;

    @SerializedName("open_frequency")
    public final long openFrequency;

    public OpenInnerSeriesPagePrepareV699() {
        this(false, false, false, 0L, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598398);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OpenInnerSeriesPagePrepareV699 a() {
            return (OpenInnerSeriesPagePrepareV699) OpenInnerSeriesPagePrepareV699.b.getValue();
        }
    }

    static {
        Lazy<OpenInnerSeriesPagePrepareV699> lazy;
        Covode.recordClassIndex(598397);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OpenInnerSeriesPagePrepareV699 c;
                c = OpenInnerSeriesPagePrepareV699.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OpenInnerSeriesPagePrepareV699 c() {
        return (OpenInnerSeriesPagePrepareV699) qq3.a.c("open_inner_series_page_prepare_v699", new OpenInnerSeriesPagePrepareV699(false, false, false, 0L, 15, null), false, 4, null);
    }

    public OpenInnerSeriesPagePrepareV699(boolean z, boolean z2, boolean z3, long j) {
        this.enable = z;
        this.enableOpenFrequency = z2;
        this.enableOpenFrequencyForResult = z3;
        this.openFrequency = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ OpenInnerSeriesPagePrepareV699(boolean r3, boolean r4, boolean r5, long r6, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r2 = this;
            r9 = r8 & 1
            r0 = 0
            if (r9 == 0) goto L7
            r9 = 0
            goto L8
        L7:
            r9 = r3
        L8:
            r3 = r8 & 2
            if (r3 == 0) goto Le
            r1 = 0
            goto Lf
        Le:
            r1 = r4
        Lf:
            r3 = r8 & 4
            if (r3 == 0) goto L14
            goto L15
        L14:
            r0 = r5
        L15:
            r3 = r8 & 8
            if (r3 == 0) goto L1b
            r6 = 500(0x1f4, double:2.47E-321)
        L1b:
            r7 = r6
            r3 = r2
            r4 = r9
            r5 = r1
            r6 = r0
            r3.<init>(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.OpenInnerSeriesPagePrepareV699.<init>(boolean, boolean, boolean, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
