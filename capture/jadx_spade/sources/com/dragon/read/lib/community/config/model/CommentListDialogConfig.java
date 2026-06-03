package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CommentListDialogConfig {
    public static final int a = 0;

    @SerializedName("above_comment_px")
    public final float aboveCommentPx;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("enable_expand")
    public final boolean enableExpand;

    @SerializedName("enable_swipe")
    public final boolean enableSwipe;

    @SerializedName("init_view_height_percent")
    public final float initViewHeightPercent;

    static {
        Covode.recordClassIndex(611350);
    }

    public CommentListDialogConfig() {
        this(false, 0.0f, false, 0.0f, false, 31, null);
    }

    public CommentListDialogConfig(boolean z, float f, boolean z2, float f2, boolean z3) {
        this.enable = z;
        this.initViewHeightPercent = f;
        this.enableExpand = z2;
        this.aboveCommentPx = f2;
        this.enableSwipe = z3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ CommentListDialogConfig(boolean r5, float r6, boolean r7, float r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
            if (r5 == 0) goto L13
            r6 = 1063675494(0x3f666666, float:0.9)
            r1 = 1063675494(0x3f666666, float:0.9)
            goto L14
        L13:
            r1 = r6
        L14:
            r5 = r10 & 4
            if (r5 == 0) goto L1a
            r2 = 0
            goto L1b
        L1a:
            r2 = r7
        L1b:
            r5 = r10 & 8
            if (r5 == 0) goto L24
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L25
        L24:
            r3 = r8
        L25:
            r5 = r10 & 16
            if (r5 == 0) goto L2b
            r10 = 0
            goto L2c
        L2b:
            r10 = r9
        L2c:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.lib.community.config.model.CommentListDialogConfig.<init>(boolean, float, boolean, float, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
