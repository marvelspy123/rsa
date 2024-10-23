// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int n = p*q;
        System.out.println("N is: " + n);
        int phi = (p-1) * (q-1);
        List<Integer> e = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        for(int i = 1; i<phi; i++){
            if(gcd(i, phi) == 1){
                e.add(i);
            }       
        }
        System.out.print("Valuse of e are: ");
        for(int i : e){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : e){
            d.add(findD(i, phi));
        }
        System.out.print("Valuse of d are: ");
        for(int i : d){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Enter Opteration 1:Encryption 2:Decryption 3:exit: " );
        int op = sc.nextInt();
        System.out.print("Enter Plaintext: " );
        int M = sc.nextInt();
        System.out.print("Enter Value of e: " );
        int val = sc.nextInt();
        System.out.println();
        while(!e.contains(val)){
            System.out.println("Wrong Value of e enter again " );
            val = sc.nextInt();
        }
        int diff = d.get(e.indexOf(val));
        System.out.println("Public key: " + "[" + e + ", " + n );
        while(op != 3){
            int enc = (int)Math.pow(M, val) % n;
            int dec = (int)Math.pow(enc, diff) % n;
            if(op == 1){
                System.out.println("Encrypted Value: "+ enc );
            }
            else{
                System.out.println("Decrypted Value: "+ dec );
            }
            System.out.print("Enter Opteration: " );
            op = sc.nextInt();
        }
    }
    public static int gcd(int a, int b){
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }
    public static int findD(int e, int phi){
        int d = 1;
        for(int i = 1; i<phi; i++){
            if((e*i)%phi == 1){
                d = i;
            }
        }
        return d;
    }
}
