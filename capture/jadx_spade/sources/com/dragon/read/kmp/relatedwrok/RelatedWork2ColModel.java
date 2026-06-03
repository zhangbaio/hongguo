package com.dragon.read.kmp.relatedwrok;

import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.feed.bookmall.card.model.staggered.BaseInfiniteModel;
import com.dragon.read.rpc.model.CellViewData;
import com.dragon.read.util.CdnLargeImageLoader;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import wm4.v;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RelatedWork2ColModel extends BaseInfiniteModel {
    public static final int $stable;
    private l0 mCardBgColor;
    private String mCardBgUrl;
    private l0 mCardMainTitleColor;
    private l0 mCardSubInfoColor1;
    private final List<v> rankList = new ArrayList();

    static {
        Covode.recordClassIndex(608672);
        $stable = 8;
    }

    public String getImpressionBookId() {
        return "";
    }

    /* renamed from: getMCardBgColor-QN2ZGVo, reason: not valid java name */
    public final l0 m34getMCardBgColorQN2ZGVo() {
        return this.mCardBgColor;
    }

    public final String getMCardBgUrl() {
        return this.mCardBgUrl;
    }

    /* renamed from: getMCardMainTitleColor-QN2ZGVo, reason: not valid java name */
    public final l0 m35getMCardMainTitleColorQN2ZGVo() {
        return this.mCardMainTitleColor;
    }

    /* renamed from: getMCardSubInfoColor1-QN2ZGVo, reason: not valid java name */
    public final l0 m36getMCardSubInfoColor1QN2ZGVo() {
        return this.mCardSubInfoColor1;
    }

    public final List<v> getRankList() {
        return this.rankList;
    }

    public String getImpressionId() {
        String str;
        CellViewData cellViewData = ((BaseInfiniteModel) this).originalData;
        if (cellViewData == null || (str = cellViewData.recommendGroupId) == null) {
            return "";
        }
        return str;
    }

    public String getImpressionRecommendInfo() {
        String str;
        CellViewData cellViewData = ((BaseInfiniteModel) this).originalData;
        if (cellViewData == null || (str = cellViewData.recommendInfo) == null) {
            return "";
        }
        return str;
    }

    public RelatedWork2ColModel() {
        String cdnFileImageUrl = CdnLargeImageLoader.getCdnFileImageUrl("img_693_staggered_rank_card_bg_feeling_v693.png");
        Intrinsics.checkNotNullExpressionValue(cdnFileImageUrl, "getCdnFileImageUrl(...)");
        this.mCardBgUrl = cdnFileImageUrl;
    }

    /* renamed from: setCardBgColor-Y2TPw74, reason: not valid java name */
    public final void m37setCardBgColorY2TPw74(l0 l0Var) {
        this.mCardBgColor = l0Var;
    }

    /* renamed from: setCardMainTitleColor-Y2TPw74, reason: not valid java name */
    public final void m38setCardMainTitleColorY2TPw74(l0 l0Var) {
        this.mCardMainTitleColor = l0Var;
    }

    /* renamed from: setCardSubInfoColor1-Y2TPw74, reason: not valid java name */
    public final void m39setCardSubInfoColor1Y2TPw74(l0 l0Var) {
        this.mCardSubInfoColor1 = l0Var;
    }

    /* renamed from: setMCardBgColor-Y2TPw74, reason: not valid java name */
    public final void m40setMCardBgColorY2TPw74(l0 l0Var) {
        this.mCardBgColor = l0Var;
    }

    /* renamed from: setMCardMainTitleColor-Y2TPw74, reason: not valid java name */
    public final void m41setMCardMainTitleColorY2TPw74(l0 l0Var) {
        this.mCardMainTitleColor = l0Var;
    }

    /* renamed from: setMCardSubInfoColor1-Y2TPw74, reason: not valid java name */
    public final void m42setMCardSubInfoColor1Y2TPw74(l0 l0Var) {
        this.mCardSubInfoColor1 = l0Var;
    }

    public final void setMCardBgUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCardBgUrl = str;
    }

    public final void setCardBgUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mCardBgUrl = url;
    }
}
