package com.tencent.tinker.loader.hidden;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.loader.hidden.Helper;
import dalvik.system.PathClassLoader;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Executable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class CoreOjClassLoader extends PathClassLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
        Covode.recordClassIndex(653950);
    }

    CoreOjClassLoader() {
        super(getCoreOjPath(), null);
    }

    private static String getCoreOjPath() {
        return System.getProperty("java.boot.class.path", "").split(":", 2)[0];
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (Object.class.getName().equals(str)) {
            return Object.class;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException unused) {
            if (Executable.class.getName().equals(str)) {
                return Helper.Executable.class;
            }
            if (MethodHandle.class.getName().equals(str)) {
                return Helper.MethodHandle.class;
            }
            if (Class.class.getName().equals(str)) {
                return Helper.Class.class;
            }
            return super.loadClass(str);
        }
    }
}
