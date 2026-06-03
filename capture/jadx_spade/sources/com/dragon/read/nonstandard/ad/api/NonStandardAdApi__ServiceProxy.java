package com.dragon.read.nonstandard.ad.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.nonstandard.ad.impl.NonStandardAdApiImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NonStandardAdApi__ServiceProxy implements IServiceProxy<NonStandardAdApi> {
    static {
        Covode.recordClassIndex(612491);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public NonStandardAdApi m43newInstance() {
        return new NonStandardAdApiImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.nonstandard.ad.api.NonStandardAdApi", "com.dragon.read.nonstandard.ad.impl.NonStandardAdApiImpl");
    }
}
