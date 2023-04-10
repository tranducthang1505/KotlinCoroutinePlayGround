import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

fun main() = runBlocking {
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    val stateFlow = MutableStateFlow("Thang")
    coroutineScope.launch {
        stateFlow.collect {
            println("New value collected: $it")
        }
    }
    delay(200)
    stateFlow.value = "Thang2"
    stateFlow.tryEmit("Thang")
    coroutineScope.launch {
        stateFlow.emit("Thang")
    }
    delay(200)
}