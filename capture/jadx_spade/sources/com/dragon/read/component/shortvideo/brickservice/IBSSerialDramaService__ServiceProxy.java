package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.BSSerialDramaHgService;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IBSSerialDramaService__ServiceProxy implements IServiceProxy<IBSSerialDramaService> {
    static {
        Covode.recordClassIndex(599001);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public IBSSerialDramaService m29newInstance() {
        return new BSSerialDramaHgService();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.IBSSerialDramaService", "com.dragon.read.component.shortvideo.impl.BSSerialDramaHgService");
    }
}
