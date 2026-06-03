package com.dragon.read.leftslidepage;

import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public final MutableState<v> a;
    public final MutableState<j> b;
    public final MutableState<l> c;
    public final MutableState<i> d;
    public final MutableState<q> e;
    public final MutableState<w> f;
    public final MutableState<b> g;

    static {
        Covode.recordClassIndex(611266);
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
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "SidebarInfo(userInfo=" + this.a + ", msgData=" + this.b + ", recentWatchData=" + this.c + ", gameData=" + this.d + ", functionData=" + this.e + ", subscribeSection=" + this.f + ", followSection=" + this.g + ')';
    }

    public s(MutableState<v> userInfo, MutableState<j> msgData, MutableState<l> recentWatchData, MutableState<i> gameData, MutableState<q> functionData, MutableState<w> subscribeSection, MutableState<b> followSection) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        Intrinsics.checkNotNullParameter(recentWatchData, "recentWatchData");
        Intrinsics.checkNotNullParameter(gameData, "gameData");
        Intrinsics.checkNotNullParameter(functionData, "functionData");
        Intrinsics.checkNotNullParameter(subscribeSection, "subscribeSection");
        Intrinsics.checkNotNullParameter(followSection, "followSection");
        this.a = userInfo;
        this.b = msgData;
        this.c = recentWatchData;
        this.d = gameData;
        this.e = functionData;
        this.f = subscribeSection;
        this.g = followSection;
    }
}
