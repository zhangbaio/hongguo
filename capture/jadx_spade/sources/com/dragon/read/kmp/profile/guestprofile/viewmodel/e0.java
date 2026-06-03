package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel;
import com.dragon.read.kmp.utils.m0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e0 {
    public final rl4.c a;
    public final c7 b;
    public final GuestProfileViewModel c;
    public final MutableState<List<c7>> d;
    public com.dragon.read.kmp.profile.album.g e;
    public final androidx.compose.runtime.snapshots.e0<Integer, tl4.l> f;
    public int g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608189);
            int[] iArr = new int[ProfileTab.values().length];
            try {
                iArr[ProfileTab.Video.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileTab.ProduceVideo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileTab.CelebrityWorks.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608188);
    }

    public final tl4.l b() {
        return d(this.g);
    }

    private final void e() {
        if (this.a.n) {
            com.dragon.read.kmp.profile.album.g gVar = new com.dragon.read.kmp.profile.album.g(this.a.i, true, false, 4, null);
            gVar.e(this.a.b);
            this.e = gVar;
        }
    }

    private final void g() {
        Iterator it2 = this.f.values().iterator();
        while (it2.hasNext()) {
            ProfileTabJustSawViewModel profileTabJustSawViewModel = ((tl4.l) it2.next()).k;
            if (profileTabJustSawViewModel != null) {
                ProfileTabJustSawViewModel.p(profileTabJustSawViewModel, false, 1, null);
            }
        }
    }

    public final String c() {
        int i;
        ProfileTab profileTab = this.a.b;
        if (profileTab == null) {
            i = -1;
        } else {
            i = a.a[profileTab.ordinal()];
        }
        if (i != 1) {
            if (i != 2 && i != 3) {
                return "";
            }
            return "profile_starred_video";
        }
        return "profile_post";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(e0 e0Var) {
        e0Var.g();
        return Unit.INSTANCE;
    }

    public final tl4.l d(int i) {
        return (tl4.l) this.f.get(Integer.valueOf(i));
    }

    public final void i(int i, tl4.l tabViewModel) {
        Intrinsics.checkNotNullParameter(tabViewModel, "tabViewModel");
        this.f.put(Integer.valueOf(i), tabViewModel);
        ProfileTabJustSawViewModel profileTabJustSawViewModel = tabViewModel.k;
        if (profileTabJustSawViewModel != null) {
            profileTabJustSawViewModel.j = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.d0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit j;
                    j = e0.j(e0.this);
                    return j;
                }
            };
        }
    }

    public final void f(FilterOptionHeaderType preType, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(preType, "preType");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        rl4.c cVar = this.a;
        if (cVar.j == filterOptionHeaderType) {
            return;
        }
        cVar.d(filterOptionHeaderType);
        com.dragon.read.kmp.profile.params.a aVar = this.a.p;
        if (aVar != null) {
            aVar.o(filterOptionHeaderType.getValue());
        }
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        String c = c();
        FilterOptionHeaderType.a aVar2 = FilterOptionHeaderType.Companion;
        String b = aVar2.b(preType);
        String str = "";
        if (b == null) {
            b = "";
        }
        String b2 = aVar2.b(filterOptionHeaderType);
        if (b2 != null) {
            str = b2;
        }
        rVar.i(c, b, str, this.a.l);
        tl4.l b3 = b();
        if (b3 != null) {
            b3.x(preType, filterOptionHeaderType);
        }
    }

    public final void h(int i, boolean z) {
        Integer num;
        Integer num2;
        List filterNotNull;
        Integer num3;
        this.g = i;
        tl4.l d = d(i);
        if (d != null) {
            d.I(this.a.j);
        }
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        ProfileTab profileTab = this.a.d;
        Integer num4 = null;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        c7 c7Var = (c7) CollectionsKt___CollectionsKt.getOrNull((List) this.d.getValue(), i);
        if (c7Var != null) {
            num2 = c7Var.b;
        } else {
            num2 = null;
        }
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull((Iterable) this.d.getValue());
        rVar.l(num, num2, filterNotNull, m0.a());
        ProfileTab profileTab2 = this.a.d;
        if (profileTab2 != null) {
            num3 = Integer.valueOf(profileTab2.getValue());
        } else {
            num3 = null;
        }
        c7 c7Var2 = (c7) CollectionsKt___CollectionsKt.getOrNull((List) this.d.getValue(), i);
        if (c7Var2 != null) {
            num4 = c7Var2.b;
        }
        rVar.k(num3, num4, z, m0.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009d, code lost:
    
        if (r7.intValue() != r2) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e0(rl4.c r6, com.dragon.read.rpc.kmp.community.model.c7 r7, com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r8) {
        /*
            r5 = this;
            java.lang.String r0 = "tabParam"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "userProfileTab"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "profileViewModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r5.<init>()
            r5.a = r6
            r5.b = r7
            r5.c = r8
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            r8 = 2
            r0 = 0
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt.mutableStateOf$default(r6, r0, r8, r0)
            r5.d = r6
            androidx.compose.runtime.snapshots.e0 r6 = androidx.compose.runtime.SnapshotStateKt.mutableStateMapOf()
            r5.f = r6
            java.util.List r6 = r7.c
            if (r6 != 0) goto L34
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L34:
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r6)
            boolean r7 = com.dragon.read.kmp.u.c()
            r8 = 1
            r1 = 0
            if (r7 != 0) goto L76
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L49:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L72
            java.lang.Object r2 = r6.next()
            r3 = r2
            com.dragon.read.rpc.kmp.community.model.c7 r3 = (com.dragon.read.rpc.kmp.community.model.c7) r3
            if (r3 == 0) goto L6b
            java.lang.Integer r3 = r3.b
            com.dragon.read.rpc.kmp.community.model.ProfileTab r4 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Album
            int r4 = r4.getValue()
            if (r3 != 0) goto L63
            goto L6b
        L63:
            int r3 = r3.intValue()
            if (r3 != r4) goto L6b
            r3 = 1
            goto L6c
        L6b:
            r3 = 0
        L6c:
            if (r3 != 0) goto L49
            r7.add(r2)
            goto L49
        L72:
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r7)
        L76:
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L80
            r6.add(r0)
            goto Lac
        L80:
            int r7 = r6.size()
            if (r7 > r8) goto Lac
            java.lang.Object r7 = kotlin.collections.CollectionsKt.firstOrNull(r6)
            com.dragon.read.rpc.kmp.community.model.c7 r7 = (com.dragon.read.rpc.kmp.community.model.c7) r7
            if (r7 == 0) goto La0
            java.lang.Integer r7 = r7.b
            com.dragon.read.rpc.kmp.community.model.ProfileTab r2 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Album
            int r2 = r2.getValue()
            if (r7 != 0) goto L99
            goto La0
        L99:
            int r7 = r7.intValue()
            if (r7 != r2) goto La0
            goto La1
        La0:
            r8 = 0
        La1:
            if (r8 == 0) goto Lac
            r5.e()
            r6.clear()
            r6.add(r0)
        Lac:
            androidx.compose.runtime.MutableState<java.util.List<com.dragon.read.rpc.kmp.community.model.c7>> r7 = r5.d
            r7.setValue(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.e0.<init>(rl4.c, com.dragon.read.rpc.kmp.community.model.c7, com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel):void");
    }
}
