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
public final class p implements n {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.f> b;
    private final EntityDeletionOrUpdateAdapter<lr4.f> c;

    static {
        Covode.recordClassIndex(611646);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public p(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    @Override // nr4.n
    public int delete(lr4.f... fVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.c.handleMultiple(fVarArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.n
    public Long[] insert(lr4.f... fVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(fVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.n
    public List<lr4.f> a(List<String> list) {
        String string;
        String string2;
        boolean z;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_book_content_detail WHERE book_id IN (");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_content");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "current_chapter_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "expect_show_next_chapter");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                lr4.f fVar = new lr4.f(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                fVar.b = string2;
                fVar.c = query.getInt(columnIndexOrThrow3);
                fVar.d = query.getInt(columnIndexOrThrow4);
                if (query.getInt(columnIndexOrThrow5) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                fVar.e = z;
                arrayList.add(fVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.n
    public lr4.f b(String str) {
        String string;
        boolean z = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_book_content_detail WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.f fVar = null;
        String string2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_content");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "current_chapter_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "expect_show_next_chapter");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                lr4.f fVar2 = new lr4.f(string);
                if (!query.isNull(columnIndexOrThrow2)) {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                fVar2.b = string2;
                fVar2.c = query.getInt(columnIndexOrThrow3);
                fVar2.d = query.getInt(columnIndexOrThrow4);
                if (query.getInt(columnIndexOrThrow5) == 0) {
                    z = false;
                }
                fVar2.e = z;
                fVar = fVar2;
            }
            return fVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.f> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_book_content_detail` (`book_id`,`book_content`,`content_type`,`current_chapter_index`,`expect_show_next_chapter`) VALUES (?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.f fVar) {
            String str = fVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (fVar.a() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, fVar.a());
            }
            supportSQLiteStatement.bindLong(3, fVar.c);
            supportSQLiteStatement.bindLong(4, fVar.d);
            supportSQLiteStatement.bindLong(5, fVar.e ? 1L : 0L);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.f> {
        public String createQuery() {
            return "DELETE FROM `t_book_content_detail` WHERE `book_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.f fVar) {
            String str = fVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }
}
