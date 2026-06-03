package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.base.ssconfig.template.CoroutineSchedulerRename;
import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.f0;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public static final Companion Companion;
    public static final f0 NOT_IN_STACK;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$volatile$FU;
    private static final /* synthetic */ AtomicLongFieldUpdater controlState$volatile$FU;
    private static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$volatile$FU;
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int corePoolSize;
    public final c globalBlockingQueue;
    public final c globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    public final String schedulerName;
    public final a0<Worker> workers;

    public static final class Companion {
        static {
            Covode.recordClassIndex(659317);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Covode.recordClassIndex(659318);
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int blockingTasks(long j) {
        return (int) ((j & 4398044413952L) >> 21);
    }

    private final int createdWorkers(long j) {
        return (int) (j & 2097151);
    }

    private final /* synthetic */ long getControlState$volatile() {
        return this.controlState$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater getControlState$volatile$FU() {
        return controlState$volatile$FU;
    }

    private final /* synthetic */ long getParkedWorkersStack$volatile() {
        return this.parkedWorkersStack$volatile;
    }

    private final /* synthetic */ int get_isTerminated$volatile() {
        return this._isTerminated$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void setControlState$volatile(long j) {
        this.controlState$volatile = j;
    }

    private final /* synthetic */ void setParkedWorkersStack$volatile(long j) {
        this.parkedWorkersStack$volatile = j;
    }

    private final /* synthetic */ void set_isTerminated$volatile(int i) {
        this._isTerminated$volatile = i;
    }

    public final int availableCpuPermits(long j) {
        return (int) ((j & 9223367638808264704L) >> 42);
    }

    public final class Worker extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU;
        private volatile int indexInArray;
        public final m localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private final Ref$ObjectRef<g> stolenTask;
        private long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        static {
            Covode.recordClassIndex(659319);
            workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        }

        private final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        private final /* synthetic */ void setWorkerCtl$volatile(int i) {
            this.workerCtl$volatile = i;
        }

        public final void setIndexInArray(int i) {
            kotlinx_coroutines_scheduling_CoroutineScheduler$Worker_com_dragon_read_aop_CoroutineSchedulerAop_setIndexInArray(this, i);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        private final boolean inStack() {
            if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                return true;
            }
            return false;
        }

        public final boolean isIo() {
            if (this.state == WorkerState.BLOCKING) {
                return true;
            }
            return false;
        }

        private final g findBlockingTask() {
            g l = this.localQueue.l();
            if (l == null) {
                g e = CoroutineScheduler.this.globalBlockingQueue.e();
                if (e == null) {
                    return trySteal(1);
                }
                return e;
            }
            return l;
        }

        private final g findCpuTask() {
            g n = this.localQueue.n();
            if (n == null) {
                g e = CoroutineScheduler.this.globalBlockingQueue.e();
                if (e == null) {
                    return trySteal(2);
                }
                return e;
            }
            return n;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final g pollGlobalQueues() {
            if (nextInt(2) == 0) {
                g e = CoroutineScheduler.this.globalCpuQueue.e();
                if (e != null) {
                    return e;
                }
                return CoroutineScheduler.this.globalBlockingQueue.e();
            }
            g e2 = CoroutineScheduler.this.globalBlockingQueue.e();
            if (e2 != null) {
                return e2;
            }
            return CoroutineScheduler.this.globalCpuQueue.e();
        }

        private final boolean tryAcquireCpuPermit() {
            boolean z;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater controlState$volatile$FU = CoroutineScheduler.getControlState$volatile$FU();
            while (true) {
                long j = controlState$volatile$FU.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                    if (CoroutineScheduler.getControlState$volatile$FU().compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.state = WorkerState.CPU_ACQUIRED;
                return true;
            }
            return false;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            workerCtl$volatile$FU.set(this, -1);
            while (inStack() && workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        public final long runSingleTask() {
            boolean z;
            g findBlockingTask;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                findBlockingTask = findCpuTask();
            } else {
                findBlockingTask = findBlockingTask();
            }
            if (findBlockingTask == null) {
                long j = this.minDelayUntilStealableTaskNs;
                if (j == 0) {
                    return -1L;
                }
                return j;
            }
            CoroutineScheduler.this.runSafely(findBlockingTask);
            if (!z) {
                CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, -2097152L);
            }
            return 0L;
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    g findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs != 0) {
                            if (!z) {
                                z = true;
                            } else {
                                tryReleaseCpu(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                                this.minDelayUntilStealableTaskNs = 0L;
                            }
                        } else {
                            tryPark();
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (CoroutineScheduler.getControlState$volatile$FU().get(coroutineScheduler) & 2097151)) <= coroutineScheduler.corePoolSize) {
                    return;
                }
                if (!workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                    return;
                }
                int i = this.indexInArray;
                setIndexInArray(0);
                coroutineScheduler.parkedWorkersStackTopUpdate(this, i, 0);
                int andDecrement = (int) (CoroutineScheduler.getControlState$volatile$FU().getAndDecrement(coroutineScheduler) & 2097151);
                if (andDecrement != i) {
                    Worker b = coroutineScheduler.workers.b(andDecrement);
                    Intrinsics.checkNotNull(b);
                    Worker worker = b;
                    coroutineScheduler.workers.c(i, worker);
                    worker.setIndexInArray(i);
                    coroutineScheduler.parkedWorkersStackTopUpdate(worker, andDecrement, i);
                }
                coroutineScheduler.workers.c(andDecrement, null);
                Unit unit = Unit.INSTANCE;
                this.state = WorkerState.TERMINATED;
            }
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        private final void idleReset(int i) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
        }

        public final g findTask(boolean z) {
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z);
            }
            return findBlockingTask();
        }

        private final void afterTask(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int i) {
            if (i != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork();
            }
        }

        private final void executeTask(g gVar) {
            int b = gVar.taskContext.b();
            idleReset(b);
            beforeTask(b);
            CoroutineScheduler.this.runSafely(gVar);
            afterTask(b);
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            boolean z;
            WorkerState workerState2 = this.state;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        private Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new m();
            this.stolenTask = new Ref$ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            int nanoTime = (int) System.nanoTime();
            this.rngState = nanoTime == 0 ? 42 : nanoTime;
        }

        private final g findAnyTask(boolean z) {
            boolean z2;
            g pollGlobalQueues;
            g pollGlobalQueues2;
            if (z) {
                if (nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                g k = this.localQueue.k();
                if (k != null) {
                    return k;
                }
                if (!z2 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                g pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        public final void CoroutineScheduler$Worker__setIndexInArray$___twin___(int i) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            if (i == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = i;
        }

        private final g trySteal(int i) {
            int i2 = (int) (CoroutineScheduler.getControlState$volatile$FU().get(CoroutineScheduler.this) & 2097151);
            if (i2 < 2) {
                return null;
            }
            int nextInt = nextInt(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                nextInt++;
                if (nextInt > i2) {
                    nextInt = 1;
                }
                Worker b = coroutineScheduler.workers.b(nextInt);
                if (b != null && b != this) {
                    long s = b.localQueue.s(i, this.stolenTask);
                    if (s == -1) {
                        Ref$ObjectRef<g> ref$ObjectRef = this.stolenTask;
                        g gVar = ref$ObjectRef.element;
                        ref$ObjectRef.element = null;
                        return gVar;
                    }
                    if (s > 0) {
                        j = Math.min(j, s);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.minDelayUntilStealableTaskNs = j;
            return null;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
            if (c3.g() && CoroutineSchedulerRename.a.a().disable) {
                Intrinsics.checkNotNullExpressionValue(this, "get(...)");
                al2.f.b(this);
            }
        }

        @TargetClass("kotlinx.coroutines.scheduling.CoroutineScheduler$Worker")
        @Insert("setIndexInArray")
        public static void kotlinx_coroutines_scheduling_CoroutineScheduler$Worker_com_dragon_read_aop_CoroutineSchedulerAop_setIndexInArray(Worker worker, int i) {
            if (c3.g() && CoroutineSchedulerRename.a.a().disable) {
                Intrinsics.checkNotNullExpressionValue(worker, "get(...)");
                al2.f.a(worker, i);
            } else {
                worker.CoroutineScheduler$Worker__setIndexInArray$___twin___(i);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    private final void decrementBlockingTasks() {
        getControlState$volatile$FU().addAndGet(this, -2097152L);
    }

    private final int decrementCreatedWorkers() {
        return (int) (getControlState$volatile$FU().getAndDecrement(this) & 2097151);
    }

    private final int getCreatedWorkers() {
        return (int) (getControlState$volatile$FU().get(this) & 2097151);
    }

    private final long incrementBlockingTasks() {
        return controlState$volatile$FU.addAndGet(this, 2097152L);
    }

    private final int incrementCreatedWorkers() {
        return (int) (controlState$volatile$FU.incrementAndGet(this) & 2097151);
    }

    private final long releaseCpuPermit() {
        return getControlState$volatile$FU().addAndGet(this, 4398046511104L);
    }

    public final boolean isTerminated() {
        if (_isTerminated$volatile$FU.get(this) != 0) {
            return true;
        }
        return false;
    }

    private final Worker currentWorker() {
        Worker worker;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    private final int getAvailableCpuPermits() {
        return (int) ((controlState$volatile$FU.get(this) & 9223367638808264704L) >> 42);
    }

    private final boolean tryUnpark() {
        Worker parkedWorkersStackPop;
        do {
            parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
        } while (!Worker.workerCtl$volatile$FU.compareAndSet(parkedWorkersStackPop, -1, 0));
        LockSupport.unpark(parkedWorkersStackPop);
        return true;
    }

    public final void signalCpuWork() {
        if (tryUnpark() || tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        tryUnpark();
    }

    static {
        Covode.recordClassIndex(659316);
        Companion = new Companion(null);
        parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
        controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
        _isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
        NOT_IN_STACK = new f0("NOT_IN_STACK");
    }

    private final Worker parkedWorkersStackPop() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            Worker b = this.workers.b((int) (2097151 & j));
            if (b == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(b);
            if (parkedWorkersStackNextIndex >= 0 && parkedWorkersStack$volatile$FU.compareAndSet(this, j, parkedWorkersStackNextIndex | j2)) {
                b.setNextParkedWorker(NOT_IN_STACK);
                return b;
            }
        }
    }

    private final boolean tryAcquireCpuPermit() {
        long j;
        AtomicLongFieldUpdater controlState$volatile$FU2 = getControlState$volatile$FU();
        do {
            j = controlState$volatile$FU2.get(this);
            if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
            } else {
                return false;
            }
        } while (!getControlState$volatile$FU().compareAndSet(this, j, j - 4398046511104L));
        return true;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class WorkerState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WorkerState[] $VALUES;
        public static final WorkerState BLOCKING;
        public static final WorkerState CPU_ACQUIRED;
        public static final WorkerState DORMANT;
        public static final WorkerState PARKING;
        public static final WorkerState TERMINATED;

        private static final /* synthetic */ WorkerState[] $values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, PARKING, DORMANT, TERMINATED};
        }

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(659320);
            CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
            BLOCKING = new WorkerState("BLOCKING", 1);
            PARKING = new WorkerState("PARKING", 2);
            DORMANT = new WorkerState("DORMANT", 3);
            TERMINATED = new WorkerState("TERMINATED", 4);
            WorkerState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private WorkerState(String str, int i) {
        }
    }

    private final int createNewWorker() {
        int coerceAtLeast;
        boolean z;
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = controlState$volatile$FU.get(this);
            int i = (int) (j & 2097151);
            boolean z2 = false;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (coerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i2 = ((int) (getControlState$volatile$FU().get(this) & 2097151)) + 1;
            if (i2 > 0 && this.workers.b(i2) == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Worker worker = new Worker(this, i2);
                this.workers.c(i2, worker);
                if (i2 == ((int) (2097151 & controlState$volatile$FU.incrementAndGet(this)))) {
                    z2 = true;
                }
                if (z2) {
                    int i3 = coerceAtLeast + 1;
                    worker.start();
                    return i3;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a = this.workers.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < a; i6++) {
            Worker b = this.workers.b(i6);
            if (b != null) {
                int i7 = b.localQueue.i();
                int i8 = WhenMappings.$EnumSwitchMapping$0[b.state.ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5) {
                                    i5++;
                                }
                            } else {
                                i4++;
                                if (i7 > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(i7);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i++;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(i7);
                            sb2.append('c');
                            arrayList.add(sb2.toString());
                        }
                    } else {
                        i2++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append('b');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    i3++;
                }
            }
        }
        long j = controlState$volatile$FU.get(this);
        return this.schedulerName + '@' + b0.b(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.c() + ", global blocking queue size = " + this.globalBlockingQueue.c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch$default(this, runnable, null, false, 6, null);
    }

    private final boolean addToGlobalQueue(g gVar) {
        boolean z = true;
        if (gVar.taskContext.b() != 1) {
            z = false;
        }
        if (z) {
            return this.globalBlockingQueue.a(gVar);
        }
        return this.globalCpuQueue.a(gVar);
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    public final void runSafely(g gVar) {
        try {
            gVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    private final boolean tryCreateWorker(long j) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0);
        if (coerceAtLeast < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean parkedWorkersStackPush(Worker worker) {
        long j;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.workers.b((int) (2097151 & j)));
        } while (!parkedWorkersStack$volatile$FU.compareAndSet(this, j, ((2097152 + j) & (-2097152)) | indexInArray));
        return true;
    }

    public final void shutdown(long j) {
        int i;
        g e;
        if (!_isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker currentWorker = currentWorker();
        synchronized (this.workers) {
            i = (int) (getControlState$volatile$FU().get(this) & 2097151);
        }
        if (1 <= i) {
            int i2 = 1;
            while (true) {
                Worker b = this.workers.b(i2);
                Intrinsics.checkNotNull(b);
                Worker worker = b;
                if (worker != currentWorker) {
                    while (worker.getState() != Thread.State.TERMINATED) {
                        LockSupport.unpark(worker);
                        worker.join(j);
                    }
                    worker.localQueue.j(this.globalBlockingQueue);
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.globalBlockingQueue.b();
        this.globalCpuQueue.b();
        while (true) {
            if (currentWorker != null) {
                e = currentWorker.findTask(true);
                if (e != null) {
                    continue;
                    runSafely(e);
                }
            }
            e = this.globalCpuQueue.e();
            if (e == null && (e = this.globalBlockingQueue.e()) == null) {
                break;
            }
            runSafely(e);
        }
        if (currentWorker != null) {
            currentWorker.tryReleaseCpu(WorkerState.TERMINATED);
        }
        parkedWorkersStack$volatile$FU.set(this, 0L);
        controlState$volatile$FU.set(this, 0L);
    }

    private final void signalBlockingWork(long j, boolean z) {
        if (z || tryUnpark() || tryCreateWorker(j)) {
            return;
        }
        tryUnpark();
    }

    public final g createTask(Runnable runnable, h hVar) {
        long a = k.f.a();
        if (runnable instanceof g) {
            g gVar = (g) runnable;
            gVar.submissionTime = a;
            gVar.taskContext = hVar;
            return gVar;
        }
        return new j(runnable, a, hVar);
    }

    private final g submitToLocalQueue(Worker worker, g gVar, boolean z) {
        if (worker == null) {
            return gVar;
        }
        if (worker.state == WorkerState.TERMINATED) {
            return gVar;
        }
        if (gVar.taskContext.b() == 0 && worker.state == WorkerState.BLOCKING) {
            return gVar;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.a(gVar, z);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    i3 = parkedWorkersStackNextIndex(worker);
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0 && parkedWorkersStack$volatile$FU.compareAndSet(this, j, j2 | i3)) {
                return;
            }
        }
    }

    public final void dispatch(Runnable runnable, h hVar, boolean z) {
        boolean z2;
        long j;
        kotlinx.coroutines.c.a();
        g createTask = createTask(runnable, hVar);
        boolean z3 = false;
        if (createTask.taskContext.b() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            j = controlState$volatile$FU.addAndGet(this, 2097152L);
        } else {
            j = 0;
        }
        Worker currentWorker = currentWorker();
        g submitToLocalQueue = submitToLocalQueue(currentWorker, createTask, z);
        if (submitToLocalQueue != null && !addToGlobalQueue(submitToLocalQueue)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (z && currentWorker != null) {
            z3 = true;
        }
        if (z2) {
            signalBlockingWork(j, z3);
        } else {
            if (z3) {
                return;
            }
            signalCpuWork();
        }
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = controlState$volatile$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(j);
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i >= 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 >= i) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (i2 <= 2097150) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (j > 0) {
                        this.globalCpuQueue = new c();
                        this.globalBlockingQueue = new c();
                        this.workers = new a0<>((i + 1) * 2);
                        this.controlState$volatile = i << 42;
                        this._isTerminated$volatile = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, h hVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            hVar = k.g;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, hVar, z);
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? k.e : j, (i3 & 8) != 0 ? k.a : str);
    }
}
