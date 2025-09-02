package com.verr.myapplication.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.verr.myapplication.R
import com.verr.myapplication.components.BaseImage
import com.verr.myapplication.data.TeamData
import com.verr.myapplication.data.TeamMember
import com.verr.myapplication.ui.theme.MyApplicationTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamListScreen(
    teamMembers: List<TeamMember>,
    onMemberClick: (TeamMember) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2196F3),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE3F2FD),
                            Color(0xFFBBDEFB),
                            Color(0xFF90CAF9)
                        )
                    )
                )
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.main_title),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1976D2),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(R.string.team_subtitle),
                            fontSize = 16.sp,
                            color = Color(0xFF424242),
                            textAlign = TextAlign.Center,
                            lineHeight = 22.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(R.string.team_members_count, teamMembers.size),
                            fontSize = 14.sp,
                            color = Color(0xFF9E9E9E),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                items(teamMembers) { member ->
                    TeamMemberCard(
                        member = member,
                        onClick = { onMemberClick(member) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
private fun TeamMemberCard(
    member: TeamMember,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.95f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage(member)

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = member.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1976D2)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFFFF9800)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = member.job,
                        fontSize = 14.sp,
                        color = Color(0xFF424242),
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFF9E9E9E)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = member.location,
                        fontSize = 12.sp,
                        color = Color(0xFF9E9E9E)
                    )
                }
            }

            // Arrow Icon
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "자세히 보기",
                tint = Color(0xFF9E9E9E),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun ProfileImage(member: TeamMember) {

    Card(
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(30.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        if (member.profileImageUrl != null) {
            BaseImage(
                imageUrl = member.profileImageUrl,
                contentDescription = member.name,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(30.dp)),
            )
        } else {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                Color(0xFF2196F3),
                                Color(0xFF1976D2)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = member.name,
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TeamListScreenPreview() {
    MyApplicationTheme {
        TeamListScreen(
            teamMembers = TeamData.teamMembers,
            onMemberClick = {},
        )
    }
}