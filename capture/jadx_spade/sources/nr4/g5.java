package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g5 implements e5 {
    public static final int b;
    private final e5 a;

    static {
        Covode.recordClassIndex(611806);
        b = 8;
    }

    @Override // nr4.e5
    public List<tu4.a> f() {
        try {
            return this.a.f();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public g5(e5 iLikeDao) {
        Intrinsics.checkNotNullParameter(iLikeDao, "iLikeDao");
        this.a = iLikeDao;
    }

    @Override // nr4.e5
    public void a(String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        this.a.a(vid);
    }

    @Override // nr4.e5
    public void c(tu4.a videoLike) {
        Intrinsics.checkNotNullParameter(videoLike, "videoLike");
        this.a.c(videoLike);
    }

    @Override // nr4.e5
    public List<tu4.a> d(List<String> seriesIdList) {
        Intrinsics.checkNotNullParameter(seriesIdList, "seriesIdList");
        return this.a.d(seriesIdList);
    }

    @Override // nr4.e5
    public tu4.a g(String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        return this.a.g(vid);
    }

    @Override // nr4.e5
    public void b(List<tu4.a> likeList) {
        Intrinsics.checkNotNullParameter(likeList, "likeList");
        for (List<tu4.a> list : com.dragon.read.local.db.e.a(likeList)) {
            e5 e5Var = this.a;
            Intrinsics.checkNotNull(list);
            e5Var.b(list);
        }
    }

    @Override // nr4.e5
    public void e(List<tu4.a> videoLikeList) {
        Intrinsics.checkNotNullParameter(videoLikeList, "videoLikeList");
        try {
            for (List<tu4.a> list : com.dragon.read.local.db.e.a(videoLikeList)) {
                e5 e5Var = this.a;
                Intrinsics.checkNotNull(list);
                e5Var.e(list);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            String message = th.getMessage();
            if (message == null) {
                message = "message is null";
            }
            LogWrapper.error("IVideoSeriesLikeImpl:insertOrReplaceLikeList", message, new Object[0]);
            com.dragon.read.base.depend.g.b.c(th, "IVideoSeriesLikeImpl");
        }
    }
}
