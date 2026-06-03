package com.tencent.tinker.lib;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.hidden.q.DoubleReflector;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import com.tencent.tinker.lib.utils.ResUtils;
import com.tencent.tinker.lib.utils.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteResReplacer {
    private static Field f_mAssets;
    private static Field f_mPackages;
    private static Field f_mResDir;
    private static Collection<WeakReference<Resources>> f_mResRef;
    private static Field f_mResourcePackages;
    private static Field f_mResourcesImpl;
    private static Field f_mStringBlocks;
    private static Field f_publicSourceDir;
    private static Method m_addAssetPath;
    private static Method m_addAssetPathAsSharedLibrary;
    private static Method m_ensureStringBlocks;
    private static Object sCurActivityThread;
    public static AssetManager sMuteAssetMgr;
    public static String[] sOriginApkAssets;
    public static AssetManager sOriginAssetMgr;

    static {
        Covode.recordClassIndex(653710);
    }

    private static Object com_tencent_tinker_lib_MuteResReplacer_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) throws Throwable {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public static boolean isSharedLib(ApplicationInfo applicationInfo) {
        if (OSUtil.isAndroidNHigher() && applicationInfo != null && applicationInfo.sharedLibraryFiles != null) {
            return true;
        }
        return false;
    }

    public static void clearResTypedArrayPool(Resources resources) {
        try {
            while (MethodUtils.invokeMethod(FieldUtils.readField(resources, "mTypedArrayPool"), "acquire", new Object[0]) != null) {
            }
            MuteLog.i("Mute.ResRpl", "clearResTypedArrayPool res.mTypedArrayPool.acquire() == null", new Object[0]);
        } catch (Throwable th) {
            MuteLog.e("Mute.ResRpl", "clearResTypedArrayPool failed", th);
        }
    }

    public static void flushRes(Resources resources) {
        try {
            Class<?> cls = Class.forName("androidx.appcompat.app.d");
            if (OSUtil.isAndroidPHigher()) {
                MuteLog.i("Mute.ResRpl", "flushNougats", new Object[0]);
                MethodUtils.invokeStaticMethod(cls, "flushNougats", resources);
            } else if (OSUtil.isAndroidLHigher()) {
                MuteLog.i("Mute.ResRpl", "flush", new Object[0]);
                MethodUtils.invokeStaticMethod(cls, "flush", resources);
            }
        } catch (Throwable th) {
            MuteLog.e("Mute.ResRpl", "flushRes failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void pruneResourceCaches(java.lang.Object r6) {
        /*
            boolean r0 = com.tencent.tinker.lib.utils.OSUtil.isAndroidMHigher()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L24
            java.lang.String r0 = "Mute.ResRpl"
            java.lang.String r3 = "pruneResourceCaches res = res.mResourcesImpl"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L18
            com.tencent.tinker.lib.MuteLog.i(r0, r3, r4)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "mResourcesImpl"
            java.lang.Object r6 = com.tencent.tinker.lib.utils.FieldUtils.readField(r6, r0)     // Catch: java.lang.Throwable -> L18
            goto L24
        L18:
            r0 = move-exception
            java.lang.String r3 = "Mute.ResRpl"
            java.lang.String r4 = "pruneResourceCaches res = res.mResourcesImpl failed"
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r2] = r0
            com.tencent.tinker.lib.MuteLog.e(r3, r4, r5)
        L24:
            boolean r0 = com.tencent.tinker.lib.utils.OSUtil.isAndroidJ_MR2Higher()
            if (r0 == 0) goto L47
            java.lang.String r0 = "Mute.ResRpl"
            java.lang.String r3 = "pruneResourceCaches lock = res.mAccessLock"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L3a
            com.tencent.tinker.lib.MuteLog.i(r0, r3, r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = "mAccessLock"
            java.lang.Object r0 = com.tencent.tinker.lib.utils.FieldUtils.readField(r6, r0)     // Catch: java.lang.Throwable -> L3a
            goto L64
        L3a:
            r0 = move-exception
            java.lang.String r3 = "Mute.ResRpl"
            java.lang.String r4 = "pruneResourceCaches lock = res.mAccessLock failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r0
            com.tencent.tinker.lib.MuteLog.e(r3, r4, r1)
            goto L63
        L47:
            java.lang.String r0 = "Mute.ResRpl"
            java.lang.String r3 = "pruneResourceCaches lock = res.mTmpValue"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L57
            com.tencent.tinker.lib.MuteLog.i(r0, r3, r4)     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = "mTmpValue"
            java.lang.Object r0 = com.tencent.tinker.lib.utils.FieldUtils.readField(r6, r0)     // Catch: java.lang.Throwable -> L57
            goto L64
        L57:
            r0 = move-exception
            java.lang.String r3 = "Mute.ResRpl"
            java.lang.String r4 = "pruneResourceCaches lock = res.mTmpValue failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r0
            com.tencent.tinker.lib.MuteLog.e(r3, r4, r1)
        L63:
            r0 = 0
        L64:
            if (r0 != 0) goto L68
            java.lang.Class<com.tencent.tinker.lib.MuteResReplacer> r0 = com.tencent.tinker.lib.MuteResReplacer.class
        L68:
            monitor-enter(r0)
            java.lang.String r1 = "mDrawableCache"
            pruneResourceCache(r6, r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "mColorDrawableCache"
            pruneResourceCache(r6, r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "mColorStateListCache"
            pruneResourceCache(r6, r1)     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = com.tencent.tinker.lib.utils.OSUtil.isAndroidMOrHigher()     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto L88
            java.lang.String r1 = "mAnimatorCache"
            pruneResourceCache(r6, r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "mStateListAnimatorCache"
            pruneResourceCache(r6, r1)     // Catch: java.lang.Throwable -> Lb4
        L88:
            java.lang.Class r1 = r6.getClass()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r2 = "com.huawei.android.content.res.ResourcesEx"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> Lb4
            if (r1 != 0) goto La8
            java.lang.Class r1 = r6.getClass()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r2 = "android.content.res.ResourcesEx"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto Lb2
        La8:
            java.lang.String r1 = "mCacheColorInfoList"
            pruneResourceCache(r6, r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "mDrawableCacheEx"
            pruneResourceCache(r6, r1)     // Catch: java.lang.Throwable -> Lb4
        Lb2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return
        Lb4:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.MuteResReplacer.pruneResourceCaches(java.lang.Object):void");
    }

    public static void checkResApi(Context context) throws Throwable {
        Class<?> cls;
        Class<?> cls2 = Class.forName("android.app.ActivityThread");
        MuteLog.i("Mute.ResRpl", "checkResApi ActivityThread.currentActivityThread()", new Object[0]);
        sCurActivityThread = ShareReflectUtil.getActivityThread(context, cls2);
        MuteLog.i("Mute.ResRpl", "checkResApi ActivityThread.mPackages", new Object[0]);
        f_mPackages = ShareReflectUtil.findField(cls2, "mPackages");
        if (OSUtil.isAndroidOLow()) {
            MuteLog.i("Mute.ResRpl", "checkResApi ActivityThread.mResourcePackages", new Object[0]);
            f_mResourcePackages = ShareReflectUtil.findField(cls2, "mResourcePackages");
        }
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException unused) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        MuteLog.i("Mute.ResRpl", "checkResApi LoadedApk.mResDir", new Object[0]);
        f_mResDir = ShareReflectUtil.findField(cls, "mResDir");
        MuteLog.w("Mute.ResRpl", "checkResApi new AssetManager() for mute global", new Object[0]);
        sMuteAssetMgr = (AssetManager) ShareReflectUtil.findConstructor(context.getAssets(), (Class<?>[]) new Class[0]).newInstance(new Object[0]);
        MuteLog.i("Mute.ResRpl", "checkResApi AssetManager.addAssetPath()", new Object[0]);
        m_addAssetPath = ShareReflectUtil.findMethod(sMuteAssetMgr, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (isSharedLib(context.getApplicationInfo())) {
            MuteLog.i("Mute.ResRpl", "checkResApi AssetManager.addAssetPathAsSharedLibrary()", new Object[0]);
            m_addAssetPathAsSharedLibrary = ShareReflectUtil.findMethod(sMuteAssetMgr, "addAssetPathAsSharedLibrary", (Class<?>[]) new Class[]{String.class});
        }
        try {
            MuteLog.i("Mute.ResRpl", "checkResApi AssetManager.mStringBlocks", new Object[0]);
            f_mStringBlocks = ShareReflectUtil.findField(sMuteAssetMgr, "mStringBlocks");
            MuteLog.i("Mute.ResRpl", "checkResApi AssetManager.ensureStringBlocks()", new Object[0]);
            m_ensureStringBlocks = ShareReflectUtil.findMethod(sMuteAssetMgr, "ensureStringBlocks", (Class<?>[]) new Class[0]);
        } catch (Throwable unused2) {
        }
        if (OSUtil.isAndroidKHigher()) {
            MuteLog.i("Mute.ResRpl", "checkResApi ResourcesManager.getInstance()", new Object[0]);
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ResourcesManager"), "getInstance", new Object[0]);
            try {
                MuteLog.i("Mute.ResRpl", "checkResApi ResourcesManager.mResourceReferences", new Object[0]);
                f_mResRef = (Collection) FieldUtils.readField(invokeStaticMethod, "mResourceReferences");
            } catch (IllegalAccessException unused3) {
                MuteLog.i("Mute.ResRpl", "checkResApi ResourcesManager.mActiveResources", new Object[0]);
                f_mResRef = ((ArrayMap) FieldUtils.readField(invokeStaticMethod, "mActiveResources")).values();
            }
        } else {
            MuteLog.i("Mute.ResRpl", "checkResApi ActivityThread.mActiveResources", new Object[0]);
            f_mResRef = ((HashMap) FieldUtils.readField(sCurActivityThread, "mActiveResources")).values();
        }
        if (f_mResRef != null) {
            Resources resources = context.getResources();
            if (OSUtil.isAndroidNHigher()) {
                try {
                    MuteLog.i("Mute.ResRpl", "checkResApi Resources.mResourcesImpl", new Object[0]);
                    f_mResourcesImpl = ShareReflectUtil.findField(resources, "mResourcesImpl");
                } catch (Throwable unused4) {
                    MuteLog.i("Mute.ResRpl", "checkResApi Resources.mAssets", new Object[0]);
                    f_mAssets = ShareReflectUtil.findField(resources, "mAssets");
                }
            } else {
                MuteLog.i("Mute.ResRpl", "checkResApi Resources.mAssets", new Object[0]);
                f_mAssets = ShareReflectUtil.findField(resources, "mAssets");
            }
            try {
                MuteLog.i("Mute.ResRpl", "checkResApi ApplicationInfo.publicSourceDir", new Object[0]);
                f_publicSourceDir = ShareReflectUtil.findField((Class<?>) ApplicationInfo.class, "publicSourceDir");
                return;
            } catch (NoSuchFieldException unused5) {
                return;
            }
        }
        throw new IllegalStateException("checkResApi f_mResRef is null");
    }

    private static void replaceActivityResInst(Activity activity, Resources resources) {
        Class<?> cls = activity.getClass();
        do {
            try {
                Field declaredField = cls.getDeclaredField("mResources");
                if (declaredField != null) {
                    MuteLog.i("Mute.ResRpl", "replaceActivityResInst activity[%s].mResources = newRes", cls);
                    FieldUtils.writeField(declaredField, activity, resources);
                }
            } catch (IllegalAccessException e) {
                MuteLog.e("Mute.ResRpl", "replaceActivityResInst activity.mResources = newRes failed %s", cls, e);
            } catch (NoSuchFieldException unused) {
            }
            cls = cls.getSuperclass();
        } while (cls != Object.class);
    }

    public static void replaceResourcesAssets(Resources resources, AssetManager assetManager) {
        if (resources.getAssets() != assetManager) {
            try {
                try {
                    MuteLog.i("Mute.ResRpl", "replaceResourcesAssets res.mResourcesImpl.mAssets = newAssetMgr", new Object[0]);
                    FieldUtils.writeField(FieldUtils.readField(resources, "mResourcesImpl"), "mAssets", assetManager);
                } catch (Exception unused) {
                    MuteLog.i("Mute.ResRpl", "replaceResourcesAssets res.mAssets = newAssetMgr", new Object[0]);
                    FieldUtils.writeField(resources, "mAssets", assetManager);
                }
            } catch (Exception e) {
                MuteLog.e("Mute.ResRpl", "replaceResourcesAssets res.mAssets = newAssetMgr failed", e);
            }
            if (OSUtil.isAndroidLHigher()) {
                clearResTypedArrayPool(resources);
            }
            pruneResourceCaches(resources);
            MuteLog.i("Mute.ResRpl", "replaceResourcesAssets res.updateConfiguration(x,x)", new Object[0]);
            resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
        }
    }

    public static void updateActivityTheme(Activity activity, int i) {
        int intValue;
        if (activity == null) {
            return;
        }
        MuteLog.i("Mute.ResRpl", "updateActivityTheme %s", activity);
        synchronized (activity) {
            try {
                int intValue2 = ((Integer) FieldUtils.readField(activity.getBaseContext(), "mThemeResource")).intValue();
                MuteLog.i("Mute.ResRpl", "updateActivityTheme activity.mBase.mTheme = null", new Object[0]);
                FieldUtils.writeField(activity.getBaseContext(), "mTheme", (Object) null);
                MuteLog.i("Mute.ResRpl", "updateActivityTheme activity.mBase.mThemeResource = 0", new Object[0]);
                FieldUtils.writeField((Object) activity.getBaseContext(), "mThemeResource", (Object) 0);
                MuteLog.i("Mute.ResRpl", "updateActivityTheme activity.mBase.setTheme(0x%s)", Integer.toHexString(intValue2));
                activity.getBaseContext().setTheme(intValue2);
                Object readField = FieldUtils.readField(activity, "mThemeId");
                if (readField != null) {
                    intValue = ((Integer) readField).intValue();
                } else {
                    intValue = ((Integer) FieldUtils.readField(activity, "mThemeResource")).intValue();
                }
                if (i == 0 || intValue == i) {
                    i = intValue;
                }
                if (OSUtil.isAndroidQHigher()) {
                    Field fieldAll = DoubleReflector.getFieldAll(activity.getClass(), "mTheme");
                    if (fieldAll != null) {
                        MuteLog.i("Mute.ResRpl", "updateActivityTheme activity.mTheme = null", new Object[0]);
                        FieldUtils.writeField(fieldAll, activity, (Object) null);
                    } else {
                        MuteLog.w("Mute.ResRpl", "updateActivityTheme activity.mTheme = null failed", new Object[0]);
                    }
                } else {
                    MuteLog.i("Mute.ResRpl", "updateActivityTheme activity.mTheme = null", new Object[0]);
                    FieldUtils.writeField(activity, "mTheme", (Object) null);
                }
                MuteLog.i("Mute.ResRpl", "updateActivityTheme activity.mThemeResource = 0", new Object[0]);
                FieldUtils.writeField((Object) activity, "mThemeResource", (Object) 0);
                MuteLog.i("Mute.ResRpl", "updateActivityTheme activity.setTheme(0x%s)", Integer.toHexString(i));
                activity.setTheme(i);
            } catch (Exception e) {
                MuteLog.e("Mute.ResRpl", "updateActivityTheme failed", e);
            }
        }
    }

    private static boolean pruneResourceCache(Object obj, String str) {
        try {
            Field field = FieldUtils.getField(obj.getClass(), str);
            if (field == null) {
                field = FieldUtils.getField(Resources.class, str);
            }
            Object obj2 = field.get(obj);
            Class<?> type = field.getType();
            if (OSUtil.isAndroidJLower()) {
                if (obj2 instanceof SparseArray) {
                    MuteLog.i("Mute.ResRpl", "pruneResourceCache res.%s[SparseArray].clear", str);
                    ((SparseArray) obj2).clear();
                    return true;
                }
                if (OSUtil.isAndroidIHigher() && (obj2 instanceof LongSparseArray)) {
                    MuteLog.i("Mute.ResRpl", "pruneResourceCache res.%s[LongSparseArray].clear", str);
                    ((LongSparseArray) obj2).clear();
                    return true;
                }
            } else if (OSUtil.isAndroidMLower()) {
                if ("mColorStateListCache".equals(str)) {
                    if (obj2 instanceof LongSparseArray) {
                        MuteLog.i("Mute.ResRpl", "pruneResourceCache res.%s[LongSparseArray].clear", str);
                        ((LongSparseArray) obj2).clear();
                        return true;
                    }
                } else {
                    if (type.isAssignableFrom(ArrayMap.class)) {
                        MuteLog.i("Mute.ResRpl", "pruneResourceCache res.clearDrawableCachesLocked(ArrayMap, int)", new Object[0]);
                        com_tencent_tinker_lib_MuteResReplacer_java_lang_reflect_Method_invoke(MethodUtils.getAccessibleMethod(Resources.class, "clearDrawableCachesLocked", ArrayMap.class, Integer.TYPE), obj, new Object[]{obj2, -1});
                        return true;
                    }
                    if (type.isAssignableFrom(LongSparseArray.class)) {
                        MuteLog.i("Mute.ResRpl", "pruneResourceCache res.clearDrawableCacheLocked(LongSparseArray, int)", new Object[0]);
                        com_tencent_tinker_lib_MuteResReplacer_java_lang_reflect_Method_invoke(MethodUtils.getAccessibleMethod(Resources.class, "clearDrawableCacheLocked", LongSparseArray.class, Integer.TYPE), obj, new Object[]{obj2, -1});
                        return true;
                    }
                    if (obj2 instanceof Map) {
                        MuteLog.i("Mute.ResRpl", "pruneResourceCache res.%s[Map].clear", str);
                        ((Map) obj2).clear();
                        return true;
                    }
                }
            } else {
                while (type != null) {
                    try {
                        MuteLog.i("Mute.ResRpl", "pruneResourceCache res.%s[%s].onConfigurationChange(int)", str, type);
                        com_tencent_tinker_lib_MuteResReplacer_java_lang_reflect_Method_invoke(MethodUtils.getAccessibleMethod(type, "onConfigurationChange", Integer.TYPE), obj2, new Object[]{-1});
                        return true;
                    } catch (Throwable th) {
                        MuteLog.e("Mute.ResRpl", "pruneResourceCache res.%s[%s].onConfigurationChange(int)", str, type, th);
                        type = type.getSuperclass();
                    }
                }
            }
        } catch (Throwable th2) {
            MuteLog.e("Mute.ResRpl", "pruneResourceCache failed", th2);
        }
        return false;
    }

    public static synchronized void replaceActivityRes(Activity activity, boolean z) {
        synchronized (MuteResReplacer.class) {
            if (sMuteAssetMgr == null) {
                return;
            }
            MuteLog.i("Mute.ResRpl", "replaceActivityRes activity[%s] created[%b] sMuteAssetMgr[%s]", activity, Boolean.valueOf(z), sMuteAssetMgr);
            if (!z) {
                Resources resources = Muter.getAppContext().getResources();
                Resources resources2 = activity.getResources();
                if (resources != null && resources != resources2) {
                    try {
                        CompatibilityInfo compatibilityInfo = (CompatibilityInfo) MethodUtils.invokeMethod(resources, "getCompatibilityInfo", new Object[0]);
                        CompatibilityInfo compatibilityInfo2 = (CompatibilityInfo) MethodUtils.invokeMethod(resources2, "getCompatibilityInfo", new Object[0]);
                        Configuration configuration = resources2.getConfiguration();
                        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                        if (compatibilityInfo2 != null && compatibilityInfo2 != compatibilityInfo) {
                            MuteLog.i("Mute.ResRpl", "replaceActivityRes appRes.updateConfiguration(x,x,x)", new Object[0]);
                            MethodUtils.invokeMethod(resources, "updateConfiguration", configuration, displayMetrics, compatibilityInfo2);
                        } else {
                            MuteLog.i("Mute.ResRpl", "replaceActivityRes appRes.updateConfiguration(x,x)", new Object[0]);
                            resources.updateConfiguration(configuration, displayMetrics);
                            flushRes(resources);
                        }
                    } catch (Exception e) {
                        MuteLog.e("Mute.ResRpl", "replaceActivityRes updateConfiguration failed", e);
                    }
                    try {
                        MuteLog.i("Mute.ResRpl", "replaceActivityRes activity.mBase.mResources = appRes", new Object[0]);
                        FieldUtils.writeField(activity.getBaseContext(), "mResources", resources);
                    } catch (Exception e2) {
                        MuteLog.e("Mute.ResRpl", "replaceActivityRes activity.mBase.mResources failed", e2);
                    }
                    MuteLog.i("Mute.ResRpl", "replaceActivityRes activity.mResources = null", new Object[0]);
                    replaceActivityResInst(activity, null);
                    updateActivityTheme(activity, 0);
                    if (OSUtil.isAndroidOHigher() && resources.getClass().getName().equals("android.content.res.HwResources") && !resources2.getDisplayMetrics().equals(resources.getDisplayMetrics())) {
                        try {
                            MuteLog.i("Mute.ResRpl", "replaceActivityRes activity.mBase.mDisplay = null", new Object[0]);
                            FieldUtils.writeField(activity.getBaseContext(), "mDisplay", (Object) null);
                        } catch (Exception e3) {
                            MuteLog.e("Mute.ResRpl", "replaceActivityRes activity.mBase.mDisplay failed", e3);
                        }
                    }
                } else {
                    MuteLog.w("Mute.ResRpl", "replaceActivityRes no need replace, appRes == actRes", new Object[0]);
                }
                return;
            }
            Resources resources3 = activity.getResources();
            if (resources3.getAssets() != sMuteAssetMgr) {
                if (resources3.getClass().getName().equals("android.support.v7.widget.TintResources")) {
                    try {
                        MuteLog.i("Mute.ResRpl", "replaceActivityRes actRes = TintResources.mResources", new Object[0]);
                        resources3 = (Resources) FieldUtils.readField(resources3, "mResources");
                    } catch (Exception e4) {
                        MuteLog.e("Mute.ResRpl", "replaceActivityRes actRes = TintResources.mResources failed", e4);
                    }
                }
                if (activity.getBaseContext().getResources() != resources3) {
                    replaceResourcesAssets(activity.getBaseContext().getResources(), sMuteAssetMgr);
                }
                replaceResourcesAssets(resources3, sMuteAssetMgr);
                if (activity.getResources() != resources3) {
                    replaceResourcesAssets(activity.getResources(), sMuteAssetMgr);
                }
            } else {
                MuteLog.w("Mute.ResRpl", "replaceActivityRes no need replace, actRes.mAssets == sMuteAssetMgr ", new Object[0]);
            }
            updateActivityTheme(activity, 0);
            return;
        }
    }

    public static void replaceAppRes(Context context, String str) throws Throwable {
        Field[] fieldArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        sOriginAssetMgr = context.getAssets();
        if (sOriginApkAssets == null) {
            sOriginApkAssets = ResUtils.getApkPaths(context.getResources().getAssets());
        }
        MuteLog.i("Mute.ResRpl", "replaceAppRes baseCtx[%s] patchApk[%s] originApkAssets %s", context, str, ResUtils.formatAssetsStr(sOriginApkAssets));
        if (OSUtil.isAndroidOLow()) {
            fieldArr = new Field[]{f_mPackages, f_mResourcePackages};
        } else {
            fieldArr = new Field[]{f_mPackages};
        }
        for (Field field : fieldArr) {
            Iterator it2 = ((Map) field.get(sCurActivityThread)).entrySet().iterator();
            while (it2.hasNext()) {
                Object obj = ((WeakReference) ((Map.Entry) it2.next()).getValue()).get();
                if (obj != null && applicationInfo.sourceDir.equals((String) f_mResDir.get(obj))) {
                    MuteLog.i("Mute.ResRpl", "replaceAppRes ActivityThread.mPackages.x.LoadedApk.mResDir = patchApk", new Object[0]);
                    f_mResDir.set(obj, str);
                }
            }
        }
        if (OSUtil.isAndroidNHigher()) {
            try {
                for (Map.Entry entry : ((ArrayMap) FieldUtils.readField(FieldUtils.readField(context, "mResourcesManager"), "mResourceImpls")).entrySet()) {
                    Object obj2 = ((WeakReference) entry.getValue()).get();
                    if (obj2 != null) {
                        if (((AssetManager) FieldUtils.readField(obj2, "mAssets")) == context.getResources().getAssets()) {
                            if (applicationInfo.sourceDir.equals((String) FieldUtils.readField(entry.getKey(), "mResDir"))) {
                                MuteLog.i("Mute.ResRpl", "replaceAppRes app.mBase.mResourcesManager.mResourceImpls.x.ResourcesKey.mResDir = patchApk", new Object[0]);
                                FieldUtils.writeField(entry.getKey(), "mResDir", str);
                            }
                        } else {
                            MuteLog.w("Mute.ResRpl", "replaceAppRes app.mBase.mResourcesManager.mResourceImpls.x.ResourcesImpl.mAssets != app.mResources.mAssets", new Object[0]);
                        }
                    }
                }
            } catch (Throwable th) {
                MuteLog.e("Mute.ResRpl", "replaceAppRes app.mBase.mResourcesManager.mResourceImpls.x.ResourcesKey.mResDir failed", th);
            }
        }
        if (((Integer) com_tencent_tinker_lib_MuteResReplacer_java_lang_reflect_Method_invoke(m_addAssetPath, sMuteAssetMgr, new Object[]{str})).intValue() != 0) {
            MuteLog.i("Mute.ResRpl", "replaceAppRes sMuteAssetMgr.addAssetPath(x)", new Object[0]);
            if (isSharedLib(applicationInfo)) {
                for (String str2 : applicationInfo.sharedLibraryFiles) {
                    if (str2.endsWith(".apk")) {
                        if (((Integer) com_tencent_tinker_lib_MuteResReplacer_java_lang_reflect_Method_invoke(m_addAssetPathAsSharedLibrary, sMuteAssetMgr, new Object[]{str2})).intValue() != 0) {
                            MuteLog.i("Mute.ResRpl", "replaceAppRes sMuteAssetMgr.addAssetPathAsSharedLibrary(x)", new Object[0]);
                        } else {
                            throw new IllegalStateException("invoke sMuteAssetMgr.addAssetPathAsSharedLibrary(x) failed");
                        }
                    }
                }
            }
            if (f_mStringBlocks != null && m_ensureStringBlocks != null) {
                MuteLog.i("Mute.ResRpl", "replaceAppRes sMuteAssetMgr.mStringBlocks = null", new Object[0]);
                f_mStringBlocks.set(sMuteAssetMgr, null);
                MuteLog.i("Mute.ResRpl", "replaceAppRes sMuteAssetMgr.ensureStringBlocks()", new Object[0]);
                com_tencent_tinker_lib_MuteResReplacer_java_lang_reflect_Method_invoke(m_ensureStringBlocks, sMuteAssetMgr, new Object[0]);
            }
            Iterator<WeakReference<Resources>> it4 = f_mResRef.iterator();
            while (it4.hasNext()) {
                Resources resources = it4.next().get();
                if (resources != null) {
                    try {
                        try {
                            MuteLog.i("Mute.ResRpl", "replaceAppRes ResMgr.mResourceReferences.x.refRes.mResourcesImpl.mAssets = sMuteAssetMgr", new Object[0]);
                            FieldUtils.writeField(f_mResourcesImpl.get(resources), "mAssets", sMuteAssetMgr);
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        MuteLog.i("Mute.ResRpl", "replaceAppRes ResMgr.mResourceReferences.x.refRes.mAssets = sMuteAssetMgr", new Object[0]);
                        f_mAssets.set(resources, sMuteAssetMgr);
                    }
                    clearResTypedArrayPool(resources);
                    MuteLog.i("Mute.ResRpl", "replaceAppRes ResMgr.x.refRes.updateConfiguration(x, x)", new Object[0]);
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
            if (OSUtil.isAndroidNHigher()) {
                try {
                    if (f_publicSourceDir != null) {
                        MuteLog.i("Mute.ResRpl", "replaceAppRes appInfo.publicSourceDir = patchApk", new Object[0]);
                        f_publicSourceDir.set(applicationInfo, str);
                        return;
                    }
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException("invoke sMuteAssetMgr.addAssetPath(x) failed");
    }
}
