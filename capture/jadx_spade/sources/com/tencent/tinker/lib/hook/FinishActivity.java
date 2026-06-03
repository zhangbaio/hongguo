package com.tencent.tinker.lib.hook;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteSP;
import com.tencent.tinker.lib.Muter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FinishActivity extends AbsMethodDelegate {
    private ComponentName mAfterTopActivity;
    private ComponentName mBaseActivity;
    private Intent mBaseIntent;
    private ComponentName mBeforeTopActivity;
    private final ActivityManager mActivityMgr = (ActivityManager) Muter.getAppContext().getSystemService("activity");
    private final String mPkgName = Muter.getAppContext().getPackageName();

    static {
        Covode.recordClassIndex(653758);
    }

    private static List com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks(ActivityManager activityManager, int i) {
        Result preInvoke = new HeliosApiHook().preInvoke(101301, "android/app/ActivityManager", "getRunningTasks", activityManager, new Object[]{Integer.valueOf(i)}, "java.util.List", new ExtraInfo(false, "(I)Ljava/util/List;"));
        return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : activityManager.getRunningTasks(i);
    }

    private void getAfterTopActivity() {
        List com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks = com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks(this.mActivityMgr, 1);
        if (com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks != null && com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks.size() > 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks.get(0);
            ComponentName componentName = runningTaskInfo.topActivity;
            this.mAfterTopActivity = componentName;
            ComponentName componentName2 = runningTaskInfo.baseActivity;
            this.mBaseActivity = componentName2;
            if (Build.VERSION.SDK_INT >= 29) {
                this.mBaseIntent = runningTaskInfo.baseIntent;
            }
            MuteLog.i("Mute.FinishActivity", "getAfterTopActivity top[%s] base[%s]", componentName, componentName2);
        }
    }

    private void getBeforeTopActivity() {
        List com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks = com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks(this.mActivityMgr, 1);
        if (com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks != null && com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks.size() > 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) com_tencent_tinker_lib_hook_FinishActivity_android_app_ActivityManager_getRunningTasks.get(0);
            ComponentName componentName = runningTaskInfo.topActivity;
            this.mBeforeTopActivity = componentName;
            ComponentName componentName2 = runningTaskInfo.baseActivity;
            this.mBaseActivity = componentName2;
            MuteLog.i("Mute.FinishActivity", "getBeforeTopActivity top[%s] base[%s]", componentName, componentName2);
        }
    }

    private boolean isTopRuleMatch() {
        ComponentName componentName = this.mBaseActivity;
        if (componentName != null && TextUtils.equals(componentName.getPackageName(), this.mPkgName) && !TextUtils.isEmpty(this.mBaseActivity.getClassName())) {
            ComponentName componentName2 = this.mAfterTopActivity;
            if (componentName2 != null && TextUtils.equals(componentName2.getPackageName(), this.mPkgName) && TextUtils.equals(this.mAfterTopActivity.getClassName(), this.mBaseActivity.getClassName())) {
                List f = Muter.getSettings().f();
                ComponentName componentName3 = this.mBeforeTopActivity;
                if (componentName3 != null && TextUtils.equals(componentName3.getPackageName(), this.mPkgName) && !TextUtils.isEmpty(this.mBeforeTopActivity.getClassName()) && f != null && f.contains(this.mBeforeTopActivity.getClassName())) {
                    return true;
                }
                MuteLog.w("Mute.FinishActivity", "isTopRuleMatch[false] mBeforeTopActivity[%s] is not allow[%s]", this.mBeforeTopActivity, f);
                return false;
            }
            MuteLog.w("Mute.FinishActivity", "isTopRuleMatch[false] mAfterTopActivity is not MainActivity", new Object[0]);
            return false;
        }
        MuteLog.w("Mute.FinishActivity", "isTopRuleMatch[false] mBaseActivity is null", new Object[0]);
        return false;
    }

    @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
    public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
        getBeforeTopActivity();
        return super.beforeInvoke(obj, method, objArr);
    }

    @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
    public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
        getAfterTopActivity();
        if (isTopRuleMatch() && Muter.isInstallReady()) {
            MuteLog.e("Mute.FinishActivity", "condition[T] will kill proc and relaunch", new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("rule_id", Integer.valueOf(MuteSP.getRuleId()));
            hashMap.put("patch_version", Integer.valueOf(MuteSP.getInstallVerCode()));
            hashMap.put("patch_md5", MuteSP.getInstallMd5());
            Muter.getReporter().onReportStatus(10000, 202, hashMap);
            Intent intent = this.mBaseIntent;
            if (intent != null) {
                intent.addFlags(268468224);
                Muter.getAppContext().startActivity(this.mBaseIntent);
            } else {
                Intent intent2 = new Intent(Muter.getAppContext(), this.mBaseActivity.getClass());
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.addFlags(268468224);
                Muter.getAppContext().startActivity(intent2);
            }
            Process.killProcess(Process.myPid());
        }
        return super.afterInvoke(obj, method, objArr, obj2);
    }
}
