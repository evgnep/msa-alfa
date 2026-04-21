package ru.otus.webapp

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class LogGenerator {
  private val log = LoggerFactory.getLogger(LogGenerator::class.java)

  private var counter = 0

  @Scheduled(fixedDelay = 1000)
  fun generate() {
    log.info("Info message counter=$counter some=\"test\"")
    log.warn("Warn message counter=$counter some=\"test\" other=${1000 - counter}")
  }
}