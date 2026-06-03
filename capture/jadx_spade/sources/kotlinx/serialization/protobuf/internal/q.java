package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    private final kotlinx.serialization.protobuf.internal.a a;
    public int b;
    public ProtoWireType c;
    private boolean d;
    private int e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(660139);
            int[] iArr = new int[ProtoWireType.values().length];
            try {
                iArr[ProtoWireType.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoWireType.i64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoWireType.SIZE_DELIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoWireType.i32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[ProtoIntegerType.values().length];
            try {
                iArr2[ProtoIntegerType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProtoIntegerType.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProtoIntegerType.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(660138);
    }

    public final int r() {
        return c(this, null, 1, null);
    }

    public final long v() {
        return d(ProtoIntegerType.DEFAULT);
    }

    public final boolean g() {
        if (!this.d && this.a.c() == 0) {
            return true;
        }
        return false;
    }

    public final kotlinx.serialization.protobuf.internal.a i() {
        int c = c(this, null, 1, null);
        a(c);
        return this.a.l(c);
    }

    public final byte[] l() {
        int c = c(this, null, 1, null);
        a(c);
        return this.a.e(c);
    }

    public final double n() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(u());
    }

    public final float p() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(s());
    }

    public final String x() {
        int c = c(this, null, 1, null);
        a(c);
        return this.a.f(c);
    }

    private final int s() {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i |= (this.a.d() & 255) << (i2 * 8);
        }
        return i;
    }

    private final long u() {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j |= (this.a.d() & 255) << (i * 8);
        }
        return j;
    }

    public final void j() {
        this.d = true;
        int typeId = (this.b << 3) | this.c.getTypeId();
        B(this.e);
        this.e = typeId;
    }

    public final void A() {
        ProtoWireType protoWireType = ProtoWireType.SIZE_DELIMITED;
        if (this.c == protoWireType) {
            int c = c(this, null, 1, null);
            a(c);
            this.a.k(c);
        } else {
            throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
        }
    }

    public final kotlinx.serialization.protobuf.internal.a h() {
        ProtoWireType protoWireType = ProtoWireType.SIZE_DELIMITED;
        if (this.c == protoWireType) {
            return i();
        }
        throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
    }

    public final byte[] k() {
        ProtoWireType protoWireType = ProtoWireType.SIZE_DELIMITED;
        if (this.c == protoWireType) {
            return l();
        }
        throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
    }

    public final double m() {
        ProtoWireType protoWireType = ProtoWireType.i64;
        if (this.c == protoWireType) {
            DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
            return Double.longBitsToDouble(u());
        }
        throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
    }

    public final float o() {
        ProtoWireType protoWireType = ProtoWireType.i32;
        if (this.c == protoWireType) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat(s());
        }
        throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
    }

    public final String w() {
        ProtoWireType protoWireType = ProtoWireType.SIZE_DELIMITED;
        if (this.c == protoWireType) {
            int c = c(this, null, 1, null);
            a(c);
            return this.a.f(c);
        }
        throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
    }

    public final int y() {
        if (this.d) {
            this.d = false;
            int typeId = (this.b << 3) | this.c.getTypeId();
            int B = B(this.e);
            this.e = typeId;
            return B;
        }
        this.e = (this.b << 3) | this.c.getTypeId();
        return B((int) this.a.i(true));
    }

    public final void z() {
        int i = a.a[this.c.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        q(ProtoIntegerType.FIXED);
                        return;
                    }
                    throw new ProtobufDecodingException("Unsupported start group or end group wire type: " + this.c, null, 2, null);
                }
                A();
                return;
            }
            t(ProtoIntegerType.FIXED);
            return;
        }
        q(ProtoIntegerType.DEFAULT);
    }

    private final int e(kotlinx.serialization.protobuf.internal.a aVar) {
        int g = aVar.g();
        return (g & Integer.MIN_VALUE) ^ ((((g << 31) >> 31) ^ g) >> 1);
    }

    public q(kotlinx.serialization.protobuf.internal.a input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.a = input;
        this.b = -1;
        this.c = ProtoWireType.INVALID;
    }

    private final int B(int i) {
        if (i == -1) {
            this.b = -1;
            this.c = ProtoWireType.INVALID;
            return -1;
        }
        this.b = i >>> 3;
        this.c = ProtoWireType.Companion.a(i & 7);
        return this.b;
    }

    private final void a(int i) {
        if (i >= 0) {
            return;
        }
        throw new ProtobufDecodingException("Unexpected negative length: " + i, null, 2, null);
    }

    private final long f(kotlinx.serialization.protobuf.internal.a aVar) {
        long i = aVar.i(false);
        return (i & Long.MIN_VALUE) ^ ((((i << 63) >> 63) ^ i) >> 1);
    }

    private final int b(ProtoIntegerType protoIntegerType) {
        int i = a.b[protoIntegerType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return s();
                }
                throw new NoWhenBranchMatchedException();
            }
            return e(this.a);
        }
        return (int) this.a.i(false);
    }

    private final long d(ProtoIntegerType protoIntegerType) {
        int i = a.b[protoIntegerType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return u();
                }
                throw new NoWhenBranchMatchedException();
            }
            return f(this.a);
        }
        return this.a.i(false);
    }

    public final int q(ProtoIntegerType format) {
        ProtoWireType protoWireType;
        Intrinsics.checkNotNullParameter(format, "format");
        if (format == ProtoIntegerType.FIXED) {
            protoWireType = ProtoWireType.i32;
        } else {
            protoWireType = ProtoWireType.VARINT;
        }
        if (this.c == protoWireType) {
            return b(format);
        }
        throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
    }

    public final long t(ProtoIntegerType format) {
        ProtoWireType protoWireType;
        Intrinsics.checkNotNullParameter(format, "format");
        if (format == ProtoIntegerType.FIXED) {
            protoWireType = ProtoWireType.i64;
        } else {
            protoWireType = ProtoWireType.VARINT;
        }
        if (this.c == protoWireType) {
            return d(format);
        }
        throw new ProtobufDecodingException("Expected wire type " + protoWireType + ", but found " + this.c, null, 2, null);
    }

    static /* synthetic */ int c(q qVar, ProtoIntegerType protoIntegerType, int i, Object obj) {
        if ((i & 1) != 0) {
            protoIntegerType = ProtoIntegerType.DEFAULT;
        }
        return qVar.b(protoIntegerType);
    }
}
