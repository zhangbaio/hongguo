package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.i;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SegmentPool {
    static long byteCount;
    static Segment next;
    private static long sMaxSize;
    private static boolean sSizeInited;
    private static final ReentrantReadWriteLock sSizeLock;
    private static final AtomicLong segmentAllocateTimes;
    private static final AtomicLong segmentRequestTimes;
    private static final AtomicLong segmentReuseTimes;

    private SegmentPool() {
    }

    static {
        Covode.recordClassIndex(654693);
        sMaxSize = 262144L;
        sSizeInited = false;
        sSizeLock = new ReentrantReadWriteLock();
        segmentAllocateTimes = new AtomicLong(0L);
        segmentReuseTimes = new AtomicLong(0L);
        segmentRequestTimes = new AtomicLong(0L);
    }

    private static long getSize() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSizeLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            sSizeInited = true;
            long j = sMaxSize;
            reentrantReadWriteLock.readLock().unlock();
            return j;
        } catch (Throwable th) {
            sSizeLock.readLock().unlock();
            throw th;
        }
    }

    static Segment take() {
        synchronized (SegmentPool.class) {
            if (i.b()) {
                segmentRequestTimes.incrementAndGet();
            }
            if (next != null) {
                if (i.b()) {
                    segmentReuseTimes.incrementAndGet();
                }
                Segment segment = next;
                next = segment.next;
                segment.next = null;
                byteCount -= Segment.getSize();
                return segment;
            }
            if (i.b()) {
                AtomicLong atomicLong = segmentAllocateTimes;
                atomicLong.incrementAndGet();
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(segmentRequestTimes.get());
                sb.append(" ");
                sb.append(atomicLong);
                sb.append(" ");
                sb.append(segmentReuseTimes);
                sb.append(" ");
                sb.append(r0.get() / r3.get());
                i.a("SegmentPool", sb.toString());
            }
            return new Segment();
        }
    }

    static boolean recycle(Segment segment) {
        if (segment.next == null && segment.prev == null) {
            synchronized (SegmentPool.class) {
                if (byteCount + Segment.getSize() > getSize()) {
                    return false;
                }
                byteCount += Segment.getSize();
                segment.next = next;
                next = segment;
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void setSize(long j) {
        if (sSizeInited) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSizeLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (!sSizeInited) {
                sSizeInited = true;
                sMaxSize = j;
            }
            sSizeInited = true;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sSizeLock.writeLock().unlock();
            throw th;
        }
    }
}
