package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import io.reactivex.functions.Cancellable;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a implements Cancellable {
    private final Job a;

    static {
        Covode.recordClassIndex(659300);
    }

    @Override // io.reactivex.functions.Cancellable
    public void cancel() {
        Job.DefaultImpls.cancel$default(this.a, (CancellationException) null, 1, (Object) null);
    }

    public a(Job job) {
        this.a = job;
    }
}
