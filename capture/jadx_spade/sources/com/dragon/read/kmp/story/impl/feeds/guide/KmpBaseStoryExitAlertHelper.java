package com.dragon.read.kmp.story.impl.feeds.guide;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.guide.a;
import ec4.l0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class KmpBaseStoryExitAlertHelper implements a {
    public static final int k;
    private final yo4.d a;
    private final float b;
    private final l0 c;
    public final a.InterfaceC0074a d;
    public boolean e;
    private final MutableStateFlow<List<kp4.b>> f;
    public final StateFlow<List<kp4.b>> g;
    public final MutableStateFlow<Pair<KmpStoryExitAlertType, kp4.b>> h;
    public final StateFlow<Pair<KmpStoryExitAlertType, kp4.b>> i;
    public final com.dragon.read.kmp.n j;

    static {
        Covode.recordClassIndex(609286);
        k = 8;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class DialogEvent {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DialogEvent[] $VALUES;
        public static final DialogEvent CLOSE;
        public static final DialogEvent EXIT;
        public static final DialogEvent GO_TO_READ;
        public static final DialogEvent NONE;

        private static final /* synthetic */ DialogEvent[] $values() {
            return new DialogEvent[]{NONE, CLOSE, EXIT, GO_TO_READ};
        }

        public static EnumEntries<DialogEvent> getEntries() {
            return $ENTRIES;
        }

        public static DialogEvent[] values() {
            return (DialogEvent[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(609287);
            NONE = new DialogEvent("NONE", 0);
            CLOSE = new DialogEvent("CLOSE", 1);
            EXIT = new DialogEvent("EXIT", 2);
            GO_TO_READ = new DialogEvent("GO_TO_READ", 3);
            DialogEvent[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static DialogEvent valueOf(String str) {
            return (DialogEvent) Enum.valueOf(DialogEvent.class, str);
        }

        private DialogEvent(String str, int i) {
        }
    }

    protected final boolean h() {
        yo4.d dVar = this.a;
        return Intrinsics.areEqual(dVar.e, dVar.c());
    }

    public void i() {
        if (a()) {
            return;
        }
        kotlinx.coroutines.i.e(this.j, Dispatchers.getIO(), null, new KmpBaseStoryExitAlertHelper$prepareExitRecommendStory$1(this, null), 2, null);
    }

    public kp4.b g() {
        Object obj;
        List<kp4.b> value = this.g.getValue();
        List<kp4.b> g = this.d.g();
        if (g == null) {
            g = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator it2 = CollectionsKt___CollectionsKt.plus((Collection) value, (Iterable) g).iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (!this.d.c(((kp4.b) obj).a())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (kp4.b) obj;
    }

    public KmpBaseStoryExitAlertHelper(yo4.d clientParam, float f, l0 strategy, a.InterfaceC0074a dependency) {
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        this.a = clientParam;
        this.b = f;
        this.c = strategy;
        this.d = dependency;
        MutableStateFlow<List<kp4.b>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt__CollectionsKt.emptyList());
        this.f = MutableStateFlow;
        this.g = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Pair<KmpStoryExitAlertType, kp4.b>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new Pair(KmpStoryExitAlertType.NONE, null));
        this.h = MutableStateFlow2;
        this.i = FlowKt.asStateFlow(MutableStateFlow2);
        this.j = com.dragon.read.kmp.n.a;
    }
}
