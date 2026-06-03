package com.dragon.read.leftslidepage;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.GameTag;
import com.bytedance.kmp.reading.model.be0;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.sj;
import com.bytedance.kmp.reading.model.u2;
import com.bytedance.kmp.reading.model.uk;
import com.bytedance.kmp.reading.model.zu;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SidebarDataManager {
    public static final a g;
    public static final int h;
    private final e a;
    private final CoroutineScope b;
    private final o c;
    private s d;
    public boolean e;
    public boolean f;

    public static final class a {
        static {
            Covode.recordClassIndex(611261);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611260);
        g = new a(null);
        h = 8;
    }

    public final void C() {
        kotlinx.coroutines.i.e(this.b, null, null, new SidebarDataManager$primeFunctionData$1(this, null), 3, null);
    }

    public final void G() {
        kotlinx.coroutines.i.e(this.b, null, null, new SidebarDataManager$updateUserInfo$1(this, null), 3, null);
    }

    public final void E() {
        if (this.c.a.contains(SidebarSectionType.MSG)) {
            return;
        }
        kotlinx.coroutines.i.e(this.b, null, null, new SidebarDataManager$refreshMsgCount$1(this, null), 3, null);
    }

    public final void m() {
        com.dragon.read.kmp.j.a.d("SidebarDataManager", "cancelPendingTasks");
        JobKt__JobKt.t(this.b.getCoroutineContext(), null, 1, null);
    }

    public final void r() {
        com.dragon.read.kmp.j.a.d("SidebarDataManager", "loadInitialData");
        G();
        D(false, true);
    }

    public final s n() {
        MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(new v(false, "", "", "", ""), (SnapshotMutationPolicy) null, 2, (Object) null);
        n nVar = n.a;
        j e = nVar.e();
        if (e == null) {
            e = new j(new m("", "", false, 4, null), CollectionsKt__CollectionsKt.emptyList());
        }
        MutableState mutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default(e, (SnapshotMutationPolicy) null, 2, (Object) null);
        l f = nVar.f();
        if (f == null) {
            f = new l(new m("", "", false), CollectionsKt__CollectionsKt.emptyList(), false, 4, null);
        }
        MutableState mutableStateOf$default3 = SnapshotStateKt.mutableStateOf$default(f, (SnapshotMutationPolicy) null, 2, (Object) null);
        i d = nVar.d();
        if (d == null) {
            d = new i(new m("", "", false, 4, null), CollectionsKt__CollectionsKt.emptyList());
        }
        MutableState mutableStateOf$default4 = SnapshotStateKt.mutableStateOf$default(d, (SnapshotMutationPolicy) null, 2, (Object) null);
        q c = nVar.c();
        if (c == null) {
            c = new q(new m("", "", false), CollectionsKt__CollectionsKt.emptyList());
        }
        s sVar = new s(mutableStateOf$default, mutableStateOf$default2, mutableStateOf$default3, mutableStateOf$default4, SnapshotStateKt.mutableStateOf$default(c, (SnapshotMutationPolicy) null, 2, (Object) null), SnapshotStateKt.mutableStateOf$default(nVar.g(), (SnapshotMutationPolicy) null, 2, (Object) null), SnapshotStateKt.mutableStateOf$default(nVar.b(), (SnapshotMutationPolicy) null, 2, (Object) null));
        this.d = sVar;
        return sVar;
    }

    private final t v(zu zuVar) {
        String str = zuVar.f;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = zuVar.i;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = zuVar.h;
        if (str4 != null) {
            str2 = str4;
        }
        return new t(str, str3, str2);
    }

    private final l j(l lVar) {
        List<k> list = lVar.b;
        int i = 2;
        if (lVar.c && !this.f) {
            i = !this.e ? 3 : list.size();
        }
        if (list.size() > i) {
            list = list.subList(0, i);
        }
        return new l(lVar.a, list, lVar.c);
    }

    private final String A(om0 om0Var) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        List list = om0Var.t0;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            e90 e90Var = (e90) CollectionsKt___CollectionsKt.getOrNull(list, i);
            if (e90Var != null) {
                String str = e90Var.a;
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    sb.append(e90Var.a);
                    if (i < list.size() - 1) {
                        sb.append(" · ");
                    }
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final r t(uk ukVar) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5 = ukVar.a;
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        String str6 = ukVar.b;
        if (str6 == null) {
            str2 = "";
        } else {
            str2 = str6;
        }
        String str7 = ukVar.c;
        if (str7 == null) {
            str3 = "";
        } else {
            str3 = str7;
        }
        String str8 = ukVar.d;
        if (str8 == null) {
            str4 = "";
        } else {
            str4 = str8;
        }
        List list = ukVar.e;
        boolean z2 = false;
        if (list != null && list.contains(Integer.valueOf(GameTag.NewGame.getValue()))) {
            z = true;
        } else {
            z = false;
        }
        List list2 = ukVar.e;
        if (list2 != null && list2.contains(Integer.valueOf(GameTag.HistoryGame.getValue()))) {
            z2 = true;
        }
        return new r(str, str2, str3, str4, z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.dragon.read.leftslidepage.SidebarDataManager$updateFunctionData$1
            if (r0 == 0) goto L13
            r0 = r5
            com.dragon.read.leftslidepage.SidebarDataManager$updateFunctionData$1 r0 = (com.dragon.read.leftslidepage.SidebarDataManager$updateFunctionData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.leftslidepage.SidebarDataManager$updateFunctionData$1 r0 = new com.dragon.read.leftslidepage.SidebarDataManager$updateFunctionData$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.k(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            com.dragon.read.leftslidepage.q r5 = (com.dragon.read.leftslidepage.q) r5
            com.dragon.read.leftslidepage.n r0 = com.dragon.read.leftslidepage.n.a
            r0.i(r5)
            com.dragon.read.leftslidepage.s r0 = r4.d
            if (r0 != 0) goto L4f
            java.lang.String r0 = "sidebarInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L4f:
            androidx.compose.runtime.MutableState<com.dragon.read.leftslidepage.q> r0 = r0.e
            r0.setValue(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.F(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final w B(be0 be0Var) {
        String str;
        String str2;
        Integer num;
        om0 om0Var;
        String str3;
        List list;
        u2 u2Var;
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("parseSubscribeSection title: ");
        k kVar = null;
        if (be0Var != null) {
            str = be0Var.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(" subTitle: ");
        if (be0Var != null && (u2Var = be0Var.b) != null) {
            str2 = u2Var.a;
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append(" size: ");
        if (be0Var != null && (list = be0Var.c) != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        sb.append(num);
        jVar.d("SidebarDataManager", sb.toString());
        if (be0Var == null || be0Var.b == null) {
            return null;
        }
        List list2 = be0Var.c;
        if (list2 != null) {
            om0Var = (om0) CollectionsKt___CollectionsKt.getOrNull(list2, 0);
        } else {
            om0Var = null;
        }
        w wVar = new w();
        String str4 = be0Var.a;
        String str5 = "";
        if (str4 == null) {
            str4 = "";
        }
        wVar.a = str4;
        u2 u2Var2 = be0Var.b;
        if (u2Var2 != null && (str3 = u2Var2.a) != null) {
            str5 = str3;
        }
        wVar.b = str5;
        if (om0Var != null) {
            kVar = y(om0Var, true);
        }
        wVar.c = kVar;
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(kotlin.coroutines.Continuation<? super com.dragon.read.leftslidepage.v> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.dragon.read.leftslidepage.SidebarDataManager$buildUserInfo$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.leftslidepage.SidebarDataManager$buildUserInfo$1 r0 = (com.dragon.read.leftslidepage.SidebarDataManager$buildUserInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.leftslidepage.SidebarDataManager$buildUserInfo$1 r0 = new com.dragon.read.leftslidepage.SidebarDataManager$buildUserInfo$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            boolean r1 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r3 = r2
            r2 = r0
            goto L8d
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L40:
            boolean r2 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L67
        L46:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.service.c0 r7 = com.dragon.read.kmp.service.c0.a
            boolean r2 = r7.isLogin()
            if (r2 == 0) goto L56
            java.lang.String r7 = r7.getUserName()
            goto L69
        L56:
            com.dragon.read.component.biz.impl.bookmall.m5 r7 = com.dragon.read.component.biz.impl.bookmall.m5.a
            org.jetbrains.compose.resources.i r7 = com.dragon.read.component.biz.impl.bookmall.s5.u(r7)
            r0.Z$0 = r2
            r0.label = r4
            java.lang.Object r7 = org.jetbrains.compose.resources.j.a(r7, r0)
            if (r7 != r1) goto L67
            return r1
        L67:
            java.lang.String r7 = (java.lang.String) r7
        L69:
            if (r2 == 0) goto L72
            com.dragon.read.kmp.service.c0 r4 = com.dragon.read.kmp.service.c0.a
            java.lang.String r4 = r4.getAvatarUrl()
            goto L74
        L72:
            java.lang.String r4 = ""
        L74:
            com.dragon.read.component.biz.impl.bookmall.m5 r5 = com.dragon.read.component.biz.impl.bookmall.m5.a
            org.jetbrains.compose.resources.i r5 = com.dragon.read.component.biz.impl.bookmall.s5.t(r5)
            r0.L$0 = r7
            r0.L$1 = r4
            r0.Z$0 = r2
            r0.label = r3
            java.lang.Object r0 = org.jetbrains.compose.resources.j.a(r5, r0)
            if (r0 != r1) goto L89
            return r1
        L89:
            r1 = r2
            r3 = r4
            r2 = r7
            r7 = r0
        L8d:
            r5 = r7
            java.lang.String r5 = (java.lang.String) r5
            com.dragon.read.leftslidepage.v r7 = new com.dragon.read.leftslidepage.v
            java.lang.String r4 = ""
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.l(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|(2:3|(13:5|6|7|(1:(1:(8:11|12|(1:14)|15|(1:17)(1:23)|18|19|20)(2:24|25))(1:26))(3:30|31|(1:33))|27|(1:29)|12|(0)|15|(0)(0)|18|19|20))|36|6|7|(0)(0)|27|(0)|12|(0)|15|(0)(0)|18|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0039, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c4, code lost:
    
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SidebarDataManager", "fetchGameData error: " + r13.getMessage(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0097 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:11:0x0029, B:12:0x0093, B:14:0x0097, B:15:0x00ad, B:17:0x00b6, B:18:0x00be, B:26:0x0035, B:27:0x0069, B:31:0x003f), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b6 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:11:0x0029, B:12:0x0093, B:14:0x0097, B:15:0x00ad, B:17:0x00b6, B:18:0x00be, B:26:0x0035, B:27:0x0069, B:31:0x003f), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final b s(sj sjVar) {
        String str;
        String str2;
        Integer num;
        boolean z;
        boolean z2;
        Boolean valueOf;
        om0 om0Var;
        String str3;
        Object firstOrNull;
        List list;
        u2 u2Var;
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("parseFollowSection title: ");
        k kVar = null;
        if (sjVar != null) {
            str = sjVar.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(" subTitle: ");
        if (sjVar != null && (u2Var = sjVar.b) != null) {
            str2 = u2Var.a;
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append(" size: ");
        if (sjVar != null && (list = sjVar.c) != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        sb.append(num);
        jVar.d("SidebarDataManager", sb.toString());
        if (sjVar == null) {
            return null;
        }
        b b = n.a.b();
        if (b != null) {
            z = Intrinsics.areEqual(b.g, Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            valueOf = b.g;
        } else {
            Boolean bool = sjVar.d;
            if (bool != null) {
                z2 = bool.booleanValue();
            } else {
                z2 = true;
            }
            valueOf = Boolean.valueOf(!z2);
        }
        List list2 = sjVar.c;
        if (list2 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            om0Var = (om0) firstOrNull;
        } else {
            om0Var = null;
        }
        b bVar = new b();
        String str4 = sjVar.a;
        String str5 = "";
        if (str4 == null) {
            str4 = "";
        }
        bVar.a = str4;
        u2 u2Var2 = sjVar.b;
        if (u2Var2 != null && (str3 = u2Var2.a) != null) {
            str5 = str3;
        }
        bVar.b = str5;
        if (om0Var != null) {
            kVar = y(om0Var, true);
        }
        bVar.c = kVar;
        bVar.g = valueOf;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:(1:(3:12|13|14)(2:16|17))(14:18|19|20|(3:22|(1:24)|25)|26|(1:28)(1:52)|(3:30|(1:32)|33)|34|(1:36)(1:51)|(6:38|(1:40)(1:47)|(1:42)|43|(1:45)|46)|48|(1:50)|13|14))(1:53))(3:67|68|(1:70))|54|(2:56|57)(12:58|(6:60|(1:62)(1:66)|63|(1:65)|20|(0))|26|(0)(0)|(0)|34|(0)(0)|(0)|48|(0)|13|14)))|73|6|7|(0)(0)|54|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0049, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0162, code lost:
    
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SidebarDataManager", "fetchSidebarContent error: " + r15.getMessage(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1 A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:12:0x002f, B:19:0x0040, B:20:0x00bd, B:22:0x00c1, B:24:0x00ce, B:25:0x00d2, B:26:0x00d7, B:30:0x00f3, B:32:0x0104, B:33:0x0108, B:34:0x010d, B:38:0x0123, B:40:0x0133, B:42:0x0141, B:43:0x0147, B:45:0x014e, B:46:0x0152, B:48:0x0157, B:51:0x011b, B:52:0x00eb, B:53:0x0045, B:54:0x0078, B:56:0x009b, B:58:0x009e, B:60:0x00aa, B:62:0x00ae, B:63:0x00b2, B:68:0x004f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f3 A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:12:0x002f, B:19:0x0040, B:20:0x00bd, B:22:0x00c1, B:24:0x00ce, B:25:0x00d2, B:26:0x00d7, B:30:0x00f3, B:32:0x0104, B:33:0x0108, B:34:0x010d, B:38:0x0123, B:40:0x0133, B:42:0x0141, B:43:0x0147, B:45:0x014e, B:46:0x0152, B:48:0x0157, B:51:0x011b, B:52:0x00eb, B:53:0x0045, B:54:0x0078, B:56:0x009b, B:58:0x009e, B:60:0x00aa, B:62:0x00ae, B:63:0x00b2, B:68:0x004f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123 A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:12:0x002f, B:19:0x0040, B:20:0x00bd, B:22:0x00c1, B:24:0x00ce, B:25:0x00d2, B:26:0x00d7, B:30:0x00f3, B:32:0x0104, B:33:0x0108, B:34:0x010d, B:38:0x0123, B:40:0x0133, B:42:0x0141, B:43:0x0147, B:45:0x014e, B:46:0x0152, B:48:0x0157, B:51:0x011b, B:52:0x00eb, B:53:0x0045, B:54:0x0078, B:56:0x009b, B:58:0x009e, B:60:0x00aa, B:62:0x00ae, B:63:0x00b2, B:68:0x004f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0161 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:12:0x002f, B:19:0x0040, B:20:0x00bd, B:22:0x00c1, B:24:0x00ce, B:25:0x00d2, B:26:0x00d7, B:30:0x00f3, B:32:0x0104, B:33:0x0108, B:34:0x010d, B:38:0x0123, B:40:0x0133, B:42:0x0141, B:43:0x0147, B:45:0x014e, B:46:0x0152, B:48:0x0157, B:51:0x011b, B:52:0x00eb, B:53:0x0045, B:54:0x0078, B:56:0x009b, B:58:0x009e, B:60:0x00aa, B:62:0x00ae, B:63:0x00b2, B:68:0x004f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:12:0x002f, B:19:0x0040, B:20:0x00bd, B:22:0x00c1, B:24:0x00ce, B:25:0x00d2, B:26:0x00d7, B:30:0x00f3, B:32:0x0104, B:33:0x0108, B:34:0x010d, B:38:0x0123, B:40:0x0133, B:42:0x0141, B:43:0x0147, B:45:0x014e, B:46:0x0152, B:48:0x0157, B:51:0x011b, B:52:0x00eb, B:53:0x0045, B:54:0x0078, B:56:0x009b, B:58:0x009e, B:60:0x00aa, B:62:0x00ae, B:63:0x00b2, B:68:0x004f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:12:0x002f, B:19:0x0040, B:20:0x00bd, B:22:0x00c1, B:24:0x00ce, B:25:0x00d2, B:26:0x00d7, B:30:0x00f3, B:32:0x0104, B:33:0x0108, B:34:0x010d, B:38:0x0123, B:40:0x0133, B:42:0x0141, B:43:0x0147, B:45:0x014e, B:46:0x0152, B:48:0x0157, B:51:0x011b, B:52:0x00eb, B:53:0x0045, B:54:0x0078, B:56:0x009b, B:58:0x009e, B:60:0x00aa, B:62:0x00ae, B:63:0x00b2, B:68:0x004f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:12:0x002f, B:19:0x0040, B:20:0x00bd, B:22:0x00c1, B:24:0x00ce, B:25:0x00d2, B:26:0x00d7, B:30:0x00f3, B:32:0x0104, B:33:0x0108, B:34:0x010d, B:38:0x0123, B:40:0x0133, B:42:0x0141, B:43:0x0147, B:45:0x014e, B:46:0x0152, B:48:0x0157, B:51:0x011b, B:52:0x00eb, B:53:0x0045, B:54:0x0078, B:56:0x009b, B:58:0x009e, B:60:0x00aa, B:62:0x00ae, B:63:0x00b2, B:68:0x004f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x008e  */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(kotlin.coroutines.Continuation<? super com.dragon.read.leftslidepage.q> r21) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object x(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto Lf
            java.lang.Long r5 = kotlin.text.StringsKt.toLongOrNull(r5)
            if (r5 == 0) goto Lf
            long r2 = r5.longValue()
            goto L10
        Lf:
            r2 = r0
        L10:
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 > 0) goto L1f
            com.dragon.read.component.biz.impl.bookmall.m5 r5 = com.dragon.read.component.biz.impl.bookmall.m5.a
            org.jetbrains.compose.resources.i r5 = com.dragon.read.component.biz.impl.bookmall.s5.c(r5)
            java.lang.Object r5 = org.jetbrains.compose.resources.j.a(r5, r6)
            return r5
        L1f:
            com.dragon.read.component.biz.impl.bookmall.m5 r5 = com.dragon.read.component.biz.impl.bookmall.m5.a
            org.jetbrains.compose.resources.i r5 = com.dragon.read.component.biz.impl.bookmall.s5.q(r5)
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r2)
            r0[r1] = r2
            java.lang.Object r5 = org.jetbrains.compose.resources.j.b(r5, r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.x(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final k y(om0 om0Var, boolean z) {
        String str;
        long j;
        int i;
        String A;
        int i2;
        String str2 = om0Var.p;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = om0Var.a;
        if (str3 == null) {
            str3 = "";
        }
        if (Intrinsics.areEqual(om0Var.t, Boolean.TRUE)) {
            str = "vertical";
        } else {
            str = "horizontal";
        }
        Long l = om0Var.b0;
        if (l != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        String str4 = om0Var.z;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = om0Var.A;
        if (str5 == null) {
            str5 = "";
        }
        Integer num = om0Var.y;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        String str6 = om0Var.b;
        if (str6 == null) {
            str6 = "";
        }
        String str7 = om0Var.e;
        if (str7 == null) {
            str7 = "";
        }
        if (!z) {
            A = om0Var.F;
            if (A == null) {
                A = "";
            }
        } else {
            A = A(om0Var);
        }
        String str8 = om0Var.g;
        if (str8 == null) {
            str8 = "";
        }
        Integer num2 = om0Var.y;
        if (num2 != null) {
            i2 = num2.intValue();
        } else {
            i2 = 0;
        }
        return new k(str2, str3, str, j, str4, str5, i, str6, str7, A, str8, i2);
    }

    public final void D(boolean z, boolean z2) {
        if (!this.c.a.contains(SidebarSectionType.MSG)) {
            kotlinx.coroutines.i.e(this.b, null, null, new SidebarDataManager$refreshAllData$1(this, z, z2, null), 3, null);
        }
        kotlinx.coroutines.i.e(this.b, null, null, new SidebarDataManager$refreshAllData$2(this, null), 3, null);
        if (this.c.a.contains(SidebarSectionType.GAME)) {
            return;
        }
        kotlinx.coroutines.i.e(this.b, null, null, new SidebarDataManager$refreshAllData$3(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(com.bytedance.kmp.reading.model.hc0 r12, kotlin.coroutines.Continuation<? super com.dragon.read.leftslidepage.i> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.dragon.read.leftslidepage.SidebarDataManager$parseGameParams$1
            if (r0 == 0) goto L13
            r0 = r13
            com.dragon.read.leftslidepage.SidebarDataManager$parseGameParams$1 r0 = (com.dragon.read.leftslidepage.SidebarDataManager$parseGameParams$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.leftslidepage.SidebarDataManager$parseGameParams$1 r0 = new com.dragon.read.leftslidepage.SidebarDataManager$parseGameParams$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L46
            if (r2 == r5) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r12 = r0.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r0 = r0.L$0
            com.bytedance.kmp.reading.model.hc0 r0 = (com.bytedance.kmp.reading.model.hc0) r0
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r12
            goto L87
        L36:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3e:
            java.lang.Object r12 = r0.L$0
            com.bytedance.kmp.reading.model.hc0 r12 = (com.bytedance.kmp.reading.model.hc0) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L6f
        L46:
            kotlin.ResultKt.throwOnFailure(r13)
            if (r12 == 0) goto L4e
            java.util.List r13 = r12.a
            goto L4f
        L4e:
            r13 = r4
        L4f:
            if (r13 == 0) goto L5a
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L58
            goto L5a
        L58:
            r13 = 0
            goto L5b
        L5a:
            r13 = 1
        L5b:
            if (r13 == 0) goto L5e
            return r4
        L5e:
            com.dragon.read.component.biz.impl.bookmall.m5 r13 = com.dragon.read.component.biz.impl.bookmall.m5.a
            org.jetbrains.compose.resources.i r13 = com.dragon.read.component.biz.impl.bookmall.s5.o(r13)
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = org.jetbrains.compose.resources.j.a(r13, r0)
            if (r13 != r1) goto L6f
            return r1
        L6f:
            java.lang.String r13 = (java.lang.String) r13
            com.dragon.read.component.biz.impl.bookmall.m5 r2 = com.dragon.read.component.biz.impl.bookmall.m5.a
            org.jetbrains.compose.resources.i r2 = com.dragon.read.component.biz.impl.bookmall.s5.c(r2)
            r0.L$0 = r12
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r0 = org.jetbrains.compose.resources.j.a(r2, r0)
            if (r0 != r1) goto L84
            return r1
        L84:
            r6 = r13
            r13 = r0
            r0 = r12
        L87:
            r7 = r13
            java.lang.String r7 = (java.lang.String) r7
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            if (r0 == 0) goto Laf
            java.util.List r13 = r0.a
            if (r13 == 0) goto Laf
            java.util.Iterator r13 = r13.iterator()
        L99:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto Laf
            java.lang.Object r0 = r13.next()
            com.bytedance.kmp.reading.model.uk r0 = (com.bytedance.kmp.reading.model.uk) r0
            if (r0 == 0) goto L99
            com.dragon.read.leftslidepage.r r0 = r11.t(r0)
            r12.add(r0)
            goto L99
        Laf:
            boolean r13 = com.dragon.read.kmp.utils.c0.a(r12)
            if (r13 == 0) goto Lc3
            com.dragon.read.leftslidepage.i r4 = new com.dragon.read.leftslidepage.i
            com.dragon.read.leftslidepage.m r13 = new com.dragon.read.leftslidepage.m
            r8 = 0
            r9 = 4
            r10 = 0
            r5 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r4.<init>(r13, r12)
        Lc3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.u(com.bytedance.kmp.reading.model.hc0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x005f, code lost:
    
        if (r8 == null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(com.bytedance.kmp.reading.model.x7 r7, kotlin.coroutines.Continuation<? super com.dragon.read.leftslidepage.l> r8) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.z(com.bytedance.kmp.reading.model.x7, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public SidebarDataManager(e eVar, CoroutineScope scope, o filter) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.a = eVar;
        this.b = scope;
        this.c = filter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(com.bytedance.kmp.reading.model.cn r12, boolean r13, kotlin.coroutines.Continuation<? super com.dragon.read.leftslidepage.j> r14) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.w(com.bytedance.kmp.reading.model.cn, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:0|1|(2:3|(17:5|6|7|(1:(1:(11:11|12|13|(1:(3:28|(1:35)|34)(2:36|37))(1:15)|16|(1:18)(1:26)|19|(1:21)|22|23|24)(2:38|39))(2:40|41))(7:48|49|(1:51)(1:59)|52|(1:54)(1:58)|55|(1:57))|42|(1:44)|45|(1:47)|13|(0)(0)|16|(0)(0)|19|(0)|22|23|24))|62|6|7|(0)(0)|42|(0)|45|(0)|13|(0)(0)|16|(0)(0)|19|(0)|22|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0120, code lost:
    
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SidebarDataManager", "fetchMsgData error: " + r0.getMessage(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f6 A[Catch: Exception -> 0x011f, TryCatch #0 {Exception -> 0x011f, blocks: (B:12:0x0032, B:13:0x00c4, B:16:0x00ef, B:18:0x00f6, B:19:0x00fe, B:21:0x0102, B:22:0x0118, B:28:0x00d1, B:30:0x00d9, B:32:0x00dd, B:34:0x00e3, B:36:0x011c, B:41:0x0041, B:42:0x0095, B:45:0x00b9, B:49:0x0048, B:52:0x005e, B:55:0x0069), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0102 A[Catch: Exception -> 0x011f, TryCatch #0 {Exception -> 0x011f, blocks: (B:12:0x0032, B:13:0x00c4, B:16:0x00ef, B:18:0x00f6, B:19:0x00fe, B:21:0x0102, B:22:0x0118, B:28:0x00d1, B:30:0x00d9, B:32:0x00dd, B:34:0x00e3, B:36:0x011c, B:41:0x0041, B:42:0x0095, B:45:0x00b9, B:49:0x0048, B:52:0x005e, B:55:0x0069), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(boolean r20, boolean r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.SidebarDataManager.p(boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ SidebarDataManager(e eVar, CoroutineScope coroutineScope, o oVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, coroutineScope, (i & 4) != 0 ? new o(null, null, 3, null) : oVar);
    }
}
