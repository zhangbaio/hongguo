package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 {
    public final long a;
    public final long b;
    public final long c;
    public final Integer d;

    static {
        Covode.recordClassIndex(608193);
    }

    public final g0 a(long j, long j2, long j3, Integer num) {
        return new g0(j, j2, j3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.a == g0Var.a && this.b == g0Var.b && this.c == g0Var.c && Intrinsics.areEqual(this.d, g0Var.d);
    }

    public int hashCode() {
        int a = ((((j.a(this.a) * 31) + j.a(this.b)) * 31) + j.a(this.c)) * 31;
        Integer num = this.d;
        return a + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "UserRelationState(fansCount=" + this.a + ", followerCount=" + this.b + ", likesCount=" + this.c + ", relationType=" + this.d + ')';
    }

    public g0(long j, long j2, long j3, Integer num) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = num;
    }
}
