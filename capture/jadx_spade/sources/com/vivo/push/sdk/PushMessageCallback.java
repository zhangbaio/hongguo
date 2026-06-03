package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface PushMessageCallback {
    boolean isAllowNet(Context context);

    void onAppInstallCompleteShowMsg(String str);

    void onBind(Context context, int i, String str);

    void onDelAlias(Context context, int i, List<String> list, List<String> list2, String str);

    void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    void onForegroundMessageArrived(UPSNotificationMessage uPSNotificationMessage);

    void onListTags(Context context, int i, List<String> list, String str);

    void onLog(Context context, String str, int i, boolean z);

    NotifyArriveCallbackByUser onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage);

    void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage);

    void onNotifyGuideDialogResult(int i);

    void onPublish(Context context, int i, String str);

    void onReceiveRegId(Context context, String str);

    void onSetAlias(Context context, int i, List<String> list, List<String> list2, String str);

    void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage);

    void onTransmissionMessageExpired(UnvarnishedMessage unvarnishedMessage);

    void onUnBind(Context context, int i, String str);
}
