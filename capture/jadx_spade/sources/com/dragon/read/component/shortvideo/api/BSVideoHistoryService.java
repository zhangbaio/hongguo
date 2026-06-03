package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BSVideoHistoryService extends IService {
    public static final a Companion;
    public static final BSVideoHistoryService IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598110);
            a = new a();
        }

        private a() {
        }
    }

    void insertAlbumPugcVideoRecordOnPause(ar3.j jVar);

    void insertAlbumPugcVideoRecordOnPlay(ar3.j jVar, boolean z);

    boolean isSinglePugcVideo(ar3.j jVar);

    static {
        Covode.recordClassIndex(598109);
        Companion = a.a;
        BSVideoHistoryService bSVideoHistoryService = (BSVideoHistoryService) ServiceManager.getService(BSVideoHistoryService.class);
        if (bSVideoHistoryService == null) {
            bSVideoHistoryService = new BSVideoHistoryService() { // from class: com.dragon.read.component.shortvideo.api.BSVideoHistoryService$Companion$IMPL$1
                @Override // com.dragon.read.component.shortvideo.api.BSVideoHistoryService
                public void insertAlbumPugcVideoRecordOnPause(ar3.j holderDataProvider) {
                    Intrinsics.checkNotNullParameter(holderDataProvider, "holderDataProvider");
                }

                @Override // com.dragon.read.component.shortvideo.api.BSVideoHistoryService
                public void insertAlbumPugcVideoRecordOnPlay(ar3.j holderDataProvider, boolean z) {
                    Intrinsics.checkNotNullParameter(holderDataProvider, "holderDataProvider");
                }

                @Override // com.dragon.read.component.shortvideo.api.BSVideoHistoryService
                public boolean isSinglePugcVideo(ar3.j jVar) {
                    return false;
                }
            };
        }
        IMPL = bSVideoHistoryService;
    }
}
