package com.dragon.read.openanim;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookOpenAnimTask {
    public static final a n;
    public static final int o;
    private static final LogHelper p;
    public final b a;
    public final Rect b;
    public final Rect c;
    public final Rect d;
    public final Matrix e;
    public final Matrix f;
    public final Matrix g;
    public final Matrix h;
    public final Rect i;
    public final String j;
    public State k;
    private final List<Pair<String, Runnable>> l;
    private final List<i> m;

    public static final class a {
        static {
            Covode.recordClassIndex(612631);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State STATE_ENTERED;
        public static final State STATE_ENTERING;
        public static final State STATE_EXISTED;
        public static final State STATE_EXISTING;
        public static final State STATE_INIT;

        private static final /* synthetic */ State[] $values() {
            return new State[]{STATE_INIT, STATE_ENTERING, STATE_ENTERED, STATE_EXISTING, STATE_EXISTED};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(612632);
            STATE_INIT = new State("STATE_INIT", 0);
            STATE_ENTERING = new State("STATE_ENTERING", 1);
            STATE_ENTERED = new State("STATE_ENTERED", 2);
            STATE_EXISTING = new State("STATE_EXISTING", 3);
            STATE_EXISTED = new State("STATE_EXISTED", 4);
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        private State(String str, int i) {
        }
    }

    public final void c() {
        this.l.clear();
        this.m.clear();
    }

    public final void e() {
        g();
        f();
        i();
        h();
    }

    static {
        Covode.recordClassIndex(612630);
        n = new a(null);
        o = 8;
        p = new LogHelper("BookOpenAnimTask");
    }

    public final void f() {
        p.i("notifyEnterEnd", new Object[0]);
        this.k = State.STATE_ENTERED;
        try {
            Iterator<T> it2 = this.m.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).a();
            }
            d();
        } catch (Exception e) {
            p.w(Log.getStackTraceString(e), new Object[0]);
        }
    }

    public final void g() {
        p.i("notifyEnterStart", new Object[0]);
        this.k = State.STATE_ENTERING;
        try {
            Iterator<T> it2 = this.m.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).b();
            }
        } catch (Exception e) {
            p.w(Log.getStackTraceString(e), new Object[0]);
        }
    }

    public final void h() {
        p.i("notifyExitEnd", new Object[0]);
        this.k = State.STATE_EXISTED;
        try {
            for (i iVar : this.m) {
                iVar.c(iVar);
            }
            d();
        } catch (Exception e) {
            p.w(Log.getStackTraceString(e), new Object[0]);
        }
    }

    public final void i() {
        p.i("notifyExitStart", new Object[0]);
        this.k = State.STATE_EXISTING;
        try {
            Iterator<T> it2 = this.m.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).d();
            }
        } catch (Exception e) {
            p.w(Log.getStackTraceString(e), new Object[0]);
        }
    }

    public String toString() {
        return "from:" + this.j + ", bookCoverEnterRect:" + this.b + ", bookCoverExitRect:" + this.c + ", bookContentRect:" + this.d;
    }

    private final void d() {
        Iterator<T> it2 = this.l.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            p.i("executePendingTask " + ((String) pair.getFirst()), new Object[0]);
            ((Runnable) pair.getSecond()).run();
        }
        this.l.clear();
    }

    public final void j(i listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.m.remove(listener);
    }

    public final void k(Rect newRect) {
        Intrinsics.checkNotNullParameter(newRect, "newRect");
        this.c.set(newRect);
    }

    public final void a(i listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        p.i("addListener " + listener, new Object[0]);
        this.m.add(listener);
    }

    public final void b(String name, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        p.v("addPendingTask " + name, new Object[0]);
        this.l.add(new Pair<>(name, runnable));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BookOpenAnimTask(Activity activity, b coverProvider, Rect bookCoverEnterRect, Rect bookCoverExitRect, Rect bookContentRect) {
        this(activity, coverProvider, bookCoverEnterRect, bookCoverExitRect, bookContentRect, null, null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_APPID, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(coverProvider, "coverProvider");
        Intrinsics.checkNotNullParameter(bookCoverEnterRect, "bookCoverEnterRect");
        Intrinsics.checkNotNullParameter(bookCoverExitRect, "bookCoverExitRect");
        Intrinsics.checkNotNullParameter(bookContentRect, "bookContentRect");
    }

    public BookOpenAnimTask(Activity activity, b coverProvider, Rect bookCoverEnterRect, Rect bookCoverExitRect, Rect bookContentRect, Matrix matrix, Matrix matrix2, Matrix matrix3, Matrix matrix4, Rect rect) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(coverProvider, "coverProvider");
        Intrinsics.checkNotNullParameter(bookCoverEnterRect, "bookCoverEnterRect");
        Intrinsics.checkNotNullParameter(bookCoverExitRect, "bookCoverExitRect");
        Intrinsics.checkNotNullParameter(bookContentRect, "bookContentRect");
        this.a = coverProvider;
        this.b = bookCoverEnterRect;
        this.c = bookCoverExitRect;
        this.d = bookContentRect;
        this.e = matrix;
        this.f = matrix2;
        this.g = matrix3;
        this.h = matrix4;
        this.i = rect;
        this.j = activity.toString();
        this.k = State.STATE_INIT;
        this.l = new ArrayList();
        this.m = new ArrayList();
        activity.overridePendingTransition(0, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ BookOpenAnimTask(android.app.Activity r13, com.dragon.read.openanim.b r14, android.graphics.Rect r15, android.graphics.Rect r16, android.graphics.Rect r17, android.graphics.Matrix r18, android.graphics.Matrix r19, android.graphics.Matrix r20, android.graphics.Matrix r21, android.graphics.Rect r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r12 = this;
            r0 = r23
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L9
            r0 = 0
            r11 = r0
            goto Lb
        L9:
            r11 = r22
        Lb:
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.openanim.BookOpenAnimTask.<init>(android.app.Activity, com.dragon.read.openanim.b, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect, android.graphics.Matrix, android.graphics.Matrix, android.graphics.Matrix, android.graphics.Matrix, android.graphics.Rect, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
