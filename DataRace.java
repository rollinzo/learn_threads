class Counter {

  int myValue;

  Counter(){
    myValue = 0;
  }

  public int getValue() {
    return myValue;
  }

  synchronized int increment() {
     int aBefore = myValue;	    
     myValue += 1;
    
    return aBefore;
  }

}

class DataRace implements Runnable {
	
  
  Counter myCounter;
  int myID;

  DataRace(int myID, Counter myCounter) {
    this.myCounter = myCounter;
    this.myID = myID;
  }

	
  public void run(){
    int i = 0;
    while(i < 3) {
      int curr = myCounter.increment();
      System.out.println("Thread " + myID + " incremented from " + curr);
      i++;
    } 
  }

  public static void main(String args[]) throws InterruptedException {

      Counter sharedCounter = new Counter();
      Thread tee1 = new Thread(new DataRace(1, sharedCounter ));
      Thread tee2 = new Thread(new DataRace(2, sharedCounter ));
      tee1.start();
      tee2.start();
      tee1.join();
      tee2.join();
      System.out.println("Final value is: " + sharedCounter.getValue() );
    
  }
}
