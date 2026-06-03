package com.dragon.read.component.shortvideo.depend;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.ShortVideoAbsActivityCallbackDepend;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IAbsActivityCallbackDepend__ServiceProxy implements IServiceProxy<IAbsActivityCallbackDepend> {
    static {
        Covode.recordClassIndex(599150);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public IAbsActivityCallbackDepend m30newInstance() {
        return new ShortVideoAbsActivityCallbackDepend();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend", "com.dragon.read.component.shortvideo.ShortVideoAbsActivityCallbackDepend");
    }
}
