package kost.max.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Level1 extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //Код, который скругляет углы
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        //Код, который скругляет углы
        img_left.setClipToOutline(true);

        //Развернуть игру на весь экран начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Развернуть игру на весь экран

        //Вызов диалогового окна в начале игры
        dialog = new Dialog(this); //Создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//Скрываем заголовок
        dialog.setContentView(R.layout.previewdialog);//Путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозрачный фон диалогового окна
        dialog.setCancelable(false);//Окно нельзя закрыть кнопкой Назад

        //Кнопка которая закрывает диалоговое окно начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки начало
                try{
                    //Вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);//Старт
                    finish();
                    //Вернуться назад к выбору уровня конец
                }catch (Exception e){
                    //Без кода
                }
                dialog.dismiss();//Закрываем диалоговое окно
                //Обрабатываем нажатие кнопки конец
            }
        });
        //Кнопка которая закрывает диалоговое окно конец

        //Кнопка Продолжить начало
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//Закрываем диалоговое окно
            }
        });
        //Кнопка Продолжить конец

        dialog.show();//показать диалоговое окно

        //Кнопка назад начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки Назад начало
                try{
                    //Вернуться к выбору 1-го уровня начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    //Вернуться к выбору 1-го уровня конец
                }catch(Exception e){
                    //Без кода
                }
                //Обрабатываем нажатие кнопки Назад конец
            }
        });
       //Кнопка назад конец
    }
    //Системная кнопка Назад начало
    @Override
    public void onBackPressed() {
        //Обрабатываем нажатие кнопки Назад начало
        try{
            //Вернуться к выбору 1-го уровня начало
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
            //Вернуться к выбору 1-го уровня конец
        }catch(Exception e){
            //Без кода
        }
        //Обрабатываем нажатие кнопки Назад конец
    }
    //Системная кнопка Назад конец
}