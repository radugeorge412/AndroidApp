package com.example.radugym;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
        @PrimaryKey
        public int id;


        public String firstName;

        @NonNull
        public String lastName;

        public int age;
        public int kg;
        public int heigth;

        public User(int id, String firstName, @NonNull String lastName, int age, int kg, int heigth) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.kg = kg;
            this.heigth=heigth;
        }
}

