package com.tencent.tinker.lib.dexopt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.lib.utils.CmdUtil;
import com.tencent.tinker.lib.utils.DirUtils;
import com.tencent.tinker.lib.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Dex2OatHelper {
    static {
        Covode.recordClassIndex(653734);
    }

    static class Dex2OatCompMode {
        public static int FASTER_ONLY_VERIFY;
        public static int FASTEST_NONE;
        public static int SLOWLY_ALL;

        Dex2OatCompMode() {
        }

        static {
            Covode.recordClassIndex(653735);
            FASTEST_NONE = 0;
            FASTER_ONLY_VERIFY = 1;
            SLOWLY_ALL = 3;
        }
    }

    public static SharedPreferences getOatSharedPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("plugin_oat_info", 0);
    }

    public static String getOatFileName(String str) {
        String str2;
        String substring = str.substring(str.lastIndexOf("/") + 1);
        String substring2 = substring.substring(substring.lastIndexOf("."));
        if (Build.VERSION.SDK_INT < 26) {
            str2 = ".dex";
        } else {
            str2 = ".odex";
        }
        if (!".dex".equals(substring2)) {
            if (!".zip".equals(substring2) && !".apk".equals(substring2)) {
                return substring + str2;
            }
            return substring.replace(substring2, str2);
        }
        return substring;
    }

    public static boolean execFastDex2OatCmd(String str, String str2) {
        return execDex2OatCmd(str, str2, Dex2OatCompMode.FASTER_ONLY_VERIFY);
    }

    public static boolean execFullDex2OatCmd(String str, String str2) {
        return execDex2OatCmd(str, str2, Dex2OatCompMode.SLOWLY_ALL);
    }

    private static void replaceOat(String str, String str2) {
        String str3;
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (polarisFileWrapper.exists()) {
            FileUtils.renameFile(polarisFileWrapper, str2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            str3 = ".odex";
        } else {
            str3 = ".dex";
        }
        PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(str.replace(str3, ".art"));
        if (polarisFileWrapper2.exists()) {
            FileUtils.renameFile(polarisFileWrapper2, str2.replace(str3, ".art"));
        }
        PolarisFileWrapper polarisFileWrapper3 = new PolarisFileWrapper(str.replace(str3, ".vdex"));
        if (polarisFileWrapper3.exists()) {
            FileUtils.renameFile(polarisFileWrapper3, str2.replace(str3, ".vdex"));
        }
    }

    private static boolean execDex2OatCmd(String str, String str2, int i) {
        String str3 = new PolarisFileWrapper(str2).getParent() + File.separator + "compFully" + DirUtils.getOatFileExt(str);
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str3);
        if (!polarisFileWrapper.exists()) {
            polarisFileWrapper.getParentFile().mkdirs();
        }
        CmdUtil.execCmd(getDex2OatCommandAndParams(str, str3, i));
        replaceOat(str3, str2);
        return true;
    }

    static String[] getDex2OatCommandAndParams(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + DirUtils.getCurtInstSet());
        if (i == Dex2OatCompMode.FASTER_ONLY_VERIFY) {
            if (i2 > 25) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == Dex2OatCompMode.SLOWLY_ALL) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=" + str);
        arrayList.add("--oat-file=" + str2);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
