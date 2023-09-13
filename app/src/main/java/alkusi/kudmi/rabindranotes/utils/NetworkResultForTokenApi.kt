package alkusi.kudmi.rabindranotes.utils

sealed class NetworkResultForTokenApi<T> constructor(val data:T?=null,val message:String?=null) {
    class OnSuccess<T> constructor(data: T?):NetworkResultForTokenApi<T>(data)
    class OnError<T> constructor(message: String?,data: T?=null):NetworkResultForTokenApi<T>(data,message)
    class OnProgress<T> constructor():NetworkResultForTokenApi<T>();
}