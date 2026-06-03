package com.ttreader.tttext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.ttreader.tttext.TTTextDefinition;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface d {
    void a(Canvas canvas, String str, float f, float f2, float f3, float f4, Paint paint);

    int b(TTTextDefinition.ThemeColorType themeColorType, int i, String str);

    void c(int i);

    void d(Throwable th);

    void e(Canvas canvas, IRunDelegate iRunDelegate, Rect rect);

    void f(IRunDelegate iRunDelegate, Rect rect);

    void g(byte[] bArr);
}
