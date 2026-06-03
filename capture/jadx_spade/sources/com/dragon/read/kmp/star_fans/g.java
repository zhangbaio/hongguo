package com.dragon.read.kmp.star_fans;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int d;
    public final String a;
    public final String b;
    public final List<String> c;

    static {
        Covode.recordClassIndex(609155);
        d = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "StarFansTaskDoneEvent(actorUid=" + this.a + ", taskType=" + this.b + ", taskKeys=" + this.c + ')';
    }

    public g(String actorUid, String taskType, List<String> taskKeys) {
        Intrinsics.checkNotNullParameter(actorUid, "actorUid");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(taskKeys, "taskKeys");
        this.a = actorUid;
        this.b = taskType;
        this.c = taskKeys;
    }
}
