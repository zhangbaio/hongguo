package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends DataOutputStream {
    static {
        Covode.recordClassIndex(654786);
    }

    public b(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(String str) throws IOException {
        byte[] bytes = str.getBytes();
        c(bytes.length);
        if (bytes.length > 0) {
            write(bytes, 0, bytes.length);
        }
    }

    public void c(int i) throws IOException {
        if (i >= 0 && i < 128) {
            writeByte(i);
            return;
        }
        do {
            byte b = (byte) (i & 127);
            i >>>= 7;
            if (i != 0) {
                b = (byte) (b | Byte.MIN_VALUE);
            }
            writeByte(b);
        } while (i != 0);
    }

    public void d(Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            c(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey());
                a(entry.getValue());
            }
            return;
        }
        c(0);
    }
}
