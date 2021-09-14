package ru.n5g.bank

data class TransactionResult(val result: Result)
enum class Result{
  OK,
  REJECT
}
