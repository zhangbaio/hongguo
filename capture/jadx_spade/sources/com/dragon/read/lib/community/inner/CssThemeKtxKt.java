package com.dragon.read.lib.community.inner;

import android.view.View;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.covode.number.Covode;
import com.dragon.community.saas.utils.LifecycleKtxKt;
import com.dragon.read.lib.community.inner.CssThemeKtxKt;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CssThemeKtxKt {
    static {
        Covode.recordClassIndex(611457);
    }

    public static final class c implements vw1.b {
        final /* synthetic */ FragmentActivity a;

        c(FragmentActivity fragmentActivity) {
            this.a = fragmentActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Runnable b(View it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            Object tag = it2.getTag(2131825251);
            if (tag instanceof Runnable) {
                return (Runnable) tag;
            }
            return null;
        }

        public void onThemeUpdate(int i) {
            View decorView = this.a.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            Iterator it2 = SequencesKt___SequencesKt.filterNotNull(SequencesKt___SequencesKt.map(ViewKt.d(decorView), new Function1() { // from class: com.dragon.read.lib.community.inner.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Runnable b;
                    b = CssThemeKtxKt.c.b((View) obj);
                    return b;
                }
            })).iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
        }
    }

    public static final class d implements vw1.b {
        final /* synthetic */ View a;

        d(View view) {
            this.a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Runnable b(View it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            Object tag = it2.getTag(2131825251);
            if (tag instanceof Runnable) {
                return (Runnable) tag;
            }
            return null;
        }

        public void onThemeUpdate(int i) {
            Iterator it2 = SequencesKt___SequencesKt.filterNotNull(SequencesKt___SequencesKt.map(ViewKt.d(this.a), new Function1() { // from class: com.dragon.read.lib.community.inner.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Runnable b;
                    b = CssThemeKtxKt.d.b((View) obj);
                    return b;
                }
            })).iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;
        final /* synthetic */ d b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            com.dragon.read.lib.community.inner.b.a.c(this.b);
        }

        public b(View view, d dVar) {
            this.a = view;
            this.b = dVar;
        }
    }

    public static final void c(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        LifecycleKtxKt.b(fragmentActivity, new CssThemeKtxKt$observeThemeUpdate$1(new c(fragmentActivity), null));
    }

    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;
        final /* synthetic */ d b;
        final /* synthetic */ View c;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            com.dragon.read.lib.community.inner.b bVar = com.dragon.read.lib.community.inner.b.a;
            bVar.a(this.b);
            View view2 = this.c;
            if (!view2.isAttachedToWindow()) {
                bVar.c(this.b);
            } else {
                view2.addOnAttachStateChangeListener(new b(view2, this.b));
            }
        }

        public a(View view, d dVar, View view2) {
            this.a = view;
            this.b = dVar;
            this.c = view2;
        }
    }

    public static final class e implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;
        final /* synthetic */ Function2 b;
        final /* synthetic */ View c;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            this.b.invoke(this.c, Integer.valueOf(com.dragon.read.lib.community.inner.c.a.b().a.c().getAppTheme()));
        }

        public e(View view, Function2 function2, View view2) {
            this.a = view;
            this.b = function2;
            this.c = view2;
        }
    }

    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        d dVar = new d(view);
        if (view.isAttachedToWindow()) {
            com.dragon.read.lib.community.inner.b bVar = com.dragon.read.lib.community.inner.b.a;
            bVar.a(dVar);
            if (!view.isAttachedToWindow()) {
                bVar.c(dVar);
                return;
            } else {
                view.addOnAttachStateChangeListener(new b(view, dVar));
                return;
            }
        }
        view.addOnAttachStateChangeListener(new a(view, dVar, view));
    }

    public static final <T extends View> void d(final T t, final Function2<? super T, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(t, Integer.valueOf(com.dragon.read.lib.community.inner.c.a.b().a.c().getAppTheme()));
        t.setTag(2131825251, new Runnable() { // from class: com.dragon.read.lib.community.inner.f
            @Override // java.lang.Runnable
            public final void run() {
                CssThemeKtxKt.e(t, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view, Function2 function2) {
        if (view.isAttachedToWindow()) {
            function2.invoke(view, Integer.valueOf(com.dragon.read.lib.community.inner.c.a.b().a.c().getAppTheme()));
        } else {
            view.addOnAttachStateChangeListener(new e(view, function2, view));
        }
    }
}
