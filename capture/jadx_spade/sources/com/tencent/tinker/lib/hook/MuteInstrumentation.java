package com.tencent.tinker.lib.hook;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.TestLooperManager;
import android.os.UserHandle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteMaxLoader;
import com.tencent.tinker.lib.MuteReplacer;
import com.tencent.tinker.lib.MuteResReplacer;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.am.ApplicationThread;
import com.tencent.tinker.lib.am.PatchActivityManager;
import com.tencent.tinker.lib.pm.PatchPackageManager;
import com.tencent.tinker.lib.utils.ATUtils;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import com.tencent.tinker.lib.utils.ProcessUtil;
import com.tencent.tinker.lib.utils.ShareReflectUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteInstrumentation extends Instrumentation implements OnHookInstall {
    private ApplicationThread mAppThread = new ApplicationThread();
    private Instrumentation mOrigin;

    static {
        Covode.recordClassIndex(653761);
    }

    private static List com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
        Result preInvoke = new HeliosApiHook().preInvoke(101311, "android/content/pm/PackageManager", "queryIntentActivities", packageManager, new Object[]{intent, Integer.valueOf(i)}, "java.util.List", new ExtraInfo(false, "(Landroid/content/Intent;I)Ljava/util/List;"));
        return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : packageManager.queryIntentActivities(intent, i);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, String str, Intent intent, int i, Bundle bundle, UserHandle userHandle) {
        Intent wrapIntent = wrapIntent(str, intent, i);
        try {
            MethodUtils.invokeMethod(this.mOrigin, "execStartActivity", new Object[]{context, iBinder, iBinder2, str, wrapIntent, Integer.valueOf(i), bundle, userHandle}, new Class[]{Context.class, IBinder.class, IBinder.class, String.class, Intent.class, Integer.TYPE, Bundle.class, UserHandle.class});
            return null;
        } catch (Exception e) {
            handleException(wrapIntent, e);
            return null;
        }
    }

    @Override // android.app.Instrumentation
    public void endPerformanceSnapshot() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.endPerformanceSnapshot();
        } else {
            super.endPerformanceSnapshot();
        }
    }

    @Override // android.app.Instrumentation
    public Bundle getAllocCounts() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getAllocCounts();
        }
        return super.getAllocCounts();
    }

    @Override // android.app.Instrumentation
    public Bundle getBinderCounts() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getBinderCounts();
        }
        return super.getBinderCounts();
    }

    @Override // android.app.Instrumentation
    public ComponentName getComponentName() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getComponentName();
        }
        return super.getComponentName();
    }

    @Override // android.app.Instrumentation
    public Context getContext() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getContext();
        }
        return super.getContext();
    }

    @Override // android.app.Instrumentation
    public String getProcessName() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getProcessName();
        }
        return super.getProcessName();
    }

    @Override // android.app.Instrumentation
    public Context getTargetContext() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getTargetContext();
        }
        return super.getTargetContext();
    }

    @Override // android.app.Instrumentation
    public UiAutomation getUiAutomation() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getUiAutomation();
        }
        return super.getUiAutomation();
    }

    @Override // android.app.Instrumentation
    public boolean isProfiling() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.isProfiling();
        }
        return super.isProfiling();
    }

    @Override // android.app.Instrumentation
    public void onDestroy() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Instrumentation
    public void onStart() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Instrumentation
    public void setAutomaticPerformanceSnapshots() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.setAutomaticPerformanceSnapshots();
        } else {
            super.setAutomaticPerformanceSnapshots();
        }
    }

    @Override // android.app.Instrumentation
    public void start() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.start();
        } else {
            super.start();
        }
    }

    @Override // android.app.Instrumentation
    public void startAllocCounting() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.startAllocCounting();
        } else {
            super.startAllocCounting();
        }
    }

    @Override // android.app.Instrumentation
    public void startPerformanceSnapshot() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.startPerformanceSnapshot();
        } else {
            super.startPerformanceSnapshot();
        }
    }

    @Override // android.app.Instrumentation
    public void startProfiling() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.startProfiling();
        } else {
            super.startProfiling();
        }
    }

    @Override // android.app.Instrumentation
    public void stopAllocCounting() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.stopAllocCounting();
        } else {
            super.stopAllocCounting();
        }
    }

    @Override // android.app.Instrumentation
    public void stopProfiling() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.stopProfiling();
        } else {
            super.stopProfiling();
        }
    }

    @Override // android.app.Instrumentation
    public void waitForIdleSync() {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.waitForIdleSync();
        } else {
            super.waitForIdleSync();
        }
    }

    @Override // com.tencent.tinker.lib.hook.OnHookInstall
    public void onHookInstall() {
        try {
            Object currentActivityThread = ATUtils.currentActivityThread();
            Instrumentation instrumentation = (Instrumentation) FieldUtils.readField(currentActivityThread, "mInstrumentation");
            if (!(instrumentation instanceof MuteInstrumentation)) {
                this.mOrigin = instrumentation;
                FieldUtils.writeField(currentActivityThread, "mInstrumentation", this);
                MuteLog.w("Mute.Inst", "onHookInstall hook success!!", new Object[0]);
            }
        } catch (Exception e) {
            MuteLog.e("Mute.Inst", "onHookInstall failed. %s", e);
        }
    }

    private Intent getLaunchMainIntent() {
        String packageName = Muter.getAppContext().getPackageName();
        PackageManager packageManager = Muter.getAppContext().getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageName);
        List com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities = com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities(packageManager, intent, 0);
        if (com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities == null || com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities.isEmpty()) {
            MuteLog.w("Mute.Inst", "getLaunchMainIntent CATEGORY_LAUNCHER --> CATEGORY_INFO", new Object[0]);
            intent.removeCategory("android.intent.category.LAUNCHER");
            intent.addCategory("android.intent.category.INFO");
            com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities = com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities(packageManager, intent, 0);
        }
        if (com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities != null && !com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities.isEmpty() && ((ResolveInfo) com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities.get(0)).activityInfo != null) {
            intent.setComponent(new ComponentName(packageName, ((ResolveInfo) com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities.get(0)).activityInfo.name));
        }
        intent.setFlags(268468224);
        MuteLog.i("Mute.Inst", "getLaunchMainIntent %s", intent);
        return intent;
    }

    @Override // android.app.Instrumentation
    public TestLooperManager acquireLooperManager(Looper looper) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.acquireLooperManager(looper);
        }
        return super.acquireLooperManager(looper);
    }

    @Override // android.app.Instrumentation
    public void addResults(Bundle bundle) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.addResults(bundle);
        } else {
            super.addResults(bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnPause(Activity activity) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnPause(activity);
        } else {
            super.callActivityOnPause(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestart(Activity activity) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnRestart(activity);
        } else {
            super.callActivityOnRestart(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnResume(Activity activity) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnResume(activity);
        } else {
            super.callActivityOnResume(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStart(Activity activity) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnStart(activity);
        } else {
            super.callActivityOnStart(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStop(Activity activity) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnStop(activity);
        } else {
            super.callActivityOnStop(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnUserLeaving(Activity activity) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnUserLeaving(activity);
        } else {
            super.callActivityOnUserLeaving(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void onCreate(Bundle bundle) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.onCreate(bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void removeMonitor(Instrumentation.ActivityMonitor activityMonitor) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.removeMonitor(activityMonitor);
        } else {
            super.removeMonitor(activityMonitor);
        }
    }

    @Override // android.app.Instrumentation
    public void runOnMainSync(Runnable runnable) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.runOnMainSync(runnable);
        } else {
            super.runOnMainSync(runnable);
        }
    }

    @Override // android.app.Instrumentation
    public void sendCharacterSync(int i) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.sendCharacterSync(i);
        } else {
            super.sendCharacterSync(i);
        }
    }

    @Override // android.app.Instrumentation
    public void sendKeyDownUpSync(int i) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.sendKeyDownUpSync(i);
        } else {
            super.sendKeyDownUpSync(i);
        }
    }

    @Override // android.app.Instrumentation
    public void sendKeySync(KeyEvent keyEvent) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.sendKeySync(keyEvent);
        } else {
            super.sendKeySync(keyEvent);
        }
    }

    @Override // android.app.Instrumentation
    public void sendPointerSync(MotionEvent motionEvent) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.sendPointerSync(motionEvent);
        } else {
            super.sendPointerSync(motionEvent);
        }
    }

    @Override // android.app.Instrumentation
    public void sendStringSync(String str) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.sendStringSync(str);
        } else {
            super.sendStringSync(str);
        }
    }

    @Override // android.app.Instrumentation
    public void sendTrackballEventSync(MotionEvent motionEvent) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.sendTrackballEventSync(motionEvent);
        } else {
            super.sendTrackballEventSync(motionEvent);
        }
    }

    @Override // android.app.Instrumentation
    public void setInTouchMode(boolean z) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.setInTouchMode(z);
        } else {
            super.setInTouchMode(z);
        }
    }

    @Override // android.app.Instrumentation
    public Activity startActivitySync(Intent intent) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.startActivitySync(intent);
        }
        return super.startActivitySync(intent);
    }

    @Override // android.app.Instrumentation
    public void waitForIdle(Runnable runnable) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.waitForIdle(runnable);
        } else {
            super.waitForIdle(runnable);
        }
    }

    @Override // android.app.Instrumentation
    public Activity waitForMonitor(Instrumentation.ActivityMonitor activityMonitor) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.waitForMonitor(activityMonitor);
        }
        return super.waitForMonitor(activityMonitor);
    }

    @Override // android.app.Instrumentation
    public UiAutomation getUiAutomation(int i) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.getUiAutomation(i);
        }
        return super.getUiAutomation(i);
    }

    private void ensureSavedStateCLLegal(Bundle bundle) {
        if (bundle != null) {
            ClassLoader classLoader = MuteMaxLoader.class.getClassLoader();
            if (bundle.getClassLoader() != classLoader) {
                bundle.setClassLoader(classLoader);
            }
            Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
            if (bundle2 != null && bundle2.getClassLoader() != classLoader) {
                bundle2.setClassLoader(classLoader);
            }
            MuteLog.i("Mute.Inst", "ensureSavedStateCLLegal", new Object[0]);
        }
    }

    @Override // android.app.Instrumentation
    public void addMonitor(Instrumentation.ActivityMonitor activityMonitor) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.addMonitor(activityMonitor);
        } else {
            super.addMonitor(activityMonitor);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnDestroy(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            MuteLog.i("Mute.Inst", "callActivityOnDestroy %s", activity);
            ActivityInfo activityInfo = (ActivityInfo) intent.getParcelableExtra("mute_target_activity_info");
            ActivityInfo activityInfo2 = (ActivityInfo) intent.getParcelableExtra("mute_stub_activity_info");
            if (activityInfo != null && activityInfo2 != null) {
                PatchActivityManager.activityDestroy(activityInfo2, activityInfo);
            }
        }
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnDestroy(activity);
        } else {
            super.callActivityOnDestroy(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callApplicationOnCreate(Application application) {
        MuteLog.i("Mute.Inst", "callApplicationOnCreate [%s]", application);
        PatchActivityManager.applicationCreated(application.getApplicationInfo(), ProcessUtil.getProcName(application), Process.myPid(), this.mAppThread);
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callApplicationOnCreate(application);
        } else {
            super.callApplicationOnCreate(application);
        }
    }

    private void createProcessRecord(Activity activity) {
        ActivityInfo activityInfo;
        Intent intent = activity.getIntent();
        if (intent != null) {
            ActivityInfo activityInfo2 = null;
            try {
                activityInfo = (ActivityInfo) intent.getParcelableExtra("mute_target_activity_info");
                try {
                    activityInfo2 = (ActivityInfo) intent.getParcelableExtra("mute_stub_activity_info");
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof BadParcelableException) {
                        try {
                            FieldUtils.writeField(FieldUtils.readField(intent, "mExtras"), "mParcelledData", (Object) null);
                        } catch (Throwable unused) {
                            intent.replaceExtras(new Bundle());
                        }
                    } else {
                        intent.replaceExtras(new Bundle());
                    }
                    if (activityInfo == null) {
                    } else {
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                activityInfo = null;
            }
            if (activityInfo == null && activityInfo2 != null) {
                MuteLog.i("Mute.Inst", "createProcessRecord %s", activity);
                PatchActivityManager.activityCreated(activityInfo2, activityInfo);
            }
        }
    }

    @Override // android.app.Instrumentation
    public boolean checkMonitorHit(Instrumentation.ActivityMonitor activityMonitor, int i) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.checkMonitorHit(activityMonitor, i);
        }
        return super.checkMonitorHit(activityMonitor, i);
    }

    @Override // android.app.Instrumentation
    public void finish(int i, Bundle bundle) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.finish(i, bundle);
        } else {
            super.finish(i, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void sendStatus(int i, Bundle bundle) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.sendStatus(i, bundle);
        } else {
            super.sendStatus(i, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public Activity waitForMonitorWithTimeout(Instrumentation.ActivityMonitor activityMonitor, long j) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.waitForMonitorWithTimeout(activityMonitor, j);
        }
        return super.waitForMonitorWithTimeout(activityMonitor, j);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        MuteLog.i("Mute.Inst", "callActivityOnNewIntent [%s] %s", activity, intent);
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnNewIntent(activity, intent);
        } else {
            super.callActivityOnNewIntent(activity, intent);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
        MuteLog.i("Mute.Inst", "callActivityOnRestoreInstanceState1 [%s] %s", activity, bundle);
        ensureSavedStateCLLegal(bundle);
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnRestoreInstanceState(activity, bundle);
        } else {
            super.callActivityOnRestoreInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
        MuteLog.i("Mute.Inst", "callActivityOnSaveInstanceState %s %s", activity, bundle);
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnSaveInstanceState(activity, bundle);
        } else {
            super.callActivityOnSaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public Activity startActivitySync(Intent intent, Bundle bundle) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.startActivitySync(intent, bundle);
        }
        return super.startActivitySync(intent, bundle);
    }

    private ClassNotFoundException getActivityClassNotFoundException(ClassLoader classLoader, ClassNotFoundException classNotFoundException) {
        return new ClassNotFoundException("\nclassLoader.parent = " + classLoader.getParent() + "\n", classNotFoundException);
    }

    private void handleException(Intent intent, Exception exc) {
        boolean z = false;
        MuteLog.e("Mute.Inst", "handleException1 [%s] %s", intent, exc);
        if (exc instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) exc).getTargetException();
            if (targetException instanceof SecurityException) {
                throw ((SecurityException) targetException);
            }
        }
        if (intent != null) {
            z = intent.getBooleanExtra("start_origin_no_patch", false);
        }
        if (!z) {
        } else {
            throw new RuntimeException(exc);
        }
    }

    private Intent[] wrapIntents(Activity activity, Intent[] intentArr) {
        MuteLog.i("Mute.Inst", "wrapIntents activity[%s]", activity);
        Intent[] intentArr2 = new Intent[intentArr.length];
        for (int i = 0; i < intentArr.length; i++) {
            intentArr2[i] = wrapIntent(activity, new Intent(intentArr[i]), 0);
        }
        return intentArr2;
    }

    private boolean breakFirstRestoreActivity(Activity activity, Bundle bundle) {
        if (activity != null && bundle != null && MuteMaxLoader.sIsFirstMuteStart) {
            try {
                Intent launchMainIntent = getLaunchMainIntent();
                ComponentName component = launchMainIntent.getComponent();
                ComponentName componentName = activity.getComponentName();
                if (component != null && componentName != null && !component.equals(componentName)) {
                    MuteLog.w("Mute.Inst", "breakFirstRestoreActivity start MainActivity", new Object[0]);
                    activity.overridePendingTransition(0, 0);
                    activity.finish();
                    Muter.getAppContext().startActivity(launchMainIntent);
                    return true;
                }
                MuteLog.i("Mute.Inst", "breakFirstRestoreActivity skip %s", componentName);
            } catch (Throwable th) {
                MuteLog.e("Mute.Inst", "breakFirstRestoreActivity failed. %s", th);
            }
        }
        return false;
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object obj, Throwable th) {
        MuteLog.e("Mute.Inst", "onException [%s] %s", obj, th);
        if (ProcessUtil.isPluginProcess(Muter.getAppContext()) && (obj instanceof Activity) && th.toString().contains("ClassCastException")) {
            MuteLog.e("Mute.Inst", "onException ClassCastException && pluginProc then finish exit. %s", th);
            ((Activity) obj).finish();
            Process.killProcess(Process.myPid());
            System.exit(1);
            return true;
        }
        if (th != null && (th instanceof UndeclaredThrowableException)) {
            MuteLog.e("Mute.Inst", "onException UndeclaredThrowableException return true. %s", th);
            return true;
        }
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.onException(obj, th);
        }
        return super.onException(obj, th);
    }

    private void handleException(Activity activity, RuntimeException runtimeException) {
        String str;
        String runtimeException2 = runtimeException.toString();
        MuteLog.e("Mute.Inst", "handleException2 [%s] %s", activity, runtimeException2);
        if (runtimeException2.contains("NameNotFoundException")) {
            if (ProcessUtil.isMainProcess(Muter.getAppContext())) {
                try {
                    Object readField = FieldUtils.readField(ATUtils.currentActivityThread(), "sPackageManager");
                    PackageManager packageManager = activity.getPackageManager();
                    throw new RuntimeException("WTF: " + ("currentActivityThread sPackageManager = " + readField + " activity packageManager = " + packageManager + " sPackageManager mPM = " + FieldUtils.readField(readField, "mPM") + " activity mPM=" + FieldUtils.readField(packageManager, "mPM") + " pmProxy = " + PackageManagerProxy.pmProxy + " activityInfo = " + PatchPackageManager.getActivityInfo(activity.getComponentName(), 128)), runtimeException);
                } catch (Exception e) {
                    throw new RuntimeException("WTF CATCH: " + e.getMessage(), runtimeException);
                }
            }
            throw new RuntimeException("WTF: " + runtimeException.getMessage(), runtimeException);
        }
        if (runtimeException2.contains("You need to use a Theme.AppCompat theme")) {
            try {
                str = String.format("themeId:0x%x themeResources:0x%x", FieldUtils.readField(activity, "mThemeId"), FieldUtils.readField(activity, "mThemeResource"));
            } catch (Exception unused) {
                str = "";
            }
            throw new RuntimeException(str, runtimeException);
        }
        throw runtimeException;
    }

    private void updateActivityParams(Activity activity, ApplicationInfo applicationInfo) {
        ActivityInfo activityInfo;
        boolean z;
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        try {
            activityInfo = (ActivityInfo) intent.getParcelableExtra("mute_stub_activity_info");
        } catch (Throwable th) {
            MuteLog.e("Mute.Inst", "updateActivityParams failed. %s", th);
            activityInfo = null;
        }
        String name = activity.getClass().getName();
        if (activityInfo != null && PatchActivityManager.isStubActivity(activityInfo)) {
            z = true;
        } else {
            z = false;
        }
        boolean isActivityModify = PatchPackageManager.isActivityModify(name);
        if (!z && !isActivityModify) {
            ActivityInfo activityInfo2 = PatchPackageManager.getActivityInfo(name, 1);
            if (MuteReplacer.sThemeChanged && activityInfo2 != null && activityInfo2.theme == 0) {
                int themeResource = activityInfo2.getThemeResource();
                MuteLog.w("Mute.Inst", "updateActivityTheme ai.theme=0 && app.theme[0x%s] changed", Integer.toHexString(themeResource));
                MuteResReplacer.updateActivityTheme(activity, themeResource);
                return;
            }
            return;
        }
        ActivityInfo activityInfo3 = PatchPackageManager.getActivityInfo(name, 1);
        if (activityInfo3 != null) {
            if (activityInfo3.applicationInfo == null) {
                activityInfo3.applicationInfo = applicationInfo;
            }
            try {
                activity.setRequestedOrientation(activityInfo3.screenOrientation);
            } catch (Throwable th2) {
                MuteLog.e("Mute.Inst", "updateActivityParams setRequestedOrientation failed. %s", th2);
            }
            try {
                try {
                    ShareReflectUtil.findField(activity, "mTheme").set(activity, null);
                } catch (Throwable th3) {
                    MuteLog.e("Mute.Inst", "updateActivityParams failed. %s", th3);
                    return;
                }
            } catch (Exception e) {
                MuteLog.e("Mute.Inst", "updateActivityParams clear origin theme failed. %s", e);
            }
            activity.setTheme(activityInfo3.getThemeResource());
            FieldUtils.getField(activity.getClass(), "mActivityInfo").set(activity, activityInfo3);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|2|3|(8:7|8|9|10|11|(1:13)(1:24)|14|(1:21)(2:18|19))|28|9|10|11|(0)(0)|14|(2:16|21)(1:22)) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        handleException(r7, r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061 A[Catch: RuntimeException -> 0x0069, TryCatch #1 {RuntimeException -> 0x0069, blocks: (B:11:0x005d, B:13:0x0061, B:24:0x0065), top: B:10:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[Catch: RuntimeException -> 0x0069, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x0069, blocks: (B:11:0x005d, B:13:0x0061, B:24:0x0065), top: B:10:0x005d }] */
    @Override // android.app.Instrumentation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callActivityOnCreate(android.app.Activity r7, android.os.Bundle r8) {
        /*
            r6 = this;
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r7
            r2 = 1
            r0[r2] = r8
            java.lang.String r3 = "Mute.Inst"
            java.lang.String r4 = "callActivityOnCreate [%s] icicle[%s]"
            com.tencent.tinker.lib.MuteLog.i(r3, r4, r0)
            android.content.pm.ApplicationInfo r0 = r7.getApplicationInfo()
            android.content.Context r4 = com.tencent.tinker.lib.Muter.getAppContext()
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r5 = r0.packageName     // Catch: java.lang.Exception -> L48
            boolean r4 = android.text.TextUtils.equals(r4, r5)     // Catch: java.lang.Exception -> L48
            if (r4 == 0) goto L52
            android.content.res.AssetManager r4 = r7.getAssets()     // Catch: java.lang.Exception -> L48
            java.io.File r5 = com.tencent.tinker.lib.MuteMaxLoader.mPatchSource     // Catch: java.lang.Exception -> L48
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Exception -> L48
            boolean r4 = com.tencent.tinker.lib.utils.ResUtils.assetsContainsPath(r4, r5)     // Catch: java.lang.Exception -> L48
            if (r4 != 0) goto L52
            java.lang.String r4 = "callActivityOnCreate activity res need to update !!!"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L48
            com.tencent.tinker.lib.MuteLog.w(r3, r4, r5)     // Catch: java.lang.Exception -> L48
            java.io.File r4 = com.tencent.tinker.lib.MuteMaxLoader.mPatchSource     // Catch: java.lang.Exception -> L48
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.lang.Exception -> L48
            r0.sourceDir = r4     // Catch: java.lang.Exception -> L48
            com.tencent.tinker.lib.MuteResReplacer.replaceActivityRes(r7, r1)     // Catch: java.lang.Exception -> L48
            r4 = 1
            goto L53
        L48:
            r4 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r4
            java.lang.String r4 = "callActivityOnCreate updateActivityRes failed. %s"
            com.tencent.tinker.lib.MuteLog.e(r3, r4, r5)
        L52:
            r4 = 0
        L53:
            android.content.res.AssetManager r5 = r7.getAssets()
            r6.createProcessRecord(r7)
            r6.updateActivityParams(r7, r0)
            android.app.Instrumentation r0 = r6.mOrigin     // Catch: java.lang.RuntimeException -> L69
            if (r0 == 0) goto L65
            r0.callActivityOnCreate(r7, r8)     // Catch: java.lang.RuntimeException -> L69
            goto L6d
        L65:
            super.callActivityOnCreate(r7, r8)     // Catch: java.lang.RuntimeException -> L69
            goto L6d
        L69:
            r8 = move-exception
            r6.handleException(r7, r8)
        L6d:
            if (r4 == 0) goto L81
            android.content.res.AssetManager r8 = com.tencent.tinker.lib.MuteResReplacer.sMuteAssetMgr
            boolean r8 = com.tencent.tinker.lib.utils.ResUtils.assetsEquals(r5, r8)
            if (r8 != 0) goto L81
            java.lang.String r8 = "callActivityOnCreate activity res need to update again"
            java.lang.Object[] r0 = new java.lang.Object[r1]
            com.tencent.tinker.lib.MuteLog.w(r3, r8, r0)
            com.tencent.tinker.lib.MuteResReplacer.replaceActivityRes(r7, r2)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.MuteInstrumentation.callActivityOnCreate(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Instrumentation
    public Instrumentation.ActivityMonitor addMonitor(IntentFilter intentFilter, Instrumentation.ActivityResult activityResult, boolean z) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.addMonitor(intentFilter, activityResult, z);
        }
        return super.addMonitor(intentFilter, activityResult, z);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnPostCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnPostCreate(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnPostCreate(activity, bundle, persistableBundle);
        }
    }

    @Override // android.app.Instrumentation
    public boolean invokeContextMenuAction(Activity activity, int i, int i2) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.invokeContextMenuAction(activity, i, i2);
        }
        return super.invokeContextMenuAction(activity, i, i2);
    }

    @Override // android.app.Instrumentation
    public boolean invokeMenuActionSync(Activity activity, int i, int i2) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.invokeMenuActionSync(activity, i, i2);
        }
        return super.invokeMenuActionSync(activity, i, i2);
    }

    @Override // android.app.Instrumentation
    public Application newApplication(ClassLoader classLoader, String str, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.newApplication(classLoader, str, context);
        }
        return super.newApplication(classLoader, str, context);
    }

    @Override // android.app.Instrumentation
    public Instrumentation.ActivityMonitor addMonitor(String str, Instrumentation.ActivityResult activityResult, boolean z) {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.addMonitor(str, activityResult, z);
        }
        return super.addMonitor(str, activityResult, z);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        MuteLog.i("Mute.Inst", "callActivityOnRestoreInstanceState2 %s %s %s", activity, bundle, persistableBundle);
        ensureSavedStateCLLegal(bundle);
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        MuteLog.i("Mute.Inst", "callActivityOnSaveInstanceState [%s] %s %s", activity, bundle, persistableBundle);
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            instrumentation.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
        }
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassLoader classLoader2 = MuteMaxLoader.class.getClassLoader();
        if (OSUtil.isAndroidPHigher()) {
            try {
                return (Activity) classLoader2.loadClass(str).newInstance();
            } catch (ClassNotFoundException e) {
                throw getActivityClassNotFoundException(classLoader2, e);
            }
        }
        try {
            Instrumentation instrumentation = this.mOrigin;
            if (instrumentation != null) {
                return instrumentation.newActivity(classLoader2, str, intent);
            }
            return super.newActivity(classLoader2, str, intent);
        } catch (ClassNotFoundException e2) {
            throw getActivityClassNotFoundException(classLoader2, e2);
        }
    }

    private Intent wrapIntent(Object obj, Intent intent, int i) {
        String str;
        MuteLog.i("Mute.Inst", "wrapIntent target[%s] intent[%s] reqCode[%d]", obj, intent, Integer.valueOf(i));
        List com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities = com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities(Muter.getAppContext().getPackageManager(), intent, 33619968);
        if (com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities != null && com_tencent_tinker_lib_hook_MuteInstrumentation_android_content_pm_PackageManager_queryIntentActivities.size() > 0) {
            MuteLog.i("Mute.Inst", "wrapIntent declare in host Manifest", new Object[0]);
            return intent;
        }
        intent.putExtra("hasWrap", true);
        if (!intent.getBooleanExtra("start_origin_no_patch", false)) {
            List<ResolveInfo> queryIntentActivities = PatchPackageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
                if (activityInfo != null) {
                    ActivityInfo selectStubActivity = PatchActivityManager.selectStubActivity(activityInfo);
                    if (selectStubActivity != null) {
                        intent.putExtra("mute_target_activity_info", activityInfo);
                        intent.putExtra("mute_stub_activity_info", selectStubActivity);
                        Intent intent2 = new Intent();
                        intent2.setClassName(selectStubActivity.packageName, selectStubActivity.name);
                        intent2.setFlags(intent.getFlags());
                        intent2.putExtra("mute_target_intent", intent);
                        intent2.putExtra("mute_target_activity_info", activityInfo);
                        intent2.putExtra("mute_stub_activity_info", selectStubActivity);
                        ApplicationInfo applicationInfo = selectStubActivity.applicationInfo;
                        if (applicationInfo != null) {
                            str = applicationInfo.processName;
                        } else {
                            str = "";
                        }
                        intent2.putExtra("mute_stub_create_info", System.currentTimeMillis() + "#" + Process.myPid() + "#" + Muter.getAppContext().getApplicationInfo().processName + "#" + str);
                        intent2.putExtra("hasWrap", true);
                        MuteLog.w("Mute.Inst", "wrapIntent Target[%s] >>> Stub[%s]", activityInfo.name, selectStubActivity.name);
                        return intent2;
                    }
                    MuteLog.w("Mute.Inst", "wrapIntent no stub activity to use", new Object[0]);
                    return intent;
                }
                return intent;
            }
            MuteLog.w("Mute.Inst", "wrapIntent query patch empty, %s", intent.getComponent());
            return intent;
        }
        return intent;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|2|3|(8:7|8|9|10|11|(1:13)(1:24)|14|(1:21)(2:18|19))|28|9|10|11|(0)(0)|14|(2:16|21)(1:22)) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        handleException(r7, r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064 A[Catch: RuntimeException -> 0x006c, TryCatch #1 {RuntimeException -> 0x006c, blocks: (B:11:0x0060, B:13:0x0064, B:24:0x0068), top: B:10:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068 A[Catch: RuntimeException -> 0x006c, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x006c, blocks: (B:11:0x0060, B:13:0x0064, B:24:0x0068), top: B:10:0x0060 }] */
    @Override // android.app.Instrumentation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callActivityOnCreate(android.app.Activity r7, android.os.Bundle r8, android.os.PersistableBundle r9) {
        /*
            r6 = this;
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r7
            r2 = 1
            r0[r2] = r8
            r3 = 2
            r0[r3] = r9
            java.lang.String r3 = "Mute.Inst"
            java.lang.String r4 = "callActivityOnCreate2 [%s] icicle[%s] ps[%s]"
            com.tencent.tinker.lib.MuteLog.i(r3, r4, r0)
            android.content.pm.ApplicationInfo r0 = r7.getApplicationInfo()
            android.content.Context r4 = com.tencent.tinker.lib.Muter.getAppContext()
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r5 = r0.packageName     // Catch: java.lang.Exception -> L4b
            boolean r4 = android.text.TextUtils.equals(r4, r5)     // Catch: java.lang.Exception -> L4b
            if (r4 == 0) goto L55
            android.content.res.AssetManager r4 = r7.getAssets()     // Catch: java.lang.Exception -> L4b
            java.io.File r5 = com.tencent.tinker.lib.MuteMaxLoader.mPatchSource     // Catch: java.lang.Exception -> L4b
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Exception -> L4b
            boolean r4 = com.tencent.tinker.lib.utils.ResUtils.assetsContainsPath(r4, r5)     // Catch: java.lang.Exception -> L4b
            if (r4 != 0) goto L55
            java.lang.String r4 = "callActivityOnCreate2 activity res need to update !!!"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L4b
            com.tencent.tinker.lib.MuteLog.w(r3, r4, r5)     // Catch: java.lang.Exception -> L4b
            java.io.File r4 = com.tencent.tinker.lib.MuteMaxLoader.mPatchSource     // Catch: java.lang.Exception -> L4b
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.lang.Exception -> L4b
            r0.sourceDir = r4     // Catch: java.lang.Exception -> L4b
            com.tencent.tinker.lib.MuteResReplacer.replaceActivityRes(r7, r1)     // Catch: java.lang.Exception -> L4b
            r4 = 1
            goto L56
        L4b:
            r4 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r4
            java.lang.String r4 = "callActivityOnCreate2 updateActivityRes failed. %s"
            com.tencent.tinker.lib.MuteLog.e(r3, r4, r5)
        L55:
            r4 = 0
        L56:
            android.content.res.AssetManager r5 = r7.getAssets()
            r6.createProcessRecord(r7)
            r6.updateActivityParams(r7, r0)
            android.app.Instrumentation r0 = r6.mOrigin     // Catch: java.lang.RuntimeException -> L6c
            if (r0 == 0) goto L68
            r0.callActivityOnCreate(r7, r8, r9)     // Catch: java.lang.RuntimeException -> L6c
            goto L70
        L68:
            super.callActivityOnCreate(r7, r8, r9)     // Catch: java.lang.RuntimeException -> L6c
            goto L70
        L6c:
            r8 = move-exception
            r6.handleException(r7, r8)
        L70:
            if (r4 == 0) goto L84
            android.content.res.AssetManager r8 = com.tencent.tinker.lib.MuteResReplacer.sMuteAssetMgr
            boolean r8 = com.tencent.tinker.lib.utils.ResUtils.assetsEquals(r5, r8)
            if (r8 != 0) goto L84
            java.lang.String r8 = "callActivityOnCreate2 activity res need to update again"
            java.lang.Object[] r9 = new java.lang.Object[r1]
            com.tencent.tinker.lib.MuteLog.w(r3, r8, r9)
            com.tencent.tinker.lib.MuteResReplacer.replaceActivityRes(r7, r2)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.MuteInstrumentation.callActivityOnCreate(android.app.Activity, android.os.Bundle, android.os.PersistableBundle):void");
    }

    public void execStartActivities(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent[] intentArr, Bundle bundle) {
        Intent intent;
        Intent[] wrapIntents = wrapIntents(activity, intentArr);
        try {
            MethodUtils.invokeMethod(this.mOrigin, "execStartActivities", new Object[]{context, iBinder, iBinder2, activity, wrapIntents, bundle}, new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent[].class, Bundle.class});
        } catch (Exception e) {
            if (wrapIntents.length > 0) {
                intent = wrapIntents[0];
            } else {
                intent = null;
            }
            handleException(intent, e);
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i) {
        Intent wrapIntent = wrapIntent(activity, intent, i);
        try {
            MethodUtils.invokeMethod(this.mOrigin, "execStartActivity", new Object[]{context, iBinder, iBinder2, activity, wrapIntent, Integer.valueOf(i)}, new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE});
            return null;
        } catch (Exception e) {
            handleException(wrapIntent, e);
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Fragment fragment, Intent intent, int i) {
        Intent wrapIntent = wrapIntent(fragment, intent, i);
        try {
            MethodUtils.invokeMethod(this.mOrigin, "execStartActivity", new Object[]{context, iBinder, iBinder2, fragment, wrapIntent, Integer.valueOf(i)}, new Class[]{Context.class, IBinder.class, IBinder.class, Fragment.class, Intent.class, Integer.TYPE});
            return null;
        } catch (Exception e) {
            handleException(wrapIntent, e);
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        Intent wrapIntent = wrapIntent(activity, intent, i);
        try {
            MethodUtils.invokeMethod(this.mOrigin, "execStartActivity", new Object[]{context, iBinder, iBinder2, activity, wrapIntent, Integer.valueOf(i), bundle}, new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class});
            return null;
        } catch (Exception e) {
            handleException(wrapIntent, e);
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Fragment fragment, Intent intent, int i, Bundle bundle) {
        Intent wrapIntent = wrapIntent(fragment, intent, i);
        try {
            MethodUtils.invokeMethod(this.mOrigin, "execStartActivity", new Object[]{context, iBinder, iBinder2, fragment, wrapIntent, Integer.valueOf(i), bundle}, new Class[]{Context.class, IBinder.class, IBinder.class, Fragment.class, Intent.class, Integer.TYPE, Bundle.class});
            return null;
        } catch (Exception e) {
            handleException(wrapIntent, e);
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, String str, Intent intent, int i, Bundle bundle) {
        Intent wrapIntent = wrapIntent(str, intent, i);
        try {
            MethodUtils.invokeMethod(this.mOrigin, "execStartActivity", new Object[]{context, iBinder, iBinder2, str, wrapIntent, Integer.valueOf(i), bundle}, new Class[]{Context.class, IBinder.class, IBinder.class, String.class, Intent.class, Integer.TYPE, Bundle.class});
            return null;
        } catch (Exception e) {
            handleException(wrapIntent, e);
            return null;
        }
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) throws IllegalAccessException, InstantiationException {
        Instrumentation instrumentation = this.mOrigin;
        if (instrumentation != null) {
            return instrumentation.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
        }
        return super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }
}
