package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.ResourceOpt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class du extends Notification.Builder {
    private Context a;

    static {
        Covode.recordClassIndex(655470);
    }

    public du a(Map<String, String> map) {
        return this;
    }

    /* renamed from: a */
    protected void mo364a() {
    }

    protected Context a() {
        return this.a;
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo364a();
        return super.build();
    }

    public du(Context context) {
        super(context);
        this.a = context;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public du addExtras(Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public du setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public du mo366a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                av.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e);
            }
        }
        return this;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return INVOKEVIRTUAL_com_xiaomi_push_du_com_dragon_read_resource_ResourceAop_getIdentifier(resources, str, str2, str3);
        }
        return 0;
    }

    @Proxy("getIdentifier")
    @TargetClass("android.content.res.Resources")
    @Skip({"com.bytedance.frameworks.plugin.core.res.MiraResourcesWrapper"})
    public static int INVOKEVIRTUAL_com_xiaomi_push_du_com_dragon_read_resource_ResourceAop_getIdentifier(Resources resources, String name, String str, String str2) {
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
