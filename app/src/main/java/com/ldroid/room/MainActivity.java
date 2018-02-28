package com.ldroid.room;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ldroid.room.persistence.User;
import com.ldroid.room.persistence.UsersDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * val机制的sqlite
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(){
            @Override
            public void run() {
                final List<User> all = UsersDatabase.getInstance(MainActivity.this).userDao()
                        .getAll();
            }
        }.start();

    }

}
