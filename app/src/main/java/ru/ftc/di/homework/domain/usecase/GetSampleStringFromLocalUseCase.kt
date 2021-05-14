package ru.ftc.di.homework.domain.usecase

import ru.ftc.di.homework.data.repository.SampleStringRepositoryImpl
import ru.ftc.di.homework.domain.repository.SampleStringRepository
import javax.inject.Inject

class GetSampleStringFromLocalUseCase @Inject constructor(private val repository: SampleStringRepository) {

    //TODO: DI
    //TODO: сделать так, чтобы repository не пересоздавался для каждого UseCase


    operator fun invoke(): String {
        val fromLocal = repository.getFromLocal()
        val repoInstanceHash = repository.hashCode()

        return "$fromLocal, repo hash = $repoInstanceHash"
    }
}