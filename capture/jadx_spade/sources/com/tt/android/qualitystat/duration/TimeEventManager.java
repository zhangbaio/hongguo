package com.tt.android.qualitystat.duration;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tt.android.qualitystat.UserStatAgent;
import com.tt.android.qualitystat.base.QualityStatLog;
import com.tt.android.qualitystat.util.KotlinExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TimeEventManager {
    private static final LinkedBlockingDeque<c> a;
    public static final TimeEventManager b;

    private TimeEventManager() {
    }

    static {
        Covode.recordClassIndex(654086);
        b = new TimeEventManager();
        a = new LinkedBlockingDeque<>(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES);
    }

    public final void e() {
        QualityStatLog qualityStatLog = QualityStatLog.c;
        StringBuilder sb = new StringBuilder();
        sb.append("clear time_event[");
        LinkedBlockingDeque<c> linkedBlockingDeque = a;
        sb.append(linkedBlockingDeque.size());
        sb.append("] in TimeAxisManager!");
        qualityStatLog.f(sb.toString());
        linkedBlockingDeque.clear();
    }

    private final synchronized void f() {
        LinkedBlockingDeque<c> linkedBlockingDeque = a;
        if (linkedBlockingDeque.size() != 0 && !linkedBlockingDeque.isEmpty()) {
            final long currentTimeMillis = System.currentTimeMillis();
            final int B = com.tt.android.qualitystat.config.c.b.c().B();
            if (linkedBlockingDeque.size() <= 200 && (linkedBlockingDeque.size() <= 40 || currentTimeMillis - ((c) CollectionsKt___CollectionsKt.first(linkedBlockingDeque)).f <= B)) {
                if (UserStatAgent.g.d()) {
                    QualityStatLog.c.f("不需要清理事件队列, " + g(linkedBlockingDeque));
                }
            }
            final int max = linkedBlockingDeque.getFirst().d + (Math.max(linkedBlockingDeque.size(), 200) / 2);
            QualityStatLog qualityStatLog = QualityStatLog.c;
            qualityStatLog.f("开始清理事件队列, " + g(linkedBlockingDeque));
            CollectionsKt__MutableCollectionsKt.removeAll(linkedBlockingDeque, new Function1<c, Boolean>() { // from class: com.tt.android.qualitystat.duration.TimeEventManager$clearTimeoutEvent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(c cVar) {
                    return Boolean.valueOf(invoke2(cVar));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(c cVar) {
                    if (cVar.d >= max && currentTimeMillis - cVar.f <= B) {
                        return false;
                    }
                    return true;
                }
            });
            qualityStatLog.f("事件队列清理完成, " + g(linkedBlockingDeque));
        }
    }

    public final void j(final c cVar) {
        com.tt.android.qualitystat.util.b.c.a(new Function0<Unit>() { // from class: com.tt.android.qualitystat.duration.TimeEventManager$onReceiveNewEvent$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinkedBlockingDeque linkedBlockingDeque;
                LinkedBlockingDeque linkedBlockingDeque2;
                LinkedBlockingDeque linkedBlockingDeque3;
                LinkedBlockingDeque linkedBlockingDeque4;
                TimeEventManager timeEventManager = TimeEventManager.b;
                linkedBlockingDeque = TimeEventManager.a;
                if (linkedBlockingDeque.size() >= 200) {
                    linkedBlockingDeque4 = TimeEventManager.a;
                    linkedBlockingDeque4.removeFirst();
                }
                linkedBlockingDeque2 = TimeEventManager.a;
                linkedBlockingDeque2.addLast(c.this);
                int i = b.a[c.this.getType().ordinal()];
                boolean z = true;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return;
                        }
                        linkedBlockingDeque3 = TimeEventManager.a;
                        Iterator it2 = linkedBlockingDeque3.iterator();
                        c cVar2 = null;
                        Object obj = null;
                        while (true) {
                            boolean z2 = false;
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (((c) next).getType() == EventType.END) {
                                z2 = true;
                            }
                            if (z2) {
                                obj = next;
                            }
                        }
                        c cVar3 = (c) obj;
                        if (cVar3 != null) {
                            long j = cVar3.f;
                            c cVar4 = c.this;
                            if (j != cVar4.f || cVar3.e == EventStatus.Init) {
                                z = false;
                            }
                            if (z) {
                                cVar2 = cVar3;
                            }
                            if (cVar2 != null) {
                                cVar4.a(cVar2.e);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    timeEventManager.h(c.this);
                    return;
                }
                timeEventManager.i(c.this);
            }
        });
    }

    public final void k(final List<c> list) {
        if (UserStatAgent.g.d()) {
            if (list == null) {
                list = CollectionsKt___CollectionsKt.toList(a);
            }
            com.tt.android.qualitystat.util.b.c.a(new Function0<Unit>() { // from class: com.tt.android.qualitystat.duration.TimeEventManager$printEventList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String g;
                    if (!list.isEmpty()) {
                        QualityStatLog qualityStatLog = QualityStatLog.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("---> print eventlist start, ");
                        g = TimeEventManager.b.g(list);
                        sb.append(g);
                        qualityStatLog.a(sb.toString());
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            QualityStatLog.c.f(((c) it2.next()).toString());
                        }
                        QualityStatLog.c.a("---> print eventlist end");
                        return;
                    }
                    QualityStatLog.c.a("eventlist is empty!");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(Collection<c> collection) {
        Object firstOrNull;
        Integer num;
        Object lastOrNull;
        Integer num2;
        Object firstOrNull2;
        Long l;
        Object lastOrNull2;
        if (collection.isEmpty()) {
            return "list is empty!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size:");
        sb.append(collection.size());
        sb.append(", index range: (");
        Collection<c> collection2 = collection;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(collection2);
        c cVar = (c) firstOrNull;
        Long l2 = null;
        if (cVar != null) {
            num = Integer.valueOf(cVar.d);
        } else {
            num = null;
        }
        sb.append(num);
        sb.append(", ");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull(collection2);
        c cVar2 = (c) lastOrNull;
        if (cVar2 != null) {
            num2 = Integer.valueOf(cVar2.d);
        } else {
            num2 = null;
        }
        sb.append(num2);
        sb.append(')');
        sb.append(", time range: (");
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull(collection2);
        c cVar3 = (c) firstOrNull2;
        if (cVar3 != null) {
            l = Long.valueOf(cVar3.f);
        } else {
            l = null;
        }
        sb.append(KotlinExtKt.c(l));
        sb.append(", ");
        lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull(collection2);
        c cVar4 = (c) lastOrNull2;
        if (cVar4 != null) {
            l2 = Long.valueOf(cVar4.f);
        }
        sb.append(KotlinExtKt.c(l2));
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(c cVar) {
        boolean z;
        Iterator<T> it2 = a.iterator();
        Object obj = null;
        Object obj2 = null;
        while (true) {
            boolean z2 = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            c cVar2 = (c) next;
            if (cVar2.d >= cVar.d || cVar2.getType() != EventType.END || !sj6.c.g(cVar2.b, cVar.b, 0, 2, null)) {
                z2 = false;
            }
            if (z2) {
                obj2 = next;
            }
        }
        c cVar3 = (c) obj2;
        if (cVar3 != null) {
            long j = cVar.f - cVar3.f;
            int t = com.tt.android.qualitystat.config.c.b.b(cVar.b).t();
            if (j < t) {
                if (UserStatAgent.g.d()) {
                    QualityStatLog qualityStatLog = QualityStatLog.c;
                    qualityStatLog.a("curEvent: " + cVar);
                    qualityStatLog.a("preEvent: " + cVar3);
                }
                QualityStatLog.c.h("END event interval: " + j + " ms, filterInterval: " + t + " ms, change status to: Duplicated");
                cVar.a(EventStatus.Ignored);
                Iterator<T> it4 = a.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next2 = it4.next();
                    if (((c) next2).f == cVar.f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        obj = next2;
                        break;
                    }
                }
                c cVar4 = (c) obj;
                if (cVar4 != null) {
                    cVar4.a(EventStatus.Ignored);
                }
            }
        }
        if (cVar.e == EventStatus.Init) {
            EventMatcher.a.b(a);
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(c cVar) {
        Object obj;
        boolean z;
        boolean z2;
        boolean z3;
        Object obj2;
        boolean z4;
        LinkedBlockingDeque<c> linkedBlockingDeque = a;
        if (linkedBlockingDeque.size() == 0) {
            return;
        }
        int c = com.tt.android.qualitystat.config.c.b.b(cVar.b).c();
        Iterator<T> it2 = linkedBlockingDeque.iterator();
        Object obj3 = null;
        while (true) {
            boolean z5 = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            c cVar2 = (c) next;
            if (cVar2.d >= cVar.d || cVar2.getType() != EventType.START || cVar2.e == EventStatus.Used || !sj6.c.g(cVar2.b, cVar.b, 0, 2, null)) {
                z5 = false;
            }
            if (z5) {
                obj3 = next;
            }
        }
        c cVar3 = (c) obj3;
        if (cVar3 != null) {
            long j = cVar.f;
            if (j - cVar3.f <= c) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                cVar3 = null;
            }
            if (cVar3 != null) {
                long j2 = j - cVar3.f;
                if (UserStatAgent.g.d()) {
                    QualityStatLog qualityStatLog = QualityStatLog.c;
                    qualityStatLog.a("preEvent: " + cVar3);
                    qualityStatLog.a("MERGE_DUPLICATE_START_AT_SHORT, curEvent: " + cVar);
                }
                QualityStatLog.c.h("START event interval: " + j2 + " ms, filterInterval: " + c + " ms, current START event it Duplicated");
                cVar.a(EventStatus.Ignored);
                Iterator<T> it4 = a.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        obj2 = it4.next();
                        if (((c) obj2).f == cVar.f) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                c cVar4 = (c) obj2;
                if (cVar4 != null) {
                    cVar4.a(EventStatus.Ignored);
                }
            }
        }
        LinkedBlockingDeque<c> linkedBlockingDeque2 = a;
        ArrayList<c> arrayList = new ArrayList();
        for (Object obj4 : linkedBlockingDeque2) {
            c cVar5 = (c) obj4;
            if (cVar5.d < cVar.d && cVar5.getType() == EventType.START && cVar5.e == EventStatus.Init && sj6.c.g(cVar5.b, cVar.b, 0, 2, null) && cVar.f - cVar5.f > c) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj4);
            }
        }
        for (c cVar6 : arrayList) {
            long j3 = cVar.f - cVar6.f;
            if (UserStatAgent.g.d()) {
                QualityStatLog.c.a("IGNORE_DUPLICATE_START_FOR_LONG , preEvent: " + cVar6);
            }
            QualityStatLog.c.h("START event interval: " + j3 + " ms, filterInterval: " + c + " ms, Ignored pre START event");
            cVar6.a(EventStatus.Ignored);
            Iterator<T> it5 = a.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (((c) obj).f == cVar6.f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            c cVar7 = (c) obj;
            if (cVar7 != null) {
                cVar7.a(EventStatus.Ignored);
            }
        }
    }
}
