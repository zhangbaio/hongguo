package com.tencent.tinker.lib;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageParser;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.crash.MuteRestoreHelper;
import com.tencent.tinker.lib.pm.PatchPackageManager;
import com.tencent.tinker.lib.pm.ReceiverInfo;
import com.tencent.tinker.lib.utils.ATUtils;
import com.tencent.tinker.lib.utils.DirUtils;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.FileUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import com.tencent.tinker.lib.utils.ProcessUtil;
import com.tencent.tinker.lib.utils.Utils;
import java.io.File;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteMaxLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static File mPatchSource;
    public static Context sBaseCtx;
    public static int sHostVerCode;
    public static boolean sIsFirstMuteStart;
    private static String sMuteDesc;
    public static ClassLoader sOriginCL;
    public static PackageParser.Package sPatchPkg;
    private final boolean mAlignDex;
    private boolean mHasOat;
    private final Intent mIntent;
    private final int mLastVerCode;
    private boolean mLockVer;
    private final boolean mMainProc;
    private final int mPatchVerCode;
    private int mRealHostVerCode;
    private final int mRuleId;

    static {
        Covode.recordClassIndex(653707);
    }

    public static String getMuteDesc() {
        if (!TextUtils.isEmpty(sMuteDesc)) {
            return sMuteDesc;
        }
        return "null";
    }

    public static ClassLoader getOriginCL() {
        ClassLoader classLoader = sOriginCL;
        if (classLoader == null) {
            return MuteMaxLoader.class.getClassLoader();
        }
        return classLoader;
    }

    public static boolean isPatchEnv() {
        if (!TextUtils.isEmpty(sMuteDesc) && MuteMaxLoader.class.getClassLoader() != sOriginCL) {
            return true;
        }
        return false;
    }

    private boolean createRes() {
        try {
            MuteResReplacer.replaceAppRes(sBaseCtx, mPatchSource.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            this.mIntent.putExtra("state", 3012);
            this.mIntent.putExtra("error", new RuntimeException("Mirage switch launch failed", th));
            Logger.e("Mute.Loader", "switch launch failed for ERROR_CREATE_RES_EXCEPTION", th);
            return false;
        }
    }

    private List<ProviderInfo> getProviders() {
        try {
            Object readField = FieldUtils.readField(ATUtils.currentActivityThread(), "mBoundApplication");
            if (readField != null) {
                return (List) FieldUtils.readField(readField, "providers");
            }
            return null;
        } catch (Exception e) {
            MuteLog.e("Mute.Loader", "clearProviders failed", e);
            return null;
        }
    }

    private boolean modifyApp() {
        try {
            MuteReplacer.modifyLoadedApk(sBaseCtx);
            MuteReplacer.modifyAppInfo(sBaseCtx.getApplicationInfo());
            MuteReplacer.modifyAppConfig(sBaseCtx);
            return true;
        } catch (Throwable th) {
            this.mIntent.putExtra("state", 3014);
            this.mIntent.putExtra("error", new RuntimeException("Mirage switch launch failed", th));
            Logger.e("Mute.Loader", "switch launch failed for ERROR_MODIFY_APP_EXCEPTION", th);
            return false;
        }
    }

    private boolean verifyAPI() {
        try {
            MuteResReplacer.checkResApi(sBaseCtx);
            return true;
        } catch (Throwable th) {
            this.mIntent.putExtra("state", 3011);
            this.mIntent.putExtra("error", new RuntimeException("Mirage switch launch failed", th));
            Logger.e("Mute.Loader", "switch launch failed for ERROR_VERIFY_API_EXCEPTION", th);
            return false;
        }
    }

    private boolean createLib() {
        File nativeLibraryDir = DirUtils.getNativeLibraryDir(this.mPatchVerCode);
        if (!nativeLibraryDir.exists()) {
            return true;
        }
        try {
            MuteSoLoader.installNativeLibDir(sBaseCtx.getClassLoader(), nativeLibraryDir);
            ApplicationInfo applicationInfo = sBaseCtx.getApplicationInfo();
            File canonicalFile = nativeLibraryDir.getCanonicalFile();
            if (canonicalFile.exists() && canonicalFile.isDirectory()) {
                applicationInfo.nativeLibraryDir = canonicalFile.getAbsolutePath();
                Logger.i("Mute.Loader", "createSo modify appInfo.nativeLibraryDir = libDir");
            }
            return true;
        } catch (Throwable th) {
            this.mIntent.putExtra("state", 3013);
            this.mIntent.putExtra("error", new RuntimeException("Mirage switch launch failed", th));
            Logger.e("Mute.Loader", "switch launch failed for ERROR_CREATE_LIB_EXCEPTION", th);
            return false;
        }
    }

    private boolean isDriverReady() {
        if (!verifyAPK() || !verifyAPI()) {
            return false;
        }
        MuteBooster muteBooster = new MuteBooster(sBaseCtx, mPatchSource, this.mPatchVerCode);
        muteBooster.submitSecurityCheck();
        muteBooster.submitParsePatchPkg();
        muteBooster.submitNeedHook();
        if (!createRes() || !createLib()) {
            return false;
        }
        PackageParser.Package waitParsePatchPkgDone = muteBooster.waitParsePatchPkgDone();
        sPatchPkg = waitParsePatchPkgDone;
        if (waitParsePatchPkgDone == null) {
            this.mIntent.putExtra("state", 3010);
            Logger.w("Mute.Loader", "switch launch failed for ERROR_PARSE_PACKAGE_FAILED");
            return false;
        }
        MutePkgMgr.parseMetaInfo(waitParsePatchPkgDone);
        ComponentDiff waitSecurityCheckDone = muteBooster.waitSecurityCheckDone();
        if (waitSecurityCheckDone != null) {
            install4Component(waitSecurityCheckDone);
        }
        muteBooster.waitForHookDone();
        if (!modifyApp()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean installContentProviders() {
        /*
            r9 = this;
            java.lang.String r0 = "Mute.Loader"
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.Object r4 = com.tencent.tinker.lib.utils.ATUtils.currentActivityThread()     // Catch: java.lang.Exception -> L25
            java.lang.String r5 = "mBoundApplication"
            java.lang.Object r4 = com.tencent.tinker.lib.utils.FieldUtils.readField(r4, r5)     // Catch: java.lang.Exception -> L25
            if (r4 == 0) goto L33
            java.lang.String r5 = "providers"
            java.lang.Object r4 = com.tencent.tinker.lib.utils.FieldUtils.readField(r4, r5)     // Catch: java.lang.Exception -> L25
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Exception -> L25
            java.lang.String r3 = "installContentProviders read AT.mBoundApplication.providers %s"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L23
            r5[r1] = r4     // Catch: java.lang.Exception -> L23
            com.tencent.tinker.lib.MuteLog.i(r0, r3, r5)     // Catch: java.lang.Exception -> L23
            goto L32
        L23:
            r3 = move-exception
            goto L29
        L25:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
        L29:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r3
            java.lang.String r3 = "installContentProviders read AT.mBoundApplication.providers failed. %s"
            com.tencent.tinker.lib.MuteLog.e(r0, r3, r5)
        L32:
            r3 = r4
        L33:
            java.util.List r4 = com.tencent.tinker.lib.pm.PatchPackageManager.getDeleteProviderNameList()
            if (r4 == 0) goto L67
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L67
            if (r3 == 0) goto L67
            int r5 = r3.size()
            int r5 = r5 - r2
        L46:
            if (r5 < 0) goto L67
            java.lang.Object r6 = r3.get(r5)
            android.content.pm.ProviderInfo r6 = (android.content.pm.ProviderInfo) r6
            java.lang.String r7 = r6.name
            boolean r7 = r4.contains(r7)
            if (r7 == 0) goto L64
            r3.remove(r5)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.String r6 = r6.name
            r7[r1] = r6
            java.lang.String r6 = "installContentProviders remove %s"
            com.tencent.tinker.lib.MuteLog.i(r0, r6, r7)
        L64:
            int r5 = r5 + (-1)
            goto L46
        L67:
            android.content.Context r4 = com.tencent.tinker.lib.Muter.getAppContext()
            java.lang.String r4 = com.tencent.tinker.lib.utils.ProcessUtil.getProcName(r4)
            java.util.List r4 = com.tencent.tinker.lib.pm.PatchPackageManager.getProviders(r4, r1)
            if (r4 == 0) goto L89
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L89
            if (r3 == 0) goto L89
            r3.addAll(r4)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r3[r1] = r4
            java.lang.String r1 = "installContentProviders add %s"
            com.tencent.tinker.lib.MuteLog.i(r0, r1, r3)
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.MuteMaxLoader.installContentProviders():boolean");
    }

    private void registerReceivers() {
        int i;
        List<ReceiverInfo> receivers = PatchPackageManager.getReceivers(ProcessUtil.getProcName(Muter.getAppContext()), 0);
        if (receivers != null && receivers.size() > 0) {
            for (ReceiverInfo receiverInfo : receivers) {
                new Intent().setComponent(new ComponentName(Muter.getAppContext().getPackageName(), receiverInfo.name));
                try {
                    BroadcastReceiver broadcastReceiver = (BroadcastReceiver) Class.forName(receiverInfo.name).newInstance();
                    for (IntentFilter intentFilter : receiverInfo.intentFilters) {
                        if (OSUtil.isAndroidUHigher()) {
                            if (receiverInfo.exported) {
                                i = 2;
                            } else {
                                i = 4;
                            }
                            Muter.getAppContext().registerReceiver(broadcastReceiver, intentFilter, i);
                        } else {
                            Muter.getAppContext().registerReceiver(broadcastReceiver, intentFilter);
                        }
                    }
                    MuteLog.i("Mute.Loader", "registerReceivers %s", broadcastReceiver);
                } catch (Exception e) {
                    MuteLog.e("Mute.Loader", "registerReceivers %s failed, %s", receiverInfo.name, e);
                }
            }
        }
    }

    private boolean retryComponentDiff() {
        File sourceApk;
        if (this.mAlignDex) {
            sourceApk = DirUtils.getAlignApk(this.mPatchVerCode);
        } else {
            sourceApk = DirUtils.getSourceApk(this.mPatchVerCode);
        }
        try {
            PackageInfo gePackageInfo = Utils.gePackageInfo(sBaseCtx);
            if (gePackageInfo == null) {
                this.mIntent.putExtra("state", 3006);
                Logger.w("Mute.Loader", "switch launch failed for ERROR_PARSE_HOST_PI_FAILED");
                return false;
            }
            PackageParser.Package obtainPackage = MutePkgMgr.obtainPackage(sourceApk);
            if (obtainPackage == null) {
                this.mIntent.putExtra("state", 3007);
                Logger.w("Mute.Loader", "switch launch failed for ERROR_PARSE_MUTE_PI_FAILED");
                return false;
            }
            ComponentDiff componentDiff = new ComponentDiff();
            componentDiff.diffActivity(componentDiff.asActivityArr(gePackageInfo.activities), obtainPackage.activities);
            componentDiff.diffService(componentDiff.asServiceArr(gePackageInfo.services), obtainPackage.services);
            componentDiff.diffReceiver(componentDiff.asActivityArr(gePackageInfo.receivers), obtainPackage.receivers);
            componentDiff.diffProvider(componentDiff.asProviderArr(gePackageInfo.providers), obtainPackage.providers);
            componentDiff.diffPermission(componentDiff.asPermissionArr(gePackageInfo.permissions), obtainPackage.permissions);
            if (!componentDiff.saveLocal(DirUtils.getComponentDiff(this.mPatchVerCode))) {
                this.mIntent.putExtra("state", 3008);
                Logger.w("Mute.Loader", "switch launch failed for ERROR_PI_DIFFS_SAVE_FAILED");
                return false;
            }
            MuteSP.setInstallRealHostUpdateVCode(sHostVerCode);
            return true;
        } catch (Throwable th) {
            this.mIntent.putExtra("state", 3009);
            this.mIntent.putExtra("error", new RuntimeException("Mirage switch launch failed", th));
            Logger.e("Mute.Loader", "switch launch failed for ERROR_RETRY_DIFF_EXCEPTION", th);
            return false;
        }
    }

    private boolean verifyAPK() {
        File sourceApk;
        boolean z;
        if (this.mMainProc && this.mPatchVerCode == MuteSP.getOfflineVerCode()) {
            this.mIntent.putExtra("state", 3001);
            Logger.w("Mute.Loader", "switch launch failed for ERROR_VERSION_BEEN_OFFLINE");
            return false;
        }
        int[] supportHostRange = MuteSP.getSupportHostRange(this.mPatchVerCode);
        if (supportHostRange[1] == 0 && DirUtils.openPushInstall(sBaseCtx)) {
            supportHostRange[1] = Integer.MAX_VALUE;
        }
        int i = sHostVerCode;
        if (i >= supportHostRange[0] && i <= supportHostRange[1]) {
            if (this.mPatchVerCode < i && !this.mLockVer && !DirUtils.openLockVersion(sBaseCtx)) {
                this.mIntent.putExtra("state", 3003);
                Logger.w("Mute.Loader", "switch launch failed for ERROR_VERSION_IS_DOWNGRADE");
                return false;
            }
            if (MuteSP.isRomUpdate()) {
                this.mIntent.putExtra("state", 3004);
                Logger.w("Mute.Loader", "switch launch failed for ERROR_SYSTEM_BUILD_CHANGED");
                return false;
            }
            if (this.mAlignDex) {
                sourceApk = DirUtils.getAlignApk(this.mPatchVerCode);
            } else {
                sourceApk = DirUtils.getSourceApk(this.mPatchVerCode);
            }
            mPatchSource = sourceApk;
            File oatFile = DirUtils.getOatFile(sourceApk);
            if (FileUtils.isLegalFile(oatFile) && FileUtils.checkElfFile(oatFile)) {
                z = true;
            } else {
                z = false;
            }
            this.mHasOat = z;
            if (!z && OSUtil.isAndroidQLower()) {
                this.mIntent.putExtra("state", 3005);
                Logger.w("Mute.Loader", "switch launch failed for ERROR_TARGET_OAT_NOT_EXIST");
                return false;
            }
            int installRealHostUpdateVCode = MuteSP.getInstallRealHostUpdateVCode();
            this.mRealHostVerCode = installRealHostUpdateVCode;
            if (sHostVerCode != installRealHostUpdateVCode && !retryComponentDiff()) {
                return false;
            }
            return true;
        }
        this.mIntent.putExtra("state", 3002);
        Logger.w("Mute.Loader", "switch launch failed for ERROR_VERSION_INCOMPATIBLE");
        return false;
    }

    public boolean maxLoad() {
        boolean z;
        char c;
        char c2;
        if (isDriverReady()) {
            if (this.mLastVerCode != this.mPatchVerCode) {
                z = true;
            } else {
                z = false;
            }
            sIsFirstMuteStart = z;
            this.mIntent.putExtra("state", 0);
            this.mIntent.putExtra("intent_rule_id", this.mRuleId);
            this.mIntent.putExtra("intent_align_zip", this.mAlignDex);
            this.mIntent.putExtra("intent_has_oat", this.mHasOat);
            StringBuilder sb = new StringBuilder();
            sb.append('M');
            sb.append(this.mPatchVerCode);
            sb.append("_H");
            sb.append(sHostVerCode);
            sb.append("_D");
            sb.append(this.mRealHostVerCode);
            sb.append("_R");
            sb.append(this.mRuleId);
            sb.append("_L");
            char c3 = '1';
            if (this.mLockVer) {
                c = '1';
            } else {
                c = '0';
            }
            sb.append(c);
            sb.append("_O");
            if (this.mHasOat) {
                c2 = '1';
            } else {
                c2 = '0';
            }
            sb.append(c2);
            sb.append("_A");
            if (!this.mAlignDex) {
                c3 = '0';
            }
            sb.append(c3);
            String sb2 = sb.toString();
            sMuteDesc = sb2;
            this.mIntent.putExtra("value", sb2);
            Logger.i("Mute.Loader", "maxLoad success ^_^: " + sMuteDesc);
            return true;
        }
        if (this.mMainProc && this.mLastVerCode < sHostVerCode) {
            MuteRestoreHelper.getInstance().dealRestoreDowngrade();
        }
        return false;
    }

    private boolean install4Component(ComponentDiff componentDiff) {
        if (!PatchPackageManager.resolvePatchPackage(sPatchPkg, componentDiff)) {
            MuteLog.w("Mute.Loader", "install4Component resolve failed", new Object[0]);
            return false;
        }
        try {
            registerReceivers();
            installContentProviders();
            MuteLog.i("Mute.Loader", "install4Component success", new Object[0]);
            return true;
        } catch (Exception e) {
            MuteLog.w("Mute.Loader", "install4Component failed, %s", e);
            return false;
        }
    }

    public MuteMaxLoader(String str, Intent intent, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.mIntent = intent;
        sHostVerCode = i;
        this.mLastVerCode = i2;
        this.mPatchVerCode = i3;
        this.mRuleId = i4;
        this.mAlignDex = z;
        this.mLockVer = z2;
        this.mMainProc = z3;
    }
}
