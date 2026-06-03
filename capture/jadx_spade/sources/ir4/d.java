package ir4;

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
public final class d implements ir4.c {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<ir4.a> b;
    private final EntityDeletionOrUpdateAdapter<ir4.a> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611506);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // ir4.c
    public void delete(ir4.a aVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(aVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ir4.c
    public void delete(List<ir4.a> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ir4.c
    public List<ir4.a> a(String str) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ChapterPageAdEntity WHERE chapterId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "chapterId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapterPageIndex");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "expiredTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "adModel");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                int i = query.getInt(columnIndexOrThrow2);
                long j = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                arrayList.add(new ir4.a(string, i, j, fr4.a.a(string2)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<ir4.a> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `ChapterPageAdEntity` (`chapterId`,`chapterPageIndex`,`expiredTime`,`adModel`) VALUES (?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ir4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, aVar.b);
            supportSQLiteStatement.bindLong(3, aVar.c);
            String b = fr4.a.b(aVar.d);
            if (b == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, b);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<ir4.a> {
        public String createQuery() {
            return "DELETE FROM `ChapterPageAdEntity` WHERE `chapterId` = ? AND `chapterPageIndex` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ir4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, aVar.b);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "delete from ChapterPageAdEntity";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // ir4.c
    public ir4.a query(String str, int i) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ChapterPageAdEntity WHERE chapterId = ? AND chapterPageIndex = ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, i);
        this.a.assertNotSuspendingTransaction();
        ir4.a aVar = null;
        String string2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "chapterId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapterPageIndex");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "expiredTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "adModel");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                int i2 = query.getInt(columnIndexOrThrow2);
                long j = query.getLong(columnIndexOrThrow3);
                if (!query.isNull(columnIndexOrThrow4)) {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                aVar = new ir4.a(string, i2, j, fr4.a.a(string2));
            }
            return aVar;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
