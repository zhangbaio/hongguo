package gs4;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.BitmapOpt;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.Args;
import com.dragon.read.base.ssconfig.template.ImageBoostAtBookShelfV673;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.multigenre.MultiGenreBookCover;
import com.dragon.read.report.ReportManager;
import com.dragon.read.util.ImageViewExtKt;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.ScaleBookCover;
import com.dragon.read.widget.bookcover.SimpleBookCover;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import gs4.o;
import gs4.z;
import java.util.HashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class o extends com.facebook.drawee.controller.a {
    public static final c j;
    public static final int k;
    private static final Lazy<a> l;
    private static final Lazy<b> m;
    private final String a;
    private boolean b;
    private final HashSet<String> c;
    private HashSet<String> d;
    private final HashSet<String> e;
    private final HashSet<String> f;
    private int g;
    private long h;
    private long i;

    protected abstract boolean s(View view);

    protected abstract void x(Args args);

    protected void y(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
    }

    public static final class a extends o {
        @Override // gs4.o
        protected void x(Args args) {
            Intrinsics.checkNotNullParameter(args, "args");
        }

        a() {
            super("book_shelf");
        }

        @Override // gs4.o
        protected boolean s(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view instanceof SimpleBookCover;
        }

        @Override // gs4.o
        protected void y(ViewGroup root) {
            Intrinsics.checkNotNullParameter(root, "root");
            ImageBoostAtBookShelfV673 a = ImageBoostAtBookShelfV673.a.a();
            if (a.enable) {
                NsCommonDepend.IMPL.turboModeApi().a(root, a.blockNormalNetwork, a.timeout);
            }
        }
    }

    public static final class b extends o {
        b() {
            super("stagger");
        }

        @Override // gs4.o
        protected boolean s(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!(view instanceof SimpleBookCover) && (!(view instanceof SimpleDraweeView) || !NsCommonDepend.IMPL.isStaggerBookCover((SimpleDraweeView) view))) {
                return false;
            }
            return true;
        }

        @Override // gs4.o
        protected void x(Args args) {
            Intrinsics.checkNotNullParameter(args, "args");
            args.put("duration_since_first_draw", Long.valueOf(o()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b A() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a k() {
        return new a();
    }

    public static final class c {
        static {
            Covode.recordClassIndex(612315);
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a() {
            return (o) o.l.getValue();
        }

        public final o b() {
            return (o) o.m.getValue();
        }
    }

    public final long o() {
        return this.i - z.a.j();
    }

    public final void z() {
        if (this.h > 0) {
            return;
        }
        NsCommonDepend.IMPL.registerFrescoGlobalControllerListener(this);
    }

    private final void F() {
        ThreadUtils.postInForeground(new Runnable() { // from class: gs4.m
            @Override // java.lang.Runnable
            public final void run() {
                o.G(o.this);
            }
        }, 5000L);
        ThreadUtils.postInForeground(new Runnable() { // from class: gs4.n
            @Override // java.lang.Runnable
            public final void run() {
                o.H(o.this);
            }
        }, 30000L);
    }

    private final String q() {
        return "CustomBookCoverWatcher_" + this.a;
    }

    static {
        Lazy<a> lazy;
        Lazy<b> lazy2;
        Covode.recordClassIndex(612314);
        j = new c(null);
        k = 8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: gs4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                o.a k2;
                k2 = o.k();
                return k2;
            }
        });
        l = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: gs4.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                o.b A;
                A = o.A();
                return A;
            }
        });
        m = lazy2;
    }

    private final void l() {
        boolean z;
        HashSet<String> hashSet = this.d;
        if (hashSet != null && hashSet.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LogWrapper.info(q(), '[' + q() + "] all bookcover loaded.", new Object[0]);
            D(true);
        }
    }

    private final void m() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.i = currentTimeMillis;
            long j2 = currentTimeMillis - this.h;
            Args args = new Args();
            args.put("count", Integer.valueOf(this.g));
            args.put("duration_cover_load", Long.valueOf(j2));
            args.put("scene", this.a);
            x(args);
            ReportManager.onReport("reading_launch_cover", args);
            LogWrapper.info(q(), '[' + q() + "] doReport: " + args.toJSONObject(), new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean r(String str) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(this.f, str);
        return contains;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(o oVar) {
        oVar.e.clear();
        oVar.f.clear();
    }

    private final void v(String str) {
        this.c.add(str);
        HashSet<String> hashSet = this.d;
        if (hashSet != null) {
            hashSet.remove(str);
        }
        l();
    }

    public o(String bizTag) {
        Intrinsics.checkNotNullParameter(bizTag, "bizTag");
        this.a = bizTag;
        this.b = true;
        this.c = new HashSet<>();
        this.e = new HashSet<>();
        this.f = new HashSet<>();
    }

    private final void D(boolean z) {
        if (!this.b) {
            return;
        }
        this.b = false;
        this.c.clear();
        HashSet<String> hashSet = this.d;
        if (hashSet != null) {
            hashSet.clear();
        }
        NsCommonDepend.IMPL.unRegisterFrescoGlobalControllerListener(this);
        if (z && this.h > 0) {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(o oVar) {
        if (oVar.b) {
            oVar.D(false);
            LogWrapper.info(oVar.q(), '[' + oVar.q() + "] canceled.", new Object[0]);
        }
    }

    public final void B(final ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (this.h > 0) {
            return;
        }
        this.h = System.currentTimeMillis();
        if (BitmapOpt.a.a().lazySizeEnable) {
            ThreadUtils.postInForegroundAtFrontOfQueue(new Runnable() { // from class: gs4.j
                @Override // java.lang.Runnable
                public final void run() {
                    o.C(o.this, root);
                }
            });
        } else {
            n(root);
        }
        y(root);
        F();
    }

    private final void n(ViewGroup viewGroup) {
        if (!this.b) {
            return;
        }
        this.d = new HashSet<>();
        try {
            LogWrapper.info(q(), '[' + q() + "] start traversal.", new Object[0]);
            E(viewGroup);
            LogWrapper.info(q(), '[' + q() + "] finish traversal.", new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        l();
    }

    private final void E(ViewGroup viewGroup) {
        String second;
        String first;
        for (View view : UIKt.getChildren(viewGroup)) {
            if (s(view)) {
                Triple<String, String, Drawable> p = p(view);
                if (p != null && (first = p.getFirst()) != null) {
                    this.g++;
                    this.e.add(first);
                    if (!this.c.contains(first)) {
                        if (p.getThird() != null) {
                            this.c.add(first);
                            LogWrapper.info(q(), '[' + q() + "] add " + first + " to doneList.", new Object[0]);
                        } else {
                            HashSet<String> hashSet = this.d;
                            if (hashSet != null) {
                                hashSet.add(first);
                            }
                            LogWrapper.info(q(), '[' + q() + "] add " + first + " to waitList.", new Object[0]);
                        }
                    }
                }
                if (p != null && (second = p.getSecond()) != null) {
                    this.f.add(second);
                    LogWrapper.info(q(), '[' + q() + "] add " + second + " to targetRequestIdList.", new Object[0]);
                }
            } else if (view instanceof ViewGroup) {
                E((ViewGroup) view);
            }
        }
    }

    private final Triple<String, String, Drawable> p(View view) {
        DraweeController draweeController;
        DraweeController draweeController2;
        DraweeController draweeController3;
        DraweeController draweeController4;
        DraweeController draweeController5;
        DraweeController draweeController6 = null;
        if (!ImageViewExtKt.isVisibleInScreen(view)) {
            return null;
        }
        if (view instanceof ScaleBookCover) {
            ScaleBookCover scaleBookCover = (ScaleBookCover) view;
            SimpleDraweeView originalCover = scaleBookCover.getOriginalCover();
            if (originalCover != null) {
                draweeController3 = originalCover.getController();
            } else {
                draweeController3 = null;
            }
            if (draweeController3 instanceof AbstractDraweeController) {
                SimpleDraweeView originalCover2 = scaleBookCover.getOriginalCover();
                if (originalCover2 != null) {
                    draweeController4 = originalCover2.getController();
                } else {
                    draweeController4 = null;
                }
                Intrinsics.checkNotNull(draweeController4, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                String id = ((AbstractDraweeController) draweeController4).getId();
                z.a aVar = z.a;
                SimpleDraweeView originalCover3 = scaleBookCover.getOriginalCover();
                if (originalCover3 != null) {
                    draweeController5 = originalCover3.getController();
                } else {
                    draweeController5 = null;
                }
                Intrinsics.checkNotNull(draweeController5, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                String p = aVar.p((AbstractDraweeController) draweeController5);
                SimpleDraweeView originalCover4 = scaleBookCover.getOriginalCover();
                if (originalCover4 != null) {
                    draweeController6 = originalCover4.getController();
                }
                Intrinsics.checkNotNull(draweeController6, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                return new Triple<>(id, p, ((AbstractDraweeController) draweeController6).getDrawable());
            }
        } else if (view instanceof MultiGenreBookCover) {
            MultiGenreBookCover multiGenreBookCover = (MultiGenreBookCover) view;
            SimpleDraweeView originalCover5 = multiGenreBookCover.getOriginalCover();
            if (originalCover5 != null) {
                draweeController = originalCover5.getController();
            } else {
                draweeController = null;
            }
            if (draweeController instanceof AbstractDraweeController) {
                SimpleDraweeView originalCover6 = multiGenreBookCover.getOriginalCover();
                if (originalCover6 != null) {
                    draweeController2 = originalCover6.getController();
                } else {
                    draweeController2 = null;
                }
                Intrinsics.checkNotNull(draweeController2, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                String id2 = ((AbstractDraweeController) draweeController2).getId();
                z.a aVar2 = z.a;
                SimpleDraweeView originalCover7 = multiGenreBookCover.getOriginalCover();
                if (originalCover7 != null) {
                    draweeController6 = originalCover7.getController();
                }
                Intrinsics.checkNotNull(draweeController6, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                String p2 = aVar2.p((AbstractDraweeController) draweeController6);
                AbstractDraweeController controller = multiGenreBookCover.getOriginalCover().getController();
                Intrinsics.checkNotNull(controller, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                return new Triple<>(id2, p2, controller.getDrawable());
            }
        } else if (view instanceof SimpleBookCover) {
            SimpleBookCover simpleBookCover = (SimpleBookCover) view;
            if (simpleBookCover.getBookImage().getController() instanceof AbstractDraweeController) {
                AbstractDraweeController controller2 = simpleBookCover.getBookImage().getController();
                Intrinsics.checkNotNull(controller2, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                String id3 = controller2.getId();
                z.a aVar3 = z.a;
                DraweeController controller3 = simpleBookCover.getBookImage().getController();
                Intrinsics.checkNotNull(controller3, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                String p3 = aVar3.p((AbstractDraweeController) controller3);
                AbstractDraweeController controller4 = simpleBookCover.getBookImage().getController();
                Intrinsics.checkNotNull(controller4, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                return new Triple<>(id3, p3, controller4.getDrawable());
            }
        } else if (view instanceof SimpleDraweeView) {
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
            if (simpleDraweeView.getController() instanceof AbstractDraweeController) {
                AbstractDraweeController controller5 = simpleDraweeView.getController();
                Intrinsics.checkNotNull(controller5, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                controller5.getCallerContext();
                if (NsCommonDepend.IMPL.isStaggerBookCover(simpleDraweeView)) {
                    AbstractDraweeController controller6 = simpleDraweeView.getController();
                    Intrinsics.checkNotNull(controller6, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                    String id4 = controller6.getId();
                    z.a aVar4 = z.a;
                    DraweeController controller7 = simpleDraweeView.getController();
                    Intrinsics.checkNotNull(controller7, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                    String p4 = aVar4.p((AbstractDraweeController) controller7);
                    AbstractDraweeController controller8 = simpleDraweeView.getController();
                    Intrinsics.checkNotNull(controller8, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                    return new Triple<>(id4, p4, controller8.getDrawable());
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(o oVar, ViewGroup viewGroup) {
        oVar.n(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(o oVar, String str) {
        oVar.v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(o oVar, String str) {
        oVar.v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(o oVar, String str) {
        oVar.c.remove(str);
        HashSet<String> hashSet = oVar.d;
        if (hashSet != null) {
            hashSet.remove(str);
        }
    }

    public void onRelease(final String str, ImageRequest imageRequest) {
        super.onRelease(str, imageRequest);
        if (!this.b) {
            return;
        }
        LogWrapper.info(q(), '[' + q() + "] onRelease, id: %s", new Object[]{str});
        if (str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.k
                @Override // java.lang.Runnable
                public final void run() {
                    o.w(o.this, str);
                }
            });
        }
    }

    public void onFailure(final String str, ImageRequest imageRequest, Throwable th) {
        super.onFailure(str, imageRequest, th);
        if (!this.b) {
            return;
        }
        LogWrapper.info(q(), '[' + q() + "] onFailure, id: %s", new Object[]{str});
        if (str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.i
                @Override // java.lang.Runnable
                public final void run() {
                    o.t(o.this, str);
                }
            });
        }
    }

    public void onFinalImageSet(final String str, Object obj, Animatable animatable, ImageRequest imageRequest, Map<Object, Object> map) {
        super.onFinalImageSet(str, obj, animatable, imageRequest, map);
        if (!this.b) {
            return;
        }
        LogWrapper.info(q(), '[' + q() + "] onFinialImageSet, id: %s", new Object[]{str});
        if (str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.l
                @Override // java.lang.Runnable
                public final void run() {
                    o.u(o.this, str);
                }
            });
        }
    }
}
