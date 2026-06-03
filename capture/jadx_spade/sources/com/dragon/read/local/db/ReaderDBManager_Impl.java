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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import nr4.e2;
import nr4.f2;
import nr4.g2;
import nr4.h2;
import nr4.i2;
import nr4.j2;
import nr4.k2;
import nr4.l2;
import nr4.m2;
import nr4.n2;
import nr4.o2;
import nr4.p2;
import nr4.q2;
import nr4.r2;
import nr4.s2;
import nr4.t2;
import nr4.u2;
import nr4.v2;
import nr4.w2;
import nr4.x2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReaderDBManager_Impl extends ReaderDBManager {
    private volatile g2 d;
    private volatile i2 e;
    private volatile u2 f;
    private volatile w2 g;
    private volatile m2 h;
    private volatile s2 i;
    private volatile o2 j;
    private volatile q2 k;
    private volatile e2 l;
    private volatile k2 m;

    static {
        Covode.recordClassIndex(611536);
    }

    class a extends RoomOpenHelper.Delegate {
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(24);
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("end_paragraph_id", new TableInfo.Column("end_paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", false, 0, (String) null, 1));
            hashMap.put("content", new TableInfo.Column("content", "TEXT", false, 0, (String) null, 1));
            hashMap.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap.put("volume_name", new TableInfo.Column("volume_name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("start_media_index", new TableInfo.Column("start_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("end_media_index", new TableInfo.Column("end_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo = new TableInfo("reader_bookmark_local", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "reader_bookmark_local");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_bookmark_local(com.dragon.read.local.db.entity.ReaderBookmarkLocal).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(25);
            hashMap2.put("mark_id", new TableInfo.Column("mark_id", "INTEGER", true, 1, (String) null, 1));
            hashMap2.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("end_paragraph_id", new TableInfo.Column("end_paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("content", new TableInfo.Column("content", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("volume_name", new TableInfo.Column("volume_name", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("start_media_index", new TableInfo.Column("start_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("end_media_index", new TableInfo.Column("end_media_index", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap2.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo2 = new TableInfo("reader_bookmark_remote", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "reader_bookmark_remote");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_bookmark_remote(com.dragon.read.local.db.entity.ReaderBookmarkRemote).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(27);
            hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap3.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("start_para_id", new TableInfo.Column("start_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("end_para_id", new TableInfo.Column("end_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("volume_name", new TableInfo.Column("volume_name", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap3.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("line_type", new TableInfo.Column("line_type", "INTEGER", true, 0, "0", 1));
            hashMap3.put("is_public", new TableInfo.Column("is_public", "INTEGER", true, 0, "0", 1));
            hashMap3.put("hot_line_id", new TableInfo.Column("hot_line_id", "INTEGER", true, 0, "0", 1));
            hashMap3.put("underline_type", new TableInfo.Column("underline_type", "INTEGER", true, 0, "0", 1));
            hashMap3.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo3 = new TableInfo("reader_underline_local", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "reader_underline_local");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_underline_local(com.dragon.read.local.db.entity.ReaderUnderlineLocal).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(28);
            hashMap4.put("mark_id", new TableInfo.Column("mark_id", "INTEGER", true, 1, (String) null, 1));
            hashMap4.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("start_para_id", new TableInfo.Column("start_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("end_para_id", new TableInfo.Column("end_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("volume_name", new TableInfo.Column("volume_name", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("end_container_id", new TableInfo.Column("end_container_id", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("end_element_index", new TableInfo.Column("end_element_index", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("end_element_offset", new TableInfo.Column("end_element_offset", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("start_order", new TableInfo.Column("start_order", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("end_order", new TableInfo.Column("end_order", "INTEGER", true, 0, "-1", 1));
            hashMap4.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("line_type", new TableInfo.Column("line_type", "INTEGER", true, 0, "0", 1));
            hashMap4.put("is_public", new TableInfo.Column("is_public", "INTEGER", true, 0, "0", 1));
            hashMap4.put("hot_line_id", new TableInfo.Column("hot_line_id", "INTEGER", true, 0, "0", 1));
            hashMap4.put("underline_type", new TableInfo.Column("underline_type", "INTEGER", true, 0, "0", 1));
            hashMap4.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo4 = new TableInfo("reader_underline_remote", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "reader_underline_remote");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_underline_remote(com.dragon.read.local.db.entity.ReaderUnderlineRemote).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(20);
            hashMap5.put("reader_font_id", new TableInfo.Column("reader_font_id", "INTEGER", true, 1, (String) null, 1));
            hashMap5.put("font_title", new TableInfo.Column("font_title", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("file_size", new TableInfo.Column("file_size", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("file_url", new TableInfo.Column("file_url", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("font_pic", new TableInfo.Column("font_pic", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("bold_name", new TableInfo.Column("bold_name", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("regular_name", new TableInfo.Column("regular_name", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("font_family", new TableInfo.Column("font_family", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("regular_file_name", new TableInfo.Column("regular_file_name", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("download_onlaunch", new TableInfo.Column("download_onlaunch", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("hidden_inreader", new TableInfo.Column("hidden_inreader", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("font_vip_type", new TableInfo.Column("font_vip_type", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("is_new_font", new TableInfo.Column("is_new_font", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("is_variable_font", new TableInfo.Column("is_variable_font", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("medium_file_name", new TableInfo.Column("medium_file_name", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("bold_file_name", new TableInfo.Column("bold_file_name", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("medium_name", new TableInfo.Column("medium_name", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("order", new TableInfo.Column("order", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("fanti_font_pic", new TableInfo.Column("fanti_font_pic", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("ui_key", new TableInfo.Column("ui_key", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo5 = new TableInfo("reader_font_config", hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase, "reader_font_config");
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_font_config(com.dragon.read.local.db.entity.ReaderFontConfig).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            HashMap hashMap6 = new HashMap(12);
            hashMap6.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap6.put("bookmark_num", new TableInfo.Column("bookmark_num", "INTEGER", true, 0, "0", 1));
            hashMap6.put("underline_num", new TableInfo.Column("underline_num", "INTEGER", true, 0, "0", 1));
            hashMap6.put("note_num", new TableInfo.Column("note_num", "INTEGER", true, 0, "0", 1));
            hashMap6.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, "0", 1));
            hashMap6.put("book_name", new TableInfo.Column("book_name", "TEXT", true, 0, (String) null, 1));
            hashMap6.put("cover_url", new TableInfo.Column("cover_url", "TEXT", true, 0, (String) null, 1));
            hashMap6.put("status", new TableInfo.Column("status", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("color", new TableInfo.Column("color", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("is_local", new TableInfo.Column("is_local", "INTEGER", true, 0, "0", 1));
            hashMap6.put("file_path", new TableInfo.Column("file_path", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("author", new TableInfo.Column("author", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo6 = new TableInfo("reader_note_book_data", hashMap6, new HashSet(0), new HashSet(0));
            TableInfo read6 = TableInfo.read(supportSQLiteDatabase, "reader_note_book_data");
            if (!tableInfo6.equals(read6)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_note_book_data(com.dragon.read.local.db.entity.ReaderNoteBookData).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
            HashMap hashMap7 = new HashMap(14);
            hashMap7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap7.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap7.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap7.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("end_paragraph_id", new TableInfo.Column("end_paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("content", new TableInfo.Column("content", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("volume_name", new TableInfo.Column("volume_name", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo7 = new TableInfo("reader_local_book_mark", hashMap7, new HashSet(0), new HashSet(0));
            TableInfo read7 = TableInfo.read(supportSQLiteDatabase, "reader_local_book_mark");
            if (!tableInfo7.equals(read7)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_local_book_mark(com.dragon.read.local.db.entity.ReaderLocalBookmark).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
            }
            HashMap hashMap8 = new HashMap(17);
            hashMap8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap8.put("mark_type", new TableInfo.Column("mark_type", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 0, (String) null, 1));
            hashMap8.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap8.put("start_para_id", new TableInfo.Column("start_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("start_offset_in_para", new TableInfo.Column("start_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("end_para_id", new TableInfo.Column("end_para_id", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("end_offset_in_para", new TableInfo.Column("end_offset_in_para", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("chapter_version", new TableInfo.Column("chapter_version", "TEXT", true, 0, (String) null, 1));
            hashMap8.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
            hashMap8.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap8.put("volume_name", new TableInfo.Column("volume_name", "TEXT", true, 0, (String) null, 1));
            hashMap8.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("modify_time", new TableInfo.Column("modify_time", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("line_type", new TableInfo.Column("line_type", "INTEGER", true, 0, "0", 1));
            hashMap8.put("underline_type", new TableInfo.Column("underline_type", "INTEGER", true, 0, "0", 1));
            hashMap8.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, "''", 1));
            TableInfo tableInfo8 = new TableInfo("reader_local_underline", hashMap8, new HashSet(0), new HashSet(0));
            TableInfo read8 = TableInfo.read(supportSQLiteDatabase, "reader_local_underline");
            if (!tableInfo8.equals(read8)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_local_underline(com.dragon.read.local.db.entity.ReaderLocalUnderline).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
            }
            HashMap hashMap9 = new HashMap(18);
            hashMap9.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap9.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 0, (String) null, 1));
            hashMap9.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap9.put("page_index", new TableInfo.Column("page_index", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("pager_progress_rate", new TableInfo.Column("pager_progress_rate", "REAL", true, 0, (String) null, 1));
            hashMap9.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("line_in_paragraph_offset", new TableInfo.Column("line_in_paragraph_offset", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("total_chapter_count_progress_rate", new TableInfo.Column("total_chapter_count_progress_rate", "REAL", true, 0, (String) null, 1));
            hashMap9.put("ms_timestamp", new TableInfo.Column("ms_timestamp", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("genre_type", new TableInfo.Column("genre_type", "TEXT", true, 0, (String) null, 1));
            hashMap9.put("chapter_recent_read_progress_rate", new TableInfo.Column("chapter_recent_read_progress_rate", "TEXT", true, 0, (String) null, 1));
            hashMap9.put("chapter_show_read_progress_rate", new TableInfo.Column("chapter_show_read_progress_rate", "TEXT", true, 0, (String) null, 1));
            hashMap9.put("book_page_progress", new TableInfo.Column("book_page_progress", "REAL", true, 0, (String) null, 1));
            hashMap9.put("update_state", new TableInfo.Column("update_state", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo9 = new TableInfo("reader_book_progress", hashMap9, new HashSet(0), new HashSet(0));
            TableInfo read9 = TableInfo.read(supportSQLiteDatabase, "reader_book_progress");
            if (!tableInfo9.equals(read9)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_book_progress(com.dragon.read.local.db.entity.ReaderBookProgress).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
            }
            HashMap hashMap10 = new HashMap(18);
            hashMap10.put("book_id", new TableInfo.Column("book_id", "TEXT", true, 1, (String) null, 1));
            hashMap10.put("chapter_id", new TableInfo.Column("chapter_id", "TEXT", true, 2, (String) null, 1));
            hashMap10.put("chapter_index", new TableInfo.Column("chapter_index", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("chapter_title", new TableInfo.Column("chapter_title", "TEXT", true, 0, (String) null, 1));
            hashMap10.put("page_index", new TableInfo.Column("page_index", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("pager_progress_rate", new TableInfo.Column("pager_progress_rate", "REAL", true, 0, (String) null, 1));
            hashMap10.put("paragraph_id", new TableInfo.Column("paragraph_id", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("line_in_paragraph_offset", new TableInfo.Column("line_in_paragraph_offset", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("start_container_id", new TableInfo.Column("start_container_id", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("start_element_index", new TableInfo.Column("start_element_index", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("start_element_offset", new TableInfo.Column("start_element_offset", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("total_chapter_count_progress_rate", new TableInfo.Column("total_chapter_count_progress_rate", "REAL", true, 0, (String) null, 1));
            hashMap10.put("ms_timestamp", new TableInfo.Column("ms_timestamp", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("genre_type", new TableInfo.Column("genre_type", "TEXT", true, 0, (String) null, 1));
            hashMap10.put("chapter_recent_read_progress_rate", new TableInfo.Column("chapter_recent_read_progress_rate", "TEXT", true, 0, (String) null, 1));
            hashMap10.put("chapter_show_read_progress_rate", new TableInfo.Column("chapter_show_read_progress_rate", "TEXT", true, 0, (String) null, 1));
            hashMap10.put("book_page_progress", new TableInfo.Column("book_page_progress", "REAL", true, 0, (String) null, 1));
            hashMap10.put("update_state", new TableInfo.Column("update_state", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo10 = new TableInfo("reader_chapter_progress", hashMap10, new HashSet(0), new HashSet(0));
            TableInfo read10 = TableInfo.read(supportSQLiteDatabase, "reader_chapter_progress");
            if (!tableInfo10.equals(read10)) {
                return new RoomOpenHelper.ValidationResult(false, "reader_chapter_progress(com.dragon.read.local.db.entity.ReaderChapterProgress).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
            }
            return new RoomOpenHelper.ValidationResult(true, (String) null);
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_bookmark_local` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `paragraph_id` INTEGER NOT NULL, `end_paragraph_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT, `content` TEXT, `chapter_title` TEXT, `volume_name` TEXT, `start_media_index` INTEGER NOT NULL, `end_media_index` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_bookmark_remote` (`mark_id` INTEGER NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `paragraph_id` INTEGER NOT NULL, `end_paragraph_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT, `content` TEXT, `chapter_title` TEXT, `volume_name` TEXT, `is_deleted` INTEGER NOT NULL, `start_media_index` INTEGER NOT NULL, `end_media_index` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL, PRIMARY KEY(`mark_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_underline_local` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `start_para_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_para_id` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT NOT NULL, `content` TEXT NOT NULL, `chapter_title` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL, `line_type` INTEGER NOT NULL DEFAULT 0, `is_public` INTEGER NOT NULL DEFAULT 0, `hot_line_id` INTEGER NOT NULL DEFAULT 0, `underline_type` INTEGER NOT NULL DEFAULT 0, `notes` TEXT NOT NULL DEFAULT '')");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_underline_remote` (`mark_id` INTEGER NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `start_para_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_para_id` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT NOT NULL, `content` TEXT NOT NULL, `chapter_title` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `is_deleted` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL DEFAULT -1, `start_element_index` INTEGER NOT NULL DEFAULT -1, `start_element_offset` INTEGER NOT NULL DEFAULT -1, `end_container_id` INTEGER NOT NULL DEFAULT -1, `end_element_index` INTEGER NOT NULL DEFAULT -1, `end_element_offset` INTEGER NOT NULL DEFAULT -1, `start_order` INTEGER NOT NULL DEFAULT -1, `end_order` INTEGER NOT NULL DEFAULT -1, `modify_time` INTEGER NOT NULL, `line_type` INTEGER NOT NULL DEFAULT 0, `is_public` INTEGER NOT NULL DEFAULT 0, `hot_line_id` INTEGER NOT NULL DEFAULT 0, `underline_type` INTEGER NOT NULL DEFAULT 0, `notes` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`mark_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_font_config` (`reader_font_id` INTEGER NOT NULL, `font_title` TEXT, `file_size` TEXT, `file_url` TEXT, `font_pic` TEXT, `bold_name` TEXT, `regular_name` TEXT, `font_family` TEXT, `regular_file_name` TEXT, `download_onlaunch` INTEGER NOT NULL, `hidden_inreader` INTEGER NOT NULL, `font_vip_type` INTEGER NOT NULL, `is_new_font` INTEGER NOT NULL, `is_variable_font` INTEGER NOT NULL, `medium_file_name` TEXT, `bold_file_name` TEXT, `medium_name` TEXT, `order` INTEGER NOT NULL, `fanti_font_pic` TEXT, `ui_key` TEXT, PRIMARY KEY(`reader_font_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_note_book_data` (`book_id` TEXT NOT NULL, `bookmark_num` INTEGER NOT NULL DEFAULT 0, `underline_num` INTEGER NOT NULL DEFAULT 0, `note_num` INTEGER NOT NULL DEFAULT 0, `update_time` INTEGER NOT NULL DEFAULT 0, `book_name` TEXT NOT NULL, `cover_url` TEXT NOT NULL, `status` TEXT, `color` TEXT, `is_local` INTEGER NOT NULL DEFAULT 0, `file_path` TEXT, `author` TEXT, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_local_book_mark` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `paragraph_id` INTEGER NOT NULL, `end_paragraph_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT, `content` TEXT, `chapter_title` TEXT, `volume_name` TEXT, `chapter_index` INTEGER NOT NULL, `modify_time` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_local_underline` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mark_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `start_para_id` INTEGER NOT NULL, `start_offset_in_para` INTEGER NOT NULL, `end_para_id` INTEGER NOT NULL, `end_offset_in_para` INTEGER NOT NULL, `chapter_version` TEXT NOT NULL, `content` TEXT NOT NULL, `chapter_title` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `modify_time` INTEGER NOT NULL, `line_type` INTEGER NOT NULL DEFAULT 0, `underline_type` INTEGER NOT NULL DEFAULT 0, `notes` TEXT NOT NULL DEFAULT '')");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_book_progress` (`book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `chapter_title` TEXT NOT NULL, `page_index` INTEGER NOT NULL, `pager_progress_rate` REAL NOT NULL, `paragraph_id` INTEGER NOT NULL, `line_in_paragraph_offset` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL, `start_element_index` INTEGER NOT NULL, `start_element_offset` INTEGER NOT NULL, `total_chapter_count_progress_rate` REAL NOT NULL, `ms_timestamp` INTEGER NOT NULL, `genre_type` TEXT NOT NULL, `chapter_recent_read_progress_rate` TEXT NOT NULL, `chapter_show_read_progress_rate` TEXT NOT NULL, `book_page_progress` REAL NOT NULL, `update_state` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reader_chapter_progress` (`book_id` TEXT NOT NULL, `chapter_id` TEXT NOT NULL, `chapter_index` INTEGER NOT NULL, `chapter_title` TEXT NOT NULL, `page_index` INTEGER NOT NULL, `pager_progress_rate` REAL NOT NULL, `paragraph_id` INTEGER NOT NULL, `line_in_paragraph_offset` INTEGER NOT NULL, `start_container_id` INTEGER NOT NULL, `start_element_index` INTEGER NOT NULL, `start_element_offset` INTEGER NOT NULL, `total_chapter_count_progress_rate` REAL NOT NULL, `ms_timestamp` INTEGER NOT NULL, `genre_type` TEXT NOT NULL, `chapter_recent_read_progress_rate` TEXT NOT NULL, `chapter_show_read_progress_rate` TEXT NOT NULL, `book_page_progress` REAL NOT NULL, `update_state` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `chapter_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dced37b430ab9ba227cd3cf572836255')");
        }

        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) ReaderDBManager_Impl.this).mDatabase = supportSQLiteDatabase;
            ReaderDBManager_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_bookmark_local`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_bookmark_remote`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_underline_local`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_underline_remote`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_font_config`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_note_book_data`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_local_book_mark`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_local_underline`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_book_progress`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reader_chapter_progress`");
            if (((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ReaderDBManager_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        a(int i) {
            super(i);
        }
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    e2 e() {
        e2 e2Var;
        if (this.l != null) {
            return this.l;
        }
        synchronized (this) {
            if (this.l == null) {
                this.l = new f2(this);
            }
            e2Var = this.l;
        }
        return e2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    g2 f() {
        g2 g2Var;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new h2(this);
            }
            g2Var = this.d;
        }
        return g2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    i2 g() {
        i2 i2Var;
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = new j2(this);
            }
            i2Var = this.e;
        }
        return i2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    k2 h() {
        k2 k2Var;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            if (this.m == null) {
                this.m = new l2(this);
            }
            k2Var = this.m;
        }
        return k2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    m2 i() {
        m2 m2Var;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new n2(this);
            }
            m2Var = this.h;
        }
        return m2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    o2 j() {
        o2 o2Var;
        if (this.j != null) {
            return this.j;
        }
        synchronized (this) {
            if (this.j == null) {
                this.j = new p2(this);
            }
            o2Var = this.j;
        }
        return o2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    q2 k() {
        q2 q2Var;
        if (this.k != null) {
            return this.k;
        }
        synchronized (this) {
            if (this.k == null) {
                this.k = new r2(this);
            }
            q2Var = this.k;
        }
        return q2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    s2 l() {
        s2 s2Var;
        if (this.i != null) {
            return this.i;
        }
        synchronized (this) {
            if (this.i == null) {
                this.i = new t2(this);
            }
            s2Var = this.i;
        }
        return s2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    u2 x() {
        u2 u2Var;
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = new v2(this);
            }
            u2Var = this.f;
        }
        return u2Var;
    }

    @Override // com.dragon.read.local.db.ReaderDBManager
    w2 y() {
        w2 w2Var;
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = new x2(this);
            }
            w2Var = this.g;
        }
        return w2Var;
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"reader_bookmark_local", "reader_bookmark_remote", "reader_underline_local", "reader_underline_remote", "reader_font_config", "reader_note_book_data", "reader_local_book_mark", "reader_local_underline", "reader_book_progress", "reader_chapter_progress"});
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `reader_bookmark_local`");
            writableDatabase.execSQL("DELETE FROM `reader_bookmark_remote`");
            writableDatabase.execSQL("DELETE FROM `reader_underline_local`");
            writableDatabase.execSQL("DELETE FROM `reader_underline_remote`");
            writableDatabase.execSQL("DELETE FROM `reader_font_config`");
            writableDatabase.execSQL("DELETE FROM `reader_note_book_data`");
            writableDatabase.execSQL("DELETE FROM `reader_local_book_mark`");
            writableDatabase.execSQL("DELETE FROM `reader_local_underline`");
            writableDatabase.execSQL("DELETE FROM `reader_book_progress`");
            writableDatabase.execSQL("DELETE FROM `reader_chapter_progress`");
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
        hashMap.put(g2.class, h2.g());
        hashMap.put(i2.class, j2.j());
        hashMap.put(u2.class, v2.h());
        hashMap.put(w2.class, x2.k());
        hashMap.put(m2.class, n2.c());
        hashMap.put(s2.class, t2.c());
        hashMap.put(o2.class, p2.f());
        hashMap.put(q2.class, r2.g());
        hashMap.put(e2.class, f2.d());
        hashMap.put(k2.class, l2.g());
        return hashMap;
    }

    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(2), "dced37b430ab9ba227cd3cf572836255", "6f978b67e2a3dc63b3b3fe8b80ca93db")).build());
    }
}
