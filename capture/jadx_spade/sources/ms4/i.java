package ms4;

import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.pages.bookmall.model.ItemDataModel;
import com.dragon.read.rpc.model.ApiBookInfo;
import com.dragon.read.util.BookUtils;
import com.dragon.read.util.UiConfigSetter;
import com.ss.android.excitingvideo.utils.extensions.ExtensionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import ls4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i implements com.dragon.read.multigenre.factory.a {
    public static final int b;
    public final Object a;

    static {
        Covode.recordClassIndex(612396);
        b = 8;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_UPDATE, 121.0f, CoverExtendViewExclusiveZone.TOP_RIGHT);
    }

    private final String f() {
        Object obj = this.a;
        if (obj instanceof ItemDataModel) {
            return ((ItemDataModel) obj).getUpdateTag();
        }
        if (obj instanceof ApiBookInfo) {
            return ((ApiBookInfo) obj).updateTag;
        }
        return null;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        String str;
        String f = f();
        if (f == null) {
            return null;
        }
        if (!StringsKt__StringsKt.isBlank(f)) {
            str = f;
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return new e.b(new e.a(str, 0, 0, null, null, 30, null));
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        Object obj = this.a;
        if (obj instanceof ItemDataModel) {
            if (BookUtils.isComicType(((ItemDataModel) obj).getGenreType()) && ((ItemDataModel) this.a).getHighlightUpdateTag() && ExtensionsKt.isNotNullOrEmpty(((ItemDataModel) this.a).getUpdateTag())) {
                return true;
            }
        } else if ((obj instanceof ApiBookInfo) && BookUtils.isComicType(((ApiBookInfo) obj).genreType)) {
            Object obj2 = this.a;
            if (((ApiBookInfo) obj2).highlightUpdateTag && ExtensionsKt.isNotNullOrEmpty(((ApiBookInfo) obj2).updateTag)) {
                return true;
            }
        }
        return false;
    }

    public i(Object obj) {
        this.a = obj;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ls4.e(context, null, 0, 6, null);
    }
}
