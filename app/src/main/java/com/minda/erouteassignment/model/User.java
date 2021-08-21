package com.minda.erouteassignment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("code")
    int code;
    @SerializedName("data")
    List<UserModel> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<UserModel> getData() {
        return data;
    }

    public void setData(List<UserModel> data) {
        this.data = data;
    }

   public class UserModel{
        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
        @SerializedName("email")
        String email;
        @SerializedName("gender")
        String gender;
        @SerializedName("status")
        String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }







}
