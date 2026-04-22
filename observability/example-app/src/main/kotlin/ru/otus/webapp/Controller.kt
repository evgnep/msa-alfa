package ru.otus.webapp

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

@RestController
class Controller(private val healthIndicator: CustomHealthIndicator) {
    private val log = LoggerFactory.getLogger(Controller::class.java)

    private val random = Random(42)

    private val counter = AtomicInteger(0)

    private fun doSomething(res: String, from: Int, to: Int): String {
        val reqIndex = this.counter.incrementAndGet()
        log.info("Request method=$res from=$from to=$to reqIndex=$reqIndex")
        val timeout = random.nextLong(from.toLong(), to.toLong())
        Thread.sleep(timeout)
        val error = random.nextInt(10)
        if (error > 8) {
            try {
                throw RuntimeException("Error $error")
            } catch (e: Exception) {
                log.error("Error in reqIndex=$reqIndex", e)
                throw e
            }
        }
        log.info("Request complete. reqIndex=$reqIndex")
        return "$res: $timeout"
    }

    @GetMapping("/api/a")
    fun method1() = doSomething("method1", 0, 300)

    @GetMapping("/api/b")
    fun method2() = doSomething("method2", 200, 400)

    @GetMapping("/health/liveness")
    fun setLiveness(@RequestParam up: Boolean) {
        healthIndicator.up = up
    }
}