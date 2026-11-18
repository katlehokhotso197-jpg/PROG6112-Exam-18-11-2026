/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mattresssales;

/**
 *
 * @author Student
 */
public class MattressSales {

    public static void main(String[] args) {
   
//The total for everything

public int getTotalPtoductsSold(int[][]sales){  
}
int total=0
        
for(int i=0 < sales.length; i++){

for(int j=0 < sales[i].length; i++){

total = total + sales[][]

    }
}

return total

}


//average= total/number of entries

public int getAverageProductsSold(int[][]sales){
    
    int total = getTotalProductsSold(sales);
    int count = sales.length * sales[0].length

return total/count
        
    }

//most popular= product highest Total sales

public string getTheHighestProductSold(string[][]Products , int[][]sales){
        
    int highestTotal=-1
    int popularIndex=0

for(int i=0 < sales.length; i++){
int productTotal=0

for(int j=0 < sales[i].length; i++){

productTotal = productTotal + sales[i][j]
        }
}

if (productTotal > highestTotal){
    highestTotal = productTotal
    popularIndex = i
            
}