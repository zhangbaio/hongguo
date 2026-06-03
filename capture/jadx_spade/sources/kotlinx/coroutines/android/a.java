package kotlinx.coroutines.android;

import android.os.Looper;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.u;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a implements u {
    static {
        Covode.recordClassIndex(659049);
    }

    @Override // kotlinx.coroutines.internal.u
    public int b() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.u
    public String c() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.u
    public MainCoroutineDispatcher a(List<? extends u> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new HandlerContext(HandlerDispatcherKt.asHandler(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }
}
