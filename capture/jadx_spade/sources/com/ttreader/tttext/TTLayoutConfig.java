package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.TTTextDefinition;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTLayoutConfig {
    public float a;
    public float b;
    public float c = 160.0f;
    public boolean d = true;
    public boolean e = false;
    public boolean f = false;
    public TTTextDefinition.InlinePunctuationCompressType g = TTTextDefinition.InlinePunctuationCompressType.kDisable;
    public float h = 0.5f;
    public boolean i = true;
    public int j = 4;
    public float k = 0.0f;
    public int l = 0;
    public int m = 0;
    private final long n = nativeCreateConfig();

    static {
        Covode.recordClassIndex(654799);
    }

    private native long nativeCreateConfig();

    private native void nativeDestroyConfig(long j);

    private native void nativeUpdateConfig(long j, byte[] bArr);

    public long b() {
        c();
        return this.n;
    }

    public void c() {
        nativeUpdateConfig(this.n, a(this));
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nativeDestroyConfig(this.n);
    }

    public enum Alignment {
        kLeft,
        kCenter,
        kRight,
        kJustify,
        kDistribute;

        static {
            Covode.recordClassIndex(654800);
        }
    }

    private static byte[] a(TTLayoutConfig tTLayoutConfig) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeFloat(s.b(tTLayoutConfig.a));
            dataOutputStream.writeFloat(s.b(tTLayoutConfig.b));
            dataOutputStream.writeBoolean(tTLayoutConfig.d);
            dataOutputStream.writeBoolean(tTLayoutConfig.e);
            dataOutputStream.writeBoolean(tTLayoutConfig.f);
            dataOutputStream.writeByte(tTLayoutConfig.g.ordinal());
            dataOutputStream.writeFloat(tTLayoutConfig.h);
            dataOutputStream.writeBoolean(tTLayoutConfig.i);
            dataOutputStream.writeInt(tTLayoutConfig.j);
            dataOutputStream.writeFloat(tTLayoutConfig.k);
            dataOutputStream.writeInt(tTLayoutConfig.l);
            dataOutputStream.writeInt(tTLayoutConfig.m);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
