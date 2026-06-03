package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.video.BSVideoCollModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c5 implements b5 {
    public static final int b;
    private final b5 a;

    static {
        Covode.recordClassIndex(611802);
        b = 8;
    }

    @Override // nr4.b5
    public List<lr4.t1> a() {
        return this.a.a();
    }

    @Override // nr4.b5
    public lr4.s1 b() {
        return this.a.b();
    }

    @Override // nr4.b5
    public List<lr4.t1> d() {
        return this.a.d();
    }

    @Override // nr4.b5
    public List<BSVideoCollModel> g() {
        return this.a.g();
    }

    @Override // nr4.b5
    public List<lr4.s1> k() {
        return this.a.k();
    }

    public c5(b5 iVideoDao) {
        Intrinsics.checkNotNullParameter(iVideoDao, "iVideoDao");
        this.a = iVideoDao;
    }

    @Override // nr4.b5
    public lr4.t1 c(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return this.a.c(seriesId);
    }

    @Override // nr4.b5
    public void e(lr4.t1 videoProgress) {
        Intrinsics.checkNotNullParameter(videoProgress, "videoProgress");
        this.a.e(videoProgress);
    }

    @Override // nr4.b5
    public void f(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        this.a.f(seriesId);
    }

    @Override // nr4.b5
    public lr4.s1 h(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return this.a.h(seriesId);
    }

    @Override // nr4.b5
    public void i(List<String> seriesIds) {
        Intrinsics.checkNotNullParameter(seriesIds, "seriesIds");
        for (List<String> list : com.dragon.read.local.db.e.a(seriesIds)) {
            b5 b5Var = this.a;
            Intrinsics.checkNotNull(list);
            b5Var.i(list);
        }
    }

    @Override // nr4.b5
    public void j(List<lr4.t1> videoProgressList) {
        Intrinsics.checkNotNullParameter(videoProgressList, "videoProgressList");
        for (List<lr4.t1> list : com.dragon.read.local.db.e.a(videoProgressList)) {
            b5 b5Var = this.a;
            Intrinsics.checkNotNull(list);
            b5Var.j(list);
        }
    }

    @Override // nr4.b5
    public void l(List<lr4.s1> videoCollection) {
        Intrinsics.checkNotNullParameter(videoCollection, "videoCollection");
        List<List<lr4.s1>> a = com.dragon.read.local.db.e.a(videoCollection);
        new ArrayList();
        for (List<lr4.s1> list : a) {
            b5 b5Var = this.a;
            Intrinsics.checkNotNull(list);
            b5Var.l(list);
        }
    }
}
