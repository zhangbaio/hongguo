package com.vivo;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.push.i;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SmpVivoPushMessageReceiver extends VivoPushMessageReceiver {
    static {
        Covode.recordClassIndex(654965);
    }

    @Override // com.vivo.VivoPushMessageReceiver, com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        i.v().i("VivoPushMessageReceiver", "SmpVivoPushMessageReceiver#onReceiveRegId token = " + str);
        super.onReceiveRegId(context, str);
    }
}
