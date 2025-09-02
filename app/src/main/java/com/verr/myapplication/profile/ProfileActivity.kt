package com.verr.myapplication.profile

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.verr.myapplication.data.TeamMember
import com.verr.myapplication.ui.theme.MyApplicationTheme

class ProfileActivity : ComponentActivity() {

    private val teamMember by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(TEAM_MEMBER_KEY, TeamMember::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(TEAM_MEMBER_KEY)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            MyApplicationTheme {
                ProfileScreen(
                    teamMember = teamMember,
                    onBackClick = { finish() }
                )
            }
        }
    }

    companion object {
        private const val TEAM_MEMBER_KEY = "team_member"
    }
}
