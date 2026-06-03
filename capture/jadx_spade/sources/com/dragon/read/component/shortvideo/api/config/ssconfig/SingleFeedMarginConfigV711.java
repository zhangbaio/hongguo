package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SingleFeedMarginConfigV711 {
    public static final a a;
    private static final Lazy<SingleFeedMarginConfigV711> b;

    @SerializedName("bottom_margin")
    public final int bottomMargin;

    @SerializedName("bottom_margin_without_bottom_bar")
    public final int bottomMarginWithoutBottomBar;

    @SerializedName("enable_margin_opt")
    public final boolean enable;

    @SerializedName("end_margin")
    public final int endMargin;

    @SerializedName("fix_right_view_layout")
    public final boolean fixRightViewLayout;

    public SingleFeedMarginConfigV711() {
        this(false, 0, 0, 0, false, 31, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598534);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SingleFeedMarginConfigV711 a() {
            return (SingleFeedMarginConfigV711) SingleFeedMarginConfigV711.b.getValue();
        }
    }

    static {
        Lazy<SingleFeedMarginConfigV711> lazy;
        Covode.recordClassIndex(598533);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.h2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleFeedMarginConfigV711 c;
                c = SingleFeedMarginConfigV711.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleFeedMarginConfigV711 c() {
        return (SingleFeedMarginConfigV711) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "single_feed_margin_config_v711", new SingleFeedMarginConfigV711(false, 0, 0, 0, false, 31, null), false, 4, null);
    }

    public SingleFeedMarginConfigV711(boolean z, int i, int i2, int i3, boolean z2) {
        this.enable = z;
        this.bottomMargin = i;
        this.bottomMarginWithoutBottomBar = i2;
        this.endMargin = i3;
        this.fixRightViewLayout = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SingleFeedMarginConfigV711(boolean r5, int r6, int r7, int r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L7
            r11 = 0
            goto L8
        L7:
            r11 = r5
        L8:
            r5 = r10 & 2
            if (r5 == 0) goto Le
            r1 = 0
            goto Lf
        Le:
            r1 = r6
        Lf:
            r5 = r10 & 4
            if (r5 == 0) goto L15
            r2 = 0
            goto L16
        L15:
            r2 = r7
        L16:
            r5 = r10 & 8
            if (r5 == 0) goto L1c
            r3 = 0
            goto L1d
        L1c:
            r3 = r8
        L1d:
            r5 = r10 & 16
            if (r5 == 0) goto L23
            r10 = 0
            goto L24
        L23:
            r10 = r9
        L24:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.SingleFeedMarginConfigV711.<init>(boolean, int, int, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
