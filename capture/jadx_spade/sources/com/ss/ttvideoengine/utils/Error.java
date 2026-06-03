package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Error {
    public int code;
    public String description;
    public String domain;
    public int internalCode;
    public Map parameters;

    static {
        Covode.recordClassIndex(652744);
    }

    private boolean needFetch() {
        if (this.code == -499897) {
            return true;
        }
        return false;
    }

    private boolean needRestartPlayer() {
        int i = this.code;
        if (i != -499999 && i != -499997 && i != -499996 && i != -499992 && i != -499991 && i != -499990 && i != -499989 && i != -2139062143) {
            return false;
        }
        return true;
    }

    public int getType() {
        if (this.domain.equals("kTTVideoErrorDomainFetchingInfo")) {
            return 1000;
        }
        if (!this.domain.equals("kTTVideoErrorDomainLocalDNS") && !this.domain.equals("kTTVideoErrorDomainHTTPDNS")) {
            if (this.domain.equals("kTTVideoErrorDomainVideoOwnPlayer") && needRestartPlayer()) {
                return 1002;
            }
            return 1003;
        }
        return 1001;
    }

    public boolean isPlayerErrorDomain() {
        if (TextUtils.isEmpty(this.domain)) {
            return false;
        }
        if (!this.domain.equals("kTTVideoErrorDomainVideoOwnPlayer") && !this.domain.equals("kTTVideoErrorDomainVideoOSPlayer") && !this.domain.equals("kTTVideoErrorDomainVideoExoPlayer")) {
            return false;
        }
        return true;
    }

    public HashMap toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("domain", this.domain);
        hashMap.put("code", Integer.valueOf(this.code));
        int i = this.internalCode;
        if (i != 0) {
            hashMap.put("internalCode", Integer.valueOf(i));
        }
        String str = this.description;
        if (str != null) {
            hashMap.put("description", str);
        }
        return hashMap;
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = this.domain;
        objArr[1] = Integer.valueOf(this.code);
        objArr[2] = Integer.valueOf(this.internalCode);
        String str = this.description;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("domain:%s, code:%d, internalCode:%d, description:%s", objArr);
    }

    private boolean needChangeURL() {
        int i = this.code;
        if (i != -499988 && i != -499987 && i != -499986 && i != -499985 && i != -499899 && i != -499898 && i != -499896 && i != -499894 && i != -499893 && i != -499891 && i != 251658241 && i != -499799 && i != -499795 && i != -499794 && i != -499793 && i != -499792) {
            return false;
        }
        return true;
    }

    public int getRetryStrategy() {
        if (!this.domain.equals("kTTVideoErrorDomainHTTPDNS") && !this.domain.equals("kTTVideoErrorDomainLocalDNS")) {
            if (this.domain.equals("kTTVideoErrorDomainFetchingInfo")) {
                return 1;
            }
            if (this.domain.equals("kTTVideoErrorDomainVideoOwnPlayer")) {
                if (needChangeURL()) {
                    return 2;
                }
                if (needRestartPlayer()) {
                    return 3;
                }
                if (needFetch()) {
                    return 1;
                }
            }
            if (this.domain.equals("kTTVideoErrorDomainVideoExoPlayer") && needFetch()) {
                return 1;
            }
        }
        return 2;
    }

    public static String getDomainForPlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return "";
        }
        int playerType = mediaPlayer.getPlayerType();
        if (playerType != 0) {
            if (playerType != 1 && playerType != 2 && playerType != 3 && playerType != 4) {
                if (playerType != 5) {
                    return "";
                }
                return "kTTVideoErrorDomainVideoExoPlayer";
            }
            return "kTTVideoErrorDomainVideoOwnPlayer";
        }
        return "kTTVideoErrorDomainVideoOSPlayer";
    }

    public Error(String str, int i) {
        this(str, i, 0);
    }

    public Error(String str, int i, int i2) {
        this(str, i, i2, null);
    }

    public static Error createForPlayer(MediaPlayer mediaPlayer, int i, String str) {
        return new Error(getDomainForPlayer(mediaPlayer), i, str);
    }

    public Error(String str, int i, String str2) {
        this(str, i, 0, str2);
    }

    public Error(String str, int i, int i2, String str2) {
        this.domain = str;
        this.code = i;
        this.internalCode = i2;
        this.description = str2;
        this.parameters = new HashMap();
    }
}
