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
import com.dragon.read.local.db.entity.Book;
import com.dragon.read.local.db.pojo.BookModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s implements q {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<Book> b;
    private final EntityInsertionAdapter<lr4.q> c;
    private final EntityDeletionOrUpdateAdapter<Book> d;
    private final EntityDeletionOrUpdateAdapter<lr4.q> e;
    private final SharedSQLiteStatement f;

    static {
        Covode.recordClassIndex(611649);
    }

    public static List<Class<?>> m() {
        return Collections.emptyList();
    }

    @Override // nr4.q
    public List<BookModel> f() {
        String string;
        Integer valueOf;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT a.book_id,a.book_type FROM t_bookshelf AS a WHERE a.is_delete = 0 ORDER BY update_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
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
                arrayList.add(new BookModel(string, kr4.b.b(valueOf)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.q
    public List<String> i() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT book_id FROM t_bookshelf ORDER BY update_time DESC", 0);
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

    @Override // nr4.q
    public List<lr4.q> c() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
        int i;
        String string2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_bookshelf ORDER BY update_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "add_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "booklist_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_chased_updates");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "add_bookshelf_time_sec");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_preheat_book_pinned");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow4)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        i = columnIndexOrThrow4;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        i = columnIndexOrThrow4;
                    }
                    BookType b2 = kr4.b.b(valueOf);
                    int i3 = columnIndexOrThrow5;
                    lr4.q qVar = new lr4.q(string, b2);
                    qVar.a = query.getInt(columnIndexOrThrow);
                    int i4 = columnIndexOrThrow;
                    qVar.b = query.getLong(columnIndexOrThrow2);
                    qVar.c = query.getLong(columnIndexOrThrow3);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow6);
                    }
                    qVar.f = string2;
                    if (query.getInt(columnIndexOrThrow7) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    qVar.g = z;
                    if (query.getInt(columnIndexOrThrow8) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    qVar.h = z2;
                    int i5 = columnIndexOrThrow12;
                    qVar.i = query.getLong(columnIndexOrThrow9);
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    qVar.j = z3;
                    qVar.k = query.getLong(columnIndexOrThrow11);
                    qVar.l = query.getLong(i5);
                    if (query.getInt(columnIndexOrThrow13) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    qVar.m = z4;
                    int i6 = i2;
                    if (query.getInt(i6) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    qVar.n = z5;
                    i2 = i6;
                    int i7 = columnIndexOrThrow15;
                    qVar.o = query.getLong(i7);
                    int i8 = columnIndexOrThrow16;
                    if (query.getInt(i8) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    qVar.p = z6;
                    arrayList.add(qVar);
                    columnIndexOrThrow16 = i8;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow5 = i3;
                    columnIndexOrThrow4 = i;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow12 = i5;
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

    @Override // nr4.q
    public List<lr4.z0> queryRealBookStatusInShelf() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        Integer valueOf;
        boolean z;
        boolean z2;
        boolean z3;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z4;
        int i2;
        boolean z5;
        boolean z6;
        int i3;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        boolean z7;
        int i4;
        String string13;
        String string14;
        int i5;
        String string15;
        String string16;
        boolean z8;
        String string17;
        String string18;
        String string19;
        String string20;
        int i6;
        String string21;
        String string22;
        boolean z9;
        boolean z10;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT f.book_id,f.book_type,f.add_type, f.is_preheat_book_pinned, f.is_asterisked, f.is_chased_updates, f.add_bookshelf_time_sec, b.horiz_thumb_url, b.creationStatus, b.abstraction, b.category, b.tags, f.update_time,f.booklist_name,f.booklist_operate_time, f.is_sync,f.is_pinned,f.pinned_time,f.is_delete, b.name,b.cover_url,b.last_serial_count,b.serial_count,b.update_status,b.author,b.is_finish,f.create_time,f.update_time,b.genre_type,b.genre,b.score,b.wordNumber,b.length_type,b.book_short_name,b.tts_status,b.is_exclusive,b.icon_tag,b.recommend_info,b.recommend_group_id,b.book_status,b.listen_bookshelf_name,b.last_chapter_title,b.last_chapter_update_time,b.is_pub_pay,b.pay_type,b.show_vip_tag,b.relative_post_schema,b.relative_post_id,b.poster_id,c.relative_audio_book_id_set,c.relative_novel_book_id FROM t_bookshelf AS f LEFT JOIN t_book AS b ON f.book_id = b.book_id LEFT JOIN t_relative_book_id AS c ON f.book_id = c.id AND f.book_type = c.book_type ORDER BY f.update_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "add_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "is_preheat_book_pinned");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_chased_updates");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "add_bookshelf_time_sec");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "abstraction");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "author");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "genre");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "wordNumber");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "book_short_name");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
                int i7 = columnIndexOrThrow27;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.z0 z0Var = new lr4.z0();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    z0Var.b = string;
                    if (query.isNull(columnIndexOrThrow2)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                    }
                    z0Var.d = kr4.b.b(valueOf);
                    z0Var.c = query.getInt(columnIndexOrThrow3);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z0Var.R = z;
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z0Var.M = z2;
                    if (query.getInt(columnIndexOrThrow6) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z0Var.N = z3;
                    int i8 = columnIndexOrThrow2;
                    z0Var.L = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow8);
                    }
                    z0Var.K = string2;
                    z0Var.J = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow10);
                    }
                    z0Var.I = string3;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow11);
                    }
                    z0Var.B = string4;
                    if (query.isNull(columnIndexOrThrow12)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow12);
                    }
                    z0Var.C = string5;
                    z0Var.q = query.getLong(columnIndexOrThrow13);
                    int i9 = columnIndexOrThrow14;
                    if (query.isNull(i9)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(i9);
                    }
                    z0Var.A = string6;
                    int i10 = columnIndexOrThrow12;
                    int i11 = columnIndexOrThrow15;
                    z0Var.D = query.getLong(i11);
                    int i12 = columnIndexOrThrow16;
                    if (query.getInt(i12) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z0Var.E = z4;
                    int i13 = columnIndexOrThrow17;
                    if (query.getInt(i13) != 0) {
                        i2 = columnIndexOrThrow13;
                        z5 = true;
                    } else {
                        i2 = columnIndexOrThrow13;
                        z5 = false;
                    }
                    z0Var.G = z5;
                    int i14 = columnIndexOrThrow18;
                    z0Var.H = query.getLong(i14);
                    int i15 = columnIndexOrThrow19;
                    if (query.getInt(i15) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z0Var.F = z6;
                    int i16 = columnIndexOrThrow20;
                    if (query.isNull(i16)) {
                        i3 = i14;
                        string7 = null;
                    } else {
                        i3 = i14;
                        string7 = query.getString(i16);
                    }
                    z0Var.e = string7;
                    int i17 = columnIndexOrThrow21;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow21 = i17;
                        string8 = null;
                    } else {
                        columnIndexOrThrow21 = i17;
                        string8 = query.getString(i17);
                    }
                    z0Var.g = string8;
                    int i18 = columnIndexOrThrow22;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow22 = i18;
                        string9 = null;
                    } else {
                        columnIndexOrThrow22 = i18;
                        string9 = query.getString(i18);
                    }
                    z0Var.m = string9;
                    int i19 = columnIndexOrThrow23;
                    if (query.isNull(i19)) {
                        columnIndexOrThrow23 = i19;
                        string10 = null;
                    } else {
                        columnIndexOrThrow23 = i19;
                        string10 = query.getString(i19);
                    }
                    z0Var.n = string10;
                    int i20 = columnIndexOrThrow24;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow24 = i20;
                        string11 = null;
                    } else {
                        columnIndexOrThrow24 = i20;
                        string11 = query.getString(i20);
                    }
                    z0Var.p = string11;
                    int i21 = columnIndexOrThrow25;
                    if (query.isNull(i21)) {
                        columnIndexOrThrow25 = i21;
                        string12 = null;
                    } else {
                        columnIndexOrThrow25 = i21;
                        string12 = query.getString(i21);
                    }
                    z0Var.a = string12;
                    int i22 = columnIndexOrThrow26;
                    columnIndexOrThrow26 = i22;
                    if (query.getInt(i22) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z0Var.l = z7;
                    columnIndexOrThrow19 = i15;
                    int i23 = i7;
                    z0Var.h = query.getLong(i23);
                    int i24 = columnIndexOrThrow28;
                    z0Var.q = query.getLong(i24);
                    int i25 = columnIndexOrThrow29;
                    z0Var.i = query.getInt(i25);
                    int i26 = columnIndexOrThrow30;
                    if (query.isNull(i26)) {
                        i4 = i23;
                        string13 = null;
                    } else {
                        i4 = i23;
                        string13 = query.getString(i26);
                    }
                    z0Var.j = string13;
                    int i27 = columnIndexOrThrow31;
                    if (query.isNull(i27)) {
                        columnIndexOrThrow31 = i27;
                        string14 = null;
                    } else {
                        columnIndexOrThrow31 = i27;
                        string14 = query.getString(i27);
                    }
                    z0Var.T = string14;
                    int i28 = columnIndexOrThrow11;
                    int i29 = columnIndexOrThrow32;
                    z0Var.U = query.getInt(i29);
                    int i30 = columnIndexOrThrow33;
                    if (query.isNull(i30)) {
                        i5 = i29;
                        string15 = null;
                    } else {
                        i5 = i29;
                        string15 = query.getString(i30);
                    }
                    z0Var.k = string15;
                    int i31 = columnIndexOrThrow34;
                    if (query.isNull(i31)) {
                        columnIndexOrThrow34 = i31;
                        string16 = null;
                    } else {
                        columnIndexOrThrow34 = i31;
                        string16 = query.getString(i31);
                    }
                    z0Var.S = string16;
                    int i32 = columnIndexOrThrow35;
                    z0Var.o = query.getInt(i32);
                    int i33 = columnIndexOrThrow36;
                    if (query.getInt(i33) != 0) {
                        columnIndexOrThrow35 = i32;
                        z8 = true;
                    } else {
                        columnIndexOrThrow35 = i32;
                        z8 = false;
                    }
                    z0Var.r = z8;
                    int i34 = columnIndexOrThrow37;
                    if (query.isNull(i34)) {
                        columnIndexOrThrow37 = i34;
                        string17 = null;
                    } else {
                        columnIndexOrThrow37 = i34;
                        string17 = query.getString(i34);
                    }
                    z0Var.s = string17;
                    int i35 = columnIndexOrThrow38;
                    if (query.isNull(i35)) {
                        columnIndexOrThrow38 = i35;
                        string18 = null;
                    } else {
                        columnIndexOrThrow38 = i35;
                        string18 = query.getString(i35);
                    }
                    z0Var.t = string18;
                    int i36 = columnIndexOrThrow39;
                    if (query.isNull(i36)) {
                        columnIndexOrThrow39 = i36;
                        string19 = null;
                    } else {
                        columnIndexOrThrow39 = i36;
                        string19 = query.getString(i36);
                    }
                    z0Var.u = string19;
                    int i37 = columnIndexOrThrow40;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow40 = i37;
                        string20 = null;
                    } else {
                        columnIndexOrThrow40 = i37;
                        string20 = query.getString(i37);
                    }
                    z0Var.v = string20;
                    int i38 = columnIndexOrThrow41;
                    if (query.isNull(i38)) {
                        columnIndexOrThrow36 = i33;
                        z0Var.f = null;
                    } else {
                        columnIndexOrThrow36 = i33;
                        z0Var.f = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow42;
                    if (query.isNull(i39)) {
                        i6 = i38;
                        string21 = null;
                    } else {
                        i6 = i38;
                        string21 = query.getString(i39);
                    }
                    z0Var.y = string21;
                    int i40 = columnIndexOrThrow43;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow43 = i40;
                        string22 = null;
                    } else {
                        columnIndexOrThrow43 = i40;
                        string22 = query.getString(i40);
                    }
                    z0Var.z = string22;
                    int i41 = columnIndexOrThrow44;
                    columnIndexOrThrow44 = i41;
                    if (query.getInt(i41) != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    z0Var.O = z9;
                    int i42 = columnIndexOrThrow45;
                    z0Var.P = query.getInt(i42);
                    int i43 = columnIndexOrThrow46;
                    if (query.getInt(i43) != 0) {
                        columnIndexOrThrow45 = i42;
                        z10 = true;
                    } else {
                        columnIndexOrThrow45 = i42;
                        z10 = false;
                    }
                    z0Var.Q = z10;
                    int i44 = columnIndexOrThrow47;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow47 = i44;
                        string23 = null;
                    } else {
                        columnIndexOrThrow47 = i44;
                        string23 = query.getString(i44);
                    }
                    z0Var.V = string23;
                    int i45 = columnIndexOrThrow48;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow48 = i45;
                        string24 = null;
                    } else {
                        columnIndexOrThrow48 = i45;
                        string24 = query.getString(i45);
                    }
                    z0Var.W = string24;
                    int i46 = columnIndexOrThrow49;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow49 = i46;
                        string25 = null;
                    } else {
                        columnIndexOrThrow49 = i46;
                        string25 = query.getString(i46);
                    }
                    z0Var.X = string25;
                    int i47 = columnIndexOrThrow50;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow50 = i47;
                        string26 = null;
                    } else {
                        string26 = query.getString(i47);
                        columnIndexOrThrow50 = i47;
                    }
                    z0Var.w = kr4.h.b(string26);
                    int i48 = columnIndexOrThrow51;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow51 = i48;
                        string27 = null;
                    } else {
                        columnIndexOrThrow51 = i48;
                        string27 = query.getString(i48);
                    }
                    z0Var.x = string27;
                    arrayList.add(z0Var);
                    columnIndexOrThrow46 = i43;
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow16 = i12;
                    columnIndexOrThrow17 = i13;
                    columnIndexOrThrow18 = i3;
                    columnIndexOrThrow11 = i28;
                    columnIndexOrThrow20 = i16;
                    columnIndexOrThrow29 = i25;
                    i7 = i4;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow30 = i26;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow28 = i24;
                    columnIndexOrThrow12 = i10;
                    columnIndexOrThrow14 = i9;
                    columnIndexOrThrow15 = i11;
                    int i49 = i5;
                    columnIndexOrThrow33 = i30;
                    columnIndexOrThrow32 = i49;
                    int i50 = i6;
                    columnIndexOrThrow42 = i39;
                    columnIndexOrThrow41 = i50;
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

    public s(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
    }

    @Override // nr4.q
    public Long[] d(lr4.q... qVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.c.insertAndReturnIdsArrayBox(qVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.q
    public int h(Book... bookArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.d.handleMultiple(bookArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.q
    public int j(lr4.q... qVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.e.handleMultiple(qVarArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.q
    public Long[] k(Book... bookArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(bookArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.q
    public List<lr4.k> g(List<String> list) {
        String string;
        String string2;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT b.book_id, b.chapter_count, p.chapter_index FROM t_reading_record AS b LEFT JOIN t_book_progress AS p ON b.book_id = p.book_id WHERE b.book_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") AND p.book_type = 0");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_count");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                arrayList.add(new lr4.k(string, string2, query.getInt(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // nr4.q
    public List<lr4.q> b(List<String> list) {
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
        Integer valueOf;
        int i;
        String string2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_bookshelf WHERE book_id  IN (");
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
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "add_type");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "booklist_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_chased_updates");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "add_bookshelf_time_sec");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_preheat_book_pinned");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow4)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    i = columnIndexOrThrow4;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                    i = columnIndexOrThrow4;
                }
                BookType b2 = kr4.b.b(valueOf);
                int i4 = columnIndexOrThrow5;
                lr4.q qVar = new lr4.q(string, b2);
                qVar.a = query.getInt(columnIndexOrThrow);
                int i5 = columnIndexOrThrow;
                qVar.b = query.getLong(columnIndexOrThrow2);
                qVar.c = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow6)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow6);
                }
                qVar.f = string2;
                if (query.getInt(columnIndexOrThrow7) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                qVar.g = z;
                if (query.getInt(columnIndexOrThrow8) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                qVar.h = z2;
                qVar.i = query.getLong(columnIndexOrThrow9);
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                qVar.j = z3;
                qVar.k = query.getLong(columnIndexOrThrow11);
                qVar.l = query.getLong(columnIndexOrThrow12);
                if (query.getInt(columnIndexOrThrow13) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                qVar.m = z4;
                int i6 = i3;
                if (query.getInt(i6) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                qVar.n = z5;
                int i7 = columnIndexOrThrow12;
                int i8 = columnIndexOrThrow15;
                int i9 = columnIndexOrThrow11;
                qVar.o = query.getLong(i8);
                int i10 = columnIndexOrThrow16;
                if (query.getInt(i10) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                qVar.p = z6;
                arrayList.add(qVar);
                columnIndexOrThrow16 = i10;
                columnIndexOrThrow11 = i9;
                columnIndexOrThrow12 = i7;
                columnIndexOrThrow5 = i4;
                i3 = i6;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow = i5;
                columnIndexOrThrow4 = i;
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

    @Override // nr4.q
    public List<lr4.z0> e(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        Integer valueOf;
        boolean z;
        boolean z2;
        boolean z3;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z4;
        int i2;
        boolean z5;
        boolean z6;
        int i3;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        boolean z7;
        int i4;
        String string13;
        String string14;
        int i5;
        String string15;
        boolean z8;
        String string16;
        String string17;
        String string18;
        String string19;
        int i6;
        String string20;
        String string21;
        boolean z9;
        boolean z10;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT f.book_id,f.book_type,f.add_type, f.is_preheat_book_pinned, f.is_asterisked, f.is_chased_updates, f.add_bookshelf_time_sec, b.horiz_thumb_url, b.creationStatus, b.abstraction, b.category, b.tags, f.update_time,f.booklist_name,f.booklist_operate_time, f.is_sync,f.is_pinned,f.pinned_time,f.is_delete, b.name,b.cover_url,b.last_serial_count,b.serial_count,b.update_status,b.author,b.is_finish,f.create_time,f.update_time,b.genre_type,b.genre,b.score,b.wordNumber,b.length_type,b.tts_status,b.is_exclusive,b.icon_tag,b.recommend_info,b.recommend_group_id,b.book_status,b.listen_bookshelf_name,b.last_chapter_title,b.last_chapter_update_time,b.is_pub_pay,b.pay_type,b.show_vip_tag,b.relative_post_schema,b.relative_post_id,b.poster_id,c.relative_audio_book_id_set,c.relative_novel_book_id FROM t_bookshelf AS f LEFT JOIN t_book AS b ON f.book_id = b.book_id LEFT JOIN t_relative_book_id AS c ON f.book_id = c.id AND f.book_type = c.book_type WHERE f.book_id in (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") ORDER BY f.update_time DESC");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i7 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i7);
            } else {
                acquire.bindString(i7, str);
            }
            i7++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "add_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "is_preheat_book_pinned");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_chased_updates");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "add_bookshelf_time_sec");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "abstraction");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "author");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "genre");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "wordNumber");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
                int i8 = columnIndexOrThrow27;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.z0 z0Var = new lr4.z0();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    z0Var.b = string;
                    if (query.isNull(columnIndexOrThrow2)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                    }
                    z0Var.d = kr4.b.b(valueOf);
                    z0Var.c = query.getInt(columnIndexOrThrow3);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z0Var.R = z;
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z0Var.M = z2;
                    if (query.getInt(columnIndexOrThrow6) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z0Var.N = z3;
                    int i9 = columnIndexOrThrow2;
                    z0Var.L = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow8);
                    }
                    z0Var.K = string2;
                    z0Var.J = query.getInt(columnIndexOrThrow9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow10);
                    }
                    z0Var.I = string3;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow11);
                    }
                    z0Var.B = string4;
                    if (query.isNull(columnIndexOrThrow12)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow12);
                    }
                    z0Var.C = string5;
                    z0Var.q = query.getLong(columnIndexOrThrow13);
                    int i10 = columnIndexOrThrow14;
                    if (query.isNull(i10)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(i10);
                    }
                    z0Var.A = string6;
                    int i11 = columnIndexOrThrow10;
                    int i12 = columnIndexOrThrow15;
                    int i13 = columnIndexOrThrow11;
                    z0Var.D = query.getLong(i12);
                    int i14 = columnIndexOrThrow16;
                    if (query.getInt(i14) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z0Var.E = z4;
                    int i15 = columnIndexOrThrow17;
                    if (query.getInt(i15) != 0) {
                        i2 = columnIndexOrThrow13;
                        z5 = true;
                    } else {
                        i2 = columnIndexOrThrow13;
                        z5 = false;
                    }
                    z0Var.G = z5;
                    int i16 = columnIndexOrThrow18;
                    z0Var.H = query.getLong(i16);
                    int i17 = columnIndexOrThrow19;
                    if (query.getInt(i17) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z0Var.F = z6;
                    int i18 = columnIndexOrThrow20;
                    if (query.isNull(i18)) {
                        i3 = i16;
                        string7 = null;
                    } else {
                        i3 = i16;
                        string7 = query.getString(i18);
                    }
                    z0Var.e = string7;
                    int i19 = columnIndexOrThrow21;
                    if (query.isNull(i19)) {
                        columnIndexOrThrow21 = i19;
                        string8 = null;
                    } else {
                        columnIndexOrThrow21 = i19;
                        string8 = query.getString(i19);
                    }
                    z0Var.g = string8;
                    int i20 = columnIndexOrThrow22;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow22 = i20;
                        string9 = null;
                    } else {
                        columnIndexOrThrow22 = i20;
                        string9 = query.getString(i20);
                    }
                    z0Var.m = string9;
                    int i21 = columnIndexOrThrow23;
                    if (query.isNull(i21)) {
                        columnIndexOrThrow23 = i21;
                        string10 = null;
                    } else {
                        columnIndexOrThrow23 = i21;
                        string10 = query.getString(i21);
                    }
                    z0Var.n = string10;
                    int i22 = columnIndexOrThrow24;
                    if (query.isNull(i22)) {
                        columnIndexOrThrow24 = i22;
                        string11 = null;
                    } else {
                        columnIndexOrThrow24 = i22;
                        string11 = query.getString(i22);
                    }
                    z0Var.p = string11;
                    int i23 = columnIndexOrThrow25;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow25 = i23;
                        string12 = null;
                    } else {
                        columnIndexOrThrow25 = i23;
                        string12 = query.getString(i23);
                    }
                    z0Var.a = string12;
                    int i24 = columnIndexOrThrow26;
                    columnIndexOrThrow26 = i24;
                    if (query.getInt(i24) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z0Var.l = z7;
                    columnIndexOrThrow19 = i17;
                    int i25 = i8;
                    z0Var.h = query.getLong(i25);
                    int i26 = columnIndexOrThrow28;
                    int i27 = columnIndexOrThrow12;
                    z0Var.q = query.getLong(i26);
                    int i28 = columnIndexOrThrow29;
                    z0Var.i = query.getInt(i28);
                    int i29 = columnIndexOrThrow30;
                    if (query.isNull(i29)) {
                        i4 = i25;
                        string13 = null;
                    } else {
                        i4 = i25;
                        string13 = query.getString(i29);
                    }
                    z0Var.j = string13;
                    int i30 = columnIndexOrThrow31;
                    if (query.isNull(i30)) {
                        columnIndexOrThrow31 = i30;
                        string14 = null;
                    } else {
                        columnIndexOrThrow31 = i30;
                        string14 = query.getString(i30);
                    }
                    z0Var.T = string14;
                    int i31 = columnIndexOrThrow32;
                    z0Var.U = query.getInt(i31);
                    int i32 = columnIndexOrThrow33;
                    if (query.isNull(i32)) {
                        i5 = i31;
                        string15 = null;
                    } else {
                        i5 = i31;
                        string15 = query.getString(i32);
                    }
                    z0Var.k = string15;
                    int i33 = columnIndexOrThrow34;
                    z0Var.o = query.getInt(i33);
                    int i34 = columnIndexOrThrow35;
                    if (query.getInt(i34) != 0) {
                        columnIndexOrThrow34 = i33;
                        z8 = true;
                    } else {
                        columnIndexOrThrow34 = i33;
                        z8 = false;
                    }
                    z0Var.r = z8;
                    int i35 = columnIndexOrThrow36;
                    if (query.isNull(i35)) {
                        columnIndexOrThrow36 = i35;
                        string16 = null;
                    } else {
                        columnIndexOrThrow36 = i35;
                        string16 = query.getString(i35);
                    }
                    z0Var.s = string16;
                    int i36 = columnIndexOrThrow37;
                    if (query.isNull(i36)) {
                        columnIndexOrThrow37 = i36;
                        string17 = null;
                    } else {
                        columnIndexOrThrow37 = i36;
                        string17 = query.getString(i36);
                    }
                    z0Var.t = string17;
                    int i37 = columnIndexOrThrow38;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow38 = i37;
                        string18 = null;
                    } else {
                        columnIndexOrThrow38 = i37;
                        string18 = query.getString(i37);
                    }
                    z0Var.u = string18;
                    int i38 = columnIndexOrThrow39;
                    if (query.isNull(i38)) {
                        columnIndexOrThrow39 = i38;
                        string19 = null;
                    } else {
                        columnIndexOrThrow39 = i38;
                        string19 = query.getString(i38);
                    }
                    z0Var.v = string19;
                    int i39 = columnIndexOrThrow40;
                    if (query.isNull(i39)) {
                        columnIndexOrThrow35 = i34;
                        z0Var.f = null;
                    } else {
                        columnIndexOrThrow35 = i34;
                        z0Var.f = query.getString(i39);
                    }
                    int i40 = columnIndexOrThrow41;
                    if (query.isNull(i40)) {
                        i6 = i39;
                        string20 = null;
                    } else {
                        i6 = i39;
                        string20 = query.getString(i40);
                    }
                    z0Var.y = string20;
                    int i41 = columnIndexOrThrow42;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow42 = i41;
                        string21 = null;
                    } else {
                        columnIndexOrThrow42 = i41;
                        string21 = query.getString(i41);
                    }
                    z0Var.z = string21;
                    int i42 = columnIndexOrThrow43;
                    columnIndexOrThrow43 = i42;
                    if (query.getInt(i42) != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    z0Var.O = z9;
                    int i43 = columnIndexOrThrow44;
                    z0Var.P = query.getInt(i43);
                    int i44 = columnIndexOrThrow45;
                    if (query.getInt(i44) != 0) {
                        columnIndexOrThrow44 = i43;
                        z10 = true;
                    } else {
                        columnIndexOrThrow44 = i43;
                        z10 = false;
                    }
                    z0Var.Q = z10;
                    int i45 = columnIndexOrThrow46;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow46 = i45;
                        string22 = null;
                    } else {
                        columnIndexOrThrow46 = i45;
                        string22 = query.getString(i45);
                    }
                    z0Var.V = string22;
                    int i46 = columnIndexOrThrow47;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow47 = i46;
                        string23 = null;
                    } else {
                        columnIndexOrThrow47 = i46;
                        string23 = query.getString(i46);
                    }
                    z0Var.W = string23;
                    int i47 = columnIndexOrThrow48;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow48 = i47;
                        string24 = null;
                    } else {
                        columnIndexOrThrow48 = i47;
                        string24 = query.getString(i47);
                    }
                    z0Var.X = string24;
                    int i48 = columnIndexOrThrow49;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow49 = i48;
                        string25 = null;
                    } else {
                        string25 = query.getString(i48);
                        columnIndexOrThrow49 = i48;
                    }
                    z0Var.w = kr4.h.b(string25);
                    int i49 = columnIndexOrThrow50;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow50 = i49;
                        string26 = null;
                    } else {
                        columnIndexOrThrow50 = i49;
                        string26 = query.getString(i49);
                    }
                    z0Var.x = string26;
                    arrayList.add(z0Var);
                    columnIndexOrThrow45 = i44;
                    columnIndexOrThrow10 = i11;
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow16 = i14;
                    columnIndexOrThrow17 = i15;
                    columnIndexOrThrow18 = i3;
                    columnIndexOrThrow20 = i18;
                    columnIndexOrThrow14 = i10;
                    i8 = i4;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow30 = i29;
                    columnIndexOrThrow12 = i27;
                    columnIndexOrThrow28 = i26;
                    columnIndexOrThrow29 = i28;
                    columnIndexOrThrow11 = i13;
                    columnIndexOrThrow15 = i12;
                    columnIndexOrThrow2 = i9;
                    int i50 = i5;
                    columnIndexOrThrow33 = i32;
                    columnIndexOrThrow32 = i50;
                    int i51 = i6;
                    columnIndexOrThrow41 = i40;
                    columnIndexOrThrow40 = i51;
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

    @Override // nr4.q
    public List<Book> l(String... strArr) {
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
        String string5;
        String string6;
        boolean z;
        String string7;
        String string8;
        String string9;
        boolean z2;
        int i2;
        String string10;
        String string11;
        String string12;
        String string13;
        boolean z3;
        String string14;
        String string15;
        String string16;
        String string17;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3;
        String string18;
        String string19;
        String string20;
        int i4;
        String string21;
        int i5;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        String string30;
        String string31;
        String string32;
        String string33;
        String string34;
        String string35;
        boolean z7;
        String string36;
        String string37;
        String string38;
        String string39;
        boolean z8;
        String string40;
        String string41;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_book WHERE book_id IN (");
        int length = strArr.length;
        StringUtil.appendPlaceholders(newStringBuilder, length);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), length + 0);
        int i6 = 1;
        for (String str : strArr) {
            if (str == null) {
                acquire.bindNull(i6);
            } else {
                acquire.bindString(i6, str);
            }
            i6++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "genre");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "valid_in_cn_region");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "gender");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_in_bookshelf");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "op_tag");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "authorId");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "abstraction");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "readCount");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "wordNumber");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "score");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "authorizeType");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "firstChapterId");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "bookRankInfoList");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "categorySchema");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "titlePageTags");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "source");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "isEbook");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "audioThumbUri");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "listenCount");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "book_short_name");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "flight_user_selected");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "audio_thumb_url_hd");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "small_cover_url");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "book_only_tts");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "platform");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "color_audio_dominate");
            int i7 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow2)) {
                    i = columnIndexOrThrow2;
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                    i = columnIndexOrThrow2;
                }
                Book book = new Book(string);
                if (query.isNull(columnIndexOrThrow)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow);
                }
                book.author = string2;
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                book.bookName = string3;
                if (query.isNull(columnIndexOrThrow4)) {
                    book.listenBookshelfName = null;
                } else {
                    book.listenBookshelfName = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                book.coverUrl = string4;
                int i8 = columnIndexOrThrow;
                book.createTime = query.getLong(columnIndexOrThrow6);
                book.genreType = query.getInt(columnIndexOrThrow7);
                if (query.isNull(columnIndexOrThrow8)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow8);
                }
                book.genre = string5;
                if (query.isNull(columnIndexOrThrow9)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow9);
                }
                book.lengthType = string6;
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                book.isFinish = z;
                if (query.isNull(columnIndexOrThrow11)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow11);
                }
                book.lastSerialCount = string7;
                if (query.isNull(columnIndexOrThrow12)) {
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow12);
                }
                book.serialCount = string8;
                book.ttsStatus = query.getInt(columnIndexOrThrow13);
                int i9 = i7;
                if (query.isNull(i9)) {
                    string9 = null;
                } else {
                    string9 = query.getString(i9);
                }
                book.updateStatus = string9;
                int i10 = columnIndexOrThrow13;
                int i11 = columnIndexOrThrow15;
                int i12 = columnIndexOrThrow11;
                book.updateTime = query.getLong(i11);
                int i13 = columnIndexOrThrow16;
                if (query.getInt(i13) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                book.isExclusive = z2;
                int i14 = columnIndexOrThrow17;
                if (query.isNull(i14)) {
                    i2 = i9;
                    string10 = null;
                } else {
                    i2 = i9;
                    string10 = query.getString(i14);
                }
                book.iconTag = string10;
                int i15 = columnIndexOrThrow18;
                if (query.isNull(i15)) {
                    columnIndexOrThrow18 = i15;
                    string11 = null;
                } else {
                    columnIndexOrThrow18 = i15;
                    string11 = query.getString(i15);
                }
                book.recommendInfo = string11;
                int i16 = columnIndexOrThrow19;
                if (query.isNull(i16)) {
                    columnIndexOrThrow19 = i16;
                    string12 = null;
                } else {
                    columnIndexOrThrow19 = i16;
                    string12 = query.getString(i16);
                }
                book.recommendGroupId = string12;
                int i17 = columnIndexOrThrow20;
                if (query.isNull(i17)) {
                    columnIndexOrThrow20 = i17;
                    string13 = null;
                } else {
                    columnIndexOrThrow20 = i17;
                    string13 = query.getString(i17);
                }
                book.bookStatus = string13;
                int i18 = columnIndexOrThrow21;
                columnIndexOrThrow21 = i18;
                if (query.getInt(i18) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                book.validInCnRegion = z3;
                int i19 = columnIndexOrThrow22;
                if (query.isNull(i19)) {
                    columnIndexOrThrow22 = i19;
                    string14 = null;
                } else {
                    columnIndexOrThrow22 = i19;
                    string14 = query.getString(i19);
                }
                book.lastChapterTitle = string14;
                int i20 = columnIndexOrThrow23;
                if (query.isNull(i20)) {
                    columnIndexOrThrow23 = i20;
                    string15 = null;
                } else {
                    columnIndexOrThrow23 = i20;
                    string15 = query.getString(i20);
                }
                book.lastChapterUpdateTime = string15;
                int i21 = columnIndexOrThrow24;
                if (query.isNull(i21)) {
                    columnIndexOrThrow24 = i21;
                    string16 = null;
                } else {
                    columnIndexOrThrow24 = i21;
                    string16 = query.getString(i21);
                }
                book.category = string16;
                int i22 = columnIndexOrThrow25;
                if (query.isNull(i22)) {
                    columnIndexOrThrow25 = i22;
                    string17 = null;
                } else {
                    columnIndexOrThrow25 = i22;
                    string17 = query.getString(i22);
                }
                book.gender = string17;
                int i23 = columnIndexOrThrow26;
                columnIndexOrThrow26 = i23;
                if (query.getInt(i23) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                book.isInBookshelf = z4;
                int i24 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i24;
                if (query.getInt(i24) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                book.isPubPay = z5;
                int i25 = columnIndexOrThrow28;
                book.payType = query.getInt(i25);
                int i26 = columnIndexOrThrow29;
                if (query.getInt(i26) != 0) {
                    columnIndexOrThrow28 = i25;
                    z6 = true;
                } else {
                    columnIndexOrThrow28 = i25;
                    z6 = false;
                }
                book.showVipTag = z6;
                int i27 = columnIndexOrThrow30;
                if (query.isNull(i27)) {
                    columnIndexOrThrow29 = i26;
                    book.opTag = null;
                } else {
                    columnIndexOrThrow29 = i26;
                    book.opTag = query.getString(i27);
                }
                int i28 = columnIndexOrThrow31;
                if (query.isNull(i28)) {
                    i3 = i27;
                    string18 = null;
                } else {
                    i3 = i27;
                    string18 = query.getString(i28);
                }
                book.authorId = string18;
                int i29 = columnIndexOrThrow32;
                if (query.isNull(i29)) {
                    columnIndexOrThrow32 = i29;
                    string19 = null;
                } else {
                    columnIndexOrThrow32 = i29;
                    string19 = query.getString(i29);
                }
                book.abstraction = string19;
                int i30 = columnIndexOrThrow33;
                if (query.isNull(i30)) {
                    columnIndexOrThrow33 = i30;
                    string20 = null;
                } else {
                    columnIndexOrThrow33 = i30;
                    string20 = query.getString(i30);
                }
                book.readCount = string20;
                int i31 = columnIndexOrThrow34;
                book.wordNumber = query.getInt(i31);
                int i32 = columnIndexOrThrow35;
                if (query.isNull(i32)) {
                    i4 = i31;
                    string21 = null;
                } else {
                    i4 = i31;
                    string21 = query.getString(i32);
                }
                book.score = string21;
                int i33 = columnIndexOrThrow36;
                book.creationStatus = query.getInt(i33);
                int i34 = columnIndexOrThrow37;
                if (query.isNull(i34)) {
                    i5 = i33;
                    string22 = null;
                } else {
                    i5 = i33;
                    string22 = query.getString(i34);
                }
                book.authorizeType = string22;
                int i35 = columnIndexOrThrow38;
                if (query.isNull(i35)) {
                    columnIndexOrThrow38 = i35;
                    string23 = null;
                } else {
                    columnIndexOrThrow38 = i35;
                    string23 = query.getString(i35);
                }
                book.firstChapterId = string23;
                int i36 = columnIndexOrThrow39;
                if (query.isNull(i36)) {
                    columnIndexOrThrow39 = i36;
                    string24 = null;
                } else {
                    columnIndexOrThrow39 = i36;
                    string24 = query.getString(i36);
                }
                book.bookRankInfoList = string24;
                int i37 = columnIndexOrThrow40;
                if (query.isNull(i37)) {
                    columnIndexOrThrow40 = i37;
                    string25 = null;
                } else {
                    columnIndexOrThrow40 = i37;
                    string25 = query.getString(i37);
                }
                book.categorySchema = string25;
                int i38 = columnIndexOrThrow41;
                if (query.isNull(i38)) {
                    columnIndexOrThrow41 = i38;
                    string26 = null;
                } else {
                    columnIndexOrThrow41 = i38;
                    string26 = query.getString(i38);
                }
                book.titlePageTags = string26;
                int i39 = columnIndexOrThrow42;
                if (query.isNull(i39)) {
                    columnIndexOrThrow42 = i39;
                    string27 = null;
                } else {
                    columnIndexOrThrow42 = i39;
                    string27 = query.getString(i39);
                }
                book.source = string27;
                int i40 = columnIndexOrThrow43;
                if (query.isNull(i40)) {
                    columnIndexOrThrow43 = i40;
                    string28 = null;
                } else {
                    columnIndexOrThrow43 = i40;
                    string28 = query.getString(i40);
                }
                book.isEbook = string28;
                int i41 = columnIndexOrThrow44;
                if (query.isNull(i41)) {
                    columnIndexOrThrow44 = i41;
                    string29 = null;
                } else {
                    columnIndexOrThrow44 = i41;
                    string29 = query.getString(i41);
                }
                book.audioThumbUri = string29;
                int i42 = columnIndexOrThrow45;
                if (query.isNull(i42)) {
                    columnIndexOrThrow45 = i42;
                    string30 = null;
                } else {
                    columnIndexOrThrow45 = i42;
                    string30 = query.getString(i42);
                }
                book.tags = string30;
                int i43 = columnIndexOrThrow46;
                if (query.isNull(i43)) {
                    columnIndexOrThrow46 = i43;
                    string31 = null;
                } else {
                    columnIndexOrThrow46 = i43;
                    string31 = query.getString(i43);
                }
                book.listenCount = string31;
                int i44 = columnIndexOrThrow47;
                if (query.isNull(i44)) {
                    columnIndexOrThrow47 = i44;
                    string32 = null;
                } else {
                    columnIndexOrThrow47 = i44;
                    string32 = query.getString(i44);
                }
                book.colorDominate = string32;
                int i45 = columnIndexOrThrow48;
                if (query.isNull(i45)) {
                    columnIndexOrThrow48 = i45;
                    string33 = null;
                } else {
                    columnIndexOrThrow48 = i45;
                    string33 = query.getString(i45);
                }
                book.horizThumbUrl = string33;
                int i46 = columnIndexOrThrow49;
                if (query.isNull(i46)) {
                    columnIndexOrThrow49 = i46;
                    string34 = null;
                } else {
                    columnIndexOrThrow49 = i46;
                    string34 = query.getString(i46);
                }
                book.bookShortName = string34;
                int i47 = columnIndexOrThrow50;
                if (query.isNull(i47)) {
                    columnIndexOrThrow50 = i47;
                    string35 = null;
                } else {
                    columnIndexOrThrow50 = i47;
                    string35 = query.getString(i47);
                }
                book.posterId = string35;
                int i48 = columnIndexOrThrow51;
                columnIndexOrThrow51 = i48;
                if (query.getInt(i48) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                book.flightUserSelected = z7;
                int i49 = columnIndexOrThrow52;
                if (query.isNull(i49)) {
                    columnIndexOrThrow52 = i49;
                    string36 = null;
                } else {
                    columnIndexOrThrow52 = i49;
                    string36 = query.getString(i49);
                }
                book.audioThumbUrlHd = string36;
                int i50 = columnIndexOrThrow53;
                if (query.isNull(i50)) {
                    columnIndexOrThrow53 = i50;
                    string37 = null;
                } else {
                    columnIndexOrThrow53 = i50;
                    string37 = query.getString(i50);
                }
                book.smallCoverUrl = string37;
                int i51 = columnIndexOrThrow54;
                if (query.isNull(i51)) {
                    columnIndexOrThrow54 = i51;
                    string38 = null;
                } else {
                    columnIndexOrThrow54 = i51;
                    string38 = query.getString(i51);
                }
                book.relativePostSchema = string38;
                int i52 = columnIndexOrThrow55;
                if (query.isNull(i52)) {
                    columnIndexOrThrow55 = i52;
                    string39 = null;
                } else {
                    columnIndexOrThrow55 = i52;
                    string39 = query.getString(i52);
                }
                book.relativePostId = string39;
                int i53 = columnIndexOrThrow56;
                columnIndexOrThrow56 = i53;
                if (query.getInt(i53) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                book.bookOnlyTts = z8;
                int i54 = columnIndexOrThrow57;
                if (query.isNull(i54)) {
                    columnIndexOrThrow57 = i54;
                    string40 = null;
                } else {
                    columnIndexOrThrow57 = i54;
                    string40 = query.getString(i54);
                }
                book.platform = string40;
                int i55 = columnIndexOrThrow58;
                if (query.isNull(i55)) {
                    columnIndexOrThrow58 = i55;
                    string41 = null;
                } else {
                    columnIndexOrThrow58 = i55;
                    string41 = query.getString(i55);
                }
                book.colorAudioDominate = string41;
                arrayList.add(book);
                columnIndexOrThrow36 = i5;
                columnIndexOrThrow2 = i;
                columnIndexOrThrow = i8;
                columnIndexOrThrow37 = i34;
                columnIndexOrThrow16 = i13;
                columnIndexOrThrow13 = i10;
                i7 = i2;
                columnIndexOrThrow17 = i14;
                columnIndexOrThrow11 = i12;
                columnIndexOrThrow15 = i11;
                int i56 = i3;
                columnIndexOrThrow31 = i28;
                columnIndexOrThrow30 = i56;
                int i57 = i4;
                columnIndexOrThrow35 = i32;
                columnIndexOrThrow34 = i57;
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

    @Override // nr4.q
    public Book v(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        Book book;
        String string;
        int i;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z;
        String string7;
        String string8;
        String string9;
        boolean z2;
        String string10;
        String string11;
        String string12;
        String string13;
        boolean z3;
        String string14;
        String string15;
        String string16;
        String string17;
        boolean z4;
        boolean z5;
        boolean z6;
        String str2;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        String string30;
        String string31;
        String string32;
        String string33;
        String string34;
        String string35;
        boolean z7;
        String string36;
        String string37;
        String string38;
        String string39;
        boolean z8;
        String string40;
        String string41;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_book WHERE book_id = ? LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "genre");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "valid_in_cn_region");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "category");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "gender");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_in_bookshelf");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "op_tag");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "authorId");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "abstraction");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "readCount");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "wordNumber");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "authorizeType");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "firstChapterId");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "bookRankInfoList");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "categorySchema");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "titlePageTags");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "isEbook");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "audioThumbUri");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "tags");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "listenCount");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "book_short_name");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "flight_user_selected");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "audio_thumb_url_hd");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "small_cover_url");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "book_only_tts");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "platform");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "color_audio_dominate");
                if (query.moveToFirst()) {
                    if (query.isNull(columnIndexOrThrow2)) {
                        i = columnIndexOrThrow58;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                        i = columnIndexOrThrow58;
                    }
                    Book book2 = new Book(string);
                    if (query.isNull(columnIndexOrThrow)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow);
                    }
                    book2.author = string2;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    book2.bookName = string3;
                    if (query.isNull(columnIndexOrThrow4)) {
                        book2.listenBookshelfName = null;
                    } else {
                        book2.listenBookshelfName = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow5);
                    }
                    book2.coverUrl = string4;
                    book2.createTime = query.getLong(columnIndexOrThrow6);
                    book2.genreType = query.getInt(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow8);
                    }
                    book2.genre = string5;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow9);
                    }
                    book2.lengthType = string6;
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    book2.isFinish = z;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow11);
                    }
                    book2.lastSerialCount = string7;
                    if (query.isNull(columnIndexOrThrow12)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow12);
                    }
                    book2.serialCount = string8;
                    book2.ttsStatus = query.getInt(columnIndexOrThrow13);
                    if (query.isNull(columnIndexOrThrow14)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow14);
                    }
                    book2.updateStatus = string9;
                    book2.updateTime = query.getLong(columnIndexOrThrow15);
                    if (query.getInt(columnIndexOrThrow16) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    book2.isExclusive = z2;
                    if (query.isNull(columnIndexOrThrow17)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow17);
                    }
                    book2.iconTag = string10;
                    if (query.isNull(columnIndexOrThrow18)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow18);
                    }
                    book2.recommendInfo = string11;
                    if (query.isNull(columnIndexOrThrow19)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow19);
                    }
                    book2.recommendGroupId = string12;
                    if (query.isNull(columnIndexOrThrow20)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(columnIndexOrThrow20);
                    }
                    book2.bookStatus = string13;
                    if (query.getInt(columnIndexOrThrow21) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    book2.validInCnRegion = z3;
                    if (query.isNull(columnIndexOrThrow22)) {
                        string14 = null;
                    } else {
                        string14 = query.getString(columnIndexOrThrow22);
                    }
                    book2.lastChapterTitle = string14;
                    if (query.isNull(columnIndexOrThrow23)) {
                        string15 = null;
                    } else {
                        string15 = query.getString(columnIndexOrThrow23);
                    }
                    book2.lastChapterUpdateTime = string15;
                    if (query.isNull(columnIndexOrThrow24)) {
                        string16 = null;
                    } else {
                        string16 = query.getString(columnIndexOrThrow24);
                    }
                    book2.category = string16;
                    if (query.isNull(columnIndexOrThrow25)) {
                        string17 = null;
                    } else {
                        string17 = query.getString(columnIndexOrThrow25);
                    }
                    book2.gender = string17;
                    if (query.getInt(columnIndexOrThrow26) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    book2.isInBookshelf = z4;
                    if (query.getInt(columnIndexOrThrow27) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    book2.isPubPay = z5;
                    book2.payType = query.getInt(columnIndexOrThrow28);
                    if (query.getInt(columnIndexOrThrow29) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    book2.showVipTag = z6;
                    if (query.isNull(columnIndexOrThrow30)) {
                        str2 = null;
                        book2.opTag = null;
                    } else {
                        str2 = null;
                        book2.opTag = query.getString(columnIndexOrThrow30);
                    }
                    if (query.isNull(columnIndexOrThrow31)) {
                        string18 = str2;
                    } else {
                        string18 = query.getString(columnIndexOrThrow31);
                    }
                    book2.authorId = string18;
                    if (query.isNull(columnIndexOrThrow32)) {
                        string19 = str2;
                    } else {
                        string19 = query.getString(columnIndexOrThrow32);
                    }
                    book2.abstraction = string19;
                    if (query.isNull(columnIndexOrThrow33)) {
                        string20 = str2;
                    } else {
                        string20 = query.getString(columnIndexOrThrow33);
                    }
                    book2.readCount = string20;
                    book2.wordNumber = query.getInt(columnIndexOrThrow34);
                    if (query.isNull(columnIndexOrThrow35)) {
                        string21 = str2;
                    } else {
                        string21 = query.getString(columnIndexOrThrow35);
                    }
                    book2.score = string21;
                    book2.creationStatus = query.getInt(columnIndexOrThrow36);
                    if (query.isNull(columnIndexOrThrow37)) {
                        string22 = str2;
                    } else {
                        string22 = query.getString(columnIndexOrThrow37);
                    }
                    book2.authorizeType = string22;
                    if (query.isNull(columnIndexOrThrow38)) {
                        string23 = str2;
                    } else {
                        string23 = query.getString(columnIndexOrThrow38);
                    }
                    book2.firstChapterId = string23;
                    if (query.isNull(columnIndexOrThrow39)) {
                        string24 = str2;
                    } else {
                        string24 = query.getString(columnIndexOrThrow39);
                    }
                    book2.bookRankInfoList = string24;
                    if (query.isNull(columnIndexOrThrow40)) {
                        string25 = str2;
                    } else {
                        string25 = query.getString(columnIndexOrThrow40);
                    }
                    book2.categorySchema = string25;
                    if (query.isNull(columnIndexOrThrow41)) {
                        string26 = str2;
                    } else {
                        string26 = query.getString(columnIndexOrThrow41);
                    }
                    book2.titlePageTags = string26;
                    if (query.isNull(columnIndexOrThrow42)) {
                        string27 = str2;
                    } else {
                        string27 = query.getString(columnIndexOrThrow42);
                    }
                    book2.source = string27;
                    if (query.isNull(columnIndexOrThrow43)) {
                        string28 = str2;
                    } else {
                        string28 = query.getString(columnIndexOrThrow43);
                    }
                    book2.isEbook = string28;
                    if (query.isNull(columnIndexOrThrow44)) {
                        string29 = str2;
                    } else {
                        string29 = query.getString(columnIndexOrThrow44);
                    }
                    book2.audioThumbUri = string29;
                    if (query.isNull(columnIndexOrThrow45)) {
                        string30 = str2;
                    } else {
                        string30 = query.getString(columnIndexOrThrow45);
                    }
                    book2.tags = string30;
                    if (query.isNull(columnIndexOrThrow46)) {
                        string31 = str2;
                    } else {
                        string31 = query.getString(columnIndexOrThrow46);
                    }
                    book2.listenCount = string31;
                    if (query.isNull(columnIndexOrThrow47)) {
                        string32 = str2;
                    } else {
                        string32 = query.getString(columnIndexOrThrow47);
                    }
                    book2.colorDominate = string32;
                    if (query.isNull(columnIndexOrThrow48)) {
                        string33 = str2;
                    } else {
                        string33 = query.getString(columnIndexOrThrow48);
                    }
                    book2.horizThumbUrl = string33;
                    if (query.isNull(columnIndexOrThrow49)) {
                        string34 = str2;
                    } else {
                        string34 = query.getString(columnIndexOrThrow49);
                    }
                    book2.bookShortName = string34;
                    if (query.isNull(columnIndexOrThrow50)) {
                        string35 = str2;
                    } else {
                        string35 = query.getString(columnIndexOrThrow50);
                    }
                    book2.posterId = string35;
                    if (query.getInt(columnIndexOrThrow51) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    book2.flightUserSelected = z7;
                    if (query.isNull(columnIndexOrThrow52)) {
                        string36 = str2;
                    } else {
                        string36 = query.getString(columnIndexOrThrow52);
                    }
                    book2.audioThumbUrlHd = string36;
                    if (query.isNull(columnIndexOrThrow53)) {
                        string37 = str2;
                    } else {
                        string37 = query.getString(columnIndexOrThrow53);
                    }
                    book2.smallCoverUrl = string37;
                    if (query.isNull(columnIndexOrThrow54)) {
                        string38 = str2;
                    } else {
                        string38 = query.getString(columnIndexOrThrow54);
                    }
                    book2.relativePostSchema = string38;
                    if (query.isNull(columnIndexOrThrow55)) {
                        string39 = str2;
                    } else {
                        string39 = query.getString(columnIndexOrThrow55);
                    }
                    book2.relativePostId = string39;
                    if (query.getInt(columnIndexOrThrow56) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    book2.bookOnlyTts = z8;
                    if (query.isNull(columnIndexOrThrow57)) {
                        string40 = str2;
                    } else {
                        string40 = query.getString(columnIndexOrThrow57);
                    }
                    book2.platform = string40;
                    int i2 = i;
                    if (query.isNull(i2)) {
                        string41 = str2;
                    } else {
                        string41 = query.getString(i2);
                    }
                    book2.colorAudioDominate = string41;
                    book = book2;
                } else {
                    book = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return book;
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

    class a extends EntityInsertionAdapter<Book> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_book` (`author`,`book_id`,`name`,`listen_bookshelf_name`,`cover_url`,`create_time`,`genre_type`,`genre`,`length_type`,`is_finish`,`last_serial_count`,`serial_count`,`tts_status`,`update_status`,`update_time`,`is_exclusive`,`icon_tag`,`recommend_info`,`recommend_group_id`,`book_status`,`valid_in_cn_region`,`last_chapter_title`,`last_chapter_update_time`,`category`,`gender`,`is_in_bookshelf`,`is_pub_pay`,`pay_type`,`show_vip_tag`,`op_tag`,`authorId`,`abstraction`,`readCount`,`wordNumber`,`score`,`creationStatus`,`authorizeType`,`firstChapterId`,`bookRankInfoList`,`categorySchema`,`titlePageTags`,`source`,`isEbook`,`audioThumbUri`,`tags`,`listenCount`,`color_dominate`,`horiz_thumb_url`,`book_short_name`,`poster_id`,`flight_user_selected`,`audio_thumb_url_hd`,`small_cover_url`,`relative_post_schema`,`relative_post_id`,`book_only_tts`,`platform`,`color_audio_dominate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, Book book) {
            String str = book.author;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = book.bookId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = book.bookName;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = book.listenBookshelfName;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            String str5 = book.coverUrl;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str5);
            }
            supportSQLiteStatement.bindLong(6, book.createTime);
            supportSQLiteStatement.bindLong(7, book.genreType);
            String str6 = book.genre;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str6);
            }
            String str7 = book.lengthType;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str7);
            }
            supportSQLiteStatement.bindLong(10, book.isFinish ? 1L : 0L);
            String str8 = book.lastSerialCount;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str8);
            }
            String str9 = book.serialCount;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str9);
            }
            supportSQLiteStatement.bindLong(13, book.ttsStatus);
            String str10 = book.updateStatus;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str10);
            }
            supportSQLiteStatement.bindLong(15, book.updateTime);
            supportSQLiteStatement.bindLong(16, book.isExclusive ? 1L : 0L);
            String str11 = book.iconTag;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str11);
            }
            String str12 = book.recommendInfo;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str12);
            }
            String str13 = book.recommendGroupId;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str13);
            }
            String str14 = book.bookStatus;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str14);
            }
            supportSQLiteStatement.bindLong(21, book.validInCnRegion ? 1L : 0L);
            String str15 = book.lastChapterTitle;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str15);
            }
            String str16 = book.lastChapterUpdateTime;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str16);
            }
            String str17 = book.category;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str17);
            }
            String str18 = book.gender;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str18);
            }
            supportSQLiteStatement.bindLong(26, book.isInBookshelf ? 1L : 0L);
            supportSQLiteStatement.bindLong(27, book.isPubPay ? 1L : 0L);
            supportSQLiteStatement.bindLong(28, book.payType);
            supportSQLiteStatement.bindLong(29, book.showVipTag ? 1L : 0L);
            String str19 = book.opTag;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str19);
            }
            String str20 = book.authorId;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str20);
            }
            String str21 = book.abstraction;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str21);
            }
            String str22 = book.readCount;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str22);
            }
            supportSQLiteStatement.bindLong(34, book.wordNumber);
            String str23 = book.score;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str23);
            }
            supportSQLiteStatement.bindLong(36, book.creationStatus);
            String str24 = book.authorizeType;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str24);
            }
            String str25 = book.firstChapterId;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str25);
            }
            String str26 = book.bookRankInfoList;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str26);
            }
            String str27 = book.categorySchema;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str27);
            }
            String str28 = book.titlePageTags;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str28);
            }
            String str29 = book.source;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str29);
            }
            String str30 = book.isEbook;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str30);
            }
            String str31 = book.audioThumbUri;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str31);
            }
            String str32 = book.tags;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str32);
            }
            String str33 = book.listenCount;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str33);
            }
            String str34 = book.colorDominate;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str34);
            }
            String str35 = book.horizThumbUrl;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str35);
            }
            String str36 = book.bookShortName;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str36);
            }
            String str37 = book.posterId;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str37);
            }
            supportSQLiteStatement.bindLong(51, book.flightUserSelected ? 1L : 0L);
            String str38 = book.audioThumbUrlHd;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str38);
            }
            String str39 = book.smallCoverUrl;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str39);
            }
            String str40 = book.relativePostSchema;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str40);
            }
            String str41 = book.relativePostId;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str41);
            }
            supportSQLiteStatement.bindLong(56, book.bookOnlyTts ? 1L : 0L);
            String str42 = book.platform;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str42);
            }
            String str43 = book.colorAudioDominate;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindString(58, str43);
            }
        }
    }

    class b extends EntityInsertionAdapter<lr4.q> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_bookshelf` (`add_type`,`create_time`,`update_time`,`book_id`,`book_type`,`booklist_name`,`is_sync`,`is_delete`,`booklist_operate_time`,`is_pinned`,`pinned_time`,`booklist_id`,`is_asterisked`,`is_chased_updates`,`add_bookshelf_time_sec`,`is_preheat_book_pinned`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.q qVar) {
            supportSQLiteStatement.bindLong(1, qVar.a);
            supportSQLiteStatement.bindLong(2, qVar.b);
            supportSQLiteStatement.bindLong(3, qVar.c);
            if (qVar.a() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, qVar.a());
            }
            if (kr4.b.a(qVar.e) == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, r0.intValue());
            }
            String str = qVar.f;
            if (str == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str);
            }
            supportSQLiteStatement.bindLong(7, qVar.g ? 1L : 0L);
            supportSQLiteStatement.bindLong(8, qVar.h ? 1L : 0L);
            supportSQLiteStatement.bindLong(9, qVar.i);
            supportSQLiteStatement.bindLong(10, qVar.j ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, qVar.k);
            supportSQLiteStatement.bindLong(12, qVar.l);
            supportSQLiteStatement.bindLong(13, qVar.m ? 1L : 0L);
            supportSQLiteStatement.bindLong(14, qVar.n ? 1L : 0L);
            supportSQLiteStatement.bindLong(15, qVar.o);
            supportSQLiteStatement.bindLong(16, qVar.p ? 1L : 0L);
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<Book> {
        public String createQuery() {
            return "DELETE FROM `t_book` WHERE `book_id` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, Book book) {
            String str = book.bookId;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class d extends EntityDeletionOrUpdateAdapter<lr4.q> {
        public String createQuery() {
            return "DELETE FROM `t_bookshelf` WHERE `book_id` = ? AND `book_type` = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.q qVar) {
            if (qVar.a() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, qVar.a());
            }
            if (kr4.b.a(qVar.e) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r5.intValue());
            }
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_bookshelf";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // nr4.q
    public lr4.q a(String str, BookType bookType) {
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
        lr4.q qVar;
        String string;
        Integer valueOf;
        String string2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_bookshelf  WHERE book_id = ? AND book_type = ? LIMIT 1", 2);
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
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "add_type");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "booklist_name");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_pinned");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "pinned_time");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "booklist_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "is_asterisked");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_chased_updates");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "add_bookshelf_time_sec");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_preheat_book_pinned");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow4)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                }
                lr4.q qVar2 = new lr4.q(string, kr4.b.b(valueOf));
                qVar2.a = query.getInt(columnIndexOrThrow);
                qVar2.b = query.getLong(columnIndexOrThrow2);
                qVar2.c = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow6)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow6);
                }
                qVar2.f = string2;
                if (query.getInt(columnIndexOrThrow7) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                qVar2.g = z;
                if (query.getInt(columnIndexOrThrow8) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                qVar2.h = z2;
                qVar2.i = query.getLong(columnIndexOrThrow9);
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                qVar2.j = z3;
                qVar2.k = query.getLong(columnIndexOrThrow11);
                qVar2.l = query.getLong(columnIndexOrThrow12);
                if (query.getInt(columnIndexOrThrow13) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                qVar2.m = z4;
                if (query.getInt(columnIndexOrThrow14) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                qVar2.n = z5;
                qVar2.o = query.getLong(columnIndexOrThrow15);
                if (query.getInt(columnIndexOrThrow16) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                qVar2.p = z6;
                qVar = qVar2;
            } else {
                qVar = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return qVar;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
