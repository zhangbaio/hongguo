package hs4;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.base.util.LogInfoUtils;
import com.dragon.read.report.ReportManager;
import com.optimize.statistics.ImageTraceListener;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e implements ImageTraceListener {
    public static final int c;
    private final String a;
    private final LogHelper b;

    static {
        Covode.recordClassIndex(612341);
        c = 8;
    }

    protected JSONObject f() {
        return null;
    }

    public void imageNetCallBack(long j, long j2, String str, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject) {
    }

    public e(String bizTag) {
        Intrinsics.checkNotNullParameter(bizTag, "bizTag");
        this.a = bizTag;
        this.b = new LogHelper("StaggerImageTraceListener_" + bizTag);
    }

    private final Pair<Integer, Integer> h(String str) {
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
            this.b.e("parse image_size error, %s", new Object[]{LogInfoUtils.getErrorInfo(e)});
            return null;
        }
    }

    private final JSONObject g(JSONObject jSONObject) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        String str;
        String str2;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        if (jSONObject == null) {
            new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = null;
        if (jSONObject != null) {
            obj = jSONObject.opt("uri");
        } else {
            obj = null;
        }
        jSONObject2.putOpt("uri", obj);
        if (jSONObject != null) {
            obj2 = jSONObject.opt("sampleSize");
        } else {
            obj2 = null;
        }
        jSONObject2.putOpt("sampleSize", obj2);
        if (jSONObject != null) {
            obj3 = jSONObject.opt("image_ram_size");
        } else {
            obj3 = null;
        }
        jSONObject2.putOpt("image_ram_size", obj3);
        if (jSONObject != null) {
            obj4 = jSONObject.opt("file_size");
        } else {
            obj4 = null;
        }
        jSONObject2.putOpt("file_size", obj4);
        if (jSONObject != null) {
            obj5 = jSONObject.opt("image_count");
        } else {
            obj5 = null;
        }
        jSONObject2.putOpt("image_count", obj5);
        if (jSONObject != null) {
            obj6 = jSONObject.opt("image_type");
        } else {
            obj6 = null;
        }
        jSONObject2.putOpt("image_type", obj6);
        if (jSONObject != null) {
            str = jSONObject.optString("intended_image_size");
        } else {
            str = null;
        }
        c(str, jSONObject2);
        if (jSONObject != null) {
            str2 = jSONObject.optString("applied_image_size");
        } else {
            str2 = null;
        }
        a(str2, jSONObject2);
        if (jSONObject != null) {
            obj7 = jSONObject.opt("duration");
        } else {
            obj7 = null;
        }
        jSONObject2.putOpt("duration", obj7);
        if (jSONObject != null) {
            obj8 = jSONObject.opt("queue_duration");
        } else {
            obj8 = null;
        }
        jSONObject2.putOpt("queue_duration", obj8);
        if (jSONObject != null) {
            obj9 = jSONObject.opt("download_duration");
        } else {
            obj9 = null;
        }
        jSONObject2.putOpt("download_duration", obj9);
        if (jSONObject != null) {
            obj10 = jSONObject.opt("cache_seek_duration");
        } else {
            obj10 = null;
        }
        jSONObject2.putOpt("cache_seek_duration", obj10);
        if (jSONObject != null) {
            obj11 = jSONObject.opt("decode_duration");
        } else {
            obj11 = null;
        }
        jSONObject2.putOpt("decode_duration", obj11);
        if (jSONObject != null) {
            obj12 = jSONObject.opt("load_status");
        } else {
            obj12 = null;
        }
        jSONObject2.putOpt("load_status", obj12);
        if (!Intrinsics.areEqual("success", obj12)) {
            if (jSONObject != null) {
                obj19 = jSONObject.opt("fail_phase");
            } else {
                obj19 = null;
            }
            jSONObject2.putOpt("fail_phase", obj19);
            if (jSONObject != null) {
                obj20 = jSONObject.opt("err_code");
            } else {
                obj20 = null;
            }
            jSONObject2.putOpt("err_code", obj20);
            if (jSONObject != null) {
                obj21 = jSONObject.opt("err_desc");
            } else {
                obj21 = null;
            }
            jSONObject2.putOpt("err_desc", obj21);
        }
        if (jSONObject != null) {
            obj13 = jSONObject.opt("http_status");
        } else {
            obj13 = null;
        }
        jSONObject2.putOpt("http_status", obj13);
        if (jSONObject != null) {
            obj14 = jSONObject.opt("is_request_network");
        } else {
            obj14 = null;
        }
        jSONObject2.putOpt("is_request_network", obj14);
        if (jSONObject != null) {
            obj15 = jSONObject.opt("hit_cdn_cache");
        } else {
            obj15 = null;
        }
        jSONObject2.putOpt("hit_cdn_cache", obj15);
        if (jSONObject != null) {
            obj16 = jSONObject.opt("network_quality");
        } else {
            obj16 = null;
        }
        jSONObject2.putOpt("network_quality", obj16);
        if (jSONObject != null) {
            obj17 = jSONObject.opt("network_type");
        } else {
            obj17 = null;
        }
        jSONObject2.putOpt("network_type", obj17);
        d(jSONObject, jSONObject2);
        if (jSONObject != null) {
            obj18 = jSONObject.opt("retry_open");
        } else {
            obj18 = null;
        }
        jSONObject2.putOpt("retry_open", obj18);
        if (jSONObject != null) {
            jSONObject3 = jSONObject.optJSONObject("image_monitor_data");
        }
        b(jSONObject3, jSONObject2);
        return jSONObject2;
    }

    private final void a(String str, JSONObject jSONObject) {
        Pair<Integer, Integer> h = h(str);
        if (h == null) {
            return;
        }
        jSONObject.putOpt("applied_image_width", h.first);
        jSONObject.putOpt("applied_image_height", h.second);
    }

    private final void b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            jSONObject2.putOpt("pause_time", jSONObject.opt("pause_time"));
            jSONObject2.putOpt("decode_queue_duration", jSONObject.opt("decode_queue_duration"));
            e(jSONObject, jSONObject2);
        }
    }

    private final void c(String str, JSONObject jSONObject) {
        Pair<Integer, Integer> h = h(str);
        if (h == null) {
            return;
        }
        jSONObject.putOpt("intended_image_width", h.first);
        jSONObject.putOpt("intended_image_height", h.second);
    }

    private final void d(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("net_timing_detail")) != null) {
            jSONObject2.putOpt("timing_dns", optJSONObject.opt("timing_dns"));
            jSONObject2.putOpt("timing_ssl", optJSONObject.opt("timing_ssl"));
            jSONObject2.putOpt("timing_connect", optJSONObject.opt("timing_connect"));
        }
    }

    protected final JSONObject i(JSONObject jSONObject, JSONObject jSONObject2) {
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

    private final void e(JSONObject jSONObject, JSONObject jSONObject2) {
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

    public final void onImageLoaded(boolean z, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("business_params");
                if (optJSONObject != null && Intrinsics.areEqual(this.a, optJSONObject.optString("biz_tag")) && optJSONObject.optInt("bind_times") == 1) {
                    JSONObject i = i(i(new JSONObject(), optJSONObject), g(jSONObject));
                    JSONObject f = f();
                    if (f != null) {
                        i(i, f);
                    }
                    ReportManager.onReport("store_card_image_load_monitor", i);
                }
            } catch (Exception e) {
                this.b.e("双列图片监控上报错误：%s", new Object[]{LogInfoUtils.getErrorInfo(e)});
            }
        }
    }
}
