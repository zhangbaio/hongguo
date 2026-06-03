package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsCollectService extends IService {
    public static final a Companion;
    public static final BsCollectService IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598979);
            a = new a();
        }

        private a() {
        }
    }

    boolean showFirstCollectToastText();

    static {
        Covode.recordClassIndex(598978);
        Companion = a.a;
        Object service = ServiceManager.getService(BsCollectService.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (BsCollectService) service;
    }
}
