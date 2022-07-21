package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play;
    Coin pos00,pos01,pos02,pos10,pos11,pos12,pos20,pos21,pos22;
    int[] gameState={0,0,0,0,0,0,0,0,0};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public int col=1;
    class Coin{
        //public int col;
        ImageView imageViewLoc;
        public boolean occupied=false;
        int x,y;
        public Coin(ImageView imageViewLoc,int x,int y){
            //this.col=col;
            this.imageViewLoc=imageViewLoc;
            this.x=x;
            this.x=y;
            occupied=false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ImageView pos00=(ImageView) findViewById(R.id.imageView1);
//        ImageView pos01=(ImageView) findViewById(R.id.imageView2);
//        ImageView pos02=(ImageView) findViewById(R.id.imageView3);
//        ImageView pos10=(ImageView) findViewById(R.id.imageView4);
//        ImageView pos11=(ImageView) findViewById(R.id.imageView5);
//        ImageView pos12=(ImageView) findViewById(R.id.imageView6);
//        ImageView pos20=(ImageView) findViewById(R.id.imageView7);
//        ImageView pos21=(ImageView) findViewById(R.id.imageView8);
//        ImageView pos22=(ImageView) findViewById(R.id.imageView9);
        pos00=new Coin((ImageView) findViewById(R.id.imageView1),0,0 );
        pos01=new Coin((ImageView) findViewById(R.id.imageView2),0,1 );
        pos02=new Coin((ImageView) findViewById(R.id.imageView3),0,2 );
        pos10=new Coin((ImageView) findViewById(R.id.imageView4),1,0 );
        pos11=new Coin((ImageView) findViewById(R.id.imageView5),1,1 );
        pos12=new Coin((ImageView) findViewById(R.id.imageView6),1,2 );
        pos20=new Coin((ImageView) findViewById(R.id.imageView7),2,0 );
        pos21=new Coin((ImageView) findViewById(R.id.imageView8),2,1 );
        pos22=new Coin((ImageView) findViewById(R.id.imageView9),2,2 );
        play=(Button) findViewById(R.id.button);


    }
    public void onClick(View view){

        ImageView imageView=(ImageView) view;
        if(imageView.getAlpha()==1){
            Toast.makeText(this,"Already filled",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(col==1){
            imageView.setImageResource(R.drawable.red);
        }
        else{
            imageView.setImageResource(R.drawable.yellow);
        }
        int tappedCounter=Integer.parseInt(imageView.getTag().toString());
        gameState[tappedCounter]=col;
        float temp=imageView.getY();
        imageView.setY(temp-6000);
        imageView.animate().translationYBy(+6000).alpha(1).setDuration(500);
//        if(imageView.getTag().equals(1))
//            checkWinner(col,pos00);
//        else if(imageView.getTag().equals(2))
//            checkWinner(col,pos01);
//        else if(imageView.getTag().equals(3))
//            checkWinner(col,pos02);
//        else if(imageView.getTag().equals(4))
//            checkWinner(col,pos10);
//        else if(imageView.getTag().equals(5))
//            checkWinner(col,pos11);
//        else if(imageView.getTag().equals(6))
//            checkWinner(col,pos12);
//        else if(imageView.getTag().equals(7))
//            checkWinner(col,pos20);
//        else if(imageView.getTag().equals(8))
//            checkWinner(col,pos21);
//        else
//            checkWinner(col,pos22);

        for(int[] winningPosition: winningPositions){
            if(gameState[winningPosition[0]]==gameState[winningPosition[1]] && gameState[winningPosition[1]]== gameState[winningPosition[2]] && gameState[winningPosition[0]]!=0){
                if(col==1){
                    Toast.makeText(this,"Red has Won!",Toast.LENGTH_LONG).show();
                    play.animate().alpha(1).setDuration(1000);

                    break;
                }
                else if(col==2){
                    Toast.makeText(this,"Yellow has Won!",Toast.LENGTH_LONG).show();
                    play.animate().alpha(1).setDuration(1000);
                    break;
                }
            }
        }
        if(col==1){
            col=2;
        }
        else{
            col=1;
        }

    }
//    public boolean checkWinner(int color, Coin coin){
//        int count=0;
//        String temp=coin.imageViewLoc.getTag().toString();
//        int tag=Integer.parseInt(temp);
//        for(int i=1;i<=2;i++){
//
//        }
//        return true;
//    }
    public void refresh(View view){
        for(int pos:gameState){
            gameState[pos]=0;
        }
        col=1;
        pos00.imageViewLoc.animate().alpha(0).setDuration(10);
        pos01.imageViewLoc.animate().alpha(0).setDuration(10);
        pos02.imageViewLoc.animate().alpha(0).setDuration(10);
        pos10.imageViewLoc.animate().alpha(0).setDuration(10);
        pos11.imageViewLoc.animate().alpha(0).setDuration(10);
        pos12.imageViewLoc.animate().alpha(0).setDuration(10);
        pos20.imageViewLoc.animate().alpha(0).setDuration(10);
        pos21.imageViewLoc.animate().alpha(0).setDuration(10);
        pos22.imageViewLoc.animate().alpha(0).setDuration(10);
        play.animate().alpha(0).setDuration(1000);

    }
}