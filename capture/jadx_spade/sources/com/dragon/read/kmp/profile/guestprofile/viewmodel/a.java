package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.bytedance.covode.number.Covode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements gk4.f {
    public static final int r;
    private final long a;
    public boolean c;
    public boolean d;
    public boolean e;
    public Integer j;
    public boolean k;
    public boolean l;
    public Integer m;
    public String n;
    public Pair<Integer, String> p;
    public String b = "";
    public String f = "";
    public int g = el4.b.a.b();
    public String h = "";
    public String i = "";
    public final ym4.a o = new ym4.a();
    public ym4.a q = new ym4.a();

    static {
        Covode.recordClassIndex(608180);
        r = 8;
    }

    @Override // gk4.f
    public long a() {
        return this.a;
    }

    public String toString() {
        return "GuestProfilePageParams(iOhosProfileDepend=" + ((Object) null) + ", userId='" + this.b + "', fromRightSlide=" + this.c + ", isSimpleType=" + this.d + ", isFromFeedTab=" + this.e + ", enterFrom='" + this.f + "', filterOptionHeaderType=" + this.g + ", justSawVid='" + this.h + "', justSawAlbumId='" + this.i + ", serverChannel=" + this.j + "')";
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.h = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public a(com.dragon.read.kmp.profile.params.b bVar, long j) {
        this.a = j;
    }
}
