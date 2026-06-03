package com.tencent.connect;

import com.bytedance.covode.number.Covode;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(653236);
    }

    public static boolean a(String str, IUiListener iUiListener) {
        return a(str, iUiListener, -6, "用户未授权，暂时无法使用QQ登录及分享等功能", "用户未授权，暂时无法使用QQ登录及分享等功能");
    }

    public static boolean a(String str, IUiListener iUiListener, int i, String str2, String str3) {
        if (Tencent.isPermissionNotGranted()) {
            SLog.i(str, "permission not granted");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(i, str2, str3));
                return true;
            }
            return true;
        }
        return false;
    }
}
