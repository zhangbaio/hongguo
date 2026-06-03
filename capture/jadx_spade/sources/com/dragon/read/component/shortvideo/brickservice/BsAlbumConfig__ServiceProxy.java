package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGAlbumConfigServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BsAlbumConfig__ServiceProxy implements IServiceProxy<BsAlbumConfig> {
    static {
        Covode.recordClassIndex(598977);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BsAlbumConfig m22newInstance() {
        return new HGAlbumConfigServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig", "com.dragon.read.component.shortvideo.impl.HGAlbumConfigServiceImpl");
    }
}
