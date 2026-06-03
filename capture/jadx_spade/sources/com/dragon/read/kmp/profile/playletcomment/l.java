package com.dragon.read.kmp.profile.playletcomment;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.subscribe.n;
import com.dragon.read.kmp.utils.l0;
import com.dragon.read.rpc.kmp.community.model.UgcCommentGroupTypeOutter;
import gk4.d0;
import gk4.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o62.m;
import y62.c0;
import y62.t;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public static final a j;
    public static final int k;
    public final d0 a;
    public final int b;
    public final ym4.a c;
    public final String d;
    public final String e;
    public final MutableState<Boolean> f;
    public final MutableState<Boolean> g;
    public final MutableState<Long> h;
    private final b i;

    public static final class a {
        static {
            Covode.recordClassIndex(608211);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608210);
        j = new a(null);
        k = 8;
    }

    public static final class b implements m {
        public List<UgcCommentGroupTypeOutter> getInterestServiceIds() {
            return CollectionsKt__CollectionsJVMKt.listOf(UgcCommentGroupTypeOutter.Book);
        }

        b() {
        }

        public boolean o(kx1.c cVar) {
            return m.a.a(this, cVar);
        }

        public boolean h(kx1.c predicateArgs) {
            Intrinsics.checkNotNullParameter(predicateArgs, "predicateArgs");
            p72.a a = p72.a.X2.a();
            if (a == null || !a.g9(predicateArgs, l.this.a.d)) {
                return false;
            }
            return true;
        }

        public boolean g(o62.k kVar, t tVar) {
            return m.a.b(this, kVar, tVar);
        }

        public void l(o62.k kVar, String str, boolean z) {
            m.a.e(this, kVar, str, z);
        }

        public void m(o62.k kVar, String str, c0 c0Var) {
            m.a.f(this, kVar, str, c0Var);
        }

        public void p(o62.k kVar, String str, String str2) {
            m.a.g(this, kVar, str, str2);
        }

        public void c(o62.k syncParams, String commentId, boolean z) {
            Intrinsics.checkNotNullParameter(syncParams, "syncParams");
            Intrinsics.checkNotNullParameter(commentId, "commentId");
            if (Intrinsics.areEqual(l.this.a.c, commentId)) {
                long c = ((o62.t) syncParams).c.c("diggCount", -1L);
                com.dragon.read.kmp.j.a.d("PlayletCommentItemVM", "onCommentDiggChanged, commentId = " + commentId + ", isDigg = " + z + ", diggCountInArgs = " + c + ", diggCountInModel = " + l.this.a.l);
                l lVar = l.this;
                d0 d0Var = lVar.a;
                d0Var.k = z;
                if (c >= 0) {
                    d0Var.l = c;
                    lVar.h.setValue(Long.valueOf(c));
                }
                l.this.g.setValue(Boolean.valueOf(z));
            }
        }

        public void k(o62.k kVar, String str, boolean z, t tVar) {
            m.a.c(this, kVar, str, z, tVar);
        }
    }

    private final void k() {
        o.a.d("click_comment", c());
    }

    private final void m() {
        o.a.d("impr_comment", c());
    }

    private final ym4.a c() {
        ym4.a aVar = new ym4.a();
        l0.a(aVar);
        aVar.j(this.c);
        aVar.g("type", "video_comment");
        aVar.g("rank", Integer.valueOf(this.b + 1));
        aVar.g("src_material_id", this.a.d);
        aVar.g("comment_id", this.a.c);
        return aVar;
    }

    public final void g() {
        com.dragon.read.kmp.j.a.d("PlayletCommentItemVM", "add comment sync listener, commentId = " + this.a.c);
        o62.j.a.i(this.i);
    }

    public final void i() {
        com.dragon.read.kmp.j.a.d("PlayletCommentItemVM", "remove comment sync listener, commentId = " + this.a.c);
        o62.j.a.B(this.i);
    }

    public final void j() {
        if (!this.a.isShown()) {
            this.a.setShown(true);
            com.dragon.read.kmp.j.a.d("PlayletCommentItemVM", "comment visible, id = " + this.a.c);
            m();
        }
    }

    public final void h() {
        boolean z;
        com.dragon.read.kmp.j.a.d("PlayletCommentItemVM", "click comment, id = " + this.a.c);
        k();
        ym4.a c = c();
        String str = this.d;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            c.g("trace_enter_from", this.d);
        }
        p72.a a2 = p72.a.X2.a();
        if (a2 != null) {
            d0 d0Var = this.a;
            a2.y4(new q72.a(d0Var.d, d0Var.c, (String) null, (String) null, (List) null, 0, false, (String) null, (String) null, (String) null, c.a, false, 3068, (DefaultConstructorMarker) null));
        }
    }

    private final void l(boolean z) {
        String str;
        o oVar = o.a;
        if (z) {
            str = "digg_comment";
        } else {
            str = "cancel_digg_comment";
        }
        oVar.d(str, c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function3 function3, boolean z, long j2, Throwable th) {
        function3.invoke(Boolean.valueOf(z), Long.valueOf(j2), th);
        com.dragon.read.kmp.j.a.b("PlayletCommentItemVM", "Like failed", th);
        return Unit.INSTANCE;
    }

    public final void d(w item, Function2<? super Boolean, ? super Long, Unit> onStart, final Function2<? super Boolean, ? super Long, Unit> onSuccess, final Function3<? super Boolean, ? super Long, ? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        n.a.u(item, onStart, new Function2() { // from class: com.dragon.read.kmp.profile.playletcomment.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit e;
                e = l.e(Function2.this, this, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue());
                return e;
            }
        }, new Function3() { // from class: com.dragon.read.kmp.profile.playletcomment.k
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit f;
                f = l.f(Function3.this, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue(), (Throwable) obj3);
                return f;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function2 function2, l lVar, boolean z, long j2) {
        boolean z2;
        String str;
        kx1.c cVar;
        function2.invoke(Boolean.valueOf(z), Long.valueOf(j2));
        kx1.c cVar2 = new kx1.c();
        String str2 = lVar.e;
        boolean z3 = false;
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            cVar2.g("profile_user_id", lVar.e);
        }
        Object d = lVar.c.d("profile_tab_name");
        String str3 = null;
        if (d instanceof String) {
            str = (String) d;
        } else {
            str = null;
        }
        if (str != null) {
            if (str.length() > 0) {
                z3 = true;
            }
            if (z3) {
                str3 = str;
            }
            if (str3 != null) {
                cVar2.g("profile_tab_name", str3);
            }
        }
        UgcCommentGroupTypeOutter ugcCommentGroupTypeOutter = UgcCommentGroupTypeOutter.Book;
        p72.a a2 = p72.a.X2.a();
        if (a2 == null || (cVar = a2.getPredicateArgs(lVar.a.d)) == null) {
            cVar = new kx1.c();
        }
        o62.k kVar = new o62.k(ugcCommentGroupTypeOutter, (kx1.c) null, cVar, cVar2, true, 2, (DefaultConstructorMarker) null);
        lVar.a.a.getDiggCount().setValue(Long.valueOf(j2));
        o62.j jVar = o62.j.a;
        d0 d0Var = lVar.a;
        jVar.r(kVar, d0Var.a, d0Var.c, z);
        com.dragon.read.kmp.j.a.d("PlayletCommentItemVM", "Like success: status=" + z + ", count=" + j2);
        lVar.l(z);
        return Unit.INSTANCE;
    }

    public l(d0 commentModel, int i, ym4.a reportArgs, String str, String str2) {
        Intrinsics.checkNotNullParameter(commentModel, "commentModel");
        Intrinsics.checkNotNullParameter(reportArgs, "reportArgs");
        this.a = commentModel;
        this.b = i;
        this.c = reportArgs;
        this.d = str;
        this.e = str2;
        this.f = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.g = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(commentModel.e()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = SnapshotStateKt.mutableStateOf$default(Long.valueOf(commentModel.l), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.i = new b();
    }
}
