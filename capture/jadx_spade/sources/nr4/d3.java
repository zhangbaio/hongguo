package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
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
import java.util.Date;
import java.util.List;
import lr4.y0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d3 implements b3 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.y0> b;
    private final SharedSQLiteStatement c;

    static {
        Covode.recordClassIndex(611751);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    public d3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    @Override // nr4.b3
    public Long[] c(lr4.y0... y0VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(y0VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.b3
    public void e(Date date) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        String a2 = kr4.c.a(date);
        if (a2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, a2);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    @Override // nr4.b3
    public y0.a d(Date date) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT date, book_id, SUM(reading_time) AS reading_time FROM t_reading_time WHERE date == ?", 1);
        String a2 = kr4.c.a(date);
        if (a2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, a2);
        }
        this.a.assertNotSuspendingTransaction();
        y0.a aVar = null;
        String string2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "date");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "reading_time");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                Date b2 = kr4.c.b(string);
                if (!query.isNull(columnIndexOrThrow2)) {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                aVar = new y0.a(b2, string2, query.getLong(columnIndexOrThrow3));
            }
            return aVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.y0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_reading_time` (`id`,`date`,`book_id`,`reading_time`) VALUES (nullif(?, 0),?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.y0 y0Var) {
            supportSQLiteStatement.bindLong(1, y0Var.a);
            String a = kr4.c.a(y0Var.b);
            if (a == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, a);
            }
            String str = y0Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            supportSQLiteStatement.bindLong(4, y0Var.d);
        }
    }

    class b extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_reading_time WHERE date < ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // nr4.b3
    public lr4.y0 a(Date date, String str) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_reading_time WHERE date = ? AND book_id = ?", 2);
        String a2 = kr4.c.a(date);
        if (a2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, a2);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.y0 y0Var = null;
        String string2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "date");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "reading_time");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                Date b2 = kr4.c.b(string);
                if (!query.isNull(columnIndexOrThrow3)) {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                lr4.y0 y0Var2 = new lr4.y0(b2, string2, query.getLong(columnIndexOrThrow4));
                y0Var2.a = query.getLong(columnIndexOrThrow);
                y0Var = y0Var2;
            }
            return y0Var;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.b3
    public List<y0.a> b(Date date, Date date2) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT date, book_id, SUM(reading_time) AS reading_time FROM t_reading_time WHERE date BETWEEN ? AND ? GROUP BY date", 2);
        String a2 = kr4.c.a(date);
        if (a2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, a2);
        }
        String a3 = kr4.c.a(date2);
        if (a3 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, a3);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "date");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "reading_time");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                Date b2 = kr4.c.b(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                arrayList.add(new y0.a(b2, string2, query.getLong(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
