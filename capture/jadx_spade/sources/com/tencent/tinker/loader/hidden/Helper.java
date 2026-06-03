package com.tencent.tinker.loader.hidden;

import com.bytedance.covode.number.Covode;
import java.lang.invoke.MethodType;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Helper {
    static final Set<String> signaturePrefixes;

    public static class AccessibleObject {
        private boolean override;

        static {
            Covode.recordClassIndex(653952);
        }
    }

    public static final class Class {
        private transient int accessFlags;
        private transient int classFlags;
        private transient ClassLoader classLoader;
        private transient int classSize;
        private transient int clinitThreadId;
        private transient java.lang.Class<?> componentType;
        private transient short copiedMethodsOffset;
        private transient Object dexCache;
        private transient int dexClassDefIndex;
        private volatile transient int dexTypeIndex;
        private transient Object extData;
        private transient long iFields;
        private transient Object[] ifTable;
        private transient long methods;
        private transient String name;
        private transient int numReferenceInstanceFields;
        private transient int numReferenceStaticFields;
        private transient int objectSize;
        private transient int objectSizeAllocFastPath;
        private transient int primitiveType;
        private transient int referenceInstanceOffsets;
        private transient long sFields;
        private transient int status;
        private transient java.lang.Class<?> superClass;
        private transient short virtualMethodsOffset;
        private transient Object vtable;

        static {
            Covode.recordClassIndex(653953);
        }
    }

    public static final class Executable extends AccessibleObject {
        private int accessFlags;
        private long artMethod;
        private Class declaringClass;
        private Class declaringClassOfOverriddenMethod;
        private Object[] parameters;

        static {
            Covode.recordClassIndex(653954);
        }
    }

    public static class MethodHandle {
        private MethodHandle cachedSpreadInvoker;
        private MethodType nominalType;
        private final MethodType type = null;
        protected final int handleKind = 0;
        protected final long artFieldOrMethod = 0;

        static {
            Covode.recordClassIndex(653956);
        }
    }

    public static class NeverCall {
        private static int s;
        private static int t;
        private int i;
        private int j;

        static {
            Covode.recordClassIndex(653957);
        }

        private static void a() {
        }

        private static void b() {
        }
    }

    static {
        Covode.recordClassIndex(653951);
        signaturePrefixes = new HashSet();
    }

    public static class InvokeStub {
        static {
            Covode.recordClassIndex(653955);
        }

        private static Object invoke(Object... objArr) {
            throw new IllegalStateException("Failed to invoke the method");
        }

        private InvokeStub(Object... objArr) {
            throw new IllegalStateException("Failed to new a instance");
        }
    }

    static boolean checkArgsForInvokeMethod(java.lang.Class<?>[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i].isPrimitive()) {
                java.lang.Class<?> cls = clsArr[i];
                if (cls == Integer.TYPE && !(objArr[i] instanceof Integer)) {
                    return false;
                }
                if (cls == Byte.TYPE && !(objArr[i] instanceof Byte)) {
                    return false;
                }
                if (cls == Character.TYPE && !(objArr[i] instanceof Character)) {
                    return false;
                }
                if (cls == Boolean.TYPE && !(objArr[i] instanceof Boolean)) {
                    return false;
                }
                if (cls == Double.TYPE && !(objArr[i] instanceof Double)) {
                    return false;
                }
                if (cls == Float.TYPE && !(objArr[i] instanceof Float)) {
                    return false;
                }
                if (cls == Long.TYPE && !(objArr[i] instanceof Long)) {
                    return false;
                }
                if (cls == Short.TYPE && !(objArr[i] instanceof Short)) {
                    return false;
                }
            } else {
                Object obj = objArr[i];
                if (obj != null && !clsArr[i].isInstance(obj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
