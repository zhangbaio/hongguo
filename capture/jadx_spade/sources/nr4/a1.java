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
public final class a1 implements y0 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.w> b;
    private final EntityDeletionOrUpdateAdapter<lr4.w> c;
    private final EntityDeletionOrUpdateAdapter<lr4.w> d;

    static {
        Covode.recordClassIndex(611685);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    public a1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.y0
    public void a(List<lr4.w> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y0
    public List<lr4.w> b(List<String> list) {
        String string;
        String string2;
        String string3;
        String string4;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_comic_read_progress_record WHERE chapter_id IN (");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "comic_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "read_progress");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "catalog_order");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.w wVar = new lr4.w();
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                wVar.c(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                wVar.b(string2);
                wVar.c = query.getInt(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow4);
                }
                wVar.a(string3);
                if (query.isNull(columnIndexOrThrow5)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                wVar.d(string4);
                arrayList.add(wVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.y0
    public List<lr4.w> c(List<String> list) {
        String string;
        String string2;
        String string3;
        String string4;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_comic_read_progress_record WHERE comic_id In (");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "comic_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "read_progress");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "catalog_order");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.w wVar = new lr4.w();
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                wVar.c(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                wVar.b(string2);
                wVar.c = query.getInt(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow4);
                }
                wVar.a(string3);
                if (query.isNull(columnIndexOrThrow5)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                wVar.d(string4);
                arrayList.add(wVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<lr4.w> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_comic_read_progress_record` (`comic_id`,`chapter_id`,`read_progress`,`catalog_order`,`last_update_time`) VALUES (?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.w wVar) {
            String str = wVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = wVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, wVar.c);
            String str3 = wVar.d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = wVar.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.w> {
        public String createQuery() {
            return "DELETE FROM `t_comic_read_progress_record` WHERE `comic_id` = ? AND `chapter_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.w wVar) {
            String str = wVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = wVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<lr4.w> {
        public String createQuery() {
            return "UPDATE OR ABORT `t_comic_read_progress_record` SET `comic_id` = ?,`chapter_id` = ?,`read_progress` = ?,`catalog_order` = ?,`last_update_time` = ? WHERE `comic_id` = ? AND `chapter_id` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.w wVar) {
            String str = wVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = wVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, wVar.c);
            String str3 = wVar.d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = wVar.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            String str5 = wVar.a;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str5);
            }
            String str6 = wVar.b;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str6);
            }
        }
    }
}
