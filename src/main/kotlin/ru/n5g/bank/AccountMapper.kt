package ru.n5g.bank

import org.apache.ibatis.annotations.*
import java.math.BigInteger

@Mapper
interface AccountMapper {
  @Select("SELECT * FROM ACCOUNT WHERE accountId = #{accountId} for update")
  fun selectForUpdate(@Param("accountId") accountId: Int?): Account?

  @Update("UPDATE ACCOUNT SET amount=#{amount} WHERE accountId = #{accountId}")
  fun update(@Param("accountId") accountId: Int?, @Param("amount") amount: BigInteger?)

  @Insert("INSERT INTO ACCOUNT (accountId, amount) VALUES (#{accountId}, #{amount})")
  fun insert(@Param("accountId") accountId: Int?, @Param("amount") amount: BigInteger?)
}