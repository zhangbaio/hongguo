package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class n {
    public static final a h;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    static {
        Covode.recordClassIndex(658836);
        h = new a(null);
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.a + '-' + this.b + '-' + this.c + ' ' + this.d + ':' + this.e + ':' + this.f + '.' + this.g + ')';
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658837);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a(Instant instant) {
            long j;
            Intrinsics.checkNotNullParameter(instant, "instant");
            long epochSeconds = instant.getEpochSeconds();
            long j2 = epochSeconds / 86400;
            if ((epochSeconds ^ 86400) < 0 && j2 * 86400 != epochSeconds) {
                j2--;
            }
            long j3 = epochSeconds % 86400;
            int i = (int) (j3 + (86400 & (((j3 ^ 86400) & ((-j3) | j3)) >> 63)));
            long j4 = (j2 + 719528) - 60;
            if (j4 < 0) {
                long j5 = 146097;
                long j6 = ((j4 + 1) / j5) - 1;
                j = 400 * j6;
                j4 += (-j6) * j5;
            } else {
                j = 0;
            }
            long j7 = 400;
            long j8 = ((j7 * j4) + 591) / 146097;
            long j9 = 365;
            long j10 = 4;
            long j11 = 100;
            long j12 = j4 - ((((j9 * j8) + (j8 / j10)) - (j8 / j11)) + (j8 / j7));
            if (j12 < 0) {
                j8--;
                j12 = j4 - ((((j9 * j8) + (j8 / j10)) - (j8 / j11)) + (j8 / j7));
            }
            int i2 = (int) j12;
            int i3 = ((i2 * 5) + 2) / 153;
            int i4 = (i2 - (((i3 * 306) + 5) / 10)) + 1;
            int i5 = i / 3600;
            int i6 = i - (i5 * 3600);
            int i7 = i6 / 60;
            return new n((int) (j8 + j + (i3 / 10)), ((i3 + 2) % 12) + 1, i4, i5, i7, i6 - (i7 * 60), instant.getNanosecondsOfSecond());
        }
    }

    public n(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
    }
}
