package ms4;

import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.util.UiConfigSetter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements com.dragon.read.multigenre.factory.a {
    public static final int b;
    public ls4.d a;

    static {
        Covode.recordClassIndex(612383);
        b = 8;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        return true;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return null;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_DARK_MASK, 100.0f, CoverExtendViewExclusiveZone.NOT_SET);
    }

    public final ls4.d f() {
        ls4.d dVar = this.a;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extendViewImpl");
        return null;
    }

    public final void g(ls4.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.a = dVar;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.a == null) {
            g(new ls4.d(context, null, 0, 6, null));
        }
        return f();
    }
}
