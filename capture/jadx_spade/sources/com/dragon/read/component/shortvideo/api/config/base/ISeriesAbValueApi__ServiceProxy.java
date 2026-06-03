package com.dragon.read.component.shortvideo.api.config.base;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.config.ssconfig.SeriesAbValueServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ISeriesAbValueApi__ServiceProxy implements IServiceProxy<ISeriesAbValueApi> {
    static {
        Covode.recordClassIndex(598308);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public ISeriesAbValueApi m14newInstance() {
        return new SeriesAbValueServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi", "com.dragon.read.component.shortvideo.impl.config.ssconfig.SeriesAbValueServiceImpl");
    }
}
