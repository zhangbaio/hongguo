package gm4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.menu.moresettings.m0;
import com.dragon.read.kmp.reader.ui.menu.moresettings.model.v;
import com.dragon.read.reader.ui.ReaderActivity;
import com.dragon.read.util.kotlin.StringKt;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sm4.h;
import sm4.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends com.dragon.read.kmp.ui.a {
    public static final int e;
    private final ComposeView b;
    private final ReaderActivity c;
    private final b d;

    static {
        Covode.recordClassIndex(608461);
        e = 8;
    }

    @Override // com.dragon.read.kmp.ui.a
    public String getViewId() {
        return "more_setting";
    }

    public boolean yb() {
        return false;
    }

    public static final class c implements sm4.b {
        @Override // sm4.b
        public void onDismiss() {
            a.super.d(true);
        }

        @Override // sm4.b
        public void onShow() {
            ViewGroup viewGroup;
            ViewParent parent = a.this.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                return;
            }
            a.super.h(viewGroup, null);
        }

        c() {
        }
    }

    @Override // com.dragon.read.kmp.ui.a
    public void d(boolean z) {
        this.d.b();
        super.d(z);
    }

    @Override // com.dragon.read.kmp.ui.a
    public void g(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        h(parent, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.b = composeView;
        ReaderActivity readerActivity = (ReaderActivity) context;
        this.c = readerActivity;
        b bVar = new b(readerActivity.getBookId(), new c());
        bVar.h(readerActivity.h2());
        this.d = bVar;
        addView(composeView);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.b);
        composeView.setContent(t.c(-640772234, true, new C0160a()));
    }

    public static final class b extends v {
        b(String str, c cVar) {
            super(str, cVar);
        }
    }

    /* renamed from: gm4.a$a, reason: collision with other inner class name */
    static final class C0160a implements Function2<Composer, Integer, Unit> {
        C0160a() {
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
                    ComposerKt.traceEventStart(-640772234, i, -1, "com.dragon.read.kmp.reader.menu.KmpReaderMoreSettingView.<anonymous> (KmpReaderMoreSettingView.kt:54)");
                }
                m0.s(a.this.d, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    @Override // com.dragon.read.kmp.ui.a
    public void h(ViewGroup parent, sm4.a aVar) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (aVar instanceof i) {
            i iVar = (i) aVar;
            if (StringKt.isNotNullOrEmpty(iVar.d)) {
                Iterator<h> it2 = this.d.g.iterator();
                int i = 0;
                while (true) {
                    if (it2.hasNext()) {
                        if (Intrinsics.areEqual(it2.next().getType(), iVar.d)) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i > 0 && i < this.d.g.size()) {
                    b bVar = this.d;
                    bVar.h = i;
                    bVar.i = 0;
                }
            }
        }
        this.d.g();
        super.h(parent, aVar);
    }
}
