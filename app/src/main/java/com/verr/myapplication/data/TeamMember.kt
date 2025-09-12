package com.verr.myapplication.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamMember(
    val id: Int,
    val name: String,
    val job: String,
    val location: String,
    val description: String,
    val profileImageUrl: String? = null
) : Parcelable

object TeamData {
    val teamMembers = listOf(
        TeamMember(
            id = 1,
            name = "김준서",
            job = "FrontEnd Developer",
            location = "Busan, Korea, PKNU",
            description = "프론트엔드 멘토로 활동하고있습니다. 편하게 질문해주세요!",
            profileImageUrl = "https://avatars.githubusercontent.com/u/112786665?v=4"
        ),
        TeamMember(
            id = 2,
            name = "심서은",
            job = "FrontEnd Developer",
            location = "Yangsan, Korea, PKNU",
            description = "프론트 엔드와 앱 개발을 배우는 중입니다!",
            profileImageUrl = "https://avatars.githubusercontent.com/u/202733674?v=4"
        ),
        TeamMember(
            id = 3,
            name = "팀원을 추가해주세요",
            job = "... Developer",
            location = "Busan, Korea",
            description = "WAP 에 오신걸 환영합니다!"
        ),
    )
}
