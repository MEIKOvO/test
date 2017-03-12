package test;

public class Triangle {
    public int triangle(int a, int b, int c){
        if(isTriangle(a, b, c)){
            if(a == b && b == c){
                return 1;
            }else if(a == b || b == c || a == c){
                return 2;
            }else{
                return 3;
            }
        }else{
            return 0;
        }
    }
    private boolean isTriangle(int a, int b, int c){
        if(a + b > c && a + c > b && b + c > a){
            return true;
        }else{
            return false;
        }
    }
}