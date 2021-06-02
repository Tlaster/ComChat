package moe.tlaster.comchat.common.db

import com.squareup.sqldelight.db.SqlDriver

expect class DriverFactory {
    expect fun createDriver(): SqlDriver
}