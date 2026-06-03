package com.ttreader.tthighlight;

import com.bytedance.covode.number.Covode;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CBufferInputStream extends DataInputStream {
    static {
        Covode.recordClassIndex(654705);
    }

    public String ReadCString() throws IOException {
        int readInt = readInt();
        if (readInt == 0) {
            return "";
        }
        byte[] bArr = new byte[readInt];
        if (read(bArr, 0, readInt) == -1) {
            return "";
        }
        return new String(bArr, Charset.defaultCharset());
    }

    public CBufferInputStream(InputStream inputStream) {
        super(inputStream);
    }
}
