package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsVideoPendantService extends IService {
    public static final a Companion;
    public static final BsVideoPendantService IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598998);
            a = new a();
        }

        private a() {
        }
    }

    boolean isOpt();

    static {
        Covode.recordClassIndex(598997);
        Companion = a.a;
        IMPL = (BsVideoPendantService) ServiceManager.getService(BsVideoPendantService.class);
    }
}
