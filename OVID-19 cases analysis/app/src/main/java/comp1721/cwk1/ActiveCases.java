package comp1721.cwk1;

import java.io.IOException;

public class ActiveCases {
  // Implement program for full solution here
  public static void main(String[] args) {
      if(args.length!=2){
          System.out.println("Rerun and enter the specified file parameters");
          System.exit(1);
      }
      CovidDataset dataset=new CovidDataset();
      try {
          dataset.readDailyCases("D:\\final coursework\\coursework\\cwk1\\chart\\datafiles\\2020-daily.csv");
          dataset.writeActiveCases("D:\\final coursework\\Scoursework\\cwk1\\chart\\datafiles\\2020-active.csv");
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
