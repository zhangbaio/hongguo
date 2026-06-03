package com.ss.videoarch.strategy.network;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private final String a;
    private final IHttpExecutor b;
    private final List<Pair<String, String>> c;

    static {
        Covode.recordClassIndex(653145);
    }

    public JSONObject e(String str) throws Exception {
        return b(str);
    }

    a(LSSDKConfig lSSDKConfig) {
        this.a = lSSDKConfig.mApiHost;
        this.b = lSSDKConfig.mHttpExecutor;
        this.c = lSSDKConfig.mCommonParams;
    }

    private JSONObject b(String str) throws Exception {
        return new JSONObject(this.b.executeGet(a(this.a + str, this.c)));
    }

    public JSONObject f(String str, Object obj) throws Exception {
        return c(str, obj);
    }

    private static String d(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private JSONObject c(String str, Object obj) throws Exception {
        return new JSONObject(this.b.executePost(a(this.a + str, this.c), obj.toString().getBytes("UTF-8"), "gzip", "application/json; charset=utf-8"));
    }

    private static String a(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(63) < 0) {
            if (list.size() > 0) {
                sb.append("?");
            }
        } else {
            sb.append("&");
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append("&");
            }
            Pair<String, String> pair = list.get(i);
            sb.append((String) pair.first);
            sb.append('=');
            sb.append(d((String) pair.second, "UTF-8"));
        }
        return sb.toString();
    }
}
