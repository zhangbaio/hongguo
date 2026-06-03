package com.dragon.read.kmp.search.searchlinkpage;

import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.CandidateDataType;
import com.bytedance.kmp.reading.model.x7;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e0 extends ViewModel {
    public static final a c;
    public static final int d;
    public final MutableStateFlow<d> a;
    public final StateFlow<d> b;

    static {
        Covode.recordClassIndex(608793);
        c = new a(null);
        d = 8;
    }

    public e0(MutableStateFlow<d> cardDataStateFlow) {
        Intrinsics.checkNotNullParameter(cardDataStateFlow, "cardDataStateFlow");
        this.a = cardDataStateFlow;
        this.b = FlowKt.asStateFlow(cardDataStateFlow);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608794);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e0 a(String queryWord, List<x7> dataList) {
            List mutableListOf;
            List mutableListOf2;
            Object obj;
            Intrinsics.checkNotNullParameter(queryWord, "queryWord");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj2 : dataList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                x7 x7Var = (x7) obj2;
                Integer num = x7Var.G0;
                int value = CandidateDataType.Book.getValue();
                if (num != null && num.intValue() == value) {
                    obj = new com.dragon.read.kmp.search.searchlinkpage.a(x7Var);
                } else {
                    int value2 = CandidateDataType.DynamicComic.getValue();
                    if (num == null || num.intValue() != value2) {
                        int value3 = CandidateDataType.VideoSeries.getValue();
                        if (num == null || num.intValue() != value3) {
                            obj = null;
                        }
                    }
                    obj = new f0(x7Var);
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
                i = i2;
            }
            if (arrayList.size() == 1) {
                ((d0) arrayList.get(0)).a = true;
            }
            String str = "去搜索" + queryWord;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(3L, Long.valueOf(queryWord.length()));
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(mutableListOf);
            arrayList.add(new c(str, mutableListOf2));
            return new e0(StateFlowKt.MutableStateFlow(new d(arrayList)));
        }
    }
}
