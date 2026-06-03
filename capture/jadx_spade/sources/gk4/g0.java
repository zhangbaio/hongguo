package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 implements f {
    public static final int g;
    public final int a;
    public final String b;
    public final String c;
    private final long d;
    public final ym4.s e;
    public int f;

    static {
        Covode.recordClassIndex(607826);
        g = 8;
    }

    @Override // gk4.f
    public long a() {
        return this.d;
    }

    public g0(int i, String seriesId, String vid, long j, ym4.s videoReportArgs) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(videoReportArgs, "videoReportArgs");
        this.a = i;
        this.b = seriesId;
        this.c = vid;
        this.d = j;
        this.e = videoReportArgs;
    }
}
