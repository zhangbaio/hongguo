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
public final class f implements e {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<ir4.b> b;
    private final EntityDeletionOrUpdateAdapter<ir4.b> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611508);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // ir4.e
    public void delete(List<ir4.b> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ir4.e
    public List<ir4.b> a(long j) {
        String string;
        boolean z;
        boolean z2;
        String string2;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ChapterStrategyInfoEntity WHERE expiredTime <= ?", 1);
        acquire.bindLong(1, j);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "chapterId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapterIndex");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "strategyChapterIndex");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "strategyIndex");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "showAd");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "hasAtAdReturn");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "rangeInfoList");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "expiredTime");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "tip");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "tipOptimizeFirst");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "tipOptimizeSecond");
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
                if (query.getInt(columnIndexOrThrow5) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (query.getInt(columnIndexOrThrow6) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow7);
                }
                List<Object> a2 = fr4.b.a(string2);
                long j2 = query.getLong(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow10);
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow11);
                }
                arrayList.add(new ir4.b(string, i, i2, i3, z, z2, a2, j2, string3, string4, string5));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ir4.e
    public ir4.b query(String str) {
        String string;
        boolean z;
        boolean z2;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ChapterStrategyInfoEntity WHERE chapterId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        ir4.b bVar = null;
        String string5 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "chapterId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapterIndex");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "strategyChapterIndex");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "strategyIndex");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "showAd");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "hasAtAdReturn");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "rangeInfoList");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "expiredTime");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "tip");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "tipOptimizeFirst");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "tipOptimizeSecond");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                int i = query.getInt(columnIndexOrThrow2);
                int i2 = query.getInt(columnIndexOrThrow3);
                int i3 = query.getInt(columnIndexOrThrow4);
                if (query.getInt(columnIndexOrThrow5) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (query.getInt(columnIndexOrThrow6) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow7);
                }
                List<Object> a2 = fr4.b.a(string2);
                long j = query.getLong(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow10);
                }
                if (!query.isNull(columnIndexOrThrow11)) {
                    string5 = query.getString(columnIndexOrThrow11);
                }
                bVar = new ir4.b(string, i, i2, i3, z, z2, a2, j, string3, string4, string5);
            }
            return bVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<ir4.b> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `ChapterStrategyInfoEntity` (`chapterId`,`chapterIndex`,`strategyChapterIndex`,`strategyIndex`,`showAd`,`hasAtAdReturn`,`rangeInfoList`,`expiredTime`,`tip`,`tipOptimizeFirst`,`tipOptimizeSecond`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ir4.b bVar) {
            String str = bVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, bVar.b);
            supportSQLiteStatement.bindLong(3, bVar.c);
            supportSQLiteStatement.bindLong(4, bVar.d);
            supportSQLiteStatement.bindLong(5, bVar.e ? 1L : 0L);
            supportSQLiteStatement.bindLong(6, bVar.f ? 1L : 0L);
            String b = fr4.b.b(bVar.g);
            if (b == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, b);
            }
            supportSQLiteStatement.bindLong(8, bVar.h);
            String str2 = bVar.i;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str2);
            }
            String str3 = bVar.j;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str3);
            }
            String str4 = bVar.k;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str4);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<ir4.b> {
        public String createQuery() {
            return "DELETE FROM `ChapterStrategyInfoEntity` WHERE `chapterId` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ir4.b bVar) {
            String str = bVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "delete from ChapterStrategyInfoEntity";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
