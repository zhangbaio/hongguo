package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.BsMineWorksServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BsMineWorksService__ServiceProxy implements IServiceProxy<BsMineWorksService> {
    static {
        Covode.recordClassIndex(598983);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BsMineWorksService m24newInstance() {
        return new BsMineWorksServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BsMineWorksService", "com.dragon.read.component.shortvideo.BsMineWorksServiceImpl");
    }
}
