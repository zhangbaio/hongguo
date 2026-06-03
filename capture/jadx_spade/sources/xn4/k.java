package xn4;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.attribute.dynamic.config.StaticConfig;
import com.dragon.read.base.Args;
import com.dragon.read.base.share2.absettings.UgSharePoster;
import com.dragon.read.base.share2.absettings.UgSharePosterTemplate;
import com.dragon.read.base.share3.business.activity.ActivityShareBusinessMgr;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.component.biz.impl.e4;
import com.dragon.read.plugin.common.PluginServiceManager;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.SharePosterInfoData;
import com.dragon.read.util.ToastUtils;
import com.google.gson.JsonObject;
import com.ss.android.messagebus.BusProvider;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements zn4.a {
    public static final k a;

    static {
        Covode.recordClassIndex(608955);
        a = new k();
    }

    private k() {
    }

    @Override // zn4.a
    public boolean b7() {
        return true;
    }

    @Override // zn4.a
    public boolean v3() {
        return PluginServiceManager.ins().isPluginLoaded("com.dragon.read.plugin.qrscan");
    }

    @Override // zn4.a
    public boolean b9(String shareChannelId) {
        Intrinsics.checkNotNullParameter(shareChannelId, "shareChannelId");
        return qn4.a.a.g(shareChannelId);
    }

    @Override // zn4.a
    public void ha(String shareType) {
        Intrinsics.checkNotNullParameter(shareType, "shareType");
        BusProvider.post(new dp2.a(shareType));
    }

    private final String za(Bitmap bitmap) {
        try {
            return ActivityShareBusinessMgr.p(ActivityShareBusinessMgr.a, bitmap, (Bitmap.CompressFormat) null, 0, 6, (Object) null);
        } finally {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override // zn4.a
    public String v5(String posterGuid) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(posterGuid, "posterGuid");
        UgSharePosterTemplate ugSharePosterTemplate = (UgSharePosterTemplate) UgSharePoster.a.a().resultConfigMap.get(posterGuid);
        if (ugSharePosterTemplate != null && (jsonObject = ugSharePosterTemplate.posterData) != null) {
            return jsonObject.toString();
        }
        return null;
    }

    private final byte[] Aa(Bitmap bitmap) {
        Object m773constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            m773constructorimpl = Result.m773constructorimpl(byteArrayOutputStream.toByteArray());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        return (byte[]) m773constructorimpl;
    }

    @Override // zn4.a
    public un4.g Z6(String shareChannelID) {
        Intrinsics.checkNotNullParameter(shareChannelID, "shareChannelID");
        Pair<Integer, Integer> d = qn4.a.a.d(shareChannelID);
        if (d != null) {
            return new un4.g(d.getFirst().intValue(), d.getSecond().intValue());
        }
        return null;
    }

    @Override // zn4.a
    public void la(un4.e kmpShareContent) {
        ao4.a aVar;
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        if (kmpShareContent.a == 0) {
            ToastUtils.showCommonToast("分享失败，请稍后重试");
            ReportManager.onReport("choose_share_channel_fail", new Args().put("fail_reason", "no data").put("fail_code", -10000).put("share_channel", kmpShareContent.b));
        } else if (!Intrinsics.areEqual(kmpShareContent.b, "long_image") && (aVar = qn4.a.a.f().get(kmpShareContent.b)) != null) {
            aVar.b(kmpShareContent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // zn4.a
    public byte[] F4(String resId) {
        int i;
        byte[] Aa;
        Intrinsics.checkNotNullParameter(resId, "resId");
        switch (resId.hashCode()) {
            case -1942614192:
                if (resId.equals("share_post_close_light")) {
                    i = 2130844714;
                    break;
                }
                i = 0;
                break;
            case -1741489224:
                if (resId.equals("share_post_qr_hide_light")) {
                    i = 2130846422;
                    break;
                }
                i = 0;
                break;
            case -1263538660:
                if (resId.equals("share_post_qr_show")) {
                    i = 2130846423;
                    break;
                }
                i = 0;
                break;
            case -610612076:
                if (resId.equals("share_post_qr_hide_dark")) {
                    i = 2130846421;
                    break;
                }
                i = 0;
                break;
            case 1738204668:
                if (resId.equals("share_post_close_dark")) {
                    i = 2130844715;
                    break;
                }
                i = 0;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return new byte[0];
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(App.context().getResources(), i);
        if (decodeResource == null || (Aa = Aa(decodeResource)) == null) {
            return new byte[0];
        }
        return Aa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b5(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource Q6(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (SingleSource) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q9(zn4.c cVar, vn4.b bVar) {
        Intrinsics.checkNotNull(bVar);
        cVar.a(bVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit xa(zn4.c cVar, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "build poster failed";
        }
        cVar.onFailure(message);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource y5(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (SingleSource) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vn4.b D9(Function2 function2, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return (vn4.b) function2.invoke(p0, p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vn4.b M8(vn4.d dVar, Bitmap qrBitmap, Bitmap noQrBitmap) {
        Intrinsics.checkNotNullParameter(qrBitmap, "qrBitmap");
        Intrinsics.checkNotNullParameter(noQrBitmap, "noQrBitmap");
        k kVar = a;
        return new vn4.b(true, CollectionsKt__CollectionsJVMKt.listOf(new vn4.c(kVar.za(qrBitmap), kVar.za(noQrBitmap), dVar)));
    }

    private final SharePosterInfoData ya(String str, kotlinx.serialization.json.JsonObject jsonObject, boolean z) {
        kotlinx.serialization.json.JsonObject jsonObject2;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String str2;
        String str3;
        String str4;
        JsonPrimitive jsonPrimitive;
        Long longOrNull;
        List mutableListOf;
        Map mapOf;
        Map plus;
        JsonArray jsonArray;
        String str5;
        JsonPrimitive jsonPrimitive2;
        kotlinx.serialization.json.JsonObject g = com.dragon.read.kmp.utils.v.a.g(v5(str));
        if (g instanceof kotlinx.serialization.json.JsonObject) {
            jsonObject2 = g;
        } else {
            jsonObject2 = null;
        }
        if (jsonObject2 == null || (jsonElement = (JsonElement) jsonObject2.get("title")) == null || (jsonElement2 = (JsonElement) jsonObject2.get("app_logo")) == null) {
            return null;
        }
        if (z) {
            str2 = "qr_bg_url";
        } else {
            str2 = "no_qr_bg_url";
        }
        JsonElement jsonElement3 = (JsonElement) jsonObject2.get(str2);
        if (jsonElement3 == null) {
            return null;
        }
        if (z) {
            str3 = "qr_desc";
        } else {
            str3 = "no_qr_desc";
        }
        JsonElement jsonElement4 = (JsonElement) jsonObject2.get(str3);
        if (jsonElement4 == null) {
            return null;
        }
        if (z) {
            str4 = "qr_height";
        } else {
            str4 = "no_qr_height";
        }
        JsonElement jsonElement5 = (JsonElement) jsonObject2.get(str4);
        if (jsonElement5 == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement5)) == null || (longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive)) == null) {
            return null;
        }
        long longValue = longOrNull.longValue();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(JsonElementKt.getJsonPrimitive(jsonElement2).getContent(), JsonElementKt.getJsonPrimitive(jsonElement3).getContent());
        for (int i = 0; i < 10; i++) {
            JsonElement jsonElement6 = (JsonElement) jsonObject.get("avatar_url_" + i);
            if (jsonElement6 != null && (jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement6)) != null) {
                str5 = jsonPrimitive2.getContent();
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str5 = "";
            }
            mutableListOf.add(str5);
        }
        JsonElement jsonElement7 = (JsonElement) jsonObject2.get("preload_urls");
        if (jsonElement7 != null && (jsonArray = JsonElementKt.getJsonArray(jsonElement7)) != null) {
            Iterator it2 = jsonArray.iterator();
            while (it2.hasNext()) {
                mutableListOf.add(JsonElementKt.getJsonPrimitive((JsonElement) it2.next()).getContent());
            }
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("title", jsonElement), TuplesKt.to("app_logo", jsonElement2), TuplesKt.to("header_bg_url", jsonElement3), TuplesKt.to("footer_desc", jsonElement4), TuplesKt.to("show_qr", JsonElementKt.JsonPrimitive(Boolean.valueOf(z))), TuplesKt.to("hide_qr", JsonElementKt.JsonPrimitive(Boolean.valueOf(!z))), TuplesKt.to("c_height", JsonElementKt.JsonPrimitive(Long.valueOf(longValue))));
        plus = MapsKt__MapsKt.plus((Map) jsonObject, mapOf);
        kotlinx.serialization.json.JsonObject jsonObject3 = new kotlinx.serialization.json.JsonObject(plus);
        SharePosterInfoData sharePosterInfoData = new SharePosterInfoData();
        sharePosterInfoData.guid = str;
        sharePosterInfoData.posterData = jsonObject3.toString();
        sharePosterInfoData.preloadUrls = mutableListOf;
        sharePosterInfoData.preloadFonts = new ArrayList();
        sharePosterInfoData.width = 390L;
        sharePosterInfoData.height = longValue;
        return sharePosterInfoData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource R4(Activity activity, SharePosterInfoData sharePosterInfoData, StaticConfig staticConfig, Boolean it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return wp2.v.w(wp2.v.a, activity, sharePosterInfoData, staticConfig, 0L, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource d6(Activity activity, SharePosterInfoData sharePosterInfoData, StaticConfig staticConfig, Boolean it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return wp2.v.w(wp2.v.a, activity, sharePosterInfoData, staticConfig, 0L, 8, (Object) null);
    }

    @Override // zn4.a
    public void n1(String posterDataJson, String posterGuid, final vn4.d qrStyle, final zn4.c callback) {
        kotlinx.serialization.json.JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(posterDataJson, "posterDataJson");
        Intrinsics.checkNotNullParameter(posterGuid, "posterGuid");
        Intrinsics.checkNotNullParameter(qrStyle, "qrStyle");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JsonElement g = com.dragon.read.kmp.utils.v.a.g(posterDataJson);
        final StaticConfig staticConfig = null;
        if (g instanceof kotlinx.serialization.json.JsonObject) {
            jsonObject = (kotlinx.serialization.json.JsonObject) g;
        } else {
            jsonObject = null;
        }
        if (jsonObject == null) {
            callback.onFailure("poster data is invalid");
            return;
        }
        final SharePosterInfoData ya = ya(posterGuid, jsonObject, true);
        final SharePosterInfoData ya2 = ya(posterGuid, jsonObject, false);
        if (ya != null && ya2 != null) {
            final Activity currentVisibleActivity = ActivityRecordHelper.getCurrentVisibleActivity();
            if (currentVisibleActivity == null) {
                callback.onFailure("activity is null");
                return;
            }
            UgSharePosterTemplate ugSharePosterTemplate = (UgSharePosterTemplate) UgSharePoster.a.a().resultConfigMap.get(ya.guid);
            if (ugSharePosterTemplate != null) {
                staticConfig = ugSharePosterTemplate.staticConfig;
            }
            if (staticConfig == null) {
                callback.onFailure("poster static config is null");
                return;
            }
            e4 e4Var = e4.a;
            Single D = e4Var.D(ya);
            final Function1 function1 = new Function1() { // from class: xn4.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    SingleSource R4;
                    R4 = k.R4(currentVisibleActivity, ya, staticConfig, (Boolean) obj);
                    return R4;
                }
            };
            Single flatMap = D.flatMap(new Function() { // from class: xn4.b
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    SingleSource y5;
                    y5 = k.y5(Function1.this, obj);
                    return y5;
                }
            });
            Single D2 = e4Var.D(ya2);
            final Function1 function12 = new Function1() { // from class: xn4.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    SingleSource d6;
                    d6 = k.d6(currentVisibleActivity, ya2, staticConfig, (Boolean) obj);
                    return d6;
                }
            };
            Single flatMap2 = D2.flatMap(new Function() { // from class: xn4.d
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    SingleSource Q6;
                    Q6 = k.Q6(Function1.this, obj);
                    return Q6;
                }
            });
            final Function2 function2 = new Function2() { // from class: xn4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    vn4.b M8;
                    M8 = k.M8(vn4.d.this, (Bitmap) obj, (Bitmap) obj2);
                    return M8;
                }
            };
            Single zip = Single.zip(flatMap, flatMap2, new BiFunction() { // from class: xn4.f
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    vn4.b D9;
                    D9 = k.D9(Function2.this, obj, obj2);
                    return D9;
                }
            });
            final Function1 function13 = new Function1() { // from class: xn4.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Q9;
                    Q9 = k.Q9(zn4.c.this, (vn4.b) obj);
                    return Q9;
                }
            };
            Consumer consumer = new Consumer() { // from class: xn4.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    k.ra(Function1.this, obj);
                }
            };
            final Function1 function14 = new Function1() { // from class: xn4.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit xa;
                    xa = k.xa(zn4.c.this, (Throwable) obj);
                    return xa;
                }
            };
            zip.subscribe(consumer, new Consumer() { // from class: xn4.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    k.b5(Function1.this, obj);
                }
            });
            return;
        }
        callback.onFailure("poster data is null");
    }
}
