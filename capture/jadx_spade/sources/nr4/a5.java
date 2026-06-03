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
public final class a5 implements y4 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<dv4.a> b;
    private final EntityDeletionOrUpdateAdapter<dv4.a> c;
    private final EntityDeletionOrUpdateAdapter<dv4.a> d;
    private final SharedSQLiteStatement e;
    private final SharedSQLiteStatement f;

    static {
        Covode.recordClassIndex(611800);
    }

    public static List<Class<?>> l() {
        return Collections.emptyList();
    }

    @Override // nr4.y4
    public List<dv4.a> d() {
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
        int i2;
        String string13;
        int i3;
        String string14;
        String string15;
        String string16;
        String string17;
        int i4;
        String string18;
        int i5;
        String string19;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        String string20;
        String string21;
        String string22;
        String string23;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        String string24;
        boolean z5;
        String string25;
        String string26;
        String string27;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_history_record WHERE has_sync = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "author_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "episodes_list_count_text");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "current_video_title");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "vid");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "total_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "last_video_vid");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "record_index");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "video_platform");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "episode_cnt");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_index");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "update_tag");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "played_video_ids");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "stayed_video_ids");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "series_play_count");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "video_scene");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "is_user_digg");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "is_interactive_game");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "secondary_info");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
                int i10 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    dv4.a aVar = new dv4.a();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    aVar.a = string;
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    aVar.b = string2;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    aVar.c = string3;
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    aVar.d = string4;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    aVar.m(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    aVar.f = string6;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    aVar.g = string7;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    aVar.h = string8;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow9);
                    }
                    aVar.i = string9;
                    if (query.isNull(columnIndexOrThrow10)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow10);
                    }
                    aVar.j = string10;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow11);
                    }
                    aVar.i(string11);
                    aVar.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow13);
                    }
                    aVar.m = string12;
                    int i11 = i10;
                    if (query.isNull(i11)) {
                        i2 = i11;
                        string13 = null;
                    } else {
                        i2 = i11;
                        string13 = query.getString(i11);
                    }
                    aVar.n = string13;
                    int i12 = columnIndexOrThrow15;
                    if (query.isNull(i12)) {
                        i3 = i12;
                        string14 = null;
                    } else {
                        i3 = i12;
                        string14 = query.getString(i12);
                    }
                    aVar.o = string14;
                    int i13 = columnIndexOrThrow16;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow16 = i13;
                        string15 = null;
                    } else {
                        columnIndexOrThrow16 = i13;
                        string15 = query.getString(i13);
                    }
                    aVar.p = string15;
                    int i14 = columnIndexOrThrow17;
                    if (query.isNull(i14)) {
                        columnIndexOrThrow17 = i14;
                        string16 = null;
                    } else {
                        columnIndexOrThrow17 = i14;
                        string16 = query.getString(i14);
                    }
                    aVar.q = string16;
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow18;
                    int i17 = columnIndexOrThrow3;
                    aVar.r = query.getLong(i16);
                    int i18 = columnIndexOrThrow19;
                    aVar.s = query.getInt(i18);
                    int i19 = columnIndexOrThrow20;
                    aVar.t = query.getInt(i19);
                    int i20 = columnIndexOrThrow12;
                    int i21 = columnIndexOrThrow21;
                    aVar.u = query.getInt(i21);
                    columnIndexOrThrow21 = i21;
                    int i22 = columnIndexOrThrow22;
                    aVar.v = query.getInt(i22);
                    int i23 = columnIndexOrThrow23;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow23 = i23;
                        string17 = null;
                    } else {
                        columnIndexOrThrow23 = i23;
                        string17 = query.getString(i23);
                    }
                    aVar.l(string17);
                    columnIndexOrThrow22 = i22;
                    int i24 = columnIndexOrThrow24;
                    aVar.x = query.getInt(i24);
                    int i25 = columnIndexOrThrow25;
                    if (query.isNull(i25)) {
                        i4 = i24;
                        string18 = null;
                    } else {
                        i4 = i24;
                        string18 = query.getString(i25);
                    }
                    aVar.n(string18);
                    int i26 = columnIndexOrThrow26;
                    aVar.z = query.getInt(i26);
                    int i27 = columnIndexOrThrow27;
                    if (query.isNull(i27)) {
                        i5 = i26;
                        string19 = null;
                    } else {
                        i5 = i26;
                        string19 = query.getString(i27);
                    }
                    aVar.A = string19;
                    int i28 = columnIndexOrThrow28;
                    if (query.getInt(i28) != 0) {
                        i6 = i28;
                        z = true;
                    } else {
                        i6 = i28;
                        z = false;
                    }
                    aVar.B = z;
                    int i29 = columnIndexOrThrow29;
                    if (query.getInt(i29) != 0) {
                        columnIndexOrThrow29 = i29;
                        z2 = true;
                    } else {
                        columnIndexOrThrow29 = i29;
                        z2 = false;
                    }
                    aVar.C = z2;
                    int i30 = columnIndexOrThrow30;
                    if (query.isNull(i30)) {
                        i7 = i30;
                        string20 = null;
                    } else {
                        i7 = i30;
                        string20 = query.getString(i30);
                    }
                    aVar.D = string20;
                    int i31 = columnIndexOrThrow31;
                    if (query.isNull(i31)) {
                        columnIndexOrThrow31 = i31;
                        string21 = null;
                    } else {
                        columnIndexOrThrow31 = i31;
                        string21 = query.getString(i31);
                    }
                    aVar.E = string21;
                    int i32 = columnIndexOrThrow32;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow32 = i32;
                        string22 = null;
                    } else {
                        columnIndexOrThrow32 = i32;
                        string22 = query.getString(i32);
                    }
                    aVar.F = string22;
                    int i33 = columnIndexOrThrow33;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow33 = i33;
                        string23 = null;
                    } else {
                        columnIndexOrThrow33 = i33;
                        string23 = query.getString(i33);
                    }
                    aVar.G = string23;
                    int i34 = columnIndexOrThrow34;
                    aVar.H = query.getLong(i34);
                    int i35 = columnIndexOrThrow35;
                    aVar.I = query.getInt(i35);
                    int i36 = columnIndexOrThrow4;
                    int i37 = columnIndexOrThrow36;
                    int i38 = columnIndexOrThrow5;
                    aVar.J = query.getLong(i37);
                    int i39 = columnIndexOrThrow37;
                    if (query.getInt(i39) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    aVar.K = z3;
                    int i40 = columnIndexOrThrow38;
                    if (query.getInt(i40) != 0) {
                        i8 = i34;
                        z4 = true;
                    } else {
                        i8 = i34;
                        z4 = false;
                    }
                    aVar.L = z4;
                    int i41 = columnIndexOrThrow39;
                    aVar.M = query.getInt(i41);
                    int i42 = columnIndexOrThrow40;
                    if (query.isNull(i42)) {
                        i9 = i41;
                        string24 = null;
                    } else {
                        i9 = i41;
                        string24 = query.getString(i42);
                    }
                    aVar.p(string24);
                    int i43 = columnIndexOrThrow41;
                    columnIndexOrThrow41 = i43;
                    if (query.getInt(i43) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    aVar.O = z5;
                    int i44 = columnIndexOrThrow42;
                    aVar.P = query.getInt(i44);
                    int i45 = columnIndexOrThrow43;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow42 = i44;
                        string25 = null;
                    } else {
                        columnIndexOrThrow42 = i44;
                        string25 = query.getString(i45);
                    }
                    aVar.j(string25);
                    int i46 = columnIndexOrThrow44;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow44 = i46;
                        string26 = null;
                    } else {
                        columnIndexOrThrow44 = i46;
                        string26 = query.getString(i46);
                    }
                    aVar.k(string26);
                    int i47 = columnIndexOrThrow45;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow45 = i47;
                        string27 = null;
                    } else {
                        columnIndexOrThrow45 = i47;
                        string27 = query.getString(i47);
                    }
                    aVar.o(string27);
                    arrayList.add(aVar);
                    columnIndexOrThrow43 = i45;
                    columnIndexOrThrow12 = i20;
                    columnIndexOrThrow20 = i19;
                    columnIndexOrThrow34 = i8;
                    columnIndexOrThrow39 = i9;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow37 = i39;
                    columnIndexOrThrow40 = i42;
                    columnIndexOrThrow4 = i36;
                    columnIndexOrThrow35 = i35;
                    columnIndexOrThrow2 = i15;
                    columnIndexOrThrow28 = i6;
                    columnIndexOrThrow26 = i5;
                    columnIndexOrThrow27 = i27;
                    columnIndexOrThrow15 = i3;
                    i10 = i2;
                    columnIndexOrThrow38 = i40;
                    columnIndexOrThrow5 = i38;
                    columnIndexOrThrow36 = i37;
                    columnIndexOrThrow3 = i17;
                    columnIndexOrThrow18 = i16;
                    columnIndexOrThrow19 = i18;
                    columnIndexOrThrow30 = i7;
                    int i48 = i4;
                    columnIndexOrThrow25 = i25;
                    columnIndexOrThrow24 = i48;
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

    @Override // nr4.y4
    public List<dv4.a> i() {
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
        int i2;
        String string13;
        int i3;
        String string14;
        String string15;
        String string16;
        String string17;
        int i4;
        String string18;
        int i5;
        String string19;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        String string20;
        String string21;
        String string22;
        String string23;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        String string24;
        boolean z5;
        String string25;
        String string26;
        String string27;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_history_record", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "author_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "episodes_list_count_text");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "current_video_title");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "vid");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "total_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "last_video_vid");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "record_index");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "video_platform");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "episode_cnt");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_index");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "update_tag");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "played_video_ids");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "stayed_video_ids");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "series_play_count");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "video_scene");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "is_user_digg");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "is_interactive_game");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "secondary_info");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
                int i10 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    dv4.a aVar = new dv4.a();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    aVar.a = string;
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    aVar.b = string2;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    aVar.c = string3;
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    aVar.d = string4;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    aVar.m(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    aVar.f = string6;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    aVar.g = string7;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    aVar.h = string8;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow9);
                    }
                    aVar.i = string9;
                    if (query.isNull(columnIndexOrThrow10)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow10);
                    }
                    aVar.j = string10;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow11);
                    }
                    aVar.i(string11);
                    aVar.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow13);
                    }
                    aVar.m = string12;
                    int i11 = i10;
                    if (query.isNull(i11)) {
                        i2 = i11;
                        string13 = null;
                    } else {
                        i2 = i11;
                        string13 = query.getString(i11);
                    }
                    aVar.n = string13;
                    int i12 = columnIndexOrThrow15;
                    if (query.isNull(i12)) {
                        i3 = i12;
                        string14 = null;
                    } else {
                        i3 = i12;
                        string14 = query.getString(i12);
                    }
                    aVar.o = string14;
                    int i13 = columnIndexOrThrow16;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow16 = i13;
                        string15 = null;
                    } else {
                        columnIndexOrThrow16 = i13;
                        string15 = query.getString(i13);
                    }
                    aVar.p = string15;
                    int i14 = columnIndexOrThrow17;
                    if (query.isNull(i14)) {
                        columnIndexOrThrow17 = i14;
                        string16 = null;
                    } else {
                        columnIndexOrThrow17 = i14;
                        string16 = query.getString(i14);
                    }
                    aVar.q = string16;
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow18;
                    int i17 = columnIndexOrThrow3;
                    aVar.r = query.getLong(i16);
                    int i18 = columnIndexOrThrow19;
                    aVar.s = query.getInt(i18);
                    int i19 = columnIndexOrThrow20;
                    aVar.t = query.getInt(i19);
                    int i20 = columnIndexOrThrow12;
                    int i21 = columnIndexOrThrow21;
                    aVar.u = query.getInt(i21);
                    columnIndexOrThrow21 = i21;
                    int i22 = columnIndexOrThrow22;
                    aVar.v = query.getInt(i22);
                    int i23 = columnIndexOrThrow23;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow23 = i23;
                        string17 = null;
                    } else {
                        columnIndexOrThrow23 = i23;
                        string17 = query.getString(i23);
                    }
                    aVar.l(string17);
                    columnIndexOrThrow22 = i22;
                    int i24 = columnIndexOrThrow24;
                    aVar.x = query.getInt(i24);
                    int i25 = columnIndexOrThrow25;
                    if (query.isNull(i25)) {
                        i4 = i24;
                        string18 = null;
                    } else {
                        i4 = i24;
                        string18 = query.getString(i25);
                    }
                    aVar.n(string18);
                    int i26 = columnIndexOrThrow26;
                    aVar.z = query.getInt(i26);
                    int i27 = columnIndexOrThrow27;
                    if (query.isNull(i27)) {
                        i5 = i26;
                        string19 = null;
                    } else {
                        i5 = i26;
                        string19 = query.getString(i27);
                    }
                    aVar.A = string19;
                    int i28 = columnIndexOrThrow28;
                    if (query.getInt(i28) != 0) {
                        i6 = i28;
                        z = true;
                    } else {
                        i6 = i28;
                        z = false;
                    }
                    aVar.B = z;
                    int i29 = columnIndexOrThrow29;
                    if (query.getInt(i29) != 0) {
                        columnIndexOrThrow29 = i29;
                        z2 = true;
                    } else {
                        columnIndexOrThrow29 = i29;
                        z2 = false;
                    }
                    aVar.C = z2;
                    int i30 = columnIndexOrThrow30;
                    if (query.isNull(i30)) {
                        i7 = i30;
                        string20 = null;
                    } else {
                        i7 = i30;
                        string20 = query.getString(i30);
                    }
                    aVar.D = string20;
                    int i31 = columnIndexOrThrow31;
                    if (query.isNull(i31)) {
                        columnIndexOrThrow31 = i31;
                        string21 = null;
                    } else {
                        columnIndexOrThrow31 = i31;
                        string21 = query.getString(i31);
                    }
                    aVar.E = string21;
                    int i32 = columnIndexOrThrow32;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow32 = i32;
                        string22 = null;
                    } else {
                        columnIndexOrThrow32 = i32;
                        string22 = query.getString(i32);
                    }
                    aVar.F = string22;
                    int i33 = columnIndexOrThrow33;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow33 = i33;
                        string23 = null;
                    } else {
                        columnIndexOrThrow33 = i33;
                        string23 = query.getString(i33);
                    }
                    aVar.G = string23;
                    int i34 = columnIndexOrThrow34;
                    aVar.H = query.getLong(i34);
                    int i35 = columnIndexOrThrow35;
                    aVar.I = query.getInt(i35);
                    int i36 = columnIndexOrThrow4;
                    int i37 = columnIndexOrThrow36;
                    int i38 = columnIndexOrThrow5;
                    aVar.J = query.getLong(i37);
                    int i39 = columnIndexOrThrow37;
                    if (query.getInt(i39) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    aVar.K = z3;
                    int i40 = columnIndexOrThrow38;
                    if (query.getInt(i40) != 0) {
                        i8 = i34;
                        z4 = true;
                    } else {
                        i8 = i34;
                        z4 = false;
                    }
                    aVar.L = z4;
                    int i41 = columnIndexOrThrow39;
                    aVar.M = query.getInt(i41);
                    int i42 = columnIndexOrThrow40;
                    if (query.isNull(i42)) {
                        i9 = i41;
                        string24 = null;
                    } else {
                        i9 = i41;
                        string24 = query.getString(i42);
                    }
                    aVar.p(string24);
                    int i43 = columnIndexOrThrow41;
                    columnIndexOrThrow41 = i43;
                    if (query.getInt(i43) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    aVar.O = z5;
                    int i44 = columnIndexOrThrow42;
                    aVar.P = query.getInt(i44);
                    int i45 = columnIndexOrThrow43;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow42 = i44;
                        string25 = null;
                    } else {
                        columnIndexOrThrow42 = i44;
                        string25 = query.getString(i45);
                    }
                    aVar.j(string25);
                    int i46 = columnIndexOrThrow44;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow44 = i46;
                        string26 = null;
                    } else {
                        columnIndexOrThrow44 = i46;
                        string26 = query.getString(i46);
                    }
                    aVar.k(string26);
                    int i47 = columnIndexOrThrow45;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow45 = i47;
                        string27 = null;
                    } else {
                        columnIndexOrThrow45 = i47;
                        string27 = query.getString(i47);
                    }
                    aVar.o(string27);
                    arrayList.add(aVar);
                    columnIndexOrThrow43 = i45;
                    columnIndexOrThrow12 = i20;
                    columnIndexOrThrow20 = i19;
                    columnIndexOrThrow34 = i8;
                    columnIndexOrThrow39 = i9;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow37 = i39;
                    columnIndexOrThrow40 = i42;
                    columnIndexOrThrow4 = i36;
                    columnIndexOrThrow35 = i35;
                    columnIndexOrThrow2 = i15;
                    columnIndexOrThrow28 = i6;
                    columnIndexOrThrow26 = i5;
                    columnIndexOrThrow27 = i27;
                    columnIndexOrThrow15 = i3;
                    i10 = i2;
                    columnIndexOrThrow38 = i40;
                    columnIndexOrThrow5 = i38;
                    columnIndexOrThrow36 = i37;
                    columnIndexOrThrow3 = i17;
                    columnIndexOrThrow18 = i16;
                    columnIndexOrThrow19 = i18;
                    columnIndexOrThrow30 = i7;
                    int i48 = i4;
                    columnIndexOrThrow25 = i25;
                    columnIndexOrThrow24 = i48;
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

    public a5(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
    }

    @Override // nr4.y4
    public void a(List<dv4.a> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y4
    public void c(List<dv4.a> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y4
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

    @Override // nr4.y4
    public void j(dv4.a... aVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.d.handleMultiple(aVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y4
    public void k(dv4.a aVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(aVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.y4
    public void b(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE t_video_history_record set has_sync = 1 where series_id in(");
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

    @Override // nr4.y4
    public void g(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM t_video_history_record WHERE series_id in (");
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

    @Override // nr4.y4
    public dv4.a e(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        dv4.a aVar;
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
        boolean z;
        boolean z2;
        String string20;
        String string21;
        String string22;
        String string23;
        boolean z3;
        boolean z4;
        String string24;
        boolean z5;
        String string25;
        String string26;
        String string27;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT * FROM t_video_history_record WHERE series_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "author_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "episodes_list_count_text");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "current_video_title");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "vid");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "total_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "last_video_vid");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "record_index");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "video_platform");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "episode_cnt");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_index");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "update_tag");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "played_video_ids");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "stayed_video_ids");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "series_play_count");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "video_scene");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "is_user_digg");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "is_interactive_game");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "secondary_info");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
                if (query.moveToFirst()) {
                    dv4.a aVar2 = new dv4.a();
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    aVar2.a = string;
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    aVar2.b = string2;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    aVar2.c = string3;
                    if (query.isNull(columnIndexOrThrow4)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow4);
                    }
                    aVar2.d = string4;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow5);
                    }
                    aVar2.m(string5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow6);
                    }
                    aVar2.f = string6;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow7);
                    }
                    aVar2.g = string7;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow8);
                    }
                    aVar2.h = string8;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow9);
                    }
                    aVar2.i = string9;
                    if (query.isNull(columnIndexOrThrow10)) {
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow10);
                    }
                    aVar2.j = string10;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string11 = null;
                    } else {
                        string11 = query.getString(columnIndexOrThrow11);
                    }
                    aVar2.i(string11);
                    aVar2.l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        string12 = null;
                    } else {
                        string12 = query.getString(columnIndexOrThrow13);
                    }
                    aVar2.m = string12;
                    if (query.isNull(columnIndexOrThrow14)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(columnIndexOrThrow14);
                    }
                    aVar2.n = string13;
                    if (query.isNull(columnIndexOrThrow15)) {
                        string14 = null;
                    } else {
                        string14 = query.getString(columnIndexOrThrow15);
                    }
                    aVar2.o = string14;
                    if (query.isNull(columnIndexOrThrow16)) {
                        string15 = null;
                    } else {
                        string15 = query.getString(columnIndexOrThrow16);
                    }
                    aVar2.p = string15;
                    if (query.isNull(columnIndexOrThrow17)) {
                        string16 = null;
                    } else {
                        string16 = query.getString(columnIndexOrThrow17);
                    }
                    aVar2.q = string16;
                    aVar2.r = query.getLong(columnIndexOrThrow18);
                    aVar2.s = query.getInt(columnIndexOrThrow19);
                    aVar2.t = query.getInt(columnIndexOrThrow20);
                    aVar2.u = query.getInt(columnIndexOrThrow21);
                    aVar2.v = query.getInt(columnIndexOrThrow22);
                    if (query.isNull(columnIndexOrThrow23)) {
                        string17 = null;
                    } else {
                        string17 = query.getString(columnIndexOrThrow23);
                    }
                    aVar2.l(string17);
                    aVar2.x = query.getInt(columnIndexOrThrow24);
                    if (query.isNull(columnIndexOrThrow25)) {
                        string18 = null;
                    } else {
                        string18 = query.getString(columnIndexOrThrow25);
                    }
                    aVar2.n(string18);
                    aVar2.z = query.getInt(columnIndexOrThrow26);
                    if (query.isNull(columnIndexOrThrow27)) {
                        string19 = null;
                    } else {
                        string19 = query.getString(columnIndexOrThrow27);
                    }
                    aVar2.A = string19;
                    if (query.getInt(columnIndexOrThrow28) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar2.B = z;
                    if (query.getInt(columnIndexOrThrow29) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    aVar2.C = z2;
                    if (query.isNull(columnIndexOrThrow30)) {
                        string20 = null;
                    } else {
                        string20 = query.getString(columnIndexOrThrow30);
                    }
                    aVar2.D = string20;
                    if (query.isNull(columnIndexOrThrow31)) {
                        string21 = null;
                    } else {
                        string21 = query.getString(columnIndexOrThrow31);
                    }
                    aVar2.E = string21;
                    if (query.isNull(columnIndexOrThrow32)) {
                        string22 = null;
                    } else {
                        string22 = query.getString(columnIndexOrThrow32);
                    }
                    aVar2.F = string22;
                    if (query.isNull(columnIndexOrThrow33)) {
                        string23 = null;
                    } else {
                        string23 = query.getString(columnIndexOrThrow33);
                    }
                    aVar2.G = string23;
                    aVar2.H = query.getLong(columnIndexOrThrow34);
                    aVar2.I = query.getInt(columnIndexOrThrow35);
                    aVar2.J = query.getLong(columnIndexOrThrow36);
                    if (query.getInt(columnIndexOrThrow37) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    aVar2.K = z3;
                    if (query.getInt(columnIndexOrThrow38) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    aVar2.L = z4;
                    aVar2.M = query.getInt(columnIndexOrThrow39);
                    if (query.isNull(columnIndexOrThrow40)) {
                        string24 = null;
                    } else {
                        string24 = query.getString(columnIndexOrThrow40);
                    }
                    aVar2.p(string24);
                    if (query.getInt(columnIndexOrThrow41) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    aVar2.O = z5;
                    aVar2.P = query.getInt(columnIndexOrThrow42);
                    if (query.isNull(columnIndexOrThrow43)) {
                        string25 = null;
                    } else {
                        string25 = query.getString(columnIndexOrThrow43);
                    }
                    aVar2.j(string25);
                    if (query.isNull(columnIndexOrThrow44)) {
                        string26 = null;
                    } else {
                        string26 = query.getString(columnIndexOrThrow44);
                    }
                    aVar2.k(string26);
                    if (query.isNull(columnIndexOrThrow45)) {
                        string27 = null;
                    } else {
                        string27 = query.getString(columnIndexOrThrow45);
                    }
                    aVar2.o(string27);
                    aVar = aVar2;
                } else {
                    aVar = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return aVar;
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

    @Override // nr4.y4
    public dv4.a h(long j) {
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
        dv4.a aVar;
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
        boolean z;
        boolean z2;
        String string20;
        String string21;
        String string22;
        String string23;
        boolean z3;
        boolean z4;
        String string24;
        boolean z5;
        String string25;
        String string26;
        String string27;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_history_record WHERE record_index = ?", 1);
        acquire.bindLong(1, j);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "author_name");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "author_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "book_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "series_name");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_id");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "episodes_list_count_text");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "current_video_title");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "cover_url");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "vid");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "content_type");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "total_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "current_play_position");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "current_video_total_time");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "last_video_vid");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "player_accumulate_total_time");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "record_index");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "video_platform");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "episode_cnt");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "series_color_hex");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "current_episode_index");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "update_tag");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "update_status");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "played_video_ids");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "has_sync");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "is_delete");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "stayed_video_ids");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "update_tag_text");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_name");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "pugc_user_avatar");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "series_play_count");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "video_scene");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "is_user_digg");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "is_multi_season");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "is_interactive_game");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "related_series_title");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "secondary_info");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
            if (query.moveToFirst()) {
                dv4.a aVar2 = new dv4.a();
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                aVar2.a = string;
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                aVar2.b = string2;
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                aVar2.c = string3;
                if (query.isNull(columnIndexOrThrow4)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow4);
                }
                aVar2.d = string4;
                if (query.isNull(columnIndexOrThrow5)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow5);
                }
                aVar2.m(string5);
                if (query.isNull(columnIndexOrThrow6)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow6);
                }
                aVar2.f = string6;
                if (query.isNull(columnIndexOrThrow7)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow7);
                }
                aVar2.g = string7;
                if (query.isNull(columnIndexOrThrow8)) {
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow8);
                }
                aVar2.h = string8;
                if (query.isNull(columnIndexOrThrow9)) {
                    string9 = null;
                } else {
                    string9 = query.getString(columnIndexOrThrow9);
                }
                aVar2.i = string9;
                if (query.isNull(columnIndexOrThrow10)) {
                    string10 = null;
                } else {
                    string10 = query.getString(columnIndexOrThrow10);
                }
                aVar2.j = string10;
                if (query.isNull(columnIndexOrThrow11)) {
                    string11 = null;
                } else {
                    string11 = query.getString(columnIndexOrThrow11);
                }
                aVar2.i(string11);
                aVar2.l = query.getInt(columnIndexOrThrow12);
                if (query.isNull(columnIndexOrThrow13)) {
                    string12 = null;
                } else {
                    string12 = query.getString(columnIndexOrThrow13);
                }
                aVar2.m = string12;
                if (query.isNull(columnIndexOrThrow14)) {
                    string13 = null;
                } else {
                    string13 = query.getString(columnIndexOrThrow14);
                }
                aVar2.n = string13;
                if (query.isNull(columnIndexOrThrow15)) {
                    string14 = null;
                } else {
                    string14 = query.getString(columnIndexOrThrow15);
                }
                aVar2.o = string14;
                if (query.isNull(columnIndexOrThrow16)) {
                    string15 = null;
                } else {
                    string15 = query.getString(columnIndexOrThrow16);
                }
                aVar2.p = string15;
                if (query.isNull(columnIndexOrThrow17)) {
                    string16 = null;
                } else {
                    string16 = query.getString(columnIndexOrThrow17);
                }
                aVar2.q = string16;
                aVar2.r = query.getLong(columnIndexOrThrow18);
                aVar2.s = query.getInt(columnIndexOrThrow19);
                aVar2.t = query.getInt(columnIndexOrThrow20);
                aVar2.u = query.getInt(columnIndexOrThrow21);
                aVar2.v = query.getInt(columnIndexOrThrow22);
                if (query.isNull(columnIndexOrThrow23)) {
                    string17 = null;
                } else {
                    string17 = query.getString(columnIndexOrThrow23);
                }
                aVar2.l(string17);
                aVar2.x = query.getInt(columnIndexOrThrow24);
                if (query.isNull(columnIndexOrThrow25)) {
                    string18 = null;
                } else {
                    string18 = query.getString(columnIndexOrThrow25);
                }
                aVar2.n(string18);
                aVar2.z = query.getInt(columnIndexOrThrow26);
                if (query.isNull(columnIndexOrThrow27)) {
                    string19 = null;
                } else {
                    string19 = query.getString(columnIndexOrThrow27);
                }
                aVar2.A = string19;
                if (query.getInt(columnIndexOrThrow28) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar2.B = z;
                if (query.getInt(columnIndexOrThrow29) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar2.C = z2;
                if (query.isNull(columnIndexOrThrow30)) {
                    string20 = null;
                } else {
                    string20 = query.getString(columnIndexOrThrow30);
                }
                aVar2.D = string20;
                if (query.isNull(columnIndexOrThrow31)) {
                    string21 = null;
                } else {
                    string21 = query.getString(columnIndexOrThrow31);
                }
                aVar2.E = string21;
                if (query.isNull(columnIndexOrThrow32)) {
                    string22 = null;
                } else {
                    string22 = query.getString(columnIndexOrThrow32);
                }
                aVar2.F = string22;
                if (query.isNull(columnIndexOrThrow33)) {
                    string23 = null;
                } else {
                    string23 = query.getString(columnIndexOrThrow33);
                }
                aVar2.G = string23;
                aVar2.H = query.getLong(columnIndexOrThrow34);
                aVar2.I = query.getInt(columnIndexOrThrow35);
                aVar2.J = query.getLong(columnIndexOrThrow36);
                if (query.getInt(columnIndexOrThrow37) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aVar2.K = z3;
                if (query.getInt(columnIndexOrThrow38) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                aVar2.L = z4;
                aVar2.M = query.getInt(columnIndexOrThrow39);
                if (query.isNull(columnIndexOrThrow40)) {
                    string24 = null;
                } else {
                    string24 = query.getString(columnIndexOrThrow40);
                }
                aVar2.p(string24);
                if (query.getInt(columnIndexOrThrow41) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                aVar2.O = z5;
                aVar2.P = query.getInt(columnIndexOrThrow42);
                if (query.isNull(columnIndexOrThrow43)) {
                    string25 = null;
                } else {
                    string25 = query.getString(columnIndexOrThrow43);
                }
                aVar2.j(string25);
                if (query.isNull(columnIndexOrThrow44)) {
                    string26 = null;
                } else {
                    string26 = query.getString(columnIndexOrThrow44);
                }
                aVar2.k(string26);
                if (query.isNull(columnIndexOrThrow45)) {
                    string27 = null;
                } else {
                    string27 = query.getString(columnIndexOrThrow45);
                }
                aVar2.o(string27);
                aVar = aVar2;
            } else {
                aVar = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    class a extends EntityInsertionAdapter<dv4.a> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_video_history_record` (`author_name`,`author_id`,`book_name`,`book_id`,`series_id`,`series_name`,`current_episode_id`,`episodes_list_count_text`,`current_video_title`,`cover_url`,`vid`,`content_type`,`total_time`,`current_play_position`,`current_video_total_time`,`last_video_vid`,`player_accumulate_total_time`,`record_index`,`video_platform`,`episode_cnt`,`video_width`,`video_height`,`series_color_hex`,`current_episode_index`,`update_tag`,`update_status`,`played_video_ids`,`has_sync`,`is_delete`,`stayed_video_ids`,`update_tag_text`,`pugc_user_name`,`pugc_user_avatar`,`series_play_count`,`video_scene`,`digged_count`,`is_user_digg`,`is_multi_season`,`season_index`,`video_tag_info`,`is_interactive_game`,`chapter_index`,`related_series_title`,`secondary_info`,`video_category_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, dv4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = aVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = aVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = aVar.d;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            String str5 = aVar.e;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str5);
            }
            String str6 = aVar.f;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str6);
            }
            String str7 = aVar.g;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str7);
            }
            String str8 = aVar.h;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str8);
            }
            String str9 = aVar.i;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str9);
            }
            String str10 = aVar.j;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str10);
            }
            String str11 = aVar.k;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str11);
            }
            supportSQLiteStatement.bindLong(12, aVar.l);
            String str12 = aVar.m;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str12);
            }
            String str13 = aVar.n;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str13);
            }
            String str14 = aVar.o;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str14);
            }
            String str15 = aVar.p;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str15);
            }
            String str16 = aVar.q;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str16);
            }
            supportSQLiteStatement.bindLong(18, aVar.r);
            supportSQLiteStatement.bindLong(19, aVar.s);
            supportSQLiteStatement.bindLong(20, aVar.t);
            supportSQLiteStatement.bindLong(21, aVar.u);
            supportSQLiteStatement.bindLong(22, aVar.v);
            String str17 = aVar.w;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str17);
            }
            supportSQLiteStatement.bindLong(24, aVar.x);
            String str18 = aVar.y;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str18);
            }
            supportSQLiteStatement.bindLong(26, aVar.z);
            String str19 = aVar.A;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str19);
            }
            supportSQLiteStatement.bindLong(28, aVar.B ? 1L : 0L);
            supportSQLiteStatement.bindLong(29, aVar.C ? 1L : 0L);
            String str20 = aVar.D;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str20);
            }
            String str21 = aVar.E;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str21);
            }
            String str22 = aVar.F;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str22);
            }
            String str23 = aVar.G;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str23);
            }
            supportSQLiteStatement.bindLong(34, aVar.H);
            supportSQLiteStatement.bindLong(35, aVar.I);
            supportSQLiteStatement.bindLong(36, aVar.J);
            supportSQLiteStatement.bindLong(37, aVar.K ? 1L : 0L);
            supportSQLiteStatement.bindLong(38, aVar.L ? 1L : 0L);
            supportSQLiteStatement.bindLong(39, aVar.M);
            String str24 = aVar.N;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str24);
            }
            supportSQLiteStatement.bindLong(41, aVar.O ? 1L : 0L);
            supportSQLiteStatement.bindLong(42, aVar.P);
            String str25 = aVar.Q;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str25);
            }
            String str26 = aVar.R;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str26);
            }
            String str27 = aVar.S;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str27);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<dv4.a> {
        public String createQuery() {
            return "DELETE FROM `t_video_history_record` WHERE `series_id` = ? AND `vid` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, dv4.a aVar) {
            String str = aVar.e;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = aVar.k;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<dv4.a> {
        public String createQuery() {
            return "UPDATE OR ABORT `t_video_history_record` SET `author_name` = ?,`author_id` = ?,`book_name` = ?,`book_id` = ?,`series_id` = ?,`series_name` = ?,`current_episode_id` = ?,`episodes_list_count_text` = ?,`current_video_title` = ?,`cover_url` = ?,`vid` = ?,`content_type` = ?,`total_time` = ?,`current_play_position` = ?,`current_video_total_time` = ?,`last_video_vid` = ?,`player_accumulate_total_time` = ?,`record_index` = ?,`video_platform` = ?,`episode_cnt` = ?,`video_width` = ?,`video_height` = ?,`series_color_hex` = ?,`current_episode_index` = ?,`update_tag` = ?,`update_status` = ?,`played_video_ids` = ?,`has_sync` = ?,`is_delete` = ?,`stayed_video_ids` = ?,`update_tag_text` = ?,`pugc_user_name` = ?,`pugc_user_avatar` = ?,`series_play_count` = ?,`video_scene` = ?,`digged_count` = ?,`is_user_digg` = ?,`is_multi_season` = ?,`season_index` = ?,`video_tag_info` = ?,`is_interactive_game` = ?,`chapter_index` = ?,`related_series_title` = ?,`secondary_info` = ?,`video_category_type` = ? WHERE `series_id` = ? AND `vid` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, dv4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = aVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = aVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = aVar.d;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            String str5 = aVar.e;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str5);
            }
            String str6 = aVar.f;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str6);
            }
            String str7 = aVar.g;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str7);
            }
            String str8 = aVar.h;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str8);
            }
            String str9 = aVar.i;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str9);
            }
            String str10 = aVar.j;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str10);
            }
            String str11 = aVar.k;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str11);
            }
            supportSQLiteStatement.bindLong(12, aVar.l);
            String str12 = aVar.m;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str12);
            }
            String str13 = aVar.n;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str13);
            }
            String str14 = aVar.o;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str14);
            }
            String str15 = aVar.p;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str15);
            }
            String str16 = aVar.q;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str16);
            }
            supportSQLiteStatement.bindLong(18, aVar.r);
            supportSQLiteStatement.bindLong(19, aVar.s);
            supportSQLiteStatement.bindLong(20, aVar.t);
            supportSQLiteStatement.bindLong(21, aVar.u);
            supportSQLiteStatement.bindLong(22, aVar.v);
            String str17 = aVar.w;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str17);
            }
            supportSQLiteStatement.bindLong(24, aVar.x);
            String str18 = aVar.y;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str18);
            }
            supportSQLiteStatement.bindLong(26, aVar.z);
            String str19 = aVar.A;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str19);
            }
            supportSQLiteStatement.bindLong(28, aVar.B ? 1L : 0L);
            supportSQLiteStatement.bindLong(29, aVar.C ? 1L : 0L);
            String str20 = aVar.D;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str20);
            }
            String str21 = aVar.E;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str21);
            }
            String str22 = aVar.F;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str22);
            }
            String str23 = aVar.G;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str23);
            }
            supportSQLiteStatement.bindLong(34, aVar.H);
            supportSQLiteStatement.bindLong(35, aVar.I);
            supportSQLiteStatement.bindLong(36, aVar.J);
            supportSQLiteStatement.bindLong(37, aVar.K ? 1L : 0L);
            supportSQLiteStatement.bindLong(38, aVar.L ? 1L : 0L);
            supportSQLiteStatement.bindLong(39, aVar.M);
            String str24 = aVar.N;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str24);
            }
            supportSQLiteStatement.bindLong(41, aVar.O ? 1L : 0L);
            supportSQLiteStatement.bindLong(42, aVar.P);
            String str25 = aVar.Q;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str25);
            }
            String str26 = aVar.R;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str26);
            }
            String str27 = aVar.S;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str27);
            }
            String str28 = aVar.e;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str28);
            }
            String str29 = aVar.k;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str29);
            }
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_video_history_record WHERE vid = ? AND series_id =?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class e extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_video_history_record WHERE series_id =?";
        }

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
