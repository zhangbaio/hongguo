package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.pictext.SeriesPostImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesPostApi__ServiceProxy implements IServiceProxy<SeriesPostApi> {
    static {
        Covode.recordClassIndex(598184);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public SeriesPostApi m11newInstance() {
        return new SeriesPostImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.SeriesPostApi", "com.dragon.read.component.shortvideo.pictext.SeriesPostImpl");
    }
}
