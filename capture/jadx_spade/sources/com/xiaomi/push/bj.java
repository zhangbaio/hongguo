package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bj implements Runnable {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f147a;

    static {
        Covode.recordClassIndex(655379);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.xiaomi.clientreport.processor.c cVar = this.f147a;
            if (cVar != null) {
                cVar.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            com.xiaomi.clientreport.processor.c cVar2 = this.f147a;
            if (cVar2 instanceof IEventProcessor) {
                bl.a(this.a).m191a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (cVar2 instanceof IPerfProcessor) {
                bl.a(this.a).m191a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(Context context) {
        this.a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f147a = cVar;
    }
}
