package com.vivo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.covode.number.Covode;
import com.bytedance.push.i;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import com.vv.VvPushAdapter;
import com.vv.b;
import org.json.JSONException;
import org.json.JSONObject;
import v01.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VivoPushMessageReceiver extends OpenClientPushMessageReceiver {
    private final Handler a = new HandlerDelegate(Looper.getMainLooper());

    static {
        Covode.recordClassIndex(654966);
    }

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;

        @Override // java.lang.Runnable
        public void run() {
            i.v().i("VivoPushMessageReceiver", "onReceiveRegId token = " + this.a);
            VvPushAdapter.sendToken(this.b, this.a);
        }

        a(String str, Context context) {
            this.a = str;
            this.b = context;
        }
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotifyGuideDialogResult(int i) {
        super.onNotifyGuideDialogResult(i);
        b.a().b(i);
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        this.a.post(new a(str, context));
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        if (context != null && uPSNotificationMessage != null) {
            Logger.i("VivoPushMessageReceiver", "onNotificationMessageClicked: message = " + uPSNotificationMessage.getSkipContent());
            try {
                String skipContent = uPSNotificationMessage.getSkipContent();
                if (!TextUtils.isEmpty(skipContent)) {
                    String e = i.z().e(VvPushAdapter.getVvPush(), skipContent.getBytes(), true);
                    if (TextUtils.isEmpty(e)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(e);
                    jSONObject.put("pass_through", 0);
                    i.z().f(context, jSONObject.toString(), VvPushAdapter.getVvPush(), (String) null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
        super.onTransmissionMessage(context, unvarnishedMessage);
        h.k("VivoPushMessageReceiver", "onMessageReceived is called");
        if (unvarnishedMessage == null) {
            h.h("VivoPushMessageReceiver", "Received message entity is null!");
            return;
        }
        String message = unvarnishedMessage.getMessage();
        h.k("VivoPushMessageReceiver", "get message: " + message);
        if (!TextUtils.isEmpty(message)) {
            try {
                JSONObject jSONObject = new JSONObject(message);
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("android_payload"));
                jSONObject2.put("voip_params", jSONObject.optString("voip_params"));
                jSONObject2.put("push_show_type", jSONObject.optInt("push_show_type"));
                i.x().d(jSONObject2, VvPushAdapter.getVvPush(), (String) null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
