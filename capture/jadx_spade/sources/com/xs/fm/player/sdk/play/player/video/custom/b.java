package com.xs.fm.player.sdk.play.player.video.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.common.utility.reflect.ReflectUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends FrameLayout {
    private final bl6.a a;
    private TTVideoEngine b;
    private yk6.b c;
    private boolean d;
    private com.xs.fm.player.sdk.play.player.video.custom.a e;
    private com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a f;
    private SurfaceTexture g;
    private Surface h;
    private FrameLayout i;
    private boolean j;
    private boolean k;
    private Context l;
    private float m;
    private int n;
    private int o;
    private boolean p;
    private ArrayList<Runnable> q;
    private boolean r;

    static {
        Covode.recordClassIndex(656015);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void E() {
    }

    private static Object r(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    protected final boolean getEnableSurfaceSync() {
        return this.p;
    }

    protected final yk6.b getMAudioProcessor() {
        return this.c;
    }

    protected final Context getMContext() {
        return this.l;
    }

    protected final FrameLayout getMCoverView() {
        return this.i;
    }

    protected final Surface getMSurface() {
        return this.h;
    }

    protected final SurfaceTexture getMSurfaceTexture() {
        return this.g;
    }

    protected final com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a getMSurfaceView() {
        return this.f;
    }

    protected final com.xs.fm.player.sdk.play.player.video.custom.a getMTextureView() {
        return this.e;
    }

    protected final TTVideoEngine getMVideoEngine() {
        return this.b;
    }

    protected final float getMWHRatio() {
        return this.m;
    }

    public final boolean getNotReleaseSurface() {
        return this.k;
    }

    public final boolean getReuseSurface() {
        return this.j;
    }

    public final Surface getSurface() {
        return this.h;
    }

    public final boolean getUseSurfaceView() {
        return this.d;
    }

    protected final int getVideoHeight() {
        return this.o;
    }

    protected final int getVideoWidth() {
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void H() {
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    protected final void u() {
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    private final void y() {
        if (this.i == null) {
            this.i = new FrameLayout(getContext());
            new FrameLayout.LayoutParams(-1, -1).gravity = 17;
            FrameLayout frameLayout = this.i;
            if (frameLayout != null) {
                frameLayout.bringToFront();
            }
            addView(this.i);
        }
    }

    public final void C() {
        if (!this.k) {
            this.a.d("releaseSurface: not notReleaseSurface mSurface = " + this.h, new Object[0]);
            TTVideoEngine tTVideoEngine = this.b;
            if (tTVideoEngine != null) {
                tTVideoEngine.setSurface(null);
            }
        }
    }

    public final void D() {
        TTVideoEngine tTVideoEngine;
        if (!this.k && (tTVideoEngine = this.b) != null) {
            tTVideoEngine.getLogger().setSurfaceSourceType("surface destroyed");
            VideoSurface textureSurface = tTVideoEngine.getTextureSurface();
            if (textureSurface != null) {
                textureSurface.setIntOption(9, 1);
                textureSurface.updateRenderSurface((Surface) null);
                textureSurface.setIntOption(9, 0);
            } else {
                long j = TTVideoEngineConfig.setSurfaceTimeoutForDestroy;
                if (j == Long.MIN_VALUE) {
                    j = tTVideoEngine.getLongOption(950);
                }
                tTVideoEngine.setSurfaceSync(null, j);
            }
        }
    }

    private final void F() {
        SurfaceTexture surfaceTexture;
        if (this.j && this.g != null && B()) {
            SurfaceTexture surfaceTexture2 = this.g;
            com.xs.fm.player.sdk.play.player.video.custom.a aVar = this.e;
            if (aVar != null) {
                surfaceTexture = aVar.getSurfaceTexture();
            } else {
                surfaceTexture = null;
            }
            if ((!Intrinsics.areEqual(surfaceTexture2, surfaceTexture)) && !A(this.g)) {
                com.xs.fm.player.sdk.play.player.video.custom.a aVar2 = this.e;
                if (aVar2 != null) {
                    SurfaceTexture surfaceTexture3 = this.g;
                    if (surfaceTexture3 == null) {
                        Intrinsics.throwNpe();
                    }
                    aVar2.setSurfaceTexture(surfaceTexture3);
                }
                this.a.d("onWindowVisibilityChanged setSurfaceTexture", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        Integer num;
        if (this.r) {
            this.a.d("execPendingActions: executingActions is ture, return", new Object[0]);
            return;
        }
        ArrayList<Runnable> arrayList = this.q;
        if (arrayList != null) {
            if (arrayList == null) {
                Intrinsics.throwNpe();
            }
            if (!arrayList.isEmpty()) {
                bl6.a aVar = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append("execPendingActions: start execPendingActions, pendingActions size = ");
                ArrayList<Runnable> arrayList2 = this.q;
                if (arrayList2 != null) {
                    num = Integer.valueOf(arrayList2.size());
                } else {
                    num = null;
                }
                sb.append(num);
                aVar.d(sb.toString(), new Object[0]);
                this.r = true;
                ArrayList<Runnable> arrayList3 = this.q;
                if (arrayList3 != null) {
                    Iterator it2 = new ArrayList(arrayList3).iterator();
                    while (it2.hasNext()) {
                        ((Runnable) it2.next()).run();
                    }
                }
                ArrayList<Runnable> arrayList4 = this.q;
                if (arrayList4 != null) {
                    arrayList4.clear();
                }
                this.r = false;
                return;
            }
        }
        this.a.d("execPendingActions: pendingActions is empty, return", new Object[0]);
    }

    public final boolean B() {
        Surface surface;
        if (this.d) {
            this.a.d("isSurfaceValid: useSurfaceView mSurface = " + this.h, new Object[0]);
            Surface surface2 = this.h;
            if (surface2 != null && surface2.isValid()) {
                return true;
            }
            return false;
        }
        this.a.d("isSurfaceValid: useTextureView mSurfaceTexture = " + this.g, new Object[0]);
        if (this.g != null && (surface = this.h) != null && surface.isValid()) {
            return true;
        }
        return false;
    }

    protected final void setEnableSurfaceSync(boolean z) {
        this.p = z;
    }

    protected final void setMAudioProcessor(yk6.b bVar) {
        this.c = bVar;
    }

    protected final void setMContext(Context context) {
        this.l = context;
    }

    protected final void setMCoverView(FrameLayout frameLayout) {
        this.i = frameLayout;
    }

    protected final void setMSurface(Surface surface) {
        this.h = surface;
    }

    protected final void setMSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.g = surfaceTexture;
    }

    protected final void setMSurfaceView(com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a aVar) {
        this.f = aVar;
    }

    protected final void setMTextureView(com.xs.fm.player.sdk.play.player.video.custom.a aVar) {
        this.e = aVar;
    }

    protected final void setMVideoEngine(TTVideoEngine tTVideoEngine) {
        this.b = tTVideoEngine;
    }

    protected final void setMWHRatio(float f) {
        this.m = f;
    }

    public final void setNotReleaseSurface(boolean z) {
        this.k = z;
    }

    public final void setReuseSurface(boolean z) {
        this.j = z;
    }

    public final void setTTVideoEngine(TTVideoEngine tTVideoEngine) {
        this.b = tTVideoEngine;
    }

    public final void setUseSurfaceView(boolean z) {
        this.d = z;
    }

    protected final void setVideoHeight(int i) {
        this.o = i;
    }

    protected final void setVideoWidth(int i) {
        this.n = i;
    }

    public final void setWHRatio(float f) {
        this.m = f;
    }

    public static final class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            b.this.a.d("surfaceCreated, mSurface= " + b.this.getMSurface() + ", mVideoEngine=" + b.this.getMVideoEngine() + ", this = " + this + "@NewMiddleVideoView", new Object[0]);
            b.this.u();
            b.this.setMSurface(surfaceHolder.getSurface());
            TTVideoEngine mVideoEngine = b.this.getMVideoEngine();
            if (mVideoEngine != null) {
                mVideoEngine.setSurface(b.this.getMSurface());
            }
            b.this.x();
            TTVideoEngine mVideoEngine2 = b.this.getMVideoEngine();
            if (mVideoEngine2 != null) {
                mVideoEngine2.forceDraw();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (b.this.getEnableSurfaceSync()) {
                b.this.a.d("surfaceDestroyed, enableSurfaceSync = " + b.this.getEnableSurfaceSync() + ", releaseSurfaceNew,this = " + this + "@NewMiddleVideoView", new Object[0]);
                b.this.D();
                return;
            }
            b.this.a.d("surfaceDestroyed, not enableSurfaceSync = " + b.this.getEnableSurfaceSync() + ", releaseSurface,this = " + this + "@NewMiddleVideoView", new Object[0]);
            b.this.C();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            b.this.a.d("surfaceChanged, this = " + this + "@NewMiddleVideoView, format = " + i + ", width = " + i2 + ", height = " + i3, new Object[0]);
        }
    }

    /* renamed from: com.xs.fm.player.sdk.play.player.video.custom.b$b, reason: collision with other inner class name */
    public static final class TextureViewSurfaceTextureListenerC0135b implements TextureView.SurfaceTextureListener {
        TextureViewSurfaceTextureListenerC0135b() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.a.d("onSurfaceTextureUpdated, this = " + this + "@NewMiddleVideoView", new Object[0]);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.a.d("onSurfaceTextureDestroyed, this = " + this + "@NewMiddleVideoView", new Object[0]);
            if (b.this.getReuseSurface()) {
                b.this.a.d("onSurfaceTextureDestroyed, reuseSurface, not release mSurfaceTexture and mSurface", new Object[0]);
            } else {
                SurfaceTexture mSurfaceTexture = b.this.getMSurfaceTexture();
                if (mSurfaceTexture != null) {
                    mSurfaceTexture.release();
                }
                b.this.setMSurfaceTexture(null);
                Surface mSurface = b.this.getMSurface();
                if (mSurface != null) {
                    mSurface.release();
                }
                b.this.setMSurface(null);
                b.this.a.d("onSurfaceTextureDestroyed, not reuseSurface, release mSurfaceTexture and let mSurface = null", new Object[0]);
            }
            return !b.this.getReuseSurface();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.a.d("onSurfaceTextureSizeChanged, this = " + this + "@NewMiddleVideoView", new Object[0]);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.a.d("onSurfaceTextureAvailable, this = " + this + "@NewMiddleVideoView", new Object[0]);
            if (b.this.getReuseSurface()) {
                if (b.this.getMSurface() == null) {
                    b.this.setMSurfaceTexture(surfaceTexture);
                    b.this.setMSurface(new Surface(b.this.getMSurfaceTexture()));
                    b.this.a.d("onSurfaceTextureAvailable, reuseSurface, mSurface==null and create, mSurfaceTexture = " + b.this.getMSurfaceTexture() + ", mSurface = " + b.this.getMSurface(), new Object[0]);
                }
            } else {
                b.this.setMSurfaceTexture(surfaceTexture);
                b.this.setMSurface(new Surface(b.this.getMSurfaceTexture()));
                b.this.a.d("onSurfaceTextureAvailable, not reuseSurface, mSurfaceTexture = " + b.this.getMSurfaceTexture() + ", mSurface = " + b.this.getMSurface(), new Object[0]);
            }
            b.this.x();
        }
    }

    protected final void l(View view) {
        y();
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.addView(view);
        }
    }

    private final void v(Runnable runnable) {
        if (this.q == null) {
            this.q = new ArrayList<>();
        }
        ArrayList<Runnable> arrayList = this.q;
        if (arrayList != null) {
            arrayList.add(runnable);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (getVisibility() == 0 && i == 0) {
            if (this.d) {
                E();
            } else {
                F();
            }
        }
    }

    public final void setTextureVideoStyle(int i) {
        if (this.d) {
            com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a aVar = this.f;
            if (aVar != null) {
                aVar.setTextureVideoStyle(i);
                return;
            }
            return;
        }
        com.xs.fm.player.sdk.play.player.video.custom.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.setTextureVideoStyle(i);
        }
    }

    private final boolean A(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return surfaceTexture.isReleased();
        }
        Method method = ReflectUtils.getMethod(SurfaceTexture.class, "isReleased", (Class[]) null);
        if (method != null) {
            try {
                Object r = r(method, surfaceTexture, new Object[0]);
                if (r instanceof Boolean) {
                    return ((Boolean) r).booleanValue();
                }
            } catch (IllegalAccessException e) {
                this.a.b("isSurfaceTextureReleased, error = " + Log.getStackTraceString(e), new Object[0]);
            } catch (InvocationTargetException e2) {
                this.a.b("isSurfaceTextureReleased, error = " + Log.getStackTraceString(e2), new Object[0]);
            }
        }
        return false;
    }

    public final void w(Runnable runnable) {
        if (runnable == null) {
            this.a.d("execAction: action is null return", new Object[0]);
            return;
        }
        if (B()) {
            this.a.d("execAction: isSurfaceValid action run mSurface = " + this.h, new Object[0]);
            runnable.run();
            return;
        }
        this.a.d("execAction: not isSurfaceValid enqueueAction action run mSurface = " + this.h, new Object[0]);
        v(runnable);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.m == 0.0f) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.m), View.MeasureSpec.getMode(i2)));
        }
    }

    protected final void G(int i, int i2) {
        if (this.n != i || this.o != i2) {
            this.a.d("setVideoSize, width = " + i + ", height = " + i2, new Object[0]);
            this.n = i;
            this.o = i2;
            if (this.d) {
                com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a aVar = this.f;
                if (aVar != null) {
                    aVar.c(i, i2);
                    return;
                }
                return;
            }
            com.xs.fm.player.sdk.play.player.video.custom.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.a(i, i2);
            }
        }
    }

    private final void z(Context context, AttributeSet attributeSet) {
        boolean z;
        SurfaceHolder holder;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{2130774520, 2130774547});
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.CommonVideoView)");
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (!this.d && !z2) {
            z = false;
        } else {
            z = true;
        }
        this.d = z;
        this.l = context;
        if (z) {
            this.f = new com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a(context, null, 0, 6, null);
            this.a.d("initView: useSurfaceView mSurfaceView = " + this.f, new Object[0]);
        } else {
            this.e = new com.xs.fm.player.sdk.play.player.video.custom.a(context, null, 0, 6, null);
            this.a.d("initView: use mTextureView mTextureView = " + this.e, new Object[0]);
        }
        setBackgroundColor(-16777216);
        this.m = 0.5625f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (this.d) {
            addView(this.f, layoutParams);
            com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a aVar = this.f;
            if (aVar != null && (holder = aVar.getHolder()) != null) {
                holder.addCallback(new a());
                return;
            }
            return;
        }
        addView(this.e, layoutParams);
        com.xs.fm.player.sdk.play.player.video.custom.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.setSurfaceTextureListener(new TextureViewSurfaceTextureListenerC0135b());
        }
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new bl6.a("FMSDKPlayerTrace-NewMiddleVideoView");
        this.j = true;
        this.m = 0.5625f;
        z(context, attributeSet);
    }

    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
