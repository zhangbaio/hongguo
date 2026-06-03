package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.ResourceOpt;
import com.vivo.push.model.InsideNotificationItem;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k implements BaseNotifyDataAdapter {
    private static int e;
    private static int f;
    private Resources a;
    private String b;
    private String c;
    private String d;

    private static boolean a(int i) {
        return (i == -1 || i == 0) ? false : true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    static {
        Covode.recordClassIndex(655196);
        e = 0;
        f = 0;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int a;
        if (a(e)) {
            return e;
        }
        String str = this.d;
        if (!a(str)) {
            t.d("DefaultNotifyDataAdapter", "getNotifyIconByArdVersion isSystemCodeUsable is false ");
            a = -1;
        } else {
            a = a(str, "_notifyicon");
        }
        e = a;
        if (a(a)) {
            return e;
        }
        String str2 = this.c;
        while (true) {
            t.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion codeReg = ".concat(String.valueOf(str2)));
            if (TextUtils.isEmpty(str2)) {
                return INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier(this.a, "vivo_push_notifyicon", "drawable", this.b);
            }
            int INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier = INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier(this.a, "vivo_push_rom" + str2 + "_notifyicon", "drawable", this.b);
            if (INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier > 0) {
                t.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion find notifyicon = vivo_push_rom" + str2 + "_notifyicon");
                return INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier;
            }
            str2 = str2.substring(0, str2.length() - 1);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int a;
        if (a(f)) {
            return f;
        }
        String str = this.d;
        if (!a(str)) {
            t.d("DefaultNotifyDataAdapter", "getSmallIconByArdVersion isSystemCodeUsable is false ");
            a = -1;
        } else {
            a = a(str, "_icon");
        }
        f = a;
        if (a(a)) {
            return f;
        }
        String str2 = this.c;
        while (true) {
            t.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion codeReg = ".concat(String.valueOf(str2)));
            if (TextUtils.isEmpty(str2)) {
                return INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier(this.a, "vivo_push_icon", "drawable", this.b);
            }
            int INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier = INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier(this.a, "vivo_push_rom" + str2 + "_icon", "drawable", this.b);
            if (INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier > 0) {
                t.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion find smallIcon = vivo_push_rom" + str2 + "_icon");
                return INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier;
            }
            str2 = str2.substring(0, str2.length() - 1);
        }
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            t.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
            return false;
        }
        return true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
        this.c = m.a();
        this.d = Build.VERSION.RELEASE;
    }

    private int a(String str, String str2) {
        t.d("DefaultNotifyDataAdapter", "getIcon systemVersion = " + str + " suffix= " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    t.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier = INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier(this.a, str3, "drawable", this.b);
                    if (INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier > 0) {
                        t.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier;
                    }
                }
            } catch (Exception e2) {
                t.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }

    @Proxy("getIdentifier")
    @TargetClass("android.content.res.Resources")
    @Skip({"com.bytedance.frameworks.plugin.core.res.MiraResourcesWrapper"})
    public static int INVOKEVIRTUAL_com_vivo_push_util_k_com_dragon_read_resource_ResourceAop_getIdentifier(Resources resources, String name, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!ResourceOpt.a.g()) {
            Integer valueOf = Integer.valueOf(resources.getIdentifier(name, str, str2));
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type kotlin.Int");
            return valueOf.intValue();
        }
        x55.b bVar = x55.b.a;
        Integer e2 = bVar.e(name, str, str2);
        if (e2 != null) {
            return e2.intValue();
        }
        Integer valueOf2 = Integer.valueOf(resources.getIdentifier(name, str, str2));
        Intrinsics.checkNotNull(valueOf2, "null cannot be cast to non-null type kotlin.Int");
        bVar.b(valueOf2.intValue(), name, str, str2);
        return valueOf2.intValue();
    }
}
