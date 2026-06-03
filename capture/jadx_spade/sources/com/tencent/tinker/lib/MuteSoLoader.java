package com.tencent.tinker.lib;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.utils.OSUtil;
import com.tencent.tinker.lib.utils.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteSoLoader {
    static {
        Covode.recordClassIndex(653712);
    }

    private static Object com_tencent_tinker_lib_MuteSoLoader_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) throws Throwable {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public static void installNativeLibDir(ClassLoader classLoader, File file) throws Throwable {
        if (file != null && file.exists()) {
            if (OSUtil.isAndroidMOrHigher()) {
                try {
                    installV23(classLoader, file);
                    return;
                } catch (Throwable th) {
                    MuteLog.e("Mute.SO", "installV23 failed sdk[%d], err[%s], fallback V14", Integer.valueOf(Build.VERSION.SDK_INT), th);
                    installV14(classLoader, file);
                    return;
                }
            }
            installV14(classLoader, file);
            return;
        }
        MuteLog.e("Mute.SO", "installNativeLibDir libDir[%s] is illegal", file);
    }

    private static void installV14(ClassLoader classLoader, File file) throws Throwable {
        Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
        Field findField = ShareReflectUtil.findField(obj, "nativeLibraryDirectories");
        File[] fileArr = (File[]) findField.get(obj);
        ArrayList arrayList = new ArrayList(fileArr.length + 1);
        arrayList.add(file);
        for (File file2 : fileArr) {
            if (!file.equals(file2)) {
                arrayList.add(file2);
            }
        }
        MuteLog.i("Mute.SO", "installV14 nativeLibDirs[%d] + libDir[%s] = mergeLibDirs %s", Integer.valueOf(fileArr.length), file, arrayList);
        File[] fileArr2 = (File[]) arrayList.toArray(new File[0]);
        findField.set(obj, fileArr2);
        MuteLog.i("Mute.SO", "installV14 pathList.nativeLibraryDirectories = %d", Integer.valueOf(fileArr2.length));
    }

    private static void installV23(ClassLoader classLoader, File file) throws Throwable {
        Object[] objArr;
        Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
        List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
        if (list == null) {
            list = new ArrayList(2);
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (file.equals((File) it2.next())) {
                it2.remove();
                break;
            }
        }
        list.add(0, file);
        List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
        if (list2 == null) {
            list2 = new ArrayList(2);
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
        arrayList.addAll(list);
        arrayList.addAll(list2);
        MuteLog.i("Mute.SO", "installV23 nativeLibDirs[%d] + sysNativeLibDirs[%d] = mergeLibDirs %s", Integer.valueOf(list.size()), Integer.valueOf(list2.size()), arrayList);
        if (OSUtil.isAndroidOHigher()) {
            objArr = (Object[]) com_tencent_tinker_lib_MuteSoLoader_java_lang_reflect_Method_invoke(ShareReflectUtil.findMethod(obj, "makePathElements", (Class<?>[]) new Class[]{List.class}), obj, new Object[]{arrayList});
            MuteLog.i("Mute.SO", "installV23 makePathElements(mergeLibDirs)", new Object[0]);
        } else if (OSUtil.isAndroidMOrHigher()) {
            Method findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            ArrayList arrayList2 = new ArrayList();
            objArr = (Object[]) com_tencent_tinker_lib_MuteSoLoader_java_lang_reflect_Method_invoke(findMethod, obj, new Object[]{arrayList, null, arrayList2});
            MuteLog.i("Mute.SO", "installV23 makePathElements(%s, null, %s)", arrayList, arrayList2);
        } else {
            objArr = null;
        }
        ShareReflectUtil.findField(obj, "nativeLibraryPathElements").set(obj, objArr);
        MuteLog.i("Mute.SO", "installV23 pathList.nativeLibraryPathElements = %s", objArr);
    }
}
