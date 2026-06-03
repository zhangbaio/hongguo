package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.utils.Log;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WXMusicVipInfo implements SendMessageToWX.IWXMusicVipObject {
    public String musicId;

    static {
        Covode.recordClassIndex(653433);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXMusicVipObject
    public boolean checkArgs() {
        String str;
        String str2 = this.musicId;
        if (str2 == null || str2.length() <= 0) {
            str = "checkArgs fail, musicId is null";
        } else {
            if (this.musicId.length() <= 10240) {
                return true;
            }
            str = "checkArgs fail, musicId length is larger than 1024";
        }
        Log.e("MicroMsg.SDK.WXMusicVipInfo", str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXMusicVipObject
    public void serialize(Bundle bundle) {
        bundle.putString("wx_music_vip_id", this.musicId);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXMusicVipObject
    public void unserialize(Bundle bundle) {
        this.musicId = bundle.getString("wx_music_vip_id", "");
    }
}
