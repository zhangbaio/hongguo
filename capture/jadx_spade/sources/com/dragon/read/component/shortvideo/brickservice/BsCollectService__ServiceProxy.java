package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGCollectServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BsCollectService__ServiceProxy implements IServiceProxy<BsCollectService> {
    static {
        Covode.recordClassIndex(598980);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BsCollectService m23newInstance() {
        return new HGCollectServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BsCollectService", "com.dragon.read.component.shortvideo.impl.HGCollectServiceImpl");
    }
}
