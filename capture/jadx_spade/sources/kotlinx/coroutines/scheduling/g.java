package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class g implements Runnable {
    public long submissionTime;
    public h taskContext;

    static {
        Covode.recordClassIndex(659330);
    }

    public g() {
        this(0L, k.g);
    }

    public final int getMode$kotlinx_coroutines_core() {
        return this.taskContext.b();
    }

    public g(long j, h hVar) {
        this.submissionTime = j;
        this.taskContext = hVar;
    }
}
