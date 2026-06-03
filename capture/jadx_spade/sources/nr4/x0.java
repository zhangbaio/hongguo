package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x0 implements v0 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.v> b;
    private final EntityInsertionAdapter<lr4.s> c;
    private final EntityInsertionAdapter<lr4.z> d;
    private final SharedSQLiteStatement e;
    private final SharedSQLiteStatement f;
    private final SharedSQLiteStatement g;

    static {
        Covode.recordClassIndex(611682);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // nr4.v0
    public List<lr4.v> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        int i2;
        String string14;
        int i3;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_comic_detail_info", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horizontal_cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "vertical_cover_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "author");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "abstraction");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "read_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "score");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "creation_status");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "authorize_type");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "first_chapter_id");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "category_scheme");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "content_chapter_count");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "book_content_length");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "horizontal_cover_path");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "vertical_cover_path");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "directory_sub_info");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "last_download_success_time");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.v vVar = new lr4.v();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    vVar.d(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    vVar.e(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    vVar.c = string3;
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    vVar.d = string4;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    vVar.e = string5;
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    vVar.f = string6;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    vVar.g = string7;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    vVar.h = string8;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow9);
                    }
                    vVar.i = string9;
                    if (query.isNull(columnIndexOrThrow10)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow10);
                    }
                    vVar.j = string10;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow11);
                    }
                    vVar.k = string11;
                    if (query.isNull(columnIndexOrThrow12)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow12);
                    }
                    vVar.l = string12;
                    if (query.isNull(columnIndexOrThrow13)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(columnIndexOrThrow13);
                    }
                    vVar.m = string13;
                    int i5 = i4;
                    if (query.isNull(i5)) {
                        i2 = i5;
                        string14 = null;
                    } else {
                        i2 = i5;
                        string14 = query.getString(i5);
                    }
                    vVar.n = string14;
                    int i6 = columnIndexOrThrow15;
                    if (query.isNull(i6)) {
                        i3 = i6;
                        string15 = null;
                    } else {
                        i3 = i6;
                        string15 = query.getString(i6);
                    }
                    vVar.o = string15;
                    int i7 = columnIndexOrThrow16;
                    if (query.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string16 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string16 = query.getString(i7);
                    }
                    vVar.p = string16;
                    int i8 = columnIndexOrThrow17;
                    if (query.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string17 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string17 = query.getString(i8);
                    }
                    vVar.q = string17;
                    int i9 = columnIndexOrThrow18;
                    if (query.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string18 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string18 = query.getString(i9);
                    }
                    vVar.r = string18;
                    int i10 = columnIndexOrThrow19;
                    if (query.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string19 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string19 = query.getString(i10);
                    }
                    vVar.s = string19;
                    int i11 = columnIndexOrThrow20;
                    if (query.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string20 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string20 = query.getString(i11);
                    }
                    vVar.t = string20;
                    int i12 = columnIndexOrThrow13;
                    int i13 = columnIndexOrThrow21;
                    vVar.u = query.getInt(i13);
                    columnIndexOrThrow21 = i13;
                    int i14 = columnIndexOrThrow22;
                    vVar.v = query.getInt(i14);
                    int i15 = columnIndexOrThrow23;
                    if (query.isNull(i15)) {
                        columnIndexOrThrow23 = i15;
                        string21 = null;
                    } else {
                        columnIndexOrThrow23 = i15;
                        string21 = query.getString(i15);
                    }
                    vVar.f(string21);
                    int i16 = columnIndexOrThrow24;
                    if (query.isNull(i16)) {
                        columnIndexOrThrow24 = i16;
                        string22 = null;
                    } else {
                        columnIndexOrThrow24 = i16;
                        string22 = query.getString(i16);
                    }
                    vVar.h(string22);
                    int i17 = columnIndexOrThrow25;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow25 = i17;
                        string23 = null;
                    } else {
                        columnIndexOrThrow25 = i17;
                        string23 = query.getString(i17);
                    }
                    vVar.j(string23);
                    int i18 = columnIndexOrThrow26;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow26 = i18;
                        string24 = null;
                    } else {
                        columnIndexOrThrow26 = i18;
                        string24 = query.getString(i18);
                    }
                    vVar.g(string24);
                    int i19 = columnIndexOrThrow27;
                    if (query.isNull(i19)) {
                        columnIndexOrThrow27 = i19;
                        string25 = null;
                    } else {
                        columnIndexOrThrow27 = i19;
                        string25 = query.getString(i19);
                    }
                    vVar.A = string25;
                    int i20 = columnIndexOrThrow28;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow28 = i20;
                        string26 = null;
                    } else {
                        columnIndexOrThrow28 = i20;
                        string26 = query.getString(i20);
                    }
                    vVar.i(string26);
                    arrayList.add(vVar);
                    columnIndexOrThrow22 = i14;
                    columnIndexOrThrow13 = i12;
                    columnIndexOrThrow15 = i3;
                    i4 = i2;
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

    @Override // nr4.v0
    public List<lr4.s> z() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        int i2;
        String string11;
        int i3;
        String string12;
        String string13;
        String string14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_comic_download_chapter_info WHERE download_status IN (1,2,4) ORDER BY download_start_time ASC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "publish_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "key_version");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content_md5");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_order");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "book_chapter_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "first_pass_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "content_key");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "download_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "download_task_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "content_length");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "download_start_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "compress_status");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "download_progress");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "download_chapter_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "thumb_abs_path");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "catalog_abandon");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.s sVar = new lr4.s();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    sVar.f(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    sVar.h(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    sVar.j(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    sVar.q(string4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    sVar.i(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    sVar.g(string6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    sVar.s(string7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    sVar.k(string8);
                    sVar.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    sVar.n(string9);
                    sVar.k = query.getInt(columnIndexOrThrow11);
                    sVar.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow13);
                    }
                    sVar.p(string10);
                    int i5 = i4;
                    if (query.isNull(i5)) {
                        i2 = i5;
                        string11 = null;
                    } else {
                        i2 = i5;
                        string11 = query.getString(i5);
                    }
                    sVar.t(string11);
                    int i6 = columnIndexOrThrow15;
                    if (query.isNull(i6)) {
                        i3 = i6;
                        string12 = null;
                    } else {
                        i3 = i6;
                        string12 = query.getString(i6);
                    }
                    sVar.m(string12);
                    int i7 = columnIndexOrThrow13;
                    int i8 = columnIndexOrThrow16;
                    sVar.p = query.getInt(i8);
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    sVar.q = query.getInt(i9);
                    columnIndexOrThrow17 = i9;
                    int i10 = columnIndexOrThrow18;
                    sVar.r = query.getInt(i10);
                    int i11 = columnIndexOrThrow2;
                    int i12 = columnIndexOrThrow19;
                    int i13 = columnIndexOrThrow3;
                    sVar.s = query.getLong(i12);
                    int i14 = columnIndexOrThrow20;
                    sVar.t = query.getInt(i14);
                    int i15 = columnIndexOrThrow21;
                    sVar.u = query.getInt(i15);
                    int i16 = columnIndexOrThrow22;
                    if (query.isNull(i16)) {
                        columnIndexOrThrow22 = i16;
                        string13 = null;
                    } else {
                        columnIndexOrThrow22 = i16;
                        string13 = query.getString(i16);
                    }
                    sVar.o(string13);
                    int i17 = columnIndexOrThrow23;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow23 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow23 = i17;
                        string14 = query.getString(i17);
                    }
                    sVar.r(string14);
                    int i18 = columnIndexOrThrow24;
                    sVar.x = query.getInt(i18);
                    columnIndexOrThrow24 = i18;
                    int i19 = columnIndexOrThrow25;
                    sVar.y = query.getInt(i19);
                    arrayList.add(sVar);
                    columnIndexOrThrow25 = i19;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow15 = i3;
                    i4 = i2;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow20 = i14;
                    columnIndexOrThrow2 = i11;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow21 = i15;
                    columnIndexOrThrow3 = i13;
                    columnIndexOrThrow19 = i12;
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

    public x0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
        this.g = new f(roomDatabase);
    }

    @Override // nr4.v0
    public void i(List<lr4.z> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.d.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void o(List<lr4.s> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void r(lr4.v vVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(vVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void a(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM t_comic_detail_info WHERE book_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void g(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM t_comic_download_chapter_info WHERE book_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void w(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM t_comic_download_item_info WHERE  chapter_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void y(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM t_comic_download_item_info WHERE  book_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public List<lr4.z> j(List<String> list) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_comic_download_item_info WHERE chapter_id IN (");
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
        String str2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "md5");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "abs_save_path");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "download_create_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "content_order");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "download_status");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "download_task_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "download_sdk_task_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content_length");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.z zVar = new lr4.z();
                if (!query.isNull(columnIndexOrThrow)) {
                    str2 = query.getString(columnIndexOrThrow);
                }
                zVar.c(str2);
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                zVar.b(string);
                if (query.isNull(columnIndexOrThrow3)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                zVar.f(string2);
                if (query.isNull(columnIndexOrThrow4)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow4);
                }
                zVar.a(string3);
                zVar.e = query.getInt(columnIndexOrThrow5);
                zVar.f = query.getInt(columnIndexOrThrow6);
                zVar.g = query.getInt(columnIndexOrThrow7);
                zVar.h = query.getInt(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow9);
                }
                zVar.e(string4);
                if (query.isNull(columnIndexOrThrow10)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow10);
                }
                zVar.d(string5);
                arrayList.add(zVar);
                str2 = null;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.v0
    public List<lr4.s> m(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        int i2;
        String string11;
        int i3;
        String string12;
        String string13;
        String string14;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_comic_download_chapter_info WHERE chapter_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i4 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str);
            }
            i4++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "publish_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "key_version");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content_md5");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_order");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "book_chapter_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "first_pass_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "content_key");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "download_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "download_task_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "content_length");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "download_start_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "compress_status");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "download_progress");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "download_chapter_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "thumb_abs_path");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "catalog_abandon");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                int i5 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.s sVar = new lr4.s();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    sVar.f(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    sVar.h(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    sVar.j(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    sVar.q(string4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    sVar.i(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    sVar.g(string6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    sVar.s(string7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    sVar.k(string8);
                    sVar.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    sVar.n(string9);
                    sVar.k = query.getInt(columnIndexOrThrow11);
                    sVar.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow13);
                    }
                    sVar.p(string10);
                    int i6 = i5;
                    if (query.isNull(i6)) {
                        i2 = i6;
                        string11 = null;
                    } else {
                        i2 = i6;
                        string11 = query.getString(i6);
                    }
                    sVar.t(string11);
                    int i7 = columnIndexOrThrow15;
                    if (query.isNull(i7)) {
                        i3 = i7;
                        string12 = null;
                    } else {
                        i3 = i7;
                        string12 = query.getString(i7);
                    }
                    sVar.m(string12);
                    int i8 = columnIndexOrThrow13;
                    int i9 = columnIndexOrThrow16;
                    sVar.p = query.getInt(i9);
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    sVar.q = query.getInt(i10);
                    columnIndexOrThrow17 = i10;
                    int i11 = columnIndexOrThrow18;
                    sVar.r = query.getInt(i11);
                    int i12 = columnIndexOrThrow2;
                    int i13 = columnIndexOrThrow19;
                    int i14 = columnIndexOrThrow3;
                    sVar.s = query.getLong(i13);
                    int i15 = columnIndexOrThrow20;
                    sVar.t = query.getInt(i15);
                    int i16 = columnIndexOrThrow21;
                    sVar.u = query.getInt(i16);
                    int i17 = columnIndexOrThrow22;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow22 = i17;
                        string13 = null;
                    } else {
                        columnIndexOrThrow22 = i17;
                        string13 = query.getString(i17);
                    }
                    sVar.o(string13);
                    int i18 = columnIndexOrThrow23;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow23 = i18;
                        string14 = null;
                    } else {
                        columnIndexOrThrow23 = i18;
                        string14 = query.getString(i18);
                    }
                    sVar.r(string14);
                    int i19 = columnIndexOrThrow24;
                    sVar.x = query.getInt(i19);
                    columnIndexOrThrow24 = i19;
                    int i20 = columnIndexOrThrow25;
                    sVar.y = query.getInt(i20);
                    arrayList.add(sVar);
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow15 = i3;
                    i5 = i2;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow2 = i12;
                    columnIndexOrThrow18 = i11;
                    columnIndexOrThrow21 = i16;
                    columnIndexOrThrow3 = i14;
                    columnIndexOrThrow19 = i13;
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

    @Override // nr4.v0
    public List<lr4.v> n(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        int i2;
        String string14;
        int i3;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_comic_detail_info WHERE book_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i4 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str);
            }
            i4++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horizontal_cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "vertical_cover_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "author");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "abstraction");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "read_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "score");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "creation_status");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "authorize_type");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "first_chapter_id");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "category_scheme");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "content_chapter_count");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "book_content_length");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "horizontal_cover_path");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "vertical_cover_path");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "directory_sub_info");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "last_download_success_time");
                int i5 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.v vVar = new lr4.v();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    vVar.d(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    vVar.e(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    vVar.c = string3;
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    vVar.d = string4;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    vVar.e = string5;
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    vVar.f = string6;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    vVar.g = string7;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    vVar.h = string8;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow9);
                    }
                    vVar.i = string9;
                    if (query.isNull(columnIndexOrThrow10)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow10);
                    }
                    vVar.j = string10;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow11);
                    }
                    vVar.k = string11;
                    if (query.isNull(columnIndexOrThrow12)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow12);
                    }
                    vVar.l = string12;
                    if (query.isNull(columnIndexOrThrow13)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(columnIndexOrThrow13);
                    }
                    vVar.m = string13;
                    int i6 = i5;
                    if (query.isNull(i6)) {
                        i2 = i6;
                        string14 = null;
                    } else {
                        i2 = i6;
                        string14 = query.getString(i6);
                    }
                    vVar.n = string14;
                    int i7 = columnIndexOrThrow15;
                    if (query.isNull(i7)) {
                        i3 = i7;
                        string15 = null;
                    } else {
                        i3 = i7;
                        string15 = query.getString(i7);
                    }
                    vVar.o = string15;
                    int i8 = columnIndexOrThrow16;
                    if (query.isNull(i8)) {
                        columnIndexOrThrow16 = i8;
                        string16 = null;
                    } else {
                        columnIndexOrThrow16 = i8;
                        string16 = query.getString(i8);
                    }
                    vVar.p = string16;
                    int i9 = columnIndexOrThrow17;
                    if (query.isNull(i9)) {
                        columnIndexOrThrow17 = i9;
                        string17 = null;
                    } else {
                        columnIndexOrThrow17 = i9;
                        string17 = query.getString(i9);
                    }
                    vVar.q = string17;
                    int i10 = columnIndexOrThrow18;
                    if (query.isNull(i10)) {
                        columnIndexOrThrow18 = i10;
                        string18 = null;
                    } else {
                        columnIndexOrThrow18 = i10;
                        string18 = query.getString(i10);
                    }
                    vVar.r = string18;
                    int i11 = columnIndexOrThrow19;
                    if (query.isNull(i11)) {
                        columnIndexOrThrow19 = i11;
                        string19 = null;
                    } else {
                        columnIndexOrThrow19 = i11;
                        string19 = query.getString(i11);
                    }
                    vVar.s = string19;
                    int i12 = columnIndexOrThrow20;
                    if (query.isNull(i12)) {
                        columnIndexOrThrow20 = i12;
                        string20 = null;
                    } else {
                        columnIndexOrThrow20 = i12;
                        string20 = query.getString(i12);
                    }
                    vVar.t = string20;
                    int i13 = columnIndexOrThrow13;
                    int i14 = columnIndexOrThrow21;
                    vVar.u = query.getInt(i14);
                    columnIndexOrThrow21 = i14;
                    int i15 = columnIndexOrThrow22;
                    vVar.v = query.getInt(i15);
                    int i16 = columnIndexOrThrow23;
                    if (query.isNull(i16)) {
                        columnIndexOrThrow23 = i16;
                        string21 = null;
                    } else {
                        columnIndexOrThrow23 = i16;
                        string21 = query.getString(i16);
                    }
                    vVar.f(string21);
                    int i17 = columnIndexOrThrow24;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow24 = i17;
                        string22 = null;
                    } else {
                        columnIndexOrThrow24 = i17;
                        string22 = query.getString(i17);
                    }
                    vVar.h(string22);
                    int i18 = columnIndexOrThrow25;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow25 = i18;
                        string23 = null;
                    } else {
                        columnIndexOrThrow25 = i18;
                        string23 = query.getString(i18);
                    }
                    vVar.j(string23);
                    int i19 = columnIndexOrThrow26;
                    if (query.isNull(i19)) {
                        columnIndexOrThrow26 = i19;
                        string24 = null;
                    } else {
                        columnIndexOrThrow26 = i19;
                        string24 = query.getString(i19);
                    }
                    vVar.g(string24);
                    int i20 = columnIndexOrThrow27;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow27 = i20;
                        string25 = null;
                    } else {
                        columnIndexOrThrow27 = i20;
                        string25 = query.getString(i20);
                    }
                    vVar.A = string25;
                    int i21 = columnIndexOrThrow28;
                    if (query.isNull(i21)) {
                        columnIndexOrThrow28 = i21;
                        string26 = null;
                    } else {
                        columnIndexOrThrow28 = i21;
                        string26 = query.getString(i21);
                    }
                    vVar.i(string26);
                    arrayList.add(vVar);
                    columnIndexOrThrow22 = i15;
                    columnIndexOrThrow13 = i13;
                    columnIndexOrThrow15 = i3;
                    i5 = i2;
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

    @Override // nr4.v0
    public lr4.s p(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.s sVar;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_comic_download_chapter_info WHERE chapter_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "publish_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "key_version");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content_md5");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_order");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "book_chapter_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "first_pass_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "content_key");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "download_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "download_task_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "content_length");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "download_start_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "compress_status");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "download_progress");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "download_chapter_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "thumb_abs_path");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "catalog_abandon");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                if (query.moveToFirst()) {
                    lr4.s sVar2 = new lr4.s();
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    sVar2.f(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    sVar2.h(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    sVar2.j(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    sVar2.q(string4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    sVar2.i(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    sVar2.g(string6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    sVar2.s(string7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    sVar2.k(string8);
                    sVar2.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    sVar2.n(string9);
                    sVar2.k = query.getInt(columnIndexOrThrow11);
                    sVar2.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow13);
                    }
                    sVar2.p(string10);
                    if (query.isNull(columnIndexOrThrow14)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow14);
                    }
                    sVar2.t(string11);
                    if (query.isNull(columnIndexOrThrow15)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow15);
                    }
                    sVar2.m(string12);
                    sVar2.p = query.getInt(columnIndexOrThrow16);
                    sVar2.q = query.getInt(columnIndexOrThrow17);
                    sVar2.r = query.getInt(columnIndexOrThrow18);
                    sVar2.s = query.getLong(columnIndexOrThrow19);
                    sVar2.t = query.getInt(columnIndexOrThrow20);
                    sVar2.u = query.getInt(columnIndexOrThrow21);
                    if (query.isNull(columnIndexOrThrow22)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(columnIndexOrThrow22);
                    }
                    sVar2.o(string13);
                    if (query.isNull(columnIndexOrThrow23)) {
                        string14 = null;
                    } else {
                        string14 = query.getString(columnIndexOrThrow23);
                    }
                    sVar2.r(string14);
                    sVar2.x = query.getInt(columnIndexOrThrow24);
                    sVar2.y = query.getInt(columnIndexOrThrow25);
                    sVar = sVar2;
                } else {
                    sVar = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return sVar;
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

    @Override // nr4.v0
    public List<lr4.s> s(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        int i2;
        String string11;
        int i3;
        String string12;
        String string13;
        String string14;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_comic_download_chapter_info WHERE book_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i4 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str);
            }
            i4++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "publish_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "key_version");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content_md5");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_order");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "book_chapter_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "first_pass_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "content_key");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "download_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "download_task_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "content_length");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "download_start_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "compress_status");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "download_progress");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "download_chapter_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "thumb_abs_path");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "catalog_abandon");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                int i5 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.s sVar = new lr4.s();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    sVar.f(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    sVar.h(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    sVar.j(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    sVar.q(string4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    sVar.i(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    sVar.g(string6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    sVar.s(string7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    sVar.k(string8);
                    sVar.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    sVar.n(string9);
                    sVar.k = query.getInt(columnIndexOrThrow11);
                    sVar.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow13);
                    }
                    sVar.p(string10);
                    int i6 = i5;
                    if (query.isNull(i6)) {
                        i2 = i6;
                        string11 = null;
                    } else {
                        i2 = i6;
                        string11 = query.getString(i6);
                    }
                    sVar.t(string11);
                    int i7 = columnIndexOrThrow15;
                    if (query.isNull(i7)) {
                        i3 = i7;
                        string12 = null;
                    } else {
                        i3 = i7;
                        string12 = query.getString(i7);
                    }
                    sVar.m(string12);
                    int i8 = columnIndexOrThrow13;
                    int i9 = columnIndexOrThrow16;
                    sVar.p = query.getInt(i9);
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    sVar.q = query.getInt(i10);
                    columnIndexOrThrow17 = i10;
                    int i11 = columnIndexOrThrow18;
                    sVar.r = query.getInt(i11);
                    int i12 = columnIndexOrThrow2;
                    int i13 = columnIndexOrThrow19;
                    int i14 = columnIndexOrThrow3;
                    sVar.s = query.getLong(i13);
                    int i15 = columnIndexOrThrow20;
                    sVar.t = query.getInt(i15);
                    int i16 = columnIndexOrThrow21;
                    sVar.u = query.getInt(i16);
                    int i17 = columnIndexOrThrow22;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow22 = i17;
                        string13 = null;
                    } else {
                        columnIndexOrThrow22 = i17;
                        string13 = query.getString(i17);
                    }
                    sVar.o(string13);
                    int i18 = columnIndexOrThrow23;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow23 = i18;
                        string14 = null;
                    } else {
                        columnIndexOrThrow23 = i18;
                        string14 = query.getString(i18);
                    }
                    sVar.r(string14);
                    int i19 = columnIndexOrThrow24;
                    sVar.x = query.getInt(i19);
                    columnIndexOrThrow24 = i19;
                    int i20 = columnIndexOrThrow25;
                    sVar.y = query.getInt(i20);
                    arrayList.add(sVar);
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow15 = i3;
                    i5 = i2;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow2 = i12;
                    columnIndexOrThrow18 = i11;
                    columnIndexOrThrow21 = i16;
                    columnIndexOrThrow3 = i14;
                    columnIndexOrThrow19 = i13;
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

    @Override // nr4.v0
    public lr4.v v(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.v vVar;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_comic_detail_info WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horizontal_cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "vertical_cover_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "author");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "abstraction");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "read_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "score");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "creation_status");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "authorize_type");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "first_chapter_id");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "category_scheme");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "content_chapter_count");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "book_content_length");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "horizontal_cover_path");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "vertical_cover_path");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "directory_sub_info");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "last_download_success_time");
                if (query.moveToFirst()) {
                    lr4.v vVar2 = new lr4.v();
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    vVar2.d(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    vVar2.e(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    vVar2.c = string3;
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    vVar2.d = string4;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    vVar2.e = string5;
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    vVar2.f = string6;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    vVar2.g = string7;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    vVar2.h = string8;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow9);
                    }
                    vVar2.i = string9;
                    if (query.isNull(columnIndexOrThrow10)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow10);
                    }
                    vVar2.j = string10;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow11);
                    }
                    vVar2.k = string11;
                    if (query.isNull(columnIndexOrThrow12)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow12);
                    }
                    vVar2.l = string12;
                    if (query.isNull(columnIndexOrThrow13)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(columnIndexOrThrow13);
                    }
                    vVar2.m = string13;
                    if (query.isNull(columnIndexOrThrow14)) {
                        string14 = null;
                    } else {
                        string14 = query.getString(columnIndexOrThrow14);
                    }
                    vVar2.n = string14;
                    if (query.isNull(columnIndexOrThrow15)) {
                        string15 = null;
                    } else {
                        string15 = query.getString(columnIndexOrThrow15);
                    }
                    vVar2.o = string15;
                    if (query.isNull(columnIndexOrThrow16)) {
                        string16 = null;
                    } else {
                        string16 = query.getString(columnIndexOrThrow16);
                    }
                    vVar2.p = string16;
                    if (query.isNull(columnIndexOrThrow17)) {
                        string17 = null;
                    } else {
                        string17 = query.getString(columnIndexOrThrow17);
                    }
                    vVar2.q = string17;
                    if (query.isNull(columnIndexOrThrow18)) {
                        string18 = null;
                    } else {
                        string18 = query.getString(columnIndexOrThrow18);
                    }
                    vVar2.r = string18;
                    if (query.isNull(columnIndexOrThrow19)) {
                        string19 = null;
                    } else {
                        string19 = query.getString(columnIndexOrThrow19);
                    }
                    vVar2.s = string19;
                    if (query.isNull(columnIndexOrThrow20)) {
                        string20 = null;
                    } else {
                        string20 = query.getString(columnIndexOrThrow20);
                    }
                    vVar2.t = string20;
                    vVar2.u = query.getInt(columnIndexOrThrow21);
                    vVar2.v = query.getInt(columnIndexOrThrow22);
                    if (query.isNull(columnIndexOrThrow23)) {
                        string21 = null;
                    } else {
                        string21 = query.getString(columnIndexOrThrow23);
                    }
                    vVar2.f(string21);
                    if (query.isNull(columnIndexOrThrow24)) {
                        string22 = null;
                    } else {
                        string22 = query.getString(columnIndexOrThrow24);
                    }
                    vVar2.h(string22);
                    if (query.isNull(columnIndexOrThrow25)) {
                        string23 = null;
                    } else {
                        string23 = query.getString(columnIndexOrThrow25);
                    }
                    vVar2.j(string23);
                    if (query.isNull(columnIndexOrThrow26)) {
                        string24 = null;
                    } else {
                        string24 = query.getString(columnIndexOrThrow26);
                    }
                    vVar2.g(string24);
                    if (query.isNull(columnIndexOrThrow27)) {
                        string25 = null;
                    } else {
                        string25 = query.getString(columnIndexOrThrow27);
                    }
                    vVar2.A = string25;
                    if (query.isNull(columnIndexOrThrow28)) {
                        string26 = null;
                    } else {
                        string26 = query.getString(columnIndexOrThrow28);
                    }
                    vVar2.i(string26);
                    vVar = vVar2;
                } else {
                    vVar = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return vVar;
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

    @Override // nr4.v0
    public List<lr4.s> x(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        int i2;
        String string11;
        int i3;
        String string12;
        String string13;
        String string14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_comic_download_chapter_info WHERE book_id = ? ORDER BY chapter_order ASC", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "publish_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, Constants.VERSION);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "key_version");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "content_md5");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "chapter_order");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "book_chapter_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "first_pass_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "volume_name");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "content_key");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "download_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "download_task_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "content_length");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "download_start_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "compress_status");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "download_progress");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "download_chapter_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "thumb_abs_path");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "catalog_abandon");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "consume_ad");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.s sVar = new lr4.s();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    sVar.f(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    sVar.h(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    sVar.j(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    sVar.q(string4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    sVar.i(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    sVar.g(string6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    sVar.s(string7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    sVar.k(string8);
                    sVar.i = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    sVar.n(string9);
                    sVar.k = query.getInt(columnIndexOrThrow11);
                    sVar.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow13);
                    }
                    sVar.p(string10);
                    int i5 = i4;
                    if (query.isNull(i5)) {
                        i2 = i5;
                        string11 = null;
                    } else {
                        i2 = i5;
                        string11 = query.getString(i5);
                    }
                    sVar.t(string11);
                    int i6 = columnIndexOrThrow15;
                    if (query.isNull(i6)) {
                        i3 = i6;
                        string12 = null;
                    } else {
                        i3 = i6;
                        string12 = query.getString(i6);
                    }
                    sVar.m(string12);
                    int i7 = columnIndexOrThrow13;
                    int i8 = columnIndexOrThrow16;
                    sVar.p = query.getInt(i8);
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    sVar.q = query.getInt(i9);
                    columnIndexOrThrow17 = i9;
                    int i10 = columnIndexOrThrow18;
                    sVar.r = query.getInt(i10);
                    int i11 = columnIndexOrThrow2;
                    int i12 = columnIndexOrThrow19;
                    int i13 = columnIndexOrThrow3;
                    sVar.s = query.getLong(i12);
                    int i14 = columnIndexOrThrow20;
                    sVar.t = query.getInt(i14);
                    int i15 = columnIndexOrThrow21;
                    sVar.u = query.getInt(i15);
                    int i16 = columnIndexOrThrow22;
                    if (query.isNull(i16)) {
                        columnIndexOrThrow22 = i16;
                        string13 = null;
                    } else {
                        columnIndexOrThrow22 = i16;
                        string13 = query.getString(i16);
                    }
                    sVar.o(string13);
                    int i17 = columnIndexOrThrow23;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow23 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow23 = i17;
                        string14 = query.getString(i17);
                    }
                    sVar.r(string14);
                    int i18 = columnIndexOrThrow24;
                    sVar.x = query.getInt(i18);
                    columnIndexOrThrow24 = i18;
                    int i19 = columnIndexOrThrow25;
                    sVar.y = query.getInt(i19);
                    arrayList.add(sVar);
                    columnIndexOrThrow25 = i19;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow15 = i3;
                    i4 = i2;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow20 = i14;
                    columnIndexOrThrow2 = i11;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow21 = i15;
                    columnIndexOrThrow3 = i13;
                    columnIndexOrThrow19 = i12;
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

    class a extends EntityInsertionAdapter<lr4.v> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_comic_detail_info` (`book_id`,`book_name`,`horizontal_cover_url`,`vertical_cover_url`,`last_update_time`,`update_status`,`author`,`create_time`,`abstraction`,`read_count`,`score`,`creation_status`,`authorize_type`,`first_chapter_id`,`last_chapter_id`,`category_scheme`,`source`,`tags`,`color_dominate`,`serial_count`,`content_chapter_count`,`book_content_length`,`consume_ad`,`horizontal_cover_path`,`vertical_cover_path`,`directory_sub_info`,`book_type`,`last_download_success_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.v vVar) {
            String str = vVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = vVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = vVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = vVar.d;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            String str5 = vVar.e;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str5);
            }
            String str6 = vVar.f;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str6);
            }
            String str7 = vVar.g;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str7);
            }
            String str8 = vVar.h;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str8);
            }
            String str9 = vVar.i;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str9);
            }
            String str10 = vVar.j;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str10);
            }
            String str11 = vVar.k;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str11);
            }
            String str12 = vVar.l;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str12);
            }
            String str13 = vVar.m;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str13);
            }
            String str14 = vVar.n;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str14);
            }
            String str15 = vVar.o;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str15);
            }
            String str16 = vVar.p;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str16);
            }
            String str17 = vVar.q;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str17);
            }
            String str18 = vVar.r;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str18);
            }
            String str19 = vVar.s;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str19);
            }
            String str20 = vVar.t;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str20);
            }
            supportSQLiteStatement.bindLong(21, vVar.u);
            supportSQLiteStatement.bindLong(22, vVar.v);
            String str21 = vVar.w;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str21);
            }
            String str22 = vVar.x;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str22);
            }
            String str23 = vVar.y;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str23);
            }
            String str24 = vVar.z;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str24);
            }
            String str25 = vVar.A;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str25);
            }
            String str26 = vVar.B;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str26);
            }
        }
    }

    class b extends EntityInsertionAdapter<lr4.s> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_comic_download_chapter_info` (`book_id`,`chapter_id`,`chapter_thumb_url`,`publish_time`,`chapter_name`,`book_name`,`version`,`content`,`key_version`,`content_md5`,`chapter_order`,`book_chapter_count`,`first_pass_time`,`volume_name`,`content_key`,`download_status`,`download_task_id`,`content_length`,`download_start_time`,`compress_status`,`download_progress`,`download_chapter_path`,`thumb_abs_path`,`catalog_abandon`,`consume_ad`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.s sVar) {
            String str = sVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = sVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = sVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = sVar.d;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            String str5 = sVar.e;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str5);
            }
            String str6 = sVar.f;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str6);
            }
            String str7 = sVar.g;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str7);
            }
            String str8 = sVar.h;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str8);
            }
            supportSQLiteStatement.bindLong(9, sVar.i);
            String str9 = sVar.j;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str9);
            }
            supportSQLiteStatement.bindLong(11, sVar.k);
            supportSQLiteStatement.bindLong(12, sVar.l);
            String str10 = sVar.m;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str10);
            }
            String str11 = sVar.n;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str11);
            }
            String str12 = sVar.o;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str12);
            }
            supportSQLiteStatement.bindLong(16, sVar.p);
            supportSQLiteStatement.bindLong(17, sVar.q);
            supportSQLiteStatement.bindLong(18, sVar.r);
            supportSQLiteStatement.bindLong(19, sVar.s);
            supportSQLiteStatement.bindLong(20, sVar.t);
            supportSQLiteStatement.bindLong(21, sVar.u);
            String str13 = sVar.v;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str13);
            }
            String str14 = sVar.w;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str14);
            }
            supportSQLiteStatement.bindLong(24, sVar.x);
            supportSQLiteStatement.bindLong(25, sVar.y);
        }
    }

    class c extends EntityInsertionAdapter<lr4.z> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_comic_download_item_info` (`chapter_id`,`book_id`,`md5`,`abs_save_path`,`download_create_time`,`content_order`,`download_status`,`download_task_id`,`download_sdk_task_id`,`content_length`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.z zVar) {
            String str = zVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = zVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = zVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = zVar.d;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            supportSQLiteStatement.bindLong(5, zVar.e);
            supportSQLiteStatement.bindLong(6, zVar.f);
            supportSQLiteStatement.bindLong(7, zVar.g);
            supportSQLiteStatement.bindLong(8, zVar.h);
            String str5 = zVar.i;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str5);
            }
            String str6 = zVar.j;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str6);
            }
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "UPDATE t_comic_detail_info SET last_download_success_time = ? WHERE book_id = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "UPDATE t_comic_download_chapter_info SET download_status = ? , download_progress = ?  WHERE chapter_id = ?";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class f extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_comic_download_item_info WHERE  book_id = (?) AND chapter_id = (?) AND md5 = (?)";
        }

        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // nr4.v0
    public List<String> h(List<String> list, int i) {
        String string;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT book_id FROM t_comic_download_chapter_info WHERE book_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") AND download_status = ");
        newStringBuilder.append("?");
        int i2 = 1;
        int i3 = size + 1;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), i3);
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        acquire.bindLong(i3, i);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    string = null;
                } else {
                    string = query.getString(0);
                }
                arrayList.add(string);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.v0
    public void k(List<String> list, int i) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE t_comic_download_chapter_info SET catalog_abandon = ");
        newStringBuilder.append("?");
        newStringBuilder.append(" WHERE chapter_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, i);
        int i2 = 2;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void l(List<String> list, int i) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE t_comic_download_chapter_info SET download_status = ");
        newStringBuilder.append("?");
        newStringBuilder.append(" WHERE chapter_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, i);
        int i2 = 2;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void q(int i, List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE t_comic_download_chapter_info SET consume_ad = ");
        newStringBuilder.append("?");
        newStringBuilder.append(" WHERE chapter_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, i);
        int i2 = 2;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void t(String str, String str2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
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

    @Override // nr4.v0
    public void f(int i, String str, List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE t_comic_download_item_info SET download_status = ");
        newStringBuilder.append("?");
        newStringBuilder.append(" AND download_task_id = ");
        newStringBuilder.append("?");
        newStringBuilder.append("  WHERE md5 IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, i);
        if (str == null) {
            compileStatement.bindNull(2);
        } else {
            compileStatement.bindString(2, str);
        }
        int i2 = 3;
        for (String str2 : list) {
            if (str2 == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str2);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.v0
    public void u(String str, int i, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        acquire.bindLong(1, i);
        acquire.bindLong(2, i2);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
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
}
