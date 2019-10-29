package com.aryandi.data.repository

import com.aryandi.data.common.coroutines.CoroutineContextProvider
import com.aryandi.data.common.utils.Connectivity
import com.aryandi.data.database.DB_ENTRY_ERROR
import com.aryandi.data.network.GENERAL_NETWORK_ERROR
import com.aryandi.data.network.base.DomainMapper
import com.aryandi.domain.model.Error
import com.aryandi.domain.model.Failure
import com.aryandi.domain.model.Result
import com.aryandi.domain.model.Success
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version BaseRepository, v 0.1 2019-10-21 13:40 by Aryandi Putra
 */
abstract class BaseRepository : KoinComponent {
    private val connectivity: Connectivity by inject()
    private val contextProvider: CoroutineContextProvider by inject()

    /**
     * Use this if you need to cache data after fetching it from the api, or retrieve something from cache
     */
    protected suspend fun <T : Any, R : DomainMapper<T>> fetchData(
        apiDataProvider: suspend () -> Result<T>,
        dbDataProvider: suspend () -> R
    ): Result<T> {
        return if (connectivity.hasNetworkAccess()) {
            withContext(contextProvider.io) {
                apiDataProvider()
            }
        } else {
            withContext(contextProvider.io) {
                val dbResult = dbDataProvider()
                if (dbResult != null) Success(dbResult.mapToDomainModel()) else Failure(
                    Error(
                        Throwable(DB_ENTRY_ERROR)
                    )
                )
            }
        }
    }

    /**
     * Use this when communicating only with the api service
     */
    protected suspend fun <T : Any, R : DomainMapper<T>> fetchApiData(apiDataProvider: suspend () -> Result<T>): Result<T> {
        return if (connectivity.hasNetworkAccess()) {
            withContext(contextProvider.io) {
                apiDataProvider()
            }
        } else {
            Failure(Error(Throwable(GENERAL_NETWORK_ERROR)))
        }
    }

//    protected suspend fun <T : Any, R : DomainMapper<T>> fetchDbData(
//        dbDataProvider: suspend () -> R
//    ): Result<T> {
//        return withContext(contextProvider.io) {
//            val dbResult = dbDataProvider()
//            if (dbResult != null) Success(dbResult.) else Failure(
//                Error(Throwable(DB_ENTRY_ERROR))
//            )
//        }
//    }

    private suspend fun <T : Any, R : Any> request(
        dbDataProvider: suspend () -> T,
        transform: (T) -> R
    ): Result<R> {
        return withContext(contextProvider.io) {
            try {
                if (dbDataProvider != null) {
                    val dbResult = dbDataProvider()
                    Success(transform(dbResult))
                } else Failure(
                    Error(Throwable(DB_ENTRY_ERROR))
                )
            } catch (exception: Throwable) {
                Failure(
                    Error(Throwable(DB_ENTRY_ERROR))
                )
            }
        }
    }
}