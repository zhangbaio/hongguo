package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BSPugcSubscribeService extends IService {
    public static final a Companion;
    public static final BSPugcSubscribeService IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598962);
            a = new a();
        }

        private a() {
        }
    }

    boolean isSupportPUgcSubscribe();

    static {
        Covode.recordClassIndex(598961);
        Companion = a.a;
        IMPL = (BSPugcSubscribeService) ServiceManager.getService(BSPugcSubscribeService.class);
    }
}
