package gq4;

import an4.e;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.VipCommonSubType;
import com.dragon.read.kmp.service.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    static {
        Covode.recordClassIndex(609607);
        a = new b();
    }

    private b() {
    }

    public final boolean b() {
        e vipInfo = c0.a.getVipInfo();
        if (vipInfo == null) {
            return false;
        }
        if (!Intrinsics.areEqual("1", vipInfo.a)) {
            Boolean bool = vipInfo.g;
            Boolean bool2 = Boolean.TRUE;
            if (!Intrinsics.areEqual(bool, bool2) && !Intrinsics.areEqual(vipInfo.i, bool2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v22 */
    public final e a() {
        String str;
        List listOf;
        int indexOf;
        boolean z;
        int i;
        int indexOf2;
        boolean z2;
        int i2;
        ArrayList arrayList = new ArrayList();
        c0 c0Var = c0.a;
        e vipInfo = c0Var.getVipInfo();
        e eVar = null;
        if (vipInfo != null) {
            str = vipInfo.a;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual("1", str)) {
            arrayList.add(vipInfo);
        }
        List<e> Y6 = c0Var.Y6();
        if (Y6 != null) {
            for (e eVar2 : Y6) {
                if (Intrinsics.areEqual("1", eVar2.a)) {
                    arrayList.add(eVar2);
                }
            }
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(VipCommonSubType.Default.getValue()), Integer.valueOf(VipCommonSubType.AdFree.getValue()), Integer.valueOf(VipCommonSubType.Publish.getValue()), Integer.valueOf(VipCommonSubType.ShortStory.getValue())});
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            ?? next = it2.next();
            if (it2.hasNext()) {
                indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends Integer>) ((List<? extends Object>) listOf), ((e) next).j);
                Integer valueOf = Integer.valueOf(indexOf);
                if (valueOf.intValue() >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    i = valueOf.intValue();
                } else {
                    i = Integer.MAX_VALUE;
                }
                Integer valueOf2 = Integer.valueOf(i);
                do {
                    Object next2 = it2.next();
                    indexOf2 = CollectionsKt___CollectionsKt.indexOf((List<? extends Integer>) ((List<? extends Object>) listOf), ((e) next2).j);
                    Integer valueOf3 = Integer.valueOf(indexOf2);
                    if (valueOf3.intValue() >= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        valueOf3 = null;
                    }
                    if (valueOf3 != null) {
                        i2 = valueOf3.intValue();
                    } else {
                        i2 = Integer.MAX_VALUE;
                    }
                    Integer valueOf4 = Integer.valueOf(i2);
                    next = next;
                    if (valueOf2.compareTo(valueOf4) > 0) {
                        next = next2;
                        valueOf2 = valueOf4;
                    }
                } while (it2.hasNext());
            }
            eVar = next;
        }
        return eVar;
    }
}
