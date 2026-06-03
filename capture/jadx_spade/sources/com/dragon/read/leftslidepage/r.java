package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;

    static {
        Covode.recordClassIndex(611265);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.a, rVar.a) && Intrinsics.areEqual(this.b, rVar.b) && Intrinsics.areEqual(this.c, rVar.c) && Intrinsics.areEqual(this.d, rVar.d) && this.e == rVar.e && this.f == rVar.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + androidx.compose.animation.m.a(this.e)) * 31) + androidx.compose.animation.m.a(this.f);
    }

    public String toString() {
        return "SidebarGameItem(gameId=" + this.a + ", gameName=" + this.b + ", gameIconUrl=" + this.c + ", gameOpenUrl=" + this.d + ", isNewGame=" + this.e + ", isPlayedGame=" + this.f + ')';
    }

    public r(String gameId, String gameName, String gameIconUrl, String gameOpenUrl, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(gameIconUrl, "gameIconUrl");
        Intrinsics.checkNotNullParameter(gameOpenUrl, "gameOpenUrl");
        this.a = gameId;
        this.b = gameName;
        this.c = gameIconUrl;
        this.d = gameOpenUrl;
        this.e = z;
        this.f = z2;
    }
}
