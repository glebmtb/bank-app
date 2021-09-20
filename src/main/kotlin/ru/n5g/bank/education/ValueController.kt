package ru.n5g.bank.education

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ValueController {

  @InjectValue
  private lateinit var injectValue: String;


  @GetMapping("/value")
  fun getValue(
  ): Value {
    return Value(injectValue)
  }
}

data class Value(val value: String)