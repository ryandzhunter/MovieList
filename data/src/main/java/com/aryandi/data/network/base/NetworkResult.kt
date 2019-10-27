package com.aryandi.data.network.base

import com.aryandi.data.database.DB_ENTRY_ERROR
import com.aryandi.data.network.GENERAL_NETWORK_ERROR
import com.aryandi.data.network.IO_NETWORK_ERROR
import com.aryandi.domain.model.Failure
import com.aryandi.domain.model.Error
import com.aryandi.domain.model.Result
import com.aryandi.domain.model.Success
import retrofit2.Response
import java.io.IOException

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version NetworkResult, v 0.1 2019-10-21 13:35 by Aryandi Putra
 */
interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}

interface RoomMapper<out T : Any> {
    fun mapToRoomEntity(): T
}

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(action)
    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (Error) -> Unit) {
    if (!isSuccessful) errorBody()?.run { action(Error(Throwable(message()), code())) }
}

/**
 * Use this if you need to cache data after fetching it from the api, or retrieve something from cache
 */

inline fun <T : RoomMapper<R>, R : DomainMapper<U>, U : Any> Response<T>.getData(
    cacheAction: (R) -> Unit,
    fetchFromCacheAction: () -> R
): Result<U> {
    try {
        onSuccess {
            val databaseEntity = it.mapToRoomEntity()
            cacheAction(databaseEntity)
            return Success(databaseEntity.mapToDomainModel())
        }
        onFailure {
            val cachedModel = fetchFromCacheAction()
            if (cachedModel != null) Success(cachedModel.mapToDomainModel()) else Failure(
                Error(
                    Throwable(DB_ENTRY_ERROR)
                )
            )
        }
        return Failure(Error(Throwable(GENERAL_NETWORK_ERROR)))
    } catch (e: IOException) {
        return Failure(Error(Throwable(IO_NETWORK_ERROR)))
    }
}

/**
 * Use this when communicating only with the api service
 */
fun <T : DomainMapper<R>, R : Any> Response<T>.getData(): Result<R> {
    try {
        onSuccess { return Success(it.mapToDomainModel()) }
        onFailure { return Failure(it) }
        return Failure(Error(Throwable(GENERAL_NETWORK_ERROR)))
    } catch (e: IOException) {
        return Failure(Error(Throwable(IO_NETWORK_ERROR)))
    }
}