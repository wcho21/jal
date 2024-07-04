package org.jal.apps;

public class Apps {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("usage: <app-name>");
    }

    String name = args[0];

    if (name.equals("hashdiff")) {
      HashDiff.main();
    }
  }
}
