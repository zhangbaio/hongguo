package com.tencent.tinker.lib.hook;

import android.app.servertransaction.ActivityLifecycleItem;
import android.app.servertransaction.ActivityRelaunchItem;
import android.app.servertransaction.ClientTransaction;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.LaunchActivityItem;
import android.app.servertransaction.PauseActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageParser;
import android.content.pm.ServiceInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteMaxLoader;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.am.PatchActivityManager;
import com.tencent.tinker.lib.crash.MuteRestoreHelper;
import com.tencent.tinker.lib.hidden.p.HackHelper;
import com.tencent.tinker.lib.hidden.q.DoubleReflector;
import com.tencent.tinker.lib.utils.ATUtils;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteHandlerCallback implements Handler.Callback, OnHookInstall {
    public static Map<String, ServiceInfo> sServiceMap;
    private Handler.Callback mOrigin;
    private Map<String, ServiceInfo> mStubServiceMap = new HashMap();
    private Map<IBinder, String> mTokenStubServiceMap = new HashMap();

    private static Object com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    static {
        Covode.recordClassIndex(653760);
        sServiceMap = new HashMap();
    }

    private void handleSamsungResource() {
        if (OSUtil.isSamsung()) {
            try {
                FieldUtils.writeStaticField(Resources.class, "sIsAppLaunching", Boolean.FALSE);
                MuteLog.w("Mute.H", "handleSamsungResource Resources.sIsAppLaunching = false", new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.tencent.tinker.lib.hook.OnHookInstall
    public void onHookInstall() {
        try {
            Handler handler = (Handler) FieldUtils.readField(ATUtils.currentActivityThread(), "mH");
            Handler.Callback callback = (Handler.Callback) FieldUtils.readField(handler, "mCallback");
            if (!(callback instanceof MuteHandlerCallback)) {
                this.mOrigin = callback;
                FieldUtils.writeField(handler, "mCallback", this);
                MuteLog.w("Mute.H", "onHookInstall hook success!!", new Object[0]);
            }
        } catch (Exception e) {
            MuteLog.e("Mute.H", "onHookInstall failed. %s", e);
        }
    }

    private void handleReceiver(Object obj) {
        try {
            ActivityInfo activityInfo = (ActivityInfo) FieldUtils.readField(obj, "info");
            if (activityInfo != null) {
                setApplicationInfo(activityInfo.applicationInfo);
            }
        } catch (Exception e) {
            MuteLog.e("Mute.H", "handleReceiver failed. %s", e);
        }
    }

    private void handleCreateService(Object obj) {
        ServiceInfo targetService;
        try {
            ServiceInfo serviceInfo = (ServiceInfo) FieldUtils.readField(obj, "info");
            MuteLog.i("Mute.H", "handleCreateService info %s", serviceInfo);
            if (serviceInfo != null) {
                setApplicationInfo(serviceInfo.applicationInfo);
            }
            IBinder iBinder = (IBinder) FieldUtils.readField(obj, "token");
            if (serviceInfo != null && PatchActivityManager.isStubService(serviceInfo) && (targetService = PatchActivityManager.getTargetService(serviceInfo)) != null) {
                MuteLog.w("Mute.H", "handleCreateService Target[%s] <<< Stub[%s]", targetService.name, serviceInfo.name);
                if (!sServiceMap.containsKey(serviceInfo.name)) {
                    sServiceMap.put(serviceInfo.name, targetService);
                }
                if (!this.mStubServiceMap.containsKey(serviceInfo.name)) {
                    this.mStubServiceMap.put(serviceInfo.name, new ServiceInfo(serviceInfo));
                }
                this.mTokenStubServiceMap.put(iBinder, serviceInfo.name);
                serviceInfo.name = targetService.name;
            }
        } catch (Exception e) {
            MuteLog.e("Mute.H", "handleCreateService failed. %s", e);
        }
    }

    private void handleStopService(Object obj) {
        MuteLog.i("Mute.H", "handleStopService token %s", obj);
        if (obj instanceof IBinder) {
            IBinder iBinder = (IBinder) obj;
            if (this.mTokenStubServiceMap.containsKey(iBinder)) {
                String str = this.mTokenStubServiceMap.get(iBinder);
                ServiceInfo serviceInfo = sServiceMap.get(str);
                ServiceInfo serviceInfo2 = this.mStubServiceMap.get(str);
                if (serviceInfo2 != null && serviceInfo != null) {
                    PatchActivityManager.serviceDestroy(serviceInfo2, serviceInfo);
                } else {
                    MuteLog.e("Mute.H", "handleStopService stub-target is null. %s", str);
                }
                sServiceMap.remove(str);
                this.mStubServiceMap.remove(str);
                this.mTokenStubServiceMap.remove(iBinder);
                MuteLog.i("Mute.H", "handleStopService clear map, %s <<>> %s", serviceInfo, serviceInfo2);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 100) {
            MuteRestoreHelper.getInstance().handleRestoreActivityProtectWhenFirstInstall(message);
            return handleLaunchPluginActivity(message);
        }
        if (i == 159) {
            if (message.obj instanceof ClientTransaction) {
                MuteRestoreHelper.getInstance().handleRestoreActivityProtectWhenFirstInstall((ClientTransaction) message.obj);
                handleSamsungResource();
                handleExecuteTransaction((ClientTransaction) message.obj);
            }
        } else if (i == 114) {
            Object obj = message.obj;
            if (obj != null) {
                handleCreateService(obj);
            }
        } else if (i == 116) {
            handleStopService(message.obj);
        } else if (i == 113) {
            Object obj2 = message.obj;
            if (obj2 != null) {
                handleReceiver(obj2);
            }
        } else if (i == 134) {
            return true;
        }
        Handler.Callback callback = this.mOrigin;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }

    private boolean handleLaunchPluginActivity(Message message) {
        Intent intent;
        Object obj;
        Intent intent2;
        ActivityInfo activityInfo;
        ActivityInfo activityInfo2;
        ActivityInfo activityInfo3;
        try {
            obj = message.obj;
            intent = (Intent) FieldUtils.readField(obj, "intent");
        } catch (Exception e) {
            e = e;
            intent = null;
        }
        try {
            intent.setExtrasClassLoader(Muter.getAppContext().getClassLoader());
            intent2 = (Intent) intent.getParcelableExtra("mute_target_intent");
            activityInfo = (ActivityInfo) intent.getParcelableExtra("mute_target_activity_info");
            activityInfo2 = (ActivityInfo) intent.getParcelableExtra("mute_stub_activity_info");
            activityInfo3 = (ActivityInfo) FieldUtils.readField(obj, "activityInfo");
            if (activityInfo3 != null) {
                setApplicationInfo(activityInfo3.applicationInfo);
            }
        } catch (Exception e2) {
            e = e2;
            MuteLog.e("Mute.H", "handleLaunchPluginActivity failed. %s", e);
            if (intent != null && (e instanceof BadParcelableException)) {
                try {
                    FieldUtils.writeField(FieldUtils.readField(intent, "mExtras"), "mParcelledData", (Object) null);
                    MuteLog.i("Mute.H", "handleLaunchPluginActivity stubIntent.mExtras.mParcelledData = null", new Object[0]);
                } catch (Throwable th) {
                    MuteLog.w("Mute.H", "handleLaunchPluginActivity stubIntent.mExtras.mParcelledData = null failed. %s", th);
                    intent.replaceExtras(new Bundle());
                }
            }
            return false;
        }
        if (activityInfo2 != null && activityInfo3 != null && !activityInfo2.exported && !activityInfo3.exported && TextUtils.equals(activityInfo2.packageName, activityInfo3.packageName) && TextUtils.equals(activityInfo2.name, activityInfo3.name)) {
            if (intent2 != null && activityInfo != null) {
                if (activityInfo.applicationInfo != null && !new PolarisFileWrapper(activityInfo.applicationInfo.sourceDir).exists()) {
                    MuteLog.w("Mute.H", "handleLaunchPluginActivity, targetActivityInfo.applicationInfo.sourceDir is not exists, %s", activityInfo.applicationInfo.sourceDir);
                    return false;
                }
                reportIfTimeout(intent);
                MuteLog.i("Mute.H", "handleLaunchPluginActivity then launchPluginApp applicationInfo[%s]", activityInfo.applicationInfo);
                intent2.setClassName(Muter.getAppContext().getPackageName(), activityInfo.name);
                FieldUtils.writeField(obj, "intent", intent2);
                FieldUtils.writeField(obj, "activityInfo", activityInfo);
                MuteLog.w("Mute.H", "handleLaunchPluginActivity Target[%s] <<< Stub[%s]", activityInfo.name, activityInfo2.name);
            }
            return false;
        }
        MuteLog.w("Mute.H", "handleLaunchPluginActivity stub/target/system not match skip!", new Object[0]);
        return false;
    }

    private void reportIfTimeout(Intent intent) {
        ApplicationInfo applicationInfo;
        try {
            String stringExtra = intent.getStringExtra("mute_stub_create_info");
            Intent intent2 = (Intent) intent.getParcelableExtra("mute_target_intent");
            ActivityInfo activityInfo = (ActivityInfo) intent.getParcelableExtra("mute_target_activity_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                String[] split = stringExtra.split("#");
                if (split.length == 3 && System.currentTimeMillis() - Long.parseLong(split[0]) > 20000) {
                    String str = "";
                    if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null) {
                        str = applicationInfo.sourceDir;
                    }
                    MuteLog.e("Mute.H", "reportIfTimeout FILTER_TYPE_START_ACTIVITY_TIMEOUT -- %s", "intent from: " + stringExtra + "\ntargetIntent: " + intent2 + "\ntargetActivityInfo: " + activityInfo + "\ntargetActivityInfo.applicationInfo.sourceDir: " + str + "\ncurrent: " + System.currentTimeMillis() + "#" + Process.myPid() + "#" + Muter.getAppContext().getApplicationInfo().processName);
                }
            }
        } catch (Exception e) {
            MuteLog.e("Mute.H", "reportIfTimeout failed. %s", e);
        }
    }

    private void setApplicationInfo(ApplicationInfo applicationInfo) {
        String str;
        if (!Muter.getAppContext().getPackageName().equals(applicationInfo.packageName)) {
            MuteLog.i("Mute.H", "setApplicationInfo not in app package, hostPackageName=" + Muter.getAppContext().getPackageName() + ", current package=" + applicationInfo.packageName, new Object[0]);
            return;
        }
        PackageParser.Package r0 = MuteMaxLoader.sPatchPkg;
        if (r0 == null) {
            MuteLog.e("Mute.H", "setApplicationInfo PackageParser.Package is null", new Object[0]);
            return;
        }
        try {
            str = (String) FieldUtils.readField(DoubleReflector.getField(r0.getClass(), "codePath"), r0);
        } catch (IllegalAccessException e) {
            MuteLog.e("Mute.H", "setApplicationInfo get codePath failed. %s", e);
            str = null;
        }
        if (str == null) {
            try {
                str = (String) FieldUtils.readField(DoubleReflector.getField(r0.getClass(), "baseCodePath"), r0);
            } catch (IllegalAccessException e2) {
                MuteLog.e("Mute.H", "setApplicationInfo get baseCodePath failed. %s", e2);
            }
        }
        if (str != null) {
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
        }
        applicationInfo.theme = r0.applicationInfo.theme;
    }

    private void handleExecuteTransaction(ClientTransaction clientTransaction) {
        try {
            Method method = HackHelper.getMethod(ClientTransaction.class, "getLifecycleStateRequest", new Class[0]);
            if (method == null) {
                MuteLog.w("Mute.H", "handleExecuteTransaction ClientTransaction.getLifecycleStateRequest() failed.", new Object[0]);
                return;
            }
            ActivityLifecycleItem activityLifecycleItem = (ActivityLifecycleItem) com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(method, clientTransaction, new Object[0]);
            updateSourceDir(clientTransaction, activityLifecycleItem);
            if (activityLifecycleItem instanceof ResumeActivityItem) {
                Method method2 = HackHelper.getMethod(ClientTransaction.class, "getCallbacks", new Class[0]);
                if (method2 == null) {
                    MuteLog.w("Mute.H", "handleExecuteTransaction ClientTransaction.getCallbacks() failed.", new Object[0]);
                    return;
                }
                List list = (List) com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(method2, clientTransaction, new Object[0]);
                if (list.size() == 0) {
                    MuteLog.w("Mute.H", "handleExecuteTransaction clientTransItems = 0", new Object[0]);
                    return;
                }
                ClientTransactionItem clientTransactionItem = (ClientTransactionItem) list.get(0);
                MuteLog.i("Mute.H", "handleExecuteTransaction %s", clientTransactionItem);
                if (clientTransactionItem instanceof LaunchActivityItem) {
                    Field field = HackHelper.getField(LaunchActivityItem.class, "mIntent");
                    Field field2 = HackHelper.getField(LaunchActivityItem.class, "mInfo");
                    if (field != null && field2 != null) {
                        ActivityInfo activityInfo = (ActivityInfo) field2.get(clientTransactionItem);
                        Intent intent = (Intent) field.get(clientTransactionItem);
                        intent.setExtrasClassLoader(Muter.getAppContext().getClassLoader());
                        intent.getComponent();
                        Intent intent2 = (Intent) intent.getParcelableExtra("mute_target_intent");
                        ActivityInfo activityInfo2 = (ActivityInfo) intent.getParcelableExtra("mute_target_activity_info");
                        ActivityInfo activityInfo3 = (ActivityInfo) intent.getParcelableExtra("mute_stub_activity_info");
                        if (activityInfo3 != null && activityInfo != null && !activityInfo3.exported && !activityInfo.exported && TextUtils.equals(activityInfo3.packageName, activityInfo.packageName) && TextUtils.equals(activityInfo3.name, activityInfo.name)) {
                            if (intent2 != null && activityInfo2 != null) {
                                if (activityInfo2.applicationInfo != null && !new PolarisFileWrapper(activityInfo2.applicationInfo.sourceDir).exists()) {
                                    MuteLog.w("Mute.H", "handleExecuteTransaction targetActivityInfo.applicationInfo.sourceDir is not exists. %s", activityInfo2.applicationInfo.sourceDir);
                                    return;
                                }
                                reportIfTimeout(intent);
                                MuteLog.i("Mute.H", "handleExecuteTransaction then launchPluginApp applicationInfo[%s]", activityInfo2.applicationInfo);
                                intent2.setClassName(Muter.getAppContext().getPackageName(), activityInfo2.name);
                                field.set(clientTransactionItem, intent2);
                                field2.set(clientTransactionItem, activityInfo2);
                                MuteLog.w("Mute.H", "handleExecuteTransaction Target[%s] <<< Stub[%s]", activityInfo2.name, activityInfo3.name);
                                if (OSUtil.isAndroidS()) {
                                    adapterForAndroidS(clientTransaction, intent2, activityInfo2, false);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        MuteLog.w("Mute.H", "handleExecuteTransaction stub/target/system not match skip!", new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            MuteLog.e("Mute.H", "handleExecuteTransaction failed. %s", th);
        }
    }

    private void updateSourceDir(ClientTransaction clientTransaction, ActivityLifecycleItem activityLifecycleItem) {
        ApplicationInfo applicationInfo;
        try {
            if ((activityLifecycleItem instanceof ResumeActivityItem) || (activityLifecycleItem instanceof PauseActivityItem)) {
                Method method = HackHelper.getMethod(ClientTransaction.class, "getCallbacks", new Class[0]);
                if (method == null) {
                    MuteLog.w("Mute.H", "updateSourceDir ClientTransaction.getCallbacks() failed.", new Object[0]);
                    return;
                }
                List list = (List) com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(method, clientTransaction, new Object[0]);
                if (list.size() == 0) {
                    MuteLog.i("Mute.H", "updateSourceDir clientTransItems = 0", new Object[0]);
                    return;
                }
                ClientTransactionItem clientTransactionItem = (ClientTransactionItem) list.get(0);
                if (clientTransactionItem instanceof LaunchActivityItem) {
                    Field field = HackHelper.getField(LaunchActivityItem.class, "mIntent");
                    Field field2 = HackHelper.getField(LaunchActivityItem.class, "mInfo");
                    if (field != null && field2 != null) {
                        setApplicationInfo(((ActivityInfo) field2.get(clientTransactionItem)).applicationInfo);
                    }
                }
                if (clientTransactionItem instanceof ActivityRelaunchItem) {
                    MuteLog.i("Mute.H", "updateSourceDir start setApplicationInfo for ActivityRelaunchItem", new Object[0]);
                    Object obj = HackHelper.getField(ActivityRelaunchItem.class, "mActivityClientRecord").get(clientTransactionItem);
                    Object com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke = com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(HackHelper.getMethod(ATUtils.currentActivityThread().getClass(), "getActivityClient", IBinder.class), ATUtils.currentActivityThread(), new Object[]{(IBinder) HackHelper.getField(obj.getClass(), "token").get(obj)});
                    ActivityInfo activityInfo = (ActivityInfo) HackHelper.getField(com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke.getClass(), "activityInfo").get(com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke);
                    if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null) {
                        setApplicationInfo(applicationInfo);
                    }
                }
            }
        } catch (Exception e) {
            MuteLog.e("Mute.H", "updateSourceDir failed. %s", e);
        }
    }

    public static void adapterForAndroidS(Object obj, Intent intent, ActivityInfo activityInfo, boolean z) {
        try {
            Object currentActivityThread = ATUtils.currentActivityThread();
            Object com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke = com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(DoubleReflector.getMethod(currentActivityThread.getClass(), "getLaunchingActivity", IBinder.class), currentActivityThread, new Object[]{com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(HackHelper.getMethod(ClientTransaction.class, "getActivityToken", new Class[0]), obj, new Object[0])});
            Class<?> cls = com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke.getClass();
            MuteLog.i("Mute.H", "adapterForAndroidS %s", com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke);
            HackHelper.getField(cls, "intent").set(com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke, intent);
            MuteLog.w("Mute.H", "adapterForAndroidS modify ActivityClientRecord.intent", new Object[0]);
            HackHelper.getField(cls, "activityInfo").set(com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke, activityInfo);
            MuteLog.w("Mute.H", "adapterForAndroidS modify ActivityClientRecord.activityInfo", new Object[0]);
            Object com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke2 = com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke(HackHelper.getMethod(currentActivityThread.getClass(), "getPackageInfoNoCheck", ApplicationInfo.class, CompatibilityInfo.class), currentActivityThread, new Object[]{activityInfo.applicationInfo, null});
            HackHelper.getField(cls, "packageInfo").set(com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke, com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke2);
            MuteLog.w("Mute.H", "adapterForAndroidS modify ActivityClientRecord.packageInfo %s", com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke2);
            if (z) {
                HackHelper.getField(cls, "state").set(com_tencent_tinker_lib_hook_MuteHandlerCallback_java_lang_reflect_Method_invoke, null);
                MuteLog.w("Mute.H", "adapterForAndroidS modify ActivityClientRecord.state = null", new Object[0]);
            }
        } catch (Exception e) {
            MuteLog.e("Mute.H", "adapterForAndroidS failed. %s", e);
        }
    }
}
