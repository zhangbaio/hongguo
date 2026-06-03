package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w {
    private static final boolean a;

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    static {
        Covode.recordClassIndex(659250);
        a = true;
    }

    public static final boolean c(MainCoroutineDispatcher mainCoroutineDispatcher) {
        return mainCoroutineDispatcher.getImmediate() instanceof x;
    }

    public static final MainCoroutineDispatcher e(u uVar, List<? extends u> list) {
        try {
            return uVar.a(list);
        } catch (Throwable th) {
            return a(th, uVar.c());
        }
    }

    private static final x a(Throwable th, String str) {
        if (a) {
            return new x(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ x b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }
}
