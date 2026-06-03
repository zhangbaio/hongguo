package ms4;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.pages.bookmall.model.ItemDataModel;
import com.dragon.read.util.BookUtils;
import com.dragon.read.util.UiConfigSetter;
import kotlin.jvm.internal.Intrinsics;
import ls4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements com.dragon.read.multigenre.factory.a {
    public static final int c;
    public final Object a;
    private final Integer b;

    static {
        Covode.recordClassIndex(612384);
        c = 8;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return new c.a(this.b);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_FINISH, 99.0f, CoverExtendViewExclusiveZone.TOP_RIGHT);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        Object obj = this.a;
        if (!(obj instanceof ItemDataModel) || !BookUtils.isComicType(((ItemDataModel) obj).getGenreType()) || !((ItemDataModel) this.a).isHighlightCreationStatus() || !TextUtils.equals("完结", BookUtils.getBookCreationStatus(((ItemDataModel) this.a).getCreationStatus()))) {
            return false;
        }
        return true;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ls4.c(context);
    }

    public c(Object obj, Integer num) {
        this.a = obj;
        this.b = num;
    }
}
