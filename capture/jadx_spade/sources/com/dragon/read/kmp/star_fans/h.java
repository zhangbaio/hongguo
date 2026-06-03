package com.dragon.read.kmp.star_fans;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public final String a;
    public final String b;

    static {
        Covode.recordClassIndex(609156);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && Intrinsics.areEqual(this.b, hVar.b);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "StarFansTaskDoneFailedEvent(actorUid=" + this.a + ", errTips=" + this.b + ')';
    }

    public h(String actorUid, String str) {
        Intrinsics.checkNotNullParameter(actorUid, "actorUid");
        this.a = actorUid;
        this.b = str;
    }
}
