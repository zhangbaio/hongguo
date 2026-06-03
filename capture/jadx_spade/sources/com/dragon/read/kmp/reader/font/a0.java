package com.dragon.read.kmp.reader.font;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final DownloadStatus f;
    public final int g;

    static {
        Covode.recordClassIndex(608432);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.areEqual(this.a, a0Var.a) && Intrinsics.areEqual(this.b, a0Var.b) && Intrinsics.areEqual(this.c, a0Var.c) && this.d == a0Var.d && this.e == a0Var.e && this.f == a0Var.f && this.g == a0Var.g;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d)) * 31) + androidx.compose.animation.m.a(this.e)) * 31) + this.f.hashCode()) * 31) + this.g;
    }

    public String toString() {
        return "FontItemUiState(fontTitle=" + this.a + ", fontPic=" + this.b + ", fileSize=" + this.c + ", isDefaultFont=" + this.d + ", isSelected=" + this.e + ", downloadStatus=" + this.f + ", downloadProgress=" + this.g + ')';
    }

    public a0(String fontTitle, String str, String fileSize, boolean z, boolean z2, DownloadStatus downloadStatus, int i) {
        Intrinsics.checkNotNullParameter(fontTitle, "fontTitle");
        Intrinsics.checkNotNullParameter(fileSize, "fileSize");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        this.a = fontTitle;
        this.b = str;
        this.c = fileSize;
        this.d = z;
        this.e = z2;
        this.f = downloadStatus;
        this.g = i;
    }
}
