package ws3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final r a;
    private static final uq3.a b;

    private r() {
    }

    public final boolean c() {
        return b.d2();
    }

    static {
        Covode.recordClassIndex(599170);
        a = new r();
        b = (uq3.a) ShortSeriesApi.Companion.c().getDocker().d(uq3.a.class);
    }

    public final void b(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        b.p4(seriesId);
    }

    public final ts3.d d(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return b.O(seriesId);
    }

    public final ts3.d e(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return b.L(seriesId);
    }

    public final List<ts3.d> f(List<String> seriesIdList) {
        Intrinsics.checkNotNullParameter(seriesIdList, "seriesIdList");
        return b.L3(seriesIdList);
    }

    public final Map<String, ts3.d> g(List<String> seriesIdList) {
        Intrinsics.checkNotNullParameter(seriesIdList, "seriesIdList");
        return b.Z1(seriesIdList);
    }

    public final void a(String str, String str2) {
        b.E(str, str2);
    }

    public final void h(String str, String str2, int i, int i2) {
        b.q4(str, str2, i, i2);
    }

    public static /* synthetic */ void i(r rVar, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 2;
        }
        rVar.h(str, str2, i, i2);
    }
}
