package ru.otus.webapp

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

@Component
class CustomHealthIndicator: HealthIndicator {
  var up = true

  override fun health(): Health? =
    if (up) Health.up().build() else Health.down().build()
}