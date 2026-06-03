package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends DataInputStream {
    static {
        Covode.recordClassIndex(654785);
    }

    public int c() throws IOException {
        return readByte() & 255;
    }

    public String a() throws IOException {
        int d = d();
        if (d == 0) {
            return "";
        }
        byte[] bArr = new byte[d];
        if (read(bArr, 0, d) == -1) {
            return "";
        }
        return new String(bArr, Charset.defaultCharset());
    }

    public int d() throws IOException {
        int readUnsignedByte = readUnsignedByte();
        int i = readUnsignedByte & 127;
        int i2 = 7;
        while (readUnsignedByte > 127) {
            readUnsignedByte = readUnsignedByte();
            i |= (readUnsignedByte & 127) << i2;
            i2 += 7;
        }
        return i;
    }

    public a(InputStream inputStream) {
        super(inputStream);
    }

    public a(byte[] bArr) {
        super(new ByteArrayInputStream(bArr));
    }
}
