package com.dragon.read.kmp.story.impl.widget.follow;

import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.UserRelationType;
import com.bytedance.kmp.ugc.model.d6;
import com.dragon.read.kmp.n;
import com.dragon.read.kmp.service.c0;
import com.dragon.read.kmp.service.f1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryFollowViewModel extends ViewModel {
    public static final int k;
    public final d6 a;
    public final a b;
    public final String c;
    private final tp4.b d;
    private final MutableStateFlow<Integer> e;
    public final StateFlow<Integer> f;
    private final MutableStateFlow<Boolean> g;
    public final StateFlow<Boolean> h;
    private final n i;
    private boolean j;

    public interface a {
        void onSuccess(boolean z);
    }

    static {
        Covode.recordClassIndex(609434);
        k = 8;
    }

    public static final class b implements f1 {
        final /* synthetic */ Function0<Unit> a;

        @Override // com.dragon.read.kmp.service.f1
        public void a() {
        }

        @Override // com.dragon.read.kmp.service.f1
        public void b() {
        }

        @Override // com.dragon.read.kmp.service.f1
        public void success() {
            this.a.invoke();
        }

        b(Function0<Unit> function0) {
            this.a = function0;
        }
    }

    public final void K0() {
        this.g.setValue(Boolean.FALSE);
    }

    public final void I0() {
        Function0 function0 = new Function0() { // from class: com.dragon.read.kmp.story.impl.widget.follow.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit J0;
                J0 = KmpStoryFollowViewModel.J0(KmpStoryFollowViewModel.this);
                return J0;
            }
        };
        c0 c0Var = c0.a;
        if (!c0Var.isLogin()) {
            c0Var.K5("story", new b(function0));
        } else {
            function0.invoke();
        }
    }

    public final void L0() {
        c0 c0Var = c0.a;
        if (Intrinsics.areEqual(c0Var.getUserId(), this.a.a) || !c0Var.isLogin() || this.j) {
            return;
        }
        kotlinx.coroutines.i.e(this.i, Dispatchers.getIO(), null, new KmpStoryFollowViewModel$performFollowAction$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        Integer value = this.f.getValue();
        UserRelationType userRelationType = UserRelationType.Follow;
        int value2 = userRelationType.getValue();
        if (value != null && value.intValue() == value2) {
            userRelationType = UserRelationType.None;
        } else {
            UserRelationType userRelationType2 = UserRelationType.Followed;
            int value3 = userRelationType2.getValue();
            if (value != null && value.intValue() == value3) {
                userRelationType = UserRelationType.MutualFollow;
            } else {
                int value4 = UserRelationType.MutualFollow.getValue();
                if (value != null && value.intValue() == value4) {
                    userRelationType = userRelationType2;
                }
            }
        }
        this.e.setValue(Integer.valueOf(userRelationType.getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit J0(com.dragon.read.kmp.story.impl.widget.follow.KmpStoryFollowViewModel r3) {
        /*
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> r0 = r3.e
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            com.bytedance.kmp.ugc.model.UserRelationType r1 = com.bytedance.kmp.ugc.model.UserRelationType.Follow
            int r1 = r1.getValue()
            if (r0 != 0) goto L11
            goto L17
        L11:
            int r2 = r0.intValue()
            if (r2 == r1) goto L29
        L17:
            com.bytedance.kmp.ugc.model.UserRelationType r1 = com.bytedance.kmp.ugc.model.UserRelationType.MutualFollow
            int r1 = r1.getValue()
            if (r0 != 0) goto L20
            goto L27
        L20:
            int r0 = r0.intValue()
            if (r0 != r1) goto L27
            goto L29
        L27:
            r0 = 0
            goto L2a
        L29:
            r0 = 1
        L2a:
            if (r0 == 0) goto L34
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r3 = r3.g
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r3.setValue(r0)
            goto L37
        L34:
            r3.L0()
        L37:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.widget.follow.KmpStoryFollowViewModel.J0(com.dragon.read.kmp.story.impl.widget.follow.KmpStoryFollowViewModel):kotlin.Unit");
    }

    public KmpStoryFollowViewModel(d6 userInfo, a aVar, String str) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        this.a = userInfo;
        this.b = aVar;
        this.c = str;
        this.d = new tp4.b("KmpStoryFollowViewModel");
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(userInfo.D);
        this.e = MutableStateFlow;
        this.f = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.g = MutableStateFlow2;
        this.h = FlowKt.asStateFlow(MutableStateFlow2);
        this.i = n.a;
    }
}
