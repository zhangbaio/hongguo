package com.dragon.read.kmp.shortvideo.distribution.infinite;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.v90;
import com.bytedance.kmp.reading.model.y7;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.kmp.utils.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609031);
            int[] iArr = new int[FilterType.values().length];
            try {
                iArr[FilterType.PANEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FilterType.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609030);
    }

    public static final boolean i(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        return Intrinsics.areEqual("operation", dVar.b.f);
    }

    public static final String d(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (i(dVar)) {
            return dVar.b.f;
        }
        return dVar.getType();
    }

    public static final FilterType f(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (l(gVar)) {
            return FilterType.PANEL;
        }
        if (k(gVar)) {
            return FilterType.BACKGROUND;
        }
        return FilterType.DEFAULT;
    }

    public static final boolean k(g gVar) {
        List<c> list;
        g gVar2;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        d g = g(gVar);
        if (g != null && (gVar2 = g.f) != null) {
            list = gVar2.c;
        } else {
            list = null;
        }
        return c0.a(list);
    }

    public static final boolean l(g gVar) {
        List<c> list;
        g gVar2;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        d g = g(gVar);
        if (g != null && (gVar2 = g.e) != null) {
            list = gVar2.c;
        } else {
            list = null;
        }
        return c0.a(list);
    }

    public static final g q(p90 p90Var) {
        y7 y7Var;
        g p;
        if (p90Var == null || (y7Var = p90Var.B) == null || (p = p(y7Var)) == null) {
            return null;
        }
        p.d = p90Var.A;
        return p;
    }

    public static final g c(y7 y7Var) {
        v90 v90Var;
        List list;
        Object obj;
        if (y7Var == null || (v90Var = y7Var.a) == null || (list = v90Var.a) == null) {
            return null;
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((p90) obj).c, Boolean.TRUE)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        p90 p90Var = (p90) obj;
        if (p90Var == null) {
            return null;
        }
        return q(p90Var);
    }

    public static final String h(g gVar) {
        g gVar2;
        p90 p90Var;
        String str;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        d g = g(gVar);
        if (g != null) {
            gVar2 = g.f;
        } else {
            gVar2 = null;
        }
        if (gVar2 != null) {
            d k = g.f.k();
            if (k == null || (p90Var = k.b) == null || (str = p90Var.a) == null) {
                return "";
            }
            return str;
        }
        return e(gVar);
    }

    public static final boolean j(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Iterator it2 = ((Iterable) gVar.a.getValue()).iterator();
        while (it2.hasNext()) {
            if (((d) it2.next()).b.k != null) {
                return true;
            }
        }
        return false;
    }

    public static final g a(y7 y7Var) {
        String str;
        Intrinsics.checkNotNullParameter(y7Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        List<v90> list = y7Var.b;
        if (list == null) {
            str = "";
        } else {
            String str2 = "";
            for (v90 v90Var : list) {
                List<p90> list2 = v90Var.a;
                if (list2 != null) {
                    for (p90 p90Var : list2) {
                        if (Intrinsics.areEqual(p90Var.c, Boolean.TRUE)) {
                            str2 = p90Var.z;
                            if (str2 == null) {
                                str2 = "";
                            }
                            String str3 = p90Var.b;
                            if (str3 == null) {
                                str3 = "";
                            }
                            linkedHashSet.add(str3);
                        }
                    }
                }
                arrayList.add(o(v90Var));
            }
            str = str2;
        }
        g gVar = new g(null, SnapshotStateKt.mutableStateOf$default(linkedHashSet, (SnapshotMutationPolicy) null, 2, (Object) null), arrayList, 1, null);
        gVar.h.setValue(str);
        return gVar;
    }

    public static final d g(g gVar) {
        List list;
        List<c> list2;
        MutableState<List<d>> mutableState;
        List list3;
        MutableState<List<d>> mutableState2;
        Object obj = null;
        if (gVar != null && (mutableState2 = gVar.a) != null) {
            list = (List) mutableState2.getValue();
        } else {
            list = null;
        }
        if (c0.a(list)) {
            if (gVar == null || (mutableState = gVar.a) == null || (list3 = (List) mutableState.getValue()) == null) {
                return null;
            }
            Iterator it2 = list3.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (gVar.n(((d) next).b.b)) {
                    obj = next;
                    break;
                }
            }
            return (d) obj;
        }
        if (gVar != null && (list2 = gVar.c) != null) {
            Iterator<T> it4 = list2.iterator();
            while (it4.hasNext()) {
                for (d dVar : ((c) it4.next()).c) {
                    if (gVar.n(dVar.b.b)) {
                        return dVar;
                    }
                }
            }
        }
        return null;
    }

    public static final g m(y7 y7Var) {
        String str;
        Intrinsics.checkNotNullParameter(y7Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        List<v90> list = y7Var.b;
        if (list == null) {
            str = "";
        } else {
            String str2 = "";
            for (v90 v90Var : list) {
                List<p90> list2 = v90Var.a;
                if (list2 != null) {
                    for (p90 p90Var : list2) {
                        if (Intrinsics.areEqual(p90Var.c, Boolean.TRUE)) {
                            str2 = p90Var.z;
                            if (str2 == null) {
                                str2 = "";
                            }
                            String str3 = p90Var.b;
                            if (str3 == null) {
                                str3 = "";
                            }
                            linkedHashSet.add(str3);
                        }
                    }
                }
                arrayList.add(o(v90Var));
            }
            str = str2;
        }
        g gVar = new g(null, SnapshotStateKt.mutableStateOf$default(linkedHashSet, (SnapshotMutationPolicy) null, 2, (Object) null), arrayList, 1, null);
        gVar.g.setValue(str);
        return gVar;
    }

    public static final c o(v90 v90Var) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(v90Var, "<this>");
        ArrayList arrayList = new ArrayList();
        List<p90> list = v90Var.a;
        if (list != null) {
            for (p90 p90Var : list) {
                String type = v90Var.getType();
                if (type == null) {
                    str2 = "";
                } else {
                    str2 = type;
                }
                String str4 = v90Var.b;
                if (str4 == null) {
                    str3 = "";
                } else {
                    str3 = str4;
                }
                arrayList.add(new d(str2, p90Var, str3, null, null, null, 56, null));
            }
        }
        String str5 = v90Var.b;
        if (str5 == null) {
            str5 = "";
        }
        String type2 = v90Var.getType();
        if (type2 == null) {
            str = "";
        } else {
            str = type2;
        }
        return new c(str5, str, arrayList, 0, null, 24, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r3 != null) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String e(com.dragon.read.kmp.shortvideo.distribution.infinite.g r13) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.infinite.h.e(com.dragon.read.kmp.shortvideo.distribution.infinite.g):java.lang.String");
    }

    public static final g p(y7 y7Var) {
        boolean z;
        List<p90> list;
        String str;
        g gVar;
        g gVar2;
        List list2;
        Intrinsics.checkNotNullParameter(y7Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        v90 v90Var = y7Var.a;
        if (v90Var != null && (list2 = v90Var.a) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (Intrinsics.areEqual(((p90) obj).c, Boolean.TRUE)) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str2 = ((p90) it2.next()).b;
                if (str2 == null) {
                    str2 = "";
                }
                linkedHashSet.add(str2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        List<v90> list3 = y7Var.b;
        if (list3 != null) {
            for (v90 v90Var2 : list3) {
                List list4 = v90Var2.a;
                if (list4 != null) {
                    Iterator it4 = list4.iterator();
                    while (it4.hasNext()) {
                        String str3 = ((p90) it4.next()).b;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String type = v90Var2.getType();
                        if (type == null) {
                            type = "";
                        }
                        linkedHashMap.put(str3, type);
                    }
                }
                arrayList2.add(o(v90Var2));
            }
        }
        ArrayList arrayList3 = new ArrayList();
        v90 v90Var3 = y7Var.a;
        if (v90Var3 != null && (list = v90Var3.a) != null) {
            for (p90 p90Var : list) {
                String str4 = p90Var.b;
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = (String) linkedHashMap.get(str4);
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                Integer num = p90Var.A;
                y7 y7Var2 = p90Var.y;
                if (y7Var2 != null) {
                    gVar = m(y7Var2);
                } else {
                    gVar = null;
                }
                y7 y7Var3 = p90Var.x;
                if (y7Var3 != null) {
                    gVar2 = a(y7Var3);
                } else {
                    gVar2 = null;
                }
                arrayList3.add(new d(str, p90Var, null, num, gVar, gVar2, 4, null));
            }
        }
        g gVar3 = new g(SnapshotStateKt.mutableStateOf$default(arrayList3, (SnapshotMutationPolicy) null, 2, (Object) null), SnapshotStateKt.mutableStateOf$default(linkedHashSet, (SnapshotMutationPolicy) null, 2, (Object) null), arrayList2);
        Boolean bool = y7Var.n;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = false;
        }
        gVar3.f = z;
        return gVar3;
    }

    public static final g b(g gVar, FilterType filterType) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        int i = a.a[filterType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                d g = g(gVar);
                if (g != null) {
                    return g.f;
                }
            } else {
                return gVar;
            }
        } else {
            d g2 = g(gVar);
            if (g2 != null) {
                return g2.e;
            }
        }
        return null;
    }

    public static final void n(y7 y7Var, y7 y7Var2) {
        v90 v90Var;
        List<p90> list;
        v90 v90Var2;
        List<p90> list2;
        v90 v90Var3;
        List<p90> list3;
        if (y7Var2 != null && y7Var != null && (v90Var = y7Var.a) != null && (list = v90Var.a) != null) {
            for (p90 p90Var : list) {
                if (p90Var.y != null && Intrinsics.areEqual(p90Var.c, Boolean.FALSE) && (v90Var3 = y7Var2.a) != null && (list3 = v90Var3.a) != null) {
                    for (p90 p90Var2 : list3) {
                        if (p90Var2.y != null && Intrinsics.areEqual(p90Var2.a, p90Var.a)) {
                            p90Var.y = p90Var2.y;
                            p90Var.c = Boolean.FALSE;
                        }
                    }
                }
                if (p90Var.x != null && Intrinsics.areEqual(p90Var.c, Boolean.FALSE) && (v90Var2 = y7Var2.a) != null && (list2 = v90Var2.a) != null) {
                    for (p90 p90Var3 : list2) {
                        if (p90Var3.x != null && Intrinsics.areEqual(p90Var3.a, p90Var.a)) {
                            p90Var.x = p90Var3.x;
                            p90Var.c = Boolean.FALSE;
                        }
                    }
                }
            }
        }
    }
}
