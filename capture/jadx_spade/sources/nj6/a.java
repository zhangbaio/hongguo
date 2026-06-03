package nj6;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.covode.number.Covode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(653122);
    }

    public static String c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static Cursor d(String str, String str2) {
        return f.d(str, str2);
    }

    public static long insert(String str, ContentValues contentValues) {
        return f.insert(str, contentValues);
    }

    public static long a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Date date2 = new Date();
        try {
            date = simpleDateFormat.parse(str);
            date2 = simpleDateFormat.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date2.getTime() - date.getTime();
    }

    public static long b(String str, String str2, String[] strArr) {
        return f.a(str, str2, strArr);
    }

    public static long e(String str, String[] strArr, List<ContentValues> list) {
        return f.e(str, strArr, list);
    }

    public static long update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return f.update(str, contentValues, str2, strArr);
    }

    public static Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return f.query(str, strArr, str2, strArr2, str3, str4, str5);
    }
}
