package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("net::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AndroidCellularSignalStrength {
    private static final AndroidCellularSignalStrength b;
    private volatile int a = Integer.MIN_VALUE;

    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            AndroidCellularSignalStrength.this.new b();
        }

        a() {
        }
    }

    private class b extends PhoneStateListener implements ApplicationStatus.b {
        private final TelephonyManager a;

        private void b() {
            l3.a.y(this.a, this, 256);
        }

        static {
            Covode.recordClassIndex(654423);
        }

        private void c() {
            AndroidCellularSignalStrength.this.a = Integer.MIN_VALUE;
            l3.a.y(this.a, this, 0);
        }

        public void a(int i) {
            if (i == 1) {
                b();
            } else if (i == 2) {
                c();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (ApplicationStatus.getStateForApplication() != 1) {
                return;
            }
            try {
                AndroidCellularSignalStrength.this.a = signalStrength.getLevel();
            } catch (SecurityException unused) {
                AndroidCellularSignalStrength.this.a = Integer.MIN_VALUE;
            }
        }

        b() {
            ThreadUtils.a();
            TelephonyManager telephonyManager = (TelephonyManager) com.ttnet.org.chromium.base.c.f().getSystemService("phone");
            this.a = telephonyManager;
            if (telephonyManager.getSimState() != 5) {
                return;
            }
            ApplicationStatus.f(this);
            a(ApplicationStatus.getStateForApplication());
        }
    }

    private static int getSignalStrengthLevel() {
        return b.a;
    }

    static {
        Covode.recordClassIndex(654422);
        b = new AndroidCellularSignalStrength();
    }

    private AndroidCellularSignalStrength() {
        if (Build.VERSION.SDK_INT < 23 || u.a().g()) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
        handlerThread.start();
        new HandlerDelegate(handlerThread.getLooper()).post(new a());
    }
}
