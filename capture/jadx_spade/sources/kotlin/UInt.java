package kotlin;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.t;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class UInt implements Comparable<UInt> {
    public static final a Companion;
    private final int data;

    public static final class a {
        static {
            Covode.recordClassIndex(658120);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658119);
        Companion = new a(null);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m784boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m790constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m796equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m842unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m797equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m802hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m830toByteimpl(int i) {
        return (byte) i;
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m833toIntimpl(int i) {
        return i;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m834toLongimpl(int i) {
        return i & 4294967295L;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m835toShortimpl(int i) {
        return (short) i;
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m838toUIntpVg5ArA(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m796equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m802hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m842unboximpl() {
        return this.data;
    }

    public String toString() {
        return m836toStringimpl(this.data);
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m791decpVg5ArA(int i) {
        return m790constructorimpl(i - 1);
    }

    /* renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m803incpVg5ArA(int i) {
        return m790constructorimpl(i + 1);
    }

    /* renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m804invpVg5ArA(int i) {
        return m790constructorimpl(~i);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m831toDoubleimpl(int i) {
        return q.e(i);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m832toFloatimpl(int i) {
        return (float) q.e(i);
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m837toUBytew2LRezQ(int i) {
        return g.b((byte) i);
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m840toUShortMh2AYeg(int i) {
        return o.b((short) i);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m787compareToWZ4Q5Ns(int i) {
        return q.b(m842unboximpl(), i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m836toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m839toULongsVKNKU(int i) {
        return ULong.m850constructorimpl(i & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return q.b(m842unboximpl(), uInt.m842unboximpl());
    }

    /* renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m783andWZ4Q5Ns(int i, int i2) {
        return m790constructorimpl(i & i2);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m788compareToWZ4Q5Ns(int i, int i2) {
        return q.b(i, i2);
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m794divWZ4Q5Ns(int i, int i2) {
        return q.c(i, i2);
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m800floorDivWZ4Q5Ns(int i, int i2) {
        return i.a(i, i2);
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m807minusWZ4Q5Ns(int i, int i2) {
        return m790constructorimpl(i - i2);
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m811modWZ4Q5Ns(int i, int i2) {
        return j.a(i, i2);
    }

    /* renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m813orWZ4Q5Ns(int i, int i2) {
        return m790constructorimpl(i | i2);
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m816plusWZ4Q5Ns(int i, int i2) {
        return m790constructorimpl(i + i2);
    }

    /* renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final kotlin.ranges.o m818rangeToWZ4Q5Ns(int i, int i2) {
        return new kotlin.ranges.o(i, i2, null);
    }

    /* renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final kotlin.ranges.o m819rangeUntilWZ4Q5Ns(int i, int i2) {
        kotlin.ranges.o a2;
        a2 = t.a(i, i2);
        return a2;
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m822remWZ4Q5Ns(int i, int i2) {
        return q.d(i, i2);
    }

    /* renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m824shlpVg5ArA(int i, int i2) {
        return m790constructorimpl(i << i2);
    }

    /* renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m825shrpVg5ArA(int i, int i2) {
        return m790constructorimpl(i >>> i2);
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m828timesWZ4Q5Ns(int i, int i2) {
        return m790constructorimpl(i * i2);
    }

    /* renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m841xorWZ4Q5Ns(int i, int i2) {
        return m790constructorimpl(i ^ i2);
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m785compareTo7apg3OU(int i, byte b) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m790constructorimpl(b & 255) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m786compareToVKZWuLQ(int i, long j) {
        return w.a(ULong.m850constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m789compareToxj2QHRw(int i, short s) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m790constructorimpl(s & 65535) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m792div7apg3OU(int i, byte b) {
        return i.a(i, m790constructorimpl(b & 255));
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m793divVKZWuLQ(int i, long j) {
        return zj5.k.a(ULong.m850constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m795divxj2QHRw(int i, short s) {
        return i.a(i, m790constructorimpl(s & 65535));
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m798floorDiv7apg3OU(int i, byte b) {
        return i.a(i, m790constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m799floorDivVKZWuLQ(int i, long j) {
        return zj5.k.a(ULong.m850constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m801floorDivxj2QHRw(int i, short s) {
        return i.a(i, m790constructorimpl(s & 65535));
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m805minus7apg3OU(int i, byte b) {
        return m790constructorimpl(i - m790constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m808minusxj2QHRw(int i, short s) {
        return m790constructorimpl(i - m790constructorimpl(s & 65535));
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m809mod7apg3OU(int i, byte b) {
        return g.b((byte) j.a(i, m790constructorimpl(b & 255)));
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m810modVKZWuLQ(int i, long j) {
        return zj5.l.a(ULong.m850constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m814plus7apg3OU(int i, byte b) {
        return m790constructorimpl(i + m790constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m817plusxj2QHRw(int i, short s) {
        return m790constructorimpl(i + m790constructorimpl(s & 65535));
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m820rem7apg3OU(int i, byte b) {
        return j.a(i, m790constructorimpl(b & 255));
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m821remVKZWuLQ(int i, long j) {
        return zj5.l.a(ULong.m850constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m823remxj2QHRw(int i, short s) {
        return j.a(i, m790constructorimpl(s & 65535));
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m826times7apg3OU(int i, byte b) {
        return m790constructorimpl(i * m790constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m829timesxj2QHRw(int i, short s) {
        return m790constructorimpl(i * m790constructorimpl(s & 65535));
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m806minusVKZWuLQ(int i, long j) {
        return ULong.m850constructorimpl(ULong.m850constructorimpl(i & 4294967295L) - j);
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m812modxj2QHRw(int i, short s) {
        return o.b((short) j.a(i, m790constructorimpl(s & 65535)));
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m815plusVKZWuLQ(int i, long j) {
        return ULong.m850constructorimpl(ULong.m850constructorimpl(i & 4294967295L) + j);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m827timesVKZWuLQ(int i, long j) {
        return ULong.m850constructorimpl(ULong.m850constructorimpl(i & 4294967295L) * j);
    }
}
