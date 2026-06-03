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

@Serializable(with = m4.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ReaderApiERR {
    SUCCESS(0),
    FAST_REJECT(100),
    ILLEGAL_ACCESS(110),
    HIT_VERIFY_CODE(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    APP_REJECT(112),
    PARAM_INVALID(101003),
    USER_NO_PERMISSION(101009),
    CHAPTER_DATA_GET_ERROR(101005),
    PERMISSION_SERVICE_ERROR(101006),
    PACK_SERVICE_ERROR(101007),
    SMART_PLAYER_SERVICE_ERROR(101008),
    CALL_SERVICE_FAIL(101013),
    ARTICLE_NOT_FOUND_ERROR(101001),
    NOVEL_DATA_GET_ERROR(101002),
    BOOK_NOT_EXIST_ERROR(101004),
    PACK_NO_VID(101010),
    SAFE_BOOK_NULL(101011),
    RECOMMEND_FAIL(101012),
    PACKAGE_TOO_BIG_ERROR(101014),
    SYSTEM_ERROR(101015),
    CACHE_ERROR(101016),
    CONTENT_VERIFYING(101017),
    NOT_SHOW_ADVERTISEMENT(101018),
    NO_THIS_TONE(101019),
    PLAY_URL_OUTTIME(101020),
    BOOK_FULLLY_REMOVE(101021),
    COMMENT_GET_ERROR(101022),
    COMMENT_CREATE_ERROR(101023),
    COMMENT_DEL_ERROR(101024),
    COMMENT_UPDATE_ERROR(101025),
    REPLY_GET_ERROR(101026),
    REPLY_DEL_ERROR(101027),
    DIGG_DEL_ERROR(101028),
    DIGG_ADD_ERROR(101029),
    USER_NOT_LOGIN(101030),
    COMMENT_HAS_DEL(101031),
    SHARE_CODE_NOT_VALID(101032),
    TOO_FREQUENT_ERROR(101033),
    TOO_MANY_STREAM_TASK(101040),
    AUDIO_SYNC_NOT_SUPPORT(101041),
    AUDIO_SYNC_NOT_READY(101042),
    AUDIO_NOT_SUPPORT_DOWNLOAD(101043),
    AUDIO_TONE_REOMVE(101044),
    QUERY_CHAPTER_LOCK_ERROR(101045),
    EMPTY_DICTIONARY_RESULT_ERROR(101046),
    DICTIONARY_NOT_SECURE_ERROR(101047),
    TTS_NO_AVAILABLE_TIMEPOINT_DATA(101048),
    TTS_MAY_HASNT_PRODUCT(101049);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610594);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ReaderApiERR> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) ReaderApiERR.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610593);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.ReaderApiERR$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return m4.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    ReaderApiERR(int i) {
        this.value = i;
    }
}
