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
public final class j2 implements i2 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.p0> b;
    private final EntityDeletionOrUpdateAdapter<lr4.p0> c;
    private final EntityDeletionOrUpdateAdapter<lr4.p0> d;
    private final SharedSQLiteStatement e;
    private final SharedSQLiteStatement f;

    static {
        Covode.recordClassIndex(611724);
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // nr4.i2
    public List<lr4.p0> i() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM reader_bookmark_remote WHERE is_deleted = 1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mark_id");
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
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_deleted");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_media_index");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "end_media_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.p0 p0Var = new lr4.p0();
                    ArrayList arrayList2 = arrayList;
                    int i3 = columnIndexOrThrow13;
                    p0Var.a = query.getLong(columnIndexOrThrow);
                    p0Var.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        p0Var.c = null;
                    } else {
                        p0Var.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        p0Var.d = null;
                    } else {
                        p0Var.d = query.getString(columnIndexOrThrow4);
                    }
                    p0Var.e = query.getInt(columnIndexOrThrow5);
                    p0Var.f = query.getInt(columnIndexOrThrow6);
                    p0Var.g = query.getInt(columnIndexOrThrow7);
                    p0Var.h = query.getInt(columnIndexOrThrow8);
                    p0Var.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        p0Var.j = null;
                    } else {
                        p0Var.j = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        p0Var.k = null;
                    } else {
                        p0Var.k = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        p0Var.l = null;
                    } else {
                        p0Var.l = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(i3)) {
                        p0Var.m = null;
                    } else {
                        p0Var.m = query.getString(i3);
                    }
                    int i4 = i2;
                    if (query.getInt(i4) != 0) {
                        i = columnIndexOrThrow;
                        z = true;
                    } else {
                        i = columnIndexOrThrow;
                        z = false;
                    }
                    p0Var.n = z;
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow12;
                    p0Var.o = query.getInt(i5);
                    int i7 = columnIndexOrThrow16;
                    p0Var.p = query.getInt(i7);
                    int i8 = columnIndexOrThrow17;
                    p0Var.q = query.getInt(i8);
                    int i9 = columnIndexOrThrow18;
                    p0Var.r = query.getInt(i9);
                    int i10 = columnIndexOrThrow19;
                    p0Var.s = query.getInt(i10);
                    int i11 = columnIndexOrThrow20;
                    p0Var.t = query.getInt(i11);
                    int i12 = columnIndexOrThrow21;
                    p0Var.u = query.getInt(i12);
                    int i13 = columnIndexOrThrow22;
                    p0Var.v = query.getInt(i13);
                    int i14 = columnIndexOrThrow23;
                    p0Var.w = query.getInt(i14);
                    int i15 = columnIndexOrThrow24;
                    p0Var.x = query.getInt(i15);
                    int i16 = columnIndexOrThrow25;
                    p0Var.y = query.getLong(i16);
                    arrayList2.add(p0Var);
                    arrayList = arrayList2;
                    columnIndexOrThrow12 = i6;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow16 = i7;
                    columnIndexOrThrow17 = i8;
                    columnIndexOrThrow18 = i9;
                    columnIndexOrThrow19 = i10;
                    columnIndexOrThrow20 = i11;
                    columnIndexOrThrow21 = i12;
                    columnIndexOrThrow22 = i13;
                    columnIndexOrThrow23 = i14;
                    columnIndexOrThrow24 = i15;
                    columnIndexOrThrow25 = i16;
                    columnIndexOrThrow = i;
                    i2 = i4;
                    columnIndexOrThrow13 = i3;
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

    public j2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
    }

    @Override // nr4.i2
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

    @Override // nr4.i2
    public int b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM reader_bookmark_remote WHERE book_id = ? AND is_deleted = 0", 1);
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

    @Override // nr4.i2
    public void c(List<lr4.p0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.i2
    public void d(String str) {
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

    @Override // nr4.i2
    public List<Long> g(List<lr4.p0> list) {
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

    @Override // nr4.i2
    public void h(List<lr4.p0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.d.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.i2
    public List<lr4.p0> e(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM reader_bookmark_remote WHERE book_id = ? AND is_deleted = 0", 1);
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
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "end_paragraph_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_deleted");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_media_index");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "end_media_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.p0 p0Var = new lr4.p0();
                    int i3 = columnIndexOrThrow12;
                    int i4 = columnIndexOrThrow13;
                    p0Var.a = query.getLong(columnIndexOrThrow);
                    p0Var.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        p0Var.c = null;
                    } else {
                        p0Var.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        p0Var.d = null;
                    } else {
                        p0Var.d = query.getString(columnIndexOrThrow4);
                    }
                    p0Var.e = query.getInt(columnIndexOrThrow5);
                    p0Var.f = query.getInt(columnIndexOrThrow6);
                    p0Var.g = query.getInt(columnIndexOrThrow7);
                    p0Var.h = query.getInt(columnIndexOrThrow8);
                    p0Var.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        p0Var.j = null;
                    } else {
                        p0Var.j = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        p0Var.k = null;
                    } else {
                        p0Var.k = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(i3)) {
                        p0Var.l = null;
                    } else {
                        p0Var.l = query.getString(i3);
                    }
                    columnIndexOrThrow13 = i4;
                    if (query.isNull(columnIndexOrThrow13)) {
                        i = columnIndexOrThrow;
                        p0Var.m = null;
                    } else {
                        i = columnIndexOrThrow;
                        p0Var.m = query.getString(columnIndexOrThrow13);
                    }
                    int i5 = i2;
                    if (query.getInt(i5) != 0) {
                        i2 = i5;
                        z = true;
                    } else {
                        i2 = i5;
                        z = false;
                    }
                    p0Var.n = z;
                    int i6 = columnIndexOrThrow15;
                    int i7 = columnIndexOrThrow11;
                    p0Var.o = query.getInt(i6);
                    int i8 = columnIndexOrThrow16;
                    p0Var.p = query.getInt(i8);
                    int i9 = columnIndexOrThrow17;
                    p0Var.q = query.getInt(i9);
                    int i10 = columnIndexOrThrow18;
                    p0Var.r = query.getInt(i10);
                    int i11 = columnIndexOrThrow19;
                    p0Var.s = query.getInt(i11);
                    int i12 = columnIndexOrThrow20;
                    p0Var.t = query.getInt(i12);
                    int i13 = columnIndexOrThrow21;
                    p0Var.u = query.getInt(i13);
                    int i14 = columnIndexOrThrow22;
                    p0Var.v = query.getInt(i14);
                    int i15 = columnIndexOrThrow23;
                    p0Var.w = query.getInt(i15);
                    int i16 = columnIndexOrThrow24;
                    p0Var.x = query.getInt(i16);
                    int i17 = columnIndexOrThrow25;
                    p0Var.y = query.getLong(i17);
                    arrayList.add(p0Var);
                    columnIndexOrThrow11 = i7;
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow16 = i8;
                    columnIndexOrThrow17 = i9;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow19 = i11;
                    columnIndexOrThrow20 = i12;
                    columnIndexOrThrow21 = i13;
                    columnIndexOrThrow22 = i14;
                    columnIndexOrThrow23 = i15;
                    columnIndexOrThrow12 = i3;
                    columnIndexOrThrow24 = i16;
                    columnIndexOrThrow25 = i17;
                    columnIndexOrThrow = i;
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

    @Override // nr4.i2
    public List<lr4.p0> f(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM reader_bookmark_remote WHERE book_id = ? AND is_deleted = 1", 1);
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
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "end_paragraph_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "start_offset_in_para");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "end_offset_in_para");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "chapter_version");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_deleted");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_media_index");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "end_media_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "end_container_id");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "end_element_index");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "end_element_offset");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "start_order");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "end_order");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "modify_time");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.p0 p0Var = new lr4.p0();
                    int i3 = columnIndexOrThrow12;
                    int i4 = columnIndexOrThrow13;
                    p0Var.a = query.getLong(columnIndexOrThrow);
                    p0Var.b = query.getInt(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        p0Var.c = null;
                    } else {
                        p0Var.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        p0Var.d = null;
                    } else {
                        p0Var.d = query.getString(columnIndexOrThrow4);
                    }
                    p0Var.e = query.getInt(columnIndexOrThrow5);
                    p0Var.f = query.getInt(columnIndexOrThrow6);
                    p0Var.g = query.getInt(columnIndexOrThrow7);
                    p0Var.h = query.getInt(columnIndexOrThrow8);
                    p0Var.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        p0Var.j = null;
                    } else {
                        p0Var.j = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        p0Var.k = null;
                    } else {
                        p0Var.k = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(i3)) {
                        p0Var.l = null;
                    } else {
                        p0Var.l = query.getString(i3);
                    }
                    columnIndexOrThrow13 = i4;
                    if (query.isNull(columnIndexOrThrow13)) {
                        i = columnIndexOrThrow;
                        p0Var.m = null;
                    } else {
                        i = columnIndexOrThrow;
                        p0Var.m = query.getString(columnIndexOrThrow13);
                    }
                    int i5 = i2;
                    if (query.getInt(i5) != 0) {
                        i2 = i5;
                        z = true;
                    } else {
                        i2 = i5;
                        z = false;
                    }
                    p0Var.n = z;
                    int i6 = columnIndexOrThrow15;
                    int i7 = columnIndexOrThrow11;
                    p0Var.o = query.getInt(i6);
                    int i8 = columnIndexOrThrow16;
                    p0Var.p = query.getInt(i8);
                    int i9 = columnIndexOrThrow17;
                    p0Var.q = query.getInt(i9);
                    int i10 = columnIndexOrThrow18;
                    p0Var.r = query.getInt(i10);
                    int i11 = columnIndexOrThrow19;
                    p0Var.s = query.getInt(i11);
                    int i12 = columnIndexOrThrow20;
                    p0Var.t = query.getInt(i12);
                    int i13 = columnIndexOrThrow21;
                    p0Var.u = query.getInt(i13);
                    int i14 = columnIndexOrThrow22;
                    p0Var.v = query.getInt(i14);
                    int i15 = columnIndexOrThrow23;
                    p0Var.w = query.getInt(i15);
                    int i16 = columnIndexOrThrow24;
                    p0Var.x = query.getInt(i16);
                    int i17 = columnIndexOrThrow25;
                    p0Var.y = query.getLong(i17);
                    arrayList.add(p0Var);
                    columnIndexOrThrow11 = i7;
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow16 = i8;
                    columnIndexOrThrow17 = i9;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow19 = i11;
                    columnIndexOrThrow20 = i12;
                    columnIndexOrThrow21 = i13;
                    columnIndexOrThrow22 = i14;
                    columnIndexOrThrow23 = i15;
                    columnIndexOrThrow12 = i3;
                    columnIndexOrThrow24 = i16;
                    columnIndexOrThrow25 = i17;
                    columnIndexOrThrow = i;
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

    class a extends EntityInsertionAdapter<lr4.p0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `reader_bookmark_remote` (`mark_id`,`mark_type`,`book_id`,`chapter_id`,`chapter_index`,`paragraph_id`,`end_paragraph_id`,`start_offset_in_para`,`end_offset_in_para`,`chapter_version`,`content`,`chapter_title`,`volume_name`,`is_deleted`,`start_media_index`,`end_media_index`,`start_container_id`,`start_element_index`,`start_element_offset`,`end_container_id`,`end_element_index`,`end_element_offset`,`start_order`,`end_order`,`modify_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.p0 p0Var) {
            supportSQLiteStatement.bindLong(1, p0Var.a);
            supportSQLiteStatement.bindLong(2, p0Var.b);
            String str = p0Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = p0Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, p0Var.e);
            supportSQLiteStatement.bindLong(6, p0Var.f);
            supportSQLiteStatement.bindLong(7, p0Var.g);
            supportSQLiteStatement.bindLong(8, p0Var.h);
            supportSQLiteStatement.bindLong(9, p0Var.i);
            String str3 = p0Var.j;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str3);
            }
            String str4 = p0Var.k;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str4);
            }
            String str5 = p0Var.l;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            String str6 = p0Var.m;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str6);
            }
            supportSQLiteStatement.bindLong(14, p0Var.n ? 1L : 0L);
            supportSQLiteStatement.bindLong(15, p0Var.o);
            supportSQLiteStatement.bindLong(16, p0Var.p);
            supportSQLiteStatement.bindLong(17, p0Var.q);
            supportSQLiteStatement.bindLong(18, p0Var.r);
            supportSQLiteStatement.bindLong(19, p0Var.s);
            supportSQLiteStatement.bindLong(20, p0Var.t);
            supportSQLiteStatement.bindLong(21, p0Var.u);
            supportSQLiteStatement.bindLong(22, p0Var.v);
            supportSQLiteStatement.bindLong(23, p0Var.w);
            supportSQLiteStatement.bindLong(24, p0Var.x);
            supportSQLiteStatement.bindLong(25, p0Var.y);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.p0> {
        public String createQuery() {
            return "DELETE FROM `reader_bookmark_remote` WHERE `mark_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.p0 p0Var) {
            supportSQLiteStatement.bindLong(1, p0Var.a);
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<lr4.p0> {
        public String createQuery() {
            return "UPDATE OR ABORT `reader_bookmark_remote` SET `mark_id` = ?,`mark_type` = ?,`book_id` = ?,`chapter_id` = ?,`chapter_index` = ?,`paragraph_id` = ?,`end_paragraph_id` = ?,`start_offset_in_para` = ?,`end_offset_in_para` = ?,`chapter_version` = ?,`content` = ?,`chapter_title` = ?,`volume_name` = ?,`is_deleted` = ?,`start_media_index` = ?,`end_media_index` = ?,`start_container_id` = ?,`start_element_index` = ?,`start_element_offset` = ?,`end_container_id` = ?,`end_element_index` = ?,`end_element_offset` = ?,`start_order` = ?,`end_order` = ?,`modify_time` = ? WHERE `mark_id` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.p0 p0Var) {
            supportSQLiteStatement.bindLong(1, p0Var.a);
            supportSQLiteStatement.bindLong(2, p0Var.b);
            String str = p0Var.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = p0Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            supportSQLiteStatement.bindLong(5, p0Var.e);
            supportSQLiteStatement.bindLong(6, p0Var.f);
            supportSQLiteStatement.bindLong(7, p0Var.g);
            supportSQLiteStatement.bindLong(8, p0Var.h);
            supportSQLiteStatement.bindLong(9, p0Var.i);
            String str3 = p0Var.j;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str3);
            }
            String str4 = p0Var.k;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str4);
            }
            String str5 = p0Var.l;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            String str6 = p0Var.m;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str6);
            }
            supportSQLiteStatement.bindLong(14, p0Var.n ? 1L : 0L);
            supportSQLiteStatement.bindLong(15, p0Var.o);
            supportSQLiteStatement.bindLong(16, p0Var.p);
            supportSQLiteStatement.bindLong(17, p0Var.q);
            supportSQLiteStatement.bindLong(18, p0Var.r);
            supportSQLiteStatement.bindLong(19, p0Var.s);
            supportSQLiteStatement.bindLong(20, p0Var.t);
            supportSQLiteStatement.bindLong(21, p0Var.u);
            supportSQLiteStatement.bindLong(22, p0Var.v);
            supportSQLiteStatement.bindLong(23, p0Var.w);
            supportSQLiteStatement.bindLong(24, p0Var.x);
            supportSQLiteStatement.bindLong(25, p0Var.y);
            supportSQLiteStatement.bindLong(26, p0Var.a);
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM reader_bookmark_remote WHERE book_id = ? AND is_deleted = 0";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM reader_bookmark_remote WHERE book_id = ?";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
