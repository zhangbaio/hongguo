package ql6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    private static long a;

    static {
        Covode.recordClassIndex(655977);
    }

    public static final void a(PlayEngineInfo playEngineInfo) {
        Integer num;
        Integer num2;
        String str;
        String str2;
        PlayAddress playAddress;
        try {
            JSONObject jSONObject = new JSONObject();
            nk6.f fVar = lk6.c.a.o;
            Integer num3 = null;
            if (fVar != null) {
                num = Integer.valueOf(fVar.c());
            } else {
                num = null;
            }
            jSONObject.putOpt("prepare_size", num);
            nk6.e eVar = lk6.c.a.n;
            if (eVar != null) {
                num2 = Integer.valueOf(eVar.J());
            } else {
                num2 = null;
            }
            jSONObject.putOpt("preload_size", num2);
            if (playEngineInfo != null) {
                str = playEngineInfo.itemId;
            } else {
                str = null;
            }
            jSONObject.putOpt("chapter_id", str);
            if (playEngineInfo != null && (playAddress = playEngineInfo.playAddress) != null) {
                str2 = playAddress.tag;
            } else {
                str2 = null;
            }
            jSONObject.putOpt("tag", str2);
            if (playEngineInfo != null) {
                num3 = Integer.valueOf(playEngineInfo.genreType);
            }
            jSONObject.putOpt("genre_type", num3);
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            lk6.c.a.f.onEvent("audio_prepare_success", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void b(boolean z, PlayEngineInfo playEngineInfo) {
        String str;
        String str2;
        PlayAddress playAddress;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("prepare_size", Integer.valueOf(lk6.c.a.o.c()));
            jSONObject.putOpt("preload_size", Integer.valueOf(lk6.c.a.n.J()));
            Integer num = null;
            if (playEngineInfo != null) {
                str = playEngineInfo.itemId;
            } else {
                str = null;
            }
            jSONObject.putOpt("chapter_id", str);
            if (playEngineInfo != null && (playAddress = playEngineInfo.playAddress) != null) {
                str2 = playAddress.tag;
            } else {
                str2 = null;
            }
            jSONObject.putOpt("tag", str2);
            if (playEngineInfo != null) {
                num = Integer.valueOf(playEngineInfo.genreType);
            }
            jSONObject.putOpt("genre_type", num);
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            Boolean bool = Boolean.TRUE;
            jSONObject.putOpt("is_from_fm_sdk", bool);
            if (z) {
                jSONObject.putOpt("is_start", bool);
                a = System.currentTimeMillis();
            } else {
                jSONObject.putOpt("is_end", bool);
                jSONObject.putOpt("prepare_cost_time", Long.valueOf(System.currentTimeMillis() - a));
                a = 0L;
            }
            lk6.c.a.f.onEvent("event_audio_prepare", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void c(String str, String str2, int i, int i2, String str3) {
        Integer num;
        try {
            JSONObject jSONObject = new JSONObject();
            nk6.f fVar = lk6.c.a.o;
            Integer num2 = null;
            if (fVar != null) {
                num = Integer.valueOf(fVar.c());
            } else {
                num = null;
            }
            jSONObject.putOpt("prepare_size", num);
            nk6.e eVar = lk6.c.a.n;
            if (eVar != null) {
                num2 = Integer.valueOf(eVar.J());
            }
            jSONObject.putOpt("preload_size", num2);
            jSONObject.putOpt("chapter_id", str);
            jSONObject.putOpt("tag", str2);
            jSONObject.putOpt("genre_type", Integer.valueOf(i));
            jSONObject.putOpt("play_path_event", zk6.c.l.k());
            jSONObject.putOpt("is_success", "0");
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
            jSONObject.putOpt("error_msg", str3);
            lk6.c.a.f.onEvent("event_audio_prepare", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
