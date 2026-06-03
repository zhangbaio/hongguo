package com.dragon.read.kmp.rank;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.feed.AbsStaggeredFeedCrossModel;
import com.dragon.read.rpc.model.CellViewData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CrossRank2ColModel extends AbsStaggeredFeedCrossModel<re4.e> {
    public static final int $stable;

    static {
        Covode.recordClassIndex(608226);
        $stable = AbsStaggeredFeedCrossModel.$stable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: generateKmpModel, reason: merged with bridge method [inline-methods] */
    public re4.e m33generateKmpModel() {
        return new re4.e(getKmpCellViewData());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossRank2ColModel(CellViewData cellViewData) {
        super(cellViewData);
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
    }
}
