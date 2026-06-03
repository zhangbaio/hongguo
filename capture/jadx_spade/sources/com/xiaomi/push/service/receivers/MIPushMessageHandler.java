package com.xiaomi.push.service.receivers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.push.i;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xm.MiPushAdapter;
import ez0.b;
import fk6.a;
import java.util.List;
import org.json.JSONObject;
import v01.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MIPushMessageHandler extends PushMessageReceiver {
    static {
        Covode.recordClassIndex(655735);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
        i.v().i("MiPush", "onNotificationMessageArrived");
        PushMessageReceiver pushMessageReceiver = a.a().a;
        if (pushMessageReceiver != null) {
            pushMessageReceiver.onNotificationMessageArrived(context, miPushMessage);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        String valueOf;
        super.onNotificationMessageClicked(context, miPushMessage);
        b v = i.v();
        StringBuilder sb = new StringBuilder();
        sb.append("Get MiPush Message ");
        if (miPushMessage != null) {
            valueOf = miPushMessage.toString();
        } else {
            valueOf = String.valueOf((char[]) null);
        }
        sb.append(valueOf);
        v.d("MiPush", sb.toString());
        if (context != null && miPushMessage != null) {
            try {
                String content = miPushMessage.getContent();
                if (!TextUtils.isEmpty(content)) {
                    String e = i.z().e(MiPushAdapter.getMiPush(), content.getBytes(), true);
                    if (TextUtils.isEmpty(e)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(e);
                    jSONObject.put("pass_through", miPushMessage.getPassThrough());
                    i.z().f(context, jSONObject.toString(), MiPushAdapter.getMiPush(), (String) null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        String valueOf;
        super.onReceivePassThroughMessage(context, miPushMessage);
        b v = i.v();
        StringBuilder sb = new StringBuilder();
        sb.append("Get MiPush Message ");
        if (miPushMessage != null) {
            valueOf = miPushMessage.toString();
        } else {
            valueOf = String.valueOf((char[]) null);
        }
        sb.append(valueOf);
        v.d("MiPush", sb.toString());
        if (context != null && miPushMessage != null) {
            try {
                String content = miPushMessage.getContent();
                if (!TextUtils.isEmpty(content)) {
                    JSONObject jSONObject = new JSONObject(i.z().e(MiPushAdapter.getMiPush(), content.getBytes(), true));
                    jSONObject.put("pass_through", miPushMessage.getPassThrough());
                    i.x().a(jSONObject.toString(), MiPushAdapter.getMiPush(), (String) null);
                }
            } catch (Throwable th) {
                h.g(Log.getStackTraceString(th));
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String str;
        String str2;
        if (context != null && miPushCommandMessage != null) {
            try {
                String command = miPushCommandMessage.getCommand();
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                String str3 = null;
                if (commandArguments != null && commandArguments.size() > 0) {
                    str = commandArguments.get(0);
                } else {
                    str = null;
                }
                if (commandArguments != null && commandArguments.size() > 1) {
                    str2 = commandArguments.get(1);
                } else {
                    str2 = null;
                }
                i.v().i("MiPush", "command:" + command);
                if ("register".equals(command)) {
                    if (miPushCommandMessage.getResultCode() == 0) {
                        i.v().d("MiPush", "mRegId = " + str);
                        if (!TextUtils.isEmpty(str)) {
                            i.z().c(context, MiPushAdapter.getMiPush(), str);
                        } else {
                            i.w().j(MiPushAdapter.getMiPush(), 102, "0", "token is empty");
                        }
                    } else {
                        i.w().j(MiPushAdapter.getMiPush(), 104, String.valueOf(miPushCommandMessage.getResultCode()), miPushCommandMessage.getReason());
                        i.z().g(MiPushAdapter.getMiPush(), String.valueOf(miPushCommandMessage.getResultCode()), miPushCommandMessage.getReason());
                    }
                } else if ("set-alias".equals(command)) {
                    if (miPushCommandMessage.getResultCode() == 0) {
                        i.v().d("MiPush", "set alias success, mAlias = " + str);
                    }
                } else if ("unset-alias".equals(command)) {
                    if (miPushCommandMessage.getResultCode() == 0) {
                        i.v().d("MiPush", "unSet alias success, mAlias = " + str);
                    }
                } else if ("subscribe-topic".equals(command)) {
                    if (miPushCommandMessage.getResultCode() == 0) {
                        i.v().d("MiPush", "subscribe topic success, mTopic = " + str);
                    }
                } else if ("unsubscibe-topic".equals(command)) {
                    if (miPushCommandMessage.getResultCode() == 0) {
                        i.v().d("MiPush", "unSubscribe topic success, mTopic = " + str);
                    }
                } else if ("accept-time".equals(command) && miPushCommandMessage.getResultCode() == 0) {
                    i.v().d("MiPush", "mStartTime = " + str + " mEndTime = " + str2);
                }
                if (miPushCommandMessage.getResultCode() != 0) {
                    if (70000002 == miPushCommandMessage.getResultCode()) {
                        str3 = "push connection certification failed";
                    } else if (70000001 == miPushCommandMessage.getResultCode()) {
                        str3 = "the push connection failed due to network failure";
                    } else if (70000004 == miPushCommandMessage.getResultCode()) {
                        str3 = "push internal status error, please contact developers if you encounter such errors";
                    } else if (70000003 == miPushCommandMessage.getResultCode()) {
                        str3 = "The message format sent by the client to the push channel is invalid";
                    }
                    if (TextUtils.equals(command, "Registration")) {
                        i.w().j(MiPushAdapter.getMiPush(), 104, String.valueOf(miPushCommandMessage.getResultCode()), str3);
                    }
                    i.v().i("MiPush", command + " -> " + str3);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
