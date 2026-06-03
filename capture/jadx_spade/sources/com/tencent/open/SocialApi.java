package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SocialApi {
    private SocialApiIml a;

    static {
        Covode.recordClassIndex(653488);
    }

    public SocialApi(QQToken qQToken) {
        this.a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.a.story(activity, bundle, iUiListener);
    }
}
