package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.BookAlbumAlgoType;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.pg;
import com.bytedance.kmp.reading.model.t3;
import com.bytedance.kmp.reading.model.u3;
import com.bytedance.kmp.ugc.model.xy;
import com.dragon.read.kmp.base_database.api.bookapi.BookCreationStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n2 {
    public static final int q;
    public final t3 a;
    public final boolean b;
    public final boolean c;
    public final com.dragon.read.kmp.reader.detail.catalog.s d;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> e;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> f;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> g;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> h;
    public final com.dragon.read.kmp.community.bookcomment.t i;
    public final xy j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final String n;
    public final String o;
    public final boolean p;

    static {
        Covode.recordClassIndex(608367);
        q = 8;
    }

    public n2() {
        this(null, false, false, null, null, null, null, null, null, null, false, false, null, null, null, false, 65535, null);
    }

    private final String s(int i) {
        return i >= 100000000 ? "亿字" : i >= 10000 ? "万字" : "字";
    }

    public final n2 b(t3 t3Var, boolean z, boolean z2, com.dragon.read.kmp.reader.detail.catalog.s catalog, List<com.dragon.read.kmp.reader.detail.widget.a> adaptationItems, List<com.dragon.read.kmp.reader.detail.widget.a> sameAuthorItems, List<com.dragon.read.kmp.reader.detail.widget.a> samePressItems, List<com.dragon.read.kmp.reader.detail.widget.a> alsoReadItems, com.dragon.read.kmp.community.bookcomment.t tVar, xy xyVar, boolean z3, boolean z4, String str, String str2, String str3, boolean z5) {
        Intrinsics.checkNotNullParameter(catalog, "catalog");
        Intrinsics.checkNotNullParameter(adaptationItems, "adaptationItems");
        Intrinsics.checkNotNullParameter(sameAuthorItems, "sameAuthorItems");
        Intrinsics.checkNotNullParameter(samePressItems, "samePressItems");
        Intrinsics.checkNotNullParameter(alsoReadItems, "alsoReadItems");
        return new n2(t3Var, z, z2, catalog, adaptationItems, sameAuthorItems, samePressItems, alsoReadItems, tVar, xyVar, z3, z4, str, str2, str3, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n2)) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return Intrinsics.areEqual(this.a, n2Var.a) && this.b == n2Var.b && this.c == n2Var.c && Intrinsics.areEqual(this.d, n2Var.d) && Intrinsics.areEqual(this.e, n2Var.e) && Intrinsics.areEqual(this.f, n2Var.f) && Intrinsics.areEqual(this.g, n2Var.g) && Intrinsics.areEqual(this.h, n2Var.h) && Intrinsics.areEqual(this.i, n2Var.i) && Intrinsics.areEqual(this.j, n2Var.j) && this.k == n2Var.k && this.l == n2Var.l && Intrinsics.areEqual(this.m, n2Var.m) && Intrinsics.areEqual(this.n, n2Var.n) && Intrinsics.areEqual(this.o, n2Var.o) && this.p == n2Var.p;
    }

    public int hashCode() {
        t3 t3Var = this.a;
        int hashCode = (((((((((((((((t3Var == null ? 0 : t3Var.hashCode()) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + androidx.compose.animation.m.a(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        com.dragon.read.kmp.community.bookcomment.t tVar = this.i;
        int hashCode2 = (hashCode + (tVar == null ? 0 : tVar.hashCode())) * 31;
        xy xyVar = this.j;
        int hashCode3 = (((((hashCode2 + (xyVar == null ? 0 : xyVar.hashCode())) * 31) + androidx.compose.animation.m.a(this.k)) * 31) + androidx.compose.animation.m.a(this.l)) * 31;
        String str = this.m;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.n;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.o;
        return ((hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + androidx.compose.animation.m.a(this.p);
    }

    public String toString() {
        return "BookDetailUiState(bookInfo=" + this.a + ", inBookshelf=" + this.b + ", introExpanded=" + this.c + ", catalog=" + this.d + ", adaptationItems=" + this.e + ", sameAuthorItems=" + this.f + ", samePressItems=" + this.g + ", alsoReadItems=" + this.h + ", hotComments=" + this.i + ", forumData=" + this.j + ", showListen=" + this.k + ", listenEnabled=" + this.l + ", listenDisabledMessage=" + this.m + ", sameAuthorMoreUrl=" + this.n + ", samePressMoreUrl=" + this.o + ", isAlsoReadRefreshing=" + this.p + ')';
    }

    public final s2 m() {
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        if (this.a == null || com.dragon.read.kmp.reader.detail.platform.d.a.a()) {
            return null;
        }
        pg pgVar = this.a.u1;
        if (pgVar != null) {
            e90 e90Var = pgVar.a;
            if (e90Var != null) {
                str = e90Var.a;
            } else {
                str = null;
            }
            if (str != null && !StringsKt__StringsKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                e90 e90Var2 = pgVar.a;
                if (e90Var2 != null) {
                    str2 = e90Var2.a;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                e90 e90Var3 = pgVar.b;
                if (e90Var3 != null) {
                    str4 = e90Var3.a;
                } else {
                    str4 = null;
                }
                if (str4 == null) {
                    str5 = "";
                } else {
                    str5 = str4;
                }
                if (e90Var3 != null) {
                    str6 = e90Var3.f;
                }
                return new s2(str3, str5, str6, true, "", "");
            }
        }
        if (!oc4.a.a.q(this.a.s)) {
            return null;
        }
        a i = i(this.a.x1, true);
        return new s2("", "累计阅读", null, false, i.a, i.c);
    }

    public final String p() {
        Boolean bool;
        Integer num;
        boolean z;
        oc4.a aVar = oc4.a.a;
        t3 t3Var = this.a;
        String str = null;
        if (t3Var != null) {
            bool = t3Var.C0;
        } else {
            bool = null;
        }
        if (t3Var != null) {
            num = t3Var.T0;
        } else {
            num = null;
        }
        if (aVar.p(bool, num)) {
            xf4.a aVar2 = xf4.a.l3;
            t3 t3Var2 = this.a;
            if (t3Var2 != null) {
                str = t3Var2.e;
            }
            if (aVar2.isBuyPaidBook(str)) {
                return "立即阅读";
            }
            return "付费阅读";
        }
        xf4.a aVar3 = xf4.a.l3;
        t3 t3Var3 = this.a;
        if (t3Var3 != null) {
            str = t3Var3.e;
        }
        if (aVar3.isBuyPaidBook(str)) {
            return "立即阅读";
        }
        if (aVar3.isVip()) {
            return "免费阅读";
        }
        t3 t3Var4 = this.a;
        if (t3Var4 != null) {
            z = Intrinsics.areEqual(t3Var4.C0, Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z) {
            return "免费阅读";
        }
        return "会员畅读";
    }

    public final String r() {
        String str;
        t3 t3Var = this.a;
        if (t3Var == null) {
            return "";
        }
        oc4.a aVar = oc4.a.a;
        String str2 = t3Var.k;
        int i = 1;
        if (str2 != null) {
            i = com.dragon.read.kmp.utils.h0.i(str2, 1);
        }
        boolean j = aVar.j(i);
        String str3 = this.a.X;
        int i2 = 0;
        if (str3 != null) {
            i2 = com.dragon.read.kmp.utils.h0.i(str3, 0);
        }
        boolean m = aVar.m(this.a.s);
        StringBuilder sb = new StringBuilder();
        if (!m) {
            if (j) {
                str = "完结";
            } else {
                str = "连载中";
            }
            sb.append(str);
            sb.append("∙");
        }
        if (i2 > 0) {
            sb.append(t(i2));
            sb.append(s(i2));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String j() {
        t3 t3Var = this.a;
        if (t3Var == null) {
            return "";
        }
        int i = com.dragon.read.kmp.utils.h0.i(String.valueOf(t3Var.H), 0);
        boolean c = BookCreationStatus.a.c(com.dragon.read.kmp.utils.h0.i(String.valueOf(t3Var.k), 1));
        int i2 = com.dragon.read.kmp.utils.h0.i(String.valueOf(t3Var.i0), 0);
        long k = com.dragon.read.kmp.utils.h0.k(String.valueOf(t3Var.h0), 0L);
        ArrayList arrayList = new ArrayList(2);
        if (!c) {
            StringBuilder sb = new StringBuilder();
            sb.append((char) 20849);
            sb.append(i);
            sb.append((char) 31456);
            arrayList.add(sb.toString());
            arrayList.add("已完结");
            return StringsKt__StringsKt.trim((CharSequence) CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null)).toString();
        }
        arrayList.add("连载至" + i + (char) 31456);
        if (i2 >= 3) {
            arrayList.add("连续更新" + i2 + (char) 22825);
        } else {
            String obj = StringsKt__StringsKt.trim((CharSequence) v(k)).toString();
            if (!StringsKt__StringsKt.isBlank(obj)) {
                arrayList.add(obj);
            }
        }
        return StringsKt__StringsKt.trim((CharSequence) CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null)).toString();
    }

    public final u2 o() {
        int i;
        String str;
        String str2;
        String str3 = null;
        if (com.dragon.read.kmp.reader.detail.platform.d.a.a()) {
            return null;
        }
        BookCreationStatus bookCreationStatus = BookCreationStatus.a;
        t3 t3Var = this.a;
        if (t3Var != null && (str2 = t3Var.k) != null) {
            i = com.dragon.read.kmp.utils.h0.i(str2, 1);
        } else {
            i = 1;
        }
        boolean c = bookCreationStatus.c(i);
        t3 t3Var2 = this.a;
        if (t3Var2 != null) {
            str = t3Var2.B;
        } else {
            str = null;
        }
        a i2 = i(str, true);
        t3 t3Var3 = this.a;
        if (t3Var3 != null) {
            str3 = t3Var3.t1;
        }
        a i3 = i(str3, false);
        if (c && i3.b != 0) {
            String str4 = i2.c;
            String str5 = "在读";
            if (!StringsKt__StringsKt.isBlank(str4)) {
                str5 = str4 + "在读";
            }
            return new u2(i2.a, str5, i3.a + i3.c + "人追更过", false);
        }
        if (i2.b < 1000 && Intrinsics.areEqual(i2.c, "")) {
            return new u2("潜力好书", "", "在读人数不足", true);
        }
        return new u2(i2.a, i2.c, "正在阅读", false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x007a, code lost:
    
        if (kotlin.Result.m779isFailureimpl(r1) != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.dragon.read.kmp.reader.detail.c> a() {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.n2.a():java.util.List");
    }

    public final String q(String str) {
        String str2 = null;
        if (str != null) {
            if (!(!StringsKt__StringsKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        t3 t3Var = this.a;
        if (t3Var != null) {
            str2 = t3Var.M;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    private final c e(t3 t3Var) {
        boolean z;
        if (Intrinsics.areEqual(t3Var.k0, "1")) {
            yf4.a aVar = yf4.a.t3;
            if (aVar != null && !aVar.isOriginalEnabled()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return new c("番茄原创", zm4.c.a.f(), false, IntroTagType.CATEGORY);
            }
        }
        return null;
    }

    private final c f(t3 t3Var) {
        if (!oc4.a.a.l(t3Var.t0) || !Intrinsics.areEqual("1", t3Var.Y0)) {
            return null;
        }
        return new c("出版体验卡可读", null, false, IntroTagType.PUBLISH_CARD);
    }

    private final String t(int i) {
        if (i >= 100000000) {
            return h(i / 1.0E8d, true);
        }
        if (i >= 10000) {
            return h(i / 10000.0d, true);
        }
        return String.valueOf(i);
    }

    private final String u(String str) {
        if (str == null) {
            return "";
        }
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "月", 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            indexOf$default = 0;
        }
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, "·", 0, false, 6, (Object) null);
        if (indexOf$default2 < 0) {
            indexOf$default2 = str.length();
        }
        try {
            String substring = str.substring(indexOf$default + 1, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        } catch (Throwable unused) {
            return str;
        }
    }

    public final String k(String str) {
        String str2;
        String str3 = null;
        if (str != null) {
            if (!(!StringsKt__StringsKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        t3 t3Var = this.a;
        if (t3Var == null || (str2 = t3Var.q1) == null || !(!StringsKt__StringsKt.isBlank(str2))) {
            str2 = null;
        }
        if (str2 == null) {
            t3 t3Var2 = this.a;
            if (t3Var2 != null) {
                str3 = t3Var2.M;
            }
            if (str3 == null) {
                return "";
            }
            return str3;
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.dragon.read.kmp.reader.detail.c g(com.bytedance.kmp.reading.model.t3 r8) {
        /*
            r7 = this;
            java.util.List r8 = r8.p0
            r0 = 0
            if (r8 == 0) goto L73
            java.lang.Object r8 = kotlin.collections.CollectionsKt.firstOrNull(r8)
            com.bytedance.kmp.reading.model.r4 r8 = (com.bytedance.kmp.reading.model.r4) r8
            if (r8 != 0) goto Lf
            goto L73
        Lf:
            java.lang.String r1 = r8.a
            java.lang.String r2 = r8.b
            java.lang.Integer r8 = r8.getType()
            com.bytedance.kmp.reading.model.BookRankInfoType r3 = com.bytedance.kmp.reading.model.BookRankInfoType.BookPraiseRank
            int r3 = r3.getValue()
            r4 = 1
            r5 = 0
            if (r8 != 0) goto L22
            goto L28
        L22:
            int r6 = r8.intValue()
            if (r6 == r3) goto L3a
        L28:
            com.bytedance.kmp.reading.model.BookRankInfoType r3 = com.bytedance.kmp.reading.model.BookRankInfoType.BookPeakRank
            int r3 = r3.getValue()
            if (r8 != 0) goto L31
            goto L38
        L31:
            int r8 = r8.intValue()
            if (r8 != r3) goto L38
            goto L3a
        L38:
            r8 = 0
            goto L3b
        L3a:
            r8 = 1
        L3b:
            if (r8 == 0) goto L52
            if (r1 == 0) goto L47
            boolean r8 = kotlin.text.StringsKt.isBlank(r1)
            if (r8 == 0) goto L46
            goto L47
        L46:
            r4 = 0
        L47:
            if (r4 == 0) goto L4a
            goto L73
        L4a:
            com.dragon.read.kmp.reader.detail.c r0 = new com.dragon.read.kmp.reader.detail.c
            com.dragon.read.kmp.reader.detail.IntroTagType r8 = com.dragon.read.kmp.reader.detail.IntroTagType.RANK
            r0.<init>(r1, r2, r5, r8)
            goto L73
        L52:
            if (r1 == 0) goto L5d
            boolean r8 = kotlin.text.StringsKt.isBlank(r1)
            if (r8 == 0) goto L5b
            goto L5d
        L5b:
            r8 = 0
            goto L5e
        L5d:
            r8 = 1
        L5e:
            if (r8 != 0) goto L73
            if (r2 == 0) goto L6a
            boolean r8 = kotlin.text.StringsKt.isBlank(r2)
            if (r8 == 0) goto L69
            goto L6a
        L69:
            r4 = 0
        L6a:
            if (r4 != 0) goto L73
            com.dragon.read.kmp.reader.detail.c r0 = new com.dragon.read.kmp.reader.detail.c
            com.dragon.read.kmp.reader.detail.IntroTagType r8 = com.dragon.read.kmp.reader.detail.IntroTagType.RANK
            r0.<init>(r1, r2, r5, r8)
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.n2.g(com.bytedance.kmp.reading.model.t3):com.dragon.read.kmp.reader.detail.c");
    }

    public final String l(String str) {
        String str2;
        t3 t3Var = this.a;
        String str3 = null;
        if (t3Var != null) {
            str2 = t3Var.f;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str == null || !(!StringsKt__StringsKt.isBlank(str))) {
            str = null;
        }
        if (str != null) {
            if (!Intrinsics.areEqual(str, str2) && !StringsKt__StringsKt.isBlank(str2)) {
                return str + '(' + str2 + ')';
            }
            return str;
        }
        t3 t3Var2 = this.a;
        if (t3Var2 != null) {
            str3 = t3Var2.N0;
        }
        String b = oc4.b.b(str2, str3);
        if (b == null) {
            return "";
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.dragon.read.kmp.reader.detail.t2 n(java.lang.String r15) {
        /*
            r14 = this;
            com.bytedance.kmp.reading.model.t3 r0 = r14.a
            r1 = 0
            if (r0 == 0) goto L8
            java.lang.String r0 = r0.a0
            goto L9
        L8:
            r0 = r1
        L9:
            java.lang.String r2 = ""
            if (r0 != 0) goto Le
            r0 = r2
        Le:
            boolean r3 = kotlin.text.StringsKt.isBlank(r0)
            r3 = r3 ^ 1
            if (r3 == 0) goto L18
            r5 = r0
            goto L19
        L18:
            r5 = r1
        L19:
            if (r5 == 0) goto L5d
            com.dragon.read.kmp.reader.detail.t2 r0 = new com.dragon.read.kmp.reader.detail.t2
            com.bytedance.kmp.reading.model.t3 r3 = r14.a
            if (r3 == 0) goto L24
            java.lang.String r4 = r3.e
            goto L25
        L24:
            r4 = r1
        L25:
            if (r4 != 0) goto L29
            r6 = r2
            goto L2a
        L29:
            r6 = r4
        L2a:
            if (r15 != 0) goto L33
            if (r3 == 0) goto L31
            java.lang.String r15 = r3.f
            goto L33
        L31:
            r7 = r1
            goto L34
        L33:
            r7 = r15
        L34:
            oc4.a r15 = oc4.a.a
            if (r3 == 0) goto L3b
            java.lang.String r2 = r3.s
            goto L3c
        L3b:
            r2 = r1
        L3c:
            boolean r8 = r15.m(r2)
            r9 = 0
            com.dragon.read.kmp.community.bookcomment.t r15 = r14.i
            if (r15 == 0) goto L4d
            int r15 = r15.c
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r10 = r15
            goto L4e
        L4d:
            r10 = r1
        L4e:
            com.dragon.read.kmp.community.bookcomment.t r15 = r14.i
            if (r15 == 0) goto L54
            java.lang.String r1 = r15.d
        L54:
            r11 = r1
            r12 = 16
            r13 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r1 = r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.n2.n(java.lang.String):com.dragon.read.kmp.reader.detail.t2");
    }

    private final String v(long j) {
        String str;
        long epochMilliseconds = (Clock.System.INSTANCE.now().toEpochMilliseconds() / 1000) - j;
        if (epochMilliseconds < 60) {
            return "1分钟前更新";
        }
        if (epochMilliseconds <= 3600) {
            return (epochMilliseconds / 60) + "分钟前更新";
        }
        if (epochMilliseconds <= 86400) {
            return (epochMilliseconds / 3600) + "小时前更新";
        }
        if (epochMilliseconds <= 2592000) {
            return (epochMilliseconds / 86400) + "天前更新";
        }
        if (epochMilliseconds <= 31536000) {
            long j2 = j * 1000;
            if (com.dragon.read.kmp.util.m.a.b(j2)) {
                str = "MM-dd";
            } else {
                str = "yyyy-MM-dd";
            }
            return com.dragon.read.kmp.utils.o.a.d(j2, str) + "更新";
        }
        return "";
    }

    private final List<c> d(t3 t3Var) {
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        List<u3> list = t3Var.n1;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        Iterator it2 = list.iterator();
        while (true) {
            str = null;
            if (it2.hasNext()) {
                obj = it2.next();
                Integer num = ((u3) obj).a;
                int value = BookAlbumAlgoType.RankListFengYun.getValue();
                if (num != null && num.intValue() == value) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        u3 u3Var = (u3) obj;
        Iterator it4 = list.iterator();
        while (true) {
            if (it4.hasNext()) {
                obj2 = it4.next();
                Integer num2 = ((u3) obj2).a;
                int value2 = BookAlbumAlgoType.PublishRankListRaise.getValue();
                if (num2 != null && num2.intValue() == value2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        u3 u3Var2 = (u3) obj2;
        Iterator it5 = list.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj3 = it5.next();
                Integer num3 = ((u3) obj3).a;
                int value3 = BookAlbumAlgoType.PublishRankListTop.getValue();
                if (num3 != null && num3.intValue() == value3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        u3 u3Var3 = (u3) obj3;
        if (u3Var == null) {
            if (u3Var2 == null) {
                u3Var = u3Var3;
            } else {
                u3Var = u3Var2;
            }
        }
        if (u3Var != null) {
            str = u3Var.c;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            String u = u(u3Var.c);
            if (!StringsKt__StringsKt.isBlank(u)) {
                arrayList.add(new c(u, u3Var.d, false, IntroTagType.RANK));
            }
        }
        for (u3 u3Var4 : list) {
            Integer num4 = u3Var4.a;
            int value4 = BookAlbumAlgoType.RankListFengYun.getValue();
            if (num4 == null || num4.intValue() != value4) {
                int value5 = BookAlbumAlgoType.PublishRankListRaise.getValue();
                if (num4 == null || num4.intValue() != value5) {
                    int value6 = BookAlbumAlgoType.PublishRankListTop.getValue();
                    if (num4 == null || num4.intValue() != value6) {
                        String u2 = u(u3Var4.c);
                        if (!StringsKt__StringsKt.isBlank(u2)) {
                            arrayList.add(new c(u2, u3Var4.d, false, IntroTagType.RANK));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final String h(double d, boolean z) {
        long j = (long) (d * 10.0d);
        if (z) {
            long j2 = j % 10;
            if (j2 != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(j / 10);
                sb.append('.');
                sb.append(j2);
                return sb.toString();
            }
        }
        return String.valueOf(j / 10);
    }

    private final a i(String str, boolean z) {
        long j;
        if (str != null) {
            j = com.dragon.read.kmp.utils.h0.l(str, 0L, 1, null);
        } else {
            j = 0;
        }
        if (j <= 0) {
            return new a("0", 0L, "");
        }
        if (j >= 100000000) {
            return new a(h(j / 1.0E8d, z), j, "亿");
        }
        if (j >= 10000) {
            return new a(h(j / 10000.0d, z), j, "万");
        }
        return new a(String.valueOf(j), j, "");
    }

    private static final class a {
        public final String a;
        public final long b;
        public final String c;

        static {
            Covode.recordClassIndex(608368);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && Intrinsics.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + j.a(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "CountText(value=" + this.a + ", rawValue=" + this.b + ", unit=" + this.c + ')';
        }

        public a(String value, long j, String unit) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.a = value;
            this.b = j;
            this.c = unit;
        }
    }

    public n2(t3 t3Var, boolean z, boolean z2, com.dragon.read.kmp.reader.detail.catalog.s catalog, List<com.dragon.read.kmp.reader.detail.widget.a> adaptationItems, List<com.dragon.read.kmp.reader.detail.widget.a> sameAuthorItems, List<com.dragon.read.kmp.reader.detail.widget.a> samePressItems, List<com.dragon.read.kmp.reader.detail.widget.a> alsoReadItems, com.dragon.read.kmp.community.bookcomment.t tVar, xy xyVar, boolean z3, boolean z4, String str, String str2, String str3, boolean z5) {
        Intrinsics.checkNotNullParameter(catalog, "catalog");
        Intrinsics.checkNotNullParameter(adaptationItems, "adaptationItems");
        Intrinsics.checkNotNullParameter(sameAuthorItems, "sameAuthorItems");
        Intrinsics.checkNotNullParameter(samePressItems, "samePressItems");
        Intrinsics.checkNotNullParameter(alsoReadItems, "alsoReadItems");
        this.a = t3Var;
        this.b = z;
        this.c = z2;
        this.d = catalog;
        this.e = adaptationItems;
        this.f = sameAuthorItems;
        this.g = samePressItems;
        this.h = alsoReadItems;
        this.i = tVar;
        this.j = xyVar;
        this.k = z3;
        this.l = z4;
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.p = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ n2(com.bytedance.kmp.reading.model.t3 r18, boolean r19, boolean r20, com.dragon.read.kmp.reader.detail.catalog.s r21, java.util.List r22, java.util.List r23, java.util.List r24, java.util.List r25, com.dragon.read.kmp.community.bookcomment.t r26, com.bytedance.kmp.ugc.model.xy r27, boolean r28, boolean r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, boolean r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.n2.<init>(com.bytedance.kmp.reading.model.t3, boolean, boolean, com.dragon.read.kmp.reader.detail.catalog.s, java.util.List, java.util.List, java.util.List, java.util.List, com.dragon.read.kmp.community.bookcomment.t, com.bytedance.kmp.ugc.model.xy, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
