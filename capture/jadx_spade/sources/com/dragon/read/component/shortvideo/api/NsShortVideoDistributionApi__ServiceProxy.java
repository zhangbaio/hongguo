package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.shortvideo.component.shortvideo.impl.NsShortVideoDistributionImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NsShortVideoDistributionApi__ServiceProxy implements IServiceProxy<NsShortVideoDistributionApi> {
    static {
        Covode.recordClassIndex(598171);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public NsShortVideoDistributionApi m9newInstance() {
        return new NsShortVideoDistributionImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.NsShortVideoDistributionApi", "com.dragon.read.shortvideo.component.shortvideo.impl.NsShortVideoDistributionImpl");
    }
}
