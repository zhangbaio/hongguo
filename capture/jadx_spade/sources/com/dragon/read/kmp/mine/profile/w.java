package com.dragon.read.kmp.mine.profile;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    static {
        Covode.recordClassIndex(607728);
    }

    public static final VerifyStatus a(int i) {
        VerifyStatus verifyStatus = VerifyStatus.NOT_VERIFY;
        if (i != verifyStatus.getValue()) {
            VerifyStatus verifyStatus2 = VerifyStatus.SUCCEED;
            if (i != verifyStatus2.getValue()) {
                VerifyStatus verifyStatus3 = VerifyStatus.REVIEWING;
                if (i != verifyStatus3.getValue()) {
                    return VerifyStatus.FAILED;
                }
                return verifyStatus3;
            }
            return verifyStatus2;
        }
        return verifyStatus;
    }
}
