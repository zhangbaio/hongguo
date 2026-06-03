package kotlinx.datetime;

import cn6.f;
import cn6.j;
import cn6.r;
import cn6.u;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = f.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a {
    public static final C0212a Companion;
    private static final e a;
    private static final e b;
    private static final e c;
    private static final e d;
    private static final e e;
    private static final e f;
    private static final c g;
    private static final c h;
    private static final d i;
    private static final d j;
    private static final d k;
    private static final d l;

    @Serializable(with = cn6.b.class)
    public static abstract class b extends a {
        public static final C0213a Companion;

        static {
            Covode.recordClassIndex(659388);
            Companion = new C0213a(null);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: kotlinx.datetime.a$b$a, reason: collision with other inner class name */
        public static final class C0213a {
            static {
                Covode.recordClassIndex(659389);
            }

            private C0213a() {
            }

            public /* synthetic */ C0213a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<b> serializer() {
                return cn6.b.a;
            }
        }

        private b() {
            super(null);
        }
    }

    @Serializable(with = j.class)
    public static final class c extends b {
        public static final C0214a Companion;
        public final int m;

        static {
            Covode.recordClassIndex(659390);
            Companion = new C0214a(null);
        }

        /* renamed from: kotlinx.datetime.a$c$a, reason: collision with other inner class name */
        public static final class C0214a {
            static {
                Covode.recordClassIndex(659391);
            }

            private C0214a() {
            }

            public /* synthetic */ C0214a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<c> serializer() {
                return j.a;
            }
        }

        public int hashCode() {
            return this.m ^ 65536;
        }

        public String toString() {
            int i = this.m;
            if (i % 7 == 0) {
                return b(i / 7, "WEEK");
            }
            return b(i, "DAY");
        }

        public c d(int i) {
            return new c(an6.c.b(this.m, i));
        }

        public boolean equals(Object obj) {
            if (this != obj && (!(obj instanceof c) || this.m != ((c) obj).m)) {
                return false;
            }
            return true;
        }

        public c(int i) {
            super(null);
            boolean z;
            this.m = i;
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + i + " days.").toString());
        }
    }

    @Serializable(with = r.class)
    public static final class d extends b {
        public static final C0215a Companion;
        public final int m;

        static {
            Covode.recordClassIndex(659392);
            Companion = new C0215a(null);
        }

        /* renamed from: kotlinx.datetime.a$d$a, reason: collision with other inner class name */
        public static final class C0215a {
            static {
                Covode.recordClassIndex(659393);
            }

            private C0215a() {
            }

            public /* synthetic */ C0215a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<d> serializer() {
                return r.a;
            }
        }

        public int hashCode() {
            return this.m ^ 131072;
        }

        public String toString() {
            int i = this.m;
            if (i % 1200 == 0) {
                return b(i / 1200, "CENTURY");
            }
            if (i % 12 == 0) {
                return b(i / 12, "YEAR");
            }
            if (i % 3 == 0) {
                return b(i / 3, "QUARTER");
            }
            return b(i, "MONTH");
        }

        public d d(int i) {
            return new d(an6.c.b(this.m, i));
        }

        public boolean equals(Object obj) {
            if (this != obj && (!(obj instanceof d) || this.m != ((d) obj).m)) {
                return false;
            }
            return true;
        }

        public d(int i) {
            super(null);
            boolean z;
            this.m = i;
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + i + " months.").toString());
        }
    }

    @Serializable(with = u.class)
    public static final class e extends a {
        public static final C0216a Companion;
        public final long m;
        private final String n;
        private final long o;

        static {
            Covode.recordClassIndex(659394);
            Companion = new C0216a(null);
        }

        /* renamed from: kotlinx.datetime.a$e$a, reason: collision with other inner class name */
        public static final class C0216a {
            static {
                Covode.recordClassIndex(659395);
            }

            private C0216a() {
            }

            public /* synthetic */ C0216a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<e> serializer() {
                return u.a;
            }
        }

        public int hashCode() {
            long j = this.m;
            return ((int) j) ^ ((int) (j >> 32));
        }

        public String toString() {
            return c(this.o, this.n);
        }

        public e d(int i) {
            return new e(an6.c.c(this.m, i));
        }

        public boolean equals(Object obj) {
            if (this != obj && (!(obj instanceof e) || this.m != ((e) obj).m)) {
                return false;
            }
            return true;
        }

        public e(long j) {
            super(null);
            boolean z;
            this.m = j;
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (j % 3600000000000L == 0) {
                    this.n = "HOUR";
                    this.o = j / 3600000000000L;
                    return;
                }
                if (j % 60000000000L == 0) {
                    this.n = "MINUTE";
                    this.o = j / 60000000000L;
                    return;
                }
                long j2 = 1000000000;
                if (j % j2 == 0) {
                    this.n = "SECOND";
                    this.o = j / j2;
                    return;
                }
                long j3 = 1000000;
                if (j % j3 == 0) {
                    this.n = "MILLISECOND";
                    this.o = j / j3;
                    return;
                }
                long j4 = 1000;
                if (j % j4 == 0) {
                    this.n = "MICROSECOND";
                    this.o = j / j4;
                    return;
                } else {
                    this.n = "NANOSECOND";
                    this.o = j;
                    return;
                }
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + j + " ns.").toString());
        }
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: kotlinx.datetime.a$a, reason: collision with other inner class name */
    public static final class C0212a {
        static {
            Covode.recordClassIndex(659387);
        }

        private C0212a() {
        }

        public /* synthetic */ C0212a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<a> serializer() {
            return f.a;
        }

        public final c a() {
            return a.g;
        }
    }

    static {
        Covode.recordClassIndex(659386);
        Companion = new C0212a(null);
        e eVar = new e(1L);
        a = eVar;
        e d2 = eVar.d(1000);
        b = d2;
        e d3 = d2.d(1000);
        c = d3;
        e d4 = d3.d(1000);
        d = d4;
        e d5 = d4.d(60);
        e = d5;
        f = d5.d(60);
        c cVar = new c(1);
        g = cVar;
        h = cVar.d(7);
        d dVar = new d(1);
        i = dVar;
        j = dVar.d(3);
        d d6 = dVar.d(12);
        k = d6;
        l = d6.d(100);
    }

    protected final String b(int i2, String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i2 != 1) {
            return i2 + '-' + unit;
        }
        return unit;
    }

    protected final String c(long j2, String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j2 != 1) {
            return j2 + '-' + unit;
        }
        return unit;
    }
}
