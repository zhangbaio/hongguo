package gs4;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.BitmapOpt;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.Args;
import com.dragon.read.base.ssconfig.template.ImageBoostAtLaunchV673;
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
import gs4.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z extends com.facebook.drawee.controller.a {
    public static final a a;
    public static final int b;
    private static WeakReference<z> c;
    private static boolean d;
    private static final HashSet<String> e;
    private static HashSet<String> f;
    private static final HashSet<String> g;
    private static final HashMap<String, String> h;
    private static k0 i;
    private static long j;

    public static final void t(ViewGroup viewGroup) {
        a.q(viewGroup);
    }

    public static final void u() {
        a.w();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(612321);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WeakReference<z> h() {
            return z.c;
        }

        public final k0 i() {
            return z.i;
        }

        public final long j() {
            return z.j;
        }

        public final HashMap<String, String> k() {
            return z.h;
        }

        public final boolean l() {
            return z.d;
        }

        private final void e() {
            boolean z;
            HashSet hashSet = z.f;
            if (hashSet != null && hashSet.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] all bookcover loaded.", new Object[0]);
                u(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x() {
            a aVar = z.a;
            if (aVar.l()) {
                aVar.u(false);
                LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] canceled.", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y() {
            z.g.clear();
            z.a.k().clear();
        }

        public final void w() {
            ThreadUtils.postInForeground(new Runnable() { // from class: gs4.x
                @Override // java.lang.Runnable
                public final void run() {
                    z.a.x();
                }
            }, 5000L);
            ThreadUtils.postInForeground(new Runnable() { // from class: gs4.y
                @Override // java.lang.Runnable
                public final void run() {
                    z.a.y();
                }
            }, 30000L);
        }

        private final void f() {
            try {
                long currentTimeMillis = System.currentTimeMillis() - j();
                Args args = new Args();
                args.put("count", Integer.valueOf(i().e));
                args.put("duration_cover_load", Long.valueOf(currentTimeMillis));
                args.put("duration", Long.valueOf(com.dragon.read.app.launch.e.s(false) + currentTimeMillis));
                args.put("scene", "first_screen");
                args.put("first_req_time", Long.valueOf(i().f() - com.dragon.read.app.launch.e.u()));
                args.put("last_req_time", Long.valueOf(i().i() - com.dragon.read.app.launch.e.u()));
                args.put("preload_count", Integer.valueOf(i().d()));
                args.put("view_load_count", Integer.valueOf(i().e()));
                ReportManager.onReport("reading_launch_cover", args);
                LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] doReport: " + args.toJSONObject(), new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final void s(long j) {
            z.j = j;
        }

        public final void t(boolean z) {
            z.d = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(ViewGroup viewGroup) {
            z.a.g(viewGroup);
        }

        public final boolean m(String str) {
            return k().containsKey(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n(String str) {
            z.e.add(str);
            HashSet hashSet = z.f;
            if (hashSet != null) {
                hashSet.remove(str);
            }
            e();
        }

        private final void g(ViewGroup viewGroup) {
            if (l()) {
                z.f = new HashSet();
                try {
                    LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] start traversal.", new Object[0]);
                    v(viewGroup);
                    LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] finish traversal.", new Object[0]);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                e();
            }
        }

        public final String p(AbstractDraweeController<?, ?> controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            try {
                Object f = wo2.a.f(controller, "mDataSource");
                if (f instanceof com.facebook.imagepipeline.datasource.a) {
                    Object f2 = wo2.a.f(f, "mSettableProducerContext");
                    if (f2 instanceof SettableProducerContext) {
                        return ((SettableProducerContext) f2).getId();
                    }
                    return null;
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                LogWrapper.error("FirstScreenBookCoverWatcher", Log.getStackTraceString(th), new Object[0]);
                return null;
            }
        }

        private final void u(boolean z) {
            z zVar;
            if (!l()) {
                return;
            }
            t(false);
            z.e.clear();
            HashSet hashSet = z.f;
            if (hashSet != null) {
                hashSet.clear();
            }
            i().j();
            com.dragon.read.app.launch.e.K(z, i().f());
            NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
            WeakReference<z> h = h();
            if (h != null) {
                zVar = h.get();
            } else {
                zVar = null;
            }
            nsCommonDepend.unRegisterFrescoGlobalControllerListener(zVar);
            nsCommonDepend.onAllCoverLoad();
            if (z && j() > 0 && com.dragon.read.app.launch.e.a.E()) {
                f();
            }
        }

        public final void q(final ViewGroup root) {
            Intrinsics.checkNotNullParameter(root, "root");
            if (j() > 0) {
                return;
            }
            s(System.currentTimeMillis());
            if (BitmapOpt.a.a().lazySizeEnable) {
                ThreadUtils.postInForegroundAtFrontOfQueue(new Runnable() { // from class: gs4.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.a.r(root);
                    }
                });
            } else {
                g(root);
            }
            ImageBoostAtLaunchV673 a = ImageBoostAtLaunchV673.a.a();
            if (a.enable) {
                NsCommonDepend.IMPL.turboModeApi().a(root, false, a.timeout);
            }
        }

        private final void v(ViewGroup viewGroup) {
            for (View view : UIKt.getChildren(viewGroup)) {
                if (!(view instanceof ScaleBookCover) && !(view instanceof MultiGenreBookCover) && !(view instanceof SimpleBookCover) && !(view instanceof SimpleDraweeView)) {
                    if (view instanceof ViewGroup) {
                        z.a.v((ViewGroup) view);
                    }
                } else {
                    a aVar = z.a;
                    Triple<String, String, String> o = aVar.o(view);
                    if (o != null) {
                        aVar.i().a(o.getThird());
                        String first = o.getFirst();
                        if (first != null) {
                            aVar.k().put(first, o.getThird());
                        }
                        String second = o.getSecond();
                        if (second != null) {
                            z.g.add(second);
                            if (!z.e.contains(second)) {
                                HashSet hashSet = z.f;
                                if (hashSet != null) {
                                    hashSet.add(second);
                                }
                                LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] add " + second + " to waitList.", new Object[0]);
                            }
                        }
                    }
                }
            }
        }

        private final Triple<String, String, String> o(View view) {
            DraweeController draweeController;
            DraweeController draweeController2;
            DraweeController draweeController3;
            DraweeController draweeController4;
            DraweeController draweeController5;
            DraweeController draweeController6;
            Uri uri = null;
            if (!ImageViewExtKt.isVisibleInScreen(view)) {
                return null;
            }
            if (view instanceof ScaleBookCover) {
                ScaleBookCover scaleBookCover = (ScaleBookCover) view;
                SimpleDraweeView originalCover = scaleBookCover.getOriginalCover();
                if (originalCover != null) {
                    draweeController5 = originalCover.getController();
                } else {
                    draweeController5 = null;
                }
                if (draweeController5 instanceof AbstractDraweeController) {
                    SimpleDraweeView originalCover2 = scaleBookCover.getOriginalCover();
                    if (originalCover2 != null) {
                        draweeController6 = originalCover2.getController();
                    } else {
                        draweeController6 = null;
                    }
                    Intrinsics.checkNotNull(draweeController6, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                    AbstractDraweeController<?, ?> abstractDraweeController = (AbstractDraweeController) draweeController6;
                    String p = z.a.p(abstractDraweeController);
                    String id = abstractDraweeController.getId();
                    ImageRequest imageRequest = abstractDraweeController.getImageRequest();
                    if (imageRequest != null) {
                        uri = imageRequest.getSourceUri();
                    }
                    return new Triple<>(p, id, String.valueOf(uri));
                }
            } else if (view instanceof MultiGenreBookCover) {
                MultiGenreBookCover multiGenreBookCover = (MultiGenreBookCover) view;
                SimpleDraweeView originalCover3 = multiGenreBookCover.getOriginalCover();
                if (originalCover3 != null) {
                    draweeController3 = originalCover3.getController();
                } else {
                    draweeController3 = null;
                }
                if (draweeController3 instanceof AbstractDraweeController) {
                    SimpleDraweeView originalCover4 = multiGenreBookCover.getOriginalCover();
                    if (originalCover4 != null) {
                        draweeController4 = originalCover4.getController();
                    } else {
                        draweeController4 = null;
                    }
                    Intrinsics.checkNotNull(draweeController4, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                    AbstractDraweeController<?, ?> abstractDraweeController2 = (AbstractDraweeController) draweeController4;
                    String p2 = z.a.p(abstractDraweeController2);
                    String id2 = abstractDraweeController2.getId();
                    ImageRequest imageRequest2 = abstractDraweeController2.getImageRequest();
                    if (imageRequest2 != null) {
                        uri = imageRequest2.getSourceUri();
                    }
                    return new Triple<>(p2, id2, String.valueOf(uri));
                }
            } else if (view instanceof SimpleBookCover) {
                SimpleBookCover simpleBookCover = (SimpleBookCover) view;
                SimpleDraweeView bookImage = simpleBookCover.getBookImage();
                if (bookImage != null) {
                    draweeController = bookImage.getController();
                } else {
                    draweeController = null;
                }
                if (draweeController instanceof AbstractDraweeController) {
                    SimpleDraweeView bookImage2 = simpleBookCover.getBookImage();
                    if (bookImage2 != null) {
                        draweeController2 = bookImage2.getController();
                    } else {
                        draweeController2 = null;
                    }
                    Intrinsics.checkNotNull(draweeController2, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                    AbstractDraweeController<?, ?> abstractDraweeController3 = (AbstractDraweeController) draweeController2;
                    String p3 = z.a.p(abstractDraweeController3);
                    String id3 = abstractDraweeController3.getId();
                    ImageRequest imageRequest3 = abstractDraweeController3.getImageRequest();
                    if (imageRequest3 != null) {
                        uri = imageRequest3.getSourceUri();
                    }
                    return new Triple<>(p3, id3, String.valueOf(uri));
                }
            } else if (view instanceof SimpleDraweeView) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
                if (simpleDraweeView.getController() instanceof AbstractDraweeController) {
                    AbstractDraweeController controller = simpleDraweeView.getController();
                    Intrinsics.checkNotNull(controller, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                    controller.getCallerContext();
                    if (NsCommonDepend.IMPL.isStaggerBookCover(simpleDraweeView)) {
                        AbstractDraweeController<?, ?> controller2 = simpleDraweeView.getController();
                        Intrinsics.checkNotNull(controller2, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, *>");
                        AbstractDraweeController<?, ?> abstractDraweeController4 = controller2;
                        String p4 = z.a.p(abstractDraweeController4);
                        String id4 = abstractDraweeController4.getId();
                        ImageRequest imageRequest4 = abstractDraweeController4.getImageRequest();
                        if (imageRequest4 != null) {
                            uri = imageRequest4.getSourceUri();
                        }
                        return new Triple<>(p4, id4, String.valueOf(uri));
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        o.j.b().z();
    }

    public z() {
        c = new WeakReference<>(this);
        ThreadUtils.postInForeground(new Runnable() { // from class: gs4.u
            @Override // java.lang.Runnable
            public final void run() {
                z.e();
            }
        }, 100L);
    }

    static {
        Covode.recordClassIndex(612320);
        a = new a(null);
        b = 8;
        d = true;
        e = new HashSet<>();
        g = new HashSet<>();
        h = new HashMap<>();
        i = new k0(0L, 0L, 0, 0, 0, null, null, 127, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String str) {
        a.n(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String str) {
        a.n(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String str) {
        e.remove(str);
        HashSet<String> hashSet = f;
        if (hashSet != null) {
            hashSet.remove(str);
        }
    }

    public void onRelease(final String str, ImageRequest imageRequest) {
        super.onRelease(str, imageRequest);
        if (!d) {
            return;
        }
        LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] onRelease, id: %s", new Object[]{str});
        if (str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.t
                @Override // java.lang.Runnable
                public final void run() {
                    z.s(str);
                }
            });
        }
    }

    public void onFailure(final String str, ImageRequest imageRequest, Throwable th) {
        super.onFailure(str, imageRequest, th);
        if (!d) {
            return;
        }
        LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] onFailure, id: %s", new Object[]{str});
        if (str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.v
                @Override // java.lang.Runnable
                public final void run() {
                    z.q(str);
                }
            });
        }
    }

    public void onFinalImageSet(final String str, Object obj, Animatable animatable, ImageRequest imageRequest, Map<Object, Object> map) {
        super.onFinalImageSet(str, obj, animatable, imageRequest, map);
        if (!d) {
            return;
        }
        LogWrapper.info("FirstScreenBookCoverWatcher", "[FirstScreenBookCoverWatcher] onFinialImageSet, id: %s", new Object[]{str});
        if (str != null) {
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.s
                @Override // java.lang.Runnable
                public final void run() {
                    z.r(str);
                }
            });
        }
    }
}
