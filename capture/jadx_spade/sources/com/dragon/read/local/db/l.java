package com.dragon.read.local.db;

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
import lr4.o1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l implements j {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<o1> b;
    private final EntityDeletionOrUpdateAdapter<o1> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611531);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // com.dragon.read.local.db.j
    public List<o1> g() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        int i2;
        boolean z;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_underline_local", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mark_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "start_para_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "end_para_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "line_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "is_public");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "hot_line_id");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "underline_type");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "notes");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    long j = query.getLong(columnIndexOrThrow);
                    int i4 = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow4);
                    }
                    int i5 = query.getInt(columnIndexOrThrow5);
                    int i6 = query.getInt(columnIndexOrThrow6);
                    int i7 = query.getInt(columnIndexOrThrow7);
                    int i8 = query.getInt(columnIndexOrThrow8);
                    int i9 = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        i = i3;
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow13);
                        i = i3;
                    }
                    int i10 = query.getInt(i);
                    int i11 = columnIndexOrThrow;
                    int i12 = columnIndexOrThrow15;
                    int i13 = query.getInt(i12);
                    columnIndexOrThrow15 = i12;
                    int i14 = columnIndexOrThrow16;
                    int i15 = query.getInt(i14);
                    columnIndexOrThrow16 = i14;
                    int i16 = columnIndexOrThrow17;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow17 = i16;
                    int i18 = columnIndexOrThrow18;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow18 = i18;
                    int i20 = columnIndexOrThrow19;
                    int i21 = query.getInt(i20);
                    columnIndexOrThrow19 = i20;
                    int i22 = columnIndexOrThrow20;
                    int i23 = query.getInt(i22);
                    columnIndexOrThrow20 = i22;
                    int i24 = columnIndexOrThrow21;
                    int i25 = query.getInt(i24);
                    columnIndexOrThrow21 = i24;
                    int i26 = columnIndexOrThrow22;
                    long j2 = query.getLong(i26);
                    columnIndexOrThrow22 = i26;
                    int i27 = columnIndexOrThrow23;
                    int i28 = query.getInt(i27);
                    columnIndexOrThrow23 = i27;
                    int i29 = columnIndexOrThrow24;
                    if (query.getInt(i29) != 0) {
                        columnIndexOrThrow24 = i29;
                        i2 = columnIndexOrThrow25;
                        z = true;
                    } else {
                        columnIndexOrThrow24 = i29;
                        i2 = columnIndexOrThrow25;
                        z = false;
                    }
                    long j3 = query.getLong(i2);
                    columnIndexOrThrow25 = i2;
                    int i30 = columnIndexOrThrow26;
                    int i31 = query.getInt(i30);
                    columnIndexOrThrow26 = i30;
                    int i32 = columnIndexOrThrow27;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow27 = i32;
                        string7 = null;
                    } else {
                        string7 = query.getString(i32);
                        columnIndexOrThrow27 = i32;
                    }
                    arrayList.add(new o1(j, i4, string, string2, i5, i6, i7, i8, i9, string3, string4, string5, string6, i10, i13, i15, i17, i19, i21, i23, i25, j2, i28, z, j3, i31, string7));
                    columnIndexOrThrow = i11;
                    i3 = i;
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

    public l(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // com.dragon.read.local.db.j
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

    @Override // com.dragon.read.local.db.j
    public int b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_underline_local WHERE book_id =? AND underline_type=1", 1);
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

    @Override // com.dragon.read.local.db.j
    public void c(List<o1> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.dragon.read.local.db.j
    public int d(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_underline_local WHERE book_id =? AND underline_type=0", 1);
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

    @Override // com.dragon.read.local.db.j
    public List<Long> f(List<o1> list) {
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

    @Override // com.dragon.read.local.db.j
    public List<o1> e(String str) {
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
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        int i2;
        boolean z;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_underline_local WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mark_type");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "start_para_id");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "end_para_id");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "line_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "is_public");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "hot_line_id");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "underline_type");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "notes");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j = query.getLong(columnIndexOrThrow);
                int i4 = query.getInt(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                int i5 = query.getInt(columnIndexOrThrow5);
                int i6 = query.getInt(columnIndexOrThrow6);
                int i7 = query.getInt(columnIndexOrThrow7);
                int i8 = query.getInt(columnIndexOrThrow8);
                int i9 = query.getInt(columnIndexOrThrow9);
                if (query.isNull(columnIndexOrThrow10)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow10);
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow11);
                }
                if (query.isNull(columnIndexOrThrow12)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow12);
                }
                if (query.isNull(columnIndexOrThrow13)) {
                    i = i3;
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow13);
                    i = i3;
                }
                int i10 = query.getInt(i);
                int i11 = columnIndexOrThrow;
                int i12 = columnIndexOrThrow15;
                int i13 = query.getInt(i12);
                columnIndexOrThrow15 = i12;
                int i14 = columnIndexOrThrow16;
                int i15 = query.getInt(i14);
                columnIndexOrThrow16 = i14;
                int i16 = columnIndexOrThrow17;
                int i17 = query.getInt(i16);
                columnIndexOrThrow17 = i16;
                int i18 = columnIndexOrThrow18;
                int i19 = query.getInt(i18);
                columnIndexOrThrow18 = i18;
                int i20 = columnIndexOrThrow19;
                int i21 = query.getInt(i20);
                columnIndexOrThrow19 = i20;
                int i22 = columnIndexOrThrow20;
                int i23 = query.getInt(i22);
                columnIndexOrThrow20 = i22;
                int i24 = columnIndexOrThrow21;
                int i25 = query.getInt(i24);
                columnIndexOrThrow21 = i24;
                int i26 = columnIndexOrThrow22;
                long j2 = query.getLong(i26);
                columnIndexOrThrow22 = i26;
                int i27 = columnIndexOrThrow23;
                int i28 = query.getInt(i27);
                columnIndexOrThrow23 = i27;
                int i29 = columnIndexOrThrow24;
                if (query.getInt(i29) != 0) {
                    columnIndexOrThrow24 = i29;
                    i2 = columnIndexOrThrow25;
                    z = true;
                } else {
                    columnIndexOrThrow24 = i29;
                    i2 = columnIndexOrThrow25;
                    z = false;
                }
                long j3 = query.getLong(i2);
                columnIndexOrThrow25 = i2;
                int i30 = columnIndexOrThrow26;
                int i31 = query.getInt(i30);
                columnIndexOrThrow26 = i30;
                int i32 = columnIndexOrThrow27;
                if (query.isNull(i32)) {
                    columnIndexOrThrow27 = i32;
                    string7 = null;
                } else {
                    string7 = query.getString(i32);
                    columnIndexOrThrow27 = i32;
                }
                arrayList.add(new o1(j, i4, string, string2, i5, i6, i7, i8, i9, string3, string4, string5, string6, i10, i13, i15, i17, i19, i21, i23, i25, j2, i28, z, j3, i31, string7));
                columnIndexOrThrow = i11;
                i3 = i;
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

    class a extends EntityInsertionAdapter<o1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_underline_local` (`id`,`mark_type`,`book_id`,`chapter_id`,`chapter_index`,`start_para_id`,`start_offset_in_para`,`end_para_id`,`end_offset_in_para`,`chapter_version`,`content`,`chapter_title`,`volume_name`,`start_container_id`,`start_element_index`,`start_element_offset`,`end_container_id`,`end_element_index`,`end_element_offset`,`start_order`,`end_order`,`modify_time`,`line_type`,`is_public`,`hot_line_id`,`underline_type`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, o1 o1Var) {
            supportSQLiteStatement.bindLong(1, o1Var.a);
            supportSQLiteStatement.bindLong(2, o1Var.b);
            String str = o1Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = o1Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, o1Var.e);
            supportSQLiteStatement.bindLong(6, o1Var.f);
            supportSQLiteStatement.bindLong(7, o1Var.g);
            supportSQLiteStatement.bindLong(8, o1Var.h);
            supportSQLiteStatement.bindLong(9, o1Var.i);
            String str3 = o1Var.j;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str3);
            }
            String str4 = o1Var.k;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str4);
            }
            String str5 = o1Var.l;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            String str6 = o1Var.m;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str6);
            }
            supportSQLiteStatement.bindLong(14, o1Var.n);
            supportSQLiteStatement.bindLong(15, o1Var.o);
            supportSQLiteStatement.bindLong(16, o1Var.p);
            supportSQLiteStatement.bindLong(17, o1Var.q);
            supportSQLiteStatement.bindLong(18, o1Var.r);
            supportSQLiteStatement.bindLong(19, o1Var.s);
            supportSQLiteStatement.bindLong(20, o1Var.t);
            supportSQLiteStatement.bindLong(21, o1Var.u);
            supportSQLiteStatement.bindLong(22, o1Var.v);
            supportSQLiteStatement.bindLong(23, o1Var.w);
            supportSQLiteStatement.bindLong(24, o1Var.x ? 1L : 0L);
            supportSQLiteStatement.bindLong(25, o1Var.y);
            supportSQLiteStatement.bindLong(26, o1Var.z);
            String str7 = o1Var.A;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str7);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<o1> {
        public String createQuery() {
            return "DELETE FROM `t_underline_local` WHERE `id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, o1 o1Var) {
            supportSQLiteStatement.bindLong(1, o1Var.a);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_underline_local WHERE book_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
