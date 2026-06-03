package ms4;

import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import kotlin.jvm.internal.Intrinsics;
import ls4.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h implements com.dragon.read.multigenre.factory.a {
    public final float a;

    static {
        Covode.recordClassIndex(612395);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        return true;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_TEXTURE_LAYER, 110.0f, CoverExtendViewExclusiveZone.NOT_SET);
    }

    @Override // com.dragon.read.multigenre.factory.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public i.b d() {
        return new i.b(new i.a(this.a));
    }

    public h(float f) {
        this.a = f;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ls4.i(context, null, 0, 6, null);
    }
}
