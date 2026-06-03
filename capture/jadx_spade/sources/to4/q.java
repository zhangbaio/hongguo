package to4;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import to4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public static final int c;
    private final MutableStateFlow<gk4.o> a;
    public final StateFlow<gk4.o> b;

    static {
        Covode.recordClassIndex(609124);
        c = 8;
    }

    private final void c() {
    }

    public q() {
        MutableStateFlow<gk4.o> MutableStateFlow = StateFlowKt.MutableStateFlow(new gk4.o(null, 1, null));
        this.a = MutableStateFlow;
        this.b = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void h(gk4.o state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.a.setValue(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(gk4.n channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        StringBuilder sb = new StringBuilder();
        sb.append(channel.a);
        sb.append(':');
        String str = channel.b;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(gk4.n channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        StringBuilder sb = new StringBuilder();
        sb.append(channel.a);
        sb.append(':');
        String str = channel.b;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public final void d(a action) {
        Intrinsics.checkNotNullParameter(action, "action");
        com.dragon.read.kmp.base.util.b.a("ChannelOrderViewModel", "onAction action=" + Reflection.getOrCreateKotlinClass(action.getClass()).getSimpleName());
        if (action instanceof a.C0273a) {
            c();
        } else {
            if (action instanceof a.b) {
                a.b bVar = (a.b) action;
                e(bVar.a, bVar.b);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void e(androidx.compose.foundation.lazy.o oVar, int i) {
        boolean z;
        gk4.o value;
        List<gk4.n> list = this.a.getValue().a;
        int index = oVar.getIndex();
        Iterator<gk4.n> it2 = list.iterator();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (it2.hasNext()) {
                if (Intrinsics.areEqual(it2.next().a, oVar.getKey())) {
                    break;
                } else {
                    i2++;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        if (index >= 0 && index < list.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i >= 0 && i < list.size()) {
                z2 = true;
            }
            if (!z2 || index == i || list.get(index).c || list.get(i).c || i2 == i) {
                return;
            }
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1() { // from class: to4.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence f;
                    f = q.f((gk4.n) obj);
                    return f;
                }
            }, 30, null);
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            mutableList.add(i, (gk4.n) mutableList.remove(index));
            List<gk4.n> list2 = CollectionsKt___CollectionsKt.toList(mutableList);
            String joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, new Function1() { // from class: to4.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence g;
                    g = q.g((gk4.n) obj);
                    return g;
                }
            }, 30, null);
            MutableStateFlow<gk4.o> mutableStateFlow = this.a;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, value.a(list2)));
            com.dragon.read.kmp.base.util.b.a("ChannelOrderViewModel", "reduceMove success itemId=" + oVar.getKey() + " from=" + index + " to=" + i + " size=" + list2.size() + " oldOrder=" + joinToString$default + " newOrder=" + joinToString$default2);
        }
    }
}
