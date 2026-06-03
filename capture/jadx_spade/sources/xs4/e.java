package xs4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.basescale.AppFontScale;
import com.dragon.read.base.basescale.AppScaleManager;
import com.dragon.read.base.depend.NsBaseUtilsDependImpl;
import com.dragon.read.base.depend.NsUiDependImpl;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.util.kotlin.ContextKt;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.util.kotlin.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import xs4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;
    private static final Lazy b;
    private static final Lazy c;
    private static final Lazy d;
    private static final Lazy e;
    public static final int f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(613583);
            int[] iArr = new int[AppFontScale.values().length];
            try {
                iArr[AppFontScale.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppFontScale.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    private e() {
    }

    public static final void E(View rootView, int i) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        H(rootView, i, null, 4, null);
    }

    public static final void K(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        N(rootView, null, null, 6, null);
    }

    public static final void L(View rootView, Set<Integer> skipIds) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(skipIds, "skipIds");
        N(rootView, skipIds, null, 4, null);
    }

    public static final void g(View view, int i, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        i(view, i, z, null, 8, null);
    }

    public static final f o(float f2) {
        return q(f2, false, 2, null);
    }

    public static final f n() {
        return q(0.0f, true, 1, null);
    }

    public static final int A() {
        int i;
        f n = n();
        if (n != null) {
            i = n.j;
        } else {
            i = 390;
        }
        return UIKt.getDp(i);
    }

    public static final boolean B() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static final boolean r() {
        if (n() != null) {
            return true;
        }
        return false;
    }

    public static final boolean s() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public static final int u() {
        f n = n();
        if (n != null) {
            return n.h;
        }
        return 6;
    }

    private final Map<Float, Float> x() {
        return (Map) e.getValue();
    }

    private final Map<Float, Float> y() {
        return (Map) d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j() {
        NsUiDependImpl nsUiDependImpl = NsUiDependImpl.INSTANCE;
        if (nsUiDependImpl.needPadUiCompat() && nsUiDependImpl.enableActivityLandscape()) {
            return true;
        }
        return false;
    }

    public static final boolean t() {
        if (NsUiDependImpl.INSTANCE.enablePadFitPhase2() && n() != null) {
            return true;
        }
        return false;
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Covode.recordClassIndex(613582);
        a = new e();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: xs4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean C;
                C = e.C();
                return Boolean.valueOf(C);
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: xs4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean j;
                j = e.j();
                return Boolean.valueOf(j);
            }
        });
        c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: xs4.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Map l;
                l = e.l();
                return l;
            }
        });
        d = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: xs4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Map k;
                k = e.k();
                return k;
            }
        });
        e = lazy4;
        f = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C() {
        NsUiDependImpl nsUiDependImpl = NsUiDependImpl.INSTANCE;
        if (nsUiDependImpl.needPadUiCompat()) {
            NsBaseUtilsDependImpl nsBaseUtilsDependImpl = NsBaseUtilsDependImpl.INSTANCE;
            if ((nsBaseUtilsDependImpl.isPadDevice() || nsBaseUtilsDependImpl.isFoldDevice()) && (nsUiDependImpl.enablePadFit() || nsUiDependImpl.enableActivityLandscape())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map k() {
        Map map;
        Map<Integer, Integer> a2 = f.v.a();
        ArrayList arrayList = new ArrayList(a2.size());
        for (Map.Entry<Integer, Integer> entry : a2.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            e eVar = a;
            arrayList.add(TuplesKt.to(Float.valueOf(eVar.P(intValue)), Float.valueOf(eVar.P(intValue2))));
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map l() {
        Map map;
        Map<Integer, Integer> b2 = f.v.b();
        ArrayList arrayList = new ArrayList(b2.size());
        for (Map.Entry<Integer, Integer> entry : b2.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            e eVar = a;
            arrayList.add(TuplesKt.to(Float.valueOf(eVar.P(intValue)), Float.valueOf(eVar.P(intValue2))));
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        return map;
    }

    public static final class b implements RecyclerView.OnChildAttachStateChangeListener {
        final /* synthetic */ Set<Integer> a;
        final /* synthetic */ float b;

        public void onChildViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public void onChildViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            e.a.J(view, this.a, this.b);
        }

        b(Set<Integer> set, float f) {
            this.a = set;
            this.b = f;
        }
    }

    private final float P(int i) {
        return ContextUtils.sp2px(AppUtils.context(), i);
    }

    public static final float z(float f2) {
        if (r()) {
            return w(a, f2, null, 2, null);
        }
        return f2;
    }

    public static final class c implements RecyclerView.OnChildAttachStateChangeListener {
        final /* synthetic */ Set<Integer> a;
        final /* synthetic */ Float b;
        final /* synthetic */ boolean c;

        public void onChildViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public void onChildViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            e.a.O(view, this.a, this.b, this.c);
        }

        c(Set<Integer> set, Float f, boolean z) {
            this.a = set;
            this.b = f;
            this.c = z;
        }
    }

    public static final void m(View view) {
        Set<Integer> emptySet;
        Intrinsics.checkNotNullParameter(view, "view");
        if (r()) {
            e eVar = a;
            emptySet = SetsKt__SetsKt.emptySet();
            eVar.O(view, emptySet, null, true);
        }
    }

    private final void D(View view, Set<Integer> set) {
        Float f2;
        if ((-1 != view.getId() && set.contains(Integer.valueOf(view.getId()))) || NsUiDependImpl.INSTANCE.isShortSeriesScalableView(view)) {
            return;
        }
        if (view instanceof TextView) {
            Object tag = view.getTag(2131833123);
            if (tag instanceof Float) {
                f2 = (Float) tag;
            } else {
                f2 = null;
            }
            if (f2 != null) {
                ((TextView) view).setTextSize(0, f2.floatValue());
                view.setTag(2131833123, null);
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                D(childAt, set);
            }
        }
    }

    public static final f p(float f2, boolean z) {
        if (z && !B()) {
            return null;
        }
        if (f2 >= 1366.0f) {
            return f.c.z;
        }
        if (f2 >= 1024.0f) {
            return f.b.z;
        }
        if (f2 >= 960.0f) {
            return f.g.z;
        }
        if (f2 >= 800.0f) {
            return f.C0297f.z;
        }
        if (f2 >= 704.0f) {
            return f.e.z;
        }
        if (f2 < 600.0f) {
            return null;
        }
        return f.d.z;
    }

    private final float v(float f2, Float f3) {
        int i;
        Float f4;
        if (f3 != null) {
            return f3.floatValue() * f2;
        }
        AppFontScale curAppFontScale = AppScaleManager.inst().getCurAppFontScale();
        if (curAppFontScale == null) {
            i = -1;
        } else {
            i = a.a[curAppFontScale.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                f4 = null;
            } else {
                f4 = x().get(Float.valueOf(f2));
            }
        } else {
            f4 = y().get(Float.valueOf(f2));
        }
        if (f4 != null) {
            return f4.floatValue();
        }
        return f2 * 1.2f;
    }

    public static final void F(View rootView, int i, Float f2) {
        Set of;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        of = SetsKt__SetsJVMKt.setOf(Integer.valueOf(i));
        G(rootView, of, f2);
    }

    public static final void G(View rootView, Set<Integer> targetIds, Float f2) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(targetIds, "targetIds");
        if (targetIds.isEmpty()) {
            return;
        }
        if (f2 == null) {
            f n = n();
            if (n != null) {
                f2 = Float.valueOf(n.f);
            } else {
                f2 = null;
            }
            if (f2 == null) {
                return;
            }
        }
        a.J(rootView, targetIds, f2.floatValue());
    }

    public static final void M(View rootView, Set<Integer> skipIds, Float f2) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(skipIds, "skipIds");
        if (!B()) {
            return;
        }
        boolean r = r();
        if (NsBaseUtilsDependImpl.INSTANCE.isFoldDevice() && !r) {
            a.D(rootView, skipIds);
        } else if (r || f2 != null) {
            a.O(rootView, skipIds, f2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(View view, Set<Integer> set, float f2) {
        Boolean bool;
        if (NsUiDependImpl.INSTANCE.isShortSeriesScalableView(view)) {
            return;
        }
        if (view.getId() != -1 && set.contains(Integer.valueOf(view.getId()))) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            Object tag = view.getTag(2131833119);
            if (tag instanceof Boolean) {
                bool = (Boolean) tag;
            } else {
                bool = null;
            }
            if (m.d(bool)) {
                return;
            }
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (i > 0) {
                layoutParams.width = (int) (i * f2);
            }
            if (i2 > 0) {
                layoutParams.height = (int) (i2 * f2);
            }
            view.setTag(2131833119, Boolean.TRUE);
            view.setLayoutParams(layoutParams);
            return;
        }
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).addOnChildAttachStateChangeListener(new b(set, f2));
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                J(childAt, set, f2);
            }
        }
    }

    public static /* synthetic */ f q(float f2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = com.dragon.read.util.kotlin.f.d(ContextKt.getCurrentContext());
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return p(f2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(View view, Set<Integer> set, Float f2, boolean z) {
        Float f3;
        float textSize;
        if ((-1 != view.getId() && set.contains(Integer.valueOf(view.getId()))) || NsUiDependImpl.INSTANCE.isShortSeriesScalableView(view)) {
            return;
        }
        if (view instanceof TextView) {
            Object tag = view.getTag(2131833123);
            if (tag instanceof Float) {
                f3 = (Float) tag;
            } else {
                f3 = null;
            }
            if (f3 != null && !z) {
                return;
            }
            if (f3 != null) {
                textSize = f3.floatValue();
            } else {
                textSize = ((TextView) view).getTextSize();
            }
            ((TextView) view).setTextSize(0, v(textSize, f2));
            view.setTag(2131833123, Float.valueOf(textSize));
            return;
        }
        if (view instanceof RecyclerView) {
            Object tag2 = view.getTag(2131833121);
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(tag2, bool)) {
                ((RecyclerView) view).addOnChildAttachStateChangeListener(new c(set, f2, z));
                view.setTag(2131833121, bool);
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                O(childAt, set, f2, z);
            }
        }
    }

    public static final void h(View view, int i, boolean z, Float f2) {
        Integer num;
        int i2;
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (f2 == null) {
            f n = n();
            if (n != null) {
                f2 = Float.valueOf(n.a);
            } else {
                f2 = null;
            }
        }
        if (f2 != null && f2.floatValue() > 1.0f) {
            int dp2px = ContextUtils.dp2px(view.getContext(), (f2.floatValue() - 1) * i);
            Object tag = view.getTag(2131833120);
            if (tag instanceof Integer) {
                num = (Integer) tag;
            } else {
                num = null;
            }
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            if (dp2px > 0 && dp2px != i2) {
                if (z) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    }
                    if (marginLayoutParams == null) {
                        return;
                    }
                    UIKt.updateMargin$default(view, Integer.valueOf(marginLayoutParams.getMarginStart() + dp2px), (Integer) null, Integer.valueOf(marginLayoutParams.getMarginEnd() + dp2px), (Integer) null, 10, (Object) null);
                } else {
                    view.setPadding(view.getPaddingStart() + dp2px, view.getPaddingTop(), view.getPaddingEnd() + dp2px, view.getPaddingBottom());
                }
                view.setTag(2131833120, Integer.valueOf(dp2px));
            }
        }
    }

    public static /* synthetic */ void H(View view, int i, Float f2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f2 = null;
        }
        F(view, i, f2);
    }

    public static /* synthetic */ void I(View view, Set set, Float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = null;
        }
        G(view, set, f2);
    }

    static /* synthetic */ float w(e eVar, float f2, Float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f3 = null;
        }
        return eVar.v(f2, f3);
    }

    public static /* synthetic */ void N(View view, Set set, Float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt__SetsKt.emptySet();
        }
        if ((i & 4) != 0) {
            f2 = null;
        }
        M(view, set, f2);
    }

    public static /* synthetic */ void i(View view, int i, boolean z, Float f2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            f2 = null;
        }
        h(view, i, z, f2);
    }
}
