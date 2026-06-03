package com.tencent.tinker.lib.crash;

import android.R;
import android.app.servertransaction.ActivityLifecycleItem;
import android.app.servertransaction.ClientTransaction;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.LaunchActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteMaxLoader;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.hidden.p.HackHelper;
import com.tencent.tinker.lib.hook.MuteHandlerCallback;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteRestoreHelper {
    private static final MuteRestoreHelper sInstance;
    private boolean handleRestore = true;

    private static Object com_tencent_tinker_lib_crash_MuteRestoreHelper_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public static MuteRestoreHelper getInstance() {
        return sInstance;
    }

    static {
        Covode.recordClassIndex(653732);
        sInstance = new MuteRestoreHelper();
    }

    public void dealRestoreDowngrade() {
        try {
            MessageQueue messageQueue = (MessageQueue) FieldUtils.readField(Looper.getMainLooper(), "mQueue");
            synchronized (messageQueue) {
                for (Message message = (Message) FieldUtils.readField(messageQueue, "mMessages"); message != null; message = (Message) FieldUtils.readField(message, "next")) {
                    int i = message.what;
                    if (i == 159) {
                        if (handleRestoreActivityProtect((ClientTransaction) message.obj)) {
                            break;
                        }
                    } else {
                        if (i == 100 && handleRestoreActivityProtect(message)) {
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MuteLog.e("Mute.Restore", "dealRestoreDowngrade failed. %s", th);
        }
    }

    public void handleRestoreActivityProtectWhenFirstInstall(ClientTransaction clientTransaction) {
        if (MuteMaxLoader.sIsFirstMuteStart && this.handleRestore && handleRestoreActivityProtect(clientTransaction)) {
            this.handleRestore = false;
        }
    }

    public void handleRestoreActivityProtectWhenFirstInstall(Message message) {
        if (MuteMaxLoader.sIsFirstMuteStart && this.handleRestore && handleRestoreActivityProtect(message)) {
            this.handleRestore = false;
        }
    }

    private boolean handleRestoreActivityProtect(Message message) {
        try {
            Object obj = message.obj;
            Object readField = FieldUtils.readField(obj, "state");
            Intent intent = (Intent) FieldUtils.readField(obj, "intent");
            MuteLog.w("Mute.Restore", "handleRestoreActivityProtect1 %s", intent);
            ActivityInfo activityInfo = (ActivityInfo) FieldUtils.readField(obj, "activityInfo");
            String packageName = Muter.getAppContext().getPackageName();
            if (readField != null) {
                MuteLog.w("Mute.Restore", "handleRestoreActivityProtect1 modify %s %s %s", activityInfo.packageName, activityInfo, activityInfo.applicationInfo);
                activityInfo.targetActivity = TinkerErrorBackupActivity.class.getName();
                activityInfo.packageName = packageName;
                activityInfo.theme = R.style.Theme.Translucent.NoTitleBar;
                ApplicationInfo applicationInfo = activityInfo.applicationInfo;
                if (applicationInfo != null) {
                    applicationInfo.packageName = packageName;
                }
                intent.setClassName(Muter.getAppContext().getApplicationContext(), TinkerErrorBackupActivity.class.getName());
                intent.replaceExtras(new Intent());
                intent.setData(null);
                return true;
            }
        } catch (Exception e) {
            MuteLog.e("Mute.Restore", "handleRestoreActivityProtect1 failed. %s", e);
        }
        return false;
    }

    private boolean handleRestoreActivityProtect(ClientTransaction clientTransaction) {
        Method method;
        try {
            method = HackHelper.getMethod(ClientTransaction.class, "getLifecycleStateRequest", new Class[0]);
        } catch (Exception e) {
            MuteLog.e("Mute.Restore", "handleRestoreActivityProtect2 failed. %s", e);
        }
        if (method == null) {
            MuteLog.e("Mute.Restore", "handleRestoreActivityProtect2 hook ClientTransaction.getLifecycleStateRequest() failed.", new Object[0]);
            return false;
        }
        if (((ActivityLifecycleItem) com_tencent_tinker_lib_crash_MuteRestoreHelper_java_lang_reflect_Method_invoke(method, clientTransaction, new Object[0])) instanceof ResumeActivityItem) {
            Method method2 = HackHelper.getMethod(ClientTransaction.class, "getCallbacks", new Class[0]);
            if (method2 == null) {
                MuteLog.e("Mute.Restore", "handleRestoreActivityProtect2 hook ClientTransaction.getCallbacks() failed.", new Object[0]);
                return false;
            }
            List list = (List) com_tencent_tinker_lib_crash_MuteRestoreHelper_java_lang_reflect_Method_invoke(method2, clientTransaction, new Object[0]);
            if (list.isEmpty()) {
                MuteLog.e("Mute.Restore", "handleRestoreActivityProtect2 clientTransaction.getCallbacks() = 0", new Object[0]);
                return false;
            }
            ClientTransactionItem clientTransactionItem = (ClientTransactionItem) list.get(0);
            if (clientTransactionItem instanceof LaunchActivityItem) {
                Field field = HackHelper.getField(LaunchActivityItem.class, "mState");
                Field field2 = HackHelper.getField(LaunchActivityItem.class, "mIntent");
                Field field3 = HackHelper.getField(LaunchActivityItem.class, "mInfo");
                if (field2 != null && field3 != null) {
                    Intent intent = (Intent) field2.get(clientTransactionItem);
                    MuteLog.i("Mute.Restore", "handleRestoreActivityProtect2 item.mIntent[%s]", intent);
                    ActivityInfo activityInfo = (ActivityInfo) field3.get(clientTransactionItem);
                    String packageName = Muter.getAppContext().getPackageName();
                    if (field.get(clientTransactionItem) != null) {
                        MuteLog.w("Mute.Restore", "handleRestoreActivityProtect2 modify %s %s %s", activityInfo.packageName, activityInfo, activityInfo.applicationInfo);
                        activityInfo.targetActivity = TinkerErrorBackupActivity.class.getName();
                        activityInfo.packageName = packageName;
                        activityInfo.theme = R.style.Theme.Translucent.NoTitleBar;
                        ApplicationInfo applicationInfo = activityInfo.applicationInfo;
                        if (applicationInfo != null) {
                            applicationInfo.packageName = packageName;
                        }
                        intent.setClassName(Muter.getAppContext().getApplicationContext(), TinkerErrorBackupActivity.class.getName());
                        intent.replaceExtras(new Intent());
                        intent.setData(null);
                        field2.set(clientTransactionItem, intent);
                        field3.set(clientTransactionItem, activityInfo);
                        if (OSUtil.isAndroidS()) {
                            MuteHandlerCallback.adapterForAndroidS(clientTransaction, intent, activityInfo, true);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
