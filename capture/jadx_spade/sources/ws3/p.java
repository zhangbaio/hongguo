package ws3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.bookmall.holder.video.model.VideoTabLoadMoreRespData;
import com.dragon.read.component.shortvideo.depend.ShortVideoRespState;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import com.dragon.read.rpc.model.ClientReqType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public static final int f;
    private final VideoTabLoadMoreRespData a;
    public final List<VideoTabModel> b;
    public ShortVideoRespState c;
    public ClientReqType d;
    public int e;

    static {
        Covode.recordClassIndex(599166);
        f = 8;
    }

    public final String a() {
        return this.a.d.e;
    }

    public String toString() {
        return "ShortVideoFeedFirstRespData(size=" + this.b.size() + " reqType=" + this.d + ')';
    }

    public final void c(ClientReqType clientReqType) {
        Intrinsics.checkNotNullParameter(clientReqType, "clientReqType");
        this.d = clientReqType;
    }

    public final void d(ShortVideoRespState respState) {
        Intrinsics.checkNotNullParameter(respState, "respState");
        this.c = respState;
    }

    public final void b(List<? extends VideoTabModel> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.b.clear();
        this.b.addAll(dataList);
    }

    public p(VideoTabLoadMoreRespData respData) {
        Intrinsics.checkNotNullParameter(respData, "respData");
        this.a = respData;
        this.b = new ArrayList();
        this.c = ShortVideoRespState.DEFAULT;
        this.d = ClientReqType.Open;
        this.e = -1;
    }
}
