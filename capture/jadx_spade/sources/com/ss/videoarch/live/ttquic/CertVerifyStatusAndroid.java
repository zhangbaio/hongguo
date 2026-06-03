package com.ss.videoarch.live.ttquic;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CertVerifyStatusAndroid {
    public static int EXPIRED;
    public static int FAILED;
    public static int INCORRECT_KEY_USAGE;
    public static int NOT_YET_VALID;
    public static int NO_TRUSTED_ROOT;
    public static int OK;
    public static int UNABLE_TO_PARSE;

    static {
        Covode.recordClassIndex(652876);
        OK = 0;
        FAILED = -1;
        NO_TRUSTED_ROOT = -2;
        EXPIRED = -3;
        NOT_YET_VALID = -4;
        UNABLE_TO_PARSE = -5;
        INCORRECT_KEY_USAGE = -6;
    }
}
