package com.dragon.read.kmp.profile.guestprofile.aicontent;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int g;
    public final String a;
    public final List<String> b;
    public final String c;
    public final List<String> d;
    public final Map<String, String> e;
    public final HashMap<String, String> f;

    static {
        Covode.recordClassIndex(608109);
        g = 8;
    }

    public a() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e) && Intrinsics.areEqual(this.f, aVar.f);
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "AiGenerateRetryState(seriesID=" + this.a + ", roleNameList=" + this.b + ", promptContent=" + this.c + ", promptWordList=" + this.d + ", sharkParam=" + this.e + ", extra=" + this.f + ')';
    }

    public a(String seriesID, List<String> roleNameList, String promptContent, List<String> promptWordList, Map<String, String> sharkParam, HashMap<String, String> extra) {
        Intrinsics.checkNotNullParameter(seriesID, "seriesID");
        Intrinsics.checkNotNullParameter(roleNameList, "roleNameList");
        Intrinsics.checkNotNullParameter(promptContent, "promptContent");
        Intrinsics.checkNotNullParameter(promptWordList, "promptWordList");
        Intrinsics.checkNotNullParameter(sharkParam, "sharkParam");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.a = seriesID;
        this.b = roleNameList;
        this.c = promptContent;
        this.d = promptWordList;
        this.e = sharkParam;
        this.f = extra;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.String r5, java.util.List r6, java.lang.String r7, java.util.List r8, java.util.Map r9, java.util.HashMap r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            java.lang.String r0 = ""
            if (r12 == 0) goto L8
            r12 = r0
            goto L9
        L8:
            r12 = r5
        L9:
            r5 = r11 & 2
            if (r5 == 0) goto L11
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L11:
            r1 = r6
            r5 = r11 & 4
            if (r5 == 0) goto L17
            goto L18
        L17:
            r0 = r7
        L18:
            r5 = r11 & 8
            if (r5 == 0) goto L20
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L20:
            r2 = r8
            r5 = r11 & 16
            if (r5 == 0) goto L29
            java.util.Map r9 = kotlin.collections.MapsKt.emptyMap()
        L29:
            r3 = r9
            r5 = r11 & 32
            if (r5 == 0) goto L33
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
        L33:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r0
            r9 = r2
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.aicontent.a.<init>(java.lang.String, java.util.List, java.lang.String, java.util.List, java.util.Map, java.util.HashMap, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
