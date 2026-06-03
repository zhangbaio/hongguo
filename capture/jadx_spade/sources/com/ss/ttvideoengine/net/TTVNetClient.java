package com.ss.ttvideoengine.net;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class TTVNetClient {

    public interface CompletionListener {
        void onCompletion(JSONObject jSONObject, Error error);
    }

    public interface RawCompletionListener {
        void onCompletion(String str, Error error);
    }

    static {
        Covode.recordClassIndex(652588);
    }

    public void cancel() {
        TTVideoEngineLog.e("TTVNetClient", "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String str, CompletionListener completionListener) {
        TTVideoEngineLog.e("TTVNetClient", "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String str, Map<String, String> map, CompletionListener completionListener) {
        TTVideoEngineLog.e("TTVNetClient", "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, CompletionListener completionListener) {
        TTVideoEngineLog.e("TTVNetClient", "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, RawCompletionListener rawCompletionListener) {
        TTVideoEngineLog.e("TTVNetClient", "TTVNetClient is a abstract class, imp is null");
    }
}
