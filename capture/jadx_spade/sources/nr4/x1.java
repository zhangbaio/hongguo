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
import com.dragon.read.pages.bookshelf.model.BookType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lr4.d0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x1 implements v1 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.d0> b;
    private final EntityDeletionOrUpdateAdapter<lr4.d0> c;
    private final EntityDeletionOrUpdateAdapter<d0.a> d;

    static {
        Covode.recordClassIndex(611709);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // nr4.v1
    public int e() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM t_local_book", 0);
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

    @Override // nr4.v1
    public List<lr4.d0> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i;
        boolean z;
        int i2;
        String string7;
        String string8;
        boolean z2;
        boolean z3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_local_book", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "bookshelf_update_time");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "file_path");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_page_index");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "progress_update_time");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_external");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mime_type");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.d0 d0Var = new lr4.d0();
                    ArrayList arrayList2 = arrayList;
                    int i4 = columnIndexOrThrow13;
                    d0Var.a = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    d0Var.b = string;
                    if (query.isNull(columnIndexOrThrow3)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow3));
                    }
                    d0Var.c = kr4.b.b(valueOf);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow4);
                    }
                    d0Var.d = string2;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    d0Var.e = string3;
                    if (query.isNull(columnIndexOrThrow6)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow6);
                    }
                    d0Var.f = string4;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow7);
                    }
                    d0Var.g = string5;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow8);
                    }
                    d0Var.h = string6;
                    d0Var.i = query.getInt(columnIndexOrThrow9);
                    d0Var.j = query.getFloat(columnIndexOrThrow10);
                    d0Var.k = query.getLong(columnIndexOrThrow11);
                    d0Var.l = query.getInt(columnIndexOrThrow12);
                    d0Var.m = query.getInt(i4);
                    int i5 = i3;
                    if (query.getInt(i5) != 0) {
                        i = columnIndexOrThrow;
                        z = true;
                    } else {
                        i = columnIndexOrThrow;
                        z = false;
                    }
                    d0Var.n = z;
                    int i6 = columnIndexOrThrow15;
                    if (query.isNull(i6)) {
                        i2 = i6;
                        string7 = null;
                    } else {
                        i2 = i6;
                        string7 = query.getString(i6);
                    }
                    d0Var.o = string7;
                    int i7 = columnIndexOrThrow16;
                    if (query.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string8 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string8 = query.getString(i7);
                    }
                    d0Var.p = string8;
                    int i8 = columnIndexOrThrow12;
                    int i9 = columnIndexOrThrow17;
                    d0Var.q = query.getInt(i9);
                    int i10 = columnIndexOrThrow18;
                    if (query.getInt(i10) != 0) {
                        columnIndexOrThrow17 = i9;
                        z2 = true;
                    } else {
                        columnIndexOrThrow17 = i9;
                        z2 = false;
                    }
                    d0Var.r = z2;
                    int i11 = columnIndexOrThrow19;
                    d0Var.s = query.getLong(i11);
                    int i12 = columnIndexOrThrow20;
                    if (query.getInt(i12) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    d0Var.t = z3;
                    arrayList = arrayList2;
                    arrayList.add(d0Var);
                    columnIndexOrThrow20 = i12;
                    columnIndexOrThrow12 = i8;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow19 = i11;
                    columnIndexOrThrow = i;
                    i3 = i5;
                    columnIndexOrThrow13 = i4;
                    columnIndexOrThrow18 = i10;
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

    public x1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // nr4.v1
    public int b(d0.a aVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handle = this.d.handle(aVar) + 0;
            this.a.setTransactionSuccessful();
            return handle;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v1
    public Long[] d(lr4.d0... d0VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(d0VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v1
    public int delete(lr4.d0... d0VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.c.handleMultiple(d0VarArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v1
    public List<lr4.d0> c(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z;
        int i;
        String string7;
        String string8;
        boolean z2;
        boolean z3;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_local_book WHERE book_id IN (");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "bookshelf_update_time");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "file_path");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_page_index");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "progress_update_time");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_external");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mime_type");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.d0 d0Var = new lr4.d0();
                    int i4 = columnIndexOrThrow12;
                    int i5 = columnIndexOrThrow13;
                    d0Var.a = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    d0Var.b = string;
                    if (query.isNull(columnIndexOrThrow3)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow3));
                    }
                    d0Var.c = kr4.b.b(valueOf);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow4);
                    }
                    d0Var.d = string2;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    d0Var.e = string3;
                    if (query.isNull(columnIndexOrThrow6)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow6);
                    }
                    d0Var.f = string4;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow7);
                    }
                    d0Var.g = string5;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow8);
                    }
                    d0Var.h = string6;
                    d0Var.i = query.getInt(columnIndexOrThrow9);
                    d0Var.j = query.getFloat(columnIndexOrThrow10);
                    d0Var.k = query.getLong(columnIndexOrThrow11);
                    d0Var.l = query.getInt(i4);
                    int i6 = columnIndexOrThrow;
                    columnIndexOrThrow13 = i5;
                    d0Var.m = query.getInt(columnIndexOrThrow13);
                    int i7 = i3;
                    if (query.getInt(i7) != 0) {
                        i3 = i7;
                        z = true;
                    } else {
                        i3 = i7;
                        z = false;
                    }
                    d0Var.n = z;
                    int i8 = columnIndexOrThrow15;
                    if (query.isNull(i8)) {
                        i = i8;
                        string7 = null;
                    } else {
                        i = i8;
                        string7 = query.getString(i8);
                    }
                    d0Var.o = string7;
                    int i9 = columnIndexOrThrow16;
                    if (query.isNull(i9)) {
                        columnIndexOrThrow16 = i9;
                        string8 = null;
                    } else {
                        columnIndexOrThrow16 = i9;
                        string8 = query.getString(i9);
                    }
                    d0Var.p = string8;
                    int i10 = columnIndexOrThrow11;
                    int i11 = columnIndexOrThrow17;
                    d0Var.q = query.getInt(i11);
                    int i12 = columnIndexOrThrow18;
                    if (query.getInt(i12) != 0) {
                        columnIndexOrThrow17 = i11;
                        z2 = true;
                    } else {
                        columnIndexOrThrow17 = i11;
                        z2 = false;
                    }
                    d0Var.r = z2;
                    int i13 = columnIndexOrThrow19;
                    d0Var.s = query.getLong(i13);
                    int i14 = columnIndexOrThrow20;
                    if (query.getInt(i14) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    d0Var.t = z3;
                    arrayList.add(d0Var);
                    columnIndexOrThrow20 = i14;
                    columnIndexOrThrow11 = i10;
                    columnIndexOrThrow12 = i4;
                    columnIndexOrThrow18 = i12;
                    columnIndexOrThrow15 = i;
                    columnIndexOrThrow19 = i13;
                    columnIndexOrThrow = i6;
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

    class a extends EntityInsertionAdapter<lr4.d0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_local_book` (`bookshelf_update_time`,`book_id`,`book_type`,`cover_url`,`book_name`,`file_path`,`last_chapter_id`,`last_chapter_title`,`last_page_index`,`progress_rate`,`progress_update_time`,`paragraph_id`,`line_in_paragraph_offset`,`is_external`,`booklist_name`,`mime_type`,`version`,`is_pinned`,`pinned_time`,`is_asterisked`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.d0 d0Var) {
            supportSQLiteStatement.bindLong(1, d0Var.a);
            String str = d0Var.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            if (kr4.b.a(d0Var.c) == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindLong(3, r0.intValue());
            }
            String str2 = d0Var.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            String str3 = d0Var.e;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str3);
            }
            String str4 = d0Var.f;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str4);
            }
            String str5 = d0Var.g;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str5);
            }
            String str6 = d0Var.h;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str6);
            }
            supportSQLiteStatement.bindLong(9, d0Var.i);
            supportSQLiteStatement.bindDouble(10, d0Var.j);
            supportSQLiteStatement.bindLong(11, d0Var.k);
            supportSQLiteStatement.bindLong(12, d0Var.l);
            supportSQLiteStatement.bindLong(13, d0Var.m);
            supportSQLiteStatement.bindLong(14, d0Var.n ? 1L : 0L);
            String str7 = d0Var.o;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str7);
            }
            String str8 = d0Var.p;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str8);
            }
            supportSQLiteStatement.bindLong(17, d0Var.q);
            supportSQLiteStatement.bindLong(18, d0Var.r ? 1L : 0L);
            supportSQLiteStatement.bindLong(19, d0Var.s);
            supportSQLiteStatement.bindLong(20, d0Var.t ? 1L : 0L);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.d0> {
        public String createQuery() {
            return "DELETE FROM `t_local_book` WHERE `book_id` = ? AND `book_type` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.d0 d0Var) {
            String str = d0Var.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(d0Var.c) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r5.intValue());
            }
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<d0.a> {
        public String createQuery() {
            return "UPDATE OR ABORT `t_local_book` SET `book_id` = ?,`book_type` = ?,`book_name` = ?,`cover_url` = ? WHERE `book_id` = ? AND `book_type` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, d0.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(aVar.b) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r0.intValue());
            }
            String str2 = aVar.c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = aVar.d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = aVar.a;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            if (kr4.b.a(aVar.b) == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, r6.intValue());
            }
        }
    }

    @Override // nr4.v1
    public lr4.d0 f(String str, BookType bookType) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.d0 d0Var;
        String string;
        Integer valueOf;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z;
        String string7;
        String string8;
        boolean z2;
        boolean z3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_local_book WHERE book_id = ? AND book_type = ?", 2);
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "bookshelf_update_time");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "file_path");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_page_index");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "progress_update_time");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_external");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mime_type");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
                if (query.moveToFirst()) {
                    lr4.d0 d0Var2 = new lr4.d0();
                    d0Var2.a = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    d0Var2.b = string;
                    if (query.isNull(columnIndexOrThrow3)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow3));
                    }
                    d0Var2.c = kr4.b.b(valueOf);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow4);
                    }
                    d0Var2.d = string2;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    d0Var2.e = string3;
                    if (query.isNull(columnIndexOrThrow6)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow6);
                    }
                    d0Var2.f = string4;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow7);
                    }
                    d0Var2.g = string5;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow8);
                    }
                    d0Var2.h = string6;
                    d0Var2.i = query.getInt(columnIndexOrThrow9);
                    d0Var2.j = query.getFloat(columnIndexOrThrow10);
                    d0Var2.k = query.getLong(columnIndexOrThrow11);
                    d0Var2.l = query.getInt(columnIndexOrThrow12);
                    d0Var2.m = query.getInt(columnIndexOrThrow13);
                    if (query.getInt(columnIndexOrThrow14) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    d0Var2.n = z;
                    if (query.isNull(columnIndexOrThrow15)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow15);
                    }
                    d0Var2.o = string7;
                    if (query.isNull(columnIndexOrThrow16)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow16);
                    }
                    d0Var2.p = string8;
                    d0Var2.q = query.getInt(columnIndexOrThrow17);
                    if (query.getInt(columnIndexOrThrow18) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    d0Var2.r = z2;
                    d0Var2.s = query.getLong(columnIndexOrThrow19);
                    if (query.getInt(columnIndexOrThrow20) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    d0Var2.t = z3;
                    d0Var = d0Var2;
                } else {
                    d0Var = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return d0Var;
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
}
