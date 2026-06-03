package km6;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<T> extends Flowable<T> {
    static {
        Covode.recordClassIndex(656279);
    }

    public abstract void b(Consumer<? super Disposable> consumer);

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public Flowable<T> c() {
        return RxJavaPlugins.onAssembly(new FlowableRefCount(this));
    }
}
