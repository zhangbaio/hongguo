package com.tencent.tinker.loader;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.loader.hidden.HiddenApiBypass;
import com.tencent.tinker.loader.utils.DirUtils;
import com.tencent.tinker.loader.utils.FieldUtils;
import com.tencent.tinker.loader.utils.Logger;
import com.tencent.tinker.loader.utils.MethodUtils;
import com.tencent.tinker.loader.utils.ProcessUtils;
import com.tencent.tinker.loader.utils.ShareTinkerLog;
import com.tencent.tinker.loader.utils.Utils;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class MuteApplication extends Application {
    static MuteApplication sApp;
    private boolean isMainProcess;
    private boolean mAlignDex;
    private Application mDelegateApp;
    private final String mDelegateCls;
    private int mHostVerCode;
    private int mLastVerCode;
    private boolean mLockVer;
    private ClassLoader mMirageCL;
    private ClassLoader mOriginCL;
    private int mPatchVerCode;
    protected Intent mResultIntent;
    private int mRuleId;

    static {
        Covode.recordClassIndex(653947);
    }

    public static MuteApplication getInstance() {
        return sApp;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Application application = this.mDelegateApp;
        if (application == null) {
            return super.getBaseContext();
        }
        return application.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Application application = this.mDelegateApp;
        if (application == null) {
            return super.getResources();
        }
        return application.getResources();
    }

    protected void onClear() {
        ShareTinkerLog.w("Mute.App", "onClear...", new Object[0]);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.mDelegateApp == null) {
            super.onLowMemory();
        } else {
            ShareTinkerLog.i("Mute.App", "mDelegateApp.onLowMemory()", new Object[0]);
            this.mDelegateApp.onLowMemory();
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        if (this.mDelegateApp == null) {
            super.onTerminate();
        } else {
            ShareTinkerLog.i("Mute.App", "mDelegateApp.onTerminate()", new Object[0]);
            this.mDelegateApp.onTerminate();
        }
    }

    public int mzNightModeUseOf() {
        if (this.mDelegateApp == null) {
            return 1;
        }
        ShareTinkerLog.i("Mute.App", "mDelegateApp.mzNightModeUseOf()", new Object[0]);
        try {
            return ((Integer) MethodUtils.invokeMethod(this.mDelegateApp, "mzNightModeUseOf", new Object[0])).intValue();
        } catch (Throwable th) {
            throw new RuntimeException("onCreate invoke mDelegateApp.onCreate err", th);
        }
    }

    private Application createApplication() throws Throwable {
        long longExtra = this.mResultIntent.getLongExtra("App.attachBaseContext+", 0L);
        if (longExtra <= 0) {
            longExtra = System.currentTimeMillis();
        }
        Class<?> cls = Class.forName(this.mDelegateCls, false, getClassLoader());
        Class<?> cls2 = Long.TYPE;
        return (Application) cls.getConstructor(Application.class, cls2, cls2, Intent.class).newInstance(this, 0, Long.valueOf(longExtra), this.mResultIntent);
    }

    @Override // android.app.Application
    public void onCreate() {
        this.mResultIntent.putExtra("App.onCreate+", System.currentTimeMillis());
        if (this.mDelegateApp == null) {
            super.onCreate();
        } else {
            try {
                FieldUtils.writeField(this.mDelegateApp, "mLoadedApk", FieldUtils.readField(this, "mLoadedApk"));
            } catch (Throwable th) {
                ShareTinkerLog.e("Mute.App", "onCreate set DelegateApp.mLoadedApk err", th);
            }
            ShareTinkerLog.i("Mute.App", "onCreate --> DelegateApp", new Object[0]);
            this.mDelegateApp.onCreate();
        }
        this.mResultIntent.putExtra("App.onCreate-", System.currentTimeMillis());
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Application application = this.mDelegateApp;
        if (application == null) {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Application, android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Application application = this.mDelegateApp;
        if (application == null) {
            super.registerComponentCallbacks(componentCallbacks);
        } else {
            application.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Application application = this.mDelegateApp;
        if (application == null) {
            super.startActivity(intent);
        } else {
            application.startActivity(intent);
        }
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Application application = this.mDelegateApp;
        if (application == null) {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Application, android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Application application = this.mDelegateApp;
        if (application == null) {
            super.unregisterComponentCallbacks(componentCallbacks);
        } else {
            application.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Application application = this.mDelegateApp;
        if (application == null) {
            super.unregisterReceiver(broadcastReceiver);
        } else {
            application.unregisterReceiver(broadcastReceiver);
        }
    }

    private void resetMirageConfig(Context context) {
        if (this.isMainProcess) {
            KVManager.getInst().setLastStartMode(this.mPatchVerCode, 1);
            if (this.mLastVerCode != this.mPatchVerCode) {
                ProcessUtils.killSubsProcess(context);
            }
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.mDelegateApp == null) {
            super.onConfigurationChanged(configuration);
        } else {
            ShareTinkerLog.i("Mute.App", "mDelegateApp.onConfigurationChanged(new)", new Object[0]);
            this.mDelegateApp.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (this.mDelegateApp == null) {
            super.onTrimMemory(i);
        } else {
            ShareTinkerLog.i("Mute.App", "mDelegateApp.onTrimMemory()", new Object[0]);
            this.mDelegateApp.onTrimMemory(i);
        }
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        if (this.mDelegateApp == null) {
            super.registerOnProvideAssistDataListener(onProvideAssistDataListener);
        } else {
            ShareTinkerLog.i("Mute.App", "mDelegateApp.registerOnProvideAssistDataListener(c)", new Object[0]);
            this.mDelegateApp.registerOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        if (this.mDelegateApp == null) {
            super.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
        } else {
            ShareTinkerLog.i("Mute.App", "mDelegateApp.unregisterOnProvideAssistDataListener(c)", new Object[0]);
            this.mDelegateApp.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    protected MuteApplication(String str) {
        Intent intent = new Intent();
        this.mResultIntent = intent;
        intent.putExtra("App.constructor+", System.currentTimeMillis());
        sApp = this;
        this.mDelegateCls = str;
        this.mResultIntent.putExtra("App.constructor-", System.currentTimeMillis());
    }

    private void clearMirageConfig(Context context) {
        if (this.isMainProcess) {
            KVManager.getInst().clearInstalledVersion();
            KVManager.getInst().setLastStartMode(this.mHostVerCode, 0);
            int i = this.mLastVerCode;
            if (i != 0 && i != this.mHostVerCode) {
                ProcessUtils.killSubsProcess(context);
            }
            if (this.mLastVerCode > this.mHostVerCode) {
                onClear();
                Utils.deleteDir((File) new PolarisFileWrapper(context.getFilesDir(), "plugins"));
            }
        }
    }

    private boolean isLoaderOK(Context context) {
        File sourceApk;
        try {
            this.mOriginCL = getClassLoader();
            if (this.mAlignDex) {
                sourceApk = DirUtils.getAlignApk(this.mPatchVerCode);
            } else {
                sourceApk = DirUtils.getSourceApk(this.mPatchVerCode);
            }
            if (!sourceApk.exists()) {
                this.mResultIntent.putExtra("state", 2001);
                Logger.w("Mute.App", "create loader failed for ERROR_TARGET_APK_NOT_EXIST");
                return false;
            }
            if (Utils.isAndroidPHigher()) {
                HiddenApiBypass.addHiddenApiExemptions("");
            }
            this.mMirageCL = MuteClassLoader.createClassLoader(this.mOriginCL, sourceApk, DirUtils.getOptDir(sourceApk));
            return true;
        } catch (Throwable th) {
            this.mResultIntent.putExtra("state", 2000);
            this.mResultIntent.putExtra("error", new RuntimeException("Mirage create loader failed", th));
            Logger.e("Mute.App", "create loader failed for ERROR_CREATE_LOADER_EXCEPTION", th);
            return false;
        }
    }

    private boolean isConfigOK(Context context) {
        try {
            this.mHostVerCode = Utils.getUpdateVersionCode(context);
            this.mLastVerCode = KVManager.getInst().getLastStartMode()[0];
            this.mPatchVerCode = KVManager.getInst().getInstalledVersion();
            this.mRuleId = KVManager.getInst().getRuleId();
            this.mAlignDex = KVManager.getInst().getEnableAlignDex();
            this.mLockVer = KVManager.getInst().getEnableLockMuteVersion();
            this.mResultIntent.putExtra("intent_host_version", this.mHostVerCode);
            this.mResultIntent.putExtra("intent_patch_version", this.mPatchVerCode);
            if (this.isMainProcess && KVManager.getInst().hasStartException()) {
                this.mResultIntent.putExtra("state", 1001);
                Logger.w("Mute.App", "verify config failed for ERROR_MAIN_STARTUP_PROTECT");
                return false;
            }
            int i = this.mPatchVerCode;
            if (i == 10000000) {
                this.mResultIntent.putExtra("state", 1002);
                Logger.w("Mute.App", "verify config failed for ERROR_NO_AVAILABLE_VERSION");
                return false;
            }
            if (!this.isMainProcess && i != this.mLastVerCode) {
                this.mResultIntent.putExtra("state", 1003);
                Logger.w("Mute.App", "verify config failed for ERROR_SUBS_STARTUP_LIMITED");
                return false;
            }
            return true;
        } catch (Throwable th) {
            this.mResultIntent.putExtra("state", 1000);
            this.mResultIntent.putExtra("error", new RuntimeException("Mirage verify config failed", th));
            Logger.e("Mute.App", "verify config failed for ERROR_VERIFY_CONFIG_EXCEPTION", th);
            return false;
        }
    }

    private boolean isLaunchOK(Context context) {
        try {
            String str = context.getApplicationInfo().packageName;
            Class<?> cls = Class.forName("com.tencent.tinker.lib.MuteMaxLoader", false, this.mMirageCL);
            FieldUtils.writeStaticField(cls, "sOriginCL", this.mOriginCL);
            FieldUtils.writeStaticField(cls, "sBaseCtx", context);
            MuteClassLoader.replaceAllCL(context, this.mMirageCL);
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            boolean booleanValue = ((Boolean) MethodUtils.invokeMethod(cls.getConstructor(String.class, Intent.class, cls2, cls2, cls2, cls2, cls3, cls3, cls3).newInstance(str, this.mResultIntent, Integer.valueOf(this.mHostVerCode), Integer.valueOf(this.mLastVerCode), Integer.valueOf(this.mPatchVerCode), Integer.valueOf(this.mRuleId), Boolean.valueOf(this.mAlignDex), Boolean.valueOf(this.mLockVer), Boolean.valueOf(this.isMainProcess)), "maxLoad", new Object[0])).booleanValue();
            if (!booleanValue) {
                MuteClassLoader.replaceAllCL(context, this.mOriginCL);
            }
            return booleanValue;
        } catch (Throwable th) {
            this.mResultIntent.putExtra("state", 3000);
            this.mResultIntent.putExtra("error", new RuntimeException("Mirage switch launch failed", th));
            Logger.e("Mute.App", "switch launch failed for ERROR_SWITCH_LAUNCH_EXCEPTION", th);
            try {
                MuteClassLoader.replaceAllCL(context, this.mOriginCL);
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        this.mResultIntent.putExtra("App.attachBaseContext+", System.currentTimeMillis());
        super.attachBaseContext(context);
        boolean isMainProcess = ProcessUtils.isMainProcess(context);
        this.isMainProcess = isMainProcess;
        if (isMainProcess) {
            KVManager.getInst().writeStartFlag();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (isConfigOK(context) && isLoaderOK(context) && isLaunchOK(context)) {
            Logger.i("Mute.App", "mirage mode: " + this.mResultIntent.getStringExtra("value"));
            resetMirageConfig(context);
        } else {
            Logger.i("Mute.App", "normal mode: " + this.mResultIntent.getIntExtra("state", 0));
            clearMirageConfig(context);
        }
        try {
            this.mDelegateApp = createApplication();
            this.mResultIntent.putExtra("App.startup", currentTimeMillis - System.currentTimeMillis());
            try {
                MethodUtils.invokeMethod(this.mDelegateApp, "attachBaseContext", context);
                if (this.isMainProcess) {
                    KVManager.getInst().clearStartFlag();
                }
                this.mResultIntent.putExtra("App.attachBaseContext-", System.currentTimeMillis());
            } catch (Throwable th) {
                throw new RuntimeException("Mirage invoke attachBaseContext error", th);
            }
        } catch (Throwable th2) {
            throw new RuntimeException("Mirage create MirageApplication error", th2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Application application = this.mDelegateApp;
        if (application == null) {
            return super.registerReceiver(broadcastReceiver, intentFilter);
        }
        return application.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        Application application = this.mDelegateApp;
        if (application == null) {
            return super.registerReceiver(broadcastReceiver, intentFilter, i);
        }
        return application.registerReceiver(broadcastReceiver, intentFilter, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        if (this.mDelegateApp == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory);
        }
        ShareTinkerLog.i("Mute.App", String.format("mDelegateApp.openOrCreateDatabase(%s, m, f)", str), new Object[0]);
        return this.mDelegateApp.openOrCreateDatabase(str, i, cursorFactory);
    }
}
