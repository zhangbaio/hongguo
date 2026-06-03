package ws3;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import com.dragon.read.base.v;
import com.dragon.read.rpc.model.ClientReqType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    int K();

    int a();

    String b();

    HashMap<String, Serializable> c();

    boolean c2();

    void d(o oVar);

    boolean e();

    int f();

    void g(o oVar, ClientReqType clientReqType, int i);

    Activity getActivity();

    Map<String, Object> getExtraParams();

    Map<String, Object> getReportParams();

    zr3.h h();

    boolean i();

    LiveData<p> j();

    boolean k();

    LiveData<n> l();

    boolean l1();

    void m(o oVar);

    String n();

    void o(m mVar);

    boolean p();

    boolean q2();

    v u();
}
