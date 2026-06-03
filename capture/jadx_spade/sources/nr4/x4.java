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
public final class x4 implements v4 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.r1> b;

    static {
        Covode.recordClassIndex(611797);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public x4(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // nr4.v4
    public List<Long> b(lr4.r1... r1VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(r1VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v4
    public lr4.r1 a(String str) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_user_info WHERE uid = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.r1 r1Var = null;
        String string3 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "nick_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "avatar_url");
            if (query.moveToFirst()) {
                lr4.r1 r1Var2 = new lr4.r1();
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                r1Var2.a = string;
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                r1Var2.b = string2;
                if (!query.isNull(columnIndexOrThrow3)) {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                r1Var2.c = string3;
                r1Var = r1Var2;
            }
            return r1Var;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.r1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_user_info` (`uid`,`nick_name`,`avatar_url`) VALUES (?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.r1 r1Var) {
            String str = r1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = r1Var.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = r1Var.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
        }
    }
}
