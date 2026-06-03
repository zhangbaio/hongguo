package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SelectKt {
    private static final Function3<Object, Object, Object, Object> a;
    private static final f0 b;
    private static final f0 c;
    private static final f0 d;
    private static final f0 e;
    private static final f0 f;

    public static final f0 i() {
        return f;
    }

    static {
        Covode.recordClassIndex(659354);
        a = new Function3() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
            @Override // kotlin.jvm.functions.Function3
            public final Void invoke(Object obj, Object obj2, Object obj3) {
                return null;
            }
        };
        b = new f0("STATE_REG");
        c = new f0("STATE_COMPLETED");
        d = new f0("STATE_CANCELLED");
        e = new f0("NO_RESULT");
        f = new f0("PARAM_CLAUSE_0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrySelectDetailedResult a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return TrySelectDetailedResult.ALREADY_SELECTED;
                    }
                    throw new IllegalStateException(("Unexpected internal result: " + i).toString());
                }
                return TrySelectDetailedResult.CANCELLED;
            }
            return TrySelectDetailedResult.REREGISTER;
        }
        return TrySelectDetailedResult.SUCCESSFUL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super Throwable, Unit> function1) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, function1);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }
}
