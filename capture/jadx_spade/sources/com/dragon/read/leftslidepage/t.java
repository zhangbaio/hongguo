package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public final String a;
    public final String b;
    public final String c;

    static {
        Covode.recordClassIndex(611267);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.areEqual(this.a, tVar.a) && Intrinsics.areEqual(this.b, tVar.b) && Intrinsics.areEqual(this.c, tVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SidebarMsgItem(title=" + this.a + ", iconUrl=" + this.b + ", subTitle=" + this.c + ')';
    }

    public t(String title, String iconUrl, String subTitle) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        this.a = title;
        this.b = iconUrl;
        this.c = subTitle;
    }
}
