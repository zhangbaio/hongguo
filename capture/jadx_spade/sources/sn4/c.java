package sn4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.i;
import com.dragon.read.kmp.share.manger.KmpShareManger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import vn4.d;
import xn4.b0;
import xn4.h0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static final i b;
    private static final Map<String, a> c;
    public static final int d;

    private c() {
    }

    static {
        Covode.recordClassIndex(608912);
        a = new c();
        b = new i("HongguoActivityListShare");
        c = new LinkedHashMap();
        d = 8;
    }

    private final String d(String str) {
        return "hongguo_activity_list_" + str;
    }

    private final yn4.b f(String str) {
        yn4.b bVar = new yn4.b();
        bVar.c(new yn4.a("top_list_share_button", "top_list").c("star_toplist", ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, str));
        return bVar;
    }

    private final void n(vn4.a aVar) {
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        yn4.b bVar = aVar.h;
        if (bVar != null) {
            bVar.d = epochMilliseconds;
        }
        if (bVar != null) {
            bVar.d(epochMilliseconds / 1000);
        }
        KmpShareManger.a.R(aVar);
    }

    public final void e(String activityId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        a remove = c.remove(d(activityId));
        boolean z = false;
        if (remove != null && remove.e) {
            z = true;
        }
        if (z) {
            h0.a.g();
        }
    }

    private final void h(String str, vn4.a aVar) {
        a aVar2 = c.get(str);
        if (aVar2 == null) {
            return;
        }
        aVar2.d = false;
        aVar2.f = aVar;
        if (aVar2.e) {
            aVar2.e = false;
            h0.a.g();
            n(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        c cVar = a;
        String message = throwable.getMessage();
        if (message == null) {
            message = "build poster failed";
        }
        cVar.g(str, message);
        return Unit.INSTANCE;
    }

    public final void i(String activityId, JsonObject itemData) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        a aVar = c.get(d(activityId));
        if (aVar != null) {
            jsonObject = aVar.b;
        } else {
            jsonObject = null;
        }
        if (Intrinsics.areEqual(jsonObject, itemData) && (aVar.d || aVar.f != null)) {
            return;
        }
        j(activityId, itemData, false, 0);
    }

    private final void g(String str, String str2) {
        a aVar = c.get(str);
        if (aVar == null) {
            return;
        }
        i.c(b, "request failed, cacheId:" + str + ", error:" + str2, (Throwable) null, 2, (Object) null);
        aVar.d = false;
        aVar.f = null;
        if (!aVar.e) {
            return;
        }
        int i = aVar.c;
        if (i < 1) {
            j(aVar.a, aVar.b, true, i + 1);
            return;
        }
        aVar.e = false;
        h0 h0Var = h0.a;
        h0Var.g();
        h0Var.h("分享失败，请稍后重试");
    }

    public final void m(String activityId, JsonObject itemData) {
        JsonObject jsonObject;
        vn4.a aVar;
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        a aVar2 = c.get(d(activityId));
        JsonObject jsonObject2 = null;
        if (aVar2 != null) {
            jsonObject = aVar2.b;
        } else {
            jsonObject = null;
        }
        if (Intrinsics.areEqual(jsonObject, itemData) && (aVar = aVar2.f) != null) {
            Intrinsics.checkNotNull(aVar);
            n(aVar);
            return;
        }
        if (aVar2 != null) {
            jsonObject2 = aVar2.b;
        }
        if (Intrinsics.areEqual(jsonObject2, itemData) && aVar2.d) {
            aVar2.e = true;
            h0.a.i("加载中");
        } else {
            h0.a.i("加载中");
            j(activityId, itemData, true, 0);
        }
    }

    private final void c(JsonObject jsonObject, Function1<? super vn4.b, Unit> function1, Function1<? super Throwable, Unit> function12) {
        b0.a.a(jsonObject, "poster_starlight_ranking_001", new d(32, 20, 50, 0, "#FFFFFF", "#FFFFFF00", 0), function1, function12);
    }

    private final void j(final String str, JsonObject jsonObject, boolean z, int i) {
        JsonElement jsonElement;
        JsonPrimitive jsonPrimitive;
        final String str2;
        JsonElement jsonElement2;
        JsonPrimitive jsonPrimitive2;
        final String d2 = d(str);
        a aVar = new a(str, jsonObject, i, false, false, null, 56, null);
        aVar.d = true;
        aVar.e = z;
        c.put(d2, aVar);
        JsonObject e = b0.a.e("poster_starlight_ranking_001");
        final String str3 = null;
        if (e != null) {
            jsonElement = (JsonElement) e.get("share_url");
        } else {
            jsonElement = null;
        }
        if (jsonElement instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) jsonElement;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            str2 = jsonPrimitive.getContent();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            g(d2, "poster share_url is null");
            return;
        }
        if (e != null) {
            jsonElement2 = (JsonElement) e.get("schema");
        } else {
            jsonElement2 = null;
        }
        if (jsonElement2 instanceof JsonPrimitive) {
            jsonPrimitive2 = (JsonPrimitive) jsonElement2;
        } else {
            jsonPrimitive2 = null;
        }
        if (jsonPrimitive2 != null) {
            str3 = jsonPrimitive2.getContent();
        }
        if (str3 == null) {
            g(d2, "poster schema is null");
        } else {
            c(jsonObject, new Function1() { // from class: sn4.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k;
                    k = c.k(str, d2, str3, str2, (vn4.b) obj);
                    return k;
                }
            }, new Function1() { // from class: sn4.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit l;
                    l = c.l(d2, (Throwable) obj);
                    return l;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, String str2, String str3, String str4, vn4.b posterContent) {
        Intrinsics.checkNotNullParameter(posterContent, "posterContent");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.put("schema", JsonElementKt.JsonPrimitive(str3));
        jsonObjectBuilder.put("share_url", JsonElementKt.JsonPrimitive(str4));
        Unit unit = Unit.INSTANCE;
        String jsonObject = jsonObjectBuilder.build().toString();
        c cVar = a;
        vn4.a aVar = new vn4.a("top_list", "common_poster_share", "top_list_share_button", str, jsonObject, posterContent, cVar.f(str));
        aVar.a(str2);
        aVar.m(str4);
        cVar.h(str2, aVar);
        return Unit.INSTANCE;
    }

    private static final class a {
        public final String a;
        public final JsonObject b;
        public int c;
        public boolean d;
        public boolean e;
        public vn4.a f;

        static {
            Covode.recordClassIndex(608913);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && Intrinsics.areEqual(this.f, aVar.f);
        }

        public int hashCode() {
            int hashCode = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + m.a(this.d)) * 31) + m.a(this.e)) * 31;
            vn4.a aVar = this.f;
            return hashCode + (aVar == null ? 0 : aVar.hashCode());
        }

        public String toString() {
            return "ShareCache(activityId=" + this.a + ", itemData=" + this.b + ", retryCount=" + this.c + ", isRequesting=" + this.d + ", pendingShow=" + this.e + ", postParams=" + this.f + ')';
        }

        public a(String activityId, JsonObject itemData, int i, boolean z, boolean z2, vn4.a aVar) {
            Intrinsics.checkNotNullParameter(activityId, "activityId");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this.a = activityId;
            this.b = itemData;
            this.c = i;
            this.d = z;
            this.e = z2;
            this.f = aVar;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ a(java.lang.String r10, kotlinx.serialization.json.JsonObject r11, int r12, boolean r13, boolean r14, vn4.a r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
            /*
                r9 = this;
                r0 = r16 & 8
                r1 = 0
                if (r0 == 0) goto L7
                r6 = 0
                goto L8
            L7:
                r6 = r13
            L8:
                r0 = r16 & 16
                if (r0 == 0) goto Le
                r7 = 0
                goto Lf
            Le:
                r7 = r14
            Lf:
                r0 = r16 & 32
                if (r0 == 0) goto L16
                r0 = 0
                r8 = r0
                goto L17
            L16:
                r8 = r15
            L17:
                r2 = r9
                r3 = r10
                r4 = r11
                r5 = r12
                r2.<init>(r3, r4, r5, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sn4.c.a.<init>(java.lang.String, kotlinx.serialization.json.JsonObject, int, boolean, boolean, vn4.a, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
