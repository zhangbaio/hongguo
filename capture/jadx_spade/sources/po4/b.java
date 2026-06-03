package po4;

import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.RankListStructStyle;
import com.bytedance.kmp.reading.model.SelectorDisplayStyle;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.multi.rpc.exception.KmpRpcException;
import com.dragon.read.kmp.base.http.exception.ErrorCodeException;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.shortvideo.distribution.infinite.d;
import com.dragon.read.kmp.shortvideo.distribution.infinite.h;
import com.dragon.read.kmp.utils.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    private static final float a;

    public static final float d() {
        return a;
    }

    static {
        Covode.recordClassIndex(609108);
        a = i.g(44);
    }

    public static final boolean i() {
        b1 b1Var = b1.a;
        if (b1Var.p() <= b1Var.e(320.0f)) {
            return true;
        }
        return false;
    }

    public static final boolean h(int i) {
        if (i == RankListStructStyle.NonCard.getValue()) {
            return true;
        }
        return false;
    }

    public static final boolean e(int i) {
        if (i != SelectorDisplayStyle.ranklist_v1.getValue() && i != SelectorDisplayStyle.ranklist_v3.getValue()) {
            return false;
        }
        return true;
    }

    public static final boolean f(int i) {
        if (i != SelectorDisplayStyle.ranklist_v2.getValue() && i != SelectorDisplayStyle.ranklist_v1.getValue()) {
            return false;
        }
        return true;
    }

    public static final int c(Throwable th) {
        Integer num;
        if (th == null) {
            return 0;
        }
        if (th instanceof KmpRpcException) {
            num = ((KmpRpcException) th).getErrorCode();
        } else if (th instanceof ErrorCodeException) {
            num = Integer.valueOf(((ErrorCodeException) th).getCode());
        } else {
            num = 0;
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static final boolean g(io4.b bVar) {
        Integer num;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        d g = h.g(bVar.p);
        if (g != null) {
            num = g.d;
        } else {
            num = null;
        }
        if (num != null) {
            return h(num.intValue());
        }
        Integer num2 = bVar.p.d;
        if (num2 != null) {
            return h(num2.intValue());
        }
        return f(bVar.n);
    }

    public static final List<l0> a(p90 p90Var) {
        boolean z;
        Intrinsics.checkNotNullParameter(p90Var, "<this>");
        List list = p90Var.t;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z && list.size() > 1) {
            long e = j.e((String) list.get(0), n0.d(4278214518L));
            long e2 = j.e((String) list.get(1), n0.d(4278190080L));
            arrayList.add(l0.j(e));
            arrayList.add(l0.j(e2));
        }
        return arrayList;
    }

    public static final List<l0> b(p90 p90Var) {
        boolean z;
        Intrinsics.checkNotNullParameter(p90Var, "<this>");
        List list = p90Var.s;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z && list.size() > 1) {
            long e = j.e((String) list.get(0), n0.d(4287163125L));
            long e2 = j.e((String) list.get(1), n0.d(4294967295L));
            arrayList.add(l0.j(e));
            arrayList.add(l0.j(e2));
        }
        return arrayList;
    }
}
