package alkusi.kudmi.rabindranotes.utils

sealed class NetworkResult<T> constructor(val data:T?=null,val message:String?=null)
{
    class OnSuccess<T> constructor(data: T?=null):NetworkResult<T>(data)
    class OnError<T> constructor(message: String?=null,data: T?=null):NetworkResult<T>(data,message,)
    class OnProgress<T> constructor():NetworkResult<T>();
}
