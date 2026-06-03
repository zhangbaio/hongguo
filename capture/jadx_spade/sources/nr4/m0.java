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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m0 implements k0 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.r> b;
    private final EntityDeletionOrUpdateAdapter<lr4.r> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611670);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    public m0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.k0
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

    @Override // nr4.k0
    public long b(String str) {
        long j;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_cache_table WHERE cache_key LIKE ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                j = query.getLong(0);
            } else {
                j = 0;
            }
            return j;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.k0
    public Long[] d(lr4.r... rVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(rVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.k0
    public int f(lr4.r... rVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.c.handleMultiple(rVarArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.k0
    public lr4.r e(String str) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_cache_table  WHERE cache_key = ? LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.r rVar = null;
        String string2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cache_key");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cache_value");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                lr4.r rVar2 = new lr4.r(string);
                rVar2.a = query.getLong(columnIndexOrThrow);
                rVar2.c = query.getLong(columnIndexOrThrow3);
                if (!query.isNull(columnIndexOrThrow4)) {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                rVar2.d = string2;
                rVar = rVar2;
            }
            return rVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.k0
    public List<lr4.r> c(String... strArr) {
        String string;
        String string2;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_cache_table WHERE cache_key IN (");
        int length = strArr.length;
        StringUtil.appendPlaceholders(newStringBuilder, length);
        newStringBuilder.append(") ORDER BY update_time DESC");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), length + 0);
        int i = 1;
        for (String str : strArr) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cache_key");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cache_value");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                lr4.r rVar = new lr4.r(string);
                rVar.a = query.getLong(columnIndexOrThrow);
                rVar.c = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                rVar.d = string2;
                arrayList.add(rVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.k0
    public List<lr4.r> g(String str) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_cache_table WHERE cache_key LIKE ? ORDER BY update_time DESC", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cache_key");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cache_value");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                lr4.r rVar = new lr4.r(string);
                rVar.a = query.getLong(columnIndexOrThrow);
                rVar.c = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                rVar.d = string2;
                arrayList.add(rVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.r> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_cache_table` (`create_time`,`cache_key`,`update_time`,`cache_value`) VALUES (?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.r rVar) {
            supportSQLiteStatement.bindLong(1, rVar.a);
            String str = rVar.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            supportSQLiteStatement.bindLong(3, rVar.c);
            String str2 = rVar.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.r> {
        public String createQuery() {
            return "DELETE FROM `t_cache_table` WHERE `cache_key` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.r rVar) {
            String str = rVar.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_cache_table WHERE cache_key LIKE ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
