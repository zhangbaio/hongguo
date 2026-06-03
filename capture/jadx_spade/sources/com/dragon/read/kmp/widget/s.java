package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public static final int h;
    public final String a;
    public final Integer b;
    public final List<String> c;
    public final String d;
    public final List<String> e;
    public final String f;
    public final Integer g;

    static {
        Covode.recordClassIndex(609635);
        h = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Intrinsics.areEqual(this.a, sVar.a) && Intrinsics.areEqual(this.b, sVar.b) && Intrinsics.areEqual(this.c, sVar.c) && Intrinsics.areEqual(this.d, sVar.d) && Intrinsics.areEqual(this.e, sVar.e) && Intrinsics.areEqual(this.f, sVar.f) && Intrinsics.areEqual(this.g, sVar.g);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list = this.c;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.d;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list2 = this.e;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.f;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.g;
        return hashCode6 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "CommonCoverTagData(title=" + this.a + ", position=" + this.b + ", bgColor=" + this.c + ", textColor=" + this.d + ", darkBgColor=" + this.e + ", darkTextColor=" + this.f + ", bgColorOrientation=" + this.g + ')';
    }

    public s(String title, Integer num, List<String> list, String str, List<String> list2, String str2, Integer num2) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.a = title;
        this.b = num;
        this.c = list;
        this.d = str;
        this.e = list2;
        this.f = str2;
        this.g = num2;
    }
}
