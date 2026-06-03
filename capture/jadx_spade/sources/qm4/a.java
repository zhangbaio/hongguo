package qm4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import com.dragon.read.kmp.reader.bookcover.InsertState;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    Pair<Function2<Composer, Integer, Unit>, State<InsertState>> a(String str);

    Function2<Composer, Integer, Unit> b(String str);

    Pair<Function2<Composer, Integer, Unit>, State<InsertState>> c(String str);
}
