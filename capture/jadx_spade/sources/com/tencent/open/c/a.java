package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends RelativeLayout {
    private static final String a;
    private Rect b;
    private boolean c;
    private InterfaceC0111a d;

    /* renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0111a {
        void a();

        void a(int i);
    }

    static {
        Covode.recordClassIndex(653522);
        a = a.class.getName();
    }

    public void a(InterfaceC0111a interfaceC0111a) {
        this.d = interfaceC0111a;
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new Rect();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        InterfaceC0111a interfaceC0111a = this.d;
        if (interfaceC0111a != null && size != 0) {
            if (height > 100) {
                interfaceC0111a.a((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0111a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
