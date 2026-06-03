package ik6;

import com.xs.fm.player.base.play.data.PlayEngineInfo;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a {
    void a(Throwable th, PlayEngineInfo playEngineInfo, JSONObject jSONObject);

    void onEvent(String str, JSONObject jSONObject);

    JSONObject w();
}
