package com.dragon.read.component.shortvideo.autoplay.common;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.base.basescale.ScaleImageView;
import com.dragon.read.base.skin.SkinDelegate;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import com.dragon.read.component.shortvideo.autoplay.VideoAutoPlayType;
import com.dragon.read.component.shortvideo.autoplay.common.StaggerAutoPlayVideoView;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.report.ReportManager;
import com.dragon.read.util.c2;
import com.dragon.read.util.kotlin.UIKt;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.Postprocessor;
import com.ss.android.videoshop.api.VideoStateInquirer;
import com.ss.android.videoshop.entity.PlayEntity;
import is3.j;
import is3.l;
import is3.m;
import is3.n;
import is3.r;
import is3.s;
import iw5.b;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StaggerAutoPlayVideoView extends FrameLayout implements r {
    public static final a k;
    public static final int l;
    private l a;
    private SimpleDraweeView b;
    private ScaleImageView c;
    private js3.c d;
    private final f e;
    private g f;
    private c g;
    private d h;
    private b i;
    private VideoAutoPlayType j;

    public static final class a {
        static {
            Covode.recordClassIndex(598937);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        boolean a();

        void b();

        boolean c();
    }

    public interface c {
        void a(boolean z);
    }

    public interface d {
        boolean b();

        void c(SaasVideoData saasVideoData);

        int getPosition();

        String getTag();
    }

    static {
        Covode.recordClassIndex(598936);
        k = new a(null);
        l = 8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StaggerAutoPlayVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final l getCommonPlayView() {
        return this.a;
    }

    public final ScaleImageView getPlayControlBtn() {
        return this.c;
    }

    public final VideoAutoPlayType getPlayType() {
        return this.j;
    }

    public static final class f extends is3.a {
        @Override // is3.m
        public b.c.b i(SaasVideoData saasVideoData) {
            return null;
        }

        @Override // is3.m
        public n a() {
            return StaggerAutoPlayVideoView.this.f;
        }

        f() {
            super(null);
        }
    }

    private final void n() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // is3.r
    public boolean a() {
        return r.a.a(this);
    }

    @Override // is3.r
    public void d() {
        l lVar = this.a;
        if (lVar != null) {
            lVar.release();
        }
    }

    @Override // is3.r
    public void f() {
        l lVar = this.a;
        if (lVar != null) {
            lVar.pause();
        }
    }

    @Override // is3.r
    public int getViewHeight() {
        return getHeight();
    }

    @Override // is3.r
    public boolean b() {
        d dVar = this.h;
        if (dVar != null) {
            return dVar.b();
        }
        return false;
    }

    @Override // is3.r
    public int getPosition() {
        d dVar = this.h;
        if (dVar != null) {
            return dVar.getPosition();
        }
        return -1;
    }

    @Override // android.view.View
    public String getTag() {
        d dVar = this.h;
        if (dVar != null) {
            return dVar.getTag();
        }
        return null;
    }

    @Override // is3.r
    public boolean isPlaying() {
        l lVar = this.a;
        if (lVar != null) {
            return lVar.isPlaying();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        js3.c cVar = this.d;
        if (cVar != null) {
            cVar.i(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        js3.c cVar = this.d;
        if (cVar != null) {
            cVar.q(this);
        }
    }

    @Override // is3.r
    public void c() {
        b bVar = this.i;
        boolean z = false;
        if (bVar != null && bVar.c()) {
            z = true;
        }
        if (z) {
            n();
        }
        l lVar = this.a;
        if (lVar != null) {
            lVar.resume();
        }
    }

    @Override // is3.r
    public Pair<Rect, Boolean> getGlobalVisibleRect() {
        Rect rect = new Rect();
        return TuplesKt.to(rect, Boolean.valueOf(UIKt.getRealGlobalVisibleRect(this, rect)));
    }

    private final void o() {
        View view;
        Args args = new Args();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        j autoPlaySeries = NsShortVideoApi.IMPL.autoPlaySeries();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.a = autoPlaySeries.b(context, this.e);
        args.put("obtain_video_view_cost_time", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2));
        l lVar = this.a;
        if (lVar != null) {
            view = lVar.getView();
        } else {
            view = null;
        }
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        View simpleDraweeView = new SimpleDraweeView(getContext());
        simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        SkinDelegate.setPlaceHolder(simpleDraweeView, 2130848273);
        this.b = simpleDraweeView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        Unit unit = Unit.INSTANCE;
        addView(simpleDraweeView, layoutParams);
        ScaleImageView scaleImageView = new ScaleImageView(getContext());
        this.c = scaleImageView;
        scaleImageView.setOnClickListener(new View.OnClickListener() { // from class: js3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StaggerAutoPlayVideoView.p(StaggerAutoPlayVideoView.this, view2);
            }
        });
        m(true);
        View view2 = this.c;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UIKt.getDp(20), UIKt.getDp(20));
        layoutParams2.gravity = 8388693;
        layoutParams2.rightMargin = UIKt.getDp(10);
        layoutParams2.bottomMargin = UIKt.getDp(6);
        addView(view2, layoutParams2);
        args.put("init_video_video_cost_time", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        ReportManager.onReport("init_video_view_cost_monitor", args);
    }

    public final void setAutoPlayManager(js3.c cVar) {
        this.d = cVar;
    }

    public static final class g extends is3.b {
        g() {
            super(null);
        }

        @Override // is3.b
        public void onVideoPause(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            boolean z;
            String str;
            super.onVideoPause(videoStateInquirer, playEntity);
            StaggerAutoPlayVideoView.this.m(true);
            b bVar = StaggerAutoPlayVideoView.this.i;
            if (bVar != null && bVar.a()) {
                z = true;
            } else {
                z = false;
            }
            Uri uri = null;
            if (z) {
                SimpleDraweeView simpleDraweeView = StaggerAutoPlayVideoView.this.b;
                if (simpleDraweeView != null) {
                    com.dragon.read.recyler.r.d(simpleDraweeView, 0L, 1, (Object) null);
                }
            } else {
                SimpleDraweeView simpleDraweeView2 = StaggerAutoPlayVideoView.this.b;
                if (simpleDraweeView2 != null) {
                    UIKt.gone(simpleDraweeView2);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoPause autoPlayCover?.gone() vid ");
            if (playEntity != null) {
                str = playEntity.getVideoId();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(" imageUrl ");
            SimpleDraweeView simpleDraweeView3 = StaggerAutoPlayVideoView.this.b;
            if (simpleDraweeView3 != null) {
                uri = simpleDraweeView3.getImageUri();
            }
            sb.append(uri);
            LogWrapper.debug("StaggerAutoPlayVideoView", sb.toString(), new Object[0]);
        }

        @Override // is3.b
        public void onVideoPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            String str;
            Uri uri;
            super.onVideoPlay(videoStateInquirer, playEntity);
            boolean z = false;
            StaggerAutoPlayVideoView.this.m(false);
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoPlay autoPlayCover?.gone() vid ");
            if (playEntity != null) {
                str = playEntity.getVideoId();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(" imageUrl ");
            SimpleDraweeView simpleDraweeView = StaggerAutoPlayVideoView.this.b;
            if (simpleDraweeView != null) {
                uri = simpleDraweeView.getImageUri();
            } else {
                uri = null;
            }
            sb.append(uri);
            LogWrapper.debug("StaggerAutoPlayVideoView", sb.toString(), new Object[0]);
            b bVar = StaggerAutoPlayVideoView.this.i;
            if (bVar != null && bVar.a()) {
                z = true;
            }
            if (z) {
                SimpleDraweeView simpleDraweeView2 = StaggerAutoPlayVideoView.this.b;
                if (simpleDraweeView2 != null) {
                    com.dragon.read.recyler.r.d(simpleDraweeView2, 0L, 1, (Object) null);
                    return;
                }
                return;
            }
            SimpleDraweeView simpleDraweeView3 = StaggerAutoPlayVideoView.this.b;
            if (simpleDraweeView3 != null) {
                UIKt.gone(simpleDraweeView3);
            }
        }

        @Override // is3.b
        public void onVideoReleased(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            String str;
            ViewPropertyAnimator animate;
            super.onVideoReleased(videoStateInquirer, playEntity);
            boolean z = true;
            StaggerAutoPlayVideoView.this.m(true);
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoReleased autoPlayCover?.visible() vid ");
            Uri uri = null;
            if (playEntity != null) {
                str = playEntity.getVideoId();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(" imageUrl ");
            SimpleDraweeView simpleDraweeView = StaggerAutoPlayVideoView.this.b;
            if (simpleDraweeView != null) {
                uri = simpleDraweeView.getImageUri();
            }
            sb.append(uri);
            LogWrapper.debug("StaggerAutoPlayVideoView", sb.toString(), new Object[0]);
            b bVar = StaggerAutoPlayVideoView.this.i;
            if (bVar == null || !bVar.a()) {
                z = false;
            }
            if (z) {
                SimpleDraweeView simpleDraweeView2 = StaggerAutoPlayVideoView.this.b;
                if (simpleDraweeView2 != null) {
                    simpleDraweeView2.setAlpha(1.0f);
                }
                SimpleDraweeView simpleDraweeView3 = StaggerAutoPlayVideoView.this.b;
                if (simpleDraweeView3 != null && (animate = simpleDraweeView3.animate()) != null) {
                    animate.cancel();
                }
            }
            SimpleDraweeView simpleDraweeView4 = StaggerAutoPlayVideoView.this.b;
            if (simpleDraweeView4 != null) {
                UIKt.visible(simpleDraweeView4);
            }
        }
    }

    public final void setStaggerAutoPlayViewListener(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = listener;
    }

    public final void setStaggerAutoPlayViewProgressDepend(b depend) {
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.i = depend;
    }

    public final void setStaggerAutoPlayViewProtocol(d protocol) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.h = protocol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean z) {
        int i;
        ScaleImageView scaleImageView = this.c;
        if (scaleImageView != null) {
            scaleImageView.setTag(Boolean.valueOf(z));
        }
        ScaleImageView scaleImageView2 = this.c;
        if (scaleImageView2 != null) {
            if (z) {
                i = 2130841002;
            } else {
                i = 2130841001;
            }
            scaleImageView2.setImageResource(i);
        }
    }

    public final void setAutoPlayViewDepend(m depend) {
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.e.a = depend;
        this.f.a = depend.a();
    }

    @Override // is3.r
    public void e(VideoAutoPlayType playType) {
        SaasVideoData saasVideoData;
        s dataProvider;
        Intrinsics.checkNotNullParameter(playType, "playType");
        d dVar = this.h;
        if (dVar != null) {
            l lVar = this.a;
            if (lVar != null && (dataProvider = lVar.getDataProvider()) != null) {
                saasVideoData = dataProvider.getVideoData();
            } else {
                saasVideoData = null;
            }
            dVar.c(saasVideoData);
        }
        l lVar2 = this.a;
        if (lVar2 != null) {
            l.a.a(lVar2, null, 1, null);
        }
        this.j = playType;
    }

    public final void l(e data) {
        Intrinsics.checkNotNullParameter(data, "data");
        l lVar = this.a;
        if (lVar != null) {
            lVar.a(data.b);
        }
        SimpleDraweeView simpleDraweeView = this.b;
        if (simpleDraweeView != null) {
            UIKt.visible(simpleDraweeView);
            c2.i(c2.a, simpleDraweeView, data.a, false, data.c, (ImageOriginListener) null, (Postprocessor) null, (ControllerListener) null, (String) null, (Drawable) null, (Drawable) null, false, 2036, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(StaggerAutoPlayVideoView staggerAutoPlayVideoView, View view) {
        Object obj;
        boolean z;
        ScaleImageView scaleImageView = staggerAutoPlayVideoView.c;
        Boolean bool = null;
        if (scaleImageView != null) {
            obj = scaleImageView.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        }
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = true;
        }
        if (z) {
            l lVar = staggerAutoPlayVideoView.a;
            if (lVar != null) {
                lVar.resume();
            }
            js3.c cVar = staggerAutoPlayVideoView.d;
            if (cVar != null) {
                cVar.k(staggerAutoPlayVideoView);
            }
        } else {
            l lVar2 = staggerAutoPlayVideoView.a;
            if (lVar2 != null) {
                lVar2.pause();
            }
        }
        staggerAutoPlayVideoView.m(!z);
        c cVar2 = staggerAutoPlayVideoView.g;
        if (cVar2 != null) {
            cVar2.a(z);
        }
    }

    public static final class e {
        public static final int d;
        public final String a;
        public final s b;
        public final hs4.a c;

        static {
            Covode.recordClassIndex(598943);
            d = hs4.a.k;
        }

        public e(String cover, s data, hs4.a aVar) {
            Intrinsics.checkNotNullParameter(cover, "cover");
            Intrinsics.checkNotNullParameter(data, "data");
            this.a = cover;
            this.b = data;
            this.c = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerAutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = new f();
        this.f = new g();
        this.j = VideoAutoPlayType.AUTO_PLAY;
        o();
    }

    public /* synthetic */ StaggerAutoPlayVideoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
