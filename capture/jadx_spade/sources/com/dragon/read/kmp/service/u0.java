package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u0 implements u {
    public static final u0 a;

    static {
        Covode.recordClassIndex(608883);
        a = new u0();
    }

    private u0() {
    }

    @Override // com.dragon.read.kmp.service.u
    public String R(String name, String channel) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(channel, "channel");
        u uVar = (u) eo0.c.a.a(Reflection.getOrCreateKotlinClass(u.class));
        if (uVar != null) {
            return uVar.R(name, channel);
        }
        return null;
    }
}
