package ws3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.bookmall.holder.video.model.VideoTabFirstRespData;
import com.dragon.read.component.shortvideo.depend.ShortVideoRespState;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final int d;
    private final VideoTabFirstRespData a;
    public final List<VideoTabModel> b;
    public ShortVideoRespState c;

    static {
        Covode.recordClassIndex(599164);
        d = 8;
    }

    public final String a() {
        return this.a.a();
    }

    public String toString() {
        return "ShortVideoFeedFirstRespData(size=" + this.b.size() + ')';
    }

    public final void c(ShortVideoRespState respState) {
        Intrinsics.checkNotNullParameter(respState, "respState");
        this.c = respState;
    }

    public final void b(List<? extends VideoTabModel> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.b.clear();
        this.b.addAll(dataList);
    }

    public n(VideoTabFirstRespData respData) {
        Intrinsics.checkNotNullParameter(respData, "respData");
        this.a = respData;
        this.b = new ArrayList();
        this.c = ShortVideoRespState.DEFAULT;
    }
}
