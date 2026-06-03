package xk6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private Activity a;
    public volatile boolean b;
    private final Set<b> c;

    public interface b {
        void onEnterBackground();

        void onEnterForeground();
    }

    static {
        Covode.recordClassIndex(655862);
    }

    public static a g() {
        return c.a;
    }

    private interface c {
        public static final a a;

        static {
            Covode.recordClassIndex(655864);
            a = new a(null);
        }
    }

    private a() {
        this.a = null;
        this.b = false;
        this.c = Collections.synchronizedSet(new HashSet());
    }

    /* synthetic */ a(C0291a c0291a) {
        this();
    }

    /* renamed from: xk6.a$a, reason: collision with other inner class name */
    class C0291a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        C0291a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (a.this.a != activity) {
                return;
            }
            a.this.a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.this.a = activity;
            if (a.this.b) {
                return;
            }
            a.this.f(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (!a.this.b || a.this.a != activity) {
                return;
            }
            a.this.f(false);
        }
    }

    public void e(b bVar) {
        if (bVar != null) {
            this.c.add(bVar);
        }
    }

    public void i(b bVar) {
        if (bVar != null) {
            this.c.remove(bVar);
        }
    }

    public void h(Application application) {
        application.registerActivityLifecycleCallbacks(new C0291a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z) {
        this.b = z;
        try {
            for (b bVar : (b[]) this.c.toArray(new b[0])) {
                if (bVar != null) {
                    if (z) {
                        bVar.onEnterForeground();
                    } else {
                        bVar.onEnterBackground();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
