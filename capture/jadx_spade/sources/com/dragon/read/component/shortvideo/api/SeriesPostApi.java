package com.dragon.read.component.shortvideo.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.report.PageRecorder;
import java.util.List;
import kotlin.Pair;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface SeriesPostApi extends IService {
    public static final a Companion;
    public static final SeriesPostApi IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598183);
            a = new a();
        }

        private a() {
        }
    }

    boolean canShowSeriesPostTabInCollect();

    boolean canShowSeriesPostTabInDigg();

    boolean enablePostTitleParseHtml();

    boolean enablePreloadDetailAllScene();

    boolean enableSeriesPostCache();

    boolean enableSeriesPostTopic();

    void fetchSeriesPostData(List<String> list);

    void fetchSeriesPostDataDelay(List<String> list, long j);

    void fetchSeriesPostTopicAb();

    int getMaxTopicCnt();

    boolean handleSeriesPostTopicDetailSchema(com.bytedance.router.c cVar);

    boolean isPicTextDetailActivity(Activity activity);

    void markHasCollectSeriesPost(boolean z);

    void markHasDiggSeriesPost(boolean z);

    void openSeriesPostDetailWithAnim(Context context, String str, String str2, PageRecorder pageRecorder, View view, View view2, Pair<Integer, Integer> pair);

    void preloadSeriesPostDetailLayout();

    void prepareTopicDetailAnim(Context context, View view, boolean z, float f);

    void startSeriesPostSpeedIn();

    void tryPreloadFirstImg(List<String> list);

    static {
        Covode.recordClassIndex(598182);
        Companion = a.a;
        IMPL = (SeriesPostApi) ServiceManager.getService(SeriesPostApi.class);
    }
}
