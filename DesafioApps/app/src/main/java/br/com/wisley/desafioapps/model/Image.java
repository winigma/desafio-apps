package br.com.wisley.desafioapps.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wisley on 12/09/17.
 */

public class Image implements Parcelable {
    private String autor;
    private String fonte;
    private String legenda;
    private String url;

    protected Image(Parcel in) {
        autor = in.readString();
        fonte = in.readString();
        legenda = in.readString();
        url = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(autor);
        parcel.writeString(fonte);
        parcel.writeString(legenda);
        parcel.writeString(url);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String copyRights() {
        String copy = "";
        if (!legenda.isEmpty()) {
            copy += legenda+" - ";
        }
        if (!fonte.isEmpty()) {
            copy += fonte;
        }

        return copy;
    }
}
