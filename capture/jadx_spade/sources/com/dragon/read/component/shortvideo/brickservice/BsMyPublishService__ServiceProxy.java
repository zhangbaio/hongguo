package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.BsMyPublishServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BsMyPublishService__ServiceProxy implements IServiceProxy<BsMyPublishService> {
    static {
        Covode.recordClassIndex(598986);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BsMyPublishService m25newInstance() {
        return new BsMyPublishServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BsMyPublishService", "com.dragon.read.component.shortvideo.BsMyPublishServiceImpl");
    }
}
