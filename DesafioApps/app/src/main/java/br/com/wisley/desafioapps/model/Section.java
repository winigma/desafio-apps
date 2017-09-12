package br.com.wisley.desafioapps.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wisley on 12/09/17.
 */

public class Section implements Parcelable{

    private String nome;
    private String url;

    protected Section(Parcel in) {
        nome = in.readString();
        url = in.readString();
    }

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(url);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
