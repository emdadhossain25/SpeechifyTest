package com.example.speechifytest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.speechifytest.ui.addexpense.AddExpenseScreen
import com.example.speechifytest.ui.expenselist.ExpenseListScreen

//class NavGraph {
//}
sealed class Screen(val route:String){
    data object ExpenseList:Screen("expense_list")
    data object AddExpense:Screen("add_expense")
}


@Composable
fun NavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.AddExpense.route
    ){
        composable(route = Screen.AddExpense.route){
            AddExpenseScreen(
               onSubmitClick ={navHostController.navigate(Screen.ExpenseList.route)}
            )
        }
        composable(route = Screen.ExpenseList.route){
            ExpenseListScreen(
               onBackClick = {navHostController.popBackStack() }
            )
        }
    }
}