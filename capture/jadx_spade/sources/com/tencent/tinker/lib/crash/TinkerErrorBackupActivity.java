package com.tencent.tinker.lib.crash;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Process;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TinkerErrorBackupActivity extends Activity {
    static {
        Covode.recordClassIndex(653733);
    }

    private static List com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
        Result preInvoke = new HeliosApiHook().preInvoke(101311, "android/content/pm/PackageManager", "queryIntentActivities", packageManager, new Object[]{intent, Integer.valueOf(i)}, "java.util.List", new ExtraInfo(false, "(Landroid/content/Intent;I)Ljava/util/List;"));
        return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : packageManager.queryIntentActivities(intent, i);
    }

    @Override // android.app.Activity
    public void onResume() {
        ActivityAgent.onTrace("com.tencent.tinker.lib.crash.TinkerErrorBackupActivity", "onResume", true);
        super.onResume();
        ActivityAgent.onTrace("com.tencent.tinker.lib.crash.TinkerErrorBackupActivity", "onResume", false);
    }

    @Override // android.app.Activity
    public void onStart() {
        ActivityAgent.onTrace("com.tencent.tinker.lib.crash.TinkerErrorBackupActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.tencent.tinker.lib.crash.TinkerErrorBackupActivity", "onStart", false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.tencent.tinker.lib.crash.TinkerErrorBackupActivity", "onWindowFocusChanged", true);
        super.onWindowFocusChanged(z);
    }

    private String getLaunchActivityForPackage(String str) {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.INFO");
        intent.setPackage(str);
        List com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities = com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities(packageManager, intent, 0);
        if (com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities == null || com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities.size() <= 0) {
            intent.removeCategory("android.intent.category.INFO");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities = com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities(packageManager, intent, 0);
        }
        if (com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities != null && com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities.size() > 0) {
            return ((ResolveInfo) com_tencent_tinker_lib_crash_TinkerErrorBackupActivity_android_content_pm_PackageManager_queryIntentActivities.get(0)).activityInfo.name;
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.tencent.tinker.lib.crash.TinkerErrorBackupActivity", "onCreate", true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            reportException((Intent) intent.getParcelableExtra("extra_stub_intent"));
        }
        try {
            Intent intent2 = new Intent(this, Class.forName(getLaunchActivityForPackage(getPackageName())));
            intent2.setFlags(268468224);
            overridePendingTransition(0, 0);
            startActivity(intent2);
            MuteLog.i("Mute.MiraErrorBackupActivity", "start main activity", new Object[0]);
        } catch (Exception e) {
            MuteLog.printErrStackTrace("Mute.MiraErrorBackupActivity", e, "re route to main activity failed", new Object[0]);
        }
        finish();
        ActivityAgent.onTrace("com.tencent.tinker.lib.crash.TinkerErrorBackupActivity", "onCreate", false);
    }

    private void reportException(Intent intent) {
        ApplicationInfo applicationInfo;
        if (intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("stub_createinfo");
            Intent intent2 = (Intent) intent.getParcelableExtra("target_intent");
            ActivityInfo activityInfo = (ActivityInfo) intent.getParcelableExtra("target_activityinfo");
            String str = "";
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null) {
                str = applicationInfo.sourceDir;
            }
            MuteLog.e("plugin_apk_not_exists", "intent from: " + stringExtra + "\ntargetIntent: " + intent2 + "\ntargetActivityInfo: " + activityInfo + "\ntargetActivityInfo.applicationInfo.sourceDir: " + str + "\ncurrent: " + System.currentTimeMillis() + "#" + Process.myPid() + "#" + getApplicationInfo().processName, new Object[0]);
        } catch (Throwable th) {
            MuteLog.printErrStackTrace("mira/activity", th, " reportIfTimeout failed.", new Object[0]);
        }
    }
}
