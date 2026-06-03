package com.vivo.push.util;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ContextDelegate {
    private static Context mContext;
    private static volatile Method mCreateCredentialProtectedStorageContext;
    private static volatile Method mCreateDeviceProtectedStorageContext;
    private static boolean mDelegateEnable;
    private static volatile Boolean mIsFbeProject;
    private static volatile Boolean mIsFdeProject;

    private static class a {
        private static ContextDelegate a;

        static {
            Covode.recordClassIndex(655172);
            a = new ContextDelegate();
        }
    }

    public static ContextDelegate getInstance() {
        return a.a;
    }

    private static void setAppContext() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    static {
        Covode.recordClassIndex(655171);
        mIsFbeProject = null;
        mIsFdeProject = null;
        mDelegateEnable = false;
        mContext = null;
    }

    public static synchronized boolean isFBEProject() {
        boolean z;
        synchronized (ContextDelegate.class) {
            if (mIsFbeProject == null) {
                try {
                    if ("file".equals(m.a("ro.crypto.type", "unknow"))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mIsFbeProject = Boolean.valueOf(z);
                    t.b("ContextDelegate", "mIsFbeProject = " + mIsFbeProject.toString());
                } catch (Exception e) {
                    t.a("ContextDelegate", "mIsFbeProject = " + e.getMessage());
                }
            }
            if (mIsFbeProject == null) {
                return false;
            }
            return mIsFbeProject.booleanValue();
        }
    }

    private static synchronized boolean isFDEProject() {
        boolean z;
        synchronized (ContextDelegate.class) {
            if (mIsFdeProject == null) {
                try {
                    if ("block".equals(m.a("ro.crypto.type", "unknow"))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mIsFdeProject = Boolean.valueOf(z);
                    t.b("ContextDelegate", "mIsFdeProject = " + mIsFdeProject.toString());
                } catch (Exception e) {
                    t.a("ContextDelegate", "mIsFdeProject = " + e.getMessage());
                }
            }
            if (mIsFdeProject == null) {
                return false;
            }
            return mIsFdeProject.booleanValue();
        }
    }

    public static void setEnable(boolean z) {
        mDelegateEnable = z;
        setAppContext();
    }

    public static Context getContext(Context context) {
        if ((!isFBEProject() && !isFDEProject()) || context == null) {
            return context;
        }
        Context context2 = mContext;
        if (context2 != null) {
            return context2;
        }
        setContext(context);
        return mContext;
    }

    private static void setContext(Context context) {
        if (!mDelegateEnable) {
            mContext = createCredentialProtectedStorageContext(context);
        } else {
            mContext = createDeviceProtectedStorageContext(context);
        }
    }

    private static synchronized Context createCredentialProtectedStorageContext(Context context) {
        Context context2;
        synchronized (ContextDelegate.class) {
            try {
                if (mCreateCredentialProtectedStorageContext == null) {
                    mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
                }
                context2 = (Context) mCreateCredentialProtectedStorageContext.invoke(context, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return context;
            }
        }
        return context2;
    }

    private static synchronized Context createDeviceProtectedStorageContext(Context context) {
        Context context2;
        synchronized (ContextDelegate.class) {
            try {
                if (mCreateDeviceProtectedStorageContext == null) {
                    mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
                }
                context2 = (Context) mCreateDeviceProtectedStorageContext.invoke(context, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return context;
            }
        }
        return context2;
    }
}
