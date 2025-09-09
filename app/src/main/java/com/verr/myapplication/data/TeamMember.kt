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
            name = "윤상혁",
            job = "Fullstack Developer",
            location = "Busan, Korea, PKNU",
            description = "소프트웨어는 죽었다라고 말하는 시대에서 그나마 사람들에게 도움되는 서비스를 만드려고 노력합니다."
        ),
    )
}
