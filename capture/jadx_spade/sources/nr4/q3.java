package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q3 implements o3 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.d1> b;

    static {
        Covode.recordClassIndex(611764);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    @Override // nr4.o3
    public List<lr4.d1> c() {
        String string;
        Integer valueOf;
        String string2;
        String string3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_relative_book_id", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                }
                lr4.d1 d1Var = new lr4.d1(string, kr4.b.b(valueOf));
                if (query.isNull(columnIndexOrThrow3)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                d1Var.c = kr4.h.b(string2);
                if (query.isNull(columnIndexOrThrow4)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow4);
                }
                d1Var.d = string3;
                arrayList.add(d1Var);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public q3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // nr4.o3
    public Long[] h(lr4.d1... d1VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(d1VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.o3
    public List<pr4.c> d(List<String> list) {
        Integer valueOf;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, book_type, relative_novel_book_id FROM t_relative_book_id WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") AND book_type = 1");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                pr4.c cVar = new pr4.c();
                if (query.isNull(columnIndexOrThrow)) {
                    cVar.a = null;
                } else {
                    cVar.a = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                }
                cVar.b = kr4.b.b(valueOf);
                if (query.isNull(columnIndexOrThrow3)) {
                    cVar.c = null;
                } else {
                    cVar.c = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(cVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.o3
    public List<lr4.d1> e(List<String> list) {
        String string;
        Integer valueOf;
        String string2;
        String string3;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_relative_book_id WHERE id IN (");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                }
                lr4.d1 d1Var = new lr4.d1(string, kr4.b.b(valueOf));
                if (query.isNull(columnIndexOrThrow3)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                d1Var.c = kr4.h.b(string2);
                if (query.isNull(columnIndexOrThrow4)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow4);
                }
                d1Var.d = string3;
                arrayList.add(d1Var);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.o3
    public List<pr4.b> g(List<String> list) {
        String string;
        String string2;
        Integer valueOf;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, book_type, relative_audio_book_id_set FROM t_relative_book_id WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") AND book_type = 1");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                pr4.b bVar = new pr4.b(string, kr4.h.b(string2));
                if (query.isNull(columnIndexOrThrow2)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                }
                bVar.b = kr4.b.b(valueOf);
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.d1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_relative_book_id` (`id`,`book_type`,`relative_audio_book_id_set`,`relative_novel_book_id`) VALUES (?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.d1 d1Var) {
            String str = d1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(d1Var.b) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r0.intValue());
            }
            String a = kr4.h.a(d1Var.c);
            if (a == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, a);
            }
            String str2 = d1Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
        }
    }

    @Override // nr4.o3
    public String b(String str, BookType bookType) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT relative_novel_book_id FROM t_relative_book_id WHERE id = (?) AND book_type = (?)", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (kr4.b.a(bookType) == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, r4.intValue());
        }
        this.a.assertNotSuspendingTransaction();
        String str2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst() && !query.isNull(0)) {
                str2 = query.getString(0);
            }
            return str2;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.o3
    public String f(String str, BookType bookType) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT relative_audio_book_id_set FROM t_relative_book_id WHERE id = (?) AND book_type = (?)", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (kr4.b.a(bookType) == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, r4.intValue());
        }
        this.a.assertNotSuspendingTransaction();
        String str2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst() && !query.isNull(0)) {
                str2 = query.getString(0);
            }
            return str2;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
