package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    private static final a c;
    private static final int[] d;
    private byte[] a = new byte[32];
    public int b;

    private static final class a {
        static {
            Covode.recordClassIndex(660119);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final byte[] e() {
        int i = this.b;
        byte[] bArr = new byte[i];
        ArraysKt___ArraysJvmKt.copyInto$default(this.a, bArr, 0, 0, i, 2, (Object) null);
        return bArr;
    }

    static {
        Covode.recordClassIndex(660118);
        c = new a(null);
        int[] iArr = new int[65];
        for (int i = 0; i < 65; i++) {
            iArr[i] = (63 - i) / 7;
        }
        d = iArr;
    }

    private final int f(long j) {
        return d[Long.numberOfLeadingZeros(j)];
    }

    public final void c(long j) {
        int f = f(j);
        d(f + 1);
        a(j, f);
    }

    public final void b(int i) {
        d(5);
        if ((i & (-128)) == 0) {
            byte[] bArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        long j = i;
        a(j, f(j));
    }

    public final void g(b output) {
        Intrinsics.checkNotNullParameter(output, "output");
        int i = output.b;
        d(i);
        ArraysKt___ArraysJvmKt.copyInto(output.a, this.a, this.b, 0, i);
        this.b += i;
    }

    public final void h(byte[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int length = buffer.length;
        if (length == 0) {
            return;
        }
        d(length);
        ArraysKt___ArraysJvmKt.copyInto(buffer, this.a, this.b, 0, length);
        this.b += length;
    }

    public final void i(int i) {
        d(4);
        for (int i2 = 3; -1 < i2; i2--) {
            byte[] bArr = this.a;
            int i3 = this.b;
            this.b = i3 + 1;
            bArr[i3] = (byte) (i >> (i2 * 8));
        }
    }

    public final void j(long j) {
        d(8);
        for (int i = 7; -1 < i; i--) {
            byte[] bArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr[i2] = (byte) (j >> (i * 8));
        }
    }

    private final void d(int i) {
        int i2 = this.b;
        if (i2 + i <= this.a.length) {
            return;
        }
        byte[] bArr = new byte[Integer.highestOneBit(i2 + i) << 1];
        ArraysKt___ArraysJvmKt.copyInto$default(this.a, bArr, 0, 0, 0, 14, (Object) null);
        this.a = bArr;
    }

    private final void a(long j, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.a[this.b + i2] = (byte) ((127 & j) | 128);
            j >>>= 7;
        }
        byte[] bArr = this.a;
        int i3 = this.b;
        bArr[i3 + i] = (byte) j;
        this.b = i3 + i + 1;
    }
}
