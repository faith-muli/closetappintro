package program.com.closetappintro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;


public class CustomIntro extends AppIntro {

    @Override
    public  void init(Bundle savedInstanceState) {
        addSlide(new FirstSlide(), getApplicationContext());
        addSlide(new SecondSlide(), getApplicationContext());
        addSlide(new ThirdSlide(), getApplicationContext());
        addSlide(new FourthSlide(), getApplicationContext());

        /*setBarColor(Color.parseColor("#FF6B53"));
        setSeparatorColor(Color.parseColor("#2196F3"));*/
        showSkipButton(true);
        setVibrate(true);
        setVibrateIntensity(30);
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed() {
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDonePressed() {

        loadMainActivity();
    }

    public void getStarted(View v){
        loadMainActivity();
    }
}