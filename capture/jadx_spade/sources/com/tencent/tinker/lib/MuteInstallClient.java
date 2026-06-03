package com.tencent.tinker.lib;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.tinker.lib.IInstallCallback;
import com.tencent.tinker.lib.IInstallService;
import com.tencent.tinker.lib.utils.ProcessUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteInstallClient extends IInstallCallback.Stub implements ServiceConnection {
    private static final Handler sMainHandler;
    private volatile boolean mBound;
    private final Context mCtx = Muter.getAppContext();
    private IInstallService mInstallService;
    private final boolean mLockVer;
    private final String mPatchFile;
    private final int mRuleId;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInstallResultImpl$1() {
        ProcessUtil.killProcBySuffix(this.mCtx, ":mist");
    }

    static {
        Covode.recordClassIndex(653701);
        sMainHandler = new HandlerDelegate(Looper.getMainLooper());
    }

    public void reqInstall() {
        if (!this.mBound) {
            if (this.mCtx.bindService(new Intent(this.mCtx, (Class<?>) MuteInstallService.class), this, 1)) {
                MuteLog.i("Mute.Install.C", "reqInstall bindService [success] mBound[%b]", Boolean.valueOf(this.mBound));
                return;
            } else {
                MuteLog.e("Mute.Install.C", "reqInstall bindService [failed] mBound[%b]", Boolean.valueOf(this.mBound));
                return;
            }
        }
        try {
            MuteLog.i("Mute.Install.C", "reqInstall install", new Object[0]);
            this.mInstallService.install(this.mPatchFile, this.mRuleId, this.mLockVer, this);
        } catch (RemoteException e) {
            MuteLog.e("Mute.Install.C", "reqInstall install failed, %s", e);
            onInstallResultImpl(false);
        }
    }

    @Override // com.tencent.tinker.lib.IInstallCallback
    public void onInstallResult(boolean z) throws RemoteException {
        onInstallResultImpl(z);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        MuteLog.w("Mute.Install.C", "onServiceDisconnected", new Object[0]);
        this.mInstallService = null;
        this.mBound = false;
    }

    private Map<String, Object> convert(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.get(str));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onInstallResultImpl$0(boolean z) {
        String str;
        Context appContext = Muter.getAppContext();
        StringBuilder sb = new StringBuilder();
        sb.append("静默灰度安装");
        if (z) {
            str = "成功";
        } else {
            str = "失败";
        }
        sb.append(str);
        Toast.makeText(appContext, sb.toString(), 0).show();
    }

    private void onInstallResultImpl(final boolean z) {
        MuteLog.i("Mute.Install.C", "onInstallResult r[%b]", Boolean.valueOf(z));
        MuteInstaller.sInstallReady = z;
        if (z && Muter.getSettings().b()) {
            Muter.installNeedHook();
        }
        if (Muter.getAppLike().isDebugMode()) {
            sMainHandler.post(new Runnable() { // from class: com.tencent.tinker.lib.a
                @Override // java.lang.Runnable
                public final void run() {
                    MuteInstallClient.lambda$onInstallResultImpl$0(z);
                }
            });
        }
        if (this.mBound) {
            MuteLog.i("Mute.Install.C", "unbindService", new Object[0]);
            this.mCtx.unbindService(this);
            this.mBound = false;
            sMainHandler.postDelayed(new Runnable() { // from class: com.tencent.tinker.lib.b
                @Override // java.lang.Runnable
                public final void run() {
                    MuteInstallClient.this.lambda$onInstallResultImpl$1();
                }
            }, 3000L);
        }
    }

    @Override // com.tencent.tinker.lib.IInstallCallback
    public void onReportDuration(int i, Bundle bundle) throws RemoteException {
        Muter.getReporter().onReportDuration(i, convert(bundle));
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MuteLog.i("Mute.Install.C", "onServiceConnected", new Object[0]);
        this.mInstallService = IInstallService.Stub.asInterface(iBinder);
        this.mBound = true;
        reqInstall();
    }

    public MuteInstallClient(String str, int i, boolean z) {
        this.mPatchFile = str;
        this.mRuleId = i;
        this.mLockVer = z;
    }

    @Override // com.tencent.tinker.lib.IInstallCallback
    public void onReportStatus(int i, int i2, Bundle bundle) throws RemoteException {
        Muter.getReporter().onReportStatus(i, i2, convert(bundle));
    }
}
