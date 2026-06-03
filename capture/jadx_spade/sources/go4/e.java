package go4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.shortvideo.distribution.infinite.InnerInfinitePanelKt;
import com.dragon.read.kmp.shortvideo.distribution.infinite.g;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pg4.i;
import pg4.p;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends FrameLayout {
    public static final int d;
    private final ComposeView a;
    private boolean b;
    private final Function1<Boolean, Unit> c;

    static {
        Covode.recordClassIndex(609019);
        d = 8;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(e eVar, boolean z) {
        eVar.b = z;
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ g b;
        final /* synthetic */ FilterType c;
        final /* synthetic */ Function0<Unit> d;

        a(g gVar, FilterType filterType, Function0<Unit> function0) {
            this.b = gVar;
            this.c = filterType;
            this.d = function0;
        }

        /* renamed from: go4.e$a$a, reason: collision with other inner class name */
        static final class C0163a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ e a;
            final /* synthetic */ g b;
            final /* synthetic */ FilterType c;
            final /* synthetic */ Function0<Unit> d;

            C0163a(e eVar, g gVar, FilterType filterType, Function0<Unit> function0) {
                this.a = eVar;
                this.b = gVar;
                this.c = filterType;
                this.d = function0;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(Composer composer, int i) {
                boolean z;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(30010154, i, -1, "com.dragon.read.kmp.shortvideo.distribution.filter.InfinitePanelWrapView.<anonymous>.<anonymous> (InfinitePanelWrapView.kt:26)");
                    }
                    InnerInfinitePanelKt.j(this.b, this.a.c, this.c, this.d, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1848241735, i, -1, "com.dragon.read.kmp.shortvideo.distribution.filter.InfinitePanelWrapView.<anonymous> (InfinitePanelWrapView.kt:25)");
                }
                p.f((i) null, t.e(30010154, true, new C0163a(e.this, this.b, this.c, this.d), composer, 54), composer, 48, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, g infiniteFilterData, Function0<Unit> onClose, FilterType filterType) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(infiniteFilterData, "infiniteFilterData");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.a = composeView;
        this.b = true;
        this.c = new Function1() { // from class: go4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c;
                c = e.c(e.this, ((Boolean) obj).booleanValue());
                return c;
            }
        };
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.b);
        composeView.setContent(t.c(-1848241735, true, new a(infiniteFilterData, filterType, onClose)));
        addView(composeView);
    }
}
