package com.dragon.read.kmp.profile.guestprofile.view;

import android.content.Context;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.snapshots.l;
import androidx.compose.runtime.t3;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.unit.LayoutDirection;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.ej;
import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.tl0;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListLayoutKt;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.profile.component.SeriesProfileHeaderTagKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.rpc.kmp.community.model.TextExtType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsKt;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileUserHeaderKt {
    static {
        Covode.recordClassIndex(608172);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(GuestProfileViewModel guestProfileViewModel, String str, String str2, boolean z, float f2, boolean z2, int i2, Composer composer, int i3) {
        x(guestProfileViewModel, str, str2, z, f2, z2, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, ok0 ok0Var, int i2, Composer composer, int i3) {
        B(guestProfileViewModel, f0Var, ok0Var, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(ej ejVar, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        F(ejVar, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(ej ejVar, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        F(ejVar, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ej ejVar, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        F(ejVar, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(List list, float f2, Function1 function1, long j, int i2, Composer composer, int i3) {
        K(list, f2, function1, j, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(List list, float f2, Function1 function1, long j, int i2, Composer composer, int i3) {
        K(list, f2, function1, j, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(List list, float f2, Function1 function1, long j, int i2, Composer composer, int i3) {
        K(list, f2, function1, j, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Modifier modifier, GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        Q(modifier, guestProfileViewModel, f0Var, collapsibleListState, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(ok0 ok0Var, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        a0(ok0Var, f0Var, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(List list, int i2, Composer composer, int i3) {
        c0(list, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, ok0 ok0Var, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        e0(f0Var, ok0Var, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(GuestProfileViewModel guestProfileViewModel, String str, String str2, boolean z, float f2, boolean z2, int i2, Composer composer, int i3) {
        x(guestProfileViewModel, str, str2, z, f2, z2, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final class a implements Function0<Boolean> {
        final /* synthetic */ Transition a;

        public a(Transition transition) {
            this.a = transition;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return this.a.u();
        }
    }

    public static final class b implements Function0<Transition.b<Boolean>> {
        final /* synthetic */ Transition a;

        public b(Transition transition) {
            this.a = transition;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Transition.b<Boolean> invoke() {
            return this.a.s();
        }
    }

    public static final class c implements Function0<Boolean> {
        final /* synthetic */ Transition a;

        public c(Transition transition) {
            this.a = transition;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return this.a.u();
        }
    }

    public static final class d implements Function0<Transition.b<Boolean>> {
        final /* synthetic */ Transition a;

        public d(Transition transition) {
            this.a = transition;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Transition.b<Boolean> invoke() {
            return this.a.s();
        }
    }

    private static final androidx.compose.ui.text.g3 l0() {
        return new androidx.compose.ui.text.g3(0L, x0.x.h(12), androidx.compose.ui.text.font.c0.b.e(), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (androidx.compose.ui.graphics.e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777209, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence N(com.dragon.read.kmp.profile.guestprofile.view.e it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence O(com.dragon.read.kmp.profile.guestprofile.view.e it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.a;
    }

    private static final boolean S(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final float Y(State<x0.i> state) {
        return ((x0.i) state.getValue()).m();
    }

    private static final float Z(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f0(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    static final class i implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ Ref$ObjectRef<MutableState<Float>> e;
        final /* synthetic */ tl0 f;
        final /* synthetic */ GuestProfileViewModel g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;
        final /* synthetic */ MutableState<Float> j;

        i(com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, boolean z, boolean z2, String str, Ref$ObjectRef<MutableState<Float>> ref$ObjectRef, tl0 tl0Var, GuestProfileViewModel guestProfileViewModel, String str2, String str3, MutableState<Float> mutableState) {
            this.a = f0Var;
            this.b = z;
            this.c = z2;
            this.d = str;
            this.e = ref$ObjectRef;
            this.f = tl0Var;
            this.g = guestProfileViewModel;
            this.h = str2;
            this.i = str3;
            this.j = mutableState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(String schema) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            zm4.d.d(zm4.d.a, schema, null, null, 6, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(Ref$ObjectRef ref$ObjectRef, float f) {
            ((MutableState) ref$ObjectRef.element).setValue(Float.valueOf(f));
            return Unit.INSTANCE;
        }

        static final class a implements Function3<androidx.compose.foundation.layout.d1, Composer, Integer, Unit> {
            final /* synthetic */ boolean a;
            final /* synthetic */ String b;
            final /* synthetic */ tl0 c;
            final /* synthetic */ Function1<String, Unit> d;
            final /* synthetic */ GuestProfileViewModel e;

            /* JADX WARN: Multi-variable type inference failed */
            a(boolean z, String str, tl0 tl0Var, Function1<? super String, Unit> function1, GuestProfileViewModel guestProfileViewModel) {
                this.a = z;
                this.b = str;
                this.c = tl0Var;
                this.d = function1;
                this.e = guestProfileViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.d1 d1Var, Composer composer, Integer num) {
                a(d1Var, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void a(androidx.compose.foundation.layout.d1 FlowRow, Composer composer, int i) {
                int i2;
                boolean z;
                long k;
                List list;
                boolean z2;
                int i3;
                Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                if ((i & 6) == 0) {
                    if (composer.changed(FlowRow)) {
                        i3 = 4;
                    } else {
                        i3 = 2;
                    }
                    i2 = i | i3;
                } else {
                    i2 = i;
                }
                if ((i2 & 19) != 18) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i2 & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2029631059, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.UserNameLayout.<anonymous>.<anonymous>.<anonymous> (ProfileUserHeader.kt:375)");
                    }
                    long h = x0.x.h(20);
                    androidx.compose.ui.text.font.c0 a = androidx.compose.ui.text.font.c0.b.a();
                    int b = w0.s.b.b();
                    if (this.a) {
                        composer.startReplaceGroup(-560284133);
                        k = og4.a.a.h(composer, og4.a.b).R();
                    } else {
                        composer.startReplaceGroup(-560282830);
                        k = og4.a.a.h(composer, og4.a.b).k();
                    }
                    composer.endReplaceGroup();
                    Modifier.a aVar = Modifier.Companion;
                    e.a aVar2 = androidx.compose.ui.e.a;
                    a6.j(this.b, FlowRow.b(aVar, aVar2.i()), k, h, (androidx.compose.ui.text.font.y) null, a, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b, false, 1, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199680, 3120, 120784);
                    e.c i4 = aVar2.i();
                    Modifier b2 = FlowRow.b(aVar, aVar2.i());
                    tl0 tl0Var = this.c;
                    Function1<String, Unit> function1 = this.d;
                    GuestProfileViewModel guestProfileViewModel = this.e;
                    androidx.compose.ui.layout.p0 b3 = androidx.compose.foundation.layout.r2.b(androidx.compose.foundation.layout.e.a.h(), i4, composer, 48);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, b2);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
                    Function0 a3 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a3);
                    } else {
                        composer.useNode();
                    }
                    Composer b4 = g5.b(composer);
                    g5.e(b4, b3, companion.c());
                    g5.e(b4, currentCompositionLocalMap, companion.e());
                    Function2 b5 = companion.b();
                    if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a2))) {
                        b4.updateRememberedValue(Integer.valueOf(a2));
                        b4.apply(Integer.valueOf(a2), b5);
                    }
                    g5.e(b4, e, companion.d());
                    androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
                    SeriesProfileHeaderTagKt.m(tl0Var, function1, "profile_page", guestProfileViewModel, composer, 432, 0);
                    ej ejVar = null;
                    if (tl0Var != null && (list = tl0Var.k) != null) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            Integer num = ((ej) next).a;
                            int value = TextExtType.RankListTag.getValue();
                            if (num != null && num.intValue() == value) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                ejVar = next;
                                break;
                            }
                        }
                        ejVar = ejVar;
                    }
                    ProfileUserHeaderKt.F(ejVar, guestProfileViewModel, composer, 0);
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
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            c(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:140:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:146:0x00b3 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:150:0x007c A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r2v74 */
        /* JADX WARN: Type inference failed for: r2v75 */
        /* JADX WARN: Type inference failed for: r2v76, types: [java.lang.Object] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(androidx.compose.foundation.layout.v r46, androidx.compose.runtime.Composer r47, int r48) {
            /*
                Method dump skipped, instructions count: 1439
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileUserHeaderKt.i.c(androidx.compose.foundation.layout.v, androidx.compose.runtime.Composer, int):void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<com.dragon.read.kmp.profile.guestprofile.view.e> m0(java.util.List<com.bytedance.kmp.reading.model.ej> r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L7:
            int r3 = r10.size()
            if (r2 >= r3) goto Lab
            java.lang.Object r3 = r10.get(r2)
            com.bytedance.kmp.reading.model.ej r3 = (com.bytedance.kmp.reading.model.ej) r3
            java.lang.String r4 = r3.b
            java.lang.String r5 = ""
            if (r4 != 0) goto L1a
            r4 = r5
        L1a:
            java.lang.Integer r6 = r3.a
            com.dragon.read.rpc.kmp.community.model.TextExtType r7 = com.dragon.read.rpc.kmp.community.model.TextExtType.Workplace
            int r7 = r7.getValue()
            r8 = 1
            if (r6 != 0) goto L26
            goto L83
        L26:
            int r6 = r6.intValue()
            if (r6 != r7) goto L83
            int r3 = r2 + 1
            java.lang.Object r6 = kotlin.collections.CollectionsKt.getOrNull(r10, r3)
            com.bytedance.kmp.reading.model.ej r6 = (com.bytedance.kmp.reading.model.ej) r6
            if (r6 == 0) goto L49
            java.lang.Integer r7 = r6.a
            com.dragon.read.rpc.kmp.community.model.TextExtType r9 = com.dragon.read.rpc.kmp.community.model.TextExtType.ProfessionalTitle
            int r9 = r9.getValue()
            if (r7 != 0) goto L41
            goto L49
        L41:
            int r7 = r7.intValue()
            if (r7 != r9) goto L49
            r7 = 1
            goto L4a
        L49:
            r7 = 0
        L4a:
            if (r7 == 0) goto L81
            java.lang.String r7 = r6.b
            if (r7 == 0) goto L59
            int r7 = r7.length()
            if (r7 != 0) goto L57
            goto L59
        L57:
            r7 = 0
            goto L5a
        L59:
            r7 = 1
        L5a:
            if (r7 != 0) goto L81
            java.lang.String r3 = r6.b
            if (r3 != 0) goto L61
            goto L62
        L61:
            r5 = r3
        L62:
            com.dragon.read.kmp.profile.guestprofile.view.e r3 = new com.dragon.read.kmp.profile.guestprofile.view.e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r7 = 32
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r3.<init>(r6, r4, r5, r8)
            r0.add(r3)
            int r2 = r2 + 2
            goto L7
        L81:
            r2 = r3
            goto L7
        L83:
            java.lang.Integer r3 = r3.a
            com.dragon.read.rpc.kmp.community.model.TextExtType r6 = com.dragon.read.rpc.kmp.community.model.TextExtType.ProfessionalTitle
            int r6 = r6.getValue()
            if (r3 != 0) goto L8e
            goto L98
        L8e:
            int r3 = r3.intValue()
            if (r3 != r6) goto L98
        L94:
            int r2 = r2 + 1
            goto L7
        L98:
            int r3 = r4.length()
            if (r3 <= 0) goto L9f
            goto La0
        L9f:
            r8 = 0
        La0:
            if (r8 == 0) goto L94
            com.dragon.read.kmp.profile.guestprofile.view.e r3 = new com.dragon.read.kmp.profile.guestprofile.view.e
            r3.<init>(r4, r4, r5, r1)
            r0.add(r3)
            goto L94
        Lab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileUserHeaderKt.m0(java.util.List):java.util.List");
    }

    static final class e implements PointerInputEventHandler {
        public static final e a = new e();

        e() {
        }

        public final Object invoke(androidx.compose.ui.input.pointer.e0 e0Var, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }
    }

    private static final void W(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(GuestProfileViewModel guestProfileViewModel, androidx.compose.ui.layout.w layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        guestProfileViewModel.p = layoutCoordinates;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(State state, androidx.compose.ui.graphics.c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.c(Z(state));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(MutableState mutableState, float f2) {
        boolean z;
        if (f2 <= 0.6f) {
            z = true;
        } else {
            z = false;
        }
        W(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(GuestProfileViewModel guestProfileViewModel, String str) {
        com.dragon.read.kmp.profile.params.a aVar = guestProfileViewModel.f;
        if (aVar != null) {
            aVar.y(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(GuestProfileViewModel guestProfileViewModel, State state) {
        Integer num;
        if (Z(state) > 0.0f) {
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 g0Var = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) guestProfileViewModel.j.getValue();
            if (g0Var != null) {
                num = g0Var.d;
            } else {
                num = null;
            }
            GuestProfileViewModel.O0(guestProfileViewModel, num, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(GuestProfileViewModel guestProfileViewModel, State state) {
        Integer num;
        if (Z(state) > 0.0f) {
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 g0Var = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) guestProfileViewModel.j.getValue();
            if (g0Var != null) {
                num = g0Var.d;
            } else {
                num = null;
            }
            GuestProfileViewModel.O0(guestProfileViewModel, num, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    static final class f implements Function3<Transition.b<Boolean>, Composer, Integer, androidx.compose.animation.core.n0<Float>> {
        public static final f a = new f();

        f() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ androidx.compose.animation.core.n0<Float> invoke(Transition.b<Boolean> bVar, Composer composer, Integer num) {
            return a(bVar, composer, num.intValue());
        }

        public final androidx.compose.animation.core.n0<Float> a(Transition.b<Boolean> animateFloat, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
            composer.startReplaceGroup(1802045700);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1802045700, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.TitleBarProfileAnimated.<anonymous> (ProfileUserHeader.kt:124)");
            }
            androidx.compose.animation.core.s2 n = androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return n;
        }
    }

    static final class g implements Function3<Transition.b<Boolean>, Composer, Integer, androidx.compose.animation.core.n0<x0.i>> {
        public static final g a = new g();

        g() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ androidx.compose.animation.core.n0<x0.i> invoke(Transition.b<Boolean> bVar, Composer composer, Integer num) {
            return a(bVar, composer, num.intValue());
        }

        public final androidx.compose.animation.core.n0<x0.i> a(Transition.b<Boolean> animateDp, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(animateDp, "$this$animateDp");
            composer.startReplaceGroup(-1118927144);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1118927144, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.TitleBarProfileAnimated.<anonymous> (ProfileUserHeader.kt:119)");
            }
            androidx.compose.animation.core.s2 n = androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return n;
        }
    }

    static final class h implements Function3<androidx.compose.foundation.layout.d1, Composer, Integer, Unit> {
        final /* synthetic */ List<ej> a;

        h(List<ej> list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.d1 d1Var, Composer composer, Integer num) {
            a(d1Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r12v2 */
        public final void a(androidx.compose.foundation.layout.d1 FlowRow, Composer composer, int i) {
            boolean z;
            int i2;
            float f;
            og4.a aVar;
            androidx.compose.foundation.layout.v2 v2Var;
            Composer composer2 = composer;
            Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
            ?? r12 = 0;
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer2.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-233261332, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.UserLabelLayout.<anonymous> (ProfileUserHeader.kt:691)");
                }
                for (ej ejVar : this.a) {
                    Modifier.a aVar2 = Modifier.Companion;
                    Modifier a = androidx.compose.ui.draw.e.a(SizeKt.D(aVar2, (androidx.compose.ui.e) null, (boolean) r12, 3, (Object) null), k.g.c(x0.i.g(4)));
                    og4.a aVar3 = og4.a.a;
                    int i3 = og4.a.b;
                    float f2 = 2;
                    Modifier s = androidx.compose.foundation.layout.f2.s(BackgroundKt.d(a, aVar3.h(composer2, i3).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(6), x0.i.g(f2));
                    e.e h = androidx.compose.foundation.layout.e.a.h();
                    e.a aVar4 = androidx.compose.ui.e.a;
                    androidx.compose.ui.layout.p0 b = androidx.compose.foundation.layout.r2.b(h, aVar4.l(), composer2, (int) r12);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer2, (int) r12));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer2, s);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
                    Function0 a3 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer2.createNode(a3);
                    } else {
                        composer.useNode();
                    }
                    Composer b2 = g5.b(composer);
                    g5.e(b2, b, companion.c());
                    g5.e(b2, currentCompositionLocalMap, companion.e());
                    Function2 b3 = companion.b();
                    if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                        b2.updateRememberedValue(Integer.valueOf(a2));
                        b2.apply(Integer.valueOf(a2), b3);
                    }
                    g5.e(b2, e, companion.d());
                    androidx.compose.foundation.layout.v2 v2Var2 = androidx.compose.foundation.layout.w2.b;
                    composer2.startReplaceGroup(-1839614958);
                    if (com.dragon.read.kmp.util.kotlin.f.a(ejVar.i)) {
                        String str = ejVar.i;
                        Modifier b4 = v2Var2.b(SizeKt.s(aVar2, x0.i.g(12)), aVar4.i());
                        com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                        nVar.a(com.bytedance.kmp.image.options.l.b.f());
                        i2 = i3;
                        f = f2;
                        aVar = aVar3;
                        v2Var = v2Var2;
                        LoadImageKt.g(str, (String) null, nVar, b4, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer, 0, 114);
                    } else {
                        i2 = i3;
                        f = f2;
                        aVar = aVar3;
                        v2Var = v2Var2;
                    }
                    composer.endReplaceGroup();
                    composer2.startReplaceGroup(-1839601047);
                    if (com.dragon.read.kmp.util.kotlin.f.a(ejVar.b)) {
                        float g = x0.i.g(f);
                        composer2.startReplaceGroup(-344996060);
                        androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar2, g), composer2, (int) r12);
                        composer.endReplaceGroup();
                        String str2 = ejVar.b;
                        if (str2 == null) {
                            str2 = "";
                        }
                        long h2 = x0.x.h(10);
                        a6.j(str2, v2Var.b(SizeKt.D(aVar2, (androidx.compose.ui.e) null, (boolean) r12, 3, (Object) null), aVar4.i()), aVar.h(composer2, i2).F(), h2, (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(14), 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199680, 6, 130000);
                    }
                    composer.endReplaceGroup();
                    composer.endNode();
                    composer2 = composer;
                    r12 = 0;
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
    public static final Unit I(GuestProfileViewModel guestProfileViewModel, String str, ej ejVar) {
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        rVar.u(guestProfileViewModel.r0(), str, "profile_page", rVar.e(), rVar.d(), "to_actor_list_rank");
        com.dragon.read.kmp.profile.params.a aVar = guestProfileViewModel.f;
        if (aVar != null) {
            aVar.s(ejVar.h, guestProfileViewModel.a.f);
        }
        return Unit.INSTANCE;
    }

    public static final void c0(final List<ej> labelList, Composer composer, final int i2) {
        int i3;
        boolean z;
        int i4;
        Intrinsics.checkNotNullParameter(labelList, "labelList");
        Composer startRestartGroup = composer.startRestartGroup(1097850631);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(labelList)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1097850631, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.UserLabelLayout (ProfileUserHeader.kt:685)");
            }
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.B(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            float f2 = 4;
            androidx.compose.foundation.layout.r0.g(t, eVar.p(x0.i.g(f2)), eVar.p(x0.i.g(f2)), (e.c) null, 0, 0, androidx.compose.runtime.internal.t.e(-233261332, true, new h(labelList), startRestartGroup, 54), startRestartGroup, 1573302, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.h1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit d0;
                    d0 = ProfileUserHeaderKt.d0(labelList, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return d0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(boolean z, String str, GuestProfileViewModel guestProfileViewModel, ok0 ok0Var) {
        String str2;
        String str3;
        String str4;
        boolean z2;
        Context b2 = ig4.f.b();
        if (z && str != null && b2 != null) {
            com.dragon.read.kmp.profile.params.a aVar = guestProfileViewModel.f;
            if (aVar != null) {
                aVar.z(str, b2);
            }
            return Unit.INSTANCE;
        }
        androidx.compose.ui.layout.w wVar = guestProfileViewModel.p;
        if (wVar == null) {
            return Unit.INSTANCE;
        }
        if (!wVar.U()) {
            return Unit.INSTANCE;
        }
        long g2 = androidx.compose.ui.layout.x.g(wVar);
        long a2 = wVar.a();
        float intBitsToFloat = Float.intBitsToFloat((int) (g2 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (g2 & 4294967295L));
        float f2 = (int) (a2 >> 32);
        float f3 = (int) (a2 & 4294967295L);
        boolean z3 = false;
        if (ok0Var != null && (str4 = ok0Var.m) != null) {
            if (str4.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                z3 = true;
            }
        }
        if (z3) {
            str2 = ok0Var.m;
            if (str2 == null) {
                str2 = "";
            }
        } else if (ok0Var != null) {
            str2 = ok0Var.c;
        } else {
            str2 = null;
        }
        com.dragon.read.kmp.profile.params.a aVar2 = guestProfileViewModel.f;
        if (aVar2 != null) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
            }
            aVar2.d(str3, intBitsToFloat, intBitsToFloat2, f2, f3);
        }
        return Unit.INSTANCE;
    }

    private static final String n0(String str, int i2, androidx.compose.ui.text.a3 a3Var, androidx.compose.ui.text.g3 g3Var) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        String str2 = "";
        if (!z && i2 > 0) {
            int length = str.length();
            int i3 = 0;
            while (i3 <= length) {
                int i4 = (i3 + length) / 2;
                String substring = str.substring(0, i4);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                if (((int) (androidx.compose.ui.text.a3.b(a3Var, substring, g3Var, 0, false, 0, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1020, (Object) null).c >> 32)) <= i2) {
                    i3 = i4 + 1;
                    str2 = substring;
                } else {
                    length = i4 - 1;
                }
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final ej ejVar, final GuestProfileViewModel guestProfileViewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        String str;
        List list;
        ArrayList arrayList;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-2120372900);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(ejVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2120372900, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.BuildExpandTextTag (ProfileUserHeader.kt:725)");
            }
            if (ejVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.p0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit G;
                            G = ProfileUserHeaderKt.G(ejVar, guestProfileViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return G;
                        }
                    });
                    return;
                }
                return;
            }
            final String str2 = ejVar.b;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.q0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit H;
                            H = ProfileUserHeaderKt.H(ejVar, guestProfileViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return H;
                        }
                    });
                    return;
                }
                return;
            }
            og4.a aVar = og4.a.a;
            boolean d2 = com.dragon.read.kmp.service.d1.d(aVar.e(startRestartGroup, og4.a.b));
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(ejVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                if (d2) {
                    str = ejVar.f;
                } else {
                    str = ejVar.e;
                }
                rememberedValue = androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.j.b(str, aVar.d().f()));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            long x = ((androidx.compose.ui.graphics.l0) rememberedValue).x();
            startRestartGroup.endReplaceGroup();
            if (d2) {
                list = ejVar.d;
            } else {
                list = ejVar.c;
            }
            startRestartGroup.startReplaceGroup(-1863842366);
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.j.b((String) it2.next(), og4.a.a.h(startRestartGroup, og4.a.b).x())));
                    x = x;
                }
            }
            long j = x;
            startRestartGroup.endReplaceGroup();
            float g2 = x0.i.g(2);
            startRestartGroup.startReplaceGroup(-344996060);
            boolean z3 = false;
            androidx.compose.foundation.layout.a3.a(SizeKt.x(Modifier.Companion, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            androidx.compose.ui.graphics.l0 j2 = androidx.compose.ui.graphics.l0.j(j);
            org.jetbrains.compose.resources.b D = yo2.d2.D(f2.a.a);
            startRestartGroup.startReplaceGroup(-1746271574);
            if ((i3 & 112) == 32) {
                z3 = true;
            }
            boolean changed2 = startRestartGroup.changed(str2) | z3 | startRestartGroup.changedInstance(ejVar);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.r0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit I;
                        I = ProfileUserHeaderKt.I(GuestProfileViewModel.this, str2, ejVar);
                        return I;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            com.dragon.read.kmp.profile.component.d.c(str2, null, j2, null, arrayList, true, D, (Function0) rememberedValue2, startRestartGroup, 196608, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit J;
                    J = ProfileUserHeaderKt.J(ejVar, guestProfileViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return J;
                }
            });
        }
    }

    public static final void a0(final ok0 ok0Var, final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 profileState, final GuestProfileViewModel viewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        boolean z2;
        long j;
        String str;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(profileState, "profileState");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(1726708394);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(ok0Var)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(profileState)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        boolean z3 = false;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1726708394, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.UserDesc (ProfileUserHeader.kt:669)");
            }
            if (ok0Var != null && (str = ok0Var.f) != null && !StringsKt__StringsKt.isBlank(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && !profileState.d) {
                String str2 = ok0Var.f;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                long h2 = x0.x.h(12);
                startRestartGroup.startReplaceGroup(1509400851);
                eo eoVar = profileState.a;
                if (eoVar != null && com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.e(eoVar)) {
                    z3 = true;
                }
                og4.a aVar = og4.a.a;
                if (z3) {
                    j = aVar.d().F();
                } else {
                    j = aVar.h(startRestartGroup, og4.a.b).j();
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                a6.j(str3, androidx.compose.foundation.layout.f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), SeriesGuestProfilePageKt.j1(), 0.0f, SeriesGuestProfilePageKt.j1(), 0.0f, 10, (Object) null), j, h2, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(19), 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer2, 3120, 6, 130032);
            } else {
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit b0;
                    b0 = ProfileUserHeaderKt.b0(ok0Var, profileState, viewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return b0;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x014f, code lost:
    
        if (r4 != null) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void B(final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r33, final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r34, final com.bytedance.kmp.reading.model.ok0 r35, androidx.compose.runtime.Composer r36, final int r37) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileUserHeaderKt.B(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0, com.bytedance.kmp.reading.model.ok0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ed A[Catch: Exception -> 0x01fa, TryCatch #1 {Exception -> 0x01fa, blocks: (B:117:0x0146, B:119:0x014a, B:120:0x0153, B:122:0x0159, B:124:0x0164, B:126:0x016a, B:131:0x01d5, B:133:0x01d9, B:138:0x01ed, B:146:0x01a1, B:148:0x01a7, B:149:0x01ce, B:155:0x0197, B:159:0x01f5, B:145:0x017a), top: B:116:0x0146, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02f5  */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, androidx.compose.runtime.MutableState] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e0(final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r31, final com.bytedance.kmp.reading.model.ok0 r32, final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r33, androidx.compose.runtime.Composer r34, final int r35) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileUserHeaderKt.e0(com.dragon.read.kmp.profile.guestprofile.viewmodel.f0, com.bytedance.kmp.reading.model.ok0, com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01d9, code lost:
    
        if (r12 == r32.getEmpty()) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void K(final java.util.List<com.bytedance.kmp.reading.model.ej> r58, final float r59, final kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r60, final long r61, androidx.compose.runtime.Composer r63, final int r64) {
        /*
            Method dump skipped, instructions count: 1174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileUserHeaderKt.K(java.util.List, float, kotlin.jvm.functions.Function1, long, androidx.compose.runtime.Composer, int):void");
    }

    public static final void Q(final Modifier modifier, final GuestProfileViewModel viewModel, final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 profileState, final CollapsibleListState collapsingState, Composer composer, final int i2) {
        int i3;
        boolean z;
        cj0 cj0Var;
        Object p;
        int i4;
        float f2;
        boolean z2;
        float f3;
        boolean z3;
        Transition transition;
        Object p2;
        float f4;
        boolean z4;
        float f5;
        boolean z5;
        boolean z6;
        int i5;
        Modifier modifier2;
        String str;
        String str2;
        int i6;
        boolean z7;
        boolean z8;
        Function1 function1;
        boolean z9;
        Function1 function12;
        boolean changedInstance;
        int i7;
        int i8;
        int i9;
        int i10;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(profileState, "profileState");
        Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
        Composer startRestartGroup = composer.startRestartGroup(2108579439);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i10 = 4;
            } else {
                i10 = 2;
            }
            i3 = i10 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i9 = 32;
            } else {
                i9 = 16;
            }
            i3 |= i9;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(profileState)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i3 |= i8;
        }
        if ((i2 & 3072) == 0) {
            if ((i2 & 4096) == 0) {
                changedInstance = startRestartGroup.changed(collapsingState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsingState);
            }
            if (changedInstance) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        int i11 = i3;
        if ((i11 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2108579439, i11, -1, "com.dragon.read.kmp.profile.guestprofile.view.TitleBarProfileAnimated (ProfileUserHeader.kt:109)");
            }
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(profileState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                eo eoVar = profileState.a;
                if (eoVar != null && (cj0Var = eoVar.a) != null) {
                    rememberedValue = cj0Var.b;
                } else {
                    rememberedValue = null;
                }
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ok0 ok0Var = (ok0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.c1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit X;
                        X = ProfileUserHeaderKt.X(mutableState, ((Float) obj).floatValue());
                        return X;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            CollapsibleListLayoutKt.n(collapsingState, (Function1) rememberedValue3, startRestartGroup, CollapsibleListState.q | 48 | ((i11 >> 9) & 14));
            Transition y = TransitionKt.y(Boolean.valueOf(S(mutableState)), "TitleBarProfileTransition", startRestartGroup, 48, 0);
            g gVar = g.a;
            androidx.compose.animation.core.t2 Q = androidx.compose.animation.core.n3.Q(x0.i.b);
            if (!y.z()) {
                startRestartGroup.startReplaceGroup(1666599280);
                if (!startRestartGroup.changed(y)) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                p = startRestartGroup.rememberedValue();
                if (z9 || p == companion.getEmpty()) {
                    l.a aVar = androidx.compose.runtime.snapshots.l.e;
                    androidx.compose.runtime.snapshots.l d2 = aVar.d();
                    if (d2 != null) {
                        function12 = d2.f();
                    } else {
                        function12 = null;
                    }
                    androidx.compose.runtime.snapshots.l f6 = aVar.f(d2);
                    try {
                        Object p3 = y.p();
                        aVar.m(d2, f6, function12);
                        startRestartGroup.updateRememberedValue(p3);
                        p = p3;
                    } finally {
                    }
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1666853325);
                startRestartGroup.endReplaceGroup();
                p = y.p();
            }
            boolean booleanValue = ((Boolean) p).booleanValue();
            startRestartGroup.startReplaceGroup(-1360445787);
            if (ComposerKt.isTraceInProgress()) {
                i4 = 0;
                ComposerKt.traceEventStart(-1360445787, 0, -1, "com.dragon.read.kmp.profile.guestprofile.view.TitleBarProfileAnimated.<anonymous> (ProfileUserHeader.kt:121)");
            } else {
                i4 = 0;
            }
            if (booleanValue) {
                f2 = i4;
            } else {
                f2 = 10;
            }
            float g2 = x0.i.g(f2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            x0.i d3 = x0.i.d(g2);
            if (!startRestartGroup.changed(y)) {
                z2 = false;
            } else {
                z2 = true;
            }
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.derivedStateOf(new a(y));
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            boolean booleanValue2 = ((Boolean) ((State) rememberedValue4).getValue()).booleanValue();
            startRestartGroup.startReplaceGroup(-1360445787);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1360445787, 0, -1, "com.dragon.read.kmp.profile.guestprofile.view.TitleBarProfileAnimated.<anonymous> (ProfileUserHeader.kt:121)");
            }
            if (booleanValue2) {
                f3 = 0;
            } else {
                f3 = 10;
            }
            float g3 = x0.i.g(f3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            x0.i d4 = x0.i.d(g3);
            if (!startRestartGroup.changed(y)) {
                z3 = false;
            } else {
                z3 = true;
            }
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt.derivedStateOf(new b(y));
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            State t = TransitionKt.t(y, d3, d4, gVar.invoke(((State) rememberedValue5).getValue(), startRestartGroup, 0), Q, "OffsetY", startRestartGroup, 196608);
            f fVar = f.a;
            androidx.compose.animation.core.t2 O = androidx.compose.animation.core.n3.O(FloatCompanionObject.INSTANCE);
            if (!y.z()) {
                startRestartGroup.startReplaceGroup(1666599280);
                transition = y;
                if (!startRestartGroup.changed(transition)) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                p2 = startRestartGroup.rememberedValue();
                if (z8 || p2 == companion.getEmpty()) {
                    l.a aVar2 = androidx.compose.runtime.snapshots.l.e;
                    androidx.compose.runtime.snapshots.l d5 = aVar2.d();
                    if (d5 != null) {
                        function1 = d5.f();
                    } else {
                        function1 = null;
                    }
                    androidx.compose.runtime.snapshots.l f7 = aVar2.f(d5);
                    try {
                        Object p4 = transition.p();
                        aVar2.m(d5, f7, function1);
                        startRestartGroup.updateRememberedValue(p4);
                        p2 = p4;
                    } finally {
                    }
                }
                startRestartGroup.endReplaceGroup();
            } else {
                transition = y;
                startRestartGroup.startReplaceGroup(1666853325);
                startRestartGroup.endReplaceGroup();
                p2 = transition.p();
            }
            boolean booleanValue3 = ((Boolean) p2).booleanValue();
            startRestartGroup.startReplaceGroup(1155184959);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1155184959, 0, -1, "com.dragon.read.kmp.profile.guestprofile.view.TitleBarProfileAnimated.<anonymous> (ProfileUserHeader.kt:126)");
            }
            if (booleanValue3) {
                f4 = 1.0f;
            } else {
                f4 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf = Float.valueOf(f4);
            if (!startRestartGroup.changed(transition)) {
                z4 = false;
            } else {
                z4 = true;
            }
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = SnapshotStateKt.derivedStateOf(new c(transition));
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            boolean booleanValue4 = ((Boolean) ((State) rememberedValue6).getValue()).booleanValue();
            startRestartGroup.startReplaceGroup(1155184959);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1155184959, 0, -1, "com.dragon.read.kmp.profile.guestprofile.view.TitleBarProfileAnimated.<anonymous> (ProfileUserHeader.kt:126)");
            }
            if (booleanValue4) {
                f5 = 1.0f;
            } else {
                f5 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf2 = Float.valueOf(f5);
            if (!startRestartGroup.changed(transition)) {
                z5 = false;
            } else {
                z5 = true;
            }
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt.derivedStateOf(new d(transition));
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final State t2 = TransitionKt.t(transition, valueOf, valueOf2, fVar.invoke(((State) rememberedValue7).getValue(), startRestartGroup, 0), O, "Alpha", startRestartGroup, 196608);
            if (Z(t2) > 0.01f) {
                z6 = true;
            } else {
                z6 = false;
            }
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.f f8 = eVar.f();
            e.a aVar3 = androidx.compose.ui.e.a;
            e.c i12 = aVar3.i();
            Modifier f9 = androidx.compose.foundation.layout.u1.f(SizeKt.d(modifier, 0.0f, 1, (Object) null), 0.0f, Y(t), 1, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed2 = startRestartGroup.changed(t2);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.d1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit R;
                        R = ProfileUserHeaderKt.R(t2, (androidx.compose.ui.graphics.c1) obj);
                        return R;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = androidx.compose.ui.graphics.b1.a(f9, (Function1) rememberedValue8);
            startRestartGroup.startReplaceGroup(-879683729);
            if (!z6) {
                Modifier.a aVar4 = Modifier.Companion;
                Unit unit = Unit.INSTANCE;
                i5 = 1849434622;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == companion.getEmpty()) {
                    rememberedValue9 = e.a;
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                startRestartGroup.endReplaceGroup();
                modifier2 = androidx.compose.ui.input.pointer.m0.c(aVar4, unit, (PointerInputEventHandler) rememberedValue9);
            } else {
                i5 = 1849434622;
                modifier2 = Modifier.Companion;
            }
            startRestartGroup.endReplaceGroup();
            Modifier then = a2.then(modifier2);
            androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(f8, i12, startRestartGroup, 54);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, then);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a4 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a4);
            } else {
                startRestartGroup.useNode();
            }
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion2.c());
            g5.e(b3, currentCompositionLocalMap, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                b3.updateRememberedValue(Integer.valueOf(a3));
                b3.apply(Integer.valueOf(a3), b4);
            }
            g5.e(b3, e2, companion2.d());
            androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
            Modifier.a aVar5 = Modifier.Companion;
            Modifier v = androidx.compose.foundation.layout.f2.v(aVar5, 0.0f, 0.0f, x0.i.g(16), 0.0f, 11, (Object) null);
            androidx.compose.ui.layout.p0 b5 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar3.i(), startRestartGroup, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, v);
            Function0 a6 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a6);
            } else {
                startRestartGroup.useNode();
            }
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, b5, companion2.c());
            g5.e(b6, currentCompositionLocalMap2, companion2.e());
            Function2 b7 = companion2.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a5))) {
                b6.updateRememberedValue(Integer.valueOf(a5));
                b6.apply(Integer.valueOf(a5), b7);
            }
            g5.e(b6, e3, companion2.d());
            startRestartGroup.startReplaceGroup(i5);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            Object obj = rememberedValue10;
            if (rememberedValue10 == companion.getEmpty()) {
                com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                nVar.e = b4.h(d4.a);
                startRestartGroup.updateRememberedValue(nVar);
                obj = nVar;
            }
            com.dragon.read.kmp.compose.common.image.n nVar2 = (com.dragon.read.kmp.compose.common.image.n) obj;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(i5);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = androidx.compose.foundation.o.h(androidx.compose.ui.draw.e.a(SizeKt.s(aVar5, x0.i.g(22)), k.g.f()), x0.i.g((float) 0.5d), og4.a.a.d().E(), k.g.f());
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            Modifier modifier3 = (Modifier) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            if (ok0Var != null) {
                str = ok0Var.c;
            } else {
                str = null;
            }
            LoadImageKt.g(str, (String) null, nVar2, modifier3, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 3456, 114);
            startRestartGroup.startReplaceGroup(230014351);
            float f10 = 8;
            androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar5, x0.i.g(f10)), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            if (ok0Var == null || (str2 = ok0Var.b) == null) {
                str2 = "";
            }
            a6.j(str2, w2Var.a(aVar5, 1.0f, false), og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (androidx.compose.ui.text.g3) null, startRestartGroup, 199680, 3120, 120784);
            startRestartGroup.startReplaceGroup(-1422812845);
            if (profileState.e) {
                startRestartGroup.startReplaceGroup(230014351);
                androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar5, x0.i.g(f10)), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                i6 = 1849434622;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (rememberedValue12 == companion.getEmpty()) {
                    rememberedValue12 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.e1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit T;
                            T = ProfileUserHeaderKt.T(GuestProfileViewModel.this, t2);
                            return T;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                }
                startRestartGroup.endReplaceGroup();
                z7 = true;
                p.r(viewModel, true, (Function0) rememberedValue12, startRestartGroup, ((i11 >> 3) & 14) | 432);
                startRestartGroup.startReplaceGroup(230014351);
                androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar5, x0.i.g(20)), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                i6 = 1849434622;
                z7 = true;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(1531886644);
            if (!profileState.e) {
                startRestartGroup.startReplaceGroup(i6);
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (rememberedValue13 == companion.getEmpty()) {
                    rememberedValue13 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.f1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit U;
                            U = ProfileUserHeaderKt.U(GuestProfileViewModel.this, t2);
                            return U;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                }
                startRestartGroup.endReplaceGroup();
                p.r(viewModel, z7, (Function0) rememberedValue13, startRestartGroup, ((i11 >> 3) & 14) | 432);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit V;
                    V = ProfileUserHeaderKt.V(modifier, viewModel, profileState, collapsingState, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    return V;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final GuestProfileViewModel guestProfileViewModel, final String str, final String str2, final boolean z, final float f2, final boolean z2, Composer composer, final int i2) {
        int i3;
        boolean z3;
        Composer composer2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Composer composer3;
        Modifier modifier;
        int i4;
        Composer composer4;
        long h2;
        org.jetbrains.compose.resources.b A0;
        androidx.compose.ui.graphics.m0 m0Var;
        long h3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-2125391256);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i10 = 4;
            } else {
                i10 = 2;
            }
            i3 = i10 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i9 = 32;
            } else {
                i9 = 16;
            }
            i3 |= i9;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(str2)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i3 |= i8;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(z)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changed(f2)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((196608 & i2) == 0) {
            if (startRestartGroup.changed(z2)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i3 |= i5;
        }
        int i11 = i3;
        if ((74899 & i11) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (startRestartGroup.shouldExecute(z3, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2125391256, i11, -1, "com.dragon.read.kmp.profile.guestprofile.view.AccountNumberView (ProfileUserHeader.kt:632)");
            }
            if (str2 != null && str2.length() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z4) {
                if (str != null && str.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5) {
                    e.c i12 = androidx.compose.ui.e.a.i();
                    Modifier modifier2 = Modifier.Companion;
                    startRestartGroup.startReplaceGroup(-1633490746);
                    if ((i11 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if ((i11 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z8 = z6 | z7;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (z8 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.a1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit z9;
                                z9 = ProfileUserHeaderKt.z(GuestProfileViewModel.this, str);
                                return z9;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                    androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(androidx.compose.foundation.layout.e.a.h(), i12, startRestartGroup, 48);
                    int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier3);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
                    Function0 a3 = companion.a();
                    if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(a3);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer b3 = g5.b(startRestartGroup);
                    g5.e(b3, b2, companion.c());
                    g5.e(b3, currentCompositionLocalMap, companion.e());
                    Function2 b4 = companion.b();
                    if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                        b3.updateRememberedValue(Integer.valueOf(a2));
                        b3.apply(Integer.valueOf(a2), b4);
                    }
                    g5.e(b3, e2, companion.d());
                    androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
                    startRestartGroup.startReplaceGroup(-805687189);
                    if (z) {
                        androidx.compose.ui.text.g3 l0 = l0();
                        int b5 = w0.s.b.b();
                        if (z2) {
                            startRestartGroup.startReplaceGroup(-805678628);
                            h3 = og4.a.a.h(startRestartGroup, og4.a.b).F();
                        } else {
                            startRestartGroup.startReplaceGroup(-805677262);
                            h3 = og4.a.a.h(startRestartGroup, og4.a.b).h();
                        }
                        startRestartGroup.endReplaceGroup();
                        i4 = i11;
                        composer3 = startRestartGroup;
                        modifier = modifier2;
                        a6.j("  |  ", (Modifier) null, h3, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b5, false, 1, 0, (Function1) null, l0, composer3, 6, 3120, 55290);
                    } else {
                        composer3 = startRestartGroup;
                        modifier = modifier2;
                        i4 = i11;
                    }
                    composer3.endReplaceGroup();
                    androidx.compose.ui.text.g3 l02 = l0();
                    Modifier modifier4 = modifier;
                    Modifier z9 = SizeKt.z(modifier4, 0.0f, x0.i.g(f2 - x0.i.g(14)), 1, (Object) null);
                    int b6 = w0.s.b.b();
                    if (z2) {
                        composer4 = composer3;
                        composer4.startReplaceGroup(-805666308);
                        h2 = og4.a.a.h(composer4, og4.a.b).G();
                    } else {
                        composer4 = composer3;
                        composer4.startReplaceGroup(-805664942);
                        h2 = og4.a.a.h(composer4, og4.a.b).h();
                    }
                    composer4.endReplaceGroup();
                    Composer composer5 = composer4;
                    a6.j(str2, z9, h2, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b6, false, 1, 0, (Function1) null, l02, composer5, (i4 >> 6) & 14, 3120, 55288);
                    float g2 = x0.i.g(2);
                    composer2 = composer5;
                    composer2.startReplaceGroup(-344996060);
                    androidx.compose.foundation.layout.a3.a(SizeKt.x(modifier4, g2), composer2, 0);
                    composer2.endReplaceGroup();
                    if (com.dragon.read.kmp.service.d1.d((Theme) composer2.consume(rg4.e.l()))) {
                        A0 = b4.z0(d4.a);
                    } else {
                        A0 = b4.A0(d4.a);
                    }
                    androidx.compose.ui.graphics.e1 a4 = org.jetbrains.compose.resources.c.a(A0, composer2, 0);
                    composer2.startReplaceGroup(-805656314);
                    if (z2) {
                        m0Var = ig4.i.d(og4.a.a.h(composer2, og4.a.b).F());
                    } else {
                        m0Var = null;
                    }
                    composer2.endReplaceGroup();
                    androidx.compose.foundation.z0.g(a4, "复制", SizeKt.s(modifier4, x0.i.g(12)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0Var, 0, composer2, 432, 184);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            t3 endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.z0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit y;
                        y = ProfileUserHeaderKt.y(GuestProfileViewModel.this, str, str2, z, f2, z2, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return y;
                    }
                });
                return;
            }
            return;
        }
        composer2 = startRestartGroup;
        composer2.skipToGroupEnd();
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit A;
                    A = ProfileUserHeaderKt.A(GuestProfileViewModel.this, str, str2, z, f2, z2, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return A;
                }
            });
        }
    }
}
