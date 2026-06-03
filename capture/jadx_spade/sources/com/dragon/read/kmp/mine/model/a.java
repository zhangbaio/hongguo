package com.dragon.read.kmp.mine.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.e3;
import androidx.compose.ui.text.input.r0;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.n;
import com.dragon.read.kmp.service.b1;
import java.util.List;
import jg4.s;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends ViewModel {
    public static final C0017a B;
    public static final int C;
    private final c A;
    public final MutableState<Boolean> a;
    public final MutableState<Boolean> b;
    public final MutableState<String> c;
    public final MutableState<h> d;
    public final MutableState<Boolean> e;
    public final MutableState<Boolean> f;
    public final MutableState<Boolean> g;
    public final MutableState<Boolean> h;
    public final MutableState<String> i;
    public CoroutineScope j;
    public final MutableState<Boolean> k;
    public final MutableState<r0> l;
    public final MutableState<String> m;
    public boolean n;
    public final MutableState<Integer> o;
    public final MutableState<Integer> p;
    public String q;
    public String r;
    public boolean s;
    public String t;
    public List<h> u;
    public Function2<? super String, ? super String, Unit> v;
    public Function2<? super String, ? super String, Unit> w;
    public Function0<Unit> x;
    public Function0<Unit> y;
    public Function0<Unit> z;

    /* renamed from: com.dragon.read.kmp.mine.model.a$a, reason: collision with other inner class name */
    public static final class C0017a {
        static {
            Covode.recordClassIndex(607687);
        }

        private C0017a() {
        }

        public /* synthetic */ C0017a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607686);
        B = new C0017a(null);
        C = 8;
    }

    public final void J0() {
        this.n = false;
    }

    public final void K0() {
        this.n = true;
    }

    public final void P0() {
        Function0<Unit> function0 = this.z;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void Q0() {
        Function0<Unit> function0 = this.y;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void R0() {
        Function0<Unit> function0 = this.x;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void I0() {
        if (sj4.e.a()) {
            s.b(this.A);
        }
    }

    public a() {
        Boolean bool = Boolean.FALSE;
        this.a = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.b = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.c = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.d = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.f = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.g = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.i = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.j = n.a;
        this.k = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.l = SnapshotStateKt.mutableStateOf$default(new r0("", 0L, (e3) null, 6, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.m = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.o = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.p = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.q = "";
        this.r = "";
        this.t = "";
        this.u = CollectionsKt__CollectionsKt.emptyList();
        this.A = new c();
    }

    public static final class c implements jg4.a {
        c() {
        }

        public void a(int i, int i2) {
            String str;
            if (((Boolean) a.this.e.getValue()).booleanValue()) {
                a.this.e.setValue(Boolean.FALSE);
                com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
                str = com.dragon.read.kmp.mine.model.b.a;
                jVar.d(str, "onKeyboardClose height = " + i + ", decorViewHeight = " + i2);
                a.this.o.setValue(0);
            }
        }

        public void b(int i, int i2) {
            String str;
            if (!((Boolean) a.this.e.getValue()).booleanValue()) {
                a.this.e.setValue(Boolean.TRUE);
                b1 b1Var = b1.a;
                int e = (b1Var.e(24.0f) - b1Var.e(b1Var.s())) - i2;
                com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
                str = com.dragon.read.kmp.mine.model.b.a;
                jVar.d(str, "onKeyboardShow height = " + i + ", decorViewHeight = " + i2 + ", offset = " + e);
                if (e > 0) {
                    a.this.o.setValue(Integer.valueOf(-e));
                }
            }
        }
    }

    public final void L0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.r = str;
    }

    public final void M0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.t = str;
    }

    public final void N0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.q = str;
    }

    public final void O0(List<h> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.u = list;
    }

    public final void H0(CoroutineScope composeContext) {
        Intrinsics.checkNotNullParameter(composeContext, "composeContext");
        this.j = composeContext;
        if (sj4.e.a()) {
            s.a(this.A);
        }
    }

    public final void F0(String sendMethod, String phone) {
        Intrinsics.checkNotNullParameter(sendMethod, "sendMethod");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.k.setValue(Boolean.TRUE);
        Function2<? super String, ? super String, Unit> function2 = this.v;
        if (function2 != null) {
            function2.invoke(sendMethod, phone);
        }
    }

    public final void G0(String phone, String captcha) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(captcha, "captcha");
        Function2<? super String, ? super String, Unit> function2 = this.w;
        if (function2 != null) {
            function2.invoke(phone, captcha);
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;

        static {
            Covode.recordClassIndex(607688);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "VerifyText(title=" + this.a + ", subtitle=" + this.b + ", button=" + this.c + ')';
        }

        public b(String title, String subtitle, String button) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(button, "button");
            this.a = title;
            this.b = subtitle;
            this.c = button;
        }
    }

    public final void E0(Function2<? super String, ? super String, Unit> fetchCode, Function2<? super String, ? super String, Unit> nextStep, Function0<Unit> showSelectPhoneCodeDialog, Function0<Unit> showOldPhoneUnavailableDialog, Function0<Unit> showCanNotReceivedCodeDialog) {
        Intrinsics.checkNotNullParameter(fetchCode, "fetchCode");
        Intrinsics.checkNotNullParameter(nextStep, "nextStep");
        Intrinsics.checkNotNullParameter(showSelectPhoneCodeDialog, "showSelectPhoneCodeDialog");
        Intrinsics.checkNotNullParameter(showOldPhoneUnavailableDialog, "showOldPhoneUnavailableDialog");
        Intrinsics.checkNotNullParameter(showCanNotReceivedCodeDialog, "showCanNotReceivedCodeDialog");
        this.v = fetchCode;
        this.w = nextStep;
        this.x = showSelectPhoneCodeDialog;
        this.y = showOldPhoneUnavailableDialog;
        this.z = showCanNotReceivedCodeDialog;
    }
}
