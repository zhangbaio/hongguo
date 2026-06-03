package com.dragon.read.kmp.reader.bookcover.epub;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.state.TagStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d1 {
    public static final d1 a;

    static {
        Covode.recordClassIndex(608278);
        a = new d1();
    }

    private d1() {
    }

    private final String e(String str) {
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

    private final com.dragon.read.kmp.reader.state.j d(List<com.dragon.read.kmp.reader.state.j> list, String str) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        for (com.dragon.read.kmp.reader.state.j jVar : list) {
            if (Intrinsics.areEqual(jVar.a, str)) {
                return jVar;
            }
        }
        return null;
    }

    public final List<com.dragon.read.kmp.reader.state.w> c(List<com.dragon.read.kmp.reader.state.j> list, List<com.dragon.read.kmp.reader.state.g> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ArrayList arrayList = new ArrayList();
        com.dragon.read.kmp.reader.state.j d = d(list, "RankListFengYun");
        com.dragon.read.kmp.reader.state.j d2 = d(list, "PublishRankListRaise");
        com.dragon.read.kmp.reader.state.j d3 = d(list, "PublishRankListTop");
        if (d == null) {
            if (d2 == null) {
                d = d3;
            } else {
                d = d2;
            }
        }
        if (d != null) {
            String e = a.e(d.b);
            if (e.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                arrayList.add(new com.dragon.read.kmp.reader.state.w(e, d.c, false, TagStyle.WHEAT));
            }
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        for (com.dragon.read.kmp.reader.state.j jVar : list) {
            if (!Intrinsics.areEqual(jVar.a, "RankListFengYun") && !Intrinsics.areEqual(jVar.a, "PublishRankListRaise") && !Intrinsics.areEqual(jVar.a, "PublishRankListTop")) {
                String e2 = a.e(jVar.b);
                if (e2.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    arrayList.add(new com.dragon.read.kmp.reader.state.w(e2, jVar.c, false, TagStyle.WHEAT));
                }
            }
        }
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        for (com.dragon.read.kmp.reader.state.g gVar : list2) {
            String str = gVar.a;
            String str2 = gVar.b;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    arrayList.add(new com.dragon.read.kmp.reader.state.w(str, str2, false, TagStyle.NORMAL));
                }
            }
        }
        return arrayList;
    }

    public final List<com.dragon.read.kmp.reader.state.w> a(List<com.dragon.read.kmp.reader.state.j> list, List<com.dragon.read.kmp.reader.state.g> list2, Function1<? super List<com.dragon.read.kmp.reader.state.w>, Unit> function1) {
        List<com.dragon.read.kmp.reader.state.w> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) c(list, list2));
        if (function1 != null) {
            function1.invoke(mutableList);
        }
        return mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List b(d1 d1Var, List list, List list2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return d1Var.a(list, list2, function1);
    }
}
