package ru.ftc.di.homework.data.repository

import dagger.Module
import ru.ftc.di.homework.data.datasource.SampleStringDataSource
import ru.ftc.di.homework.data.datasource.SampleStringLocalDataSource
import ru.ftc.di.homework.data.datasource.SampleStringRemoteDataSource
import ru.ftc.di.homework.domain.repository.SampleStringRepository
import javax.inject.Inject

@Module
class SampleStringRepositoryImpl @Inject constructor(
    private val localDataSource: SampleStringDataSource,
    private val remoteDataSource: SampleStringDataSource ) : SampleStringRepository {

    //TODO: DI

    override fun getFromRemote(): String =
        remoteDataSource.get()

    override fun getFromLocal(): String =
        localDataSource.get()
}