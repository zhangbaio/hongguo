package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SingleBackToFirstGuideV675 {
    public static final a a;
    private static final Lazy<SingleBackToFirstGuideV675> b;

    @SerializedName("enable_guide")
    public final boolean enableGuide;

    @SerializedName("guide_background_color")
    public final String guideBackgroundColor;

    @SerializedName("guide_content")
    public final String guideContent;

    @SerializedName("guide_show_time")
    public final int guideShowTime;

    @SerializedName("guide_toast_content")
    public final String guideToastContent;

    public SingleBackToFirstGuideV675() {
        this(false, null, null, 0, null, 31, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598532);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return e().guideBackgroundColor;
        }

        public final String b() {
            return e().guideContent;
        }

        public final int c() {
            return e().guideShowTime;
        }

        public final String d() {
            return e().guideToastContent;
        }

        public final boolean f() {
            return e().enableGuide;
        }

        private final SingleBackToFirstGuideV675 e() {
            return (SingleBackToFirstGuideV675) SingleBackToFirstGuideV675.b.getValue();
        }
    }

    static {
        Lazy<SingleBackToFirstGuideV675> lazy;
        Covode.recordClassIndex(598531);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.g2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleBackToFirstGuideV675 c;
                c = SingleBackToFirstGuideV675.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleBackToFirstGuideV675 c() {
        return (SingleBackToFirstGuideV675) qq3.a.c("video_feed_back_to_first_config", new SingleBackToFirstGuideV675(false, null, null, 0, null, 31, null), false, 4, null);
    }

    public SingleBackToFirstGuideV675(boolean z, String guideContent, String guideToastContent, int i, String guideBackgroundColor) {
        Intrinsics.checkNotNullParameter(guideContent, "guideContent");
        Intrinsics.checkNotNullParameter(guideToastContent, "guideToastContent");
        Intrinsics.checkNotNullParameter(guideBackgroundColor, "guideBackgroundColor");
        this.enableGuide = z;
        this.guideContent = guideContent;
        this.guideToastContent = guideToastContent;
        this.guideShowTime = i;
        this.guideBackgroundColor = guideBackgroundColor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SingleBackToFirstGuideV675(boolean r4, java.lang.String r5, java.lang.String r6, int r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L5
            r4 = 0
        L5:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto Ld
            r10 = r0
            goto Le
        Ld:
            r10 = r5
        Le:
            r5 = r9 & 4
            if (r5 == 0) goto L14
            r1 = r0
            goto L15
        L14:
            r1 = r6
        L15:
            r5 = r9 & 8
            if (r5 == 0) goto L1c
            r7 = -1
            r2 = -1
            goto L1d
        L1c:
            r2 = r7
        L1d:
            r5 = r9 & 16
            if (r5 == 0) goto L22
            goto L23
        L22:
            r0 = r8
        L23:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.SingleBackToFirstGuideV675.<init>(boolean, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
