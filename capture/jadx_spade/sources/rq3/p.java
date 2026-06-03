package rq3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.dragon.read.base.AbsActivity;
import com.dragon.read.report.PageRecorder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface p {
    void F4(n nVar);

    void M2();

    Class<? extends Fragment> N2(AbsActivity absActivity);

    AbsActivity Q4();

    a e9();

    FragmentManager f9();

    boolean isFinishing();

    LifecycleOwner lifecycleOwner();

    Bundle s4();

    PageRecorder ue();
}
