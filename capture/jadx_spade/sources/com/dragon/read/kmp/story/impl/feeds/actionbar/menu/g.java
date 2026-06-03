package com.dragon.read.kmp.story.impl.feeds.actionbar.menu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.GenreTypeEnum;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.g1;
import com.dragon.read.kmp.story.impl.feeds.actionbar.menu.g;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements lp4.a {
    public static final int b;
    public final kp4.b a;

    static {
        Covode.recordClassIndex(609233);
        b = 8;
    }

    public final void b() {
        String str;
        String str2;
        str = StoryMenuDialogKt.a;
        if (StringsKt__StringsKt.isBlank(str)) {
            return;
        }
        str2 = StoryMenuDialogKt.a;
        KmpDialogServiceKt.h(str2);
        StoryMenuDialogKt.a = "";
    }

    static final class a implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ h a;
        final /* synthetic */ g b;

        a(h hVar, g gVar) {
            this.a = hVar;
            this.b = gVar;
        }

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.g$a$a, reason: collision with other inner class name */
        static final class C0069a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ h a;
            final /* synthetic */ g b;

            C0069a(h hVar, g gVar) {
                this.a = hVar;
                this.b = gVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(g gVar) {
                gVar.b();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                b(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void b(Composer composer, int i) {
                boolean z;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-908628112, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.StoryMenuDialogManager.showStoryMenuDialog.<anonymous>.<anonymous> (StoryMenuDialog.kt:90)");
                    }
                    h hVar = this.a;
                    composer.startReplaceGroup(5004770);
                    boolean changedInstance = composer.changedInstance(this.b);
                    final g gVar = this.b;
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit c;
                                c = g.a.C0069a.c(g.this);
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    StoryMenuDialogKt.e(hVar, (Function0) rememberedValue, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
            a(gVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(com.dragon.read.kmp.service.g it2, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(it2, "it");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1609093787, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.StoryMenuDialogManager.showStoryMenuDialog.<anonymous> (StoryMenuDialog.kt:89)");
                }
                rp4.e.d(t.e(-908628112, true, new C0069a(this.a, this.b), composer, 54), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public g(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        this.a = story;
    }

    @Override // lp4.a
    public void a(KmpStoryFeedsVM viewModel) {
        h o;
        h p;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        b();
        ArrayList arrayList = new ArrayList();
        Integer genreType = this.a.d().getGenreType();
        int value = GenreTypeEnum.STORY_GENRE_TYPE.getValue();
        if (genreType == null || genreType.intValue() != value) {
            Integer genreType2 = this.a.d().getGenreType();
            int value2 = GenreTypeEnum.NOVEL.getValue();
            if (genreType2 == null || genreType2.intValue() != value2) {
                return;
            }
            o = StoryMenuDialogKt.o(this.a, viewModel);
            if (o != null) {
                arrayList.addAll(o.a);
            }
        } else {
            p = StoryMenuDialogKt.p(this.a, viewModel);
            if (p != null) {
                arrayList.addAll(p.a);
            }
        }
        StoryMenuDialogKt.a = KmpDialogServiceKt.l(new g1(false, false, null, true, 6, null), t.c(-1609093787, true, new a(new h(arrayList), this)));
    }
}
