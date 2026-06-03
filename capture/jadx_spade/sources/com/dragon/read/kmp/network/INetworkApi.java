package com.dragon.read.kmp.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface INetworkApi {
    @GET
    Call<TypedInput> get(@Url String str, @AddCommonParam boolean z, @HeaderList List<Header> list, @QueryMap Map<String, Object> map);

    @POST
    Call<TypedInput> post(@Url String str, @AddCommonParam boolean z, @HeaderList List<Header> list, @Body TypedOutput typedOutput);
}
