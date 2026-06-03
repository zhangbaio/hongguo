package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.NsShortVideoImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NsShortVideoApi__ServiceProxy implements IServiceProxy<NsShortVideoApi> {
    static {
        Covode.recordClassIndex(598164);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public NsShortVideoApi m7newInstance() {
        return new NsShortVideoImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.NsShortVideoApi", "com.dragon.read.component.shortvideo.impl.NsShortVideoImpl");
    }
}
