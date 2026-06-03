package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m {
    private static final boolean a;

    public static final boolean a() {
        return a;
    }

    static {
        Object m773constructorimpl;
        Covode.recordClassIndex(659230);
        try {
            Result.Companion companion = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(l3.a.q("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        a = Result.m780isSuccessimpl(m773constructorimpl);
    }
}
