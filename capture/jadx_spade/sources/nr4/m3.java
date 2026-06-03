package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import readersaas.com.dragon.read.saas.rpc.model.GenreTypeEnum;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m3 implements j3 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.c1> b;

    static {
        Covode.recordClassIndex(611760);
    }

    public static List<Class<?>> p() {
        return Collections.emptyList();
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[GenreTypeEnum.values().length];
            b = iArr;
            try {
                iArr[GenreTypeEnum.NOVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GenreTypeEnum.AUDIOBOOK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GenreTypeEnum.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GenreTypeEnum.COMIC_GENRE_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GenreTypeEnum.OTHER_GENRE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GenreTypeEnum.VIDEO_GENRE_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GenreTypeEnum.MAGAZINE_GENRE_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GenreTypeEnum.PUBLISH_GENRE_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[GenreTypeEnum.CONTE_GENRE_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[GenreTypeEnum.STORY_GENRE_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[GenreTypeEnum.DIALOGUE_GENRE_TYPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[GenreTypeEnum.DOUYIN_VIDEO.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[GenreTypeEnum.PRODUCT_GENRE_TYPE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[GenreTypeEnum.NOVEL_STORY_GENRE_TYPE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[GenreTypeEnum.CP_SHORT_PLAY_GENRE_TYPE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[GenreTypeEnum.ANCIENTBOOK_GENRE_TYPE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[GenreTypeEnum.UNCOPYRIGHTED_PUBLISH_GENRE_TYPE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[GenreTypeEnum.STORY_ALBUM_GENRE_TYPE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[BookType.values().length];
            a = iArr2;
            try {
                iArr2[BookType.READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[BookType.LISTEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[BookType.SHORT_SERIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    @Override // nr4.j3
    public List<lr4.c1> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        int i;
        String string5;
        m3 m3Var = this;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_recent_book_read_progress ", 0);
        m3Var.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(m3Var.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "create_timestamp_ms");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "page_index");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "total_chapter_count_progress_rate");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "ms_timestamp");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "short_story_pager_progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "start_container_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "chapter_recent_read_progress_rate");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "chapter_show_read_progress_rate");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_page_progress");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "update_state");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "duration");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "start_time");
                int i2 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.c1 c1Var = new lr4.c1();
                    int i3 = columnIndexOrThrow11;
                    int i4 = columnIndexOrThrow12;
                    c1Var.a = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    c1Var.h(string);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    c1Var.k(string2);
                    c1Var.d = query.getInt(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    c1Var.o(string3);
                    c1Var.f = query.getInt(columnIndexOrThrow6);
                    c1Var.g = query.getFloat(columnIndexOrThrow7);
                    c1Var.j(m3Var.k(query.getString(columnIndexOrThrow8)));
                    c1Var.i = query.getLong(columnIndexOrThrow9);
                    c1Var.j = query.getFloat(columnIndexOrThrow10);
                    columnIndexOrThrow11 = i3;
                    c1Var.k = query.getInt(columnIndexOrThrow11);
                    int i5 = columnIndexOrThrow;
                    columnIndexOrThrow12 = i4;
                    c1Var.l = query.getInt(columnIndexOrThrow12);
                    int i6 = i2;
                    int i7 = columnIndexOrThrow2;
                    c1Var.m = query.getInt(i6);
                    int i8 = columnIndexOrThrow14;
                    c1Var.n = query.getInt(i8);
                    int i9 = columnIndexOrThrow15;
                    c1Var.o = query.getInt(i9);
                    int i10 = columnIndexOrThrow16;
                    c1Var.q(m3Var.m(query.getString(i10)));
                    int i11 = columnIndexOrThrow17;
                    int i12 = columnIndexOrThrow3;
                    c1Var.q = query.getLong(i11);
                    int i13 = columnIndexOrThrow18;
                    if (query.isNull(i13)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(i13);
                    }
                    c1Var.m(string4);
                    int i14 = columnIndexOrThrow19;
                    if (query.isNull(i14)) {
                        i = i11;
                        string5 = null;
                    } else {
                        i = i11;
                        string5 = query.getString(i14);
                    }
                    c1Var.n(string5);
                    columnIndexOrThrow18 = i13;
                    int i15 = columnIndexOrThrow20;
                    c1Var.t = query.getDouble(i15);
                    int i16 = columnIndexOrThrow21;
                    c1Var.u = query.getInt(i16);
                    int i17 = columnIndexOrThrow22;
                    c1Var.v = query.getLong(i17);
                    columnIndexOrThrow22 = i17;
                    int i18 = columnIndexOrThrow23;
                    c1Var.w = query.getLong(i18);
                    columnIndexOrThrow23 = i18;
                    int i19 = columnIndexOrThrow24;
                    c1Var.x = query.getLong(i19);
                    columnIndexOrThrow24 = i19;
                    int i20 = columnIndexOrThrow25;
                    c1Var.y = query.getLong(i20);
                    arrayList.add(c1Var);
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow3 = i12;
                    columnIndexOrThrow17 = i;
                    columnIndexOrThrow19 = i14;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow2 = i7;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow21 = i16;
                    i2 = i6;
                    columnIndexOrThrow14 = i8;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i10;
                    m3Var = this;
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

    public m3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(BookType bookType) {
        if (bookType == null) {
            return null;
        }
        int i = b.a[bookType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "SHORT_SERIES";
                }
                throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + bookType);
            }
            return "LISTEN";
        }
        return "READ";
    }

    @Override // nr4.j
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Long[] h(lr4.c1... c1VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(c1VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    private BookType k(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "LISTEN":
                return BookType.LISTEN;
            case "SHORT_SERIES":
                return BookType.SHORT_SERIES;
            case "READ":
                return BookType.READ;
            default:
                throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(GenreTypeEnum genreTypeEnum) {
        if (genreTypeEnum == null) {
            return null;
        }
        switch (b.b[genreTypeEnum.ordinal()]) {
            case 1:
                return "NOVEL";
            case 2:
                return "AUDIOBOOK";
            case 3:
                return "AUDIO";
            case 4:
                return "COMIC_GENRE_TYPE";
            case 5:
                return "OTHER_GENRE_TYPE";
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return "VIDEO_GENRE_TYPE";
            case 7:
                return "MAGAZINE_GENRE_TYPE";
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return "PUBLISH_GENRE_TYPE";
            case 9:
                return "CONTE_GENRE_TYPE";
            case 10:
                return "STORY_GENRE_TYPE";
            case 11:
                return "DIALOGUE_GENRE_TYPE";
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return "DOUYIN_VIDEO";
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return "PRODUCT_GENRE_TYPE";
            case 14:
                return "NOVEL_STORY_GENRE_TYPE";
            case 15:
                return "CP_SHORT_PLAY_GENRE_TYPE";
            case 16:
                return "ANCIENTBOOK_GENRE_TYPE";
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return "UNCOPYRIGHTED_PUBLISH_GENRE_TYPE";
            case 18:
                return "STORY_ALBUM_GENRE_TYPE";
            default:
                throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + genreTypeEnum);
        }
    }

    private GenreTypeEnum m(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "ANCIENTBOOK_GENRE_TYPE":
                return GenreTypeEnum.ANCIENTBOOK_GENRE_TYPE;
            case "AUDIOBOOK":
                return GenreTypeEnum.AUDIOBOOK;
            case "PRODUCT_GENRE_TYPE":
                return GenreTypeEnum.PRODUCT_GENRE_TYPE;
            case "COMIC_GENRE_TYPE":
                return GenreTypeEnum.COMIC_GENRE_TYPE;
            case "DIALOGUE_GENRE_TYPE":
                return GenreTypeEnum.DIALOGUE_GENRE_TYPE;
            case "NOVEL_STORY_GENRE_TYPE":
                return GenreTypeEnum.NOVEL_STORY_GENRE_TYPE;
            case "CONTE_GENRE_TYPE":
                return GenreTypeEnum.CONTE_GENRE_TYPE;
            case "PUBLISH_GENRE_TYPE":
                return GenreTypeEnum.PUBLISH_GENRE_TYPE;
            case "AUDIO":
                return GenreTypeEnum.AUDIO;
            case "NOVEL":
                return GenreTypeEnum.NOVEL;
            case "DOUYIN_VIDEO":
                return GenreTypeEnum.DOUYIN_VIDEO;
            case "VIDEO_GENRE_TYPE":
                return GenreTypeEnum.VIDEO_GENRE_TYPE;
            case "STORY_ALBUM_GENRE_TYPE":
                return GenreTypeEnum.STORY_ALBUM_GENRE_TYPE;
            case "UNCOPYRIGHTED_PUBLISH_GENRE_TYPE":
                return GenreTypeEnum.UNCOPYRIGHTED_PUBLISH_GENRE_TYPE;
            case "MAGAZINE_GENRE_TYPE":
                return GenreTypeEnum.MAGAZINE_GENRE_TYPE;
            case "CP_SHORT_PLAY_GENRE_TYPE":
                return GenreTypeEnum.CP_SHORT_PLAY_GENRE_TYPE;
            case "OTHER_GENRE_TYPE":
                return GenreTypeEnum.OTHER_GENRE_TYPE;
            case "STORY_GENRE_TYPE":
                return GenreTypeEnum.STORY_GENRE_TYPE;
            default:
                throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + str);
        }
    }

    @Override // nr4.j3
    public lr4.c1 f(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.c1 c1Var;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_recent_book_read_progress WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "create_timestamp_ms");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "page_index");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "total_chapter_count_progress_rate");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "ms_timestamp");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "short_story_pager_progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "start_container_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "chapter_recent_read_progress_rate");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "chapter_show_read_progress_rate");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_page_progress");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "update_state");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "duration");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "start_time");
                if (query.moveToFirst()) {
                    lr4.c1 c1Var2 = new lr4.c1();
                    c1Var2.a = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    c1Var2.h(string);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    c1Var2.k(string2);
                    c1Var2.d = query.getInt(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    c1Var2.o(string3);
                    c1Var2.f = query.getInt(columnIndexOrThrow6);
                    c1Var2.g = query.getFloat(columnIndexOrThrow7);
                    c1Var2.j(k(query.getString(columnIndexOrThrow8)));
                    c1Var2.i = query.getLong(columnIndexOrThrow9);
                    c1Var2.j = query.getFloat(columnIndexOrThrow10);
                    c1Var2.k = query.getInt(columnIndexOrThrow11);
                    c1Var2.l = query.getInt(columnIndexOrThrow12);
                    c1Var2.m = query.getInt(columnIndexOrThrow13);
                    c1Var2.n = query.getInt(columnIndexOrThrow14);
                    c1Var2.o = query.getInt(columnIndexOrThrow15);
                    c1Var2.q(m(query.getString(columnIndexOrThrow16)));
                    c1Var2.q = query.getLong(columnIndexOrThrow17);
                    if (query.isNull(columnIndexOrThrow18)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow18);
                    }
                    c1Var2.m(string4);
                    if (query.isNull(columnIndexOrThrow19)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow19);
                    }
                    c1Var2.n(string5);
                    c1Var2.t = query.getDouble(columnIndexOrThrow20);
                    c1Var2.u = query.getInt(columnIndexOrThrow21);
                    c1Var2.v = query.getLong(columnIndexOrThrow22);
                    c1Var2.w = query.getLong(columnIndexOrThrow23);
                    c1Var2.x = query.getLong(columnIndexOrThrow24);
                    c1Var2.y = query.getLong(columnIndexOrThrow25);
                    c1Var = c1Var2;
                } else {
                    c1Var = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return c1Var;
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

    @Override // nr4.j3
    public List<lr4.c1> g(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        int i;
        String string5;
        m3 m3Var = this;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_recent_book_read_progress WHERE book_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        m3Var.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(m3Var.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "create_timestamp_ms");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "page_index");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "total_chapter_count_progress_rate");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "book_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "ms_timestamp");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "short_story_pager_progress_rate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "start_container_index");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "tone_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "chapter_recent_read_progress_rate");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "chapter_show_read_progress_rate");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "book_page_progress");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "update_state");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "cur_channel_id");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "duration");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "start_time");
                int i3 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    lr4.c1 c1Var = new lr4.c1();
                    int i4 = columnIndexOrThrow11;
                    int i5 = columnIndexOrThrow12;
                    c1Var.a = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    c1Var.h(string);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    c1Var.k(string2);
                    c1Var.d = query.getInt(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow5);
                    }
                    c1Var.o(string3);
                    c1Var.f = query.getInt(columnIndexOrThrow6);
                    c1Var.g = query.getFloat(columnIndexOrThrow7);
                    c1Var.j(m3Var.k(query.getString(columnIndexOrThrow8)));
                    c1Var.i = query.getLong(columnIndexOrThrow9);
                    c1Var.j = query.getFloat(columnIndexOrThrow10);
                    columnIndexOrThrow11 = i4;
                    c1Var.k = query.getInt(columnIndexOrThrow11);
                    int i6 = columnIndexOrThrow;
                    columnIndexOrThrow12 = i5;
                    c1Var.l = query.getInt(columnIndexOrThrow12);
                    int i7 = i3;
                    int i8 = columnIndexOrThrow2;
                    c1Var.m = query.getInt(i7);
                    int i9 = columnIndexOrThrow14;
                    c1Var.n = query.getInt(i9);
                    int i10 = columnIndexOrThrow15;
                    c1Var.o = query.getInt(i10);
                    int i11 = columnIndexOrThrow16;
                    c1Var.q(m3Var.m(query.getString(i11)));
                    int i12 = columnIndexOrThrow17;
                    int i13 = columnIndexOrThrow3;
                    c1Var.q = query.getLong(i12);
                    int i14 = columnIndexOrThrow18;
                    if (query.isNull(i14)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(i14);
                    }
                    c1Var.m(string4);
                    int i15 = columnIndexOrThrow19;
                    if (query.isNull(i15)) {
                        i = i12;
                        string5 = null;
                    } else {
                        i = i12;
                        string5 = query.getString(i15);
                    }
                    c1Var.n(string5);
                    columnIndexOrThrow18 = i14;
                    int i16 = columnIndexOrThrow20;
                    c1Var.t = query.getDouble(i16);
                    int i17 = columnIndexOrThrow21;
                    c1Var.u = query.getInt(i17);
                    int i18 = columnIndexOrThrow22;
                    c1Var.v = query.getLong(i18);
                    columnIndexOrThrow22 = i18;
                    int i19 = columnIndexOrThrow23;
                    c1Var.w = query.getLong(i19);
                    columnIndexOrThrow23 = i19;
                    int i20 = columnIndexOrThrow24;
                    c1Var.x = query.getLong(i20);
                    columnIndexOrThrow24 = i20;
                    int i21 = columnIndexOrThrow25;
                    c1Var.y = query.getLong(i21);
                    arrayList.add(c1Var);
                    columnIndexOrThrow25 = i21;
                    columnIndexOrThrow3 = i13;
                    columnIndexOrThrow17 = i;
                    columnIndexOrThrow19 = i15;
                    columnIndexOrThrow20 = i16;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow21 = i17;
                    i3 = i7;
                    columnIndexOrThrow14 = i9;
                    columnIndexOrThrow15 = i10;
                    columnIndexOrThrow16 = i11;
                    m3Var = this;
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

    class a extends EntityInsertionAdapter<lr4.c1> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_recent_book_read_progress` (`create_timestamp_ms`,`book_id`,`chapter_id`,`chapter_index`,`chapter_title`,`page_index`,`total_chapter_count_progress_rate`,`book_type`,`ms_timestamp`,`short_story_pager_progress_rate`,`paragraph_id`,`line_in_paragraph_offset`,`start_container_index`,`start_element_index`,`start_element_offset`,`genre_type`,`tone_id`,`chapter_recent_read_progress_rate`,`chapter_show_read_progress_rate`,`book_page_progress`,`update_state`,`channel_id`,`cur_channel_id`,`duration`,`start_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.c1 c1Var) {
            supportSQLiteStatement.bindLong(1, c1Var.a);
            String str = c1Var.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            String str2 = c1Var.c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            supportSQLiteStatement.bindLong(4, c1Var.d);
            String str3 = c1Var.e;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str3);
            }
            supportSQLiteStatement.bindLong(6, c1Var.f);
            supportSQLiteStatement.bindDouble(7, c1Var.g);
            BookType bookType = c1Var.h;
            if (bookType == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, m3.this.j(bookType));
            }
            supportSQLiteStatement.bindLong(9, c1Var.i);
            supportSQLiteStatement.bindDouble(10, c1Var.j);
            supportSQLiteStatement.bindLong(11, c1Var.k);
            supportSQLiteStatement.bindLong(12, c1Var.l);
            supportSQLiteStatement.bindLong(13, c1Var.m);
            supportSQLiteStatement.bindLong(14, c1Var.n);
            supportSQLiteStatement.bindLong(15, c1Var.o);
            GenreTypeEnum genreTypeEnum = c1Var.p;
            if (genreTypeEnum == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, m3.this.l(genreTypeEnum));
            }
            supportSQLiteStatement.bindLong(17, c1Var.q);
            String str4 = c1Var.r;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str4);
            }
            String str5 = c1Var.s;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str5);
            }
            supportSQLiteStatement.bindDouble(20, c1Var.t);
            supportSQLiteStatement.bindLong(21, c1Var.u);
            supportSQLiteStatement.bindLong(22, c1Var.v);
            supportSQLiteStatement.bindLong(23, c1Var.w);
            supportSQLiteStatement.bindLong(24, c1Var.x);
            supportSQLiteStatement.bindLong(25, c1Var.y);
        }
    }
}
