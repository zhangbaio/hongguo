package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LSPreconnDataHandle {

    public static class a {
        public boolean a = false;
        public String b = "0";
        public int c = 0;
        public String d = "";
        public int e = 0;
        public String f = "NONE";
        public int g = 0;
        public String h = "";

        static {
            Covode.recordClassIndex(653170);
        }
    }

    public static class b {
        public int a = 3;
        public boolean b = true;
        public int c = 0;
        public int d = 0;
        public int e = 0;

        static {
            Covode.recordClassIndex(653171);
        }
    }

    static {
        Covode.recordClassIndex(653169);
    }

    LSPreconnDataHandle() {
    }

    private native String nativeGetPreconnectIp(String str);

    private native int nativeSetLSConnectToggles(int i, boolean z, int i2, int i3, int i4);

    private native int nativeSetLiveStartOptToggles(boolean z, String str, int i, String str2, String str3, int i2, int i3, String str4);

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return nativeGetPreconnectIp(str);
    }

    public void b(b bVar) {
        nativeSetLSConnectToggles(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
    }

    public void c(a aVar) {
        nativeSetLiveStartOptToggles(aVar.a, aVar.b, aVar.c, aVar.d, aVar.f, aVar.e, aVar.g, aVar.h);
    }
}
