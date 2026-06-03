package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SendTdiAuth {

    public static final class Resp extends SendAuth.Resp {
        public byte[] tdiAuthBuffer;

        static {
            Covode.recordClassIndex(653408);
        }

        public Resp(Bundle bundle) {
            super(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.tdiAuthBuffer = bundle.getByteArray("_wxapi_sendauth_resp_tdi_buffer");
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 31;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putByteArray("_wxapi_sendauth_resp_tdi_buffer", this.tdiAuthBuffer);
        }
    }

    static {
        Covode.recordClassIndex(653407);
    }

    private SendTdiAuth() {
    }
}
