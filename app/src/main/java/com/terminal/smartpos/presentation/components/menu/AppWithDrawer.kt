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
@Preview(showBackground = true)
fun AppDrawerContent() {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val drawerWidth = screenWidthDp / 2

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
                .background(Color(0xFFF7F7F7))
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text("Menu", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(24.dp))
            items.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = item.title)
                }
            }
        }
    }
}