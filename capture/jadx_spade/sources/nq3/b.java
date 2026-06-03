package nq3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesRelativeCellModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    Observable<List<ShortSeriesRelativeCellModel>> a(a aVar);

    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final boolean e;
        public final String f;

        static {
            Covode.recordClassIndex(598214);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && Intrinsics.areEqual(this.f, aVar.f);
        }

        public int hashCode() {
            return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + m.a(this.d)) * 31) + m.a(this.e)) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "PlanRequestParams(bookId=" + this.a + ", source=" + this.b + ", scene=" + this.c + ", isFirstOpen=" + this.d + ", isEndOfSeries=" + this.e + ", filterIds=" + this.f + ')';
        }

        public a(String bookId, String source, int i, boolean z, boolean z2, String filterIds) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(filterIds, "filterIds");
            this.a = bookId;
            this.b = source;
            this.c = i;
            this.d = z;
            this.e = z2;
            this.f = filterIds;
        }
    }
}
