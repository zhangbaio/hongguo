package com.tencent.open.im;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.utils.m;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class IM extends BaseApi {
    static {
        Covode.recordClassIndex(653532);
    }

    public IM(QQToken qQToken) {
        super(qQToken);
    }

    public IM(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public IM(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        if (a.a("ImApi", null) || str == null || (!str.equals("thirdparty2c") && !str.equals("audio_chat") && !str.equals("video_chat"))) {
            return -5;
        }
        if (!str.equals("audio_chat")) {
            str.equals("video_chat");
        }
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        if (str2.length() < 5) {
            return -3;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!Character.isDigit(str2.charAt(i))) {
                return -4;
            }
        }
        if (m.d(activity)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("mqqapi://im/chat?chat_type=%1$s&uin=%2$s&version=1&src_type=app&open_id=%3$s&app_id=%4$s&app_pkg_name=%5$s", str, str2, m.k(this.c.getOpenId()), m.k(this.c.getAppId()), m.k(str3))));
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra("pkg_name", str3);
            activity.startActivity(intent);
            return 0;
        }
        try {
            new TDialog(activity, "", a(""), null, this.c).show();
            return -2;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return -2;
        }
    }
}
