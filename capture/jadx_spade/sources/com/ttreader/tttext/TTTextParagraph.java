package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTTextParagraph {
    private long d;
    private ArrayList<q> c = new ArrayList<>();
    public TTLayoutConfig b = new TTLayoutConfig();
    public p a = new p();

    native long CreateInstance();

    native void DestroyInstance(long j);

    native void UpdateParagraph(long j, byte[] bArr);

    static {
        Covode.recordClassIndex(654825);
    }

    public long c() {
        UpdateParagraph(this.d, b());
        return this.d;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.d;
        if (j != 0) {
            DestroyInstance(j);
        }
    }

    public TTTextParagraph() {
        this.d = 0L;
        this.d = CreateInstance();
    }

    byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b bVar = new b(byteArrayOutputStream);
        try {
            bVar.writeLong(this.b.b());
            e(this.a, bVar);
            bVar.writeInt(this.c.size());
            Iterator<q> it2 = this.c.iterator();
            while (it2.hasNext()) {
                f(it2.next(), bVar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void a(q qVar) {
        this.c.add(qVar);
    }

    void d(n nVar, b bVar) throws IOException {
        IRunDelegate iRunDelegate = nVar.d;
        bVar.writeInt(nVar.c);
        if (iRunDelegate == null) {
            bVar.writeFloat(0.0f);
            bVar.writeFloat(0.0f);
            bVar.writeFloat(0.0f);
        } else {
            bVar.writeFloat(iRunDelegate.GetAdvance());
            bVar.writeFloat(iRunDelegate.GetAscent());
            bVar.writeFloat(iRunDelegate.GetDescent());
        }
    }

    void e(p pVar, b bVar) throws IOException {
        bVar.writeInt(pVar.a.ordinal());
        bVar.writeInt(pVar.b.ordinal());
        bVar.writeFloat(pVar.c);
        bVar.writeFloat(pVar.d);
        bVar.writeFloat(pVar.e);
        bVar.writeFloat(pVar.f);
        bVar.writeFloat(pVar.g);
        bVar.writeFloat(pVar.h);
        bVar.writeFloat(pVar.i);
    }

    void f(q qVar, b bVar) throws IOException {
        bVar.a(qVar.a);
        g(qVar.b, bVar);
        if ((qVar instanceof n) && qVar.a.equals(n.e)) {
            bVar.writeBoolean(true);
            d((n) qVar, bVar);
        } else {
            bVar.writeBoolean(false);
        }
    }

    void g(r rVar, b bVar) throws IOException {
        bVar.writeInt(JavaFontManager.GetInstance().RegisterFont(rVar.a));
        bVar.writeFloat(rVar.b);
        bVar.writeFloat(rVar.c);
        bVar.writeInt(rVar.d);
        bVar.writeInt(rVar.e);
        bVar.writeInt(rVar.f);
        bVar.writeInt(rVar.g.ordinal());
        bVar.writeBoolean(rVar.h);
        bVar.writeBoolean(rVar.i);
        bVar.writeInt(rVar.j.ordinal());
    }
}
