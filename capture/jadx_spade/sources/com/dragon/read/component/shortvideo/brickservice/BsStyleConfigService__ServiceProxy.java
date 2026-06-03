package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGStyleConfigServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BsStyleConfigService__ServiceProxy implements IServiceProxy<BsStyleConfigService> {
    static {
        Covode.recordClassIndex(598996);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BsStyleConfigService m28newInstance() {
        return new HGStyleConfigServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BsStyleConfigService", "com.dragon.read.component.shortvideo.impl.HGStyleConfigServiceImpl");
    }
}
