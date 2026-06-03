package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a3 implements y2 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.x0> b;

    static {
        Covode.recordClassIndex(611748);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public a3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // nr4.y2
    public Long[] a(lr4.x0... x0VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(x0VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y2
    public lr4.x0 b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_reading_record WHERE book_id = ? LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.x0 x0Var = null;
        String string = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "today_read_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "today_time_stamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "last_popup_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "last_popup_read_time");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "read_chapter_count");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "chapter_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "popup_count");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "popup_count_for_chase_comment");
            if (query.moveToFirst()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    string = query.getString(columnIndexOrThrow);
                }
                lr4.x0 x0Var2 = new lr4.x0(string);
                x0Var2.b = query.getLong(columnIndexOrThrow2);
                x0Var2.c = query.getLong(columnIndexOrThrow3);
                x0Var2.d = query.getLong(columnIndexOrThrow4);
                x0Var2.e = query.getLong(columnIndexOrThrow5);
                x0Var2.f = query.getLong(columnIndexOrThrow6);
                x0Var2.g = query.getInt(columnIndexOrThrow7);
                x0Var2.h = query.getInt(columnIndexOrThrow8);
                x0Var2.i = query.getInt(columnIndexOrThrow9);
                x0Var2.j = query.getInt(columnIndexOrThrow10);
                x0Var = x0Var2;
            }
            return x0Var;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.x0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_reading_record` (`book_id`,`read_time`,`today_read_time`,`today_time_stamp`,`last_popup_time`,`last_popup_read_time`,`read_chapter_count`,`chapter_count`,`popup_count`,`popup_count_for_chase_comment`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.x0 x0Var) {
            String str = x0Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, x0Var.b);
            supportSQLiteStatement.bindLong(3, x0Var.c);
            supportSQLiteStatement.bindLong(4, x0Var.d);
            supportSQLiteStatement.bindLong(5, x0Var.e);
            supportSQLiteStatement.bindLong(6, x0Var.f);
            supportSQLiteStatement.bindLong(7, x0Var.g);
            supportSQLiteStatement.bindLong(8, x0Var.h);
            supportSQLiteStatement.bindLong(9, x0Var.i);
            supportSQLiteStatement.bindLong(10, x0Var.j);
        }
    }
}
