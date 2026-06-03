package com.dragon.read.local.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.interfaces.IIMParticipantDao;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import nr4.a1;
import nr4.a2;
import nr4.a3;
import nr4.a4;
import nr4.a5;
import nr4.b0;
import nr4.b1;
import nr4.b3;
import nr4.b5;
import nr4.c0;
import nr4.c4;
import nr4.d1;
import nr4.d3;
import nr4.d4;
import nr4.d5;
import nr4.e0;
import nr4.e1;
import nr4.e5;
import nr4.f0;
import nr4.f4;
import nr4.f5;
import nr4.g1;
import nr4.g4;
import nr4.h0;
import nr4.h1;
import nr4.i0;
import nr4.i4;
import nr4.j0;
import nr4.j1;
import nr4.j4;
import nr4.k0;
import nr4.k1;
import nr4.l4;
import nr4.m0;
import nr4.m1;
import nr4.m4;
import nr4.o1;
import nr4.o3;
import nr4.o4;
import nr4.p1;
import nr4.p4;
import nr4.q;
import nr4.q3;
import nr4.r1;
import nr4.r3;
import nr4.r4;
import nr4.s;
import nr4.s1;
import nr4.s4;
import nr4.t;
import nr4.u1;
import nr4.u3;
import nr4.u4;
import nr4.v;
import nr4.v0;
import nr4.v1;
import nr4.v4;
import nr4.w;
import nr4.x0;
import nr4.x1;
import nr4.x3;
import nr4.x4;
import nr4.y;
import nr4.y0;
import nr4.y1;
import nr4.y2;
import nr4.y4;
import nr4.z;
import nr4.z3;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DBManager_Impl extends DBManager {
    private volatile e1 A;
    private volatile b1 B;
    private volatile y4 C;
    private volatile e5 D;
    private volatile b5 E;
    private volatile nr4.a F;
    private volatile y0 G;
    private volatile j H;
    private volatile m I;
    private volatile g J;
    private volatile nr4.k K;
    private volatile y1 L;
    private volatile IIMParticipantDao M;
    private volatile v0 N;
    private volatile k1 O;
    private volatile s4 P;
    private volatile m4 Q;
    private volatile q a;
    private volatile k0 b;
    private volatile nr4.n c;
    private volatile w d;
    private volatile h1 e;
    private volatile z f;
    private volatile i0 g;
    private volatile a4 h;
    private volatile g4 i;
    private volatile d4 j;
    private volatile x3 k;
    private volatile o3 l;
    private volatile r3 m;
    private volatile y2 n;
    private volatile b3 o;
    private volatile nr4.g p;
    private volatile nr4.d q;
    private volatile f0 r;
    private volatile c0 s;
    private volatile v1 t;
    private volatile s1 u;
    private volatile t v;
    private volatile v4 w;
    private volatile j4 x;
    private volatile p4 y;
    private volatile p1 z;

    static {
        Covode.recordClassIndex(611519);
    }

    class a extends RoomOpenHelper.Delegate {
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(58);
            hashMap.put("author", new TableInfo.Column("author", "TEXT", false, 0, (String) null, 1));
            hashMap.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("listen_bookshelf_name", new TableInfo.Column("listen_bookshelf_name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("cover_url", new TableInfo.Column("cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("genre_type", new TableInfo.Column("genre_type", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("genre", new TableInfo.Column("genre", "TEXT", false, 0, (String) null, 1));
            hashMap.put("length_type", new TableInfo.Column("length_type", "TEXT", false, 0, (String) null, 1));
            hashMap.put("is_finish", new TableInfo.Column("is_finish", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("last_serial_count", new TableInfo.Column("last_serial_count", "TEXT", false, 0, (String) null, 1));
            hashMap.put("serial_count", new TableInfo.Column("serial_count", "TEXT", false, 0, (String) null, 1));
            hashMap.put("tts_status", new TableInfo.Column("tts_status", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("update_status", new TableInfo.Column("update_status", "TEXT", false, 0, (String) null, 1));
            hashMap.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("is_exclusive", new TableInfo.Column("is_exclusive", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("icon_tag", new TableInfo.Column("icon_tag", "TEXT", false, 0, (String) null, 1));
            hashMap.put("recommend_info", new TableInfo.Column("recommend_info", "TEXT", false, 0, (String) null, 1));
            hashMap.put("recommend_group_id", new TableInfo.Column("recommend_group_id", "TEXT", false, 0, (String) null, 1));
            hashMap.put("book_status", new TableInfo.Column("book_status", "TEXT", false, 0, (String) null, 1));
            hashMap.put("valid_in_cn_region", new TableInfo.Column("valid_in_cn_region", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("last_chapter_title", new TableInfo.Column("last_chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap.put("last_chapter_update_time", new TableInfo.Column("last_chapter_update_time", "TEXT", false, 0, (String) null, 1));
            hashMap.put("category", new TableInfo.Column("category", "TEXT", false, 0, (String) null, 1));
            hashMap.put("gender", new TableInfo.Column("gender", "TEXT", false, 0, (String) null, 1));
            hashMap.put("is_in_bookshelf", new TableInfo.Column("is_in_bookshelf", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("is_pub_pay", new TableInfo.Column("is_pub_pay", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("pay_type", new TableInfo.Column("pay_type", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("show_vip_tag", new TableInfo.Column("show_vip_tag", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("op_tag", new TableInfo.Column("op_tag", "TEXT", false, 0, (String) null, 1));
            hashMap.put("authorId", new TableInfo.Column("authorId", "TEXT", false, 0, "''", 1));
            hashMap.put("abstraction", new TableInfo.Column("abstraction", "TEXT", false, 0, "''", 1));
            hashMap.put("readCount", new TableInfo.Column("readCount", "TEXT", false, 0, "'0'", 1));
            hashMap.put("wordNumber", new TableInfo.Column("wordNumber", "INTEGER", true, 0, "0", 1));
            hashMap.put("score", new TableInfo.Column("score", "TEXT", false, 0, "'0'", 1));
            hashMap.put("creationStatus", new TableInfo.Column("creationStatus", "INTEGER", true, 0, "-1", 1));
            hashMap.put("authorizeType", new TableInfo.Column("authorizeType", "TEXT", false, 0, "''", 1));
            hashMap.put("firstChapterId", new TableInfo.Column("firstChapterId", "TEXT", false, 0, "''", 1));
            hashMap.put("bookRankInfoList", new TableInfo.Column("bookRankInfoList", "TEXT", false, 0, "''", 1));
            hashMap.put("categorySchema", new TableInfo.Column("categorySchema", "TEXT", false, 0, "''", 1));
            hashMap.put("titlePageTags", new TableInfo.Column("titlePageTags", "TEXT", false, 0, "''", 1));
            hashMap.put("source", new TableInfo.Column("source", "TEXT", false, 0, "''", 1));
            hashMap.put("isEbook", new TableInfo.Column("isEbook", "TEXT", false, 0, "''", 1));
            hashMap.put("audioThumbUri", new TableInfo.Column("audioThumbUri", "TEXT", false, 0, "''", 1));
            hashMap.put("tags", new TableInfo.Column("tags", "TEXT", false, 0, "''", 1));
            hashMap.put("listenCount", new TableInfo.Column("listenCount", "TEXT", false, 0, "'0'", 1));
            hashMap.put("color_dominate", new TableInfo.Column("color_dominate", "TEXT", false, 0, (String) null, 1));
            hashMap.put("horiz_thumb_url", new TableInfo.Column("horiz_thumb_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("book_short_name", new TableInfo.Column("book_short_name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("poster_id", new TableInfo.Column("poster_id", "TEXT", false, 0, (String) null, 1));
            hashMap.put("flight_user_selected", new TableInfo.Column("flight_user_selected", "INTEGER", true, 0, "0", 1));
            hashMap.put("audio_thumb_url_hd", new TableInfo.Column("audio_thumb_url_hd", "TEXT", false, 0, (String) null, 1));
            hashMap.put("small_cover_url", new TableInfo.Column("small_cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("relative_post_schema", new TableInfo.Column("relative_post_schema", "TEXT", false, 0, (String) null, 1));
            hashMap.put("relative_post_id", new TableInfo.Column("relative_post_id", "TEXT", false, 0, (String) null, 1));
            hashMap.put("book_only_tts", new TableInfo.Column("book_only_tts", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("platform", new TableInfo.Column("platform", "TEXT", false, 0, (String) null, 1));
            hashMap.put("color_audio_dominate", new TableInfo.Column("color_audio_dominate", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo = new TableInfo("t_book", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "t_book");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "t_book(com.dragon.read.local.db.entity.Book).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("add_type", new TableInfo.Column("add_type", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap2.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap2.put("booklist_name", new TableInfo.Column("booklist_name", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("is_sync", new TableInfo.Column("is_sync", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("is_delete", new TableInfo.Column("is_delete", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("booklist_operate_time", new TableInfo.Column("booklist_operate_time", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("is_pinned", new TableInfo.Column("is_pinned", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("pinned_time", new TableInfo.Column("pinned_time", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("booklist_id", new TableInfo.Column("booklist_id", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("is_asterisked", new TableInfo.Column("is_asterisked", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("is_chased_updates", new TableInfo.Column("is_chased_updates", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("add_bookshelf_time_sec", new TableInfo.Column("add_bookshelf_time_sec", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("is_preheat_book_pinned", new TableInfo.Column("is_preheat_book_pinned", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo2 = new TableInfo("t_bookshelf", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "t_bookshelf");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "t_bookshelf(com.dragon.read.local.db.entity.BookshelfOld).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(26);
            hashMap3.put("author_name", new TableInfo.Column("author_name", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("book_name", new TableInfo.Column("book_name", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("cover_url", new TableInfo.Column("cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("genre_type", new TableInfo.Column("genre_type", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("tts_status", new TableInfo.Column("tts_status", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap3.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap3.put("last_update_time", new TableInfo.Column("last_update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("read_time", new TableInfo.Column("read_time", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("is_delete", new TableInfo.Column("is_delete", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("has_sync", new TableInfo.Column("has_sync", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("resource", new TableInfo.Column("resource", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("is_finish", new TableInfo.Column("is_finish", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("recent_read_count", new TableInfo.Column("recent_read_count", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("score", new TableInfo.Column("score", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("source", new TableInfo.Column("source", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("page_info", new TableInfo.Column("page_info", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("is_pub_pay", new TableInfo.Column("is_pub_pay", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("pay_type", new TableInfo.Column("pay_type", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("color_dominate", new TableInfo.Column("color_dominate", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("tone_id", new TableInfo.Column("tone_id", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("platform_book_id", new TableInfo.Column("platform_book_id", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("total_read_time", new TableInfo.Column("total_read_time", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("exact_read_time", new TableInfo.Column("exact_read_time", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("exact_read_word_num", new TableInfo.Column("exact_read_word_num", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo3 = new TableInfo("t_book_record", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "t_book_record");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "t_book_record(com.dragon.read.local.db.entity.BookRecord).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(19);
            hashMap4.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", false, 0, (String) null, 1));
            hashMap4.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap4.put("page_index", new TableInfo.Column("page_index", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("progress_rate", new TableInfo.Column("progress_rate", "REAL", true, 0, (String) null, 1));
            hashMap4.put("sync", new TableInfo.Column("sync", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap4.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap4.put("pager_progress_rate", new TableInfo.Column("pager_progress_rate", "REAL", true, 0, (String) null, 1));
            hashMap4.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("line_in_paragraph_offset", new TableInfo.Column("line_in_paragraph_offset", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("tone_id", new TableInfo.Column("tone_id", "INTEGER", true, 0, "0", 1));
            hashMap4.put("tone_id_after_v579", new TableInfo.Column("tone_id_after_v579", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("channel_id", new TableInfo.Column("channel_id", "INTEGER", true, 0, "0", 1));
            hashMap4.put("cur_channel_id", new TableInfo.Column("cur_channel_id", "INTEGER", true, 0, "0", 1));
            TableInfo tableInfo4 = new TableInfo("t_book_progress", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "t_book_progress");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "t_book_progress(com.dragon.read.local.db.entity.BookProgress).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(8);
            hashMap5.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap5.put("book_name", new TableInfo.Column("book_name", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("cover_url", new TableInfo.Column("cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("category", new TableInfo.Column("category", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("width", new TableInfo.Column("width", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("height", new TableInfo.Column("height", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("book_status", new TableInfo.Column("book_status", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo5 = new TableInfo("t_interactive_record", hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase, "t_interactive_record");
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "t_interactive_record(com.dragon.read.local.db.entity.InteractiveRecord).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            HashMap hashMap6 = new HashMap(6);
            hashMap6.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap6.put("book_name", new TableInfo.Column("book_name", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("cover_url", new TableInfo.Column("cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("category", new TableInfo.Column("category", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("book_status", new TableInfo.Column("book_status", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo6 = new TableInfo("t_dialogue_record", hashMap6, new HashSet(0), new HashSet(0));
            TableInfo read6 = TableInfo.read(supportSQLiteDatabase, "t_dialogue_record");
            if (!tableInfo6.equals(read6)) {
                return new RoomOpenHelper.ValidationResult(false, "t_dialogue_record(com.dragon.read.local.db.entity.DialogueRecord).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
            HashMap hashMap7 = new HashMap(6);
            hashMap7.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap7.put("progress", new TableInfo.Column("progress", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("chapter_name", new TableInfo.Column("chapter_name", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo7 = new TableInfo("t_dialogue_progress", hashMap7, new HashSet(0), new HashSet(0));
            TableInfo read7 = TableInfo.read(supportSQLiteDatabase, "t_dialogue_progress");
            if (!tableInfo7.equals(read7)) {
                return new RoomOpenHelper.ValidationResult(false, "t_dialogue_progress(com.dragon.read.local.db.entity.DialogueProgress).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
            }
            HashMap hashMap8 = new HashMap(4);
            hashMap8.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("cache_key", new TableInfo.Column("cache_key", "TEXT", true, 1, (String) null, 1));
            hashMap8.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("cache_value", new TableInfo.Column("cache_value", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo8 = new TableInfo("t_cache_table", hashMap8, new HashSet(0), new HashSet(0));
            TableInfo read8 = TableInfo.read(supportSQLiteDatabase, "t_cache_table");
            if (!tableInfo8.equals(read8)) {
                return new RoomOpenHelper.ValidationResult(false, "t_cache_table(com.dragon.read.local.db.entity.CacheEntity).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
            }
            HashMap hashMap9 = new HashMap(2);
            hashMap9.put("search_record", new TableInfo.Column("search_record", "TEXT", true, 1, (String) null, 1));
            hashMap9.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo9 = new TableInfo("t_search_record", hashMap9, new HashSet(0), new HashSet(0));
            TableInfo read9 = TableInfo.read(supportSQLiteDatabase, "t_search_record");
            if (!tableInfo9.equals(read9)) {
                return new RoomOpenHelper.ValidationResult(false, "t_search_record(com.dragon.read.local.db.entity.SearchRecord).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
            }
            HashMap hashMap10 = new HashMap(4);
            hashMap10.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
            hashMap10.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap10.put("relative_audio_book_id_set", new TableInfo.Column("relative_audio_book_id_set", "TEXT", false, 0, (String) null, 1));
            hashMap10.put("relative_novel_book_id", new TableInfo.Column("relative_novel_book_id", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo10 = new TableInfo("t_relative_book_id", hashMap10, new HashSet(0), new HashSet(0));
            TableInfo read10 = TableInfo.read(supportSQLiteDatabase, "t_relative_book_id");
            if (!tableInfo10.equals(read10)) {
                return new RoomOpenHelper.ValidationResult(false, "t_relative_book_id(com.dragon.read.local.db.entity.RelativeBook).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
            }
            HashMap hashMap11 = new HashMap(10);
            hashMap11.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap11.put("read_time", new TableInfo.Column("read_time", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("today_read_time", new TableInfo.Column("today_read_time", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("today_time_stamp", new TableInfo.Column("today_time_stamp", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("last_popup_time", new TableInfo.Column("last_popup_time", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("last_popup_read_time", new TableInfo.Column("last_popup_read_time", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("read_chapter_count", new TableInfo.Column("read_chapter_count", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("chapter_count", new TableInfo.Column("chapter_count", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("popup_count", new TableInfo.Column("popup_count", "INTEGER", true, 0, (String) null, 1));
            hashMap11.put("popup_count_for_chase_comment", new TableInfo.Column("popup_count_for_chase_comment", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo11 = new TableInfo("t_reading_record", hashMap11, new HashSet(0), new HashSet(0));
            TableInfo read11 = TableInfo.read(supportSQLiteDatabase, "t_reading_record");
            if (!tableInfo11.equals(read11)) {
                return new RoomOpenHelper.ValidationResult(false, "t_reading_record(com.dragon.read.local.db.entity.ReadingRecord).\n Expected:\n" + tableInfo11 + "\n Found:\n" + read11);
            }
            HashMap hashMap12 = new HashMap(4);
            hashMap12.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap12.put("date", new TableInfo.Column("date", "TEXT", false, 0, (String) null, 1));
            hashMap12.put("book_id", new TableInfo.Column("book_id", "TEXT", false, 0, (String) null, 1));
            hashMap12.put("reading_time", new TableInfo.Column("reading_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo12 = new TableInfo("t_reading_time", hashMap12, new HashSet(0), new HashSet(0));
            TableInfo read12 = TableInfo.read(supportSQLiteDatabase, "t_reading_time");
            if (!tableInfo12.equals(read12)) {
                return new RoomOpenHelper.ValidationResult(false, "t_reading_time(com.dragon.read.local.db.entity.ReadingTime).\n Expected:\n" + tableInfo12 + "\n Found:\n" + read12);
            }
            HashMap hashMap13 = new HashMap(17);
            hashMap13.put("book_id", new TableInfo.Column("book_id", "TEXT", false, 0, (String) null, 1));
            hashMap13.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 1, (String) null, 1));
            hashMap13.put("book_name", new TableInfo.Column("book_name", "TEXT", false, 0, (String) null, 1));
            hashMap13.put("tone_id", new TableInfo.Column("tone_id", "INTEGER", true, 2, (String) null, 1));
            hashMap13.put("status", new TableInfo.Column("status", "INTEGER", true, 0, (String) null, 1));
            hashMap13.put("progress", new TableInfo.Column("progress", "INTEGER", true, 0, (String) null, 1));
            hashMap13.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap13.put("download_url", new TableInfo.Column("download_url", "TEXT", false, 0, (String) null, 1));
            hashMap13.put("is_encrypt", new TableInfo.Column("is_encrypt", "INTEGER", true, 0, (String) null, 1));
            hashMap13.put("encrypt_key", new TableInfo.Column("encrypt_key", "TEXT", false, 0, (String) null, 1));
            hashMap13.put("download_id", new TableInfo.Column("download_id", "INTEGER", true, 0, (String) null, 1));
            hashMap13.put("abs_save_path", new TableInfo.Column("abs_save_path", "TEXT", false, 0, (String) null, 1));
            hashMap13.put("chapter_name", new TableInfo.Column("chapter_name", "TEXT", false, 0, (String) null, 1));
            hashMap13.put("current_length", new TableInfo.Column("current_length", "REAL", true, 0, (String) null, 1));
            hashMap13.put("total_length", new TableInfo.Column("total_length", "REAL", true, 0, (String) null, 1));
            hashMap13.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, (String) null, 1));
            hashMap13.put("pause_reason", new TableInfo.Column("pause_reason", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo13 = new TableInfo("t_audio_download_status", hashMap13, new HashSet(0), new HashSet(0));
            TableInfo read13 = TableInfo.read(supportSQLiteDatabase, "t_audio_download_status");
            if (!tableInfo13.equals(read13)) {
                return new RoomOpenHelper.ValidationResult(false, "t_audio_download_status(com.dragon.read.local.db.entity.AudioDlStatusEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + read13);
            }
            HashMap hashMap14 = new HashMap(13);
            hashMap14.put("book_id", new TableInfo.Column("book_id", "TEXT", false, 0, (String) null, 1));
            hashMap14.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 1, (String) null, 1));
            hashMap14.put("book_name", new TableInfo.Column("book_name", "TEXT", false, 0, (String) null, 1));
            hashMap14.put("tone_id", new TableInfo.Column("tone_id", "INTEGER", true, 2, (String) null, 1));
            hashMap14.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap14.put("is_encrypt", new TableInfo.Column("is_encrypt", "INTEGER", true, 0, (String) null, 1));
            hashMap14.put("encrypt_key", new TableInfo.Column("encrypt_key", "TEXT", false, 0, (String) null, 1));
            hashMap14.put("download_id", new TableInfo.Column("download_id", "INTEGER", true, 0, (String) null, 1));
            hashMap14.put("abs_save_path", new TableInfo.Column("abs_save_path", "TEXT", false, 0, (String) null, 1));
            hashMap14.put("chapter_name", new TableInfo.Column("chapter_name", "TEXT", false, 0, (String) null, 1));
            hashMap14.put("current_length", new TableInfo.Column("current_length", "REAL", true, 0, (String) null, 1));
            hashMap14.put("total_length", new TableInfo.Column("total_length", "REAL", true, 0, (String) null, 1));
            hashMap14.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo14 = new TableInfo("t_audio_download_result", hashMap14, new HashSet(0), new HashSet(0));
            TableInfo read14 = TableInfo.read(supportSQLiteDatabase, "t_audio_download_result");
            if (!tableInfo14.equals(read14)) {
                return new RoomOpenHelper.ValidationResult(false, "t_audio_download_result(com.dragon.read.local.db.entity.AudioDlResultEntity).\n Expected:\n" + tableInfo14 + "\n Found:\n" + read14);
            }
            HashMap hashMap15 = new HashMap(25);
            hashMap15.put("mark_id", new TableInfo.Column("mark_id", "INTEGER", true, 1, (String) null, 1));
            hashMap15.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap15.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap15.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("end_paragraph_id", new TableInfo.Column("end_paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("content", new TableInfo.Column("content", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("volume_name", new TableInfo.Column("volume_name", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("start_media_index", new TableInfo.Column("start_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("end_media_index", new TableInfo.Column("end_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap15.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo15 = new TableInfo("t_bookmark_remote", hashMap15, new HashSet(0), new HashSet(0));
            TableInfo read15 = TableInfo.read(supportSQLiteDatabase, "t_bookmark_remote");
            if (!tableInfo15.equals(read15)) {
                return new RoomOpenHelper.ValidationResult(false, "t_bookmark_remote(com.dragon.read.local.db.entity.BookmarkRemoteDB).\n Expected:\n" + tableInfo15 + "\n Found:\n" + read15);
            }
            HashMap hashMap16 = new HashMap(24);
            hashMap16.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap16.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap16.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap16.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("end_paragraph_id", new TableInfo.Column("end_paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", false, 0, (String) null, 1));
            hashMap16.put("content", new TableInfo.Column("content", "TEXT", false, 0, (String) null, 1));
            hashMap16.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap16.put("volume_name", new TableInfo.Column("volume_name", "TEXT", false, 0, (String) null, 1));
            hashMap16.put("start_media_index", new TableInfo.Column("start_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("end_media_index", new TableInfo.Column("end_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap16.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap16.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo16 = new TableInfo("t_bookmark_local", hashMap16, new HashSet(0), new HashSet(0));
            TableInfo read16 = TableInfo.read(supportSQLiteDatabase, "t_bookmark_local");
            if (!tableInfo16.equals(read16)) {
                return new RoomOpenHelper.ValidationResult(false, "t_bookmark_local(com.dragon.read.local.db.entity.BookmarkLocalDB).\n Expected:\n" + tableInfo16 + "\n Found:\n" + read16);
            }
            HashMap hashMap17 = new HashMap(20);
            hashMap17.put("bookshelf_update_time", new TableInfo.Column("bookshelf_update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap17.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap17.put("cover_url", new TableInfo.Column("cover_url", "TEXT", true, 0, (String) null, 1));
            hashMap17.put("book_name", new TableInfo.Column("book_name", "TEXT", true, 0, (String) null, 1));
            hashMap17.put("file_path", new TableInfo.Column("file_path", "TEXT", true, 0, (String) null, 1));
            hashMap17.put("last_chapter_id", new TableInfo.Column("last_chapter_id", "TEXT", false, 0, (String) null, 1));
            hashMap17.put("last_chapter_title", new TableInfo.Column("last_chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap17.put("last_page_index", new TableInfo.Column("last_page_index", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("progress_rate", new TableInfo.Column("progress_rate", "REAL", true, 0, (String) null, 1));
            hashMap17.put("progress_update_time", new TableInfo.Column("progress_update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("line_in_paragraph_offset", new TableInfo.Column("line_in_paragraph_offset", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("is_external", new TableInfo.Column("is_external", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("booklist_name", new TableInfo.Column("booklist_name", "TEXT", false, 0, (String) null, 1));
            hashMap17.put("mime_type", new TableInfo.Column("mime_type", "TEXT", true, 0, (String) null, 1));
            hashMap17.put(Constants.VERSION, new TableInfo.Column(Constants.VERSION, "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("is_pinned", new TableInfo.Column("is_pinned", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("pinned_time", new TableInfo.Column("pinned_time", "INTEGER", true, 0, (String) null, 1));
            hashMap17.put("is_asterisked", new TableInfo.Column("is_asterisked", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo17 = new TableInfo("t_local_book", hashMap17, new HashSet(0), new HashSet(0));
            TableInfo read17 = TableInfo.read(supportSQLiteDatabase, "t_local_book");
            if (!tableInfo17.equals(read17)) {
                return new RoomOpenHelper.ValidationResult(false, "t_local_book(com.dragon.read.local.db.entity.LocalBook).\n Expected:\n" + tableInfo17 + "\n Found:\n" + read17);
            }
            HashMap hashMap18 = new HashMap(14);
            hashMap18.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap18.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap18.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap18.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap18.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap18.put("end_paragraph_id", new TableInfo.Column("end_paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap18.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap18.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap18.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", false, 0, (String) null, 1));
            hashMap18.put("content", new TableInfo.Column("content", "TEXT", false, 0, (String) null, 1));
            hashMap18.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap18.put("volume_name", new TableInfo.Column("volume_name", "TEXT", false, 0, (String) null, 1));
            hashMap18.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap18.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo18 = new TableInfo("t_local_book_bookmark", hashMap18, new HashSet(0), new HashSet(0));
            TableInfo read18 = TableInfo.read(supportSQLiteDatabase, "t_local_book_bookmark");
            if (!tableInfo18.equals(read18)) {
                return new RoomOpenHelper.ValidationResult(false, "t_local_book_bookmark(com.dragon.read.local.db.entity.LocalBookBookmarkDB).\n Expected:\n" + tableInfo18 + "\n Found:\n" + read18);
            }
            HashMap hashMap19 = new HashMap(6);
            hashMap19.put("booklist_id", new TableInfo.Column("booklist_id", "INTEGER", true, 1, (String) null, 1));
            hashMap19.put("booklist_name", new TableInfo.Column("booklist_name", "TEXT", false, 0, (String) null, 1));
            hashMap19.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap19.put("pinned_time", new TableInfo.Column("pinned_time", "INTEGER", true, 0, (String) null, 1));
            hashMap19.put("real_booklist_id", new TableInfo.Column("real_booklist_id", "INTEGER", true, 0, (String) null, 1));
            hashMap19.put("is_pinned", new TableInfo.Column("is_pinned", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo19 = new TableInfo("t_booklist", hashMap19, new HashSet(0), new HashSet(0));
            TableInfo read19 = TableInfo.read(supportSQLiteDatabase, "t_booklist");
            if (!tableInfo19.equals(read19)) {
                return new RoomOpenHelper.ValidationResult(false, "t_booklist(com.dragon.read.local.db.entity.BookGroup).\n Expected:\n" + tableInfo19 + "\n Found:\n" + read19);
            }
            HashMap hashMap20 = new HashMap(3);
            hashMap20.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, (String) null, 1));
            hashMap20.put("nick_name", new TableInfo.Column("nick_name", "TEXT", true, 0, (String) null, 1));
            hashMap20.put("avatar_url", new TableInfo.Column("avatar_url", "TEXT", true, 0, (String) null, 1));
            TableInfo tableInfo20 = new TableInfo("t_user_info", hashMap20, new HashSet(0), new HashSet(0));
            TableInfo read20 = TableInfo.read(supportSQLiteDatabase, "t_user_info");
            if (!tableInfo20.equals(read20)) {
                return new RoomOpenHelper.ValidationResult(false, "t_user_info(com.dragon.read.local.db.entity.UserInfo).\n Expected:\n" + tableInfo20 + "\n Found:\n" + read20);
            }
            HashMap hashMap21 = new HashMap(23);
            hashMap21.put("book_list_id", new TableInfo.Column("book_list_id", "TEXT", true, 1, (String) null, 1));
            hashMap21.put("topic_id", new TableInfo.Column("topic_id", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("topic_title", new TableInfo.Column("topic_title", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("topic_status", new TableInfo.Column("topic_status", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("topic_schemes", new TableInfo.Column("topic_schemes", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("book_count", new TableInfo.Column("book_count", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("subscribe_time", new TableInfo.Column("subscribe_time", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("click_time", new TableInfo.Column("click_time", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("operate_time", new TableInfo.Column("operate_time", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("delete_time", new TableInfo.Column("delete_time", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("is_sync", new TableInfo.Column("is_sync", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("is_delete", new TableInfo.Column("is_delete", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("book_list_type", new TableInfo.Column("book_list_type", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("user_info", new TableInfo.Column("user_info", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("recommend_text", new TableInfo.Column("recommend_text", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("is_pinned", new TableInfo.Column("is_pinned", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("pinned_time", new TableInfo.Column("pinned_time", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("author_name", new TableInfo.Column("author_name", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("author_abstract", new TableInfo.Column("author_abstract", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("author_pic_url", new TableInfo.Column("author_pic_url", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("author_id", new TableInfo.Column("author_id", "INTEGER", true, 0, (String) null, 1));
            hashMap21.put("secondary_info", new TableInfo.Column("secondary_info", "TEXT", false, 0, (String) null, 1));
            hashMap21.put("show_update_notify", new TableInfo.Column("show_update_notify", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo21 = new TableInfo("t_ugc_book_list", hashMap21, new HashSet(0), new HashSet(0));
            TableInfo read21 = TableInfo.read(supportSQLiteDatabase, "t_ugc_book_list");
            if (!tableInfo21.equals(read21)) {
                return new RoomOpenHelper.ValidationResult(false, "t_ugc_book_list(com.dragon.read.local.db.entity.UgcBookList).\n Expected:\n" + tableInfo21 + "\n Found:\n" + read21);
            }
            HashMap hashMap22 = new HashMap(7);
            hashMap22.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap22.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap22.put("book_list_id", new TableInfo.Column("book_list_id", "TEXT", true, 3, (String) null, 1));
            hashMap22.put("recommend_count", new TableInfo.Column("recommend_count", "TEXT", false, 0, (String) null, 1));
            hashMap22.put("read_count", new TableInfo.Column("read_count", "TEXT", false, 0, (String) null, 1));
            hashMap22.put("book_rank", new TableInfo.Column("book_rank", "INTEGER", true, 0, (String) null, 1));
            hashMap22.put("color_dominate", new TableInfo.Column("color_dominate", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo22 = new TableInfo("t_ugc_book_info", hashMap22, new HashSet(0), new HashSet(0));
            TableInfo read22 = TableInfo.read(supportSQLiteDatabase, "t_ugc_book_info");
            if (!tableInfo22.equals(read22)) {
                return new RoomOpenHelper.ValidationResult(false, "t_ugc_book_info(com.dragon.read.local.db.entity.UgcBookInfo).\n Expected:\n" + tableInfo22 + "\n Found:\n" + read22);
            }
            HashMap hashMap23 = new HashMap(5);
            hashMap23.put("bookId", new TableInfo.Column("bookId", "TEXT", true, 1, (String) null, 1));
            hashMap23.put("date_time", new TableInfo.Column("date_time", "TEXT", true, 0, (String) null, 1));
            hashMap23.put("today_show_count", new TableInfo.Column("today_show_count", "INTEGER", true, 0, (String) null, 1));
            hashMap23.put("last_read_count", new TableInfo.Column("last_read_count", "INTEGER", true, 0, (String) null, 1));
            hashMap23.put("read_count", new TableInfo.Column("read_count", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo23 = new TableInfo("shelf_control_model", hashMap23, new HashSet(0), new HashSet(0));
            TableInfo read23 = TableInfo.read(supportSQLiteDatabase, "shelf_control_model");
            if (!tableInfo23.equals(read23)) {
                return new RoomOpenHelper.ValidationResult(false, "shelf_control_model(com.dragon.read.local.db.entity.AddShelfDialogControlModel).\n Expected:\n" + tableInfo23 + "\n Found:\n" + read23);
            }
            HashMap hashMap24 = new HashMap(45);
            hashMap24.put("author_name", new TableInfo.Column("author_name", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("author_id", new TableInfo.Column("author_id", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("book_name", new TableInfo.Column("book_name", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("book_id", new TableInfo.Column("book_id", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("series_id", new TableInfo.Column("series_id", "TEXT", true, 1, (String) null, 1));
            hashMap24.put("series_name", new TableInfo.Column("series_name", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("current_episode_id", new TableInfo.Column("current_episode_id", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("episodes_list_count_text", new TableInfo.Column("episodes_list_count_text", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("current_video_title", new TableInfo.Column("current_video_title", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("cover_url", new TableInfo.Column("cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("vid", new TableInfo.Column("vid", "TEXT", true, 2, (String) null, 1));
            hashMap24.put("content_type", new TableInfo.Column("content_type", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("total_time", new TableInfo.Column("total_time", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("current_play_position", new TableInfo.Column("current_play_position", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("current_video_total_time", new TableInfo.Column("current_video_total_time", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("last_video_vid", new TableInfo.Column("last_video_vid", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("player_accumulate_total_time", new TableInfo.Column("player_accumulate_total_time", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("record_index", new TableInfo.Column("record_index", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("video_platform", new TableInfo.Column("video_platform", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("episode_cnt", new TableInfo.Column("episode_cnt", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("video_width", new TableInfo.Column("video_width", "INTEGER", true, 0, "0", 1));
            hashMap24.put("video_height", new TableInfo.Column("video_height", "INTEGER", true, 0, "0", 1));
            hashMap24.put("series_color_hex", new TableInfo.Column("series_color_hex", "TEXT", true, 0, (String) null, 1));
            hashMap24.put("current_episode_index", new TableInfo.Column("current_episode_index", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("update_tag", new TableInfo.Column("update_tag", "TEXT", true, 0, (String) null, 1));
            hashMap24.put("update_status", new TableInfo.Column("update_status", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("played_video_ids", new TableInfo.Column("played_video_ids", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("has_sync", new TableInfo.Column("has_sync", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("is_delete", new TableInfo.Column("is_delete", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("stayed_video_ids", new TableInfo.Column("stayed_video_ids", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("update_tag_text", new TableInfo.Column("update_tag_text", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("pugc_user_name", new TableInfo.Column("pugc_user_name", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("pugc_user_avatar", new TableInfo.Column("pugc_user_avatar", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("series_play_count", new TableInfo.Column("series_play_count", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("video_scene", new TableInfo.Column("video_scene", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("digged_count", new TableInfo.Column("digged_count", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("is_user_digg", new TableInfo.Column("is_user_digg", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("is_multi_season", new TableInfo.Column("is_multi_season", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("season_index", new TableInfo.Column("season_index", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("video_tag_info", new TableInfo.Column("video_tag_info", "TEXT", true, 0, (String) null, 1));
            hashMap24.put("is_interactive_game", new TableInfo.Column("is_interactive_game", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put("related_series_title", new TableInfo.Column("related_series_title", "TEXT", true, 0, (String) null, 1));
            hashMap24.put("secondary_info", new TableInfo.Column("secondary_info", "TEXT", true, 0, (String) null, 1));
            hashMap24.put("video_category_type", new TableInfo.Column("video_category_type", "TEXT", true, 0, (String) null, 1));
            TableInfo tableInfo24 = new TableInfo("t_video_history_record", hashMap24, new HashSet(0), new HashSet(0));
            TableInfo read24 = TableInfo.read(supportSQLiteDatabase, "t_video_history_record");
            if (!tableInfo24.equals(read24)) {
                return new RoomOpenHelper.ValidationResult(false, "t_video_history_record(com.dragon.read.pages.videorecord.model.VideoRecord).\n Expected:\n" + tableInfo24 + "\n Found:\n" + read24);
            }
            HashMap hashMap25 = new HashMap(2);
            hashMap25.put("search_record", new TableInfo.Column("search_record", "TEXT", true, 1, (String) null, 1));
            hashMap25.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo25 = new TableInfo("t_topic_search_record", hashMap25, new HashSet(0), new HashSet(0));
            TableInfo read25 = TableInfo.read(supportSQLiteDatabase, "t_topic_search_record");
            if (!tableInfo25.equals(read25)) {
                return new RoomOpenHelper.ValidationResult(false, "t_topic_search_record(com.dragon.read.local.db.entity.TopicSearchRecord).\n Expected:\n" + tableInfo25 + "\n Found:\n" + read25);
            }
            HashMap hashMap26 = new HashMap(27);
            hashMap26.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap26.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap26.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap26.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap26.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap26.put("start_para_id", new TableInfo.Column("start_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap26.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap26.put("end_para_id", new TableInfo.Column("end_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap26.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap26.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", true, 0, (String) null, 1));
            hashMap26.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
            hashMap26.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap26.put("volume_name", new TableInfo.Column("volume_name", "TEXT", true, 0, (String) null, 1));
            hashMap26.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap26.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            hashMap26.put("line_type", new TableInfo.Column("line_type", "INTEGER", true, 0, "0", 1));
            hashMap26.put("is_public", new TableInfo.Column("is_public", "INTEGER", true, 0, "0", 1));
            hashMap26.put("hot_line_id", new TableInfo.Column("hot_line_id", "INTEGER", true, 0, "0", 1));
            hashMap26.put("underline_type", new TableInfo.Column("underline_type", "INTEGER", true, 0, "0", 1));
            hashMap26.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo26 = new TableInfo("t_underline_local", hashMap26, new HashSet(0), new HashSet(0));
            TableInfo read26 = TableInfo.read(supportSQLiteDatabase, "t_underline_local");
            if (!tableInfo26.equals(read26)) {
                return new RoomOpenHelper.ValidationResult(false, "t_underline_local(com.dragon.read.local.db.entity.UnderlineLocalDB).\n Expected:\n" + tableInfo26 + "\n Found:\n" + read26);
            }
            HashMap hashMap27 = new HashMap(28);
            hashMap27.put("mark_id", new TableInfo.Column("mark_id", "INTEGER", true, 1, (String) null, 1));
            hashMap27.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap27.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap27.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("start_para_id", new TableInfo.Column("start_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("end_para_id", new TableInfo.Column("end_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", true, 0, (String) null, 1));
            hashMap27.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
            hashMap27.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap27.put("volume_name", new TableInfo.Column("volume_name", "TEXT", true, 0, (String) null, 1));
            hashMap27.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap27.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            hashMap27.put("line_type", new TableInfo.Column("line_type", "INTEGER", true, 0, "0", 1));
            hashMap27.put("is_public", new TableInfo.Column("is_public", "INTEGER", true, 0, "0", 1));
            hashMap27.put("hot_line_id", new TableInfo.Column("hot_line_id", "INTEGER", true, 0, "0", 1));
            hashMap27.put("underline_type", new TableInfo.Column("underline_type", "INTEGER", true, 0, "0", 1));
            hashMap27.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo27 = new TableInfo("t_underline_remote", hashMap27, new HashSet(0), new HashSet(0));
            TableInfo read27 = TableInfo.read(supportSQLiteDatabase, "t_underline_remote");
            if (!tableInfo27.equals(read27)) {
                return new RoomOpenHelper.ValidationResult(false, "t_underline_remote(com.dragon.read.local.db.entity.UnderlineRemoteDB).\n Expected:\n" + tableInfo27 + "\n Found:\n" + read27);
            }
            HashMap hashMap28 = new HashMap(17);
            hashMap28.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap28.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap28.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap28.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap28.put("start_para_id", new TableInfo.Column("start_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap28.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap28.put("end_para_id", new TableInfo.Column("end_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap28.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap28.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", true, 0, (String) null, 1));
            hashMap28.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
            hashMap28.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap28.put("volume_name", new TableInfo.Column("volume_name", "TEXT", true, 0, (String) null, 1));
            hashMap28.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap28.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            hashMap28.put("line_type", new TableInfo.Column("line_type", "INTEGER", true, 0, "0", 1));
            hashMap28.put("underline_type", new TableInfo.Column("underline_type", "INTEGER", true, 0, "0", 1));
            hashMap28.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo28 = new TableInfo("t_local_book_underline", hashMap28, new HashSet(0), new HashSet(0));
            TableInfo read28 = TableInfo.read(supportSQLiteDatabase, "t_local_book_underline");
            if (!tableInfo28.equals(read28)) {
                return new RoomOpenHelper.ValidationResult(false, "t_local_book_underline(com.dragon.read.local.db.entity.LocalBookUnderlineDB).\n Expected:\n" + tableInfo28 + "\n Found:\n" + read28);
            }
            HashMap hashMap29 = new HashMap(20);
            hashMap29.put("reader_font_id", new TableInfo.Column("reader_font_id", "INTEGER", true, 1, (String) null, 1));
            hashMap29.put("font_title", new TableInfo.Column("font_title", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("file_size", new TableInfo.Column("file_size", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("file_url", new TableInfo.Column("file_url", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("font_pic", new TableInfo.Column("font_pic", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("bold_name", new TableInfo.Column("bold_name", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("regular_name", new TableInfo.Column("regular_name", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("font_family", new TableInfo.Column("font_family", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("regular_file_name", new TableInfo.Column("regular_file_name", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("download_onlaunch", new TableInfo.Column("download_onlaunch", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("hidden_inreader", new TableInfo.Column("hidden_inreader", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("font_vip_type", new TableInfo.Column("font_vip_type", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("is_new_font", new TableInfo.Column("is_new_font", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("is_variable_font", new TableInfo.Column("is_variable_font", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("medium_file_name", new TableInfo.Column("medium_file_name", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("bold_file_name", new TableInfo.Column("bold_file_name", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("medium_name", new TableInfo.Column("medium_name", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("order", new TableInfo.Column("order", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("fanti_font_pic", new TableInfo.Column("fanti_font_pic", "TEXT", false, 0, (String) null, 1));
            hashMap29.put("ui_key", new TableInfo.Column("ui_key", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo29 = new TableInfo("t_font_config", hashMap29, new HashSet(0), new HashSet(0));
            TableInfo read29 = TableInfo.read(supportSQLiteDatabase, "t_font_config");
            if (!tableInfo29.equals(read29)) {
                return new RoomOpenHelper.ValidationResult(false, "t_font_config(com.dragon.read.local.db.entity.FontConfigDB).\n Expected:\n" + tableInfo29 + "\n Found:\n" + read29);
            }
            HashMap hashMap30 = new HashMap(7);
            hashMap30.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, "''", 1));
            hashMap30.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 1, "''", 1));
            hashMap30.put("para_id", new TableInfo.Column("para_id", "INTEGER", true, 0, "0", 1));
            hashMap30.put("para_offset", new TableInfo.Column("para_offset", "INTEGER", true, 0, "0", 1));
            hashMap30.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap30.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap30.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            TableInfo tableInfo30 = new TableInfo("t_book_chapter_progress", hashMap30, new HashSet(0), new HashSet(0));
            TableInfo read30 = TableInfo.read(supportSQLiteDatabase, "t_book_chapter_progress");
            if (!tableInfo30.equals(read30)) {
                return new RoomOpenHelper.ValidationResult(false, "t_book_chapter_progress(com.dragon.read.local.db.entity.BookChapterProgress).\n Expected:\n" + tableInfo30 + "\n Found:\n" + read30);
            }
            HashMap hashMap31 = new HashMap(4);
            hashMap31.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap31.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap31.put("add_book_time", new TableInfo.Column("add_book_time", "INTEGER", true, 0, (String) null, 1));
            hashMap31.put("listening_and_reading_time", new TableInfo.Column("listening_and_reading_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo31 = new TableInfo("t_bookshelf_panel", hashMap31, new HashSet(0), new HashSet(0));
            TableInfo read31 = TableInfo.read(supportSQLiteDatabase, "t_bookshelf_panel");
            if (!tableInfo31.equals(read31)) {
                return new RoomOpenHelper.ValidationResult(false, "t_bookshelf_panel(com.dragon.read.local.db.entity.BookShelfPanelInfo).\n Expected:\n" + tableInfo31 + "\n Found:\n" + read31);
            }
            HashMap hashMap32 = new HashMap(3);
            hashMap32.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap32.put("player_accumulate_total_time", new TableInfo.Column("player_accumulate_total_time", "INTEGER", true, 0, (String) null, 1));
            hashMap32.put("last_show_time_ms", new TableInfo.Column("last_show_time_ms", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo32 = new TableInfo("t_audio_bookshelf_guide_info", hashMap32, new HashSet(0), new HashSet(0));
            TableInfo read32 = TableInfo.read(supportSQLiteDatabase, "t_audio_bookshelf_guide_info");
            if (!tableInfo32.equals(read32)) {
                return new RoomOpenHelper.ValidationResult(false, "t_audio_bookshelf_guide_info(com.dragon.read.local.db.entity.AudioBookshelfGuideInfo).\n Expected:\n" + tableInfo32 + "\n Found:\n" + read32);
            }
            HashMap hashMap33 = new HashMap(5);
            hashMap33.put("comic_id", new TableInfo.Column("comic_id", "TEXT", true, 1, (String) null, 1));
            hashMap33.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 2, (String) null, 1));
            hashMap33.put("read_progress", new TableInfo.Column("read_progress", "INTEGER", true, 0, (String) null, 1));
            hashMap33.put("catalog_order", new TableInfo.Column("catalog_order", "TEXT", true, 0, (String) null, 1));
            hashMap33.put("last_update_time", new TableInfo.Column("last_update_time", "TEXT", true, 0, (String) null, 1));
            TableInfo tableInfo33 = new TableInfo("t_comic_read_progress_record", hashMap33, new HashSet(0), new HashSet(0));
            TableInfo read33 = TableInfo.read(supportSQLiteDatabase, "t_comic_read_progress_record");
            if (!tableInfo33.equals(read33)) {
                return new RoomOpenHelper.ValidationResult(false, "t_comic_read_progress_record(com.dragon.read.local.db.entity.ComicReadProgressRecordInfo).\n Expected:\n" + tableInfo33 + "\n Found:\n" + read33);
            }
            HashMap hashMap34 = new HashMap(5);
            hashMap34.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap34.put("book_content", new TableInfo.Column("book_content", "TEXT", false, 0, (String) null, 1));
            hashMap34.put("content_type", new TableInfo.Column("content_type", "INTEGER", true, 0, (String) null, 1));
            hashMap34.put("current_chapter_index", new TableInfo.Column("current_chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap34.put("expect_show_next_chapter", new TableInfo.Column("expect_show_next_chapter", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo34 = new TableInfo("t_book_content_detail", hashMap34, new HashSet(0), new HashSet(0));
            TableInfo read34 = TableInfo.read(supportSQLiteDatabase, "t_book_content_detail");
            if (!tableInfo34.equals(read34)) {
                return new RoomOpenHelper.ValidationResult(false, "t_book_content_detail(com.dragon.read.local.db.entity.BookContentDetail).\n Expected:\n" + tableInfo34 + "\n Found:\n" + read34);
            }
            HashMap hashMap35 = new HashMap(28);
            hashMap35.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap35.put("book_name", new TableInfo.Column("book_name", "TEXT", true, 0, (String) null, 1));
            hashMap35.put("horizontal_cover_url", new TableInfo.Column("horizontal_cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("vertical_cover_url", new TableInfo.Column("vertical_cover_url", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("last_update_time", new TableInfo.Column("last_update_time", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("update_status", new TableInfo.Column("update_status", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("author", new TableInfo.Column("author", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("create_time", new TableInfo.Column("create_time", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("abstraction", new TableInfo.Column("abstraction", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("read_count", new TableInfo.Column("read_count", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("score", new TableInfo.Column("score", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("creation_status", new TableInfo.Column("creation_status", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("authorize_type", new TableInfo.Column("authorize_type", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("first_chapter_id", new TableInfo.Column("first_chapter_id", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("last_chapter_id", new TableInfo.Column("last_chapter_id", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("category_scheme", new TableInfo.Column("category_scheme", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("source", new TableInfo.Column("source", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("tags", new TableInfo.Column("tags", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("color_dominate", new TableInfo.Column("color_dominate", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("serial_count", new TableInfo.Column("serial_count", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("content_chapter_count", new TableInfo.Column("content_chapter_count", "INTEGER", true, 0, (String) null, 1));
            hashMap35.put("book_content_length", new TableInfo.Column("book_content_length", "INTEGER", true, 0, (String) null, 1));
            hashMap35.put("consume_ad", new TableInfo.Column("consume_ad", "TEXT", true, 0, (String) null, 1));
            hashMap35.put("horizontal_cover_path", new TableInfo.Column("horizontal_cover_path", "TEXT", true, 0, (String) null, 1));
            hashMap35.put("vertical_cover_path", new TableInfo.Column("vertical_cover_path", "TEXT", true, 0, (String) null, 1));
            hashMap35.put("directory_sub_info", new TableInfo.Column("directory_sub_info", "TEXT", true, 0, (String) null, 1));
            hashMap35.put("book_type", new TableInfo.Column("book_type", "TEXT", false, 0, (String) null, 1));
            hashMap35.put("last_download_success_time", new TableInfo.Column("last_download_success_time", "TEXT", true, 0, "'0'", 1));
            TableInfo tableInfo35 = new TableInfo("t_comic_detail_info", hashMap35, new HashSet(0), new HashSet(0));
            TableInfo read35 = TableInfo.read(supportSQLiteDatabase, "t_comic_detail_info");
            if (!tableInfo35.equals(read35)) {
                return new RoomOpenHelper.ValidationResult(false, "t_comic_detail_info(com.dragon.read.local.db.entity.ComicBookInfoEntity).\n Expected:\n" + tableInfo35 + "\n Found:\n" + read35);
            }
            HashMap hashMap36 = new HashMap(25);
            hashMap36.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 1, (String) null, 1));
            hashMap36.put("chapter_thumb_url", new TableInfo.Column("chapter_thumb_url", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("publish_time", new TableInfo.Column("publish_time", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("chapter_name", new TableInfo.Column("chapter_name", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("book_name", new TableInfo.Column("book_name", "TEXT", true, 0, (String) null, 1));
            hashMap36.put(Constants.VERSION, new TableInfo.Column(Constants.VERSION, "TEXT", true, 0, (String) null, 1));
            hashMap36.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("key_version", new TableInfo.Column("key_version", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("content_md5", new TableInfo.Column("content_md5", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("chapter_order", new TableInfo.Column("chapter_order", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("book_chapter_count", new TableInfo.Column("book_chapter_count", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("first_pass_time", new TableInfo.Column("first_pass_time", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("volume_name", new TableInfo.Column("volume_name", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("content_key", new TableInfo.Column("content_key", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("download_status", new TableInfo.Column("download_status", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("download_task_id", new TableInfo.Column("download_task_id", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("content_length", new TableInfo.Column("content_length", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("download_start_time", new TableInfo.Column("download_start_time", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("compress_status", new TableInfo.Column("compress_status", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("download_progress", new TableInfo.Column("download_progress", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("download_chapter_path", new TableInfo.Column("download_chapter_path", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("thumb_abs_path", new TableInfo.Column("thumb_abs_path", "TEXT", true, 0, (String) null, 1));
            hashMap36.put("catalog_abandon", new TableInfo.Column("catalog_abandon", "INTEGER", true, 0, (String) null, 1));
            hashMap36.put("consume_ad", new TableInfo.Column("consume_ad", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo36 = new TableInfo("t_comic_download_chapter_info", hashMap36, new HashSet(0), new HashSet(0));
            TableInfo read36 = TableInfo.read(supportSQLiteDatabase, "t_comic_download_chapter_info");
            if (!tableInfo36.equals(read36)) {
                return new RoomOpenHelper.ValidationResult(false, "t_comic_download_chapter_info(com.dragon.read.local.db.entity.CatalogInfoEntity).\n Expected:\n" + tableInfo36 + "\n Found:\n" + read36);
            }
            HashMap hashMap37 = new HashMap(10);
            hashMap37.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 2, (String) null, 1));
            hashMap37.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap37.put("md5", new TableInfo.Column("md5", "TEXT", true, 3, (String) null, 1));
            hashMap37.put("abs_save_path", new TableInfo.Column("abs_save_path", "TEXT", true, 0, (String) null, 1));
            hashMap37.put("download_create_time", new TableInfo.Column("download_create_time", "INTEGER", true, 0, "-1", 1));
            hashMap37.put("content_order", new TableInfo.Column("content_order", "INTEGER", true, 0, "-1", 1));
            hashMap37.put("download_status", new TableInfo.Column("download_status", "INTEGER", true, 0, "-1", 1));
            hashMap37.put("download_task_id", new TableInfo.Column("download_task_id", "INTEGER", true, 0, "-1", 1));
            hashMap37.put("download_sdk_task_id", new TableInfo.Column("download_sdk_task_id", "TEXT", true, 0, "'-1'", 1));
            hashMap37.put("content_length", new TableInfo.Column("content_length", "TEXT", true, 0, "'-1'", 1));
            TableInfo tableInfo37 = new TableInfo("t_comic_download_item_info", hashMap37, new HashSet(0), new HashSet(0));
            TableInfo read37 = TableInfo.read(supportSQLiteDatabase, "t_comic_download_item_info");
            if (!tableInfo37.equals(read37)) {
                return new RoomOpenHelper.ValidationResult(false, "t_comic_download_item_info(com.dragon.read.local.db.entity.DownloadPicItemInfoEntity).\n Expected:\n" + tableInfo37 + "\n Found:\n" + read37);
            }
            HashMap hashMap38 = new HashMap(12);
            hashMap38.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap38.put("bookmark_num", new TableInfo.Column("bookmark_num", "INTEGER", true, 0, "0", 1));
            hashMap38.put("underline_num", new TableInfo.Column("underline_num", "INTEGER", true, 0, "0", 1));
            hashMap38.put("note_num", new TableInfo.Column("note_num", "INTEGER", true, 0, "0", 1));
            hashMap38.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, "0", 1));
            hashMap38.put("book_name", new TableInfo.Column("book_name", "TEXT", true, 0, (String) null, 1));
            hashMap38.put("cover_url", new TableInfo.Column("cover_url", "TEXT", true, 0, (String) null, 1));
            hashMap38.put("status", new TableInfo.Column("status", "TEXT", false, 0, (String) null, 1));
            hashMap38.put("color", new TableInfo.Column("color", "TEXT", false, 0, (String) null, 1));
            hashMap38.put("is_local", new TableInfo.Column("is_local", "INTEGER", true, 0, "0", 1));
            hashMap38.put("file_path", new TableInfo.Column("file_path", "TEXT", false, 0, (String) null, 1));
            hashMap38.put("author", new TableInfo.Column("author", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo38 = new TableInfo("t_note_book_data", hashMap38, new HashSet(0), new HashSet(0));
            TableInfo read38 = TableInfo.read(supportSQLiteDatabase, "t_note_book_data");
            if (!tableInfo38.equals(read38)) {
                return new RoomOpenHelper.ValidationResult(false, "t_note_book_data(com.dragon.read.local.db.entity.NoteBookDataDB).\n Expected:\n" + tableInfo38 + "\n Found:\n" + read38);
            }
            HashMap hashMap39 = new HashMap(2);
            hashMap39.put("search_record", new TableInfo.Column("search_record", "TEXT", true, 1, (String) null, 1));
            hashMap39.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo39 = new TableInfo("t_shelf_search_record", hashMap39, new HashSet(0), new HashSet(0));
            TableInfo read39 = TableInfo.read(supportSQLiteDatabase, "t_shelf_search_record");
            if (!tableInfo39.equals(read39)) {
                return new RoomOpenHelper.ValidationResult(false, "t_shelf_search_record(com.dragon.read.local.db.entity.SearchRecordShelf).\n Expected:\n" + tableInfo39 + "\n Found:\n" + read39);
            }
            HashMap hashMap40 = new HashMap(9);
            hashMap40.put("conversation_id", new TableInfo.Column("conversation_id", "TEXT", true, 1, (String) null, 1));
            hashMap40.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 2, (String) null, 1));
            hashMap40.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
            hashMap40.put("avatar_uri", new TableInfo.Column("avatar_uri", "TEXT", false, 0, (String) null, 1));
            hashMap40.put("role", new TableInfo.Column("role", "INTEGER", false, 0, (String) null, 1));
            hashMap40.put("description", new TableInfo.Column("description", "TEXT", false, 0, (String) null, 1));
            hashMap40.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap40.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap40.put("is_robot", new TableInfo.Column("is_robot", "INTEGER", true, 0, "0", 1));
            TableInfo tableInfo40 = new TableInfo("t_im_participant", hashMap40, new HashSet(0), new HashSet(0));
            TableInfo read40 = TableInfo.read(supportSQLiteDatabase, "t_im_participant");
            if (!tableInfo40.equals(read40)) {
                return new RoomOpenHelper.ValidationResult(false, "t_im_participant(com.dragon.read.local.db.entity.IMParticipant).\n Expected:\n" + tableInfo40 + "\n Found:\n" + read40);
            }
            HashMap hashMap41 = new HashMap(2);
            hashMap41.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap41.put("search_record", new TableInfo.Column("search_record", "TEXT", true, 0, (String) null, 1));
            TableInfo tableInfo41 = new TableInfo("t_search_record_book_comment", hashMap41, new HashSet(0), new HashSet(0));
            TableInfo read41 = TableInfo.read(supportSQLiteDatabase, "t_search_record_book_comment");
            if (!tableInfo41.equals(read41)) {
                return new RoomOpenHelper.ValidationResult(false, "t_search_record_book_comment(com.dragon.read.local.db.entity.SearchRecordBookComment).\n Expected:\n" + tableInfo41 + "\n Found:\n" + read41);
            }
            HashMap hashMap42 = new HashMap(24);
            hashMap42.put("series_id", new TableInfo.Column("series_id", "TEXT", true, 1, "''", 1));
            hashMap42.put("series_name", new TableInfo.Column("series_name", "TEXT", true, 0, "''", 1));
            hashMap42.put("cover_url", new TableInfo.Column("cover_url", "TEXT", true, 0, "''", 1));
            hashMap42.put("series_color_hex", new TableInfo.Column("series_color_hex", "TEXT", true, 0, "''", 1));
            hashMap42.put("series_status", new TableInfo.Column("series_status", "INTEGER", true, 0, "1", 1));
            hashMap42.put("last_update_time", new TableInfo.Column("last_update_time", "INTEGER", true, 0, "0", 1));
            hashMap42.put("is_delete", new TableInfo.Column("is_delete", "INTEGER", true, 0, "0", 1));
            hashMap42.put("is_sync", new TableInfo.Column("is_sync", "INTEGER", true, 0, "0", 1));
            hashMap42.put("series_cnt", new TableInfo.Column("series_cnt", "INTEGER", true, 0, "-1", 1));
            hashMap42.put("update_status", new TableInfo.Column("update_status", "INTEGER", true, 0, (String) null, 1));
            hashMap42.put("content_type", new TableInfo.Column("content_type", "INTEGER", true, 0, "-1", 1));
            hashMap42.put("group_name", new TableInfo.Column("group_name", "TEXT", true, 0, "''", 1));
            hashMap42.put("booklist_operate_time", new TableInfo.Column("booklist_operate_time", "INTEGER", true, 0, "0", 1));
            hashMap42.put("collect_time", new TableInfo.Column("collect_time", "INTEGER", true, 0, "0", 1));
            hashMap42.put("update_tag_text", new TableInfo.Column("update_tag_text", "TEXT", true, 0, "''", 1));
            hashMap42.put("digged_count", new TableInfo.Column("digged_count", "INTEGER", true, 0, "0", 1));
            hashMap42.put("user_digg", new TableInfo.Column("user_digg", "INTEGER", true, 0, "0", 1));
            hashMap42.put("pugc_user_name", new TableInfo.Column("pugc_user_name", "TEXT", true, 0, "''", 1));
            hashMap42.put("pugc_user_avatar", new TableInfo.Column("pugc_user_avatar", "TEXT", true, 0, "''", 1));
            hashMap42.put("video_tag_info", new TableInfo.Column("video_tag_info", "TEXT", true, 0, "''", 1));
            hashMap42.put("is_multi_season", new TableInfo.Column("is_multi_season", "INTEGER", true, 0, "0", 1));
            hashMap42.put("season_index", new TableInfo.Column("season_index", "INTEGER", true, 0, "0", 1));
            hashMap42.put("video_category_type", new TableInfo.Column("video_category_type", "TEXT", true, 0, (String) null, 1));
            hashMap42.put("related_series_title", new TableInfo.Column("related_series_title", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo42 = new TableInfo("t_video_serial_collection", hashMap42, new HashSet(0), new HashSet(0));
            TableInfo read42 = TableInfo.read(supportSQLiteDatabase, "t_video_serial_collection");
            if (!tableInfo42.equals(read42)) {
                return new RoomOpenHelper.ValidationResult(false, "t_video_serial_collection(com.dragon.read.local.db.entity.VideoCollection).\n Expected:\n" + tableInfo42 + "\n Found:\n" + read42);
            }
            HashMap hashMap43 = new HashMap(22);
            hashMap43.put("series_id", new TableInfo.Column("series_id", "TEXT", true, 1, "''", 1));
            hashMap43.put("series_name", new TableInfo.Column("series_name", "TEXT", true, 0, "''", 1));
            hashMap43.put("series_cnt", new TableInfo.Column("series_cnt", "INTEGER", true, 0, "0", 1));
            hashMap43.put("current_play_video_index", new TableInfo.Column("current_play_video_index", "INTEGER", true, 0, "0", 1));
            hashMap43.put("current_play_video_id", new TableInfo.Column("current_play_video_id", "TEXT", true, 0, "''", 1));
            hashMap43.put("current_video_title", new TableInfo.Column("current_video_title", "TEXT", true, 0, "''", 1));
            hashMap43.put("total_time", new TableInfo.Column("total_time", "TEXT", true, 0, "''", 1));
            hashMap43.put("current_play_position", new TableInfo.Column("current_play_position", "TEXT", true, 0, "'0'", 1));
            hashMap43.put("current_video_total_time", new TableInfo.Column("current_video_total_time", "TEXT", true, 0, "'0'", 1));
            hashMap43.put("last_video_vid", new TableInfo.Column("last_video_vid", "TEXT", true, 0, "''", 1));
            hashMap43.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, "0", 1));
            hashMap43.put("is_sync", new TableInfo.Column("is_sync", "INTEGER", true, 0, "0", 1));
            hashMap43.put("video_width", new TableInfo.Column("video_width", "INTEGER", true, 0, "0", 1));
            hashMap43.put("video_height", new TableInfo.Column("video_height", "INTEGER", true, 0, "0", 1));
            hashMap43.put("relative_book_id", new TableInfo.Column("relative_book_id", "TEXT", true, 0, "''", 1));
            hashMap43.put("player_accumulate_total_time", new TableInfo.Column("player_accumulate_total_time", "TEXT", true, 0, "'0'", 1));
            hashMap43.put("is_fake_progress", new TableInfo.Column("is_fake_progress", "INTEGER", true, 0, "0", 1));
            hashMap43.put("channel_id", new TableInfo.Column("channel_id", "INTEGER", true, 0, "0", 1));
            hashMap43.put("cur_channel_id", new TableInfo.Column("cur_channel_id", "INTEGER", true, 0, "0", 1));
            hashMap43.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 0, "2", 1));
            hashMap43.put("content_type", new TableInfo.Column("content_type", "INTEGER", true, 0, "1", 1));
            hashMap43.put("video_scene", new TableInfo.Column("video_scene", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo43 = new TableInfo("t_video_serial_progress", hashMap43, new HashSet(0), new HashSet(0));
            TableInfo read43 = TableInfo.read(supportSQLiteDatabase, "t_video_serial_progress");
            if (!tableInfo43.equals(read43)) {
                return new RoomOpenHelper.ValidationResult(false, "t_video_serial_progress(com.dragon.read.local.db.entity.VideoSeriesProgress).\n Expected:\n" + tableInfo43 + "\n Found:\n" + read43);
            }
            HashMap hashMap44 = new HashMap(2);
            hashMap44.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, "''", 1));
            hashMap44.put("session_data", new TableInfo.Column("session_data", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo44 = new TableInfo("t_forum_session_data", hashMap44, new HashSet(0), new HashSet(0));
            TableInfo read44 = TableInfo.read(supportSQLiteDatabase, "t_forum_session_data");
            if (!tableInfo44.equals(read44)) {
                return new RoomOpenHelper.ValidationResult(false, "t_forum_session_data(com.dragon.read.local.db.entity.ForumSessionData).\n Expected:\n" + tableInfo44 + "\n Found:\n" + read44);
            }
            HashMap hashMap45 = new HashMap(71);
            hashMap45.put("vid", new TableInfo.Column("vid", "TEXT", true, 1, (String) null, 1));
            hashMap45.put("cover", new TableInfo.Column("cover", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("scene_cover", new TableInfo.Column("scene_cover", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("video_desc", new TableInfo.Column("video_desc", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("series_id", new TableInfo.Column("series_id", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("digged_count", new TableInfo.Column("digged_count", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("user_digg", new TableInfo.Column("user_digg", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("followed", new TableInfo.Column("followed", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("sub_title", new TableInfo.Column("sub_title", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("episode_cnt", new TableInfo.Column("episode_cnt", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("time", new TableInfo.Column("time", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("video_width", new TableInfo.Column("video_width", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("video_height", new TableInfo.Column("video_height", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("user_digg_timestamp_ms", new TableInfo.Column("user_digg_timestamp_ms", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("color_dominate", new TableInfo.Column("color_dominate", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("bg_color_hex", new TableInfo.Column("bg_color_hex", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("followed_cnt", new TableInfo.Column("followed_cnt", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("episodes_status", new TableInfo.Column("episodes_status", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("series_title", new TableInfo.Column("series_title", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("vid_index", new TableInfo.Column("vid_index", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("video_platform_type", new TableInfo.Column("video_platform_type", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("video_content_type", new TableInfo.Column("video_content_type", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("relate_video_content_type", new TableInfo.Column("relate_video_content_type", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("update_tag", new TableInfo.Column("update_tag", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("is_vertical", new TableInfo.Column("is_vertical", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("series_cover", new TableInfo.Column("series_cover", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("show_record_info", new TableInfo.Column("show_record_info", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("record_number", new TableInfo.Column("record_number", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("secondary_infos", new TableInfo.Column("secondary_infos", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("is_trailer", new TableInfo.Column("is_trailer", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("celebrities", new TableInfo.Column("celebrities", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("category_schema", new TableInfo.Column("category_schema", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("series_intro", new TableInfo.Column("series_intro", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("series_play_cnt", new TableInfo.Column("series_play_cnt", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("video_series_id_type", new TableInfo.Column("video_series_id_type", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("user_name", new TableInfo.Column("user_name", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("user_avatar", new TableInfo.Column("user_avatar", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("user_avatar_decoration_url", new TableInfo.Column("user_avatar_decoration_url", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("user_avatar_decoration_id", new TableInfo.Column("user_avatar_decoration_id", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("post_title", new TableInfo.Column("post_title", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("is_ugc_video", new TableInfo.Column("is_ugc_video", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("is_private", new TableInfo.Column("is_private", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("online_subscribed", new TableInfo.Column("online_subscribed", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("online_time", new TableInfo.Column("online_time", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("label", new TableInfo.Column("label", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("enable_vision_product", new TableInfo.Column("enable_vision_product", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("abstract_tags", new TableInfo.Column("abstract_tags", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("bottom_bar_type", new TableInfo.Column("bottom_bar_type", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("bottom_bar_group_id", new TableInfo.Column("bottom_bar_group_id", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("bottom_bar_text_list", new TableInfo.Column("bottom_bar_text_list", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("bottom_bar_schema", new TableInfo.Column("bottom_bar_schema", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("bottom_bar_icon_url", new TableInfo.Column("bottom_bar_icon_url", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("related_album_id", new TableInfo.Column("related_album_id", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("sub_title_list", new TableInfo.Column("sub_title_list", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("main_creator_users", new TableInfo.Column("main_creator_users", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("recommend_info", new TableInfo.Column("recommend_info", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("recommend_group_id", new TableInfo.Column("recommend_group_id", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("support_listen", new TableInfo.Column("support_listen", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("ai_usage_type", new TableInfo.Column("ai_usage_type", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("relate_book_id", new TableInfo.Column("relate_book_id", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("relate_post_id", new TableInfo.Column("relate_post_id", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("relate_genre_type", new TableInfo.Column("relate_genre_type", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("season_index", new TableInfo.Column("season_index", "INTEGER", true, 0, (String) null, 1));
            hashMap45.put("video_tag_info", new TableInfo.Column("video_tag_info", "TEXT", false, 0, (String) null, 1));
            hashMap45.put("user_creator_type", new TableInfo.Column("user_creator_type", "INTEGER", false, 0, (String) null, 1));
            hashMap45.put("video_category_type", new TableInfo.Column("video_category_type", "TEXT", true, 0, (String) null, 1));
            hashMap45.put("video_share_info", new TableInfo.Column("video_share_info", "TEXT", true, 0, (String) null, 1));
            TableInfo tableInfo45 = new TableInfo("t_video_serial_like", hashMap45, new HashSet(0), new HashSet(0));
            TableInfo read45 = TableInfo.read(supportSQLiteDatabase, "t_video_serial_like");
            if (!tableInfo45.equals(read45)) {
                return new RoomOpenHelper.ValidationResult(false, "t_video_serial_like(com.dragon.read.pages.video.like.VideoLikeModel).\n Expected:\n" + tableInfo45 + "\n Found:\n" + read45);
            }
            RoomOpenHelper.ValidationResult a = a(supportSQLiteDatabase);
            return !a.isValid ? a : new RoomOpenHelper.ValidationResult(true, (String) null);
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) DBManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) DBManager_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) DBManager_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) DBManager_Impl.this).mDatabase = supportSQLiteDatabase;
            DBManager_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) DBManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) DBManager_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) DBManager_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_book` (`author` TEXT, `book_id` TEXT NOT NULL, `name` TEXT, `listen_bookshelf_name` TEXT, `cover_url` TEXT, `create_time` INTEGER NOT NULL, `genre_type` INTEGER NOT NULL, `genre` TEXT, `length_type` TEXT, `is_finish` INTEGER NOT NULL, `last_serial_count` TEXT, `serial_count` TEXT, `tts_status` INTEGER NOT NULL, `update_status` TEXT, `update_time` INTEGER NOT NULL, `is_exclusive` INTEGER NOT NULL, `icon_tag` TEXT, `recommend_info` TEXT, `recommend_group_id` TEXT, `book_status` TEXT, `valid_in_cn_region` INTEGER NOT NULL, `last_chapter_title` TEXT, `last_chapter_update_time` TEXT, `category` TEXT, `gender` TEXT, `is_in_bookshelf` INTEGER NOT NULL, `is_pub_pay` INTEGER NOT NULL, `pay_type` INTEGER NOT NULL, `show_vip_tag` INTEGER NOT NULL, `op_tag` TEXT, `authorId` TEXT DEFAULT '', `abstraction` TEXT DEFAULT '', `readCount` TEXT DEFAULT '0', `wordNumber` INTEGER NOT NULL DEFAULT 0, `score` TEXT DEFAULT '0', `creationStatus` INTEGER NOT NULL DEFAULT -1, `authorizeType` TEXT DEFAULT '', `firstChapterId` TEXT DEFAULT '', `bookRankInfoList` TEXT DEFAULT '', `categorySchema` TEXT DEFAULT '', `titlePageTags` TEXT DEFAULT '', `source` TEXT DEFAULT '', `isEbook` TEXT DEFAULT '', `audioThumbUri` TEXT DEFAULT '', `tags` TEXT DEFAULT '', `listenCount` TEXT DEFAULT '0', `color_dominate` TEXT, `horiz_thumb_url` TEXT, `book_short_name` TEXT, `poster_id` TEXT, `flight_user_selected` INTEGER NOT NULL DEFAULT 0, `audio_thumb_url_hd` TEXT, `small_cover_url` TEXT, `relative_post_schema` TEXT, `relative_post_id` TEXT, `book_only_tts` INTEGER NOT NULL, `platform` TEXT, `color_audio_dominate` TEXT, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_bookshelf` (`add_type` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `booklist_name` TEXT, `is_sync` INTEGER NOT NULL, `is_delete` INTEGER NOT NULL, `booklist_operate_time` INTEGER NOT NULL, `is_pinned` INTEGER NOT NULL, `pinned_time` INTEGER NOT NULL, `booklist_id` INTEGER NOT NULL, `is_asterisked` INTEGER NOT NULL, `is_chased_updates` INTEGER NOT NULL, `add_bookshelf_time_sec` INTEGER NOT NULL, `is_preheat_book_pinned` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_book_record` (`author_name` TEXT, `book_name` TEXT, `cover_url` TEXT, `genre_type` INTEGER NOT NULL, `tts_status` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `last_update_time` INTEGER NOT NULL, `read_time` INTEGER NOT NULL, `is_delete` INTEGER NOT NULL, `has_sync` INTEGER NOT NULL, `resource` TEXT, `is_finish` INTEGER NOT NULL, `recent_read_count` INTEGER NOT NULL, `score` TEXT, `source` TEXT, `page_info` TEXT, `is_pub_pay` INTEGER NOT NULL, `pay_type` INTEGER NOT NULL, `color_dominate` TEXT, `tone_id` INTEGER NOT NULL, `platform_book_id` TEXT, `total_read_time` INTEGER NOT NULL, `exact_read_time` INTEGER NOT NULL, `exact_read_word_num` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_book_progress` (`chapter_id` TEXT, `chapter_index` INTEGER NOT NULL, `chapter_title` TEXT, `page_index` INTEGER NOT NULL, `progress_rate` REAL NOT NULL, `sync` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `pager_progress_rate` REAL NOT NULL, `paragraph_id` INTEGER NOT NULL, `line_in_paragraph_offset` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `tone_id` INTEGER NOT NULL DEFAULT 0, `tone_id_after_v579` INTEGER NOT NULL DEFAULT -1, `channel_id` INTEGER NOT NULL DEFAULT 0, `cur_channel_id` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_interactive_record` (`book_id` TEXT NOT NULL, `book_name` TEXT, `cover_url` TEXT, `category` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `book_status` TEXT, `update_time` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_dialogue_record` (`book_id` TEXT NOT NULL, `book_name` TEXT, `cover_url` TEXT, `category` TEXT, `book_status` TEXT, `update_time` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_dialogue_progress` (`book_id` TEXT NOT NULL, `progress` TEXT, `chapter_name` TEXT, `chapter_index` INTEGER, `chapter_id` TEXT, `update_time` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_cache_table` (`create_time` INTEGER NOT NULL, `cache_key` TEXT NOT NULL, `update_time` INTEGER NOT NULL, `cache_value` TEXT, PRIMARY KEY(`cache_key`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_search_record` (`search_record` TEXT NOT NULL, `update_time` INTEGER NOT NULL, PRIMARY KEY(`search_record`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_relative_book_id` (`id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `relative_audio_book_id_set` TEXT, `relative_novel_book_id` TEXT, PRIMARY KEY(`id`, `book_type`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_reading_record` (`book_id` TEXT NOT NULL, `read_time` INTEGER NOT NULL, `today_read_time` INTEGER NOT NULL, `today_time_stamp` INTEGER NOT NULL, `last_popup_time` INTEGER NOT NULL, `last_popup_read_time` INTEGER NOT NULL, `read_chapter_count` INTEGER NOT NULL, `chapter_count` INTEGER NOT NULL, `popup_count` INTEGER NOT NULL, `popup_count_for_chase_comment` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_reading_time` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT, `book_id` TEXT, `reading_time` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_audio_download_status` (`book_id` TEXT, `chapter_id` TEXT NOT NULL, `book_name` TEXT, `tone_id` INTEGER NOT NULL, `status` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `download_url` TEXT, `is_encrypt` INTEGER NOT NULL, `encrypt_key` TEXT, `download_id` INTEGER NOT NULL, `abs_save_path` TEXT, `chapter_name` TEXT, `current_length` REAL NOT NULL, `total_length` REAL NOT NULL, `duration` INTEGER NOT NULL, `pause_reason` INTEGER NOT NULL, PRIMARY KEY(`chapter_id`, `tone_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_audio_download_result` (`book_id` TEXT, `chapter_id` TEXT NOT NULL, `book_name` TEXT, `tone_id` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `is_encrypt` INTEGER NOT NULL, `encrypt_key` TEXT, `download_id` INTEGER NOT NULL, `abs_save_path` TEXT, `chapter_name` TEXT, `current_length` REAL NOT NULL, `total_length` REAL NOT NULL, `duration` INTEGER NOT NULL, PRIMARY KEY(`chapter_id`, `tone_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_bookmark_remote` (`mark_id` INTEGER NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `paragraph_id` INTEGER NOT NULL, `end_paragraph_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT, `content` TEXT, `chapter_title` TEXT, `volume_name` TEXT, `is_deleted` INTEGER NOT NULL, `start_media_index` INTEGER NOT NULL, `end_media_index` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL, PRIMARY KEY(`mark_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_bookmark_local` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `paragraph_id` INTEGER NOT NULL, `end_paragraph_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT, `content` TEXT, `chapter_title` TEXT, `volume_name` TEXT, `start_media_index` INTEGER NOT NULL, `end_media_index` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_local_book` (`bookshelf_update_time` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `cover_url` TEXT NOT NULL, `book_name` TEXT NOT NULL, `file_path` TEXT NOT NULL, `last_chapter_id` TEXT, `last_chapter_title` TEXT, `last_page_index` INTEGER NOT NULL, `progress_rate` REAL NOT NULL, `progress_update_time` INTEGER NOT NULL, `paragraph_id` INTEGER NOT NULL, `line_in_paragraph_offset` INTEGER NOT NULL, `is_external` INTEGER NOT NULL, `booklist_name` TEXT, `mime_type` TEXT NOT NULL, `version` INTEGER NOT NULL, `is_pinned` INTEGER NOT NULL, `pinned_time` INTEGER NOT NULL, `is_asterisked` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_local_book_bookmark` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `paragraph_id` INTEGER NOT NULL, `end_paragraph_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT, `content` TEXT, `chapter_title` TEXT, `volume_name` TEXT, `chapter_index` INTEGER NOT NULL, `modify_time` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_booklist` (`booklist_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `booklist_name` TEXT, `update_time` INTEGER NOT NULL, `pinned_time` INTEGER NOT NULL, `real_booklist_id` INTEGER NOT NULL, `is_pinned` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_user_info` (`uid` TEXT NOT NULL, `nick_name` TEXT NOT NULL, `avatar_url` TEXT NOT NULL, PRIMARY KEY(`uid`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_ugc_book_list` (`book_list_id` TEXT NOT NULL, `topic_id` TEXT, `topic_title` TEXT, `topic_status` INTEGER NOT NULL, `topic_schemes` TEXT, `book_count` INTEGER NOT NULL, `subscribe_time` INTEGER NOT NULL, `click_time` INTEGER NOT NULL, `operate_time` INTEGER NOT NULL, `delete_time` INTEGER NOT NULL, `is_sync` INTEGER NOT NULL, `is_delete` INTEGER NOT NULL, `book_list_type` INTEGER NOT NULL, `user_info` TEXT, `recommend_text` TEXT, `is_pinned` INTEGER NOT NULL, `pinned_time` INTEGER NOT NULL, `author_name` TEXT, `author_abstract` TEXT, `author_pic_url` TEXT, `author_id` INTEGER NOT NULL, `secondary_info` TEXT, `show_update_notify` INTEGER NOT NULL, PRIMARY KEY(`book_list_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_ugc_book_info` (`book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `book_list_id` TEXT NOT NULL, `recommend_count` TEXT, `read_count` TEXT, `book_rank` INTEGER NOT NULL, `color_dominate` TEXT, PRIMARY KEY(`book_id`, `book_type`, `book_list_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `shelf_control_model` (`bookId` TEXT NOT NULL, `date_time` TEXT NOT NULL, `today_show_count` INTEGER NOT NULL, `last_read_count` INTEGER NOT NULL, `read_count` INTEGER NOT NULL, PRIMARY KEY(`bookId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_video_history_record` (`author_name` TEXT, `author_id` TEXT, `book_name` TEXT, `book_id` TEXT, `series_id` TEXT NOT NULL, `series_name` TEXT, `current_episode_id` TEXT, `episodes_list_count_text` TEXT, `current_video_title` TEXT, `cover_url` TEXT, `vid` TEXT NOT NULL, `content_type` INTEGER NOT NULL, `total_time` TEXT, `current_play_position` TEXT, `current_video_total_time` TEXT, `last_video_vid` TEXT, `player_accumulate_total_time` TEXT, `record_index` INTEGER NOT NULL, `video_platform` INTEGER NOT NULL, `episode_cnt` INTEGER NOT NULL, `video_width` INTEGER NOT NULL DEFAULT 0, `video_height` INTEGER NOT NULL DEFAULT 0, `series_color_hex` TEXT NOT NULL, `current_episode_index` INTEGER NOT NULL, `update_tag` TEXT NOT NULL, `update_status` INTEGER NOT NULL, `played_video_ids` TEXT, `has_sync` INTEGER NOT NULL, `is_delete` INTEGER NOT NULL, `stayed_video_ids` TEXT, `update_tag_text` TEXT, `pugc_user_name` TEXT, `pugc_user_avatar` TEXT, `series_play_count` INTEGER NOT NULL, `video_scene` INTEGER NOT NULL, `digged_count` INTEGER NOT NULL, `is_user_digg` INTEGER NOT NULL, `is_multi_season` INTEGER NOT NULL, `season_index` INTEGER NOT NULL, `video_tag_info` TEXT NOT NULL, `is_interactive_game` INTEGER NOT NULL, `chapter_index` INTEGER NOT NULL, `related_series_title` TEXT NOT NULL, `secondary_info` TEXT NOT NULL, `video_category_type` TEXT NOT NULL, PRIMARY KEY(`series_id`, `vid`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_topic_search_record` (`search_record` TEXT NOT NULL, `update_time` INTEGER NOT NULL, PRIMARY KEY(`search_record`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_underline_local` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `start_para_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_para_id` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT NOT NULL, `content` TEXT NOT NULL, `chapter_title` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL, `line_type` INTEGER NOT NULL DEFAULT 0, `is_public` INTEGER NOT NULL DEFAULT 0, `hot_line_id` INTEGER NOT NULL DEFAULT 0, `underline_type` INTEGER NOT NULL DEFAULT 0, `notes` TEXT NOT NULL DEFAULT '')");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_underline_remote` (`mark_id` INTEGER NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `start_para_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_para_id` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT NOT NULL, `content` TEXT NOT NULL, `chapter_title` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `is_deleted` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL, `line_type` INTEGER NOT NULL DEFAULT 0, `is_public` INTEGER NOT NULL DEFAULT 0, `hot_line_id` INTEGER NOT NULL DEFAULT 0, `underline_type` INTEGER NOT NULL DEFAULT 0, `notes` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`mark_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_local_book_underline` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `start_para_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_para_id` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT NOT NULL, `content` TEXT NOT NULL, `chapter_title` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `modify_time` INTEGER NOT NULL, `line_type` INTEGER NOT NULL DEFAULT 0, `underline_type` INTEGER NOT NULL DEFAULT 0, `notes` TEXT NOT NULL DEFAULT '')");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_font_config` (`reader_font_id` INTEGER NOT NULL, `font_title` TEXT, `file_size` TEXT, `file_url` TEXT, `font_pic` TEXT, `bold_name` TEXT, `regular_name` TEXT, `font_family` TEXT, `regular_file_name` TEXT, `download_onlaunch` INTEGER NOT NULL, `hidden_inreader` INTEGER NOT NULL, `font_vip_type` INTEGER NOT NULL, `is_new_font` INTEGER NOT NULL, `is_variable_font` INTEGER NOT NULL, `medium_file_name` TEXT, `bold_file_name` TEXT, `medium_name` TEXT, `order` INTEGER NOT NULL, `fanti_font_pic` TEXT, `ui_key` TEXT, PRIMARY KEY(`reader_font_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_book_chapter_progress` (`book_id` TEXT NOT NULL DEFAULT '', `chapter_id` TEXT NOT NULL DEFAULT '', `para_id` INTEGER NOT NULL DEFAULT 0, `para_offset` INTEGER NOT NULL DEFAULT 0, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, PRIMARY KEY(`chapter_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_bookshelf_panel` (`book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `add_book_time` INTEGER NOT NULL, `listening_and_reading_time` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_audio_bookshelf_guide_info` (`book_id` TEXT NOT NULL, `player_accumulate_total_time` INTEGER NOT NULL, `last_show_time_ms` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_comic_read_progress_record` (`comic_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `read_progress` INTEGER NOT NULL, `catalog_order` TEXT NOT NULL, `last_update_time` TEXT NOT NULL, PRIMARY KEY(`comic_id`, `chapter_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_book_content_detail` (`book_id` TEXT NOT NULL, `book_content` TEXT, `content_type` INTEGER NOT NULL, `current_chapter_index` INTEGER NOT NULL, `expect_show_next_chapter` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_comic_detail_info` (`book_id` TEXT NOT NULL, `book_name` TEXT NOT NULL, `horizontal_cover_url` TEXT, `vertical_cover_url` TEXT, `last_update_time` TEXT, `update_status` TEXT, `author` TEXT, `create_time` TEXT, `abstraction` TEXT, `read_count` TEXT, `score` TEXT, `creation_status` TEXT, `authorize_type` TEXT, `first_chapter_id` TEXT, `last_chapter_id` TEXT, `category_scheme` TEXT, `source` TEXT, `tags` TEXT, `color_dominate` TEXT, `serial_count` TEXT, `content_chapter_count` INTEGER NOT NULL, `book_content_length` INTEGER NOT NULL, `consume_ad` TEXT NOT NULL, `horizontal_cover_path` TEXT NOT NULL, `vertical_cover_path` TEXT NOT NULL, `directory_sub_info` TEXT NOT NULL, `book_type` TEXT, `last_download_success_time` TEXT NOT NULL DEFAULT '0', PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_comic_download_chapter_info` (`book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_thumb_url` TEXT NOT NULL, `publish_time` TEXT NOT NULL, `chapter_name` TEXT NOT NULL, `book_name` TEXT NOT NULL, `version` TEXT NOT NULL, `content` TEXT NOT NULL, `key_version` INTEGER NOT NULL, `content_md5` TEXT NOT NULL, `chapter_order` INTEGER NOT NULL, `book_chapter_count` INTEGER NOT NULL, `first_pass_time` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `content_key` TEXT NOT NULL, `download_status` INTEGER NOT NULL, `download_task_id` INTEGER NOT NULL, `content_length` INTEGER NOT NULL, `download_start_time` INTEGER NOT NULL, `compress_status` INTEGER NOT NULL, `download_progress` INTEGER NOT NULL, `download_chapter_path` TEXT NOT NULL, `thumb_abs_path` TEXT NOT NULL, `catalog_abandon` INTEGER NOT NULL, `consume_ad` INTEGER NOT NULL, PRIMARY KEY(`chapter_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_comic_download_item_info` (`chapter_id` TEXT NOT NULL, `book_id` TEXT NOT NULL, `md5` TEXT NOT NULL, `abs_save_path` TEXT NOT NULL, `download_create_time` INTEGER NOT NULL DEFAULT -1, `content_order` INTEGER NOT NULL DEFAULT -1, `download_status` INTEGER NOT NULL DEFAULT -1, `download_task_id` INTEGER NOT NULL DEFAULT -1, `download_sdk_task_id` TEXT NOT NULL DEFAULT '-1', `content_length` TEXT NOT NULL DEFAULT '-1', PRIMARY KEY(`book_id`, `chapter_id`, `md5`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_note_book_data` (`book_id` TEXT NOT NULL, `bookmark_num` INTEGER NOT NULL DEFAULT 0, `underline_num` INTEGER NOT NULL DEFAULT 0, `note_num` INTEGER NOT NULL DEFAULT 0, `update_time` INTEGER NOT NULL DEFAULT 0, `book_name` TEXT NOT NULL, `cover_url` TEXT NOT NULL, `status` TEXT, `color` TEXT, `is_local` INTEGER NOT NULL DEFAULT 0, `file_path` TEXT, `author` TEXT, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_shelf_search_record` (`search_record` TEXT NOT NULL, `update_time` INTEGER NOT NULL, PRIMARY KEY(`search_record`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_im_participant` (`conversation_id` TEXT NOT NULL, `user_id` TEXT NOT NULL, `name` TEXT, `avatar_uri` TEXT, `role` INTEGER, `description` TEXT, `update_time` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `is_robot` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`conversation_id`, `user_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_search_record_book_comment` (`book_id` TEXT NOT NULL, `search_record` TEXT NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_video_serial_collection` (`series_id` TEXT NOT NULL DEFAULT '', `series_name` TEXT NOT NULL DEFAULT '', `cover_url` TEXT NOT NULL DEFAULT '', `series_color_hex` TEXT NOT NULL DEFAULT '', `series_status` INTEGER NOT NULL DEFAULT 1, `last_update_time` INTEGER NOT NULL DEFAULT 0, `is_delete` INTEGER NOT NULL DEFAULT 0, `is_sync` INTEGER NOT NULL DEFAULT 0, `series_cnt` INTEGER NOT NULL DEFAULT -1, `update_status` INTEGER NOT NULL, `content_type` INTEGER NOT NULL DEFAULT -1, `group_name` TEXT NOT NULL DEFAULT '', `booklist_operate_time` INTEGER NOT NULL DEFAULT 0, `collect_time` INTEGER NOT NULL DEFAULT 0, `update_tag_text` TEXT NOT NULL DEFAULT '', `digged_count` INTEGER NOT NULL DEFAULT 0, `user_digg` INTEGER NOT NULL DEFAULT 0, `pugc_user_name` TEXT NOT NULL DEFAULT '', `pugc_user_avatar` TEXT NOT NULL DEFAULT '', `video_tag_info` TEXT NOT NULL DEFAULT '', `is_multi_season` INTEGER NOT NULL DEFAULT 0, `season_index` INTEGER NOT NULL DEFAULT 0, `video_category_type` TEXT NOT NULL, `related_series_title` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`series_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_video_serial_progress` (`series_id` TEXT NOT NULL DEFAULT '', `series_name` TEXT NOT NULL DEFAULT '', `series_cnt` INTEGER NOT NULL DEFAULT 0, `current_play_video_index` INTEGER NOT NULL DEFAULT 0, `current_play_video_id` TEXT NOT NULL DEFAULT '', `current_video_title` TEXT NOT NULL DEFAULT '', `total_time` TEXT NOT NULL DEFAULT '', `current_play_position` TEXT NOT NULL DEFAULT '0', `current_video_total_time` TEXT NOT NULL DEFAULT '0', `last_video_vid` TEXT NOT NULL DEFAULT '', `update_time` INTEGER NOT NULL DEFAULT 0, `is_sync` INTEGER NOT NULL DEFAULT 0, `video_width` INTEGER NOT NULL DEFAULT 0, `video_height` INTEGER NOT NULL DEFAULT 0, `relative_book_id` TEXT NOT NULL DEFAULT '', `player_accumulate_total_time` TEXT NOT NULL DEFAULT '0', `is_fake_progress` INTEGER NOT NULL DEFAULT 0, `channel_id` INTEGER NOT NULL DEFAULT 0, `cur_channel_id` INTEGER NOT NULL DEFAULT 0, `book_type` INTEGER NOT NULL DEFAULT 2, `content_type` INTEGER NOT NULL DEFAULT 1, `video_scene` INTEGER NOT NULL, PRIMARY KEY(`series_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_forum_session_data` (`book_id` TEXT NOT NULL DEFAULT '', `session_data` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_video_serial_like` (`vid` TEXT NOT NULL, `cover` TEXT NOT NULL, `scene_cover` TEXT NOT NULL, `duration` INTEGER NOT NULL, `title` TEXT NOT NULL, `video_desc` TEXT NOT NULL, `series_id` TEXT NOT NULL, `digged_count` INTEGER NOT NULL, `user_digg` INTEGER NOT NULL, `followed` INTEGER NOT NULL, `sub_title` TEXT NOT NULL, `episode_cnt` INTEGER NOT NULL, `time` INTEGER NOT NULL, `video_width` INTEGER NOT NULL, `video_height` INTEGER NOT NULL, `user_digg_timestamp_ms` INTEGER NOT NULL, `color_dominate` TEXT NOT NULL, `bg_color_hex` TEXT, `followed_cnt` INTEGER NOT NULL, `episodes_status` INTEGER NOT NULL, `series_title` TEXT NOT NULL, `vid_index` INTEGER NOT NULL, `video_platform_type` INTEGER NOT NULL, `video_content_type` INTEGER NOT NULL, `relate_video_content_type` INTEGER NOT NULL, `update_tag` TEXT NOT NULL, `is_vertical` INTEGER NOT NULL, `series_cover` TEXT, `show_record_info` INTEGER NOT NULL, `record_number` TEXT, `secondary_infos` TEXT, `is_trailer` INTEGER NOT NULL, `celebrities` TEXT, `category_schema` TEXT NOT NULL, `series_intro` TEXT NOT NULL, `series_play_cnt` INTEGER NOT NULL, `video_series_id_type` INTEGER NOT NULL, `user_id` TEXT NOT NULL, `user_name` TEXT NOT NULL, `user_avatar` TEXT NOT NULL, `user_avatar_decoration_url` TEXT, `user_avatar_decoration_id` TEXT, `post_title` TEXT NOT NULL, `is_ugc_video` INTEGER NOT NULL, `is_private` INTEGER NOT NULL, `online_subscribed` INTEGER NOT NULL, `online_time` INTEGER NOT NULL, `label` TEXT, `enable_vision_product` INTEGER NOT NULL, `abstract_tags` TEXT, `bottom_bar_type` TEXT, `bottom_bar_group_id` TEXT, `bottom_bar_text_list` TEXT, `bottom_bar_schema` TEXT, `bottom_bar_icon_url` TEXT, `related_album_id` INTEGER NOT NULL, `sub_title_list` TEXT NOT NULL, `main_creator_users` TEXT NOT NULL, `recommend_info` TEXT NOT NULL, `recommend_group_id` TEXT NOT NULL, `support_listen` INTEGER NOT NULL, `ai_usage_type` INTEGER NOT NULL, `relate_book_id` TEXT, `relate_post_id` TEXT, `relate_genre_type` TEXT, `create_time` INTEGER NOT NULL, `season_index` INTEGER NOT NULL, `video_tag_info` TEXT, `user_creator_type` INTEGER, `video_category_type` TEXT NOT NULL, `video_share_info` TEXT NOT NULL, PRIMARY KEY(`vid`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_download_book` (`book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `status` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `percent` REAL NOT NULL, `download_size` INTEGER NOT NULL, `unlock_downloaded_size` INTEGER NOT NULL, `genre_type` INTEGER NOT NULL, `total_file_length` INTEGER NOT NULL, `book_name` TEXT NOT NULL, `cover_url` TEXT NOT NULL, `pause_reason` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_ugc_video_info` (`video_list_id` TEXT NOT NULL DEFAULT '', `series_id` TEXT NOT NULL DEFAULT '', `series_cover` TEXT NOT NULL DEFAULT '', `series_title` TEXT NOT NULL DEFAULT '', `v_index` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`video_list_id`, `series_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_ugc_video_list_info` (`video_list_id` TEXT NOT NULL DEFAULT '', `post_title` TEXT NOT NULL DEFAULT '', `subscribe_time` INTEGER NOT NULL DEFAULT 0, `operate_time` INTEGER NOT NULL DEFAULT 0, `delete_time` INTEGER NOT NULL DEFAULT 0, `is_delete` INTEGER NOT NULL DEFAULT 0, `has_sync` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`video_list_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_task_comment_publish_record` (`comment_id` TEXT NOT NULL DEFAULT '', `timestamp` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 0, `word_count` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`comment_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_relative_pdf_epub` (`pdf_book_id` TEXT NOT NULL, `epub_book_id` TEXT NOT NULL, PRIMARY KEY(`pdf_book_id`, `epub_book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '40f8e3a9b87c6c5a796008bc1ad9a2ef')");
        }

        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_book`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_bookshelf`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_book_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_book_progress`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_interactive_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_dialogue_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_dialogue_progress`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_cache_table`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_search_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_relative_book_id`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_reading_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_reading_time`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_audio_download_status`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_audio_download_result`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_bookmark_remote`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_bookmark_local`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_local_book`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_local_book_bookmark`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_booklist`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_user_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_ugc_book_list`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_ugc_book_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `shelf_control_model`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_video_history_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_topic_search_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_underline_local`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_underline_remote`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_local_book_underline`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_font_config`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_book_chapter_progress`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_bookshelf_panel`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_audio_bookshelf_guide_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_comic_read_progress_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_book_content_detail`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_comic_detail_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_comic_download_chapter_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_comic_download_item_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_note_book_data`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_shelf_search_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_im_participant`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_search_record_book_comment`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_video_serial_collection`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_video_serial_progress`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_forum_session_data`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_video_serial_like`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_download_book`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_ugc_video_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_ugc_video_list_info`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_task_comment_publish_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_relative_pdf_epub`");
            if (((RoomDatabase) DBManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) DBManager_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) DBManager_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        private RoomOpenHelper.ValidationResult a(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(13);
            hashMap.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap.put("book_type", new TableInfo.Column("book_type", "INTEGER", true, 2, (String) null, 1));
            hashMap.put("status", new TableInfo.Column("status", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("percent", new TableInfo.Column("percent", "REAL", true, 0, (String) null, 1));
            hashMap.put("download_size", new TableInfo.Column("download_size", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("unlock_downloaded_size", new TableInfo.Column("unlock_downloaded_size", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("genre_type", new TableInfo.Column("genre_type", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("total_file_length", new TableInfo.Column("total_file_length", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("book_name", new TableInfo.Column("book_name", "TEXT", true, 0, (String) null, 1));
            hashMap.put("cover_url", new TableInfo.Column("cover_url", "TEXT", true, 0, (String) null, 1));
            hashMap.put("pause_reason", new TableInfo.Column("pause_reason", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo = new TableInfo("t_download_book", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "t_download_book");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "t_download_book(com.dragon.read.pages.download.DownloadBookInfo).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(5);
            hashMap2.put("video_list_id", new TableInfo.Column("video_list_id", "TEXT", true, 1, "''", 1));
            hashMap2.put("series_id", new TableInfo.Column("series_id", "TEXT", true, 2, "''", 1));
            hashMap2.put("series_cover", new TableInfo.Column("series_cover", "TEXT", true, 0, "''", 1));
            hashMap2.put("series_title", new TableInfo.Column("series_title", "TEXT", true, 0, "''", 1));
            hashMap2.put("v_index", new TableInfo.Column("v_index", "INTEGER", true, 0, "0", 1));
            TableInfo tableInfo2 = new TableInfo("t_ugc_video_info", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "t_ugc_video_info");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "t_ugc_video_info(com.dragon.read.pages.video.videolist.UgcVideoInfo).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(7);
            hashMap3.put("video_list_id", new TableInfo.Column("video_list_id", "TEXT", true, 1, "''", 1));
            hashMap3.put("post_title", new TableInfo.Column("post_title", "TEXT", true, 0, "''", 1));
            hashMap3.put("subscribe_time", new TableInfo.Column("subscribe_time", "INTEGER", true, 0, "0", 1));
            hashMap3.put("operate_time", new TableInfo.Column("operate_time", "INTEGER", true, 0, "0", 1));
            hashMap3.put("delete_time", new TableInfo.Column("delete_time", "INTEGER", true, 0, "0", 1));
            hashMap3.put("is_delete", new TableInfo.Column("is_delete", "INTEGER", true, 0, "0", 1));
            hashMap3.put("has_sync", new TableInfo.Column("has_sync", "INTEGER", true, 0, "0", 1));
            TableInfo tableInfo3 = new TableInfo("t_ugc_video_list_info", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "t_ugc_video_list_info");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "t_ugc_video_list_info(com.dragon.read.pages.video.videolist.UgcVideoList).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(4);
            hashMap4.put("comment_id", new TableInfo.Column("comment_id", "TEXT", true, 1, "''", 1));
            hashMap4.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, "0", 1));
            hashMap4.put("type", new TableInfo.Column("type", "INTEGER", true, 0, "0", 1));
            hashMap4.put("word_count", new TableInfo.Column("word_count", "INTEGER", true, 0, "0", 1));
            TableInfo tableInfo4 = new TableInfo("t_task_comment_publish_record", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "t_task_comment_publish_record");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "t_task_comment_publish_record(com.dragon.read.local.db.entity.TaskCommentPublishRecord).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("pdf_book_id", new TableInfo.Column("pdf_book_id", "TEXT", true, 1, (String) null, 1));
            hashMap5.put("epub_book_id", new TableInfo.Column("epub_book_id", "TEXT", true, 2, (String) null, 1));
            TableInfo tableInfo5 = new TableInfo("t_relative_pdf_epub", hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase, "t_relative_pdf_epub");
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "t_relative_pdf_epub(com.dragon.read.local.db.entity.RelativePdfEpubModel).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            return new RoomOpenHelper.ValidationResult(true, (String) null);
        }

        a(int i) {
            super(i);
        }
    }

    @Override // com.dragon.read.local.db.DBManager
    nr4.a audioBookshelfGuideDao() {
        nr4.a aVar;
        if (this.F != null) {
            return this.F;
        }
        synchronized (this) {
            if (this.F == null) {
                this.F = new nr4.c(this);
            }
            aVar = this.F;
        }
        return aVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    nr4.d audioDlResultDao() {
        nr4.d dVar;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            if (this.q == null) {
                this.q = new nr4.f(this);
            }
            dVar = this.q;
        }
        return dVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    nr4.g audioDlStatusDao() {
        nr4.g gVar;
        if (this.p != null) {
            return this.p;
        }
        synchronized (this) {
            if (this.p == null) {
                this.p = new nr4.i(this);
            }
            gVar = this.p;
        }
        return gVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    nr4.k bookChapterProgressDao() {
        nr4.k kVar;
        if (this.K != null) {
            return this.K;
        }
        synchronized (this) {
            if (this.K == null) {
                this.K = new nr4.m(this);
            }
            kVar = this.K;
        }
        return kVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    x3 bookCommentSearchRecordDao() {
        x3 x3Var;
        if (this.k != null) {
            return this.k;
        }
        synchronized (this) {
            if (this.k == null) {
                this.k = new z3(this);
            }
            x3Var = this.k;
        }
        return x3Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    nr4.n bookContentDao() {
        nr4.n nVar;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new nr4.p(this);
            }
            nVar = this.c;
        }
        return nVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    q bookDao() {
        q qVar;
        if (this.a != null) {
            return this.a;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new s(this);
            }
            qVar = this.a;
        }
        return qVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    f0 bookMarkDao() {
        f0 f0Var;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            if (this.r == null) {
                this.r = new h0(this);
            }
            f0Var = this.r;
        }
        return f0Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    public d4 bookShelfSearchRecordDao() {
        d4 d4Var;
        if (this.j != null) {
            return this.j;
        }
        synchronized (this) {
            if (this.j == null) {
                this.j = new f4(this);
            }
            d4Var = this.j;
        }
        return d4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    t booklistDao() {
        t tVar;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            if (this.v == null) {
                this.v = new v(this);
            }
            tVar = this.v;
        }
        return tVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    c0 bookmarkCacheDao() {
        c0 c0Var;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            if (this.s == null) {
                this.s = new e0(this);
            }
            c0Var = this.s;
        }
        return c0Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    i0 bookshelfPanelDao() {
        i0 i0Var;
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = new j0(this);
            }
            i0Var = this.g;
        }
        return i0Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    k0 cacheDao() {
        k0 k0Var;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new m0(this);
            }
            k0Var = this.b;
        }
        return k0Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    y0 comicReadProgressRecordDao() {
        y0 y0Var;
        if (this.G != null) {
            return this.G;
        }
        synchronized (this) {
            if (this.G == null) {
                this.G = new a1(this);
            }
            y0Var = this.G;
        }
        return y0Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    v0 comicRecordDao() {
        v0 v0Var;
        if (this.N != null) {
            return this.N;
        }
        synchronized (this) {
            if (this.N == null) {
                this.N = new x0(this);
            }
            v0Var = this.N;
        }
        return v0Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    public a4 commonSearchRecordDao() {
        a4 a4Var;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new c4(this);
            }
            a4Var = this.h;
        }
        return a4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    b1 dialogueProgressDao() {
        b1 b1Var;
        if (this.B != null) {
            return this.B;
        }
        synchronized (this) {
            if (this.B == null) {
                this.B = new d1(this);
            }
            b1Var = this.B;
        }
        return b1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    e1 dialogueRecordDao() {
        e1 e1Var;
        if (this.A != null) {
            return this.A;
        }
        synchronized (this) {
            if (this.A == null) {
                this.A = new g1(this);
            }
            e1Var = this.A;
        }
        return e1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    h1 downloadBookDao() {
        h1 h1Var;
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = new j1(this);
            }
            h1Var = this.e;
        }
        return h1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    k1 forumSessionDataDao() {
        k1 k1Var;
        if (this.O != null) {
            return this.O;
        }
        synchronized (this) {
            if (this.O == null) {
                this.O = new m1(this);
            }
            k1Var = this.O;
        }
        return k1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    IIMParticipantDao imParticipantDao() {
        IIMParticipantDao iIMParticipantDao;
        if (this.M != null) {
            return this.M;
        }
        synchronized (this) {
            if (this.M == null) {
                this.M = new o1(this);
            }
            iIMParticipantDao = this.M;
        }
        return iIMParticipantDao;
    }

    @Override // com.dragon.read.local.db.DBManager
    p1 interactiveRecordDao() {
        p1 p1Var;
        if (this.z != null) {
            return this.z;
        }
        synchronized (this) {
            if (this.z == null) {
                this.z = new r1(this);
            }
            p1Var = this.z;
        }
        return p1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    s1 localBookBookmarkDao() {
        s1 s1Var;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            if (this.u == null) {
                this.u = new u1(this);
            }
            s1Var = this.u;
        }
        return s1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    g localBookUnderlineDao() {
        g gVar;
        if (this.J != null) {
            return this.J;
        }
        synchronized (this) {
            if (this.J == null) {
                this.J = new i(this);
            }
            gVar = this.J;
        }
        return gVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    v1 localBookshelfDao() {
        v1 v1Var;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            if (this.t == null) {
                this.t = new x1(this);
            }
            v1Var = this.t;
        }
        return v1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    y1 noteBookDataDao() {
        y1 y1Var;
        if (this.L != null) {
            return this.L;
        }
        synchronized (this) {
            if (this.L == null) {
                this.L = new a2(this);
            }
            y1Var = this.L;
        }
        return y1Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    w progressDao() {
        w wVar;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new y(this);
            }
            wVar = this.d;
        }
        return wVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    y2 readingRecordDao() {
        y2 y2Var;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            if (this.n == null) {
                this.n = new a3(this);
            }
            y2Var = this.n;
        }
        return y2Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    b3 readingTimeDao() {
        b3 b3Var;
        if (this.o != null) {
            return this.o;
        }
        synchronized (this) {
            if (this.o == null) {
                this.o = new d3(this);
            }
            b3Var = this.o;
        }
        return b3Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    z recordDao() {
        z zVar;
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = new b0(this);
            }
            zVar = this.f;
        }
        return zVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    o3 relativeBookDao() {
        o3 o3Var;
        if (this.l != null) {
            return this.l;
        }
        synchronized (this) {
            if (this.l == null) {
                this.l = new q3(this);
            }
            o3Var = this.l;
        }
        return o3Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    r3 relativePDFEpubDao() {
        r3 r3Var;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            if (this.m == null) {
                this.m = new u3(this);
            }
            r3Var = this.m;
        }
        return r3Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    j4 shelfControlModelDao() {
        j4 j4Var;
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            if (this.x == null) {
                this.x = new l4(this);
            }
            j4Var = this.x;
        }
        return j4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    m4 taskCommentPublishRecordDao() {
        m4 m4Var;
        if (this.Q != null) {
            return this.Q;
        }
        synchronized (this) {
            if (this.Q == null) {
                this.Q = new o4(this);
            }
            m4Var = this.Q;
        }
        return m4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    public g4 topicSearchRecordDao() {
        g4 g4Var;
        if (this.i != null) {
            return this.i;
        }
        synchronized (this) {
            if (this.i == null) {
                this.i = new i4(this);
            }
            g4Var = this.i;
        }
        return g4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    p4 ugcBookListDao() {
        p4 p4Var;
        if (this.y != null) {
            return this.y;
        }
        synchronized (this) {
            if (this.y == null) {
                this.y = new r4(this);
            }
            p4Var = this.y;
        }
        return p4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    s4 ugcVideoListDataDao() {
        s4 s4Var;
        if (this.P != null) {
            return this.P;
        }
        synchronized (this) {
            if (this.P == null) {
                this.P = new u4(this);
            }
            s4Var = this.P;
        }
        return s4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    j underlineLocalDao() {
        j jVar;
        if (this.H != null) {
            return this.H;
        }
        synchronized (this) {
            if (this.H == null) {
                this.H = new l(this);
            }
            jVar = this.H;
        }
        return jVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    m underlineRemoteDao() {
        m mVar;
        if (this.I != null) {
            return this.I;
        }
        synchronized (this) {
            if (this.I == null) {
                this.I = new o(this);
            }
            mVar = this.I;
        }
        return mVar;
    }

    @Override // com.dragon.read.local.db.DBManager
    v4 userInfoDao() {
        v4 v4Var;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            if (this.w == null) {
                this.w = new x4(this);
            }
            v4Var = this.w;
        }
        return v4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    e5 videoLikeDao() {
        e5 e5Var;
        if (this.D != null) {
            return this.D;
        }
        synchronized (this) {
            if (this.D == null) {
                this.D = new f5(this);
            }
            e5Var = this.D;
        }
        return e5Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    y4 videoRecordDao() {
        y4 y4Var;
        if (this.C != null) {
            return this.C;
        }
        synchronized (this) {
            if (this.C == null) {
                this.C = new a5(this);
            }
            y4Var = this.C;
        }
        return y4Var;
    }

    @Override // com.dragon.read.local.db.DBManager
    b5 videoSeriesProgressDao() {
        b5 b5Var;
        if (this.E != null) {
            return this.E;
        }
        synchronized (this) {
            if (this.E == null) {
                this.E = new d5(this);
            }
            b5Var = this.E;
        }
        return b5Var;
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"t_book", "t_bookshelf", "t_book_record", "t_book_progress", "t_interactive_record", "t_dialogue_record", "t_dialogue_progress", "t_cache_table", "t_search_record", "t_relative_book_id", "t_reading_record", "t_reading_time", "t_audio_download_status", "t_audio_download_result", "t_bookmark_remote", "t_bookmark_local", "t_local_book", "t_local_book_bookmark", "t_booklist", "t_user_info", "t_ugc_book_list", "t_ugc_book_info", "shelf_control_model", "t_video_history_record", "t_topic_search_record", "t_underline_local", "t_underline_remote", "t_local_book_underline", "t_font_config", "t_book_chapter_progress", "t_bookshelf_panel", "t_audio_bookshelf_guide_info", "t_comic_read_progress_record", "t_book_content_detail", "t_comic_detail_info", "t_comic_download_chapter_info", "t_comic_download_item_info", "t_note_book_data", "t_shelf_search_record", "t_im_participant", "t_search_record_book_comment", "t_video_serial_collection", "t_video_serial_progress", "t_forum_session_data", "t_video_serial_like", "t_download_book", "t_ugc_video_info", "t_ugc_video_list_info", "t_task_comment_publish_record", "t_relative_pdf_epub"});
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `t_book`");
            writableDatabase.execSQL("DELETE FROM `t_bookshelf`");
            writableDatabase.execSQL("DELETE FROM `t_book_record`");
            writableDatabase.execSQL("DELETE FROM `t_book_progress`");
            writableDatabase.execSQL("DELETE FROM `t_interactive_record`");
            writableDatabase.execSQL("DELETE FROM `t_dialogue_record`");
            writableDatabase.execSQL("DELETE FROM `t_dialogue_progress`");
            writableDatabase.execSQL("DELETE FROM `t_cache_table`");
            writableDatabase.execSQL("DELETE FROM `t_search_record`");
            writableDatabase.execSQL("DELETE FROM `t_relative_book_id`");
            writableDatabase.execSQL("DELETE FROM `t_reading_record`");
            writableDatabase.execSQL("DELETE FROM `t_reading_time`");
            writableDatabase.execSQL("DELETE FROM `t_audio_download_status`");
            writableDatabase.execSQL("DELETE FROM `t_audio_download_result`");
            writableDatabase.execSQL("DELETE FROM `t_bookmark_remote`");
            writableDatabase.execSQL("DELETE FROM `t_bookmark_local`");
            writableDatabase.execSQL("DELETE FROM `t_local_book`");
            writableDatabase.execSQL("DELETE FROM `t_local_book_bookmark`");
            writableDatabase.execSQL("DELETE FROM `t_booklist`");
            writableDatabase.execSQL("DELETE FROM `t_user_info`");
            writableDatabase.execSQL("DELETE FROM `t_ugc_book_list`");
            writableDatabase.execSQL("DELETE FROM `t_ugc_book_info`");
            writableDatabase.execSQL("DELETE FROM `shelf_control_model`");
            writableDatabase.execSQL("DELETE FROM `t_video_history_record`");
            writableDatabase.execSQL("DELETE FROM `t_topic_search_record`");
            writableDatabase.execSQL("DELETE FROM `t_underline_local`");
            writableDatabase.execSQL("DELETE FROM `t_underline_remote`");
            writableDatabase.execSQL("DELETE FROM `t_local_book_underline`");
            writableDatabase.execSQL("DELETE FROM `t_font_config`");
            writableDatabase.execSQL("DELETE FROM `t_book_chapter_progress`");
            writableDatabase.execSQL("DELETE FROM `t_bookshelf_panel`");
            writableDatabase.execSQL("DELETE FROM `t_audio_bookshelf_guide_info`");
            writableDatabase.execSQL("DELETE FROM `t_comic_read_progress_record`");
            writableDatabase.execSQL("DELETE FROM `t_book_content_detail`");
            writableDatabase.execSQL("DELETE FROM `t_comic_detail_info`");
            writableDatabase.execSQL("DELETE FROM `t_comic_download_chapter_info`");
            writableDatabase.execSQL("DELETE FROM `t_comic_download_item_info`");
            writableDatabase.execSQL("DELETE FROM `t_note_book_data`");
            writableDatabase.execSQL("DELETE FROM `t_shelf_search_record`");
            writableDatabase.execSQL("DELETE FROM `t_im_participant`");
            writableDatabase.execSQL("DELETE FROM `t_search_record_book_comment`");
            writableDatabase.execSQL("DELETE FROM `t_video_serial_collection`");
            writableDatabase.execSQL("DELETE FROM `t_video_serial_progress`");
            writableDatabase.execSQL("DELETE FROM `t_forum_session_data`");
            writableDatabase.execSQL("DELETE FROM `t_video_serial_like`");
            writableDatabase.execSQL("DELETE FROM `t_download_book`");
            writableDatabase.execSQL("DELETE FROM `t_ugc_video_info`");
            writableDatabase.execSQL("DELETE FROM `t_ugc_video_list_info`");
            writableDatabase.execSQL("DELETE FROM `t_task_comment_publish_record`");
            writableDatabase.execSQL("DELETE FROM `t_relative_pdf_epub`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(q.class, s.m());
        hashMap.put(k0.class, m0.h());
        hashMap.put(nr4.n.class, nr4.p.c());
        hashMap.put(w.class, y.d());
        hashMap.put(h1.class, j1.d());
        hashMap.put(z.class, b0.m());
        hashMap.put(i0.class, j0.a());
        hashMap.put(a4.class, c4.s());
        hashMap.put(g4.class, i4.s());
        hashMap.put(d4.class, f4.s());
        hashMap.put(x3.class, z3.d());
        hashMap.put(o3.class, q3.a());
        hashMap.put(r3.class, u3.f());
        hashMap.put(y2.class, a3.c());
        hashMap.put(b3.class, d3.f());
        hashMap.put(nr4.g.class, nr4.i.f());
        hashMap.put(nr4.d.class, nr4.f.a());
        hashMap.put(f0.class, h0.k());
        hashMap.put(c0.class, e0.g());
        hashMap.put(v1.class, x1.g());
        hashMap.put(s1.class, u1.g());
        hashMap.put(t.class, v.g());
        hashMap.put(v4.class, x4.c());
        hashMap.put(j4.class, l4.c());
        hashMap.put(p4.class, r4.j());
        hashMap.put(p1.class, r1.a());
        hashMap.put(e1.class, g1.a());
        hashMap.put(b1.class, d1.a());
        hashMap.put(y4.class, a5.l());
        hashMap.put(e5.class, f5.h());
        hashMap.put(b5.class, d5.m());
        hashMap.put(nr4.a.class, nr4.c.e());
        hashMap.put(y0.class, a1.d());
        hashMap.put(j.class, l.h());
        hashMap.put(m.class, o.l());
        hashMap.put(g.class, i.h());
        hashMap.put(nr4.k.class, nr4.m.a());
        hashMap.put(y1.class, a2.d());
        hashMap.put(IIMParticipantDao.class, o1.a());
        hashMap.put(v0.class, x0.c());
        hashMap.put(k1.class, m1.a());
        hashMap.put(s4.class, u4.a());
        hashMap.put(m4.class, o4.c());
        return hashMap;
    }

    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(118), "40f8e3a9b87c6c5a796008bc1ad9a2ef", "a77909cb8ec9b2db361ef4d739caa587")).build());
    }
}
