package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.saas.ShortSeriesImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortSeriesApi__ServiceProxy implements IServiceProxy<ShortSeriesApi> {
    static {
        Covode.recordClassIndex(598187);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public ShortSeriesApi m12newInstance() {
        return new ShortSeriesImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.ShortSeriesApi", "com.dragon.read.component.shortvideo.saas.ShortSeriesImpl");
    }
}
