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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r4 implements p4 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.m1> b;
    private final EntityInsertionAdapter<lr4.l1> c;
    private final EntityDeletionOrUpdateAdapter<lr4.m1> d;
    private final SharedSQLiteStatement e;

    static {
        Covode.recordClassIndex(611791);
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // nr4.p4
    public int c() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT Count(*) FROM t_ugc_book_list", 0);
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

    @Override // nr4.p4
    public List<lr4.m1> h() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        String string;
        int i;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        int i2;
        String string6;
        boolean z3;
        String string7;
        int i3;
        String string8;
        String string9;
        String string10;
        int i4;
        boolean z4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_ugc_book_list ORDER BY subscribe_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_list_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "topic_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "topic_title");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "topic_status");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "topic_schemes");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_count");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "subscribe_time");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "click_time");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "operate_time");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "delete_time");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_list_type");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "user_info");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "recommend_text");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "author_abstract");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "author_pic_url");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "author_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "secondary_info");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "show_update_notify");
            int i5 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                    i = columnIndexOrThrow;
                }
                lr4.m1 m1Var = new lr4.m1(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                m1Var.b = string2;
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                m1Var.c = string3;
                m1Var.d = query.getInt(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                m1Var.e = string4;
                m1Var.f = query.getInt(columnIndexOrThrow6);
                int i6 = columnIndexOrThrow2;
                int i7 = columnIndexOrThrow3;
                m1Var.g = query.getLong(columnIndexOrThrow7);
                m1Var.h = query.getLong(columnIndexOrThrow8);
                m1Var.i = query.getLong(columnIndexOrThrow9);
                m1Var.j = query.getLong(columnIndexOrThrow10);
                if (query.getInt(columnIndexOrThrow11) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                m1Var.k = z;
                if (query.getInt(columnIndexOrThrow12) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                m1Var.l = z2;
                m1Var.m = query.getInt(columnIndexOrThrow13);
                int i8 = i5;
                if (query.isNull(i8)) {
                    string5 = null;
                } else {
                    string5 = query.getString(i8);
                }
                m1Var.n = kr4.a.a(string5);
                int i9 = columnIndexOrThrow15;
                if (query.isNull(i9)) {
                    i2 = i6;
                    string6 = null;
                } else {
                    i2 = i6;
                    string6 = query.getString(i9);
                }
                m1Var.o = string6;
                int i10 = columnIndexOrThrow16;
                columnIndexOrThrow16 = i10;
                if (query.getInt(i10) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                m1Var.p = z3;
                int i11 = columnIndexOrThrow17;
                m1Var.q = query.getLong(i11);
                int i12 = columnIndexOrThrow18;
                if (query.isNull(i12)) {
                    string7 = null;
                } else {
                    string7 = query.getString(i12);
                }
                m1Var.r = string7;
                int i13 = columnIndexOrThrow19;
                if (query.isNull(i13)) {
                    i3 = i11;
                    string8 = null;
                } else {
                    i3 = i11;
                    string8 = query.getString(i13);
                }
                m1Var.s = string8;
                int i14 = columnIndexOrThrow20;
                if (query.isNull(i14)) {
                    columnIndexOrThrow20 = i14;
                    string9 = null;
                } else {
                    columnIndexOrThrow20 = i14;
                    string9 = query.getString(i14);
                }
                m1Var.t = string9;
                columnIndexOrThrow18 = i12;
                int i15 = columnIndexOrThrow21;
                m1Var.u = query.getLong(i15);
                int i16 = columnIndexOrThrow22;
                if (query.isNull(i16)) {
                    string10 = null;
                } else {
                    string10 = query.getString(i16);
                }
                m1Var.v = string10;
                int i17 = columnIndexOrThrow23;
                if (query.getInt(i17) != 0) {
                    i4 = i15;
                    z4 = true;
                } else {
                    i4 = i15;
                    z4 = false;
                }
                m1Var.w = z4;
                arrayList.add(m1Var);
                columnIndexOrThrow23 = i17;
                columnIndexOrThrow = i;
                columnIndexOrThrow3 = i7;
                int i18 = i4;
                columnIndexOrThrow22 = i16;
                columnIndexOrThrow2 = i2;
                i5 = i8;
                columnIndexOrThrow15 = i9;
                columnIndexOrThrow17 = i3;
                columnIndexOrThrow19 = i13;
                columnIndexOrThrow21 = i18;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public r4(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    @Override // nr4.p4
    public Long[] a(lr4.l1... l1VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.c.insertAndReturnIdsArrayBox(l1VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.p4
    public Long[] d(lr4.m1... m1VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(m1VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.p4
    public int f(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.e.release(acquire);
        }
    }

    @Override // nr4.p4
    public int i(lr4.m1... m1VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.d.handleMultiple(m1VarArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.p4
    public lr4.m1 e(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        lr4.m1 m1Var;
        String string;
        int i;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        String string6;
        boolean z3;
        String string7;
        String string8;
        String string9;
        String string10;
        boolean z4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_ugc_book_list WHERE book_list_id = ? LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_list_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "topic_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "topic_title");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "topic_status");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "topic_schemes");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_count");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "subscribe_time");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "click_time");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "operate_time");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "delete_time");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_list_type");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "user_info");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "recommend_text");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "author_abstract");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "author_pic_url");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "author_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "secondary_info");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "show_update_notify");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow23;
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                    i = columnIndexOrThrow23;
                }
                lr4.m1 m1Var2 = new lr4.m1(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                m1Var2.b = string2;
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                m1Var2.c = string3;
                m1Var2.d = query.getInt(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                m1Var2.e = string4;
                m1Var2.f = query.getInt(columnIndexOrThrow6);
                m1Var2.g = query.getLong(columnIndexOrThrow7);
                m1Var2.h = query.getLong(columnIndexOrThrow8);
                m1Var2.i = query.getLong(columnIndexOrThrow9);
                m1Var2.j = query.getLong(columnIndexOrThrow10);
                if (query.getInt(columnIndexOrThrow11) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                m1Var2.k = z;
                if (query.getInt(columnIndexOrThrow12) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                m1Var2.l = z2;
                m1Var2.m = query.getInt(columnIndexOrThrow13);
                if (query.isNull(columnIndexOrThrow14)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow14);
                }
                m1Var2.n = kr4.a.a(string5);
                if (query.isNull(columnIndexOrThrow15)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow15);
                }
                m1Var2.o = string6;
                if (query.getInt(columnIndexOrThrow16) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                m1Var2.p = z3;
                m1Var2.q = query.getLong(columnIndexOrThrow17);
                if (query.isNull(columnIndexOrThrow18)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow18);
                }
                m1Var2.r = string7;
                if (query.isNull(columnIndexOrThrow19)) {
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow19);
                }
                m1Var2.s = string8;
                if (query.isNull(columnIndexOrThrow20)) {
                    string9 = null;
                } else {
                    string9 = query.getString(columnIndexOrThrow20);
                }
                m1Var2.t = string9;
                m1Var2.u = query.getLong(columnIndexOrThrow21);
                if (query.isNull(columnIndexOrThrow22)) {
                    string10 = null;
                } else {
                    string10 = query.getString(columnIndexOrThrow22);
                }
                m1Var2.v = string10;
                if (query.getInt(i) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                m1Var2.w = z4;
                m1Var = m1Var2;
            } else {
                m1Var = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return m1Var;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // nr4.p4
    public List<lr4.a1> g(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        ArrayList arrayList;
        Integer valueOf;
        int i;
        int i2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT a.book_id, a.book_type, a.book_list_id, b.name, b.cover_url, b.genre_type, b.icon_tag, b.recommend_info, b.recommend_group_id, b.book_status, a.recommend_count, a.read_count, a.book_rank, c.topic_title, a.color_dominate FROM t_ugc_book_info as a LEFT JOIN t_book as b ON a.book_id = b.book_id LEFT JOIN t_ugc_book_list as c ON a.book_list_id = c.book_list_id WHERE a.book_list_id = ? ORDER BY a.book_rank ASC", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_list_id");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "recommend_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_count");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_rank");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "topic_title");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList2 = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.a1 a1Var = new lr4.a1();
                if (query.isNull(columnIndexOrThrow)) {
                    arrayList = arrayList2;
                    a1Var.a = null;
                } else {
                    arrayList = arrayList2;
                    a1Var.a = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                }
                a1Var.b = kr4.b.b(valueOf);
                if (query.isNull(columnIndexOrThrow3)) {
                    a1Var.d = null;
                } else {
                    a1Var.d = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    a1Var.e = null;
                } else {
                    a1Var.e = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    a1Var.f = null;
                } else {
                    a1Var.f = query.getString(columnIndexOrThrow5);
                }
                a1Var.c = query.getInt(columnIndexOrThrow6);
                if (query.isNull(columnIndexOrThrow7)) {
                    a1Var.g = null;
                } else {
                    a1Var.g = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    a1Var.h = null;
                } else {
                    a1Var.h = query.getString(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    a1Var.i = null;
                } else {
                    a1Var.i = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    a1Var.j = null;
                } else {
                    a1Var.j = query.getString(columnIndexOrThrow10);
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    a1Var.k = null;
                } else {
                    a1Var.k = query.getString(columnIndexOrThrow11);
                }
                if (query.isNull(columnIndexOrThrow12)) {
                    a1Var.l = null;
                } else {
                    a1Var.l = query.getString(columnIndexOrThrow12);
                }
                a1Var.m = query.getInt(columnIndexOrThrow13);
                int i4 = i3;
                if (query.isNull(i4)) {
                    i = columnIndexOrThrow;
                    a1Var.n = null;
                } else {
                    i = columnIndexOrThrow;
                    a1Var.n = query.getString(i4);
                }
                int i5 = columnIndexOrThrow15;
                if (query.isNull(i5)) {
                    i2 = i4;
                    a1Var.o = null;
                } else {
                    i2 = i4;
                    a1Var.o = query.getString(i5);
                }
                arrayList2 = arrayList;
                arrayList2.add(a1Var);
                int i6 = i2;
                columnIndexOrThrow15 = i5;
                columnIndexOrThrow = i;
                i3 = i6;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList2;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // nr4.p4
    public List<lr4.m1> b(String... strArr) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        int i2;
        String string6;
        boolean z3;
        String string7;
        int i3;
        String string8;
        String string9;
        String string10;
        int i4;
        boolean z4;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_ugc_book_list WHERE book_list_id IN (");
        int length = strArr.length;
        StringUtil.appendPlaceholders(newStringBuilder, length);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), length + 0);
        int i5 = 1;
        for (String str : strArr) {
            if (str == null) {
                acquire.bindNull(i5);
            } else {
                acquire.bindString(i5, str);
            }
            i5++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_list_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "topic_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "topic_title");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "topic_status");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "topic_schemes");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_count");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "subscribe_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "click_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "operate_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "delete_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_list_type");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "user_info");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "recommend_text");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "author_abstract");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "author_pic_url");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "author_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "secondary_info");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "show_update_notify");
                int i6 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                        i = columnIndexOrThrow;
                    }
                    lr4.m1 m1Var = new lr4.m1(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    m1Var.b = string2;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    m1Var.c = string3;
                    m1Var.d = query.getInt(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow5);
                    }
                    m1Var.e = string4;
                    m1Var.f = query.getInt(columnIndexOrThrow6);
                    int i7 = columnIndexOrThrow2;
                    int i8 = columnIndexOrThrow3;
                    m1Var.g = query.getLong(columnIndexOrThrow7);
                    m1Var.h = query.getLong(columnIndexOrThrow8);
                    m1Var.i = query.getLong(columnIndexOrThrow9);
                    m1Var.j = query.getLong(columnIndexOrThrow10);
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m1Var.k = z;
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    m1Var.l = z2;
                    m1Var.m = query.getInt(columnIndexOrThrow13);
                    int i9 = i6;
                    if (query.isNull(i9)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(i9);
                    }
                    m1Var.n = kr4.a.a(string5);
                    int i10 = columnIndexOrThrow15;
                    if (query.isNull(i10)) {
                        i2 = i7;
                        string6 = null;
                    } else {
                        i2 = i7;
                        string6 = query.getString(i10);
                    }
                    m1Var.o = string6;
                    int i11 = columnIndexOrThrow16;
                    columnIndexOrThrow16 = i11;
                    if (query.getInt(i11) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    m1Var.p = z3;
                    int i12 = columnIndexOrThrow11;
                    int i13 = columnIndexOrThrow17;
                    int i14 = columnIndexOrThrow12;
                    m1Var.q = query.getLong(i13);
                    int i15 = columnIndexOrThrow18;
                    if (query.isNull(i15)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(i15);
                    }
                    m1Var.r = string7;
                    int i16 = columnIndexOrThrow19;
                    if (query.isNull(i16)) {
                        i3 = i13;
                        string8 = null;
                    } else {
                        i3 = i13;
                        string8 = query.getString(i16);
                    }
                    m1Var.s = string8;
                    int i17 = columnIndexOrThrow20;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow20 = i17;
                        string9 = null;
                    } else {
                        columnIndexOrThrow20 = i17;
                        string9 = query.getString(i17);
                    }
                    m1Var.t = string9;
                    columnIndexOrThrow18 = i15;
                    int i18 = columnIndexOrThrow21;
                    m1Var.u = query.getLong(i18);
                    int i19 = columnIndexOrThrow22;
                    if (query.isNull(i19)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(i19);
                    }
                    m1Var.v = string10;
                    int i20 = columnIndexOrThrow23;
                    if (query.getInt(i20) != 0) {
                        i4 = i18;
                        z4 = true;
                    } else {
                        i4 = i18;
                        z4 = false;
                    }
                    m1Var.w = z4;
                    arrayList.add(m1Var);
                    columnIndexOrThrow23 = i20;
                    columnIndexOrThrow12 = i14;
                    columnIndexOrThrow17 = i3;
                    columnIndexOrThrow19 = i16;
                    columnIndexOrThrow21 = i4;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow22 = i19;
                    columnIndexOrThrow11 = i12;
                    columnIndexOrThrow15 = i10;
                    columnIndexOrThrow3 = i8;
                    int i21 = i2;
                    i6 = i9;
                    columnIndexOrThrow2 = i21;
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

    class a extends EntityInsertionAdapter<lr4.m1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_ugc_book_list` (`book_list_id`,`topic_id`,`topic_title`,`topic_status`,`topic_schemes`,`book_count`,`subscribe_time`,`click_time`,`operate_time`,`delete_time`,`is_sync`,`is_delete`,`book_list_type`,`user_info`,`recommend_text`,`is_pinned`,`pinned_time`,`author_name`,`author_abstract`,`author_pic_url`,`author_id`,`secondary_info`,`show_update_notify`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.m1 m1Var) {
            String str = m1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = m1Var.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = m1Var.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            supportSQLiteStatement.bindLong(4, m1Var.d);
            String str4 = m1Var.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            supportSQLiteStatement.bindLong(6, m1Var.f);
            supportSQLiteStatement.bindLong(7, m1Var.g);
            supportSQLiteStatement.bindLong(8, m1Var.h);
            supportSQLiteStatement.bindLong(9, m1Var.i);
            supportSQLiteStatement.bindLong(10, m1Var.j);
            supportSQLiteStatement.bindLong(11, m1Var.k ? 1L : 0L);
            supportSQLiteStatement.bindLong(12, m1Var.l ? 1L : 0L);
            supportSQLiteStatement.bindLong(13, m1Var.m);
            String b = kr4.a.b(m1Var.n);
            if (b == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, b);
            }
            String str5 = m1Var.o;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str5);
            }
            supportSQLiteStatement.bindLong(16, m1Var.p ? 1L : 0L);
            supportSQLiteStatement.bindLong(17, m1Var.q);
            String str6 = m1Var.r;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str6);
            }
            String str7 = m1Var.s;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str7);
            }
            String str8 = m1Var.t;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str8);
            }
            supportSQLiteStatement.bindLong(21, m1Var.u);
            String str9 = m1Var.v;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str9);
            }
            supportSQLiteStatement.bindLong(23, m1Var.w ? 1L : 0L);
        }
    }

    class b extends EntityInsertionAdapter<lr4.l1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_ugc_book_info` (`book_id`,`book_type`,`book_list_id`,`recommend_count`,`read_count`,`book_rank`,`color_dominate`) VALUES (?,?,?,?,?,?,?)";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.l1 l1Var) {
            String str = l1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(l1Var.b) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r0.intValue());
            }
            String str2 = l1Var.c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = l1Var.d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = l1Var.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            supportSQLiteStatement.bindLong(6, l1Var.f);
            String str5 = l1Var.g;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str5);
            }
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<lr4.m1> {
        public String createQuery() {
            return "DELETE FROM `t_ugc_book_list` WHERE `book_list_id` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.m1 m1Var) {
            String str = m1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_ugc_book_info WHERE book_list_id = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
