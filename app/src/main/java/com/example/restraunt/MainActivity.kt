package com.example.restraunt


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restraunt.ui.theme.RestrauntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestrauntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                   Screen()
                }
            }
        }
    }
}




@Composable
fun Description(centername : String , itemlist : String ){

        Column(modifier = Modifier.padding(6.dp)) {
            Text(text = centername, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(text = itemlist)
        }

}

//Image(
//painter = painterResource(id = id),
//contentDescription = null,
//modifier = Modifier
//.fillMaxWidth()
//.height(150.dp),
//contentScale = ContentScale.Crop
//)
//
//
//Image(painter = painterResource(id = id), contentDescription = null , modifier = Modifier.fillMaxWidth() .height(150.dp) , contentScale = ContentScale.Crop )
//Downcard(centername, itemlist , rating , price)


@Composable
fun RatingPrice( rating :String , price : String){
    Column(horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .wrapContentWidth(Alignment.End)) {
        Surface(color = Color(38, 150, 111) ,  shape = RoundedCornerShape(10.dp)) {
            Row(modifier = Modifier.padding(3.dp)) {
                Text(text = rating , fontWeight = FontWeight.Bold , fontSize = 18.sp , color = Color.White)
                Text(text ="⭐",  modifier = Modifier.padding(start = 3.dp) , color = Color.White)}
            }
        Text("₹$price for one" , fontSize = 14.sp)
        }


    }

@Composable
fun Downcard(centername : String , itemlist : String , rating :String , price : String){
    Row(verticalAlignment = Alignment.CenterVertically){
        Description(centername  , itemlist )
        RatingPrice( rating, price )
    }

}


@Composable
fun Itemcard(centername : String , itemlist : String , rating :String , price : String , id :Int ) {
    Column( ) {
        Card( modifier = Modifier.padding(10.dp) , elevation = 4.dp , shape = RoundedCornerShape(10.dp) ,) {
            Column {

                Image(painter = painterResource(id = id), contentDescription = "location" , modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) , contentScale = ContentScale.Crop)
                Downcard(centername, itemlist , rating , price)
  }
        }
    }
    
}


//
//leadingIcon = {
//    Icon(
//        Icons.Default.Search,
//        contentDescription = "",
//        modifier = Modifier
//            .padding(15.dp)
//            .size(24.dp)
//    )}
@Composable
fun Search(){
    var search by remember{
        mutableStateOf("Restaurant name or a dish")
    }
    Surface( elevation = 10.dp  , shape = CircleShape  , modifier = Modifier
        .scale(scaleY = 0.7F, scaleX = 1F)
        .padding(top = 5.dp, start = 6.dp, end = 6.dp, bottom = 12.dp) ) {
        TextField(
            value = search,
            onValueChange = { search = it},
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true


            ,
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(25.dp)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                )

        )
    }


}
@Composable
fun Screen(){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(start = 14.dp, top = 10.dp, end = 14.dp, bottom = 10.dp)) {

Search()

        Itemcard(centername = "Tea Times", itemlist = "Tea, Beverages, Shake " , rating ="4.7" , price ="100",id = R.drawable.download__6_ )
        Itemcard(centername = "Family Restaurant", itemlist = "Tiffin , Meals , Biriyani" , rating ="4.6" , price ="200", id = R.drawable.download__5_ )
        Itemcard(centername = "Havelis Restaurant", itemlist = "South Indian , North Indian", rating = "4.8" , price = "500", id = R.drawable.chestnut_restaurant )
        Itemcard(centername = "Food Court", itemlist = "Biriyani , North Indian  " , rating ="4.5" , price ="200",id = R.drawable.hyderabadi_dum_biryani )
        Itemcard(centername = "Mithai wala", itemlist = "All Types of Sweets" , rating ="4.7" , price ="100", id = R.drawable.sweet1 )
        Itemcard(centername = "Food Parks", itemlist = "Biriyani, Chinese , North Indian", rating = "4.8" , price = "400", id = R.drawable.desi_chow_mein_featured_500x375 )



    }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestrauntTheme {
       Screen()
    }
}