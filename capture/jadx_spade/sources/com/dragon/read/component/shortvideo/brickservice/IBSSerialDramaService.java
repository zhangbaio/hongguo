package com.dragon.read.component.shortvideo.brickservice;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesRelativeSeriesModel;
import com.dragon.read.component.shortvideo.impl.catalogdialog.view.r;
import com.dragon.read.recyler.RecyclerClient;
import eu3.a;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface IBSSerialDramaService extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598999);
        Companion = a.a;
    }

    boolean enableSerialDramaTab();

    boolean enableTryLoadSingleEpisodeData(VideoContentType videoContentType);

    boolean initRecommendVideo(RecyclerClient recyclerClient, a.c cVar);

    void initSerialPanel(RecyclerClient recyclerClient, RecyclerView recyclerView, r rVar);

    void setPlayBtnRadius(View view);

    void updateRecommend(RecyclerClient recyclerClient, ShortSeriesRelativeSeriesModel shortSeriesRelativeSeriesModel, a.c cVar);

    public static final class a {
        static final /* synthetic */ a a;
        private static final IBSSerialDramaService b;

        private a() {
        }

        public final IBSSerialDramaService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(599000);
            a = new a();
            b = (IBSSerialDramaService) ServiceManager.getService(IBSSerialDramaService.class);
        }
    }
}
