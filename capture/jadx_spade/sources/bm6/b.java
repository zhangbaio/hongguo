package bm6;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.entity.Album;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b implements LoaderManager.LoaderCallbacks<Cursor> {
    private WeakReference<Context> a;
    private LoaderManager b;
    private a c;

    public interface a {
        void Ea(Cursor cursor);

        void i5();
    }

    static {
        Covode.recordClassIndex(656128);
    }

    public void d() {
        LoaderManager loaderManager = this.b;
        if (loaderManager != null) {
            loaderManager.destroyLoader(2);
        }
        this.c = null;
    }

    public void a(Album album) {
        b(album, false);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.a.get() == null) {
            return;
        }
        this.c.i5();
    }

    public void c(FragmentActivity fragmentActivity, a aVar) {
        this.a = new WeakReference<>(fragmentActivity);
        this.b = fragmentActivity.getSupportLoaderManager();
        this.c = aVar;
    }

    public void b(Album album, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("args_album", album);
        bundle.putBoolean("args_enable_capture", z);
        this.b.initLoader(2, bundle, this);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (this.a.get() == null) {
            return;
        }
        this.c.Ea(cursor);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Album album;
        Context context = this.a.get();
        if (context == null || (album = (Album) bundle.getParcelable("args_album")) == null) {
            return null;
        }
        boolean z = false;
        if (album.isAll() && bundle.getBoolean("args_enable_capture", false)) {
            z = true;
        }
        return am6.b.d(context, album, z);
    }
}
