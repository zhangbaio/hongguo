package com.dragon.read.mgl.service;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.platform.internal.AMglInvCallerService;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.interfaces.BdpHostAudioEventDispatcher;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BdpHostAudioEventDispatcherImpl implements BdpHostAudioEventDispatcher {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(611965);
    }

    public void dispatchHostAudioStateChange(boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_playing", z);
        BdpManager.getInst().getService(AMglInvCallerService.class).dispatchHostEvent("event_host_audio_state_change", jSONObject);
    }
}
