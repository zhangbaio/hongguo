package gk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.qn0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 extends a {
    public static final int f;
    public final jd4.c c;
    public final String d;
    private Boolean e;

    static {
        Covode.recordClassIndex(607827);
        f = 8;
    }

    public final List<e90> b() {
        List<e90> list;
        om0 om0Var = this.c.b;
        if (om0Var == null || (list = om0Var.s0) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public final List<e90> d() {
        List<e90> list;
        om0 om0Var = this.c.b;
        if (om0Var == null || (list = om0Var.t0) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public final qn0 e() {
        om0 om0Var = this.c.b;
        if (om0Var != null) {
            return om0Var.y0;
        }
        return null;
    }

    public final int a() {
        Integer num;
        om0 om0Var = this.c.b;
        if (om0Var != null && (num = om0Var.y) != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean f() {
        if (a() != VideoContentType.UnrealShortPlay.getValue() && a() != VideoContentType.UnrealMotionComic.getValue()) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        Boolean bool = this.e;
        if (bool != null) {
            return bool.booleanValue();
        }
        om0 om0Var = this.c.b;
        if (om0Var != null) {
            return Intrinsics.areEqual(om0Var.U0, Boolean.TRUE);
        }
        return false;
    }

    public final void h(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    public h0(jd4.c videoTabModel) {
        String str;
        Intrinsics.checkNotNullParameter(videoTabModel, "videoTabModel");
        this.c = videoTabModel;
        om0 om0Var = videoTabModel.b;
        this.d = (om0Var == null || (str = om0Var.p) == null) ? "" : str;
    }

    public String c(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        om0 om0Var = this.c.b;
        if (om0Var != null) {
            str = om0Var.p;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append('_');
        sb.append(i);
        return sb.toString();
    }
}
