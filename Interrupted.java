class Interruptor implements Runnable {
  
  Thread myParent;

  public Interruptor(Thread myParent){
    this.myParent = myParent;
  }
  
  public void run(){
     try {
       for(int i = 15; i > 0; i--){
         System.out.println("Countdown: " + i);
         Thread.sleep(1000);
       }
       myParent.interrupt();
     } catch(InterruptedException e) {
       System.out.println("Interrupter Interrupted");
     }
  }
}

class Interrupted implements Runnable {
  
  public void run() {
      try {
        while(true) {
        System.out.println("This is just a test");
	Thread.sleep(2000);
       }
      } catch(InterruptedException e) {
         
	  System.out.println("I was interrupted."); 
      }
    
  }


  public static void main(String[] args){
     Thread tee = new Thread(new Interrupted());
     tee.start();
     Thread tee2 = new Thread(new Interruptor(tee));
     tee2.start();
  }
}
