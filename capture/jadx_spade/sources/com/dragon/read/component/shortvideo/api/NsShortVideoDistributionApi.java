package com.dragon.read.component.shortvideo.api;

import android.app.Activity;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface NsShortVideoDistributionApi extends IService {
    public static final a Companion;
    public static final NsShortVideoDistributionApi IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598170);
            a = new a();
        }

        private a() {
        }
    }

    ip2.i getSeriesRankingShareModal(Activity activity);

    void handleShortSeriesRankingKmp(Context context, com.bytedance.router.c cVar);

    boolean isEnableRankKmpActivity();

    boolean isNewRankHolderStyle();

    boolean isNewRankTopBgStyle();

    boolean isRankingActivity(Activity activity);

    void preloadRankingData(com.bytedance.router.c cVar);

    void startRankingActivityTrace();

    static {
        Covode.recordClassIndex(598169);
        Companion = a.a;
        Object service = ServiceManager.getService(NsShortVideoDistributionApi.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (NsShortVideoDistributionApi) service;
    }
}
