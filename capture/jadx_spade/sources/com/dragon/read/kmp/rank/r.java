package com.dragon.read.kmp.rank;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.ClickItemJumpType;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.bn0;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.d6;
import com.bytedance.kmp.reading.model.e50;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.f0;
import com.bytedance.kmp.reading.model.jm0;
import com.bytedance.kmp.reading.model.jn0;
import com.bytedance.kmp.reading.model.km0;
import com.bytedance.kmp.reading.model.n2;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.q20;
import com.bytedance.kmp.reading.model.qn0;
import com.bytedance.kmp.reading.model.r50;
import com.bytedance.kmp.reading.model.rm0;
import com.bytedance.kmp.reading.model.vd0;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.xm0;
import com.bytedance.kmp.reading.model.zm0;
import com.dragon.read.component.biz.impl.bookmall.l5;
import com.dragon.read.component.biz.impl.bookmall.r4;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.utils.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r extends ViewModel {
    public static final a e;
    public static final int f;
    public fe4.n a = new fe4.n("", "", "", 6, (int) (b1.a.q() * 0.4871795f), CollectionsKt__CollectionsKt.emptyList());
    private re4.e b;
    private Function0<ym4.a> c;
    private Function0<Unit> d;

    public static final class a {
        static {
            Covode.recordClassIndex(608231);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608230);
        e = new a(null);
        f = 8;
    }

    public final void Q0() {
        Function0<Unit> function0 = this.d;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final ym4.a H0() {
        Function0<ym4.a> function0 = this.c;
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }

    public final String L0() {
        String j;
        re4.e eVar = this.b;
        if (eVar == null || (j = eVar.j()) == null) {
            return "";
        }
        return j;
    }

    protected void onCleared() {
        super.onCleared();
        this.c = null;
        this.d = null;
    }

    private final boolean T0() {
        x7 x7Var;
        re4.e eVar = this.b;
        if (eVar == null || (x7Var = ((yh4.b) eVar).d) == null) {
            return false;
        }
        Integer num = x7Var.R2;
        int value = ClickItemJumpType.VideoRanklist.getValue();
        if (num == null || num.intValue() != value) {
            return false;
        }
        return true;
    }

    private final ym4.a G0() {
        String str;
        x7 x7Var;
        x7 x7Var2;
        ym4.a n = k0.a.b().n();
        ym4.a H0 = H0();
        if (H0 == null) {
            H0 = new ym4.a();
        }
        n.j(H0);
        n.g("unlimited_content_ranking_list_type", this.a.a);
        re4.e eVar = this.b;
        String str2 = null;
        if (eVar != null && (x7Var2 = ((yh4.b) eVar).d) != null) {
            str = x7Var2.g;
        } else {
            str = null;
        }
        n.g("unlimited_content_ranking_list_sub_type", J0(str));
        re4.e eVar2 = this.b;
        if (eVar2 != null && (x7Var = ((yh4.b) eVar2).d) != null) {
            str2 = x7Var.g;
        }
        n.g("unlimited_content_ranking_parent_list_type", K0(str2));
        return n;
    }

    public final void P0() {
        String str;
        boolean z;
        x7 x7Var;
        re4.e eVar = this.b;
        if (eVar != null && (x7Var = ((yh4.b) eVar).d) != null) {
            str = x7Var.g;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "KmpRank2ColViewModel", "schema is empty " + str, (Throwable) null, 4, (Object) null);
        }
        ym4.k b = k0.a.b();
        b.d("ranking_list_page_entrance", "unlimited_content");
        b.d("parent_tag_name", this.a.a);
        b.g(G0());
        zm4.d dVar = zm4.d.a;
        if (str == null) {
            str = "";
        }
        zm4.d.d(dVar, str, null, b, 2, null);
        U0(true, "landing_page");
    }

    public final void Y0(Function0<ym4.a> argsGetter) {
        Intrinsics.checkNotNullParameter(argsGetter, "argsGetter");
        this.c = argsGetter;
    }

    public final void Z0(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.d = callback;
    }

    public final void S0(fe4.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        W0(item, false);
    }

    private final org.jetbrains.compose.resources.b I0(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return r4.d(l5.a);
                }
                return r4.c(l5.a);
            }
            return r4.b(l5.a);
        }
        return r4.a(l5.a);
    }

    private final String J0(String str) {
        boolean z;
        boolean contains$default;
        com.dragon.read.kmp.base.l a2;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "sub_selected_items", false, 2, (Object) null);
        if (!contains$default || (a2 = com.dragon.read.kmp.base.m.a(str)) == null) {
            return null;
        }
        return a2.d("sub_selected_items");
    }

    private final String K0(String str) {
        boolean z;
        boolean contains$default;
        com.dragon.read.kmp.base.l a2;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "parent_list_type", false, 2, (Object) null);
        if (!contains$default || (a2 = com.dragon.read.kmp.base.m.a(str)) == null) {
            return null;
        }
        return a2.d("parent_list_type");
    }

    private final om0 M0(fe4.a aVar) {
        List list;
        re4.e eVar = this.b;
        Object obj = null;
        if (eVar == null || (list = eVar.g) == null) {
            return null;
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.areEqual(((om0) next).p, aVar.a)) {
                obj = next;
                break;
            }
        }
        return (om0) obj;
    }

    private final int O0(String str) {
        List list;
        re4.e eVar = this.b;
        int i = -1;
        if (eVar != null && (list = eVar.g) != null) {
            Iterator it2 = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(((om0) it2.next()).p, str)) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        return i + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (r0 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String F0(re4.e r3) {
        /*
            r2 = this;
            com.bytedance.kmp.reading.model.x7 r3 = r3.d
            if (r3 == 0) goto L44
            java.lang.String r3 = r3.g
            if (r3 == 0) goto L44
            com.dragon.read.kmp.base.l r3 = com.dragon.read.kmp.base.m.a(r3)
            if (r3 != 0) goto Lf
            goto L44
        Lf:
            java.lang.String r0 = "img_name"
            java.lang.String r0 = r2.X0(r3, r0)
            if (r0 == 0) goto L25
            boolean r1 = kotlin.text.StringsKt.isBlank(r0)
            if (r1 == 0) goto L23
            java.lang.String r0 = "selected_items"
            java.lang.String r0 = r2.X0(r3, r0)
        L23:
            if (r0 != 0) goto L27
        L25:
            java.lang.String r0 = "double_col"
        L27:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "img_693_staggered_rank_card_bg_"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = ".png"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            ed4.a r0 = ed4.a.a
            java.lang.String r3 = r0.a(r3)
            return r3
        L44:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.rank.r.F0(re4.e):java.lang.String");
    }

    private final ym4.a N0(om0 om0Var) {
        String str;
        String str2;
        e90 e90Var;
        ym4.a G0 = G0();
        G0.g("src_material_id", om0Var.p);
        G0.g("material_id", om0Var.a);
        G0.g("material_type", ld4.a.a.d(om0Var.y));
        G0.g("cover_url", om0Var.b);
        G0.g("src_material_show_name", om0Var.e);
        List list = om0Var.t0;
        boolean z = false;
        String str3 = "";
        if (list == null || (e90Var = (e90) CollectionsKt___CollectionsKt.getOrNull(list, 0)) == null || (str = e90Var.a) == null) {
            str = "";
        }
        G0.g("side_title", str);
        Boolean bool = om0Var.t;
        if (bool != null) {
            z = bool.booleanValue();
        }
        if (z) {
            str2 = "vertical";
        } else {
            str2 = "horizontal";
        }
        G0.g("direction", str2);
        G0.g("recommend_info", om0Var.z);
        G0.g("recommend_group_id", om0Var.A);
        String str4 = om0Var.p;
        if (str4 != null) {
            str3 = str4;
        }
        G0.g("rank", Integer.valueOf(O0(str3)));
        return G0;
    }

    public final void E0(re4.e data) {
        List list;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        e90 e90Var;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(data, "data");
        this.b = data;
        x7 x7Var = ((yh4.b) data).d;
        if (x7Var != null && (str8 = x7Var.c) != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) str8, new String[]{"·"}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        fe4.n nVar = this.a;
        if (list == null || (str = (String) CollectionsKt___CollectionsKt.getOrNull(list, 0)) == null) {
            str = "";
        }
        if (list == null || (str2 = (String) CollectionsKt___CollectionsKt.getOrNull(list, 1)) == null) {
            str2 = "";
        }
        String F0 = F0(data);
        int q = (int) (b1.a.q() * 0.4871795f);
        List list2 = data.g;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            om0 om0Var = (om0) obj;
            String str9 = om0Var.p;
            if (str9 == null) {
                str3 = "";
            } else {
                str3 = str9;
            }
            String str10 = om0Var.e;
            if (str10 == null) {
                str4 = "";
            } else {
                str4 = str10;
            }
            List list3 = om0Var.t0;
            if (list3 == null || (e90Var = (e90) CollectionsKt___CollectionsKt.getOrNull(list3, 0)) == null || (str7 = e90Var.a) == null) {
                str5 = "";
            } else {
                str5 = str7;
            }
            String str11 = om0Var.b;
            if (str11 == null) {
                str6 = "";
            } else {
                str6 = str11;
            }
            arrayList.add(new fe4.a(str3, str4, str5, str6, I0(i2), false, 32, (DefaultConstructorMarker) null));
            i = i2;
        }
        this.a = nVar.a(str, str2, F0, q, 8, arrayList);
    }

    private final String X0(com.dragon.read.kmp.base.l lVar, String str) {
        if (lVar == null) {
            return null;
        }
        try {
            return lVar.d(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void W0(fe4.a aVar, boolean z) {
        om0 M0 = M0(aVar);
        if (M0 == null) {
            return;
        }
        ld4.b a2 = new ld4.b().a(N0(M0));
        if (z) {
            a2.m();
        } else {
            a2.r();
        }
    }

    public final void U0(boolean z, String str) {
        String str2;
        ym4.a G0 = G0();
        if (str != null) {
            G0.g("click_to", str);
        }
        ym4.o oVar = ym4.o.a;
        if (z) {
            str2 = "click_unlimited_content";
        } else {
            str2 = "show_unlimited_content";
        }
        oVar.d(str2, G0);
    }

    public final void R0(fe4.a item, Context context) {
        String str;
        boolean z;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(item, "item");
        if (T0()) {
            P0();
            return;
        }
        ym4.k b = k0.a.b();
        b.g(G0());
        b.d("side_title", item.c);
        b.d("src_material_show_name", item.b);
        b.d("cover_url", item.d);
        om0 M0 = M0(item);
        String str4 = "";
        if (M0 == null || (str = M0.z) == null) {
            str = "";
        }
        b.d("recommend_info", str);
        om0 M02 = M0(item);
        if (M02 != null && (str3 = M02.A) != null) {
            str4 = str3;
        }
        b.d("recommend_group_id", str4);
        b.c("rank", Integer.valueOf(O0(item.a)));
        om0 M03 = M0(item);
        if (M03 == null) {
            M03 = new om0((String) null, (String) null, (Long) null, (d1) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (f0) null, (String) null, (String) null, (Long) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (String) null, (String) null, (Boolean) null, (Long) null, (Boolean) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, (Long) null, (Boolean) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (Integer) null, (Long) null, (Boolean) null, (String) null, (Long) null, (String) null, (rm0) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (xm0) null, (String) null, (Integer) null, (List) null, (List) null, (bn0) null, (String) null, (Long) null, (String) null, (qn0) null, (String) null, (Long) null, (List) null, (List) null, (Boolean) null, (List) null, (List) null, (Integer) null, (qn0) null, (d6) null, (Boolean) null, (String) null, (String) null, (String) null, (e50) null, (String) null, (Boolean) null, (Boolean) null, (jm0) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (zm0) null, (vd0) null, (String) null, (String) null, (List) null, (q20) null, (List) null, (Integer) null, (n2) null, (String) null, (List) null, (r50) null, (km0) null, (jn0) null, (Long) null, (String) null, (Long) null, (List) null, (String) null, (Boolean) null, (Boolean) null, -1, -1, -1, 33554431, (DefaultConstructorMarker) null);
        }
        tb4.l a2 = eo0.c.a.a(Reflection.getOrCreateKotlinClass(tb4.l.class));
        if (a2 != null) {
            a2.f4(M03, b, context);
        }
        Integer num = M03.y;
        int value = VideoContentType.MotionComic.getValue();
        if (num != null && num.intValue() == value) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str2 = "motion_comic";
        } else {
            str2 = "playlet";
        }
        U0(true, str2);
        W0(item, true);
    }

    public static /* synthetic */ void V0(r rVar, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        rVar.U0(z, str);
    }
}
