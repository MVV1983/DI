package ru.ftc.di.homework.domain.usecase

import ru.ftc.di.homework.data.repository.SampleStringRepositoryImpl
import ru.ftc.di.homework.domain.repository.SampleStringRepository
import javax.inject.Inject

class GetSampleStringFromRemoteUseCase @Inject constructor(private val repository: SampleStringRepository){

    //TODO: DI
    //TODO: сделать так, чтобы repository не пересоздавался для каждого UseCase


    operator fun invoke(): String {
        val fromRemote = repository.getFromRemote()
        val repoInstanceHash = repository.hashCode()

        return "$fromRemote, repo hash = $repoInstanceHash"
    }
}