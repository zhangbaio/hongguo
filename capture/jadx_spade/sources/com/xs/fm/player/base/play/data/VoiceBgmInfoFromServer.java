package com.xs.fm.player.base.play.data;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoModel;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VoiceBgmInfoFromServer implements Serializable {

    @SerializedName("bg_mix_radio")
    public long bgMixRadio;
    public VideoModel bgmVideoModel;

    @SerializedName("bgm_video_model")
    public String bgmVideoModelStr;

    @SerializedName("default_bg_adjust")
    public boolean defaultBGAdjust;

    @SerializedName("origin_video_model")
    public String originVideoModelStr;

    static {
        Covode.recordClassIndex(655825);
    }

    public String toString() {
        return "VoiceBgmInfoFromServer{bgmVideoModelStr='" + this.bgmVideoModelStr + "', bgmVideoModel=" + this.bgmVideoModel + ", originVideoModelStr='" + this.originVideoModelStr + "', bgMixRadio=" + this.bgMixRadio + ", defaultBGAdjust=" + this.defaultBGAdjust + '}';
    }

    public boolean isTwoChannelSource(String str) {
        return TextUtils.equals(str, this.originVideoModelStr);
    }
}
