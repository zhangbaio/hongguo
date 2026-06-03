package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.ResourceOpt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l implements BaseNotifyLayoutAdapter {
    private Resources a;
    private String b;

    static {
        Covode.recordClassIndex(655197);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return INVOKEVIRTUAL_com_vivo_push_util_l_com_dragon_read_resource_ResourceAop_getIdentifier(this.a, "push_notify", "layout", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        if (m.d) {
            resources = this.a;
            str = "notify_icon_rom30";
        } else if (m.c) {
            resources = this.a;
            str = "notify_icon_rom20";
        } else {
            resources = this.a;
            str = "notify_icon";
        }
        return INVOKEVIRTUAL_com_vivo_push_util_l_com_dragon_read_resource_ResourceAop_getIdentifier(resources, str, "id", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((Integer) ah.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.a.getColor(i);
        }
        boolean z = m.d;
        if (z) {
            return -1;
        }
        if (m.c) {
            if (!z) {
                return -1;
            }
            return Color.parseColor("#ff999999");
        }
        return -16777216;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
    }

    @Proxy("getIdentifier")
    @TargetClass("android.content.res.Resources")
    @Skip({"com.bytedance.frameworks.plugin.core.res.MiraResourcesWrapper"})
    public static int INVOKEVIRTUAL_com_vivo_push_util_l_com_dragon_read_resource_ResourceAop_getIdentifier(Resources resources, String name, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!ResourceOpt.a.g()) {
            Integer valueOf = Integer.valueOf(resources.getIdentifier(name, str, str2));
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type kotlin.Int");
            return valueOf.intValue();
        }
        x55.b bVar = x55.b.a;
        Integer e = bVar.e(name, str, str2);
        if (e != null) {
            return e.intValue();
        }
        Integer valueOf2 = Integer.valueOf(resources.getIdentifier(name, str, str2));
        Intrinsics.checkNotNull(valueOf2, "null cannot be cast to non-null type kotlin.Int");
        bVar.b(valueOf2.intValue(), name, str, str2);
        return valueOf2.intValue();
    }
}
