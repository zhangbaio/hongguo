package com.dragon.read.mgl.service;

import android.os.Bundle;
import com.bytedance.bdp.bdpbase.ipc.IpcBaseCallback;
import com.bytedance.bdp.bdpbase.ipc.IpcInterface;
import com.bytedance.bdp.bdpbase.ipc.annotation.Callback;
import com.bytedance.bdp.bdpbase.ipc.annotation.RemoteInterface;
import org.json.JSONObject;

@RemoteInterface(implementClass = AwemeIpcProviderImpl.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface AwemeIpcProvider extends IpcInterface {
    void handlePageEventListener(String str, boolean z, @Callback IpcBaseCallback<Bundle> ipcBaseCallback);

    void sendPageEvent(String str, JSONObject jSONObject);
}
