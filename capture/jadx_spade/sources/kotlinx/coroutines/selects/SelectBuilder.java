package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SelectBuilder<R> {
    <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    void invoke(b bVar, Function1<? super Continuation<? super R>, ? extends Object> function1);

    <P, Q> void invoke(e<? super P, ? extends Q> eVar, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    <P, Q> void invoke(e<? super P, ? extends Q> eVar, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    void onTimeout(long j, Function1<? super Continuation<? super R>, ? extends Object> function1);

    public static final class a {
        static {
            Covode.recordClassIndex(659341);
        }

        public static <R> void b(SelectBuilder<? super R> selectBuilder, long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
            kotlinx.coroutines.selects.a.a(selectBuilder, j, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void a(SelectBuilder<? super R> selectBuilder, e<? super P, ? extends Q> eVar, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
            selectBuilder.invoke(eVar, null, function2);
        }
    }
}
