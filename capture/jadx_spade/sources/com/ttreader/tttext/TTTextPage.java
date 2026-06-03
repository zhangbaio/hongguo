package com.ttreader.tttext;

import android.graphics.Canvas;
import com.bytedance.covode.number.Covode;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTTextPage {
    public final long a;
    public final float b;
    public final float c;
    private o[] d;

    static {
        Covode.recordClassIndex(654824);
    }

    native void DestroyPage(long j);

    native byte[] DrawPage(long j, long j2);

    native byte[] nativeFillLines(long j);

    native float nativeLayoutHeight(long j);

    native float nativeLayoutWidth(long j);

    native int nativeLineCount(long j);

    public float a() {
        return nativeLayoutHeight(this.a);
    }

    public float b() {
        return nativeLayoutWidth(this.a);
    }

    public int e() {
        return nativeLineCount(this.a);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.a;
        if (j != 0) {
            DestroyPage(j);
        }
    }

    public void d() {
        a aVar = new a(new ByteArrayInputStream(nativeFillLines(this.a)));
        try {
            int readInt = aVar.readInt();
            this.d = new o[readInt];
            for (int i = 0; i < readInt; i++) {
                o oVar = new o();
                float readFloat = aVar.readFloat();
                float readFloat2 = aVar.readFloat();
                float readFloat3 = aVar.readFloat();
                float readFloat4 = aVar.readFloat();
                float readFloat5 = aVar.readFloat();
                m mVar = oVar.a;
                mVar.a = readFloat;
                mVar.b = readFloat2;
                mVar.c = readFloat3;
                mVar.d = readFloat4;
                mVar.e = readFloat5;
                int readInt2 = aVar.readInt();
                int readInt3 = aVar.readInt();
                l lVar = oVar.b;
                lVar.a = readInt2;
                lVar.b = readInt3;
                this.d[i] = oVar;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public o f(int i) {
        return this.d[i];
    }

    public TTTextPage(long j, float f, float f2) {
        this.a = j;
        this.b = f;
        this.c = f2;
    }

    public void c(Canvas canvas, d dVar, j jVar) {
        if (this.a == 0) {
            return;
        }
        JavaDrawerCallback javaDrawerCallback = new JavaDrawerCallback(dVar);
        new i(canvas, jVar, javaDrawerCallback).g(DrawPage(this.a, javaDrawerCallback.GetInstance()));
    }
}
