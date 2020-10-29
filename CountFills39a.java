import java.util.Scanner;
public class CountFills39a{
  public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    final int SIZE = 8;
    int c[][] = { { 1, 0, 1, 0, 1, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 0, 1, 1, 1, 1, 0, 1 },
        { 0, 0, 1, 0, 1, 1, 1, 1 }, { 0, 1, 1, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 },
        { 0, 0, 0, 0, 0, 0, 0, 0 } };
    int xCount[][] = new int[SIZE][SIZE + 1];
    int yCount[][] = new int[SIZE + 1][SIZE];
    int xmx[] = new int[SIZE];
    int xw=0;
    int yw=0;
    int ymx[] = new int[SIZE];
    int x = 0, y = 0;
    int cnt = 0;
    for (y = 0; y < SIZE; y++) {
      cnt = 0;
      for (x = 0; x < SIZE; x++) {
        if(c[y][x]==1){
          while(x<SIZE&&c[y][x]==1){
            xCount[y][cnt]++;
            x++;
          }
          cnt++;
        }
      }
      xmx[y] = cnt;
      xw=Math.max(xw,cnt);
    }
    cnt = 0;
    for (y = 0; y < SIZE; y++) {
      cnt = 0;
      for (x = 0; x < SIZE; x++) {
        if(c[x][y]==1){
          while(x<SIZE&&c[x][y]==1){
            yCount[cnt][y]++;
            x++;
          }
          cnt++;
        }
      }
      ymx[y] = cnt;
      yw=Math.max(yw,cnt);
    }


    for(int i=0;i<yw;i++){
      for(int j=0;j<xw*2+1;j++){
        System.out.print(" ");
      }
      for(int j=0;j<SIZE;j++){
        if(ymx[j]>=yw-i){
          System.out.print(yCount[ymx[j]-yw+i][j]+" ");
        }else{
          System.out.print("  ");
        }
      }
      System.out.print("\n");
    }
    for(int j=0;j<xw*2+1;j++){
      System.out.print(" ");
    }
    System.out.println("---------------");
    for(int i=0;i<SIZE;i++){
      for(int j=0;j<xw;j++){
        if(j==xw-1){
          if(xmx[i]>=xw-j){
            System.out.print(xCount[i][xmx[i]-xw+j]);
          }else{
            System.out.print(" ");
          }
          break;
        }
        if(xmx[i]>=xw-j){
          System.out.print(xCount[i][xmx[i]-xw+j]+" ");
        }else{
          System.out.print("  ");
        }
      }
      System.out.print("||");
      for(int j=0;j<SIZE;j++){
        System.out.print("_"+" ");
      }
      System.out.print("\n");
    }
    System.out.println("Q:Write 0 or 1 in this blank(_)");
    int ans[][]=new int[SIZE][SIZE];
    for(int i=0;i<SIZE;i++){
      for(int j=0;j<SIZE;j++){
        ans[i][j]=sc.nextInt();
      }
    }
    int jadge=1;
    for(int i=0;i<SIZE;i++){
      for(int j=0;j<SIZE;j++){
        if(c[i][j]!=ans[i][j]) jadge=0;
      }
    }
    if(jadge==1){
      System.out.println("Clear!! You are very cool!!!");
    }else{
      System.out.println("Wrong answer! Please try again...");
    }
  }
}