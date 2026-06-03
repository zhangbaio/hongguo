package to4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.g1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import to4.a;
import to4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(609121);
        a = new d();
    }

    private d() {
    }

    static final class a implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ List<gk4.n> a;

        a(List<gk4.n> list) {
            this.a = list;
        }

        private static final gk4.o d(State<gk4.o> state) {
            return (gk4.o) state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(State state, boolean z) {
            ((com.dragon.read.kmp.service.g) state.getValue()).b(!z);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
            c(gVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(com.dragon.read.kmp.service.g gVar, q qVar, to4.a action) {
            Intrinsics.checkNotNullParameter(action, "action");
            if (action instanceof a.C0273a) {
                gVar.a();
            }
            qVar.d(action);
            return Unit.INSTANCE;
        }

        public final void c(final com.dragon.read.kmp.service.g dialog, Composer composer, int i) {
            int i2;
            boolean z;
            boolean changedInstance;
            int i3;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            if ((i & 6) == 0) {
                if ((i & 8) == 0) {
                    changedInstance = composer.changed(dialog);
                } else {
                    changedInstance = composer.changedInstance(dialog);
                }
                if (changedInstance) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            boolean z2 = false;
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1207345814, i2, -1, "com.dragon.read.kmp.sortdialog.ChannelOrderDialogHelper.showDialog.<anonymous> (ChannelOrderDialogHelper.kt:59)");
                }
                composer.startReplaceGroup(1849434622);
                List<gk4.n> list = this.a;
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                Object obj = rememberedValue;
                if (rememberedValue == companion.getEmpty()) {
                    q qVar = new q();
                    qVar.h(new gk4.o(list));
                    composer.updateRememberedValue(qVar);
                    obj = qVar;
                }
                final q qVar2 = (q) obj;
                composer.endReplaceGroup();
                State collectAsState = SnapshotStateKt.collectAsState(qVar2.b, (CoroutineContext) null, composer, 0, 1);
                int i4 = i2 & 14;
                final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(dialog, composer, com.dragon.read.kmp.service.g.b | i4);
                gk4.o d = d(collectAsState);
                composer.startReplaceGroup(-1633490746);
                if (i4 == 4 || ((i2 & 8) != 0 && composer.changedInstance(dialog))) {
                    z2 = true;
                }
                boolean changedInstance2 = composer.changedInstance(qVar2) | z2;
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: to4.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit e;
                            e = d.a.e(com.dragon.read.kmp.service.g.this, qVar2, (a) obj2);
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function1 function1 = (Function1) rememberedValue2;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(rememberUpdatedState);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: to4.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit f;
                            f = d.a.f(rememberUpdatedState, ((Boolean) obj2).booleanValue());
                            return f;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                h.d(d, function1, (Function1) rememberedValue3, composer, gk4.o.b, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public final void b(List<String> titles) {
        List reversed;
        boolean z;
        Intrinsics.checkNotNullParameter(titles, "titles");
        g1 g1Var = new g1(false, false, null, false, 15, null);
        g1Var.e = true;
        reversed = CollectionsKt___CollectionsKt.reversed(titles);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(reversed, 10));
        int i = 0;
        for (Object obj : reversed) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new gk4.n(str, str, z));
            i = i2;
        }
        a(g1Var, arrayList);
    }

    public final void a(g1 g1Var, List<gk4.n> channels) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        KmpDialogServiceKt.l(g1Var, t.c(1207345814, true, new a(channels)));
    }
}
