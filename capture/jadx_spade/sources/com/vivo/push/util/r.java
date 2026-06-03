package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r implements s {
    private static final String a;

    static {
        Covode.recordClassIndex(655203);
        a = "(" + Process.myPid() + ")";
    }

    private static boolean a() {
        t.a();
        if (com.vivo.push.i.a.a().b()) {
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.util.s
    public final void a(Context context, String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    @Override // com.vivo.push.util.s
    public final void b(Context context, String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.s
    public final void c(Context context, String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.s
    public final int b(String str, String str2) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(str)), a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int c(String str, String str2) {
        return Log.d("VivoPush.Client.".concat(String.valueOf(str)), a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int d(String str, String str2) {
        if (t.a()) {
            return Log.i("VivoPush.Client.".concat(String.valueOf(str)), a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.s
    public final int e(String str, String str2) {
        if (t.a()) {
            return Log.v("VivoPush.Client.".concat(String.valueOf(str)), a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.s
    public final int a(String str, String str2) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), a + str2);
    }

    @Override // com.vivo.push.util.s
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    private void a(Context context, String str, int i) {
        com.vivo.push.b.n nVar = new com.vivo.push.b.n();
        nVar.b(str);
        nVar.a(i);
        if (i > 0) {
            d("LogController", str);
        }
        nVar.h();
        com.vivo.push.a.a.a(context, nVar, context.getPackageName());
    }

    @Override // com.vivo.push.util.s
    public final int b(String str, String str2, Throwable th) {
        if (t.a()) {
            return Log.i("VivoPush.Client.".concat(String.valueOf(str)), a + str2, th);
        }
        return -1;
    }

    @Override // com.vivo.push.util.s
    public final int a(String str, String str2, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), a + str2, th);
    }
}
