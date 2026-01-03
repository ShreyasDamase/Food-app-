package com.example.foodapp.Activity.Splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodapp.MainActivity
import com.example.foodapp.R

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen(onGetStartedClick = {
                startActivity(
                    Intent(
                        this,
                        MainActivity::class.java
                    )
                )
            })


        }

    }
}

@Composable
@Preview
fun SplashScreen(onGetStartedClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkBrown))
    )
    {
        ConstraintLayout(modifier = Modifier.padding(top = 48.dp)) {
            val (backgroundImage, logImage) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.intro_pic),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(backgroundImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)

                    }
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.pizza), contentDescription = null,
                modifier = Modifier.run {
                    constrainAs(logImage) {
                        top.linkTo(backgroundImage.top)
                        bottom.linkTo(backgroundImage.bottom)
                        start.linkTo(backgroundImage.start)
                        end.linkTo(backgroundImage.end)
                    }
                }, contentScale = ContentScale.Fit
            )


        }
        val styledText = buildAnnotatedString {
            append("Welcome to your")
            withStyle(
                style = SpanStyle(color = colorResource(R.color.orange))
            ) {
                append("food\nparadis")
            }
            append(" experience food perfection delivered")
        }

        Text(
            text = styledText,
            fontSize = 27.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 32.dp)
                .padding(horizontal = 16.dp)

        )
        Text(
            text = stringResource(R.string.splashSubtitle),
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)

        )

        GetStartedButton(onClick = onGetStartedClick, modifier = Modifier.padding(top = 60.dp))
    }
}

