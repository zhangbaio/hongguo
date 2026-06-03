package com.ss.videoarch.liveplayer.log;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class LiveError extends Error {
    public int code;
    public Map info;
    public long timeStamp;

    static {
        Covode.recordClassIndex(653042);
    }

    public String getInfoJSON() {
        if (this.info == null) {
            this.info = new HashMap();
        }
        JSONObject jSONObject = new JSONObject(this.info);
        try {
            jSONObject.put("timestamp", this.timeStamp);
            jSONObject.put("message", super.toString());
        } catch (JSONException e) {
            a.a("Live Error", e.toString());
        }
        return jSONObject.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.info == null) {
            this.info = new HashMap();
        }
        JSONObject jSONObject = new JSONObject(this.info);
        try {
            jSONObject.put("message", super.toString());
            jSONObject.put("code", this.code);
            jSONObject.put("timestamp", this.timeStamp);
        } catch (JSONException e) {
            a.a("Live Error", e.toString());
        }
        return jSONObject.toString();
    }

    public static int convertVeLivePlayerErrorCode(int i) {
        switch (i) {
            case -1330794744:
            case -1296385272:
            case -1094995529:
            case -499983:
            case -499975:
            case -499971:
                return t.a.l;
            case -1128613112:
            case -499998:
            case -499997:
            case -499996:
            case -499981:
            case -499978:
            case -499977:
                return t.a.m;
            case -499992:
            case -499990:
                return t.a.n;
            case -499988:
            case -499987:
            case -100002:
            case -100001:
                return t.a.f;
            case -499984:
            case -100009:
                return t.a.g;
            case -499898:
            case -499897:
            case -499896:
            case -499895:
            case -499894:
            case -499893:
            case -499892:
            case -499891:
            case -100011:
                return t.a.k;
            case -499799:
            case -499798:
            case -100010:
                return t.a.j;
            case -30001:
                return t.a.b;
            default:
                return t.a.x;
        }
    }

    public LiveError(int i, String str, Map<String, String> map) {
        super(str);
        this.code = i;
        this.info = map;
        this.timeStamp = System.currentTimeMillis();
    }
}
