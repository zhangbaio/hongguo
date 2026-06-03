package com.tencent.tinker.lib.utils;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteMaxLoader;
import com.tencent.tinker.lib.MuteResReplacer;
import com.tencent.tinker.lib.Muter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ResTranUtils {
    private static Method m_getResIdentifier;
    public static HashMap<Integer, Integer> sCacheTransRTxtMap;
    private static AssetManager sOldApkAssetManager;

    private static Object com_tencent_tinker_lib_utils_ResTranUtils_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    static {
        Covode.recordClassIndex(653933);
        sCacheTransRTxtMap = new HashMap<>();
    }

    private static AssetManager getOriginApkAssetMgr(String[] strArr) {
        AssetManager assetManager = sOldApkAssetManager;
        if (assetManager != null) {
            return assetManager;
        }
        try {
            AssetManager assetManager2 = (AssetManager) AssetManager.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            declaredMethod.setAccessible(true);
            for (String str : strArr) {
                declaredMethod.invoke(assetManager2, str);
            }
            Method declaredMethod2 = AssetManager.class.getDeclaredMethod("getResourceIdentifier", String.class, String.class, String.class);
            m_getResIdentifier = declaredMethod2;
            declaredMethod2.setAccessible(true);
            sOldApkAssetManager = assetManager2;
        } catch (IllegalAccessException e) {
            MuteLog.e("Mute.ResTran", "getOriginApkAssetMgr err, %s", e);
        } catch (InstantiationException e2) {
            MuteLog.e("Mute.ResTran", "getOriginApkAssetMgr err, %s", e2);
        } catch (NoSuchMethodException e3) {
            MuteLog.e("Mute.ResTran", "getOriginApkAssetMgr err, %s", e3);
        } catch (InvocationTargetException e4) {
            MuteLog.e("Mute.ResTran", "getOriginApkAssetMgr err, %s", e4);
        }
        return sOldApkAssetManager;
    }

    public static int transResourceId(int i, String str) {
        if (!MuteMaxLoader.isPatchEnv()) {
            MuteLog.w("Mute.ResTran", "transResourceId origin %s[0x%s]", str, Integer.toHexString(i));
            return i;
        }
        if (i == 0) {
            MuteLog.w("Mute.ResTran", "transResourceId resId=0 type=%s", str);
            return i;
        }
        if (sCacheTransRTxtMap.containsKey(Integer.valueOf(i))) {
            int intValue = sCacheTransRTxtMap.get(Integer.valueOf(i)).intValue();
            MuteLog.w("Mute.ResTran", "transResourceId cached %s [0x%s] --> [0x%s]", str, Integer.toHexString(i), Integer.toHexString(intValue));
            return intValue;
        }
        String[] strArr = MuteResReplacer.sOriginApkAssets;
        if (strArr == null) {
            MuteLog.w("Mute.ResTran", "transResourceId oldApkPaths null! %s [0x%s]", str, Integer.toHexString(i));
            return i;
        }
        AssetManager originApkAssetMgr = getOriginApkAssetMgr(strArr);
        if (originApkAssetMgr != null && m_getResIdentifier != null) {
            String resourceName = Muter.getAppContext().getResources().getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                MuteLog.w("Mute.ResTran", "transResourceId resName null! %s [0x%s]", str, Integer.toHexString(i));
                return i;
            }
            try {
                int intValue2 = ((Integer) com_tencent_tinker_lib_utils_ResTranUtils_java_lang_reflect_Method_invoke(m_getResIdentifier, originApkAssetMgr, new Object[]{resourceName, str, Muter.getAppContext().getPackageName()})).intValue();
                sCacheTransRTxtMap.put(Integer.valueOf(i), Integer.valueOf(intValue2));
                MuteLog.i("Mute.ResTran", "transResourceId %s %s[0x%s] --> [0x%s]", str, resourceName, Integer.toHexString(i), Integer.toHexString(intValue2));
                return intValue2;
            } catch (IllegalAccessException e) {
                MuteLog.e("Mute.ResTran", "transResourceId err, %s", e);
                MuteLog.w("Mute.ResTran", "transResourceId failed %s %s[0x%s]", str, resourceName, Integer.toHexString(i));
                return i;
            } catch (InvocationTargetException e2) {
                MuteLog.e("Mute.ResTran", "transResourceId err, %s", e2);
                MuteLog.w("Mute.ResTran", "transResourceId failed %s %s[0x%s]", str, resourceName, Integer.toHexString(i));
                return i;
            }
        }
        MuteLog.w("Mute.ResTran", "transResourceId oldApkAssetManager null! %s [0x%s]", str, Integer.toHexString(i));
        return i;
    }

    public static int[] transAnim(int i, int i2, boolean z) {
        int transResourceId;
        int[] iArr = new int[2];
        if (MuteMaxLoader.isPatchEnv()) {
            if (sCacheTransRTxtMap.containsKey(Integer.valueOf(i)) && sCacheTransRTxtMap.containsKey(Integer.valueOf(i2))) {
                int intValue = sCacheTransRTxtMap.get(Integer.valueOf(i)).intValue();
                int intValue2 = sCacheTransRTxtMap.get(Integer.valueOf(i2)).intValue();
                MuteLog.i("Mute.ResTran", "transAnim cached! enterAnim[0x%s] --> [0x%s], exitAnim[0x%s] --> [0x%s]", Integer.toHexString(i), Integer.toHexString(intValue), Integer.toHexString(i2), Integer.toHexString(intValue2));
                iArr[0] = intValue;
                iArr[1] = intValue2;
                return iArr;
            }
            if (z) {
                transResourceId = i2;
            } else {
                transResourceId = transResourceId(i2, "anim");
            }
            int transResourceId2 = transResourceId(i, "anim");
            if (transResourceId2 != -1 && transResourceId != -1) {
                iArr[0] = transResourceId2;
                iArr[1] = transResourceId;
                sCacheTransRTxtMap.put(Integer.valueOf(i), Integer.valueOf(transResourceId2));
                sCacheTransRTxtMap.put(Integer.valueOf(i2), Integer.valueOf(transResourceId));
                return iArr;
            }
            return null;
        }
        MuteLog.w("Mute.ResTran", "transAnim origin enterAnim[0x%s], exitAnim[0x%s]", Integer.toHexString(i), Integer.toHexString(i2));
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }
}
