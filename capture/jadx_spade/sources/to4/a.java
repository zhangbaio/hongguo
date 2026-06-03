package to4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {

    /* renamed from: to4.a$a, reason: collision with other inner class name */
    public static final class C0273a implements a {
        public static final C0273a a;

        static {
            Covode.recordClassIndex(609118);
            a = new C0273a();
        }

        private C0273a() {
        }
    }

    public static final class b implements a {
        public static final int c;
        public final androidx.compose.foundation.lazy.o a;
        public final int b;

        static {
            Covode.recordClassIndex(609119);
            c = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public String toString() {
            return "MoveItem(dragItemInfo=" + this.a + ", to=" + this.b + ')';
        }

        public b(androidx.compose.foundation.lazy.o dragItemInfo, int i) {
            Intrinsics.checkNotNullParameter(dragItemInfo, "dragItemInfo");
            this.a = dragItemInfo;
            this.b = i;
        }
    }
}
