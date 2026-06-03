package com.tencent.connect.auth;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class QQToken {
    private static SharedPreferences g;
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private long e = -1;
    private com.tencent.open.utils.a f;

    static {
        Covode.recordClassIndex(653245);
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.c;
    }

    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (g == null) {
                g = g.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = g;
        }
        return sharedPreferences;
    }

    public boolean isSessionValid() {
        if (this.b != null && System.currentTimeMillis() < this.e) {
            return true;
        }
        return false;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
            }
        } catch (Exception e) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
        }
        return openId;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public QQToken(String str) {
        this.a = str;
    }

    private static String b(String str) {
        return Base64.encodeToString(m.j(str), 2);
    }

    public void setOpenId(String str) {
        this.c = str;
        com.tencent.open.b.b.a().a(str);
    }

    private static String c(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_spkey";
    }

    private static String a(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_aes_google";
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(g.a());
            }
            return a(str, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(g.a());
            }
            return a(this.a, jSONObject, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String b;
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            }
            if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            }
            String string = a().getString(a(str), "");
            if (TextUtils.isEmpty(string)) {
                if (!JniInterface.isJniOk) {
                    k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                    JniInterface.loadSo();
                }
                if (!JniInterface.isJniOk) {
                    SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                    return null;
                }
                String c = c(str);
                String string2 = a().getString(c, "");
                try {
                    if (TextUtils.isEmpty(string2)) {
                        String b2 = b(str);
                        String string3 = a().getString(b2, "");
                        try {
                            if (TextUtils.isEmpty(string3)) {
                                SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            b = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(b)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                return null;
                            }
                            a(str, new JSONObject(b), aVar);
                        } catch (Exception e) {
                            SLog.e("QQToken", "Catch Exception", e);
                            return null;
                        } finally {
                            a().edit().remove(b2).apply();
                        }
                    } else {
                        b = JniInterface.d2(string2);
                        a(str, new JSONObject(b), aVar);
                    }
                } catch (Exception e2) {
                    SLog.e("QQToken", "Catch Exception", e2);
                    return null;
                } finally {
                    a().edit().remove(c).apply();
                }
            } else {
                b = aVar.b(string);
            }
            try {
                JSONObject jSONObject = new JSONObject(b);
                SLog.i("QQToken", "loadJsonPreference sucess");
                return jSONObject;
            } catch (Exception e3) {
                SLog.i("QQToken", "loadJsonPreference decode " + e3.toString());
                return null;
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            }
            if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a = a(str);
                        String a2 = aVar.a(jSONObject.toString());
                        if (a.length() > 6 && a2 != null) {
                            a().edit().putString(a, a2).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());
                    return false;
                }
            }
            SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
            return false;
        }
    }
}
