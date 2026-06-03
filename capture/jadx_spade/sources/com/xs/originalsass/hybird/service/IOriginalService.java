package com.xs.originalsass.hybird.service;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import wl6.a;
import wl6.b;
import wl6.e;
import wl6.g;
import wl6.h;
import wl6.i;
import wl6.j;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IOriginalService extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(656107);
        Companion = a.a;
    }

    void handleAppendVideoWorkList(IBDXBridgeContext iBDXBridgeContext, a.b bVar, CompletionBlock<a.c> completionBlock);

    void handleOpenVideoPlayer(IBDXBridgeContext iBDXBridgeContext, b.InterfaceC0285b interfaceC0285b, CompletionBlock<b.c> completionBlock);

    void handlePreviewVideo(IBDXBridgeContext iBDXBridgeContext, e.b bVar, CompletionBlock<e.c> completionBlock);

    void handlePublishVideoWork(IBDXBridgeContext iBDXBridgeContext, g.b bVar, CompletionBlock<g.c> completionBlock);

    void handleStartUploadVideo(IBDXBridgeContext iBDXBridgeContext, h.b bVar, CompletionBlock<h.c> completionBlock);

    void handleStopUploadVideo(IBDXBridgeContext iBDXBridgeContext, i.b bVar, CompletionBlock<i.c> completionBlock);

    void updateVideoWorkInfo(IBDXBridgeContext iBDXBridgeContext, j.b bVar, CompletionBlock<j.c> completionBlock);

    public static final class a {
        static final /* synthetic */ a a;
        private static final IOriginalService b;

        private a() {
        }

        public final IOriginalService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(656108);
            a = new a();
            b = (IOriginalService) ServiceManager.getService(IOriginalService.class);
        }
    }
}
