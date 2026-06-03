package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f implements nr4.d {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.b> b;
    private final EntityDeletionOrUpdateAdapter<lr4.b> c;
    private final SharedSQLiteStatement d;
    private final SharedSQLiteStatement e;
    private final SharedSQLiteStatement f;

    static {
        Covode.recordClassIndex(611636);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    @Override // nr4.d
    public List<lr4.b> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_result", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            roomSQLiteQuery = acquire;
            try {
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.b bVar = new lr4.b();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        bVar.a = null;
                    } else {
                        arrayList = arrayList2;
                        bVar.a = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        bVar.b = null;
                    } else {
                        bVar.b = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        bVar.c = null;
                    } else {
                        bVar.c = query.getString(columnIndexOrThrow3);
                    }
                    int i = columnIndexOrThrow;
                    bVar.d = query.getLong(columnIndexOrThrow4);
                    bVar.e = query.getLong(columnIndexOrThrow5);
                    if (query.getInt(columnIndexOrThrow6) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar.f = z;
                    if (query.isNull(columnIndexOrThrow7)) {
                        bVar.g = null;
                    } else {
                        bVar.g = query.getString(columnIndexOrThrow7);
                    }
                    bVar.h = query.getInt(columnIndexOrThrow8);
                    if (query.isNull(columnIndexOrThrow9)) {
                        bVar.i = null;
                    } else {
                        bVar.i = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        bVar.j = null;
                    } else {
                        bVar.j = query.getString(columnIndexOrThrow10);
                    }
                    bVar.k = query.getFloat(columnIndexOrThrow11);
                    bVar.l = query.getFloat(columnIndexOrThrow12);
                    bVar.m = query.getLong(columnIndexOrThrow13);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(bVar);
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i;
                }
                ArrayList arrayList4 = arrayList2;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
    }

    @Override // nr4.d
    public void delete(lr4.b... bVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(bVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.d
    public void deleteBook(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f.release(acquire);
        }
    }

    @Override // nr4.d
    public Long[] f(lr4.b... bVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(bVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.d
    public List<lr4.b> v(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        ArrayList arrayList;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_result WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            ArrayList arrayList2 = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.b bVar = new lr4.b();
                if (query.isNull(columnIndexOrThrow)) {
                    arrayList = arrayList2;
                    bVar.a = null;
                } else {
                    arrayList = arrayList2;
                    bVar.a = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    bVar.b = null;
                } else {
                    bVar.b = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    bVar.c = null;
                } else {
                    bVar.c = query.getString(columnIndexOrThrow3);
                }
                int i = columnIndexOrThrow;
                bVar.d = query.getLong(columnIndexOrThrow4);
                bVar.e = query.getLong(columnIndexOrThrow5);
                if (query.getInt(columnIndexOrThrow6) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                bVar.f = z;
                if (query.isNull(columnIndexOrThrow7)) {
                    bVar.g = null;
                } else {
                    bVar.g = query.getString(columnIndexOrThrow7);
                }
                bVar.h = query.getInt(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    bVar.i = null;
                } else {
                    bVar.i = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    bVar.j = null;
                } else {
                    bVar.j = query.getString(columnIndexOrThrow10);
                }
                bVar.k = query.getFloat(columnIndexOrThrow11);
                bVar.l = query.getFloat(columnIndexOrThrow12);
                bVar.m = query.getLong(columnIndexOrThrow13);
                ArrayList arrayList3 = arrayList;
                arrayList3.add(bVar);
                arrayList2 = arrayList3;
                columnIndexOrThrow = i;
            }
            ArrayList arrayList4 = arrayList2;
            query.close();
            roomSQLiteQuery.release();
            return arrayList4;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    class a extends EntityInsertionAdapter<lr4.b> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_audio_download_result` (`book_id`,`chapter_id`,`book_name`,`tone_id`,`create_time`,`is_encrypt`,`encrypt_key`,`download_id`,`abs_save_path`,`chapter_name`,`current_length`,`total_length`,`duration`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.b bVar) {
            String str = bVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = bVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = bVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            supportSQLiteStatement.bindLong(4, bVar.d);
            supportSQLiteStatement.bindLong(5, bVar.e);
            supportSQLiteStatement.bindLong(6, bVar.f ? 1L : 0L);
            String str4 = bVar.g;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str4);
            }
            supportSQLiteStatement.bindLong(8, bVar.h);
            String str5 = bVar.i;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str5);
            }
            String str6 = bVar.j;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str6);
            }
            supportSQLiteStatement.bindDouble(11, bVar.k);
            supportSQLiteStatement.bindDouble(12, bVar.l);
            supportSQLiteStatement.bindLong(13, bVar.m);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.b> {
        public String createQuery() {
            return "DELETE FROM `t_audio_download_result` WHERE `chapter_id` = ? AND `tone_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.b bVar) {
            String str = bVar.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, bVar.d);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_audio_download_result WHERE chapter_id = ? and tone_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_audio_download_result WHERE book_id = ? and tone_id = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_audio_download_result WHERE book_id = ?";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // nr4.d
    public void c(String str, long j) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.e.release(acquire);
        }
    }

    @Override // nr4.d
    public void d(String str, long j) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [androidx.room.RoomSQLiteQuery] */
    /* JADX WARN: Type inference failed for: r16v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    @Override // nr4.d
    public lr4.b e(String str, long j) {
        ?? r16;
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.b bVar;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_result WHERE chapter_id = ? and tone_id = ? limit 1", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            if (query.moveToFirst()) {
                lr4.b bVar2 = new lr4.b();
                r16 = query.isNull(columnIndexOrThrow);
                try {
                    if (r16 != 0) {
                        r16 = acquire;
                        bVar2.a = null;
                    } else {
                        r16 = acquire;
                        bVar2.a = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        bVar2.b = null;
                    } else {
                        bVar2.b = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        bVar2.c = null;
                    } else {
                        bVar2.c = query.getString(columnIndexOrThrow3);
                    }
                    bVar2.d = query.getLong(columnIndexOrThrow4);
                    bVar2.e = query.getLong(columnIndexOrThrow5);
                    if (query.getInt(columnIndexOrThrow6) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar2.f = z;
                    if (query.isNull(columnIndexOrThrow7)) {
                        bVar2.g = null;
                    } else {
                        bVar2.g = query.getString(columnIndexOrThrow7);
                    }
                    bVar2.h = query.getInt(columnIndexOrThrow8);
                    if (query.isNull(columnIndexOrThrow9)) {
                        bVar2.i = null;
                    } else {
                        bVar2.i = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        bVar2.j = null;
                    } else {
                        bVar2.j = query.getString(columnIndexOrThrow10);
                    }
                    bVar2.k = query.getFloat(columnIndexOrThrow11);
                    bVar2.l = query.getFloat(columnIndexOrThrow12);
                    bVar2.m = query.getLong(columnIndexOrThrow13);
                    bVar = bVar2;
                    roomSQLiteQuery = r16;
                } catch (Throwable th) {
                    th = th;
                    query.close();
                    r16.release();
                    throw th;
                }
            } else {
                roomSQLiteQuery = acquire;
                bVar = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return bVar;
        } catch (Throwable th2) {
            th = th2;
            r16 = acquire;
        }
    }

    @Override // nr4.d
    public List<lr4.b> queryBookTone(String str, long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_result WHERE book_id = ? and tone_id = ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            roomSQLiteQuery = acquire;
            try {
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.b bVar = new lr4.b();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        bVar.a = null;
                    } else {
                        arrayList = arrayList2;
                        bVar.a = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        bVar.b = null;
                    } else {
                        bVar.b = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        bVar.c = null;
                    } else {
                        bVar.c = query.getString(columnIndexOrThrow3);
                    }
                    int i = columnIndexOrThrow;
                    bVar.d = query.getLong(columnIndexOrThrow4);
                    bVar.e = query.getLong(columnIndexOrThrow5);
                    if (query.getInt(columnIndexOrThrow6) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar.f = z;
                    if (query.isNull(columnIndexOrThrow7)) {
                        bVar.g = null;
                    } else {
                        bVar.g = query.getString(columnIndexOrThrow7);
                    }
                    bVar.h = query.getInt(columnIndexOrThrow8);
                    if (query.isNull(columnIndexOrThrow9)) {
                        bVar.i = null;
                    } else {
                        bVar.i = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        bVar.j = null;
                    } else {
                        bVar.j = query.getString(columnIndexOrThrow10);
                    }
                    bVar.k = query.getFloat(columnIndexOrThrow11);
                    bVar.l = query.getFloat(columnIndexOrThrow12);
                    bVar.m = query.getLong(columnIndexOrThrow13);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(bVar);
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i;
                }
                ArrayList arrayList4 = arrayList2;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }
}
