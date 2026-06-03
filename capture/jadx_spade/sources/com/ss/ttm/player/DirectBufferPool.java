package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttm.utils.AVLogger;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DirectBufferPool {
    private static volatile DirectBufferPool instance;
    private int mCheckIntervalMs;
    private AtomicInteger bufferPoolSizeLimit = new AtomicInteger(2);
    private Queue<DirectBufferUnion> bufferPool = new LinkedBlockingQueue();

    static {
        Covode.recordClassIndex(652098);
    }

    public static DirectBufferPool getInstance() {
        if (instance == null) {
            synchronized (DirectBufferPool.class) {
                if (instance == null) {
                    instance = new DirectBufferPool();
                }
            }
        }
        return instance;
    }

    private DirectBufferPool() {
        this.mCheckIntervalMs = 30000;
        setDirectBufferPoolSize(TTPlayerConfiger.getValue(84, 2));
        boolean z = TTPlayerConfiger.getValue(85, 0) != 0;
        int value = TTPlayerConfiger.getValue(86, 30000);
        this.mCheckIntervalMs = value;
        if (z && value > 0) {
            ScheduledExecutorService newScheduledThreadPool = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("DirectBufferPool"), "com.ss.ttm.player.DirectBufferPool");
            Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.d
                @Override // java.lang.Runnable
                public final void run() {
                    DirectBufferPool.this.checkExpireThreadPeriod();
                }
            };
            int i = this.mCheckIntervalMs;
            newScheduledThreadPool.scheduleWithFixedDelay(runnable, i, i, TimeUnit.MILLISECONDS);
        }
        AVLogger.InfoTrackLife("DirectBufferPool", this, "create direct buffer pool, needCheckExpire:" + z + ", mCheckIntervalMs:" + this.mCheckIntervalMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkExpireThreadPeriod() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (DirectBufferUnion.class) {
            while (!this.bufferPool.isEmpty() && currentTimeMillis - this.bufferPool.peek().freeTimePoint > this.mCheckIntervalMs) {
                linkedBlockingQueue.offer(this.bufferPool.peek());
                this.bufferPool.poll();
            }
        }
        AVLogger.InfoTrackLife("DirectBufferPool", this, "exist direct buffer after check expire:" + this.bufferPool.size() + ", clean size:" + linkedBlockingQueue.size());
        while (!linkedBlockingQueue.isEmpty()) {
            ByteBuffer byteBuffer = ((DirectBufferUnion) linkedBlockingQueue.poll()).buffer;
            if (byteBuffer != null) {
                clean(byteBuffer);
            }
        }
    }

    public void setDirectBufferPoolSize(int i) {
        AVLogger.InfoTrackLife("DirectBufferPool", this, "set direct buffer pool size:" + i);
        this.bufferPoolSizeLimit.set(i);
    }

    public void clean(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return;
        }
        AVLogger.InfoTrackLife("DirectBufferPool", this, "start clean direct buffer");
        try {
            if (byteBuffer.isDirect()) {
                Method method = byteBuffer.getClass().getMethod("cleaner", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(byteBuffer, new Object[0]);
                if (invoke != null) {
                    invoke.getClass().getMethod("clean", new Class[0]).invoke(invoke, new Object[0]);
                }
            }
        } catch (Exception unused) {
        }
    }

    public ByteBuffer getReuseDirectBuffer(int i) {
        if (this.bufferPool.isEmpty()) {
            AVLogger.InfoTrackLife("DirectBufferPool", this, "pool is empty, find match direct buffer fail");
            return null;
        }
        synchronized (this) {
            DirectBufferUnion directBufferUnion = null;
            for (DirectBufferUnion directBufferUnion2 : this.bufferPool) {
                int i2 = directBufferUnion2.size;
                if (i2 == i) {
                    this.bufferPool.remove(directBufferUnion2);
                    AVLogger.InfoTrackLife("DirectBufferPool", this, "find best-match direct buffer, after pool size:" + this.bufferPool.size());
                    return directBufferUnion2.buffer;
                }
                if (i2 > i) {
                    directBufferUnion = directBufferUnion2;
                }
            }
            if (directBufferUnion != null) {
                this.bufferPool.remove(directBufferUnion);
                AVLogger.InfoTrackLife("DirectBufferPool", this, "find size not-match direct buffer, after pool size:" + this.bufferPool.size());
                return directBufferUnion.buffer;
            }
            AVLogger.InfoTrackLife("DirectBufferPool", this, "find match direct buffer fail, pool size:" + this.bufferPool.size());
            return null;
        }
    }

    public int pushDirectBufferBack(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return 0;
        }
        int capacity = byteBuffer.capacity();
        byteBuffer.clear();
        synchronized (this) {
            Iterator<DirectBufferUnion> it2 = this.bufferPool.iterator();
            while (it2.hasNext()) {
                if (it2.next().size == capacity) {
                    clean(byteBuffer);
                    AVLogger.InfoTrackLife("DirectBufferPool", this, "pool has similarity direct buffer, size:" + this.bufferPool.size());
                    return -1;
                }
            }
            DirectBufferUnion directBufferUnion = new DirectBufferUnion(byteBuffer, capacity);
            if (this.bufferPool.size() < this.bufferPoolSizeLimit.get()) {
                if (this.bufferPool.offer(directBufferUnion)) {
                    directBufferUnion.resetFreeTimePoint();
                    AVLogger.InfoTrackLife("DirectBufferPool", this, "push direct buffer success, size:" + this.bufferPool.size());
                }
            } else {
                DirectBufferUnion poll = this.bufferPool.poll();
                if (poll != null) {
                    clean(poll.buffer);
                }
                if (this.bufferPool.offer(directBufferUnion)) {
                    directBufferUnion.resetFreeTimePoint();
                    AVLogger.InfoTrackLife("DirectBufferPool", this, "push direct buffer after poll success, size:" + this.bufferPool.size());
                }
            }
            return 0;
        }
    }
}
