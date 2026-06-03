package ms4;

import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.util.UiConfigSetter;
import kotlin.jvm.internal.Intrinsics;
import ls4.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements com.dragon.read.multigenre.factory.a {
    static {
        Covode.recordClassIndex(612390);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        return true;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_SHADOW_DOWN, 70.0f, CoverExtendViewExclusiveZone.NOT_SET);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return new h.b(new h.a(2130841062, 0.062015504f));
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ls4.h(context, null, 0, 6, null);
    }
}
