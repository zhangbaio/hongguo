package os4;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.covode.number.Covode;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import os4.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class j<T extends i> {
    public static final int d;
    private final MutableLiveData<a<T>> a = new MutableLiveData<>();
    private final ConcurrentHashMap<Observer<T>, Observer<a<T>>> b = new ConcurrentHashMap<>();
    private AtomicInteger c = new AtomicInteger(0);

    static {
        Covode.recordClassIndex(612428);
        d = 8;
    }

    public final void f(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.b.clear();
        this.a.removeObservers(owner);
    }

    private final class b<T extends i> implements Observer<a<T>> {
        public final a<T> a;
        public final Observer<T> b;
        final /* synthetic */ j<T> c;

        static {
            Covode.recordClassIndex(612430);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(a<T> event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event, this.a)) {
                return;
            }
            this.b.onChanged(event.b);
        }

        public b(j jVar, a<T> aVar, Observer<T> observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.c = jVar;
            this.a = aVar;
            this.b = observer;
        }
    }

    public final void c(Observer<T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        b bVar = new b(this, (a) this.a.getValue(), observer);
        this.b.put(observer, bVar);
        this.a.observeForever(bVar);
    }

    protected final void d(T args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.a.postValue(new a(this.c.incrementAndGet(), args));
    }

    public final void e(Observer<T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Observer<a<T>> remove = this.b.remove(observer);
        if (remove != null) {
            this.a.removeObserver(remove);
        }
    }

    protected final void g(T args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.a.setValue(new a(this.c.incrementAndGet(), args));
    }

    private static final class a<T extends i> {
        public final int a;
        public final T b;

        static {
            Covode.recordClassIndex(612429);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Event(id=" + this.a + ", args=" + this.b + ')';
        }

        public a(int i, T args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.a = i;
            this.b = args;
        }
    }

    public final void a(LifecycleOwner owner, Lifecycle.State atLeastState, Observer<T> observer) {
        b bVar;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(atLeastState, "atLeastState");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (owner.getLifecycle().getCurrentState().isAtLeast(atLeastState)) {
            bVar = new b(this, (a) this.a.getValue(), observer);
        } else {
            bVar = new b(this, null, observer);
        }
        this.b.put(observer, bVar);
        this.a.observe(owner, bVar);
    }

    public static /* synthetic */ void b(j jVar, LifecycleOwner lifecycleOwner, Lifecycle.State state, Observer observer, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                state = Lifecycle.State.STARTED;
            }
            jVar.a(lifecycleOwner, state, observer);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observe");
    }
}
