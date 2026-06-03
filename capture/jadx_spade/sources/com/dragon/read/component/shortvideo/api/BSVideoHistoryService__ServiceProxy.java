package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGVideoHistoryServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BSVideoHistoryService__ServiceProxy implements IServiceProxy<BSVideoHistoryService> {
    static {
        Covode.recordClassIndex(598111);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BSVideoHistoryService m4newInstance() {
        return new HGVideoHistoryServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.BSVideoHistoryService", "com.dragon.read.component.shortvideo.impl.HGVideoHistoryServiceImpl");
    }
}
