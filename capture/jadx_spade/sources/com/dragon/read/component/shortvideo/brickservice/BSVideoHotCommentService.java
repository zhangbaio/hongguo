package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.impl.infoheader.ShortSeriesInfoHeaderView;
import com.dragon.read.component.shortvideo.impl.infopanel.r0;
import com.dragon.read.social.model.HotCommentInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BSVideoHotCommentService extends IService {
    public static final Companion Companion;

    static {
        Covode.recordClassIndex(598968);
        Companion = Companion.a;
    }

    boolean allowShowHotComment(int i, SaasVideoData saasVideoData);

    void showHotComment(ShortSeriesInfoHeaderView shortSeriesInfoHeaderView, List<HotCommentInfo> list, String str);

    void showHotCommentBelowDesc(r0 r0Var, List<HotCommentInfo> list, String str);

    public static final class Companion {
        static final /* synthetic */ Companion a;
        private static final BSVideoHotCommentService b;

        private Companion() {
        }

        public final BSVideoHotCommentService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598969);
            a = new Companion();
            BSVideoHotCommentService bSVideoHotCommentService = (BSVideoHotCommentService) ServiceManager.getService(BSVideoHotCommentService.class);
            if (bSVideoHotCommentService == null) {
                bSVideoHotCommentService = new BSVideoHotCommentService() { // from class: com.dragon.read.component.shortvideo.brickservice.BSVideoHotCommentService$Companion$IMPL$1
                    @Override // com.dragon.read.component.shortvideo.brickservice.BSVideoHotCommentService
                    public boolean allowShowHotComment(int i, SaasVideoData saasVideoData) {
                        return false;
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BSVideoHotCommentService
                    public void showHotComment(ShortSeriesInfoHeaderView shortSeriesInfoHeaderView, List<HotCommentInfo> hotCommentInfoList, String recommendInfo) {
                        Intrinsics.checkNotNullParameter(hotCommentInfoList, "hotCommentInfoList");
                        Intrinsics.checkNotNullParameter(recommendInfo, "recommendInfo");
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BSVideoHotCommentService
                    public void showHotCommentBelowDesc(r0 r0Var, List<HotCommentInfo> hotCommentInfoList, String recommendInfo) {
                        Intrinsics.checkNotNullParameter(hotCommentInfoList, "hotCommentInfoList");
                        Intrinsics.checkNotNullParameter(recommendInfo, "recommendInfo");
                    }
                };
            }
            b = bSVideoHotCommentService;
        }
    }
}
