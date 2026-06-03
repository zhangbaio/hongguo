package com.tencent.tinker.lib;

import android.content.pm.PackageParser;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.lib.utils.FileUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MutePkgMgr {
    private static Map<String, Bundle> sMetaInfoMap;

    static {
        Covode.recordClassIndex(653708);
        sMetaInfoMap = new HashMap();
    }

    public static PackageParser.Package obtainPackage(File file) throws Throwable {
        PackageParser.Package resolvePkgInfoLocal = resolvePkgInfoLocal(file.getParentFile());
        if (resolvePkgInfoLocal == null) {
            return parsePackage(file);
        }
        return resolvePkgInfoLocal;
    }

    public static Bundle getMetaInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sMetaInfoMap.get(str);
    }

    private static File getPkgInfoFile(File file) {
        return new PolarisFileWrapper(file, "package" + Build.VERSION.SDK_INT + ".info");
    }

    private static PackageParser.Package parsePackage(File file) throws Throwable {
        PackageParser.Package parsePackage = new PackageParser().parsePackage(file, 0);
        if (parsePackage != null) {
            MuteLog.i("Mute.PkgMgr", "PackageParser.parsePackage pkg[..]", new Object[0]);
            savePackageInfo(file, parsePackage);
        }
        if (parsePackage != null) {
            return parsePackage;
        }
        MuteLog.i("Mute.PkgMgr", "PackageParser.parsePackage pkg[null]", new Object[0]);
        throw new RuntimeException("parse package failed!");
    }

    public static PackageParser.Package resolvePkgInfoLocal(File file) throws Throwable {
        PackageParser.Package r5;
        Throwable th;
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper;
        File pkgInfoFile = getPkgInfoFile(file);
        if (!pkgInfoFile.exists()) {
            MuteLog.w("Mute.PkgMgr", "resolvePkgInfoLocal localFile[package.info] not exist", new Object[0]);
            return null;
        }
        try {
            polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(pkgInfoFile);
            try {
                int available = polarisFileInputStreamWrapper.available();
                byte[] bArr = new byte[available];
                polarisFileInputStreamWrapper.read(bArr);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, available);
                obtain.setDataPosition(0);
                r5 = (PackageParser.Package) obtain.readParcelable(MutePkgMgr.class.getClassLoader());
                try {
                    MuteLog.i("Mute.PkgMgr", "resolvePkgInfoLocal package.info --> pkg[..]", new Object[0]);
                    polarisFileInputStreamWrapper.close();
                    if (r5 == null) {
                        MuteLog.w("Mute.PkgMgr", "resolvePkgInfoLocal del localFile", new Object[0]);
                        FileUtils.safeDeleteFile(pkgInfoFile);
                    }
                    return r5;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        MuteLog.e("Mute.PkgMgr", "resolvePkgInfoLocal err", th);
                        throw th;
                    } catch (Throwable th3) {
                        if (polarisFileInputStreamWrapper != null) {
                            polarisFileInputStreamWrapper.close();
                        }
                        if (r5 == null) {
                            MuteLog.w("Mute.PkgMgr", "resolvePkgInfoLocal del localFile", new Object[0]);
                            FileUtils.safeDeleteFile(pkgInfoFile);
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                r5 = null;
                th = th4;
            }
        } catch (Throwable th5) {
            r5 = null;
            th = th5;
            polarisFileInputStreamWrapper = null;
        }
    }

    public static void parseMetaInfo(PackageParser.Package r4) {
        if (r4 != null && r4.activities != null && r4.activities.size() > 0) {
            Bundle bundle = r4.mAppMetaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            sMetaInfoMap.put(Muter.getAppContext().getPackageName(), bundle);
            Iterator it2 = r4.activities.iterator();
            while (it2.hasNext()) {
                PackageParser.Activity activity = (PackageParser.Activity) it2.next();
                if (activity.metaData == null) {
                    activity.metaData = new Bundle();
                }
                sMetaInfoMap.put(activity.className, activity.metaData);
            }
            Iterator it4 = r4.services.iterator();
            while (it4.hasNext()) {
                PackageParser.Service service = (PackageParser.Service) it4.next();
                if (service.metaData == null) {
                    service.metaData = new Bundle();
                }
                sMetaInfoMap.put(service.className, service.metaData);
            }
            Iterator it5 = r4.receivers.iterator();
            while (it5.hasNext()) {
                PackageParser.Activity activity2 = (PackageParser.Activity) it5.next();
                if (activity2.metaData == null) {
                    activity2.metaData = new Bundle();
                }
                sMetaInfoMap.put(activity2.className, activity2.metaData);
            }
            Iterator it6 = r4.providers.iterator();
            while (it6.hasNext()) {
                PackageParser.Provider provider = (PackageParser.Provider) it6.next();
                if (provider.metaData == null) {
                    provider.metaData = new Bundle();
                }
                sMetaInfoMap.put(provider.className, provider.metaData);
            }
        }
    }

    private static boolean savePackageInfo(File file, PackageParser.Package r8) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        boolean z = false;
        if (file.getParentFile() == null) {
            MuteLog.w("Mute.PkgMgr", "savePackageInfo parent is null", new Object[0]);
            return false;
        }
        File pkgInfoFile = getPkgInfoFile(file.getParentFile());
        pkgInfoFile.createNewFile();
        if (!pkgInfoFile.exists()) {
            MuteLog.w("Mute.PkgMgr", String.format("savePackageInfo localFile[%s] not exist", pkgInfoFile.getAbsolutePath()), new Object[0]);
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(pkgInfoFile);
            try {
                bufferedOutputStream = new BufferedOutputStream(polarisFileOutputStreamWrapper);
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.writeParcelable(r8, 0);
                    bufferedOutputStream.write(obtain.marshall());
                    MuteLog.i("Mute.PkgMgr", "savePackageInfo pkg[..] --> package.info", new Object[0]);
                    try {
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        polarisFileOutputStreamWrapper.flush();
                        polarisFileOutputStreamWrapper.close();
                        z = true;
                    } catch (Throwable th) {
                        MuteLog.w("Mute.PkgMgr", "savePackageInfo close bos fos fail " + th.getMessage(), new Object[0]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = polarisFileOutputStreamWrapper;
                    try {
                        MuteLog.w("Mute.PkgMgr", "savePackageInfo err", th);
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            MuteLog.w("Mute.PkgMgr", "savePackageInfo close bos fos fail " + th3.getMessage(), new Object[0]);
                        }
                        if (!z) {
                            FileUtils.safeDeleteFile(pkgInfoFile);
                        }
                        return z;
                    } catch (Throwable th4) {
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            MuteLog.w("Mute.PkgMgr", "savePackageInfo close bos fos fail " + th5.getMessage(), new Object[0]);
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedOutputStream = null;
        }
        if (!z && pkgInfoFile.exists()) {
            FileUtils.safeDeleteFile(pkgInfoFile);
        }
        return z;
    }
}
