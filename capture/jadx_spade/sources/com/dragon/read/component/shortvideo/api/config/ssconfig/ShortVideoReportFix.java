package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortVideoReportFix {
    public static final a a;
    private static final Lazy<ShortVideoReportFix> b;

    @SerializedName("fix_current_page_recorder")
    public final boolean fixCurrentPageRecorder;

    @SerializedName("fix_show_profile")
    public final boolean fixShowProfile;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShortVideoReportFix() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.ShortVideoReportFix.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598524);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortVideoReportFix a() {
            return (ShortVideoReportFix) ShortVideoReportFix.b.getValue();
        }
    }

    static {
        Lazy<ShortVideoReportFix> lazy;
        Covode.recordClassIndex(598523);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.b2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoReportFix c;
                c = ShortVideoReportFix.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoReportFix c() {
        boolean z = false;
        return (ShortVideoReportFix) qq3.a.c("short_video_report_fix_v683", new ShortVideoReportFix(z, z, 3, null), false, 4, null);
    }

    public ShortVideoReportFix(boolean z, boolean z2) {
        this.fixCurrentPageRecorder = z;
        this.fixShowProfile = z2;
    }

    public /* synthetic */ ShortVideoReportFix(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }
}
