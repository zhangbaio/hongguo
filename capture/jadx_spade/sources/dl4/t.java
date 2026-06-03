package dl4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UgcCreatorType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.tl0;
import com.dragon.read.kmp.profile.data.SeriesProfileType;
import com.dragon.read.kmp.utils.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public static final int c;
    private final List<SeriesProfileType> a = new ArrayList();
    private cj0 b;

    static {
        Covode.recordClassIndex(608082);
        c = 8;
    }

    public final boolean h() {
        return !this.a.isEmpty();
    }

    private final boolean f() {
        long j;
        ok0 ok0Var;
        Long l;
        cj0 cj0Var = this.b;
        if (cj0Var != null && (ok0Var = cj0Var.b) != null && (l = ok0Var.l) != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        if (j > 0) {
            return true;
        }
        return false;
    }

    private final boolean g() {
        String str;
        Map map;
        cj0 cj0Var = this.b;
        if (cj0Var != null && (map = cj0Var.f) != null) {
            str = (String) map.get("brand_id");
        } else {
            str = null;
        }
        if (i0.a.f(str, 0L) > 0) {
            return true;
        }
        return false;
    }

    public final String b() {
        if (this.a.isEmpty()) {
            return SeriesProfileType.USER.getValue();
        }
        return CollectionsKt___CollectionsKt.joinToString$default(this.a, "/", null, null, 0, null, new Function1() { // from class: dl4.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence c2;
                c2 = t.c((SeriesProfileType) obj);
                return c2;
            }
        }, 30, null);
    }

    private final void d() {
        tl0 tl0Var;
        List list;
        cj0 cj0Var = this.b;
        if (cj0Var != null && (tl0Var = cj0Var.d) != null && (list = tl0Var.q) != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue = ((Number) it2.next()).intValue();
                if (intValue == UgcCreatorType.Brand.getValue()) {
                    this.a.add(SeriesProfileType.MCN);
                } else if (intValue == UgcCreatorType.Actor.getValue()) {
                    this.a.add(SeriesProfileType.ACTOR);
                } else if (intValue == UgcCreatorType.Writer.getValue()) {
                    this.a.add(SeriesProfileType.SCREENWRITER);
                } else if (intValue == UgcCreatorType.Director.getValue()) {
                    this.a.add(SeriesProfileType.DIRECTOR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence c(SeriesProfileType it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.getValue();
    }

    public final void e(cj0 cj0Var) {
        this.b = cj0Var;
        this.a.clear();
        d();
        if (this.a.isEmpty()) {
            if (g()) {
                this.a.add(SeriesProfileType.MCN);
            }
            if (f()) {
                this.a.add(SeriesProfileType.ACTOR);
            }
        }
    }
}
