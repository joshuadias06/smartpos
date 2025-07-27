import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.terminal.smartpos.presentation.components.menu.DrawerItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawerContent() {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val drawerWidth = screenWidthDp / 2
    val drawerBackgroundColor = Color(0xFFF7F7F7)
    val headerBackgroundColor = Color(0xFF007BFF)

    val items = listOf(
        DrawerItem("Pagamento", Icons.Default.AttachMoney) { /* TODO */ },
        DrawerItem("Transações", Icons.Default.AccountBalanceWallet) { /* TODO */ },
        DrawerItem("Configurações", Icons.Default.Settings) { /* TODO */ },
        DrawerItem("Sobre", Icons.Default.Info) { /* TODO */ },
    )

    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .width(drawerWidth)
                .fillMaxHeight()
                .background(drawerBackgroundColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(headerBackgroundColor)
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.LightGray),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Nome da Loja",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                items.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(vertical = 4.dp)
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = headerBackgroundColor,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                        Text(
                            text = item.title,
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDrawerContentPreview() {
    AppDrawerContent()
}