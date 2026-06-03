package com.ttreader.tttext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.covode.number.Covode;
import java.io.ByteArrayInputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JavaDrawerCallback {
    private final d callback_;
    private final long instance_;

    static {
        Covode.recordClassIndex(654794);
    }

    private native long nativeCreateDrawerCallback();

    private native void nativeDestroyDrawerCallback(long j);

    public long GetInstance() {
        return this.instance_;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.instance_;
        if (j != 0) {
            nativeDestroyDrawerCallback(j);
        }
    }

    public void DrawTexture(int i) {
        this.callback_.c(i);
    }

    public void HandleDrawException(Throwable th) {
        this.callback_.d(th);
    }

    void OnPreDrawBuffer(byte[] bArr) {
        this.callback_.g(bArr);
    }

    public JavaDrawerCallback(d dVar) {
        this.callback_ = dVar;
        long nativeCreateDrawerCallback = nativeCreateDrawerCallback();
        this.instance_ = nativeCreateDrawerCallback;
        if (nativeCreateDrawerCallback == 0) {
            dVar.d(new RuntimeException("nativeCreateDrawerCallback"));
        }
    }

    public int FetchThemeColor(byte[] bArr) {
        a aVar = new a(new ByteArrayInputStream(bArr));
        try {
            int readInt = aVar.readInt();
            return this.callback_.b(TTTextDefinition.g(readInt), aVar.readInt(), aVar.a());
        } catch (Exception e) {
            HandleDrawException(e);
            return 0;
        }
    }

    public void DrawBackgroundDelegate(IRunDelegate iRunDelegate, Rect rect) {
        if (iRunDelegate == null) {
            return;
        }
        this.callback_.f(iRunDelegate, rect);
    }

    public void DrawRunDelegate(Canvas canvas, IRunDelegate iRunDelegate, Rect rect) {
        if (iRunDelegate == null) {
            return;
        }
        this.callback_.e(canvas, iRunDelegate, rect);
    }

    public void DrawHighlight(Canvas canvas, String str, float f, float f2, float f3, float f4, Paint paint) {
        this.callback_.a(canvas, str, f, f2, f3, f4, paint);
    }
}
