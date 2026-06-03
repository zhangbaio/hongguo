package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.i;
import kotlinx.coroutines.rx2.DispatcherScheduler;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class DispatcherScheduler extends Scheduler {
    private static final /* synthetic */ AtomicLongFieldUpdater d;
    public final CoroutineDispatcher a;
    private final CompletableJob b;
    private final CoroutineScope c;
    private volatile /* synthetic */ long workerCounter$volatile;

    static {
        Covode.recordClassIndex(659296);
        d = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter$volatile");
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        Job.DefaultImpls.cancel$default((Job) this.b, (CancellationException) null, 1, (Object) null);
    }

    public String toString() {
        return this.a.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class DispatcherWorker extends Scheduler.Worker {
        private final long a;
        private final CoroutineDispatcher b;
        private final CompletableJob c;
        private final CoroutineScope d;
        private final Channel<Function1<Continuation<? super Unit>, Object>> e;

        static {
            Covode.recordClassIndex(659297);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SendChannel.DefaultImpls.close$default(this.e, null, 1, null);
            Job.DefaultImpls.cancel$default((Job) this.c, (CancellationException) null, 1, (Object) null);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return !CoroutineScopeKt.isActive(this.d);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append(" (worker ");
            sb.append(this.a);
            sb.append(", ");
            if (isDisposed()) {
                str = "disposed";
            } else {
                str = "active";
            }
            sb.append(str);
            sb.append(')');
            return sb.toString();
        }

        @DebugMetadata(c = "kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1", f = "RxScheduler.kt", i = {0, 1}, l = {186, 78}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$0", "L$0"})
        /* renamed from: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return DispatcherWorker.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:16:0x0051, B:18:0x0059, B:22:0x0070), top: B:15:0x0051 }] */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:16:0x0051, B:18:0x0059, B:22:0x0070), top: B:15:0x0051 }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006c -> B:10:0x003f). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L31
                    if (r1 == r3) goto L23
                    if (r1 != r2) goto L1b
                    java.lang.Object r1 = r7.L$1
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r4 = r7.L$0
                    kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L7c
                    r8 = r1
                    goto L3e
                L1b:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L23:
                    java.lang.Object r1 = r7.L$1
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r4 = r7.L$0
                    kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L7c
                    r5 = r4
                    r4 = r7
                    goto L51
                L31:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker r8 = kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.this
                    kotlinx.coroutines.channels.Channel r4 = kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.a(r8)
                    kotlinx.coroutines.channels.ChannelIterator r8 = r4.iterator()     // Catch: java.lang.Throwable -> L7c
                L3e:
                    r1 = r7
                L3f:
                    r1.L$0 = r4     // Catch: java.lang.Throwable -> L7c
                    r1.L$1 = r8     // Catch: java.lang.Throwable -> L7c
                    r1.label = r3     // Catch: java.lang.Throwable -> L7c
                    java.lang.Object r5 = r8.a(r1)     // Catch: java.lang.Throwable -> L7c
                    if (r5 != r0) goto L4c
                    return r0
                L4c:
                    r6 = r1
                    r1 = r8
                    r8 = r5
                    r5 = r4
                    r4 = r6
                L51:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L79
                    boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L79
                    if (r8 == 0) goto L70
                    java.lang.Object r8 = r1.next()     // Catch: java.lang.Throwable -> L79
                    kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch: java.lang.Throwable -> L79
                    r4.L$0 = r5     // Catch: java.lang.Throwable -> L79
                    r4.L$1 = r1     // Catch: java.lang.Throwable -> L79
                    r4.label = r2     // Catch: java.lang.Throwable -> L79
                    java.lang.Object r8 = r8.invoke(r4)     // Catch: java.lang.Throwable -> L79
                    if (r8 != r0) goto L6c
                    return r0
                L6c:
                    r8 = r1
                    r1 = r4
                    r4 = r5
                    goto L3f
                L70:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L79
                    r8 = 0
                    kotlinx.coroutines.channels.e.b(r5, r8)
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                L79:
                    r8 = move-exception
                    r4 = r5
                    goto L7d
                L7c:
                    r8 = move-exception
                L7d:
                    throw r8     // Catch: java.lang.Throwable -> L7e
                L7e:
                    r0 = move-exception
                    kotlinx.coroutines.channels.e.b(r4, r8)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Disposable d;
            d = RxSchedulerKt.d(this.d, runnable, timeUnit.toMillis(j), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$schedule$1
                {
                    super(1);
                }

                public static final class a implements Runnable {
                    final /* synthetic */ DispatcherScheduler.DispatcherWorker a;
                    final /* synthetic */ Function1 b;

                    public a(DispatcherScheduler.DispatcherWorker dispatcherWorker, Function1 function1) {
                        this.a = dispatcherWorker;
                        this.b = function1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e.mo1078trySendJP2dKIU(this.b);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final Runnable invoke(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                    return new a(DispatcherScheduler.DispatcherWorker.this, function1);
                }
            });
            return d;
        }

        public DispatcherWorker(long j, CoroutineDispatcher coroutineDispatcher, Job job) {
            this.a = j;
            this.b = coroutineDispatcher;
            CompletableJob SupervisorJob = SupervisorKt.SupervisorJob(job);
            this.c = SupervisorJob;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob.plus(coroutineDispatcher));
            this.d = CoroutineScope;
            this.e = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            i.e(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new DispatcherWorker(d.getAndIncrement(this), this.a, this.b);
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Disposable d2;
        d2 = RxSchedulerKt.d(this.c, runnable, timeUnit.toMillis(j), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$scheduleDirect$1
            {
                super(1);
            }

            public static final class a implements Runnable {
                final /* synthetic */ DispatcherScheduler a;
                final /* synthetic */ Function1 b;

                public a(DispatcherScheduler dispatcherScheduler, Function1 function1) {
                    this.a = dispatcherScheduler;
                    this.b = function1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CoroutineScope coroutineScope;
                    coroutineScope = this.a.c;
                    i.e(coroutineScope, null, null, new DispatcherScheduler$scheduleDirect$1$1$1(this.b, null), 3, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final Runnable invoke(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                return new a(DispatcherScheduler.this, function1);
            }
        });
        return d2;
    }
}
