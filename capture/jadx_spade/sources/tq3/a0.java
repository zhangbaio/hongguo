package tq3;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.report.PageRecorder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a0 {
    void a(Context context, String str, PageRecorder pageRecorder);

    public static final class a {
        public final long a;
        public final String b;

        static {
            Covode.recordClassIndex(598649);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            return (j.a(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "GetCelebrityWorksParams(count=" + this.a + ", encryptedCelebrityIds=" + this.b + ')';
        }

        public a(long j, String encryptedCelebrityIds) {
            Intrinsics.checkNotNullParameter(encryptedCelebrityIds, "encryptedCelebrityIds");
            this.a = j;
            this.b = encryptedCelebrityIds;
        }
    }
}
