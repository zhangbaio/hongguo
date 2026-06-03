package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WXChannelShareVideo {

    public static class Req extends BaseReq {
        public String extData;
        public IWXChannelJumpInfo jumpInfo;
        public String videoPath;

        static {
            Covode.recordClassIndex(653350);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            if (b.b(this.videoPath)) {
                str = "videoPath is null";
            } else {
                IWXChannelJumpInfo iWXChannelJumpInfo = this.jumpInfo;
                if (iWXChannelJumpInfo == null || iWXChannelJumpInfo.checkArgs()) {
                    return true;
                }
                str = "checkArgs fail, jumpInfo is invalid";
            }
            Log.e("MicroMsg.SDK.WXChannelShareVideo.Req", str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.videoPath = bundle.getString("_wxapi_finder_share_video_path");
            this.extData = bundle.getString("_wxapi_finder_share_video_extData");
            String string = bundle.getString("_wxapi_channel_share_video_jump_info_identifier");
            if (string != null) {
                try {
                    IWXChannelJumpInfo iWXChannelJumpInfo = (IWXChannelJumpInfo) a.q(string).newInstance();
                    this.jumpInfo = iWXChannelJumpInfo;
                    iWXChannelJumpInfo.unserialize(bundle);
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.WXChannelShareVideo.Req", "get WXChannelJumpInfo from bundle failed: unknown ident " + string + ", ex = " + e.getMessage());
                }
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 33;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_share_video_path", this.videoPath);
            bundle.putString("_wxapi_finder_share_video_extData", this.extData);
            IWXChannelJumpInfo iWXChannelJumpInfo = this.jumpInfo;
            if (iWXChannelJumpInfo != null) {
                bundle.putString("_wxapi_channel_share_video_jump_info_identifier", iWXChannelJumpInfo.getClass().getName());
                this.jumpInfo.serialize(bundle);
            }
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        static {
            Covode.recordClassIndex(653351);
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
            this.extMsg = bundle.getString("_wxapi_finder_extMsg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 33;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_extMsg", this.extMsg);
        }
    }

    static {
        Covode.recordClassIndex(653349);
    }
}
