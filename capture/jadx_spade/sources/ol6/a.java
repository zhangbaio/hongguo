package ol6;

import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public static final C0249a h;
    public sk6.b a;
    public boolean b;
    public boolean c;
    private final WeakHandler.IHandler d;
    private final WeakHandler e;
    public final TTVideoEngine f;
    public final sk6.a g;

    static {
        Covode.recordClassIndex(655945);
        h = new C0249a(null);
    }

    public final void g() {
        this.c = true;
    }

    public final void j() {
        this.e.removeMessages(1);
    }

    public final void h() {
        j();
        this.b = false;
        this.c = false;
    }

    public final void f() {
        if (this.b) {
            this.b = false;
            sk6.b bVar = this.a;
            if (bVar != null) {
                bVar.a(e());
            }
        }
    }

    public final void i() {
        this.e.removeMessages(1);
        WeakHandler weakHandler = this.e;
        weakHandler.sendMessageDelayed(weakHandler.obtainMessage(1), 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long e() {
        long coerceAtMost;
        long longOption = this.f.getLongOption(61);
        long longOption2 = this.f.getLongOption(62);
        if (longOption > 0 && longOption2 > 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(longOption, longOption2);
            return coerceAtMost;
        }
        if (longOption2 > 0) {
            return longOption2;
        }
        return longOption;
    }

    /* renamed from: ol6.a$a, reason: collision with other inner class name */
    public static final class C0249a {
        static {
            Covode.recordClassIndex(655946);
        }

        private C0249a() {
        }

        public /* synthetic */ C0249a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements WeakHandler.IHandler {
        b() {
        }

        public final void handleMsg(Message message) {
            if (message.what == 1) {
                a.this.d(a.this.e(), a.this.f.getCurrentPlaybackTime(), a.this.f.getDuration());
                a.this.e.removeMessages(1);
                a.this.e.sendMessageDelayed(a.this.e.obtainMessage(1), 300L);
            }
        }
    }

    public a(TTVideoEngine tTVideoEngine, sk6.a aVar) {
        this.f = tTVideoEngine;
        this.g = aVar;
        b bVar = new b();
        this.d = bVar;
        this.e = new WeakHandler(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(long j, int i, int i2) {
        if (j > this.g.b && !this.b) {
            this.b = true;
            sk6.b bVar = this.a;
            if (bVar != null) {
                bVar.b(j);
            }
        }
        if (!this.c && (i <= 0 || i2 <= 0 || i + j + 2000 < i2)) {
            if (j < this.g.a && this.b) {
                this.b = false;
                sk6.b bVar2 = this.a;
                if (bVar2 != null) {
                    bVar2.a(j);
                    return;
                }
                return;
            }
            return;
        }
        if (!this.b) {
            this.b = true;
            sk6.b bVar3 = this.a;
            if (bVar3 != null) {
                bVar3.b(j);
            }
        }
    }
}
