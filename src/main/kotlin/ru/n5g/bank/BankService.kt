package ru.n5g.bank

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigInteger

@Service
class BankService {
  @Autowired
  private lateinit var mapper: AccountMapper

  @Transactional
  fun putMoney(accountId: Int, amount: BigInteger): TransactionResult {
    val account = mapper.selectForUpdate(accountId)
    Thread.sleep(5000) //проверить что блокировка работает
    if (account == null) {
      mapper.insert(accountId, amount)
    } else {
      mapper.update(accountId, account.amount.plus(amount))
    }
    return TransactionResult(Result.OK)
  }

  @Transactional
  fun getMoney(accountId: Int, amount: BigInteger): TransactionResult {
    val accountAmount = mapper.selectForUpdate(accountId)?.amount
    Thread.sleep(5000) //проверить что блокировка работает
    return if ((accountAmount?.compareTo(amount) ?: -1) > 0) {
      mapper.update(accountId, accountAmount!!.minus(amount))
      TransactionResult(Result.OK)
    } else {
      TransactionResult(Result.REJECT)
    }
  }

  @Transactional
  fun transferMoney(accountIdFrom: Int, accountIdTo: Int, amount: BigInteger): TransactionResult {
    val accountFrom = mapper.selectForUpdate(accountIdFrom)
    val accountTo = mapper.selectForUpdate(accountIdTo)
    Thread.sleep(5000) //проверить что блокировка работает

    if ((accountFrom?.amount?.compareTo(amount) ?: -1) > 0) {
      mapper.update(accountIdFrom, accountFrom!!.amount.minus(amount))
    } else {
      TransactionResult(Result.REJECT)
    }

    if (accountTo == null) {
      mapper.insert(accountIdTo, amount)
    } else {
      mapper.update(accountIdTo, accountTo.amount.plus(amount))
    }
    return TransactionResult(Result.OK)
  }
}