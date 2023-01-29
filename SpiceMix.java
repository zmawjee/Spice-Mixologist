class SpiceMix{
    //initialise variable
    char[] spices;

    //Constructor
    public SpiceMix(char[] spices){
        this.spices = spices;
    }

    //getter
    public char getSpice(int i){return spices[i];}

    // toString method that  displays the spicemix as a string
    public  String toString(){
        String a = "";
        for (int i =0; i < 5; i++){
            if (i == 4){
                a += this.spices[i];
            }
            else{
                a += this.spices[i] + " ";
            }
            
        }
        return a;
    }
}

class Attempt{
    //initialise variables
    SpiceMix suggestion, solution;

    //constructor
    public Attempt(SpiceMix suggestion, SpiceMix solution){
        this.suggestion = suggestion;
        this.solution = solution;
    }
    //getters
    public SpiceMix getSpiceMix(){return this.suggestion;}

    public int getNumGood(){
        int count = 0;
        for(int i=0; i<5; i++){
            if (this.suggestion.spices[i] == this.solution.spices[i]){
                count ++;
            }

        } 
        return count;
    }
    public int getNumWrongQuantity(){
        int count = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (this.suggestion.spices[i] == this.solution.spices[j]){
                    count++;
                }
            }
        }
        return count - this.getNumGood();
    }
    
    public boolean isCorrect(){
        if (getNumGood() ==  5 ){
            return true;
        }
        return false;
    }
    //to string method, returns object as string 
    public String toString(){
        return this.suggestion.toString() + " (Good " + getNumGood() + ", Wrong quantity " + getNumWrongQuantity() + ")";
    }
}
