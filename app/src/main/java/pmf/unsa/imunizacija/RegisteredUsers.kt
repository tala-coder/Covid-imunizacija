package pmf.unsa.imunizacija

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class RegisteredUsers(lifecycle: Lifecycle) : LifecycleObserver {
     var counter = 0

    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer() {
        runnable = Runnable {
            counter++
            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer() {
        handler.removeCallbacks(runnable)
    }
}
