package com.dragon.read.kmp.profile.guestprofile.view.subpage;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.c7;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class s implements jd4.b {
    public final c7 a;
    private boolean b;

    static {
        Covode.recordClassIndex(608179);
    }

    public boolean isShown() {
        return this.b;
    }

    public void setShown(boolean z) {
        this.b = z;
    }

    public s(c7 subTabType) {
        Intrinsics.checkNotNullParameter(subTabType, "subTabType");
        this.a = subTabType;
    }
}
