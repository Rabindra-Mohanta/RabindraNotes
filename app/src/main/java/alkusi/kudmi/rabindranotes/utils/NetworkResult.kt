package alkusi.kudmi.rabindranotes.utils

sealed class NetworkResult<T> constructor(data:T?=null,message:String?=null)
{
    class OnSuccess<T> constructor(data: T?=null):NetworkResult<T>(data)
    class OnError<T> constructor(val message: String?=null,val data: T?=null,):NetworkResult<T>(data,message)
    class OnProgress<T> constructor():NetworkResult<T>();
}
