package kost.max.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Button button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Здесь будет команда для кнопки

                //начало конструкции
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {
                }//конец конструкции
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //Системная кнопка "Назад" начало
    @Override
    public void onBackPressed() {
        //начало конструкции
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
        //Конец конструкции
    }
    //Системная кнопка Назад конец
}