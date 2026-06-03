package kotlin;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.r;
import kotlin.ranges.t;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ULong implements Comparable<ULong> {
    public static final a Companion;
    private final long data;

    public static final class a {
        static {
            Covode.recordClassIndex(658126);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658125);
        Companion = new a(null);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m844boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m850constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m856equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m902unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m857equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m862hashCodeimpl(long j) {
        return j.a(j);
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m890toByteimpl(long j) {
        return (byte) j;
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m893toIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m894toLongimpl(long j) {
        return j;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m895toShortimpl(long j) {
        return (short) j;
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m899toULongsVKNKU(long j) {
        return j;
    }

    public boolean equals(Object obj) {
        return m856equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m862hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m902unboximpl() {
        return this.data;
    }

    public String toString() {
        return m896toStringimpl(this.data);
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m851decsVKNKU(long j) {
        return m850constructorimpl(j - 1);
    }

    /* renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m863incsVKNKU(long j) {
        return m850constructorimpl(j + 1);
    }

    /* renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m864invsVKNKU(long j) {
        return m850constructorimpl(~j);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m891toDoubleimpl(long j) {
        return q.i(j);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m892toFloatimpl(long j) {
        return (float) q.i(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m896toStringimpl(long j) {
        return q.j(j, 10);
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m897toUBytew2LRezQ(long j) {
        return g.b((byte) j);
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m898toUIntpVg5ArA(long j) {
        return UInt.m790constructorimpl((int) j);
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m900toUShortMh2AYeg(long j) {
        return o.b((short) j);
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m846compareToVKZWuLQ(long j) {
        return q.f(m902unboximpl(), j);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return q.f(m902unboximpl(), uLong.m902unboximpl());
    }

    /* renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m843andVKZWuLQ(long j, long j2) {
        return m850constructorimpl(j & j2);
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m847compareToVKZWuLQ(long j, long j2) {
        return q.f(j, j2);
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m853divVKZWuLQ(long j, long j2) {
        return q.g(j, j2);
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m859floorDivVKZWuLQ(long j, long j2) {
        return zj5.k.a(j, j2);
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m866minusVKZWuLQ(long j, long j2) {
        return m850constructorimpl(j - j2);
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m870modVKZWuLQ(long j, long j2) {
        return zj5.l.a(j, j2);
    }

    /* renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m873orVKZWuLQ(long j, long j2) {
        return m850constructorimpl(j | j2);
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m875plusVKZWuLQ(long j, long j2) {
        return m850constructorimpl(j + j2);
    }

    /* renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final r m879rangeUntilVKZWuLQ(long j, long j2) {
        r b;
        b = t.b(j, j2);
        return b;
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m881remVKZWuLQ(long j, long j2) {
        return q.h(j, j2);
    }

    /* renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m884shlsVKNKU(long j, int i) {
        return m850constructorimpl(j << i);
    }

    /* renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m885shrsVKNKU(long j, int i) {
        return m850constructorimpl(j >>> i);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m887timesVKZWuLQ(long j, long j2) {
        return m850constructorimpl(j * j2);
    }

    /* renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m901xorVKZWuLQ(long j, long j2) {
        return m850constructorimpl(j ^ j2);
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m845compareTo7apg3OU(long j, byte b) {
        return w.a(j, m850constructorimpl(b & 255));
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m848compareToWZ4Q5Ns(long j, int i) {
        return w.a(j, m850constructorimpl(i & 4294967295L));
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m849compareToxj2QHRw(long j, short s) {
        return w.a(j, m850constructorimpl(s & 65535));
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m852div7apg3OU(long j, byte b) {
        return zj5.k.a(j, m850constructorimpl(b & 255));
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m854divWZ4Q5Ns(long j, int i) {
        return zj5.k.a(j, m850constructorimpl(i & 4294967295L));
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m855divxj2QHRw(long j, short s) {
        return zj5.k.a(j, m850constructorimpl(s & 65535));
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m858floorDiv7apg3OU(long j, byte b) {
        return zj5.k.a(j, m850constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m860floorDivWZ4Q5Ns(long j, int i) {
        return zj5.k.a(j, m850constructorimpl(i & 4294967295L));
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m861floorDivxj2QHRw(long j, short s) {
        return zj5.k.a(j, m850constructorimpl(s & 65535));
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m865minus7apg3OU(long j, byte b) {
        return m850constructorimpl(j - m850constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m868minusxj2QHRw(long j, short s) {
        return m850constructorimpl(j - m850constructorimpl(s & 65535));
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m874plus7apg3OU(long j, byte b) {
        return m850constructorimpl(j + m850constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m877plusxj2QHRw(long j, short s) {
        return m850constructorimpl(j + m850constructorimpl(s & 65535));
    }

    /* renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final r m878rangeToVKZWuLQ(long j, long j2) {
        return new r(j, j2, null);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m880rem7apg3OU(long j, byte b) {
        return zj5.l.a(j, m850constructorimpl(b & 255));
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m882remWZ4Q5Ns(long j, int i) {
        return zj5.l.a(j, m850constructorimpl(i & 4294967295L));
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m883remxj2QHRw(long j, short s) {
        return zj5.l.a(j, m850constructorimpl(s & 65535));
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m886times7apg3OU(long j, byte b) {
        return m850constructorimpl(j * m850constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m889timesxj2QHRw(long j, short s) {
        return m850constructorimpl(j * m850constructorimpl(s & 65535));
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m867minusWZ4Q5Ns(long j, int i) {
        return m850constructorimpl(j - m850constructorimpl(i & 4294967295L));
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m869mod7apg3OU(long j, byte b) {
        return g.b((byte) zj5.l.a(j, m850constructorimpl(b & 255)));
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m871modWZ4Q5Ns(long j, int i) {
        return UInt.m790constructorimpl((int) zj5.l.a(j, m850constructorimpl(i & 4294967295L)));
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m872modxj2QHRw(long j, short s) {
        return o.b((short) zj5.l.a(j, m850constructorimpl(s & 65535)));
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m876plusWZ4Q5Ns(long j, int i) {
        return m850constructorimpl(j + m850constructorimpl(i & 4294967295L));
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m888timesWZ4Q5Ns(long j, int i) {
        return m850constructorimpl(j * m850constructorimpl(i & 4294967295L));
    }
}
