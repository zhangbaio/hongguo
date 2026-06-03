package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.IMParticipant;
import com.dragon.read.local.db.interfaces.IIMParticipantDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o1 implements IIMParticipantDao {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<IMParticipant> b;
    private final SharedSQLiteStatement c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611700);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public o1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void deleteAllParticipant(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
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
            this.d.release(acquire);
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void insertOrReplaceParticipant(IMParticipant iMParticipant) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(iMParticipant);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void insertOrReplaceParticipant(List<IMParticipant> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public List<IMParticipant> queryAllParticipant(String str) {
        String string;
        String string2;
        String string3;
        String string4;
        Integer valueOf;
        String string5;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_im_participant WHERE conversation_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        String str2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "conversation_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "avatar_uri");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "role");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "is_robot");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = str2;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = str2;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                IMParticipant iMParticipant = new IMParticipant(string, string2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                iMParticipant.setName(string3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow4);
                }
                iMParticipant.setAvatarUri(string4);
                if (query.isNull(columnIndexOrThrow5)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                }
                iMParticipant.setRole(valueOf);
                if (query.isNull(columnIndexOrThrow6)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow6);
                }
                iMParticipant.setDescription(string5);
                iMParticipant.setUpdateTime(query.getLong(columnIndexOrThrow7));
                iMParticipant.setCreateTime(query.getLong(columnIndexOrThrow8));
                if (query.getInt(columnIndexOrThrow9) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                iMParticipant.setRobot(z);
                arrayList.add(iMParticipant);
                str2 = null;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<IMParticipant> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_im_participant` (`conversation_id`,`user_id`,`name`,`avatar_uri`,`role`,`description`,`update_time`,`create_time`,`is_robot`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, IMParticipant iMParticipant) {
            if (iMParticipant.getConversationId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, iMParticipant.getConversationId());
            }
            if (iMParticipant.getUserId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, iMParticipant.getUserId());
            }
            if (iMParticipant.getName() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, iMParticipant.getName());
            }
            if (iMParticipant.getAvatarUri() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, iMParticipant.getAvatarUri());
            }
            if (iMParticipant.getRole() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, iMParticipant.getRole().intValue());
            }
            if (iMParticipant.getDescription() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, iMParticipant.getDescription());
            }
            supportSQLiteStatement.bindLong(7, iMParticipant.getUpdateTime());
            supportSQLiteStatement.bindLong(8, iMParticipant.getCreateTime());
            supportSQLiteStatement.bindLong(9, iMParticipant.isRobot() ? 1L : 0L);
        }
    }

    class b extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_im_participant WHERE conversation_id = ? AND user_id = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_im_participant WHERE conversation_id = ?";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void deleteParticipant(String str, String str2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void deleteParticipant(String str, List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM t_im_participant WHERE conversation_id = ");
        newStringBuilder.append("?");
        newStringBuilder.append(" AND user_id in (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        if (str == null) {
            compileStatement.bindNull(1);
        } else {
            compileStatement.bindString(1, str);
        }
        int i = 2;
        for (String str2 : list) {
            if (str2 == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str2);
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

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public IMParticipant queryParticipant(String str, String str2) {
        String string;
        String string2;
        String string3;
        String string4;
        Integer valueOf;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_im_participant WHERE conversation_id = ? AND user_id = ?", 2);
        boolean z = true;
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        IMParticipant iMParticipant = null;
        String string5 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "conversation_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "avatar_uri");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "role");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "is_robot");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                IMParticipant iMParticipant2 = new IMParticipant(string, string2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                iMParticipant2.setName(string3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow4);
                }
                iMParticipant2.setAvatarUri(string4);
                if (query.isNull(columnIndexOrThrow5)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                }
                iMParticipant2.setRole(valueOf);
                if (!query.isNull(columnIndexOrThrow6)) {
                    string5 = query.getString(columnIndexOrThrow6);
                }
                iMParticipant2.setDescription(string5);
                iMParticipant2.setUpdateTime(query.getLong(columnIndexOrThrow7));
                iMParticipant2.setCreateTime(query.getLong(columnIndexOrThrow8));
                if (query.getInt(columnIndexOrThrow9) == 0) {
                    z = false;
                }
                iMParticipant2.setRobot(z);
                iMParticipant = iMParticipant2;
            }
            return iMParticipant;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public List<IMParticipant> queryParticipant(String str, List<String> list) {
        String string;
        String string2;
        String string3;
        String string4;
        Integer valueOf;
        String string5;
        boolean z;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_im_participant WHERE conversation_id = ");
        newStringBuilder.append("?");
        newStringBuilder.append(" AND user_id in (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        int i = 2;
        for (String str2 : list) {
            if (str2 == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str2);
            }
            i++;
        }
        this.a.assertNotSuspendingTransaction();
        String str3 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "conversation_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "avatar_uri");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "role");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "description");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "update_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "create_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "is_robot");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = str3;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = str3;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                IMParticipant iMParticipant = new IMParticipant(string, string2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                iMParticipant.setName(string3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow4);
                }
                iMParticipant.setAvatarUri(string4);
                if (query.isNull(columnIndexOrThrow5)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                }
                iMParticipant.setRole(valueOf);
                if (query.isNull(columnIndexOrThrow6)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow6);
                }
                iMParticipant.setDescription(string5);
                iMParticipant.setUpdateTime(query.getLong(columnIndexOrThrow7));
                iMParticipant.setCreateTime(query.getLong(columnIndexOrThrow8));
                if (query.getInt(columnIndexOrThrow9) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                iMParticipant.setRobot(z);
                arrayList.add(iMParticipant);
                str3 = null;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
