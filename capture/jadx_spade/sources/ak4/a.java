package ak4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.CandidateDataType;
import com.bytedance.kmp.reading.model.a80;
import com.bytedance.kmp.reading.model.di0;
import com.bytedance.kmp.reading.model.s80;
import com.bytedance.kmp.reading.model.x7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import yn0.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(607746);
        a = new a();
    }

    private a() {
    }

    private final com.dragon.read.kmp.base.e c(String str, Map<String, a80> map, int i) {
        if (map != null && map.get(str) != null) {
            return com.dragon.read.kmp.base.f.b(map.get(str), i);
        }
        return null;
    }

    public final List<yh4.b> b(s80 tabData, hn4.d params, List<? extends com.dragon.read.kmp.mine.data.b> list) {
        Map emptyMap;
        boolean z;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            emptyMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list) {
                String str = ((com.dragon.read.kmp.mine.data.b) obj).h;
                if (str == null) {
                    str = "";
                }
                emptyMap.put(str, obj);
            }
        } else {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        List<x7> list2 = tabData.c;
        if (list2 != null) {
            for (x7 x7Var : list2) {
                Integer num = x7Var.G0;
                int value = CandidateDataType.Video.getValue();
                boolean z2 = false;
                if (num != null && num.intValue() == value) {
                    ck4.d dVar = new ck4.d(x7Var, false, 2, null);
                    dVar.g = params;
                    dVar.i = d(a, "title", x7Var.m, 0, 4, null);
                    dVar.n = (com.dragon.read.kmp.mine.data.b) emptyMap.get(dVar.h());
                    arrayList.add(dVar);
                } else {
                    int value2 = CandidateDataType.Book.getValue();
                    if (num != null && num.intValue() == value2) {
                        ck4.a aVar = new ck4.a(x7Var);
                        aVar.g = params;
                        aVar.i = d(a, "title", x7Var.m, 0, 4, null);
                        aVar.n = (com.dragon.read.kmp.mine.data.b) emptyMap.get(aVar.h());
                        arrayList.add(aVar);
                    } else {
                        int value3 = CandidateDataType.VideoSeriesPost.getValue();
                        if (num != null && num.intValue() == value3) {
                            Integer num2 = tabData.a;
                            if (num2 != null && num2.intValue() == 25) {
                                z = true;
                            } else {
                                z = false;
                            }
                            Integer num3 = tabData.a;
                            if (num3 != null && num3.intValue() == 26) {
                                z2 = true;
                            }
                            ck4.c a2 = a.a(x7Var, params, z2, z);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        } else {
                            a.a.b(yn0.b.b, "MineSearchDataParser", "Unsupported groupIdType " + x7Var.G0 + ",skip it!", false, 4, (Object) null);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final ck4.c a(x7 x7Var, hn4.d dVar, boolean z, boolean z2) {
        di0 di0Var;
        List list = x7Var.Q0;
        if (list != null) {
            di0Var = (di0) CollectionsKt___CollectionsKt.getOrNull(list, 0);
        } else {
            di0Var = null;
        }
        if (di0Var == null) {
            return null;
        }
        ck4.c cVar = new ck4.c(di0Var, x7Var, z, z2);
        cVar.i = d(a, "title", x7Var.m, 0, 4, null);
        cVar.g = dVar;
        return cVar;
    }

    static /* synthetic */ com.dragon.read.kmp.base.e d(a aVar, String str, Map map, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return aVar.c(str, map, i);
    }
}
