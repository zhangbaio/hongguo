package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    static {
        Covode.recordClassIndex(611271);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.a == vVar.a && Intrinsics.areEqual(this.b, vVar.b) && Intrinsics.areEqual(this.c, vVar.c) && Intrinsics.areEqual(this.d, vVar.d) && Intrinsics.areEqual(this.e, vVar.e);
    }

    public int hashCode() {
        return (((((((androidx.compose.animation.m.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "SidebarUserInfoParams(isLogin=" + this.a + ", nameContent=" + this.b + ", avatarUrl=" + this.c + ", avatarDecorationUrl=" + this.d + ", moduleName=" + this.e + ')';
    }

    public v(boolean z, String nameContent, String avatarUrl, String avatarDecorationUrl, String moduleName) {
        Intrinsics.checkNotNullParameter(nameContent, "nameContent");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(avatarDecorationUrl, "avatarDecorationUrl");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.a = z;
        this.b = nameContent;
        this.c = avatarUrl;
        this.d = avatarDecorationUrl;
        this.e = moduleName;
    }
}
