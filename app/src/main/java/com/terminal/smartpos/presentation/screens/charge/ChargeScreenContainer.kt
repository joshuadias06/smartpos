import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.terminal.smartpos.presentation.screens.charge.ChargeScreen


@Composable
fun ChargeScreenWithDrawer() {
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
            onMenuClick = { isDrawerOpen = true },
            onSyncClick = {},
            onSwitchStore = {},
            onConfirmAmount = {}
        )

        if (isDrawerOpen || offsetX.value > -drawerWidth.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { isDrawerOpen = false }
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(drawerWidth)
                    .offset(x = offsetX.value.dp)
                    .background(Color(0xFFF7F7F7))
            ) {
                AppDrawerContent()
            }
        }
    }
}
