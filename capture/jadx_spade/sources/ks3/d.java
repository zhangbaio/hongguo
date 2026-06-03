package ks3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsUiDepend;
import com.dragon.read.base.basescale.ScaleImageView;
import com.dragon.read.base.depend.NsBaseUtilsDependImpl;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.y;
import com.dragon.read.component.shortvideo.autoplay.VideoAutoPlayType;
import com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import com.dragon.read.recyler.r;
import com.dragon.read.rpc.model.AutoPlayStyle;
import com.dragon.read.rpc.model.PlayCoverInfo;
import com.dragon.read.rpc.model.PlayStrategyType;
import com.dragon.read.rpc.model.StartPlayStrategy;
import com.dragon.read.util.DebugManager;
import com.dragon.read.util.NetworkUtils;
import com.dragon.read.util.NumberUtils;
import com.dragon.read.util.c2;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.util.q6;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.ss.android.videoshop.api.VideoStateInquirer;
import com.ss.android.videoshop.entity.PlayEntity;
import cv4.b;
import is3.a0;
import is3.k;
import is3.l;
import is3.n;
import is3.q;
import is3.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import ks3.d;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements s64.b<s64.a> {
    public static final a m;
    public static final int n;
    public final ViewStub a;
    public final ks3.a b;
    private ks3.g c;
    private SaasVideoData d;
    private View e;
    private FrameLayout f;
    private FrameLayout g;
    public StaggerAutoPlayVideoView h;
    private View i;
    private SimpleDraweeView j;
    private final Lazy k;
    private final g l;

    public static final class a {
        static {
            Covode.recordClassIndex(598949);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends is3.e {
        final /* synthetic */ f a;

        @Override // is3.e, is3.m
        public String getSubTag() {
            return "AutoPlayCard_Double_Col";
        }

        public static final class a extends is3.c {
            @Override // is3.c, is3.g
            public boolean d() {
                return true;
            }

            @Override // is3.c, is3.g
            public int getTextureLayout() {
                return 2;
            }

            a() {
            }
        }

        /* renamed from: ks3.d$b$b, reason: collision with other inner class name */
        public static final class C0233b extends is3.d {
            @Override // is3.d, is3.k
            public boolean c() {
                return false;
            }

            C0233b() {
            }
        }

        @Override // is3.m
        public n a() {
            return this.a;
        }

        @Override // is3.e, is3.m
        public is3.g d() {
            return new a();
        }

        @Override // is3.e, is3.m
        public q e() {
            return new a0();
        }

        @Override // is3.m
        public k f() {
            return new C0233b();
        }

        b(f fVar) {
            this.a = fVar;
        }
    }

    public static final class c implements StaggerAutoPlayVideoView.c {
        c() {
        }

        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.c
        public void a(boolean z) {
        }
    }

    static {
        Covode.recordClassIndex(598948);
        m = new a(null);
        n = 8;
    }

    public void b() {
        r();
    }

    /* renamed from: ks3.d$d, reason: collision with other inner class name */
    public static final class C0234d implements StaggerAutoPlayVideoView.d {
        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.d
        public void c(SaasVideoData saasVideoData) {
        }

        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.d
        public int getPosition() {
            return d.this.b.d();
        }

        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.d
        public String getTag() {
            return d.this.b.getTag();
        }

        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.d
        public boolean b() {
            if (!NetworkUtils.isNetworkAvailable() || d.this.c == null || d.this.d == null) {
                return false;
            }
            return true;
        }

        C0234d() {
        }
    }

    public static final class f extends is3.f {
        private final Lazy a;

        public final com.dragon.read.pages.video.a c() {
            return (com.dragon.read.pages.video.a) this.a.getValue();
        }

        f() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ks3.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    com.dragon.read.pages.video.a d;
                    d = d.f.d(d.this);
                    return d;
                }
            });
            this.a = lazy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final com.dragon.read.pages.video.a d(d dVar) {
            com.dragon.read.pages.video.a a = dVar.b.a();
            a.d2("if_autoplay", 1);
            a.M2("outside_autoplay");
            return a;
        }

        @Override // is3.f
        public void onVideoPause(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            Serializable serializable;
            VideoAutoPlayType playType;
            super.onVideoPause(videoStateInquirer, playEntity);
            com.dragon.read.pages.video.a c = c();
            StaggerAutoPlayVideoView staggerAutoPlayVideoView = d.this.h;
            if (staggerAutoPlayVideoView == null || (playType = staggerAutoPlayVideoView.getPlayType()) == null || (serializable = playType.getValue()) == null) {
                serializable = 0;
            }
            vr3.d.g(c.d2("autoplay_active_type", serializable), false, 1, null);
        }

        @Override // is3.f
        public void onVideoPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            Serializable serializable;
            VideoAutoPlayType playType;
            super.onVideoPlay(videoStateInquirer, playEntity);
            com.dragon.read.pages.video.a c = c();
            StaggerAutoPlayVideoView staggerAutoPlayVideoView = d.this.h;
            if (staggerAutoPlayVideoView == null || (playType = staggerAutoPlayVideoView.getPlayType()) == null || (serializable = playType.getValue()) == null) {
                serializable = 0;
            }
            vr3.d.h(c.d2("autoplay_active_type", serializable), false, 1, null);
        }

        @Override // is3.f
        public void onVideoReleased(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            Serializable serializable;
            VideoAutoPlayType playType;
            super.onVideoReleased(videoStateInquirer, playEntity);
            com.dragon.read.pages.video.a c = c();
            StaggerAutoPlayVideoView staggerAutoPlayVideoView = d.this.h;
            if (staggerAutoPlayVideoView == null || (playType = staggerAutoPlayVideoView.getPlayType()) == null || (serializable = playType.getValue()) == null) {
                serializable = 0;
            }
            vr3.d.g(c.d2("autoplay_active_type", serializable), false, 1, null);
        }

        @Override // is3.f
        public void onVideoCompleted(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            List<ks3.f> list;
            Object obj;
            l commonPlayView;
            super.onVideoCompleted(videoStateInquirer, playEntity);
            ks3.g gVar = d.this.c;
            if (gVar != null && (list = gVar.a) != null) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    obj = null;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    String str = ((ks3.f) next).a;
                    if (playEntity != null) {
                        obj = playEntity.getVideoId();
                    }
                    if (Intrinsics.areEqual(str, obj)) {
                        obj = next;
                        break;
                    }
                }
                ks3.f fVar = (ks3.f) obj;
                if (fVar != null) {
                    if (fVar.f == PlayStrategyType.Stop) {
                        StaggerAutoPlayVideoView staggerAutoPlayVideoView = d.this.h;
                        if (staggerAutoPlayVideoView != null) {
                            staggerAutoPlayVideoView.f();
                            return;
                        }
                        return;
                    }
                    StaggerAutoPlayVideoView staggerAutoPlayVideoView2 = d.this.h;
                    if (staggerAutoPlayVideoView2 != null && (commonPlayView = staggerAutoPlayVideoView2.getCommonPlayView()) != null) {
                        commonPlayView.seekTo(fVar.d);
                    }
                    SaasVideoData saasVideoData = d.this.d;
                    if (saasVideoData != null) {
                        saasVideoData.setForceStartTime(fVar.d);
                    }
                    d.this.A();
                }
            }
        }

        @Override // is3.f
        public void onFrameDraw(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, Map<?, ?> map) {
            boolean z;
            List<ks3.f> list;
            Object obj;
            String str;
            super.onFrameDraw(videoStateInquirer, playEntity, i, map);
            ks3.g gVar = d.this.c;
            AutoPlayStyle autoPlayStyle = null;
            if (gVar != null && (list = gVar.a) != null) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        String str2 = ((ks3.f) obj).a;
                        if (playEntity != null) {
                            str = playEntity.getVideoId();
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str2, str)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                ks3.f fVar = (ks3.f) obj;
                if (fVar != null) {
                    autoPlayStyle = fVar.h;
                }
            }
            if (autoPlayStyle != AutoPlayStyle.GaussianBlur) {
                VideoTabModel.VideoData videoData = d.this.b.getVideoData();
                if (videoData != null && videoData.isVertical()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    d.this.C(true);
                    return;
                }
            }
            d.this.C(false);
        }

        @Override // is3.f
        public void onProgressUpdate(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
            List<ks3.f> list;
            String str;
            Object obj;
            String str2;
            l commonPlayView;
            SaasVideoData saasVideoData;
            String str3;
            super.onProgressUpdate(videoStateInquirer, playEntity, i, i2);
            if (!DebugManager.isOfficialBuild()) {
                LogWrapper.debug("StaggeredAutoPlayVideoComponent", "on progress update, current:" + i + ", duration: " + i2, new Object[0]);
            }
            ks3.g gVar = d.this.c;
            if (gVar != null && (list = gVar.a) != null) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    str = null;
                    if (it2.hasNext()) {
                        obj = it2.next();
                        String str4 = ((ks3.f) obj).a;
                        if (playEntity != null) {
                            str3 = playEntity.getVideoId();
                        } else {
                            str3 = null;
                        }
                        if (Intrinsics.areEqual(str4, str3)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                ks3.f fVar = (ks3.f) obj;
                if (fVar != null) {
                    d.this.b.g(i, fVar.a);
                    SaasVideoData saasVideoData2 = d.this.d;
                    if (saasVideoData2 != null) {
                        str2 = saasVideoData2.getVid();
                    } else {
                        str2 = null;
                    }
                    if (playEntity != null) {
                        str = playEntity.getVideoId();
                    }
                    if (Intrinsics.areEqual(str2, str) && (saasVideoData = d.this.d) != null) {
                        saasVideoData.setForceStartTime(i);
                    }
                    if (i >= i2 || i >= fVar.d + (fVar.g * 1000)) {
                        if (fVar.f == PlayStrategyType.Stop) {
                            StaggerAutoPlayVideoView staggerAutoPlayVideoView = d.this.h;
                            if (staggerAutoPlayVideoView != null) {
                                staggerAutoPlayVideoView.f();
                                return;
                            }
                            return;
                        }
                        StaggerAutoPlayVideoView staggerAutoPlayVideoView2 = d.this.h;
                        if (staggerAutoPlayVideoView2 != null && (commonPlayView = staggerAutoPlayVideoView2.getCommonPlayView()) != null) {
                            commonPlayView.seekTo(fVar.d);
                        }
                        SaasVideoData saasVideoData3 = d.this.d;
                        if (saasVideoData3 != null) {
                            saasVideoData3.setForceStartTime(fVar.d);
                        }
                        d.this.A();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cv4.b p() {
        return (cv4.b) this.k.getValue();
    }

    public final boolean o() {
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = this.h;
        if (staggerAutoPlayVideoView == null || !staggerAutoPlayVideoView.b()) {
            return false;
        }
        return true;
    }

    public static final class e implements StaggerAutoPlayVideoView.b {
        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.b
        public boolean a() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001c A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x001e A[ORIG_RETURN, RETURN] */
        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c() {
            /*
                r2 = this;
                ks3.d r0 = ks3.d.this
                ks3.g r0 = ks3.d.d(r0)
                if (r0 == 0) goto L17
                java.util.List<ks3.f> r0 = r0.a
                if (r0 == 0) goto L17
                java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
                ks3.f r0 = (ks3.f) r0
                if (r0 == 0) goto L17
                com.dragon.read.rpc.model.StartPlayStrategy r0 = r0.i
                goto L18
            L17:
                r0 = 0
            L18:
                com.dragon.read.rpc.model.StartPlayStrategy r1 = com.dragon.read.rpc.model.StartPlayStrategy.ReadProgress
                if (r0 != r1) goto L1e
                r0 = 1
                goto L1f
            L1e:
                r0 = 0
            L1f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ks3.d.e.c():boolean");
        }

        @Override // com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView.b
        public void b() {
            List<ks3.f> list;
            String str;
            Object obj;
            VideoContentType videoContentType;
            String seriesId;
            ts3.d dVar;
            String str2;
            long coerceAtLeast;
            long coerceAtMost;
            l commonPlayView;
            uq3.a aVar;
            String vid;
            String str3;
            long coerceAtLeast2;
            long coerceAtMost2;
            l commonPlayView2;
            String str4;
            ks3.g gVar = d.this.c;
            if (gVar != null && (list = gVar.a) != null) {
                d dVar2 = d.this;
                Iterator<T> it2 = list.iterator();
                while (true) {
                    str = null;
                    if (it2.hasNext()) {
                        obj = it2.next();
                        String str5 = ((ks3.f) obj).a;
                        SaasVideoData saasVideoData = dVar2.d;
                        if (saasVideoData != null) {
                            str4 = saasVideoData.getVid();
                        } else {
                            str4 = null;
                        }
                        if (Intrinsics.areEqual(str5, str4)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                ks3.f fVar = (ks3.f) obj;
                if (fVar == null) {
                    return;
                }
                SaasVideoData saasVideoData2 = d.this.d;
                if (saasVideoData2 != null) {
                    videoContentType = saasVideoData2.getContentType();
                } else {
                    videoContentType = null;
                }
                if (videoContentType == VideoContentType.PUGC) {
                    SaasVideoData saasVideoData3 = d.this.d;
                    if (saasVideoData3 != null && (vid = saasVideoData3.getVid()) != null) {
                        d dVar3 = d.this;
                        dv4.a D = NsUiDepend.IMPL.recordDataManager().D(vid, "");
                        if (D != null) {
                            str3 = D.o;
                        } else {
                            str3 = null;
                        }
                        long parse = NumberUtils.parse(str3, 0L);
                        if (D != null) {
                            str = D.n;
                        }
                        long parse2 = NumberUtils.parse(str, 0L);
                        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(parse - (fVar.g * 1000), 0L);
                        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(parse2, coerceAtLeast2);
                        StaggerAutoPlayVideoView staggerAutoPlayVideoView = dVar3.h;
                        if (staggerAutoPlayVideoView != null && (commonPlayView2 = staggerAutoPlayVideoView.getCommonPlayView()) != null) {
                            commonPlayView2.seekTo(coerceAtMost2);
                        }
                        fVar.d = (int) coerceAtMost2;
                        return;
                    }
                    return;
                }
                SaasVideoData saasVideoData4 = d.this.d;
                if (saasVideoData4 != null && (seriesId = saasVideoData4.getSeriesId()) != null) {
                    d dVar4 = d.this;
                    y docker = ShortSeriesApi.Companion.c().getDocker();
                    if (docker != null && (aVar = (uq3.a) docker.d(uq3.a.class)) != null) {
                        dVar = aVar.O(seriesId);
                    } else {
                        dVar = null;
                    }
                    if (dVar != null) {
                        str2 = dVar.i;
                    } else {
                        str2 = null;
                    }
                    long parse3 = NumberUtils.parse(str2, 0L);
                    if (dVar != null) {
                        str = dVar.h;
                    }
                    long parse4 = NumberUtils.parse(str, 0L);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(parse3 - (fVar.g * 1000), 0L);
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(parse4, coerceAtLeast);
                    StaggerAutoPlayVideoView staggerAutoPlayVideoView2 = dVar4.h;
                    if (staggerAutoPlayVideoView2 != null && (commonPlayView = staggerAutoPlayVideoView2.getCommonPlayView()) != null) {
                        commonPlayView.seekTo(coerceAtMost);
                    }
                    fVar.d = (int) coerceAtMost;
                }
            }
        }

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        StaggerAutoPlayVideoView staggerAutoPlayVideoView;
        StaggerAutoPlayVideoView staggerAutoPlayVideoView2 = this.h;
        boolean z = false;
        if (staggerAutoPlayVideoView2 != null && staggerAutoPlayVideoView2.isPlaying()) {
            z = true;
        }
        if (!z && (staggerAutoPlayVideoView = this.h) != null) {
            staggerAutoPlayVideoView.c();
        }
    }

    public final void q() {
        ScaleImageView playControlBtn;
        FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            UIKt.gone(frameLayout);
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = this.h;
        if (staggerAutoPlayVideoView != null && (playControlBtn = staggerAutoPlayVideoView.getPlayControlBtn()) != null) {
            UIKt.gone(playControlBtn);
        }
    }

    public final boolean u() {
        boolean z;
        if (!UIKt.isVisible(this.h)) {
            return false;
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = this.h;
        if (staggerAutoPlayVideoView != null && staggerAutoPlayVideoView.isPlaying()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    public final void z() {
        ScaleImageView playControlBtn;
        FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            UIKt.visible(frameLayout);
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = this.h;
        if (staggerAutoPlayVideoView != null && (playControlBtn = staggerAutoPlayVideoView.getPlayControlBtn()) != null) {
            UIKt.gone(playControlBtn);
        }
    }

    private final void r() {
        ScaleImageView playControlBtn;
        l commonPlayView;
        if (this.h == null) {
            return;
        }
        f fVar = new f();
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = this.h;
        if (staggerAutoPlayVideoView != null && (commonPlayView = staggerAutoPlayVideoView.getCommonPlayView()) != null) {
            commonPlayView.setMute(true);
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView2 = this.h;
        if (staggerAutoPlayVideoView2 != null) {
            staggerAutoPlayVideoView2.setAutoPlayViewDepend(new b(fVar));
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView3 = this.h;
        if (staggerAutoPlayVideoView3 != null) {
            staggerAutoPlayVideoView3.setStaggerAutoPlayViewListener(new c());
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView4 = this.h;
        if (staggerAutoPlayVideoView4 != null) {
            staggerAutoPlayVideoView4.setStaggerAutoPlayViewProtocol(new C0234d());
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView5 = this.h;
        if (staggerAutoPlayVideoView5 != null) {
            staggerAutoPlayVideoView5.setStaggerAutoPlayViewProgressDepend(new e());
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView6 = this.h;
        if (staggerAutoPlayVideoView6 != null) {
            staggerAutoPlayVideoView6.setAutoPlayManager(this.b.b());
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView7 = this.h;
        if (staggerAutoPlayVideoView7 != null && (playControlBtn = staggerAutoPlayVideoView7.getPlayControlBtn()) != null) {
            UIKt.gone(playControlBtn);
        }
    }

    private final void s() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        View view;
        if (this.e == null) {
            View inflate = this.a.inflate();
            this.e = inflate;
            SimpleDraweeView simpleDraweeView = null;
            if (inflate != null) {
                frameLayout = (FrameLayout) inflate.findViewById(2131821940);
            } else {
                frameLayout = null;
            }
            this.f = frameLayout;
            if (frameLayout != null) {
                frameLayout2 = (FrameLayout) frameLayout.findViewById(2131820736);
            } else {
                frameLayout2 = null;
            }
            this.g = frameLayout2;
            View view2 = this.e;
            if (view2 != null) {
                view = view2.findViewById(2131821939);
            } else {
                view = null;
            }
            this.i = view;
            View view3 = this.e;
            if (view3 != null) {
                simpleDraweeView = (SimpleDraweeView) view3.findViewById(2131822259);
            }
            this.j = simpleDraweeView;
            FrameLayout frameLayout3 = this.g;
            if (frameLayout3 != null) {
                if (this.h == null) {
                    Context context = frameLayout3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    this.h = new StaggerAutoPlayVideoView(context, null, 0, 6, null);
                }
                frameLayout3.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
            }
            FrameLayout frameLayout4 = this.g;
            if (frameLayout4 != null) {
                r.b(frameLayout4, new Function0() { // from class: ks3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit t;
                        t = d.t(d.this);
                        return t;
                    }
                });
            }
            r();
        }
    }

    public static final class h implements cv4.b {
        public void D(dv4.a aVar) {
            b.a.a(this, aVar);
        }

        h() {
        }

        public void k(List<dv4.a> videoRecords) {
            List<ks3.f> list;
            Object firstOrNull;
            Object obj;
            boolean z;
            Intrinsics.checkNotNullParameter(videoRecords, "videoRecords");
            ks3.g gVar = d.this.c;
            if (gVar != null && (list = gVar.a) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                ks3.f fVar = (ks3.f) firstOrNull;
                if (fVar == null || d.this.d == null || fVar.i == StartPlayStrategy.Default) {
                    return;
                }
                d dVar = d.this;
                Iterator<T> it2 = videoRecords.iterator();
                while (true) {
                    obj = null;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    String str = ((dv4.a) next).e;
                    SaasVideoData saasVideoData = dVar.d;
                    if (saasVideoData != null) {
                        obj = saasVideoData.getSeriesId();
                    }
                    if (Intrinsics.areEqual(str, obj)) {
                        obj = next;
                        break;
                    }
                }
                dv4.a aVar = (dv4.a) obj;
                if (aVar == null) {
                    return;
                }
                if (aVar.k.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && !Intrinsics.areEqual(aVar.k, "0")) {
                    d.this.b.f(aVar);
                }
            }
        }
    }

    public static final class g implements View.OnAttachStateChangeListener {
        g() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            NsUiDepend.IMPL.recordDataManager().i(d.this.p());
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            NsUiDepend nsUiDepend = NsUiDepend.IMPL;
            nsUiDepend.recordDataManager().i(d.this.p());
            nsUiDepend.recordDataManager().u(d.this.p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h x(d dVar) {
        return dVar.new h();
    }

    public final void y(float f2) {
        q6.g(this.f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean z) {
        int i;
        View view = this.i;
        if (view != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void v(s64.a model) {
        Intrinsics.checkNotNullParameter(model, "model");
        ks3.g gVar = (ks3.g) model;
        this.c = gVar;
        if (gVar != null) {
            n(gVar);
        }
    }

    private final void l(float f2) {
        int i;
        float cardWidth = this.b.getCardWidth();
        if (f2 > 0.0f && cardWidth > 0.0f) {
            i = (int) (cardWidth * f2);
        } else {
            i = -1;
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = this.h;
        if (staggerAutoPlayVideoView != null) {
            UIKt.updateHeightOpt(staggerAutoPlayVideoView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(d dVar) {
        int i;
        VideoTabModel.VideoData videoData;
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = dVar.h;
        if (staggerAutoPlayVideoView != null) {
            i = staggerAutoPlayVideoView.getHeight();
        } else {
            i = 0;
        }
        if (i <= 0 && (videoData = dVar.b.getVideoData()) != null) {
            dVar.k(videoData);
        }
        return Unit.INSTANCE;
    }

    private final void k(VideoTabModel.VideoData videoData) {
        List<ks3.f> list;
        Object firstOrNull;
        boolean z;
        ks3.g gVar = this.c;
        if (gVar != null && (list = gVar.a) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            ks3.f fVar = (ks3.f) firstOrNull;
            if (fVar != null) {
                if (fVar.h == AutoPlayStyle.Default) {
                    z = true;
                } else {
                    z = false;
                }
                String a2 = a54.b.a.a(videoData);
                if (!videoData.isVertical() && !z) {
                    l(0.0f);
                    if (fVar.h == AutoPlayStyle.WaterfallFlow) {
                        j(a2, this.f);
                        SimpleDraweeView simpleDraweeView = this.j;
                        if (simpleDraweeView != null) {
                            UIKt.gone(simpleDraweeView);
                            return;
                        }
                        return;
                    }
                    j(a2, this.f);
                    SimpleDraweeView simpleDraweeView2 = this.j;
                    if (simpleDraweeView2 != null) {
                        UIKt.visible(simpleDraweeView2);
                    }
                    SimpleDraweeView simpleDraweeView3 = this.j;
                    if (simpleDraweeView3 != null) {
                        c2.i(c2.a, simpleDraweeView3, this.b.getCover(), false, (Object) null, (ImageOriginListener) null, new IterativeBoxBlurPostProcessor(44), (ControllerListener) null, (String) null, (Drawable) null, (Drawable) null, false, 2012, (Object) null);
                        return;
                    }
                    return;
                }
                j(a2, this.f);
                m(this, 0.0f, 1, null);
                SimpleDraweeView simpleDraweeView4 = this.j;
                if (simpleDraweeView4 != null) {
                    UIKt.gone(simpleDraweeView4);
                }
            }
        }
    }

    private final void n(ks3.g gVar) {
        Object firstOrNull;
        Object firstOrNull2;
        boolean z;
        boolean z2;
        int i;
        AutoPlayStyle autoPlayStyle;
        boolean z3;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) gVar.a);
        ks3.f fVar = (ks3.f) firstOrNull;
        if (fVar == null) {
            return;
        }
        VideoTabModel.VideoData videoData = this.b.getVideoData();
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) gVar.a);
        ks3.f fVar2 = (ks3.f) firstOrNull2;
        s();
        boolean z4 = false;
        if (this.b.c()) {
            if (fVar2 != null) {
                autoPlayStyle = fVar2.h;
            } else {
                autoPlayStyle = null;
            }
            if (autoPlayStyle == AutoPlayStyle.GaussianBlur) {
                SimpleDraweeView simpleDraweeView = this.j;
                if (simpleDraweeView != null) {
                    UIKt.visible(simpleDraweeView);
                }
                SimpleDraweeView simpleDraweeView2 = this.j;
                if (simpleDraweeView2 != null) {
                    c2.i(c2.a, simpleDraweeView2, this.b.getCover(), false, (Object) null, (ImageOriginListener) null, new IterativeBoxBlurPostProcessor(44), (ControllerListener) null, (String) null, (Drawable) null, (Drawable) null, false, 2012, (Object) null);
                }
            } else {
                SimpleDraweeView simpleDraweeView3 = this.j;
                if (simpleDraweeView3 != null) {
                    UIKt.gone(simpleDraweeView3);
                }
            }
            SimpleDraweeView simpleDraweeView4 = this.j;
            if (simpleDraweeView4 != null && UIKt.isVisible(simpleDraweeView4)) {
                z3 = true;
            } else {
                z3 = false;
            }
            C(!z3);
        } else if (videoData != null) {
            k(videoData);
            SimpleDraweeView simpleDraweeView5 = this.j;
            if (simpleDraweeView5 != null && UIKt.isVisible(simpleDraweeView5)) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !videoData.isVertical()) {
                z2 = true;
            } else {
                z2 = false;
            }
            C(z2);
        }
        SaasVideoData saasVideoData = new SaasVideoData();
        saasVideoData.setVid(fVar.a);
        String str = fVar.b;
        if (str.length() == 0) {
            z4 = true;
        }
        if (z4) {
            str = fVar.a;
        }
        saasVideoData.setSeriesId(str);
        saasVideoData.setContentType(VideoContentType.findByValue(fVar.c.getValue()));
        Integer e2 = this.b.e(fVar.a);
        if (e2 != null) {
            i = e2.intValue();
        } else {
            i = fVar.d;
        }
        saasVideoData.setForceStartTime(i);
        this.d = saasVideoData;
        StaggerAutoPlayVideoView staggerAutoPlayVideoView = this.h;
        if (staggerAutoPlayVideoView != null) {
            staggerAutoPlayVideoView.d();
        }
        StaggerAutoPlayVideoView staggerAutoPlayVideoView2 = this.h;
        if (staggerAutoPlayVideoView2 != null) {
            staggerAutoPlayVideoView2.l(new StaggerAutoPlayVideoView.e(this.b.getCover(), new z(this.d), this.b.getCallerContext()));
        }
    }

    public s64.a w(Object model) {
        ks3.g gVar;
        ks3.f fVar;
        String str;
        List<ks3.f> list;
        Object firstOrNull;
        VideoTabModel.VideoData videoData;
        List<PlayCoverInfo> playCoverInfo;
        Intrinsics.checkNotNullParameter(model, "model");
        StartPlayStrategy startPlayStrategy = null;
        if (NsBaseUtilsDependImpl.INSTANCE.isPadDevice()) {
            return null;
        }
        if ((model instanceof VideoTabModel.VideoData) && (playCoverInfo = (videoData = (VideoTabModel.VideoData) model).getPlayCoverInfo()) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(playCoverInfo, 10));
            for (PlayCoverInfo playCoverInfo2 : playCoverInfo) {
                String vid = playCoverInfo2.vid;
                Intrinsics.checkNotNullExpressionValue(vid, "vid");
                String seriesId = videoData.getSeriesId();
                if (seriesId == null) {
                    seriesId = "";
                }
                String str2 = seriesId;
                com.dragon.read.rpc.model.VideoContentType contentType = playCoverInfo2.contentType;
                Intrinsics.checkNotNullExpressionValue(contentType, "contentType");
                int i = playCoverInfo2.startTime;
                int i2 = playCoverInfo2.endTime;
                PlayStrategyType playStrategyType = playCoverInfo2.playStrategyType;
                Intrinsics.checkNotNullExpressionValue(playStrategyType, "playStrategyType");
                int i3 = playCoverInfo2.secondLimit;
                AutoPlayStyle autoPlayStyle = playCoverInfo2.autoPlayStyle;
                if (autoPlayStyle == null) {
                    autoPlayStyle = AutoPlayStyle.Default;
                }
                AutoPlayStyle autoPlayStyle2 = autoPlayStyle;
                StartPlayStrategy startPlayStrategy2 = playCoverInfo2.startPlayStrategy;
                if (startPlayStrategy2 == null) {
                    startPlayStrategy2 = StartPlayStrategy.Default;
                }
                arrayList.add(new ks3.f(vid, str2, contentType, i, i2, playStrategyType, i3, autoPlayStyle2, startPlayStrategy2));
            }
            gVar = new ks3.g(arrayList);
        } else {
            gVar = null;
        }
        if (gVar != null && (list = gVar.a) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            fVar = (ks3.f) firstOrNull;
        } else {
            fVar = null;
        }
        if (gVar != null) {
            if (fVar != null) {
                startPlayStrategy = fVar.i;
            }
            if (startPlayStrategy != StartPlayStrategy.Default) {
                if (fVar != null && (str = fVar.b) != null) {
                    B(str, fVar);
                }
                return gVar;
            }
        }
        NsUiDepend.IMPL.recordDataManager().i(p());
        return gVar;
    }

    private final void j(String str, View view) {
        ConstraintLayout.LayoutParams layoutParams;
        if (view == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.dimensionRatio = str;
            view.setLayoutParams(layoutParams);
        }
    }

    public d(ViewStub autoPlayViewStub, ks3.a ability) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(autoPlayViewStub, "autoPlayViewStub");
        Intrinsics.checkNotNullParameter(ability, "ability");
        this.a = autoPlayViewStub;
        this.b = ability;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ks3.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                d.h x;
                x = d.x(d.this);
                return x;
            }
        });
        this.k = lazy;
        this.l = new g();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[EDGE_INSN: B:15:0x0044->B:16:0x0044 BREAK  A[LOOP:0: B:2:0x000e->B:34:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[LOOP:0: B:2:0x000e->B:34:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void B(java.lang.String r9, ks3.f r10) {
        /*
            r8 = this;
            com.dragon.read.NsUiDepend r0 = com.dragon.read.NsUiDepend.IMPL
            qo3.m0 r0 = r0.recordDataManager()
            java.util.List r0 = r0.k()
            java.util.Iterator r0 = r0.iterator()
        Le:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L43
            java.lang.Object r1 = r0.next()
            r4 = r1
            dv4.a r4 = (dv4.a) r4
            java.lang.String r5 = r4.e
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r9)
            if (r5 != 0) goto L3f
            java.lang.String r5 = r10.b
            int r5 = r5.length()
            if (r5 != 0) goto L2f
            r5 = 1
            goto L30
        L2f:
            r5 = 0
        L30:
            if (r5 == 0) goto L3d
            java.lang.String r4 = r4.k
            java.lang.String r5 = r10.a
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L3d
            goto L3f
        L3d:
            r4 = 0
            goto L40
        L3f:
            r4 = 1
        L40:
            if (r4 == 0) goto Le
            goto L44
        L43:
            r1 = 0
        L44:
            dv4.a r1 = (dv4.a) r1
            if (r1 == 0) goto L81
            java.lang.String r9 = r1.k
            int r9 = r9.length()
            if (r9 <= 0) goto L51
            r2 = 1
        L51:
            if (r2 == 0) goto L81
            java.lang.String r9 = r1.k
            java.lang.String r0 = "0"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            if (r9 != 0) goto L81
            java.lang.String r9 = r1.k
            r10.a(r9)
            java.lang.String r9 = r1.o
            r2 = 0
            long r4 = com.dragon.read.util.NumberUtils.parse(r9, r2)
            java.lang.String r9 = r1.n
            long r0 = com.dragon.read.util.NumberUtils.parse(r9, r2)
            int r9 = r10.g
            int r9 = r9 * 1000
            long r6 = (long) r9
            long r4 = r4 - r6
            long r2 = kotlin.ranges.RangesKt.coerceAtLeast(r4, r2)
            long r0 = kotlin.ranges.RangesKt.coerceAtMost(r0, r2)
            int r9 = (int) r0
            r10.d = r9
        L81:
            com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView r9 = r8.h
            if (r9 == 0) goto L8a
            ks3.d$g r10 = r8.l
            r9.removeOnAttachStateChangeListener(r10)
        L8a:
            com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView r9 = r8.h
            if (r9 == 0) goto L93
            ks3.d$g r10 = r8.l
            r9.addOnAttachStateChangeListener(r10)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ks3.d.B(java.lang.String, ks3.f):void");
    }

    static /* synthetic */ void m(d dVar, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        dVar.l(f2);
    }
}
