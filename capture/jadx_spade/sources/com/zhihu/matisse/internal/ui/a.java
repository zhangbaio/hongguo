package com.zhihu.matisse.internal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;
import cm6.c;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.zhihu.matisse.internal.entity.IncapableCause;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.widget.CheckRadioView;
import com.zhihu.matisse.internal.ui.widget.CheckView;
import com.zhihu.matisse.internal.ui.widget.IncapableDialog;
import fm6.d;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener, fm6.a {
    protected com.zhihu.matisse.internal.entity.a b;
    protected ViewPager c;
    protected c d;
    protected CheckView e;
    protected TextView f;
    protected TextView g;
    protected TextView h;
    private LinearLayout j;
    private CheckRadioView k;
    protected boolean l;
    private FrameLayout m;
    private FrameLayout n;
    protected final bm6.c a = new bm6.c(this);
    protected int i = -1;
    private boolean o = false;

    static {
        Covode.recordClassIndex(656132);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onBackPressed() {
        a2(false);
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z1() {
        int e = this.a.e();
        int i = 0;
        for (int i2 = 0; i2 < e; i2++) {
            Item item = this.a.b().get(i2);
            if (item.isImage() && em6.c.d(item.size) > this.b.u) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b2() {
        int e = this.a.e();
        if (e == 0) {
            this.g.setText(2131104502);
            this.g.setEnabled(false);
        } else if (e == 1 && this.b.g()) {
            this.g.setText(2131104502);
            this.g.setEnabled(true);
        } else {
            this.g.setEnabled(true);
            this.g.setText(getString(2131104501, new Object[]{Integer.valueOf(e)}));
        }
        if (this.b.s) {
            this.j.setVisibility(0);
            c2();
        } else {
            this.j.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c2() {
        this.k.setChecked(this.l);
        if (!this.l) {
            this.k.setColor(-1);
        }
        if (Z1() > 0 && this.l) {
            IncapableDialog.wf("", getString(2131104509, new Object[]{Integer.valueOf(this.b.u)})).show(getSupportFragmentManager(), IncapableDialog.class.getName());
            this.k.setChecked(false);
            this.k.setColor(-1);
            this.l = false;
        }
    }

    @Override // fm6.a
    public void onClick() {
        if (!this.b.t) {
            return;
        }
        if (this.o) {
            this.n.animate().setInterpolator(new FastOutSlowInInterpolator()).translationYBy(this.n.getMeasuredHeight()).start();
            this.m.animate().translationYBy(-this.m.getMeasuredHeight()).setInterpolator(new FastOutSlowInInterpolator()).start();
        } else {
            this.n.animate().setInterpolator(new FastOutSlowInInterpolator()).translationYBy(-this.n.getMeasuredHeight()).start();
            this.m.animate().setInterpolator(new FastOutSlowInInterpolator()).translationYBy(this.m.getMeasuredHeight()).start();
        }
        this.o = !this.o;
    }

    /* renamed from: com.zhihu.matisse.internal.ui.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0138a implements View.OnClickListener {
        ViewOnClickListenerC0138a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ClickAgent.onClick(view);
            if (a.this.d.getCount() <= 0) {
                return;
            }
            a aVar = a.this;
            Item b = aVar.d.b(aVar.c.getCurrentItem());
            if (a.this.a.i(b)) {
                a.this.a.o(b);
                a aVar2 = a.this;
                if (aVar2.b.f) {
                    aVar2.e.setCheckedNum(Integer.MIN_VALUE);
                } else {
                    aVar2.e.setChecked(false);
                }
            } else if (a.this.Y1(b)) {
                a.this.a.a(b);
                a aVar3 = a.this;
                if (aVar3.b.f) {
                    aVar3.e.setCheckedNum(aVar3.a.d(b));
                } else {
                    aVar3.e.setChecked(true);
                }
            }
            a.this.b2();
            a aVar4 = a.this;
            fm6.c cVar = aVar4.b.p;
            if (cVar != null) {
                cVar.a(aVar4.a.b());
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ClickAgent.onClick(view);
            int Z1 = a.this.Z1();
            if (Z1 > 0) {
                IncapableDialog.wf("", a.this.getString(2131104508, new Object[]{Integer.valueOf(Z1), Integer.valueOf(a.this.b.u)})).show(a.this.getSupportFragmentManager(), IncapableDialog.class.getName());
                return;
            }
            a aVar = a.this;
            aVar.l = true ^ aVar.l;
            aVar.k.setChecked(a.this.l);
            a aVar2 = a.this;
            if (!aVar2.l) {
                aVar2.k.setColor(-1);
            }
            a.this.b.getClass();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.a.l(bundle);
        bundle.putBoolean("checkState", this.l);
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean Y1(Item item) {
        d dVar;
        IncapableCause h = this.a.h(item);
        com.zhihu.matisse.internal.entity.a aVar = this.b;
        if (aVar == null) {
            dVar = null;
        } else {
            dVar = aVar.q;
        }
        IncapableCause.a(this, h, dVar);
        if (h == null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void a2(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("extra_result_bundle", this.a.g());
        intent.putExtra("extra_result_apply", z);
        intent.putExtra("extra_result_original_enable", this.l);
        setResult(-1, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClickAgent.onClick(view);
        if (view.getId() == 2131822873) {
            onBackPressed();
        } else if (view.getId() == 2131822871) {
            a2(true);
            finish();
        }
    }

    protected void d2(Item item) {
        if (item.isGif()) {
            this.h.setVisibility(0);
            this.h.setText(em6.c.d(item.size) + "M");
        } else {
            this.h.setVisibility(8);
        }
        if (item.isVideo()) {
            this.j.setVisibility(8);
        } else if (this.b.s) {
            this.j.setVisibility(0);
        }
    }

    public void onPageSelected(int i) {
        c adapter = this.c.getAdapter();
        int i2 = this.i;
        if (i2 != -1 && i2 != i) {
            ((PreviewItemFragment) adapter.instantiateItem(this.c, i2)).yf();
            Item b2 = adapter.b(i);
            if (this.b.f) {
                int d = this.a.d(b2);
                this.e.setCheckedNum(d);
                if (d > 0) {
                    this.e.setEnabled(true);
                } else {
                    this.e.setEnabled(true ^ this.a.j());
                }
            } else {
                boolean i3 = this.a.i(b2);
                this.e.setChecked(i3);
                if (i3) {
                    this.e.setEnabled(true);
                } else {
                    this.e.setEnabled(true ^ this.a.j());
                }
            }
            d2(b2);
        }
        this.i = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        setTheme(com.zhihu.matisse.internal.entity.a.b().d);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        if (!com.zhihu.matisse.internal.entity.a.b().o) {
            setResult(0);
            finish();
            return;
        }
        setContentView(2131034273);
        if (em6.d.b()) {
            getWindow().addFlags(67108864);
        }
        com.zhihu.matisse.internal.entity.a b2 = com.zhihu.matisse.internal.entity.a.b();
        this.b = b2;
        if (b2.c()) {
            setRequestedOrientation(this.b.e);
        }
        if (bundle == null) {
            this.a.k(S1(getIntent(), "extra_default_bundle"));
            this.l = getIntent().getBooleanExtra("extra_result_original_enable", false);
        } else {
            this.a.k(bundle);
            this.l = bundle.getBoolean("checkState");
        }
        this.f = (TextView) findViewById(2131822873);
        this.g = (TextView) findViewById(2131822871);
        this.h = (TextView) findViewById(2131832439);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        ViewPager findViewById = findViewById(2131830325);
        this.c = findViewById;
        findViewById.addOnPageChangeListener(this);
        c cVar = new c(getSupportFragmentManager(), null, this.b);
        this.d = cVar;
        this.c.setAdapter(cVar);
        CheckView checkView = (CheckView) findViewById(2131823240);
        this.e = checkView;
        checkView.setCountable(this.b.f);
        this.m = (FrameLayout) findViewById(2131822650);
        this.n = (FrameLayout) findViewById(2131833586);
        this.e.setOnClickListener(new ViewOnClickListenerC0138a());
        this.j = (LinearLayout) findViewById(2131830275);
        this.k = (CheckRadioView) findViewById(2131830274);
        this.j.setOnClickListener(new b());
        b2();
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle S1(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }
}
