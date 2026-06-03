package com.vivo.push.ups;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.vivo.push.PushClient;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VUpsManager {
    static {
        Covode.recordClassIndex(655163);
    }

    public void onCommandResult(Context context, Bundle bundle) {
    }

    private static class a {
        private static VUpsManager a;

        static {
            Covode.recordClassIndex(655164);
            a = new VUpsManager();
        }
    }

    public static VUpsManager getInstance() {
        return a.a;
    }

    public void turnOffPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOffPush(new d(this, uPSTurnCallback));
    }

    public void turnOnPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOnPush(new c(this, uPSTurnCallback));
    }

    public void unRegisterToken(Context context, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOffPush(new b(this, uPSRegisterCallback));
    }

    public void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOnPush(new com.vivo.push.ups.a(this, uPSRegisterCallback));
    }
}
