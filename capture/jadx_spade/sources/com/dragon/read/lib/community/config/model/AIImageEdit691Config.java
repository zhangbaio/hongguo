package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AIImageEdit691Config {

    @SerializedName("enable_add_tag_to_result_image")
    public final boolean enableAddTagToResultImage;

    @SerializedName("enable_add_text_to_generate_image")
    public final boolean enableAddTextToGenerateImage;

    @SerializedName("enable_ai_page_new_style")
    public final boolean enableAiPageNewStyle;

    @SerializedName("enable_generate_video_from_result_image")
    public final boolean enableGenerateVideoFromResultImage;

    @SerializedName("enable_memory_last_edit_action")
    public final boolean enableMemoryLastEditAction;

    @SerializedName("enable_new_style_to_generate_image")
    public final boolean enableNewStyleToGenerateImage;

    static {
        Covode.recordClassIndex(611345);
    }

    public AIImageEdit691Config() {
        this(false, false, false, false, false, false, 63, null);
    }

    public AIImageEdit691Config(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.enableAiPageNewStyle = z;
        this.enableNewStyleToGenerateImage = z2;
        this.enableAddTextToGenerateImage = z3;
        this.enableAddTagToResultImage = z4;
        this.enableGenerateVideoFromResultImage = z5;
        this.enableMemoryLastEditAction = z6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AIImageEdit691Config(boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.lib.community.config.model.AIImageEdit691Config.<init>(boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
