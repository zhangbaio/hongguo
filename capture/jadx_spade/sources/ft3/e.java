package ft3;

import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;
    private static final Lazy b;
    private static final Lazy c;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c() {
        if (a.e().a == 0) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final pq3.f e() {
        return (pq3.f) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final pq3.f f() {
        return ((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).S0();
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Covode.recordClassIndex(599204);
        a = new e();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ft3.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                pq3.f f;
                f = e.f();
                return f;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ft3.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean c2;
                c2 = e.c();
                return Boolean.valueOf(c2);
            }
        });
        c = lazy2;
    }

    public final void h(TextView[] textViewArr) {
        Unit unit;
        if (textViewArr != null && !d()) {
            ps3.a aVar = e().b;
            ArrayList arrayList = new ArrayList(textViewArr.length);
            for (TextView textView : textViewArr) {
                if (textView != null) {
                    a.g(textView, aVar);
                    textView.postInvalidate();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                arrayList.add(unit);
            }
        }
    }

    public final void i(TextView[] textViewArr) {
        Unit unit;
        if (textViewArr != null) {
            ArrayList arrayList = new ArrayList(textViewArr.length);
            for (TextView textView : textViewArr) {
                if (textView != null) {
                    textView.getPaint().clearShadowLayer();
                    textView.postInvalidate();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                arrayList.add(unit);
            }
        }
    }

    private final void g(TextView textView, ps3.a aVar) {
        if (textView != null) {
            textView.setShadowLayer(aVar.a, aVar.b, aVar.c, aVar.d);
        }
        if (textView != null) {
            textView.postInvalidate();
        }
    }
}
