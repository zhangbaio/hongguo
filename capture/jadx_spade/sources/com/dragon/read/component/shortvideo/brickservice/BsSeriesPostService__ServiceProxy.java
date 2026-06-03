package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.BsSeriesPostServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BsSeriesPostService__ServiceProxy implements IServiceProxy<BsSeriesPostService> {
    static {
        Covode.recordClassIndex(598989);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BsSeriesPostService m26newInstance() {
        return new BsSeriesPostServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService", "com.dragon.read.component.shortvideo.BsSeriesPostServiceImpl");
    }
}
