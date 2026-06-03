package com.dragon.read.kmp.mine.model;

import android.content.Context;
import androidx.compose.material.n2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.Gender;
import com.bytedance.kmp.reading.model.ya0;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.mine.profile.ProfileItemType;
import com.dragon.read.kmp.mine.profile.VerifyStatus;
import com.dragon.read.kmp.mine.profile.a0;
import com.dragon.read.kmp.mine.profile.c2;
import com.dragon.read.kmp.mine.profile.y;
import com.dragon.read.kmp.mine.profile.z;
import com.dragon.read.kmp.n;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import jg4.s;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ChangeProfilePageViewModel extends ViewModel {
    public static final a s;
    public static final int t;
    private final a0 a;
    public y b;
    public z c;
    private final Lazy d;
    public final MutableState<Boolean> e;
    public CoroutineScope f;
    public boolean g;
    public final MutableState<Integer> h;
    public boolean i;
    public final MutableState<Boolean> j;
    public int k;
    public int l;
    private n2 m;
    private Gender n;
    public boolean o;
    public MutableState<Boolean> p;
    private final Map<String, Boolean> q;
    private final c r;

    public static final class a {
        static {
            Covode.recordClassIndex(607695);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(607696);
            int[] iArr = new int[Gender.values().length];
            try {
                iArr[Gender.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Gender.FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[ProfileItemType.values().length];
            try {
                iArr2[ProfileItemType.GENDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ProfileItemType.AVATAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProfileItemType.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(607694);
        s = new a(null);
        t = 8;
    }

    public final void h1() {
        this.g = false;
    }

    public final void i1() {
        this.g = true;
    }

    public final boolean N0() {
        return this.b.k();
    }

    public final boolean O0() {
        return this.b.g();
    }

    public final boolean P0() {
        return this.b.b();
    }

    public final boolean a1() {
        return this.b.c();
    }

    public final void d1() {
        this.b.f();
    }

    private final a0 U0() {
        return (a0) this.d.getValue();
    }

    public final boolean Z0() {
        return !Intrinsics.areEqual(this.a, U0());
    }

    public final void c1() {
        this.b.a();
        o1("photo");
    }

    public final void f1() {
        if (sj4.e.a()) {
            s.b(this.r);
        }
    }

    public final void g1() {
        this.e.setValue(Boolean.valueOf(W0().a));
    }

    public final boolean z1() {
        z zVar = this.c;
        if (zVar != null) {
            return zVar.useNewProfileChangePage();
        }
        return false;
    }

    public final boolean S0() {
        Gender gender = this.n;
        if (gender != null && gender != this.a.f.getValue()) {
            return true;
        }
        return false;
    }

    public final String V0() {
        MutableState<String> mutableState;
        String str;
        a0 U0 = U0();
        if (U0 == null || (mutableState = U0.i) == null || (str = (String) mutableState.getValue()) == null) {
            return "";
        }
        return str;
    }

    public final boolean s1() {
        Gender gender = this.n;
        if (gender == null || gender == this.a.f.getValue()) {
            return false;
        }
        return true;
    }

    private final i W0() {
        boolean z;
        String str;
        boolean z2;
        MutableState<String> mutableState;
        Gender gender;
        if (z1() && (gender = this.n) != null && gender != this.a.f.getValue()) {
            com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "getSaveStatus gender changed");
            return new i(true, "");
        }
        if (Intrinsics.areEqual(this.a, U0())) {
            com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "getSaveStatus userInfo hasn't changed");
            return new i(false, "");
        }
        if (((CharSequence) this.a.d.getValue()).length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "getSaveStatus userName is empty");
            return new i(false, "昵称不能为空");
        }
        a0 U0 = U0();
        if (U0 != null && (mutableState = U0.i) != null) {
            str = (String) mutableState.getValue();
        } else {
            str = null;
        }
        if (StringUtilsKt.a(str)) {
            if (((CharSequence) this.a.i.getValue()).length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "getSaveStatus bizUserId is empty");
                return new i(false, ek4.c.b.o5() + "不能为空");
            }
            if (((String) this.a.i.getValue()).length() < 8) {
                com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "getSaveStatus bizUserId's length is less than 8");
                return new i(false, ek4.c.b.o5() + "未满8字符");
            }
        }
        com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "getSaveStatus canSave = true");
        return new i(true, "");
    }

    public static final class c implements jg4.a {
        c() {
        }

        public void a(int i, int i2) {
            if (((Boolean) ChangeProfilePageViewModel.this.j.getValue()).booleanValue()) {
                ChangeProfilePageViewModel.this.j.setValue(Boolean.FALSE);
                com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "onKeyboardClose height = " + i + ", decorViewHeight = " + i2);
                ChangeProfilePageViewModel.this.h.setValue(0);
            }
        }

        public void b(int i, int i2) {
            if (!((Boolean) ChangeProfilePageViewModel.this.j.getValue()).booleanValue()) {
                ChangeProfilePageViewModel.this.j.setValue(Boolean.TRUE);
                b1 b1Var = b1.a;
                int e = b1Var.e(b1Var.s());
                ChangeProfilePageViewModel changeProfilePageViewModel = ChangeProfilePageViewModel.this;
                int e2 = (((changeProfilePageViewModel.k + changeProfilePageViewModel.l) + b1Var.e(24.0f)) - e) - i2;
                com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "onKeyboardShow height = " + i + ", decorViewHeight = " + i2 + ", offset = " + e2);
                if (e2 > 0) {
                    ChangeProfilePageViewModel.this.h.setValue(Integer.valueOf(-e2));
                }
            }
        }
    }

    public final void R0(String str) {
        this.b.d(str);
    }

    public final void t1(y yVar) {
        Intrinsics.checkNotNullParameter(yVar, "<set-?>");
        this.b = yVar;
    }

    public final void w1(String str) {
        this.a.b.setValue(str);
    }

    public final void x1(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        this.n = gender;
    }

    public final void M0(n2 state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.m = state;
    }

    private final String T0(Gender gender) {
        int i = b.a[gender.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return "请选择性别";
            }
            return "女";
        }
        return "男";
    }

    public final void e1(CoroutineScope composeContext) {
        Intrinsics.checkNotNullParameter(composeContext, "composeContext");
        this.f = composeContext;
        if (sj4.e.a()) {
            s.a(this.r);
        }
    }

    public final void l1(ProfileItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        z zVar = this.c;
        if (zVar != null) {
            zVar.a(type.getValue());
        }
    }

    private final String X0(int i) {
        if (i == VerifyStatus.SUCCEED.getValue()) {
            return "yes";
        }
        if (i == VerifyStatus.FAILED.getValue()) {
            return "no";
        }
        if (i == VerifyStatus.REVIEWING.getValue()) {
            return "need_verify";
        }
        return "";
    }

    public final void o1(String updateContent) {
        Intrinsics.checkNotNullParameter(updateContent, "updateContent");
        ym4.a aVar = new ym4.a();
        aVar.g("tab_name", "mine");
        aVar.g("update_content", updateContent);
        o.a.d("click_update_profile", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b1(ya0 ya0Var) {
        if (ya0Var == null) {
            return false;
        }
        Integer num = ya0Var.f;
        if (num != null) {
            int value = VerifyStatus.REVIEWING.getValue();
            if (num != null && num.intValue() == value) {
                return true;
            }
        }
        Integer num2 = ya0Var.g;
        if (num2 != null) {
            int value2 = VerifyStatus.REVIEWING.getValue();
            if (num2 != null && num2.intValue() == value2) {
                return true;
            }
        }
        Integer num3 = ya0Var.h;
        if (num3 != null) {
            int value3 = VerifyStatus.REVIEWING.getValue();
            if (num3 != null && num3.intValue() == value3) {
                return true;
            }
        }
        return false;
    }

    public final boolean Q0(ProfileItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String a2 = wj4.b.a.a(type);
        Boolean bool = this.q.get(a2);
        if (bool == null) {
            gj4.a a3 = gj4.e.a.a("key_profile_verify_fail_tag_show_" + this.a.q);
            if (a3.contains(a2)) {
                bool = Boolean.valueOf(a3.getBoolean(a2, true));
                this.q.put(a2, bool);
            } else {
                bool = Boolean.TRUE;
            }
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 m1(ChangeProfilePageViewModel changeProfilePageViewModel) {
        a0 a2;
        a0 a0Var = changeProfilePageViewModel.a;
        a2 = a0Var.a((r35 & 1) != 0 ? a0Var.a : SnapshotStateKt.mutableStateOf$default(a0Var.a.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 2) != 0 ? a0Var.b : null, (r35 & 4) != 0 ? a0Var.c : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.c.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 8) != 0 ? a0Var.d : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.d.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 16) != 0 ? a0Var.e : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.e.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 32) != 0 ? a0Var.f : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.f.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 64) != 0 ? a0Var.g : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.g.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 128) != 0 ? a0Var.h : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.h.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 256) != 0 ? a0Var.i : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.i.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? a0Var.j : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.j.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 1024) != 0 ? a0Var.k : null, (r35 & 2048) != 0 ? a0Var.l : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.l.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 4096) != 0 ? a0Var.m : null, (r35 & 8192) != 0 ? a0Var.n : SnapshotStateKt.mutableStateOf$default(changeProfilePageViewModel.a.n.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 16384) != 0 ? a0Var.o : null, (r35 & 32768) != 0 ? a0Var.p : null, (r35 & 65536) != 0 ? a0Var.q : null);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(ya0 ya0Var) {
        int value;
        int value2;
        int value3;
        int value4;
        if (ya0Var == null) {
            return;
        }
        Integer num = ya0Var.f;
        if (num != null) {
            value = num.intValue();
        } else {
            value = VerifyStatus.NOT_VERIFY.getValue();
        }
        Integer num2 = ya0Var.g;
        if (num2 != null) {
            value2 = num2.intValue();
        } else {
            value2 = VerifyStatus.NOT_VERIFY.getValue();
        }
        Integer num3 = ya0Var.h;
        if (num3 != null) {
            value3 = num3.intValue();
        } else {
            value3 = VerifyStatus.NOT_VERIFY.getValue();
        }
        Integer num4 = ya0Var.l;
        if (num4 != null) {
            value4 = num4.intValue();
        } else {
            value4 = VerifyStatus.NOT_VERIFY.getValue();
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Integer num5 = ya0Var.f;
        if (num5 != null) {
            int value5 = VerifyStatus.FAILED.getValue();
            if (num5 != null && num5.intValue() == value5) {
                arrayList.add("头像");
            }
        }
        Integer num6 = ya0Var.g;
        if (num6 != null) {
            int value6 = VerifyStatus.FAILED.getValue();
            if (num6 != null && num6.intValue() == value6) {
                arrayList.add("昵称");
            }
        }
        Integer num7 = ya0Var.h;
        if (num7 != null) {
            int value7 = VerifyStatus.FAILED.getValue();
            if (num7 != null && num7.intValue() == value7) {
                arrayList.add("签名");
            }
        }
        Integer num8 = ya0Var.l;
        if (num8 != null) {
            int value8 = VerifyStatus.FAILED.getValue();
            if (num8 != null && num8.intValue() == value8) {
                arrayList.add(ek4.c.b.o5());
            }
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append((char) 12289 + ((String) arrayList.get(i)));
                } else {
                    sb.append((String) arrayList.get(i));
                }
            }
            sb.append("审核未通过，请重新设置");
            kotlinx.coroutines.i.e(this.f, Dispatchers.getMain(), null, new ChangeProfilePageViewModel$toastIfNeed$1(sb, null), 2, null);
            r1(value, value2, value3, value4);
            return;
        }
        kotlinx.coroutines.i.e(this.f, Dispatchers.getMain(), null, new ChangeProfilePageViewModel$toastIfNeed$2(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0104, code lost:
    
        if (r0 != r2) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e4, code lost:
    
        if (r0 != r21.a.f.getValue()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e6, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0219 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x025d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a9  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u1(kotlin.coroutines.Continuation<? super com.dragon.read.kmp.mine.profile.c2> r22) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel.u1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void p1(String str, String str2) {
        ym4.a aVar = new ym4.a();
        aVar.g("edit_element", str);
        aVar.g("edit_content", str2);
        aVar.g("edit_type", "manual");
        o.a.d("edit_profile_info_success", aVar);
    }

    public final void y1(String str, VerifyStatus verifyStatus) {
        Intrinsics.checkNotNullParameter(verifyStatus, "verifyStatus");
        this.a.l.setValue(str);
        this.a.n.setValue(verifyStatus);
    }

    public final void n1(ProfileItemType type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        String a2 = wj4.b.a.a(type);
        this.q.put(a2, Boolean.valueOf(z));
        gj4.e.a.a("key_profile_verify_fail_tag_show_" + this.a.q).edit().putBoolean(a2, false).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(ProfileItemType profileItemType, c2 c2Var) {
        int i = b.b[profileItemType.ordinal()];
        if (i != 1) {
            String str = "";
            if (i != 2) {
                if (i == 3) {
                    String str2 = (String) this.a.l.getValue();
                    if (str2 != null) {
                        str = str2;
                    }
                    p1("背景图", str);
                    z zVar = this.c;
                    if (zVar != null) {
                        zVar.b(c2Var.d);
                        return;
                    }
                    return;
                }
                return;
            }
            String str3 = (String) this.a.a.getValue();
            if (str3 != null) {
                str = str3;
            }
            p1("头像", str);
            return;
        }
        Gender gender = this.n;
        if (gender != null && gender != this.a.f.getValue()) {
            MutableState<Gender> mutableState = this.a.f;
            Gender gender2 = this.n;
            Intrinsics.checkNotNull(gender2);
            mutableState.setValue(gender2);
            Gender gender3 = this.n;
            Intrinsics.checkNotNull(gender3);
            p1("性别", T0(gender3));
        }
    }

    public final void j1(boolean z, ProfileItemType profileItemType) {
        boolean z2;
        Context b2;
        Intrinsics.checkNotNullParameter(profileItemType, "profileItemType");
        i W0 = W0();
        if (!W0.a) {
            com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "onSave canSave = false, toastMsg = " + W0.b);
            if (W0.b.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && (b2 = ig4.f.b()) != null) {
                ig4.g.d(b2, W0.b, (ToastDuration) null, 4, (Object) null);
                return;
            }
            return;
        }
        if (this.b.h() || this.b.i()) {
            return;
        }
        kotlinx.coroutines.i.e(this.f, Dispatchers.getMain(), null, new ChangeProfilePageViewModel$onSave$2(this, z, profileItemType, null), 2, null);
    }

    public ChangeProfilePageViewModel(a0 userInfo, y iDepend, z zVar) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = userInfo;
        this.b = iDepend;
        this.c = zVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.mine.model.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                a0 m1;
                m1 = ChangeProfilePageViewModel.m1(ChangeProfilePageViewModel.this);
                return m1;
            }
        });
        this.d = lazy;
        Boolean bool = Boolean.FALSE;
        this.e = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.f = n.a;
        this.h = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.j = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.p = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.q = new LinkedHashMap();
        this.r = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(int i, int i2, int i3, int i4) {
        ym4.a aVar = new ym4.a();
        aVar.g("type", "toast");
        aVar.g("photo", X0(i));
        aVar.g("nickname", X0(i2));
        aVar.g("character_sign", X0(i3));
        aVar.g("hongguo_id", X0(i4));
        aVar.g("background", "");
        o.a.d("update_profile_notapproved", aVar);
    }

    public static /* synthetic */ void k1(ChangeProfilePageViewModel changeProfilePageViewModel, boolean z, ProfileItemType profileItemType, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            profileItemType = ProfileItemType.NOTHING;
        }
        changeProfilePageViewModel.j1(z, profileItemType);
    }

    private final void q1(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object obj;
        String str;
        Object obj2;
        Object obj3;
        ym4.a aVar = new ym4.a();
        aVar.g("tab_name", "mine");
        String str2 = "yes";
        if (z) {
            obj = "yes";
        } else {
            obj = "no";
        }
        aVar.g("photo", obj);
        if (!z2) {
            str = "no";
        } else {
            int i = b.a[((Gender) this.a.f.getValue()).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    str = "";
                } else {
                    str = "female";
                }
            } else {
                str = "male";
            }
        }
        aVar.g("gender", str);
        if (z3) {
            obj2 = "yes";
        } else {
            obj2 = "no";
        }
        aVar.g("nickname", obj2);
        if (z4) {
            obj3 = "yes";
        } else {
            obj3 = "no";
        }
        aVar.g("character_sign", obj3);
        if (!z5) {
            str2 = "no";
        }
        aVar.g("hongguo_id", str2);
        aVar.g("background", "no");
        o.a.d("save_update_profile", aVar);
    }
}
