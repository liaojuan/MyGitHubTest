package com.lc.liao.mygithub.objectprovider;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liao on 2017/3/9.
 *
 * 该类是基于现在用过的测试用的
 */

public class Contact implements Parcelable{

    public String name;
    public String password;

    protected Contact(Parcel in) {
        name = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
