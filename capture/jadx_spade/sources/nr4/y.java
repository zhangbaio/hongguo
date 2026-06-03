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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y implements w {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.h> b;

    static {
        Covode.recordClassIndex(611655);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // nr4.w
    public List<lr4.h> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        Integer num;
        Integer valueOf;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_book_progress ", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "page_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "progress_rate");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "sync");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "pager_progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "tone_id_after_v579");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.h hVar = new lr4.h();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    hVar.a = string;
                    hVar.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    hVar.c = string2;
                    hVar.d = query.getInt(columnIndexOrThrow4);
                    hVar.e = query.getFloat(columnIndexOrThrow5);
                    hVar.f = query.getInt(columnIndexOrThrow6);
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    hVar.g = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        num = null;
                        hVar.h = null;
                    } else {
                        num = null;
                        hVar.h = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        valueOf = num;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                    }
                    hVar.i = kr4.b.b(valueOf);
                    hVar.j = query.getFloat(columnIndexOrThrow10);
                    hVar.k = query.getInt(columnIndexOrThrow11);
                    hVar.l = query.getInt(columnIndexOrThrow12);
                    hVar.m = query.getInt(columnIndexOrThrow13);
                    int i5 = i2;
                    hVar.n = query.getInt(i5);
                    int i6 = columnIndexOrThrow15;
                    hVar.o = query.getInt(i6);
                    int i7 = columnIndexOrThrow16;
                    int i8 = columnIndexOrThrow13;
                    hVar.p = query.getLong(i7);
                    int i9 = columnIndexOrThrow17;
                    hVar.q = query.getLong(i9);
                    int i10 = columnIndexOrThrow18;
                    int i11 = columnIndexOrThrow4;
                    hVar.r = query.getLong(i10);
                    int i12 = columnIndexOrThrow19;
                    hVar.s = query.getLong(i12);
                    arrayList.add(hVar);
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow16 = i7;
                    i2 = i5;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow17 = i9;
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow19 = i12;
                    columnIndexOrThrow3 = i4;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    public y(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // nr4.w
    public Long[] c(lr4.h... hVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(hVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.w
    public List<lr4.h> b(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        Integer num;
        Integer valueOf;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_book_progress WHERE book_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "page_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "progress_rate");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "sync");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "pager_progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "tone_id_after_v579");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.h hVar = new lr4.h();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    hVar.a = string;
                    hVar.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    hVar.c = string2;
                    hVar.d = query.getInt(columnIndexOrThrow4);
                    hVar.e = query.getFloat(columnIndexOrThrow5);
                    hVar.f = query.getInt(columnIndexOrThrow6);
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    hVar.g = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        num = null;
                        hVar.h = null;
                    } else {
                        num = null;
                        hVar.h = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        valueOf = num;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                    }
                    hVar.i = kr4.b.b(valueOf);
                    hVar.j = query.getFloat(columnIndexOrThrow10);
                    hVar.k = query.getInt(columnIndexOrThrow11);
                    hVar.l = query.getInt(columnIndexOrThrow12);
                    hVar.m = query.getInt(columnIndexOrThrow13);
                    int i6 = i3;
                    hVar.n = query.getInt(i6);
                    int i7 = columnIndexOrThrow15;
                    hVar.o = query.getInt(i7);
                    int i8 = columnIndexOrThrow16;
                    int i9 = columnIndexOrThrow13;
                    hVar.p = query.getLong(i8);
                    int i10 = columnIndexOrThrow17;
                    hVar.q = query.getLong(i10);
                    int i11 = columnIndexOrThrow18;
                    int i12 = columnIndexOrThrow4;
                    hVar.r = query.getLong(i11);
                    int i13 = columnIndexOrThrow19;
                    hVar.s = query.getLong(i13);
                    arrayList.add(hVar);
                    columnIndexOrThrow2 = i4;
                    columnIndexOrThrow13 = i9;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow16 = i8;
                    i3 = i6;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow17 = i10;
                    columnIndexOrThrow4 = i12;
                    columnIndexOrThrow18 = i11;
                    columnIndexOrThrow19 = i13;
                    columnIndexOrThrow3 = i5;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    class a extends EntityInsertionAdapter<lr4.h> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_book_progress` (`chapter_id`,`chapter_index`,`chapter_title`,`page_index`,`progress_rate`,`sync`,`update_time`,`book_id`,`book_type`,`pager_progress_rate`,`paragraph_id`,`line_in_paragraph_offset`,`start_container_id`,`start_element_index`,`start_element_offset`,`tone_id`,`tone_id_after_v579`,`channel_id`,`cur_channel_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.h hVar) {
            if (hVar.a() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, hVar.a());
            }
            supportSQLiteStatement.bindLong(2, hVar.b);
            if (hVar.b() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, hVar.b());
            }
            supportSQLiteStatement.bindLong(4, hVar.d);
            supportSQLiteStatement.bindDouble(5, hVar.e);
            supportSQLiteStatement.bindLong(6, hVar.f);
            supportSQLiteStatement.bindLong(7, hVar.g);
            String str = hVar.h;
            if (str == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str);
            }
            if (kr4.b.a(hVar.i) == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, r0.intValue());
            }
            supportSQLiteStatement.bindDouble(10, hVar.j);
            supportSQLiteStatement.bindLong(11, hVar.k);
            supportSQLiteStatement.bindLong(12, hVar.l);
            supportSQLiteStatement.bindLong(13, hVar.m);
            supportSQLiteStatement.bindLong(14, hVar.n);
            supportSQLiteStatement.bindLong(15, hVar.o);
            supportSQLiteStatement.bindLong(16, hVar.p);
            supportSQLiteStatement.bindLong(17, hVar.q);
            supportSQLiteStatement.bindLong(18, hVar.r);
            supportSQLiteStatement.bindLong(19, hVar.s);
        }
    }
}
