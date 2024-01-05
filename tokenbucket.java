import java.util.Scanner;

public class tokenbucket {
    static int tokens = 0; 
    static int rate = 10; 
    static int capacity = 100; 
    public static void main(String[] args) {
    int request[]=new int[100];
    int n;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of requests:");
    n=sc.nextInt();

    System.out.println("Enter the number of packets per request:");
    for (int i=0;i<n;i++){
        request[i]=sc.nextInt();
        }
    for (int i=0;i<n;i++){
        tokens = Math.min(tokens+rate , capacity);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        if(tokens>=request[i]){
            tokens-=request[i];
            System.out.println("Request granted, tokens remaining :"+tokens);
        }
        else{
            System.out.println("Request denied, not enough tokens:"+tokens);
            }
        }
    }

}
