package oo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.apm.newquality.trace.QualityTracer;
import com.dragon.read.apm.newquality.trace.TraceContext;
import com.dragon.read.apm.newquality.trace.model.BaseSpan;
import com.dragon.read.util.kotlin.StringKt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements b {
    public static final a a;
    private static TraceContext b;
    private static BaseSpan c;
    public static final int d;

    static {
        Covode.recordClassIndex(609099);
        a = new a();
        d = 8;
    }

    private a() {
    }

    @Override // oo4.b
    public void cancel() {
        TraceContext traceContext = b;
        if (traceContext != null) {
            traceContext.cancel();
        }
        b = null;
        c = null;
    }

    @Override // oo4.b
    public void c() {
        BaseSpan baseSpan = c;
        if (baseSpan != null) {
            QualityTracer.endNetSpan(b, "/reading/bookapi/plan/v", baseSpan.getSpanId());
            TraceContext traceContext = b;
            if (traceContext != null) {
                traceContext.startSpan("render_dur");
            }
        }
    }

    @Override // oo4.b
    public void startTrace() {
        TraceContext traceContext = b;
        if (traceContext != null) {
            traceContext.cancel();
        }
        TraceContext startTrace = QualityTracer.startTrace("video_detail_first_load");
        b = startTrace;
        if (startTrace != null) {
            startTrace.setReportTraceEvent("qua_video_detail_event");
            startTrace.startSpan("init_dur");
        }
    }

    @Override // oo4.b
    public void a(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        TraceContext traceContext = b;
        if (traceContext != null) {
            traceContext.addTag("from", from);
        }
        TraceContext traceContext2 = b;
        if (traceContext2 != null) {
            traceContext2.addTag("is_kmp", "1");
        }
        TraceContext traceContext3 = b;
        if (traceContext3 != null) {
            if (traceContext3 != null) {
                traceContext3.endSpan("init_dur");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("inner_dur");
            arrayList.add("recommend_dur");
            c = QualityTracer.startNetSpan(b, "/reading/bookapi/plan/v", (String) null, arrayList);
        }
    }

    @Override // oo4.b
    public void b(String listName, String str) {
        TraceContext traceContext;
        TraceContext traceContext2;
        Intrinsics.checkNotNullParameter(listName, "listName");
        if (!StringKt.isNotNullOrEmpty(listName)) {
            listName = null;
        }
        if (listName != null && (traceContext2 = b) != null) {
            traceContext2.addTag("item_id", listName);
        }
        if (!StringKt.isNotNullOrEmpty(str)) {
            str = null;
        }
        if (str != null && (traceContext = b) != null) {
            traceContext.addTag("sub_item_id", str);
        }
        TraceContext traceContext3 = b;
        if (traceContext3 != null) {
            traceContext3.endSpan("render_dur");
        }
        TraceContext traceContext4 = b;
        if (traceContext4 != null) {
            traceContext4.end();
        }
        b = null;
        c = null;
    }
}
