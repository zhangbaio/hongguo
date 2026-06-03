package com.tencent.tinker.lib.dexopt;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.DirUtils;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.FileUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import com.tencent.tinker.lib.utils.ShareReflectUtil;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DexOptimize {
    private Context mContext;
    private File mDexFile;
    private File mOatFile;
    private final IBinder[] mPMSBinder = {null};
    private Result mResult;
    private PackageManager mSyncAppPkgMgr;
    private File mVdexFile;

    static {
        Covode.recordClassIndex(653738);
    }

    private static Object com_tencent_tinker_lib_dexopt_DexOptimize_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        com.bytedance.helios.statichook.api.Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public static final class Result {
        public String mReason1;
        public String mReason2;
        public String mReason3;
        public String mReason4;
        public int mRetryTimes;
        public boolean mSuccess;
        public int mType;
        public boolean mWait;

        static {
            Covode.recordClassIndex(653739);
        }

        public Result() {
        }

        public String format2Json() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mSuccess", this.mSuccess);
                jSONObject.put("mType", this.mType);
                jSONObject.put("mRetryTimes", this.mRetryTimes);
                jSONObject.put("mWait", this.mWait);
                jSONObject.put("mReason1", this.mReason1);
                jSONObject.put("mReason2", this.mReason2);
                jSONObject.put("mReason3", this.mReason3);
                jSONObject.put("mReason4", this.mReason4);
                String jSONObject2 = jSONObject.toString();
                MuteLog.i("Mute.DexOpt2", "format2Json %s", jSONObject2);
                return jSONObject2;
            } catch (JSONException e) {
                MuteLog.w("Mute.DexOpt2", "format2Json write JSON failed. %s", e);
                return "";
            }
        }

        public Map<String, Object> formatMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("oatSuccess", Boolean.valueOf(this.mSuccess));
            hashMap.put("oatType", Integer.valueOf(this.mType));
            hashMap.put("oatRetryTimes", Integer.valueOf(this.mRetryTimes));
            hashMap.put("oatWait", Boolean.valueOf(this.mWait));
            String str = this.mReason1;
            if (str != null) {
                hashMap.put("reason1", str);
            }
            String str2 = this.mReason2;
            if (str2 != null) {
                hashMap.put("reason2", str2);
            }
            String str3 = this.mReason3;
            if (str3 != null) {
                hashMap.put("reason3", str3);
            }
            String str4 = this.mReason4;
            if (str4 != null) {
                hashMap.put("reason4", str4);
            }
            return hashMap;
        }

        public Result(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mSuccess = jSONObject.optBoolean("mSuccess");
                this.mType = jSONObject.optInt("mType");
                this.mRetryTimes = jSONObject.optInt("mRetryTimes");
                this.mWait = jSONObject.optBoolean("mWait");
                this.mReason1 = jSONObject.optString("mReason1");
                this.mReason2 = jSONObject.optString("mReason2");
                this.mReason3 = jSONObject.optString("mReason3");
                this.mReason4 = jSONObject.optString("mReason4");
            } catch (JSONException e) {
                MuteLog.w("Mute.DexOpt2", "formatFromJson failed. %s", e);
            }
        }

        public Result(boolean z, int i) {
            this.mSuccess = z;
            this.mType = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResult(boolean z, int i) {
            this.mSuccess = z;
            this.mType = i;
        }
    }

    private boolean isOatValid() {
        if (FileUtils.isLegalFile(this.mOatFile) && FileUtils.checkElfFile(this.mOatFile)) {
            return true;
        }
        return false;
    }

    private void createOatFile() {
        if (!this.mOatFile.exists()) {
            File parentFile = this.mOatFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                this.mOatFile.createNewFile();
                MuteLog.i("Mute.DexOpt2", "createOatFile success [%s]", this.mOatFile);
                return;
            } catch (Throwable th) {
                MuteLog.e("Mute.DexOpt2", "createOatFile err[%s]", th.getMessage());
                return;
            }
        }
        MuteLog.i("Mute.DexOpt2", "createOatFile already exist [%s]", this.mOatFile);
    }

    private IBinder getPMSBinder() throws Throwable {
        synchronized (this.mPMSBinder) {
            IBinder iBinder = this.mPMSBinder[0];
            if (iBinder != null && iBinder.isBinderAlive()) {
                MuteLog.i("Mute.DexOpt2", "getPMSBinder alive", new Object[0]);
                return this.mPMSBinder[0];
            }
            this.mPMSBinder[0] = (IBinder) MethodUtils.invokeStaticMethod(Class.forName("android.os.ServiceManager"), "getService", "package");
            MuteLog.i("Mute.DexOpt2", "getPMSBinder invoke android.os.ServiceManager.getService(\"package\")", new Object[0]);
            return this.mPMSBinder[0];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean bgDexOptJob() {
        Parcel parcel;
        String[] strArr = {"bg-dexopt-job", this.mContext.getPackageName()};
        long clearCallingIdentity = Binder.clearCallingIdentity();
        Parcel parcel2 = null;
        Object[] objArr = 0;
        try {
            IBinder pMSBinder = getPMSBinder();
            Parcel obtain = Parcel.obtain();
            try {
                parcel = Parcel.obtain();
                try {
                    obtain.writeFileDescriptor(FileDescriptor.in);
                    obtain.writeFileDescriptor(FileDescriptor.out);
                    obtain.writeFileDescriptor(FileDescriptor.err);
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(null);
                    new ResultReceiver(objArr == true ? 1 : 0) { // from class: com.tencent.tinker.lib.dexopt.DexOptimize.3
                        @Override // android.os.ResultReceiver
                        protected void onReceiveResult(int i, Bundle bundle) {
                            super.onReceiveResult(i, bundle);
                            MuteLog.i("Mute.DexOpt2", "bgDexOptJob onReceiveResult(%d, %s)", Integer.valueOf(i), bundle);
                        }
                    }.writeToParcel(obtain, 0);
                    MuteLog.i("Mute.DexOpt2", "bgDexOptJob data.write[in, out, err, args=%s, shellCB=null, rec]", Arrays.toString(strArr));
                    if (!pMSBinder.transact(1598246212, obtain, parcel, 0)) {
                        MuteLog.w("Mute.DexOpt2", "bgDexOptJob pmsBinder.transact >> false", new Object[0]);
                        this.mResult.mReason4 = "bgDexOptJob_transact";
                        obtain.recycle();
                        if (parcel != null) {
                            parcel.recycle();
                        }
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        return false;
                    }
                    MuteLog.i("Mute.DexOpt2", "bgDexOptJob pmsBinder.transact >> true", new Object[0]);
                    parcel.readException();
                    MuteLog.i("Mute.DexOpt2", "bgDexOptJob reply.readException()", new Object[0]);
                    obtain.recycle();
                    parcel.recycle();
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    parcel2 = obtain;
                    try {
                        this.mResult.mReason4 = "bgDexOptJob_err[" + th.getCause() + "]";
                        MuteLog.printErrStackTrace("Mute.DexOpt2", th, "bgDexOptJob[false] err", new Object[0]);
                        return false;
                    } finally {
                        if (parcel2 != null) {
                            parcel2.recycle();
                        }
                        if (parcel != null) {
                            parcel.recycle();
                        }
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                parcel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            parcel = null;
        }
    }

    private boolean performDexOptSecondary() {
        Throwable th;
        Parcel parcel;
        int i;
        String str;
        Parcel parcel2 = null;
        try {
            IBinder pMSBinder = getPMSBinder();
            Object readStaticField = FieldUtils.readStaticField(Class.forName("android.content.pm.IPackageManager$Stub"), "TRANSACTION_performDexOptSecondary");
            if (readStaticField != null) {
                i = ((Integer) readStaticField).intValue();
            } else {
                i = 104;
            }
            boolean z = true;
            MuteLog.i("Mute.DexOpt2", "performDexOptSecondary read IPackageManager$Stub.TRANSACTION_performDexOptSecondary=%d", Integer.valueOf(i));
            Parcel obtain = Parcel.obtain();
            try {
                Parcel obtain2 = Parcel.obtain();
                String interfaceDescriptor = pMSBinder.getInterfaceDescriptor();
                obtain.writeInterfaceToken(interfaceDescriptor);
                String packageName = this.mContext.getPackageName();
                obtain.writeString(packageName);
                if (OSUtil.isNewerOrEqualThanVersion(31)) {
                    str = "verify";
                } else {
                    str = "speed-profile";
                }
                obtain.writeString(str);
                obtain.writeInt(1);
                MuteLog.i("Mute.DexOpt2", "performDexOptSecondary data.write[token=%s, pkgName=%s, compilerFilter=%s, force=1]", interfaceDescriptor, packageName, str);
                if (!pMSBinder.transact(i, obtain, obtain2, 0)) {
                    MuteLog.w("Mute.DexOpt2", "performDexOptSecondary pmsBinder.transact >> false", new Object[0]);
                    this.mResult.mReason1 = "performDexOptSecondary_transact";
                    obtain.recycle();
                    if (obtain2 != null) {
                        obtain2.recycle();
                    }
                    return false;
                }
                MuteLog.i("Mute.DexOpt2", "performDexOptSecondary pmsBinder.transact >> true", new Object[0]);
                obtain2.readException();
                MuteLog.i("Mute.DexOpt2", "performDexOptSecondary reply.readException()", new Object[0]);
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                if (z) {
                    MuteLog.i("Mute.DexOpt2", "performDexOptSecondary reply.readInt=true", new Object[0]);
                } else {
                    this.mResult.mReason1 = "performDexOptSecondary_readInt";
                    MuteLog.w("Mute.DexOpt2", "performDexOptSecondary reply.readInt=false", new Object[0]);
                }
                obtain.recycle();
                obtain2.recycle();
                return z;
            } catch (Throwable th2) {
                th = th2;
                parcel = null;
                parcel2 = obtain;
                try {
                    this.mResult.mReason1 = "performDexOptSecondary_err[" + th.getCause() + "]";
                    MuteLog.printErrStackTrace("Mute.DexOpt2", th, "performDexOptSecondary[false] err", new Object[0]);
                    return false;
                } finally {
                    if (parcel2 != null) {
                        parcel2.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            parcel = null;
        }
    }

    private boolean registerDexModule() {
        IBinder iBinder;
        if (OSUtil.isAndroidUHigher()) {
            MuteLog.w("Mute.DexOpt2", "registerDexModule skip by >= android-14", new Object[0]);
            this.mResult.mReason3 = "registerDexModule_skip";
            return false;
        }
        try {
            if (this.mSyncAppPkgMgr == null || (iBinder = this.mPMSBinder[0]) == null || !iBinder.isBinderAlive()) {
                final IBinder pMSBinder = getPMSBinder();
                IBinder iBinder2 = (IBinder) Proxy.newProxyInstance(this.mContext.getClassLoader(), pMSBinder.getClass().getInterfaces(), new InvocationHandler() { // from class: com.tencent.tinker.lib.dexopt.DexOptimize.2
                    private static Object com_tencent_tinker_lib_dexopt_DexOptimize$2_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) throws Throwable {
                        com.bytedance.helios.statichook.api.Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
                        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
                    }

                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        if ("transact".equals(method.getName())) {
                            objArr[3] = 0;
                        }
                        return com_tencent_tinker_lib_dexopt_DexOptimize$2_java_lang_reflect_Method_invoke(method, pMSBinder, objArr);
                    }
                });
                MuteLog.i("Mute.DexOpt2", "registerDexModule newProxyInstance for syncPMSBinder", new Object[0]);
                Class<?> cls = Class.forName("android.content.pm.IPackageManager");
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.content.pm.IPackageManager$Stub"), "asInterface", iBinder2);
                Context context = this.mContext;
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                MuteLog.i("Mute.DexOpt2", "registerDexModule IPackageManager$Stub.asInterface(syncPMSBinder)", new Object[0]);
                Constructor<?> declaredConstructor = Class.forName("android.app.ApplicationPackageManager").getDeclaredConstructor(context.getClass(), cls);
                declaredConstructor.setAccessible(true);
                this.mSyncAppPkgMgr = (PackageManager) declaredConstructor.newInstance(context, invokeStaticMethod);
                MuteLog.i("Mute.DexOpt2", "registerDexModule new ApplicationPackageManager(contextImpl, pmsStubProxy)", new Object[0]);
            }
            com_tencent_tinker_lib_dexopt_DexOptimize_java_lang_reflect_Method_invoke(ShareReflectUtil.findMethod(this.mSyncAppPkgMgr, "registerDexModule", (Class<?>[]) new Class[]{String.class, Class.forName("android.content.pm.PackageManager$DexModuleRegisterCallback")}), this.mSyncAppPkgMgr, new Object[]{this.mDexFile.getAbsolutePath(), null});
            MuteLog.i("Mute.DexOpt2", "invoke registerDexModule(x, x)", new Object[0]);
            return true;
        } catch (Throwable th) {
            this.mResult.mReason3 = "registerDexModule_err[" + th.getCause() + "]";
            MuteLog.printErrStackTrace("Mute.DexOpt2", th, "registerDexModule[false] err", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean compileSecondaryDex() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.dexopt.DexOptimize.compileSecondaryDex():boolean");
    }

    private Result dex2oatCompile() {
        createOatFile();
        if (isOatValid()) {
            MuteLog.w("Mute.DexOpt2", "dex2oatCompile OAT already exist", new Object[0]);
            this.mResult.setResult(true, 2);
            return this.mResult;
        }
        FileUtils.setOnlyReadable(this.mDexFile);
        new PathClassLoader(this.mDexFile.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
        MuteLog.i("Mute.DexOpt2", "dex2oatCompile new PathClassLoader() --> notifyDexLoad()", new Object[0]);
        int i = 0;
        while (i < 3) {
            try {
                i++;
                this.mResult.mRetryTimes = i;
                MuteLog.i("Mute.DexOpt2", "dex2oatCompile times[%d]", Integer.valueOf(i));
                if (performDexOptSecondary()) {
                    if (isOatValid()) {
                        MuteLog.i("Mute.DexOpt2", "performDexOptSecondary OAT valid", new Object[0]);
                        this.mResult.setResult(true, 3);
                        Result result = this.mResult;
                        waitTimeSeq(this.mVdexFile, new Long[0]);
                        return result;
                    }
                    if (waitTimeSeq(this.mOatFile, 3000L) && isOatValid()) {
                        MuteLog.i("Mute.DexOpt2", "performDexOptSecondary OAT valid", new Object[0]);
                        this.mResult.setResult(true, 3);
                        Result result2 = this.mResult;
                        result2.mWait = true;
                        waitTimeSeq(this.mVdexFile, new Long[0]);
                        return result2;
                    }
                    MuteLog.w("Mute.DexOpt2", "performDexOptSecondary OAT invalid", new Object[0]);
                    this.mResult.mReason1 = "performDexOptSecondary_invalid";
                }
                if (compileSecondaryDex()) {
                    if (isOatValid()) {
                        MuteLog.i("Mute.DexOpt2", "compileSecondaryDex OAT valid", new Object[0]);
                        this.mResult.setResult(true, 4);
                        Result result3 = this.mResult;
                        waitTimeSeq(this.mVdexFile, new Long[0]);
                        return result3;
                    }
                    if (waitTimeSeq(this.mOatFile, 3000L) && isOatValid()) {
                        MuteLog.i("Mute.DexOpt2", "compileSecondaryDex OAT valid", new Object[0]);
                        this.mResult.setResult(true, 4);
                        Result result4 = this.mResult;
                        result4.mWait = true;
                        waitTimeSeq(this.mVdexFile, new Long[0]);
                        return result4;
                    }
                    MuteLog.w("Mute.DexOpt2", "compileSecondaryDex OAT invalid", new Object[0]);
                    this.mResult.mReason2 = "compileSecondaryDex_invalid";
                }
                if (registerDexModule()) {
                    if (isOatValid()) {
                        MuteLog.i("Mute.DexOpt2", "registerDexModule OAT valid", new Object[0]);
                        this.mResult.setResult(true, 5);
                        Result result5 = this.mResult;
                        waitTimeSeq(this.mVdexFile, new Long[0]);
                        return result5;
                    }
                    if (waitTimeSeq(this.mOatFile, 3000L) && isOatValid()) {
                        MuteLog.i("Mute.DexOpt2", "registerDexModule OAT valid", new Object[0]);
                        this.mResult.setResult(true, 5);
                        Result result6 = this.mResult;
                        result6.mWait = true;
                        waitTimeSeq(this.mVdexFile, new Long[0]);
                        return result6;
                    }
                    MuteLog.w("Mute.DexOpt2", "registerDexModule OAT invalid", new Object[0]);
                    this.mResult.mReason3 = "registerDexModule_invalid";
                }
            } catch (Throwable th) {
                waitTimeSeq(this.mVdexFile, new Long[0]);
                throw th;
            }
        }
        waitTimeSeq(this.mVdexFile, new Long[0]);
        if (isOatValid()) {
            MuteLog.i("Mute.DexOpt2", "exeDex2OatCompile[true] finalCheck OAT valid", new Object[0]);
            this.mResult.setResult(true, 7);
        } else {
            MuteLog.w("Mute.DexOpt2", "exeDex2OatCompile[false] finalCheck OAT invalid", new Object[0]);
            this.mResult.setResult(false, 7);
        }
        return this.mResult;
    }

    private static boolean waitTimeSeq(File file, Long... lArr) {
        if (lArr == null || lArr.length <= 0) {
            lArr = new Long[]{1000L, 2000L, 4000L, 8000L, 16000L};
        }
        for (int i = 0; !FileUtils.isLegalFile(file) && i < lArr.length; i++) {
            MuteLog.i("Mute.DexOpt2", "waitTimeSeq[%d] file[%s]", lArr[i], file.getName());
            SystemClock.sleep(lArr[i].longValue());
        }
        boolean isLegalFile = FileUtils.isLegalFile(file);
        if (isLegalFile) {
            MuteLog.i("Mute.DexOpt2", "waitTimeSeq[true] file[%s]", file.getName());
        } else {
            MuteLog.w("Mute.DexOpt2", "waitTimeSeq[false] file[%s]", file.getName());
        }
        return isLegalFile;
    }

    public Result optimize(Context context, File file) {
        MuteLog.i("Mute.DexOpt2", "optimize start dex[%s] dexSize[%d]", file.getName(), Long.valueOf(file.length()));
        this.mContext = context;
        this.mDexFile = file;
        this.mOatFile = DirUtils.getOatFile(file);
        this.mVdexFile = new PolarisFileWrapper(this.mOatFile.getParent(), this.mOatFile.getName().substring(0, this.mOatFile.getName().lastIndexOf(".")) + ".vdex");
        this.mResult = new Result();
        if (OSUtil.isNewerOrEqualThanVersion(29)) {
            MuteLog.i("Mute.DexOpt2", "optimize os >= 29 dex2OatCompile", new Object[0]);
            return dex2oatCompile();
        }
        MuteLog.i("Mute.DexOpt2", "optimize os < 29 execFastDex2OatCmd", new Object[0]);
        Dex2OatHelper.execFastDex2OatCmd(file.getAbsolutePath(), this.mOatFile.getAbsolutePath());
        this.mResult.setResult(isOatValid(), 1);
        return this.mResult;
    }
}
