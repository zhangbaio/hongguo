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
public final class u1 implements s1 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.f0> b;
    private final EntityDeletionOrUpdateAdapter<lr4.f0> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611706);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // nr4.s1
    public List<lr4.f0> f() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_local_book_bookmark", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mark_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "end_paragraph_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.f0 f0Var = new lr4.f0();
                    ArrayList arrayList2 = arrayList;
                    int i = columnIndexOrThrow13;
                    f0Var.a = query.getLong(columnIndexOrThrow);
                    f0Var.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        f0Var.c = null;
                    } else {
                        f0Var.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        f0Var.d = null;
                    } else {
                        f0Var.d = query.getString(columnIndexOrThrow4);
                    }
                    f0Var.e = query.getInt(columnIndexOrThrow5);
                    f0Var.f = query.getInt(columnIndexOrThrow6);
                    f0Var.g = query.getInt(columnIndexOrThrow7);
                    f0Var.h = query.getInt(columnIndexOrThrow8);
                    if (query.isNull(columnIndexOrThrow9)) {
                        f0Var.i = null;
                    } else {
                        f0Var.i = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        f0Var.j = null;
                    } else {
                        f0Var.j = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        f0Var.k = null;
                    } else {
                        f0Var.k = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        f0Var.l = null;
                    } else {
                        f0Var.l = query.getString(columnIndexOrThrow12);
                    }
                    f0Var.m = query.getInt(i);
                    int i2 = columnIndexOrThrow14;
                    int i3 = columnIndexOrThrow2;
                    f0Var.n = query.getLong(i2);
                    arrayList2.add(f0Var);
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow14 = i2;
                    arrayList = arrayList2;
                    columnIndexOrThrow13 = i;
                }
                ArrayList arrayList3 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList3;
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

    public u1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.s1
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
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
            this.d.release(acquire);
        }
    }

    @Override // nr4.s1
    public int b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_local_book_bookmark WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        int i = 0;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                i = query.getInt(0);
            }
            return i;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.s1
    public void c(List<lr4.f0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.s1
    public List<Long> d(List<lr4.f0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(list);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.s1
    public List<lr4.f0> e(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_local_book_bookmark WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mark_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "end_paragraph_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.f0 f0Var = new lr4.f0();
                    int i2 = columnIndexOrThrow11;
                    int i3 = columnIndexOrThrow12;
                    f0Var.a = query.getLong(columnIndexOrThrow);
                    f0Var.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        f0Var.c = null;
                    } else {
                        f0Var.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        f0Var.d = null;
                    } else {
                        f0Var.d = query.getString(columnIndexOrThrow4);
                    }
                    f0Var.e = query.getInt(columnIndexOrThrow5);
                    f0Var.f = query.getInt(columnIndexOrThrow6);
                    f0Var.g = query.getInt(columnIndexOrThrow7);
                    f0Var.h = query.getInt(columnIndexOrThrow8);
                    if (query.isNull(columnIndexOrThrow9)) {
                        f0Var.i = null;
                    } else {
                        f0Var.i = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        f0Var.j = null;
                    } else {
                        f0Var.j = query.getString(columnIndexOrThrow10);
                    }
                    columnIndexOrThrow11 = i2;
                    if (query.isNull(columnIndexOrThrow11)) {
                        f0Var.k = null;
                    } else {
                        f0Var.k = query.getString(columnIndexOrThrow11);
                    }
                    columnIndexOrThrow12 = i3;
                    if (query.isNull(columnIndexOrThrow12)) {
                        i = columnIndexOrThrow;
                        f0Var.l = null;
                    } else {
                        i = columnIndexOrThrow;
                        f0Var.l = query.getString(columnIndexOrThrow12);
                    }
                    f0Var.m = query.getInt(columnIndexOrThrow13);
                    int i4 = columnIndexOrThrow13;
                    int i5 = columnIndexOrThrow14;
                    int i6 = columnIndexOrThrow2;
                    f0Var.n = query.getLong(i5);
                    arrayList.add(f0Var);
                    columnIndexOrThrow2 = i6;
                    columnIndexOrThrow13 = i4;
                    columnIndexOrThrow14 = i5;
                    columnIndexOrThrow = i;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    class a extends EntityInsertionAdapter<lr4.f0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_local_book_bookmark` (`id`,`mark_type`,`book_id`,`chapter_id`,`paragraph_id`,`end_paragraph_id`,`start_offset_in_para`,`end_offset_in_para`,`chapter_version`,`content`,`chapter_title`,`volume_name`,`chapter_index`,`modify_time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.f0 f0Var) {
            supportSQLiteStatement.bindLong(1, f0Var.a);
            supportSQLiteStatement.bindLong(2, f0Var.b);
            String str = f0Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = f0Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, f0Var.e);
            supportSQLiteStatement.bindLong(6, f0Var.f);
            supportSQLiteStatement.bindLong(7, f0Var.g);
            supportSQLiteStatement.bindLong(8, f0Var.h);
            String str3 = f0Var.i;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str3);
            }
            String str4 = f0Var.j;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str4);
            }
            String str5 = f0Var.k;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str5);
            }
            String str6 = f0Var.l;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str6);
            }
            supportSQLiteStatement.bindLong(13, f0Var.m);
            supportSQLiteStatement.bindLong(14, f0Var.n);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.f0> {
        public String createQuery() {
            return "DELETE FROM `t_local_book_bookmark` WHERE `id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.f0 f0Var) {
            supportSQLiteStatement.bindLong(1, f0Var.a);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_local_book_bookmark WHERE book_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
