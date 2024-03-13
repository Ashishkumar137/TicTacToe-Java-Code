import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
import java.awt.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Player1 Name : ");
        String p1 = sc.nextLine();
        System.out.print("Enter player2 Name : ");
        String p2 = sc.nextLine();
        playGame(p1, p2);
        window();

    }
    public static void window(){
        window();
    }
    public static boolean fullFiled(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void showArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        } 
    }
    public static void checkFilled(int arr[][],int n,int r ,int c){
        Scanner sc = new Scanner(System.in);
        boolean filled = true;
        while(filled==true){
            if(arr[r][c]!=0){
                System.out.print("Already filled enter another position : ");
                r = sc.nextInt();
                c = sc.nextInt();
            }
            else{
                arr[r][c] = n;
                filled = false;
            }
        }
    }
    public static boolean checkWinning(int[][] arr, int n){
        if ((arr[0][0] == n && arr[0][1] == n && arr[0][2] == n) ||
                (arr[1][0] == n && arr[1][1] == n && arr[1][2] == n) ||
                (arr[2][0] == n && arr[2][1] == n && arr[2][2] == n) ||
                (arr[0][0] == n && arr[1][0] == n && arr[2][0] == n) ||
                (arr[0][1] == n && arr[1][1] == n && arr[2][1] == n) ||
                (arr[0][2] == n && arr[1][2] == n && arr[2][2] == n) ||
                (arr[0][0] == n && arr[1][1] == n && arr[2][2] == n) ||
                (arr[2][0] == n && arr[1][1] == n && arr[0][2] == n)) {
            return true;
        }
        return false;
    }
    public static int playGame(String p1, String p2) {
        int arr[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        RandomGenerator rd = new Random();
        int n = rd.nextInt(1,3);
        int playAgain;
        boolean play = true;
        do {
            if(n==1){
                System.out.println(p1+ " your term");
            }
            else{
                System.out.println(p2+ " your term");
            }
            showArray(arr);
            System.out.print("Enter the position to fill(row space then column) : ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            checkFilled(arr,n, r, c);
            if(checkWinning(arr, n)==true){
                if(n==1){
                    showArray(arr);
                    System.out.println(p1+ " Winned!");
                }
                else{
                    showArray(arr);
                    System.out.println(p2+ " Winned!");
                }
                play = false;
                System.out.print("To replay enter 1 or to exit enter 0 : ");
                playAgain = sc.nextInt();
                    if(playAgain == 1){
                        return playGame(p1, p2);
                    }
            }
            else{
                if(fullFiled(arr)==true){
                    showArray(arr);
                    System.out.print("Tie");
                    play = false;
                    System.out.print("To replay enter 1 or to exit enter 0 : ");
                    playAgain = sc.nextInt();
                    if(playAgain == 1){
                        return playGame(p1, p2);
                    }
                }
            }    
            n = (n*5)%3;
        }while (play == true);
        return 0;
    }
}
