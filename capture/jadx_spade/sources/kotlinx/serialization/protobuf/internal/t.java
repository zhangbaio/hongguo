package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    private final b a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(660147);
            int[] iArr = new int[ProtoIntegerType.values().length];
            try {
                iArr[ProtoIntegerType.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoIntegerType.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoIntegerType.SIGNED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(660146);
    }

    public t(b out) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.a = out;
    }

    private final int e(float f) {
        return c.a(Float.floatToRawIntBits(f));
    }

    private final long f(double d) {
        return c.b(Double.doubleToRawLongBits(d));
    }

    public final void i(double d) {
        this.a.j(f(d));
    }

    public final void k(float f) {
        this.a.i(e(f));
    }

    public final void m(int i) {
        b(this, this.a, i, null, 2, null);
    }

    public final void o(long j) {
        d(this, this.a, j, null, 2, null);
    }

    public final void s(String value) {
        byte[] encodeToByteArray;
        Intrinsics.checkNotNullParameter(value, "value");
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(value);
        g(encodeToByteArray);
    }

    public final void g(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        b(this, this.a, bytes.length, null, 2, null);
        this.a.h(bytes);
    }

    public final void q(b output) {
        Intrinsics.checkNotNullParameter(output, "output");
        b(this, this.a, output.b, null, 2, null);
        this.a.g(output);
    }

    public final void t(String value, int i) {
        byte[] encodeToByteArray;
        Intrinsics.checkNotNullParameter(value, "value");
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(value);
        h(encodeToByteArray, i);
    }

    public final void h(byte[] bytes, int i) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        b(this, this.a, ProtoWireType.SIZE_DELIMITED.wireIntWithTag(i), null, 2, null);
        g(bytes);
    }

    public final void j(double d, int i) {
        b(this, this.a, ProtoWireType.i64.wireIntWithTag(i), null, 2, null);
        this.a.j(f(d));
    }

    public final void l(float f, int i) {
        b(this, this.a, ProtoWireType.i32.wireIntWithTag(i), null, 2, null);
        this.a.i(e(f));
    }

    public final void r(b output, int i) {
        Intrinsics.checkNotNullParameter(output, "output");
        b(this, this.a, ProtoWireType.SIZE_DELIMITED.wireIntWithTag(i), null, 2, null);
        q(output);
    }

    private final void a(b bVar, int i, ProtoIntegerType protoIntegerType) {
        int i2 = a.a[protoIntegerType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    bVar.b((i >> 31) ^ (i << 1));
                    return;
                }
                throw new NoWhenBranchMatchedException();
            }
            bVar.c(i);
            return;
        }
        this.a.i(c.a(i));
    }

    private final void c(b bVar, long j, ProtoIntegerType protoIntegerType) {
        int i = a.a[protoIntegerType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    bVar.c((j >> 63) ^ (j << 1));
                    return;
                }
                throw new NoWhenBranchMatchedException();
            }
            bVar.c(j);
            return;
        }
        this.a.j(c.b(j));
    }

    public final void n(int i, int i2, ProtoIntegerType format) {
        ProtoWireType protoWireType;
        Intrinsics.checkNotNullParameter(format, "format");
        if (format == ProtoIntegerType.FIXED) {
            protoWireType = ProtoWireType.i32;
        } else {
            protoWireType = ProtoWireType.VARINT;
        }
        b(this, this.a, protoWireType.wireIntWithTag(i2), null, 2, null);
        a(this.a, i, format);
    }

    public final void p(long j, int i, ProtoIntegerType format) {
        ProtoWireType protoWireType;
        Intrinsics.checkNotNullParameter(format, "format");
        if (format == ProtoIntegerType.FIXED) {
            protoWireType = ProtoWireType.i64;
        } else {
            protoWireType = ProtoWireType.VARINT;
        }
        b(this, this.a, protoWireType.wireIntWithTag(i), null, 2, null);
        c(this.a, j, format);
    }

    static /* synthetic */ void b(t tVar, b bVar, int i, ProtoIntegerType protoIntegerType, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            protoIntegerType = ProtoIntegerType.DEFAULT;
        }
        tVar.a(bVar, i, protoIntegerType);
    }

    static /* synthetic */ void d(t tVar, b bVar, long j, ProtoIntegerType protoIntegerType, int i, Object obj) {
        if ((i & 2) != 0) {
            protoIntegerType = ProtoIntegerType.DEFAULT;
        }
        tVar.c(bVar, j, protoIntegerType);
    }
}
