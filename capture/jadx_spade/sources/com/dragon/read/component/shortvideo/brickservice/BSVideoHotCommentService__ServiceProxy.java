package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IServiceProxy;
import com.dragon.read.component.shortvideo.impl.HGVideoHotCommentServiceImpl;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BSVideoHotCommentService__ServiceProxy implements IServiceProxy<BSVideoHotCommentService> {
    static {
        Covode.recordClassIndex(598970);
    }

    /* renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    public BSVideoHotCommentService m21newInstance() {
        return new HGVideoHotCommentServiceImpl();
    }

    public void collectService(Map<String, String> map) {
        map.put("com.dragon.read.component.shortvideo.brickservice.BSVideoHotCommentService", "com.dragon.read.component.shortvideo.impl.HGVideoHotCommentServiceImpl");
    }
}
