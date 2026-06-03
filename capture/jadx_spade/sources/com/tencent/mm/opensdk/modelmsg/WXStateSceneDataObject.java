package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.utils.Log;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WXStateSceneDataObject implements SendMessageToWX.IWXSceneDataObject {
    public String stateId;
    public IWXStateJumpInfo stateJumpInfo;
    public String stateTitle;
    public String token;

    public interface IWXStateJumpInfo {
        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    static {
        Covode.recordClassIndex(653437);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public boolean checkArgs() {
        String str = this.stateId;
        if (str != null && str.length() > 10240) {
            Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, stateId is invalid");
            return false;
        }
        String str2 = this.stateTitle;
        if (str2 != null && str2.length() > 10240) {
            Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, stateId is invalid");
            return false;
        }
        String str3 = this.token;
        if (str3 != null && str3.length() > 10240) {
            Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, stateId is invalid");
            return false;
        }
        IWXStateJumpInfo iWXStateJumpInfo = this.stateJumpInfo;
        if (iWXStateJumpInfo != null) {
            return iWXStateJumpInfo.checkArgs();
        }
        Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, statsJumpInfo is null");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public int getJumpType() {
        IWXStateJumpInfo iWXStateJumpInfo = this.stateJumpInfo;
        if (iWXStateJumpInfo != null) {
            return iWXStateJumpInfo.type();
        }
        return 0;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxapi_scene_data_state_id", this.stateId);
        bundle.putString("_wxapi_scene_data_state_title", this.stateTitle);
        bundle.putString("_wxapi_scene_data_state_token", this.token);
        IWXStateJumpInfo iWXStateJumpInfo = this.stateJumpInfo;
        if (iWXStateJumpInfo != null) {
            bundle.putString("_wxapi_scene_data_state_jump_info_identifier", iWXStateJumpInfo.getClass().getName());
            this.stateJumpInfo.serialize(bundle);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public void unserialize(Bundle bundle) {
        this.stateId = bundle.getString("_wxapi_scene_data_state_id");
        this.stateTitle = bundle.getString("_wxapi_scene_data_state_title");
        this.token = bundle.getString("_wxapi_scene_data_state_token");
        String string = bundle.getString("_wxapi_scene_data_state_jump_info_identifier");
        if (string != null) {
            try {
                IWXStateJumpInfo iWXStateJumpInfo = (IWXStateJumpInfo) a.q(string).newInstance();
                this.stateJumpInfo = iWXStateJumpInfo;
                iWXStateJumpInfo.unserialize(bundle);
            } catch (Exception e) {
                Log.e("MicroMsg.SDK.WXStateSceneDataObject", "get WXSceneDataObject from bundle failed: unknown ident " + string + ", ex = " + e.getMessage());
            }
        }
    }
}
