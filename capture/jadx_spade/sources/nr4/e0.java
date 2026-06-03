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
public final class e0 implements c0 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.m> b;
    private final EntityDeletionOrUpdateAdapter<lr4.m> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611661);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // nr4.c0
    public List<lr4.m> f() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_bookmark_local", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mark_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "end_paragraph_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_media_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "end_media_index");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.m mVar = new lr4.m();
                    ArrayList arrayList2 = arrayList;
                    int i2 = columnIndexOrThrow13;
                    mVar.a = query.getLong(columnIndexOrThrow);
                    mVar.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        mVar.c = null;
                    } else {
                        mVar.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        mVar.d = null;
                    } else {
                        mVar.d = query.getString(columnIndexOrThrow4);
                    }
                    mVar.e = query.getInt(columnIndexOrThrow5);
                    mVar.f = query.getInt(columnIndexOrThrow6);
                    mVar.g = query.getInt(columnIndexOrThrow7);
                    mVar.h = query.getInt(columnIndexOrThrow8);
                    mVar.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        mVar.j = null;
                    } else {
                        mVar.j = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        mVar.k = null;
                    } else {
                        mVar.k = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        mVar.l = null;
                    } else {
                        mVar.l = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(i2)) {
                        mVar.m = null;
                    } else {
                        mVar.m = query.getString(i2);
                    }
                    int i3 = i;
                    int i4 = columnIndexOrThrow;
                    mVar.n = query.getInt(i3);
                    int i5 = columnIndexOrThrow15;
                    mVar.o = query.getInt(i5);
                    columnIndexOrThrow15 = i5;
                    int i6 = columnIndexOrThrow16;
                    mVar.p = query.getInt(i6);
                    columnIndexOrThrow16 = i6;
                    int i7 = columnIndexOrThrow17;
                    mVar.q = query.getInt(i7);
                    columnIndexOrThrow17 = i7;
                    int i8 = columnIndexOrThrow18;
                    mVar.r = query.getInt(i8);
                    columnIndexOrThrow18 = i8;
                    int i9 = columnIndexOrThrow19;
                    mVar.s = query.getInt(i9);
                    columnIndexOrThrow19 = i9;
                    int i10 = columnIndexOrThrow20;
                    mVar.t = query.getInt(i10);
                    columnIndexOrThrow20 = i10;
                    int i11 = columnIndexOrThrow21;
                    mVar.u = query.getInt(i11);
                    columnIndexOrThrow21 = i11;
                    int i12 = columnIndexOrThrow22;
                    mVar.v = query.getInt(i12);
                    columnIndexOrThrow22 = i12;
                    int i13 = columnIndexOrThrow23;
                    mVar.w = query.getInt(i13);
                    int i14 = columnIndexOrThrow2;
                    int i15 = columnIndexOrThrow24;
                    mVar.x = query.getLong(i15);
                    arrayList2.add(mVar);
                    columnIndexOrThrow2 = i14;
                    columnIndexOrThrow23 = i13;
                    columnIndexOrThrow = i4;
                    i = i3;
                    columnIndexOrThrow24 = i15;
                    arrayList = arrayList2;
                    columnIndexOrThrow13 = i2;
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

    public e0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.c0
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

    @Override // nr4.c0
    public int b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_bookmark_local WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        int i = 0;
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

    @Override // nr4.c0
    public void c(List<lr4.m> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.c0
    public List<Long> d(List<lr4.m> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(list);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.c0
    public List<lr4.m> e(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_bookmark_local WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mark_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "end_paragraph_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_media_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "end_media_index");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.m mVar = new lr4.m();
                    int i3 = columnIndexOrThrow11;
                    int i4 = columnIndexOrThrow12;
                    mVar.a = query.getLong(columnIndexOrThrow);
                    mVar.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        mVar.c = null;
                    } else {
                        mVar.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        mVar.d = null;
                    } else {
                        mVar.d = query.getString(columnIndexOrThrow4);
                    }
                    mVar.e = query.getInt(columnIndexOrThrow5);
                    mVar.f = query.getInt(columnIndexOrThrow6);
                    mVar.g = query.getInt(columnIndexOrThrow7);
                    mVar.h = query.getInt(columnIndexOrThrow8);
                    mVar.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        mVar.j = null;
                    } else {
                        mVar.j = query.getString(columnIndexOrThrow10);
                    }
                    columnIndexOrThrow11 = i3;
                    if (query.isNull(columnIndexOrThrow11)) {
                        mVar.k = null;
                    } else {
                        mVar.k = query.getString(columnIndexOrThrow11);
                    }
                    columnIndexOrThrow12 = i4;
                    if (query.isNull(columnIndexOrThrow12)) {
                        i = columnIndexOrThrow;
                        mVar.l = null;
                    } else {
                        i = columnIndexOrThrow;
                        mVar.l = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        mVar.m = null;
                    } else {
                        mVar.m = query.getString(columnIndexOrThrow13);
                    }
                    int i5 = i2;
                    int i6 = columnIndexOrThrow13;
                    mVar.n = query.getInt(i5);
                    int i7 = columnIndexOrThrow15;
                    mVar.o = query.getInt(i7);
                    int i8 = columnIndexOrThrow16;
                    mVar.p = query.getInt(i8);
                    int i9 = columnIndexOrThrow17;
                    mVar.q = query.getInt(i9);
                    int i10 = columnIndexOrThrow18;
                    mVar.r = query.getInt(i10);
                    int i11 = columnIndexOrThrow19;
                    mVar.s = query.getInt(i11);
                    int i12 = columnIndexOrThrow20;
                    mVar.t = query.getInt(i12);
                    int i13 = columnIndexOrThrow21;
                    mVar.u = query.getInt(i13);
                    int i14 = columnIndexOrThrow22;
                    mVar.v = query.getInt(i14);
                    int i15 = columnIndexOrThrow23;
                    mVar.w = query.getInt(i15);
                    int i16 = columnIndexOrThrow24;
                    int i17 = columnIndexOrThrow2;
                    mVar.x = query.getLong(i16);
                    arrayList.add(mVar);
                    columnIndexOrThrow2 = i17;
                    columnIndexOrThrow13 = i6;
                    columnIndexOrThrow24 = i16;
                    i2 = i5;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow16 = i8;
                    columnIndexOrThrow17 = i9;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow19 = i11;
                    columnIndexOrThrow20 = i12;
                    columnIndexOrThrow21 = i13;
                    columnIndexOrThrow22 = i14;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow23 = i15;
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

    class a extends EntityInsertionAdapter<lr4.m> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_bookmark_local` (`id`,`mark_type`,`book_id`,`chapter_id`,`chapter_index`,`paragraph_id`,`end_paragraph_id`,`start_offset_in_para`,`end_offset_in_para`,`chapter_version`,`content`,`chapter_title`,`volume_name`,`start_media_index`,`end_media_index`,`start_container_id`,`start_element_index`,`start_element_offset`,`end_container_id`,`end_element_index`,`end_element_offset`,`start_order`,`end_order`,`modify_time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.m mVar) {
            supportSQLiteStatement.bindLong(1, mVar.a);
            supportSQLiteStatement.bindLong(2, mVar.b);
            String str = mVar.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = mVar.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, mVar.e);
            supportSQLiteStatement.bindLong(6, mVar.f);
            supportSQLiteStatement.bindLong(7, mVar.g);
            supportSQLiteStatement.bindLong(8, mVar.h);
            supportSQLiteStatement.bindLong(9, mVar.i);
            String str3 = mVar.j;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str3);
            }
            String str4 = mVar.k;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str4);
            }
            String str5 = mVar.l;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            String str6 = mVar.m;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str6);
            }
            supportSQLiteStatement.bindLong(14, mVar.n);
            supportSQLiteStatement.bindLong(15, mVar.o);
            supportSQLiteStatement.bindLong(16, mVar.p);
            supportSQLiteStatement.bindLong(17, mVar.q);
            supportSQLiteStatement.bindLong(18, mVar.r);
            supportSQLiteStatement.bindLong(19, mVar.s);
            supportSQLiteStatement.bindLong(20, mVar.t);
            supportSQLiteStatement.bindLong(21, mVar.u);
            supportSQLiteStatement.bindLong(22, mVar.v);
            supportSQLiteStatement.bindLong(23, mVar.w);
            supportSQLiteStatement.bindLong(24, mVar.x);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.m> {
        public String createQuery() {
            return "DELETE FROM `t_bookmark_local` WHERE `id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.m mVar) {
            supportSQLiteStatement.bindLong(1, mVar.a);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_bookmark_local WHERE book_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
