package gr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kr4.d;
import kr4.e;
import kr4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements gr4.b {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<gr4.a> b;
    private final EntityDeletionOrUpdateAdapter<gr4.a> c;

    static {
        Covode.recordClassIndex(611494);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // gr4.b
    public List<gr4.a> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        boolean z;
        String string2;
        String string3;
        String string4;
        int i2;
        int i3;
        String string5;
        String string6;
        boolean z2;
        boolean z3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_ad_download ORDER BY update_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "download_url");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "ad_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "extra_value");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "is_ad");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "model_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "log_extra");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "package_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "app_icon_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_web_url");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_open_url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_cloud_game_url");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_web_title");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "click_track_url");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "extra");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "backup_urls");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "app_name");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mime_type");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "headers");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "download_settings");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "version_code");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "version_name");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "quick_app_open_url");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "quick_app_extra_data");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "auto_install_without_notification");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "file_dir");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "success_install_time");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "shown_after_download_finished");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "source");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "unified_game_id");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "download_info");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                        i = columnIndexOrThrow;
                    }
                    gr4.a aVar = new gr4.a(string);
                    ArrayList arrayList2 = arrayList;
                    int i5 = columnIndexOrThrow13;
                    aVar.b = query.getLong(columnIndexOrThrow2);
                    aVar.c = query.getLong(columnIndexOrThrow3);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.d = z;
                    aVar.e = query.getInt(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        aVar.f = null;
                    } else {
                        aVar.f = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        aVar.g = null;
                    } else {
                        aVar.g = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        aVar.h = null;
                    } else {
                        aVar.h = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        aVar.i = null;
                    } else {
                        aVar.i = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        aVar.j = null;
                    } else {
                        aVar.j = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        aVar.k = null;
                    } else {
                        aVar.k = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        aVar.l = null;
                    } else {
                        aVar.l = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(i5)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(i5);
                    }
                    aVar.m = e.a(string2);
                    int i6 = i4;
                    if (query.isNull(i6)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(i6);
                    }
                    aVar.n = d.a(string3);
                    int i7 = columnIndexOrThrow15;
                    if (query.isNull(i7)) {
                        i2 = i5;
                        string4 = null;
                    } else {
                        string4 = query.getString(i7);
                        i2 = i5;
                    }
                    aVar.o = e.a(string4);
                    int i8 = columnIndexOrThrow16;
                    if (query.isNull(i8)) {
                        i3 = columnIndexOrThrow12;
                        aVar.p = null;
                    } else {
                        i3 = columnIndexOrThrow12;
                        aVar.p = query.getString(i8);
                    }
                    int i9 = columnIndexOrThrow17;
                    if (query.isNull(i9)) {
                        columnIndexOrThrow16 = i8;
                        aVar.q = null;
                    } else {
                        columnIndexOrThrow16 = i8;
                        aVar.q = query.getString(i9);
                    }
                    int i10 = columnIndexOrThrow18;
                    if (query.isNull(i10)) {
                        columnIndexOrThrow18 = i10;
                        string5 = null;
                    } else {
                        string5 = query.getString(i10);
                        columnIndexOrThrow18 = i10;
                    }
                    aVar.r = f.a(string5);
                    int i11 = columnIndexOrThrow19;
                    if (query.isNull(i11)) {
                        columnIndexOrThrow19 = i11;
                        string6 = null;
                    } else {
                        string6 = query.getString(i11);
                        columnIndexOrThrow19 = i11;
                    }
                    aVar.s = d.a(string6);
                    columnIndexOrThrow17 = i9;
                    int i12 = columnIndexOrThrow20;
                    aVar.t = query.getInt(i12);
                    int i13 = columnIndexOrThrow21;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow20 = i12;
                        aVar.u = null;
                    } else {
                        columnIndexOrThrow20 = i12;
                        aVar.u = query.getString(i13);
                    }
                    int i14 = columnIndexOrThrow22;
                    if (query.isNull(i14)) {
                        columnIndexOrThrow21 = i13;
                        aVar.v = null;
                    } else {
                        columnIndexOrThrow21 = i13;
                        aVar.v = query.getString(i14);
                    }
                    int i15 = columnIndexOrThrow23;
                    if (query.isNull(i15)) {
                        columnIndexOrThrow22 = i14;
                        aVar.w = null;
                    } else {
                        columnIndexOrThrow22 = i14;
                        aVar.w = query.getString(i15);
                    }
                    int i16 = columnIndexOrThrow24;
                    columnIndexOrThrow24 = i16;
                    if (query.getInt(i16) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    aVar.x = z2;
                    int i17 = columnIndexOrThrow25;
                    aVar.y = query.getLong(i17);
                    int i18 = columnIndexOrThrow26;
                    if (query.isNull(i18)) {
                        aVar.z = null;
                    } else {
                        aVar.z = query.getString(i18);
                    }
                    int i19 = columnIndexOrThrow27;
                    aVar.A = query.getLong(i19);
                    int i20 = columnIndexOrThrow28;
                    if (query.getInt(i20) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    aVar.B = z3;
                    int i21 = columnIndexOrThrow29;
                    if (query.isNull(i21)) {
                        columnIndexOrThrow28 = i20;
                        aVar.C = null;
                    } else {
                        columnIndexOrThrow28 = i20;
                        aVar.C = query.getString(i21);
                    }
                    int i22 = columnIndexOrThrow30;
                    if (query.isNull(i22)) {
                        columnIndexOrThrow29 = i21;
                        aVar.D = null;
                    } else {
                        columnIndexOrThrow29 = i21;
                        aVar.D = query.getString(i22);
                    }
                    int i23 = columnIndexOrThrow31;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow30 = i22;
                        aVar.E = null;
                    } else {
                        columnIndexOrThrow30 = i22;
                        aVar.E = query.getString(i23);
                    }
                    arrayList2.add(aVar);
                    columnIndexOrThrow31 = i23;
                    columnIndexOrThrow12 = i3;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow13 = i2;
                    i4 = i6;
                    columnIndexOrThrow23 = i15;
                    columnIndexOrThrow25 = i17;
                    columnIndexOrThrow26 = i18;
                    columnIndexOrThrow27 = i19;
                    arrayList = arrayList2;
                }
                ArrayList arrayList3 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList3;
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

    public c(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    @Override // gr4.b
    public void b(gr4.a... aVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(aVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // gr4.b
    public void delete(gr4.a... aVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(aVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // gr4.b
    public gr4.a query(String str) {
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
        gr4.a aVar;
        String string;
        int i;
        boolean z;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z2;
        boolean z3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_ad_download WHERE download_url = ? limit 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "download_url");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "ad_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "extra_value");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "is_ad");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "model_type");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "log_extra");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "package_name");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "app_icon_url");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_web_url");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_open_url");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_cloud_game_url");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "deep_link_web_title");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "click_track_url");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "extra");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "backup_urls");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "app_name");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mime_type");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "headers");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "download_settings");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "version_code");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "version_name");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "quick_app_open_url");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "quick_app_extra_data");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "auto_install_without_notification");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "file_dir");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "success_install_time");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "shown_after_download_finished");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "source");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "unified_game_id");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "download_info");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow31;
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                    i = columnIndexOrThrow31;
                }
                gr4.a aVar2 = new gr4.a(string);
                aVar2.b = query.getLong(columnIndexOrThrow2);
                aVar2.c = query.getLong(columnIndexOrThrow3);
                if (query.getInt(columnIndexOrThrow4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar2.d = z;
                aVar2.e = query.getInt(columnIndexOrThrow5);
                if (query.isNull(columnIndexOrThrow6)) {
                    aVar2.f = null;
                } else {
                    aVar2.f = query.getString(columnIndexOrThrow6);
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    aVar2.g = null;
                } else {
                    aVar2.g = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    aVar2.h = null;
                } else {
                    aVar2.h = query.getString(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    aVar2.i = null;
                } else {
                    aVar2.i = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    aVar2.j = null;
                } else {
                    aVar2.j = query.getString(columnIndexOrThrow10);
                }
                if (query.isNull(columnIndexOrThrow11)) {
                    aVar2.k = null;
                } else {
                    aVar2.k = query.getString(columnIndexOrThrow11);
                }
                if (query.isNull(columnIndexOrThrow12)) {
                    aVar2.l = null;
                } else {
                    aVar2.l = query.getString(columnIndexOrThrow12);
                }
                if (query.isNull(columnIndexOrThrow13)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow13);
                }
                aVar2.m = e.a(string2);
                if (query.isNull(columnIndexOrThrow14)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow14);
                }
                aVar2.n = d.a(string3);
                if (query.isNull(columnIndexOrThrow15)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow15);
                }
                aVar2.o = e.a(string4);
                if (query.isNull(columnIndexOrThrow16)) {
                    aVar2.p = null;
                } else {
                    aVar2.p = query.getString(columnIndexOrThrow16);
                }
                if (query.isNull(columnIndexOrThrow17)) {
                    aVar2.q = null;
                } else {
                    aVar2.q = query.getString(columnIndexOrThrow17);
                }
                if (query.isNull(columnIndexOrThrow18)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow18);
                }
                aVar2.r = f.a(string5);
                if (query.isNull(columnIndexOrThrow19)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow19);
                }
                aVar2.s = d.a(string6);
                aVar2.t = query.getInt(columnIndexOrThrow20);
                if (query.isNull(columnIndexOrThrow21)) {
                    aVar2.u = null;
                } else {
                    aVar2.u = query.getString(columnIndexOrThrow21);
                }
                if (query.isNull(columnIndexOrThrow22)) {
                    aVar2.v = null;
                } else {
                    aVar2.v = query.getString(columnIndexOrThrow22);
                }
                if (query.isNull(columnIndexOrThrow23)) {
                    aVar2.w = null;
                } else {
                    aVar2.w = query.getString(columnIndexOrThrow23);
                }
                if (query.getInt(columnIndexOrThrow24) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar2.x = z2;
                aVar2.y = query.getLong(columnIndexOrThrow25);
                if (query.isNull(columnIndexOrThrow26)) {
                    aVar2.z = null;
                } else {
                    aVar2.z = query.getString(columnIndexOrThrow26);
                }
                aVar2.A = query.getLong(columnIndexOrThrow27);
                if (query.getInt(columnIndexOrThrow28) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aVar2.B = z3;
                if (query.isNull(columnIndexOrThrow29)) {
                    aVar2.C = null;
                } else {
                    aVar2.C = query.getString(columnIndexOrThrow29);
                }
                if (query.isNull(columnIndexOrThrow30)) {
                    aVar2.D = null;
                } else {
                    aVar2.D = query.getString(columnIndexOrThrow30);
                }
                int i2 = i;
                if (query.isNull(i2)) {
                    aVar2.E = null;
                } else {
                    aVar2.E = query.getString(i2);
                }
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

    class a extends EntityInsertionAdapter<gr4.a> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_ad_download` (`download_url`,`ad_id`,`extra_value`,`is_ad`,`model_type`,`log_extra`,`package_name`,`app_icon_url`,`deep_link_web_url`,`deep_link_open_url`,`deep_link_cloud_game_url`,`deep_link_web_title`,`click_track_url`,`extra`,`backup_urls`,`app_name`,`mime_type`,`headers`,`download_settings`,`version_code`,`version_name`,`quick_app_open_url`,`quick_app_extra_data`,`auto_install_without_notification`,`update_time`,`file_dir`,`success_install_time`,`shown_after_download_finished`,`source`,`unified_game_id`,`download_info`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, gr4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, aVar.b);
            supportSQLiteStatement.bindLong(3, aVar.c);
            supportSQLiteStatement.bindLong(4, aVar.d ? 1L : 0L);
            supportSQLiteStatement.bindLong(5, aVar.e);
            String str2 = aVar.f;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str2);
            }
            String str3 = aVar.g;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str3);
            }
            String str4 = aVar.h;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str4);
            }
            String str5 = aVar.i;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str5);
            }
            String str6 = aVar.j;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str6);
            }
            String str7 = aVar.k;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str7);
            }
            String str8 = aVar.l;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str8);
            }
            String b = e.b(aVar.m);
            if (b == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, b);
            }
            String b2 = d.b(aVar.n);
            if (b2 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, b2);
            }
            String b3 = e.b(aVar.o);
            if (b3 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, b3);
            }
            String str9 = aVar.p;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str9);
            }
            String str10 = aVar.q;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str10);
            }
            String b4 = f.b(aVar.r);
            if (b4 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, b4);
            }
            String b5 = d.b(aVar.s);
            if (b5 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, b5);
            }
            supportSQLiteStatement.bindLong(20, aVar.t);
            String str11 = aVar.u;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str11);
            }
            String str12 = aVar.v;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str12);
            }
            String str13 = aVar.w;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str13);
            }
            supportSQLiteStatement.bindLong(24, aVar.x ? 1L : 0L);
            supportSQLiteStatement.bindLong(25, aVar.y);
            String str14 = aVar.z;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str14);
            }
            supportSQLiteStatement.bindLong(27, aVar.A);
            supportSQLiteStatement.bindLong(28, aVar.B ? 1L : 0L);
            String str15 = aVar.C;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str15);
            }
            String str16 = aVar.D;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str16);
            }
            String str17 = aVar.E;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str17);
            }
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<gr4.a> {
        public String createQuery() {
            return "DELETE FROM `t_ad_download` WHERE `download_url` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, gr4.a aVar) {
            String str = aVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }
}
