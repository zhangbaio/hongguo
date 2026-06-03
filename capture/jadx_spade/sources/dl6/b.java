package dl6;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.bytedance.covode.number.Covode;
import java.security.SecureRandom;
import kotlin.jvm.internal.Intrinsics;
import lk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static final bl6.a a;
    private static WifiManager.WifiLock b;
    public static final b c;

    private b() {
    }

    static {
        Covode.recordClassIndex(655905);
        c = new b();
        a = new bl6.a("WiFiLockManager");
    }

    private final String d() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder("WiFiLockManager-");
        for (int i = 0; i <= 4; i++) {
            sb.append(secureRandom.nextInt(10));
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public final void a() {
        bl6.a aVar = a;
        aVar.d("begin acquire wifi lock", new Object[0]);
        if (b == null) {
            aVar.d("acquire wifi lock", new Object[0]);
            WifiManager.WifiLock c2 = c(false);
            b = c2;
            if (c2 != null) {
                c2.setReferenceCounted(false);
            }
        }
        WifiManager.WifiLock wifiLock = b;
        if (wifiLock != null) {
            wifiLock.acquire();
        }
    }

    public final void b() {
        bl6.a aVar = a;
        aVar.d("begin acquire wifi lock ignore", new Object[0]);
        WifiManager.WifiLock c2 = c(true);
        if (c2 != null) {
            aVar.d("acquire wifi lock", new Object[0]);
            c2.setReferenceCounted(false);
            c2.acquire();
            WifiManager.WifiLock wifiLock = b;
            if (wifiLock != null && wifiLock != null) {
                wifiLock.release();
            }
            b = c2;
        }
    }

    public final void e() {
        a.d("release wifi lock. wifi lock = " + b, new Object[0]);
        WifiManager.WifiLock wifiLock = b;
        if (wifiLock != null) {
            wifiLock.release();
        }
        b = null;
    }

    private final WifiManager.WifiLock c(boolean z) {
        Boolean bool;
        Object obj;
        Application application;
        Context applicationContext;
        nk6.b bVar;
        lk6.b bVar2 = c.a;
        if (bVar2 != null && (bVar = bVar2.l) != null) {
            bool = Boolean.valueOf(bVar.n0());
        } else {
            bool = null;
        }
        lk6.b bVar3 = c.a;
        if (bVar3 != null && (application = bVar3.b) != null && (applicationContext = application.getApplicationContext()) != null) {
            obj = applicationContext.getSystemService("wifi");
        } else {
            obj = null;
        }
        WifiManager wifiManager = (WifiManager) obj;
        String str = "WiFiLockManager";
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            if (wifiManager == null) {
                return null;
            }
            if (z) {
                str = d();
            }
            return wifiManager.createWifiLock(3, str);
        }
        if (wifiManager == null) {
            return null;
        }
        if (z) {
            str = d();
        }
        return wifiManager.createWifiLock(str);
    }
}
