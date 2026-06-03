package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ABLockWrapper extends ABLock {
    private ABLock mCurrentLock;
    private ABLock mLastLock;

    static {
        Covode.recordClassIndex(652737);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public int getType() {
        return this.mCurrentLock.getType();
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public void lock(int i) {
        this.mCurrentLock.lock(i);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public boolean tryLock(int i) {
        return this.mCurrentLock.tryLock(i);
    }

    public ABLockWrapper(int i) {
        super(i);
        this.mCurrentLock = ABLock.create(i);
        this.mLastLock = ABLock.create(ABLock.LOCK_IMPL_VOID);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public void unlock(int i) {
        try {
            this.mCurrentLock.unlock(i);
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
            try {
                this.mLastLock.unlock(i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void updateLockType(int i) {
        if (this.mCurrentLock.getType() != i) {
            this.mLastLock = this.mCurrentLock;
            this.mCurrentLock = ABLock.create(i);
        }
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public boolean tryLock(int i, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.mCurrentLock.tryLock(i, j, timeUnit);
    }
}
