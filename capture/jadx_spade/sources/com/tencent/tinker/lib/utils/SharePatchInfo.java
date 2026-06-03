package com.tencent.tinker.lib.utils;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SharePatchInfo {
    public String baseAppVersion;
    public boolean disallowDexImg;
    public String fingerPrint;
    public boolean isProtectedApp;
    public boolean isRemoveInterpretOATDir;
    public boolean isRemoveNewVersion;
    public String newVersion;
    public String oatDir;
    public String oldVersion;
    public boolean optLoadEnable;
    public String patchVersion;

    static {
        Covode.recordClassIndex(653941);
    }

    public void updateDisallowDexImg(boolean z) {
        this.disallowDexImg = z;
    }

    public void updateOptLoadEnable(boolean z) {
        this.optLoadEnable = z;
    }

    public void updatePatchVersion(String str) {
        this.patchVersion = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0125 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.tencent.tinker.lib.utils.SharePatchInfo readAndCheckProperty(java.io.File r19) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.utils.SharePatchInfo.readAndCheckProperty(java.io.File):com.tencent.tinker.lib.utils.SharePatchInfo");
    }

    public static SharePatchInfo readAndCheckPropertyWithLock(File file, File file2) {
        ShareFileLockHelper shareFileLockHelper = null;
        if (file == null || file2 == null) {
            return null;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            try {
                shareFileLockHelper = ShareFileLockHelper.getFileLock(file2);
                SharePatchInfo readAndCheckProperty = readAndCheckProperty(file);
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e) {
                        MuteLog.w("Tinker.PatchInfo", "releaseInfoLock error", e);
                    }
                }
                return readAndCheckProperty;
            } catch (Throwable th) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e2) {
                        MuteLog.w("Tinker.PatchInfo", "releaseInfoLock error", e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            throw new RuntimeException("readAndCheckPropertyWithLock fail", e3);
        }
    }

    public static boolean rewritePatchInfoFileWithLock(File file, SharePatchInfo sharePatchInfo, File file2) {
        return rewritePatchInfoFileWithLock(file, sharePatchInfo, file2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean rewritePatchInfoFile(java.io.File r7, com.tencent.tinker.lib.utils.SharePatchInfo r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.utils.SharePatchInfo.rewritePatchInfoFile(java.io.File, com.tencent.tinker.lib.utils.SharePatchInfo, boolean):boolean");
    }

    public static boolean rewritePatchInfoFileWithLock(File file, SharePatchInfo sharePatchInfo, File file2, boolean z) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            try {
                shareFileLockHelper = ShareFileLockHelper.getFileLock(file2);
                boolean rewritePatchInfoFile = rewritePatchInfoFile(file, sharePatchInfo, z);
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e) {
                        MuteLog.i("Tinker.PatchInfo", "releaseInfoLock error", e);
                    }
                }
                return rewritePatchInfoFile;
            } catch (Throwable th) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e2) {
                        MuteLog.i("Tinker.PatchInfo", "releaseInfoLock error", e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            throw new RuntimeException("rewritePatchInfoFileWithLock fail", e3);
        }
    }

    public SharePatchInfo(String str, String str2, boolean z, boolean z2, String str3, String str4, boolean z3) {
        this.oldVersion = str;
        this.newVersion = str2;
        this.isProtectedApp = z;
        this.isRemoveNewVersion = z2;
        this.fingerPrint = str3;
        this.oatDir = str4;
        this.isRemoveInterpretOATDir = z3;
    }
}
