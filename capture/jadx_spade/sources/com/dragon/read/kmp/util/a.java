package com.dragon.read.kmp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.e1;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static final CoroutineScope b;
    public static final int c;

    private a() {
    }

    static {
        Covode.recordClassIndex(609454);
        a = new a();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        c = 8;
    }

    public final Object b(String str, int i, int i2, Continuation<? super e1> continuation) {
        try {
            if (!new PolarisFileWrapper(str).exists()) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = BitmapCommonUtils.a.a(i, i2, options.outWidth, options.outHeight);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile == null) {
                return null;
            }
            return androidx.compose.ui.graphics.j.c(decodeFile);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Object a(String str, int i, int i2, float f, Continuation<? super e1> continuation) {
        try {
            if (!new PolarisFileWrapper(str).exists()) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = BitmapCommonUtils.a.b(i, i2, options.outWidth, options.outHeight, f);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile == null) {
                return null;
            }
            return androidx.compose.ui.graphics.j.c(decodeFile);
        } catch (Exception unused) {
            return null;
        }
    }
}
