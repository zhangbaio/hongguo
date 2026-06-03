package com.dragon.read.component.biz.impl;

import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import com.dragon.read.asyncinflate.PreloadViewInfo;
import com.dragon.read.component.biz.brickservice.BsSearchConfigService;
import com.dragon.read.component.biz.impl.absettings.SearchPreloadOptV703;
import com.dragon.read.component.biz.impl.ui.searchpage.fragment.AbsSearchResultFragment;
import com.dragon.read.rpc.model.SearchTabType;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGSearchConfigServiceImpl implements BsSearchConfigService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588064);
    }

    public boolean enableSearchLongPressOpt() {
        return true;
    }

    public SearchTabType getDefaultSearchTab() {
        return SearchTabType.ShortPlay;
    }

    public Map<Integer, PreloadViewInfo> getPreloadXMLList() {
        Map<Integer, PreloadViewInfo> mapOf;
        if (SearchPreloadOptV703.a.a().preloadViewHolder) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(2131039166, new PreloadViewInfo.a().e(2131039166).c("ResultShortVideoHolder").f(6).b()), TuplesKt.to(2131039161, new PreloadViewInfo.a().e(2131039161).c("ResultActorHolderV3").f(1).b()), TuplesKt.to(2131039170, new PreloadViewInfo.a().e(2131039170).c("ResultVideoSubscribeCardHolder").f(1).b()), TuplesKt.to(2131039163, new PreloadViewInfo.a().e(2131039163).c("SearchPersonalizedCardView").f(1).b()), TuplesKt.to(2131038622, new PreloadViewInfo.a().e(2131038622).c("StaggeredRelatedHolder").f(1).b()), TuplesKt.to(2131038621, new PreloadViewInfo.a().e(2131038621).c("StaggeredBookHolder").f(1).b()), TuplesKt.to(2131039165, new PreloadViewInfo.a().e(2131039165).c("ResultPugcHolder").f(5).b()));
            return mapOf;
        }
        return null;
    }

    public void saveLastSecondPreloadSearchTabType(SearchTabType searchTabType) {
        Intrinsics.checkNotNullParameter(searchTabType, "searchTabType");
        n3.a.b(searchTabType);
    }

    public AbsSearchResultFragment obtainSecondFragment(SearchActivity activity, SearchTabType searchTabType, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(searchTabType, "searchTabType");
        return n3.a.a(activity, viewGroup);
    }
}
