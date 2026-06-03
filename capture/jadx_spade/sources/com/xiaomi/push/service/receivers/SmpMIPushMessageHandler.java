package com.xiaomi.push.service.receivers;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.push.i;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SmpMIPushMessageHandler extends MIPushMessageHandler {
    static {
        Covode.recordClassIndex(655738);
    }

    @Override // com.xiaomi.push.service.receivers.MIPushMessageHandler, com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        i.v().i("MiPush", "onCommandResult on smp");
        super.onCommandResult(context, miPushCommandMessage);
    }
}
