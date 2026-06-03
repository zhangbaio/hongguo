package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.dragon.read.app.PrivacyMgr;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ac implements e {
    private ContentResolver a;

    static {
        Covode.recordClassIndex(655179);
    }

    ac() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String com_vivo_push_util_ac_android_provider_Settings$System_getString(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102003, "android/provider/Settings$System", "getString", Settings.System.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102003, "android/provider/Settings$System", "getString", Settings.System.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.System.getString(contentResolver, str);
        heliosApiHook.postInvoke(102003, "android/provider/Settings$System", "getString", Settings.System.class, objArr, string, extraInfo, true);
        return string;
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (m.b()) {
            this.a = context.getContentResolver();
            return true;
        }
        return false;
    }

    @Proxy("getString")
    @TargetClass(scope = Scope.SELF, value = "android.provider.Settings$System")
    public static String INVOKESTATIC_com_vivo_push_util_ac_com_dragon_read_base_lancet_PrivacyAop_getStringSystem(ContentResolver contentResolver, String str) {
        if (TextUtils.equals(str, "android_id") && !PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return null;
        }
        return com_vivo_push_util_ac_android_provider_Settings$System_getString(contentResolver, str);
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        try {
            return INVOKESTATIC_com_vivo_push_util_ac_com_dragon_read_base_lancet_PrivacyAop_getStringSystem(this.a, str);
        } catch (Exception e) {
            e.printStackTrace();
            t.b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
