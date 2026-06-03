package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import kotlinx.coroutines.b0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j extends g {
    public final Runnable a;

    static {
        Covode.recordClassIndex(659333);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
        } finally {
            this.taskContext.a();
        }
    }

    public String toString() {
        return "Task[" + b0.a(this.a) + '@' + b0.b(this.a) + ", " + this.submissionTime + ", " + this.taskContext + ']';
    }

    public j(Runnable runnable, long j, h hVar) {
        super(j, hVar);
        this.a = runnable;
    }
}
