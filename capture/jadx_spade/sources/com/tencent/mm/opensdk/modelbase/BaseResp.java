package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class BaseResp {
    public int errCode;
    public String errStr;
    public String openId;
    public String transaction;

    public interface ErrCode {
    }

    static {
        Covode.recordClassIndex(653302);
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.errCode = bundle.getInt("_wxapi_baseresp_errcode");
        this.errStr = bundle.getString("_wxapi_baseresp_errstr");
        this.transaction = bundle.getString("_wxapi_baseresp_transaction");
        this.openId = bundle.getString("_wxapi_baseresp_openId");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putInt("_wxapi_baseresp_errcode", this.errCode);
        bundle.putString("_wxapi_baseresp_errstr", this.errStr);
        bundle.putString("_wxapi_baseresp_transaction", this.transaction);
        bundle.putString("_wxapi_baseresp_openId", this.openId);
    }
}
