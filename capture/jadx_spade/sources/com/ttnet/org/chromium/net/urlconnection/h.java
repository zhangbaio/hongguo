package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.i;
import java.io.EOFException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h {
    private Segment a = null;
    public int b = 0;

    static {
        Covode.recordClassIndex(654694);
    }

    public byte b() {
        if (this.b <= 0) {
            return (byte) 0;
        }
        byte[] bArr = new byte[1];
        d(bArr, 0, 1);
        return bArr[0];
    }

    public void f() {
        while (true) {
            Segment segment = this.a;
            if (segment != null) {
                this.a = segment.release();
            } else {
                return;
            }
        }
    }

    Segment c() {
        Segment segment = this.a;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.a = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        if (!segment2.isWritable()) {
            segment2.push(SegmentPool.take());
        }
        return this.a.prev;
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) >= 0 && j2 <= j && j - j2 >= j3) {
        } else {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    private int d(byte[] bArr, int i, int i2) {
        a(bArr.length, i, i2);
        Segment segment = this.a;
        if (segment == null) {
            return -1;
        }
        int innerBufferTo = segment.getInnerBufferTo(bArr, i, i2);
        if (i.b()) {
            i.a("TTBuffer", "head curReadLength is " + innerBufferTo);
        }
        this.b -= innerBufferTo;
        if (!segment.getInnerBuffer().hasRemaining()) {
            this.a = segment.release();
        }
        return innerBufferTo;
    }

    public int e(byte[] bArr, int i, int i2) throws EOFException {
        a(bArr.length, i, i2);
        int min = Math.min(this.b, i2);
        if (i.b()) {
            i.a("TTBuffer", "start get buffer, size is " + this.b + " byteCount is " + i2);
        }
        int i3 = i;
        while (min > 0) {
            int d = d(bArr, i3, min);
            if (d != -1) {
                i3 += d;
                min -= d;
                if (i.b()) {
                    i.a("TTBuffer", "get segment buffer, n is " + d + " offset is " + i3 + " bytesRead is " + min);
                }
            } else {
                throw new EOFException();
            }
        }
        return i3 - i;
    }
}
