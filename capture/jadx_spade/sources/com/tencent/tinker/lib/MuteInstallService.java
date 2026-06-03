package com.tencent.tinker.lib;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.IInstallService;
import com.tencent.tinker.lib.MuteInstallService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteInstallService extends Service {
    private final IBinder mInstallBinder = new AnonymousClass1();

    static {
        Covode.recordClassIndex(653702);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MuteLog.i("Mute.Install.S", "onCreate", new Object[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MuteLog.i("Mute.Install.S", "onDestroy", new Object[0]);
    }

    /* renamed from: com.tencent.tinker.lib.MuteInstallService$1, reason: invalid class name */
    class AnonymousClass1 extends IInstallService.Stub {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$install$0(String str, int i, boolean z, IInstallCallback iInstallCallback) {
            MuteInstaller muteInstaller = new MuteInstaller(str, i, z);
            muteInstaller.setCallback(iInstallCallback);
            try {
                iInstallCallback.onInstallResult(muteInstaller.install());
            } catch (RemoteException e) {
                MuteLog.e("Mute.Install.S", "install callback dead, %s", e);
            }
        }

        @Override // com.tencent.tinker.lib.IInstallService
        public void install(final String str, final int i, final boolean z, final IInstallCallback iInstallCallback) {
            MuteLog.i("Mute.Install.S", "install received task", new Object[0]);
            new Thread(new Runnable() { // from class: com.tencent.tinker.lib.c
                @Override // java.lang.Runnable
                public final void run() {
                    MuteInstallService.AnonymousClass1.lambda$install$0(str, i, z, iInstallCallback);
                }
            }, "mute-install").start();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        MuteLog.i("Mute.Install.S", "onBind", new Object[0]);
        return this.mInstallBinder;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        MuteLog.w("Mute.Install.S", "onTaskRemoved stopSelf", new Object[0]);
        stopSelf();
    }
}
