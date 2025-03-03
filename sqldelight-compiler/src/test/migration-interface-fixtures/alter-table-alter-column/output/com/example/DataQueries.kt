package com.example

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.JdbcPreparedStatement
import kotlin.Int
import kotlin.String

public class DataQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun insertFirst(
    first: String?,
    second: Int,
    third: String,
    fourth: Int?,
  ) {
    driver.execute(-2_134_278_654,
        """INSERT INTO test (first, second, third, fourth) VALUES (?, ?, ?, ?)""", 4) {
          check(this is JdbcPreparedStatement)
          bindString(0, first)
          bindInt(1, second)
          bindString(2, third)
          bindInt(3, fourth)
        }
    notifyQueries(-2_134_278_654) { emit ->
      emit("test")
    }
  }
}
