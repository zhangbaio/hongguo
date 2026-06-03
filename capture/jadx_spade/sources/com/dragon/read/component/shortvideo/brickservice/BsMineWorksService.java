package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import io.reactivex.Single;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsMineWorksService extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598981);
        Companion = a.a;
    }

    void clearCache();

    int getAndResetPreloadType();

    String getPreloadStrategy();

    boolean hasEnteredDynamicTabRecently();

    void registerEventBus();

    Single<com.dragon.read.component.shortvideo.brickservice.a> tryGetPreloadDataAsync(String str);

    void tryPreload(String str);

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598982);
            a = new a();
        }

        private a() {
        }

        public final BsMineWorksService a() {
            return (BsMineWorksService) ServiceManager.getService(BsMineWorksService.class);
        }
    }
}
