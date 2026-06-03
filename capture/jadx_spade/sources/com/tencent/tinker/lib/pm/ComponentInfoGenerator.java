package com.tencent.tinker.lib.pm;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.hidden.q.DoubleReflector;
import com.tencent.tinker.lib.utils.FieldUtils;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ComponentInfoGenerator {
    static {
        Covode.recordClassIndex(653772);
    }

    public static void addProcessName(ComponentInfo componentInfo) {
        String str = componentInfo.processName;
        if (str == null || str.length() <= 0) {
            componentInfo.processName = componentInfo.applicationInfo.processName;
        }
    }

    public static ActivityInfo generateActivityInfo(PackageParser.Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        ActivityInfo activityInfo = new ActivityInfo(activity.info);
        if ((i & 128) != 0) {
            activityInfo.metaData = activity.metaData;
        }
        activityInfo.applicationInfo = generateApplicationInfo(activity.owner, i);
        addProcessName(activityInfo);
        return activityInfo;
    }

    public static PermissionInfo generatePermissionInfo(PackageParser.Permission permission, int i) {
        if (permission == null) {
            return null;
        }
        if ((i & 128) == 0) {
            return permission.info;
        }
        PermissionInfo permissionInfo = new PermissionInfo(permission.info);
        permissionInfo.metaData = permission.metaData;
        return permissionInfo;
    }

    public static ServiceInfo generateServiceInfo(PackageParser.Service service, int i) {
        if (service == null) {
            return null;
        }
        ServiceInfo serviceInfo = new ServiceInfo(service.info);
        if ((i & 128) != 0) {
            serviceInfo.metaData = service.metaData;
        }
        serviceInfo.applicationInfo = generateApplicationInfo(service.owner, i);
        addProcessName(serviceInfo);
        return serviceInfo;
    }

    public static ProviderInfo generateProviderInfo(PackageParser.Provider provider, int i) {
        if (provider == null) {
            return null;
        }
        ProviderInfo providerInfo = new ProviderInfo(provider.info);
        if ((i & 128) != 0) {
            providerInfo.metaData = provider.metaData;
        }
        if ((i & 2048) == 0) {
            providerInfo.uriPermissionPatterns = null;
        }
        providerInfo.applicationInfo = generateApplicationInfo(provider.owner, i);
        addProcessName(providerInfo);
        return providerInfo;
    }

    private static String validateName(String str, boolean z) {
        int length = str.length();
        boolean z2 = false;
        boolean z3 = true;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                z3 = false;
            } else if (z3 || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                if (charAt == '.') {
                    z2 = true;
                    z3 = true;
                } else {
                    return "bad character '" + charAt + "'";
                }
            }
        }
        if (!z2 && z) {
            return "must have at least one '.' separator";
        }
        return null;
    }

    public static ApplicationInfo generateApplicationInfo(PackageParser.Package r8, int i) {
        String str;
        if (r8 == null) {
            return null;
        }
        ApplicationInfo applicationInfo = new ApplicationInfo(r8.applicationInfo);
        if ((i & 128) != 0) {
            applicationInfo.metaData = r8.mAppMetaData;
        }
        String str2 = applicationInfo.className;
        if (str2 != null) {
            applicationInfo.className = buildClassName(applicationInfo.packageName, str2, null);
        }
        try {
            str = (String) FieldUtils.readField(DoubleReflector.getField(r8.getClass(), "codePath"), r8);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null) {
            try {
                str = (String) FieldUtils.readField(DoubleReflector.getField(r8.getClass(), "baseCodePath"), r8);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        if (applicationInfo.sourceDir == null && str != null) {
            applicationInfo.sourceDir = str;
        }
        if (applicationInfo.publicSourceDir == null && str != null) {
            applicationInfo.publicSourceDir = str;
        }
        Context appContext = Muter.getAppContext();
        if (applicationInfo.dataDir == null) {
            applicationInfo.dataDir = appContext.getApplicationInfo().dataDir;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (applicationInfo.deviceProtectedDataDir == null) {
                applicationInfo.deviceProtectedDataDir = appContext.getApplicationInfo().deviceProtectedDataDir;
            }
            try {
                if (FieldUtils.readField(applicationInfo, "credentialProtectedDataDir") == null) {
                    FieldUtils.writeField(applicationInfo, "credentialProtectedDataDir", applicationInfo.dataDir);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            if (FieldUtils.readField(applicationInfo, "scanSourceDir") == null) {
                FieldUtils.writeField(applicationInfo, "scanSourceDir", applicationInfo.sourceDir);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            if (FieldUtils.readField(applicationInfo, "scanPublicSourceDir") == null) {
                FieldUtils.writeField(applicationInfo, "scanPublicSourceDir", applicationInfo.publicSourceDir);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        if (applicationInfo.nativeLibraryDir == null && str != null) {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
            if (polarisFileWrapper.getParentFile() != null && polarisFileWrapper.getParentFile().getParentFile() != null) {
                applicationInfo.nativeLibraryDir = new PolarisFileWrapper(polarisFileWrapper.getParentFile().getParentFile(), "lib").getPath();
            }
        }
        String packageName = appContext.getPackageName();
        String str3 = applicationInfo.packageName;
        String buildProcessName = buildProcessName(str3, str3, packageName, i, null);
        applicationInfo.processName = buildProcessName;
        if (TextUtils.isEmpty(buildProcessName)) {
            applicationInfo.processName = applicationInfo.packageName;
        }
        applicationInfo.uid = appContext.getApplicationInfo().uid;
        return applicationInfo;
    }

    private static String buildClassName(String str, CharSequence charSequence, String[] strArr) {
        if (charSequence != null && charSequence.length() > 0) {
            String charSequence2 = charSequence.toString();
            char charAt = charSequence2.charAt(0);
            if (charAt == '.') {
                return (str + charSequence2).intern();
            }
            if (charSequence2.indexOf(46) < 0) {
                return (str + '.' + charSequence2).intern();
            }
            if (charAt >= 'a' && charAt <= 'z') {
                return charSequence2.intern();
            }
            strArr[0] = "Bad class name " + charSequence2 + " in package " + str;
            return null;
        }
        strArr[0] = "Empty class name in package " + str;
        return null;
    }

    private static String buildCompoundName(String str, CharSequence charSequence, String str2, String[] strArr) {
        String charSequence2 = charSequence.toString();
        char charAt = charSequence2.charAt(0);
        if (str != null && charAt == ':') {
            if (charSequence2.length() < 2) {
                strArr[0] = "Bad " + str2 + " name " + charSequence2 + " in package " + str + ": must be at least two characters";
                return null;
            }
            String validateName = validateName(charSequence2.substring(1), false);
            if (validateName != null) {
                strArr[0] = "Invalid " + str2 + " name " + charSequence2 + " in package " + str + ": " + validateName;
                return null;
            }
            return (str + charSequence2).intern();
        }
        String validateName2 = validateName(charSequence2, true);
        if (validateName2 != null && !"system".equals(charSequence2)) {
            strArr[0] = "Invalid " + str2 + " name " + charSequence2 + " in package " + str + ": " + validateName2;
            return null;
        }
        return charSequence2.intern();
    }

    private static String buildProcessName(String str, String str2, CharSequence charSequence, int i, String[] strArr) {
        if ((i & 4) != 0 && !"system".equals(charSequence)) {
            if (str2 != null) {
                return str2;
            }
            return str;
        }
        if (charSequence != null && charSequence.length() > 0) {
            return buildCompoundName(str, charSequence, "process", strArr);
        }
        return str2;
    }
}
