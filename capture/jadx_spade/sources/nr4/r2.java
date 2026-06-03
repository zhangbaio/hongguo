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
public final class r2 implements q2 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.t0> b;
    private final EntityDeletionOrUpdateAdapter<lr4.t0> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611736);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    public r2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.q2
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

    @Override // nr4.q2
    public int b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM reader_local_underline WHERE book_id = ? AND underline_type=1", 1);
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

    @Override // nr4.q2
    public void c(List<lr4.t0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.q2
    public int d(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM reader_local_underline WHERE book_id = ? AND underline_type=0", 1);
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

    @Override // nr4.q2
    public List<Long> f(List<lr4.t0> list) {
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

    @Override // nr4.q2
    public List<lr4.t0> e(String str) {
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
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM reader_local_underline WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mark_type");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "start_para_id");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "end_para_id");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "line_type");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "underline_type");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "notes");
            int i = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j = query.getLong(columnIndexOrThrow);
                int i2 = query.getInt(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                int i3 = query.getInt(columnIndexOrThrow5);
                int i4 = query.getInt(columnIndexOrThrow6);
                int i5 = query.getInt(columnIndexOrThrow7);
                int i6 = query.getInt(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow10);
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow11);
                }
                if (query.isNull(columnIndexOrThrow12)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow12);
                }
                int i7 = query.getInt(columnIndexOrThrow13);
                int i8 = i;
                long j2 = query.getLong(i8);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow15;
                int i11 = query.getInt(i10);
                columnIndexOrThrow15 = i10;
                int i12 = columnIndexOrThrow16;
                int i13 = query.getInt(i12);
                columnIndexOrThrow16 = i12;
                int i14 = columnIndexOrThrow17;
                if (query.isNull(i14)) {
                    columnIndexOrThrow17 = i14;
                    string7 = null;
                } else {
                    string7 = query.getString(i14);
                    columnIndexOrThrow17 = i14;
                }
                arrayList.add(new lr4.t0(j, i2, string, string2, i3, i4, i5, i6, string3, string4, string5, string6, i7, j2, i11, i13, string7));
                columnIndexOrThrow = i9;
                i = i8;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    class a extends EntityInsertionAdapter<lr4.t0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `reader_local_underline` (`id`,`mark_type`,`book_id`,`chapter_id`,`start_para_id`,`start_offset_in_para`,`end_para_id`,`end_offset_in_para`,`chapter_version`,`content`,`chapter_title`,`volume_name`,`chapter_index`,`modify_time`,`line_type`,`underline_type`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.t0 t0Var) {
            supportSQLiteStatement.bindLong(1, t0Var.a);
            supportSQLiteStatement.bindLong(2, t0Var.b);
            String str = t0Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = t0Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, t0Var.e);
            supportSQLiteStatement.bindLong(6, t0Var.f);
            supportSQLiteStatement.bindLong(7, t0Var.g);
            supportSQLiteStatement.bindLong(8, t0Var.h);
            String str3 = t0Var.i;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str3);
            }
            String str4 = t0Var.j;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str4);
            }
            String str5 = t0Var.k;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str5);
            }
            String str6 = t0Var.l;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str6);
            }
            supportSQLiteStatement.bindLong(13, t0Var.m);
            supportSQLiteStatement.bindLong(14, t0Var.n);
            supportSQLiteStatement.bindLong(15, t0Var.o);
            supportSQLiteStatement.bindLong(16, t0Var.p);
            String str7 = t0Var.q;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str7);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.t0> {
        public String createQuery() {
            return "DELETE FROM `reader_local_underline` WHERE `id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.t0 t0Var) {
            supportSQLiteStatement.bindLong(1, t0Var.a);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM reader_local_underline WHERE book_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
