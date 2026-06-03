package bs4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.covode.number.Covode;
import kotlin.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static final MutableLiveData<Pair<Integer, Integer>> b;
    private static final LiveData<Pair<Integer, Integer>> c;
    public static final int d;

    static final class a implements Observer, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        a(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    private b() {
    }

    public final LiveData<Pair<Integer, Integer>> getType() {
        return c;
    }

    static {
        Covode.recordClassIndex(611976);
        a = new b();
        int c2 = ol2.d.c();
        MutableLiveData<Pair<Integer, Integer>> mutableLiveData = new MutableLiveData<>(TuplesKt.to(Integer.valueOf(c2), Integer.valueOf(c2)));
        b = mutableLiveData;
        c = mutableLiveData;
        ol2.d.f().observeForever(new a(new Function1() { // from class: bs4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit b2;
                b2 = b.b((Integer) obj);
                return b2;
            }
        }));
        d = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(Integer num) {
        b bVar = a;
        Intrinsics.checkNotNull(num);
        bVar.c(num.intValue());
        return Unit.INSTANCE;
    }

    private final void c(int i) {
        int i2;
        Pair pair = (Pair) c.getValue();
        if (pair != null) {
            i2 = ((Number) pair.getSecond()).intValue();
        } else {
            i2 = 0;
        }
        if (i != i2) {
            b.postValue(new Pair(Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
