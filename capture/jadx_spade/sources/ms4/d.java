package ms4;

import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.util.UiConfigSetter;
import kotlin.jvm.internal.Intrinsics;
import ls4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements com.dragon.read.multigenre.factory.a {
    private final float a;
    private final int b;
    private final int c;
    private final boolean d;

    static {
        Covode.recordClassIndex(612389);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        return true;
    }

    private final b.a f() {
        return new b.a(this.a, this.b, this.c, this.d);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_SCORE, 124.0f, CoverExtendViewExclusiveZone.BOTTOM_LEFT);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return new b.C0241b(f());
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ls4.b(context, null, 0, 6, null);
    }

    public d(float f, int i, int i2, boolean z) {
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = z;
    }
}
