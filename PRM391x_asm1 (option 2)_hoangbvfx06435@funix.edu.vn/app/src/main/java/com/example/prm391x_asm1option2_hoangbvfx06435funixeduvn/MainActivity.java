package com.example.prm391x_asm1option2_hoangbvfx06435funixeduvn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarMain;
    GridView gridViewAnimal;
    ArrayList<Animal> arrayListAnimals;
    AnimalAdapter animalAdapter;
    ImageView imgIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);

        gridViewAnimal = (GridView) findViewById(R.id.gridViewAnimal);
        arrayListAnimals = new ArrayList<>();
        addAnimal();

        animalAdapter = new AnimalAdapter(this, R.layout.list_animals, arrayListAnimals);
        gridViewAnimal.setAdapter(animalAdapter);

        gridViewAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                switch (position) {
                    case 0: {
                        bundle.putInt("img", R.drawable.bg_meo);
                        bundle.putString("name", "Cat");
                        bundle.putString("info", getString(R.string.text_cat) );
                        bundle.putBoolean("FAV", true);

                    }
                    break;
                    case 1: {
                        bundle.putInt("img", R.drawable.bg_cho);
                        bundle.putString("name", "Dog");
                        bundle.putString("info", getString(R.string.text_dog) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                    case 2: {
                        bundle.putInt("img", R.drawable.bg_camap);
                        bundle.putString("name", "Dolphin");
                        bundle.putString("info", getString(R.string.text_dolphin) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                    case 3: {
                        bundle.putInt("img", R.drawable.bg_huoucaoco);
                        bundle.putString("name", "Giraffe");
                        bundle.putString("info", getString(R.string.text_giraffe) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                    case 4: {
                        bundle.putInt("img", R.drawable.bg_gautruc);
                        bundle.putString("name", "Panda");
                        bundle.putString("info", getString(R.string.text_panda) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                    case 5: {
                        bundle.putInt("img", R.drawable.bg_heo);
                        bundle.putString("name", "Pig");
                        bundle.putString("info", getString(R.string.text_pig) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                    case 6: {
                        bundle.putInt("img", R.drawable.bg_camap);
                        bundle.putString("name", "Shark");
                        bundle.putString("info", getString(R.string.text_shark) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                    case 7: {
                        bundle.putInt("img", R.drawable.bg_ran);
                        bundle.putString("name", "Snake");
                        bundle.putString("info", getString(R.string.text_snake) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                    case 8: {
                        bundle.putInt("img", R.drawable.bg_rua);
                        bundle.putString("name", "Turtle");
                        bundle.putString("info", getString(R.string.text_turtle) );
                        bundle.putBoolean("FAV", true);
                    }
                    break;
                }
                intent.putExtras(bundle);

                // passing position as request code
                startActivityForResult(intent, position);

                //animation
                overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Animal animal = arrayListAnimals.get(requestCode);
        animal.isSelected = data.getBooleanExtra("isOn", false);

        if (animal != null) {
            if (animal.isSelected) {
                animal.setIc(R.drawable.ig_heart_asm1);
            } else {
                animal.setIc(0);
            }
        } else {
            startActivity(new Intent(MainActivity.this, DetailActivity.class));
        }

        arrayListAnimals.set(requestCode, animal);
        animalAdapter.notifyDataSetChanged();

        super.onActivityResult(requestCode, resultCode, data);
    }



    private void addAnimal() {
        arrayListAnimals.add(new Animal(R.drawable.img_cat_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_dog_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_dolphin_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_giraffe_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_panda_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_pig_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_shark_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_snake_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_turtle_asm1, 0));

    }
}