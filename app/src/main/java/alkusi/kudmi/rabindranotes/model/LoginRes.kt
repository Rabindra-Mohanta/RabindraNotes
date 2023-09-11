package alkusi.kudmi.rabindranotes.model

class LoginRes {
    var userName =  MyUserName();

    class MyUserName
    {
        var countryCode:String? = "IN"
        var phone:String? = ""
    }
    var password:String? = ""

}