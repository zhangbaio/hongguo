package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ABLock {
    public static int LOCK_IMPL_NORMAL;
    public static int LOCK_IMPL_READ_WRITE;
    public static int LOCK_IMPL_VOID;
    public static int TYPE_READ;
    public static int TYPE_VOID;
    public static int TYPE_WRITE;
    private final int mImplType;

    public abstract void lock(int i);

    public abstract boolean tryLock(int i);

    public abstract boolean tryLock(int i, long j, TimeUnit timeUnit) throws InterruptedException;

    public abstract void unlock(int i);

    public int getType() {
        return this.mImplType;
    }

    public void lock() {
        lock(TYPE_VOID);
    }

    public void unlock() {
        unlock(TYPE_VOID);
    }

    static {
        Covode.recordClassIndex(652733);
        TYPE_VOID = 0;
        TYPE_READ = 1;
        TYPE_WRITE = 2;
        LOCK_IMPL_NORMAL = 0;
        LOCK_IMPL_VOID = 1;
        LOCK_IMPL_READ_WRITE = 2;
    }

    public static class VoidLock extends ABLock {
        static {
            Covode.recordClassIndex(652736);
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int i) {
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int i) {
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int i, long j, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int i) {
        }

        public VoidLock(int i) {
            super(i);
        }
    }

    public static class NormalLock extends ABLock {
        private ReentrantLock mLock;

        static {
            Covode.recordClassIndex(652734);
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int i) {
            this.mLock.lock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int i) {
            return this.mLock.tryLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int i) {
            this.mLock.unlock();
        }

        public NormalLock(int i) {
            super(i);
            this.mLock = new ReentrantLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int i, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.mLock.tryLock(j, timeUnit);
        }
    }

    public ABLock(int i) {
        this.mImplType = i;
    }

    public static class OptimizedLock extends ABLock {
        private final ReentrantReadWriteLock.ReadLock mReadLock;
        private final ReentrantReadWriteLock.WriteLock mWriteLock;

        static {
            Covode.recordClassIndex(652735);
        }

        public OptimizedLock(int i) {
            super(i);
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            this.mReadLock = reentrantReadWriteLock.readLock();
            this.mWriteLock = reentrantReadWriteLock.writeLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int i) {
            if (i == ABLock.TYPE_READ) {
                this.mReadLock.lock();
            } else if (i == ABLock.TYPE_WRITE) {
                this.mWriteLock.lock();
            }
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int i) {
            if (i == ABLock.TYPE_READ) {
                return this.mReadLock.tryLock();
            }
            if (i == ABLock.TYPE_WRITE) {
                return this.mWriteLock.tryLock();
            }
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int i) {
            if (i == ABLock.TYPE_READ) {
                this.mReadLock.unlock();
            } else if (i == ABLock.TYPE_WRITE) {
                this.mWriteLock.unlock();
            }
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int i, long j, TimeUnit timeUnit) throws InterruptedException {
            if (i == ABLock.TYPE_READ) {
                return this.mReadLock.tryLock(j, timeUnit);
            }
            if (i == ABLock.TYPE_WRITE) {
                return this.mWriteLock.tryLock(j, timeUnit);
            }
            return true;
        }
    }

    public static ABLock create(int i) {
        TTVideoEngineLog.i("ABLock", "create ABLock type: " + i);
        if (i == LOCK_IMPL_NORMAL) {
            return new NormalLock(i);
        }
        if (i == LOCK_IMPL_VOID) {
            return new VoidLock(i);
        }
        if (i == LOCK_IMPL_READ_WRITE) {
            return new OptimizedLock(i);
        }
        return new NormalLock(LOCK_IMPL_NORMAL);
    }
}
