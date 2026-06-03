package io.reactivex.schedulers;

import com.bytedance.covode.number.Covode;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Schedulers {
    static final Scheduler COMPUTATION;
    static final Scheduler IO;
    static final Scheduler NEW_THREAD;
    static final Scheduler SINGLE;
    static final Scheduler TRAMPOLINE;

    static final class b implements Callable<Scheduler> {
        static {
            Covode.recordClassIndex(657794);
        }

        b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return a.a;
        }
    }

    static final class c implements Callable<Scheduler> {
        static {
            Covode.recordClassIndex(657795);
        }

        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return d.a;
        }
    }

    static final class f implements Callable<Scheduler> {
        static {
            Covode.recordClassIndex(657798);
        }

        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return e.a;
        }
    }

    static final class h implements Callable<Scheduler> {
        static {
            Covode.recordClassIndex(657800);
        }

        h() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return g.a;
        }
    }

    public static Scheduler trampoline() {
        return TRAMPOLINE;
    }

    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(COMPUTATION);
    }

    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(IO);
    }

    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(NEW_THREAD);
    }

    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(SINGLE);
    }

    static final class a {
        static final Scheduler a;

        static {
            Covode.recordClassIndex(657793);
            a = new io.reactivex.internal.schedulers.a();
        }
    }

    static final class d {
        static final Scheduler a;

        static {
            Covode.recordClassIndex(657796);
            a = new io.reactivex.internal.schedulers.e();
        }
    }

    static final class e {
        static final Scheduler a;

        static {
            Covode.recordClassIndex(657797);
            a = new io.reactivex.internal.schedulers.f();
        }
    }

    static final class g {
        static final Scheduler a;

        static {
            Covode.recordClassIndex(657799);
            a = new SingleScheduler();
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    static {
        Covode.recordClassIndex(657792);
        SINGLE = RxJavaPlugins.initSingleScheduler(new h());
        COMPUTATION = RxJavaPlugins.initComputationScheduler(new b());
        IO = RxJavaPlugins.initIoScheduler(new c());
        TRAMPOLINE = TrampolineScheduler.instance();
        NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new f());
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        j.b();
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        j.c();
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    public static Scheduler from(Executor executor, boolean z) {
        return new ExecutorScheduler(executor, z);
    }
}
