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
public final class f5 implements e5 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<tu4.a> b;
    private final EntityDeletionOrUpdateAdapter<tu4.a> c;
    private final EntityDeletionOrUpdateAdapter<tu4.a> d;
    private final SharedSQLiteStatement e;

    static {
        Covode.recordClassIndex(611805);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // nr4.e5
    public List<tu4.a> f() {
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
        String string5;
        String string6;
        boolean z;
        boolean z2;
        String string7;
        String string8;
        int i2;
        String string9;
        int i3;
        String string10;
        int i4;
        String string11;
        boolean z3;
        String string12;
        boolean z4;
        String string13;
        String string14;
        boolean z5;
        String string15;
        String string16;
        String string17;
        int i5;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        boolean z6;
        boolean z7;
        boolean z8;
        String string24;
        int i6;
        boolean z9;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        String string30;
        String string31;
        int i7;
        String string32;
        String string33;
        String string34;
        boolean z10;
        String string35;
        int i8;
        String string36;
        String string37;
        String string38;
        int i9;
        Integer valueOf;
        String string39;
        String string40;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_like", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "vid");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cover");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "scene_cover");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "title");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "video_desc");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "user_digg");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "followed");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sub_title");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "episode_cnt");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "user_digg_timestamp_ms");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "bg_color_hex");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "followed_cnt");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "episodes_status");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "series_title");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "vid_index");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "video_platform_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "video_content_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "relate_video_content_type");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "update_tag");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "is_vertical");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "series_cover");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "show_record_info");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "record_number");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "secondary_infos");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "is_trailer");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "celebrities");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "category_schema");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "series_intro");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "series_play_cnt");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "video_series_id_type");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "user_name");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar_decoration_url");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar_decoration_id");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "post_title");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "is_ugc_video");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "is_private");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "online_subscribed");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "online_time");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "label");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "enable_vision_product");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "abstract_tags");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_type");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_group_id");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_text_list");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_schema");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_icon_url");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "related_album_id");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "sub_title_list");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "main_creator_users");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "support_listen");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "ai_usage_type");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "relate_book_id");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "relate_post_id");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "relate_genre_type");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "user_creator_type");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "video_share_info");
            int i10 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                tu4.a aVar = new tu4.a();
                if (query.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = query.getString(columnIndexOrThrow);
                }
                aVar.s(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                aVar.c(string2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                aVar.h(string3);
                int i11 = columnIndexOrThrow2;
                int i12 = columnIndexOrThrow3;
                aVar.d = query.getLong(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                aVar.n(string4);
                if (query.isNull(columnIndexOrThrow6)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow6);
                }
                aVar.u(string5);
                if (query.isNull(columnIndexOrThrow7)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow7);
                }
                aVar.i(string6);
                aVar.h = query.getLong(columnIndexOrThrow8);
                if (query.getInt(columnIndexOrThrow9) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.i = z;
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar.j = z2;
                if (query.isNull(columnIndexOrThrow11)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow11);
                }
                aVar.l(string7);
                int i13 = columnIndexOrThrow4;
                aVar.l = query.getLong(columnIndexOrThrow12);
                aVar.m = query.getInt(columnIndexOrThrow13);
                int i14 = i10;
                aVar.n = query.getInt(i14);
                int i15 = columnIndexOrThrow15;
                aVar.o = query.getInt(i15);
                i10 = i14;
                int i16 = columnIndexOrThrow16;
                aVar.p = query.getLong(i16);
                int i17 = columnIndexOrThrow17;
                if (query.isNull(i17)) {
                    string8 = null;
                } else {
                    string8 = query.getString(i17);
                }
                aVar.b(string8);
                int i18 = columnIndexOrThrow18;
                if (query.isNull(i18)) {
                    i2 = i16;
                    string9 = null;
                } else {
                    i2 = i16;
                    string9 = query.getString(i18);
                }
                aVar.r = string9;
                columnIndexOrThrow17 = i17;
                int i19 = columnIndexOrThrow19;
                aVar.s = query.getLong(i19);
                int i20 = columnIndexOrThrow20;
                aVar.t = query.getInt(i20);
                int i21 = columnIndexOrThrow21;
                if (query.isNull(i21)) {
                    i3 = i19;
                    string10 = null;
                } else {
                    i3 = i19;
                    string10 = query.getString(i21);
                }
                aVar.k(string10);
                columnIndexOrThrow20 = i20;
                int i22 = columnIndexOrThrow22;
                aVar.v = query.getLong(i22);
                int i23 = columnIndexOrThrow23;
                aVar.w = query.getInt(i23);
                int i24 = columnIndexOrThrow24;
                aVar.x = query.getInt(i24);
                int i25 = columnIndexOrThrow12;
                int i26 = columnIndexOrThrow25;
                aVar.y = query.getInt(i26);
                int i27 = columnIndexOrThrow26;
                if (query.isNull(i27)) {
                    i4 = i26;
                    string11 = null;
                } else {
                    i4 = i26;
                    string11 = query.getString(i27);
                }
                aVar.o(string11);
                int i28 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i28;
                if (query.getInt(i28) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aVar.A = z3;
                int i29 = columnIndexOrThrow28;
                if (query.isNull(i29)) {
                    columnIndexOrThrow28 = i29;
                    string12 = null;
                } else {
                    columnIndexOrThrow28 = i29;
                    string12 = query.getString(i29);
                }
                aVar.B = string12;
                int i30 = columnIndexOrThrow29;
                columnIndexOrThrow29 = i30;
                if (query.getInt(i30) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                aVar.C = z4;
                int i31 = columnIndexOrThrow30;
                if (query.isNull(i31)) {
                    columnIndexOrThrow30 = i31;
                    string13 = null;
                } else {
                    columnIndexOrThrow30 = i31;
                    string13 = query.getString(i31);
                }
                aVar.D = string13;
                int i32 = columnIndexOrThrow31;
                if (query.isNull(i32)) {
                    columnIndexOrThrow31 = i32;
                    string14 = null;
                } else {
                    columnIndexOrThrow31 = i32;
                    string14 = query.getString(i32);
                }
                aVar.E = string14;
                int i33 = columnIndexOrThrow32;
                columnIndexOrThrow32 = i33;
                if (query.getInt(i33) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                aVar.F = z5;
                int i34 = columnIndexOrThrow33;
                if (query.isNull(i34)) {
                    columnIndexOrThrow33 = i34;
                    string15 = null;
                } else {
                    columnIndexOrThrow33 = i34;
                    string15 = query.getString(i34);
                }
                aVar.G = string15;
                int i35 = columnIndexOrThrow34;
                if (query.isNull(i35)) {
                    columnIndexOrThrow34 = i35;
                    string16 = null;
                } else {
                    columnIndexOrThrow34 = i35;
                    string16 = query.getString(i35);
                }
                aVar.a(string16);
                int i36 = columnIndexOrThrow35;
                if (query.isNull(i36)) {
                    columnIndexOrThrow35 = i36;
                    string17 = null;
                } else {
                    columnIndexOrThrow35 = i36;
                    string17 = query.getString(i36);
                }
                aVar.j(string17);
                int i37 = columnIndexOrThrow36;
                aVar.J = query.getLong(i37);
                int i38 = columnIndexOrThrow37;
                aVar.K = query.getInt(i38);
                int i39 = columnIndexOrThrow38;
                if (query.isNull(i39)) {
                    i5 = i37;
                    string18 = null;
                } else {
                    i5 = i37;
                    string18 = query.getString(i39);
                }
                aVar.q(string18);
                int i40 = columnIndexOrThrow39;
                if (query.isNull(i40)) {
                    columnIndexOrThrow39 = i40;
                    string19 = null;
                } else {
                    columnIndexOrThrow39 = i40;
                    string19 = query.getString(i40);
                }
                aVar.r(string19);
                int i41 = columnIndexOrThrow40;
                if (query.isNull(i41)) {
                    columnIndexOrThrow40 = i41;
                    string20 = null;
                } else {
                    columnIndexOrThrow40 = i41;
                    string20 = query.getString(i41);
                }
                aVar.p(string20);
                int i42 = columnIndexOrThrow41;
                if (query.isNull(i42)) {
                    columnIndexOrThrow41 = i42;
                    string21 = null;
                } else {
                    columnIndexOrThrow41 = i42;
                    string21 = query.getString(i42);
                }
                aVar.O = string21;
                int i43 = columnIndexOrThrow42;
                if (query.isNull(i43)) {
                    columnIndexOrThrow42 = i43;
                    string22 = null;
                } else {
                    columnIndexOrThrow42 = i43;
                    string22 = query.getString(i43);
                }
                aVar.P = string22;
                int i44 = columnIndexOrThrow43;
                if (query.isNull(i44)) {
                    columnIndexOrThrow43 = i44;
                    string23 = null;
                } else {
                    columnIndexOrThrow43 = i44;
                    string23 = query.getString(i44);
                }
                aVar.e(string23);
                int i45 = columnIndexOrThrow44;
                columnIndexOrThrow44 = i45;
                if (query.getInt(i45) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                aVar.R = z6;
                int i46 = columnIndexOrThrow45;
                columnIndexOrThrow45 = i46;
                if (query.getInt(i46) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                aVar.S = z7;
                int i47 = columnIndexOrThrow46;
                columnIndexOrThrow46 = i47;
                if (query.getInt(i47) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                aVar.T = z8;
                columnIndexOrThrow37 = i38;
                int i48 = columnIndexOrThrow47;
                aVar.U = query.getLong(i48);
                int i49 = columnIndexOrThrow48;
                if (query.isNull(i49)) {
                    string24 = null;
                } else {
                    string24 = query.getString(i49);
                }
                aVar.V = string24;
                int i50 = columnIndexOrThrow49;
                if (query.getInt(i50) != 0) {
                    i6 = i48;
                    z9 = true;
                } else {
                    i6 = i48;
                    z9 = false;
                }
                aVar.W = z9;
                int i51 = columnIndexOrThrow50;
                if (query.isNull(i51)) {
                    columnIndexOrThrow50 = i51;
                    string25 = null;
                } else {
                    columnIndexOrThrow50 = i51;
                    string25 = query.getString(i51);
                }
                aVar.X = string25;
                int i52 = columnIndexOrThrow51;
                if (query.isNull(i52)) {
                    columnIndexOrThrow51 = i52;
                    string26 = null;
                } else {
                    columnIndexOrThrow51 = i52;
                    string26 = query.getString(i52);
                }
                aVar.Y = string26;
                int i53 = columnIndexOrThrow52;
                if (query.isNull(i53)) {
                    columnIndexOrThrow52 = i53;
                    string27 = null;
                } else {
                    columnIndexOrThrow52 = i53;
                    string27 = query.getString(i53);
                }
                aVar.Z = string27;
                int i54 = columnIndexOrThrow53;
                if (query.isNull(i54)) {
                    columnIndexOrThrow53 = i54;
                    string28 = null;
                } else {
                    columnIndexOrThrow53 = i54;
                    string28 = query.getString(i54);
                }
                aVar.a0 = string28;
                int i55 = columnIndexOrThrow54;
                if (query.isNull(i55)) {
                    columnIndexOrThrow54 = i55;
                    string29 = null;
                } else {
                    columnIndexOrThrow54 = i55;
                    string29 = query.getString(i55);
                }
                aVar.b0 = string29;
                int i56 = columnIndexOrThrow55;
                if (query.isNull(i56)) {
                    columnIndexOrThrow55 = i56;
                    string30 = null;
                } else {
                    columnIndexOrThrow55 = i56;
                    string30 = query.getString(i56);
                }
                aVar.c0 = string30;
                int i57 = columnIndexOrThrow56;
                aVar.d0 = query.getLong(i57);
                int i58 = columnIndexOrThrow57;
                if (query.isNull(i58)) {
                    string31 = null;
                } else {
                    string31 = query.getString(i58);
                }
                aVar.m(string31);
                int i59 = columnIndexOrThrow58;
                if (query.isNull(i59)) {
                    i7 = i57;
                    string32 = null;
                } else {
                    i7 = i57;
                    string32 = query.getString(i59);
                }
                aVar.d(string32);
                int i60 = columnIndexOrThrow59;
                if (query.isNull(i60)) {
                    columnIndexOrThrow59 = i60;
                    string33 = null;
                } else {
                    columnIndexOrThrow59 = i60;
                    string33 = query.getString(i60);
                }
                aVar.g(string33);
                int i61 = columnIndexOrThrow60;
                if (query.isNull(i61)) {
                    columnIndexOrThrow60 = i61;
                    string34 = null;
                } else {
                    columnIndexOrThrow60 = i61;
                    string34 = query.getString(i61);
                }
                aVar.f(string34);
                int i62 = columnIndexOrThrow61;
                columnIndexOrThrow61 = i62;
                if (query.getInt(i62) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                aVar.i0 = z10;
                columnIndexOrThrow57 = i58;
                int i63 = columnIndexOrThrow62;
                aVar.j0 = query.getLong(i63);
                int i64 = columnIndexOrThrow63;
                if (query.isNull(i64)) {
                    string35 = null;
                } else {
                    string35 = query.getString(i64);
                }
                aVar.k0 = string35;
                int i65 = columnIndexOrThrow64;
                if (query.isNull(i65)) {
                    i8 = i63;
                    string36 = null;
                } else {
                    i8 = i63;
                    string36 = query.getString(i65);
                }
                aVar.l0 = string36;
                int i66 = columnIndexOrThrow65;
                if (query.isNull(i66)) {
                    columnIndexOrThrow65 = i66;
                    string37 = null;
                } else {
                    columnIndexOrThrow65 = i66;
                    string37 = query.getString(i66);
                }
                aVar.m0 = string37;
                columnIndexOrThrow63 = i64;
                int i67 = columnIndexOrThrow66;
                aVar.n0 = query.getLong(i67);
                int i68 = columnIndexOrThrow67;
                aVar.o0 = query.getLong(i68);
                int i69 = columnIndexOrThrow68;
                if (query.isNull(i69)) {
                    string38 = null;
                } else {
                    string38 = query.getString(i69);
                }
                aVar.p0 = string38;
                int i70 = columnIndexOrThrow69;
                if (query.isNull(i70)) {
                    i9 = i67;
                    valueOf = null;
                } else {
                    i9 = i67;
                    valueOf = Integer.valueOf(query.getInt(i70));
                }
                aVar.q0 = valueOf;
                int i71 = columnIndexOrThrow70;
                if (query.isNull(i71)) {
                    columnIndexOrThrow70 = i71;
                    string39 = null;
                } else {
                    columnIndexOrThrow70 = i71;
                    string39 = query.getString(i71);
                }
                aVar.t(string39);
                int i72 = columnIndexOrThrow71;
                if (query.isNull(i72)) {
                    columnIndexOrThrow71 = i72;
                    string40 = null;
                } else {
                    columnIndexOrThrow71 = i72;
                    string40 = query.getString(i72);
                }
                aVar.v(string40);
                arrayList.add(aVar);
                columnIndexOrThrow68 = i69;
                columnIndexOrThrow3 = i12;
                columnIndexOrThrow = i;
                int i73 = i4;
                columnIndexOrThrow26 = i27;
                columnIndexOrThrow12 = i25;
                columnIndexOrThrow24 = i24;
                columnIndexOrThrow36 = i5;
                columnIndexOrThrow38 = i39;
                columnIndexOrThrow47 = i6;
                columnIndexOrThrow48 = i49;
                columnIndexOrThrow49 = i50;
                columnIndexOrThrow56 = i7;
                columnIndexOrThrow58 = i59;
                columnIndexOrThrow62 = i8;
                columnIndexOrThrow64 = i65;
                columnIndexOrThrow66 = i9;
                columnIndexOrThrow69 = i70;
                columnIndexOrThrow4 = i13;
                columnIndexOrThrow16 = i2;
                columnIndexOrThrow18 = i18;
                columnIndexOrThrow19 = i3;
                columnIndexOrThrow21 = i21;
                columnIndexOrThrow22 = i22;
                columnIndexOrThrow23 = i23;
                columnIndexOrThrow25 = i73;
                columnIndexOrThrow67 = i68;
                columnIndexOrThrow2 = i11;
                columnIndexOrThrow15 = i15;
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

    public f5(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    @Override // nr4.e5
    public void a(String str) {
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

    @Override // nr4.e5
    public void b(List<tu4.a> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.e5
    public void c(tu4.a aVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(aVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.e5
    public void e(List<tu4.a> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.e5
    public List<tu4.a> d(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z;
        boolean z2;
        String string7;
        String string8;
        int i2;
        String string9;
        int i3;
        String string10;
        int i4;
        String string11;
        boolean z3;
        String string12;
        boolean z4;
        String string13;
        String string14;
        boolean z5;
        String string15;
        String string16;
        String string17;
        int i5;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        boolean z6;
        boolean z7;
        boolean z8;
        String string24;
        int i6;
        boolean z9;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        String string30;
        String string31;
        int i7;
        String string32;
        String string33;
        String string34;
        boolean z10;
        String string35;
        int i8;
        String string36;
        String string37;
        String string38;
        int i9;
        Integer valueOf;
        String string39;
        String string40;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_video_serial_like WHERE series_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i10 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i10);
            } else {
                acquire.bindString(i10, str);
            }
            i10++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "vid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cover");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "scene_cover");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "title");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "video_desc");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "user_digg");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "followed");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sub_title");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "episode_cnt");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "user_digg_timestamp_ms");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "bg_color_hex");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "followed_cnt");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "episodes_status");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "series_title");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "vid_index");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "video_platform_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "video_content_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "relate_video_content_type");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "update_tag");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "is_vertical");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "series_cover");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "show_record_info");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "record_number");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "secondary_infos");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "is_trailer");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "celebrities");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "category_schema");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "series_intro");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "series_play_cnt");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "video_series_id_type");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "user_name");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar_decoration_url");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar_decoration_id");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "post_title");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "is_ugc_video");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "is_private");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "online_subscribed");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "online_time");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "label");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "enable_vision_product");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "abstract_tags");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_type");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_group_id");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_text_list");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_schema");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_icon_url");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "related_album_id");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "sub_title_list");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "main_creator_users");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "support_listen");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "ai_usage_type");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "relate_book_id");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "relate_post_id");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "relate_genre_type");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "user_creator_type");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "video_share_info");
                int i11 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    tu4.a aVar = new tu4.a();
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = query.getString(columnIndexOrThrow);
                    }
                    aVar.s(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    aVar.c(string2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow3);
                    }
                    aVar.h(string3);
                    int i12 = columnIndexOrThrow2;
                    int i13 = columnIndexOrThrow3;
                    aVar.d = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow5);
                    }
                    aVar.n(string4);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow6);
                    }
                    aVar.u(string5);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow7);
                    }
                    aVar.i(string6);
                    aVar.h = query.getLong(columnIndexOrThrow8);
                    if (query.getInt(columnIndexOrThrow9) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.i = z;
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    aVar.j = z2;
                    if (query.isNull(columnIndexOrThrow11)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow11);
                    }
                    aVar.l(string7);
                    aVar.l = query.getLong(columnIndexOrThrow12);
                    aVar.m = query.getInt(columnIndexOrThrow13);
                    int i14 = i11;
                    aVar.n = query.getInt(i14);
                    int i15 = columnIndexOrThrow15;
                    aVar.o = query.getInt(i15);
                    int i16 = columnIndexOrThrow12;
                    int i17 = columnIndexOrThrow16;
                    int i18 = columnIndexOrThrow11;
                    aVar.p = query.getLong(i17);
                    int i19 = columnIndexOrThrow17;
                    if (query.isNull(i19)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(i19);
                    }
                    aVar.b(string8);
                    int i20 = columnIndexOrThrow18;
                    if (query.isNull(i20)) {
                        i2 = i17;
                        string9 = null;
                    } else {
                        i2 = i17;
                        string9 = query.getString(i20);
                    }
                    aVar.r = string9;
                    columnIndexOrThrow17 = i19;
                    int i21 = columnIndexOrThrow19;
                    aVar.s = query.getLong(i21);
                    int i22 = columnIndexOrThrow20;
                    aVar.t = query.getInt(i22);
                    int i23 = columnIndexOrThrow21;
                    if (query.isNull(i23)) {
                        i3 = i21;
                        string10 = null;
                    } else {
                        i3 = i21;
                        string10 = query.getString(i23);
                    }
                    aVar.k(string10);
                    columnIndexOrThrow20 = i22;
                    int i24 = columnIndexOrThrow22;
                    aVar.v = query.getLong(i24);
                    int i25 = columnIndexOrThrow23;
                    aVar.w = query.getInt(i25);
                    int i26 = columnIndexOrThrow24;
                    aVar.x = query.getInt(i26);
                    int i27 = columnIndexOrThrow25;
                    aVar.y = query.getInt(i27);
                    int i28 = columnIndexOrThrow26;
                    if (query.isNull(i28)) {
                        i4 = i27;
                        string11 = null;
                    } else {
                        i4 = i27;
                        string11 = query.getString(i28);
                    }
                    aVar.o(string11);
                    int i29 = columnIndexOrThrow27;
                    columnIndexOrThrow27 = i29;
                    if (query.getInt(i29) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    aVar.A = z3;
                    int i30 = columnIndexOrThrow28;
                    if (query.isNull(i30)) {
                        columnIndexOrThrow28 = i30;
                        string12 = null;
                    } else {
                        columnIndexOrThrow28 = i30;
                        string12 = query.getString(i30);
                    }
                    aVar.B = string12;
                    int i31 = columnIndexOrThrow29;
                    columnIndexOrThrow29 = i31;
                    if (query.getInt(i31) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    aVar.C = z4;
                    int i32 = columnIndexOrThrow30;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow30 = i32;
                        string13 = null;
                    } else {
                        columnIndexOrThrow30 = i32;
                        string13 = query.getString(i32);
                    }
                    aVar.D = string13;
                    int i33 = columnIndexOrThrow31;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow31 = i33;
                        string14 = null;
                    } else {
                        columnIndexOrThrow31 = i33;
                        string14 = query.getString(i33);
                    }
                    aVar.E = string14;
                    int i34 = columnIndexOrThrow32;
                    columnIndexOrThrow32 = i34;
                    if (query.getInt(i34) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    aVar.F = z5;
                    int i35 = columnIndexOrThrow33;
                    if (query.isNull(i35)) {
                        columnIndexOrThrow33 = i35;
                        string15 = null;
                    } else {
                        columnIndexOrThrow33 = i35;
                        string15 = query.getString(i35);
                    }
                    aVar.G = string15;
                    int i36 = columnIndexOrThrow34;
                    if (query.isNull(i36)) {
                        columnIndexOrThrow34 = i36;
                        string16 = null;
                    } else {
                        columnIndexOrThrow34 = i36;
                        string16 = query.getString(i36);
                    }
                    aVar.a(string16);
                    int i37 = columnIndexOrThrow35;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow35 = i37;
                        string17 = null;
                    } else {
                        columnIndexOrThrow35 = i37;
                        string17 = query.getString(i37);
                    }
                    aVar.j(string17);
                    int i38 = columnIndexOrThrow36;
                    aVar.J = query.getLong(i38);
                    int i39 = columnIndexOrThrow37;
                    aVar.K = query.getInt(i39);
                    int i40 = columnIndexOrThrow38;
                    if (query.isNull(i40)) {
                        i5 = i38;
                        string18 = null;
                    } else {
                        i5 = i38;
                        string18 = query.getString(i40);
                    }
                    aVar.q(string18);
                    int i41 = columnIndexOrThrow39;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow39 = i41;
                        string19 = null;
                    } else {
                        columnIndexOrThrow39 = i41;
                        string19 = query.getString(i41);
                    }
                    aVar.r(string19);
                    int i42 = columnIndexOrThrow40;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow40 = i42;
                        string20 = null;
                    } else {
                        columnIndexOrThrow40 = i42;
                        string20 = query.getString(i42);
                    }
                    aVar.p(string20);
                    int i43 = columnIndexOrThrow41;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow41 = i43;
                        string21 = null;
                    } else {
                        columnIndexOrThrow41 = i43;
                        string21 = query.getString(i43);
                    }
                    aVar.O = string21;
                    int i44 = columnIndexOrThrow42;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow42 = i44;
                        string22 = null;
                    } else {
                        columnIndexOrThrow42 = i44;
                        string22 = query.getString(i44);
                    }
                    aVar.P = string22;
                    int i45 = columnIndexOrThrow43;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow43 = i45;
                        string23 = null;
                    } else {
                        columnIndexOrThrow43 = i45;
                        string23 = query.getString(i45);
                    }
                    aVar.e(string23);
                    int i46 = columnIndexOrThrow44;
                    columnIndexOrThrow44 = i46;
                    if (query.getInt(i46) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    aVar.R = z6;
                    int i47 = columnIndexOrThrow45;
                    columnIndexOrThrow45 = i47;
                    if (query.getInt(i47) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    aVar.S = z7;
                    int i48 = columnIndexOrThrow46;
                    columnIndexOrThrow46 = i48;
                    if (query.getInt(i48) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    aVar.T = z8;
                    columnIndexOrThrow37 = i39;
                    int i49 = columnIndexOrThrow47;
                    aVar.U = query.getLong(i49);
                    int i50 = columnIndexOrThrow48;
                    if (query.isNull(i50)) {
                        string24 = null;
                    } else {
                        string24 = query.getString(i50);
                    }
                    aVar.V = string24;
                    int i51 = columnIndexOrThrow49;
                    if (query.getInt(i51) != 0) {
                        i6 = i49;
                        z9 = true;
                    } else {
                        i6 = i49;
                        z9 = false;
                    }
                    aVar.W = z9;
                    int i52 = columnIndexOrThrow50;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow50 = i52;
                        string25 = null;
                    } else {
                        columnIndexOrThrow50 = i52;
                        string25 = query.getString(i52);
                    }
                    aVar.X = string25;
                    int i53 = columnIndexOrThrow51;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow51 = i53;
                        string26 = null;
                    } else {
                        columnIndexOrThrow51 = i53;
                        string26 = query.getString(i53);
                    }
                    aVar.Y = string26;
                    int i54 = columnIndexOrThrow52;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow52 = i54;
                        string27 = null;
                    } else {
                        columnIndexOrThrow52 = i54;
                        string27 = query.getString(i54);
                    }
                    aVar.Z = string27;
                    int i55 = columnIndexOrThrow53;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow53 = i55;
                        string28 = null;
                    } else {
                        columnIndexOrThrow53 = i55;
                        string28 = query.getString(i55);
                    }
                    aVar.a0 = string28;
                    int i56 = columnIndexOrThrow54;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow54 = i56;
                        string29 = null;
                    } else {
                        columnIndexOrThrow54 = i56;
                        string29 = query.getString(i56);
                    }
                    aVar.b0 = string29;
                    int i57 = columnIndexOrThrow55;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow55 = i57;
                        string30 = null;
                    } else {
                        columnIndexOrThrow55 = i57;
                        string30 = query.getString(i57);
                    }
                    aVar.c0 = string30;
                    int i58 = columnIndexOrThrow56;
                    aVar.d0 = query.getLong(i58);
                    int i59 = columnIndexOrThrow57;
                    if (query.isNull(i59)) {
                        string31 = null;
                    } else {
                        string31 = query.getString(i59);
                    }
                    aVar.m(string31);
                    int i60 = columnIndexOrThrow58;
                    if (query.isNull(i60)) {
                        i7 = i58;
                        string32 = null;
                    } else {
                        i7 = i58;
                        string32 = query.getString(i60);
                    }
                    aVar.d(string32);
                    int i61 = columnIndexOrThrow59;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow59 = i61;
                        string33 = null;
                    } else {
                        columnIndexOrThrow59 = i61;
                        string33 = query.getString(i61);
                    }
                    aVar.g(string33);
                    int i62 = columnIndexOrThrow60;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow60 = i62;
                        string34 = null;
                    } else {
                        columnIndexOrThrow60 = i62;
                        string34 = query.getString(i62);
                    }
                    aVar.f(string34);
                    int i63 = columnIndexOrThrow61;
                    columnIndexOrThrow61 = i63;
                    if (query.getInt(i63) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    aVar.i0 = z10;
                    columnIndexOrThrow57 = i59;
                    int i64 = columnIndexOrThrow62;
                    aVar.j0 = query.getLong(i64);
                    int i65 = columnIndexOrThrow63;
                    if (query.isNull(i65)) {
                        string35 = null;
                    } else {
                        string35 = query.getString(i65);
                    }
                    aVar.k0 = string35;
                    int i66 = columnIndexOrThrow64;
                    if (query.isNull(i66)) {
                        i8 = i64;
                        string36 = null;
                    } else {
                        i8 = i64;
                        string36 = query.getString(i66);
                    }
                    aVar.l0 = string36;
                    int i67 = columnIndexOrThrow65;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow65 = i67;
                        string37 = null;
                    } else {
                        columnIndexOrThrow65 = i67;
                        string37 = query.getString(i67);
                    }
                    aVar.m0 = string37;
                    columnIndexOrThrow63 = i65;
                    int i68 = columnIndexOrThrow66;
                    aVar.n0 = query.getLong(i68);
                    int i69 = columnIndexOrThrow67;
                    int i70 = columnIndexOrThrow13;
                    aVar.o0 = query.getLong(i69);
                    int i71 = columnIndexOrThrow68;
                    if (query.isNull(i71)) {
                        string38 = null;
                    } else {
                        string38 = query.getString(i71);
                    }
                    aVar.p0 = string38;
                    int i72 = columnIndexOrThrow69;
                    if (query.isNull(i72)) {
                        i9 = i68;
                        valueOf = null;
                    } else {
                        i9 = i68;
                        valueOf = Integer.valueOf(query.getInt(i72));
                    }
                    aVar.q0 = valueOf;
                    int i73 = columnIndexOrThrow70;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow70 = i73;
                        string39 = null;
                    } else {
                        columnIndexOrThrow70 = i73;
                        string39 = query.getString(i73);
                    }
                    aVar.t(string39);
                    int i74 = columnIndexOrThrow71;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow71 = i74;
                        string40 = null;
                    } else {
                        columnIndexOrThrow71 = i74;
                        string40 = query.getString(i74);
                    }
                    aVar.v(string40);
                    arrayList.add(aVar);
                    columnIndexOrThrow68 = i71;
                    columnIndexOrThrow12 = i16;
                    columnIndexOrThrow = i;
                    i11 = i14;
                    columnIndexOrThrow2 = i12;
                    columnIndexOrThrow15 = i15;
                    columnIndexOrThrow3 = i13;
                    columnIndexOrThrow67 = i69;
                    columnIndexOrThrow11 = i18;
                    columnIndexOrThrow16 = i2;
                    columnIndexOrThrow18 = i20;
                    columnIndexOrThrow19 = i3;
                    columnIndexOrThrow21 = i23;
                    columnIndexOrThrow22 = i24;
                    columnIndexOrThrow23 = i25;
                    columnIndexOrThrow24 = i26;
                    columnIndexOrThrow25 = i4;
                    columnIndexOrThrow26 = i28;
                    columnIndexOrThrow36 = i5;
                    columnIndexOrThrow38 = i40;
                    columnIndexOrThrow47 = i6;
                    columnIndexOrThrow48 = i50;
                    columnIndexOrThrow49 = i51;
                    columnIndexOrThrow56 = i7;
                    columnIndexOrThrow58 = i60;
                    columnIndexOrThrow62 = i8;
                    columnIndexOrThrow64 = i66;
                    columnIndexOrThrow66 = i9;
                    columnIndexOrThrow69 = i72;
                    columnIndexOrThrow13 = i70;
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

    @Override // nr4.e5
    public tu4.a g(String str) {
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
        tu4.a aVar;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z;
        boolean z2;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        boolean z3;
        String string12;
        boolean z4;
        String string13;
        String string14;
        boolean z5;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        boolean z6;
        boolean z7;
        boolean z8;
        String string24;
        boolean z9;
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
        boolean z10;
        String string35;
        String string36;
        String string37;
        String string38;
        Integer valueOf;
        String string39;
        String string40;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_video_serial_like WHERE vid = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "vid");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "cover");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "scene_cover");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "title");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "video_desc");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "series_id");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "digged_count");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "user_digg");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "followed");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sub_title");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "episode_cnt");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "video_width");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "video_height");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "user_digg_timestamp_ms");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "color_dominate");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "bg_color_hex");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "followed_cnt");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "episodes_status");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "series_title");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "vid_index");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "video_platform_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "video_content_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "relate_video_content_type");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "update_tag");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "is_vertical");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "series_cover");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "show_record_info");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "record_number");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "secondary_infos");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "is_trailer");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "celebrities");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "category_schema");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "series_intro");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "series_play_cnt");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "video_series_id_type");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "user_name");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar_decoration_url");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "user_avatar_decoration_id");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "post_title");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "is_ugc_video");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "is_private");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "online_subscribed");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "online_time");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "label");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "enable_vision_product");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "abstract_tags");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_type");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_group_id");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_text_list");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_schema");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "bottom_bar_icon_url");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "related_album_id");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "sub_title_list");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "main_creator_users");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "recommend_info");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "recommend_group_id");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "support_listen");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "ai_usage_type");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "relate_book_id");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "relate_post_id");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "relate_genre_type");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "season_index");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "video_tag_info");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "user_creator_type");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "video_category_type");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "video_share_info");
            if (query.moveToFirst()) {
                tu4.a aVar2 = new tu4.a();
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                aVar2.s(string);
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                aVar2.c(string2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                aVar2.h(string3);
                aVar2.d = query.getLong(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                aVar2.n(string4);
                if (query.isNull(columnIndexOrThrow6)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow6);
                }
                aVar2.u(string5);
                if (query.isNull(columnIndexOrThrow7)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow7);
                }
                aVar2.i(string6);
                aVar2.h = query.getLong(columnIndexOrThrow8);
                if (query.getInt(columnIndexOrThrow9) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar2.i = z;
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar2.j = z2;
                if (query.isNull(columnIndexOrThrow11)) {
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow11);
                }
                aVar2.l(string7);
                aVar2.l = query.getLong(columnIndexOrThrow12);
                aVar2.m = query.getInt(columnIndexOrThrow13);
                aVar2.n = query.getInt(columnIndexOrThrow14);
                aVar2.o = query.getInt(columnIndexOrThrow15);
                aVar2.p = query.getLong(columnIndexOrThrow16);
                if (query.isNull(columnIndexOrThrow17)) {
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow17);
                }
                aVar2.b(string8);
                if (query.isNull(columnIndexOrThrow18)) {
                    string9 = null;
                } else {
                    string9 = query.getString(columnIndexOrThrow18);
                }
                aVar2.r = string9;
                aVar2.s = query.getLong(columnIndexOrThrow19);
                aVar2.t = query.getInt(columnIndexOrThrow20);
                if (query.isNull(columnIndexOrThrow21)) {
                    string10 = null;
                } else {
                    string10 = query.getString(columnIndexOrThrow21);
                }
                aVar2.k(string10);
                aVar2.v = query.getLong(columnIndexOrThrow22);
                aVar2.w = query.getInt(columnIndexOrThrow23);
                aVar2.x = query.getInt(columnIndexOrThrow24);
                aVar2.y = query.getInt(columnIndexOrThrow25);
                if (query.isNull(columnIndexOrThrow26)) {
                    string11 = null;
                } else {
                    string11 = query.getString(columnIndexOrThrow26);
                }
                aVar2.o(string11);
                if (query.getInt(columnIndexOrThrow27) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aVar2.A = z3;
                if (query.isNull(columnIndexOrThrow28)) {
                    string12 = null;
                } else {
                    string12 = query.getString(columnIndexOrThrow28);
                }
                aVar2.B = string12;
                if (query.getInt(columnIndexOrThrow29) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                aVar2.C = z4;
                if (query.isNull(columnIndexOrThrow30)) {
                    string13 = null;
                } else {
                    string13 = query.getString(columnIndexOrThrow30);
                }
                aVar2.D = string13;
                if (query.isNull(columnIndexOrThrow31)) {
                    string14 = null;
                } else {
                    string14 = query.getString(columnIndexOrThrow31);
                }
                aVar2.E = string14;
                if (query.getInt(columnIndexOrThrow32) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                aVar2.F = z5;
                if (query.isNull(columnIndexOrThrow33)) {
                    string15 = null;
                } else {
                    string15 = query.getString(columnIndexOrThrow33);
                }
                aVar2.G = string15;
                if (query.isNull(columnIndexOrThrow34)) {
                    string16 = null;
                } else {
                    string16 = query.getString(columnIndexOrThrow34);
                }
                aVar2.a(string16);
                if (query.isNull(columnIndexOrThrow35)) {
                    string17 = null;
                } else {
                    string17 = query.getString(columnIndexOrThrow35);
                }
                aVar2.j(string17);
                aVar2.J = query.getLong(columnIndexOrThrow36);
                aVar2.K = query.getInt(columnIndexOrThrow37);
                if (query.isNull(columnIndexOrThrow38)) {
                    string18 = null;
                } else {
                    string18 = query.getString(columnIndexOrThrow38);
                }
                aVar2.q(string18);
                if (query.isNull(columnIndexOrThrow39)) {
                    string19 = null;
                } else {
                    string19 = query.getString(columnIndexOrThrow39);
                }
                aVar2.r(string19);
                if (query.isNull(columnIndexOrThrow40)) {
                    string20 = null;
                } else {
                    string20 = query.getString(columnIndexOrThrow40);
                }
                aVar2.p(string20);
                if (query.isNull(columnIndexOrThrow41)) {
                    string21 = null;
                } else {
                    string21 = query.getString(columnIndexOrThrow41);
                }
                aVar2.O = string21;
                if (query.isNull(columnIndexOrThrow42)) {
                    string22 = null;
                } else {
                    string22 = query.getString(columnIndexOrThrow42);
                }
                aVar2.P = string22;
                if (query.isNull(columnIndexOrThrow43)) {
                    string23 = null;
                } else {
                    string23 = query.getString(columnIndexOrThrow43);
                }
                aVar2.e(string23);
                if (query.getInt(columnIndexOrThrow44) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                aVar2.R = z6;
                if (query.getInt(columnIndexOrThrow45) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                aVar2.S = z7;
                if (query.getInt(columnIndexOrThrow46) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                aVar2.T = z8;
                aVar2.U = query.getLong(columnIndexOrThrow47);
                if (query.isNull(columnIndexOrThrow48)) {
                    string24 = null;
                } else {
                    string24 = query.getString(columnIndexOrThrow48);
                }
                aVar2.V = string24;
                if (query.getInt(columnIndexOrThrow49) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                aVar2.W = z9;
                if (query.isNull(columnIndexOrThrow50)) {
                    string25 = null;
                } else {
                    string25 = query.getString(columnIndexOrThrow50);
                }
                aVar2.X = string25;
                if (query.isNull(columnIndexOrThrow51)) {
                    string26 = null;
                } else {
                    string26 = query.getString(columnIndexOrThrow51);
                }
                aVar2.Y = string26;
                if (query.isNull(columnIndexOrThrow52)) {
                    string27 = null;
                } else {
                    string27 = query.getString(columnIndexOrThrow52);
                }
                aVar2.Z = string27;
                if (query.isNull(columnIndexOrThrow53)) {
                    string28 = null;
                } else {
                    string28 = query.getString(columnIndexOrThrow53);
                }
                aVar2.a0 = string28;
                if (query.isNull(columnIndexOrThrow54)) {
                    string29 = null;
                } else {
                    string29 = query.getString(columnIndexOrThrow54);
                }
                aVar2.b0 = string29;
                if (query.isNull(columnIndexOrThrow55)) {
                    string30 = null;
                } else {
                    string30 = query.getString(columnIndexOrThrow55);
                }
                aVar2.c0 = string30;
                aVar2.d0 = query.getLong(columnIndexOrThrow56);
                if (query.isNull(columnIndexOrThrow57)) {
                    string31 = null;
                } else {
                    string31 = query.getString(columnIndexOrThrow57);
                }
                aVar2.m(string31);
                if (query.isNull(columnIndexOrThrow58)) {
                    string32 = null;
                } else {
                    string32 = query.getString(columnIndexOrThrow58);
                }
                aVar2.d(string32);
                if (query.isNull(columnIndexOrThrow59)) {
                    string33 = null;
                } else {
                    string33 = query.getString(columnIndexOrThrow59);
                }
                aVar2.g(string33);
                if (query.isNull(columnIndexOrThrow60)) {
                    string34 = null;
                } else {
                    string34 = query.getString(columnIndexOrThrow60);
                }
                aVar2.f(string34);
                if (query.getInt(columnIndexOrThrow61) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                aVar2.i0 = z10;
                aVar2.j0 = query.getLong(columnIndexOrThrow62);
                if (query.isNull(columnIndexOrThrow63)) {
                    string35 = null;
                } else {
                    string35 = query.getString(columnIndexOrThrow63);
                }
                aVar2.k0 = string35;
                if (query.isNull(columnIndexOrThrow64)) {
                    string36 = null;
                } else {
                    string36 = query.getString(columnIndexOrThrow64);
                }
                aVar2.l0 = string36;
                if (query.isNull(columnIndexOrThrow65)) {
                    string37 = null;
                } else {
                    string37 = query.getString(columnIndexOrThrow65);
                }
                aVar2.m0 = string37;
                aVar2.n0 = query.getLong(columnIndexOrThrow66);
                aVar2.o0 = query.getLong(columnIndexOrThrow67);
                if (query.isNull(columnIndexOrThrow68)) {
                    string38 = null;
                } else {
                    string38 = query.getString(columnIndexOrThrow68);
                }
                aVar2.p0 = string38;
                if (query.isNull(columnIndexOrThrow69)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow69));
                }
                aVar2.q0 = valueOf;
                if (query.isNull(columnIndexOrThrow70)) {
                    string39 = null;
                } else {
                    string39 = query.getString(columnIndexOrThrow70);
                }
                aVar2.t(string39);
                if (query.isNull(columnIndexOrThrow71)) {
                    string40 = null;
                } else {
                    string40 = query.getString(columnIndexOrThrow71);
                }
                aVar2.v(string40);
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

    class a extends EntityInsertionAdapter<tu4.a> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_video_serial_like` (`vid`,`cover`,`scene_cover`,`duration`,`title`,`video_desc`,`series_id`,`digged_count`,`user_digg`,`followed`,`sub_title`,`episode_cnt`,`time`,`video_width`,`video_height`,`user_digg_timestamp_ms`,`color_dominate`,`bg_color_hex`,`followed_cnt`,`episodes_status`,`series_title`,`vid_index`,`video_platform_type`,`video_content_type`,`relate_video_content_type`,`update_tag`,`is_vertical`,`series_cover`,`show_record_info`,`record_number`,`secondary_infos`,`is_trailer`,`celebrities`,`category_schema`,`series_intro`,`series_play_cnt`,`video_series_id_type`,`user_id`,`user_name`,`user_avatar`,`user_avatar_decoration_url`,`user_avatar_decoration_id`,`post_title`,`is_ugc_video`,`is_private`,`online_subscribed`,`online_time`,`label`,`enable_vision_product`,`abstract_tags`,`bottom_bar_type`,`bottom_bar_group_id`,`bottom_bar_text_list`,`bottom_bar_schema`,`bottom_bar_icon_url`,`related_album_id`,`sub_title_list`,`main_creator_users`,`recommend_info`,`recommend_group_id`,`support_listen`,`ai_usage_type`,`relate_book_id`,`relate_post_id`,`relate_genre_type`,`create_time`,`season_index`,`video_tag_info`,`user_creator_type`,`video_category_type`,`video_share_info`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, tu4.a aVar) {
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
            supportSQLiteStatement.bindLong(4, aVar.d);
            String str4 = aVar.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            String str5 = aVar.f;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str5);
            }
            String str6 = aVar.g;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str6);
            }
            supportSQLiteStatement.bindLong(8, aVar.h);
            supportSQLiteStatement.bindLong(9, aVar.i ? 1L : 0L);
            supportSQLiteStatement.bindLong(10, aVar.j ? 1L : 0L);
            String str7 = aVar.k;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str7);
            }
            supportSQLiteStatement.bindLong(12, aVar.l);
            supportSQLiteStatement.bindLong(13, aVar.m);
            supportSQLiteStatement.bindLong(14, aVar.n);
            supportSQLiteStatement.bindLong(15, aVar.o);
            supportSQLiteStatement.bindLong(16, aVar.p);
            String str8 = aVar.q;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str8);
            }
            String str9 = aVar.r;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str9);
            }
            supportSQLiteStatement.bindLong(19, aVar.s);
            supportSQLiteStatement.bindLong(20, aVar.t);
            String str10 = aVar.u;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str10);
            }
            supportSQLiteStatement.bindLong(22, aVar.v);
            supportSQLiteStatement.bindLong(23, aVar.w);
            supportSQLiteStatement.bindLong(24, aVar.x);
            supportSQLiteStatement.bindLong(25, aVar.y);
            String str11 = aVar.z;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str11);
            }
            supportSQLiteStatement.bindLong(27, aVar.A ? 1L : 0L);
            String str12 = aVar.B;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str12);
            }
            supportSQLiteStatement.bindLong(29, aVar.C ? 1L : 0L);
            String str13 = aVar.D;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str13);
            }
            String str14 = aVar.E;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str14);
            }
            supportSQLiteStatement.bindLong(32, aVar.F ? 1L : 0L);
            String str15 = aVar.G;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str15);
            }
            String str16 = aVar.H;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str16);
            }
            String str17 = aVar.I;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str17);
            }
            supportSQLiteStatement.bindLong(36, aVar.J);
            supportSQLiteStatement.bindLong(37, aVar.K);
            String str18 = aVar.L;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str18);
            }
            String str19 = aVar.M;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str19);
            }
            String str20 = aVar.N;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str20);
            }
            String str21 = aVar.O;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str21);
            }
            String str22 = aVar.P;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str22);
            }
            String str23 = aVar.Q;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str23);
            }
            supportSQLiteStatement.bindLong(44, aVar.R ? 1L : 0L);
            supportSQLiteStatement.bindLong(45, aVar.S ? 1L : 0L);
            supportSQLiteStatement.bindLong(46, aVar.T ? 1L : 0L);
            supportSQLiteStatement.bindLong(47, aVar.U);
            String str24 = aVar.V;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str24);
            }
            supportSQLiteStatement.bindLong(49, aVar.W ? 1L : 0L);
            String str25 = aVar.X;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str25);
            }
            String str26 = aVar.Y;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str26);
            }
            String str27 = aVar.Z;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str27);
            }
            String str28 = aVar.a0;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str28);
            }
            String str29 = aVar.b0;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str29);
            }
            String str30 = aVar.c0;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str30);
            }
            supportSQLiteStatement.bindLong(56, aVar.d0);
            String str31 = aVar.e0;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str31);
            }
            String str32 = aVar.f0;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindString(58, str32);
            }
            String str33 = aVar.g0;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindString(59, str33);
            }
            String str34 = aVar.h0;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindString(60, str34);
            }
            supportSQLiteStatement.bindLong(61, aVar.i0 ? 1L : 0L);
            supportSQLiteStatement.bindLong(62, aVar.j0);
            String str35 = aVar.k0;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindString(63, str35);
            }
            String str36 = aVar.l0;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindString(64, str36);
            }
            String str37 = aVar.m0;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindString(65, str37);
            }
            supportSQLiteStatement.bindLong(66, aVar.n0);
            supportSQLiteStatement.bindLong(67, aVar.o0);
            String str38 = aVar.p0;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindString(68, str38);
            }
            if (aVar.q0 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, r0.intValue());
            }
            String str39 = aVar.r0;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str39);
            }
            String str40 = aVar.s0;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindString(71, str40);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<tu4.a> {
        public String createQuery() {
            return "DELETE FROM `t_video_serial_like` WHERE `vid` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, tu4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<tu4.a> {
        public String createQuery() {
            return "UPDATE OR ABORT `t_video_serial_like` SET `vid` = ?,`cover` = ?,`scene_cover` = ?,`duration` = ?,`title` = ?,`video_desc` = ?,`series_id` = ?,`digged_count` = ?,`user_digg` = ?,`followed` = ?,`sub_title` = ?,`episode_cnt` = ?,`time` = ?,`video_width` = ?,`video_height` = ?,`user_digg_timestamp_ms` = ?,`color_dominate` = ?,`bg_color_hex` = ?,`followed_cnt` = ?,`episodes_status` = ?,`series_title` = ?,`vid_index` = ?,`video_platform_type` = ?,`video_content_type` = ?,`relate_video_content_type` = ?,`update_tag` = ?,`is_vertical` = ?,`series_cover` = ?,`show_record_info` = ?,`record_number` = ?,`secondary_infos` = ?,`is_trailer` = ?,`celebrities` = ?,`category_schema` = ?,`series_intro` = ?,`series_play_cnt` = ?,`video_series_id_type` = ?,`user_id` = ?,`user_name` = ?,`user_avatar` = ?,`user_avatar_decoration_url` = ?,`user_avatar_decoration_id` = ?,`post_title` = ?,`is_ugc_video` = ?,`is_private` = ?,`online_subscribed` = ?,`online_time` = ?,`label` = ?,`enable_vision_product` = ?,`abstract_tags` = ?,`bottom_bar_type` = ?,`bottom_bar_group_id` = ?,`bottom_bar_text_list` = ?,`bottom_bar_schema` = ?,`bottom_bar_icon_url` = ?,`related_album_id` = ?,`sub_title_list` = ?,`main_creator_users` = ?,`recommend_info` = ?,`recommend_group_id` = ?,`support_listen` = ?,`ai_usage_type` = ?,`relate_book_id` = ?,`relate_post_id` = ?,`relate_genre_type` = ?,`create_time` = ?,`season_index` = ?,`video_tag_info` = ?,`user_creator_type` = ?,`video_category_type` = ?,`video_share_info` = ? WHERE `vid` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, tu4.a aVar) {
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
            supportSQLiteStatement.bindLong(4, aVar.d);
            String str4 = aVar.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            String str5 = aVar.f;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str5);
            }
            String str6 = aVar.g;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str6);
            }
            supportSQLiteStatement.bindLong(8, aVar.h);
            supportSQLiteStatement.bindLong(9, aVar.i ? 1L : 0L);
            supportSQLiteStatement.bindLong(10, aVar.j ? 1L : 0L);
            String str7 = aVar.k;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str7);
            }
            supportSQLiteStatement.bindLong(12, aVar.l);
            supportSQLiteStatement.bindLong(13, aVar.m);
            supportSQLiteStatement.bindLong(14, aVar.n);
            supportSQLiteStatement.bindLong(15, aVar.o);
            supportSQLiteStatement.bindLong(16, aVar.p);
            String str8 = aVar.q;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str8);
            }
            String str9 = aVar.r;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str9);
            }
            supportSQLiteStatement.bindLong(19, aVar.s);
            supportSQLiteStatement.bindLong(20, aVar.t);
            String str10 = aVar.u;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str10);
            }
            supportSQLiteStatement.bindLong(22, aVar.v);
            supportSQLiteStatement.bindLong(23, aVar.w);
            supportSQLiteStatement.bindLong(24, aVar.x);
            supportSQLiteStatement.bindLong(25, aVar.y);
            String str11 = aVar.z;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str11);
            }
            supportSQLiteStatement.bindLong(27, aVar.A ? 1L : 0L);
            String str12 = aVar.B;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str12);
            }
            supportSQLiteStatement.bindLong(29, aVar.C ? 1L : 0L);
            String str13 = aVar.D;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str13);
            }
            String str14 = aVar.E;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str14);
            }
            supportSQLiteStatement.bindLong(32, aVar.F ? 1L : 0L);
            String str15 = aVar.G;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str15);
            }
            String str16 = aVar.H;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str16);
            }
            String str17 = aVar.I;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str17);
            }
            supportSQLiteStatement.bindLong(36, aVar.J);
            supportSQLiteStatement.bindLong(37, aVar.K);
            String str18 = aVar.L;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str18);
            }
            String str19 = aVar.M;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str19);
            }
            String str20 = aVar.N;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str20);
            }
            String str21 = aVar.O;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str21);
            }
            String str22 = aVar.P;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str22);
            }
            String str23 = aVar.Q;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str23);
            }
            supportSQLiteStatement.bindLong(44, aVar.R ? 1L : 0L);
            supportSQLiteStatement.bindLong(45, aVar.S ? 1L : 0L);
            supportSQLiteStatement.bindLong(46, aVar.T ? 1L : 0L);
            supportSQLiteStatement.bindLong(47, aVar.U);
            String str24 = aVar.V;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str24);
            }
            supportSQLiteStatement.bindLong(49, aVar.W ? 1L : 0L);
            String str25 = aVar.X;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str25);
            }
            String str26 = aVar.Y;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str26);
            }
            String str27 = aVar.Z;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str27);
            }
            String str28 = aVar.a0;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str28);
            }
            String str29 = aVar.b0;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str29);
            }
            String str30 = aVar.c0;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str30);
            }
            supportSQLiteStatement.bindLong(56, aVar.d0);
            String str31 = aVar.e0;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str31);
            }
            String str32 = aVar.f0;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindString(58, str32);
            }
            String str33 = aVar.g0;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindString(59, str33);
            }
            String str34 = aVar.h0;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindString(60, str34);
            }
            supportSQLiteStatement.bindLong(61, aVar.i0 ? 1L : 0L);
            supportSQLiteStatement.bindLong(62, aVar.j0);
            String str35 = aVar.k0;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindString(63, str35);
            }
            String str36 = aVar.l0;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindString(64, str36);
            }
            String str37 = aVar.m0;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindString(65, str37);
            }
            supportSQLiteStatement.bindLong(66, aVar.n0);
            supportSQLiteStatement.bindLong(67, aVar.o0);
            String str38 = aVar.p0;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindString(68, str38);
            }
            if (aVar.q0 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, r0.intValue());
            }
            String str39 = aVar.r0;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str39);
            }
            String str40 = aVar.s0;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindString(71, str40);
            }
            String str41 = aVar.a;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindString(72, str41);
            }
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_video_serial_like WHERE vid =?";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
