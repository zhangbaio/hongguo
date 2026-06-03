package ml6;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.IPlayManager;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    public static final b a;

    private b() {
    }

    static {
        Covode.recordClassIndex(655941);
        a = new b();
    }

    private final int a(int i) {
        return (int) ((i / xk6.c.e.e()) * 100);
    }

    public final void e(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("listener_error_msg", str);
            jSONObject.putOpt("is_from_fm_sdk", Boolean.TRUE);
            lk6.c.a.f.onEvent("play_listener_handler", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static final void j(PlayEngineInfo playEngineInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("genre_type", Integer.valueOf(playEngineInfo.genreType));
            jSONObject.putOpt("item_id", playEngineInfo.itemId);
            jSONObject.putOpt("tone_id", Integer.valueOf(playEngineInfo.toneId));
            jSONObject.putOpt("is_from_fm_sdk", Boolean.TRUE);
            lk6.c.a.f.onEvent("try_with_video_model_is_null", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1 A[Catch: Exception -> 0x00c3, LOOP:0: B:15:0x009b->B:17:0x00a1, LOOP_END, TryCatch #0 {Exception -> 0x00c3, blocks: (B:3:0x0001, B:5:0x007f, B:10:0x008b, B:12:0x008f, B:14:0x0095, B:15:0x009b, B:17:0x00a1, B:19:0x00b5, B:21:0x00b9, B:23:0x00bd), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(yk6.e r7) {
        /*
            r6 = this;
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> Lc3
            java.lang.String r2 = r7.j     // Catch: java.lang.Exception -> Lc3
            r1.<init>(r2)     // Catch: java.lang.Exception -> Lc3
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> Lc3
            r2.<init>()     // Catch: java.lang.Exception -> Lc3
            r6.b(r1, r2)     // Catch: java.lang.Exception -> Lc3
            ml6.b r1 = ml6.b.a     // Catch: java.lang.Exception -> Lc3
            int r3 = r7.c     // Catch: java.lang.Exception -> Lc3
            int r3 = r1.a(r3)     // Catch: java.lang.Exception -> Lc3
            int r4 = r7.d     // Catch: java.lang.Exception -> Lc3
            int r1 = r1.a(r4)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "vid"
            java.lang.String r5 = r7.h     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r5)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "start_volume"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r5)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "end_volume"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r5)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "play_tag"
            java.lang.String r5 = r7.g     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r5)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "item_id"
            java.lang.String r5 = r7.a     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r5)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "tone_id"
            int r5 = r7.b     // Catch: java.lang.Exception -> Lc3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r5)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "genre_type"
            int r5 = r7.f     // Catch: java.lang.Exception -> Lc3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r5)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r4 = "volume_diff"
            int r1 = r1 - r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r4, r1)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r1 = "change_number"
            int r3 = r7.e     // Catch: java.lang.Exception -> Lc3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r1, r3)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r1 = "source_loudness"
            float r3 = r7.i     // Catch: java.lang.Exception -> Lc3
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r1, r3)     // Catch: java.lang.Exception -> Lc3
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.k     // Catch: java.lang.Exception -> Lc3
            if (r1 == 0) goto L88
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> Lc3
            if (r1 == 0) goto L86
            goto L88
        L86:
            r1 = 0
            goto L89
        L88:
            r1 = 1
        L89:
            if (r1 != 0) goto Lb5
            java.util.Map<java.lang.String, java.lang.String> r7 = r7.k     // Catch: java.lang.Exception -> Lc3
            if (r7 == 0) goto Lb5
            java.util.Set r7 = r7.entrySet()     // Catch: java.lang.Exception -> Lc3
            if (r7 == 0) goto Lb5
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Exception -> Lc3
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Exception -> Lc3
        L9b:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> Lc3
            if (r1 == 0) goto Lb5
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Exception -> Lc3
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Exception -> Lc3
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Exception -> Lc3
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> Lc3
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Exception -> Lc3
            r2.putOpt(r3, r1)     // Catch: java.lang.Exception -> Lc3
            goto L9b
        Lb5:
            lk6.b r7 = lk6.c.a     // Catch: java.lang.Exception -> Lc3
            if (r7 == 0) goto Le5
            ik6.a r7 = r7.f     // Catch: java.lang.Exception -> Lc3
            if (r7 == 0) goto Le5
            java.lang.String r1 = "audio_quality_info"
            r7.onEvent(r1, r2)     // Catch: java.lang.Exception -> Lc3
            goto Le5
        Lc3:
            r7 = move-exception
            bl6.a r1 = new bl6.a
            java.lang.String r2 = "PlayMonitorUtil"
            r1.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "reportAudioQualityInfo failed! \n exception = "
            r2.append(r3)
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1.b(r7, r0)
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ml6.b.c(yk6.e):void");
    }

    private final void b(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "sourceJson.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            if (jSONObject.opt(next) instanceof JSONObject) {
                Object opt = jSONObject.opt(next);
                if (opt != null) {
                    b((JSONObject) opt, jSONObject2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else if (!(jSONObject.opt(next) instanceof JSONArray)) {
                jSONObject2.put(next, jSONObject.opt(next));
            }
        }
    }

    public final void h(long j, int i) {
        String str;
        ik6.a aVar;
        try {
            JSONObject jSONObject = new JSONObject();
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            AbsPlayList currentList = B.getCurrentList();
            Integer num = null;
            if (currentList != null) {
                str = currentList.getListId();
            } else {
                str = null;
            }
            jSONObject.putOpt("bookId", str);
            IPlayManager B2 = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B2, "PlayManager.getInstance()");
            jSONObject.putOpt("item_id", B2.getCurrentItemId());
            IPlayManager B3 = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B3, "PlayManager.getInstance()");
            AbsPlayList currentList2 = B3.getCurrentList();
            if (currentList2 != null) {
                num = Integer.valueOf(currentList2.getGenreType());
            }
            jSONObject.putOpt("genre_type", num);
            jSONObject.putOpt("start_silence_pos", Integer.valueOf(i));
            jSONObject.putOpt("report_silence_time", Long.valueOf(j));
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (aVar = bVar.f) != null) {
                aVar.onEvent("play_silence_event", jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    public final void d(String str, int i, int i2, String str2) {
        Integer num;
        ik6.a aVar;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("item_id", str);
            jSONObject.putOpt("genre_type", Integer.valueOf(i));
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
            jSONObject.putOpt("error_msg", str2);
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            jSONObject.putOpt("cur_play_item_id", B.getCurrentItemId());
            IPlayManager B2 = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B2, "PlayManager.getInstance()");
            AbsPlayList currentList = B2.getCurrentList();
            if (currentList != null) {
                num = Integer.valueOf(currentList.getGenreType());
            } else {
                num = null;
            }
            jSONObject.putOpt("cur_play_genre_type", num);
            IPlayManager B3 = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B3, "PlayManager.getInstance()");
            jSONObject.putOpt("is_same_Item_id", Boolean.valueOf(TextUtils.equals(str, B3.getCurrentItemId())));
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (aVar = bVar.f) != null) {
                aVar.onEvent("event_cancel_play_error", jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    public final void i(String str, boolean z, String str2, boolean z2, String str3) {
        ik6.a aVar;
        if (z || z2) {
            try {
                IPlayManager B = il6.a.B();
                Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
                AbsPlayList currentList = B.getCurrentList();
                if (currentList != null) {
                    Intrinsics.checkExpressionValueIsNotNull(currentList, "PlayManager.getInstance().currentList ?: return");
                    IPlayManager B2 = il6.a.B();
                    Intrinsics.checkExpressionValueIsNotNull(B2, "PlayManager.getInstance()");
                    String currentItemId = B2.getCurrentItemId();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("genre_type", Integer.valueOf(currentList.getGenreType()));
                    jSONObject.putOpt("bookId", currentList.getListId());
                    jSONObject.putOpt("item_id", currentItemId);
                    jSONObject.putOpt("is_from_fm_sdk", Boolean.TRUE);
                    jSONObject.putOpt("has_tip_play", Boolean.valueOf(z));
                    jSONObject.putOpt("tip_play_name", str2);
                    jSONObject.putOpt("is_intercept_play", Boolean.valueOf(z2));
                    jSONObject.putOpt("intercept_play_trace", str);
                    jSONObject.putOpt("intercept_play_name", str3);
                    lk6.b bVar = lk6.c.a;
                    if (bVar != null && (aVar = bVar.f) != null) {
                        aVar.onEvent("play_intercept_event", jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void g(PlayEngineInfo playEngineInfo, String str, String str2, int i, String str3) {
        boolean z;
        JSONObject jSONObject;
        String str4;
        if (playEngineInfo == null) {
            return;
        }
        if (playEngineInfo.playAddress.playType == 2) {
            z = true;
        } else {
            z = false;
        }
        try {
            lk6.b bVar = lk6.c.a;
            Application application = bVar.b;
            ik6.a aVar = bVar.f;
            if (aVar != null && (jSONObject = aVar.w()) != null) {
                jSONObject.putOpt("err_type", str2);
                jSONObject.putOpt("real_error_code", Integer.valueOf(i));
                jSONObject.putOpt("error_msg", str3);
                jSONObject.putOpt("play_type", str);
                jSONObject.putOpt("genre_type", Integer.valueOf(playEngineInfo.genreType));
                jSONObject.putOpt("item_id", playEngineInfo.itemId);
                jSONObject.putOpt("tone_id", Integer.valueOf(playEngineInfo.toneId));
                jSONObject.putOpt("is_video_model_api", Boolean.valueOf(z));
                PlayAddress playAddress = playEngineInfo.playAddress;
                if (playAddress != null) {
                    str4 = playAddress.tag;
                } else {
                    str4 = null;
                }
                jSONObject.putOpt("tag", str4);
                jSONObject.putOpt("net_type", NetworkUtils.getNetworkAccessType(application));
                jSONObject.putOpt("network_available", Boolean.valueOf(NetworkUtils.isNetworkAvailable(application)));
                jSONObject.putOpt("is_from_fm_sdk", Boolean.TRUE);
            } else {
                jSONObject = null;
            }
            ik6.a aVar2 = lk6.c.a.f;
            if (aVar2 != null) {
                aVar2.a(null, playEngineInfo, jSONObject);
            }
            ik6.a aVar3 = lk6.c.a.f;
            if (aVar3 != null) {
                aVar3.onEvent("v3_play_error", jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void f(int i, int i2, String str, int i3, boolean z, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_resume_play", z);
            jSONObject.putOpt("play_type", Integer.valueOf(i2));
            jSONObject.putOpt("genre_type", Integer.valueOf(i));
            jSONObject.putOpt("item_id", str);
            jSONObject.putOpt("tone_id", Integer.valueOf(i3));
            jSONObject.putOpt("is_from_fm_sdk", Boolean.TRUE);
            jSONObject.putOpt("real_play_entrance", str2);
            lk6.c.a.f.onEvent("v3_new_play_start", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
