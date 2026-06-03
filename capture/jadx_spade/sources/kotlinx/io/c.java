package kotlinx.io;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements a {
    public final a a;
    public boolean b;

    static {
        Covode.recordClassIndex(659706);
    }

    @Override // kotlinx.io.a, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        try {
            throw null;
        } catch (Throwable th) {
            try {
                this.a.close();
            } catch (Throwable unused) {
            }
            this.b = true;
            throw th;
        }
    }

    @Override // java.io.Flushable
    public void flush() {
        if (!(!this.b)) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        throw null;
    }

    public String toString() {
        return "buffered(" + this.a + ')';
    }
}
