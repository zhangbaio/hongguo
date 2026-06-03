package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ttnet.org.chromium.net.e0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class UrlRequestBase extends com.ttnet.org.chromium.net.g {

    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusValues {
    }

    protected abstract void p(String str, String str2);

    protected abstract void r(String str);

    protected abstract void s(int i);

    protected abstract void t(int i);

    protected abstract void u(int i);

    protected abstract void v(int i);

    protected abstract void w(e0 e0Var, Executor executor);

    static {
        Covode.recordClassIndex(654662);
    }

    public static int q(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
            default:
                throw new IllegalArgumentException("No request status found.");
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return 5;
            case 7:
                return 6;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return 11;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return 12;
            case 14:
                return 13;
            case 15:
                return 14;
        }
    }
}
