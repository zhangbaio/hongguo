package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o4 implements m4 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.j1> b;
    private final SharedSQLiteStatement c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611788);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // nr4.m4
    public int clearAll() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }

    public o4(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.m4
    public int a(int i) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        acquire.bindLong(1, i);
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    @Override // nr4.m4
    public void insert(lr4.j1 j1Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(j1Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    class a extends EntityInsertionAdapter<lr4.j1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_task_comment_publish_record` (`comment_id`,`timestamp`,`type`,`word_count`) VALUES (?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.j1 j1Var) {
            String str = j1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, j1Var.b);
            supportSQLiteStatement.bindLong(3, j1Var.getType());
            supportSQLiteStatement.bindLong(4, j1Var.d);
        }
    }

    class b extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_task_comment_publish_record WHERE type = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_task_comment_publish_record";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // nr4.m4
    public int b(long j, Long l, Integer num, int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_task_comment_publish_record WHERE timestamp >= ? AND (? IS NULL OR timestamp <= ?) AND (? IS NULL OR type = ?) AND word_count >= ?", 6);
        acquire.bindLong(1, j);
        if (l == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, l.longValue());
        }
        if (l == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindLong(3, l.longValue());
        }
        if (num == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindLong(4, num.intValue());
        }
        if (num == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindLong(5, num.intValue());
        }
        acquire.bindLong(6, i);
        this.a.assertNotSuspendingTransaction();
        int i2 = 0;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                i2 = query.getInt(0);
            }
            return i2;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
