package alkusi.kudmi.rabindranotes.model

class StaffRes {
    val data = ArrayList<MyData>()
    inner class MyData
    {
        val topicName:String?=null
        val topicId:String?=null
        val toDate:String?=null
        val teamName:String?=null
        val teamId:String?=null
        val subjectId:String?=null
        val fromDate:String?=null
        val chapterName:String?=null
        val chapterId:String?=null
        val actualStartDate:String?=null
        val actualEndDate:String?=null

    }
}
