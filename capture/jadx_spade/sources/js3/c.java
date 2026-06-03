package js3;

import android.graphics.Rect;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.shortvideo.autoplay.VideoAutoPlayType;
import is3.r;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final a h;
    public static final int i;
    private final LogHelper a = new LogHelper("StaggerVideoAutoPlayManagerV2");
    private final LinkedHashSet<r> b = new LinkedHashSet<>();
    private final Rect c = new Rect();
    public r d;
    private final Lazy e;
    private boolean f;
    public boolean g;

    public static final class a {
        static {
            Covode.recordClassIndex(598945);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598944);
        h = new a(null);
        i = 8;
    }

    public final void f() {
        r rVar = this.d;
        if (rVar != null) {
            rVar.f();
        }
    }

    public final void g() {
        r rVar = this.d;
        if (rVar != null) {
            rVar.c();
        }
    }

    public final void o() {
        this.f = false;
        n();
    }

    private final boolean c() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h() {
        return AppUtils.context().getResources().getBoolean(2131230864);
    }

    public final void j() {
        r rVar = this.d;
        if (rVar != null) {
            rVar.d();
        }
        this.d = null;
        this.b.clear();
    }

    public c() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: js3.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean h2;
                h2 = c.h();
                return Boolean.valueOf(h2);
            }
        });
        this.e = lazy;
    }

    public final void b() {
        r rVar = this.d;
        if (rVar == null) {
            return;
        }
        Pair<Rect, Boolean> globalVisibleRect = rVar.getGlobalVisibleRect();
        Rect first = globalVisibleRect.getFirst();
        if (!globalVisibleRect.getSecond().booleanValue() || !d(first, rVar) || !rVar.b()) {
            rVar.d();
            this.d = null;
        }
    }

    public final void n() {
        r e;
        if (this.f) {
            this.f = false;
            return;
        }
        int centerY = this.c.centerY();
        r rVar = null;
        Rect rect = null;
        for (r rVar2 : CollectionsKt___CollectionsKt.sortedWith(this.b, new b())) {
            Pair<Rect, Boolean> globalVisibleRect = rVar2.getGlobalVisibleRect();
            Rect first = rVar2.getGlobalVisibleRect().getFirst();
            if (globalVisibleRect.getSecond().booleanValue() && d(first, rVar2) && rVar2.b()) {
                if (rect != null && Math.abs(first.centerY() - centerY) >= Math.abs(rect.centerY() - centerY)) {
                    if (c() && Math.abs(first.centerY() - centerY) == Math.abs(rect.centerY() - centerY) && (e = e(rVar, rVar2)) != null) {
                        rVar = e;
                    }
                } else {
                    rVar = rVar2;
                    rect = first;
                }
            }
        }
        if (!Intrinsics.areEqual(this.d, rVar)) {
            r rVar3 = this.d;
            if (rVar3 != null) {
                rVar3.d();
            }
            if (rVar != null) {
                rVar.e(VideoAutoPlayType.AUTO_PLAY);
            }
            this.d = rVar;
        }
    }

    public final void p() {
        boolean z;
        r e;
        r rVar = this.d;
        r rVar2 = null;
        if (rVar != null) {
            Pair<Rect, Boolean> globalVisibleRect = rVar.getGlobalVisibleRect();
            Rect first = globalVisibleRect.getFirst();
            if (!globalVisibleRect.getSecond().booleanValue() || !d(first, rVar) || !rVar.b()) {
                rVar.d();
                this.d = null;
            }
        }
        LinkedHashSet<r> linkedHashSet = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = linkedHashSet.iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (true ^ ((r) next).a()) {
                arrayList.add(next);
            }
        }
        List<r> sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new C0203c());
        if (!sortedWith.isEmpty()) {
            r rVar3 = this.d;
            if (rVar3 == null || !rVar3.a()) {
                z = false;
            }
            if (!z) {
                int centerY = this.c.centerY();
                Rect rect = null;
                for (r rVar4 : sortedWith) {
                    Pair<Rect, Boolean> globalVisibleRect2 = rVar4.getGlobalVisibleRect();
                    Rect first2 = rVar4.getGlobalVisibleRect().getFirst();
                    if (globalVisibleRect2.getSecond().booleanValue() && d(first2, rVar4) && rVar4.b()) {
                        if (rect != null && Math.abs(first2.centerY() - centerY) >= Math.abs(rect.centerY() - centerY)) {
                            if (c() && Math.abs(first2.centerY() - centerY) == Math.abs(rect.centerY() - centerY) && (e = e(rVar2, rVar4)) != null) {
                                rVar2 = e;
                            }
                        } else {
                            rVar2 = rVar4;
                            rect = first2;
                        }
                    }
                }
                if (!Intrinsics.areEqual(this.d, rVar2)) {
                    r rVar5 = this.d;
                    if (rVar5 != null) {
                        rVar5.d();
                    }
                    if (rVar2 != null) {
                        rVar2.e(VideoAutoPlayType.AUTO_PLAY);
                    }
                    this.d = rVar2;
                }
            }
        }
    }

    public final void i(r rVar) {
        if (rVar != null) {
            this.b.add(rVar);
        }
    }

    public final void k(r protocol) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        if (!Intrinsics.areEqual(this.d, protocol)) {
            r rVar = this.d;
            if (rVar != null) {
                rVar.d();
            }
            this.d = protocol;
        }
    }

    public final void l(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (rect.isEmpty()) {
            return;
        }
        this.c.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void q(r rVar) {
        if (Intrinsics.areEqual(this.d, rVar)) {
            if (rVar != null) {
                rVar.d();
            }
            this.d = null;
        }
        TypeIntrinsics.asMutableCollection(this.b).remove(rVar);
    }

    public final void m(r protocol) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        LogWrapper.debug("StaggerVideoAutoPlayManagerV2", "triggerPlayByDrag " + protocol + " enableFollowHandDrag " + this.g, new Object[0]);
        if (!this.g) {
            return;
        }
        Pair<Rect, Boolean> globalVisibleRect = protocol.getGlobalVisibleRect();
        Rect first = globalVisibleRect.getFirst();
        boolean booleanValue = globalVisibleRect.getSecond().booleanValue();
        this.f = true;
        if (protocol.b() && !protocol.isPlaying() && !Intrinsics.areEqual(this.d, protocol) && booleanValue && d(first, protocol)) {
            r rVar = this.d;
            if (rVar != null) {
                rVar.d();
            }
            protocol.e(VideoAutoPlayType.LONG_PRESS_PLAY);
            this.d = protocol;
            return;
        }
        LogWrapper.debug("StaggerVideoAutoPlayManagerV2", "can not play " + protocol + " enablePlay " + protocol.b() + " isPlaying " + protocol.isPlaying() + " visible " + booleanValue + " isExpose20Percent " + d(first, protocol) + " currentAutoPlayLayout " + this.d, new Object[0]);
    }

    private final r e(r rVar, r rVar2) {
        if (Random.Default.nextInt(2) != 0) {
            return rVar2;
        }
        return rVar;
    }

    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((r) t).getPosition()), Integer.valueOf(((r) t2).getPosition()));
            return compareValues;
        }
    }

    /* renamed from: js3.c$c, reason: collision with other inner class name */
    public static final class C0203c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((r) t).getPosition()), Integer.valueOf(((r) t2).getPosition()));
            return compareValues;
        }
    }

    private final boolean d(Rect rect, r rVar) {
        if (rect.isEmpty()) {
            this.a.i("empty false", new Object[0]);
            return false;
        }
        if (rVar.getViewHeight() <= 0 || rect.height() / r6 < 0.2d) {
            return false;
        }
        return true;
    }
}
