package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CenterAnimationResConfigsWrap {

    @SerializedName("cdn_url")
    public final String cdnUrl;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("height")
    public final int height;

    @SerializedName("lottie_url_list")
    public final List<String> lottieUrlList;

    @SerializedName("width")
    public final int width;

    static {
        Covode.recordClassIndex(598323);
    }

    public CenterAnimationResConfigsWrap() {
        this(false, null, 0, 0, null, 31, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CenterAnimationResConfigsWrap)) {
            return false;
        }
        CenterAnimationResConfigsWrap centerAnimationResConfigsWrap = (CenterAnimationResConfigsWrap) obj;
        return this.enable == centerAnimationResConfigsWrap.enable && Intrinsics.areEqual(this.lottieUrlList, centerAnimationResConfigsWrap.lottieUrlList) && this.width == centerAnimationResConfigsWrap.width && this.height == centerAnimationResConfigsWrap.height && Intrinsics.areEqual(this.cdnUrl, centerAnimationResConfigsWrap.cdnUrl);
    }

    public int hashCode() {
        return (((((((androidx.compose.animation.m.a(this.enable) * 31) + this.lottieUrlList.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.cdnUrl.hashCode();
    }

    public String toString() {
        return "CenterAnimationResConfigsWrap(enable=" + this.enable + ", lottieUrlList=" + this.lottieUrlList + ", width=" + this.width + ", height=" + this.height + ", cdnUrl=" + this.cdnUrl + ')';
    }

    public CenterAnimationResConfigsWrap(boolean z, List<String> lottieUrlList, int i, int i2, String cdnUrl) {
        Intrinsics.checkNotNullParameter(lottieUrlList, "lottieUrlList");
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        this.enable = z;
        this.lottieUrlList = lottieUrlList;
        this.width = i;
        this.height = i2;
        this.cdnUrl = cdnUrl;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ CenterAnimationResConfigsWrap(boolean r4, java.util.List r5, int r6, int r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L5
            r4 = 0
        L5:
            r10 = r9 & 2
            if (r10 == 0) goto Ld
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        Ld:
            r10 = r5
            r5 = r9 & 4
            r0 = -1
            if (r5 == 0) goto L15
            r1 = -1
            goto L16
        L15:
            r1 = r6
        L16:
            r5 = r9 & 8
            if (r5 == 0) goto L1b
            goto L1c
        L1b:
            r0 = r7
        L1c:
            r5 = r9 & 16
            if (r5 == 0) goto L22
            java.lang.String r8 = ""
        L22:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.CenterAnimationResConfigsWrap.<init>(boolean, java.util.List, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
