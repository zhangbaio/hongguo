package com.dragon.read.mgl.service;

import android.os.Bundle;
import com.bytedance.bdp.bdpbase.ipc.IpcBaseCallback;
import com.bytedance.covode.number.Covode;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AwemeIpcProviderImpl implements AwemeIpcProvider {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(611962);
    }

    public static final class a implements JsEventSubscriber {
        final /* synthetic */ IpcBaseCallback<Bundle> a;

        a(IpcBaseCallback<Bundle> ipcBaseCallback) {
            this.a = ipcBaseCallback;
        }

        public void onReceiveJsEvent(Js2NativeEvent jsEvent) {
            JSONObject jSONObject;
            Map map;
            Intrinsics.checkNotNullParameter(jsEvent, "jsEvent");
            XReadableMap params = jsEvent.getParams();
            if (params != null && (map = params.toMap()) != null) {
                jSONObject = new JSONObject(map);
            } else {
                jSONObject = new JSONObject();
            }
            Bundle bundle = new Bundle();
            bundle.putString("eventName", jsEvent.getEventName());
            bundle.putString("data", jSONObject.toString());
            this.a.onResponse(100, (String) null, bundle);
        }
    }

    @Override // com.dragon.read.mgl.service.AwemeIpcProvider
    public void sendPageEvent(String str, JSONObject jSONObject) {
        if (str == null) {
            str = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        EventCenter.enqueueEvent(new Event(str, currentTimeMillis, new ReadableMapImpl(jSONObject)));
    }

    @Override // com.dragon.read.mgl.service.AwemeIpcProvider
    public void handlePageEventListener(String str, boolean z, IpcBaseCallback<Bundle> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a(callback);
        if (z) {
            if (str == null) {
                str = "";
            }
            EventCenter.registerJsEventSubscriber(str, aVar);
        } else {
            if (str == null) {
                str = "";
            }
            EventCenter.unregisterJsEventSubscriber(str, aVar);
        }
    }
}
