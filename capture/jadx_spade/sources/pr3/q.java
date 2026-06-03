package pr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.model.VideoHighlightModelType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public boolean a;
    public final long b;
    public final String c;
    public final int d;
    public final String e;
    public final long f;
    public final VideoHighlightModelType g;
    public boolean h;

    static {
        Covode.recordClassIndex(598809);
    }

    public q(boolean z, long j, String seriesId, int i, String vid, long j2, VideoHighlightModelType highlightType) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(highlightType, "highlightType");
        this.a = z;
        this.b = j;
        this.c = seriesId;
        this.d = i;
        this.e = vid;
        this.f = j2;
        this.g = highlightType;
    }
}
