package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class QQAvatar extends BaseApi {
    private IUiListener a;

    static {
        Covode.recordClassIndex(653257);
    }

    public QQAvatar(QQToken qQToken) {
        super(qQToken);
    }

    private Intent a(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    private void a(Bundle bundle) {
        QQToken qQToken = this.c;
        if (qQToken != null) {
            bundle.putString("appid", qQToken.getAppId());
            if (this.c.isSessionValid()) {
                bundle.putString("keystr", this.c.getAccessToken());
                bundle.putString("keytype", "0x80");
            }
            String openId = this.c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString("platform", "androidqz");
            try {
                bundle.putString("pf", g.a().getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
            } catch (Exception e) {
                e.printStackTrace();
                bundle.putString("pf", "openmobile_android");
            }
        }
        bundle.putString("sdkv", "3.5.11.lite");
        bundle.putString("sdkp", "a");
    }

    private void a(Activity activity, Bundle bundle, Intent intent) {
        a(bundle);
        intent.putExtra("key_action", "action_avatar");
        intent.putExtra("key_params", bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(11102, this.a);
        a(activity, intent, 11102);
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        if (!k.b(activity)) {
            l3.a.B(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (k.c(activity, "8.0.0") < 0) {
            l3.a.B(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String a = m.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
        if (!TextUtils.isEmpty(a)) {
            if (a.length() > 20) {
                a = a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a), 2));
        }
        String appId = this.c.getAppId();
        String openId = this.c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
        }
        String b = m.b(activity, uri);
        if (!TextUtils.isEmpty(b)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&set_uri=" + Base64.encodeToString(m.j(uri.toString()), 2));
            } catch (Exception e) {
                SLog.e("QQAvatar", "Exception", e);
            }
        }
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&set_path=" + Base64.encodeToString(m.j(b), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j("3.5.11.lite"), 2));
        SLog.v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (a(intent)) {
            UIListenerManager.getInstance().setListenerWithRequestcode(10108, iUiListener);
            a(activity, 10108, intent, false);
        }
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        if (!k.b(activity)) {
            l3.a.B(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (k.c(activity, "8.0.5") < 0) {
            l3.a.B(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String a = m.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
        if (!TextUtils.isEmpty(a)) {
            if (a.length() > 20) {
                a = a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a), 2));
        }
        String appId = this.c.getAppId();
        String openId = this.c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
        }
        String b = m.b(activity, uri);
        if (!TextUtils.isEmpty(b)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&video_uri=");
                stringBuffer.append(Base64.encodeToString(m.j(uri.toString()), 2));
            } catch (Exception e) {
                SLog.e("QQAvatar", "Exception", e);
            }
        }
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&video_path=" + Base64.encodeToString(m.j(b), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j("3.5.11.lite"), 2));
        SLog.v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (a(intent)) {
            UIListenerManager.getInstance().setListenerWithRequestcode(10110, iUiListener);
            a(activity, 10110, intent, false);
        }
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i);
        bundle.putString("appid", this.c.getAppId());
        bundle.putString("access_token", this.c.getAccessToken());
        bundle.putLong("expires_in", this.c.getExpireTimeInSecond());
        bundle.putString("openid", this.c.getOpenId());
        Intent a = a(activity);
        if (a(a)) {
            a(activity, bundle, a);
            e.a().a(this.c.getOpenId(), this.c.getAppId(), "ANDROIDSDK.SETAVATAR.XX", "12", "18", "0");
        } else {
            e.a().a(this.c.getOpenId(), this.c.getAppId(), "ANDROIDSDK.SETAVATAR.XX", "12", "18", "1");
        }
    }
}
