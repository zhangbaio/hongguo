package com.tencent.tinker.lib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageParser;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteReplacer {
    public static boolean sThemeChanged;

    static {
        Covode.recordClassIndex(653709);
    }

    public static void modifyLoadedApk(Context context) throws IllegalAccessException {
        String absolutePath = MuteMaxLoader.mPatchSource.getAbsolutePath();
        Object readField = FieldUtils.readField(context, "mPackageInfo");
        FieldUtils.writeField(readField, "mAppDir", absolutePath);
        FieldUtils.writeField(readField, "mResDir", absolutePath);
        MuteLog.i("Mute.Rpl", "modifyLoadedApk mAppDir = mResDir [%s]", absolutePath);
    }

    public static void modifyAppConfig(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if (OSUtil.isAndroidNHigher()) {
            Object newInstance = Class.forName("android.security.net.config.ManifestConfigSource").getConstructor(Context.class).newInstance(context);
            Class<?> cls = Class.forName("android.security.net.config.ApplicationConfig");
            MethodUtils.invokeStaticMethod(cls, "setDefaultInstance", cls.getConstructors()[0].newInstance(newInstance));
            MuteLog.i("Mute.Rpl", "modifyAppConfig ApplicationConfig.setDefaultInstance(x)", new Object[0]);
        }
    }

    public static void modifyAppInfo(ApplicationInfo applicationInfo) throws IllegalAccessException {
        ApplicationInfo applicationInfo2;
        int intValue;
        int intValue2;
        String absolutePath = MuteMaxLoader.mPatchSource.getAbsolutePath();
        applicationInfo.sourceDir = absolutePath;
        applicationInfo.publicSourceDir = absolutePath;
        MuteLog.i("Mute.Rpl", "modifyAppInfo sourceDir and publicSourceDir", new Object[0]);
        PackageParser.Package r1 = MuteMaxLoader.sPatchPkg;
        if (r1 != null && (applicationInfo2 = r1.applicationInfo) != null) {
            int i = applicationInfo.theme;
            if (i != applicationInfo2.theme) {
                MuteLog.i("Mute.Rpl", "modifyAppInfo theme[%s] --> [%s]", Integer.toHexString(i), Integer.toHexString(applicationInfo2.theme));
                applicationInfo.theme = applicationInfo2.theme;
                sThemeChanged = true;
            }
            int i2 = applicationInfo.labelRes;
            if (i2 != applicationInfo2.labelRes) {
                MuteLog.i("Mute.Rpl", "modifyAppInfo labelRes[%s] --> [%s]", Integer.toHexString(i2), Integer.toHexString(applicationInfo2.labelRes));
                applicationInfo.labelRes = applicationInfo2.labelRes;
            }
            int i3 = applicationInfo.icon;
            if (i3 != applicationInfo2.icon) {
                MuteLog.i("Mute.Rpl", "modifyAppInfo icon[%s] --> [%s]", Integer.toHexString(i3), Integer.toHexString(applicationInfo2.icon));
                applicationInfo.icon = applicationInfo2.icon;
            }
            int i4 = applicationInfo.logo;
            if (i4 != applicationInfo2.logo) {
                MuteLog.i("Mute.Rpl", "modifyAppInfo logo[%s] --> [%s]", Integer.toHexString(i4), Integer.toHexString(applicationInfo2.logo));
                applicationInfo.logo = applicationInfo2.logo;
            }
            if (OSUtil.isAndroidNHigher() && (intValue2 = ((Integer) FieldUtils.readField(applicationInfo, "networkSecurityConfigRes")).intValue()) != (intValue = ((Integer) FieldUtils.readField(applicationInfo2, "networkSecurityConfigRes")).intValue())) {
                MuteLog.i("Mute.Rpl", "modifyAppInfo networkSecurityConfigRes[%s] --> [%s]", Integer.toHexString(intValue2), Integer.toHexString(intValue));
                FieldUtils.writeField(applicationInfo, "networkSecurityConfigRes", Integer.valueOf(intValue));
            }
        }
    }
}
