package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.channel.a.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class BaseReq {
    public String openId;
    public String transaction;

    static {
        Covode.recordClassIndex(653301);
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.transaction = a.a(bundle, "_wxapi_basereq_transaction");
        this.openId = a.a(bundle, "_wxapi_basereq_openid");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.transaction);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
