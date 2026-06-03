package com.tencent.connect.commonchannel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CommonChannelApi extends BaseApi {
    static {
        Covode.recordClassIndex(653269);
    }

    public CommonChannelApi(QQToken qQToken) {
        super(qQToken);
    }

    private boolean a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("src_id") || !bundle.containsKey("opensdk_ext_data")) {
            return false;
        }
        return true;
    }

    public CommonChannelApi(c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public int launchQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (iUiListener == null) {
            return -5;
        }
        if (a.a("UniversalApi", iUiListener)) {
            return -6;
        }
        if (!a(bundle)) {
            iUiListener.onError(new UiError(-5, "传入参数有误!", "传入参数有误!"));
            return -5;
        }
        StringBuilder sb = new StringBuilder("mqqapi://open_connect/common_channel");
        a(sb, activity);
        String string = bundle.getString("opensdk_ext_data");
        a(sb, "exsvr_userinfo", m.k(string));
        a(sb, "opensdk_ext_data", m.k(string));
        a(sb, "src_id", String.valueOf(bundle.getInt("src_id", 0)));
        Intent intent = new Intent();
        intent.setData(Uri.parse(sb.toString()));
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("for_result", true);
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setFlags(335544320);
        UIListenerManager.getInstance().setListenerWithRequestcode(10114, iUiListener);
        a(activity, 10114, intent, false);
        return 0;
    }
}
