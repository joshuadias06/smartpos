import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import com.terminal.smartpos.presentation.screens.charge.ChargeScreen

@Composable
fun ChargeScreenWithDrawer(navController: NavController) {
    var isDrawerOpen by remember { mutableStateOf(false) }
    val drawerWidth = LocalConfiguration.current.screenWidthDp.dp / 2
    val scope = rememberCoroutineScope()

    val offsetX = remember { Animatable(-drawerWidth.value) }

    LaunchedEffect(isDrawerOpen) {
        if (isDrawerOpen) {
            offsetX.animateTo(0f, animationSpec = tween(durationMillis = 300))
        } else {
            offsetX.animateTo(-drawerWidth.value, animationSpec = tween(durationMillis = 300))
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        ChargeScreen(
            navController = navController,
            onMenuClick = { isDrawerOpen = true },
            onSyncClick = {},
            onSwitchStore = {
                navController.navigate("select_store")
            },
            onConfirmAmount = {}
        )

        if (isDrawerOpen || offsetX.value > -drawerWidth.value) {
            // Fundo semitransparente para clique fora
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { isDrawerOpen = false }
            )

            // Drawer com swipe
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(drawerWidth)
                    .offset(x = offsetX.value.dp)
                    .background(Color(0xFFF7F7F7))
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            if (dragAmount < -10) {
                                isDrawerOpen = false
                                change.consume()
                            }
                        }
                    }
            ) {
                AppDrawerContent()
            }
        }
    }
}

