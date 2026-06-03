package com.tencent.mm.opensdk.modelbiz;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelbase.BaseReq;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class OpenRankList {

    public static class Req extends BaseReq {
        static {
            Covode.recordClassIndex(653324);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 11;
        }
    }

    static {
        Covode.recordClassIndex(653323);
    }
}
