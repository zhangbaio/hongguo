package po4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.CandidateDataType;
import com.bytedance.kmp.reading.model.ShowType;
import com.bytedance.kmp.reading.model.VideoInnerNextItem;
import com.bytedance.kmp.reading.model.a8;
import com.bytedance.kmp.reading.model.bj0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.x7;
import com.dragon.read.kmp.basenovel.ui.ui.v0;
import io4.g;
import java.util.ArrayList;
import java.util.List;
import jd4.c;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609107);
        a = new a();
    }

    private a() {
    }

    public final List<v0> b(List<x7> cellViewDatas, int i) {
        Intrinsics.checkNotNullParameter(cellViewDatas, "cellViewDatas");
        ArrayList arrayList = new ArrayList();
        if (cellViewDatas.isEmpty()) {
            return arrayList;
        }
        int i2 = 0;
        for (Object obj : cellViewDatas) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.addAll(a.c((x7) obj, i));
            i2 = i3;
        }
        return arrayList;
    }

    public final List<v0> c(x7 cell, int i) {
        Intrinsics.checkNotNullParameter(cell, "cell");
        ArrayList arrayList = new ArrayList();
        Integer num = cell.b;
        int value = ShowType.RanklistSingleCol.getValue();
        if (num == null || num.intValue() != value) {
            int value2 = ShowType.VideoTopicLandpage.getValue();
            if (num == null || num.intValue() != value2) {
                int value3 = ShowType.FeedUgcUserCard.getValue();
                if (num != null && num.intValue() == value3) {
                    arrayList.addAll(e(cell, i));
                }
                return arrayList;
            }
        }
        arrayList.addAll(e(cell, i));
        return arrayList;
    }

    private final List<v0> e(x7 x7Var, int i) {
        boolean z;
        boolean z2;
        v0 a2;
        Boolean bool;
        ArrayList arrayList = new ArrayList();
        List list = x7Var.u;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return arrayList;
        }
        a8 a8Var = x7Var.o0;
        if (a8Var != null && a8Var != null && (bool = a8Var.q) != null) {
            z2 = bool.booleanValue();
        } else {
            z2 = false;
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            x7 x7Var2 = (x7) obj;
            Integer num = x7Var2.b;
            int value = ShowType.RanklistSingleCol.getValue();
            if (num == null || num.intValue() != value) {
                int value2 = ShowType.VideoTopicLandpage.getValue();
                if (num == null || num.intValue() != value2) {
                    int value3 = ShowType.FeedUgcUserCard.getValue();
                    if (num != null && num.intValue() == value3 && (a2 = a.a(x7Var, x7Var2, i)) != null) {
                        arrayList.add(a2);
                    }
                    i2 = i3;
                }
            }
            v0 d = a.d(x7Var, x7Var2, i2, i, z2);
            if (d != null) {
                arrayList.add(d);
            }
            i2 = i3;
        }
        return arrayList;
    }

    public final v0 a(x7 cellViewData, x7 data, int i) {
        bj0 bj0Var;
        ShowType showType;
        Integer num;
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        Intrinsics.checkNotNullParameter(data, "data");
        List list = data.c3;
        int i2 = 0;
        VideoInnerNextItem videoInnerNextItem = null;
        if (list != null) {
            bj0Var = (bj0) CollectionsKt___CollectionsKt.getOrNull(list, 0);
        } else {
            bj0Var = null;
        }
        if (bj0Var == null) {
            return null;
        }
        io4.a aVar = new io4.a(bj0Var);
        a8 a8Var = cellViewData.o0;
        if (a8Var != null) {
            Integer num2 = a8Var.S;
            if (num2 != null) {
                i2 = num2.intValue();
            }
            aVar.c = i2;
        }
        a8 a8Var2 = data.o0;
        if (a8Var2 != null && (num = a8Var2.m0) != null) {
            videoInnerNextItem = jd4.a.d(num.intValue());
        }
        if (videoInnerNextItem != null) {
            aVar.d = videoInnerNextItem;
        }
        Integer num3 = data.b;
        if (num3 == null || (showType = jd4.a.b(num3.intValue())) == null) {
            showType = ShowType.RanklistSingleCol;
        }
        aVar.e(showType);
        return aVar;
    }

    public final v0 d(x7 cellViewData, x7 data, int i, int i2, boolean z) {
        boolean z2;
        CandidateDataType candidateDataType;
        ShowType showType;
        Integer num;
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        Intrinsics.checkNotNullParameter(data, "data");
        List list = data.v;
        int i3 = 0;
        if (list != null && !list.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        VideoInnerNextItem videoInnerNextItem = null;
        if (z2) {
            return null;
        }
        a8 a8Var = cellViewData.o0;
        om0 om0Var = (om0) CollectionsKt___CollectionsKt.first(list);
        Integer num2 = data.G0;
        if (num2 != null) {
            candidateDataType = jd4.a.a(num2.intValue());
        } else {
            candidateDataType = null;
        }
        c cVar = new c(om0Var, candidateDataType, z);
        cVar.g = i;
        if (a8Var != null) {
            Integer num3 = a8Var.S;
            if (num3 != null) {
                i3 = num3.intValue();
            }
            cVar.h = i3;
        }
        g gVar = new g(cVar);
        a8 a8Var2 = data.o0;
        if (a8Var2 != null && (num = a8Var2.m0) != null) {
            videoInnerNextItem = jd4.a.d(num.intValue());
        }
        if (videoInnerNextItem != null) {
            gVar.c = videoInnerNextItem;
        }
        Integer num4 = data.b;
        if (num4 == null || (showType = jd4.a.b(num4.intValue())) == null) {
            showType = ShowType.RanklistSingleCol;
        }
        gVar.i(showType);
        return gVar;
    }
}
