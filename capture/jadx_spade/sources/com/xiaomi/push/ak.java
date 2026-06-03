package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ak implements ah {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private Class<?> f114a;

    /* renamed from: a, reason: collision with other field name */
    private Object f115a;

    /* renamed from: a, reason: collision with other field name */
    private Method f116a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    static {
        Covode.recordClassIndex(655344);
    }

    private static Object com_xiaomi_push_ak_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo140a() {
        return a(this.a, this.b);
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo141a() {
        if (this.f114a != null && this.f115a != null) {
            return true;
        }
        return false;
    }

    public ak(Context context) {
        this.a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            Class<?> a = q.a(context, "com.android.id.impl.IdProviderImpl");
            this.f114a = a;
            this.f115a = a.newInstance();
            this.b = this.f114a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    private String a(Context context, Method method) {
        Object obj = this.f115a;
        if (obj != null && method != null) {
            try {
                Object com_xiaomi_push_ak_java_lang_reflect_Method_invoke = com_xiaomi_push_ak_java_lang_reflect_Method_invoke(method, obj, new Object[]{context});
                if (com_xiaomi_push_ak_java_lang_reflect_Method_invoke != null) {
                    return (String) com_xiaomi_push_ak_java_lang_reflect_Method_invoke;
                }
                return null;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
                return null;
            }
        }
        return null;
    }
}
