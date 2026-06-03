package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.impl.moredialog.ShortSeriesMorePanelDialogV2;
import com.dragon.read.recyler.RecyclerClient;
import com.dragon.read.rpc.model.SecondaryInfo;
import java.util.ArrayList;
import rq3.g;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import tx3.e0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BSSeriesPanel extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598965);
        Companion = a.a;
    }

    boolean getPanelShareExposeEnable(boolean z);

    Args getSecondaryCategoryClickParams(SecondaryInfo secondaryInfo);

    void insertDanmakuOption(int i, ArrayList<e0> arrayList, RecyclerClient recyclerClient, ArrayList<e0> arrayList2, RecyclerClient recyclerClient2, ShortSeriesMorePanelDialogV2.c cVar);

    void removeDanmakuOption(ArrayList<e0> arrayList, RecyclerClient recyclerClient, ArrayList<e0> arrayList2, RecyclerClient recyclerClient2);

    void tryAddCommentActionInIndependentTab(ArrayList<e0> arrayList);

    void tryAddDanmakuAction(ArrayList<e0> arrayList, ArrayList<e0> arrayList2, String str, VideoContentType videoContentType, int i);

    void tryAddDownloadAction(ArrayList<e0> arrayList, ArrayList<e0> arrayList2, g gVar, VideoContentType videoContentType);

    public static final class a {
        static final /* synthetic */ a a;
        private static final BSSeriesPanel b;

        private a() {
        }

        public final BSSeriesPanel a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598966);
            a = new a();
            b = (BSSeriesPanel) ServiceManager.getService(BSSeriesPanel.class);
        }
    }
}
