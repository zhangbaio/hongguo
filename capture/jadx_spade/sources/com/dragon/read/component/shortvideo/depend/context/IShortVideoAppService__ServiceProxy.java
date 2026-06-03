package com.dragon.read.component.shortvideo.depend.context;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.saas.impl.ShortVideoSaaSAppImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IShortVideoAppService__ServiceProxy implements IServiceProxy<IShortVideoAppService> {
    static {
        Covode.recordClassIndex(599178);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public IShortVideoAppService m31newInstance() {
        return new ShortVideoSaaSAppImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.depend.context.IShortVideoAppService", "com.dragon.read.component.shortvideo.saas.impl.ShortVideoSaaSAppImpl");
    }
}
