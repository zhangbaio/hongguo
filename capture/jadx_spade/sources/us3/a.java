package us3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final List<SaasVideoData> a;
    public final int b;
    public final boolean c;

    static {
        Covode.recordClassIndex(599089);
    }

    public a() {
        this(null, 0, false, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c;
    }

    public int hashCode() {
        List<SaasVideoData> list = this.a;
        return ((((list == null ? 0 : list.hashCode()) * 31) + this.b) * 31) + m.a(this.c);
    }

    public String toString() {
        return "SaasCelebrityWorksInfo(videoList=" + this.a + ", totalCount=" + this.b + ", hasMore=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends SaasVideoData> list, int i, boolean z) {
        this.a = list;
        this.b = i;
        this.c = z;
    }

    public /* synthetic */ a(List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z);
    }
}
