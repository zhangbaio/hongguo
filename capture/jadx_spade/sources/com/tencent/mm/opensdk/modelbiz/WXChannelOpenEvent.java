package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WXChannelOpenEvent {

    public static class Req extends BaseReq {
        public String eventId;
        public String extInfo;
        public String username;

        static {
            Covode.recordClassIndex(653338);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            if (b.b(this.username)) {
                str = "username is null";
            } else if (this.username.length() > 1024) {
                str = "username exceeds the limit";
            } else if (b.b(this.eventId)) {
                str = "eventId is null";
            } else {
                if (this.eventId.length() <= 1024) {
                    return true;
                }
                str = "eventId exceeds the limit";
            }
            Log.e("MicroMsg.SDK.WXChannelOpenEvent.Req", str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.username = bundle.getString("_wxapi_finder_open_event_username");
            this.eventId = bundle.getString("_wxapi_finder_open_event_eventId");
            this.extInfo = bundle.getString("_wxapi_finder_open_event_extInfo");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 41;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_open_event_username", this.username);
            bundle.putString("_wxapi_finder_open_event_eventId", this.eventId);
            bundle.putString("_wxapi_finder_open_event_extInfo", this.extInfo);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        static {
            Covode.recordClassIndex(653339);
        }

        public Resp() {
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
            this.extMsg = bundle.getString("_wxapi_finder_open_event_extMsg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 41;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_open_event_extMsg", this.extMsg);
        }
    }

    static {
        Covode.recordClassIndex(653337);
    }
}
