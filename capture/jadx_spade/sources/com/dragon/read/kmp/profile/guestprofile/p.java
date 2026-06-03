package com.dragon.read.kmp.profile.guestprofile;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public final String a;
    public final long b;

    static {
        Covode.recordClassIndex(608104);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.areEqual(this.a, pVar.a) && this.b == pVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + j.a(this.b);
    }

    public String toString() {
        return "GuestProfileStarFansRewardResult(actorUid=" + this.a + ", sum=" + this.b + ')';
    }

    public p(String actorUid, long j) {
        Intrinsics.checkNotNullParameter(actorUid, "actorUid");
        this.a = actorUid;
        this.b = j;
    }
}
