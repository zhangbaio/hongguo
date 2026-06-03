package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j1 implements h1 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<vt4.b> b;
    private final EntityDeletionOrUpdateAdapter<vt4.b> c;

    static {
        Covode.recordClassIndex(611694);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // nr4.h1
    public List<vt4.b> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
        int i;
        String string2;
        String string3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_download_book ORDER BY create_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "percent");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "download_size");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "unlock_downloaded_size");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "total_file_length");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "pause_reason");
            roomSQLiteQuery = acquire;
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        i = columnIndexOrThrow;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                        i = columnIndexOrThrow;
                    }
                    BookType b2 = kr4.b.b(valueOf);
                    int i2 = columnIndexOrThrow2;
                    vt4.b bVar = new vt4.b(string, b2);
                    bVar.c = query.getInt(columnIndexOrThrow3);
                    ArrayList arrayList2 = arrayList;
                    bVar.d = query.getLong(columnIndexOrThrow4);
                    bVar.e = query.getLong(columnIndexOrThrow5);
                    bVar.f = query.getFloat(columnIndexOrThrow6);
                    bVar.g = query.getInt(columnIndexOrThrow7);
                    bVar.h = query.getInt(columnIndexOrThrow8);
                    bVar.i = query.getInt(columnIndexOrThrow9);
                    bVar.j = query.getLong(columnIndexOrThrow10);
                    if (query.isNull(columnIndexOrThrow11)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow11);
                    }
                    bVar.a(string2);
                    if (query.isNull(columnIndexOrThrow12)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow12);
                    }
                    bVar.b(string3);
                    bVar.m = query.getInt(columnIndexOrThrow13);
                    arrayList2.add(bVar);
                    arrayList = arrayList2;
                    columnIndexOrThrow2 = i2;
                    columnIndexOrThrow = i;
                }
                ArrayList arrayList3 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    public j1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    @Override // nr4.h1
    public void a(List<vt4.b> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.h1
    public void delete(List<vt4.b> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    class a extends EntityInsertionAdapter<vt4.b> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_download_book` (`book_id`,`book_type`,`status`,`create_time`,`update_time`,`percent`,`download_size`,`unlock_downloaded_size`,`genre_type`,`total_file_length`,`book_name`,`cover_url`,`pause_reason`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, vt4.b bVar) {
            String str = bVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(bVar.b) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r0.intValue());
            }
            supportSQLiteStatement.bindLong(3, bVar.c);
            supportSQLiteStatement.bindLong(4, bVar.d);
            supportSQLiteStatement.bindLong(5, bVar.e);
            supportSQLiteStatement.bindDouble(6, bVar.f);
            supportSQLiteStatement.bindLong(7, bVar.g);
            supportSQLiteStatement.bindLong(8, bVar.h);
            supportSQLiteStatement.bindLong(9, bVar.i);
            supportSQLiteStatement.bindLong(10, bVar.j);
            String str2 = bVar.k;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str2);
            }
            String str3 = bVar.l;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str3);
            }
            supportSQLiteStatement.bindLong(13, bVar.m);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<vt4.b> {
        public String createQuery() {
            return "DELETE FROM `t_download_book` WHERE `book_id` = ? AND `book_type` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, vt4.b bVar) {
            String str = bVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(bVar.b) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r5.intValue());
            }
        }
    }

    @Override // nr4.h1
    public vt4.b c(String str, BookType bookType) {
        vt4.b bVar;
        String string;
        Integer valueOf;
        String string2;
        String string3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_download_book  WHERE book_id = ? AND book_type = ? LIMIT 1", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (kr4.b.a(bookType) == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, r0.intValue());
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "percent");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "download_size");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "unlock_downloaded_size");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "total_file_length");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "pause_reason");
            if (query.moveToFirst()) {
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
                vt4.b bVar2 = new vt4.b(string, kr4.b.b(valueOf));
                bVar2.c = query.getInt(columnIndexOrThrow3);
                bVar2.d = query.getLong(columnIndexOrThrow4);
                bVar2.e = query.getLong(columnIndexOrThrow5);
                bVar2.f = query.getFloat(columnIndexOrThrow6);
                bVar2.g = query.getInt(columnIndexOrThrow7);
                bVar2.h = query.getInt(columnIndexOrThrow8);
                bVar2.i = query.getInt(columnIndexOrThrow9);
                bVar2.j = query.getLong(columnIndexOrThrow10);
                if (query.isNull(columnIndexOrThrow11)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow11);
                }
                bVar2.a(string2);
                if (query.isNull(columnIndexOrThrow12)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow12);
                }
                bVar2.b(string3);
                bVar2.m = query.getInt(columnIndexOrThrow13);
                bVar = bVar2;
            } else {
                bVar = null;
            }
            return bVar;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
