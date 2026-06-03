package com.dragon.read.lib.community.inner;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.community.saas.NsCommonDepend;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NsCommonDependImpl implements NsCommonDepend {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(611458);
    }

    public p92.e getErrorView(Context context, FrameLayout parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return c.a.b().a.a().getErrorView(context, parent);
    }

    public p92.f getLoadingView(Context context, FrameLayout parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return c.a.b().a.a().getLoadingView(context, parent);
    }

    public void monitorEvent(String serviceName, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        c.a.b().a.a().monitorEvent(serviceName, jSONObject, jSONObject2, jSONObject3);
    }
}
