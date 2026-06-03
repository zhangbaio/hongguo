package com.tencent.tinker.lib;

import android.content.Context;
import android.content.pm.PackageParser;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.hook.HookManager;
import com.tencent.tinker.lib.utils.DirUtils;
import com.tencent.tinker.lib.utils.FileUtils;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteBooster {
    private ComponentDiff mComponentDiff;
    private final Context mContext;
    private Future<Boolean> mHookTask;
    private Future<PackageParser.Package> mParsePatchPkgTask;
    private final int mPatchVerCode;
    private String mPublicKeyMd5;
    private Future<Boolean> mSecurityCheckTask;
    private final File mSource;

    static {
        Covode.recordClassIndex(653699);
    }

    public void submitNeedHook() {
        MuteLog.i("Mute.Booster", "NeedHook submit", new Object[0]);
        this.mHookTask = MuteBoostExecutor.preload(new Callable<Boolean>() { // from class: com.tencent.tinker.lib.MuteBooster.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                MuteLog.i("Mute.Booster", "NeedHook call >>>", new Object[0]);
                HookManager.getInstance().installNeedHook();
                return Boolean.TRUE;
            }
        });
    }

    public void submitParsePatchPkg() {
        MuteLog.i("Mute.Booster", "ParsePatchPkg submit", new Object[0]);
        this.mParsePatchPkgTask = MuteBoostExecutor.preload(new Callable<PackageParser.Package>() { // from class: com.tencent.tinker.lib.MuteBooster.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PackageParser.Package call() {
                MuteLog.i("Mute.Booster", "ParsePatchPkg call >>>", new Object[0]);
                try {
                    return MutePkgMgr.obtainPackage(MuteBooster.this.mSource);
                } catch (Throwable th) {
                    MuteLog.e("Mute.Booster", "ParsePatchPkg obtainPackage err, %s", th);
                    return null;
                }
            }
        });
    }

    public void submitSecurityCheck() {
        MuteLog.i("Mute.Booster", "SecurityCheck submit", new Object[0]);
        this.mSecurityCheckTask = MuteBoostExecutor.boostSerial(new Callable<Boolean>() { // from class: com.tencent.tinker.lib.MuteBooster.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                MuteLog.i("Mute.Booster", "SecurityCheck call >>>", new Object[0]);
                MuteBooster.this.securityCheckImpl();
                return Boolean.TRUE;
            }
        });
    }

    public ComponentDiff waitSecurityCheckDone() {
        Boolean bool;
        Exception e;
        try {
            bool = this.mSecurityCheckTask.get(200L, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            bool = null;
            e = e2;
        }
        try {
            MuteLog.i("Mute.Booster", "SecurityCheck waitForDone[%b]", bool);
        } catch (Exception e3) {
            e = e3;
            MuteLog.e("Mute.Booster", "SecurityCheck waitForDone[err]", e);
            if (bool != null) {
            }
            MuteLog.w("Mute.Booster", "SecurityCheck waitForDone >> loadComponentDiff", new Object[0]);
            securityCheckImpl();
            return this.mComponentDiff;
        }
        if (bool != null || !bool.booleanValue()) {
            MuteLog.w("Mute.Booster", "SecurityCheck waitForDone >> loadComponentDiff", new Object[0]);
            securityCheckImpl();
        }
        return this.mComponentDiff;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void securityCheckImpl() {
        if (this.mPublicKeyMd5 != null) {
            MuteLog.i("Mute.Booster", "SecurityCheck impl PublicKeyMd5[..] no need", new Object[0]);
            return;
        }
        try {
            try {
                File componentDiff = DirUtils.getComponentDiff(this.mPatchVerCode);
                if (componentDiff.exists()) {
                    this.mComponentDiff = ComponentDiff.loadLocal(componentDiff);
                    MuteLog.i("Mute.Booster", "SecurityCheck impl component.diff readObj", new Object[0]);
                } else {
                    MuteLog.w("Mute.Booster", "SecurityCheck impl component.diff not exist", new Object[0]);
                }
                String md5 = FileUtils.getMD5(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64).signatures[0].toByteArray());
                this.mPublicKeyMd5 = md5;
                if (md5 != null) {
                    MuteLog.i("Mute.Booster", "SecurityCheck impl PublicKeyMd5[..]", new Object[0]);
                } else {
                    MuteLog.e("Mute.Booster", "SecurityCheck impl PublicKeyMd5[null]", new Object[0]);
                    throw new RuntimeException("get public key md5 is null");
                }
            } catch (Exception e) {
                throw new RuntimeException("SecurityCheck impl fail", e);
            }
        } finally {
            FileUtils.closeQuietly(null);
        }
    }

    public void waitForHookDone() {
        Boolean bool;
        Exception e;
        try {
            bool = this.mHookTask.get(600L, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            bool = null;
            e = e2;
        }
        try {
            MuteLog.i("Mute.Booster", "NeedHook waitForDone[%b]", bool);
        } catch (Exception e3) {
            e = e3;
            MuteLog.e("Mute.Booster", "NeedHook waitForDone[err], %s", e);
            if (bool != null) {
            }
            MuteLog.w("Mute.Booster", "NeedHook waitForDone >> install", new Object[0]);
            HookManager.getInstance().installNeedHook();
        }
        if (bool != null || !bool.booleanValue()) {
            MuteLog.w("Mute.Booster", "NeedHook waitForDone >> install", new Object[0]);
            HookManager.getInstance().installNeedHook();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.pm.PackageParser.Package waitParsePatchPkgDone() {
        /*
            r9 = this;
            java.lang.String r0 = "Mute.Booster"
            r1 = 1
            r2 = 0
            r3 = 0
            java.util.concurrent.Future<android.content.pm.PackageParser$Package> r4 = r9.mParsePatchPkgTask     // Catch: java.lang.Exception -> L24
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L24
            r6 = 600(0x258, double:2.964E-321)
            java.lang.Object r4 = r4.get(r6, r5)     // Catch: java.lang.Exception -> L24
            android.content.pm.PackageParser$Package r4 = (android.content.pm.PackageParser.Package) r4     // Catch: java.lang.Exception -> L24
            java.lang.String r3 = "ParsePatchPkg waitForDone[%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L22
            if (r4 == 0) goto L1a
            java.lang.String r6 = "pkg"
            goto L1c
        L1a:
            java.lang.String r6 = "null"
        L1c:
            r5[r2] = r6     // Catch: java.lang.Exception -> L22
            com.tencent.tinker.lib.MuteLog.i(r0, r3, r5)     // Catch: java.lang.Exception -> L22
            goto L31
        L22:
            r3 = move-exception
            goto L28
        L24:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
        L28:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r3
            java.lang.String r3 = "ParsePatchPkg waitForDone[err]"
            com.tencent.tinker.lib.MuteLog.e(r0, r3, r1)
        L31:
            if (r4 != 0) goto L42
            java.io.File r1 = r9.mSource     // Catch: java.lang.Throwable -> L3a
            android.content.pm.PackageParser$Package r4 = com.tencent.tinker.lib.MutePkgMgr.obtainPackage(r1)     // Catch: java.lang.Throwable -> L3a
            goto L42
        L3a:
            r1 = move-exception
            java.lang.String r3 = "ParsePatchPkg waitForDone obtainPackage err"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.tencent.tinker.lib.MuteLog.printErrStackTrace(r0, r1, r3, r2)
        L42:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.MuteBooster.waitParsePatchPkgDone():android.content.pm.PackageParser$Package");
    }

    public MuteBooster(Context context, File file, int i) {
        this.mContext = context;
        this.mSource = file;
        this.mPatchVerCode = i;
    }
}
