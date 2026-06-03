package com.tencent.tinker.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.loader.utils.FieldUtils;
import com.tencent.tinker.loader.utils.MethodUtils;
import com.tencent.tinker.loader.utils.ShareTinkerLog;
import com.tencent.tinker.loader.utils.Utils;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteClassLoader {
    static {
        Covode.recordClassIndex(653948);
    }

    private static Object[] getDexElementsExceptMain(ClassLoader classLoader) throws Throwable {
        boolean equals;
        Object[] objArr = (Object[]) FieldUtils.readField(FieldUtils.readField(classLoader, "pathList"), "dexElements");
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(MuteApplication.getInstance().getApplicationInfo().sourceDir);
        ArrayList arrayList = new ArrayList();
        if (objArr != null) {
            for (Object obj : objArr) {
                String name = ((DexFile) FieldUtils.readField(obj, "dexFile")).getName();
                PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(name);
                if (Build.VERSION.SDK_INT >= 26) {
                    if (polarisFileWrapper2.exists() && Files.isSameFile(polarisFileWrapper2.toPath(), polarisFileWrapper.toPath())) {
                        equals = true;
                    } else {
                        equals = false;
                    }
                } else {
                    equals = MuteApplication.getInstance().getApplicationInfo().sourceDir.equals(name);
                }
                if (!equals) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList.toArray();
    }

    private static String getNativeLibsDirs(ClassLoader classLoader) throws Throwable {
        List<File> list;
        Object readField = FieldUtils.readField(classLoader, "pathList");
        Field field = FieldUtils.getField(readField.getClass(), "nativeLibraryDirectories");
        if (field.getType().isArray()) {
            list = Arrays.asList((File[]) field.get(readField));
        } else {
            list = (List) field.get(readField);
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (File file : list) {
            if (file != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(File.pathSeparator);
                }
                sb.append(file.getAbsolutePath());
            }
        }
        return sb.toString();
    }

    public static void replaceAllCL(Context context, ClassLoader classLoader) throws Throwable {
        ShareTinkerLog.w("Mute.CL", "replaceAllCL spCL %s", classLoader);
        Thread.currentThread().setContextClassLoader(classLoader);
        ShareTinkerLog.i("Mute.CL", "replace Thread.Ctx.CL", new Object[0]);
        FieldUtils.writeField(FieldUtils.readField(context, "mPackageInfo"), "mClassLoader", classLoader);
        ShareTinkerLog.i("Mute.CL", "replace app.mBase.mPackageInfo.mClassLoader", new Object[0]);
        if (Build.VERSION.SDK_INT < 27) {
            Resources resources = context.getResources();
            try {
                FieldUtils.writeField(resources, "mClassLoader", classLoader);
                ShareTinkerLog.i("Mute.CL", "replace res.mClassLoader", new Object[0]);
                Object readField = FieldUtils.readField(resources, "mDrawableInflater");
                if (readField != null) {
                    FieldUtils.writeField(readField, "mClassLoader", classLoader);
                    ShareTinkerLog.i("Mute.CL", "replace res.mDrawableInflater.mClassLoader", new Object[0]);
                }
            } catch (Throwable th) {
                ShareTinkerLog.e("Mute.CL", "replaceAllCL failed, %s", th);
            }
        }
    }

    private static void insertDexElements(Object obj, Object[] objArr, ArrayList<IOException> arrayList) throws Throwable {
        Object[] objArr2 = (Object[]) FieldUtils.readField(obj, "dexElements");
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        FieldUtils.writeField(obj, "dexElements", objArr3);
        ShareTinkerLog.i("Mute.CL", "insertDexElements %s len[%d]", objArr3, Integer.valueOf(objArr3.length));
        if (!arrayList.isEmpty()) {
            Iterator<IOException> it2 = arrayList.iterator();
            if (it2.hasNext()) {
                IOException next = it2.next();
                ShareTinkerLog.e("Mute.CL", "insertDexElements has supExp, %s", next);
                throw next;
            }
        }
    }

    public static ClassLoader createClassLoader(ClassLoader classLoader, File file, File file2) throws Throwable {
        String str;
        Object[] makeDexElements;
        ShareTinkerLog.i("Mute.CL", "createClassLoader apkPath[%s] optDir[%s]", file, file2);
        ShareTinkerLog.i("Mute.CL", "origin %s", classLoader);
        Utils.setFileOnlyReadable(file);
        int i = Build.VERSION.SDK_INT;
        if (i >= 27) {
            str = file.getAbsolutePath();
        } else {
            str = "";
        }
        PathClassLoader pathClassLoader = new PathClassLoader(str, getNativeLibsDirs(classLoader), Object.class.getClassLoader());
        ShareTinkerLog.i("Mute.CL", "new %s", pathClassLoader);
        if (i <= 26) {
            ArrayList arrayList = new ArrayList();
            Object readField = FieldUtils.readField(pathClassLoader, "pathList");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(file);
            if (i >= 23) {
                makeDexElements = makePathElements(readField, arrayList2, file2, arrayList);
            } else {
                makeDexElements = makeDexElements(readField, arrayList2, file2, arrayList);
            }
            insertDexElements(readField, makeDexElements, arrayList);
        }
        try {
            insertDexElements(FieldUtils.readField(pathClassLoader, "pathList"), getDexElementsExceptMain(classLoader), new ArrayList());
        } catch (Throwable th) {
            ShareTinkerLog.e("Mute.CL", "insertDexElements failed, %s", th);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            FieldUtils.writeField(pathClassLoader, "sharedLibraryLoaders", (ClassLoader[]) FieldUtils.readField(classLoader, "sharedLibraryLoaders"));
            ShareTinkerLog.i("Mute.CL", "newCL.sharedLibraryLoaders = originCL.sharedLibraryLoaders", new Object[0]);
        }
        return pathClassLoader;
    }

    private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws Throwable {
        Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), "makeDexElements", ArrayList.class, File.class, ArrayList.class);
        if (accessibleMethod == null) {
            ShareTinkerLog.w("Mute.CL", "No makeDexElements(ArrayList,File,ArrayList) method", new Object[0]);
            accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), "makeDexElements", List.class, File.class, List.class);
            if (accessibleMethod == null) {
                ShareTinkerLog.w("Mute.CL", "No makeDexElements(List,File,List) method", new Object[0]);
                throw new NoSuchMethodException("No makeDexElements(List,File,List) method");
            }
        }
        Object[] objArr = (Object[]) accessibleMethod.invoke(obj, arrayList, file, arrayList2);
        ShareTinkerLog.i("Mute.CL", "makeDexElements %s", objArr);
        return objArr;
    }

    private static Object[] makePathElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws Throwable {
        Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), "makePathElements", List.class, File.class, List.class);
        if (accessibleMethod == null) {
            ShareTinkerLog.w("Mute.CL", "No makePathElements(List,File,List) method", new Object[0]);
            accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), "makePathElements", ArrayList.class, File.class, ArrayList.class);
            if (accessibleMethod == null) {
                ShareTinkerLog.w("Mute.CL", "NO makePathElements(ArrayList,File,ArrayList) method", new Object[0]);
                try {
                    return makeDexElements(obj, arrayList, file, arrayList2);
                } catch (NoSuchMethodException e) {
                    ShareTinkerLog.w("Mute.CL", "makePathElements failed with v19", new Object[0]);
                    throw e;
                }
            }
        }
        Object[] objArr = (Object[]) accessibleMethod.invoke(obj, arrayList, file, arrayList2);
        ShareTinkerLog.i("Mute.CL", "makePathElements %s", objArr);
        return objArr;
    }
}
