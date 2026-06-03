package ds4;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.plugin.common.host.IRouterService;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements a {
    static {
        Covode.recordClassIndex(611982);
    }

    @Override // ds4.a
    public boolean a(Activity activity, String schema, Uri uri, String str, Function2<? super Boolean, ? super String, Unit> function2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(uri, "uri");
        ((IRouterService) ServiceManager.getService(IRouterService.class)).openScheme(activity, schema);
        if (function2 != null) {
            function2.invoke(Boolean.TRUE, "handle by router service");
            return true;
        }
        return true;
    }
}
