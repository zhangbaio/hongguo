package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsActorInfoService extends IService {
    public static final a Companion;
    public static final BsActorInfoService IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598972);
            a = new a();
        }

        private a() {
        }
    }

    boolean enableActorInfoConfig();

    static {
        Covode.recordClassIndex(598971);
        Companion = a.a;
        IMPL = (BsActorInfoService) ServiceManager.getService(BsActorInfoService.class);
    }
}
