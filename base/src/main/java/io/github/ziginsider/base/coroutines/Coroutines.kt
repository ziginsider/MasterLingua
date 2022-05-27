package io.github.ziginsider.base.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

fun CoroutineScope.newCoroutineScope(context: CoroutineContext): CoroutineScope {
    return CoroutineScope(this.coroutineContext + Job() + context)
}

fun CoroutineScope.newCoroutineScope(): CoroutineScope {
    return CoroutineScope(this.coroutineContext + Job())
}

fun CoroutineScope.newSupervisorScope(context: CoroutineContext): CoroutineScope {
    return CoroutineScope(this.coroutineContext + SupervisorJob() + context)
}

fun CoroutineScope.newSupervisorScope(): CoroutineScope {
    return CoroutineScope(this.coroutineContext + SupervisorJob())
}
