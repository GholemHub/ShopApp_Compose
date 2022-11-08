package com.gholem.shopapp.arch.nav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.gholem.shopapp.R

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.header_menu_text)),
    ) {
        Text(text = stringResource(id = R.string.header), fontSize = dimensionResource(R.dimen.header_menu_text).value.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = dimensionResource(R.dimen.menu_text).value.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn() {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(dimensionResource(R.dimen.default_padding))
            ) {
                Icon(painter = item.icon, contentDescription = null)
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.default_padding)))
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f),
                    style = itemTextStyle,
                )
            }
        }
    }
}