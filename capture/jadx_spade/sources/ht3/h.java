package ht3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.pages.video.model.SeriesPostModel;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final int d;
    public final String a;
    public final SeriesPostModel b;
    public final boolean c;

    static {
        Covode.recordClassIndex(599220);
        d = SeriesPostModel.$stable;
    }

    public h(String fromScene, SeriesPostModel seriesPostModel, boolean z) {
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        Intrinsics.checkNotNullParameter(seriesPostModel, "seriesPostModel");
        this.a = fromScene;
        this.b = seriesPostModel;
        this.c = z;
        LogWrapper.info("PostCollectStatusChangeEvent", "construct event: fromScene:" + fromScene + ", title:" + seriesPostModel.getPostTitle() + ", isCollect:" + z, new Object[0]);
    }
}
