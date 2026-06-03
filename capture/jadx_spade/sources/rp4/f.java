package rp4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.uicontext.KmpStoryReadingSettingManager;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    private com.dragon.read.kmp.story.impl.feeds.uicontext.b a;
    public final MutableStateFlow<rp4.a> b = StateFlowKt.MutableStateFlow(new rp4.a(KmpStoryReadingSettingManager.a.i()));

    static {
        Covode.recordClassIndex(609368);
    }

    public final void a() {
        b(false);
    }

    public f() {
        b(true);
    }

    public static final class a implements com.dragon.read.kmp.story.impl.feeds.uicontext.b {
        a() {
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.uicontext.b
        public void g(int i) {
            f.this.c(i);
        }
    }

    private final void b(boolean z) {
        if (z) {
            if (this.a == null) {
                a aVar = new a();
                this.a = aVar;
                KmpStoryReadingSettingManager.a.b(aVar);
                return;
            }
            return;
        }
        KmpStoryReadingSettingManager.a.k(this.a);
        this.a = null;
    }

    public final void c(int i) {
        rp4.a value;
        MutableStateFlow<rp4.a> mutableStateFlow = this.b;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.a(i)));
    }
}
