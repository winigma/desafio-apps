package br.com.wisley.desafioapps.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Wisley on 13/09/17.
 */

public class Result implements Parcelable{
    private List<Content> conteudos;
    private String produto;

    protected Result(Parcel in) {
        conteudos = in.createTypedArrayList(Content.CREATOR);
        produto = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(conteudos);
        parcel.writeString(produto);
    }

    public List<Content> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Content> conteudos) {
        this.conteudos = conteudos;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
