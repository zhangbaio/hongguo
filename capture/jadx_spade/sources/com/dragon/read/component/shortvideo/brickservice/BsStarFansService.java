package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsStarFansService extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598990);
        Companion = a.a;
    }

    void initTaskTriggerReceiverCenter();

    void onPlayerActivityCreate();

    public static final class a {
        static final /* synthetic */ a a;
        private static final BsStarFansService b;

        private a() {
        }

        public final BsStarFansService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598991);
            a = new a();
            b = (BsStarFansService) ServiceManager.getService(BsStarFansService.class);
        }
    }
}
