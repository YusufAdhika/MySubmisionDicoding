package com.example.mysubmisiondicoding;

import android.os.Parcel;
import android.os.Parcelable;

public class Rumah implements Parcelable {
    private String name;
    private String detail;
    private int photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.detail);
        dest.writeInt(this.photo);
    }

    public Rumah() {
    }

    protected Rumah(Parcel in) {
        this.name = in.readString();
        this.detail = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<Rumah> CREATOR = new Parcelable.Creator<Rumah>() {
        @Override
        public Rumah createFromParcel(Parcel source) {
            return new Rumah(source);
        }

        @Override
        public Rumah[] newArray(int size) {
            return new Rumah[size];
        }
    };
}
