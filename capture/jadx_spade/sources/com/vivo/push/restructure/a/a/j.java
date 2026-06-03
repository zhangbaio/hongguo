package com.vivo.push.restructure.a.a;

import com.bytedance.covode.number.Covode;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j implements i<com.vivo.push.restructure.a.a> {
    private a a;
    private n b;
    private k c;
    private com.vivo.push.restructure.c.a d;

    static {
        Covode.recordClassIndex(655115);
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final void a(g gVar) {
        this.a = gVar;
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* bridge */ /* synthetic */ void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.a.a aVar2 = aVar;
        if (aVar2 == null) {
            t.a("onAllNodeExecuteComplete, receivedMsg is null");
        } else if (this.a == null) {
            t.a("onAllNodeExecuteComplete, mFirstNode is null");
        } else {
            a2(aVar2);
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.vivo.push.restructure.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!aVar.e()) {
            t.a("core is not support monitor report");
            return;
        }
        t.a("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + aVar.f());
        if (aVar.f()) {
            n nVar = this.b;
            if (nVar != null) {
                nVar.a(aVar, this.a);
            }
            k kVar = this.c;
            if (kVar != null) {
                kVar.a(aVar, this.a.c().toString());
                t.a("reportNodeMonitorInfo() , report client NodeInfo！！！");
            } else {
                t.a("onNodeError , mReporter is null， can not report");
            }
        }
    }

    public j(n nVar, k kVar, com.vivo.push.restructure.c.a aVar) {
        this.b = nVar;
        this.c = kVar;
        this.d = aVar;
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* synthetic */ void a(a aVar, com.vivo.push.restructure.a.a aVar2, int i) {
        com.vivo.push.restructure.a.a aVar3 = aVar2;
        if (aVar3 == null) {
            t.a("onNodeError() receivedMsg is null ");
            return;
        }
        t.a("onNodeError() , msgID = " + aVar3.a() + ", nodeName = " + aVar.b());
        com.vivo.push.restructure.c.a aVar4 = this.d;
        if (aVar4 != null) {
            aVar4.a(i, aVar3.a());
        }
        a2(aVar3);
    }
}
