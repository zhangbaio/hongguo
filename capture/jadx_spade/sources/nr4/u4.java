package nr4;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u4 implements s4 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<wu4.b> b;
    private final EntityInsertionAdapter<wu4.a> c;
    private final EntityDeletionOrUpdateAdapter<wu4.b> d;
    private final SharedSQLiteStatement e;

    static {
        Covode.recordClassIndex(611794);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public u4(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    class a extends EntityInsertionAdapter<wu4.b> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_ugc_video_list_info` (`video_list_id`,`post_title`,`subscribe_time`,`operate_time`,`delete_time`,`is_delete`,`has_sync`) VALUES (?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, wu4.b bVar) {
            String str = bVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = bVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, bVar.c);
            supportSQLiteStatement.bindLong(4, bVar.d);
            supportSQLiteStatement.bindLong(5, bVar.e);
            supportSQLiteStatement.bindLong(6, bVar.f ? 1L : 0L);
            supportSQLiteStatement.bindLong(7, bVar.g ? 1L : 0L);
        }
    }

    class b extends EntityInsertionAdapter<wu4.a> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_ugc_video_info` (`video_list_id`,`series_id`,`series_cover`,`series_title`,`v_index`) VALUES (?,?,?,?,?)";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, wu4.a aVar) {
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
            supportSQLiteStatement.bindLong(5, aVar.e);
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<wu4.b> {
        public String createQuery() {
            return "DELETE FROM `t_ugc_video_list_info` WHERE `video_list_id` = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, wu4.b bVar) {
            String str = bVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class d extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_ugc_video_info WHERE video_list_id IN (?)";
        }

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
