package gs4;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.BitmapOpt;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.Args;
import com.dragon.read.base.ssconfig.template.ImageBoostAtStaggerV679;
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
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q0 extends com.facebook.drawee.controller.a {
    public static final q0 a;
    private static boolean b;
    private static final HashSet<String> c;
    private static HashSet<String> d;
    private static long e;
    private static int f;
    private static String g;
    public static final int h;

    private q0() {
    }

    private final boolean m() {
        if (e > 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(612333);
        a = new q0();
        c = new HashSet<>();
        h = 8;
    }

    private final void g() {
        if (m()) {
            HashSet<String> hashSet = d;
            boolean z = false;
            if (hashSet != null && hashSet.isEmpty()) {
                z = true;
            }
            if (z) {
                i();
                x();
            }
        }
    }

    private final void x() {
        g = null;
        e = 0L;
        f = 0;
        c.clear();
        HashSet<String> hashSet = d;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public final void B() {
        if (!b) {
            return;
        }
        b = false;
        x();
        NsCommonDepend.IMPL.unRegisterFrescoGlobalControllerListener(this);
        LogWrapper.info("SensibleStaggerCoverScheduler", "unRegister.", new Object[0]);
    }

    public final void w() {
        if (b) {
            return;
        }
        b = true;
        NsCommonDepend.IMPL.registerFrescoGlobalControllerListener(this);
        LogWrapper.info("SensibleStaggerCoverScheduler", "register.", new Object[0]);
    }

    private final void i() {
        if (g != null && e != 0) {
            try {
                Args args = new Args();
                args.put("duration_cover_load", Long.valueOf(System.currentTimeMillis() - e));
                args.put("count", Integer.valueOf(f));
                args.put("scene", g);
                ReportManager.onReport("reading_launch_cover", args);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String str) {
        a.p(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String str) {
        a.p(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ViewGroup viewGroup) {
        a.j(viewGroup);
    }

    private final void p(String str) {
        c.add(str);
        HashSet<String> hashSet = d;
        if (hashSet != null) {
            hashSet.remove(str);
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(RecyclerView recyclerView) {
        a.h(recyclerView, "stagger_loadmore");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String str) {
        c.remove(str);
        HashSet<String> hashSet = d;
        if (hashSet != null) {
            hashSet.remove(str);
        }
    }

    public final void q(final RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.post(new Runnable() { // from class: gs4.m0
            @Override // java.lang.Runnable
            public final void run() {
                q0.r(recyclerView);
            }
        });
    }

    private final boolean l(View view) {
        if (!(view instanceof SimpleBookCover) && (!(view instanceof SimpleDraweeView) || !NsCommonDepend.IMPL.isStaggerBookCover((SimpleDraweeView) view))) {
            return false;
        }
        return true;
    }

    private final void y(final ViewGroup viewGroup) {
        e = System.currentTimeMillis();
        if (BitmapOpt.a.a().lazySizeEnable) {
            ThreadUtils.postInForegroundAtFrontOfQueue(new Runnable() { // from class: gs4.p0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.z(viewGroup);
                }
            });
        } else {
            j(viewGroup);
        }
    }

    private final a f(SimpleDraweeView simpleDraweeView) {
        String str;
        AbstractDraweeController controller = simpleDraweeView.getController();
        Intrinsics.checkNotNull(controller, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
        String id = controller.getId();
        String v = v(simpleDraweeView);
        Uri k = k(simpleDraweeView);
        if (k != null) {
            str = k.getPath();
        } else {
            str = null;
        }
        AbstractDraweeController controller2 = simpleDraweeView.getController();
        Intrinsics.checkNotNull(controller2, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
        return new a(id, v, str, controller2.getDrawable());
    }

    private final Uri k(SimpleDraweeView simpleDraweeView) {
        if (simpleDraweeView.getController() instanceof AbstractDraweeController) {
            AbstractDraweeController controller = simpleDraweeView.getController();
            Intrinsics.checkNotNull(controller, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
            controller.getCallerContext();
            AbstractDraweeController controller2 = simpleDraweeView.getController();
            Intrinsics.checkNotNull(controller2, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
            return controller2.getImageRequest().getSourceUri();
        }
        return null;
    }

    private final String v(SimpleDraweeView simpleDraweeView) {
        DraweeController controller;
        try {
            controller = simpleDraweeView.getController();
        } catch (Throwable th) {
            LogWrapper.warn("SensibleStaggerCoverScheduler", Log.getStackTraceString(th), new Object[0]);
        }
        if (!(controller instanceof AbstractDraweeController)) {
            return null;
        }
        Object f2 = wo2.a.f(controller, "mDataSource");
        if (f2 instanceof com.facebook.imagepipeline.datasource.a) {
            Object f3 = wo2.a.f(f2, "mSettableProducerContext");
            if (f3 instanceof SettableProducerContext) {
                return ((SettableProducerContext) f3).getId();
            }
        }
        return null;
    }

    private final void j(ViewGroup viewGroup) {
        if (!b) {
            return;
        }
        d = new HashSet<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            A(viewGroup, arrayList, arrayList2, 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ImageBoostAtStaggerV679 a2 = ImageBoostAtStaggerV679.a.a();
        if (a2.enable && ((!arrayList.isEmpty()) || (true ^ arrayList2.isEmpty()))) {
            NsCommonDepend.IMPL.turboModeApi().c(arrayList, arrayList2, a2.enableBlockNet, a2.timeout);
        }
        g();
    }

    private final a u(View view) {
        DraweeController draweeController;
        DraweeController draweeController2;
        if (!ImageViewExtKt.isVisibleInScreen(view)) {
            return null;
        }
        if (view instanceof ScaleBookCover) {
            ScaleBookCover scaleBookCover = (ScaleBookCover) view;
            SimpleDraweeView originalCover = scaleBookCover.getOriginalCover();
            if (originalCover != null) {
                draweeController2 = originalCover.getController();
            } else {
                draweeController2 = null;
            }
            if (draweeController2 instanceof AbstractDraweeController) {
                SimpleDraweeView originalCover2 = scaleBookCover.getOriginalCover();
                Intrinsics.checkNotNullExpressionValue(originalCover2, "getOriginalCover(...)");
                return f(originalCover2);
            }
        } else if (view instanceof MultiGenreBookCover) {
            MultiGenreBookCover multiGenreBookCover = (MultiGenreBookCover) view;
            SimpleDraweeView originalCover3 = multiGenreBookCover.getOriginalCover();
            if (originalCover3 != null) {
                draweeController = originalCover3.getController();
            } else {
                draweeController = null;
            }
            if (draweeController instanceof AbstractDraweeController) {
                return f(multiGenreBookCover.getOriginalCover());
            }
        } else if (view instanceof SimpleBookCover) {
            SimpleBookCover simpleBookCover = (SimpleBookCover) view;
            if (simpleBookCover.getBookImage().getController() instanceof AbstractDraweeController) {
                return f(simpleBookCover.getBookImage());
            }
        } else if (view instanceof SimpleDraweeView) {
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
            if (simpleDraweeView.getController() instanceof AbstractDraweeController) {
                return f(simpleDraweeView);
            }
        }
        return null;
    }

    public final void t(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i != 0) {
            return;
        }
        h(recyclerView, "stagger_idle");
    }

    public void onRelease(final String str, ImageRequest imageRequest) {
        super.onRelease(str, imageRequest);
        if (b && str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.o0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.s(str);
                }
            });
        }
    }

    private final void h(RecyclerView recyclerView, String str) {
        x();
        g = str;
        y(recyclerView);
        LogWrapper.info("SensibleStaggerCoverScheduler", "schedule at " + g + '.', new Object[0]);
    }

    public void onFailure(final String str, ImageRequest imageRequest, Throwable th) {
        super.onFailure(str, imageRequest, th);
        if (b && str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.l0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.n(str);
                }
            });
        }
    }

    public static final class a {
        public static final int e;
        public final String a;
        public final String b;
        public final String c;
        public final Drawable d;

        static {
            Covode.recordClassIndex(612334);
            e = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d);
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Drawable drawable = this.d;
            return hashCode3 + (drawable != null ? drawable.hashCode() : 0);
        }

        public String toString() {
            return "Image(controllerId=" + this.a + ", requestId=" + this.b + ", uriPath=" + this.c + ", drawable=" + this.d + ')';
        }

        public a(String str, String str2, String str3, Drawable drawable) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = drawable;
        }
    }

    private final void A(ViewGroup viewGroup, List<String> list, List<String> list2, int i) {
        String str;
        String str2;
        String str3;
        if (i >= 8) {
            return;
        }
        for (View view : UIKt.getChildren(viewGroup)) {
            q0 q0Var = a;
            if (q0Var.l(view)) {
                f++;
                a u = q0Var.u(view);
                if (u != null && (str3 = u.a) != null) {
                    HashSet<String> hashSet = c;
                    if (!hashSet.contains(str3)) {
                        if (u.d != null) {
                            hashSet.add(str3);
                        } else {
                            HashSet<String> hashSet2 = d;
                            if (hashSet2 != null) {
                                hashSet2.add(str3);
                            }
                        }
                    }
                }
                if (u != null && (str2 = u.c) != null) {
                    list.add(str2);
                }
                if (u != null && (str = u.b) != null) {
                    list2.add(str);
                }
            } else if (view instanceof ViewGroup) {
                q0Var.A((ViewGroup) view, list, list2, i + 1);
            }
        }
    }

    public void onFinalImageSet(final String str, Object obj, Animatable animatable, ImageRequest imageRequest, Map<Object, Object> map) {
        super.onFinalImageSet(str, obj, animatable, imageRequest, map);
        if (b && str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.n0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.o(str);
                }
            });
        }
    }
}
