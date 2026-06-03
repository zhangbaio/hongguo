package bk6;

import android.util.Log;
import android.view.MotionEvent;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static final String k;
    private a a;
    private MotionEvent b;
    private MotionEvent c;
    private double d;
    private double e;
    private double f;
    private double g;
    public boolean h;
    private int i = 0;
    private int j = 1;

    public interface a {
        void a(b bVar);

        boolean b(b bVar);

        boolean c(b bVar);
    }

    /* renamed from: bk6.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0006b implements a {
        static {
            Covode.recordClassIndex(654962);
        }
    }

    static {
        Covode.recordClassIndex(654960);
        k = b.class.getSimpleName();
    }

    private void d() {
        this.h = false;
        MotionEvent motionEvent = this.b;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.b = null;
        }
        MotionEvent motionEvent2 = this.c;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.c = null;
        }
    }

    public float a() {
        return (float) (((Math.atan2(this.g, this.f) - Math.atan2(this.e, this.d)) * 180.0d) / 3.141592653589793d);
    }

    public b(a aVar) {
        this.a = aVar;
    }

    public boolean c(MotionEvent motionEvent) {
        try {
            if (this.a == null) {
                return false;
            }
            if (!b(motionEvent)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Log.e(k, e.toString());
            return false;
        }
    }

    private boolean b(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            z = false;
        } else {
            z = true;
        }
        if (actionMasked != 0 && !z) {
            int pointerCount = motionEvent.getPointerCount();
            if (actionMasked == 6) {
                if (pointerCount < 2) {
                    if (this.h) {
                        this.a.a(this);
                    }
                    d();
                } else {
                    e(motionEvent);
                    this.b = null;
                }
                return true;
            }
            if (actionMasked == 5) {
                this.b = MotionEvent.obtain(motionEvent);
                e(motionEvent);
                f(motionEvent);
                this.h = this.a.c(this);
            }
            if (actionMasked == 2 && pointerCount >= 2) {
                if (this.b == null) {
                    this.b = MotionEvent.obtain(motionEvent);
                }
                f(motionEvent);
                if (this.a.b(this)) {
                    this.b.recycle();
                    this.b = MotionEvent.obtain(motionEvent);
                }
            }
            return true;
        }
        if (this.h) {
            this.a.a(this);
        }
        d();
        return true;
    }

    private void e(MotionEvent motionEvent) {
        int i;
        int pointerCount = motionEvent.getPointerCount();
        if (motionEvent.getActionMasked() == 6) {
            i = motionEvent.getActionIndex();
        } else {
            i = Integer.MAX_VALUE;
        }
        if (pointerCount <= 2) {
            this.i = 0;
            this.j = 1;
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < pointerCount; i6++) {
            if (i6 != i) {
                float x = motionEvent.getX(i6);
                float y = motionEvent.getY(i6);
                if (x <= f3) {
                    i3 = i6;
                    f3 = x;
                }
                if (x >= f) {
                    i5 = i6;
                    f = x;
                }
                if (y <= f4) {
                    i2 = i6;
                    f4 = y;
                }
                if (y >= f2) {
                    i4 = i6;
                    f2 = y;
                }
            }
        }
        if (f - f3 > f2 - f2) {
            if (i3 >= i) {
                i3--;
            }
            this.i = i3;
            if (i5 >= i) {
                i5--;
            }
            this.j = i5;
            return;
        }
        if (i2 >= i) {
            i2--;
        }
        this.i = i2;
        if (i4 >= i) {
            i4--;
        }
        this.j = i4;
    }

    private void f(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.c;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.c = null;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.c = obtain;
        MotionEvent motionEvent3 = this.b;
        float x = motionEvent3.getX(this.i);
        float y = motionEvent3.getY(this.i);
        float x2 = motionEvent3.getX(this.j);
        float y2 = motionEvent3.getY(this.j) - y;
        this.d = x2 - x;
        this.e = y2;
        float x3 = obtain.getX(this.i);
        float y3 = obtain.getY(this.i);
        float x4 = obtain.getX(this.j);
        float y4 = obtain.getY(this.j) - y3;
        this.f = x4 - x3;
        this.g = y4;
    }
}
