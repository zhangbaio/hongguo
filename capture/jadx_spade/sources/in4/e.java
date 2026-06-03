package in4;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.m;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.d0;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.i;
import androidx.compose.runtime.t2;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.AbsFragment;
import com.dragon.read.component.biz.impl.ui.searchpage.fragment.AbsSearchResultFragment;
import com.dragon.read.compose.NovelComposeHolderView;
import com.dragon.read.kmp.basenovel.ui.widget.staggered.RecyclerHolder;
import com.dragon.read.kmp.common_feed.staggeredfeed.q;
import com.dragon.read.kmp.search.model.AbsSearchStaggeredFeedCrossModel;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import com.dragon.read.rpc.model.SearchTabType;
import com.dragon.read.util.DebugManager;
import gn4.c;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pg4.p;
import pg4.t;
import q64.r;
import w0.h;
import yh4.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e<KM extends gn4.c, NM extends AbsSearchStaggeredFeedCrossModel<KM>> extends AbsRecyclerViewHolder<NM> {
    public static final int m;
    public final r d;
    public final AbsFragment e;
    private final NovelComposeHolderView<f<KM>> f;
    private g<KM> g;
    private final me4.f h;
    private final Rect i;
    private final int[] j;
    private ViewTreeObserver.OnDrawListener k;
    private View.OnAttachStateChangeListener l;

    static {
        Covode.recordClassIndex(608772);
        m = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F2(e eVar, f fVar, int i, Composer composer, int i2) {
        eVar.E2(fVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G2(e eVar, f fVar, int i, Composer composer, int i2) {
        eVar.E2(fVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public xh4.a L2() {
        return null;
    }

    public uh4.a M2() {
        return null;
    }

    private final void V2() {
        g<KM> gVar = this.g;
        if (gVar != null) {
            gVar.B();
        }
    }

    protected final View O2() {
        View itemView = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return itemView;
    }

    protected final boolean W2() {
        return ((RecyclerView.ViewHolder) this).itemView.getGlobalVisibleRect(this.i);
    }

    public static final class c implements View.OnAttachStateChangeListener {
        final /* synthetic */ e<KM, NM> a;

        c(e<KM, NM> eVar) {
            this.a = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a.O2().getViewTreeObserver().addOnPreDrawListener(((AbsRecyclerViewHolder) this.a).onPreDrawListener);
            this.a.O2().getViewTreeObserver().addOnDrawListener(((e) this.a).k);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a.O2().getViewTreeObserver().removeOnPreDrawListener(((AbsRecyclerViewHolder) this.a).onPreDrawListener);
            this.a.O2().getViewTreeObserver().removeOnDrawListener(((e) this.a).k);
        }
    }

    private final void P2(final KM km) {
        if (!km.c()) {
            ((AbsRecyclerViewHolder) this).onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: in4.a
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    boolean S2;
                    S2 = e.S2(gn4.c.this, this);
                    return S2;
                }
            };
            this.k = new ViewTreeObserver.OnDrawListener() { // from class: in4.b
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public final void onDraw() {
                    e.T2(gn4.c.this, this);
                }
            };
            this.l = new c(this);
            O2().addOnAttachStateChangeListener(this.l);
        }
    }

    static final class a implements Function3<MutableState<f<KM>>, Composer, Integer, Unit> {
        final /* synthetic */ e<KM, NM> a;

        a(e<KM, NM> eVar) {
            this.a = eVar;
        }

        /* renamed from: in4.e$a$a, reason: collision with other inner class name */
        static final class C0173a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ e<KM, NM> a;
            final /* synthetic */ MutableState<f<KM>> b;

            C0173a(e<KM, NM> eVar, MutableState<f<KM>> mutableState) {
                this.a = eVar;
                this.b = mutableState;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(Composer composer, int i) {
                boolean z;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2086760070, i, -1, "com.dragon.read.kmp.search.holder.BaseSearchStaggeredFeedCrossHolder.<anonymous>.<anonymous> (BaseSearchStaggeredFeedCrossHolder.kt:63)");
                    }
                    e<KM, NM> eVar = this.a;
                    MutableState<f<KM>> mutableState = this.b;
                    Modifier.a aVar = Modifier.Companion;
                    e.a aVar2 = androidx.compose.ui.e.a;
                    p0 i2 = m.i(aVar2.o(), false);
                    int a = j.a(i.b(composer, 0));
                    e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, aVar);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
                    Function0 a2 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a2);
                    } else {
                        composer.useNode();
                    }
                    Composer b = g5.b(composer);
                    g5.e(b, i2, companion.c());
                    g5.e(b, currentCompositionLocalMap, companion.e());
                    Function2 b2 = companion.b();
                    if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                        b.updateRememberedValue(Integer.valueOf(a));
                        b.apply(Integer.valueOf(a), b2);
                    }
                    g5.e(b, e, companion.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    eVar.E2((f) mutableState.getValue(), composer, 0);
                    composer.startReplaceGroup(1282792030);
                    if (DebugManager.isDebugBuild()) {
                        a6.j("kmp", boxScopeInstance.b(aVar, aVar2.c()), l0.b.f(), 0L, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 390, 0, 131064);
                    }
                    composer.endReplaceGroup();
                    composer.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Composer composer, Integer num) {
            a((MutableState) obj, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(MutableState<f<KM>> item, Composer composer, int i) {
            boolean z;
            int i2;
            Intrinsics.checkNotNullParameter(item, "item");
            if ((i & 6) == 0) {
                if (composer.changed(item)) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1317442997, i, -1, "com.dragon.read.kmp.search.holder.BaseSearchStaggeredFeedCrossHolder.<anonymous> (BaseSearchStaggeredFeedCrossHolder.kt:62)");
                }
                p.e(new pg4.h((t) null, (t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-2086760070, true, new C0173a(this.a, item), composer, 54), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ f<KM> a;
        final /* synthetic */ e<KM, NM> b;

        b(f<KM> fVar, e<KM, NM> eVar) {
            this.a = fVar;
            this.b = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620184646, i, -1, "com.dragon.read.kmp.search.holder.BaseSearchStaggeredFeedCrossHolder.Content.<anonymous> (BaseSearchStaggeredFeedCrossHolder.kt:152)");
                }
                KM km = this.a.a;
                g gVar = ((e) this.b).g;
                if (gVar != null) {
                    gVar.I(km, this.a.b, composer, g.l << 6);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S2(gn4.c cVar, e eVar) {
        if (!cVar.c()) {
            eVar.O2().getLocationOnScreen(eVar.j);
            return true;
        }
        return true;
    }

    public g<KM> N2(KM kmpModel, wh4.i depend) {
        Intrinsics.checkNotNullParameter(kmpModel, "kmpModel");
        Intrinsics.checkNotNullParameter(depend, "depend");
        return (g) ue4.b.a.c(Reflection.getOrCreateKotlinClass(kmpModel.getClass())).invoke(depend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T2(gn4.c cVar, e eVar) {
        if (!cVar.c()) {
            eVar.O2().getLocationOnScreen(eVar.j);
            if (eVar.W2()) {
                int[] iArr = eVar.j;
                if (iArr[0] != 0 || iArr[1] != 0) {
                    eVar.V2();
                    cVar.d(true);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: U2, reason: merged with bridge method [inline-methods] */
    public void onBind(NM nm, int i) {
        gn4.c kmpModel;
        String str;
        String str2;
        String str3;
        super.onBind(nm, i);
        if (nm == null || (kmpModel = nm.getKmpModel()) == null) {
            return;
        }
        this.g = N2(kmpModel, this.h);
        AbsSearchResultFragment absSearchResultFragment = this.e;
        if (absSearchResultFragment instanceof AbsSearchResultFragment) {
            SearchTabType searchTabType = absSearchResultFragment.c;
            if (searchTabType == null) {
                searchTabType = SearchTabType.ShortPlay;
            }
            int value = searchTabType.getValue();
            AbsSearchResultFragment absSearchResultFragment2 = this.e;
            String str4 = absSearchResultFragment2.i;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            String str5 = absSearchResultFragment2.d;
            if (str5 == null) {
                str2 = "";
            } else {
                str2 = str5;
            }
            String str6 = absSearchResultFragment2.g;
            if (str6 == null) {
                str3 = "";
            } else {
                str3 = str6;
            }
            String str7 = absSearchResultFragment2.f;
            if (str7 == null) {
                str7 = "";
            }
            hn4.d dVar = new hn4.d(value, str, str2, str7, str3, null, null);
            dVar.f = this.e.v.getValue();
            kmpModel.g = dVar;
        }
        g<KM> gVar = this.g;
        if (gVar != null) {
            ((RecyclerHolder) gVar).d = kmpModel;
        }
        if (gVar != null) {
            ((RecyclerHolder) gVar).b = i;
        }
        this.f.b(new f(kmpModel, i));
        P2(kmpModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(r staggeredFeedDepend, ViewGroup parent, AbsFragment attachFragment) {
        super(LayoutInflater.from(parent.getContext()).inflate(2131036923, parent, false));
        Intrinsics.checkNotNullParameter(staggeredFeedDepend, "staggeredFeedDepend");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(attachFragment, "attachFragment");
        this.d = staggeredFeedDepend;
        this.e = attachFragment;
        NovelComposeHolderView<f<KM>> findViewById = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131825001);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        NovelComposeHolderView<f<KM>> novelComposeHolderView = findViewById;
        this.f = novelComposeHolderView;
        this.h = new me4.f(staggeredFeedDepend);
        this.i = new Rect();
        this.j = new int[2];
        novelComposeHolderView.setContent(androidx.compose.runtime.internal.t.c(-1317442997, true, new a(this)));
    }

    protected final void E2(final f<KM> fVar, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        boolean changedInstance;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(970624250);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(fVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(fVar);
            }
            if (changedInstance) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(this)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(970624250, i2, -1, "com.dragon.read.kmp.search.holder.BaseSearchStaggeredFeedCrossHolder.Content (BaseSearchStaggeredFeedCrossHolder.kt:141)");
            }
            if (fVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: in4.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit F2;
                            F2 = e.F2(e.this, fVar, i, (Composer) obj, ((Integer) obj2).intValue());
                            return F2;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = M2();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            uh4.a aVar = (uh4.a) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = L2();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            d0.d(new t2[]{ve4.b.c().provides(aVar), q.c().provides((xh4.a) rememberedValue2)}, androidx.compose.runtime.internal.t.e(-1620184646, true, new b(fVar, this), startRestartGroup, 54), startRestartGroup, t2.i | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: in4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit G2;
                    G2 = e.G2(e.this, fVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return G2;
                }
            });
        }
    }
}
