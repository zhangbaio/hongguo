package am6;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.Album;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends CursorLoader {
    private static final Uri a;
    private static final String[] b;
    private static final String[] c;
    private static final String[] d;
    private static final String[] e;
    private static final String[] f;
    private static final String[] g;

    public void onContentChanged() {
    }

    static {
        Covode.recordClassIndex(656124);
        a = MediaStore.Files.getContentUri("external");
        b = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type", "uri", "count"};
        c = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type", "COUNT(*) AS count"};
        d = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type", "COUNT(*) AS count"};
        e = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type"};
        f = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type"};
        g = new String[]{String.valueOf(1), String.valueOf(3)};
    }

    /* renamed from: loadInBackground, reason: merged with bridge method [inline-methods] */
    public Cursor m0loadInBackground() {
        Uri uri;
        int i;
        long valueOf;
        Uri uri2;
        int i2;
        Cursor loadInBackground = super.loadInBackground();
        String[] strArr = b;
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        String str = null;
        if (Build.VERSION.SDK_INT < 29) {
            MatrixCursor matrixCursor2 = new MatrixCursor(strArr);
            if (loadInBackground != null) {
                i2 = 0;
                while (loadInBackground.moveToNext()) {
                    long j = loadInBackground.getLong(loadInBackground.getColumnIndex("_id"));
                    long j2 = loadInBackground.getLong(loadInBackground.getColumnIndex("bucket_id"));
                    String string = loadInBackground.getString(loadInBackground.getColumnIndex("bucket_display_name"));
                    String string2 = loadInBackground.getString(loadInBackground.getColumnIndex("mime_type"));
                    Uri b2 = b(loadInBackground);
                    int i3 = loadInBackground.getInt(loadInBackground.getColumnIndex("count"));
                    matrixCursor2.addRow(new String[]{Long.toString(j), Long.toString(j2), string, string2, b2.toString(), String.valueOf(i3)});
                    i2 += i3;
                }
                if (loadInBackground.moveToFirst()) {
                    uri2 = b(loadInBackground);
                } else {
                    uri2 = null;
                }
            } else {
                uri2 = null;
                i2 = 0;
            }
            String[] strArr2 = new String[6];
            String str2 = Album.ALBUM_ID_ALL;
            strArr2[0] = str2;
            strArr2[1] = str2;
            strArr2[2] = "All";
            strArr2[3] = null;
            if (uri2 != null) {
                str = uri2.toString();
            }
            strArr2[4] = str;
            strArr2[5] = String.valueOf(i2);
            matrixCursor.addRow(strArr2);
            return new MergeCursor(new Cursor[]{matrixCursor, matrixCursor2});
        }
        HashMap hashMap = new HashMap();
        if (loadInBackground != null) {
            while (loadInBackground.moveToNext()) {
                long j3 = loadInBackground.getLong(loadInBackground.getColumnIndex("bucket_id"));
                Long l = (Long) hashMap.get(Long.valueOf(j3));
                if (l == null) {
                    valueOf = 1L;
                } else {
                    valueOf = Long.valueOf(l.longValue() + 1);
                }
                hashMap.put(Long.valueOf(j3), valueOf);
            }
        }
        MatrixCursor matrixCursor3 = new MatrixCursor(b);
        if (loadInBackground != null && loadInBackground.moveToFirst()) {
            uri = b(loadInBackground);
            HashSet hashSet = new HashSet();
            i = 0;
            do {
                long j4 = loadInBackground.getLong(loadInBackground.getColumnIndex("bucket_id"));
                if (!hashSet.contains(Long.valueOf(j4))) {
                    long j5 = loadInBackground.getLong(loadInBackground.getColumnIndex("_id"));
                    String string3 = loadInBackground.getString(loadInBackground.getColumnIndex("bucket_display_name"));
                    String string4 = loadInBackground.getString(loadInBackground.getColumnIndex("mime_type"));
                    Uri b3 = b(loadInBackground);
                    long longValue = ((Long) hashMap.get(Long.valueOf(j4))).longValue();
                    matrixCursor3.addRow(new String[]{Long.toString(j5), Long.toString(j4), string3, string4, b3.toString(), String.valueOf(longValue)});
                    hashSet.add(Long.valueOf(j4));
                    i = (int) (i + longValue);
                }
            } while (loadInBackground.moveToNext());
        } else {
            uri = null;
            i = 0;
        }
        String[] strArr3 = new String[6];
        String str3 = Album.ALBUM_ID_ALL;
        strArr3[0] = str3;
        strArr3[1] = str3;
        strArr3[2] = "All";
        strArr3[3] = null;
        if (uri != null) {
            str = uri.toString();
        }
        strArr3[4] = str;
        strArr3[5] = String.valueOf(i);
        matrixCursor.addRow(strArr3);
        return new MergeCursor(new Cursor[]{matrixCursor, matrixCursor3});
    }

    private static String[] a(int i) {
        return new String[]{String.valueOf(i)};
    }

    private static Uri b(Cursor cursor) {
        Uri contentUri;
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("mime_type"));
        if (MimeType.isImage(string)) {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (MimeType.isVideo(string)) {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            contentUri = MediaStore.Files.getContentUri("external");
        }
        return ContentUris.withAppendedId(contentUri, j);
    }

    public static CursorLoader c(Context context) {
        String str;
        String[] strArr;
        String str2 = "media_type=? AND _size>0) GROUP BY (bucket_id";
        if (com.zhihu.matisse.internal.entity.a.b().d()) {
            if (Build.VERSION.SDK_INT >= 29) {
                str2 = "media_type=? AND _size>0";
            }
            strArr = a(1);
        } else if (com.zhihu.matisse.internal.entity.a.b().e()) {
            if (Build.VERSION.SDK_INT >= 29) {
                str2 = "media_type=? AND _size>0";
            }
            strArr = a(3);
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                str = "(media_type=? OR media_type=?) AND _size>0) GROUP BY (bucket_id";
            } else {
                str = "(media_type=? OR media_type=?) AND _size>0";
            }
            str2 = str;
            strArr = g;
        }
        return new a(context, str2, strArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private a(android.content.Context r8, java.lang.String r9, java.lang.String[] r10) {
        /*
            r7 = this;
            android.net.Uri r2 = am6.a.a
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto Lb
            java.lang.String[] r0 = am6.a.d
            goto Ld
        Lb:
            java.lang.String[] r0 = am6.a.f
        Ld:
            r3 = r0
            java.lang.String r6 = "datetaken DESC"
            r0 = r7
            r1 = r8
            r4 = r9
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: am6.a.<init>(android.content.Context, java.lang.String, java.lang.String[]):void");
    }
}
