package hj6;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.INetworkClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private final ExecutorService a;
    private final INetworkClient b;
    private Future c;

    static {
        Covode.recordClassIndex(653076);
    }

    public void a() {
        Future future = this.c;
        if (future != null && !future.isDone()) {
            this.c.cancel(true);
            this.c = null;
        }
    }

    public c(ExecutorService executorService, INetworkClient iNetworkClient) {
        this.a = executorService;
        this.b = iNetworkClient;
    }
}
