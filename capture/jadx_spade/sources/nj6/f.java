package nj6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f extends SQLiteOpenHelper {
    public static volatile f a;

    static {
        Covode.recordClassIndex(653129);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public f(Context context) {
        super(context, "StrategyData.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void c(Context context) {
        if (a == null) {
            a = new f(context);
            Log.d("StrategySQLiteWrapper", "new StrategySQLiteWrapper mInstance");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(d.f);
        sQLiteDatabase.execSQL(b.b);
        sQLiteDatabase.execSQL(c.b);
        sQLiteDatabase.execSQL(c.c);
        Log.d("StrategySQLiteWrapper", "create database");
    }

    public static Cursor d(String str, String str2) {
        if (a != null) {
            try {
                return a.getReadableDatabase().rawQuery(str2, null);
            } catch (Throwable th) {
                Log.e("StrategySQLiteWrapper", th.getMessage());
            }
        }
        return null;
    }

    public static long insert(String str, ContentValues contentValues) {
        try {
            if (a != null) {
                return a.getWritableDatabase().insert(str, null, contentValues);
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static int delete(String str, String str2, String[] strArr) {
        if (a != null) {
            try {
                return a.getWritableDatabase().delete(str, str2, strArr);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    public static long a(String str, String str2, String[] strArr) {
        if (a != null) {
            try {
                Cursor rawQuery = a.getReadableDatabase().rawQuery("select count(DISTINCT " + str2 + ") from " + str, null);
                if (rawQuery != null) {
                    rawQuery.moveToFirst();
                    long j = rawQuery.getLong(0);
                    rawQuery.close();
                    return j;
                }
                return -1L;
            } catch (Throwable th) {
                Log.e("StrategySQLiteWrapper", th.getMessage());
                return -1L;
            }
        }
        return -1L;
    }

    public static long e(String str, String[] strArr, List<ContentValues> list) {
        long j = -1;
        if (a == null || strArr == null || strArr.length <= 0) {
            return -1L;
        }
        char c = 0;
        String str2 = "";
        for (int i = 0; i < strArr.length; i++) {
            String str3 = strArr[i];
            if (i != 0) {
                str2 = str2 + " and ";
            }
            str2 = str2 + str3 + "=?";
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = a.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                String[] strArr2 = new String[strArr.length];
                long j2 = -1;
                for (ContentValues contentValues : list) {
                    try {
                        if (contentValues != null) {
                            for (int i2 = 0; i2 < strArr.length; i2++) {
                                strArr2[i2] = String.valueOf(contentValues.get(strArr[i2]));
                            }
                            String[] strArr3 = new String[1];
                            strArr3[c] = strArr[c];
                            Cursor query = writableDatabase.query(str, strArr3, str2, strArr2, null, null, null);
                            if (query == null) {
                                continue;
                            } else {
                                if (query.getCount() == 0) {
                                    j = writableDatabase.insert(str, null, contentValues);
                                } else {
                                    j = writableDatabase.update(str, contentValues, str2, strArr2);
                                }
                                query.close();
                                j2 = j;
                            }
                        }
                        c = 0;
                    } catch (Throwable unused) {
                        sQLiteDatabase = writableDatabase;
                        j = j2;
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                                return j;
                            } catch (SQLiteFullException | Exception unused2) {
                                return j;
                            }
                        }
                        return j;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                try {
                    writableDatabase.endTransaction();
                } catch (SQLiteFullException | Exception unused3) {
                }
                return j2;
            } catch (Throwable unused4) {
                sQLiteDatabase = writableDatabase;
            }
        } catch (Throwable unused5) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (r0 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r0 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int update(java.lang.String r3, android.content.ContentValues r4, java.lang.String r5, java.lang.String[] r6) {
        /*
            r0 = 0
            r1 = -1
            nj6.f r2 = nj6.f.a     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L16
            nj6.f r2 = nj6.f.a     // Catch: java.lang.Throwable -> L1c
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L1c
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L1c
            int r1 = r0.update(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L1c
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L1c
        L16:
            if (r0 == 0) goto L1f
        L18:
            r0.endTransaction()     // Catch: java.lang.Exception -> L1f
            goto L1f
        L1c:
            if (r0 == 0) goto L1f
            goto L18
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: nj6.f.update(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public static Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (a != null) {
            try {
                return a.getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
