package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v implements t {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.g> b;
    private final EntityDeletionOrUpdateAdapter<lr4.g> c;

    static {
        Covode.recordClassIndex(611652);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // nr4.t
    public int getBookGroupCount() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT count(*) FROM t_booklist", 0);
        this.a.assertNotSuspendingTransaction();
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

    @Override // nr4.t
    public List<lr4.g> f() {
        String string;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_booklist", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "booklist_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "real_booklist_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.g gVar = new lr4.g();
                gVar.a = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                gVar.b = string;
                gVar.c = query.getLong(columnIndexOrThrow3);
                gVar.d = query.getLong(columnIndexOrThrow4);
                gVar.e = query.getLong(columnIndexOrThrow5);
                if (query.getInt(columnIndexOrThrow6) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                gVar.f = z;
                arrayList.add(gVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public v(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    @Override // nr4.t
    public List<Long> b(lr4.g... gVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(gVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.t
    public int c(lr4.g... gVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.c.handleMultiple(gVarArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.t
    public long d(lr4.g gVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(gVar);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.t
    public List<lr4.g> a(List<String> list) {
        String string;
        boolean z;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_booklist WHERE booklist_name IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "booklist_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "real_booklist_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.g gVar = new lr4.g();
                gVar.a = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                gVar.b = string;
                gVar.c = query.getLong(columnIndexOrThrow3);
                gVar.d = query.getLong(columnIndexOrThrow4);
                gVar.e = query.getLong(columnIndexOrThrow5);
                if (query.getInt(columnIndexOrThrow6) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                gVar.f = z;
                arrayList.add(gVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.t
    public lr4.g e(String str) {
        boolean z = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_booklist WHERE booklist_name = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.g gVar = null;
        String string = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "booklist_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "real_booklist_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            if (query.moveToFirst()) {
                lr4.g gVar2 = new lr4.g();
                gVar2.a = query.getLong(columnIndexOrThrow);
                if (!query.isNull(columnIndexOrThrow2)) {
                    string = query.getString(columnIndexOrThrow2);
                }
                gVar2.b = string;
                gVar2.c = query.getLong(columnIndexOrThrow3);
                gVar2.d = query.getLong(columnIndexOrThrow4);
                gVar2.e = query.getLong(columnIndexOrThrow5);
                if (query.getInt(columnIndexOrThrow6) == 0) {
                    z = false;
                }
                gVar2.f = z;
                gVar = gVar2;
            }
            return gVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.g> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_booklist` (`booklist_id`,`booklist_name`,`update_time`,`pinned_time`,`real_booklist_id`,`is_pinned`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.g gVar) {
            supportSQLiteStatement.bindLong(1, gVar.a);
            String str = gVar.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            supportSQLiteStatement.bindLong(3, gVar.c);
            supportSQLiteStatement.bindLong(4, gVar.d);
            supportSQLiteStatement.bindLong(5, gVar.e);
            supportSQLiteStatement.bindLong(6, gVar.f ? 1L : 0L);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.g> {
        public String createQuery() {
            return "DELETE FROM `t_booklist` WHERE `booklist_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.g gVar) {
            supportSQLiteStatement.bindLong(1, gVar.a);
        }
    }
}
