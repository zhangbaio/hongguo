package com.zhihu.matisse.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import bm6.a;
import bm6.c;
import cm6.a;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.component.biz.api.NsAdApi;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.AlbumPreviewActivity;
import com.zhihu.matisse.internal.ui.MediaSelectionFragment;
import com.zhihu.matisse.internal.ui.SelectedPreviewActivity;
import com.zhihu.matisse.internal.ui.widget.CheckRadioView;
import com.zhihu.matisse.internal.ui.widget.IncapableDialog;
import em6.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MatisseActivity extends AppCompatActivity implements a.InterfaceC0010a, AdapterView.OnItemSelectedListener, MediaSelectionFragment.a, View.OnClickListener, a.c, a.e, a.f {
    private b b;
    private com.zhihu.matisse.internal.entity.a d;
    private dm6.a e;
    private cm6.b f;
    private TextView g;
    private TextView h;
    private View i;
    private View j;
    private LinearLayout k;
    private CheckRadioView l;
    private boolean m;
    private Fragment o;
    private final bm6.a a = new bm6.a();
    private c c = new c(this);
    private boolean n = false;

    static {
        Covode.recordClassIndex(656171);
    }

    public void T1() {
        super.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U1(Intent intent, Bundle bundle) {
        super/*android.app.Activity*/.startActivity(intent, bundle);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onResume() {
        ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onResume", true);
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onResume", false);
    }

    public void onStart() {
        ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onStart", false);
    }

    protected void onStop() {
        Z1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onWindowFocusChanged", true);
        super/*android.app.Activity*/.onWindowFocusChanged(z);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        a2(this, intent, bundle);
    }

    @Override // com.zhihu.matisse.internal.ui.MediaSelectionFragment.a
    public c e0() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        setResult(0);
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // bm6.a.InterfaceC0010a
    public void s0() {
        this.f.swapCursor(null);
    }

    @Override // cm6.a.f
    public void capture() {
        this.b.getClass();
        d2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d2() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(this, 24);
        }
    }

    @Override // cm6.a.c
    public void onUpdate() {
        h2();
        fm6.c cVar = this.d.p;
        if (cVar != null) {
            cVar.a(this.c.b());
        }
    }

    private int b2() {
        int e = this.c.e();
        int i = 0;
        for (int i2 = 0; i2 < e; i2++) {
            Item item = this.c.b().get(i2);
            if (item.isImage() && em6.c.d(item.size) > this.d.u) {
                i++;
            }
        }
        return i;
    }

    private void c2() {
        TextView textView = (TextView) findViewById(2131832078);
        Drawable drawable = getResources().getDrawable(2130842849);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    protected void onDestroy() {
        List<Item> arrayList;
        super.onDestroy();
        fm6.b bVar = this.d.r;
        if (bVar != null) {
            boolean z = this.n;
            if (z) {
                arrayList = this.c.b();
            } else {
                arrayList = new ArrayList<>();
            }
            bVar.a(z, arrayList);
        }
        this.a.c();
        this.d.getClass();
        this.d.p = null;
    }

    class a implements Runnable {
        final /* synthetic */ Cursor a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [android.content.Context, com.zhihu.matisse.ui.MatisseActivity] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.a.isClosed()) {
                    this.a.moveToPosition(MatisseActivity.this.a.d);
                    dm6.a aVar = MatisseActivity.this.e;
                    ?? r1 = MatisseActivity.this;
                    aVar.j(r1, ((MatisseActivity) r1).a.d);
                    Album valueOf = Album.valueOf(this.a);
                    if (valueOf.isAll() && com.zhihu.matisse.internal.entity.a.b().k) {
                        valueOf.addCaptureCount();
                    }
                    MatisseActivity.this.e2(valueOf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        a(Cursor cursor) {
            this.a = cursor;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h2() {
        int e = this.c.e();
        if (e == 0) {
            f2(this.g, false);
            f2(this.h, false);
            this.h.setText(getString(2131104502));
        } else if (e == 1 && this.d.g()) {
            f2(this.g, true);
            this.h.setText(2131104502);
            f2(this.h, true);
        } else {
            f2(this.g, true);
            f2(this.h, true);
            this.h.setText(getString(2131104501, new Object[]{Integer.valueOf(e)}));
        }
        if (this.d.s) {
            this.k.setVisibility(0);
            i2();
        } else {
            this.k.setVisibility(4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i2() {
        this.l.setChecked(this.m);
        if (b2() > 0 && this.m) {
            IncapableDialog.wf("", getString(2131104509, new Object[]{Integer.valueOf(this.d.u)})).show(getSupportFragmentManager(), IncapableDialog.class.getName());
            this.l.setChecked(false);
            this.m = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void Z1(MatisseActivity matisseActivity) {
        matisseActivity.T1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                matisseActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // bm6.a.InterfaceC0010a
    public void F0(Cursor cursor) {
        this.f.swapCursor(cursor);
        new HandlerDelegate(Looper.getMainLooper()).post(new a(cursor));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        this.c.l(bundle);
        this.a.f(bundle);
        bundle.putBoolean("checkState", this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2(Album album) {
        if (album.isAll() && album.isEmpty()) {
            this.i.setVisibility(8);
            this.j.setVisibility(0);
            return;
        }
        this.i.setVisibility(0);
        this.j.setVisibility(8);
        if (this.o != null) {
            getSupportFragmentManager().beginTransaction().remove(this.o).commitAllowingStateLoss();
        }
        this.o = MediaSelectionFragment.wf(album);
        getSupportFragmentManager().beginTransaction().add(2131820545, this.o, MediaSelectionFragment.class.getSimpleName()).commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClickAgent.onClick(view);
        if (view.getId() == 2131822896) {
            Intent intent = new Intent((Context) this, (Class<?>) SelectedPreviewActivity.class);
            intent.putExtra("extra_default_bundle", this.c.g());
            intent.putExtra("extra_result_original_enable", this.m);
            startActivityForResult(intent, 23);
            return;
        }
        if (view.getId() == 2131822871) {
            Intent intent2 = new Intent();
            intent2.putParcelableArrayListExtra("extra_result_selection", (ArrayList) this.c.c());
            intent2.putExtra("extra_result_original_enable", this.m);
            setResult(-1, intent2);
            this.n = true;
            finish();
            return;
        }
        if (view.getId() == 2131830275) {
            int b2 = b2();
            if (b2 > 0) {
                IncapableDialog.wf("", getString(2131104508, new Object[]{Integer.valueOf(b2), Integer.valueOf(this.d.u)})).show(getSupportFragmentManager(), IncapableDialog.class.getName());
                return;
            }
            boolean z = !this.m;
            this.m = z;
            this.l.setChecked(z);
            this.d.getClass();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onCreate", true);
        com.zhihu.matisse.internal.entity.a b = com.zhihu.matisse.internal.entity.a.b();
        this.d = b;
        setTheme(b.d);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        if (!this.d.o) {
            setResult(0);
            finish();
            ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onCreate", false);
            return;
        }
        setContentView(2131034272);
        if (this.d.c()) {
            setRequestedOrientation(this.d.e);
        }
        if (!this.d.k) {
            Toolbar findViewById = findViewById(2131821144);
            setSupportActionBar(findViewById);
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.o(false);
            supportActionBar.n(true);
            findViewById.getNavigationIcon().setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
            this.g = (TextView) findViewById(2131822896);
            this.h = (TextView) findViewById(2131822871);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.i = findViewById(2131820545);
            this.j = findViewById(2131820826);
            this.k = (LinearLayout) findViewById(2131830275);
            this.l = (CheckRadioView) findViewById(2131830274);
            this.k.setOnClickListener(this);
            this.c.k(bundle);
            if (bundle != null) {
                this.m = bundle.getBoolean("checkState");
            }
            h2();
            this.f = new cm6.b(this, null, false);
            dm6.a aVar = new dm6.a(this);
            this.e = aVar;
            aVar.d = this;
            aVar.i((TextView) findViewById(2131832078));
            this.e.h(findViewById(2131832078));
            this.e.g(this.f);
            this.a.b(this, this);
            this.a.e(bundle);
            this.a.a();
            c2();
            ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onCreate", false);
            return;
        }
        this.b = new b(this);
        this.d.getClass();
        RuntimeException runtimeException = new RuntimeException("Don't forget to set CaptureStrategy.");
        ActivityAgent.onTrace("com.zhihu.matisse.ui.MatisseActivity", "onCreate", false);
        throw runtimeException;
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

    private void f2(TextView textView, boolean z) {
        textView.setEnabled(z);
        if (z) {
            textView.setTextColor(-16777216);
        } else {
            textView.setTextColor(Color.parseColor("#AFAFAF"));
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void a2(MatisseActivity matisseActivity, Intent intent, Bundle bundle) {
        al2.a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        matisseActivity.U1(intent, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cm6.a.e
    public void Sb(Album album, Item item, int i) {
        Intent intent = new Intent((Context) this, (Class<?>) AlbumPreviewActivity.class);
        intent.putExtra("extra_album", album);
        intent.putExtra("extra_item", item);
        intent.putExtra("extra_default_bundle", this.c.g());
        intent.putExtra("extra_result_original_enable", this.m);
        startActivityForResult(intent, 23);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 23) {
            Bundle S1 = S1(intent, "extra_result_bundle");
            ArrayList<Item> parcelableArrayList = S1.getParcelableArrayList("state_selection");
            this.m = intent.getBooleanExtra("extra_result_original_enable", false);
            int i3 = S1.getInt("state_collection_type", 0);
            if (intent.getBooleanExtra("extra_result_apply", false)) {
                Intent intent2 = new Intent();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                if (parcelableArrayList != null) {
                    Iterator<Item> it2 = parcelableArrayList.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next().getContentUri());
                    }
                }
                intent2.putParcelableArrayListExtra("extra_result_selection", arrayList);
                intent2.putExtra("extra_result_original_enable", this.m);
                setResult(-1, intent2);
                finish();
                return;
            }
            this.c.m(parcelableArrayList, i3);
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MediaSelectionFragment.class.getSimpleName());
            if (findFragmentByTag instanceof MediaSelectionFragment) {
                ((MediaSelectionFragment) findFragmentByTag).xf();
            }
            h2();
            return;
        }
        if (i == 24) {
            Uri uri = this.b.c;
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(uri);
            Intent intent3 = new Intent();
            intent3.putParcelableArrayListExtra("extra_result_selection", arrayList2);
            setResult(-1, intent3);
            finish();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.d = i;
        this.f.getCursor().moveToPosition(i);
        Album valueOf = Album.valueOf(this.f.getCursor());
        if (valueOf.isAll() && com.zhihu.matisse.internal.entity.a.b().k) {
            valueOf.addCaptureCount();
        }
        e2(valueOf);
    }
}
