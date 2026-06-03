package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p0 {
    static {
        Covode.recordClassIndex(609562);
    }

    public static final void b(ym4.a aVar) {
        String str;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (com.dragon.read.kmp.service.c0.a.isLogin()) {
            str = "login";
        } else {
            str = "not_login";
        }
        aVar.g("login_status", str);
    }

    public static final void a(ym4.a aVar) {
        Boolean bool;
        boolean z;
        String str;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        com.dragon.read.kmp.service.q a = com.dragon.read.kmp.service.m0.a();
        Boolean bool2 = null;
        if (a != null) {
            bool = a.isFirstLaunch();
        } else {
            bool = null;
        }
        if (bool == null) {
            com.dragon.read.kmp.service.q a2 = com.dragon.read.kmp.service.m0.a();
            if (a2 != null) {
                bool2 = a2.isFirstColdStart();
            }
            if (bool2 == null) {
                return;
            }
        }
        com.dragon.read.kmp.service.q a3 = com.dragon.read.kmp.service.m0.a();
        boolean z2 = false;
        if (a3 != null) {
            z = Intrinsics.areEqual(a3.isFirstLaunch(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z) {
            com.dragon.read.kmp.service.q a4 = com.dragon.read.kmp.service.m0.a();
            if (a4 != null) {
                z2 = Intrinsics.areEqual(a4.isFirstColdStart(), Boolean.TRUE);
            }
            if (!z2) {
                str = "0";
                aVar.g("is_first_launch", str);
            }
        }
        str = "1";
        aVar.g("is_first_launch", str);
    }
}
