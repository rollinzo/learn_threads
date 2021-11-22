class Jabber implements Runnable {
  String str;
  boolean plsYield;
  public Jabber(String s, boolean plsYield) { str = s; this.plsYield = plsYield;  }
  public void run() {
    int i = 0;
    while (i < 10) {
      System.out.print(str);
      System.out.println();
      i++;
      if (plsYield == true) { Thread.yield(); }
    }
  }

  public static void main(String[] args) {
    Jabber j = new Jabber("1: Yes Yield 1", true);
    Jabber k = new Jabber("2: --- Yes Yield 2", true);
    Thread t = new Thread(j);
    Thread u = new Thread(k);
    t.start();
    u.start();
    System.out.println("--------------------");
    Jabber j2 = new Jabber("3: Don't Yield 1", false);
    Jabber k2 = new Jabber("4: --- Don't Yield 2", false);
    Thread w = new Thread(j2);
    Thread v = new Thread(k2);
    w.start();
    v.start();

    System.out.println("--------------------");
    
    Jabber j3 = new Jabber("5: Yes Yield 1", true);
    Jabber k3 = new Jabber("6: --- Don't Yield 2", false);
    Thread a = new Thread(j3);
    Thread b = new Thread(k3);
    a.start();
    b.start();
  }
}
