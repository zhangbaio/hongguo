package dm6;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.t;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.entity.Album;
import em6.d;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private CursorAdapter a;
    private TextView b;
    private t c;
    public AdapterView.OnItemSelectedListener d;

    static {
        Covode.recordClassIndex(656147);
    }

    /* renamed from: dm6.a$a, reason: collision with other inner class name */
    class C0142a implements AdapterView.OnItemClickListener {
        C0142a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.this.f(adapterView.getContext(), i);
            if (a.this.d != null) {
                a.this.d.onItemSelected(adapterView, view, i, j);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int count;
            ClickAgent.onClick(view);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(2131493040);
            t tVar = a.this.c;
            if (a.this.a.getCount() > 6) {
                count = dimensionPixelSize * 6;
            } else {
                count = dimensionPixelSize * a.this.a.getCount();
            }
            tVar.k(count);
            a.this.c.show();
        }
    }

    public void g(CursorAdapter cursorAdapter) {
        this.c.setAdapter(cursorAdapter);
        this.a = cursorAdapter;
    }

    public void h(View view) {
        t tVar = this.c;
        tVar.s = view;
        tVar.q = 0;
        tVar.setHorizontalOffset((view.getLayoutParams().width - this.c.e) / 2);
        this.c.setVerticalOffset(e(view.getContext(), 10.0f));
    }

    public a(Context context) {
        t tVar = new t(context, (AttributeSet) null, 2130773736);
        this.c = tVar;
        tVar.m(true);
        float f = context.getResources().getDisplayMetrics().density;
        this.c.i((int) (216.0f * f));
        this.c.setHorizontalOffset((int) (16.0f * f));
        this.c.setVerticalOffset((int) (f * (-48.0f)));
        this.c.u = new C0142a();
    }

    public void i(TextView textView) {
        this.b = textView;
        Drawable drawable = textView.getCompoundDrawables()[2];
        TypedArray obtainStyledAttributes = this.b.getContext().getTheme().obtainStyledAttributes(new int[]{2130772784});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.b.setVisibility(8);
        this.b.setOnClickListener(new b());
        TextView textView2 = this.b;
        textView2.setOnTouchListener(this.c.c(textView2));
    }

    private int e(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public void j(Context context, int i) {
        this.c.q(i);
        f(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, int i) {
        this.c.dismiss();
        Cursor cursor = this.a.getCursor();
        cursor.moveToPosition(i);
        String displayName = Album.valueOf(cursor).getDisplayName(context);
        if (this.b.getVisibility() == 0) {
            this.b.setText(displayName);
            return;
        }
        if (d.a()) {
            this.b.setAlpha(0.0f);
            this.b.setVisibility(0);
            this.b.setText(displayName);
            this.b.animate().alpha(1.0f).setDuration(context.getResources().getInteger(R.integer.config_longAnimTime)).start();
            return;
        }
        this.b.setVisibility(0);
        this.b.setText(displayName);
    }
}
