package com.xs.fm.player.base.play.address;

import android.text.TextUtils;
import bl6.a;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoModel;
import com.xs.fm.player.base.play.data.BalanceData;
import com.xs.fm.player.base.play.data.VoiceBgmInfoFromServer;
import java.io.Serializable;
import java.util.HashMap;
import lk6.c;
import xk6.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayAddress implements Serializable {
    private static final a mLog;
    public String aeConfigJsonStr;
    public String backUrl;
    public BalanceData balanceData;
    public String cacheKey;
    public String encryptionKey;
    public boolean forceBackCompressor;
    public boolean isEncrypt;
    public String mdlCachePath;
    public String playFile;
    public String playUrl;
    public String playVideoModel;
    public String subTag;
    public String tag;
    public String videoId;
    public VideoModel videoModel;
    public VoiceBgmInfoFromServer voiceBgmInfoFromServer;
    public int playType = 0;
    public boolean isFromDisk = false;
    public boolean isFromCache = false;
    public int cacheType = 0;
    public HashMap<String, Object> customStr = new HashMap<>();
    public int volumeBalanceType = -1;
    public float volumeBalanceTargetLoudness = 0.0f;
    public float volumeBalanceSrcLoudness = 0.0f;
    public float volumeBalanceLoudPeak = 0.0f;
    public int openingTime = -1;
    public int endingTime = -1;
    public long fetchTime = 0;
    public HashMap<String, Object> extras = new HashMap<>();

    static {
        Covode.recordClassIndex(655811);
        mLog = new a("FMSDKPlayerTrace-PlayAddress");
    }

    public boolean isFourChannelSource() {
        VoiceBgmInfoFromServer voiceBgmInfoFromServer = this.voiceBgmInfoFromServer;
        if (voiceBgmInfoFromServer != null && !TextUtils.isEmpty(voiceBgmInfoFromServer.bgmVideoModelStr)) {
            return TextUtils.equals(this.voiceBgmInfoFromServer.bgmVideoModelStr, this.playVideoModel);
        }
        return false;
    }

    public boolean isValidExpiredTime() {
        if (System.currentTimeMillis() - this.fetchTime < c.a.m.i()) {
            mLog.d("addressCacheNotExpired", new Object[0]);
            return true;
        }
        mLog.d("addressCacheExpired", new Object[0]);
        return false;
    }

    public String toString() {
        return "PlayAddress{playType=" + this.playType + ", playUrl='" + this.playUrl + "', playFile='" + this.playFile + "', tag='" + this.tag + "', subTag='" + this.subTag + "', volumeBalanceType=" + this.volumeBalanceType + ", volumeBalanceLoudness=" + this.volumeBalanceTargetLoudness + ", volumeBalanceLoudPeak=" + this.volumeBalanceLoudPeak + ", isEncrypt=" + this.isEncrypt + ", encryptionKey='" + this.encryptionKey + "', mdlCachePath='" + this.mdlCachePath + "', openingTime='" + this.openingTime + "', endingTime='" + this.endingTime + "', playVideoModel='" + this.playVideoModel + "'}";
    }

    public boolean isSameWith(PlayAddress playAddress) {
        if (playAddress != null && TextUtils.equals(this.playUrl, playAddress.playUrl) && TextUtils.equals(this.playFile, playAddress.playFile) && isSameVideoModel(this.playVideoModel, playAddress.playVideoModel) && TextUtils.equals(this.tag, playAddress.tag) && TextUtils.equals(this.subTag, playAddress.subTag) && this.volumeBalanceType == playAddress.volumeBalanceType && this.volumeBalanceTargetLoudness == playAddress.volumeBalanceTargetLoudness && this.volumeBalanceLoudPeak == playAddress.volumeBalanceLoudPeak && this.isEncrypt == playAddress.isEncrypt && TextUtils.equals(this.encryptionKey, playAddress.encryptionKey) && this.openingTime == playAddress.openingTime && this.endingTime == playAddress.endingTime) {
            return true;
        }
        return false;
    }

    public boolean isSameVideoModel(String str, String str2) {
        if (c.a.l.c0()) {
            h hVar = h.a;
            return hVar.d(hVar.b(str), hVar.b(str2));
        }
        return TextUtils.equals(str, str2);
    }
}
