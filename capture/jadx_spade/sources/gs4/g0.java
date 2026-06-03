package gs4;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.dragon.read.base.ssconfig.template.FrescoEnableSensible;
import com.dragon.read.base.util.LogInfoUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.util.DebugManager;
import com.dragon.read.util.NumberUtils;
import com.dragon.read.util.ToastUtils;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.IMonitorHookV2;
import com.optimize.statistics.ImageTraceListener;
import gs4.g0;
import gs4.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 {
    public static final a a;
    private static long b;

    public static final class a {
        static {
            Covode.recordClassIndex(612327);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612326);
        a = new a(null);
    }

    public static final class c implements ImageTraceListener {
        static {
            Covode.recordClassIndex(612329);
        }

        public void imageNetCallBack(long j, long j2, String str, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject) {
        }

        private final Pair<Integer, Integer> k(String str) {
            List list;
            boolean z;
            if (str != null) {
                list = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"x"}, false, 0, 6, (Object) null);
            } else {
                list = null;
            }
            if (list != null && list.size() == 2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return null;
            }
            try {
                return Pair.create(Integer.valueOf(Integer.parseInt((String) list.get(0))), Integer.valueOf(Integer.parseInt((String) list.get(1))));
            } catch (Exception e) {
                LogWrapper.error("CustomFrescoMonitor", "parse image_size error, %s", new Object[]{LogInfoUtils.getErrorInfo(e)});
                return null;
            }
        }

        private final String m(Integer num) {
            if (num != null && num.intValue() > 0) {
                if (num.intValue() == 1) {
                    return "network";
                }
                if (num.intValue() != 2 && num.intValue() != 3) {
                    if (num.intValue() == 4) {
                        return "memory_encode";
                    }
                    if (num.intValue() != 5 && num.intValue() != 6) {
                        return "unknown(multiplex)";
                    }
                    return "memory_bitmap";
                }
                return "disk";
            }
            return null;
        }

        private final void h(JSONObject jSONObject) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            final int optInt = jSONObject.optInt("intended_image_width", 0);
            final int optInt2 = jSONObject.optInt("intended_image_height", 0);
            final int optInt3 = jSONObject.optInt("applied_image_width", 0);
            final int optInt4 = jSONObject.optInt("applied_image_height", 0);
            if (optInt > 0 && optInt2 > 0 && optInt3 > 0 && optInt4 > 0) {
                if (optInt3 <= 200 && optInt4 <= 200) {
                    return;
                }
                if (optInt * 2 < optInt3) {
                    z = true;
                } else {
                    z = false;
                }
                if (optInt2 * 2 < optInt4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (optInt * optInt2 * 2 < optInt3 * optInt4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z && !z2 && !z3) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                jSONObject.putOpt("is_large_image", Boolean.valueOf(z4));
                if (!z4 || !DebugManager.inst().isImageSizeCheckEnabled()) {
                    return;
                }
                final String optString = jSONObject.optString("biz_tag", "unknown");
                LogWrapper.w("GlobalFrescoStats", new Object[]{"图片尺寸超过预期：当前宽度=" + optInt3 + "，预期宽度=" + optInt + "；当前高度=" + optInt4 + "，预期高度=" + optInt2});
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - g0.b > 10000) {
                    g0.b = currentTimeMillis;
                    ThreadUtils.postInForeground(new Runnable() { // from class: gs4.h0
                        @Override // java.lang.Runnable
                        public final void run() {
                            g0.c.i(optString, optInt, optInt2, optInt3, optInt4);
                        }
                    });
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        
            r1 = kotlin.text.StringsKt__StringsKt.substringAfterLast$default(r3, '/', (java.lang.String) null, 2, (java.lang.Object) null);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final org.json.JSONObject j(org.json.JSONObject r6) {
            /*
                Method dump skipped, instructions count: 647
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: gs4.g0.c.j(org.json.JSONObject):org.json.JSONObject");
        }

        private final void b(String str, JSONObject jSONObject) {
            Pair<Integer, Integer> k = k(str);
            if (k == null) {
                return;
            }
            jSONObject.putOpt("applied_image_width", k.first);
            jSONObject.putOpt("applied_image_height", k.second);
        }

        private final void c(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null) {
                jSONObject2.putOpt("pause_time", jSONObject.opt("pause_time"));
                jSONObject2.putOpt("decode_queue_duration", jSONObject.opt("decode_queue_duration"));
                f(jSONObject, jSONObject2);
            }
        }

        private final void d(String str, JSONObject jSONObject) {
            Pair<Integer, Integer> k = k(str);
            if (k == null) {
                return;
            }
            jSONObject.putOpt("intended_image_width", k.first);
            jSONObject.putOpt("intended_image_height", k.second);
        }

        private final void e(JSONObject jSONObject, JSONObject jSONObject2) {
            JSONObject optJSONObject;
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("net_timing_detail")) != null) {
                jSONObject2.putOpt("timing_dns", optJSONObject.opt("timing_dns"));
                jSONObject2.putOpt("timing_ssl", optJSONObject.opt("timing_ssl"));
                jSONObject2.putOpt("timing_connect", optJSONObject.opt("timing_connect"));
            }
        }

        public final JSONObject l(JSONObject jSONObject, JSONObject jSONObject2) {
            Iterator<String> keys;
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject2 != null && (keys = jSONObject2.keys()) != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.putOpt(next, jSONObject2.opt(next));
                }
            }
            return jSONObject;
        }

        private final void f(JSONObject jSONObject, JSONObject jSONObject2) {
            List<String> listOf;
            if (jSONObject == null) {
                return;
            }
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"BackgroundThreadHandoffProducer", "BitmapMemoryCacheProducer", "EncodedMemoryCacheProducer", "DiskCacheProducer", "DiskCacheWriteProducer"});
            for (String str : listOf) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("producer_start", -1L);
                    long optLong2 = optJSONObject.optLong("producer_end", -1L);
                    if (optLong >= 0 && optLong2 >= 0) {
                        jSONObject2.putOpt(str, Long.valueOf(optLong2 - optLong));
                    }
                }
            }
        }

        private final void g(JSONObject jSONObject, JSONObject jSONObject2) {
            String str;
            if (jSONObject != null) {
                jSONObject2.putOpt("cover_type", jSONObject.opt("cover_type"));
                jSONObject2.putOpt("is_mall_stagger_img", Boolean.valueOf(Intrinsics.areEqual("true", jSONObject.opt("is_mall_stagger_img"))));
                jSONObject2.putOpt("biz_tag", jSONObject.opt("biz_tag"));
                Object opt = jSONObject.opt("tab_type");
                if (opt != null) {
                    str = opt.toString();
                } else {
                    str = null;
                }
                jSONObject2.putOpt("tab_type", Integer.valueOf(NumberUtils.parseInt(str, -1)));
                jSONObject2.putOpt("image_compress_key", jSONObject.opt("image_compress_key"));
                jSONObject2.putOpt("is_dynamic_image", jSONObject.opt("is_dynamic_image"));
            }
        }

        public void onImageLoaded(boolean z, String str, JSONObject jSONObject) {
            boolean z2;
            try {
                JSONObject l = l(new JSONObject(), j(jSONObject));
                h(l);
                if (z.a.m(str)) {
                    LogWrapper.info("GlobalFrescoStats", "first screen imageLoaded: " + l, new Object[0]);
                    l.putOpt("custom_biz_tag", "first_screen");
                    com.dragon.read.base.depend.g.b.e("first_screen_image_item_trace", l);
                } else {
                    o.c cVar = o.j;
                    if (cVar.a().r(str)) {
                        LogWrapper.info("GlobalFrescoStats", "book shelf first enter imageLoaded: reqId(" + str + ") " + l, new Object[0]);
                        l.putOpt("custom_biz_tag", "book_shelf");
                        com.dragon.read.base.depend.g.b.e("first_screen_image_item_trace", l);
                    } else if (cVar.b().r(str)) {
                        LogWrapper.info("GlobalFrescoStats", "stagger first enter imageLoaded: reqId(" + str + ") " + l, new Object[0]);
                        l.putOpt("custom_biz_tag", "stagger");
                        com.dragon.read.base.depend.g.b.e("first_screen_image_item_trace", l);
                    }
                }
                if (FrescoEnableSensible.a.a().enable) {
                    if (jSONObject != null && jSONObject.optBoolean("is_request_network")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        com.dragon.read.base.depend.g.b.e("fresco_image_item_trace", l);
                    }
                    com.dragon.read.base.depend.g.b.e("fresco_image_item_trace_sensible", l);
                    return;
                }
                com.dragon.read.base.depend.g.b.e("fresco_image_item_trace", l);
            } catch (Exception e) {
                LogWrapper.error("GlobalFrescoStats", "图片监控上报错误：%s", new Object[]{LogInfoUtils.getErrorInfo(e)});
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(String str, int i, int i2, int i3, int i4) {
            ToastUtils.showCommonToast('[' + str + "]下载图片过大: " + i + 'x' + i2 + "->" + i3 + 'x' + i4);
        }
    }

    public static final class b implements IMonitorHookV2 {
        static {
            Covode.recordClassIndex(612328);
        }

        public Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest imageRequest, Object obj, String str, JSONObject jSONObject, boolean z, boolean z2) {
            Map customParam;
            if (imageRequest != null && (customParam = imageRequest.getCustomParam()) != null) {
            }
            Pair<Boolean, Map<String, Object>> create = Pair.create(Boolean.FALSE, null);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }
    }
}
