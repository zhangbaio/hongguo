package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGConfigServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BSConfigService__ServiceProxy implements IServiceProxy<BSConfigService> {
    static {
        Covode.recordClassIndex(598960);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BSConfigService m18newInstance() {
        return new HGConfigServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BSConfigService", "com.dragon.read.component.shortvideo.impl.HGConfigServiceImpl");
    }
}
