package com.tencent.open.apireq;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseResp {
    private int a = 0;
    private String b = "";

    static {
        Covode.recordClassIndex(653508);
    }

    protected String a(int i) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.a;
    }

    public String getErrorMsg() {
        return this.b;
    }

    public boolean isSuccess() {
        if (this.a == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.a + ", mErrorMsg='" + this.b + "'}";
    }

    public void setErrorMsg(String str) {
        this.b = str;
    }

    public void setCode(int i) {
        String str;
        this.a = i;
        if (i != -2001) {
            if (i != -2000) {
                if (i != 0) {
                    switch (i) {
                        case -1002:
                            str = "The QQ branch (e.g. TIM) is not supported";
                            break;
                        case -1001:
                            str = "QQ version is too low.";
                            break;
                        case -1000:
                            str = "QQ is not installed.";
                            break;
                        default:
                            str = a(i);
                            break;
                    }
                } else {
                    str = "";
                }
            } else {
                str = "The given params check failed.";
            }
        } else {
            str = "Not login.";
        }
        setErrorMsg(str);
    }
}
