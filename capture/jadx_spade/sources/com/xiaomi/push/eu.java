package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class eu {
    public static final byte[] a;

    /* renamed from: a, reason: collision with other field name */
    private byte f412a;

    /* renamed from: a, reason: collision with other field name */
    private int f413a;

    /* renamed from: a, reason: collision with other field name */
    private short f414a;
    private byte[] b;

    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    public static final class c {
        static {
            Covode.recordClassIndex(655505);
        }
    }

    public static class a {
        public static final c a;

        /* renamed from: a, reason: collision with other field name */
        public static final d f415a;

        static {
            Covode.recordClassIndex(655503);
            a = new c();
            f415a = new d();
        }

        public static byte[] a(byte[] bArr) {
            return a(bArr, f415a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (eu.m408a(bArr)) {
                eu a2 = eu.a(bArr);
                if (a2.f412a == 0 || a2.f412a != bVar.a()) {
                    return a2.b;
                }
                return bVar.a(a2.b, a2.f413a);
            }
            return bArr;
        }
    }

    static {
        Covode.recordClassIndex(655502);
        a = new byte[]{80, 85, 83, 72};
    }

    public static eu a(byte[] bArr) {
        if (m408a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return a(s, b2, i, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m408a(byte[] bArr) {
        byte[] bArr2 = a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static final class d implements b {
        static {
            Covode.recordClassIndex(655506);
        }

        @Override // com.xiaomi.push.eu.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.eu.b
        public byte[] a(byte[] bArr, int i) {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bArr2;
                } catch (IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    protected eu(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
    }

    public static eu a(byte b2, int i, byte[] bArr) {
        return new eu(b2, i, bArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    protected eu(short s, byte b2, int i, byte[] bArr) {
        this.f414a = s;
        this.f412a = b2;
        this.f413a = i;
        this.b = bArr;
    }

    public static eu a(short s, byte b2, int i, byte[] bArr) {
        return new eu(s, b2, i, bArr);
    }
}
