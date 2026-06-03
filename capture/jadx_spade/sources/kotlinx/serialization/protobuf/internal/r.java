package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class r {
    private long[] a = new long[8];
    protected int b = -1;

    static {
        Covode.recordClassIndex(660140);
    }

    protected final long c() {
        return this.a[this.b];
    }

    protected final long d() {
        int i = this.b;
        if (i == -1) {
            return 19500L;
        }
        return this.a[i];
    }

    private final void b() {
        long[] jArr = this.a;
        long[] copyOf = Arrays.copyOf(jArr, jArr.length * 2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.a = copyOf;
    }

    protected final long e() {
        int i = this.b;
        if (i >= 0) {
            long[] jArr = this.a;
            this.b = i - 1;
            return jArr[i];
        }
        throw new SerializationException("No tag in stack for requested element");
    }

    protected final long f() {
        int i = this.b;
        if (i == -1) {
            return 19500L;
        }
        long[] jArr = this.a;
        this.b = i - 1;
        return jArr[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(long j) {
        if (j == 19500) {
            return;
        }
        int i = this.b + 1;
        this.b = i;
        if (i >= this.a.length) {
            b();
        }
        this.a[i] = j;
    }
}
