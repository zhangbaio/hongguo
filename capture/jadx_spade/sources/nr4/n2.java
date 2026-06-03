package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n2 implements m2 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.r0> b;
    private final SharedSQLiteStatement c;

    static {
        Covode.recordClassIndex(611730);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // nr4.m2
    public List<lr4.r0> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        String string9;
        String string10;
        String string11;
        int i3;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM reader_font_config order by `order`", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "reader_font_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "font_title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "file_size");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "file_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "font_pic");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "bold_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "regular_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "font_family");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "regular_file_name");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "download_onlaunch");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "hidden_inreader");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "font_vip_type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "is_new_font");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_variable_font");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "medium_file_name");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "bold_file_name");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "medium_name");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "order");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "fanti_font_pic");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "ui_key");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.r0 r0Var = new lr4.r0();
                    ArrayList arrayList2 = arrayList;
                    r0Var.a = query.getInt(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    r0Var.b = string;
                    if (query.isNull(columnIndexOrThrow3)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    r0Var.c = string2;
                    if (query.isNull(columnIndexOrThrow4)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow4);
                    }
                    r0Var.d = string3;
                    if (query.isNull(columnIndexOrThrow5)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow5);
                    }
                    r0Var.e = string4;
                    if (query.isNull(columnIndexOrThrow6)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow6);
                    }
                    r0Var.f = string5;
                    if (query.isNull(columnIndexOrThrow7)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow7);
                    }
                    r0Var.g = string6;
                    if (query.isNull(columnIndexOrThrow8)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow8);
                    }
                    r0Var.h = string7;
                    if (query.isNull(columnIndexOrThrow9)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow9);
                    }
                    r0Var.i = string8;
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    r0Var.j = z;
                    if (query.getInt(columnIndexOrThrow11) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    r0Var.k = z2;
                    r0Var.l = query.getInt(columnIndexOrThrow12);
                    if (query.getInt(columnIndexOrThrow13) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    r0Var.m = z3;
                    int i5 = i4;
                    if (query.getInt(i5) != 0) {
                        i = columnIndexOrThrow;
                        z4 = true;
                    } else {
                        i = columnIndexOrThrow;
                        z4 = false;
                    }
                    r0Var.n = z4;
                    int i6 = columnIndexOrThrow15;
                    if (query.isNull(i6)) {
                        i2 = i6;
                        string9 = null;
                    } else {
                        i2 = i6;
                        string9 = query.getString(i6);
                    }
                    r0Var.o = string9;
                    int i7 = columnIndexOrThrow16;
                    if (query.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string10 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string10 = query.getString(i7);
                    }
                    r0Var.p = string10;
                    int i8 = columnIndexOrThrow17;
                    if (query.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string11 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string11 = query.getString(i8);
                    }
                    r0Var.q = string11;
                    int i9 = columnIndexOrThrow12;
                    int i10 = columnIndexOrThrow18;
                    r0Var.r = query.getInt(i10);
                    int i11 = columnIndexOrThrow19;
                    if (query.isNull(i11)) {
                        i3 = i10;
                        string12 = null;
                    } else {
                        i3 = i10;
                        string12 = query.getString(i11);
                    }
                    r0Var.s = string12;
                    int i12 = columnIndexOrThrow20;
                    if (query.isNull(i12)) {
                        columnIndexOrThrow20 = i12;
                        string13 = null;
                    } else {
                        columnIndexOrThrow20 = i12;
                        string13 = query.getString(i12);
                    }
                    r0Var.t = string13;
                    arrayList2.add(r0Var);
                    columnIndexOrThrow18 = i3;
                    columnIndexOrThrow19 = i11;
                    columnIndexOrThrow12 = i9;
                    columnIndexOrThrow15 = i2;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i;
                    i4 = i5;
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

    public n2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    @Override // nr4.m2
    public Long[] b(List<lr4.r0> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(list);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    class a extends EntityInsertionAdapter<lr4.r0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `reader_font_config` (`reader_font_id`,`font_title`,`file_size`,`file_url`,`font_pic`,`bold_name`,`regular_name`,`font_family`,`regular_file_name`,`download_onlaunch`,`hidden_inreader`,`font_vip_type`,`is_new_font`,`is_variable_font`,`medium_file_name`,`bold_file_name`,`medium_name`,`order`,`fanti_font_pic`,`ui_key`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.r0 r0Var) {
            supportSQLiteStatement.bindLong(1, r0Var.a);
            String str = r0Var.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            String str2 = r0Var.c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = r0Var.d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = r0Var.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            String str5 = r0Var.f;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str5);
            }
            String str6 = r0Var.g;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str6);
            }
            String str7 = r0Var.h;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str7);
            }
            String str8 = r0Var.i;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str8);
            }
            supportSQLiteStatement.bindLong(10, r0Var.j ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, r0Var.k ? 1L : 0L);
            supportSQLiteStatement.bindLong(12, r0Var.l);
            supportSQLiteStatement.bindLong(13, r0Var.m ? 1L : 0L);
            supportSQLiteStatement.bindLong(14, r0Var.n ? 1L : 0L);
            String str9 = r0Var.o;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str9);
            }
            String str10 = r0Var.p;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str10);
            }
            String str11 = r0Var.q;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str11);
            }
            supportSQLiteStatement.bindLong(18, r0Var.r);
            String str12 = r0Var.s;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str12);
            }
            String str13 = r0Var.t;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str13);
            }
        }
    }

    class b extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM reader_font_config";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
