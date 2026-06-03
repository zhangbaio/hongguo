package xr4;

import com.bytedance.covode.number.Covode;
import com.bytedance.minigame.bdpbase.manager.BdpManager;
import com.bytedance.minigame.serviceapi.defaults.event.BdpEventService;
import com.bytedance.minigame.serviceapi.defaults.log.BdpLogService;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements BdpEventService {
    public static final C0296a a;

    /* renamed from: xr4.a$a, reason: collision with other inner class name */
    public static final class C0296a {
        static {
            Covode.recordClassIndex(611972);
        }

        private C0296a() {
        }

        public /* synthetic */ C0296a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611971);
        a = new C0296a(null);
    }

    private final String a(String str) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(str).getAsJsonObject());
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public void sendEventV3(String event, JSONObject params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        BdpLogService service = BdpManager.getInst().getService(BdpLogService.class);
        StringBuilder sb = new StringBuilder();
        sb.append(event);
        sb.append("=============================\n");
        String jSONObject = params.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        sb.append(a(jSONObject));
        service.i("tma_AppLogHandler", sb.toString());
        AppLogNewUtils.onEventV3(event, params);
    }

    public void sendEventV1(String category, String tag, String label, long j, long j2, JSONObject extraJson) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(extraJson, "extraJson");
        BdpManager.getInst().getService(BdpLogService.class).i("tma_AppLogHandler", "category: " + category + ", tag: " + tag + ", label: " + label + ", value: " + j + ", ext_value: " + j2 + ", ext_json: " + extraJson);
    }
}
