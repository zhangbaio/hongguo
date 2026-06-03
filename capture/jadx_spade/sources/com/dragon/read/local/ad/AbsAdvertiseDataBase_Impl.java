package com.dragon.read.local.ad;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.covode.number.Covode;
import gr4.b;
import ir4.c;
import ir4.d;
import ir4.e;
import ir4.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AbsAdvertiseDataBase_Impl extends AbsAdvertiseDataBase {
    private volatile b b;
    private volatile c c;
    private volatile e d;

    static {
        Covode.recordClassIndex(611488);
    }

    @Override // com.dragon.read.local.ad.AbsAdvertiseDataBase
    b c() {
        b bVar;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new gr4.c(this);
            }
            bVar = this.b;
        }
        return bVar;
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"t_ad_download", "ChapterPageAdEntity", "ChapterStrategyInfoEntity", "TextLinkAdEntity"});
    }

    @Override // com.dragon.read.local.ad.AbsAdvertiseDataBase
    c d() {
        c cVar;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new d(this);
            }
            cVar = this.c;
        }
        return cVar;
    }

    @Override // com.dragon.read.local.ad.AbsAdvertiseDataBase
    e e() {
        e eVar;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new f(this);
            }
            eVar = this.d;
        }
        return eVar;
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, gr4.c.c());
        hashMap.put(c.class, d.b());
        hashMap.put(e.class, f.b());
        hashMap.put(jr4.a.class, jr4.b.a());
        return hashMap;
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `t_ad_download`");
            writableDatabase.execSQL("DELETE FROM `ChapterPageAdEntity`");
            writableDatabase.execSQL("DELETE FROM `ChapterStrategyInfoEntity`");
            writableDatabase.execSQL("DELETE FROM `TextLinkAdEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    class a extends RoomOpenHelper.Delegate {
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_ad_download` (`download_url` TEXT NOT NULL, `ad_id` INTEGER NOT NULL, `extra_value` INTEGER NOT NULL, `is_ad` INTEGER NOT NULL, `model_type` INTEGER NOT NULL, `log_extra` TEXT, `package_name` TEXT, `app_icon_url` TEXT, `deep_link_web_url` TEXT, `deep_link_open_url` TEXT, `deep_link_cloud_game_url` TEXT, `deep_link_web_title` TEXT, `click_track_url` TEXT, `extra` TEXT, `backup_urls` TEXT, `app_name` TEXT, `mime_type` TEXT, `headers` TEXT, `download_settings` TEXT, `version_code` INTEGER NOT NULL, `version_name` TEXT, `quick_app_open_url` TEXT, `quick_app_extra_data` TEXT, `auto_install_without_notification` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `file_dir` TEXT, `success_install_time` INTEGER NOT NULL, `shown_after_download_finished` INTEGER NOT NULL, `source` TEXT, `unified_game_id` TEXT, `download_info` TEXT, PRIMARY KEY(`download_url`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ChapterPageAdEntity` (`chapterId` TEXT NOT NULL, `chapterPageIndex` INTEGER NOT NULL, `expiredTime` INTEGER NOT NULL, `adModel` TEXT, PRIMARY KEY(`chapterId`, `chapterPageIndex`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ChapterStrategyInfoEntity` (`chapterId` TEXT NOT NULL, `chapterIndex` INTEGER NOT NULL, `strategyChapterIndex` INTEGER NOT NULL, `strategyIndex` INTEGER NOT NULL, `showAd` INTEGER NOT NULL, `hasAtAdReturn` INTEGER NOT NULL, `rangeInfoList` TEXT, `expiredTime` INTEGER NOT NULL, `tip` TEXT, `tipOptimizeFirst` TEXT, `tipOptimizeSecond` TEXT, PRIMARY KEY(`chapterId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TextLinkAdEntity` (`chapterId` TEXT NOT NULL, `word` TEXT NOT NULL, `wordIndex` INTEGER NOT NULL, `expiredTime` INTEGER NOT NULL, `textLinkAdInfo` TEXT, PRIMARY KEY(`chapterId`, `word`, `wordIndex`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f8025e0645f0bab93937861497dcdc7a')");
        }

        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_ad_download`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ChapterPageAdEntity`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ChapterStrategyInfoEntity`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `TextLinkAdEntity`");
            if (((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mDatabase = supportSQLiteDatabase;
            AbsAdvertiseDataBase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AbsAdvertiseDataBase_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(31);
            hashMap.put("download_url", new TableInfo.Column("download_url", "TEXT", true, 1, (String) null, 1));
            hashMap.put("ad_id", new TableInfo.Column("ad_id", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("extra_value", new TableInfo.Column("extra_value", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("is_ad", new TableInfo.Column("is_ad", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("model_type", new TableInfo.Column("model_type", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("log_extra", new TableInfo.Column("log_extra", "TEXT", false, 0, (String) null, 1));
            hashMap.put("package_name", new TableInfo.Column("package_name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("app_icon_url", new TableInfo.Column("app_icon_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("deep_link_web_url", new TableInfo.Column("deep_link_web_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("deep_link_open_url", new TableInfo.Column("deep_link_open_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("deep_link_cloud_game_url", new TableInfo.Column("deep_link_cloud_game_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("deep_link_web_title", new TableInfo.Column("deep_link_web_title", "TEXT", false, 0, (String) null, 1));
            hashMap.put("click_track_url", new TableInfo.Column("click_track_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("extra", new TableInfo.Column("extra", "TEXT", false, 0, (String) null, 1));
            hashMap.put("backup_urls", new TableInfo.Column("backup_urls", "TEXT", false, 0, (String) null, 1));
            hashMap.put("app_name", new TableInfo.Column("app_name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("mime_type", new TableInfo.Column("mime_type", "TEXT", false, 0, (String) null, 1));
            hashMap.put("headers", new TableInfo.Column("headers", "TEXT", false, 0, (String) null, 1));
            hashMap.put("download_settings", new TableInfo.Column("download_settings", "TEXT", false, 0, (String) null, 1));
            hashMap.put("version_code", new TableInfo.Column("version_code", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("version_name", new TableInfo.Column("version_name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("quick_app_open_url", new TableInfo.Column("quick_app_open_url", "TEXT", false, 0, (String) null, 1));
            hashMap.put("quick_app_extra_data", new TableInfo.Column("quick_app_extra_data", "TEXT", false, 0, (String) null, 1));
            hashMap.put("auto_install_without_notification", new TableInfo.Column("auto_install_without_notification", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("file_dir", new TableInfo.Column("file_dir", "TEXT", false, 0, (String) null, 1));
            hashMap.put("success_install_time", new TableInfo.Column("success_install_time", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("shown_after_download_finished", new TableInfo.Column("shown_after_download_finished", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("source", new TableInfo.Column("source", "TEXT", false, 0, (String) null, 1));
            hashMap.put("unified_game_id", new TableInfo.Column("unified_game_id", "TEXT", false, 0, (String) null, 1));
            hashMap.put("download_info", new TableInfo.Column("download_info", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo = new TableInfo("t_ad_download", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "t_ad_download");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "t_ad_download(com.dragon.read.local.ad.download.AdDownloadEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(4);
            hashMap2.put("chapterId", new TableInfo.Column("chapterId", "TEXT", true, 1, (String) null, 1));
            hashMap2.put("chapterPageIndex", new TableInfo.Column("chapterPageIndex", "INTEGER", true, 2, (String) null, 1));
            hashMap2.put("expiredTime", new TableInfo.Column("expiredTime", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("adModel", new TableInfo.Column("adModel", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo2 = new TableInfo("ChapterPageAdEntity", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "ChapterPageAdEntity");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "ChapterPageAdEntity(com.dragon.read.local.ad.reader.flow.ChapterPageAdEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(11);
            hashMap3.put("chapterId", new TableInfo.Column("chapterId", "TEXT", true, 1, (String) null, 1));
            hashMap3.put("chapterIndex", new TableInfo.Column("chapterIndex", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("strategyChapterIndex", new TableInfo.Column("strategyChapterIndex", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("strategyIndex", new TableInfo.Column("strategyIndex", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("showAd", new TableInfo.Column("showAd", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("hasAtAdReturn", new TableInfo.Column("hasAtAdReturn", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("rangeInfoList", new TableInfo.Column("rangeInfoList", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("expiredTime", new TableInfo.Column("expiredTime", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("tip", new TableInfo.Column("tip", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("tipOptimizeFirst", new TableInfo.Column("tipOptimizeFirst", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("tipOptimizeSecond", new TableInfo.Column("tipOptimizeSecond", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo3 = new TableInfo("ChapterStrategyInfoEntity", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "ChapterStrategyInfoEntity");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "ChapterStrategyInfoEntity(com.dragon.read.local.ad.reader.flow.ChapterStrategyInfoEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(5);
            hashMap4.put("chapterId", new TableInfo.Column("chapterId", "TEXT", true, 1, (String) null, 1));
            hashMap4.put("word", new TableInfo.Column("word", "TEXT", true, 2, (String) null, 1));
            hashMap4.put("wordIndex", new TableInfo.Column("wordIndex", "INTEGER", true, 3, (String) null, 1));
            hashMap4.put("expiredTime", new TableInfo.Column("expiredTime", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("textLinkAdInfo", new TableInfo.Column("textLinkAdInfo", "TEXT", false, 0, (String) null, 1));
            TableInfo tableInfo4 = new TableInfo("TextLinkAdEntity", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "TextLinkAdEntity");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "TextLinkAdEntity(com.dragon.read.local.ad.textlink.TextLinkAdEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            return new RoomOpenHelper.ValidationResult(true, (String) null);
        }

        a(int i) {
            super(i);
        }
    }

    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(7), "f8025e0645f0bab93937861497dcdc7a", "e6313fae909617c8b13fa4befe281da8")).build());
    }
}
