package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.homepage.impl.ShowSeriesDistributeImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortSeriesDistributeApi__ServiceProxy implements IServiceProxy<ShortSeriesDistributeApi> {
    static {
        Covode.recordClassIndex(598191);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public ShortSeriesDistributeApi m13newInstance() {
        return new ShowSeriesDistributeImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi", "com.dragon.read.component.shortvideo.homepage.impl.ShowSeriesDistributeImpl");
    }
}
