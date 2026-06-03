package kotlin.time;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Instant implements Comparable<Instant>, Serializable {
    public static final a Companion;
    private static final Instant MAX;
    private static final Instant MIN;
    private final long epochSeconds;
    private final int nanosecondsOfSecond;

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658817);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Instant d() {
            return Instant.MAX;
        }

        public final Instant e() {
            return Instant.MIN;
        }

        public final Instant a(long j) {
            long j2 = j / 1000;
            if ((j ^ 1000) < 0 && j2 * 1000 != j) {
                j2--;
            }
            long j3 = j % 1000;
            int i = (int) ((j3 + (1000 & (((j3 ^ 1000) & ((-j3) | j3)) >> 63))) * 1000000);
            if (j2 < -31557014167219200L) {
                return e();
            }
            if (j2 > 31556889864403199L) {
                return d();
            }
            return b(j2, i);
        }

        public final Instant b(long j, int i) {
            return c(j, i);
        }

        public final Instant c(long j, long j2) {
            long j3 = j2 / 1000000000;
            if ((j2 ^ 1000000000) < 0 && j3 * 1000000000 != j2) {
                j3--;
            }
            long j4 = j + j3;
            if ((j ^ j4) < 0 && (j3 ^ j) >= 0) {
                a aVar = Instant.Companion;
                if (j > 0) {
                    return aVar.d();
                }
                return aVar.e();
            }
            if (j4 < -31557014167219200L) {
                return e();
            }
            if (j4 > 31556889864403199L) {
                return d();
            }
            long j5 = j2 % 1000000000;
            return new Instant(j4, (int) (j5 + ((((j5 ^ 1000000000) & ((-j5) | j5)) >> 63) & 1000000000)));
        }
    }

    private final Object writeReplace() {
        return i.a(this);
    }

    public String toString() {
        String b;
        b = j.b(this);
        return b;
    }

    public int hashCode() {
        return j.a(this.epochSeconds) + (this.nanosecondsOfSecond * 51);
    }

    static {
        Covode.recordClassIndex(658816);
        Companion = new a(null);
        MIN = new Instant(-31557014167219200L, 0);
        MAX = new Instant(31556889864403199L, 999999999);
    }

    public final long toEpochMilliseconds() {
        long j = this.epochSeconds;
        long j2 = 1000;
        if (j >= 0) {
            if (j != 1) {
                if (j != 0) {
                    long j3 = j * 1000;
                    if (j3 / 1000 != j) {
                        return Long.MAX_VALUE;
                    }
                    int i = (j > Long.MIN_VALUE ? 1 : (j == Long.MIN_VALUE ? 0 : -1));
                    j2 = j3;
                } else {
                    j2 = 0;
                }
            }
            long j4 = this.nanosecondsOfSecond / 1000000;
            long j5 = j2 + j4;
            if ((j2 ^ j5) < 0 && (j4 ^ j2) >= 0) {
                return Long.MAX_VALUE;
            }
            return j5;
        }
        long j6 = j + 1;
        if (j6 != 1) {
            if (j6 != 0) {
                long j7 = j6 * 1000;
                if (j7 / 1000 != j6) {
                    return Long.MIN_VALUE;
                }
                int i2 = (j6 > Long.MIN_VALUE ? 1 : (j6 == Long.MIN_VALUE ? 0 : -1));
                j2 = j7;
            } else {
                j2 = 0;
            }
        }
        long j8 = (this.nanosecondsOfSecond / 1000000) - 1000;
        long j9 = j2 + j8;
        if ((j2 ^ j9) < 0 && (j8 ^ j2) >= 0) {
            return Long.MIN_VALUE;
        }
        return j9;
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final Instant m1034minusLRDsOJo(long j) {
        return m1036plusLRDsOJo(c.V(j));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int compare = Intrinsics.compare(this.epochSeconds, other.epochSeconds);
        if (compare != 0) {
            return compare;
        }
        return Intrinsics.compare(this.nanosecondsOfSecond, other.nanosecondsOfSecond);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Instant) {
                Instant instant = (Instant) obj;
                if (this.epochSeconds != instant.epochSeconds || this.nanosecondsOfSecond != instant.nanosecondsOfSecond) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: minus-UwyO8pc, reason: not valid java name */
    public final long m1035minusUwyO8pc(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        c.a aVar = c.b;
        return c.Q(e.t(this.epochSeconds - other.epochSeconds, DurationUnit.SECONDS), e.s(this.nanosecondsOfSecond - other.nanosecondsOfSecond, DurationUnit.NANOSECONDS));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final Instant m1036plusLRDsOJo(long j) {
        long u = c.u(j);
        int w = c.w(j);
        if (u == 0 && w == 0) {
            return this;
        }
        long j2 = this.epochSeconds;
        long j3 = j2 + u;
        if ((j2 ^ j3) < 0 && (u ^ j2) >= 0) {
            if (c.M(j)) {
                return MAX;
            }
            return MIN;
        }
        return Companion.b(j3, this.nanosecondsOfSecond + w);
    }

    public Instant(long j, int i) {
        this.epochSeconds = j;
        this.nanosecondsOfSecond = i;
        boolean z = false;
        if (-31557014167219200L <= j && j < 31556889864403200L) {
            z = true;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant".toString());
        }
    }
}
