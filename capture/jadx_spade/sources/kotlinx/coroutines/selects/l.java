package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectImplementation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class l<R> extends SelectImplementation<R> {
    private final List<SelectImplementation<R>.a> a;

    static {
        Covode.recordClassIndex(659359);
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    public Object doSelect(Continuation<? super R> continuation) {
        return a(this, continuation);
    }

    private final void b() {
        try {
            Collections.shuffle(this.a);
            Iterator<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                SelectImplementation.register$default(this, (SelectImplementation.a) it2.next(), false, 1, null);
            }
        } finally {
            this.a.clear();
        }
    }

    static /* synthetic */ <R> Object a(l<R> lVar, Continuation<? super R> continuation) {
        lVar.b();
        return super.doSelect(continuation);
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.a.add(new SelectImplementation.a(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public void invoke(b bVar, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.a.add(new SelectImplementation.a(bVar.getClauseObject(), bVar.getRegFunc(), bVar.getProcessResFunc(), SelectKt.i(), function1, bVar.getOnCancellationConstructor()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(e<? super P, ? extends Q> eVar, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.a.add(new SelectImplementation.a(eVar.getClauseObject(), eVar.getRegFunc(), eVar.getProcessResFunc(), p, function2, eVar.getOnCancellationConstructor()));
    }
}
