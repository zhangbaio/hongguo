package com.tencent.tinker.lib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageParser;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import cf0.a;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.tencent.tinker.lib.dexopt.DexAlign;
import com.tencent.tinker.lib.dexopt.DexOptimize;
import com.tencent.tinker.lib.signature.ApkSignatureVerify;
import com.tencent.tinker.lib.utils.DirUtils;
import com.tencent.tinker.lib.utils.FileUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import com.tencent.tinker.lib.utils.ProcessUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteInstaller {
    public static volatile boolean sInstallReady;
    private IInstallCallback mCallback;
    private Context mContext;
    private int mCurHostVerCode;
    private DexAlign.Result mDexAlignResult;
    private DexOptimize.Result mDexOptResult;
    private final boolean mEnableLockVer;
    private File mOriginPatch;
    private File mPatchFile;
    private String mPatchMd5;
    private final String mPatchPath;
    private PackageParser.Package mPatchPkg;
    private int mPatchVerCode;
    private File mPatchVerDir;
    private int mRealHostUpVerCode;
    private final int mRuleId;
    private InstallTimer mTimer;
    private String mTranKey;
    private int mTranStatus;

    private class InstallTimer {
        private long mAbiDone;
        private long mAlignDone;
        private final long mBegin;
        private long mDexOptDone;
        private long mDiffDone;
        private long mDone;
        private long mMoveDone;
        private long mObtainDone;
        private long mParseDone;
        private long mSignDone;
        private long mSoDone;

        static {
            Covode.recordClassIndex(653704);
        }

        public void finish() {
            this.mDone = SystemClock.elapsedRealtime();
        }

        public void recordAbiTime() {
            this.mAbiDone = SystemClock.elapsedRealtime();
        }

        public void recordAlignTime() {
            this.mAlignDone = SystemClock.elapsedRealtime();
        }

        public void recordDexOptTime() {
            this.mDexOptDone = SystemClock.elapsedRealtime();
        }

        public void recordDiffTime() {
            this.mDiffDone = SystemClock.elapsedRealtime();
        }

        public void recordMoveTime() {
            this.mMoveDone = SystemClock.elapsedRealtime();
        }

        public void recordObtainTime() {
            this.mObtainDone = SystemClock.elapsedRealtime();
        }

        public void recordParseTime() {
            this.mParseDone = SystemClock.elapsedRealtime();
        }

        public void recordSignTime() {
            this.mSignDone = SystemClock.elapsedRealtime();
        }

        public void recordSoTime() {
            this.mSoDone = SystemClock.elapsedRealtime();
        }

        public Map<String, Long> formatTimeMap() {
            long j;
            long j2 = this.mDone;
            long j3 = this.mBegin;
            long j4 = j2 - j3;
            long j5 = this.mParseDone;
            long j6 = j5 - j3;
            long j7 = this.mSignDone;
            long j8 = j7 - j5;
            long j9 = this.mMoveDone;
            long j10 = j9 - j7;
            long j11 = this.mObtainDone;
            long j12 = j11 - j9;
            long j13 = this.mSoDone;
            long j14 = j13 - j11;
            long j15 = this.mAbiDone;
            long j16 = j15 - j13;
            long j17 = this.mDiffDone;
            long j18 = j17 - j15;
            long j19 = this.mDexOptDone;
            long j20 = j19 - j17;
            long j21 = 0;
            if (j20 < 0) {
                j = j12;
                j20 = 0;
            } else {
                j = j12;
            }
            long j22 = this.mAlignDone;
            if (j22 > 0) {
                if (j19 > 0) {
                    j21 = j22 - j19;
                } else {
                    j21 = j22 - j17;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("all_sync_duration", Long.valueOf(j4));
            hashMap.put("packageInfoDuration", Long.valueOf(j6));
            hashMap.put("signDuration", Long.valueOf(j8));
            hashMap.put("packageMoveDuration", Long.valueOf(j10));
            hashMap.put("obtainPkgDuration", Long.valueOf(j));
            hashMap.put("packageUnzipDuration", Long.valueOf(j14));
            hashMap.put("abiDuration", Long.valueOf(j16));
            hashMap.put("componentDiffDuration", Long.valueOf(j18));
            hashMap.put("dexOptDuration", Long.valueOf(j20));
            hashMap.put("alignZipDuration", Long.valueOf(j21));
            MuteLog.i("Mute.Install", "install Timer all[%d] parsePkgInfo[%d] signVerify[%d] move[%d] obtainPkg[%d] unzipSo[%d] abiMatch[%d] storeDiff[%d] dexOpt[%d] alignZip[%d]", Long.valueOf(j4), Long.valueOf(j6), Long.valueOf(j8), Long.valueOf(j10), Long.valueOf(j), Long.valueOf(j14), Long.valueOf(j16), Long.valueOf(j18), Long.valueOf(j20), Long.valueOf(j21));
            return hashMap;
        }

        private InstallTimer() {
            this.mBegin = SystemClock.elapsedRealtime();
        }
    }

    static {
        Covode.recordClassIndex(653703);
        sInstallReady = false;
    }

    private void safeDelete() {
        MuteSP.removeTranStatus(this.mTranKey);
        MuteSP.removeInstallOpt();
        MuteSP.removeInstallAlign();
        File file = this.mPatchFile;
        if (file != null) {
            FileUtils.safeDeleteFile(file);
        }
        File file2 = this.mPatchVerDir;
        if (file2 != null) {
            FileUtils.deleteDir(file2);
        }
    }

    private boolean calPatchMd5() {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.mPatchPath);
        this.mOriginPatch = polarisFileWrapper;
        String md5 = FileUtils.getMD5((File) polarisFileWrapper);
        this.mPatchMd5 = md5;
        if (md5 != null) {
            MuteLog.i("Mute.Install", "calPatchMd5 [%s]", md5);
            return true;
        }
        reportFail("calPatchMd5 null");
        MuteLog.e("Mute.Install", "calPatchMd5[false] [null]", new Object[0]);
        return false;
    }

    private boolean checkLatest() {
        this.mContext = Muter.getAppContext();
        int installVerCode = MuteSP.getInstallVerCode();
        this.mCurHostVerCode = getHostUpVerCode();
        MuteLog.i("Mute.Install", "checkLatest installedPatchVerCode[%d] curHostVerCode[%d]", Integer.valueOf(installVerCode), Integer.valueOf(this.mCurHostVerCode));
        if (installVerCode != this.mCurHostVerCode) {
            return true;
        }
        MuteLog.i("Mute.Install", "checkLatest[false] mute mode already LATEST", new Object[0]);
        return false;
    }

    public static int getHostUpVerCode() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            Context appContext = Muter.getAppContext();
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 128);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getInt("UPDATE_VERSION_CODE", 0);
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean isInstallReady() {
        if (!ProcessUtil.isMainProcess(Muter.getAppContext())) {
            MuteLog.w("Mute.Install", "isInstallReady[false] not main proc", new Object[0]);
            return false;
        }
        MuteLog.i("Mute.Install", "isInstallReady[%b]", Boolean.valueOf(sInstallReady));
        return sInstallReady;
    }

    private boolean obtainPatchPackage() {
        if (this.mTranStatus >= 40) {
            MuteLog.w("Mute.Install", "obtainPatchPackage[true] tran[OBTAIN-40] skip...", new Object[0]);
            return true;
        }
        try {
            MutePkgMgr.obtainPackage(this.mPatchFile);
            MuteSP.setInstallTranStatus(this.mTranKey, 40);
            return true;
        } catch (Throwable th) {
            reportFail("obtainPatchPackage fail");
            MuteLog.w("Mute.Install", "obtainPatchPackage failed. %s", th);
            return false;
        }
    }

    private boolean signatureVerify() {
        if (this.mTranStatus >= 20) {
            MuteLog.w("Mute.Install", "signatureVerify[T] tran[SIGN-20] skip...", new Object[0]);
            return true;
        }
        if (ApkSignatureVerify.verify(this.mContext, this.mOriginPatch.getAbsolutePath(), false)) {
            MuteSP.setInstallTranStatus(this.mTranKey, 20);
            MuteLog.i("Mute.Install", "signatureVerify[T]", new Object[0]);
            return true;
        }
        reportFail("signature verify fail");
        MuteLog.e("Mute.Install", "signatureVerify[F]", new Object[0]);
        return false;
    }

    public boolean install() {
        boolean installImpl;
        MuteLog.w("Mute.Install", "install begin", new Object[0]);
        synchronized (MuteInstaller.class) {
            this.mTimer = new InstallTimer();
            installImpl = installImpl();
            this.mTimer.finish();
            if (installImpl) {
                reportDuration();
                MuteLog.w("Mute.Install", "install[true] success[^_^]", new Object[0]);
            } else {
                MuteLog.e("Mute.Install", "install[false] failed[^..^]", new Object[0]);
            }
        }
        return installImpl;
    }

    private boolean abiMatch() {
        String hostAbi = Muter.getAppLike().getHostAbi();
        if (TextUtils.isEmpty(hostAbi)) {
            reportFail("hostAbi empty");
            MuteLog.e("Mute.Install", "abiMatch[false] hostAbi empty", new Object[0]);
            return false;
        }
        if (!TextUtils.equals(hostAbi, "arm64-v8a")) {
            reportFail("ABI not match");
            MuteLog.e("Mute.Install", "abiMatch[false] patch ABI[%s] NOT match host require ABI[%s]", "arm64-v8a", hostAbi);
            return false;
        }
        MuteLog.i("Mute.Install", "abiMatch[true] patch / host ABI[%s] match", hostAbi);
        return true;
    }

    private void beginTran() {
        String str = "install_tran_" + this.mPatchVerCode + "_" + this.mPatchMd5;
        this.mTranKey = str;
        int installTranStatus = MuteSP.getInstallTranStatus(str);
        this.mTranStatus = installTranStatus;
        if (installTranStatus == 0) {
            this.mTranStatus = 10;
            MuteSP.setInstallTranStatus(this.mTranKey, 10);
        }
        this.mPatchVerDir = DirUtils.getPkgVerDir(this.mPatchVerCode);
        MuteLog.w("Mute.Install", "beginTran key[%s] value[XX-%d]", this.mTranKey, Integer.valueOf(this.mTranStatus));
    }

    private boolean dex2Opt() {
        if (this.mTranStatus >= 70) {
            DexOptimize.Result result = new DexOptimize.Result(MuteSP.getInstallOpt());
            this.mDexOptResult = result;
            MuteLog.w("Mute.Install", "dex2Opt[%b] tran[OAT-70] skip...", Boolean.valueOf(result.mSuccess));
            return this.mDexOptResult.mSuccess;
        }
        if (new PolarisFileWrapper(DirUtils.getPushDir(this.mContext), "mute_skip_oat.flag").exists()) {
            MuteLog.w("Mute.Install", "dex2Opt skip...", new Object[0]);
            DexOptimize.Result result2 = new DexOptimize.Result();
            this.mDexOptResult = result2;
            result2.mSuccess = true;
            return true;
        }
        DexOptimize.Result optimize = new DexOptimize().optimize(this.mContext, this.mPatchFile);
        this.mDexOptResult = optimize;
        MuteSP.setInstallOpt(optimize.format2Json());
        MuteSP.setInstallTranStatus(this.mTranKey, 70);
        MuteLog.w("Mute.Install", "dex2Opt[%b] finish", Boolean.valueOf(this.mDexOptResult.mSuccess));
        return this.mDexOptResult.mSuccess;
    }

    private boolean move() {
        File sourceApk = DirUtils.getSourceApk(this.mPatchVerCode);
        this.mPatchFile = sourceApk;
        if (this.mTranStatus >= 30) {
            MuteLog.w("Mute.Install", "move[true] tran[MOVE-30] skip...", new Object[0]);
            return true;
        }
        try {
            FileUtils.copyFileUsingStream(this.mOriginPatch, sourceApk);
            if (FileUtils.isLegalFile(this.mPatchFile)) {
                MuteSP.setInstallTranStatus(this.mTranKey, 30);
                MuteLog.i("Mute.Install", "move[true] patchFile --> patchSource", new Object[0]);
                return true;
            }
        } catch (IOException e) {
            reportFail("patch move fail");
            MuteLog.e("Mute.Install", "move[false] patchFile --> patchSource failed. %s", e);
        }
        return false;
    }

    private void reportDuration() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rule_id", Integer.valueOf(this.mRuleId));
        hashMap.put("patch_version", Integer.valueOf(this.mPatchVerCode));
        hashMap.put("patch_md5", this.mPatchMd5);
        hashMap.putAll(this.mTimer.formatTimeMap());
        IInstallCallback iInstallCallback = this.mCallback;
        if (iInstallCallback != null) {
            try {
                iInstallCallback.onReportDuration(10000, convert(hashMap));
                return;
            } catch (RemoteException e) {
                MuteLog.w("Mute.Install", "reportDuration failed. %s", e);
                return;
            }
        }
        Muter.getReporter().onReportDuration(10000, hashMap);
    }

    private boolean verNotLocked() {
        if (this.mPatchVerCode < this.mCurHostVerCode && !this.mEnableLockVer && !DirUtils.openLockVersion(this.mContext)) {
            reportFail("verNotLocked not LOCKED but patch <= host");
            MuteLog.e("Mute.Install", "verNotLocked[false] not LOCKED but patch <= host, not allow", Integer.valueOf(this.mCurHostVerCode));
            return false;
        }
        MuteLog.i("Mute.Install", "verNotLocked locked[%b] patchUpVerCode[%d]", Boolean.valueOf(this.mEnableLockVer), Integer.valueOf(this.mPatchVerCode));
        return true;
    }

    private boolean dexAlign() {
        if (this.mTranStatus >= 80) {
            this.mDexAlignResult = new DexAlign.Result(MuteSP.getInstallAlign());
            MuteLog.w("Mute.Install", "dexAlign[%b] tran[ALIGN-80] skip...", Boolean.valueOf(this.mDexOptResult.mSuccess));
            return this.mDexAlignResult.isSuccess();
        }
        if (new PolarisFileWrapper(DirUtils.getPushDir(this.mContext), "mute_skip_align.flag").exists()) {
            this.mDexAlignResult = new DexAlign.Result(4);
            MuteLog.w("Mute.Install", "dexAlign skip...", new Object[0]);
            return false;
        }
        DexAlign.Result align = new DexAlign().align(this.mPatchFile, DirUtils.getAlignApk(this.mPatchVerCode));
        this.mDexAlignResult = align;
        MuteSP.setInstallAlign(align.format2Json());
        MuteSP.setInstallTranStatus(this.mTranKey, 80);
        MuteLog.i("Mute.Install", "alignZip[%b] finish", Boolean.valueOf(this.mDexAlignResult.isSuccess()));
        return this.mDexAlignResult.isSuccess();
    }

    private boolean installImpl() {
        boolean z;
        if (!checkLatest() || !calPatchMd5() || !parsePatchPkg()) {
            return false;
        }
        this.mTimer.recordParseTime();
        if (!verNotLocked()) {
            return false;
        }
        beginTran();
        if (!signatureVerify()) {
            return false;
        }
        this.mTimer.recordSignTime();
        if (!move()) {
            return false;
        }
        this.mTimer.recordMoveTime();
        if (!obtainPatchPackage()) {
            return false;
        }
        this.mTimer.recordObtainTime();
        if (!unzipSo()) {
            return false;
        }
        this.mTimer.recordSoTime();
        if (!abiMatch()) {
            return false;
        }
        this.mTimer.recordAbiTime();
        if (!storeCompDiff()) {
            return false;
        }
        this.mTimer.recordDiffTime();
        if (!this.mPatchFile.exists()) {
            MuteLog.w("Mute.Install", "dex2Opt DEX invalid", new Object[0]);
            reportFail("DEX invalid");
            safeDelete();
            return false;
        }
        a.a a = Muter.getSettings().a();
        if (a != null && a.d) {
            z = true;
        } else {
            z = false;
        }
        boolean dex2Opt = dex2Opt();
        this.mTimer.recordDexOptTime();
        if (dex2Opt) {
            endTranWriteSp(z);
            return true;
        }
        if (OSUtil.isAndroidUHigher()) {
            boolean dexAlign = dexAlign();
            this.mTimer.recordAlignTime();
            if (dexAlign) {
                endTranWriteSp(z);
                return true;
            }
        }
        safeDelete();
        report(false, this.mDexOptResult, this.mDexAlignResult);
        return false;
    }

    private boolean parsePatchPkg() {
        PackageParser.Package parsePackage = new PackageParser().parsePackage(this.mOriginPatch, 0);
        this.mPatchPkg = parsePackage;
        if (parsePackage == null) {
            reportFail("parsePatchPkg pkg null");
            MuteLog.e("Mute.Install", "parsePatchPkg[false] pkg null", new Object[0]);
            return false;
        }
        if (parsePackage.mAppMetaData == null) {
            reportFail("parsePatchPkg metaData null");
            MuteLog.e("Mute.Install", "parsePatchPkg[false] metaData null", new Object[0]);
            return false;
        }
        int i = this.mPatchPkg.mAppMetaData.getInt("UPDATE_VERSION_CODE");
        this.mPatchVerCode = i;
        if (i <= 0) {
            reportFail("parsePatchPackage patchUpVerCode invalid");
            MuteLog.e("Mute.Install", "parsePatchPkg[false] patchUpVerCode[%d] invalid", Integer.valueOf(this.mPatchVerCode));
            return false;
        }
        if (!this.mPatchPkg.packageName.equals(this.mContext.getPackageName())) {
            reportFail("parsePatchPackage patch package name not match");
            MuteLog.e("Mute.Install", "parsePatchPkg[false] patch package name not match [%s]", this.mPatchPkg.packageName);
            return false;
        }
        MuteLog.i("Mute.Install", "parsePatchPackage patchUpVerCode[%d]", Integer.valueOf(this.mPatchVerCode));
        return true;
    }

    private boolean storeCompDiff() {
        if (this.mTranStatus >= 60) {
            MuteLog.w("Mute.Install", "storeCompDiff[true] tran[DIFF-60] skip...", new Object[0]);
            this.mRealHostUpVerCode = MuteSP.getInstallRealHostUpdateVCode();
            return true;
        }
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.mPatchVerDir, "host_base_temp.apk");
        try {
            FileUtils.copyFileUsingStream(new PolarisFileWrapper(this.mContext.getPackageCodePath()), polarisFileWrapper);
            MuteLog.i("Mute.Install", "storeCompDiff originHostApk --> targetHostApk", new Object[0]);
            PackageParser.Package parsePackage = new PackageParser().parsePackage(polarisFileWrapper, 0);
            MuteLog.i("Mute.Install", "storeCompDiff parseHostPackage", new Object[0]);
            FileUtils.safeDeleteFile(polarisFileWrapper);
            int i = parsePackage.mAppMetaData.getInt("UPDATE_VERSION_CODE", 0);
            this.mRealHostUpVerCode = i;
            MuteLog.i("Mute.Install", "storeCompDiff realHostUpVerCode[%d]", Integer.valueOf(i));
            ComponentDiff componentDiff = new ComponentDiff();
            componentDiff.diffActivity(parsePackage.activities, this.mPatchPkg.activities);
            componentDiff.diffService(parsePackage.services, this.mPatchPkg.services);
            componentDiff.diffReceiver(parsePackage.receivers, this.mPatchPkg.receivers);
            componentDiff.diffProvider(parsePackage.providers, this.mPatchPkg.providers);
            componentDiff.diffPermission(parsePackage.permissions, this.mPatchPkg.permissions);
            if (componentDiff.saveLocal(DirUtils.getComponentDiff(this.mPatchVerCode))) {
                MuteSP.setInstallRealHostUpdateVCode(this.mRealHostUpVerCode);
                MuteSP.setInstallTranStatus(this.mTranKey, 60);
                MuteLog.i("Mute.Install", "storeCompDiff[true] diffSerial --> component.diff", new Object[0]);
                return true;
            }
            reportFail("storeCompDiff saveToParcelFile fail");
            MuteLog.e("Mute.Install", "storeCompDiff[false] saveToParcelFile", new Object[0]);
            return false;
        } catch (Throwable th) {
            try {
                reportFail("storeCompDiff parseHostPackage failed");
                MuteLog.e("Mute.Install", "storeCompDiff[false] parseHostPackage failed. %s", th);
                return false;
            } finally {
                FileUtils.safeDeleteFile(polarisFileWrapper);
            }
        }
    }

    private boolean unzipSo() {
        if (this.mTranStatus >= 50) {
            MuteLog.w("Mute.Install", "unzipSo[true] tran[SO-50] skip...", new Object[0]);
            return true;
        }
        File nativeLibraryDir = DirUtils.getNativeLibraryDir(this.mPatchVerCode);
        ZipFile zipFile = null;
        try {
            ZipFile polarisZipFileWrapper = new PolarisZipFileWrapper(this.mPatchFile);
            try {
                Iterator it2 = Collections.list(polarisZipFileWrapper.entries()).iterator();
                while (it2.hasNext()) {
                    ZipEntry zipEntry = (ZipEntry) it2.next();
                    if (zipEntry != null && zipEntry.getName().startsWith("lib/arm64-v8a/")) {
                        String[] split = zipEntry.getName().split("/");
                        saveStreamToFile(polarisZipFileWrapper.getInputStream(zipEntry), new PolarisFileWrapper(nativeLibraryDir, split[split.length - 1]));
                    }
                }
                MuteSP.setInstallTranStatus(this.mTranKey, 50);
                MuteLog.i("Mute.Install", "unzipSo[true]", new Object[0]);
                try {
                    polarisZipFileWrapper.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th) {
                th = th;
                zipFile = polarisZipFileWrapper;
                try {
                    FileUtils.deleteDir(nativeLibraryDir);
                    reportFail("unzipSo fail");
                    MuteLog.e("Mute.Install", "unzipSo[false] failed. %s", th);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void setCallback(IInstallCallback iInstallCallback) {
        this.mCallback = iInstallCallback;
    }

    private Bundle convert(HashMap<String, Object> hashMap) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            bundle.putString(entry.getKey(), "" + entry.getValue());
        }
        return bundle;
    }

    public void tryDex2Oat(Context context) {
        int installVerCode = MuteSP.getInstallVerCode();
        File sourceApk = DirUtils.getSourceApk(installVerCode);
        MuteLog.i("Mute.Install", "tryDex2Oat patchVerCode[" + installVerCode + "]", new Object[0]);
        new DexOptimize().optimize(context, sourceApk);
    }

    private void reportFail(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rule_id", Integer.valueOf(this.mRuleId));
        hashMap.put("patch_version", Integer.valueOf(this.mPatchVerCode));
        hashMap.put("patch_md5", this.mPatchMd5);
        hashMap.put("detail", str);
        IInstallCallback iInstallCallback = this.mCallback;
        if (iInstallCallback != null) {
            try {
                iInstallCallback.onReportStatus(10000, 0, convert(hashMap));
                return;
            } catch (RemoteException e) {
                MuteLog.w("Mute.Install", "reportFail failed. %s", e);
                return;
            }
        }
        Muter.getReporter().onReportStatus(10000, 0, hashMap);
    }

    private boolean endTranWriteSp(boolean z) {
        boolean z2;
        MuteSP.setRomUpdate();
        MuteSP.setInstallVerCode(this.mPatchVerCode);
        MuteSP.setInstallMd5(this.mPatchMd5);
        MuteSP.setRuleId(this.mRuleId);
        MuteSP.setEnableLockVersion(this.mEnableLockVer);
        if (this.mEnableLockVer) {
            MuteSP.setSupportHostRange(this.mPatchVerCode + "|0|2147483647");
        }
        DexAlign.Result result = this.mDexAlignResult;
        if (result != null && result.isSuccess()) {
            z2 = true;
        } else {
            z2 = false;
        }
        MuteSP.setAlignDex(z2);
        MuteSP.setInstallOptMode(z);
        MuteSP.removeTranStatus(this.mTranKey);
        MuteSP.removeInstallOpt();
        MuteSP.removeInstallAlign();
        report(true, this.mDexOptResult, this.mDexAlignResult);
        FileUtils.safeDeleteFile(this.mOriginPatch);
        sInstallReady = true;
        MuteLog.i("Mute.Install", "endTranWriteSp optMode[%b] patchVerCode[%d] md5[%s] ruleId[%d] lockVer[%b] nativeLibs[...] realHostVer[%d]", Boolean.valueOf(z), Integer.valueOf(this.mPatchVerCode), this.mPatchMd5, Integer.valueOf(this.mRuleId), Boolean.valueOf(this.mEnableLockVer), Integer.valueOf(this.mRealHostUpVerCode));
        return true;
    }

    private static void saveStreamToFile(InputStream inputStream, File file) throws IOException {
        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                polarisFileOutputStreamWrapper.write(bArr, 0, read);
            } else {
                polarisFileOutputStreamWrapper.close();
                inputStream.close();
                return;
            }
        }
    }

    public MuteInstaller(String str, int i, boolean z) {
        this.mRuleId = i;
        this.mEnableLockVer = z;
        this.mPatchPath = str;
    }

    private void report(boolean z, DexOptimize.Result result, DexAlign.Result result2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rule_id", Integer.valueOf(this.mRuleId));
        hashMap.put("patch_version", Integer.valueOf(this.mPatchVerCode));
        hashMap.put("patch_md5", this.mPatchMd5);
        if (result != null) {
            hashMap.putAll(result.formatMap());
        }
        if (result2 != null) {
            hashMap.putAll(result2.formatMap());
        }
        if (!z) {
            hashMap.put("detail", "dex_opt");
        }
        IInstallCallback iInstallCallback = this.mCallback;
        if (iInstallCallback != null) {
            try {
                iInstallCallback.onReportStatus(10000, z ? 1 : 0, convert(hashMap));
                return;
            } catch (RemoteException e) {
                MuteLog.w("Mute.Install", "report failed. %s", e);
                return;
            }
        }
        Muter.getReporter().onReportStatus(10000, z ? 1 : 0, hashMap);
    }
}
