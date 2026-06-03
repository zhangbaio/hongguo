package al4;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.commonlayout.CommonErrorType;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.CommonErrorView;
import com.dragon.read.widget.CommonLayout;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(608034);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(a aVar, int i, Composer composer, int i2) {
        d(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CommonLayout e(Context it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return CommonLayout.createEmptyInstance(it2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(a aVar, CommonLayout commonLayout) {
        View loadingLayout = commonLayout.getLoadingLayout();
        Intrinsics.checkNotNullExpressionValue(loadingLayout, "getLoadingLayout(...)");
        UIKt.gone(loadingLayout);
        commonLayout.setTransparentBackGround();
        commonLayout.getErrorLayout().setTag(aVar.d);
        commonLayout.resetGravityForCustomizeMarginTop();
        CommonErrorType commonErrorType = aVar.g;
        if (commonErrorType == CommonErrorType.DefaultError) {
            commonLayout.showError();
        } else if (commonErrorType == CommonErrorType.Empty) {
            commonLayout.getErrorLayout().setErrorText(aVar.e);
            commonLayout.getErrorLayout().errorIv.setAlpha(aVar.f);
            commonLayout.getErrorLayout().setEmptyImageDrawable();
            CommonErrorView errorLayout = commonLayout.getErrorLayout();
            Intrinsics.checkNotNullExpressionValue(errorLayout, "getErrorLayout(...)");
            UIKt.visible(errorLayout);
        } else {
            commonLayout.getErrorLayout().setErrorText(aVar.e);
            commonLayout.getErrorLayout().errorIv.setAlpha(aVar.f);
            Pair<String, String> pair = aVar.a;
            if (pair != null) {
                commonLayout.setErrorLottieUrl(pair);
            } else {
                commonLayout.setErrorStaticImageUrl(aVar.b);
            }
        }
        return Unit.INSTANCE;
    }

    public static final void d(final a layoutState, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(layoutState, "layoutState");
        Composer startRestartGroup = composer.startRestartGroup(-219876235);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(layoutState)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-219876235, i2, -1, "com.dragon.read.kmp.profile.commonlayout.CommonErrorLayout (CommonLayout.android.kt:18)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: al4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        CommonLayout e;
                        e = e.e((Context) obj);
                        return e;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(layoutState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: al4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit f2;
                        f2 = e.f(a.this, (CommonLayout) obj);
                        return f2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            AndroidView_androidKt.a(function1, f, (Function1) rememberedValue2, startRestartGroup, 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: al4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = e.g(a.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }
}
