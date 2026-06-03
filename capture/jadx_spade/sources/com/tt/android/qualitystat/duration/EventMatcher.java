package com.tt.android.qualitystat.duration;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.base.QualityStatLog;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Pair;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class EventMatcher {
    public static final EventMatcher a;

    private EventMatcher() {
    }

    static {
        Covode.recordClassIndex(654081);
        a = new EventMatcher();
    }

    public Pair<c, c> a(LinkedBlockingDeque<c> linkedBlockingDeque) {
        boolean z;
        Iterator<T> it2 = linkedBlockingDeque.iterator();
        Object obj = null;
        while (true) {
            boolean z2 = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            c cVar = (c) next;
            if (cVar.getType() != EventType.END || cVar.e != EventStatus.Init) {
                z2 = false;
            }
            if (z2) {
                obj = next;
            }
        }
        c cVar2 = (c) obj;
        if (cVar2 != null) {
            Object obj2 = null;
            for (Object obj3 : linkedBlockingDeque) {
                c cVar3 = (c) obj3;
                if (cVar3.d < cVar2.d && cVar3.e == EventStatus.Init && cVar3.getType() == EventType.START && sj6.c.g(cVar3.b, cVar2.b, 0, 2, null)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    obj2 = obj3;
                }
            }
            c cVar4 = (c) obj2;
            if (cVar4 == null) {
                cVar2.a(EventStatus.Ignored);
                return null;
            }
            if (cVar4.getType() == EventType.START && cVar2.getType() == EventType.END) {
                QualityStatLog.c.a("开始进行埋点匹配:" + cVar2);
                return new Pair<>(cVar4, cVar2);
            }
            QualityStatLog.c.c("没有找到合适的匹配点。 S: " + cVar4 + ", E: " + cVar2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0301 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0569 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0543 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0685 A[LOOP:13: B:269:0x067f->B:271:0x0685, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0671 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0647 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0226 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.util.concurrent.LinkedBlockingDeque<com.tt.android.qualitystat.duration.c> r26) {
        /*
            Method dump skipped, instructions count: 1687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tt.android.qualitystat.duration.EventMatcher.b(java.util.concurrent.LinkedBlockingDeque):void");
    }
}
