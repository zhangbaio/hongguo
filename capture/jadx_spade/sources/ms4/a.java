package ms4;

import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.api.bookapi.BookInfo;
import com.dragon.read.app.App;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.pages.bookmall.model.ItemDataModel;
import com.dragon.read.rpc.model.ApiBookInfo;
import com.dragon.read.util.BookUtils;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.ResourcesKt;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.jvm.internal.Intrinsics;
import ls4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements com.dragon.read.multigenre.factory.a {
    public static final int b;
    public final Object a;

    static {
        Covode.recordClassIndex(612382);
        b = 8;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_COMIC_HINT, 122.0f, CoverExtendViewExclusiveZone.TOP_RIGHT);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        Object obj = this.a;
        if (obj instanceof ItemDataModel) {
            return BookUtils.isComicType(((ItemDataModel) obj).getGenreType());
        }
        if (obj instanceof ApiBookInfo) {
            return BookUtils.isComicType(((ApiBookInfo) obj).genreType);
        }
        if (obj instanceof BookInfo) {
            return BookUtils.isComicType(((BookInfo) obj).genreType);
        }
        return false;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        String string = App.context().getString(2131102338);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new e.b(new e.a(string, ResourcesKt.getColor(2131559813), UIKt.addAlpha2Color(ResourcesKt.getColor(2131559692), 0.8f), null, null, 24, null));
    }

    public a(Object obj) {
        this.a = obj;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ls4.e(context, null, 0, 6, null);
    }
}
