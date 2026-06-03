package com.xs.originalsass.hybird.service;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.anniex.bridge.OriginalServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class IOriginalService__ServiceProxy implements IServiceProxy<IOriginalService> {
    static {
        Covode.recordClassIndex(656109);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public IOriginalService m771newInstance() {
        return new OriginalServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.xs.originalsass.hybird.service.IOriginalService", "com.dragon.read.anniex.bridge.OriginalServiceImpl");
    }
}
