package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.SerializationException;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    private byte[] a;
    private final int b;
    private int c;

    static {
        Covode.recordClassIndex(660117);
    }

    private final void b() {
        throw new SerializationException("Unexpected EOF");
    }

    public final int c() {
        return this.b - this.c;
    }

    private final int h() {
        int i = 0;
        for (int i2 = 0; i2 < 32; i2 += 7) {
            int d = d();
            i |= (d & 127) << i2;
            if ((d & 128) == 0) {
                return i;
            }
        }
        throw new SerializationException("Input stream is malformed: Varint too long (exceeded 32 bits)");
    }

    private final long j() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & 127) << i;
            if ((d() & 128) == 0) {
                return j;
            }
        }
        throw new SerializationException("Input stream is malformed: Varint too long (exceeded 64 bits)");
    }

    public final int d() {
        int i = this.c;
        if (i < this.b) {
            byte[] bArr = this.a;
            this.c = i + 1;
            return bArr[i] & 255;
        }
        return -1;
    }

    public final int g() {
        if (this.c == this.b) {
            b();
        }
        int i = this.c;
        byte[] bArr = this.a;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            this.c = i2;
            return b;
        }
        if (this.b - i > 1) {
            int i3 = i2 + 1;
            int i4 = (bArr[i2] << 7) ^ b;
            if (i4 < 0) {
                this.c = i3;
                return i4 ^ (-128);
            }
        }
        return h();
    }

    public final void k(int i) {
        a(i);
        this.c += i;
    }

    public final byte[] e(int i) {
        a(i);
        byte[] bArr = new byte[i];
        int i2 = this.b;
        int i3 = this.c;
        if (i2 - i3 < i) {
            i = i2 - i3;
        }
        ArraysKt___ArraysJvmKt.copyInto(this.a, bArr, 0, i3, i3 + i);
        this.c += i;
        return bArr;
    }

    public final String f(int i) {
        String decodeToString$default;
        byte[] bArr = this.a;
        int i2 = this.c;
        decodeToString$default = StringsKt__StringsJVMKt.decodeToString$default(bArr, i2, i2 + i, false, 4, null);
        this.c += i;
        return decodeToString$default;
    }

    public final a l(int i) {
        a(i);
        a aVar = new a(this.a, this.c + i);
        aVar.c = this.c;
        this.c += i;
        return aVar;
    }

    private final void a(int i) {
        if (i <= c()) {
            return;
        }
        throw new SerializationException("Unexpected EOF, available " + c() + " bytes, requested: " + i);
    }

    public final long i(boolean z) {
        if (this.c == this.b) {
            if (z) {
                return -1L;
            }
            b();
        }
        int i = this.c;
        int i2 = i + 1;
        long j = this.a[i];
        if (j >= 0) {
            this.c = i2;
            return j;
        }
        if (this.b - i > 1) {
            int i3 = i2 + 1;
            long j2 = (r0[i2] << 7) ^ j;
            if (j2 < 0) {
                this.c = i3;
                return j2 ^ (-128);
            }
        }
        return j();
    }

    public a(byte[] array, int i) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.a = array;
        this.b = i;
    }

    public /* synthetic */ a(byte[] bArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i2 & 2) != 0 ? bArr.length : i);
    }
}
