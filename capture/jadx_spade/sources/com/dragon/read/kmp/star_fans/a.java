package com.dragon.read.kmp.star_fans;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final String a;
    public final String b;

    static {
        Covode.recordClassIndex(609145);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CommunityStartTaskClaimedEvent(actorUid=" + this.a + ", taskType=" + this.b + ')';
    }

    public a(String actorUid, String taskType) {
        Intrinsics.checkNotNullParameter(actorUid, "actorUid");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        this.a = actorUid;
        this.b = taskType;
    }
}
