package yp4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.bm;
import com.bytedance.kmp.ugc.model.rj;
import com.bytedance.kmp.ugc.model.us;
import com.bytedance.kmp.ugc.model.vf;
import com.dragon.read.kmp.utils.StringUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements xp4.a {
    public static final int b;
    public final bm a;

    static {
        Covode.recordClassIndex(609398);
        b = 8;
    }

    @Override // xp4.a
    public String a() {
        return this.a.y;
    }

    @Override // xp4.a
    public String c() {
        return this.a.q;
    }

    public final List<us> f() {
        return g();
    }

    @Override // xp4.a
    public String getPostId() {
        return this.a.a;
    }

    @Override // xp4.a
    public String getTitle() {
        return this.a.k;
    }

    public final rj e() {
        Object firstOrNull;
        List list = this.a.F;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            return (rj) firstOrNull;
        }
        return null;
    }

    @Override // xp4.a
    public String b() {
        return "post_" + getPostId();
    }

    public final String j() {
        String str;
        vf vfVar = this.a.F0;
        if (vfVar == null || (str = vfVar.k) == null || !(!StringsKt__StringsKt.isBlank(str))) {
            return null;
        }
        return str;
    }

    public List<us> g() {
        List<us> list = this.a.k1;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (us usVar : list) {
            if (StringUtilsKt.a(usVar.a)) {
                arrayList.add(usVar);
            }
        }
        return arrayList;
    }

    public String h() {
        List<us> g = g();
        if (!g.isEmpty()) {
            return CollectionsKt___CollectionsKt.joinToString$default(g, ",", null, null, 0, null, new Function1() { // from class: yp4.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence i;
                    i = b.i((us) obj);
                    return i;
                }
            }, 30, null);
        }
        return CollectionsKt___CollectionsKt.joinToString$default(k(), ",", null, null, 0, null, null, 62, null);
    }

    @Override // xp4.a
    public String getCoverUrl() {
        boolean z;
        boolean z2;
        vf vfVar = this.a.F0;
        if (vfVar == null) {
            return null;
        }
        String str = vfVar.f;
        boolean z3 = false;
        if (str != null && !StringsKt__StringsKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return vfVar.f;
        }
        String str2 = vfVar.j;
        if (str2 != null && !StringsKt__StringsKt.isBlank(str2)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return vfVar.j;
        }
        String str3 = vfVar.k;
        if (str3 == null || StringsKt__StringsKt.isBlank(str3)) {
            z3 = true;
        }
        if (!z3) {
            return vfVar.k;
        }
        return vfVar.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.lang.String> k() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yp4.b.k():java.util.List");
    }

    public b(bm postData) {
        Intrinsics.checkNotNullParameter(postData, "postData");
        this.a = postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence i(us it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return String.valueOf(it2.a);
    }
}
