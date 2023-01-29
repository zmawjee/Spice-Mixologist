import java.util.Random;
class SpiceMixGame{

    // initialise variables 
    Random r = new Random();
    private SpiceMix solution;
    private LinkedList attemptsList = new LinkedList();

    //random generated solution constructor 
    public SpiceMixGame(){
        char[] solutionRand = new char[5];
        //fill array
        for (int i=0; i<5; i++){
            //generate random integer, convert to char and add it to array
            solutionRand[i] = (char)('N'+ r.nextInt(7));
        }
        //set solution 
        this.solution = new SpiceMix(solutionRand);
    }
    //given solution constructor  
    public SpiceMixGame(SpiceMix solution){
        this.solution = solution;
    }

    public boolean attemptSpiceMix(SpiceMix spiceMix){
        boolean correct = false;;
        Attempt attempt = new Attempt(spiceMix, this.solution);
        attemptsList.addAttempt(attempt);

        correct = attempt.isCorrect();
        return correct;  
      }
    //getters
    public String getPreviousAttempts(){return attemptsList.toString();}
    public SpiceMix getSolution(){return this.solution;} 


}

class LinkedList{
    //initialise variables
    private Node head;
    
    //constructor
    public LinkedList(){
        head = null;
    }

    public void addAttempt(Attempt attempt){
        if(head ==null){
            head = new Node(attempt,null);
        }
        else{
            head = new Node(attempt,head);
        }
    }
    //to string method that displays attempts as strings
    public String toString(){
        String a = "";
        Node cursor = head;
        
        if(head == null){
            return null;
        }
        
        
        while (cursor != null){
            a += cursor.getPayload().toString() + "\n";
            cursor = cursor.getNext();
        }
        return a;
    }
    
}

class Node{
    //initialise variables 
    private Attempt attempt;
    private Node next;

    //constructor
    public Node(Attempt attempt, Node next){
        this.attempt = attempt;
        this.next = next;
    }

    //getters
    public Attempt getPayload(){return attempt;}
    public Node getNext(){return next;}


}


