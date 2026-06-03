package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.star_fans.BsStarFansServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BsStarFansService__ServiceProxy implements IServiceProxy<BsStarFansService> {
    static {
        Covode.recordClassIndex(598992);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BsStarFansService m27newInstance() {
        return new BsStarFansServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BsStarFansService", "com.dragon.read.component.shortvideo.star_fans.BsStarFansServiceImpl");
    }
}
