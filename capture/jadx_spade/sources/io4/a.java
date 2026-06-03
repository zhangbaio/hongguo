package io4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.ShowType;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.bytedance.kmp.reading.model.VideoInnerNextItem;
import com.bytedance.kmp.reading.model.bj0;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.dl0;
import com.dragon.read.kmp.basenovel.ui.ui.v0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements v0 {
    public static final int i;
    public final bj0 a;
    public ShowType b;
    public int c;
    public VideoInnerNextItem d;
    private boolean e;
    public List<? extends List<Integer>> f;
    public String g;
    public final MutableState<UserRelationType> h;

    static {
        Covode.recordClassIndex(609034);
        i = 8;
    }

    public boolean a() {
        return this.e;
    }

    public final boolean b() {
        if (this.c == 1) {
            return true;
        }
        return false;
    }

    public void d(boolean z) {
        this.e = z;
    }

    public final void e(ShowType showType) {
        Intrinsics.checkNotNullParameter(showType, "<set-?>");
        this.b = showType;
    }

    public a(bj0 ugcUserData) {
        int value;
        dl0 dl0Var;
        Integer num;
        Intrinsics.checkNotNullParameter(ugcUserData, "ugcUserData");
        this.a = ugcUserData;
        this.b = ShowType.RanklistSingleCol;
        UserRelationType.a aVar = UserRelationType.Companion;
        cj0 cj0Var = ugcUserData.a;
        if (cj0Var != null && (dl0Var = cj0Var.e) != null && (num = dl0Var.b) != null) {
            value = num.intValue();
        } else {
            value = UserRelationType.None.getValue();
        }
        this.h = SnapshotStateKt.mutableStateOf$default(aVar.a(value), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public String c(int i2) {
        Object valueOf;
        StringBuilder sb = new StringBuilder();
        cj0 cj0Var = this.a.a;
        if (cj0Var == null || (valueOf = cj0Var.a) == null) {
            valueOf = Integer.valueOf(hashCode());
        }
        sb.append(valueOf);
        sb.append('_');
        sb.append(i2);
        return sb.toString();
    }
}
