package pr3;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoModel;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public final VideoModel a;
    public final int b;
    public final int c;
    public final long d;
    public final boolean e;
    public final String f;
    public final String g;
    public final int h;
    public boolean i;
    public long j;
    public boolean k;
    public String l;
    public boolean m;
    public boolean n;

    static {
        Covode.recordClassIndex(598816);
    }

    public final void a() {
        this.n = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.a, rVar.a) && this.b == rVar.b && this.c == rVar.c && this.d == rVar.d && this.e == rVar.e && Intrinsics.areEqual(this.f, rVar.f) && Intrinsics.areEqual(this.g, rVar.g) && this.h == rVar.h && this.i == rVar.i;
    }

    public int hashCode() {
        VideoModel videoModel = this.a;
        return ((((((((((((((((videoModel == null ? 0 : videoModel.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + j.a(this.d)) * 31) + androidx.compose.animation.m.a(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h) * 31) + androidx.compose.animation.m.a(this.i);
    }

    public String toString() {
        return "VideoModelInfo(videoModel=" + this.a + ", videoWidth=" + this.b + ", videoHeight=" + this.c + ", expireTime=" + this.d + ", isTrialVideo=" + this.e + ", seriesId=" + this.f + ", videoId=" + this.g + ", contentType=" + this.h + ", disableVsr=" + this.i + ')';
    }

    public r(VideoModel videoModel, int i, int i2, long j, boolean z, String seriesId, String videoId, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.a = videoModel;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = z;
        this.f = seriesId;
        this.g = videoId;
        this.h = i3;
        this.i = z2;
    }
}
