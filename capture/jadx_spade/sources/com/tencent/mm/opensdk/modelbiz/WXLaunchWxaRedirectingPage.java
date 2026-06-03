package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WXLaunchWxaRedirectingPage {

    interface ConstantsWxaRedirectingPage {
    }

    public static final class Req extends BaseReq {
        public String callbackActivity;
        public String invokeTicket;

        static {
            Covode.recordClassIndex(653366);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return !TextUtils.isEmpty(this.invokeTicket);
        }

        public void fromArray(String[] strArr) {
            this.invokeTicket = strArr[0];
            this.callbackActivity = strArr[1];
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.invokeTicket = bundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
            this.callbackActivity = bundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 30;
        }

        public String[] toArray() {
            return new String[]{this.invokeTicket, this.callbackActivity};
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
            bundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
        }
    }

    public static final class Resp extends BaseResp {
        public String callbackActivity;
        public String invokeTicket;

        static {
            Covode.recordClassIndex(653367);
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.invokeTicket = bundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
            this.callbackActivity = bundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 30;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
            bundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
        }
    }

    static {
        Covode.recordClassIndex(653364);
    }
}
