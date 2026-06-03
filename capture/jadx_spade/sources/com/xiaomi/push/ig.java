package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ig extends ij {
    protected InputStream a;

    /* renamed from: a, reason: collision with other field name */
    protected OutputStream f837a;

    static {
        Covode.recordClassIndex(655613);
    }

    protected ig() {
        this.a = null;
        this.f837a = null;
    }

    public ig(OutputStream outputStream) {
        this.a = null;
        this.f837a = outputStream;
    }

    @Override // com.xiaomi.push.ij
    /* renamed from: a, reason: collision with other method in class */
    public void mo626a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f837a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e) {
                throw new ik(0, e);
            }
        }
        throw new ik(1, "Cannot write to null outputStream");
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new ik(4);
            } catch (IOException e) {
                throw new ik(0, e);
            }
        }
        throw new ik(1, "Cannot read from null inputStream");
    }
}
