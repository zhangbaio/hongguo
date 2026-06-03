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
public final class i implements g {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.c> b;
    private final EntityDeletionOrUpdateAdapter<lr4.c> c;
    private final SharedSQLiteStatement d;
    private final SharedSQLiteStatement e;
    private final SharedSQLiteStatement f;

    static {
        Covode.recordClassIndex(611639);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // nr4.g
    public List<lr4.c> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_status", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "progress");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "pause_reason");
                int i = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.c cVar = new lr4.c();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        cVar.a = null;
                    } else {
                        arrayList = arrayList2;
                        cVar.a = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        cVar.b = null;
                    } else {
                        cVar.b = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        cVar.c = null;
                    } else {
                        cVar.c = query.getString(columnIndexOrThrow3);
                    }
                    int i2 = columnIndexOrThrow2;
                    int i3 = columnIndexOrThrow3;
                    cVar.d = query.getLong(columnIndexOrThrow4);
                    cVar.e = query.getInt(columnIndexOrThrow5);
                    cVar.f = query.getInt(columnIndexOrThrow6);
                    cVar.g = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        cVar.h = null;
                    } else {
                        cVar.h = query.getString(columnIndexOrThrow8);
                    }
                    if (query.getInt(columnIndexOrThrow9) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cVar.i = z;
                    if (query.isNull(columnIndexOrThrow10)) {
                        cVar.j = null;
                    } else {
                        cVar.j = query.getString(columnIndexOrThrow10);
                    }
                    cVar.k = query.getInt(columnIndexOrThrow11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        cVar.l = null;
                    } else {
                        cVar.l = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        cVar.m = null;
                    } else {
                        cVar.m = query.getString(columnIndexOrThrow13);
                    }
                    int i4 = i;
                    cVar.n = query.getFloat(i4);
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow;
                    cVar.o = query.getFloat(i5);
                    int i7 = columnIndexOrThrow16;
                    int i8 = columnIndexOrThrow12;
                    cVar.p = query.getLong(i7);
                    int i9 = columnIndexOrThrow17;
                    cVar.q = query.getInt(i9);
                    arrayList2 = arrayList;
                    arrayList2.add(cVar);
                    columnIndexOrThrow17 = i9;
                    columnIndexOrThrow12 = i8;
                    columnIndexOrThrow16 = i7;
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow2 = i2;
                    i = i4;
                    columnIndexOrThrow3 = i3;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList2;
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

    public i(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
    }

    @Override // nr4.g
    public Long[] a(lr4.c... cVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(cVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.g
    public void delete(lr4.c... cVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(cVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.g
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

    @Override // nr4.g
    public List<lr4.c> v(String str) {
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
        int columnIndexOrThrow14;
        ArrayList arrayList;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_status WHERE book_id = ?", 1);
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
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "status");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "progress");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_url");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "pause_reason");
            int i = columnIndexOrThrow14;
            ArrayList arrayList2 = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.c cVar = new lr4.c();
                if (query.isNull(columnIndexOrThrow)) {
                    arrayList = arrayList2;
                    cVar.a = null;
                } else {
                    arrayList = arrayList2;
                    cVar.a = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    cVar.b = null;
                } else {
                    cVar.b = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    cVar.c = null;
                } else {
                    cVar.c = query.getString(columnIndexOrThrow3);
                }
                int i2 = columnIndexOrThrow2;
                int i3 = columnIndexOrThrow3;
                cVar.d = query.getLong(columnIndexOrThrow4);
                cVar.e = query.getInt(columnIndexOrThrow5);
                cVar.f = query.getInt(columnIndexOrThrow6);
                cVar.g = query.getLong(columnIndexOrThrow7);
                if (query.isNull(columnIndexOrThrow8)) {
                    cVar.h = null;
                } else {
                    cVar.h = query.getString(columnIndexOrThrow8);
                }
                if (query.getInt(columnIndexOrThrow9) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                cVar.i = z;
                if (query.isNull(columnIndexOrThrow10)) {
                    cVar.j = null;
                } else {
                    cVar.j = query.getString(columnIndexOrThrow10);
                }
                cVar.k = query.getInt(columnIndexOrThrow11);
                if (query.isNull(columnIndexOrThrow12)) {
                    cVar.l = null;
                } else {
                    cVar.l = query.getString(columnIndexOrThrow12);
                }
                if (query.isNull(columnIndexOrThrow13)) {
                    cVar.m = null;
                } else {
                    cVar.m = query.getString(columnIndexOrThrow13);
                }
                int i4 = i;
                cVar.n = query.getFloat(i4);
                int i5 = columnIndexOrThrow15;
                int i6 = columnIndexOrThrow;
                cVar.o = query.getFloat(i5);
                int i7 = columnIndexOrThrow16;
                int i8 = columnIndexOrThrow11;
                cVar.p = query.getLong(i7);
                int i9 = columnIndexOrThrow17;
                cVar.q = query.getInt(i9);
                ArrayList arrayList3 = arrayList;
                arrayList3.add(cVar);
                columnIndexOrThrow17 = i9;
                arrayList2 = arrayList3;
                columnIndexOrThrow11 = i8;
                columnIndexOrThrow16 = i7;
                columnIndexOrThrow = i6;
                columnIndexOrThrow15 = i5;
                columnIndexOrThrow2 = i2;
                i = i4;
                columnIndexOrThrow3 = i3;
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

    class a extends EntityInsertionAdapter<lr4.c> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_audio_download_status` (`book_id`,`chapter_id`,`book_name`,`tone_id`,`status`,`progress`,`create_time`,`download_url`,`is_encrypt`,`encrypt_key`,`download_id`,`abs_save_path`,`chapter_name`,`current_length`,`total_length`,`duration`,`pause_reason`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.c cVar) {
            String str = cVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = cVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = cVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            supportSQLiteStatement.bindLong(4, cVar.d);
            supportSQLiteStatement.bindLong(5, cVar.e);
            supportSQLiteStatement.bindLong(6, cVar.f);
            supportSQLiteStatement.bindLong(7, cVar.g);
            String str4 = cVar.h;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str4);
            }
            supportSQLiteStatement.bindLong(9, cVar.i ? 1L : 0L);
            String str5 = cVar.j;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str5);
            }
            supportSQLiteStatement.bindLong(11, cVar.k);
            String str6 = cVar.l;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str6);
            }
            String str7 = cVar.m;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str7);
            }
            supportSQLiteStatement.bindDouble(14, cVar.n);
            supportSQLiteStatement.bindDouble(15, cVar.o);
            supportSQLiteStatement.bindLong(16, cVar.p);
            supportSQLiteStatement.bindLong(17, cVar.q);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.c> {
        public String createQuery() {
            return "DELETE FROM `t_audio_download_status` WHERE `chapter_id` = ? AND `tone_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.c cVar) {
            String str = cVar.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, cVar.d);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_audio_download_status WHERE chapter_id = ? and tone_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_audio_download_status WHERE book_id = ? and tone_id = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_audio_download_status WHERE book_id = ?";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // nr4.g
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

    @Override // nr4.g
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

    @Override // nr4.g
    public lr4.c e(String str, long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.c cVar;
        int i;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_status WHERE chapter_id = ? and tone_id = ? limit 1", 2);
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
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "progress");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "pause_reason");
                if (query.moveToFirst()) {
                    lr4.c cVar2 = new lr4.c();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow14;
                        cVar2.a = null;
                    } else {
                        i = columnIndexOrThrow14;
                        cVar2.a = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        cVar2.b = null;
                    } else {
                        cVar2.b = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        cVar2.c = null;
                    } else {
                        cVar2.c = query.getString(columnIndexOrThrow3);
                    }
                    cVar2.d = query.getLong(columnIndexOrThrow4);
                    cVar2.e = query.getInt(columnIndexOrThrow5);
                    cVar2.f = query.getInt(columnIndexOrThrow6);
                    cVar2.g = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        cVar2.h = null;
                    } else {
                        cVar2.h = query.getString(columnIndexOrThrow8);
                    }
                    if (query.getInt(columnIndexOrThrow9) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cVar2.i = z;
                    if (query.isNull(columnIndexOrThrow10)) {
                        cVar2.j = null;
                    } else {
                        cVar2.j = query.getString(columnIndexOrThrow10);
                    }
                    cVar2.k = query.getInt(columnIndexOrThrow11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        cVar2.l = null;
                    } else {
                        cVar2.l = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        cVar2.m = null;
                    } else {
                        cVar2.m = query.getString(columnIndexOrThrow13);
                    }
                    cVar2.n = query.getFloat(i);
                    cVar2.o = query.getFloat(columnIndexOrThrow15);
                    cVar2.p = query.getLong(columnIndexOrThrow16);
                    cVar2.q = query.getInt(columnIndexOrThrow17);
                    cVar = cVar2;
                } else {
                    cVar = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return cVar;
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

    @Override // nr4.g
    public List<lr4.c> queryBookTone(String str, long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_download_status WHERE book_id = ? and tone_id = ?", 2);
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
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "progress");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "is_encrypt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "encrypt_key");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "download_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_length");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "total_length");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "pause_reason");
                int i = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.c cVar = new lr4.c();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        cVar.a = null;
                    } else {
                        arrayList = arrayList2;
                        cVar.a = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        cVar.b = null;
                    } else {
                        cVar.b = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        cVar.c = null;
                    } else {
                        cVar.c = query.getString(columnIndexOrThrow3);
                    }
                    int i2 = columnIndexOrThrow2;
                    int i3 = columnIndexOrThrow3;
                    cVar.d = query.getLong(columnIndexOrThrow4);
                    cVar.e = query.getInt(columnIndexOrThrow5);
                    cVar.f = query.getInt(columnIndexOrThrow6);
                    cVar.g = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        cVar.h = null;
                    } else {
                        cVar.h = query.getString(columnIndexOrThrow8);
                    }
                    if (query.getInt(columnIndexOrThrow9) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cVar.i = z;
                    if (query.isNull(columnIndexOrThrow10)) {
                        cVar.j = null;
                    } else {
                        cVar.j = query.getString(columnIndexOrThrow10);
                    }
                    cVar.k = query.getInt(columnIndexOrThrow11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        cVar.l = null;
                    } else {
                        cVar.l = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        cVar.m = null;
                    } else {
                        cVar.m = query.getString(columnIndexOrThrow13);
                    }
                    int i4 = i;
                    cVar.n = query.getFloat(i4);
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow;
                    cVar.o = query.getFloat(i5);
                    int i7 = columnIndexOrThrow16;
                    int i8 = columnIndexOrThrow11;
                    cVar.p = query.getLong(i7);
                    int i9 = columnIndexOrThrow17;
                    cVar.q = query.getInt(i9);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(cVar);
                    columnIndexOrThrow17 = i9;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow11 = i8;
                    columnIndexOrThrow16 = i7;
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow2 = i2;
                    i = i4;
                    columnIndexOrThrow3 = i3;
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
