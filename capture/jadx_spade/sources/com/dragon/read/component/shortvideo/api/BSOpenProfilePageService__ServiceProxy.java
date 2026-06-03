package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGOpenProfilePageServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BSOpenProfilePageService__ServiceProxy implements IServiceProxy<BSOpenProfilePageService> {
    static {
        Covode.recordClassIndex(598108);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BSOpenProfilePageService m3newInstance() {
        return new HGOpenProfilePageServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.BSOpenProfilePageService", "com.dragon.read.component.shortvideo.impl.HGOpenProfilePageServiceImpl");
    }
}
