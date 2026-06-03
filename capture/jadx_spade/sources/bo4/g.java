package bo4;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.CommonErrorView;
import com.dragon.read.widget.CommonLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    static {
        Covode.recordClassIndex(608995);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        e(z, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CommonLayout f(Context it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        CommonLayout createEmptyInstance = CommonLayout.createEmptyInstance(it2);
        createEmptyInstance.setErrorInCenter();
        createEmptyInstance.hideLoadingView();
        createEmptyInstance.setTransparentBackGround();
        return createEmptyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(boolean z, Function0 function0) {
        if (!z && function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(boolean z, CommonLayout commonLayout) {
        if (z) {
            commonLayout.getErrorLayout().setEmptyImageDrawable();
            CommonErrorView errorLayout = commonLayout.getErrorLayout();
            Intrinsics.checkNotNullExpressionValue(errorLayout, "getErrorLayout(...)");
            UIKt.visible(errorLayout);
        } else {
            commonLayout.showError();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final boolean r31, kotlin.jvm.functions.Function0<kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bo4.g.e(boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
