package ns4;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.ui.skin.IViewThemeObserver;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.UIKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(612415);
    }

    private static final LogHelper k() {
        return g.a;
    }

    private static final UiConfigSetter j() {
        return UiConfigSetter.j.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(FrameLayout frameLayout) {
        x(frameLayout);
    }

    public static final void h(TextView textView) {
        if (textView != null) {
            textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    public static final void x(final FrameLayout frameLayout) {
        IViewThemeObserver iViewThemeObserver;
        Intrinsics.checkNotNullParameter(frameLayout, "<this>");
        if (!ThreadUtils.isMainThread()) {
            ThreadUtils.postInForeground(new Runnable() { // from class: ns4.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.y(frameLayout);
                }
            });
            return;
        }
        k().d("updateExtendViewSkin()", new Object[0]);
        if (frameLayout instanceof IViewThemeObserver) {
            iViewThemeObserver = (IViewThemeObserver) frameLayout;
        } else {
            iViewThemeObserver = null;
        }
        if (iViewThemeObserver != null) {
            iViewThemeObserver.notifyUpdateTheme();
        }
        for (IViewThemeObserver iViewThemeObserver2 : UIKt.getChildren(frameLayout)) {
            if ((iViewThemeObserver2.getTag() instanceof com.dragon.read.multigenre.factory.a) && (iViewThemeObserver2 instanceof IViewThemeObserver)) {
                k().d("书封的ExtendView.onSkinUpdate()", new Object[0]);
                iViewThemeObserver2.notifyUpdateTheme();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(FrameLayout frameLayout, com.dragon.read.multigenre.factory.a aVar) {
        r(frameLayout, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(FrameLayout frameLayout, com.dragon.read.multigenre.factory.a[] aVarArr) {
        m(frameLayout, (com.dragon.read.multigenre.factory.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    private static final void f(final FrameLayout frameLayout, View view) {
        Object obj;
        final com.dragon.read.multigenre.factory.a aVar = null;
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof com.dragon.read.multigenre.factory.a) {
            aVar = (com.dragon.read.multigenre.factory.a) obj;
        }
        if (aVar == null) {
            return;
        }
        Integer num = (Integer) new Function0() { // from class: ns4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Integer g;
                g = f.g(frameLayout, aVar);
                return g;
            }
        }.invoke();
        if (num == null) {
            k().d("没有更高优先级，正常添加", new Object[0]);
            frameLayout.addView(view);
            return;
        }
        frameLayout.addView(view, num.intValue());
        k().d("有更高优先级的扩展View，它的index=" + num + "。添加在它的下面", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer g(FrameLayout frameLayout, com.dragon.read.multigenre.factory.a aVar) {
        com.dragon.read.multigenre.factory.a aVar2;
        js4.a a;
        int i = 0;
        Integer num = null;
        for (Object obj : UIKt.getChildren(frameLayout)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Object tag = ((View) obj).getTag();
            if (tag instanceof com.dragon.read.multigenre.factory.a) {
                aVar2 = (com.dragon.read.multigenre.factory.a) tag;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null && (a = aVar2.a()) != null && a.b > aVar.a().b) {
                num = Integer.valueOf(i);
            }
            i = i2;
        }
        return num;
    }

    private static final Pair<Boolean, View> i(FrameLayout frameLayout, com.dragon.read.multigenre.factory.a aVar) {
        js4.b bVar;
        View view;
        com.dragon.read.multigenre.factory.a aVar2;
        js4.a a;
        Iterator it2 = UIKt.getChildren(frameLayout).iterator();
        do {
            bVar = null;
            if (it2.hasNext()) {
                view = (View) it2.next();
                Object tag = view.getTag();
                if (tag instanceof com.dragon.read.multigenre.factory.a) {
                    aVar2 = (com.dragon.read.multigenre.factory.a) tag;
                } else {
                    aVar2 = null;
                }
                if (aVar2 != null && (a = aVar2.a()) != null) {
                    bVar = a.a;
                }
            } else {
                return new Pair<>(Boolean.FALSE, null);
            }
        } while (!Intrinsics.areEqual(aVar.a().a, bVar));
        return new Pair<>(Boolean.TRUE, view);
    }

    private static final boolean l(FrameLayout frameLayout, com.dragon.read.multigenre.factory.a aVar) {
        com.dragon.read.multigenre.factory.a aVar2;
        js4.a a;
        boolean z;
        if (!ThreadUtils.isMainThread()) {
            if (x10.a.b(frameLayout.getContext())) {
                ToastUtils.showCommonToast("CoverExtendViewHelper不在主线程的未知错误！", 1);
            }
            k().e("hasHigherPriorityExtendViewInSameExclusiveZone(). 不在主线程, return false", new Object[0]);
            return false;
        }
        if (aVar.a().c == CoverExtendViewExclusiveZone.NOT_SET) {
            k().d("hasHigherPriorityExtendViewInSameExclusiveZone(). 此扩展View不属于任何区域，return false", new Object[0]);
            return false;
        }
        Iterator it2 = UIKt.getChildren(frameLayout).iterator();
        while (it2.hasNext()) {
            Object tag = ((View) it2.next()).getTag();
            if (tag instanceof com.dragon.read.multigenre.factory.a) {
                aVar2 = (com.dragon.read.multigenre.factory.a) tag;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null && (a = aVar2.a()) != null) {
                if (a.c == aVar.a().c && a.b > aVar.a().b) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void r(final FrameLayout frameLayout, final com.dragon.read.multigenre.factory.a factory) {
        com.dragon.read.multigenre.factory.a aVar;
        js4.a a;
        Intrinsics.checkNotNullParameter(frameLayout, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (!ThreadUtils.isMainThread()) {
            ThreadUtils.postInForeground(new Runnable() { // from class: ns4.a
                @Override // java.lang.Runnable
                public final void run() {
                    f.s(frameLayout, factory);
                }
            });
            return;
        }
        k().d("removeSameTypeExtendViewIfExist(" + factory + ')', new Object[0]);
        for (View view : UIKt.getChildren(frameLayout)) {
            Object tag = view.getTag();
            js4.b bVar = null;
            if (tag instanceof com.dragon.read.multigenre.factory.a) {
                aVar = (com.dragon.read.multigenre.factory.a) tag;
            } else {
                aVar = null;
            }
            if (aVar != null && (a = aVar.a()) != null) {
                bVar = a.a;
            }
            if (Intrinsics.areEqual(factory.a().a, bVar)) {
                k().d("has same type, remove it.", new Object[0]);
                frameLayout.removeView(view);
            }
        }
    }

    private static final void q(FrameLayout frameLayout, com.dragon.read.multigenre.factory.a aVar) {
        com.dragon.read.multigenre.factory.a aVar2;
        js4.a a;
        boolean z;
        if (!ThreadUtils.isMainThread()) {
            if (x10.a.b(frameLayout.getContext())) {
                ToastUtils.showCommonToast("CoverExtendViewHelper不在主线程的未知错误！", 1);
            }
            k().e("removeLowerPriorityExtendViewInSameExclusiveZoneIfExist(). 不在主线程, return false", new Object[0]);
            return;
        }
        if (aVar.a().c == CoverExtendViewExclusiveZone.NOT_SET) {
            k().d("removeLowerPriorityExtendViewInSameExclusiveZoneIfExist(). 此扩展View不属于任何区域，return false", new Object[0]);
            return;
        }
        k().d("removeLowerPriorityExtendViewInSameExclusiveZoneIfExist(" + aVar + ')', new Object[0]);
        for (View view : UIKt.getChildren(frameLayout)) {
            Object tag = view.getTag();
            if (tag instanceof com.dragon.read.multigenre.factory.a) {
                aVar2 = (com.dragon.read.multigenre.factory.a) tag;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null && (a = aVar2.a()) != null) {
                if (a.c == aVar.a().c && a.b < aVar.a().b) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    k().d("同一独占区域，存在更低优先级，删除之 ", new Object[0]);
                    frameLayout.removeView(view);
                }
            }
        }
    }

    public static final void m(final FrameLayout frameLayout, final com.dragon.read.multigenre.factory.a... factorys) {
        Intrinsics.checkNotNullParameter(frameLayout, "<this>");
        Intrinsics.checkNotNullParameter(factorys, "factorys");
        if (!ThreadUtils.isMainThread()) {
            ThreadUtils.postInForeground(new Runnable() { // from class: ns4.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.n(frameLayout, factorys);
                }
            });
            return;
        }
        for (com.dragon.read.multigenre.factory.a aVar : factorys) {
            k().d("putExtendViewIfNeedElseRemove(" + aVar + ')', new Object[0]);
            if (!aVar.c()) {
                r(frameLayout, aVar);
                k().d("enableExtendView()=false, 不添加扩展View.", new Object[0]);
            } else if (l(frameLayout, aVar)) {
                k().d("同一独占区域内包含更高优先级的扩展View，不添加扩展View", new Object[0]);
            } else {
                Pair<Boolean, View> i = i(frameLayout, aVar);
                boolean booleanValue = i.component1().booleanValue();
                View component2 = i.component2();
                if (booleanValue) {
                    k().d("包含类型:" + aVar.a().a + ", 更新夜间模式、UI, 不添加新的扩展View", new Object[0]);
                    x(frameLayout);
                    j().M(new UiConfigSetter.e[]{aVar.d()}).n(new View[]{component2});
                    g.a(component2, aVar);
                } else {
                    k().i("所有条件都满足，可以出扩展View. factory=" + aVar, new Object[0]);
                    q(frameLayout, aVar);
                    Context context = frameLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    View e = aVar.e(context);
                    j().M(new UiConfigSetter.e[]{aVar.d()}).n(new View[]{e});
                    g.a(e, aVar);
                    e.setTag(aVar);
                    f(frameLayout, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(FrameLayout frameLayout, com.dragon.read.multigenre.factory.a aVar, Function1 function1) {
        o(frameLayout, aVar, function1);
    }

    public static final void o(final FrameLayout frameLayout, final com.dragon.read.multigenre.factory.a factory, final Function1<? super View, Unit> callback) {
        Intrinsics.checkNotNullParameter(frameLayout, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!ThreadUtils.isMainThread()) {
            ThreadUtils.postInForeground(new Runnable() { // from class: ns4.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.p(frameLayout, factory, callback);
                }
            });
            return;
        }
        k().d("putExtendViewIfNeedElseRemove(" + factory + ')', new Object[0]);
        if (!factory.c()) {
            r(frameLayout, factory);
            k().d("enableExtendView()=false, 不添加扩展View.", new Object[0]);
            return;
        }
        if (l(frameLayout, factory)) {
            k().d("同一独占区域内包含更高优先级的扩展View，不添加扩展View", new Object[0]);
            return;
        }
        Pair<Boolean, View> i = i(frameLayout, factory);
        boolean booleanValue = i.component1().booleanValue();
        View component2 = i.component2();
        if (booleanValue) {
            k().d("包含类型:" + factory.a().a + ", 更新夜间模式、UI, 不添加新的扩展View", new Object[0]);
            x(frameLayout);
            j().M(new UiConfigSetter.e[]{factory.d()}).n(new View[]{component2});
            g.a(component2, factory);
            if (component2 != null) {
                callback.invoke(component2);
                return;
            }
            return;
        }
        k().i("所有条件都满足，可以出扩展View. factory=" + factory, new Object[0]);
        q(frameLayout, factory);
        Context context = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View e = factory.e(context);
        j().M(new UiConfigSetter.e[]{factory.d()}).n(new View[]{e});
        g.a(e, factory);
        e.setTag(factory);
        f(frameLayout, e);
        callback.invoke(e);
    }

    public static final void t(TextView textView, float f, float f2, float f3, int i) {
        if (textView != null) {
            textView.setShadowLayer(ContextUtils.dp2pxFloat(App.context(), f), ContextUtils.dp2pxFloat(App.context(), f2), ContextUtils.dp2pxFloat(App.context(), f3), ContextCompat.getColor(App.context(), i));
        }
    }

    public static final void v(TextView textView, float f, float f2, float f3, int i) {
        if (textView != null) {
            textView.setShadowLayer(ContextUtils.dp2pxFloat(App.context(), f), ContextUtils.dp2pxFloat(App.context(), f2), ContextUtils.dp2pxFloat(App.context(), f3), ContextCompat.getColor(App.context(), i));
        }
    }

    public static /* synthetic */ void u(TextView textView, float f, float f2, float f3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = 0.3f;
        }
        if ((i2 & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 8) != 0) {
            i = 2131559417;
        }
        t(textView, f, f2, f3, i);
    }

    public static /* synthetic */ void w(TextView textView, float f, float f2, float f3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = 0.3f;
        }
        if ((i2 & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 8) != 0) {
            i = 2131559417;
        }
        v(textView, f, f2, f3, i);
    }
}
