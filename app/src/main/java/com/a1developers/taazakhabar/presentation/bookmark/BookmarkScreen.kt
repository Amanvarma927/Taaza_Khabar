package com.a1developers.taazakhabar.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.a1developers.taazakhabar.R
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.presentation.common.ArticlessList
import com.a1developers.taazakhabar.presentation.nvgrapgh.Route
import com.a1developers.taazakhabar.presentation.onboarding.Dimens.MediumPadding

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails: (Article) -> Unit
) {
    Spacer(modifier = Modifier.height(MediumPadding))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = MediumPadding, start = MediumPadding, end = MediumPadding)
    ) {

        Spacer(modifier = Modifier.height(MediumPadding))

        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.homescreen)
        )
        Spacer(modifier = Modifier.height(MediumPadding))


        ArticlessList(articles = state.articles, onClick = {navigateToDetails(it)})

    }
}