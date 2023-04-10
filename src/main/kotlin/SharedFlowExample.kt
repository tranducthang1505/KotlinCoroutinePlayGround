import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow

fun main() = runBlocking{
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    val sharedFlow = MutableSharedFlow<String>(1)
    sharedFlow.tryEmit("Thang")
    coroutineScope.launch {
        sharedFlow.collect {
            println("New value collected: $it")
        }
    }
    delay(200)
    sharedFlow.tryEmit("Thang")
    coroutineScope.launch {
        sharedFlow.emit("Thang")
    }
    delay(200)
}