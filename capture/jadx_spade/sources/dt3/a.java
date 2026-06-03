package dt3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.video.d;
import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    Observable<C0147a> a(b bVar);

    /* renamed from: dt3.a$a, reason: collision with other inner class name */
    public static final class C0147a {
        public final boolean a;
        public List<? extends d> b;
        public String c;
        public Integer d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public Boolean j = Boolean.FALSE;
        public SaaSVideoBottomBar k;
        public List<? extends SecondaryInfo> l;

        static {
            Covode.recordClassIndex(599196);
        }

        public C0147a(boolean z) {
            this.a = z;
        }
    }

    public static final class b {
        public final long a;
        public final int b;
        public final String c;
        public final Integer d;
        public final Boolean e;
        public final boolean f;
        public final boolean g;

        static {
            Covode.recordClassIndex(599197);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d) && Intrinsics.areEqual(this.e, bVar.e) && this.f == bVar.f && this.g == bVar.g;
        }

        public int hashCode() {
            int a = ((j.a(this.a) * 31) + this.b) * 31;
            String str = this.c;
            int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.d;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Boolean bool = this.e;
            return ((((hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31) + m.a(this.f)) * 31) + m.a(this.g);
        }

        public String toString() {
            return "RequestRecommendInPossibleLostItemParams(currentSeriesId=" + this.a + ", requestType=" + this.b + ", chapterEndStrategy=" + this.c + ", tabType=" + this.d + ", fromSingleSeries=" + this.e + ", isFirstLoad=" + this.f + ", needSeriesFilter=" + this.g + ')';
        }

        public b(long j, int i, String str, Integer num, Boolean bool, boolean z, boolean z2) {
            this.a = j;
            this.b = i;
            this.c = str;
            this.d = num;
            this.e = bool;
            this.f = z;
            this.g = z2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ b(long r12, int r14, java.lang.String r15, java.lang.Integer r16, java.lang.Boolean r17, boolean r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r11 = this;
                r0 = r20 & 4
                r1 = 0
                if (r0 == 0) goto L7
                r6 = r1
                goto L8
            L7:
                r6 = r15
            L8:
                r0 = r20 & 8
                if (r0 == 0) goto Le
                r7 = r1
                goto L10
            Le:
                r7 = r16
            L10:
                r0 = r20 & 16
                if (r0 == 0) goto L16
                r8 = r1
                goto L18
            L16:
                r8 = r17
            L18:
                r0 = r20 & 32
                r1 = 0
                if (r0 == 0) goto L1f
                r9 = 0
                goto L21
            L1f:
                r9 = r18
            L21:
                r0 = r20 & 64
                if (r0 == 0) goto L27
                r10 = 0
                goto L29
            L27:
                r10 = r19
            L29:
                r2 = r11
                r3 = r12
                r5 = r14
                r2.<init>(r3, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dt3.a.b.<init>(long, int, java.lang.String, java.lang.Integer, java.lang.Boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
