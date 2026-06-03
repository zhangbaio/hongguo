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
import lr4.q1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o implements m {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<q1> b;
    private final EntityDeletionOrUpdateAdapter<q1> c;
    private final EntityDeletionOrUpdateAdapter<q1> d;
    private final SharedSQLiteStatement e;
    private final SharedSQLiteStatement f;

    static {
        Covode.recordClassIndex(611534);
    }

    public static List<Class<?>> l() {
        return Collections.emptyList();
    }

    @Override // com.dragon.read.local.db.m
    public List<q1> j() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        boolean z;
        int i2;
        boolean z2;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_underline_remote WHERE is_deleted = 1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mark_id");
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
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_deleted");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "line_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_public");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "hot_line_id");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "underline_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "notes");
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
                    if (query.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i10 = columnIndexOrThrow15;
                    int i11 = columnIndexOrThrow;
                    int i12 = query.getInt(i10);
                    int i13 = columnIndexOrThrow16;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow16 = i13;
                    int i15 = columnIndexOrThrow17;
                    int i16 = query.getInt(i15);
                    columnIndexOrThrow17 = i15;
                    int i17 = columnIndexOrThrow18;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow18 = i17;
                    int i19 = columnIndexOrThrow19;
                    int i20 = query.getInt(i19);
                    columnIndexOrThrow19 = i19;
                    int i21 = columnIndexOrThrow20;
                    int i22 = query.getInt(i21);
                    columnIndexOrThrow20 = i21;
                    int i23 = columnIndexOrThrow21;
                    int i24 = query.getInt(i23);
                    columnIndexOrThrow21 = i23;
                    int i25 = columnIndexOrThrow22;
                    int i26 = query.getInt(i25);
                    columnIndexOrThrow22 = i25;
                    int i27 = columnIndexOrThrow23;
                    long j2 = query.getLong(i27);
                    columnIndexOrThrow23 = i27;
                    int i28 = columnIndexOrThrow24;
                    int i29 = query.getInt(i28);
                    columnIndexOrThrow24 = i28;
                    int i30 = columnIndexOrThrow25;
                    if (query.getInt(i30) != 0) {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = true;
                    } else {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = false;
                    }
                    long j3 = query.getLong(i2);
                    columnIndexOrThrow26 = i2;
                    int i31 = columnIndexOrThrow27;
                    int i32 = query.getInt(i31);
                    columnIndexOrThrow27 = i31;
                    int i33 = columnIndexOrThrow28;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow28 = i33;
                        string7 = null;
                    } else {
                        string7 = query.getString(i33);
                        columnIndexOrThrow28 = i33;
                    }
                    arrayList.add(new q1(j, i4, string, string2, i5, i6, i7, i8, i9, string3, string4, string5, string6, z, i12, i14, i16, i18, i20, i22, i24, i26, j2, i29, z2, j3, i32, string7));
                    columnIndexOrThrow = i11;
                    columnIndexOrThrow15 = i10;
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

    @Override // com.dragon.read.local.db.m
    public List<q1> k() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        boolean z;
        int i2;
        boolean z2;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_underline_remote", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mark_id");
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
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_deleted");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "line_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_public");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "hot_line_id");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "underline_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "notes");
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
                    if (query.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i10 = columnIndexOrThrow15;
                    int i11 = columnIndexOrThrow;
                    int i12 = query.getInt(i10);
                    int i13 = columnIndexOrThrow16;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow16 = i13;
                    int i15 = columnIndexOrThrow17;
                    int i16 = query.getInt(i15);
                    columnIndexOrThrow17 = i15;
                    int i17 = columnIndexOrThrow18;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow18 = i17;
                    int i19 = columnIndexOrThrow19;
                    int i20 = query.getInt(i19);
                    columnIndexOrThrow19 = i19;
                    int i21 = columnIndexOrThrow20;
                    int i22 = query.getInt(i21);
                    columnIndexOrThrow20 = i21;
                    int i23 = columnIndexOrThrow21;
                    int i24 = query.getInt(i23);
                    columnIndexOrThrow21 = i23;
                    int i25 = columnIndexOrThrow22;
                    int i26 = query.getInt(i25);
                    columnIndexOrThrow22 = i25;
                    int i27 = columnIndexOrThrow23;
                    long j2 = query.getLong(i27);
                    columnIndexOrThrow23 = i27;
                    int i28 = columnIndexOrThrow24;
                    int i29 = query.getInt(i28);
                    columnIndexOrThrow24 = i28;
                    int i30 = columnIndexOrThrow25;
                    if (query.getInt(i30) != 0) {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = true;
                    } else {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = false;
                    }
                    long j3 = query.getLong(i2);
                    columnIndexOrThrow26 = i2;
                    int i31 = columnIndexOrThrow27;
                    int i32 = query.getInt(i31);
                    columnIndexOrThrow27 = i31;
                    int i33 = columnIndexOrThrow28;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow28 = i33;
                        string7 = null;
                    } else {
                        string7 = query.getString(i33);
                        columnIndexOrThrow28 = i33;
                    }
                    arrayList.add(new q1(j, i4, string, string2, i5, i6, i7, i8, i9, string3, string4, string5, string6, z, i12, i14, i16, i18, i20, i22, i24, i26, j2, i29, z2, j3, i32, string7));
                    columnIndexOrThrow = i11;
                    columnIndexOrThrow15 = i10;
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

    public o(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
    }

    @Override // com.dragon.read.local.db.m
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
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
            this.f.release(acquire);
        }
    }

    @Override // com.dragon.read.local.db.m
    public int b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_underline_remote WHERE book_id =? AND is_deleted = 0 AND underline_type=1", 1);
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

    @Override // com.dragon.read.local.db.m
    public void c(List<q1> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.dragon.read.local.db.m
    public int d(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_underline_remote WHERE book_id =? AND is_deleted = 0 AND underline_type=0", 1);
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

    @Override // com.dragon.read.local.db.m
    public List<Long> e(List<q1> list) {
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

    @Override // com.dragon.read.local.db.m
    public void f(List<q1> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.d.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.dragon.read.local.db.m
    public void g(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
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
            this.e.release(acquire);
        }
    }

    @Override // com.dragon.read.local.db.m
    public List<q1> h(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        boolean z;
        int i2;
        boolean z2;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_underline_remote WHERE book_id = ? AND is_deleted = 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mark_id");
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
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_deleted");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "line_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_public");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "hot_line_id");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "underline_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "notes");
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
                    if (query.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i10 = columnIndexOrThrow15;
                    int i11 = columnIndexOrThrow;
                    int i12 = query.getInt(i10);
                    int i13 = columnIndexOrThrow16;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow16 = i13;
                    int i15 = columnIndexOrThrow17;
                    int i16 = query.getInt(i15);
                    columnIndexOrThrow17 = i15;
                    int i17 = columnIndexOrThrow18;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow18 = i17;
                    int i19 = columnIndexOrThrow19;
                    int i20 = query.getInt(i19);
                    columnIndexOrThrow19 = i19;
                    int i21 = columnIndexOrThrow20;
                    int i22 = query.getInt(i21);
                    columnIndexOrThrow20 = i21;
                    int i23 = columnIndexOrThrow21;
                    int i24 = query.getInt(i23);
                    columnIndexOrThrow21 = i23;
                    int i25 = columnIndexOrThrow22;
                    int i26 = query.getInt(i25);
                    columnIndexOrThrow22 = i25;
                    int i27 = columnIndexOrThrow23;
                    long j2 = query.getLong(i27);
                    columnIndexOrThrow23 = i27;
                    int i28 = columnIndexOrThrow24;
                    int i29 = query.getInt(i28);
                    columnIndexOrThrow24 = i28;
                    int i30 = columnIndexOrThrow25;
                    if (query.getInt(i30) != 0) {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = true;
                    } else {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = false;
                    }
                    long j3 = query.getLong(i2);
                    columnIndexOrThrow26 = i2;
                    int i31 = columnIndexOrThrow27;
                    int i32 = query.getInt(i31);
                    columnIndexOrThrow27 = i31;
                    int i33 = columnIndexOrThrow28;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow28 = i33;
                        string7 = null;
                    } else {
                        string7 = query.getString(i33);
                        columnIndexOrThrow28 = i33;
                    }
                    arrayList.add(new q1(j, i4, string, string2, i5, i6, i7, i8, i9, string3, string4, string5, string6, z, i12, i14, i16, i18, i20, i22, i24, i26, j2, i29, z2, j3, i32, string7));
                    columnIndexOrThrow = i11;
                    columnIndexOrThrow15 = i10;
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

    @Override // com.dragon.read.local.db.m
    public List<q1> i(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        boolean z;
        int i2;
        boolean z2;
        String string7;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_underline_remote WHERE book_id = ? AND is_deleted = 0", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mark_id");
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
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_deleted");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "line_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_public");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "hot_line_id");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "underline_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "notes");
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
                    if (query.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i10 = columnIndexOrThrow15;
                    int i11 = columnIndexOrThrow;
                    int i12 = query.getInt(i10);
                    int i13 = columnIndexOrThrow16;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow16 = i13;
                    int i15 = columnIndexOrThrow17;
                    int i16 = query.getInt(i15);
                    columnIndexOrThrow17 = i15;
                    int i17 = columnIndexOrThrow18;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow18 = i17;
                    int i19 = columnIndexOrThrow19;
                    int i20 = query.getInt(i19);
                    columnIndexOrThrow19 = i19;
                    int i21 = columnIndexOrThrow20;
                    int i22 = query.getInt(i21);
                    columnIndexOrThrow20 = i21;
                    int i23 = columnIndexOrThrow21;
                    int i24 = query.getInt(i23);
                    columnIndexOrThrow21 = i23;
                    int i25 = columnIndexOrThrow22;
                    int i26 = query.getInt(i25);
                    columnIndexOrThrow22 = i25;
                    int i27 = columnIndexOrThrow23;
                    long j2 = query.getLong(i27);
                    columnIndexOrThrow23 = i27;
                    int i28 = columnIndexOrThrow24;
                    int i29 = query.getInt(i28);
                    columnIndexOrThrow24 = i28;
                    int i30 = columnIndexOrThrow25;
                    if (query.getInt(i30) != 0) {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = true;
                    } else {
                        columnIndexOrThrow25 = i30;
                        i2 = columnIndexOrThrow26;
                        z2 = false;
                    }
                    long j3 = query.getLong(i2);
                    columnIndexOrThrow26 = i2;
                    int i31 = columnIndexOrThrow27;
                    int i32 = query.getInt(i31);
                    columnIndexOrThrow27 = i31;
                    int i33 = columnIndexOrThrow28;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow28 = i33;
                        string7 = null;
                    } else {
                        string7 = query.getString(i33);
                        columnIndexOrThrow28 = i33;
                    }
                    arrayList.add(new q1(j, i4, string, string2, i5, i6, i7, i8, i9, string3, string4, string5, string6, z, i12, i14, i16, i18, i20, i22, i24, i26, j2, i29, z2, j3, i32, string7));
                    columnIndexOrThrow = i11;
                    columnIndexOrThrow15 = i10;
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

    class a extends EntityInsertionAdapter<q1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_underline_remote` (`mark_id`,`mark_type`,`book_id`,`chapter_id`,`chapter_index`,`start_para_id`,`start_offset_in_para`,`end_para_id`,`end_offset_in_para`,`chapter_version`,`content`,`chapter_title`,`volume_name`,`is_deleted`,`start_container_id`,`start_element_index`,`start_element_offset`,`end_container_id`,`end_element_index`,`end_element_offset`,`start_order`,`end_order`,`modify_time`,`line_type`,`is_public`,`hot_line_id`,`underline_type`,`notes`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, q1 q1Var) {
            supportSQLiteStatement.bindLong(1, q1Var.a);
            supportSQLiteStatement.bindLong(2, q1Var.b);
            String str = q1Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = q1Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, q1Var.e);
            supportSQLiteStatement.bindLong(6, q1Var.f);
            supportSQLiteStatement.bindLong(7, q1Var.g);
            supportSQLiteStatement.bindLong(8, q1Var.h);
            supportSQLiteStatement.bindLong(9, q1Var.i);
            String str3 = q1Var.j;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str3);
            }
            String str4 = q1Var.k;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str4);
            }
            String str5 = q1Var.l;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            String str6 = q1Var.m;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str6);
            }
            supportSQLiteStatement.bindLong(14, q1Var.n ? 1L : 0L);
            supportSQLiteStatement.bindLong(15, q1Var.o);
            supportSQLiteStatement.bindLong(16, q1Var.p);
            supportSQLiteStatement.bindLong(17, q1Var.q);
            supportSQLiteStatement.bindLong(18, q1Var.r);
            supportSQLiteStatement.bindLong(19, q1Var.s);
            supportSQLiteStatement.bindLong(20, q1Var.t);
            supportSQLiteStatement.bindLong(21, q1Var.u);
            supportSQLiteStatement.bindLong(22, q1Var.v);
            supportSQLiteStatement.bindLong(23, q1Var.w);
            supportSQLiteStatement.bindLong(24, q1Var.x);
            supportSQLiteStatement.bindLong(25, q1Var.y ? 1L : 0L);
            supportSQLiteStatement.bindLong(26, q1Var.z);
            supportSQLiteStatement.bindLong(27, q1Var.A);
            String str7 = q1Var.B;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str7);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<q1> {
        public String createQuery() {
            return "DELETE FROM `t_underline_remote` WHERE `mark_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, q1 q1Var) {
            supportSQLiteStatement.bindLong(1, q1Var.a);
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<q1> {
        public String createQuery() {
            return "UPDATE OR ABORT `t_underline_remote` SET `mark_id` = ?,`mark_type` = ?,`book_id` = ?,`chapter_id` = ?,`chapter_index` = ?,`start_para_id` = ?,`start_offset_in_para` = ?,`end_para_id` = ?,`end_offset_in_para` = ?,`chapter_version` = ?,`content` = ?,`chapter_title` = ?,`volume_name` = ?,`is_deleted` = ?,`start_container_id` = ?,`start_element_index` = ?,`start_element_offset` = ?,`end_container_id` = ?,`end_element_index` = ?,`end_element_offset` = ?,`start_order` = ?,`end_order` = ?,`modify_time` = ?,`line_type` = ?,`is_public` = ?,`hot_line_id` = ?,`underline_type` = ?,`notes` = ? WHERE `mark_id` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, q1 q1Var) {
            supportSQLiteStatement.bindLong(1, q1Var.a);
            supportSQLiteStatement.bindLong(2, q1Var.b);
            String str = q1Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = q1Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, q1Var.e);
            supportSQLiteStatement.bindLong(6, q1Var.f);
            supportSQLiteStatement.bindLong(7, q1Var.g);
            supportSQLiteStatement.bindLong(8, q1Var.h);
            supportSQLiteStatement.bindLong(9, q1Var.i);
            String str3 = q1Var.j;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str3);
            }
            String str4 = q1Var.k;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str4);
            }
            String str5 = q1Var.l;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            String str6 = q1Var.m;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str6);
            }
            supportSQLiteStatement.bindLong(14, q1Var.n ? 1L : 0L);
            supportSQLiteStatement.bindLong(15, q1Var.o);
            supportSQLiteStatement.bindLong(16, q1Var.p);
            supportSQLiteStatement.bindLong(17, q1Var.q);
            supportSQLiteStatement.bindLong(18, q1Var.r);
            supportSQLiteStatement.bindLong(19, q1Var.s);
            supportSQLiteStatement.bindLong(20, q1Var.t);
            supportSQLiteStatement.bindLong(21, q1Var.u);
            supportSQLiteStatement.bindLong(22, q1Var.v);
            supportSQLiteStatement.bindLong(23, q1Var.w);
            supportSQLiteStatement.bindLong(24, q1Var.x);
            supportSQLiteStatement.bindLong(25, q1Var.y ? 1L : 0L);
            supportSQLiteStatement.bindLong(26, q1Var.z);
            supportSQLiteStatement.bindLong(27, q1Var.A);
            String str7 = q1Var.B;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str7);
            }
            supportSQLiteStatement.bindLong(29, q1Var.a);
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_underline_remote WHERE book_id = ? AND is_deleted = 0";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_underline_remote WHERE book_id = ?";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
