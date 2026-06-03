package jl6;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.VoiceBgmInfoFromServer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static {
        Covode.recordClassIndex(655921);
    }

    public static final boolean b(PlayAddress playAddress) {
        boolean z;
        boolean z2;
        boolean z3;
        if (playAddress == null) {
            Log.i(a.g.n(), "isValidPlay: this is null, return false");
            return false;
        }
        if (playAddress.playType == 0) {
            String str = playAddress.playUrl;
            if (str != null && str.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                Log.i(a.g.n(), "isValidPlay: this.playType == PlayAddress.PLAY_TYPE_URL && this.playUrl.isNullOrEmpty(), return false");
                return false;
            }
        }
        if (playAddress.playType == 2) {
            String str2 = playAddress.playVideoModel;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                Log.i(a.g.n(), "isValidPlay: this.playType == PlayAddress.PLAY_TYPE_VIDEO_MODEL && this.playVideoModel.isNullOrEmpty(), return false");
                return false;
            }
        }
        if (playAddress.playType == 1) {
            String str3 = playAddress.playFile;
            if (str3 != null && str3.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                Log.i(a.g.n(), "isValidPlay: this.playType == PlayAddress.PLAY_TYPE_FILE && this.playFile.isNullOrEmpty(), return false");
                return false;
            }
        }
        return true;
    }

    public static final PlayAddress a(PlayAddress playAddress) {
        if (playAddress == null) {
            return null;
        }
        PlayAddress playAddress2 = new PlayAddress();
        playAddress2.playType = playAddress.playType;
        playAddress2.playUrl = playAddress.playUrl;
        playAddress2.playFile = playAddress.playFile;
        playAddress2.playVideoModel = playAddress.playVideoModel;
        playAddress2.videoId = playAddress.videoId;
        playAddress2.backUrl = playAddress.backUrl;
        playAddress2.cacheKey = playAddress.cacheKey;
        playAddress2.isFromDisk = playAddress.isFromDisk;
        playAddress2.isFromCache = playAddress.isFromCache;
        playAddress2.cacheType = playAddress.cacheType;
        playAddress2.tag = playAddress.tag;
        playAddress2.subTag = playAddress.subTag;
        playAddress2.customStr = playAddress.customStr;
        playAddress2.volumeBalanceType = playAddress.volumeBalanceType;
        playAddress2.volumeBalanceTargetLoudness = playAddress.volumeBalanceTargetLoudness;
        playAddress2.aeConfigJsonStr = playAddress.aeConfigJsonStr;
        playAddress2.volumeBalanceSrcLoudness = playAddress.volumeBalanceSrcLoudness;
        playAddress2.volumeBalanceLoudPeak = playAddress.volumeBalanceLoudPeak;
        playAddress2.balanceData = playAddress.balanceData;
        playAddress2.forceBackCompressor = playAddress.forceBackCompressor;
        playAddress2.isEncrypt = playAddress.isEncrypt;
        playAddress2.encryptionKey = playAddress.encryptionKey;
        playAddress2.openingTime = playAddress.openingTime;
        playAddress2.endingTime = playAddress.endingTime;
        playAddress2.fetchTime = playAddress.fetchTime;
        playAddress2.mdlCachePath = playAddress.mdlCachePath;
        playAddress2.extras = playAddress.extras;
        if (playAddress.voiceBgmInfoFromServer != null) {
            VoiceBgmInfoFromServer voiceBgmInfoFromServer = new VoiceBgmInfoFromServer();
            VoiceBgmInfoFromServer voiceBgmInfoFromServer2 = playAddress.voiceBgmInfoFromServer;
            voiceBgmInfoFromServer.bgmVideoModelStr = voiceBgmInfoFromServer2.bgmVideoModelStr;
            voiceBgmInfoFromServer.bgMixRadio = voiceBgmInfoFromServer2.bgMixRadio;
            voiceBgmInfoFromServer.originVideoModelStr = voiceBgmInfoFromServer2.originVideoModelStr;
            voiceBgmInfoFromServer.defaultBGAdjust = voiceBgmInfoFromServer2.defaultBGAdjust;
            playAddress2.voiceBgmInfoFromServer = voiceBgmInfoFromServer;
        }
        return playAddress2;
    }
}
