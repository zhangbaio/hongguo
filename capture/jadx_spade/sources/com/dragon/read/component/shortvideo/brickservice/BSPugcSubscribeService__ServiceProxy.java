package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.FQPugcSubscribeServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BSPugcSubscribeService__ServiceProxy implements IServiceProxy<BSPugcSubscribeService> {
    static {
        Covode.recordClassIndex(598964);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BSPugcSubscribeService m19newInstance() {
        return new FQPugcSubscribeServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BSPugcSubscribeService", "com.dragon.read.component.shortvideo.impl.FQPugcSubscribeServiceImpl");
    }
}
