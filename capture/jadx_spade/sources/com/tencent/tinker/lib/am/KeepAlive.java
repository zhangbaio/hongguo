package com.tencent.tinker.lib.am;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.utils.OSUtil;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class KeepAlive extends Service {
    static {
        Covode.recordClassIndex(653725);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static final class InnerService extends Service {
        static {
            Covode.recordClassIndex(653726);
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            MuteLog.i("Mute.InnerService", "onCreate, then startForeground, then stopSelf", new Object[0]);
            startForeground(32, new Notification());
            stopSelf();
        }

        @Override // android.app.Service
        public void onDestroy() {
            super.onDestroy();
            MuteLog.i("Mute.InnerService", "onDestroy", new Object[0]);
            stopForeground(true);
        }
    }

    public static void start() {
        MuteLog.d("Mute.KeepAlive", "start KeepAlive", new Object[0]);
        Muter.getAppContext().startService(new Intent(Muter.getAppContext(), (Class<?>) KeepAlive.class));
    }

    public static void stop() {
        MuteLog.d("Mute.KeepAlive", "stop KeepAlive", new Object[0]);
        Muter.getAppContext().stopService(new Intent(Muter.getAppContext(), (Class<?>) KeepAlive.class));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MuteLog.i("Mute.KeepAlive", "onDestroy", new Object[0]);
        stopForeground(true);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MuteLog.i("Mute.KeepAlive", "onCreate", new Object[0]);
        if (OSUtil.isAndroidJ_MR2Higher()) {
            MuteLog.d("Mute.KeepAlive", "onCreate start InnerService with startForeground", new Object[0]);
            startService(new Intent(this, (Class<?>) InnerService.class));
        }
        startForeground(32, new Notification());
    }
}
