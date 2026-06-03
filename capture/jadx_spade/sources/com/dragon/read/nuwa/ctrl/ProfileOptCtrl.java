package com.dragon.read.nuwa.ctrl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.nuwa.base.util.DoubleReflectHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ProfileOptCtrl {
    public static onProfileChangedListener sListener;

    public interface onProfileChangedListener {
        void onClassProfileChanged(int i, int i2);
    }

    static {
        Covode.recordClassIndex(612610);
        sListener = null;
    }

    public static String getDexLocation(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Field declaredField = Class.class.getDeclaredField("dexCache");
            declaredField.setAccessible(true);
            return (String) DoubleReflectHelper.readField(declaredField.get(cls), "location");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getDexTypeIndex(Class<?> cls) {
        if (cls == null) {
            return -1;
        }
        try {
            return ((Integer) DoubleReflectHelper.readField(cls, "dexTypeIndex")).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static String getProfileDexFileBaseKeyView(String str) {
        if (str != null && !str.isEmpty()) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf == -1) {
                return str;
            }
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    public static long getDexFilePtr(Class<?> cls) {
        if (cls == null) {
            return -1L;
        }
        try {
            Field declaredField = Class.class.getDeclaredField("dexCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = obj.getClass().getDeclaredField("dexFile");
            declaredField2.setAccessible(true);
            return declaredField2.getLong(obj);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String javaClassNameToDescriptor(String str) {
        int i;
        if (str == null || str.isEmpty()) {
            return null;
        }
        switch (str) {
            case "double":
                return "D";
            case "int":
                return "I";
            case "byte":
                return "B";
            case "char":
                return "C";
            case "long":
                return "J";
            case "void":
                return "V";
            case "boolean":
                return "Z";
            case "float":
                return "F";
            case "short":
                return "S";
            default:
                if (str.endsWith("[]")) {
                    int i2 = 0;
                    while (str.endsWith("[]")) {
                        i2++;
                        str = str.substring(0, str.length() - 2);
                    }
                    String javaClassNameToDescriptor = javaClassNameToDescriptor(str);
                    if (javaClassNameToDescriptor == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (i = 0; i < i2; i++) {
                        sb.append('[');
                    }
                    sb.append(javaClassNameToDescriptor);
                    return sb.toString();
                }
                if (!str.matches("[a-zA-Z_$][a-zA-Z0-9_$]*(\\.[a-zA-Z_$][a-zA-Z0-9_$]*)*")) {
                    return null;
                }
                return "L" + str.replace('.', '/') + ";";
        }
    }

    public static Map<Long, List<String>> convertToDexFileAndClassDescriptorMap(ClassLoader classLoader, List<String> list) {
        HashMap hashMap = new HashMap();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str, false, classLoader);
                String javaClassNameToDescriptor = javaClassNameToDescriptor(str);
                long dexFilePtr = getDexFilePtr(cls);
                if (javaClassNameToDescriptor != null && dexFilePtr != -1) {
                    if (!hashMap.containsKey(Long.valueOf(dexFilePtr))) {
                        hashMap.put(Long.valueOf(dexFilePtr), new ArrayList());
                    }
                    ((List) hashMap.get(Long.valueOf(dexFilePtr))).add(javaClassNameToDescriptor);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public static Map<String, List<Integer>> convertToProfileKeyAndTypeIndex(ClassLoader classLoader, List<String> list) {
        HashMap hashMap = new HashMap();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                Class<?> cls = Class.forName(it2.next(), false, classLoader);
                String profileDexFileBaseKeyView = getProfileDexFileBaseKeyView(getDexLocation(cls));
                int dexTypeIndex = getDexTypeIndex(cls);
                if (profileDexFileBaseKeyView != null && dexTypeIndex != -1) {
                    if (!hashMap.containsKey(profileDexFileBaseKeyView)) {
                        hashMap.put(profileDexFileBaseKeyView, new ArrayList());
                    }
                    ((List) hashMap.get(profileDexFileBaseKeyView)).add(Integer.valueOf(dexTypeIndex));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }
}
