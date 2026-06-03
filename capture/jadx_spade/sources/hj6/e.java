package hj6;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.INetworkClient;
import com.ss.videoarch.liveplayer.log.LiveError;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e {

    interface a {
        void a(JSONObject jSONObject);

        void onError(LiveError liveError);
    }

    static {
        Covode.recordClassIndex(653079);
    }

    static void a(INetworkClient iNetworkClient, String str, String str2, a aVar) {
        LiveError liveError;
        JSONObject jSONObject;
        if (str2 == null) {
            return;
        }
        INetworkClient.Result doRequest = iNetworkClient.doRequest(str, str2);
        if (doRequest == null) {
            aVar.onError(new LiveError(-100011, "result is null", null));
            return;
        }
        Exception exc = doRequest.e;
        if (exc == null && (jSONObject = doRequest.response) != null) {
            aVar.a(jSONObject);
            return;
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = doRequest.response;
        if (jSONObject2 != null) {
            hashMap.put("rawResp", jSONObject2);
        }
        if (exc instanceof IOException) {
            hashMap.put("description", "network IO exception");
            liveError = new LiveError(-100008, exc.toString(), hashMap);
        } else if (exc instanceof JSONException) {
            hashMap.put("description", "parse JSON failure");
            String str3 = doRequest.body;
            if (str3 != null) {
                hashMap.put("rowBody", str3);
            }
            String str4 = doRequest.header;
            if (str4 != null) {
                hashMap.put("responseHeader", str4);
            }
            liveError = new LiveError(-100000, exc.getMessage(), hashMap);
        } else {
            hashMap.put("description", "response not successful");
            liveError = new LiveError(-100004, exc.getMessage(), hashMap);
        }
        aVar.onError(liveError);
    }
}
