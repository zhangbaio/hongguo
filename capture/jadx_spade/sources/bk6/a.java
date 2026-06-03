package bk6;

import ak6.a;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import bk6.b;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends ak6.a {
    private boolean a;
    private boolean b;
    private TextView c;
    private a.InterfaceC0002a d;
    private e e;
    private Rect f;
    private RectF g;
    private com.ss.android.videoshop.mediaview.d h;
    public TextView i;
    private ScaleGestureDetector j;
    private GestureDetectorCompat k;
    private bk6.b l;
    private GestureDetector m;
    private GestureDetector.SimpleOnGestureListener n;
    private int o;
    private int p;
    private final ScaleGestureDetector.SimpleOnScaleGestureListener q;
    private final GestureDetector.SimpleOnGestureListener r;
    private final b.AbstractC0006b s;

    public interface e {
        void a();

        void b();

        void c();
    }

    static {
        Covode.recordClassIndex(654958);
    }

    private void i() {
        e eVar = this.e;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        e eVar = this.e;
        if (eVar != null) {
            eVar.b();
        }
    }

    private void k() {
        e eVar = this.e;
        if (eVar != null) {
            eVar.a();
        }
    }

    private int h() {
        return Math.min(2, Math.min(2, 2));
    }

    public float getCurrentRotateDegree() {
        com.ss.android.videoshop.mediaview.d dVar = this.h;
        if (dVar != null) {
            return dVar.getRotation() % 360.0f;
        }
        return 0.0f;
    }

    public Boolean getResetBtnVisibility() {
        boolean z;
        TextView textView = this.c;
        if (textView != null && textView.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        com.ss.android.videoshop.mediaview.d dVar = this.h;
        if (dVar != null && dVar.m() && Math.abs(this.h.getScaleX() - this.h.getCenterInsideScaleFactor()) < 1.1d && Math.abs(this.h.getScaleY() - this.h.getCenterInsideScaleFactor()) < 1.1d) {
            return false;
        }
        return true;
    }

    @Override // ak6.a
    public void setGestureCallback(a.InterfaceC0002a interfaceC0002a) {
        this.d = interfaceC0002a;
    }

    public void setResizeListener(e eVar) {
        this.e = eVar;
    }

    public void setSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.n = simpleOnGestureListener;
    }

    public void setVideoView(com.ss.android.videoshop.mediaview.d dVar) {
        this.h = dVar;
    }

    /* renamed from: bk6.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0005a implements View.OnClickListener {
        ViewOnClickListenerC0005a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ClickAgent.onClick(view);
            a.this.l(false);
            a.this.d.e();
        }
    }

    class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        b() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            if (a.this.h == null) {
                return false;
            }
            a.this.b = true;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (a.this.h != null) {
                a.this.h.u(a.this.h.getScaleX() * scaleGestureDetector.getScaleFactor());
                a.this.j();
                return true;
            }
            return false;
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            a.this.b = true;
            if (a.this.h != null && a.this.f() && a.this.d.g()) {
                a.this.h.y(f, f2);
                a.this.j();
            }
            return true;
        }
    }

    class d extends b.AbstractC0006b {
        @Override // bk6.b.a
        public void a(bk6.b bVar) {
        }

        d() {
        }

        @Override // bk6.b.a
        public boolean c(bk6.b bVar) {
            a.this.b = true;
            return true;
        }

        @Override // bk6.b.a
        public boolean b(bk6.b bVar) {
            if (a.this.h != null) {
                a.this.h.t(a.this.h.getRotation() + bVar.a());
                a.this.j();
                return true;
            }
            return false;
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public void l(boolean z) {
        com.ss.android.videoshop.mediaview.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        this.d.a(bVar, z);
        m(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 2 && this.b) {
            return true;
        }
        return false;
    }

    private void g(Context context) {
        if (context == null) {
            return;
        }
        if (this.j == null) {
            this.j = new ScaleGestureDetector(context, this.q);
        }
        if (this.k == null) {
            this.k = new GestureDetectorCompat(context, this.r);
        }
        if (this.l == null) {
            this.l = new bk6.b(this.s);
        }
    }

    public void m(boolean z) {
        int i;
        TextView textView = this.c;
        if (textView != null && this.h != null && UIUtils.isViewVisible(textView) != z) {
            if (z) {
                this.d.h(this.h);
            }
            TextView textView2 = this.c;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            UIUtils.setViewVisibility(textView2, i);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a.InterfaceC0002a interfaceC0002a;
        a.InterfaceC0002a interfaceC0002a2;
        a.InterfaceC0002a interfaceC0002a3 = this.d;
        boolean z = false;
        if (interfaceC0002a3 != null && !interfaceC0002a3.d()) {
            this.b = false;
            return false;
        }
        if (this.a && (interfaceC0002a2 = this.d) != null && interfaceC0002a2.g() && this.h == null) {
            this.b = false;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.b = false;
        }
        if (actionMasked == 0 || actionMasked == 5) {
            this.d.c(pointerCount);
        }
        if (actionMasked == 5 && pointerCount == h() && this.d.g() && this.d.isFullScreen() && !this.a) {
            i();
            this.a = true;
            this.d.b(false);
            this.d.i();
        }
        if (this.a) {
            if (this.d.g() && this.h.o() && pointerCount == 2) {
                this.j.onTouchEvent(motionEvent);
            }
            if (this.d.g() && this.h.q() && pointerCount == 2) {
                this.k.onTouchEvent(motionEvent);
            }
            if (this.d.g() && this.h.n() && pointerCount == 2) {
                this.l.c(motionEvent);
            }
            if (actionMasked == 1 || actionMasked == 3 || pointerCount < h()) {
                this.a = false;
                this.d.b(true);
                k();
            }
        }
        if (!this.b) {
            if (this.m == null) {
                this.m = new GestureDetector(getContext(), this.n);
            }
            if (actionMasked == 0) {
                this.m.onTouchEvent(motionEvent);
            }
        }
        if ((actionMasked == 1 || actionMasked == 3) && (interfaceC0002a = this.d) != null) {
            interfaceC0002a.i();
        }
        if (actionMasked == 2) {
            this.d.f(motionEvent);
        }
        if (actionMasked == 0 || this.m.onTouchEvent(motionEvent)) {
            z = true;
        }
        this.b = z;
        return z;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = false;
        this.f = new Rect();
        this.g = new RectF();
        this.q = new b();
        this.r = new c();
        this.s = new d();
        g(context);
        LayoutInflater.from(context).inflate(2131041069, this);
        TextView textView = (TextView) findViewById(2131836161);
        this.c = textView;
        textView.setOnClickListener(new ViewOnClickListenerC0005a());
        LayoutInflater.from(context).inflate(2131041070, this);
        TextView textView2 = (TextView) findViewById(2131831772);
        this.i = textView2;
        UIUtils.setViewVisibility(textView2, 8);
        this.o = (int) getResources().getDimension(2131494163);
        this.p = (int) getResources().getDimension(2131494164);
    }
}
