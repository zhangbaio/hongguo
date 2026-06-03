package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TimeSource$Monotonic {
    public static final TimeSource$Monotonic INSTANCE;

    static {
        Covode.recordClassIndex(658832);
        INSTANCE = new TimeSource$Monotonic();
    }

    private TimeSource$Monotonic() {
    }

    @JvmInline
    public static final class ValueTimeMark implements b {
        private final long reading;

        static {
            Covode.recordClassIndex(658833);
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ ValueTimeMark m1039boximpl(long j) {
            return new ValueTimeMark(j);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static long m1042constructorimpl(long j) {
            return j;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m1044equalsimpl(long j, Object obj) {
            return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).m1062unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1045equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m1048hashCodeimpl(long j) {
            return j.a(j);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m1053toStringimpl(long j) {
            return "ValueTimeMark(reading=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m1044equalsimpl(this.reading, obj);
        }

        public int hashCode() {
            return m1048hashCodeimpl(this.reading);
        }

        public String toString() {
            return m1053toStringimpl(this.reading);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m1062unboximpl() {
            return this.reading;
        }

        public boolean hasNotPassedNow() {
            return m1046hasNotPassedNowimpl(this.reading);
        }

        public boolean hasPassedNow() {
            return m1047hasPassedNowimpl(this.reading);
        }

        @Override // kotlin.time.m
        /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
        public long mo1054elapsedNowUwyO8pc() {
            return m1043elapsedNowUwyO8pc(this.reading);
        }

        private /* synthetic */ ValueTimeMark(long j) {
            this.reading = j;
        }

        /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
        public static long m1043elapsedNowUwyO8pc(long j) {
            return l.a.c(j);
        }

        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public long m1055minusLRDsOJo(long j) {
            return m1050minusLRDsOJo(this.reading, j);
        }

        /* renamed from: hasNotPassedNow-impl, reason: not valid java name */
        public static boolean m1046hasNotPassedNowimpl(long j) {
            return c.J(m1043elapsedNowUwyO8pc(j));
        }

        /* renamed from: hasPassedNow-impl, reason: not valid java name */
        public static boolean m1047hasPassedNowimpl(long j) {
            return !c.J(m1043elapsedNowUwyO8pc(j));
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            return b.a.a(this, bVar);
        }

        @Override // kotlin.time.b
        /* renamed from: minus-UwyO8pc, reason: not valid java name */
        public long mo1058minusUwyO8pc(b other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return m1051minusUwyO8pc(this.reading, other);
        }

        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public long m1059plusLRDsOJo(long j) {
            return m1052plusLRDsOJo(this.reading, j);
        }

        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public /* bridge */ /* synthetic */ b m1056minusLRDsOJo(long j) {
            return m1039boximpl(m1055minusLRDsOJo(j));
        }

        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public /* bridge */ /* synthetic */ b m1060plusLRDsOJo(long j) {
            return m1039boximpl(m1059plusLRDsOJo(j));
        }

        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public /* bridge */ /* synthetic */ m m1057minusLRDsOJo(long j) {
            return m1039boximpl(m1055minusLRDsOJo(j));
        }

        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public /* bridge */ /* synthetic */ m m1061plusLRDsOJo(long j) {
            return m1039boximpl(m1059plusLRDsOJo(j));
        }

        /* renamed from: minus-6eNON_k, reason: not valid java name */
        public static final long m1049minus6eNON_k(long j, long j2) {
            return l.a.b(j, j2);
        }

        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public static long m1052plusLRDsOJo(long j, long j2) {
            return l.a.a(j, j2);
        }

        /* renamed from: compareTo-6eNON_k, reason: not valid java name */
        public static final int m1040compareTo6eNON_k(long j, long j2) {
            return c.h(m1049minus6eNON_k(j, j2), c.b.c());
        }

        /* renamed from: compareTo-impl, reason: not valid java name */
        public static int m1041compareToimpl(long j, b other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return m1039boximpl(j).compareTo(other);
        }

        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public static long m1050minusLRDsOJo(long j, long j2) {
            return l.a.a(j, c.V(j2));
        }

        /* renamed from: minus-UwyO8pc, reason: not valid java name */
        public static long m1051minusUwyO8pc(long j, b other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof ValueTimeMark) {
                return m1049minus6eNON_k(j, ((ValueTimeMark) other).m1062unboximpl());
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m1053toStringimpl(j)) + " and " + other);
        }
    }

    /* renamed from: markNow-z9LOYto, reason: not valid java name */
    public long m1037markNowz9LOYto() {
        return l.a.d();
    }

    public String toString() {
        return l.a.toString();
    }

    public /* bridge */ /* synthetic */ b markNow() {
        return ValueTimeMark.m1039boximpl(m1037markNowz9LOYto());
    }

    /* renamed from: markNow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ m m1038markNow() {
        return ValueTimeMark.m1039boximpl(m1037markNowz9LOYto());
    }
}
