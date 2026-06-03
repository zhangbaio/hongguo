package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.saas.ugc.model.UgcActionType;
import io.reactivex.Single;
import java.util.List;
import l34.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsSeriesPostService extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598987);
        Companion = a.a;
    }

    boolean canShowSeriesPostTabInCollect();

    Single<Boolean> diggPicTextLike(String str, boolean z, String str2);

    Single<d> doPostAction(String str, UgcActionType ugcActionType, Boolean bool);

    List<String> getSeriesPostPreloadFontList();

    void onBookMallTabListLoaded(List<Integer> list);

    void setHasCreateSeriesPost(boolean z);

    public static final class a {
        static final /* synthetic */ a a;
        private static final BsSeriesPostService b;

        private a() {
        }

        public final BsSeriesPostService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598988);
            a = new a();
            b = (BsSeriesPostService) ServiceManager.getService(BsSeriesPostService.class);
        }
    }
}
