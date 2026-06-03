package com.dragon.read.component.shortvideo.api.constant;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.base.BaseModelDependImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IBaseModelDependApi__ServiceProxy implements IServiceProxy<IBaseModelDependApi> {
    static {
        Covode.recordClassIndex(598606);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public IBaseModelDependApi m15newInstance() {
        return new BaseModelDependImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.api.constant.IBaseModelDependApi", "com.dragon.read.component.shortvideo.impl.base.BaseModelDependImpl");
    }
}
