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
public final class a2 implements y1 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.l0> b;
    private final EntityDeletionOrUpdateAdapter<lr4.l0> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611712);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // nr4.y1
    public List<lr4.l0> a() {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        boolean z;
        String string6;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_note_book_data WHERE is_local = 0 ORDER BY update_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "bookmark_num");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "underline_num");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "note_num");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "color");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_local");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "file_path");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "author");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                int i = query.getInt(columnIndexOrThrow2);
                int i2 = query.getInt(columnIndexOrThrow3);
                int i3 = query.getInt(columnIndexOrThrow4);
                long j = query.getLong(columnIndexOrThrow5);
                if (query.isNull(columnIndexOrThrow6)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow6);
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow9);
                }
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow11);
                }
                if (query.isNull(columnIndexOrThrow12)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow12);
                }
                arrayList.add(new lr4.l0(string, i, i2, i3, j, string2, string3, string4, string5, z, string6, string7));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.y1
    public List<lr4.l0> b() {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        boolean z;
        String string6;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_note_book_data WHERE is_local = 1 ORDER BY update_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "bookmark_num");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "underline_num");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "note_num");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "color");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_local");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "file_path");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "author");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                int i = query.getInt(columnIndexOrThrow2);
                int i2 = query.getInt(columnIndexOrThrow3);
                int i3 = query.getInt(columnIndexOrThrow4);
                long j = query.getLong(columnIndexOrThrow5);
                if (query.isNull(columnIndexOrThrow6)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow6);
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow9);
                }
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow11);
                }
                if (query.isNull(columnIndexOrThrow12)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow12);
                }
                arrayList.add(new lr4.l0(string, i, i2, i3, j, string2, string3, string4, string5, z, string6, string7));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.y1
    public List<lr4.l0> c() {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        boolean z;
        String string6;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_note_book_data ORDER BY update_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "bookmark_num");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "underline_num");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "note_num");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "color");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_local");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "file_path");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "author");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                int i = query.getInt(columnIndexOrThrow2);
                int i2 = query.getInt(columnIndexOrThrow3);
                int i3 = query.getInt(columnIndexOrThrow4);
                long j = query.getLong(columnIndexOrThrow5);
                if (query.isNull(columnIndexOrThrow6)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow6);
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow9);
                }
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow11);
                }
                if (query.isNull(columnIndexOrThrow12)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow12);
                }
                arrayList.add(new lr4.l0(string, i, i2, i3, j, string2, string3, string4, string5, z, string6, string7));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public a2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.y1
    public void delete(String str) {
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

    @Override // nr4.y1
    public void insert(List<lr4.l0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y1
    public void delete(List<lr4.l0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y1
    public lr4.l0 query(String str) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        boolean z;
        String string6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_note_book_data WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.l0 l0Var = null;
        String string7 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "bookmark_num");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "underline_num");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "note_num");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "color");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_local");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "file_path");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "author");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                int i = query.getInt(columnIndexOrThrow2);
                int i2 = query.getInt(columnIndexOrThrow3);
                int i3 = query.getInt(columnIndexOrThrow4);
                long j = query.getLong(columnIndexOrThrow5);
                if (query.isNull(columnIndexOrThrow6)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow6);
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow9);
                }
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow11);
                }
                if (!query.isNull(columnIndexOrThrow12)) {
                    string7 = query.getString(columnIndexOrThrow12);
                }
                l0Var = new lr4.l0(string, i, i2, i3, j, string2, string3, string4, string5, z, string6, string7);
            }
            return l0Var;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.l0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_note_book_data` (`book_id`,`bookmark_num`,`underline_num`,`note_num`,`update_time`,`book_name`,`cover_url`,`status`,`color`,`is_local`,`file_path`,`author`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.l0 l0Var) {
            String str = l0Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, l0Var.b);
            supportSQLiteStatement.bindLong(3, l0Var.c);
            supportSQLiteStatement.bindLong(4, l0Var.d);
            supportSQLiteStatement.bindLong(5, l0Var.e);
            String str2 = l0Var.f;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str2);
            }
            String str3 = l0Var.g;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str3);
            }
            String str4 = l0Var.h;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str4);
            }
            String str5 = l0Var.i;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str5);
            }
            supportSQLiteStatement.bindLong(10, l0Var.j ? 1L : 0L);
            String str6 = l0Var.k;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str6);
            }
            String str7 = l0Var.l;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str7);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.l0> {
        public String createQuery() {
            return "DELETE FROM `t_note_book_data` WHERE `book_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.l0 l0Var) {
            String str = l0Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_note_book_data WHERE book_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
