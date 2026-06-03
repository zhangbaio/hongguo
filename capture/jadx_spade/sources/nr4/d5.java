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
import com.dragon.read.pages.bookshelf.video.BSVideoCollModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d5 implements b5 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.t1> b;
    private final EntityInsertionAdapter<lr4.s1> c;
    private final EntityDeletionOrUpdateAdapter<lr4.t1> d;
    private final EntityDeletionOrUpdateAdapter<lr4.t1> e;
    private final SharedSQLiteStatement f;

    static {
        Covode.recordClassIndex(611803);
    }

    public static List<Class<?>> m() {
        return Collections.emptyList();
    }

    @Override // nr4.b5
    public lr4.s1 b() {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.s1 s1Var;
        String string;
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
        boolean z4;
        String string10;
        String string11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_collection LIMIT 1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "group_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "collect_time");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "user_digg");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
                if (query.moveToFirst()) {
                    lr4.s1 s1Var2 = new lr4.s1();
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    s1Var2.g(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    s1Var2.h(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    s1Var2.a(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    s1Var2.f(string4);
                    s1Var2.e = query.getInt(columnIndexOrThrow5);
                    s1Var2.f = query.getLong(columnIndexOrThrow6);
                    if (query.getInt(columnIndexOrThrow7) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    s1Var2.g = z;
                    if (query.getInt(columnIndexOrThrow8) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    s1Var2.h = z2;
                    s1Var2.i = query.getLong(columnIndexOrThrow9);
                    s1Var2.j = query.getInt(columnIndexOrThrow10);
                    s1Var2.k = query.getInt(columnIndexOrThrow11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow12);
                    }
                    s1Var2.b(string5);
                    s1Var2.m = query.getLong(columnIndexOrThrow13);
                    s1Var2.n = query.getLong(columnIndexOrThrow14);
                    if (query.isNull(columnIndexOrThrow15)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow15);
                    }
                    s1Var2.i(string6);
                    s1Var2.p = query.getLong(columnIndexOrThrow16);
                    if (query.getInt(columnIndexOrThrow17) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    s1Var2.q = z3;
                    if (query.isNull(columnIndexOrThrow18)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow18);
                    }
                    s1Var2.d(string7);
                    if (query.isNull(columnIndexOrThrow19)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow19);
                    }
                    s1Var2.c(string8);
                    if (query.isNull(columnIndexOrThrow20)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow20);
                    }
                    s1Var2.k(string9);
                    if (query.getInt(columnIndexOrThrow21) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    s1Var2.u = z4;
                    s1Var2.v = query.getInt(columnIndexOrThrow22);
                    if (query.isNull(columnIndexOrThrow23)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow23);
                    }
                    s1Var2.j(string10);
                    if (query.isNull(columnIndexOrThrow24)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow24);
                    }
                    s1Var2.e(string11);
                    s1Var = s1Var2;
                } else {
                    s1Var = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return s1Var;
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

    @Override // nr4.b5
    public List<lr4.t1> a() {
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
        boolean z;
        int i2;
        String string9;
        String string10;
        boolean z2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_progress WHERE is_sync = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "current_video_title");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "total_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_video_vid");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "relative_book_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "is_fake_progress");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "video_scene");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.t1 t1Var = new lr4.t1();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    t1Var.h(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    t1Var.i(string2);
                    t1Var.c = query.getInt(columnIndexOrThrow3);
                    t1Var.d = query.getInt(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    t1Var.b(string3);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow6);
                    }
                    t1Var.c(string4);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow7);
                    }
                    t1Var.j(string5);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow8);
                    }
                    t1Var.a(string6);
                    if (query.isNull(columnIndexOrThrow9)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow9);
                    }
                    t1Var.d(string7);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow10);
                    }
                    t1Var.e(string8);
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    t1Var.k = query.getLong(columnIndexOrThrow11);
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t1Var.l = z;
                    t1Var.m = query.getInt(columnIndexOrThrow13);
                    int i6 = i3;
                    t1Var.n = query.getInt(i6);
                    int i7 = columnIndexOrThrow15;
                    if (query.isNull(i7)) {
                        i2 = i4;
                        string9 = null;
                    } else {
                        i2 = i4;
                        string9 = query.getString(i7);
                    }
                    t1Var.g(string9);
                    int i8 = columnIndexOrThrow16;
                    if (query.isNull(i8)) {
                        columnIndexOrThrow16 = i8;
                        string10 = null;
                    } else {
                        columnIndexOrThrow16 = i8;
                        string10 = query.getString(i8);
                    }
                    t1Var.f(string10);
                    int i9 = columnIndexOrThrow17;
                    columnIndexOrThrow17 = i9;
                    if (query.getInt(i9) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t1Var.q = z2;
                    i3 = i6;
                    columnIndexOrThrow15 = i7;
                    int i10 = columnIndexOrThrow18;
                    t1Var.r = query.getLong(i10);
                    int i11 = columnIndexOrThrow4;
                    int i12 = columnIndexOrThrow19;
                    t1Var.s = query.getLong(i12);
                    int i13 = columnIndexOrThrow20;
                    t1Var.t = query.getInt(i13);
                    int i14 = columnIndexOrThrow21;
                    t1Var.u = query.getInt(i14);
                    int i15 = columnIndexOrThrow12;
                    int i16 = columnIndexOrThrow22;
                    t1Var.v = query.getInt(i16);
                    arrayList.add(t1Var);
                    columnIndexOrThrow22 = i16;
                    columnIndexOrThrow21 = i14;
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow12 = i15;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow19 = i12;
                    columnIndexOrThrow20 = i13;
                    columnIndexOrThrow3 = i5;
                    columnIndexOrThrow2 = i2;
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

    @Override // nr4.b5
    public List<lr4.t1> d() {
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
        boolean z;
        int i2;
        String string9;
        String string10;
        boolean z2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_progress", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "current_video_title");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "total_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_video_vid");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "relative_book_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "is_fake_progress");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "video_scene");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.t1 t1Var = new lr4.t1();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    t1Var.h(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    t1Var.i(string2);
                    t1Var.c = query.getInt(columnIndexOrThrow3);
                    t1Var.d = query.getInt(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    t1Var.b(string3);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow6);
                    }
                    t1Var.c(string4);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow7);
                    }
                    t1Var.j(string5);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow8);
                    }
                    t1Var.a(string6);
                    if (query.isNull(columnIndexOrThrow9)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow9);
                    }
                    t1Var.d(string7);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow10);
                    }
                    t1Var.e(string8);
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    t1Var.k = query.getLong(columnIndexOrThrow11);
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t1Var.l = z;
                    t1Var.m = query.getInt(columnIndexOrThrow13);
                    int i6 = i3;
                    t1Var.n = query.getInt(i6);
                    int i7 = columnIndexOrThrow15;
                    if (query.isNull(i7)) {
                        i2 = i4;
                        string9 = null;
                    } else {
                        i2 = i4;
                        string9 = query.getString(i7);
                    }
                    t1Var.g(string9);
                    int i8 = columnIndexOrThrow16;
                    if (query.isNull(i8)) {
                        columnIndexOrThrow16 = i8;
                        string10 = null;
                    } else {
                        columnIndexOrThrow16 = i8;
                        string10 = query.getString(i8);
                    }
                    t1Var.f(string10);
                    int i9 = columnIndexOrThrow17;
                    columnIndexOrThrow17 = i9;
                    if (query.getInt(i9) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t1Var.q = z2;
                    i3 = i6;
                    columnIndexOrThrow15 = i7;
                    int i10 = columnIndexOrThrow18;
                    t1Var.r = query.getLong(i10);
                    int i11 = columnIndexOrThrow4;
                    int i12 = columnIndexOrThrow19;
                    t1Var.s = query.getLong(i12);
                    int i13 = columnIndexOrThrow20;
                    t1Var.t = query.getInt(i13);
                    int i14 = columnIndexOrThrow21;
                    t1Var.u = query.getInt(i14);
                    int i15 = columnIndexOrThrow12;
                    int i16 = columnIndexOrThrow22;
                    t1Var.v = query.getInt(i16);
                    arrayList.add(t1Var);
                    columnIndexOrThrow22 = i16;
                    columnIndexOrThrow21 = i14;
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow12 = i15;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow19 = i12;
                    columnIndexOrThrow20 = i13;
                    columnIndexOrThrow3 = i5;
                    columnIndexOrThrow2 = i2;
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

    @Override // nr4.b5
    public List<BSVideoCollModel> g() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        boolean z;
        boolean z2;
        String string4;
        int i2;
        String string5;
        boolean z3;
        int i3;
        String string6;
        String string7;
        int i4;
        String string8;
        String string9;
        boolean z4;
        int i5;
        String string10;
        String string11;
        String string12;
        boolean z5;
        int i6;
        String string13;
        String string14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT c.series_id, c.series_name, c.cover_url, c.series_color_hex, c.series_status, c.is_sync, c.is_delete, c.update_status as update_status, c.update_tag_text as update_tag_text, p.update_time as last_update_time,p.series_cnt as series_cnt_progress, c.content_type as series_content_type, p.video_height, p.video_width, p.relative_book_id, p.current_play_video_index, p.current_play_video_id, p.is_fake_progress, c.collect_time as last_collect_time, c.series_cnt as series_cnt_collect, c.group_name as group_name ,c.booklist_operate_time as booklist_operate_time, c.collect_time as collect_time, p.current_video_title as series_introduction,p.current_play_position, p.current_video_total_time, c.digged_count as digged_count, c.user_digg as user_digg, c.pugc_user_name as pugc_user_name, c.pugc_user_avatar as pugc_user_avatar, c.video_tag_info as video_tag_info, c.is_multi_season as is_multi_season, c.season_index as season_index, c.video_category_type as video_category_type, c.related_series_title as related_series_title FROM t_video_serial_collection AS c LEFT JOIN t_video_serial_progress AS p ON c.series_id = p.series_id ORDER BY MAX(last_update_time, last_collect_time) DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt_progress");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "series_content_type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "relative_book_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_index");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "is_fake_progress");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "last_collect_time");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt_collect");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "group_name");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "collect_time");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "series_introduction");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "user_digg");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    BSVideoCollModel bSVideoCollModel = new BSVideoCollModel();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    bSVideoCollModel.setSeriesId(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    bSVideoCollModel.setSeriesName(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    bSVideoCollModel.setCoverUrl(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        bSVideoCollModel.seriesColorHex = null;
                    } else {
                        bSVideoCollModel.seriesColorHex = query.getString(columnIndexOrThrow4);
                    }
                    bSVideoCollModel.setSeriesStatus(query.getInt(columnIndexOrThrow5));
                    if (query.getInt(columnIndexOrThrow6) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bSVideoCollModel.setSync(z);
                    if (query.getInt(columnIndexOrThrow7) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    bSVideoCollModel.setDelete(z2);
                    bSVideoCollModel.setUpdateStatus(query.getInt(columnIndexOrThrow8));
                    if (query.isNull(columnIndexOrThrow9)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow9);
                    }
                    bSVideoCollModel.setUpdateTagText(string4);
                    int i8 = columnIndexOrThrow2;
                    int i9 = columnIndexOrThrow3;
                    bSVideoCollModel.setLastUpdateTimeProgress(query.getLong(columnIndexOrThrow10));
                    bSVideoCollModel.setSeriesCountProgress(query.getInt(columnIndexOrThrow11));
                    bSVideoCollModel.setSeriesContentType(query.getInt(columnIndexOrThrow12));
                    bSVideoCollModel.setVideoHeight(query.getInt(columnIndexOrThrow13));
                    int i10 = i7;
                    bSVideoCollModel.setVideoWidth(query.getInt(i10));
                    int i11 = columnIndexOrThrow15;
                    bSVideoCollModel.setRelativeBookId(query.getInt(i11));
                    int i12 = columnIndexOrThrow16;
                    int i13 = columnIndexOrThrow12;
                    bSVideoCollModel.setCurrentPlayIndex(query.getInt(i12));
                    int i14 = columnIndexOrThrow17;
                    if (query.isNull(i14)) {
                        i2 = i12;
                        string5 = null;
                    } else {
                        i2 = i12;
                        string5 = query.getString(i14);
                    }
                    bSVideoCollModel.setCurrentPlayVideoId(string5);
                    int i15 = columnIndexOrThrow18;
                    columnIndexOrThrow18 = i15;
                    if (query.getInt(i15) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    bSVideoCollModel.setFakeProgress(z3);
                    int i16 = columnIndexOrThrow19;
                    bSVideoCollModel.setLastCollectTime(query.getLong(i16));
                    int i17 = columnIndexOrThrow20;
                    bSVideoCollModel.setSeriesCountCollect(query.getInt(i17));
                    int i18 = columnIndexOrThrow21;
                    if (query.isNull(i18)) {
                        i3 = i16;
                        string6 = null;
                    } else {
                        i3 = i16;
                        string6 = query.getString(i18);
                    }
                    bSVideoCollModel.setVideoGroupName(string6);
                    columnIndexOrThrow20 = i17;
                    int i19 = columnIndexOrThrow22;
                    bSVideoCollModel.setBookshelfModifyTime(query.getLong(i19));
                    int i20 = columnIndexOrThrow23;
                    int i21 = columnIndexOrThrow4;
                    bSVideoCollModel.setCollectTime(query.getLong(i20));
                    int i22 = columnIndexOrThrow24;
                    if (query.isNull(i22)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(i22);
                    }
                    bSVideoCollModel.setSeriesIntroduction(string7);
                    int i23 = columnIndexOrThrow25;
                    if (query.isNull(i23)) {
                        i4 = i19;
                        string8 = null;
                    } else {
                        i4 = i19;
                        string8 = query.getString(i23);
                    }
                    bSVideoCollModel.setCurrentPlayPosition(string8);
                    int i24 = columnIndexOrThrow26;
                    if (query.isNull(i24)) {
                        columnIndexOrThrow26 = i24;
                        string9 = null;
                    } else {
                        columnIndexOrThrow26 = i24;
                        string9 = query.getString(i24);
                    }
                    bSVideoCollModel.setCurrentVideoTotalTime(string9);
                    int i25 = columnIndexOrThrow27;
                    bSVideoCollModel.setDiggCount(query.getLong(i25));
                    int i26 = columnIndexOrThrow28;
                    if (query.getInt(i26) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    bSVideoCollModel.setUserDigg(z4);
                    int i27 = columnIndexOrThrow29;
                    if (query.isNull(i27)) {
                        i5 = i25;
                        string10 = null;
                    } else {
                        i5 = i25;
                        string10 = query.getString(i27);
                    }
                    bSVideoCollModel.setPugcUserName(string10);
                    int i28 = columnIndexOrThrow30;
                    if (query.isNull(i28)) {
                        columnIndexOrThrow30 = i28;
                        string11 = null;
                    } else {
                        columnIndexOrThrow30 = i28;
                        string11 = query.getString(i28);
                    }
                    bSVideoCollModel.setPugcUserAvatar(string11);
                    int i29 = columnIndexOrThrow31;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow31 = i29;
                        string12 = null;
                    } else {
                        columnIndexOrThrow31 = i29;
                        string12 = query.getString(i29);
                    }
                    bSVideoCollModel.setVideoTagInfoJson(string12);
                    int i30 = columnIndexOrThrow32;
                    columnIndexOrThrow32 = i30;
                    if (query.getInt(i30) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    bSVideoCollModel.setMultiSeason(z5);
                    int i31 = columnIndexOrThrow33;
                    bSVideoCollModel.setSeasonIndex(query.getInt(i31));
                    int i32 = columnIndexOrThrow34;
                    if (query.isNull(i32)) {
                        i6 = i31;
                        string13 = null;
                    } else {
                        i6 = i31;
                        string13 = query.getString(i32);
                    }
                    bSVideoCollModel.setVideoCategoryType(string13);
                    int i33 = columnIndexOrThrow35;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow35 = i33;
                        string14 = null;
                    } else {
                        columnIndexOrThrow35 = i33;
                        string14 = query.getString(i33);
                    }
                    bSVideoCollModel.setRelatedSeriesTitle(string14);
                    arrayList.add(bSVideoCollModel);
                    columnIndexOrThrow33 = i6;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow34 = i32;
                    columnIndexOrThrow12 = i13;
                    columnIndexOrThrow16 = i2;
                    i7 = i10;
                    columnIndexOrThrow17 = i14;
                    columnIndexOrThrow28 = i26;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow15 = i11;
                    columnIndexOrThrow19 = i3;
                    columnIndexOrThrow21 = i18;
                    columnIndexOrThrow22 = i4;
                    columnIndexOrThrow25 = i23;
                    columnIndexOrThrow4 = i21;
                    columnIndexOrThrow23 = i20;
                    columnIndexOrThrow24 = i22;
                    columnIndexOrThrow27 = i5;
                    columnIndexOrThrow29 = i27;
                    columnIndexOrThrow3 = i9;
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

    @Override // nr4.b5
    public List<lr4.s1> k() {
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
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        String string6;
        boolean z3;
        int i2;
        String string7;
        String string8;
        String string9;
        boolean z4;
        int i3;
        String string10;
        String string11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_collection", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_status");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "group_name");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "collect_time");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "user_digg");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                lr4.s1 s1Var = new lr4.s1();
                if (query.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = query.getString(columnIndexOrThrow);
                }
                s1Var.g(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                s1Var.h(string2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                s1Var.a(string3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow4);
                }
                s1Var.f(string4);
                s1Var.e = query.getInt(columnIndexOrThrow5);
                int i5 = columnIndexOrThrow2;
                int i6 = columnIndexOrThrow3;
                s1Var.f = query.getLong(columnIndexOrThrow6);
                if (query.getInt(columnIndexOrThrow7) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                s1Var.g = z;
                if (query.getInt(columnIndexOrThrow8) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                s1Var.h = z2;
                int i7 = columnIndexOrThrow4;
                s1Var.i = query.getLong(columnIndexOrThrow9);
                s1Var.j = query.getInt(columnIndexOrThrow10);
                s1Var.k = query.getInt(columnIndexOrThrow11);
                if (query.isNull(columnIndexOrThrow12)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow12);
                }
                s1Var.b(string5);
                s1Var.m = query.getLong(columnIndexOrThrow13);
                int i8 = i4;
                int i9 = columnIndexOrThrow5;
                s1Var.n = query.getLong(i8);
                int i10 = columnIndexOrThrow15;
                if (query.isNull(i10)) {
                    string6 = null;
                } else {
                    string6 = query.getString(i10);
                }
                s1Var.i(string6);
                int i11 = columnIndexOrThrow16;
                s1Var.p = query.getLong(i11);
                int i12 = columnIndexOrThrow17;
                if (query.getInt(i12) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                s1Var.q = z3;
                int i13 = columnIndexOrThrow18;
                if (query.isNull(i13)) {
                    i2 = i5;
                    string7 = null;
                } else {
                    i2 = i5;
                    string7 = query.getString(i13);
                }
                s1Var.d(string7);
                int i14 = columnIndexOrThrow19;
                if (query.isNull(i14)) {
                    columnIndexOrThrow19 = i14;
                    string8 = null;
                } else {
                    columnIndexOrThrow19 = i14;
                    string8 = query.getString(i14);
                }
                s1Var.c(string8);
                int i15 = columnIndexOrThrow20;
                if (query.isNull(i15)) {
                    columnIndexOrThrow20 = i15;
                    string9 = null;
                } else {
                    columnIndexOrThrow20 = i15;
                    string9 = query.getString(i15);
                }
                s1Var.k(string9);
                int i16 = columnIndexOrThrow21;
                columnIndexOrThrow21 = i16;
                if (query.getInt(i16) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                s1Var.u = z4;
                int i17 = columnIndexOrThrow12;
                int i18 = columnIndexOrThrow22;
                s1Var.v = query.getInt(i18);
                int i19 = columnIndexOrThrow23;
                if (query.isNull(i19)) {
                    i3 = i18;
                    string10 = null;
                } else {
                    i3 = i18;
                    string10 = query.getString(i19);
                }
                s1Var.j(string10);
                int i20 = columnIndexOrThrow24;
                if (query.isNull(i20)) {
                    columnIndexOrThrow24 = i20;
                    string11 = null;
                } else {
                    columnIndexOrThrow24 = i20;
                    string11 = query.getString(i20);
                }
                s1Var.e(string11);
                arrayList.add(s1Var);
                columnIndexOrThrow22 = i3;
                columnIndexOrThrow = i;
                columnIndexOrThrow23 = i19;
                columnIndexOrThrow12 = i17;
                columnIndexOrThrow17 = i12;
                columnIndexOrThrow2 = i2;
                columnIndexOrThrow18 = i13;
                columnIndexOrThrow3 = i6;
                columnIndexOrThrow15 = i10;
                columnIndexOrThrow4 = i7;
                columnIndexOrThrow16 = i11;
                columnIndexOrThrow5 = i9;
                i4 = i8;
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

    public d5(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
    }

    @Override // nr4.b5
    public void e(lr4.t1 t1Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(t1Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.b5
    public void f(String str) {
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

    @Override // nr4.b5
    public void j(List<lr4.t1> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.b5
    public void l(List<lr4.s1> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.b5
    public void i(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM t_video_serial_collection WHERE series_id IN (");
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

    @Override // nr4.b5
    public lr4.t1 c(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.t1 t1Var;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        boolean z;
        String string9;
        String string10;
        boolean z2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_progress WHERE series_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "current_play_video_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "current_video_title");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "total_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "last_video_vid");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "relative_book_id");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "is_fake_progress");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "video_scene");
                if (query.moveToFirst()) {
                    lr4.t1 t1Var2 = new lr4.t1();
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    t1Var2.h(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    t1Var2.i(string2);
                    t1Var2.c = query.getInt(columnIndexOrThrow3);
                    t1Var2.d = query.getInt(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    t1Var2.b(string3);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow6);
                    }
                    t1Var2.c(string4);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow7);
                    }
                    t1Var2.j(string5);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow8);
                    }
                    t1Var2.a(string6);
                    if (query.isNull(columnIndexOrThrow9)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow9);
                    }
                    t1Var2.d(string7);
                    if (query.isNull(columnIndexOrThrow10)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow10);
                    }
                    t1Var2.e(string8);
                    t1Var2.k = query.getLong(columnIndexOrThrow11);
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t1Var2.l = z;
                    t1Var2.m = query.getInt(columnIndexOrThrow13);
                    t1Var2.n = query.getInt(columnIndexOrThrow14);
                    if (query.isNull(columnIndexOrThrow15)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow15);
                    }
                    t1Var2.g(string9);
                    if (query.isNull(columnIndexOrThrow16)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow16);
                    }
                    t1Var2.f(string10);
                    if (query.getInt(columnIndexOrThrow17) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t1Var2.q = z2;
                    t1Var2.r = query.getLong(columnIndexOrThrow18);
                    t1Var2.s = query.getLong(columnIndexOrThrow19);
                    t1Var2.t = query.getInt(columnIndexOrThrow20);
                    t1Var2.u = query.getInt(columnIndexOrThrow21);
                    t1Var2.v = query.getInt(columnIndexOrThrow22);
                    t1Var = t1Var2;
                } else {
                    t1Var = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return t1Var;
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

    @Override // nr4.b5
    public lr4.s1 h(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.s1 s1Var;
        String string;
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
        boolean z4;
        String string10;
        String string11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_collection  WHERE series_id =? LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_status");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "last_update_time");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "is_sync");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "series_cnt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "group_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "booklist_operate_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "collect_time");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "user_digg");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
                if (query.moveToFirst()) {
                    lr4.s1 s1Var2 = new lr4.s1();
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    s1Var2.g(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    s1Var2.h(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    s1Var2.a(string3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    s1Var2.f(string4);
                    s1Var2.e = query.getInt(columnIndexOrThrow5);
                    s1Var2.f = query.getLong(columnIndexOrThrow6);
                    if (query.getInt(columnIndexOrThrow7) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    s1Var2.g = z;
                    if (query.getInt(columnIndexOrThrow8) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    s1Var2.h = z2;
                    s1Var2.i = query.getLong(columnIndexOrThrow9);
                    s1Var2.j = query.getInt(columnIndexOrThrow10);
                    s1Var2.k = query.getInt(columnIndexOrThrow11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow12);
                    }
                    s1Var2.b(string5);
                    s1Var2.m = query.getLong(columnIndexOrThrow13);
                    s1Var2.n = query.getLong(columnIndexOrThrow14);
                    if (query.isNull(columnIndexOrThrow15)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow15);
                    }
                    s1Var2.i(string6);
                    s1Var2.p = query.getLong(columnIndexOrThrow16);
                    if (query.getInt(columnIndexOrThrow17) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    s1Var2.q = z3;
                    if (query.isNull(columnIndexOrThrow18)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow18);
                    }
                    s1Var2.d(string7);
                    if (query.isNull(columnIndexOrThrow19)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow19);
                    }
                    s1Var2.c(string8);
                    if (query.isNull(columnIndexOrThrow20)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow20);
                    }
                    s1Var2.k(string9);
                    if (query.getInt(columnIndexOrThrow21) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    s1Var2.u = z4;
                    s1Var2.v = query.getInt(columnIndexOrThrow22);
                    if (query.isNull(columnIndexOrThrow23)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow23);
                    }
                    s1Var2.j(string10);
                    if (query.isNull(columnIndexOrThrow24)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow24);
                    }
                    s1Var2.e(string11);
                    s1Var = s1Var2;
                } else {
                    s1Var = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return s1Var;
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

    class a extends EntityInsertionAdapter<lr4.t1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_video_serial_progress` (`series_id`,`series_name`,`series_cnt`,`current_play_video_index`,`current_play_video_id`,`current_video_title`,`total_time`,`current_play_position`,`current_video_total_time`,`last_video_vid`,`update_time`,`is_sync`,`video_width`,`video_height`,`relative_book_id`,`player_accumulate_total_time`,`is_fake_progress`,`channel_id`,`cur_channel_id`,`book_type`,`content_type`,`video_scene`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.t1 t1Var) {
            String str = t1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = t1Var.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, t1Var.c);
            supportSQLiteStatement.bindLong(4, t1Var.d);
            String str3 = t1Var.e;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str3);
            }
            String str4 = t1Var.f;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str4);
            }
            String str5 = t1Var.g;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str5);
            }
            String str6 = t1Var.h;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str6);
            }
            String str7 = t1Var.i;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str7);
            }
            String str8 = t1Var.j;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str8);
            }
            supportSQLiteStatement.bindLong(11, t1Var.k);
            supportSQLiteStatement.bindLong(12, t1Var.l ? 1L : 0L);
            supportSQLiteStatement.bindLong(13, t1Var.m);
            supportSQLiteStatement.bindLong(14, t1Var.n);
            String str9 = t1Var.o;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str9);
            }
            String str10 = t1Var.p;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str10);
            }
            supportSQLiteStatement.bindLong(17, t1Var.q ? 1L : 0L);
            supportSQLiteStatement.bindLong(18, t1Var.r);
            supportSQLiteStatement.bindLong(19, t1Var.s);
            supportSQLiteStatement.bindLong(20, t1Var.t);
            supportSQLiteStatement.bindLong(21, t1Var.u);
            supportSQLiteStatement.bindLong(22, t1Var.v);
        }
    }

    class b extends EntityInsertionAdapter<lr4.s1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_video_serial_collection` (`series_id`,`series_name`,`cover_url`,`series_color_hex`,`series_status`,`last_update_time`,`is_delete`,`is_sync`,`series_cnt`,`update_status`,`content_type`,`group_name`,`booklist_operate_time`,`collect_time`,`update_tag_text`,`digged_count`,`user_digg`,`pugc_user_name`,`pugc_user_avatar`,`video_tag_info`,`is_multi_season`,`season_index`,`video_category_type`,`related_series_title`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.s1 s1Var) {
            String str = s1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = s1Var.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = s1Var.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = s1Var.d;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            supportSQLiteStatement.bindLong(5, s1Var.e);
            supportSQLiteStatement.bindLong(6, s1Var.f);
            supportSQLiteStatement.bindLong(7, s1Var.g ? 1L : 0L);
            supportSQLiteStatement.bindLong(8, s1Var.h ? 1L : 0L);
            supportSQLiteStatement.bindLong(9, s1Var.i);
            supportSQLiteStatement.bindLong(10, s1Var.j);
            supportSQLiteStatement.bindLong(11, s1Var.k);
            String str5 = s1Var.l;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            supportSQLiteStatement.bindLong(13, s1Var.m);
            supportSQLiteStatement.bindLong(14, s1Var.n);
            String str6 = s1Var.o;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str6);
            }
            supportSQLiteStatement.bindLong(16, s1Var.p);
            supportSQLiteStatement.bindLong(17, s1Var.q ? 1L : 0L);
            String str7 = s1Var.r;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str7);
            }
            String str8 = s1Var.s;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str8);
            }
            String str9 = s1Var.t;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str9);
            }
            supportSQLiteStatement.bindLong(21, s1Var.u ? 1L : 0L);
            supportSQLiteStatement.bindLong(22, s1Var.v);
            String str10 = s1Var.w;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str10);
            }
            String str11 = s1Var.x;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str11);
            }
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<lr4.t1> {
        public String createQuery() {
            return "DELETE FROM `t_video_serial_progress` WHERE `series_id` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.t1 t1Var) {
            String str = t1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class d extends EntityDeletionOrUpdateAdapter<lr4.t1> {
        public String createQuery() {
            return "UPDATE OR ABORT `t_video_serial_progress` SET `series_id` = ?,`series_name` = ?,`series_cnt` = ?,`current_play_video_index` = ?,`current_play_video_id` = ?,`current_video_title` = ?,`total_time` = ?,`current_play_position` = ?,`current_video_total_time` = ?,`last_video_vid` = ?,`update_time` = ?,`is_sync` = ?,`video_width` = ?,`video_height` = ?,`relative_book_id` = ?,`player_accumulate_total_time` = ?,`is_fake_progress` = ?,`channel_id` = ?,`cur_channel_id` = ?,`book_type` = ?,`content_type` = ?,`video_scene` = ? WHERE `series_id` = ?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.t1 t1Var) {
            String str = t1Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = t1Var.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, t1Var.c);
            supportSQLiteStatement.bindLong(4, t1Var.d);
            String str3 = t1Var.e;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str3);
            }
            String str4 = t1Var.f;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str4);
            }
            String str5 = t1Var.g;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str5);
            }
            String str6 = t1Var.h;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str6);
            }
            String str7 = t1Var.i;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str7);
            }
            String str8 = t1Var.j;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str8);
            }
            supportSQLiteStatement.bindLong(11, t1Var.k);
            supportSQLiteStatement.bindLong(12, t1Var.l ? 1L : 0L);
            supportSQLiteStatement.bindLong(13, t1Var.m);
            supportSQLiteStatement.bindLong(14, t1Var.n);
            String str9 = t1Var.o;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str9);
            }
            String str10 = t1Var.p;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str10);
            }
            supportSQLiteStatement.bindLong(17, t1Var.q ? 1L : 0L);
            supportSQLiteStatement.bindLong(18, t1Var.r);
            supportSQLiteStatement.bindLong(19, t1Var.s);
            supportSQLiteStatement.bindLong(20, t1Var.t);
            supportSQLiteStatement.bindLong(21, t1Var.u);
            supportSQLiteStatement.bindLong(22, t1Var.v);
            String str11 = t1Var.a;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str11);
            }
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_video_serial_progress WHERE series_id =?";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
