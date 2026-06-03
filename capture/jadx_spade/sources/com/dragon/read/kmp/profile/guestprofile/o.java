package com.dragon.read.kmp.profile.guestprofile;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.f0;
import com.dragon.read.kmp.r;
import com.dragon.read.kmp.utils.k0;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final int e;
    public final GuestProfileViewModel a;
    public final boolean b;
    private long c;
    private String d;

    static {
        Covode.recordClassIndex(608103);
        e = 8;
    }

    public final void f() {
        k();
    }

    public final void g() {
        j();
    }

    private final String b() {
        return d().f;
    }

    private final com.dragon.read.kmp.profile.guestprofile.viewmodel.a d() {
        return this.a.a;
    }

    private final MutableStateFlow<f0> e() {
        return this.a.l;
    }

    public final void h() {
        if (!this.b) {
            k();
        }
    }

    public final void i() {
        if (!this.b) {
            j();
        }
    }

    private final String a() {
        String b = this.a.h.b();
        if (b == null) {
            return "";
        }
        return b;
    }

    private final String c() {
        String str = this.d;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        String b = this.a.h.b();
        if (b == null) {
            b = "user";
        }
        this.d = b;
        Intrinsics.checkNotNull(b);
        return b;
    }

    public final void k() {
        if (e().getValue().a != null) {
            r rVar = r.a;
            long j = this.c;
            ym4.k b = k0.a.b();
            b.d("enter_from", b());
            b.d("profile_type", a());
            Unit unit = Unit.INSTANCE;
            rVar.C(j, b);
            this.c = 0L;
        }
    }

    public final void j() {
        boolean z;
        if (e().getValue().a != null && this.c == 0) {
            this.c = Clock.System.INSTANCE.now().toEpochMilliseconds();
            ym4.k b = k0.a.b();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String r0 = this.a.r0();
            if (r0.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                linkedHashMap.put("profile_user_id", r0);
            }
            linkedHashMap.put("profile_type", c());
            linkedHashMap.put("enter_from", b());
            linkedHashMap.put("profile_type", a());
            b.f(linkedHashMap);
            zm4.d.a.g(linkedHashMap);
            r.a.j(b);
        }
    }

    public o(GuestProfileViewModel videoModel, boolean z) {
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        this.a = videoModel;
        this.b = z;
    }
}
