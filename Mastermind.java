public class Mastermind{

private int pegNum;
private int pegColour;

public Mastermind(int pegNum, int pegColour){

this.pegNum = pegNum;
this.pegColour = pegColour;
  
}

public void setPegNum(int pegNum){
this.pegNum = pegNum;

}
 public int getPegNum(){
return pegNum;

}

public void setPegColour(int pegColour){
this.pegColour = pegColour;

}
 public int getPegColour(){
return pegColour;

}

String masterMind = "Number of pegs: " + this.getPegNum() + "Peg colours: " + this.getPegColour();

}