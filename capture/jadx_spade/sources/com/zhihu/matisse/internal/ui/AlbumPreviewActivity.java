package com.zhihu.matisse.internal.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import bm6.b;
import cm6.c;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.component.biz.api.NsAdApi;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import java.util.ArrayList;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AlbumPreviewActivity extends a implements b.a {
    private b p = new b();
    private boolean q;

    static {
        Covode.recordClassIndex(656131);
    }

    public void e2() {
        super.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void f2(Intent intent, Bundle bundle) {
        super/*android.app.Activity*/.startActivity(intent, bundle);
    }

    @Override // bm6.b.a
    public void i5() {
    }

    public void onResume() {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onResume", true);
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onResume", false);
    }

    public void onStart() {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onStart", false);
    }

    protected void onStop() {
        h2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onWindowFocusChanged", true);
        super/*android.app.Activity*/.onWindowFocusChanged(z);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        i2(this, intent, bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.p.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void h2(AlbumPreviewActivity albumPreviewActivity) {
        albumPreviewActivity.e2();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                albumPreviewActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bm6.b.a
    public void Ea(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(Item.valueOf(cursor));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        c adapter = this.c.getAdapter();
        adapter.a(arrayList);
        adapter.notifyDataSetChanged();
        if (!this.q) {
            this.q = true;
            int indexOf = arrayList.indexOf((Item) getIntent().getParcelableExtra("extra_item"));
            this.c.setCurrentItem(indexOf, false);
            this.i = indexOf;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zhihu.matisse.internal.ui.a
    protected void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onCreate", true);
        super.onCreate(bundle);
        if (!com.zhihu.matisse.internal.entity.a.b().o) {
            setResult(0);
            finish();
            ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onCreate", false);
            return;
        }
        this.p.c(this, this);
        this.p.a((Album) getIntent().getParcelableExtra("extra_album"));
        Item item = (Item) getIntent().getParcelableExtra("extra_item");
        if (this.b.f) {
            this.e.setCheckedNum(this.a.d(item));
        } else {
            this.e.setChecked(this.a.i(item));
        }
        d2(item);
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.AlbumPreviewActivity", "onCreate", false);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void i2(AlbumPreviewActivity albumPreviewActivity, Intent intent, Bundle bundle) {
        al2.a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        albumPreviewActivity.f2(intent, bundle);
    }
}
