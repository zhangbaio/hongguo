package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("net")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u {
    private static final String b;
    private static volatile u c;
    public a a;

    public interface a {
        String getNetworkOperator();

        String getSimOperator();

        int getWifiFrequency();

        int getWifiRssi();
    }

    interface b {
        boolean a();

        boolean b();
    }

    static {
        Covode.recordClassIndex(654519);
        b = u.class.getSimpleName();
    }

    public String b() {
        a aVar = this.a;
        if (aVar == null) {
            return "";
        }
        return aVar.getNetworkOperator();
    }

    public String c() {
        a aVar = this.a;
        if (aVar == null) {
            return "";
        }
        return aVar.getSimOperator();
    }

    public int d() {
        a aVar = this.a;
        if (aVar == null) {
            return 0;
        }
        return aVar.getWifiFrequency();
    }

    public int e() {
        a aVar = this.a;
        if (aVar == null) {
            return 0;
        }
        return aVar.getWifiRssi();
    }

    boolean f() {
        return v.c().a();
    }

    boolean g() {
        return v.c().b();
    }

    public static u a() {
        if (c == null) {
            synchronized (u.class) {
                if (c == null) {
                    c = new u();
                }
            }
        }
        return c;
    }
}
