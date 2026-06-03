package kotlin.text;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c implements Sequence<IntRange> {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> d;

    static {
        Covode.recordClassIndex(658747);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new a();
    }

    public static final class a implements Iterator<IntRange>, KMappedMarker {
        public int a = -1;
        public int b;
        public int c;
        public IntRange d;
        public int e;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                c();
            }
            if (this.a == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public IntRange next() {
            if (this.a == -1) {
                c();
            }
            if (this.a != 0) {
                IntRange intRange = this.d;
                Intrinsics.checkNotNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.d = null;
                this.a = -1;
                return intRange;
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f.c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void c() {
            /*
                r6 = this;
                int r0 = r6.c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.d = r0
                goto L9e
            Lc:
                kotlin.text.c r0 = kotlin.text.c.this
                int r0 = kotlin.text.c.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.e
                int r0 = r0 + r3
                r6.e = r0
                kotlin.text.c r4 = kotlin.text.c.this
                int r4 = kotlin.text.c.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.c
                kotlin.text.c r4 = kotlin.text.c.this
                java.lang.CharSequence r4 = kotlin.text.c.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.b
                kotlin.text.c r4 = kotlin.text.c.this
                java.lang.CharSequence r4 = kotlin.text.c.d(r4)
                int r4 = kotlin.text.StringsKt.getLastIndex(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9c
            L47:
                kotlin.text.c r0 = kotlin.text.c.this
                kotlin.jvm.functions.Function2 r0 = kotlin.text.c.c(r0)
                kotlin.text.c r4 = kotlin.text.c.this
                java.lang.CharSequence r4 = kotlin.text.c.d(r4)
                int r5 = r6.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.b
                kotlin.text.c r4 = kotlin.text.c.this
                java.lang.CharSequence r4 = kotlin.text.c.d(r4)
                int r4 = kotlin.text.StringsKt.getLastIndex(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.until(r4, r2)
                r6.d = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.c = r2
            L9c:
                r6.a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.c.a.c():void");
        }

        a() {
            int coerceIn;
            coerceIn = RangesKt___RangesKt.coerceIn(c.this.b, 0, c.this.a.length());
            this.b = coerceIn;
            this.c = coerceIn;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(CharSequence input, int i, int i2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(getNextMatch, "getNextMatch");
        this.a = input;
        this.b = i;
        this.c = i2;
        this.d = getNextMatch;
    }
}
