package com.xs.fm.player.base.play.data;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.xs.fm.player.base.play.address.PlayAddress;
import java.util.HashMap;
import pk6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayEngineInfo {
    public a audioEffectInfo;
    public a audioLoudestInfo;
    public PlayAddress playAddress;
    public AbsPlayList playList;
    public long playPosition;
    public Resolution resolution;
    public int speed;
    public VoiceBgmInfo voiceBgmInfo;
    public int genreType = 0;
    public String itemId = "";
    public String playBookId = "";
    public int toneId = 0;
    public int bgNoiseId = 0;
    public String playFrom = "unKnow";
    public boolean isOsPlayer = false;
    public String backUrl = "";
    public sk6.a dynamicBuffer = null;
    public int playerFocusDurationHint = -1;
    public boolean enableAudioEffect = false;
    public boolean enableAudioLoudest = false;
    public boolean enableAudioDevicePrepare = false;
    public HashMap<Integer, Object> engineOptions = new HashMap<>();
    public HashMap<String, Object> extras = new HashMap<>();
    public HashMap<String, String> engineHeader = new HashMap<>();
    public HashMap<String, String> monitorExtraInfo = new HashMap<>();

    static {
        Covode.recordClassIndex(655821);
    }

    public String toString() {
        return "PlayEngineInfo{playBookId=" + this.playBookId + ", itemId=" + this.itemId + ", genreType=" + this.genreType + ", startTime=" + this.playPosition + ", speed=" + this.speed + ", toneId=" + this.toneId + ", bgNoiseId=" + this.bgNoiseId + ", playFrom= " + this.playFrom + ", isOsPlayer=" + this.isOsPlayer + ", dynamicBuffer=" + this.dynamicBuffer + ", playFocusDurationHint=" + this.playerFocusDurationHint + ", enableAudioDevicePrepare=" + this.enableAudioDevicePrepare + ", resolution=" + this.resolution + ", enableAudioEffect=" + this.enableAudioEffect + ", audioEffectInfo=" + ((Object) null) + ", enableAudioLoudest=" + this.enableAudioLoudest + ", audioLoudestInfo=" + ((Object) null) + ", backUrl=" + this.backUrl + ", extras=" + this.extras + ", engineOptions=" + this.engineOptions + ", engineHeader=" + this.engineHeader + ", playAddress=" + this.playAddress + '}';
    }

    public void updateSpeed(int i) {
        this.speed = i;
    }

    public boolean isSameWith(PlayEngineInfo playEngineInfo) {
        PlayAddress playAddress;
        if (playEngineInfo != null && (playAddress = this.playAddress) != null && playAddress.isSameWith(playEngineInfo.playAddress) && this.toneId == playEngineInfo.toneId && this.bgNoiseId == playEngineInfo.bgNoiseId && this.speed == playEngineInfo.speed) {
            return true;
        }
        return false;
    }

    public PlayEngineInfo(PlayAddress playAddress, long j, int i) {
        this.playAddress = playAddress;
        this.playPosition = j;
        this.speed = i;
    }

    public PlayEngineInfo appendInfo(AbsPlayList absPlayList, int i, String str, int i2, String str2, int i3, String str3, HashMap<String, Object> hashMap) {
        this.playList = absPlayList;
        this.genreType = i;
        this.itemId = str;
        this.toneId = i2;
        this.extras = hashMap;
        this.bgNoiseId = i3;
        this.playFrom = str3;
        this.playBookId = str2;
        PlayAddress playAddress = this.playAddress;
        if (playAddress != null) {
            this.backUrl = playAddress.backUrl;
        }
        return this;
    }
}
