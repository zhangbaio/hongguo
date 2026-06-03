package pl6;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.IPlayManager;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static {
        Covode.recordClassIndex(655962);
    }

    public static final void d(String str, int i, boolean z) {
        if (!StringsKt__StringsJVMKt.endsWith$default(str, "_retry", false, 2, null)) {
            return;
        }
        try {
            ik6.a aVar = lk6.c.a.f;
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("retry_count", Integer.valueOf(i));
                jSONObject.putOpt("preload_scene", str);
                jSONObject.putOpt("success", Boolean.valueOf(z));
                aVar.onEvent("media_loader_retry_succeed", jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    public static final void a(String str, long j, PlayEngineInfo playEngineInfo, boolean z) {
        String str2;
        String str3;
        int i;
        PlayAddress playAddress;
        if (j < 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("cacheKey", str);
            jSONObject.putOpt("cacheSize", Long.valueOf(j));
            Integer num = null;
            if (playEngineInfo != null) {
                str2 = playEngineInfo.itemId;
            } else {
                str2 = null;
            }
            jSONObject.putOpt("chapter_id", str2);
            if (playEngineInfo != null && (playAddress = playEngineInfo.playAddress) != null) {
                str3 = playAddress.tag;
            } else {
                str3 = null;
            }
            jSONObject.putOpt("tag", str3);
            if (playEngineInfo != null) {
                num = Integer.valueOf(playEngineInfo.genreType);
            }
            jSONObject.putOpt("genre_type", num);
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            jSONObject.putOpt("is_first_hit_mdl_cache", Boolean.valueOf(z));
            jSONObject.putOpt("is_from_fm_sdk", Boolean.TRUE);
            xk6.a g = xk6.a.g();
            Intrinsics.checkExpressionValueIsNotNull(g, "AppLifecycleMonitor.getInstance()");
            int i2 = 1;
            if (g.b) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.putOpt("is_foreground", Integer.valueOf(i));
            if (!xk6.b.a(new Pair("20:30", "22:30"))) {
                i2 = 0;
            }
            jSONObject.putOpt("is_night_rush_hour", Integer.valueOf(i2));
            lk6.c.a.f.onEvent("audio_player_preload", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void c(String str, Long l, int i, String str2, String str3) {
        int i2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("chapter_id", str);
            jSONObject.putOpt("toneId", l);
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
            jSONObject.putOpt("preload_scene", str3);
            ik6.a aVar = lk6.c.a.f;
            if (aVar != null) {
                aVar.onEvent("media_loader_preload_finish", jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void e(String str, long j, int i, String str2, int i2, String str3) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("chapter_id", str);
            jSONObject.putOpt("toneId", Long.valueOf(j));
            jSONObject.putOpt("genre_type", Integer.valueOf(i));
            jSONObject.putOpt("bookId", str2);
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            if (B.isPlaying()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.putOpt("is_playing", Integer.valueOf(i3));
            jSONObject.putOpt("network_available", Boolean.valueOf(NetworkUtils.isNetworkAvailable(lk6.c.a.b)));
            jSONObject.putOpt("net_rank", NetworkUtils.getNetworkAccessType(lk6.c.a.b));
            jSONObject.putOpt("real_error_code", Integer.valueOf(i2));
            jSONObject.putOpt("error_msg", str3);
            ik6.a aVar = lk6.c.a.f;
            if (aVar != null) {
                aVar.onEvent("audio_preload_failed", jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void b(String str, long j, String str2, String str3, long j2, int i, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                str = "";
            }
            jSONObject.putOpt("error_code", str);
            jSONObject.putOpt("preload_size", Long.valueOf(j));
            jSONObject.putOpt("chapter_id", str2);
            jSONObject.putOpt("toneId", Long.valueOf(j2));
            jSONObject.putOpt("genre_type", Integer.valueOf(i));
            jSONObject.putOpt("bookId", str3);
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            jSONObject.putOpt("network_available", Boolean.valueOf(NetworkUtils.isNetworkAvailable(lk6.c.a.b)));
            jSONObject.putOpt("net_rank", NetworkUtils.getNetworkAccessType(lk6.c.a.b));
            jSONObject.putOpt("preload_scene", str4);
            ik6.a aVar = lk6.c.a.f;
            if (aVar != null) {
                aVar.onEvent("media_loader_preload_fail", jSONObject);
            }
        } catch (JSONException unused) {
        }
    }
}
