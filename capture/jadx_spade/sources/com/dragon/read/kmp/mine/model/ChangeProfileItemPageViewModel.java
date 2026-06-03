package com.dragon.read.kmp.mine.model;

import android.content.Context;
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
import com.dragon.read.kmp.mine.profile.x;
import com.dragon.read.kmp.n;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import jg4.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ChangeProfileItemPageViewModel extends ViewModel {
    public static final a n;
    public static final int o;
    public final a0 a;
    private final ProfileItemType b;
    private final x c;
    private a0 d;
    public final MutableState<Boolean> e;
    public boolean f;
    public final MutableState<Boolean> g;
    public int h;
    public int i;
    public final MutableState<Integer> j;
    public boolean k;
    public CoroutineScope l;
    private final c m;

    public static final class a {
        static {
            Covode.recordClassIndex(607691);
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
            Covode.recordClassIndex(607692);
            int[] iArr = new int[ProfileItemType.values().length];
            try {
                iArr[ProfileItemType.NICKNAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileItemType.SIGNATURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileItemType.ACCOUNTID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[Gender.values().length];
            try {
                iArr2[Gender.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Gender.FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(607690);
        n = new a(null);
        o = 8;
    }

    public final void U0() {
        this.f = false;
    }

    public final void V0() {
        this.f = true;
    }

    public final ProfileItemType getType() {
        return this.b;
    }

    public final boolean Q0() {
        return !Intrinsics.areEqual(this.a, this.d);
    }

    public final void S0() {
        if (sj4.e.a()) {
            s.b(this.m);
        }
    }

    public final void T0() {
        this.e.setValue(Boolean.valueOf(O0().a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String L0() {
        int i;
        ProfileItemType profileItemType = this.b;
        if (profileItemType == null) {
            i = -1;
        } else {
            i = b.a[profileItemType.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return (String) this.a.i.getValue();
            }
            return (String) this.a.g.getValue();
        }
        return (String) this.a.d.getValue();
    }

    public final String M0() {
        int i;
        ProfileItemType profileItemType = this.b;
        if (profileItemType == null) {
            return "";
        }
        if (profileItemType == null) {
            i = -1;
        } else {
            i = b.a[profileItemType.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return "";
                }
                return ek4.c.b.o5();
            }
            return "个人签名";
        }
        return "昵称";
    }

    public final void W0() {
        boolean z;
        Context b2;
        i O0 = O0();
        if (!O0.a) {
            com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "onSave canSave = false, toastMsg = " + O0.b);
            if (O0.b.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && (b2 = ig4.f.b()) != null) {
                ig4.g.d(b2, O0.b, (ToastDuration) null, 4, (Object) null);
                return;
            }
            return;
        }
        kotlinx.coroutines.i.e(this.l, Dispatchers.getMain(), null, new ChangeProfileItemPageViewModel$onSave$2(this, null), 2, null);
    }

    private final i O0() {
        boolean z;
        String str;
        boolean z2;
        MutableState<String> mutableState;
        if (Intrinsics.areEqual(this.a, this.d)) {
            com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "getSaveStatus userInfo hasn't changed");
            return new i(false, "");
        }
        if (((CharSequence) this.a.d.getValue()).length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "getSaveStatus userName is empty");
            return new i(false, "昵称不能为空");
        }
        a0 a0Var = this.d;
        if (a0Var != null && (mutableState = a0Var.i) != null) {
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
                com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "getSaveStatus bizUserId is empty");
                return new i(false, ek4.c.b.o5() + "不能为空");
            }
            if (((String) this.a.i.getValue()).length() < 8) {
                com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "getSaveStatus bizUserId's length is less than 8");
                return new i(false, ek4.c.b.o5() + "未满8字符");
            }
        }
        com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "getSaveStatus canSave = true");
        return new i(true, "");
    }

    public static final class c implements jg4.a {
        c() {
        }

        public void a(int i, int i2) {
            if (((Boolean) ChangeProfileItemPageViewModel.this.g.getValue()).booleanValue()) {
                ChangeProfileItemPageViewModel.this.g.setValue(Boolean.FALSE);
                com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "onKeyboardClose height = " + i + ", decorViewHeight = " + i2);
                ChangeProfileItemPageViewModel.this.j.setValue(0);
            }
        }

        public void b(int i, int i2) {
            if (!((Boolean) ChangeProfileItemPageViewModel.this.g.getValue()).booleanValue()) {
                ChangeProfileItemPageViewModel.this.g.setValue(Boolean.TRUE);
                b1 b1Var = b1.a;
                int e = b1Var.e(b1Var.s());
                ChangeProfileItemPageViewModel changeProfileItemPageViewModel = ChangeProfileItemPageViewModel.this;
                int e2 = (((changeProfileItemPageViewModel.h + changeProfileItemPageViewModel.i) + b1Var.e(24.0f)) - e) - i2;
                com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "onKeyboardShow height = " + i + ", decorViewHeight = " + i2 + ", offset = " + e2);
                if (e2 > 0) {
                    ChangeProfileItemPageViewModel.this.j.setValue(Integer.valueOf(-e2));
                }
            }
        }
    }

    private final String P0(int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(ProfileItemType profileItemType) {
        gj4.e.a.a("key_profile_verify_fail_tag_show_" + this.a.q).edit().putBoolean(wj4.b.a.a(profileItemType), true).apply();
    }

    public final void Y0(String updateContent) {
        Intrinsics.checkNotNullParameter(updateContent, "updateContent");
        ym4.a aVar = new ym4.a();
        aVar.g("tab_name", "mine");
        aVar.g("update_content", updateContent);
        o.a.d("click_update_profile", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int N0(ya0 ya0Var) {
        int i;
        Integer num;
        Integer num2;
        Integer num3;
        ProfileItemType profileItemType = this.b;
        if (profileItemType == null) {
            return VerifyStatus.NOT_VERIFY.getValue();
        }
        if (profileItemType == null) {
            i = -1;
        } else {
            i = b.a[profileItemType.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return VerifyStatus.NOT_VERIFY.getValue();
                }
                if (ya0Var != null && (num3 = ya0Var.l) != null) {
                    return num3.intValue();
                }
                return VerifyStatus.NOT_VERIFY.getValue();
            }
            if (ya0Var != null && (num2 = ya0Var.h) != null) {
                return num2.intValue();
            }
            return VerifyStatus.NOT_VERIFY.getValue();
        }
        if (ya0Var != null && (num = ya0Var.g) != null) {
            return num.intValue();
        }
        return VerifyStatus.NOT_VERIFY.getValue();
    }

    public final void R0(CoroutineScope composeContext) {
        a0 a2;
        Intrinsics.checkNotNullParameter(composeContext, "composeContext");
        this.l = composeContext;
        if (this.d == null) {
            a0 a0Var = this.a;
            a2 = a0Var.a((r35 & 1) != 0 ? a0Var.a : SnapshotStateKt.mutableStateOf$default(a0Var.a.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 2) != 0 ? a0Var.b : null, (r35 & 4) != 0 ? a0Var.c : SnapshotStateKt.mutableStateOf$default(this.a.c.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 8) != 0 ? a0Var.d : SnapshotStateKt.mutableStateOf$default(this.a.d.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 16) != 0 ? a0Var.e : SnapshotStateKt.mutableStateOf$default(this.a.e.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 32) != 0 ? a0Var.f : SnapshotStateKt.mutableStateOf$default(this.a.f.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 64) != 0 ? a0Var.g : SnapshotStateKt.mutableStateOf$default(this.a.g.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 128) != 0 ? a0Var.h : SnapshotStateKt.mutableStateOf$default(this.a.h.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 256) != 0 ? a0Var.i : SnapshotStateKt.mutableStateOf$default(this.a.i.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? a0Var.j : SnapshotStateKt.mutableStateOf$default(this.a.j.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 1024) != 0 ? a0Var.k : null, (r35 & 2048) != 0 ? a0Var.l : SnapshotStateKt.mutableStateOf$default(this.a.l.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 4096) != 0 ? a0Var.m : null, (r35 & 8192) != 0 ? a0Var.n : SnapshotStateKt.mutableStateOf$default(this.a.n.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null), (r35 & 16384) != 0 ? a0Var.o : null, (r35 & 32768) != 0 ? a0Var.p : null, (r35 & 65536) != 0 ? a0Var.q : null);
            this.d = a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(ya0 ya0Var) {
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
            kotlinx.coroutines.i.e(this.l, Dispatchers.getMain(), null, new ChangeProfileItemPageViewModel$toastIfNeed$1(sb, null), 2, null);
            a1(value, value2, value3, value4);
            return;
        }
        kotlinx.coroutines.i.e(this.l, Dispatchers.getMain(), null, new ChangeProfileItemPageViewModel$toastIfNeed$2(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0225 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b1(kotlin.coroutines.Continuation<? super com.dragon.read.kmp.mine.profile.b2> r22) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel.b1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public ChangeProfileItemPageViewModel(a0 userInfo, ProfileItemType profileItemType, x iDepend) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = userInfo;
        this.b = profileItemType;
        this.c = iDepend;
        Boolean bool = Boolean.FALSE;
        this.e = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.g = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.j = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.l = n.a;
        this.m = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(int i, int i2, int i3, int i4) {
        ym4.a aVar = new ym4.a();
        aVar.g("type", "toast");
        aVar.g("photo", P0(i));
        aVar.g("nickname", P0(i2));
        aVar.g("character_sign", P0(i3));
        aVar.g("hongguo_id", P0(i4));
        aVar.g("background", "");
        o.a.d("update_profile_notapproved", aVar);
    }

    private final void Z0(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
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
            int i = b.b[((Gender) this.a.f.getValue()).ordinal()];
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
