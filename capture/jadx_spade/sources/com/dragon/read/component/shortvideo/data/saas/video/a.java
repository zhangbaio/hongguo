package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.ugc.AlbumDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostDataWrapper;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    static {
        Covode.recordClassIndex(599110);
    }

    public static final boolean e(SaasVideoData saasVideoData) {
        Intrinsics.checkNotNullParameter(saasVideoData, "<this>");
        return saasVideoData instanceof SaaSUgcPostData;
    }

    public static final AlbumDetailModel a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar instanceof SaaSUgcPostDataWrapper) {
            return ((SaaSUgcPostDataWrapper) dVar).getFromDetailModel();
        }
        return null;
    }

    public static final SaasVideoDetailModel b(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar instanceof SaasVideoDataWrapper) {
            return ((SaasVideoDataWrapper) dVar).getFromDetailModel();
        }
        if (dVar instanceof SaaSSeriesUgcPostDataWrapper) {
            return ((SaaSSeriesUgcPostDataWrapper) dVar).getBindDetailModel();
        }
        return null;
    }

    public static final String c(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        SaasVideoDetailModel b = b(dVar);
        if (b != null) {
            return b.getEpisodesId();
        }
        return null;
    }

    public static final SaaSUgcPostData d(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        SaasVideoData videoData = dVar.getVideoData();
        if (videoData instanceof SaaSUgcPostData) {
            return (SaaSUgcPostData) videoData;
        }
        return null;
    }

    public static final List<d> f(SaasVideoDetailModel saasVideoDetailModel, int i) {
        Intrinsics.checkNotNullParameter(saasVideoDetailModel, "<this>");
        ArrayList arrayList = new ArrayList();
        List<SaasVideoData> episodesListWithTrail = saasVideoDetailModel.getEpisodesListWithTrail();
        if (episodesListWithTrail != null) {
            Iterator<T> it2 = episodesListWithTrail.iterator();
            while (it2.hasNext()) {
                arrayList.add(new SaasVideoDataWrapper(saasVideoDetailModel, (SaasVideoData) it2.next(), i));
            }
        }
        return arrayList;
    }
}
