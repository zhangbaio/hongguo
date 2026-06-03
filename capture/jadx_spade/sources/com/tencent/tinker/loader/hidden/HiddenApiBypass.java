package com.tencent.tinker.loader.hidden;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.loader.hidden.Helper;
import com.tencent.tinker.loader.utils.ShareTinkerLog;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import sun.misc.Unsafe;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HiddenApiBypass {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long artFieldBias;
    private static final long artFieldSize;
    private static final long artMethodBias;
    private static final long artMethodSize;
    private static final long artOffset;
    private static final long classOffset;
    private static final long iFieldOffset;
    private static final long methodOffset;
    private static final long methodsOffset;
    private static final long sFieldOffset;
    private static final Unsafe unsafe;

    public static boolean clearHiddenApiExemptions() {
        Helper.signaturePrefixes.clear();
        return setHiddenApiExemptions(new String[0]);
    }

    static {
        long objectFieldOffset;
        long objectFieldOffset2;
        Covode.recordClassIndex(653958);
        try {
            Unsafe unsafe2 = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
            unsafe = unsafe2;
            CoreOjClassLoader coreOjClassLoader = new CoreOjClassLoader();
            Class<?> loadClass = coreOjClassLoader.loadClass(Executable.class.getName());
            Class<?> loadClass2 = coreOjClassLoader.loadClass(MethodHandle.class.getName());
            Class<?> loadClass3 = coreOjClassLoader.loadClass(Class.class.getName());
            methodOffset = unsafe2.objectFieldOffset(loadClass.getDeclaredField("artMethod"));
            classOffset = unsafe2.objectFieldOffset(loadClass.getDeclaredField("declaringClass"));
            artOffset = unsafe2.objectFieldOffset(loadClass2.getDeclaredField("artFieldOrMethod"));
            try {
                objectFieldOffset = unsafe2.objectFieldOffset(loadClass3.getDeclaredField("fields"));
                objectFieldOffset2 = objectFieldOffset;
            } catch (NoSuchFieldException unused) {
                Unsafe unsafe3 = unsafe;
                objectFieldOffset = unsafe3.objectFieldOffset(loadClass3.getDeclaredField("iFields"));
                objectFieldOffset2 = unsafe3.objectFieldOffset(loadClass3.getDeclaredField("sFields"));
            }
            iFieldOffset = objectFieldOffset;
            sFieldOffset = objectFieldOffset2;
            Unsafe unsafe4 = unsafe;
            long objectFieldOffset3 = unsafe4.objectFieldOffset(loadClass3.getDeclaredField("methods"));
            methodsOffset = objectFieldOffset3;
            Method declaredMethod = Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]);
            Method declaredMethod2 = Helper.NeverCall.class.getDeclaredMethod("b", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            MethodHandle unreflect = MethodHandles.lookup().unreflect(declaredMethod);
            MethodHandle unreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
            long j = artOffset;
            long j2 = unsafe4.getLong(unreflect, j);
            long j3 = unsafe4.getLong(unreflect2, j);
            long j4 = unsafe4.getLong(Helper.NeverCall.class, objectFieldOffset3);
            long j5 = j3 - j2;
            artMethodSize = j5;
            ShareTinkerLog.v("Mute.Hidden", j5 + " " + Long.toString(j2, 16) + ", " + Long.toString(j3, 16) + ", " + Long.toString(j4, 16), new Object[0]);
            artMethodBias = (j2 - j4) - j5;
            Field declaredField = Helper.NeverCall.class.getDeclaredField("i");
            Field declaredField2 = Helper.NeverCall.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            MethodHandle unreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
            MethodHandle unreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
            long j6 = unsafe4.getLong(unreflectGetter, j);
            long j7 = unsafe4.getLong(unreflectGetter2, j);
            long j8 = unsafe4.getLong(Helper.NeverCall.class, objectFieldOffset);
            long j9 = j7 - j6;
            artFieldSize = j9;
            ShareTinkerLog.v("Mute.Hidden", j9 + " " + Long.toString(j6, 16) + ", " + Long.toString(j7, 16) + ", " + Long.toString(j8, 16), new Object[0]);
            artFieldBias = j6 - j8;
        } catch (ReflectiveOperationException e) {
            ShareTinkerLog.e("Mute.Hidden", "Initialize error, %s", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static boolean addHiddenApiExemptions(String... strArr) {
        Set<String> set = Helper.signaturePrefixes;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[set.size()];
        set.toArray(strArr2);
        return setHiddenApiExemptions(strArr2);
    }

    public static boolean setHiddenApiExemptions(String... strArr) {
        try {
            invoke(VMRuntime.class, invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (ReflectiveOperationException e) {
            ShareTinkerLog.w("Mute.Hidden", "setHiddenApiExemptions", e);
            return false;
        }
    }

    public static List<Executable> getDeclaredMethods(Class<?> cls) {
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Method declaredMethod = Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]);
                declaredMethod.setAccessible(true);
                MethodHandle unreflect = MethodHandles.lookup().unreflect(declaredMethod);
                Unsafe unsafe2 = unsafe;
                long j = unsafe2.getLong(cls, methodsOffset);
                if (j == 0) {
                    return Collections.emptyList();
                }
                int i = unsafe2.getInt(j);
                ShareTinkerLog.d("Mute.Hidden", cls + " has " + i + " methods", new Object[0]);
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    unsafe.putLong(unreflect, artOffset, (i2 * artMethodSize) + j + artMethodBias);
                    Executable executable = (Executable) MethodHandles.reflectAs(Executable.class, unreflect);
                    ShareTinkerLog.v("Mute.Hidden", "got " + cls.getTypeName() + "." + executable.getName() + "(" + ((String) Arrays.stream(executable.getParameterTypes()).map(new a()).collect(Collectors.joining())) + ")", new Object[0]);
                    arrayList.add(executable);
                }
                return arrayList;
            } catch (IllegalAccessException | NoSuchMethodException unused) {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }

    public static List<Field> getInstanceFields(Class<?> cls) {
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = Helper.NeverCall.class.getDeclaredField("i");
                declaredField.setAccessible(true);
                MethodHandle unreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                Unsafe unsafe2 = unsafe;
                long j = unsafe2.getLong(cls, iFieldOffset);
                if (j == 0) {
                    return Collections.emptyList();
                }
                int i = unsafe2.getInt(j);
                ShareTinkerLog.d("Mute.Hidden", cls + " has " + i + " fields", new Object[0]);
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    unsafe.putLong(unreflectGetter, artOffset, (i2 * artFieldSize) + j + artFieldBias);
                    Field field = (Field) MethodHandles.reflectAs(Field.class, unreflectGetter);
                    ShareTinkerLog.v("Mute.Hidden", "got " + field.getType() + " " + cls.getTypeName() + "." + field.getName(), new Object[0]);
                    if (!Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(field);
                    }
                }
                return arrayList;
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }

    public static List<Field> getStaticFields(Class<?> cls) {
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = Helper.NeverCall.class.getDeclaredField("s");
                declaredField.setAccessible(true);
                MethodHandle unreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                Unsafe unsafe2 = unsafe;
                long j = unsafe2.getLong(cls, sFieldOffset);
                if (j == 0) {
                    return Collections.emptyList();
                }
                int i = unsafe2.getInt(j);
                ShareTinkerLog.d("Mute.Hidden", cls + " has " + i + " fields", new Object[0]);
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    unsafe.putLong(unreflectGetter, artOffset, (i2 * artFieldSize) + j + artFieldBias);
                    Field field = (Field) MethodHandles.reflectAs(Field.class, unreflectGetter);
                    ShareTinkerLog.v("Mute.Hidden", "got " + field.getType() + " " + cls.getTypeName() + "." + field.getName(), new Object[0]);
                    if (Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(field);
                    }
                }
                return arrayList;
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }

    public static Constructor<?> getDeclaredConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        for (Executable executable : getDeclaredMethods(cls)) {
            if (executable instanceof Constructor) {
                Class<?>[] parameterTypes = executable.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i = 0; i < clsArr.length; i++) {
                        if (clsArr[i] != parameterTypes[i]) {
                            break;
                        }
                    }
                    return (Constructor) executable;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Object newInstance(Class<?> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String str;
        Method declaredMethod = Helper.InvokeStub.class.getDeclaredMethod("invoke", Object[].class);
        Constructor declaredConstructor = Helper.InvokeStub.class.getDeclaredConstructor(Object[].class);
        declaredConstructor.setAccessible(true);
        Unsafe unsafe2 = unsafe;
        long j = unsafe2.getLong(cls, methodsOffset);
        if (j != 0) {
            int i = unsafe2.getInt(j);
            String str2 = "Mute.Hidden";
            ShareTinkerLog.d("Mute.Hidden", cls + " has " + i + " methods", new Object[0]);
            int i2 = 0;
            while (i2 < i) {
                long j2 = (i2 * artMethodSize) + j + artMethodBias;
                Unsafe unsafe3 = unsafe;
                long j3 = methodOffset;
                int i3 = i2;
                unsafe3.putLong(declaredMethod, j3, j2);
                ShareTinkerLog.v(str2, "got " + cls.getTypeName() + "." + declaredMethod.getName() + "(" + ((String) Arrays.stream(declaredMethod.getParameterTypes()).map(new a()).collect(Collectors.joining())) + ")", new Object[0]);
                if ("<init>".equals(declaredMethod.getName())) {
                    str = str2;
                    unsafe3.putLong(declaredConstructor, j3, j2);
                    unsafe3.putObject(declaredConstructor, classOffset, cls);
                    if (Helper.checkArgsForInvokeMethod(declaredConstructor.getParameterTypes(), objArr)) {
                        return declaredConstructor.newInstance(objArr);
                    }
                } else {
                    str = str2;
                }
                i2 = i3 + 1;
                str2 = str;
            }
            throw new NoSuchMethodException("Cannot find matching constructor");
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Executable executable : getDeclaredMethods(cls)) {
            if (executable.getName().equals(str) && (executable instanceof Method)) {
                Class<?>[] parameterTypes = executable.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i = 0; i < clsArr.length; i++) {
                        if (clsArr[i] != parameterTypes[i]) {
                            break;
                        }
                    }
                    return (Method) executable;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = Helper.InvokeStub.class.getDeclaredMethod("invoke", Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe2 = unsafe;
        long j = unsafe2.getLong(cls, methodsOffset);
        if (j != 0) {
            int i = unsafe2.getInt(j);
            ShareTinkerLog.d("Mute.Hidden", cls + " has " + i + " methods", new Object[0]);
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2;
                unsafe.putLong(declaredMethod, methodOffset, (i2 * artMethodSize) + j + artMethodBias);
                ShareTinkerLog.v("Mute.Hidden", "got " + cls.getTypeName() + "." + declaredMethod.getName() + "(" + ((String) Arrays.stream(declaredMethod.getParameterTypes()).map(new a()).collect(Collectors.joining())) + ")", new Object[0]);
                if (str.equals(declaredMethod.getName()) && Helper.checkArgsForInvokeMethod(declaredMethod.getParameterTypes(), objArr)) {
                    return declaredMethod.invoke(obj, objArr);
                }
                i2 = i3 + 1;
            }
            throw new NoSuchMethodException("Cannot find matching method");
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }
}
