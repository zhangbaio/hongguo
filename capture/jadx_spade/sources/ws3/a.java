package ws3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(599147);
        a = new a();
    }

    private a() {
    }

    public static final a a() {
        return a;
    }

    public final long b(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return o44.q.d.A1(seriesId);
    }

    public final long c(String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return o44.q.d.W1(videoId);
    }

    public final long d(String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return o44.q.d.E1(videoId);
    }

    public final void e(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        o44.q.d.h1(seriesId);
    }

    public final void f(String str, long j) {
        o44.q.d.N4(str, j);
    }

    public final void g(String seriesId, long j, long j2) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        o44.q.d.l2(seriesId, j, j2);
    }
}
