package ca.michaelpierce.pokedex.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    // Create Success class with mandatory data (i.e. response from API)
    class Success<T>(data: T) : Resource<T>(data)
    // Create error class. Data is optional but message is mandatory
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    // Loading class with optional data to pass loading percent data
    class Loading<T>(data: T? = null) : Resource<T>(data)

}
