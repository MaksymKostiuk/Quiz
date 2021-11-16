package kost.max.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    Dialog dialog;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();//Для генерации случайных чисел
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //Код, который скругляет углы
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        //Код, который скругляет углы
        img_left.setClipToOutline(true);

        //Путь к левой и правой TextView
        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

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

        //Массив для прогресса игры - начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7,
                R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14,
                R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        //Массив для прогресса игры - конец

        //Подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);
        //Подключаем анимацию - конец


        numLeft = random.nextInt(10); //Генерируем число до 10
        img_left.setImageResource(array.images1[numLeft]); // Достаем из массива картинку
        text_left.setText(array.texts1[numLeft]);//Достаем из массива текст

        numRight = random.nextInt(10);

        //Цикл для проверки на равенство - начало
        while (numLeft == numRight){
            numRight = random.nextInt(10);
        }
        //Цикл для проверки на равенство - конец
        img_right.setImageResource(array.images1[numRight]);//Достаем из массива картинку
        text_right.setText(array.texts1[numRight]);//Достаем из массива текст

        //Обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки - начало
                    img_right.setEnabled(false); // Блокируем правую картинку
                    if(numLeft>numRight){
                        img_left.setImageResource(R.drawable.img_true);
                    }else{
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    //Если коснулся картинки - конец

                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    //Если отпустил палец - начало
                    if (numLeft > numRight) {
                        if(count<20){
                            count++;
                        }
                        //Закрашиваем прогресс серым цветом - начало
                        for (int i = 0; i < 20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогресс серым цветом - конец

                        //Определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правильные ответы и закрашиваем зеленым - конец

                    }else{
                        //Если левая картинка меньше
                    }
                    //Если отпустил палец - конец

                }
                //Условие касания картинки - конец
                return true;
            }
        });
        //Обрабатываем нажатие на левую картинку - конец
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