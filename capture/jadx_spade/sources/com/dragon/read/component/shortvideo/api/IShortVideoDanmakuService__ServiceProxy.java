package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.ShortVideoDanmakuImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IShortVideoDanmakuService__ServiceProxy implements IServiceProxy<IShortVideoDanmakuService> {
    static {
        Covode.recordClassIndex(598144);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public IShortVideoDanmakuService m6newInstance() {
        return new ShortVideoDanmakuImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.IShortVideoDanmakuService", "com.dragon.read.component.shortvideo.impl.ShortVideoDanmakuImpl");
    }
}
