package com.dragon.read.kmp.nps;

import com.bytedance.covode.number.Covode;
import com.dragon.read.feed.bookmall.card.model.staggered.BaseInfiniteModel;
import com.dragon.read.rpc.model.UserResearchOptionInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DoubleColSimilarNpsModel extends BaseInfiniteModel {
    public static final int $stable;
    private UserResearchOptionInfo optionInfos;
    private String researchId = "";
    private String researchTitle = "";
    private Map<String, ? extends UserResearchOptionInfo> scoreOptionInfo;

    static {
        Covode.recordClassIndex(607868);
        $stable = 8;
    }

    public String getImpressionBookId() {
        return "";
    }

    public String getImpressionId() {
        return "";
    }

    public String getImpressionRecommendInfo() {
        return "";
    }

    public final UserResearchOptionInfo getOptionInfos() {
        return this.optionInfos;
    }

    public final String getResearchId() {
        return this.researchId;
    }

    public final String getResearchTitle() {
        return this.researchTitle;
    }

    public final Map<String, UserResearchOptionInfo> getScoreOptionInfo() {
        return this.scoreOptionInfo;
    }

    public final void setOptionInfos(UserResearchOptionInfo userResearchOptionInfo) {
        this.optionInfos = userResearchOptionInfo;
    }

    public final void setScoreOptionInfo(Map<String, ? extends UserResearchOptionInfo> map) {
        this.scoreOptionInfo = map;
    }

    public final void setResearchId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.researchId = str;
    }

    public final void setResearchTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.researchTitle = str;
    }
}
