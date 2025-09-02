package com.verr.myapplication.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.verr.myapplication.data.TeamData
import com.verr.myapplication.data.TeamMember
import com.verr.myapplication.profile.ProfileActivity
import com.verr.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                TeamListScreen(
                    teamMembers = TeamData.teamMembers,
                    onMemberClick = { member -> startMemberProfile(member) }
                )
            }
        }
    }

    private fun startMemberProfile(member: TeamMember) {
        /**
         * intent를 추가해주세요.
         * **/
        startActivity(intent)
    }
}
