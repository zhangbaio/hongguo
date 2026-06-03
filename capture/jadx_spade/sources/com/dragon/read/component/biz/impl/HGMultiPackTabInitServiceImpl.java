package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.absettins.HongguoMultiTabLandingForBookshelf;
import com.dragon.read.component.biz.impl.absettins.HongguoMultiTabLandingForCollectionV605;
import com.dragon.read.component.biz.impl.absettins.HongguoMultiTabLandingForHistory;
import com.dragon.read.component.biz.impl.absettins.HongguoMultiTabLandingForInheritance;
import com.dragon.read.component.biz.impl.brickservice.BsMultiPackTabInitService;
import com.dragon.read.rpc.model.BookshelfTabType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGMultiPackTabInitServiceImpl implements BsMultiPackTabInitService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588063);
    }

    public int getDefaultTabValue() {
        return BookshelfTabType.Video.getValue();
    }

    private final boolean enableLandingSettingV1() {
        if (HongguoMultiTabLandingForHistory.a.a().enable == 1) {
            return true;
        }
        return false;
    }

    private final boolean enableLandingSettingV2() {
        if (HongguoMultiTabLandingForBookshelf.a.a().enable == 1) {
            return true;
        }
        return false;
    }

    private final boolean enableLandingSettingV3() {
        if (HongguoMultiTabLandingForInheritance.a.a().enable == 1) {
            return true;
        }
        return false;
    }

    private final int getCollectionLandingTarget() {
        return HongguoMultiTabLandingForCollectionV605.a.a().target;
    }

    public BookshelfTabType getTargetTabType(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int collectionLandingTarget = getCollectionLandingTarget();
        if (collectionLandingTarget == -1) {
            if (z && z2 && !z3 && enableLandingSettingV1()) {
                return BookshelfTabType.ReadHistory;
            }
            if (!z && z2 && enableLandingSettingV2()) {
                return BookshelfTabType.Bookshelf;
            }
            if (!z && !z2 && enableLandingSettingV3()) {
                BookshelfTabType bookshelfTabType = BookshelfTabType.Bookshelf;
                if (i != bookshelfTabType.getValue()) {
                    BookshelfTabType bookshelfTabType2 = BookshelfTabType.Video;
                    if (i != bookshelfTabType2.getValue()) {
                        BookshelfTabType bookshelfTabType3 = BookshelfTabType.ReadHistory;
                        if (i == bookshelfTabType3.getValue() && !z3) {
                            return bookshelfTabType3;
                        }
                        return bookshelfTabType2;
                    }
                    return bookshelfTabType2;
                }
                return bookshelfTabType;
            }
            return BookshelfTabType.Video;
        }
        BookshelfTabType bookshelfTabType4 = BookshelfTabType.ReadHistory;
        if (collectionLandingTarget != bookshelfTabType4.getValue()) {
            BookshelfTabType bookshelfTabType5 = BookshelfTabType.Video;
            bookshelfTabType5.getValue();
            return bookshelfTabType5;
        }
        return bookshelfTabType4;
    }
}
