package com.tt.android.qualitystat.duration;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.UserStatAgent;
import com.tt.android.qualitystat.base.QualityStatLog;
import com.tt.android.qualitystat.constants.SystemScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TimeMatchProcessorKt {
    static {
        Covode.recordClassIndex(654088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList<Pair<c, c>> f(Pair<c, c> pair) {
        ArrayList<Pair<c, c>> arrayListOf;
        QualityStatLog.c.a("******************************** matchSimpleTimeCost **********************************");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(pair);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList<Pair<c, c>> e(List<c> list) {
        c cVar;
        Object obj;
        boolean z;
        boolean z2;
        QualityStatLog.c.a("******************************** matchForegroundTimeCost START **********************************");
        ArrayList<Pair<c, c>> arrayList = new ArrayList<>();
        c cVar2 = (c) CollectionsKt___CollectionsKt.first((List) list);
        c cVar3 = (c) CollectionsKt___CollectionsKt.last((List) list);
        if (list.size() == 2) {
            arrayList.add(new Pair<>(cVar2, cVar3));
        } else if (list.size() > 2) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                cVar = null;
                if (it2.hasNext()) {
                    obj = it2.next();
                    c cVar4 = (c) obj;
                    if (cVar4.d > cVar2.d && cVar4.getType() == EventType.PAUSE && cVar4.e == EventStatus.Init && (sj6.c.g(cVar4.b, cVar3.b, 0, 2, null) || ArraysKt___ArraysKt.contains(SystemScene.values(), cVar4.b))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            c cVar5 = (c) obj;
            if (cVar5 == null) {
                cVar5 = cVar3;
            }
            ListIterator<c> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                c previous = listIterator.previous();
                c cVar6 = previous;
                if (cVar6.d < cVar3.d && cVar6.getType() == EventType.CONTINUE && cVar6.e == EventStatus.Init && (sj6.c.g(cVar6.b, cVar3.b, 0, 2, null) || cVar6.b == SystemScene.App)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    cVar = previous;
                    break;
                }
            }
            c cVar7 = cVar;
            if (cVar7 == null) {
                cVar7 = cVar3;
            }
            if (cVar5.d >= cVar7.d) {
                arrayList.add(new Pair<>(cVar2, cVar3));
            } else {
                arrayList.add(new Pair<>(cVar2, cVar5));
                if (cVar7.d < cVar3.d) {
                    arrayList.add(new Pair<>(cVar7, cVar3));
                }
            }
        }
        if (UserStatAgent.g.d()) {
            QualityStatLog.c.a(CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", "matched index pairs: ", null, 0, null, new Function1<Pair<? extends c, ? extends c>, String>() { // from class: com.tt.android.qualitystat.duration.TimeMatchProcessorKt$matchEventForegroundTimeCost$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Pair<? extends c, ? extends c> pair) {
                    return invoke2((Pair<c, c>) pair);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final String invoke2(Pair<c, c> pair) {
                    return '(' + pair.getFirst().d + "->" + pair.getSecond().d + ')';
                }
            }, 28, null));
        }
        QualityStatLog.c.a("******************************** matchForegroundTimeCost END **********************************");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList<Pair<c, c>> d(List<c> list, Pair<c, c> pair) {
        Object obj;
        Object obj2;
        boolean z;
        boolean z2;
        QualityStatLog.c.a("******************************** matchAppForegroundTimeCost START **********************************");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (true) {
            boolean z3 = true;
            obj = null;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            c cVar = (c) next;
            if (!sj6.c.g(cVar.b, pair.getSecond().b, 0, 2, null) && cVar.b != SystemScene.App) {
                z3 = false;
            }
            if (z3) {
                arrayList.add(next);
            }
        }
        ArrayList<Pair<c, c>> arrayList2 = new ArrayList<>();
        c cVar2 = (c) CollectionsKt___CollectionsKt.first((List) arrayList);
        c cVar3 = (c) CollectionsKt___CollectionsKt.last((List) arrayList);
        if (arrayList.size() == 2) {
            arrayList2.add(new Pair<>(cVar2, cVar3));
        } else if (arrayList.size() > 2) {
            Iterator it4 = arrayList.iterator();
            while (true) {
                if (it4.hasNext()) {
                    obj2 = it4.next();
                    c cVar4 = (c) obj2;
                    if (cVar4.d > cVar2.d && cVar4.getType() == EventType.PAUSE && cVar4.e == EventStatus.Init) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            c cVar5 = (c) obj2;
            if (cVar5 == null) {
                cVar5 = cVar3;
            }
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                Object previous = listIterator.previous();
                c cVar6 = (c) previous;
                if (cVar6.d < cVar3.d && cVar6.getType() == EventType.CONTINUE && cVar6.e == EventStatus.Init) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    obj = previous;
                    break;
                }
            }
            c cVar7 = (c) obj;
            if (cVar7 == null) {
                cVar7 = cVar3;
            }
            if (cVar5.d >= cVar7.d) {
                arrayList2.add(new Pair<>(cVar2, cVar3));
            } else {
                arrayList2.add(new Pair<>(cVar2, cVar5));
                if (cVar7.d < cVar3.d) {
                    arrayList2.add(new Pair<>(cVar7, cVar3));
                }
            }
        }
        if (UserStatAgent.g.d()) {
            QualityStatLog.c.a(CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", "matched index pairs: ", null, 0, null, new Function1<Pair<? extends c, ? extends c>, String>() { // from class: com.tt.android.qualitystat.duration.TimeMatchProcessorKt$matchAppForegroundTimeCost$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Pair<? extends c, ? extends c> pair2) {
                    return invoke2((Pair<c, c>) pair2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final String invoke2(Pair<c, c> pair2) {
                    return '(' + pair2.getFirst().d + "->" + pair2.getSecond().d + ')';
                }
            }, 28, null));
        }
        QualityStatLog.c.a("******************************** matchAppForegroundTimeCost END **********************************");
        return arrayList2;
    }
}
