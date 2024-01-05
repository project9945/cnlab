import java.util.Random;

public class RED {
    static int MAX_PACKETS =20;
    static int QUEUE_SIZE =10;
    static double MAX_PROB =0.7;
    static double MIN_PROB=0.3;

    public static void main(String[] args) {
        Random rand = new Random();
        int queueLength=0;
        double drop_prob= MIN_PROB;

        for(int i=0;i<MAX_PACKETS;i++)
        {
            if (queueLength==QUEUE_SIZE){
                System.out.println("Packets Dropped (QUEUE FULL) \n");
                drop_prob=MIN_PROB;
            }
            else if (rand.nextDouble()<drop_prob){
                System.out.println("Packets Dropped (RANDOM) \n");
                drop_prob += (MAX_PROB-MIN_PROB)/(MAX_PACKETS-1.0);
            }
            else{
                System.out.println("Packet Accepted");
                queueLength++;
                drop_prob = MIN_PROB;
            }
        }
    }
}
