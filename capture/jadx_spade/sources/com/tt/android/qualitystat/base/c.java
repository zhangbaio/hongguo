package com.tt.android.qualitystat.base;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public static final a c;
    public final JSONObject a;
    private final long b;

    static {
        Covode.recordClassIndex(654026);
        c = new a(null);
    }

    public String toString() {
        String jSONObject = this.a.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "result.toString()");
        return jSONObject;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(654027);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final c e(String str) {
        this.a.remove(str);
        return this;
    }

    public c(long j) {
        this.b = j;
        this.a = new JSONObject();
    }

    public final c b(JSONObject jSONObject, long j) {
        Iterator<String> keys;
        if (jSONObject != null && (keys = jSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String it2 = keys.next();
                Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                a(it2, jSONObject.opt(it2), j);
            }
        }
        return this;
    }

    public /* synthetic */ c(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1L : j);
    }

    public final c a(String str, Object obj, long j) {
        Object opt = this.a.opt(str);
        if (!Intrinsics.areEqual(opt, obj)) {
            if (opt != null) {
                String str2 = "JSONBuilder key [" + str + ':' + obj + "] already exist, ";
                if (j == 1) {
                    QualityStatLog.c.h(str2 + "value will be overwrite: [" + opt + "] -> [" + obj + ']');
                    if (obj == null) {
                        this.a.remove(str);
                    } else if ((opt instanceof JSONObject) && (obj instanceof JSONObject)) {
                        this.a.putOpt(str, d(d(new c(j), (JSONObject) opt, 0L, 2, null), (JSONObject) obj, 0L, 2, null).a);
                    } else {
                        this.a.putOpt(str, obj);
                    }
                } else if (j == 2) {
                    QualityStatLog.c.h(str2 + "append value: [" + obj + ']');
                    this.a.accumulate(str, obj);
                } else if (j == 3) {
                    QualityStatLog.c.h(str2 + "ignore value: [" + obj + ']');
                }
            } else {
                this.a.putOpt(str, obj);
            }
        } else {
            QualityStatLog.c.h("Add duplicate key to JSON, do nothing!");
        }
        return this;
    }

    public static /* synthetic */ c d(c cVar, JSONObject jSONObject, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = cVar.b;
        }
        return cVar.b(jSONObject, j);
    }

    public static /* synthetic */ c c(c cVar, String str, Object obj, long j, int i, Object obj2) {
        if ((i & 4) != 0) {
            j = cVar.b;
        }
        return cVar.a(str, obj, j);
    }
}
