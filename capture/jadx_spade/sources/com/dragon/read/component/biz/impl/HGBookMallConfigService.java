package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.BookMallTabPreloadConfig;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.component.biz.impl.brickservice.BookMallBsConfigService;
import java.util.List;
import kj3.g0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import nb0.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGBookMallConfigService implements BookMallBsConfigService {
    public static final int $stable;
    private Integer config;
    private final g0 privacyDialogDelayOptSafeController;

    static {
        Covode.recordClassIndex(588058);
        $stable = 8;
    }

    public int defaultAppIdForFirstStartPrivacyDialogDelayOpt() {
        return 8662;
    }

    public boolean enablePreloadPugcTab() {
        return true;
    }

    /* renamed from: getColdStartDefaultLandingToSeriesFeedConfig, reason: collision with other method in class */
    public Integer m2getColdStartDefaultLandingToSeriesFeedConfig() {
        return this.config;
    }

    public boolean enableFeedSurlCombineWithColdStartOpt() {
        return BookMallBsConfigService.b.c(this);
    }

    public boolean enableSupportMultiTabPreload() {
        return BookMallBsConfigService.b.e(this);
    }

    public void startCrashMonitorForPrivacyDialogDelayOpt() {
        this.privacyDialogDelayOptSafeController.h();
    }

    public boolean enableColdStartDefaultLandingToSeriesFeed() {
        Integer num = this.config;
        if (num == null || num.intValue() != 0) {
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ int getColdStartDefaultLandingToSeriesFeedConfig() {
        return m2getColdStartDefaultLandingToSeriesFeedConfig().intValue();
    }

    public HGBookMallConfigService() {
        int i;
        g0 g0Var = new g0();
        this.privacyDialogDelayOptSafeController = g0Var;
        if (!PrivacyMgr.inst().hasConfirmedOrBasicFunctionEnabled() && !g0Var.d()) {
            i = a.s(true);
        } else {
            i = 0;
        }
        this.config = i;
    }

    public BookMallTabPreloadConfig getBookMallTabPreloadConfig() {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{8, 14, 16, 17, 21, 22});
        return new BookMallTabPreloadConfig(listOf);
    }
}
