package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Segment {
    private static int sSize;
    private static boolean sSizeInited;
    private static final ReentrantReadWriteLock sSizeLock;
    private ByteBuffer bb;
    private boolean bufferFlipped = false;
    Segment next;
    Segment prev;

    Segment() {
        getInnerBuffer();
    }

    public void completeRead() {
        this.bb.flip();
        this.bufferFlipped = true;
    }

    public boolean isWritable() {
        if (!this.bufferFlipped && this.bb.hasRemaining()) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(654692);
        sSize = 32768;
        sSizeInited = false;
        sSizeLock = new ReentrantReadWriteLock();
    }

    public ByteBuffer getInnerBuffer() {
        if (this.bb == null) {
            this.bb = ByteBuffer.allocateDirect(getSize());
        }
        return this.bb;
    }

    public Segment pop() {
        Segment segment;
        Segment segment2 = this.next;
        if (segment2 != this) {
            segment = segment2;
        } else {
            segment = null;
        }
        Segment segment3 = this.prev;
        segment3.next = segment2;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public Segment release() {
        this.bb.clear();
        this.bufferFlipped = false;
        Segment pop = pop();
        if (!SegmentPool.recycle(this)) {
            this.bb = null;
        }
        return pop;
    }

    public static int getSize() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSizeLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            sSizeInited = true;
            int i = sSize;
            reentrantReadWriteLock.readLock().unlock();
            return i;
        } catch (Throwable th) {
            sSizeLock.readLock().unlock();
            throw th;
        }
    }

    public Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public static void setSize(int i) {
        if (sSizeInited) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSizeLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (!sSizeInited) {
                sSizeInited = true;
                sSize = i;
            }
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sSizeLock.writeLock().unlock();
            throw th;
        }
    }

    public int getInnerBufferTo(byte[] bArr, int i, int i2) {
        if (!this.bufferFlipped) {
            return -1;
        }
        int min = Math.min(this.bb.remaining(), i2);
        this.bb.get(bArr, i, min);
        return min;
    }
}
