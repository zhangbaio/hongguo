package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.sp;
import com.bytedance.kmp.reading.model.tl0;
import com.bytedance.kmp.reading.model.tp;
import com.bytedance.kmp.reading.model.xk0;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    static {
        Covode.recordClassIndex(608187);
    }

    public static final boolean b(ProfileTab profileTab) {
        Intrinsics.checkNotNullParameter(profileTab, "<this>");
        if (profileTab != ProfileTab.CelebrityWorks && profileTab != ProfileTab.ProduceVideo && profileTab != ProfileTab.DirectorWorks && profileTab != ProfileTab.WriterWorks) {
            return false;
        }
        return true;
    }

    public static final boolean e(eo eoVar) {
        Intrinsics.checkNotNullParameter(eoVar, "<this>");
        if (StringUtilsKt.a(eoVar.h) && com.dragon.read.kmp.u.f()) {
            return true;
        }
        return false;
    }

    public static final boolean c(g0 g0Var) {
        Intrinsics.checkNotNullParameter(g0Var, "<this>");
        Integer num = g0Var.d;
        int value = UserRelationType.None.getValue();
        if (num == null || num.intValue() != value) {
            Integer num2 = g0Var.d;
            int value2 = UserRelationType.Followed.getValue();
            if (num2 == null || num2.intValue() != value2) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean d(com.bytedance.kmp.reading.model.cj0 r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L11
            com.bytedance.kmp.reading.model.ok0 r2 = r6.b
            if (r2 == 0) goto L11
            java.lang.Long r2 = r2.l
            if (r2 == 0) goto L11
            long r2 = r2.longValue()
            goto L12
        L11:
            r2 = r0
        L12:
            r4 = 0
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 <= 0) goto L35
            r0 = 1
            if (r6 == 0) goto L31
            com.bytedance.kmp.reading.model.tl0 r6 = r6.d
            if (r6 == 0) goto L31
            java.lang.Integer r6 = r6.j
            com.bytedance.kmp.reading.model.UgcActorType r1 = com.bytedance.kmp.reading.model.UgcActorType.Registered
            int r1 = r1.getValue()
            if (r6 != 0) goto L29
            goto L31
        L29:
            int r6 = r6.intValue()
            if (r6 != r1) goto L31
            r6 = 1
            goto L32
        L31:
            r6 = 0
        L32:
            if (r6 == 0) goto L35
            r4 = 1
        L35:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.d(com.bytedance.kmp.reading.model.cj0):boolean");
    }

    public static final jv5.d f(eo eoVar) {
        tl0 tl0Var;
        sp spVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(eoVar, "<this>");
        cj0 cj0Var = eoVar.a;
        if (cj0Var != null && (tl0Var = cj0Var.d) != null && (spVar = tl0Var.u) != null) {
            ArrayList arrayList = new ArrayList();
            List list = spVar.a;
            String str7 = "";
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size && i < 5; i++) {
                    tp tpVar = (tp) list.get(i);
                    String str8 = tpVar.a;
                    if (str8 == null) {
                        str = "";
                    } else {
                        str = str8;
                    }
                    String str9 = tpVar.b;
                    if (str9 == null) {
                        str2 = "";
                    } else {
                        str2 = str9;
                    }
                    String str10 = tpVar.i;
                    if (str10 == null) {
                        str3 = "";
                    } else {
                        str3 = str10;
                    }
                    String str11 = tpVar.k;
                    if (str11 == null) {
                        str4 = "";
                    } else {
                        str4 = str11;
                    }
                    String str12 = tpVar.h;
                    if (str12 == null) {
                        str5 = "";
                    } else {
                        str5 = str12;
                    }
                    if (e(eoVar)) {
                        str6 = "#FFFFFFFF";
                    } else {
                        str6 = null;
                    }
                    String str13 = str6;
                    String str14 = tpVar.m;
                    if (str14 == null) {
                        str14 = "";
                    }
                    arrayList.add(new jv5.b(str, str2, str3, str4, str5, str13, str14));
                }
                if (list.size() > 5) {
                    arrayList.add(new jv5.q("", "更多成就"));
                }
            }
            com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
            List list2 = spVar.a;
            if (list2 != null) {
                gn6.a c = com.dragon.read.kmp.base.h.c();
                c.getSerializersModule();
                str7 = c.a(new kotlinx.serialization.internal.f(tp.Companion.serializer()), list2);
            }
            String str15 = spVar.b;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("top_show_detail_list", str7);
            Unit unit = Unit.INSTANCE;
            return new jv5.d(arrayList, str15, linkedHashMap, (jv5.r) null, 8, (DefaultConstructorMarker) null);
        }
        return new jv5.d((List) null, (String) null, (Map) null, (jv5.r) null, 15, (DefaultConstructorMarker) null);
    }

    public static final f0 g(eo eoVar, com.dragon.read.kmp.profile.params.a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        xk0 xk0Var;
        ok0 ok0Var;
        Intrinsics.checkNotNullParameter(eoVar, "<this>");
        dl4.t tVar = new dl4.t();
        tVar.e(eoVar.a);
        cj0 cj0Var = eoVar.a;
        if (cj0Var != null && (ok0Var = cj0Var.b) != null) {
            z = Intrinsics.areEqual(ok0Var.h, Boolean.TRUE);
        } else {
            z = false;
        }
        if (aVar != null && aVar.l(eoVar.d)) {
            z2 = true;
        } else {
            z2 = false;
        }
        cj0 cj0Var2 = eoVar.a;
        if (cj0Var2 != null && (xk0Var = cj0Var2.g) != null) {
            z3 = Intrinsics.areEqual(xk0Var.e, Boolean.TRUE);
        } else {
            z3 = false;
        }
        return new f0(eoVar, tVar, f(eoVar), z, z2, z3);
    }
}
