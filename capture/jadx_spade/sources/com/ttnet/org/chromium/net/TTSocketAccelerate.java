package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.lang.reflect.Method;

@JNINamespace("net")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTSocketAccelerate {
    private long a = 0;

    interface a {
        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void a(long j, TTSocketAccelerate tTSocketAccelerate, int i, int i2);

        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void b(long j, TTSocketAccelerate tTSocketAccelerate, int i);
    }

    static {
        Covode.recordClassIndex(654536);
    }

    protected TTSocketAccelerate() {
    }

    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    public void checkSystemAvailable() {
        if (this.a == 0) {
            return;
        }
        if (!Build.MANUFACTURER.toLowerCase().contains("honor") && !Build.BRAND.toLowerCase().contains("honor")) {
            a0.c().b(this.a, this, -1002);
        } else if (Build.VERSION.SDK_INT < 29) {
            a0.c().b(this.a, this, -1003);
        } else {
            a0.c().b(this.a, this, 0);
        }
    }

    public void setNativeDelegate(long j) {
        this.a = j;
    }

    public void notifyAccelerate(int i, int i2, int i3) {
        try {
            Method method = l3.a.q("com.hihonor.android.emcom.EmcomManagerEx").getMethod("notifyAppInfo", Bundle.class);
            Log.e("SA", "notify scene:" + i + " value: " + i2 + " fd:" + i3);
            Bundle bundle = new Bundle();
            bundle.putInt("msgType", 49);
            bundle.putInt("scene", 16);
            bundle.putInt("subscene", i2);
            bundle.putInt("status", 1);
            bundle.putInt("accStatus", 3);
            bundle.putString("KFD", "" + i3);
            method.invoke(null, bundle);
            a0.c().a(this.a, this, i, 0);
        } catch (Throwable th) {
            th.printStackTrace();
            a0.c().a(this.a, this, i, -1000);
        }
    }
}
