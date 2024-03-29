package cn.soybean.framework.common.util

import cn.soybean.framework.common.consts.DbConstants
import io.vertx.core.http.HttpServerRequest

fun getClientIPAndPort(request: HttpServerRequest): Pair<String, Int?> = Pair(
    request.getHeader("X-Forwarded-For")?.split(":")?.first()?.trim()
        ?: request.getHeader("X-Real-IP")?.trim()
        ?: request.getHeader("Proxy-Client-IP")?.trim()
        ?: request.getHeader("WL-Proxy-Client-IP")?.trim()
        ?: request.getHeader("HTTP_CLIENT_IP")?.trim()
        ?: request.getHeader("HTTP_X_FORWARDED_FOR")?.split(":")?.first()?.trim()
        ?: request.remoteAddress().host(),
    request.remoteAddress().port()
)

fun isSuperUser(userId: Long): Boolean = userId == DbConstants.SUPER_USER