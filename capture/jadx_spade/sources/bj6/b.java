package bj6;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.config.PlayerConfig;
import com.ss.videoarch.liveplayer.r;
import com.ss.videoarch.liveplayer.w;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.network.VeLSNetworkManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    static {
        Covode.recordClassIndex(653025);
    }

    private static String a(String str) {
        if (TextUtils.equals(str, "RTMPlayer")) {
            return new VeLSNetworkManager().b();
        }
        if (TextUtils.equals(str, "LivePlayerSettings")) {
            return new VeLSNetworkManager().a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("strategyName", str);
            String str2 = (String) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 51, "", jSONObject);
            com.ss.videoarch.liveplayer.log.a.c("PlayerStrategyConfig", "getStrategyConfigByName:" + str + ", config:" + str2);
            return str2;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void e(PlayerConfig playerConfig, r rVar) {
        if (playerConfig != null && rVar != null) {
            playerConfig.VeLivePlayerKeySetHardwareDecode.a(Integer.valueOf(rVar.b ? 1 : 0), 2);
        }
    }

    public static void c(PlayerConfig playerConfig, w wVar) {
        if (playerConfig == null) {
            return;
        }
        try {
            String a = a("LivePlayerSettings");
            com.ss.videoarch.liveplayer.log.a.a("PlayerStrategyConfig", "configStr:" + a);
            b(playerConfig, new JSONObject(a), 8);
        } catch (Exception unused) {
            com.ss.videoarch.liveplayer.log.a.f("PlayerStrategyConfig", "parseStrategyConfig ex=");
        }
    }

    public static void b(Object obj, JSONObject jSONObject, int i) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.get(next) instanceof JSONObject) {
                    b(obj.getClass().getDeclaredField(next).get(obj), (JSONObject) jSONObject.get(next), i);
                } else {
                    d(obj, next, jSONObject.get(next), i);
                }
            }
        } catch (Exception unused) {
            com.ss.videoarch.liveplayer.log.a.f("PlayerStrategyConfig", "parseConfigObject ex=");
        }
    }

    private static void d(Object obj, String str, Object obj2, int i) {
        Type type;
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            Type genericType = declaredField.getGenericType();
            if (genericType instanceof ParameterizedType) {
                type = ((ParameterizedType) genericType).getActualTypeArguments()[0];
            } else {
                type = null;
            }
            if (type == null) {
                if (obj2 instanceof Double) {
                    declaredField.set(obj, Float.valueOf(BigDecimal.valueOf(((Double) obj2).doubleValue()).floatValue()));
                    return;
                } else if (obj2 instanceof BigDecimal) {
                    declaredField.set(obj, Float.valueOf(((BigDecimal) obj2).floatValue()));
                    return;
                } else {
                    declaredField.set(obj, obj2);
                    return;
                }
            }
            declaredField.setAccessible(true);
            Object obj3 = declaredField.get(obj);
            Method method = obj3.getClass().getMethod("setConfig", Object.class, Integer.TYPE);
            if (obj2 instanceof Double) {
                method.invoke(obj3, Float.valueOf(BigDecimal.valueOf(((Double) obj2).doubleValue()).floatValue()), Integer.valueOf(i));
            } else if (obj2 instanceof BigDecimal) {
                method.invoke(obj3, Float.valueOf(((BigDecimal) obj2).floatValue()), Integer.valueOf(i));
            } else {
                method.invoke(obj3, obj2, Integer.valueOf(i));
            }
        } catch (Exception unused) {
            com.ss.videoarch.liveplayer.log.a.a("PlayerStrategyConfig", "set config ex");
        }
    }
}
