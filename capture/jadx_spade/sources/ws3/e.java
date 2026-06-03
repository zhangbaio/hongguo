package ws3;

import com.bytedance.covode.number.Covode;
import io.reactivex.disposables.Disposable;
import k44.e0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;

    static {
        Covode.recordClassIndex(599155);
        a = new e();
    }

    private e() {
    }

    public static final void a(Object obj) throws Exception {
        e0.a.g().m4(obj);
    }

    public final boolean b(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            return true;
        }
        return false;
    }
}
