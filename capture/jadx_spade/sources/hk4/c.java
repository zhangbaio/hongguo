package hk4;

import a0.h;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.x;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(607851);
    }

    public static final Modifier b(Modifier modifier, final a model, final Function0<Unit> onFirstVisible) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(onFirstVisible, "onFirstVisible");
        if (!model.isShown()) {
            return d1.a(modifier, new Function1() { // from class: hk4.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit c;
                    c = c.c(a.this, onFirstVisible, (w) obj);
                    return c;
                }
            });
        }
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(a aVar, Function0 function0, w coordinates) {
        h hVar;
        boolean z;
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (aVar.isShown()) {
            return Unit.INSTANCE;
        }
        h c = x.c(coordinates);
        w W = coordinates.W();
        if (W != null) {
            hVar = x.c(W);
        } else {
            hVar = null;
        }
        if (hVar != null) {
            z = hVar.r(c);
        } else {
            z = false;
        }
        if (z) {
            aVar.setShown(true);
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
