package com.tencent.open.log;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f implements Iterable<String> {
    private ConcurrentLinkedQueue<String> a;
    private AtomicInteger b;

    static {
        Covode.recordClassIndex(653545);
    }

    public int a() {
        return this.b.get();
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.a.iterator();
    }

    public void b() {
        this.a.clear();
        this.b.set(0);
    }

    public f() {
        this.a = null;
        this.b = null;
        this.a = new ConcurrentLinkedQueue<>();
        this.b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.a.add(str);
        return this.b.addAndGet(length);
    }

    public void a(Writer[] writerArr, char[] cArr) throws IOException {
        int i;
        if (writerArr != null && cArr != null && cArr.length != 0 && writerArr.length >= 2) {
            Writer writer = writerArr[0];
            Writer writer2 = writerArr[1];
            int length = cArr.length;
            Iterator<String> it2 = iterator();
            int i2 = length;
            int i3 = 0;
            while (it2.hasNext()) {
                String next = it2.next();
                int length2 = next.length();
                int i4 = 0;
                while (length2 > 0) {
                    if (i2 > length2) {
                        i = length2;
                    } else {
                        i = i2;
                    }
                    int i5 = i4 + i;
                    next.getChars(i4, i5, cArr, i3);
                    i2 -= i;
                    i3 += i;
                    length2 -= i;
                    if (i2 == 0) {
                        if (writer != null) {
                            try {
                                writer.write(cArr, 0, length);
                            } catch (Exception unused) {
                            }
                        }
                        if (writer2 != null) {
                            try {
                                writer2.write(cArr, 0, length);
                            } catch (Exception unused2) {
                            }
                        }
                        i2 = length;
                        i4 = i5;
                        i3 = 0;
                    } else {
                        i4 = i5;
                    }
                }
            }
            if (i3 > 0) {
                if (writer != null) {
                    try {
                        writer.write(cArr, 0, i3);
                    } catch (Exception unused3) {
                    }
                }
                if (writer2 != null) {
                    try {
                        writer2.write(cArr, 0, i3);
                    } catch (Exception unused4) {
                    }
                }
            }
            if (writer != null) {
                try {
                    writer.flush();
                } catch (Exception unused5) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.flush();
                } catch (Exception unused6) {
                }
            }
        }
    }
}
