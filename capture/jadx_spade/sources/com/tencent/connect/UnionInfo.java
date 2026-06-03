package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.tauth.IUiListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class UnionInfo extends BaseApi {
    static {
        Covode.recordClassIndex(653234);
    }

    public void getUnionId(IUiListener iUiListener) {
        Bundle a = a();
        a.putString("unionid", "1");
        HttpUtils.requestAsync(this.c, g.a(), "https://openmobile.qq.com/oauth2.0/me", a, "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public UnionInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }
}
