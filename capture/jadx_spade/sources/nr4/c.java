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
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements nr4.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.a> b;
    private final EntityDeletionOrUpdateAdapter<lr4.a> c;
    private final EntityDeletionOrUpdateAdapter<lr4.a> d;
    private final SharedSQLiteStatement e;

    static {
        Covode.recordClassIndex(611633);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // nr4.a
    public List<lr4.a> c() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_bookshelf_guide_info", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "last_show_time_ms");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.a aVar = new lr4.a();
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                aVar.a(string);
                aVar.b = query.getLong(columnIndexOrThrow2);
                aVar.c = query.getLong(columnIndexOrThrow3);
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new C0247c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    @Override // nr4.a
    public void a(lr4.a aVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(aVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.a
    public void b(List<lr4.a> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.a
    public lr4.a d(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_audio_bookshelf_guide_info WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        lr4.a aVar = null;
        String string = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "last_show_time_ms");
            if (query.moveToFirst()) {
                lr4.a aVar2 = new lr4.a();
                if (!query.isNull(columnIndexOrThrow)) {
                    string = query.getString(columnIndexOrThrow);
                }
                aVar2.a(string);
                aVar2.b = query.getLong(columnIndexOrThrow2);
                aVar2.c = query.getLong(columnIndexOrThrow3);
                aVar = aVar2;
            }
            return aVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.a> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_audio_bookshelf_guide_info` (`book_id`,`player_accumulate_total_time`,`last_show_time_ms`) VALUES (?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, aVar.b);
            supportSQLiteStatement.bindLong(3, aVar.c);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.a> {
        public String createQuery() {
            return "DELETE FROM `t_audio_bookshelf_guide_info` WHERE `book_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    /* renamed from: nr4.c$c, reason: collision with other inner class name */
    class C0247c extends EntityDeletionOrUpdateAdapter<lr4.a> {
        public String createQuery() {
            return "UPDATE OR ABORT `t_audio_bookshelf_guide_info` SET `book_id` = ?,`player_accumulate_total_time` = ?,`last_show_time_ms` = ? WHERE `book_id` = ?";
        }

        C0247c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, aVar.b);
            supportSQLiteStatement.bindLong(3, aVar.c);
            String str2 = aVar.a;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_audio_bookshelf_guide_info WHERE book_id = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
