package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final /* synthetic */ class JobKt__JobKt {
    static {
        Covode.recordClassIndex(659003);
    }

    public static final CompletableJob a(Job job) {
        return new d1(job);
    }

    public static final /* synthetic */ Job b(Job job) {
        return JobKt.Job(job);
    }

    public static final void x(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            JobKt.ensureActive(job);
        }
    }

    public static final void y(Job job) {
        if (job.isActive()) {
        } else {
            throw job.getCancellationException();
        }
    }

    public static final boolean C(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final Job z(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    private static final Throwable D(Throwable th, Job job) {
        if (th == null) {
            return new JobCancellationException("Job was cancelled", null, job);
        }
        return th;
    }

    public static final void f(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static final DisposableHandle w(Job job, DisposableHandle disposableHandle) {
        return B(job, false, false, new n0(disposableHandle), 3, null);
    }

    public static final /* synthetic */ boolean h(CoroutineContext coroutineContext, Throwable th) {
        JobSupport jobSupport;
        CoroutineContext.Element element = coroutineContext.get(Job.Key);
        if (element instanceof JobSupport) {
            jobSupport = (JobSupport) element;
        } else {
            jobSupport = null;
        }
        if (jobSupport == null) {
            return false;
        }
        jobSupport.v(D(th, jobSupport));
        return true;
    }

    public static final Object l(Job job, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        Object join = job.join(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (join == coroutine_suspended) {
            return join;
        }
        return Unit.INSTANCE;
    }

    public static final void r(Job job, CancellationException cancellationException) {
        Iterator<Job> it2 = job.getChildren().iterator();
        while (it2.hasNext()) {
            it2.next().cancel(cancellationException);
        }
    }

    public static final /* synthetic */ void n(CoroutineContext coroutineContext, Throwable th) {
        JobSupport jobSupport;
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job == null) {
            return;
        }
        for (Job job2 : job.getChildren()) {
            if (job2 instanceof JobSupport) {
                jobSupport = (JobSupport) job2;
            } else {
                jobSupport = null;
            }
            if (jobSupport != null) {
                jobSupport.v(D(th, job));
            }
        }
    }

    public static final void o(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence<Job> children;
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null && (children = job.getChildren()) != null) {
            Iterator<Job> it2 = children.iterator();
            while (it2.hasNext()) {
                it2.next().cancel(cancellationException);
            }
        }
    }

    public static final /* synthetic */ void q(Job job, Throwable th) {
        JobSupport jobSupport;
        for (Job job2 : job.getChildren()) {
            if (job2 instanceof JobSupport) {
                jobSupport = (JobSupport) job2;
            } else {
                jobSupport = null;
            }
            if (jobSupport != null) {
                jobSupport.v(D(th, job));
            }
        }
    }

    public static final void g(Job job, String str, Throwable th) {
        job.cancel(u0.a(str, th));
    }

    public static /* synthetic */ CompletableJob c(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static /* synthetic */ Job d(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return b(job);
    }

    public static /* synthetic */ void i(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    public static /* synthetic */ boolean k(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return h(coroutineContext, th);
    }

    public static /* synthetic */ void s(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        n(coroutineContext, th);
    }

    public static /* synthetic */ void t(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void u(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        q(job, th);
    }

    public static /* synthetic */ void v(Job job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    public static final DisposableHandle A(Job job, boolean z, boolean z2, z0 z0Var) {
        if (job instanceof JobSupport) {
            return ((JobSupport) job).X(z, z2, z0Var);
        }
        return job.invokeOnCompletion(z, z2, new JobKt__JobKt$invokeOnCompletion$1(z0Var));
    }

    public static /* synthetic */ void j(Job job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        JobKt.cancel(job, str, th);
    }

    public static /* synthetic */ DisposableHandle B(Job job, boolean z, boolean z2, z0 z0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return JobKt.invokeOnCompletion(job, z, z2, z0Var);
    }
}
