package ao4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.util.ToastUtils;
import ip2.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g extends ao4.a {
    static {
        Covode.recordClassIndex(608977);
    }

    @Override // ao4.a
    public boolean a() {
        return hp2.h.a.p();
    }

    @Override // ao4.a
    public void b(un4.e kmpShareContent) {
        boolean z;
        boolean z2;
        List split$default;
        boolean z3;
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        if (kmpShareContent.a != 2) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            return;
        }
        String str = kmpShareContent.e;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            return;
        }
        d.a f = new d.a().e(1).d(str).f(false);
        String str2 = kmpShareContent.c;
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            ArrayList arrayList = new ArrayList();
            split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"#"}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : split$default) {
                if (((String) obj).length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    arrayList2.add(obj);
                }
            }
            arrayList.addAll(arrayList2);
            if (!arrayList.isEmpty()) {
                f.b(arrayList);
            }
        }
        cp2.g.t(cp2.g.a, true, false, f.a(), new a(), (ap2.f) null, 16, (Object) null);
    }

    public static final class a implements ap2.a {
        a() {
        }

        public void a(boolean z, Integer num, String str) {
            if (!z) {
                ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            }
        }
    }
}
