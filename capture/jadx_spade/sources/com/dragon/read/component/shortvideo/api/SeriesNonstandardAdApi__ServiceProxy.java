package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.nonstandard.ad.adapter.NonstandardAdApiImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesNonstandardAdApi__ServiceProxy implements IServiceProxy<SeriesNonstandardAdApi> {
    static {
        Covode.recordClassIndex(598181);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public SeriesNonstandardAdApi m10newInstance() {
        return new NonstandardAdApiImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.SeriesNonstandardAdApi", "com.dragon.read.nonstandard.ad.adapter.NonstandardAdApiImpl");
    }
}
