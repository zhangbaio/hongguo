package fo4;

import android.content.Context;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.cj0;
import com.dragon.read.base.share2.model.ShareEntrance;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsShareProxy;
import com.dragon.read.component.shortvideo.api.BSOpenProfilePageService;
import com.dragon.read.kmp.compose.common.list.k;
import com.dragon.read.kmp.shortvideo.distribution.config.KmpSeriesVideoRankConfig;
import com.dragon.read.kmp.utils.n0;
import com.dragon.read.kmp.utils.v;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import com.dragon.read.rpc.model.ActorBasic;
import com.dragon.read.rpc.model.ActorInfo;
import com.dragon.read.rpc.model.GetUserVotingRecordRequest;
import com.dragon.read.rpc.model.GetUserVotingRecordResponse;
import com.dragon.read.rpc.model.RankItemBasic;
import com.dragon.read.rpc.model.RankItemInfo;
import com.dragon.read.rpc.model.StatDetail;
import com.dragon.read.rpc.model.UserVoteDetail;
import com.dragon.read.rpc.model.UserVotingRecord;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.kotlin.ContextKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io4.f;
import io4.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import pr3.n;
import pr3.q;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements lo4.a {
    private final String a = "RankListDependImpl";

    static {
        Covode.recordClassIndex(609014);
    }

    @Override // lo4.a
    public void c() {
        NsShareProxy.INSTANCE.clearHongguoActivityListShareCache("521");
    }

    @Override // lo4.a
    public Map<String, String> h() {
        Map<String, String> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @Override // lo4.a
    public boolean d() {
        return NsShareProxy.INSTANCE.checkShareEnable(ShareEntrance.TOP_LIST_SHARE_BUTTON, (Object) null);
    }

    @Override // lo4.a
    public k a() {
        KmpSeriesVideoRankConfig a = KmpSeriesVideoRankConfig.a.a();
        if (a.customFlingBehavior) {
            return new k(true, a.firstGlobalFlingFactor, a.firstFlingFactor, a.flingFactor, a.useNewFlingBehavior);
        }
        return null;
    }

    private final JsonObject w(String str) {
        JsonObject g = v.a.g(str);
        if (g instanceof JsonObject) {
            return g;
        }
        return null;
    }

    @Override // lo4.a
    public void b(io4.b distributeModel) {
        Intrinsics.checkNotNullParameter(distributeModel, "distributeModel");
        Pair<String, JsonObject> q = q(distributeModel);
        if (q == null) {
            return;
        }
        NsShareProxy.INSTANCE.preloadHongguoActivityListShare(q.getFirst(), q.getSecond());
    }

    private final Pair<String, JsonObject> q(io4.b bVar) {
        boolean z;
        String a = io4.c.a(bVar);
        JsonObject o = o(bVar);
        if (a != null && a.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            LogWrapper.info(this.a, "activityId is empty or null", new Object[0]);
            return null;
        }
        if (o == null) {
            LogWrapper.info(this.a, "posterData is empty or null", new Object[0]);
            return null;
        }
        return TuplesKt.to(a, o);
    }

    @Override // lo4.a
    public Observable<List<f>> e(String activityId) {
        boolean z;
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        if (activityId.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        GetUserVotingRecordRequest getUserVotingRecordRequest = new GetUserVotingRecordRequest();
        getUserVotingRecordRequest.activityId = activityId;
        Observable subscribeOn = g65.a.b(getUserVotingRecordRequest).subscribeOn(Schedulers.io());
        final Function1 function1 = new Function1() { // from class: fo4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List r;
                r = c.r(c.this, (GetUserVotingRecordResponse) obj);
                return r;
            }
        };
        return subscribeOn.map(new Function() { // from class: fo4.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List s;
                s = c.s(Function1.this, obj);
                return s;
            }
        });
    }

    @Override // lo4.a
    public void k(io4.b distributeModel) {
        Intrinsics.checkNotNullParameter(distributeModel, "distributeModel");
        Pair<String, JsonObject> q = q(distributeModel);
        if (q == null) {
            ToastUtils.showCommonToastSafely("暂不支持分享");
        } else {
            NsShareProxy.INSTANCE.showHongguoActivityListSharePanel(q.getFirst(), q.getSecond());
        }
    }

    private final f x(UserVotingRecord userVotingRecord) {
        RankItemBasic rankItemBasic;
        ActorInfo actorInfo;
        ActorBasic actorBasic;
        String str;
        boolean z;
        StatDetail statDetail;
        String str2;
        String str3;
        Long l;
        String str4;
        String str5;
        String str6;
        RankItemInfo rankItemInfo = userVotingRecord.rankItemInfo;
        String str7 = null;
        if (rankItemInfo == null || (rankItemBasic = rankItemInfo.rankItemBasic) == null || (actorInfo = rankItemInfo.actorInfo) == null || (actorBasic = actorInfo.actorBasic) == null || (str = rankItemBasic.id) == null) {
            return null;
        }
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        UserVoteDetail userVoteDetail = userVotingRecord.voteDetail;
        if (userVoteDetail != null) {
            statDetail = userVoteDetail.yesterdayVoteCount;
        } else {
            statDetail = null;
        }
        String str8 = actorBasic.name;
        if (str8 == null) {
            str8 = "";
        }
        String str9 = actorBasic.avatar;
        if (str9 == null) {
            str9 = "";
        }
        int i = rankItemBasic.index;
        boolean z2 = rankItemBasic.isShortlisted;
        if (statDetail != null) {
            str2 = statDetail.name;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if (statDetail != null) {
            l = Long.valueOf(statDetail.count);
        } else {
            l = null;
        }
        UserVoteDetail userVoteDetail2 = userVotingRecord.voteDetail;
        if (userVoteDetail2 != null) {
            str4 = userVoteDetail2.countIcon;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        if (userVoteDetail2 != null) {
            str7 = userVoteDetail2.darkCountIcon;
        }
        if (str7 == null) {
            str6 = "";
        } else {
            str6 = str7;
        }
        return new f(str, str8, str9, i, z2, str3, l, str5, str6);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[Catch: Exception -> 0x0053, TRY_LEAVE, TryCatch #0 {Exception -> 0x0053, blocks: (B:23:0x0028, B:25:0x003f, B:31:0x004c), top: B:22:0x0028 }] */
    @Override // lo4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(java.util.List<? extends io4.d> r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            if (r9 == 0) goto Lb9
            java.util.Iterator r9 = r9.iterator()
        Lc:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto Lb9
            java.lang.Object r2 = r9.next()
            io4.d r2 = (io4.d) r2
            boolean r3 = r2 instanceof io4.g
            if (r3 == 0) goto Lc
            io4.g r2 = (io4.g) r2
            com.bytedance.kmp.reading.model.om0 r2 = r2.getVideoData()
            com.dragon.read.kmp.utils.x r3 = com.dragon.read.kmp.utils.x.a
            r3 = 0
            if (r2 != 0) goto L28
            goto L78
        L28:
            com.dragon.read.kmp.utils.v r4 = com.dragon.read.kmp.utils.v.a     // Catch: java.lang.Exception -> L53
            gn6.a r4 = com.dragon.read.kmp.base.h.c()     // Catch: java.lang.Exception -> L53
            r4.getSerializersModule()     // Catch: java.lang.Exception -> L53
            com.bytedance.kmp.reading.model.om0$b r5 = com.bytedance.kmp.reading.model.om0.Companion     // Catch: java.lang.Exception -> L53
            kotlinx.serialization.KSerializer r5 = r5.serializer()     // Catch: java.lang.Exception -> L53
            kotlinx.serialization.SerializationStrategy r5 = (kotlinx.serialization.SerializationStrategy) r5     // Catch: java.lang.Exception -> L53
            java.lang.String r4 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L53
            if (r4 == 0) goto L48
            int r5 = r4.length()     // Catch: java.lang.Exception -> L53
            if (r5 != 0) goto L46
            goto L48
        L46:
            r5 = 0
            goto L49
        L48:
            r5 = 1
        L49:
            if (r5 == 0) goto L4c
            goto L78
        L4c:
            java.lang.Class<com.dragon.read.rpc.model.VideoData> r5 = com.dragon.read.rpc.model.VideoData.class
            java.lang.Object r3 = com.dragon.read.base.util.JSONUtils.fromJson(r4, r5)     // Catch: java.lang.Exception -> L53
            goto L78
        L53:
            r4 = move-exception
            com.dragon.read.kmp.utils.q r5 = com.dragon.read.kmp.utils.q.a
            boolean r5 = r5.a()
            if (r5 != 0) goto L9a
            com.dragon.read.kmp.j r5 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "convertKmpToAndroidData,error = "
            r6.append(r7)
            java.lang.String r4 = r4.getMessage()
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "KmpDataConvertUtil"
            r5.d(r6, r4)
        L78:
            com.dragon.read.rpc.model.VideoData r3 = (com.dragon.read.rpc.model.VideoData) r3
            com.dragon.read.pages.bookmall.model.VideoTabModel$VideoData r3 = com.dragon.read.pages.bookmall.model.VideoTabModel.VideoData.parseVideoData(r3)
            java.lang.String r4 = "parseVideoData(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            if (r2 == 0) goto Lc
            java.lang.String r2 = r3.getSeriesId()
            boolean r2 = com.dragon.read.util.kotlin.StringKt.isNotNullOrEmpty(r2)
            if (r2 == 0) goto Lc
            a54.f r2 = a54.f.a
            pr3.q r2 = r2.a(r3)
            r8.p(r0, r3, r2)
            goto Lc
        L9a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "convertKmpToAndroidData data:"
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = ", error:"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        Lb9:
            java.lang.String r9 = r8.a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "prefetchVideoDetail prefetchList:"
            r2.append(r3)
            int r3 = r0.size()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.dragon.read.base.util.LogWrapper.info(r9, r2, r1)
            com.dragon.read.component.shortvideo.api.NsShortVideoApi r9 = com.dragon.read.component.shortvideo.api.NsShortVideoApi.IMPL
            r9.enqueue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fo4.c.i(java.util.List):void");
    }

    private final JsonObject o(io4.b bVar) {
        JsonObject w;
        String u;
        String str;
        String str2;
        String str3;
        String u2;
        String str4 = bVar.f;
        if (str4 != null) {
            if (!(!StringsKt__StringsKt.isBlank(str4))) {
                str4 = null;
            }
            if (str4 != null && (w = w(str4)) != null && (u = u(w, "rank_list_date")) != null) {
                String str5 = u + " 榜单战报";
                if (str5 != null) {
                    List<JsonObject> t = t(w, "rank_list_data");
                    if (t.isEmpty()) {
                        return null;
                    }
                    JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                    jsonObjectBuilder.put("subtitle", JsonElementKt.JsonPrimitive(str5));
                    for (int i = 0; i < 10; i++) {
                        JsonObject jsonObject = (JsonObject) CollectionsKt___CollectionsKt.getOrNull(t, i);
                        String str6 = "avatar_url_" + i;
                        if (jsonObject != null) {
                            str = u(jsonObject, "avatar_url");
                        } else {
                            str = null;
                        }
                        String str7 = "";
                        if (str == null) {
                            str = "";
                        }
                        jsonObjectBuilder.put(str6, JsonElementKt.JsonPrimitive(str));
                        String str8 = "name_" + i;
                        if (jsonObject != null) {
                            str2 = u(jsonObject, "actor_name");
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            str2 = "";
                        }
                        jsonObjectBuilder.put(str8, JsonElementKt.JsonPrimitive(str2));
                        String str9 = "starlight_text_" + i;
                        if (jsonObject != null && (u2 = u(jsonObject, "score")) != null) {
                            str3 = (char) 10022 + u2;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null) {
                            str7 = str3;
                        }
                        jsonObjectBuilder.put(str9, JsonElementKt.JsonPrimitive(str7));
                    }
                    for (int i2 = 3; i2 < 10; i2++) {
                        JsonObject jsonObject2 = (JsonObject) CollectionsKt___CollectionsKt.getOrNull(t, i2);
                        jsonObjectBuilder.put("stats_text_" + i2 + "_1", JsonElementKt.JsonPrimitive(v(jsonObject2, 0)));
                        jsonObjectBuilder.put("stats_text_" + i2 + "_2", JsonElementKt.JsonPrimitive(v(jsonObject2, 1)));
                    }
                    return jsonObjectBuilder.build();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List s(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) function1.invoke(p0);
    }

    private final List<JsonObject> t(JsonObject jsonObject, String str) {
        JsonArray<JsonElement> jsonArray;
        JsonObject jsonObject2;
        Object obj = jsonObject.get(str);
        ArrayList arrayList = null;
        if (obj instanceof JsonArray) {
            jsonArray = (JsonArray) obj;
        } else {
            jsonArray = null;
        }
        if (jsonArray != null) {
            ArrayList arrayList2 = new ArrayList();
            for (JsonElement jsonElement : jsonArray) {
                if (jsonElement instanceof JsonObject) {
                    jsonObject2 = (JsonObject) jsonElement;
                } else {
                    jsonObject2 = null;
                }
                if (jsonObject2 != null) {
                    arrayList2.add(jsonObject2);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return arrayList;
    }

    private final String u(JsonObject jsonObject, String str) {
        JsonPrimitive jsonPrimitive;
        String content;
        Object obj = jsonObject.get(str);
        if (obj instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) obj;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive == null || (content = jsonPrimitive.getContent()) == null) {
            return null;
        }
        boolean z = true;
        if (!(!StringsKt__StringsKt.isBlank(content)) || Intrinsics.areEqual(content, "null")) {
            z = false;
        }
        if (!z) {
            return null;
        }
        return content;
    }

    private final String v(JsonObject jsonObject, int i) {
        JsonElement jsonElement;
        JsonArray jsonArray;
        JsonElement jsonElement2;
        JsonPrimitive jsonPrimitive;
        String str = null;
        if (jsonObject != null) {
            jsonElement = (JsonElement) jsonObject.get("sub_title_list");
        } else {
            jsonElement = null;
        }
        if (jsonElement instanceof JsonArray) {
            jsonArray = (JsonArray) jsonElement;
        } else {
            jsonArray = null;
        }
        if (jsonArray != null) {
            jsonElement2 = (JsonElement) CollectionsKt___CollectionsKt.getOrNull(jsonArray, i);
        } else {
            jsonElement2 = null;
        }
        if (jsonElement2 instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) jsonElement2;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            str = jsonPrimitive.getContent();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List r(fo4.c r2, com.dragon.read.rpc.model.GetUserVotingRecordResponse r3) {
        /*
            java.lang.String r0 = "rsp"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.dragon.read.rpc.model.GetUserVotingRecordData r3 = r3.data
            if (r3 == 0) goto L18
            java.util.List r3 = r3.data
            if (r3 == 0) goto L18
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            com.dragon.read.rpc.model.UserRankListVotingRecord r3 = (com.dragon.read.rpc.model.UserRankListVotingRecord) r3
            if (r3 == 0) goto L18
            java.util.List r3 = r3.votingRecords
            goto L19
        L18:
            r3 = 0
        L19:
            if (r3 != 0) goto L1f
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L1f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r3 = r3.iterator()
        L28:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L41
            java.lang.Object r1 = r3.next()
            com.dragon.read.rpc.model.UserVotingRecord r1 = (com.dragon.read.rpc.model.UserVotingRecord) r1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            io4.f r1 = r2.x(r1)
            if (r1 == 0) goto L28
            r0.add(r1)
            goto L28
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fo4.c.r(fo4.c, com.dragon.read.rpc.model.GetUserVotingRecordResponse):java.util.List");
    }

    private final void p(List<n> list, VideoTabModel.VideoData videoData, q qVar) {
        if (videoData != null) {
            String seriesId = videoData.getSeriesId();
            Intrinsics.checkNotNullExpressionValue(seriesId, "getSeriesId(...)");
            list.add(new n(seriesId, qVar, 0, null, null, 24, null));
        }
    }

    @Override // lo4.a
    public void g(String userId, ym4.k pageRecorder, ym4.a args) {
        boolean z;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
        Intrinsics.checkNotNullParameter(args, "args");
        if (userId.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LogWrapper.info(this.a, "openProfileByUserId error userId is empty", new Object[0]);
        } else {
            BSOpenProfilePageService.IMPL.openSeriesProfilePage(ContextKt.getCurrentContext(), bd4.b.a(pageRecorder), userId, n0.a(args));
        }
    }

    @Override // lo4.a
    public void j(io4.a model, int i, ym4.k pageRecorder, ym4.a args) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
        Intrinsics.checkNotNullParameter(args, "args");
        cj0 cj0Var = model.a.a;
        if (cj0Var != null) {
            str = cj0Var.a;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            LogWrapper.info(this.a, "openSeriesProfilePage error userID is null", new Object[0]);
        } else {
            BSOpenProfilePageService.IMPL.openSeriesProfilePage(ContextKt.getCurrentContext(), bd4.b.a(pageRecorder), str, n0.a(args));
        }
    }

    @Override // lo4.a
    public void l(g model, int i, View view, Context context, ym4.k kVar) {
        Intrinsics.checkNotNullParameter(model, "model");
        e.a.e(model, i, view, context, kVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6 A[Catch: Exception -> 0x00dd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00dd, blocks: (B:50:0x00b2, B:52:0x00c9, B:58:0x00d6), top: B:49:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0064 A[Catch: Exception -> 0x006b, TRY_LEAVE, TryCatch #1 {Exception -> 0x006b, blocks: (B:23:0x0040, B:25:0x0057, B:75:0x0064), top: B:22:0x0040 }] */
    @Override // lo4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.util.List<com.bytedance.kmp.reading.model.x7> r17, com.bytedance.kmp.reading.model.y7 r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fo4.c.f(java.util.List, com.bytedance.kmp.reading.model.y7, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
