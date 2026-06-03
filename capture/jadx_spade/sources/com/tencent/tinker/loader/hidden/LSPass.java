package com.tencent.tinker.loader.hidden;

import android.util.Property;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.loader.utils.ShareTinkerLog;
import dalvik.system.VMRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class LSPass {
    private static final Property<Class, Constructor[]> constructors;
    private static final Property<Class, Field[]> fields;
    private static final Property<Class, Method[]> methods;

    public static boolean clearHiddenApiExemptions() {
        Helper.signaturePrefixes.clear();
        return setHiddenApiExemptions(new String[0]);
    }

    static {
        Covode.recordClassIndex(653959);
        methods = Property.of(Class.class, Method[].class, "DeclaredMethods");
        constructors = Property.of(Class.class, Constructor[].class, "DeclaredConstructors");
        fields = Property.of(Class.class, Field[].class, "DeclaredFields");
    }

    public static List<Constructor<?>> getDeclaredConstructors(Class<?> cls) {
        return Arrays.asList(constructors.get(cls));
    }

    public static List<Field> getDeclaredFields(Class<?> cls) {
        return Arrays.asList(fields.get(cls));
    }

    public static List<Method> getDeclaredMethods(Class<?> cls) {
        return Arrays.asList(methods.get(cls));
    }

    public static boolean addHiddenApiExemptions(String... strArr) {
        Set<String> set = Helper.signaturePrefixes;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[set.size()];
        set.toArray(strArr2);
        return setHiddenApiExemptions(strArr2);
    }

    public static List<Field> getInstanceFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : getDeclaredFields(cls)) {
            if (!Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    public static List<Field> getStaticFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : getDeclaredFields(cls)) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    public static boolean setHiddenApiExemptions(String... strArr) {
        try {
            invoke(VMRuntime.class, invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (ReflectiveOperationException e) {
            ShareTinkerLog.w("Mute.LSPass", "setHiddenApiExemptions", e);
            return false;
        }
    }

    public static Constructor<?> getDeclaredConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        for (Constructor<?> constructor : getDeclaredConstructors(cls)) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    if (clsArr[i] != parameterTypes[i]) {
                        break;
                    }
                }
                return constructor;
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Object newInstance(Class<?> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Constructor<?> constructor : getDeclaredConstructors(cls)) {
            if (Helper.checkArgsForInvokeMethod(constructor.getParameterTypes(), objArr)) {
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Method method : getDeclaredMethods(cls)) {
            if (method.getName().equals(str)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i = 0; i < clsArr.length; i++) {
                        if (clsArr[i] != parameterTypes[i]) {
                            break;
                        }
                    }
                    return method;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Method method : getDeclaredMethods(cls)) {
            if (method.getName().equals(str) && Helper.checkArgsForInvokeMethod(method.getParameterTypes(), objArr)) {
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }
}
