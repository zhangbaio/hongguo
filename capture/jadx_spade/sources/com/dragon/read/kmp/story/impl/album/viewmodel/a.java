package com.dragon.read.kmp.story.impl.album.viewmodel;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.community.base.sdk.load.KmpCSSLoadStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int i;
    public final KmpCSSLoadStatus a;
    public final KmpCSSLoadStatus b;
    public final KmpCSSLoadStatus c;
    public final boolean d;
    public final boolean e;
    public final c f;
    public final String g;
    public final int h;

    static {
        Covode.recordClassIndex(609221);
        i = 8;
    }

    public a() {
        this(null, null, null, false, false, null, null, 0, 255, null);
    }

    public final a a(KmpCSSLoadStatus pageLoadStatus, KmpCSSLoadStatus nextLoadStatus, KmpCSSLoadStatus prevLoadStatus, boolean z, boolean z2, c dataAdapter, String str, int i2) {
        Intrinsics.checkNotNullParameter(pageLoadStatus, "pageLoadStatus");
        Intrinsics.checkNotNullParameter(nextLoadStatus, "nextLoadStatus");
        Intrinsics.checkNotNullParameter(prevLoadStatus, "prevLoadStatus");
        Intrinsics.checkNotNullParameter(dataAdapter, "dataAdapter");
        return new a(pageLoadStatus, nextLoadStatus, prevLoadStatus, z, z2, dataAdapter, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g) && this.h == aVar.h;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + m.a(this.d)) * 31) + m.a(this.e)) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.h;
    }

    public String toString() {
        return "KmpAlbumListState(pageLoadStatus=" + this.a + ", nextLoadStatus=" + this.b + ", prevLoadStatus=" + this.c + ", hasMore=" + this.d + ", hasPrev=" + this.e + ", dataAdapter=" + this.f + ", currentStoryId=" + this.g + ", currentTheme=" + this.h + ')';
    }

    public a(KmpCSSLoadStatus pageLoadStatus, KmpCSSLoadStatus nextLoadStatus, KmpCSSLoadStatus prevLoadStatus, boolean z, boolean z2, c dataAdapter, String str, int i2) {
        Intrinsics.checkNotNullParameter(pageLoadStatus, "pageLoadStatus");
        Intrinsics.checkNotNullParameter(nextLoadStatus, "nextLoadStatus");
        Intrinsics.checkNotNullParameter(prevLoadStatus, "prevLoadStatus");
        Intrinsics.checkNotNullParameter(dataAdapter, "dataAdapter");
        this.a = pageLoadStatus;
        this.b = nextLoadStatus;
        this.c = prevLoadStatus;
        this.d = z;
        this.e = z2;
        this.f = dataAdapter;
        this.g = str;
        this.h = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(com.dragon.community.base.sdk.load.KmpCSSLoadStatus r10, com.dragon.community.base.sdk.load.KmpCSSLoadStatus r11, com.dragon.community.base.sdk.load.KmpCSSLoadStatus r12, boolean r13, boolean r14, com.dragon.read.kmp.story.impl.album.viewmodel.c r15, java.lang.String r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L9
            com.dragon.community.base.sdk.load.KmpCSSLoadStatus r1 = com.dragon.community.base.sdk.load.KmpCSSLoadStatus.Loading
            goto La
        L9:
            r1 = r10
        La:
            r2 = r0 & 2
            if (r2 == 0) goto L11
            com.dragon.community.base.sdk.load.KmpCSSLoadStatus r2 = com.dragon.community.base.sdk.load.KmpCSSLoadStatus.Init
            goto L12
        L11:
            r2 = r11
        L12:
            r3 = r0 & 4
            if (r3 == 0) goto L19
            com.dragon.community.base.sdk.load.KmpCSSLoadStatus r3 = com.dragon.community.base.sdk.load.KmpCSSLoadStatus.Init
            goto L1a
        L19:
            r3 = r12
        L1a:
            r4 = r0 & 8
            r5 = 1
            if (r4 == 0) goto L21
            r4 = 1
            goto L22
        L21:
            r4 = r13
        L22:
            r6 = r0 & 16
            if (r6 == 0) goto L28
            r6 = 0
            goto L29
        L28:
            r6 = r14
        L29:
            r7 = r0 & 32
            if (r7 == 0) goto L33
            com.dragon.read.kmp.story.impl.album.viewmodel.c r7 = new com.dragon.read.kmp.story.impl.album.viewmodel.c
            r7.<init>()
            goto L34
        L33:
            r7 = r15
        L34:
            r8 = r0 & 64
            if (r8 == 0) goto L3a
            r8 = 0
            goto L3c
        L3a:
            r8 = r16
        L3c:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L41
            goto L43
        L41:
            r5 = r17
        L43:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r5
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.viewmodel.a.<init>(com.dragon.community.base.sdk.load.KmpCSSLoadStatus, com.dragon.community.base.sdk.load.KmpCSSLoadStatus, com.dragon.community.base.sdk.load.KmpCSSLoadStatus, boolean, boolean, com.dragon.read.kmp.story.impl.album.viewmodel.c, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
