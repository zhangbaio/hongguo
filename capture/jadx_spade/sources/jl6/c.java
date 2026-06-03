package jl6;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.inter.IPlayManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    static {
        Covode.recordClassIndex(655922);
    }

    public static final void b(String str, long j, int i, String str2) {
        int i2;
        if (!pl6.a.a.a()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("chapterId", str);
            jSONObject.putOpt("toneId", Long.valueOf(j));
            jSONObject.putOpt("genre_type", Integer.valueOf(i));
            jSONObject.putOpt("bookId", str2);
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            if (B.isPlaying()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            jSONObject.putOpt("is_playing", Integer.valueOf(i2));
            jSONObject.putOpt("network_available", Boolean.valueOf(NetworkUtils.isNetworkAvailable(lk6.c.a.b)));
            jSONObject.putOpt("net_rank", NetworkUtils.getNetworkAccessType(lk6.c.a.b));
            lk6.c.a.f.onEvent("event_preload_request_play_info", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void a(String str, boolean z, boolean z2, long j, int i, String str2) {
        if (!pl6.a.a.a()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("cacheKey", str);
            jSONObject.putOpt("hasHitCache", Boolean.valueOf(z));
            jSONObject.putOpt("wasteCacheTime", Long.valueOf(j));
            jSONObject.putOpt("isEnablePreloadNext", Boolean.valueOf(z2));
            jSONObject.putOpt("genre_type", Integer.valueOf(i));
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            jSONObject.putOpt("real_play_entrance", str2);
            lk6.c.a.f.onEvent("audio_play_info_cache", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
