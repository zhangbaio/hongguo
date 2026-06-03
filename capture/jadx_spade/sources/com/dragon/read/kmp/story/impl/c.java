package com.dragon.read.kmp.story.impl;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.bytedance.router.SmartRoute;
import com.bytedance.router.SmartRouter;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.component.biz.api.NsCommunityApi;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.util.DebugManager;
import com.dragon.read.util.kotlin.ContextKt;
import com.google.gson.reflect.TypeToken;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements cp4.a {
    public static final c a;

    static {
        Covode.recordClassIndex(609195);
        a = new c();
    }

    private c() {
    }

    public static final class a extends TypeToken<Map<String, ? extends String>> {
        a() {
        }
    }

    private final Map<String, String> z0(yo4.d dVar) {
        Map<String, String> map = dVar.c;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), "tempReportInfo")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final String F0(yo4.d dVar) {
        boolean z;
        Map jsonToMapSafe;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = dVar.c.get("tempReportInfo");
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                str = null;
            }
            if (str != null && (jsonToMapSafe = JSONUtils.jsonToMapSafe(str, new a())) != null) {
                linkedHashMap.putAll(jsonToMapSafe);
            }
        }
        linkedHashMap.putAll(dVar.m);
        if (linkedHashMap.isEmpty()) {
            return null;
        }
        return new JSONObject(linkedHashMap).toString();
    }

    @Override // cp4.a
    public void p6(yo4.d param) {
        String str;
        Intrinsics.checkNotNullParameter(param, "param");
        String F0 = F0(param);
        Bundle bundle = new Bundle();
        String str2 = param.e;
        if (str2 != null) {
            bundle.putString("postId", str2);
        }
        String str3 = param.d;
        if (str3 != null) {
            bundle.putString("bookId", str3);
        }
        Integer num = param.o;
        if (num != null) {
            bundle.putInt("originType", num.intValue());
        }
        String str4 = param.p;
        if (str4 != null) {
            bundle.putString("pageStyle", str4);
        }
        bundle.putInt("sourceType", param.f);
        String str5 = param.t;
        if (str5 != null) {
            bundle.putString("fromVideoId", str5);
        }
        String str6 = param.q;
        if (str6 != null) {
            bundle.putString("targetPosition", str6);
        }
        Integer num2 = param.r;
        if (num2 != null) {
            bundle.putInt("targetPositionHighlight", num2.intValue());
        }
        Integer num3 = param.s;
        if (num3 != null) {
            bundle.putInt("listenAudio", num3.intValue());
        }
        if (F0 != null) {
            bundle.putString("tempReportInfo", F0);
        }
        String string = bundle.getString("pageStyle");
        if (DebugManager.inst().isShortStoryToKmpContainer() && Intrinsics.areEqual(string, NsCommunityApi.UGC_STROY_PAGE_STYLE)) {
            str = "//shortStoryDetail";
        } else {
            str = "//ugcPostDetails";
        }
        SmartRoute buildRoute = SmartRouter.buildRoute(ContextKt.getCurrentContext(), str);
        buildRoute.withParam(bundle);
        PageRecorder pageRecorder = new PageRecorder("", "", "", (PageRecorder) null);
        pageRecorder.addParam(a.z0(param));
        buildRoute.withParam("enter_from", pageRecorder);
        buildRoute.open();
    }
}
