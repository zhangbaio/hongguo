package kotlinx.io;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d implements b {
    public final b a;
    public boolean b;

    static {
        Covode.recordClassIndex(659707);
    }

    @Override // kotlinx.io.b, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.close();
        throw null;
    }

    public String toString() {
        return "buffered(" + this.a + ')';
    }
}
