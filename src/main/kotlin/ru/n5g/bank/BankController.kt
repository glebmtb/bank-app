package ru.n5g.bank

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import java.util.concurrent.atomic.AtomicLong

@RestController
class BankController {

  @Autowired
  private lateinit var service:BankService

  @PostMapping("/putMoney")
  fun putMoney(
    @RequestParam(value = "accountId") accountId: Int,
    @RequestParam(value = "amount") amount: BigInteger,
  ): TransactionResult{
    return service.putMoney(accountId, amount)
  }

  @PostMapping("/getMoney")
  fun getMoney(
    @RequestParam(value = "accountId") accountId: Int,
    @RequestParam(value = "amount") amount: BigInteger,
  ): TransactionResult{
    return service.getMoney(accountId, amount)
  }

  @PostMapping("/transferMoney")
  fun transferMoney(
    @RequestParam(value = "accountIdFrom") accountIdFrom: Int,
    @RequestParam(value = "accountIdTo") accountIdTo: Int,
    @RequestParam(value = "amount") amount: BigInteger,
  ): TransactionResult{
    return service.transferMoney(accountIdFrom, accountIdTo, amount)
  }
}