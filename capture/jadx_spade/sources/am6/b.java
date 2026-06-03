package am6;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.entity.Album;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends CursorLoader {
    private static final Uri b;
    private static final String[] c;
    private static final String[] d;
    private final boolean a;

    public void onContentChanged() {
    }

    static {
        Covode.recordClassIndex(656125);
        b = MediaStore.Files.getContentUri("external");
        c = new String[]{"_id", "_display_name", "mime_type", "_size", "duration"};
        d = new String[]{String.valueOf(1), String.valueOf(3)};
    }

    /* renamed from: loadInBackground, reason: merged with bridge method [inline-methods] */
    public Cursor m1loadInBackground() {
        Cursor loadInBackground = super.loadInBackground();
        if (this.a && em6.b.b(getContext())) {
            MatrixCursor matrixCursor = new MatrixCursor(c);
            matrixCursor.addRow(new Object[]{-1L, "Capture", "", 0, 0});
            return new MergeCursor(new Cursor[]{matrixCursor, loadInBackground});
        }
        return loadInBackground;
    }

    private static String[] c(int i) {
        return new String[]{String.valueOf(i)};
    }

    private static String[] a(String str) {
        return new String[]{String.valueOf(1), String.valueOf(3), str};
    }

    private static String[] b(int i, String str) {
        return new String[]{String.valueOf(i), str};
    }

    public static CursorLoader d(Context context, Album album, boolean z) {
        String str;
        String[] a;
        if (album.isAll()) {
            str = "media_type=? AND _size>0";
            if (com.zhihu.matisse.internal.entity.a.b().d()) {
                a = c(1);
            } else if (com.zhihu.matisse.internal.entity.a.b().e()) {
                a = c(3);
            } else {
                a = d;
                str = "(media_type=? OR media_type=?) AND _size>0";
            }
        } else {
            str = "media_type=? AND  bucket_id=? AND _size>0";
            if (com.zhihu.matisse.internal.entity.a.b().d()) {
                a = b(1, album.getId());
            } else if (com.zhihu.matisse.internal.entity.a.b().e()) {
                a = b(3, album.getId());
            } else {
                a = a(album.getId());
                str = "(media_type=? OR media_type=?) AND  bucket_id=? AND _size>0";
            }
            z = false;
        }
        return new b(context, str, a, z);
    }

    private b(Context context, String str, String[] strArr, boolean z) {
        super(context, b, c, str, strArr, "datetaken DESC");
        this.a = z;
    }
}
