package com.a1developers.taazakhabar.presentation.onboarding

import androidx.annotation.DrawableRes
import com.a1developers.taazakhabar.R

data class Page(

    val title: String,
    val description: String,
    @DrawableRes val image: Int,

    )


val pages = listOf(


    Page(
        title = "Stay Informed, Stay Ahead",
        description = "Discover the latest news from around the world, curated and delivered straight to your fingertips. With real-time updates and customizable categories, never miss a story that matters to you.",
        image = R.drawable.onboarding1


    ),

    Page(

        title = "Your Daily Dose of News",
        description = "Dive into breaking news, trending topics, and in-depth analysis. From global headlines to local updates, experience news like never before with our sleek, user-friendly interface.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "News, Simplified for You",
        description = "Explore a personalized news experience designed to keep you connected and informed. Get the stories you care about, tailored to your interests and preferences, all in one place.",
        image = R.drawable.onboarding3

    )

)

