package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = t.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookApiERR {
    SUCCESS(0),
    FAST_REJECT(100),
    ALL_CONTENT_SHOWN(101),
    ILLEGAL_ACCESS(110),
    HIT_VERIFY_CODE(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    APP_REJECT(112),
    REQ_ID_GET_ERROR(101101),
    OUT_OF_MAX_LIMIT_ERROR(101102),
    DIRECTORY_GET_ERROR(101103),
    BOOK_NOT_EXIST_ERROR(101104),
    PARAM_INVALID(100103),
    BOOKSHELF_ADD_ERROR(101105),
    BOOKSHELF_CHECK_ERROR(101106),
    BOOKSHELF_DELETE_ERROR(101107),
    USER_NOT_LOGIN(101108),
    BOOK_REMOVE(101109),
    READ_HISTORY_UPLOAD_ERROR(101110),
    READ_HISTORY_DELETE_ERROR(101111),
    READ_HISTORY_GET_ERROR(101112),
    CHAPTER_INFO_GET_ERROR(101113),
    PACK_SERVICE_ERROR(101114),
    PERMISSION_NOT_SATISFIED(101115),
    SERVICE_ERROR(101116),
    ERR_ARTICLE_SERVICE_ERROR(101117),
    BOOKSHELF_ADD_TOO_MUCH(101118),
    BOOKSHELF_GET_ERROR(101119),
    BOOKLIST_NAME_DUPLICATE(101120),
    BOOK_FULLLY_REMOVE(101121),
    SHARE_CODE_NOT_VALID(101122),
    NOT_AUTHORIZED(101123),
    SSTIMOR_EMPTY_ERROR(101124),
    BOOKSHELF_TOPPING_DATA_EXPIRE(101130),
    TRANSFER_LINE_POSITION_ERROR(101131),
    PANIC(101132),
    ITEM_UNLOCK_SET_ERROR(101133),
    BOOKSHELF_ASTERISK_ERROR(101134),
    SMART_PLAYER_SERVICE_ERROR(101135),
    PLAY_URL_OUTTIME(101136),
    CONTENT_VERIFYING(101137),
    TOO_MANY_STREAM_TASK(101138),
    NO_THIS_TONE(101139),
    QUERY_CHAPTER_LOCK_ERROR(101140),
    VIDEO_NO_PERMISSION(101141),
    USER_NO_PERMISSION(101009),
    USER_INPUT_INVALID(101142),
    FREQUENCY_BLOCK(101143),
    HIT_SHARK_RULE(101144);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609793);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BookApiERR> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) BookApiERR.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609792);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.BookApiERR$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return t.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    BookApiERR(int i) {
        this.value = i;
    }
}
