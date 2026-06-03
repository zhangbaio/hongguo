package kotlin.io;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b extends ByteArrayOutputStream {
    static {
        Covode.recordClassIndex(658373);
    }

    public final byte[] a() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        Intrinsics.checkNotNullExpressionValue(buf, "buf");
        return buf;
    }

    public b(int i) {
        super(i);
    }
}
