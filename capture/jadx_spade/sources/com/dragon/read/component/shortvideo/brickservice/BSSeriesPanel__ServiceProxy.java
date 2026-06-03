package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGSeriesPanelServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BSSeriesPanel__ServiceProxy implements IServiceProxy<BSSeriesPanel> {
    static {
        Covode.recordClassIndex(598967);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BSSeriesPanel m20newInstance() {
        return new HGSeriesPanelServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BSSeriesPanel", "com.dragon.read.component.shortvideo.impl.HGSeriesPanelServiceImpl");
    }
}
