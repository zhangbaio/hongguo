package rl4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.list.k;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int z;
    public final int a;
    public final ProfileTab b;
    public String c;
    public ProfileTab d;
    public String e;
    public ProfileTab f;
    public String g;
    public int h;
    public String i;
    public FilterOptionHeaderType j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public com.dragon.read.kmp.profile.params.a p;
    public boolean q;
    public final Map<String, String> r;
    public boolean s;
    public String t;
    public String u;
    public boolean v;
    public k w;
    public String x;
    public String y;

    static {
        Covode.recordClassIndex(608153);
        z = 8;
    }

    public final c a(int i, ProfileTab profileTab, String tabName, ProfileTab profileTab2, String mainTabName, ProfileTab profileTab3, String subProfileName, int i2, String targetUserId, FilterOptionHeaderType filterOption, boolean z2, int i3, boolean z3, boolean z4, boolean z5, com.dragon.read.kmp.profile.params.a aVar, boolean z6, Map<String, String> extraMap, boolean z7, String justSawVid, String justSawAlbumId, boolean z8, k kVar, String actorName, String str) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(mainTabName, "mainTabName");
        Intrinsics.checkNotNullParameter(subProfileName, "subProfileName");
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(filterOption, "filterOption");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        Intrinsics.checkNotNullParameter(justSawVid, "justSawVid");
        Intrinsics.checkNotNullParameter(justSawAlbumId, "justSawAlbumId");
        Intrinsics.checkNotNullParameter(actorName, "actorName");
        return new c(i, profileTab, tabName, profileTab2, mainTabName, profileTab3, subProfileName, i2, targetUserId, filterOption, z2, i3, z3, z4, z5, aVar, z6, extraMap, z7, justSawVid, justSawAlbumId, z8, kVar, actorName, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b && Intrinsics.areEqual(this.c, cVar.c) && this.d == cVar.d && Intrinsics.areEqual(this.e, cVar.e) && this.f == cVar.f && Intrinsics.areEqual(this.g, cVar.g) && this.h == cVar.h && Intrinsics.areEqual(this.i, cVar.i) && this.j == cVar.j && this.k == cVar.k && this.l == cVar.l && this.m == cVar.m && this.n == cVar.n && this.o == cVar.o && Intrinsics.areEqual(this.p, cVar.p) && this.q == cVar.q && Intrinsics.areEqual(this.r, cVar.r) && this.s == cVar.s && Intrinsics.areEqual(this.t, cVar.t) && Intrinsics.areEqual(this.u, cVar.u) && this.v == cVar.v && Intrinsics.areEqual(this.w, cVar.w) && Intrinsics.areEqual(this.x, cVar.x) && Intrinsics.areEqual(this.y, cVar.y);
    }

    public int hashCode() {
        int i = this.a * 31;
        ProfileTab profileTab = this.b;
        int hashCode = (((i + (profileTab == null ? 0 : profileTab.hashCode())) * 31) + this.c.hashCode()) * 31;
        ProfileTab profileTab2 = this.d;
        int hashCode2 = (((hashCode + (profileTab2 == null ? 0 : profileTab2.hashCode())) * 31) + this.e.hashCode()) * 31;
        ProfileTab profileTab3 = this.f;
        int hashCode3 = (((((((((((((((((((hashCode2 + (profileTab3 == null ? 0 : profileTab3.hashCode())) * 31) + this.g.hashCode()) * 31) + this.h) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + m.a(this.k)) * 31) + this.l) * 31) + m.a(this.m)) * 31) + m.a(this.n)) * 31) + m.a(this.o)) * 31;
        com.dragon.read.kmp.profile.params.a aVar = this.p;
        int hashCode4 = (((((((((((((hashCode3 + (aVar == null ? 0 : aVar.hashCode())) * 31) + m.a(this.q)) * 31) + this.r.hashCode()) * 31) + m.a(this.s)) * 31) + this.t.hashCode()) * 31) + this.u.hashCode()) * 31) + m.a(this.v)) * 31;
        k kVar = this.w;
        int hashCode5 = (((hashCode4 + (kVar == null ? 0 : kVar.hashCode())) * 31) + this.x.hashCode()) * 31;
        String str = this.y;
        return hashCode5 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "GuestProfileTabParams(pageIndex=" + this.a + ", profileTab=" + this.b + ", targetUserId='" + this.i + "', tabName='" + this.c + "', filterOption=" + this.j + ", isPrivacyTab=" + this.k + ", totalVideoCount=" + this.l + ", isOneTabType=" + this.m + ", hasAlbum=" + this.n + ", justSawVid='" + this.t + "', isFanqieProfilePage=" + this.o + ", isBrandOrActor=" + this.q + ", extraMap=" + this.r + ", isSimpleType=" + this.s + ')';
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.x = str;
    }

    public final void d(FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "<set-?>");
        this.j = filterOptionHeaderType;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.u = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.t = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public c(int i, ProfileTab profileTab, String tabName, ProfileTab profileTab2, String mainTabName, ProfileTab profileTab3, String subProfileName, int i2, String targetUserId, FilterOptionHeaderType filterOption, boolean z2, int i3, boolean z3, boolean z4, boolean z5, com.dragon.read.kmp.profile.params.a aVar, boolean z6, Map<String, String> extraMap, boolean z7, String justSawVid, String justSawAlbumId, boolean z8, k kVar, String actorName, String str) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(mainTabName, "mainTabName");
        Intrinsics.checkNotNullParameter(subProfileName, "subProfileName");
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(filterOption, "filterOption");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        Intrinsics.checkNotNullParameter(justSawVid, "justSawVid");
        Intrinsics.checkNotNullParameter(justSawAlbumId, "justSawAlbumId");
        Intrinsics.checkNotNullParameter(actorName, "actorName");
        this.a = i;
        this.b = profileTab;
        this.c = tabName;
        this.d = profileTab2;
        this.e = mainTabName;
        this.f = profileTab3;
        this.g = subProfileName;
        this.h = i2;
        this.i = targetUserId;
        this.j = filterOption;
        this.k = z2;
        this.l = i3;
        this.m = z3;
        this.n = z4;
        this.o = z5;
        this.p = aVar;
        this.q = z6;
        this.r = extraMap;
        this.s = z7;
        this.t = justSawVid;
        this.u = justSawAlbumId;
        this.v = z8;
        this.w = kVar;
        this.x = actorName;
        this.y = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(int r30, com.dragon.read.rpc.kmp.community.model.ProfileTab r31, java.lang.String r32, com.dragon.read.rpc.kmp.community.model.ProfileTab r33, java.lang.String r34, com.dragon.read.rpc.kmp.community.model.ProfileTab r35, java.lang.String r36, int r37, java.lang.String r38, com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType r39, boolean r40, int r41, boolean r42, boolean r43, boolean r44, com.dragon.read.kmp.profile.params.a r45, boolean r46, java.util.Map r47, boolean r48, java.lang.String r49, java.lang.String r50, boolean r51, com.dragon.read.kmp.compose.common.list.k r52, java.lang.String r53, java.lang.String r54, int r55, kotlin.jvm.internal.DefaultConstructorMarker r56) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rl4.c.<init>(int, com.dragon.read.rpc.kmp.community.model.ProfileTab, java.lang.String, com.dragon.read.rpc.kmp.community.model.ProfileTab, java.lang.String, com.dragon.read.rpc.kmp.community.model.ProfileTab, java.lang.String, int, java.lang.String, com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType, boolean, int, boolean, boolean, boolean, com.dragon.read.kmp.profile.params.a, boolean, java.util.Map, boolean, java.lang.String, java.lang.String, boolean, com.dragon.read.kmp.compose.common.list.k, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
