package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static Class<?> a;
    private static Class<?> b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static boolean g;

    private static Object com_tencent_connect_a_a_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    static {
        Covode.recordClassIndex(653237);
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = false;
    }

    public static boolean a(Context context, QQToken qQToken) {
        return i.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                com_tencent_connect_a_a_java_lang_reflect_Method_invoke(f, a, new Object[]{Boolean.TRUE});
            } else {
                com_tencent_connect_a_a_java_lang_reflect_Method_invoke(f, a, new Object[]{Boolean.FALSE});
            }
        } catch (Exception e2) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (!g) {
            return;
        }
        b(context, qQToken);
        if (qQToken.getOpenId() != null) {
            try {
                com_tencent_connect_a_a_java_lang_reflect_Method_invoke(c, b, new Object[]{context, qQToken.getOpenId()});
            } catch (Exception e2) {
                SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
            }
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            a = l3.a.q("com.tencent.stat.StatConfig");
            Class<?> q = l3.a.q("com.tencent.stat.StatService");
            b = q;
            c = q.getMethod("reportQQ", Context.class, String.class);
            d = b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls = b;
            Class<?> cls2 = Integer.TYPE;
            e = cls.getMethod("commitEvents", Context.class, cls2);
            Class<?> cls3 = a;
            Class<?> cls4 = Boolean.TYPE;
            f = cls3.getMethod("setEnableStatService", cls4);
            b(context, qQToken);
            a.getMethod("setAutoExceptionCaught", cls4).invoke(a, Boolean.FALSE);
            a.getMethod("setEnableSmartReporting", cls4).invoke(a, Boolean.TRUE);
            a.getMethod("setSendPeriodMinutes", cls2).invoke(a, 1440);
            Class<?> q2 = l3.a.q("com.tencent.stat.StatReportStrategy");
            a.getMethod("setStatSendStrategy", q2).invoke(a, q2.getField("PERIOD").get(null));
            b.getMethod("startStatService", Context.class, String.class, String.class).invoke(b, context, str, l3.a.q("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            g = true;
        } catch (Exception e2) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (!g) {
            return;
        }
        b(context, qQToken);
        try {
            com_tencent_connect_a_a_java_lang_reflect_Method_invoke(d, b, new Object[]{context, str, strArr});
        } catch (Exception e2) {
            SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
        }
    }
}
