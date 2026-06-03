package com.dragon.read.kmp.profile.guestprofile.aicontent;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l implements jd4.b {
    public static final int r;
    public String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public AiGeneratedVideoGenerationState n;
    public float o;
    public final a p;
    public boolean q;

    static {
        Covode.recordClassIndex(608114);
        r = 8;
    }

    public l() {
        this(null, null, null, null, false, null, null, null, null, null, false, false, false, null, 0.0f, null, false, 131071, null);
    }

    public final l a(String taskId, String vid, String title, String bgUrl, boolean z, String lightBgUrl, String darkBgUrl, String coverUrl, String coverUri, String centerText, boolean z2, boolean z3, boolean z4, AiGeneratedVideoGenerationState generationState, float f, a retryState, boolean z5) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bgUrl, "bgUrl");
        Intrinsics.checkNotNullParameter(lightBgUrl, "lightBgUrl");
        Intrinsics.checkNotNullParameter(darkBgUrl, "darkBgUrl");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverUri, "coverUri");
        Intrinsics.checkNotNullParameter(centerText, "centerText");
        Intrinsics.checkNotNullParameter(generationState, "generationState");
        Intrinsics.checkNotNullParameter(retryState, "retryState");
        return new l(taskId, vid, title, bgUrl, z, lightBgUrl, darkBgUrl, coverUrl, coverUri, centerText, z2, z3, z4, generationState, f, retryState, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual(this.a, lVar.a) && Intrinsics.areEqual(this.b, lVar.b) && Intrinsics.areEqual(this.c, lVar.c) && Intrinsics.areEqual(this.d, lVar.d) && this.e == lVar.e && Intrinsics.areEqual(this.f, lVar.f) && Intrinsics.areEqual(this.g, lVar.g) && Intrinsics.areEqual(this.h, lVar.h) && Intrinsics.areEqual(this.i, lVar.i) && Intrinsics.areEqual(this.j, lVar.j) && this.k == lVar.k && this.l == lVar.l && this.m == lVar.m && this.n == lVar.n && Float.compare(this.o, lVar.o) == 0 && Intrinsics.areEqual(this.p, lVar.p) && this.q == lVar.q;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + androidx.compose.animation.m.a(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + androidx.compose.animation.m.a(this.k)) * 31) + androidx.compose.animation.m.a(this.l)) * 31) + androidx.compose.animation.m.a(this.m)) * 31) + this.n.hashCode()) * 31) + Float.floatToIntBits(this.o)) * 31) + this.p.hashCode()) * 31) + androidx.compose.animation.m.a(this.q);
    }

    public String toString() {
        return "AiGeneratedVideoState(taskId=" + this.a + ", vid=" + this.b + ", title=" + this.c + ", bgUrl=" + this.d + ", showBgBrush=" + this.e + ", lightBgUrl=" + this.f + ", darkBgUrl=" + this.g + ", coverUrl=" + this.h + ", coverUri=" + this.i + ", centerText=" + this.j + ", showBottomPreviewButton=" + this.k + ", showBottomRetryButton=" + this.l + ", showBottomButton=" + this.m + ", generationState=" + this.n + ", progress=" + this.o + ", retryState=" + this.p + ", isShown=" + this.q + ')';
    }

    public boolean isShown() {
        return this.q;
    }

    public void setShown(boolean z) {
        this.q = z;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.j = str;
    }

    public final void d(AiGeneratedVideoGenerationState aiGeneratedVideoGenerationState) {
        Intrinsics.checkNotNullParameter(aiGeneratedVideoGenerationState, "<set-?>");
        this.n = aiGeneratedVideoGenerationState;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public l(String taskId, String vid, String title, String bgUrl, boolean z, String lightBgUrl, String darkBgUrl, String coverUrl, String coverUri, String centerText, boolean z2, boolean z3, boolean z4, AiGeneratedVideoGenerationState generationState, float f, a retryState, boolean z5) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bgUrl, "bgUrl");
        Intrinsics.checkNotNullParameter(lightBgUrl, "lightBgUrl");
        Intrinsics.checkNotNullParameter(darkBgUrl, "darkBgUrl");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverUri, "coverUri");
        Intrinsics.checkNotNullParameter(centerText, "centerText");
        Intrinsics.checkNotNullParameter(generationState, "generationState");
        Intrinsics.checkNotNullParameter(retryState, "retryState");
        this.a = taskId;
        this.b = vid;
        this.c = title;
        this.d = bgUrl;
        this.e = z;
        this.f = lightBgUrl;
        this.g = darkBgUrl;
        this.h = coverUrl;
        this.i = coverUri;
        this.j = centerText;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = generationState;
        this.o = f;
        this.p = retryState;
        this.q = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ l(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, boolean r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, boolean r36, boolean r37, boolean r38, com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoGenerationState r39, float r40, com.dragon.read.kmp.profile.guestprofile.aicontent.a r41, boolean r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.aicontent.l.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoGenerationState, float, com.dragon.read.kmp.profile.guestprofile.aicontent.a, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
