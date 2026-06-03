package com.ss.videoarch.liveplayer;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.log.VeLivePlayerLogConfig;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class o {
    static {
        Covode.recordClassIndex(652949);
    }

    public static String getVersion() {
        return "1.10.227.4-aweme";
    }

    public abstract void destroy();

    public abstract void enableAudioFrameObserver(boolean z, boolean z2, VeLivePlayerDef$VeLivePlayerAudioBufferType veLivePlayerDef$VeLivePlayerAudioBufferType);

    public abstract void enableVideoFrameObserver(boolean z, VeLivePlayerDef$VeLivePlayerPixelFormat veLivePlayerDef$VeLivePlayerPixelFormat, VeLivePlayerDef$VeLivePlayerVideoBufferType veLivePlayerDef$VeLivePlayerVideoBufferType);

    public abstract boolean isMute();

    public abstract boolean isPlaying();

    public abstract int isSupportResolutionSwitch(s sVar);

    public abstract void pause();

    public abstract void play();

    public abstract void setConfig(r rVar);

    public abstract void setEnableSuperResolution(boolean z);

    public abstract void setIAppInfoFetcher(b bVar);

    public abstract void setLiveEnsuer(d dVar);

    public abstract void setMute(boolean z);

    public abstract void setNetworkClient(INetworkClient iNetworkClient);

    public abstract void setObserver(u uVar);

    public abstract void setPlayStreamData(w wVar);

    public abstract void setPlayUrl(String str);

    public abstract void setPlayerVolume(float f);

    public abstract void setProperty(String str, Object obj);

    public abstract void setRenderFillMode(VeLivePlayerDef$VeLivePlayerFillMode veLivePlayerDef$VeLivePlayerFillMode);

    public abstract void setRenderMirror(VeLivePlayerDef$VeLivePlayerMirror veLivePlayerDef$VeLivePlayerMirror);

    public abstract void setRenderRotation(VeLivePlayerDef$VeLivePlayerRotation veLivePlayerDef$VeLivePlayerRotation);

    public abstract void setSdkParamsJson(String str, String str2, JSONObject jSONObject);

    public abstract void setSettingsBundle(ILiveSettingBundle iLiveSettingBundle);

    public abstract void setStreamInfoAndSdkParams(JSONObject jSONObject, String str, String str2, JSONObject jSONObject2);

    public abstract void setSurface(Surface surface);

    public abstract void setSurfaceHolder(SurfaceHolder surfaceHolder);

    public abstract void setUrlHostIP(Map<String, List<String>> map);

    public abstract int snapshot();

    public abstract void stop();

    public abstract boolean switchResolution(s sVar);

    public static void setLogConfig(VeLivePlayerLogConfig veLivePlayerLogConfig) {
        com.ss.videoarch.liveplayer.log.b.g(veLivePlayerLogConfig);
    }

    public static void setLogLevel(VeLivePlayerLogConfig.VeLivePlayerLogLevel veLivePlayerLogLevel) {
        com.ss.videoarch.liveplayer.log.a.d(veLivePlayerLogLevel);
    }
}
