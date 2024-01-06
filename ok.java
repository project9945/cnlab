import java.util.*;
public class RSA {
    public static int gcd(int a, int b){
        while(b!=0){
            int r=b;
            b=a%b;
            a=r;
        }
        return a;
    }
    public static int FindCoprime(int phi){
        int e=2;
        while(e<phi){
            if(gcd(e,phi)==1)
                return e;
            e++;
        }
        return -1;
    }
    public static int FindPrivateKey(int e, int phi){
        int d;
        int k=1;
        while(true){
            d=(1+(k*phi))/e;
            if (d*e == (1+(k*phi)))
                return d;
            k++;
        }
    }
    public static int modularExp(int b, int e, int m){
        int res=1;
        for(int i=0;i<e;i++)
        {
            res=(res*b)%m;
        }
        return res;
    }
    public static List<Integer> rsa_encrypt(String P, int e, int n){
        List <Integer> cipertext = new ArrayList<>();
        for (char c : P.toCharArray()){
            cipertext.add(modularExp((int)c, e, n));
        }
        return cipertext;
    }
    public static String rsa_decrypt(List<Integer> c, int d, int n){
        StringBuilder plaintext = new StringBuilder();
        for (int i:c){
            plaintext.append((char)modularExp(i, d, n));
        }
        return plaintext.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p=17,q=23;
        int n=p*q;
        int phi=(p-1)*(q-1);
        int e=FindCoprime(phi);
        int d=FindPrivateKey(e, phi);
        System.out.println("Enter the plaintext : \n");
        String plaintext=sc.nextLine();
        List <Integer> ct = rsa_encrypt(plaintext, e, n);
        System.out.println("Cipher Text: "+ct);
        String pt=rsa_decrypt(ct, d, n);
        System.out.println("Plaintext: "+pt);
    }
}
