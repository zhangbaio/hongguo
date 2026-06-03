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
import com.dragon.read.local.db.entity.RecordModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 implements z {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.i> b;
    private final EntityDeletionOrUpdateAdapter<lr4.i> c;
    private final SharedSQLiteStatement d;
    private final SharedSQLiteStatement e;

    static {
        Covode.recordClassIndex(611658);
    }

    public static List<Class<?>> m() {
        return Collections.emptyList();
    }

    @Override // nr4.z
    public List<lr4.i> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
        int i;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        boolean z3;
        int i2;
        String string6;
        String string7;
        String string8;
        boolean z4;
        int i3;
        String string9;
        String string10;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_book_record ORDER BY read_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "resource");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "platform_book_id");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "total_read_time");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_time");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_word_num");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow7)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        i = columnIndexOrThrow7;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                        i = columnIndexOrThrow7;
                    }
                    BookType b2 = kr4.b.b(valueOf);
                    int i5 = columnIndexOrThrow8;
                    lr4.i iVar = new lr4.i(string, b2);
                    if (query.isNull(columnIndexOrThrow)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow);
                    }
                    iVar.a = string2;
                    if (query.isNull(columnIndexOrThrow2)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow2);
                    }
                    iVar.b = string3;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow3);
                    }
                    iVar.c = string4;
                    iVar.d = query.getInt(columnIndexOrThrow4);
                    iVar.e = query.getInt(columnIndexOrThrow5);
                    int i6 = columnIndexOrThrow;
                    iVar.f = query.getLong(columnIndexOrThrow6);
                    iVar.i = query.getLong(columnIndexOrThrow9);
                    iVar.j = query.getLong(columnIndexOrThrow10);
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar.k = z;
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    iVar.l = z2;
                    if (query.isNull(columnIndexOrThrow13)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow13);
                    }
                    iVar.m = string5;
                    int i7 = i4;
                    if (query.getInt(i7) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    iVar.n = z3;
                    int i8 = columnIndexOrThrow15;
                    iVar.o = query.getInt(i8);
                    int i9 = columnIndexOrThrow16;
                    if (query.isNull(i9)) {
                        i2 = i9;
                        string6 = null;
                    } else {
                        i2 = i9;
                        string6 = query.getString(i9);
                    }
                    iVar.p = string6;
                    int i10 = columnIndexOrThrow17;
                    if (query.isNull(i10)) {
                        columnIndexOrThrow17 = i10;
                        string7 = null;
                    } else {
                        columnIndexOrThrow17 = i10;
                        string7 = query.getString(i10);
                    }
                    iVar.q = string7;
                    int i11 = columnIndexOrThrow18;
                    if (query.isNull(i11)) {
                        columnIndexOrThrow18 = i11;
                        string8 = null;
                    } else {
                        string8 = query.getString(i11);
                        columnIndexOrThrow18 = i11;
                    }
                    iVar.r = kr4.g.b(string8);
                    int i12 = columnIndexOrThrow19;
                    columnIndexOrThrow19 = i12;
                    if (query.getInt(i12) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    iVar.u = z4;
                    int i13 = columnIndexOrThrow20;
                    iVar.v = query.getInt(i13);
                    int i14 = columnIndexOrThrow21;
                    if (query.isNull(i14)) {
                        i3 = i13;
                        string9 = null;
                    } else {
                        i3 = i13;
                        string9 = query.getString(i14);
                    }
                    iVar.w = string9;
                    int i15 = columnIndexOrThrow12;
                    int i16 = columnIndexOrThrow22;
                    iVar.x = query.getLong(i16);
                    int i17 = columnIndexOrThrow23;
                    if (query.isNull(i17)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(i17);
                    }
                    iVar.y = string10;
                    int i18 = columnIndexOrThrow24;
                    iVar.z = query.getLong(i18);
                    int i19 = columnIndexOrThrow25;
                    iVar.A = query.getLong(i19);
                    int i20 = columnIndexOrThrow2;
                    int i21 = columnIndexOrThrow26;
                    int i22 = columnIndexOrThrow3;
                    iVar.B = query.getLong(i21);
                    arrayList.add(iVar);
                    columnIndexOrThrow2 = i20;
                    i4 = i7;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow12 = i15;
                    columnIndexOrThrow20 = i3;
                    columnIndexOrThrow21 = i14;
                    columnIndexOrThrow22 = i16;
                    columnIndexOrThrow23 = i17;
                    columnIndexOrThrow24 = i18;
                    columnIndexOrThrow3 = i22;
                    columnIndexOrThrow8 = i5;
                    columnIndexOrThrow16 = i2;
                    columnIndexOrThrow25 = i19;
                    columnIndexOrThrow26 = i21;
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow7 = i;
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

    @Override // nr4.z
    public List<RecordModel> k() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
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
        int i2;
        String string11;
        int i3;
        String string12;
        int i4;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        int i5;
        String string21;
        String string22;
        boolean z3;
        boolean z4;
        boolean z5;
        String string23;
        int i6;
        String string24;
        int i7;
        String string25;
        String string26;
        String string27;
        boolean z6;
        int i8;
        String string28;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT b.serial_count,b.color_dominate, b.horiz_thumb_url, b.tags, b.creationStatus, b.update_status, b.show_vip_tag,b.last_serial_count, b.last_chapter_update_time, b.last_chapter_title,b.is_exclusive, b.icon_tag, b.book_status, b.relative_post_schema, b.relative_post_id, b.poster_id, b.platform, b.authorizeType, b.op_tag, a.book_id,a.book_type,a.author_name,a.book_name AS name,a.cover_url,a.genre_type,b.genre,b.length_type,a.tts_status,a.read_time, a.update_time, a.is_delete, a.is_finish, a.has_sync, b.listen_bookshelf_name,c.relative_audio_book_id_set,c.relative_novel_book_id,a.recent_read_count, a.score, a.source, a.page_info, b.is_pub_pay, b.pay_type, b.audioThumbUri FROM t_book_record AS a LEFT JOIN t_book AS b ON a.book_id == b.book_id LEFT JOIN t_relative_book_id AS c ON a.book_id = c.id AND a.book_type = c.book_type ORDER BY a.read_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "platform");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "authorizeType");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "op_tag");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
                int i9 = columnIndexOrThrow14;
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int i10 = columnIndexOrThrow13;
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "genre");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "audioThumbUri");
                int i11 = columnIndexOrThrow12;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow20)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow20);
                    }
                    if (query.isNull(columnIndexOrThrow21)) {
                        i = columnIndexOrThrow21;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow21));
                        i = columnIndexOrThrow21;
                    }
                    BookType b2 = kr4.b.b(valueOf);
                    int i12 = columnIndexOrThrow20;
                    RecordModel recordModel = new RecordModel(string, b2);
                    if (query.isNull(columnIndexOrThrow)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow);
                    }
                    recordModel.setSerialCount(string2);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow2);
                    }
                    recordModel.setColorDominate(string3);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow3);
                    }
                    recordModel.setHorizThumbUrl(string4);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow4);
                    }
                    recordModel.setCategoryTags(string5);
                    recordModel.setCreationStatus(query.getInt(columnIndexOrThrow5));
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    recordModel.setUpdateStatus(string6);
                    if (query.getInt(columnIndexOrThrow7) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    recordModel.setShowVipTag(z);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow8);
                    }
                    recordModel.setLastSerialCount(string7);
                    if (query.isNull(columnIndexOrThrow9)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow9);
                    }
                    recordModel.setLastChapterUpdateTime(string8);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    recordModel.setLastChapterTitle(string9);
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    recordModel.setExclusive(z2);
                    int i13 = i11;
                    if (query.isNull(i13)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(i13);
                    }
                    recordModel.setIconTag(string10);
                    int i14 = i10;
                    if (query.isNull(i14)) {
                        i2 = columnIndexOrThrow;
                        string11 = null;
                    } else {
                        i2 = columnIndexOrThrow;
                        string11 = query.getString(i14);
                    }
                    recordModel.setStatus(string11);
                    int i15 = i9;
                    if (query.isNull(i15)) {
                        i3 = i15;
                        string12 = null;
                    } else {
                        i3 = i15;
                        string12 = query.getString(i15);
                    }
                    recordModel.setRelativePostSchema(string12);
                    int i16 = columnIndexOrThrow15;
                    if (query.isNull(i16)) {
                        i4 = i16;
                        string13 = null;
                    } else {
                        i4 = i16;
                        string13 = query.getString(i16);
                    }
                    recordModel.setRelativePostId(string13);
                    int i17 = columnIndexOrThrow16;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow16 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow16 = i17;
                        string14 = query.getString(i17);
                    }
                    recordModel.setPosterId(string14);
                    int i18 = columnIndexOrThrow17;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow17 = i18;
                        string15 = null;
                    } else {
                        columnIndexOrThrow17 = i18;
                        string15 = query.getString(i18);
                    }
                    recordModel.setPlatform(string15);
                    int i19 = columnIndexOrThrow18;
                    if (query.isNull(i19)) {
                        columnIndexOrThrow18 = i19;
                        string16 = null;
                    } else {
                        columnIndexOrThrow18 = i19;
                        string16 = query.getString(i19);
                    }
                    recordModel.setAuthorizeType(string16);
                    int i20 = columnIndexOrThrow19;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow19 = i20;
                        string17 = null;
                    } else {
                        columnIndexOrThrow19 = i20;
                        string17 = query.getString(i20);
                    }
                    recordModel.setOpTag(string17);
                    int i21 = columnIndexOrThrow22;
                    if (query.isNull(i21)) {
                        columnIndexOrThrow22 = i21;
                        string18 = null;
                    } else {
                        columnIndexOrThrow22 = i21;
                        string18 = query.getString(i21);
                    }
                    recordModel.setAuthor(string18);
                    int i22 = columnIndexOrThrow23;
                    if (query.isNull(i22)) {
                        columnIndexOrThrow23 = i22;
                        string19 = null;
                    } else {
                        columnIndexOrThrow23 = i22;
                        string19 = query.getString(i22);
                    }
                    recordModel.setBookName(string19);
                    int i23 = columnIndexOrThrow24;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow24 = i23;
                        string20 = null;
                    } else {
                        columnIndexOrThrow24 = i23;
                        string20 = query.getString(i23);
                    }
                    recordModel.setCoverUrl(string20);
                    int i24 = columnIndexOrThrow25;
                    recordModel.setGenreType(query.getInt(i24));
                    int i25 = columnIndexOrThrow26;
                    if (query.isNull(i25)) {
                        i5 = i24;
                        string21 = null;
                    } else {
                        i5 = i24;
                        string21 = query.getString(i25);
                    }
                    recordModel.setGenre(string21);
                    int i26 = columnIndexOrThrow27;
                    if (query.isNull(i26)) {
                        columnIndexOrThrow27 = i26;
                        string22 = null;
                    } else {
                        columnIndexOrThrow27 = i26;
                        string22 = query.getString(i26);
                    }
                    recordModel.setLengthType(string22);
                    int i27 = columnIndexOrThrow28;
                    recordModel.setTtsStatus(query.getInt(i27));
                    int i28 = columnIndexOrThrow2;
                    int i29 = columnIndexOrThrow29;
                    int i30 = columnIndexOrThrow3;
                    recordModel.setReadTime(query.getLong(i29));
                    int i31 = columnIndexOrThrow30;
                    recordModel.setUpdateTime(query.getLong(i31));
                    int i32 = columnIndexOrThrow31;
                    if (query.getInt(i32) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    recordModel.setDelete(z3);
                    int i33 = columnIndexOrThrow32;
                    if (query.getInt(i33) != 0) {
                        columnIndexOrThrow31 = i32;
                        z4 = true;
                    } else {
                        columnIndexOrThrow31 = i32;
                        z4 = false;
                    }
                    recordModel.setFinish(z4);
                    int i34 = columnIndexOrThrow33;
                    columnIndexOrThrow33 = i34;
                    if (query.getInt(i34) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    recordModel.setHasSync(z5);
                    int i35 = columnIndexOrThrow34;
                    if (query.isNull(i35)) {
                        columnIndexOrThrow32 = i33;
                        recordModel.listenBookshelfName = null;
                    } else {
                        columnIndexOrThrow32 = i33;
                        recordModel.listenBookshelfName = query.getString(i35);
                    }
                    int i36 = columnIndexOrThrow35;
                    if (query.isNull(i36)) {
                        i6 = i35;
                        string23 = null;
                    } else {
                        string23 = query.getString(i36);
                        i6 = i35;
                    }
                    recordModel.setRelativeAudioBookSet(kr4.h.b(string23));
                    int i37 = columnIndexOrThrow36;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow36 = i37;
                        string24 = null;
                    } else {
                        columnIndexOrThrow36 = i37;
                        string24 = query.getString(i37);
                    }
                    recordModel.setRelativeNovelBookId(string24);
                    int i38 = columnIndexOrThrow37;
                    recordModel.setRecentReadCount(query.getInt(i38));
                    int i39 = columnIndexOrThrow38;
                    if (query.isNull(i39)) {
                        i7 = i38;
                        string25 = null;
                    } else {
                        i7 = i38;
                        string25 = query.getString(i39);
                    }
                    recordModel.setScore(string25);
                    int i40 = columnIndexOrThrow39;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow39 = i40;
                        string26 = null;
                    } else {
                        columnIndexOrThrow39 = i40;
                        string26 = query.getString(i40);
                    }
                    recordModel.setSource(string26);
                    int i41 = columnIndexOrThrow40;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow40 = i41;
                        string27 = null;
                    } else {
                        string27 = query.getString(i41);
                        columnIndexOrThrow40 = i41;
                    }
                    recordModel.setPageInfo(kr4.g.b(string27));
                    int i42 = columnIndexOrThrow41;
                    columnIndexOrThrow41 = i42;
                    if (query.getInt(i42) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    recordModel.setPubPay(z6);
                    int i43 = columnIndexOrThrow42;
                    recordModel.setPayType(query.getInt(i43));
                    int i44 = columnIndexOrThrow43;
                    if (query.isNull(i44)) {
                        i8 = i43;
                        string28 = null;
                    } else {
                        i8 = i43;
                        string28 = query.getString(i44);
                    }
                    recordModel.setAudioCover(string28);
                    arrayList.add(recordModel);
                    columnIndexOrThrow42 = i8;
                    columnIndexOrThrow = i2;
                    columnIndexOrThrow20 = i12;
                    columnIndexOrThrow43 = i44;
                    i11 = i13;
                    columnIndexOrThrow15 = i4;
                    i9 = i3;
                    columnIndexOrThrow21 = i;
                    i10 = i14;
                    columnIndexOrThrow30 = i31;
                    columnIndexOrThrow2 = i28;
                    columnIndexOrThrow28 = i27;
                    columnIndexOrThrow3 = i30;
                    columnIndexOrThrow29 = i29;
                    int i45 = i5;
                    columnIndexOrThrow26 = i25;
                    columnIndexOrThrow25 = i45;
                    int i46 = i6;
                    columnIndexOrThrow35 = i36;
                    columnIndexOrThrow34 = i46;
                    int i47 = i7;
                    columnIndexOrThrow38 = i39;
                    columnIndexOrThrow37 = i47;
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

    public b0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    @Override // nr4.z
    public Long[] g(lr4.i... iVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(iVarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.z
    public int l(lr4.i... iVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handleMultiple = this.c.handleMultiple(iVarArr) + 0;
            this.a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.z
    public List<lr4.i> e(BookType bookType) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
        int i;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        boolean z3;
        String string6;
        String string7;
        String string8;
        boolean z4;
        int i2;
        String string9;
        String string10;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_book_record WHERE book_type = (?) ORDER BY read_time DESC", 1);
        if (kr4.b.a(bookType) == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindLong(1, r0.intValue());
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "resource");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "platform_book_id");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "total_read_time");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_time");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_word_num");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow7)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        i = columnIndexOrThrow7;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                        i = columnIndexOrThrow7;
                    }
                    BookType b2 = kr4.b.b(valueOf);
                    int i4 = columnIndexOrThrow8;
                    lr4.i iVar = new lr4.i(string, b2);
                    if (query.isNull(columnIndexOrThrow)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow);
                    }
                    iVar.a = string2;
                    if (query.isNull(columnIndexOrThrow2)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow2);
                    }
                    iVar.b = string3;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow3);
                    }
                    iVar.c = string4;
                    iVar.d = query.getInt(columnIndexOrThrow4);
                    iVar.e = query.getInt(columnIndexOrThrow5);
                    int i5 = columnIndexOrThrow;
                    iVar.f = query.getLong(columnIndexOrThrow6);
                    iVar.i = query.getLong(columnIndexOrThrow9);
                    iVar.j = query.getLong(columnIndexOrThrow10);
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar.k = z;
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    iVar.l = z2;
                    if (query.isNull(columnIndexOrThrow13)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow13);
                    }
                    iVar.m = string5;
                    int i6 = i3;
                    if (query.getInt(i6) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    iVar.n = z3;
                    i3 = i6;
                    int i7 = columnIndexOrThrow15;
                    iVar.o = query.getInt(i7);
                    int i8 = columnIndexOrThrow16;
                    if (query.isNull(i8)) {
                        columnIndexOrThrow16 = i8;
                        string6 = null;
                    } else {
                        columnIndexOrThrow16 = i8;
                        string6 = query.getString(i8);
                    }
                    iVar.p = string6;
                    int i9 = columnIndexOrThrow17;
                    if (query.isNull(i9)) {
                        columnIndexOrThrow17 = i9;
                        string7 = null;
                    } else {
                        columnIndexOrThrow17 = i9;
                        string7 = query.getString(i9);
                    }
                    iVar.q = string7;
                    int i10 = columnIndexOrThrow18;
                    if (query.isNull(i10)) {
                        columnIndexOrThrow18 = i10;
                        string8 = null;
                    } else {
                        string8 = query.getString(i10);
                        columnIndexOrThrow18 = i10;
                    }
                    iVar.r = kr4.g.b(string8);
                    int i11 = columnIndexOrThrow19;
                    columnIndexOrThrow19 = i11;
                    if (query.getInt(i11) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    iVar.u = z4;
                    columnIndexOrThrow15 = i7;
                    int i12 = columnIndexOrThrow20;
                    iVar.v = query.getInt(i12);
                    int i13 = columnIndexOrThrow21;
                    if (query.isNull(i13)) {
                        i2 = i12;
                        string9 = null;
                    } else {
                        i2 = i12;
                        string9 = query.getString(i13);
                    }
                    iVar.w = string9;
                    int i14 = columnIndexOrThrow11;
                    int i15 = columnIndexOrThrow22;
                    iVar.x = query.getLong(i15);
                    int i16 = columnIndexOrThrow23;
                    if (query.isNull(i16)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(i16);
                    }
                    iVar.y = string10;
                    int i17 = columnIndexOrThrow24;
                    iVar.z = query.getLong(i17);
                    int i18 = columnIndexOrThrow25;
                    iVar.A = query.getLong(i18);
                    int i19 = columnIndexOrThrow12;
                    int i20 = columnIndexOrThrow26;
                    int i21 = columnIndexOrThrow13;
                    iVar.B = query.getLong(i20);
                    arrayList.add(iVar);
                    columnIndexOrThrow12 = i19;
                    columnIndexOrThrow11 = i14;
                    columnIndexOrThrow20 = i2;
                    columnIndexOrThrow21 = i13;
                    columnIndexOrThrow22 = i15;
                    columnIndexOrThrow23 = i16;
                    columnIndexOrThrow24 = i17;
                    columnIndexOrThrow13 = i21;
                    columnIndexOrThrow8 = i4;
                    columnIndexOrThrow25 = i18;
                    columnIndexOrThrow26 = i20;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow7 = i;
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

    @Override // nr4.z
    public List<lr4.i> i(List<String> list) {
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
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        boolean z3;
        String string6;
        String string7;
        String string8;
        boolean z4;
        int i2;
        String string9;
        String string10;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_book_record WHERE book_id in (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i3 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str);
            }
            i3++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "resource");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "score");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "source");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "platform_book_id");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "total_read_time");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_time");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_word_num");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow7)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    i = columnIndexOrThrow7;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    i = columnIndexOrThrow7;
                }
                BookType b2 = kr4.b.b(valueOf);
                int i5 = columnIndexOrThrow8;
                lr4.i iVar = new lr4.i(string, b2);
                if (query.isNull(columnIndexOrThrow)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow);
                }
                iVar.a = string2;
                if (query.isNull(columnIndexOrThrow2)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow2);
                }
                iVar.b = string3;
                if (query.isNull(columnIndexOrThrow3)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow3);
                }
                iVar.c = string4;
                iVar.d = query.getInt(columnIndexOrThrow4);
                iVar.e = query.getInt(columnIndexOrThrow5);
                int i6 = columnIndexOrThrow;
                iVar.f = query.getLong(columnIndexOrThrow6);
                iVar.i = query.getLong(columnIndexOrThrow9);
                iVar.j = query.getLong(columnIndexOrThrow10);
                if (query.getInt(columnIndexOrThrow11) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                iVar.k = z;
                if (query.getInt(columnIndexOrThrow12) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                iVar.l = z2;
                if (query.isNull(columnIndexOrThrow13)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow13);
                }
                iVar.m = string5;
                int i7 = i4;
                if (query.getInt(i7) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                iVar.n = z3;
                i4 = i7;
                int i8 = columnIndexOrThrow15;
                iVar.o = query.getInt(i8);
                int i9 = columnIndexOrThrow16;
                if (query.isNull(i9)) {
                    columnIndexOrThrow16 = i9;
                    string6 = null;
                } else {
                    columnIndexOrThrow16 = i9;
                    string6 = query.getString(i9);
                }
                iVar.p = string6;
                int i10 = columnIndexOrThrow17;
                if (query.isNull(i10)) {
                    columnIndexOrThrow17 = i10;
                    string7 = null;
                } else {
                    columnIndexOrThrow17 = i10;
                    string7 = query.getString(i10);
                }
                iVar.q = string7;
                int i11 = columnIndexOrThrow18;
                if (query.isNull(i11)) {
                    columnIndexOrThrow18 = i11;
                    string8 = null;
                } else {
                    string8 = query.getString(i11);
                    columnIndexOrThrow18 = i11;
                }
                iVar.r = kr4.g.b(string8);
                int i12 = columnIndexOrThrow19;
                columnIndexOrThrow19 = i12;
                if (query.getInt(i12) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                iVar.u = z4;
                columnIndexOrThrow15 = i8;
                int i13 = columnIndexOrThrow20;
                iVar.v = query.getInt(i13);
                int i14 = columnIndexOrThrow21;
                if (query.isNull(i14)) {
                    i2 = i13;
                    string9 = null;
                } else {
                    i2 = i13;
                    string9 = query.getString(i14);
                }
                iVar.w = string9;
                int i15 = columnIndexOrThrow11;
                int i16 = columnIndexOrThrow22;
                int i17 = columnIndexOrThrow12;
                iVar.x = query.getLong(i16);
                int i18 = columnIndexOrThrow23;
                if (query.isNull(i18)) {
                    string10 = null;
                } else {
                    string10 = query.getString(i18);
                }
                iVar.y = string10;
                int i19 = columnIndexOrThrow24;
                iVar.z = query.getLong(i19);
                int i20 = columnIndexOrThrow25;
                iVar.A = query.getLong(i20);
                int i21 = columnIndexOrThrow26;
                iVar.B = query.getLong(i21);
                arrayList.add(iVar);
                columnIndexOrThrow = i6;
                columnIndexOrThrow8 = i5;
                columnIndexOrThrow7 = i;
                columnIndexOrThrow26 = i21;
                columnIndexOrThrow11 = i15;
                columnIndexOrThrow20 = i2;
                columnIndexOrThrow21 = i14;
                columnIndexOrThrow23 = i18;
                columnIndexOrThrow25 = i20;
                columnIndexOrThrow12 = i17;
                columnIndexOrThrow22 = i16;
                columnIndexOrThrow24 = i19;
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

    @Override // nr4.z
    public RecordModel f(boolean z) {
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
        RecordModel recordModel;
        String string;
        Integer valueOf;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z2;
        String string7;
        String string8;
        String string9;
        boolean z3;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        boolean z7;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT b.serial_count,b.color_dominate, b.horiz_thumb_url, b.tags, b.creationStatus, b.update_status, b.show_vip_tag, b.last_serial_count, b.last_chapter_update_time, b.last_chapter_title, b.is_exclusive, b.icon_tag, b.book_status,a.book_id,a.book_type,a.author_name,b.name,a.cover_url,a.genre_type,b.genre,b.length_type,a.tts_status,a.read_time, a.update_time, a.is_delete, a.is_finish, a.has_sync, b.listen_bookshelf_name,c.relative_audio_book_id_set,c.relative_novel_book_id,a.recent_read_count, a.score, a.source, a.page_info, b.is_pub_pay, a.platform_book_id, b.pay_type, b.audioThumbUri, b.relative_post_schema, b.relative_post_id, b.poster_id, b.platform, b.authorizeType, b.op_tag FROM t_book_record AS a LEFT JOIN t_book AS b ON a.book_id == b.book_id LEFT JOIN t_relative_book_id AS c ON a.book_id = c.id AND a.book_type = c.book_type AND a.is_delete = ? ORDER BY a.read_time DESC LIMIT 1", 1);
        acquire.bindLong(1, z ? 1L : 0L);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "genre");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "score");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "source");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "platform_book_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "audioThumbUri");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "platform");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "authorizeType");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "op_tag");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow14)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow14);
                }
                if (query.isNull(columnIndexOrThrow15)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow15));
                }
                recordModel = new RecordModel(string, kr4.b.b(valueOf));
                if (query.isNull(columnIndexOrThrow)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow);
                }
                recordModel.setSerialCount(string2);
                if (query.isNull(columnIndexOrThrow2)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow2);
                }
                recordModel.setColorDominate(string3);
                if (query.isNull(columnIndexOrThrow3)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow3);
                }
                recordModel.setHorizThumbUrl(string4);
                if (query.isNull(columnIndexOrThrow4)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow4);
                }
                recordModel.setCategoryTags(string5);
                recordModel.setCreationStatus(query.getInt(columnIndexOrThrow5));
                if (query.isNull(columnIndexOrThrow6)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow6);
                }
                recordModel.setUpdateStatus(string6);
                if (query.getInt(columnIndexOrThrow7) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                recordModel.setShowVipTag(z2);
                if (query.isNull(columnIndexOrThrow8)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow8);
                }
                recordModel.setLastSerialCount(string7);
                if (query.isNull(columnIndexOrThrow9)) {
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow9);
                }
                recordModel.setLastChapterUpdateTime(string8);
                if (query.isNull(columnIndexOrThrow10)) {
                    string9 = null;
                } else {
                    string9 = query.getString(columnIndexOrThrow10);
                }
                recordModel.setLastChapterTitle(string9);
                if (query.getInt(columnIndexOrThrow11) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                recordModel.setExclusive(z3);
                if (query.isNull(columnIndexOrThrow12)) {
                    string10 = null;
                } else {
                    string10 = query.getString(columnIndexOrThrow12);
                }
                recordModel.setIconTag(string10);
                if (query.isNull(columnIndexOrThrow13)) {
                    string11 = null;
                } else {
                    string11 = query.getString(columnIndexOrThrow13);
                }
                recordModel.setStatus(string11);
                if (query.isNull(columnIndexOrThrow16)) {
                    string12 = null;
                } else {
                    string12 = query.getString(columnIndexOrThrow16);
                }
                recordModel.setAuthor(string12);
                if (query.isNull(columnIndexOrThrow17)) {
                    string13 = null;
                } else {
                    string13 = query.getString(columnIndexOrThrow17);
                }
                recordModel.setBookName(string13);
                if (query.isNull(columnIndexOrThrow18)) {
                    string14 = null;
                } else {
                    string14 = query.getString(columnIndexOrThrow18);
                }
                recordModel.setCoverUrl(string14);
                recordModel.setGenreType(query.getInt(columnIndexOrThrow19));
                if (query.isNull(columnIndexOrThrow20)) {
                    string15 = null;
                } else {
                    string15 = query.getString(columnIndexOrThrow20);
                }
                recordModel.setGenre(string15);
                if (query.isNull(columnIndexOrThrow21)) {
                    string16 = null;
                } else {
                    string16 = query.getString(columnIndexOrThrow21);
                }
                recordModel.setLengthType(string16);
                recordModel.setTtsStatus(query.getInt(columnIndexOrThrow22));
                recordModel.setReadTime(query.getLong(columnIndexOrThrow23));
                recordModel.setUpdateTime(query.getLong(columnIndexOrThrow24));
                if (query.getInt(columnIndexOrThrow25) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                recordModel.setDelete(z4);
                if (query.getInt(columnIndexOrThrow26) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                recordModel.setFinish(z5);
                if (query.getInt(columnIndexOrThrow27) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                recordModel.setHasSync(z6);
                if (query.isNull(columnIndexOrThrow28)) {
                    str = null;
                    recordModel.listenBookshelfName = null;
                } else {
                    str = null;
                    recordModel.listenBookshelfName = query.getString(columnIndexOrThrow28);
                }
                if (query.isNull(columnIndexOrThrow29)) {
                    string17 = str;
                } else {
                    string17 = query.getString(columnIndexOrThrow29);
                }
                recordModel.setRelativeAudioBookSet(kr4.h.b(string17));
                if (query.isNull(columnIndexOrThrow30)) {
                    string18 = str;
                } else {
                    string18 = query.getString(columnIndexOrThrow30);
                }
                recordModel.setRelativeNovelBookId(string18);
                recordModel.setRecentReadCount(query.getInt(columnIndexOrThrow31));
                if (query.isNull(columnIndexOrThrow32)) {
                    string19 = str;
                } else {
                    string19 = query.getString(columnIndexOrThrow32);
                }
                recordModel.setScore(string19);
                if (query.isNull(columnIndexOrThrow33)) {
                    string20 = str;
                } else {
                    string20 = query.getString(columnIndexOrThrow33);
                }
                recordModel.setSource(string20);
                if (query.isNull(columnIndexOrThrow34)) {
                    string21 = str;
                } else {
                    string21 = query.getString(columnIndexOrThrow34);
                }
                recordModel.setPageInfo(kr4.g.b(string21));
                if (query.getInt(columnIndexOrThrow35) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                recordModel.setPubPay(z7);
                if (query.isNull(columnIndexOrThrow36)) {
                    string22 = str;
                } else {
                    string22 = query.getString(columnIndexOrThrow36);
                }
                recordModel.setPlatformBookId(string22);
                recordModel.setPayType(query.getInt(columnIndexOrThrow37));
                if (query.isNull(columnIndexOrThrow38)) {
                    string23 = str;
                } else {
                    string23 = query.getString(columnIndexOrThrow38);
                }
                recordModel.setAudioCover(string23);
                if (query.isNull(columnIndexOrThrow39)) {
                    string24 = str;
                } else {
                    string24 = query.getString(columnIndexOrThrow39);
                }
                recordModel.setRelativePostSchema(string24);
                if (query.isNull(columnIndexOrThrow40)) {
                    string25 = str;
                } else {
                    string25 = query.getString(columnIndexOrThrow40);
                }
                recordModel.setRelativePostId(string25);
                if (query.isNull(columnIndexOrThrow41)) {
                    string26 = str;
                } else {
                    string26 = query.getString(columnIndexOrThrow41);
                }
                recordModel.setPosterId(string26);
                if (query.isNull(columnIndexOrThrow42)) {
                    string27 = str;
                } else {
                    string27 = query.getString(columnIndexOrThrow42);
                }
                recordModel.setPlatform(string27);
                if (query.isNull(columnIndexOrThrow43)) {
                    string28 = str;
                } else {
                    string28 = query.getString(columnIndexOrThrow43);
                }
                recordModel.setAuthorizeType(string28);
                if (query.isNull(columnIndexOrThrow44)) {
                    string29 = str;
                } else {
                    string29 = query.getString(columnIndexOrThrow44);
                }
                recordModel.setOpTag(string29);
            } else {
                recordModel = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return recordModel;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // nr4.z
    public List<RecordModel> h(List<BookType> list) {
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
        int i2;
        String string11;
        String string12;
        String string13;
        String string14;
        int i3;
        String string15;
        String string16;
        boolean z3;
        boolean z4;
        boolean z5;
        String string17;
        int i4;
        String string18;
        int i5;
        String string19;
        String string20;
        String string21;
        boolean z6;
        String string22;
        int i6;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT b.serial_count, b.color_dominate, b.horiz_thumb_url, b.tags, b.creationStatus, b.update_status, b.show_vip_tag,b.last_serial_count, b.last_chapter_update_time, b.last_chapter_title, b.is_exclusive, b.icon_tag, b.book_status,a.book_id,a.book_type,a.author_name,a.book_name AS name,a.cover_url,a.genre_type,b.genre,b.length_type,a.tts_status,a.read_time, a.update_time, a.is_delete, a.is_finish, a.has_sync, b.listen_bookshelf_name,c.relative_audio_book_id_set,c.relative_novel_book_id, a.recent_read_count, a.score, a.source, a.page_info, b.is_pub_pay, a.platform_book_id, b.pay_type, b.audioThumbUri, b.relative_post_schema, b.relative_post_id, b.poster_id, b.platform, b.authorizeType, b.op_tag FROM t_book_record AS a LEFT JOIN t_book AS b ON a.book_id == b.book_id LEFT JOIN t_relative_book_id AS c ON a.book_id = c.id AND a.book_type = c.book_type  WHERE a.book_type IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") ORDER BY a.read_time DESC");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        Iterator<BookType> it2 = list.iterator();
        int i7 = 1;
        while (it2.hasNext()) {
            if (kr4.b.a(it2.next()) == null) {
                acquire.bindNull(i7);
            } else {
                acquire.bindLong(i7, r6.intValue());
            }
            i7++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int i8 = columnIndexOrThrow13;
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "genre");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "score");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "source");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "platform_book_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "audioThumbUri");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "platform");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "authorizeType");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "op_tag");
            int i9 = columnIndexOrThrow12;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow14)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow14);
                }
                if (query.isNull(columnIndexOrThrow15)) {
                    i = columnIndexOrThrow14;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow15));
                    i = columnIndexOrThrow14;
                }
                BookType b2 = kr4.b.b(valueOf);
                int i10 = columnIndexOrThrow15;
                RecordModel recordModel = new RecordModel(string, b2);
                if (query.isNull(columnIndexOrThrow)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow);
                }
                recordModel.setSerialCount(string2);
                if (query.isNull(columnIndexOrThrow2)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow2);
                }
                recordModel.setColorDominate(string3);
                if (query.isNull(columnIndexOrThrow3)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow3);
                }
                recordModel.setHorizThumbUrl(string4);
                if (query.isNull(columnIndexOrThrow4)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow4);
                }
                recordModel.setCategoryTags(string5);
                recordModel.setCreationStatus(query.getInt(columnIndexOrThrow5));
                if (query.isNull(columnIndexOrThrow6)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow6);
                }
                recordModel.setUpdateStatus(string6);
                if (query.getInt(columnIndexOrThrow7) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                recordModel.setShowVipTag(z);
                if (query.isNull(columnIndexOrThrow8)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow8);
                }
                recordModel.setLastSerialCount(string7);
                if (query.isNull(columnIndexOrThrow9)) {
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow9);
                }
                recordModel.setLastChapterUpdateTime(string8);
                if (query.isNull(columnIndexOrThrow10)) {
                    string9 = null;
                } else {
                    string9 = query.getString(columnIndexOrThrow10);
                }
                recordModel.setLastChapterTitle(string9);
                if (query.getInt(columnIndexOrThrow11) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                recordModel.setExclusive(z2);
                int i11 = i9;
                if (query.isNull(i11)) {
                    string10 = null;
                } else {
                    string10 = query.getString(i11);
                }
                recordModel.setIconTag(string10);
                int i12 = i8;
                if (query.isNull(i12)) {
                    i2 = columnIndexOrThrow;
                    string11 = null;
                } else {
                    i2 = columnIndexOrThrow;
                    string11 = query.getString(i12);
                }
                recordModel.setStatus(string11);
                int i13 = columnIndexOrThrow16;
                if (query.isNull(i13)) {
                    columnIndexOrThrow16 = i13;
                    string12 = null;
                } else {
                    columnIndexOrThrow16 = i13;
                    string12 = query.getString(i13);
                }
                recordModel.setAuthor(string12);
                int i14 = columnIndexOrThrow17;
                if (query.isNull(i14)) {
                    columnIndexOrThrow17 = i14;
                    string13 = null;
                } else {
                    columnIndexOrThrow17 = i14;
                    string13 = query.getString(i14);
                }
                recordModel.setBookName(string13);
                int i15 = columnIndexOrThrow18;
                if (query.isNull(i15)) {
                    columnIndexOrThrow18 = i15;
                    string14 = null;
                } else {
                    columnIndexOrThrow18 = i15;
                    string14 = query.getString(i15);
                }
                recordModel.setCoverUrl(string14);
                int i16 = columnIndexOrThrow19;
                recordModel.setGenreType(query.getInt(i16));
                int i17 = columnIndexOrThrow20;
                if (query.isNull(i17)) {
                    i3 = i16;
                    string15 = null;
                } else {
                    i3 = i16;
                    string15 = query.getString(i17);
                }
                recordModel.setGenre(string15);
                int i18 = columnIndexOrThrow21;
                if (query.isNull(i18)) {
                    columnIndexOrThrow21 = i18;
                    string16 = null;
                } else {
                    columnIndexOrThrow21 = i18;
                    string16 = query.getString(i18);
                }
                recordModel.setLengthType(string16);
                int i19 = columnIndexOrThrow22;
                recordModel.setTtsStatus(query.getInt(i19));
                int i20 = columnIndexOrThrow11;
                int i21 = columnIndexOrThrow23;
                recordModel.setReadTime(query.getLong(i21));
                int i22 = columnIndexOrThrow24;
                recordModel.setUpdateTime(query.getLong(i22));
                int i23 = columnIndexOrThrow25;
                if (query.getInt(i23) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                recordModel.setDelete(z3);
                int i24 = columnIndexOrThrow26;
                if (query.getInt(i24) != 0) {
                    columnIndexOrThrow25 = i23;
                    z4 = true;
                } else {
                    columnIndexOrThrow25 = i23;
                    z4 = false;
                }
                recordModel.setFinish(z4);
                int i25 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i25;
                if (query.getInt(i25) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                recordModel.setHasSync(z5);
                int i26 = columnIndexOrThrow28;
                if (query.isNull(i26)) {
                    columnIndexOrThrow26 = i24;
                    recordModel.listenBookshelfName = null;
                } else {
                    columnIndexOrThrow26 = i24;
                    recordModel.listenBookshelfName = query.getString(i26);
                }
                int i27 = columnIndexOrThrow29;
                if (query.isNull(i27)) {
                    i4 = i26;
                    string17 = null;
                } else {
                    string17 = query.getString(i27);
                    i4 = i26;
                }
                recordModel.setRelativeAudioBookSet(kr4.h.b(string17));
                int i28 = columnIndexOrThrow30;
                if (query.isNull(i28)) {
                    columnIndexOrThrow30 = i28;
                    string18 = null;
                } else {
                    columnIndexOrThrow30 = i28;
                    string18 = query.getString(i28);
                }
                recordModel.setRelativeNovelBookId(string18);
                int i29 = columnIndexOrThrow31;
                recordModel.setRecentReadCount(query.getInt(i29));
                int i30 = columnIndexOrThrow32;
                if (query.isNull(i30)) {
                    i5 = i29;
                    string19 = null;
                } else {
                    i5 = i29;
                    string19 = query.getString(i30);
                }
                recordModel.setScore(string19);
                int i31 = columnIndexOrThrow33;
                if (query.isNull(i31)) {
                    columnIndexOrThrow33 = i31;
                    string20 = null;
                } else {
                    columnIndexOrThrow33 = i31;
                    string20 = query.getString(i31);
                }
                recordModel.setSource(string20);
                int i32 = columnIndexOrThrow34;
                if (query.isNull(i32)) {
                    columnIndexOrThrow34 = i32;
                    string21 = null;
                } else {
                    string21 = query.getString(i32);
                    columnIndexOrThrow34 = i32;
                }
                recordModel.setPageInfo(kr4.g.b(string21));
                int i33 = columnIndexOrThrow35;
                columnIndexOrThrow35 = i33;
                if (query.getInt(i33) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                recordModel.setPubPay(z6);
                int i34 = columnIndexOrThrow36;
                if (query.isNull(i34)) {
                    columnIndexOrThrow36 = i34;
                    string22 = null;
                } else {
                    columnIndexOrThrow36 = i34;
                    string22 = query.getString(i34);
                }
                recordModel.setPlatformBookId(string22);
                int i35 = columnIndexOrThrow37;
                recordModel.setPayType(query.getInt(i35));
                int i36 = columnIndexOrThrow38;
                if (query.isNull(i36)) {
                    i6 = i35;
                    string23 = null;
                } else {
                    i6 = i35;
                    string23 = query.getString(i36);
                }
                recordModel.setAudioCover(string23);
                int i37 = columnIndexOrThrow39;
                if (query.isNull(i37)) {
                    columnIndexOrThrow39 = i37;
                    string24 = null;
                } else {
                    columnIndexOrThrow39 = i37;
                    string24 = query.getString(i37);
                }
                recordModel.setRelativePostSchema(string24);
                int i38 = columnIndexOrThrow40;
                if (query.isNull(i38)) {
                    columnIndexOrThrow40 = i38;
                    string25 = null;
                } else {
                    columnIndexOrThrow40 = i38;
                    string25 = query.getString(i38);
                }
                recordModel.setRelativePostId(string25);
                int i39 = columnIndexOrThrow41;
                if (query.isNull(i39)) {
                    columnIndexOrThrow41 = i39;
                    string26 = null;
                } else {
                    columnIndexOrThrow41 = i39;
                    string26 = query.getString(i39);
                }
                recordModel.setPosterId(string26);
                int i40 = columnIndexOrThrow42;
                if (query.isNull(i40)) {
                    columnIndexOrThrow42 = i40;
                    string27 = null;
                } else {
                    columnIndexOrThrow42 = i40;
                    string27 = query.getString(i40);
                }
                recordModel.setPlatform(string27);
                int i41 = columnIndexOrThrow43;
                if (query.isNull(i41)) {
                    columnIndexOrThrow43 = i41;
                    string28 = null;
                } else {
                    columnIndexOrThrow43 = i41;
                    string28 = query.getString(i41);
                }
                recordModel.setAuthorizeType(string28);
                int i42 = columnIndexOrThrow44;
                if (query.isNull(i42)) {
                    columnIndexOrThrow44 = i42;
                    string29 = null;
                } else {
                    columnIndexOrThrow44 = i42;
                    string29 = query.getString(i42);
                }
                recordModel.setOpTag(string29);
                arrayList.add(recordModel);
                columnIndexOrThrow37 = i6;
                columnIndexOrThrow = i2;
                columnIndexOrThrow15 = i10;
                columnIndexOrThrow38 = i36;
                i9 = i11;
                i8 = i12;
                columnIndexOrThrow23 = i21;
                columnIndexOrThrow14 = i;
                columnIndexOrThrow24 = i22;
                columnIndexOrThrow11 = i20;
                columnIndexOrThrow22 = i19;
                int i43 = i3;
                columnIndexOrThrow20 = i17;
                columnIndexOrThrow19 = i43;
                int i44 = i4;
                columnIndexOrThrow29 = i27;
                columnIndexOrThrow28 = i44;
                int i45 = i5;
                columnIndexOrThrow32 = i30;
                columnIndexOrThrow31 = i45;
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

    class a extends EntityInsertionAdapter<lr4.i> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_book_record` (`author_name`,`book_name`,`cover_url`,`genre_type`,`tts_status`,`update_time`,`book_id`,`book_type`,`last_update_time`,`read_time`,`is_delete`,`has_sync`,`resource`,`is_finish`,`recent_read_count`,`score`,`source`,`page_info`,`is_pub_pay`,`pay_type`,`color_dominate`,`tone_id`,`platform_book_id`,`total_read_time`,`exact_read_time`,`exact_read_word_num`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.i iVar) {
            String str = iVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = iVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = iVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            supportSQLiteStatement.bindLong(4, iVar.d);
            supportSQLiteStatement.bindLong(5, iVar.e);
            supportSQLiteStatement.bindLong(6, iVar.f);
            String str4 = iVar.g;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str4);
            }
            if (kr4.b.a(iVar.h) == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, r0.intValue());
            }
            supportSQLiteStatement.bindLong(9, iVar.i);
            supportSQLiteStatement.bindLong(10, iVar.j);
            supportSQLiteStatement.bindLong(11, iVar.k ? 1L : 0L);
            supportSQLiteStatement.bindLong(12, iVar.l ? 1L : 0L);
            String str5 = iVar.m;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str5);
            }
            supportSQLiteStatement.bindLong(14, iVar.n ? 1L : 0L);
            supportSQLiteStatement.bindLong(15, iVar.o);
            String str6 = iVar.p;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str6);
            }
            String str7 = iVar.q;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str7);
            }
            String a = kr4.g.a(iVar.r);
            if (a == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, a);
            }
            supportSQLiteStatement.bindLong(19, iVar.u ? 1L : 0L);
            supportSQLiteStatement.bindLong(20, iVar.v);
            String str8 = iVar.w;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str8);
            }
            supportSQLiteStatement.bindLong(22, iVar.x);
            String str9 = iVar.y;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str9);
            }
            supportSQLiteStatement.bindLong(24, iVar.z);
            supportSQLiteStatement.bindLong(25, iVar.A);
            supportSQLiteStatement.bindLong(26, iVar.B);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.i> {
        public String createQuery() {
            return "DELETE FROM `t_book_record` WHERE `book_id` = ? AND `book_type` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.i iVar) {
            String str = iVar.g;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(iVar.h) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r5.intValue());
            }
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_book_record";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "UPDATE t_book_record SET total_read_time = total_read_time + ?, exact_read_time = exact_read_time + ?, exact_read_word_num = exact_read_word_num + ? WHERE book_id = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // nr4.z
    public lr4.i c(String str, BookType bookType) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.i iVar;
        String string;
        Integer valueOf;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        boolean z3;
        String string6;
        String string7;
        String string8;
        boolean z4;
        String string9;
        String string10;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_book_record WHERE book_id = ? AND book_type = (?)", 2);
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "resource");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "platform_book_id");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "total_read_time");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_time");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "exact_read_word_num");
                if (query.moveToFirst()) {
                    if (query.isNull(columnIndexOrThrow7)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    }
                    lr4.i iVar2 = new lr4.i(string, kr4.b.b(valueOf));
                    if (query.isNull(columnIndexOrThrow)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow);
                    }
                    iVar2.a = string2;
                    if (query.isNull(columnIndexOrThrow2)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow2);
                    }
                    iVar2.b = string3;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow3);
                    }
                    iVar2.c = string4;
                    iVar2.d = query.getInt(columnIndexOrThrow4);
                    iVar2.e = query.getInt(columnIndexOrThrow5);
                    iVar2.f = query.getLong(columnIndexOrThrow6);
                    iVar2.i = query.getLong(columnIndexOrThrow9);
                    iVar2.j = query.getLong(columnIndexOrThrow10);
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar2.k = z;
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    iVar2.l = z2;
                    if (query.isNull(columnIndexOrThrow13)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow13);
                    }
                    iVar2.m = string5;
                    if (query.getInt(columnIndexOrThrow14) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    iVar2.n = z3;
                    iVar2.o = query.getInt(columnIndexOrThrow15);
                    if (query.isNull(columnIndexOrThrow16)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow16);
                    }
                    iVar2.p = string6;
                    if (query.isNull(columnIndexOrThrow17)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow17);
                    }
                    iVar2.q = string7;
                    if (query.isNull(columnIndexOrThrow18)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow18);
                    }
                    iVar2.r = kr4.g.b(string8);
                    if (query.getInt(columnIndexOrThrow19) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    iVar2.u = z4;
                    iVar2.v = query.getInt(columnIndexOrThrow20);
                    if (query.isNull(columnIndexOrThrow21)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow21);
                    }
                    iVar2.w = string9;
                    iVar2.x = query.getLong(columnIndexOrThrow22);
                    if (query.isNull(columnIndexOrThrow23)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow23);
                    }
                    iVar2.y = string10;
                    iVar2.z = query.getLong(columnIndexOrThrow24);
                    iVar2.A = query.getLong(columnIndexOrThrow25);
                    iVar2.B = query.getLong(columnIndexOrThrow26);
                    iVar = iVar2;
                } else {
                    iVar = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return iVar;
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

    @Override // nr4.z
    public RecordModel b(String str, BookType bookType) {
        RoomSQLiteQuery roomSQLiteQuery;
        RecordModel recordModel;
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
        String string9;
        boolean z2;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        boolean z3;
        boolean z4;
        boolean z5;
        String str2;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        boolean z6;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT b.serial_count,b.color_dominate, b.horiz_thumb_url, b.tags, b.creationStatus, b.update_status, b.show_vip_tag,b.last_serial_count, b.last_chapter_update_time, b.last_chapter_title, b.is_exclusive, b.icon_tag, b.book_status,a.book_id,a.book_type,a.author_name,a.book_name AS name,a.cover_url,a.genre_type,b.genre,b.length_type,a.tts_status,a.read_time, a.update_time, a.is_delete, a.is_finish, a.has_sync, b.listen_bookshelf_name,c.relative_audio_book_id_set,c.relative_novel_book_id, a.recent_read_count, a.score, a.source, a.page_info, b.is_pub_pay, a.platform_book_id, b.pay_type, b.audioThumbUri, b.relative_post_schema, b.relative_post_id, b.poster_id, b.platform, b.authorizeType, b.op_tag FROM t_book_record AS a LEFT JOIN t_book AS b ON a.book_id == b.book_id LEFT JOIN t_relative_book_id AS c ON a.book_id = c.id AND a.book_type = c.book_type  WHERE a.book_type = (?) and a.book_id == (?) ORDER BY a.read_time DESC LIMIT 1", 2);
        if (kr4.b.a(bookType) == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindLong(1, r4.intValue());
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "genre");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "platform_book_id");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "audioThumbUri");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "platform");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "authorizeType");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "op_tag");
                if (query.moveToFirst()) {
                    if (query.isNull(columnIndexOrThrow14)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow14);
                    }
                    if (query.isNull(columnIndexOrThrow15)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow15));
                    }
                    recordModel = new RecordModel(string, kr4.b.b(valueOf));
                    if (query.isNull(columnIndexOrThrow)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow);
                    }
                    recordModel.setSerialCount(string2);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow2);
                    }
                    recordModel.setColorDominate(string3);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow3);
                    }
                    recordModel.setHorizThumbUrl(string4);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow4);
                    }
                    recordModel.setCategoryTags(string5);
                    recordModel.setCreationStatus(query.getInt(columnIndexOrThrow5));
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    recordModel.setUpdateStatus(string6);
                    if (query.getInt(columnIndexOrThrow7) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    recordModel.setShowVipTag(z);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow8);
                    }
                    recordModel.setLastSerialCount(string7);
                    if (query.isNull(columnIndexOrThrow9)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow9);
                    }
                    recordModel.setLastChapterUpdateTime(string8);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    recordModel.setLastChapterTitle(string9);
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    recordModel.setExclusive(z2);
                    if (query.isNull(columnIndexOrThrow12)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow12);
                    }
                    recordModel.setIconTag(string10);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow13);
                    }
                    recordModel.setStatus(string11);
                    if (query.isNull(columnIndexOrThrow16)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow16);
                    }
                    recordModel.setAuthor(string12);
                    if (query.isNull(columnIndexOrThrow17)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(columnIndexOrThrow17);
                    }
                    recordModel.setBookName(string13);
                    if (query.isNull(columnIndexOrThrow18)) {
                        string14 = null;
                    } else {
                        string14 = query.getString(columnIndexOrThrow18);
                    }
                    recordModel.setCoverUrl(string14);
                    recordModel.setGenreType(query.getInt(columnIndexOrThrow19));
                    if (query.isNull(columnIndexOrThrow20)) {
                        string15 = null;
                    } else {
                        string15 = query.getString(columnIndexOrThrow20);
                    }
                    recordModel.setGenre(string15);
                    if (query.isNull(columnIndexOrThrow21)) {
                        string16 = null;
                    } else {
                        string16 = query.getString(columnIndexOrThrow21);
                    }
                    recordModel.setLengthType(string16);
                    recordModel.setTtsStatus(query.getInt(columnIndexOrThrow22));
                    recordModel.setReadTime(query.getLong(columnIndexOrThrow23));
                    recordModel.setUpdateTime(query.getLong(columnIndexOrThrow24));
                    if (query.getInt(columnIndexOrThrow25) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    recordModel.setDelete(z3);
                    if (query.getInt(columnIndexOrThrow26) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    recordModel.setFinish(z4);
                    if (query.getInt(columnIndexOrThrow27) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    recordModel.setHasSync(z5);
                    if (query.isNull(columnIndexOrThrow28)) {
                        str2 = null;
                        recordModel.listenBookshelfName = null;
                    } else {
                        str2 = null;
                        recordModel.listenBookshelfName = query.getString(columnIndexOrThrow28);
                    }
                    if (query.isNull(columnIndexOrThrow29)) {
                        string17 = str2;
                    } else {
                        string17 = query.getString(columnIndexOrThrow29);
                    }
                    recordModel.setRelativeAudioBookSet(kr4.h.b(string17));
                    if (query.isNull(columnIndexOrThrow30)) {
                        string18 = str2;
                    } else {
                        string18 = query.getString(columnIndexOrThrow30);
                    }
                    recordModel.setRelativeNovelBookId(string18);
                    recordModel.setRecentReadCount(query.getInt(columnIndexOrThrow31));
                    if (query.isNull(columnIndexOrThrow32)) {
                        string19 = str2;
                    } else {
                        string19 = query.getString(columnIndexOrThrow32);
                    }
                    recordModel.setScore(string19);
                    if (query.isNull(columnIndexOrThrow33)) {
                        string20 = str2;
                    } else {
                        string20 = query.getString(columnIndexOrThrow33);
                    }
                    recordModel.setSource(string20);
                    if (query.isNull(columnIndexOrThrow34)) {
                        string21 = str2;
                    } else {
                        string21 = query.getString(columnIndexOrThrow34);
                    }
                    recordModel.setPageInfo(kr4.g.b(string21));
                    if (query.getInt(columnIndexOrThrow35) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    recordModel.setPubPay(z6);
                    if (query.isNull(columnIndexOrThrow36)) {
                        string22 = str2;
                    } else {
                        string22 = query.getString(columnIndexOrThrow36);
                    }
                    recordModel.setPlatformBookId(string22);
                    recordModel.setPayType(query.getInt(columnIndexOrThrow37));
                    if (query.isNull(columnIndexOrThrow38)) {
                        string23 = str2;
                    } else {
                        string23 = query.getString(columnIndexOrThrow38);
                    }
                    recordModel.setAudioCover(string23);
                    if (query.isNull(columnIndexOrThrow39)) {
                        string24 = str2;
                    } else {
                        string24 = query.getString(columnIndexOrThrow39);
                    }
                    recordModel.setRelativePostSchema(string24);
                    if (query.isNull(columnIndexOrThrow40)) {
                        string25 = str2;
                    } else {
                        string25 = query.getString(columnIndexOrThrow40);
                    }
                    recordModel.setRelativePostId(string25);
                    if (query.isNull(columnIndexOrThrow41)) {
                        string26 = str2;
                    } else {
                        string26 = query.getString(columnIndexOrThrow41);
                    }
                    recordModel.setPosterId(string26);
                    if (query.isNull(columnIndexOrThrow42)) {
                        string27 = str2;
                    } else {
                        string27 = query.getString(columnIndexOrThrow42);
                    }
                    recordModel.setPlatform(string27);
                    if (query.isNull(columnIndexOrThrow43)) {
                        string28 = str2;
                    } else {
                        string28 = query.getString(columnIndexOrThrow43);
                    }
                    recordModel.setAuthorizeType(string28);
                    if (query.isNull(columnIndexOrThrow44)) {
                        string29 = str2;
                    } else {
                        string29 = query.getString(columnIndexOrThrow44);
                    }
                    recordModel.setOpTag(string29);
                } else {
                    recordModel = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return recordModel;
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

    @Override // nr4.z
    public List<RecordModel> d(int i, boolean z) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        Integer valueOf;
        int i2;
        String string2;
        String string3;
        String string4;
        String string5;
        boolean z2;
        String string6;
        String string7;
        String string8;
        String string9;
        boolean z3;
        String string10;
        int i3;
        String string11;
        String string12;
        String string13;
        String string14;
        int i4;
        String string15;
        String string16;
        boolean z4;
        boolean z5;
        boolean z6;
        String string17;
        int i5;
        String string18;
        int i6;
        String string19;
        String string20;
        String string21;
        boolean z7;
        int i7;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT b.serial_count,b.color_dominate, b.horiz_thumb_url, b.tags, b.creationStatus, b.show_vip_tag, b.update_status, b.last_serial_count, b.last_chapter_update_time, b.last_chapter_title, b.is_exclusive, b.icon_tag, b.book_status,a.book_id,a.book_type,a.author_name,a.book_name AS name,a.cover_url,a.genre_type,b.genre,b.length_type,a.tts_status,a.read_time, a.update_time, a.is_delete, a.is_finish, a.has_sync, b.listen_bookshelf_name,c.relative_audio_book_id_set,c.relative_novel_book_id, a.recent_read_count, a.score, a.source, a.page_info, b.is_pub_pay, b.pay_type, b.audioThumbUri, b.relative_post_schema, b.relative_post_id, b.poster_id, b.platform, b.authorizeType, b.op_tag FROM t_book_record AS a LEFT JOIN t_book AS b ON a.book_id == b.book_id LEFT JOIN t_relative_book_id AS c ON a.book_id = c.id AND a.book_type = c.book_type AND a.is_delete = ? ORDER BY a.read_time DESC LIMIT ?", 2);
        acquire.bindLong(1, z ? 1L : 0L);
        acquire.bindLong(2, i);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serial_count");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "horiz_thumb_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "creationStatus");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "show_vip_tag");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "last_serial_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_update_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_chapter_title");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_exclusive");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "icon_tag");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "book_status");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int i8 = columnIndexOrThrow13;
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "author_name");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "genre");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "length_type");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "tts_status");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "read_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "is_finish");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "listen_bookshelf_name");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "relative_audio_book_id_set");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "relative_novel_book_id");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "recent_read_count");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "score");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "page_info");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "is_pub_pay");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "pay_type");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "audioThumbUri");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_schema");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "relative_post_id");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "poster_id");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "platform");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "authorizeType");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "op_tag");
                int i9 = columnIndexOrThrow12;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow14)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow14);
                    }
                    if (query.isNull(columnIndexOrThrow15)) {
                        i2 = columnIndexOrThrow14;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow15));
                        i2 = columnIndexOrThrow14;
                    }
                    BookType b2 = kr4.b.b(valueOf);
                    int i10 = columnIndexOrThrow15;
                    RecordModel recordModel = new RecordModel(string, b2);
                    if (query.isNull(columnIndexOrThrow)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow);
                    }
                    recordModel.setSerialCount(string2);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow2);
                    }
                    recordModel.setColorDominate(string3);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow3);
                    }
                    recordModel.setHorizThumbUrl(string4);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow4);
                    }
                    recordModel.setCategoryTags(string5);
                    recordModel.setCreationStatus(query.getInt(columnIndexOrThrow5));
                    if (query.getInt(columnIndexOrThrow6) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    recordModel.setShowVipTag(z2);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow7);
                    }
                    recordModel.setUpdateStatus(string6);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow8);
                    }
                    recordModel.setLastSerialCount(string7);
                    if (query.isNull(columnIndexOrThrow9)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow9);
                    }
                    recordModel.setLastChapterUpdateTime(string8);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow10);
                    }
                    recordModel.setLastChapterTitle(string9);
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    recordModel.setExclusive(z3);
                    int i11 = i9;
                    if (query.isNull(i11)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(i11);
                    }
                    recordModel.setIconTag(string10);
                    int i12 = i8;
                    if (query.isNull(i12)) {
                        i3 = columnIndexOrThrow11;
                        string11 = null;
                    } else {
                        i3 = columnIndexOrThrow11;
                        string11 = query.getString(i12);
                    }
                    recordModel.setStatus(string11);
                    int i13 = columnIndexOrThrow16;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow16 = i13;
                        string12 = null;
                    } else {
                        columnIndexOrThrow16 = i13;
                        string12 = query.getString(i13);
                    }
                    recordModel.setAuthor(string12);
                    int i14 = columnIndexOrThrow17;
                    if (query.isNull(i14)) {
                        columnIndexOrThrow17 = i14;
                        string13 = null;
                    } else {
                        columnIndexOrThrow17 = i14;
                        string13 = query.getString(i14);
                    }
                    recordModel.setBookName(string13);
                    int i15 = columnIndexOrThrow18;
                    if (query.isNull(i15)) {
                        columnIndexOrThrow18 = i15;
                        string14 = null;
                    } else {
                        columnIndexOrThrow18 = i15;
                        string14 = query.getString(i15);
                    }
                    recordModel.setCoverUrl(string14);
                    int i16 = columnIndexOrThrow19;
                    recordModel.setGenreType(query.getInt(i16));
                    int i17 = columnIndexOrThrow20;
                    if (query.isNull(i17)) {
                        i4 = i16;
                        string15 = null;
                    } else {
                        i4 = i16;
                        string15 = query.getString(i17);
                    }
                    recordModel.setGenre(string15);
                    int i18 = columnIndexOrThrow21;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow21 = i18;
                        string16 = null;
                    } else {
                        columnIndexOrThrow21 = i18;
                        string16 = query.getString(i18);
                    }
                    recordModel.setLengthType(string16);
                    int i19 = columnIndexOrThrow22;
                    recordModel.setTtsStatus(query.getInt(i19));
                    int i20 = columnIndexOrThrow;
                    int i21 = columnIndexOrThrow23;
                    int i22 = columnIndexOrThrow2;
                    recordModel.setReadTime(query.getLong(i21));
                    int i23 = columnIndexOrThrow24;
                    recordModel.setUpdateTime(query.getLong(i23));
                    int i24 = columnIndexOrThrow25;
                    if (query.getInt(i24) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    recordModel.setDelete(z4);
                    int i25 = columnIndexOrThrow26;
                    if (query.getInt(i25) != 0) {
                        columnIndexOrThrow25 = i24;
                        z5 = true;
                    } else {
                        columnIndexOrThrow25 = i24;
                        z5 = false;
                    }
                    recordModel.setFinish(z5);
                    int i26 = columnIndexOrThrow27;
                    columnIndexOrThrow27 = i26;
                    if (query.getInt(i26) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    recordModel.setHasSync(z6);
                    int i27 = columnIndexOrThrow28;
                    if (query.isNull(i27)) {
                        columnIndexOrThrow26 = i25;
                        recordModel.listenBookshelfName = null;
                    } else {
                        columnIndexOrThrow26 = i25;
                        recordModel.listenBookshelfName = query.getString(i27);
                    }
                    int i28 = columnIndexOrThrow29;
                    if (query.isNull(i28)) {
                        i5 = i27;
                        string17 = null;
                    } else {
                        string17 = query.getString(i28);
                        i5 = i27;
                    }
                    recordModel.setRelativeAudioBookSet(kr4.h.b(string17));
                    int i29 = columnIndexOrThrow30;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow30 = i29;
                        string18 = null;
                    } else {
                        columnIndexOrThrow30 = i29;
                        string18 = query.getString(i29);
                    }
                    recordModel.setRelativeNovelBookId(string18);
                    int i30 = columnIndexOrThrow31;
                    recordModel.setRecentReadCount(query.getInt(i30));
                    int i31 = columnIndexOrThrow32;
                    if (query.isNull(i31)) {
                        i6 = i30;
                        string19 = null;
                    } else {
                        i6 = i30;
                        string19 = query.getString(i31);
                    }
                    recordModel.setScore(string19);
                    int i32 = columnIndexOrThrow33;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow33 = i32;
                        string20 = null;
                    } else {
                        columnIndexOrThrow33 = i32;
                        string20 = query.getString(i32);
                    }
                    recordModel.setSource(string20);
                    int i33 = columnIndexOrThrow34;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow34 = i33;
                        string21 = null;
                    } else {
                        string21 = query.getString(i33);
                        columnIndexOrThrow34 = i33;
                    }
                    recordModel.setPageInfo(kr4.g.b(string21));
                    int i34 = columnIndexOrThrow35;
                    columnIndexOrThrow35 = i34;
                    if (query.getInt(i34) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    recordModel.setPubPay(z7);
                    int i35 = columnIndexOrThrow36;
                    recordModel.setPayType(query.getInt(i35));
                    int i36 = columnIndexOrThrow37;
                    if (query.isNull(i36)) {
                        i7 = i35;
                        string22 = null;
                    } else {
                        i7 = i35;
                        string22 = query.getString(i36);
                    }
                    recordModel.setAudioCover(string22);
                    int i37 = columnIndexOrThrow38;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow38 = i37;
                        string23 = null;
                    } else {
                        columnIndexOrThrow38 = i37;
                        string23 = query.getString(i37);
                    }
                    recordModel.setRelativePostSchema(string23);
                    int i38 = columnIndexOrThrow39;
                    if (query.isNull(i38)) {
                        columnIndexOrThrow39 = i38;
                        string24 = null;
                    } else {
                        columnIndexOrThrow39 = i38;
                        string24 = query.getString(i38);
                    }
                    recordModel.setRelativePostId(string24);
                    int i39 = columnIndexOrThrow40;
                    if (query.isNull(i39)) {
                        columnIndexOrThrow40 = i39;
                        string25 = null;
                    } else {
                        columnIndexOrThrow40 = i39;
                        string25 = query.getString(i39);
                    }
                    recordModel.setPosterId(string25);
                    int i40 = columnIndexOrThrow41;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow41 = i40;
                        string26 = null;
                    } else {
                        columnIndexOrThrow41 = i40;
                        string26 = query.getString(i40);
                    }
                    recordModel.setPlatform(string26);
                    int i41 = columnIndexOrThrow42;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow42 = i41;
                        string27 = null;
                    } else {
                        columnIndexOrThrow42 = i41;
                        string27 = query.getString(i41);
                    }
                    recordModel.setAuthorizeType(string27);
                    int i42 = columnIndexOrThrow43;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow43 = i42;
                        string28 = null;
                    } else {
                        columnIndexOrThrow43 = i42;
                        string28 = query.getString(i42);
                    }
                    recordModel.setOpTag(string28);
                    arrayList.add(recordModel);
                    columnIndexOrThrow36 = i7;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow15 = i10;
                    columnIndexOrThrow37 = i36;
                    i9 = i11;
                    columnIndexOrThrow14 = i2;
                    i8 = i12;
                    columnIndexOrThrow24 = i23;
                    columnIndexOrThrow = i20;
                    columnIndexOrThrow22 = i19;
                    columnIndexOrThrow2 = i22;
                    columnIndexOrThrow23 = i21;
                    int i43 = i4;
                    columnIndexOrThrow20 = i17;
                    columnIndexOrThrow19 = i43;
                    int i44 = i5;
                    columnIndexOrThrow29 = i28;
                    columnIndexOrThrow28 = i44;
                    int i45 = i6;
                    columnIndexOrThrow32 = i31;
                    columnIndexOrThrow31 = i45;
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

    @Override // nr4.z
    public void j(String str, long j, long j2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        acquire.bindLong(1, j);
        acquire.bindLong(2, j);
        acquire.bindLong(3, j2);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
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
}
