package gq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsVipApi;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(609608);
    }

    public static final boolean a(String str) {
        NsVipApi nsVipApi = NsVipApi.IMPL;
        if (str == null) {
            str = "";
        }
        return nsVipApi.isBuyPaidBook(str);
    }
}
