package async
import kotlinx.coroutines.*

suspend fun task1(){
    val stuff = 100
    println("entering task1 ${Thread.currentThread()}")
    delay(1000)
    println("exiting task1 ${Thread.currentThread()}---$stuff")
}

suspend fun task2(){
    println("entering task2 ${Thread.currentThread()}")
    delay(1000)
    println("exiting task2 ${Thread.currentThread()}")
}

fun main() {
    runBlocking {
        launch { task1()  }
        launch { task2() }

        println("called the task ${Thread.currentThread()}")
    }
}
