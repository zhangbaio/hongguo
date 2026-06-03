package ak6;

import ak6.a;
import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import bk6.a;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.videoshop.api.VideoStateInquirer;
import com.ss.android.videoshop.layer.stub.BaseVideoLayer;
import eh6.e;
import eh6.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends BaseVideoLayer {
    protected int a;
    protected float b;
    protected int c;
    protected int d;
    public boolean e;
    protected VelocityTracker f;
    protected int g;
    protected ak6.a h;
    private float k;
    protected boolean l;
    private final float i = 0.8f;
    private final float j = 0.8f;
    public final a.InterfaceC0002a m = new a();
    public final a.e n = new C0003b();
    public final GestureDetector.SimpleOnGestureListener o = new c();

    static {
        Covode.recordClassIndex(654956);
    }

    public void A0(com.ss.android.videoshop.mediaview.b bVar) {
    }

    public boolean B0(boolean z, int i) {
        return true;
    }

    public boolean D0() {
        return false;
    }

    public void d0() {
    }

    public boolean f0(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public boolean g0() {
        return false;
    }

    public int getZIndex() {
        return -1;
    }

    public boolean h0() {
        return false;
    }

    public boolean i0() {
        return false;
    }

    public boolean j0() {
        return true;
    }

    public void k0() {
    }

    public void n0(MotionEvent motionEvent) {
    }

    public void o0(MotionEvent motionEvent) {
    }

    public void p0(MotionEvent motionEvent) {
    }

    public void q0() {
    }

    public void r0() {
    }

    public void s0() {
    }

    public void v0(com.ss.android.videoshop.mediaview.b bVar, boolean z) {
    }

    public void x0(int i) {
    }

    public void y0(boolean z) {
    }

    public boolean z0(int i) {
        return true;
    }

    public static final class a implements a.InterfaceC0002a {
        @Override // ak6.a.InterfaceC0002a
        public boolean d() {
            return b.this.j0();
        }

        @Override // ak6.a.InterfaceC0002a
        public void e() {
            b.this.d0();
        }

        @Override // ak6.a.InterfaceC0002a
        public boolean g() {
            return b.this.i0();
        }

        @Override // ak6.a.InterfaceC0002a
        public void i() {
            b.this.k0();
        }

        @Override // ak6.a.InterfaceC0002a
        public boolean isFullScreen() {
            return b.this.e;
        }

        a() {
        }

        @Override // ak6.a.InterfaceC0002a
        public void b(boolean z) {
            b.this.y0(z);
        }

        @Override // ak6.a.InterfaceC0002a
        public void c(int i) {
            b.this.x0(i);
        }

        @Override // ak6.a.InterfaceC0002a
        public void f(MotionEvent motionEvent) {
            b.this.p0(motionEvent);
        }

        @Override // ak6.a.InterfaceC0002a
        public void h(com.ss.android.videoshop.mediaview.b bVar) {
            b.this.A0(bVar);
        }

        @Override // ak6.a.InterfaceC0002a
        public void a(com.ss.android.videoshop.mediaview.b bVar, boolean z) {
            b.this.v0(bVar, z);
        }
    }

    /* renamed from: ak6.b$b, reason: collision with other inner class name */
    public static final class C0003b implements a.e {
        @Override // bk6.a.e
        public void a() {
            b.this.s0();
        }

        @Override // bk6.a.e
        public void b() {
            b.this.r0();
        }

        @Override // bk6.a.e
        public void c() {
            b.this.q0();
        }

        C0003b() {
        }
    }

    public ArrayList<Integer> getSupportEvents() {
        return new ArrayList<>();
    }

    protected final void C0() {
        int maxVolume;
        VideoStateInquirer videoStateInquirer = getVideoStateInquirer();
        if (videoStateInquirer == null || (maxVolume = (int) videoStateInquirer.getMaxVolume()) <= 0) {
            return;
        }
        float f = maxVolume;
        float volume = (((int) videoStateInquirer.getVolume()) * 100.0f) / f;
        if (Math.abs(volume - this.k) > 100.0f / f) {
            this.k = volume;
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return b.this.l0(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return b.this.m0(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            b.this.o0(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return b.this.u0(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return b.this.t0(motionEvent, motionEvent2, f, f2);
        }
    }

    public boolean handleVideoEvent(l lVar) {
        if (lVar != null) {
            return super.handleVideoEvent(lVar);
        }
        return false;
    }

    protected ak6.a X(Context context) {
        bk6.a aVar = new bk6.a(context);
        if (!D0()) {
            aVar.m(false);
        }
        aVar.setGestureCallback(this.m);
        aVar.setResizeListener(this.n);
        aVar.setSimpleOnGestureListener(this.o);
        return aVar;
    }

    public void onRegister(hh6.a aVar) {
        super.onRegister(aVar);
        this.g = (int) UIUtils.dip2Px(getContext(), 40.0f);
    }

    public boolean u0(MotionEvent motionEvent) {
        hh6.a host = getHost();
        if (host != null) {
            host.notifyEvent(new e(1050));
            return true;
        }
        return true;
    }

    public boolean l0(MotionEvent motionEvent) {
        VideoStateInquirer videoStateInquirer = getVideoStateInquirer();
        if (videoStateInquirer != null) {
            if (videoStateInquirer.isPlaying()) {
                getHost().execCommand(new wg6.b(208));
                return true;
            }
            getHost().execCommand(new wg6.b(207));
            return true;
        }
        return false;
    }

    public float w0(float f) {
        Window window;
        WindowManager.LayoutParams attributes;
        Context context = getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return -1.0f;
        }
        float f2 = attributes.screenBrightness;
        if (f2 < 0.0f || f2 > 1.0f) {
            f2 = ck6.b.c(activity);
        }
        float a2 = ck6.a.a(f2 - f, 0.0f, 1.0f);
        attributes.screenBrightness = a2;
        window.setAttributes(attributes);
        return a2;
    }

    public boolean m0(MotionEvent motionEvent) {
        this.a = 0;
        int screenWidth = UIUtils.getScreenWidth(getContext());
        int screenHeight = UIUtils.getScreenHeight(getContext());
        if (this.e && !h0() && screenHeight > screenWidth) {
            this.c = screenHeight;
            this.d = screenWidth;
        } else {
            this.c = screenWidth;
            this.d = screenHeight;
        }
        if (this.b == 0.0f) {
            Intrinsics.checkExpressionValueIsNotNull(ViewConfiguration.get(getContext()), "ViewConfiguration.get(context)");
            this.b = r0.getScaledTouchSlop() / 2;
        }
        n0(motionEvent);
        return true;
    }

    public List<Pair<View, RelativeLayout.LayoutParams>> onCreateView(Context context, LayoutInflater layoutInflater) {
        this.h = X(context);
        List<Pair<View, RelativeLayout.LayoutParams>> onCreateView = super.onCreateView(context, layoutInflater);
        Intrinsics.checkExpressionValueIsNotNull(onCreateView, "super.onCreateView(context, inflater)");
        return onCreateView;
    }

    public void W(boolean z, float f) {
        int i;
        int roundToInt;
        int roundToInt2;
        VideoStateInquirer videoStateInquirer = getVideoStateInquirer();
        if (videoStateInquirer != null) {
            i = (int) videoStateInquirer.getMaxVolume();
        } else {
            i = 0;
        }
        if (i <= 0) {
            return;
        }
        float f2 = this.k;
        if (!z) {
            f = -f;
        }
        float f3 = f2 + f;
        this.k = f3;
        float a2 = ck6.a.a(f3, 0.0f, 100.0f);
        this.k = a2;
        roundToInt = MathKt__MathJVMKt.roundToInt((a2 * i) / 100);
        hh6.a host = getHost();
        if (host != null) {
            host.execCommand(new wg6.b(213, Integer.valueOf(roundToInt)));
        }
        roundToInt2 = MathKt__MathJVMKt.roundToInt(this.k);
        B0(z, roundToInt2);
    }

    public void Z(float f, int i, float f2, float f3) {
        if (f2 != 0.0f && f3 > 0) {
            z0(ck6.a.b((int) (w0((this.i * f2) / f3) * 100), 0, 100));
        }
    }

    public void e0(float f, int i, float f2, int i2) {
        if (f2 != 0.0f && i2 > 0) {
            boolean z = false;
            if (this.l && getVideoStateInquirer() != null) {
                this.l = false;
                C0();
            }
            float abs = ((this.j * Math.abs(f2)) / i2) * 100;
            if (f2 < 0) {
                z = true;
            }
            W(z, abs);
        }
    }

    public long Y(boolean z, float f, float f2, float f3) {
        ak6.a aVar = this.h;
        if (aVar != null) {
            int width = aVar.getWidth();
            if (getVideoStateInquirer() != null) {
                float f4 = f / width;
                VideoStateInquirer videoStateInquirer = getVideoStateInquirer();
                Intrinsics.checkExpressionValueIsNotNull(videoStateInquirer, "videoStateInquirer");
                long duration = (long) (f4 * videoStateInquirer.getDuration());
                if (z) {
                    VideoStateInquirer videoStateInquirer2 = getVideoStateInquirer();
                    Intrinsics.checkExpressionValueIsNotNull(videoStateInquirer2, "videoStateInquirer");
                    return duration + videoStateInquirer2.getCurrentPosition();
                }
                VideoStateInquirer videoStateInquirer3 = getVideoStateInquirer();
                Intrinsics.checkExpressionValueIsNotNull(videoStateInquirer3, "videoStateInquirer");
                return videoStateInquirer3.getCurrentPosition() - duration;
            }
        }
        return 0L;
    }

    public void a0(float f, float f2, float f3, float f4) {
        float f5;
        ViewParent parent;
        VelocityTracker velocityTracker = this.f;
        if (velocityTracker != null) {
            f5 = velocityTracker.getXVelocity();
        } else {
            f5 = 0.0f;
        }
        float abs = Math.abs(f5);
        int i = (int) (this.c * 0.9f);
        float f6 = 0;
        if (f2 > f6) {
            c0(false, f3, f, i, f4, abs);
        } else if (f2 < f6) {
            c0(true, f3, f, i, f4, abs);
        }
        ak6.a aVar = this.h;
        if (aVar != null && (parent = aVar.getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0090, code lost:
    
        if ((r16.d - r7) >= r2) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean t0(android.view.MotionEvent r17, android.view.MotionEvent r18, float r19, float r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = 0
            if (r1 == 0) goto Lcd
            if (r2 == 0) goto Lcd
            float r6 = r17.getX()
            float r7 = r17.getY()
            float r8 = r18.getX()
            float r9 = r18.getY()
            float r10 = java.lang.Math.abs(r19)
            float r11 = java.lang.Math.abs(r20)
            float r12 = r8 - r6
            float r12 = java.lang.Math.abs(r12)
            float r9 = r9 - r7
            float r9 = java.lang.Math.abs(r9)
            android.view.VelocityTracker r13 = r0.f
            if (r13 != 0) goto L3c
            android.view.VelocityTracker r13 = android.view.VelocityTracker.obtain()
            r0.f = r13
        L3c:
            android.view.VelocityTracker r13 = r0.f
            if (r13 == 0) goto L45
            r14 = 1000(0x3e8, float:1.401E-42)
            r13.computeCurrentVelocity(r14)
        L45:
            android.view.VelocityTracker r13 = r0.f
            if (r13 == 0) goto L4c
            r13.addMovement(r2)
        L4c:
            int r13 = r0.a
            r15 = 1
            r14 = 2
            if (r13 > 0) goto L65
            int r13 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r13 <= 0) goto L58
            r13 = 1
            goto L63
        L58:
            int r13 = r0.c
            int r13 = r13 / r14
            float r13 = (float) r13
            int r13 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r13 <= 0) goto L62
            r13 = 2
            goto L63
        L62:
            r13 = 3
        L63:
            r0.a = r13
        L65:
            boolean r1 = r0.f0(r1, r2, r12, r9)
            if (r1 == 0) goto L6c
            return r5
        L6c:
            boolean r1 = r16.g0()
            if (r1 == 0) goto L7e
            boolean r1 = r0.e
            if (r1 != 0) goto L7e
            int r1 = r0.a
            if (r1 != r15) goto Lcd
            r0.a0(r8, r3, r10, r6)
            goto Lcd
        L7e:
            boolean r1 = r0.e
            if (r1 == 0) goto L92
            int r2 = r0.g
            float r9 = (float) r2
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto Lcd
            int r9 = r0.d
            float r9 = (float) r9
            float r9 = r9 - r7
            float r2 = (float) r2
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 < 0) goto Lcd
        L92:
            if (r1 == 0) goto La3
            boolean r1 = r16.h0()
            if (r1 == 0) goto La3
            ak6.a r1 = r0.h
            if (r1 == 0) goto Lac
            int r1 = r1.getHeight()
            goto Lad
        La3:
            ak6.a r1 = r0.h
            if (r1 == 0) goto Lac
            int r1 = r1.getHeight()
            goto Lad
        Lac:
            r1 = 0
        Lad:
            int r2 = r0.a
            r7 = 3
            if (r2 != r7) goto Lba
            int r2 = r0.c
            float r3 = -r4
            float r1 = (float) r1
            r0.Z(r6, r2, r3, r1)
            goto Lcd
        Lba:
            if (r2 != r14) goto Lc8
            float r2 = (float) r5
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 <= 0) goto Lcd
            int r2 = r0.c
            float r3 = -r4
            r0.e0(r6, r2, r3, r1)
            goto Lcd
        Lc8:
            if (r2 != r15) goto Lcd
            r0.a0(r8, r3, r10, r6)
        Lcd:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ak6.b.t0(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public void c0(boolean z, float f, float f2, int i, float f3, float f4) {
        long j;
        long Y = Y(z, f, f3, f4);
        VideoStateInquirer videoStateInquirer = getVideoStateInquirer();
        if (videoStateInquirer != null) {
            j = videoStateInquirer.getDuration();
        } else {
            j = 0;
        }
        notifyEvent(new xg6.a(Y, j, false));
    }
}
