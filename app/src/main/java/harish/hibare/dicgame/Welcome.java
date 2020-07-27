package harish.hibare.dicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class Welcome extends AppCompatActivity {
ImageView imageView1,imageView2;
Button button;
MediaPlayer mediaPlayer_dice;
int [] diceImages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView1=findViewById(R.id.imageDice1);
        imageView2=findViewById(R.id.imageDice2);
        button=findViewById(R.id.btnRollTheDice);
        mediaPlayer_dice=MediaPlayer.create(this,R.raw.dice_sound);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int random_number=random.nextInt(6);
                imageView1.setImageResource(diceImages[random_number]);

                random_number=random.nextInt(6);
                imageView2.setImageResource(diceImages[random_number]);
                YoYo.with(Techniques.RollIn)
                        .duration(700)
                        .repeat(1)
                        .playOn((imageView1));
                YoYo.with(Techniques.RollIn)
                        .duration(700)
                        .repeat(1)
                        .playOn((imageView2));
                mediaPlayer_dice.start();

            }
        });

    }
}