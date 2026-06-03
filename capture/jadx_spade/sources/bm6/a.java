package bm6;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.bytedance.covode.number.Covode;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a implements LoaderManager.LoaderCallbacks<Cursor> {
    private WeakReference<Context> a;
    private LoaderManager b;
    private InterfaceC0010a c;
    public int d;
    private boolean e;

    /* renamed from: bm6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0010a {
        void F0(Cursor cursor);

        void s0();
    }

    static {
        Covode.recordClassIndex(656126);
    }

    public void a() {
        this.b.initLoader(1, (Bundle) null, this);
    }

    public void c() {
        LoaderManager loaderManager = this.b;
        if (loaderManager != null) {
            loaderManager.destroyLoader(1);
        }
        this.c = null;
    }

    public void f(Bundle bundle) {
        bundle.putInt("state_current_selection", this.d);
    }

    public void e(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.d = bundle.getInt("state_current_selection");
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.a.get() == null) {
            return;
        }
        this.c.s0();
    }

    public void b(FragmentActivity fragmentActivity, InterfaceC0010a interfaceC0010a) {
        this.a = new WeakReference<>(fragmentActivity);
        this.b = fragmentActivity.getSupportLoaderManager();
        this.c = interfaceC0010a;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (this.a.get() != null && !this.e) {
            this.e = true;
            this.c.F0(cursor);
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Context context = this.a.get();
        if (context == null) {
            return null;
        }
        this.e = false;
        return am6.a.c(context);
    }
}
