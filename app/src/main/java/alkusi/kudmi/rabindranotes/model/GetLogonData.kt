package alkusi.kudmi.rabindranotes.model

data class GetLogonData (
    val voterId:String?="",
    val userId:String?="",
    val tssMember:Boolean?=false,
    val tssEmployee:Boolean?=false,
    val token:String?="",
    val switchRole:String?="",
    val phone:String?="",
    val name:String?="",
    val image:String?="",
    val groupId:String?="",
    val groupCount:Int?=null,
    val groupCategory:String?="",
    val countryAlpha2Code:String?="",
    val counryTelephoneCode:Int?=91,
    val admin:Boolean?=null,
)



