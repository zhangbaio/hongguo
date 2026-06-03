package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.uicontext.KmpStoryReadingSettingManager;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class s extends ViewModel {
    public final int a;
    public final ec4.k b;
    public final int c;
    public final List<com.dragon.read.kmp.story.impl.feeds.uicontext.a> d;
    public final MutableState<com.dragon.read.kmp.story.impl.feeds.uicontext.a> e;
    public final com.dragon.read.kmp.story.impl.feeds.uicontext.b f;

    static {
        Covode.recordClassIndex(609237);
    }

    public final void E0() {
        KmpStoryReadingSettingManager.a.b(this.f);
    }

    public final void F0() {
        KmpStoryReadingSettingManager.a.k(this.f);
    }

    public s() {
        KmpStoryReadingSettingManager kmpStoryReadingSettingManager = KmpStoryReadingSettingManager.a;
        this.a = kmpStoryReadingSettingManager.e();
        this.b = kmpStoryReadingSettingManager.h();
        this.c = kmpStoryReadingSettingManager.i();
        this.d = kmpStoryReadingSettingManager.d();
        this.e = SnapshotStateKt.mutableStateOf$default(new com.dragon.read.kmp.story.impl.feeds.uicontext.a(kmpStoryReadingSettingManager.i(), null, 2, null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.f = new a();
    }

    public static final class a implements com.dragon.read.kmp.story.impl.feeds.uicontext.b {
        a() {
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.uicontext.b
        public void g(int i) {
            Object obj;
            boolean z;
            Iterator<T> it2 = s.this.d.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((com.dragon.read.kmp.story.impl.feeds.uicontext.a) obj).a == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar = (com.dragon.read.kmp.story.impl.feeds.uicontext.a) obj;
            if (aVar != null) {
                s sVar = s.this;
                if (!Intrinsics.areEqual(aVar, sVar.e.getValue())) {
                    sVar.e.setValue(aVar);
                }
            }
        }
    }
}
