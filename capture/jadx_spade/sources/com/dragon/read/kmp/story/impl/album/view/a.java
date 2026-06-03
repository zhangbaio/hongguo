package com.dragon.read.kmp.story.impl.album.view;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function2<Composer, Integer, Unit> b;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(609217);
        a = new a();
        b = t.c(-493594252, false, C0066a.a);
    }

    /* renamed from: com.dragon.read.kmp.story.impl.album.view.a$a, reason: collision with other inner class name */
    static final class C0066a implements Function2<Composer, Integer, Unit> {
        public static final C0066a a = new C0066a();

        C0066a() {
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
                    ComposerKt.traceEventStart(-493594252, i, -1, "com.dragon.read.kmp.story.impl.album.view.ComposableSingletons$StoryAlbumDetailViewKt.lambda$-493594252.<anonymous> (StoryAlbumDetailView.kt:90)");
                }
                a3.a(SizeKt.x(Modifier.Companion, x0.i.g(6)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }
}
