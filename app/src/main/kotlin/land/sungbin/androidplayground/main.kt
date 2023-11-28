package land.sungbin.androidplayground

// interface AApi
// class AApiImpl : AApi
//
// interface AApi2
// class AApiImpl2 : AApi2
//
// interface AApi3
// class AApiImpl3 : AApi3

internal object AApi1
internal object AApi2

internal object AApi3 {
  fun call() = Unit
}

object PublicApi {
  fun call() = AApi3.call()
}

fun main() {
  PublicApi.call()
}

object AmsRepository {
  /** aa */
  fun apiCall() {
    println("api call")
  }
}

fun usage() {
  AmsRepository.apiCall()
}

// AmsRepository.apiCall()
// DrtDispatcher.repository.call()
