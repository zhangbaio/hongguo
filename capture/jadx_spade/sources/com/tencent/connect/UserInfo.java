package com.tencent.connect;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.tauth.IUiListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class UserInfo extends BaseApi {
    static {
        Covode.recordClassIndex(653235);
    }

    public void getOpenId(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.c, g.a(), "oauth2.0/m_me", a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getUserInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.c, g.a(), "user/get_simple_userinfo", a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public UserInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public UserInfo(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }
}
