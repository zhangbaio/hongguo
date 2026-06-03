package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.base.Args;
import com.dragon.read.rpc.model.BottomTabBarItemType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsShortSeriesRetainService extends IService {
    public static final a Companion;
    public static final BsShortSeriesRetainService IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598113);
            a = new a();
        }

        private a() {
        }
    }

    void navigateToFindSeriesTab(boolean z, Args args);

    void navigateToSeriesFeedTab(boolean z, Args args);

    void notifyFromNeedRetainTab(boolean z, BottomTabBarItemType bottomTabBarItemType, Integer num, boolean z2);

    static {
        Covode.recordClassIndex(598112);
        Companion = a.a;
        IMPL = (BsShortSeriesRetainService) ServiceManager.getService(BsShortSeriesRetainService.class);
    }
}
