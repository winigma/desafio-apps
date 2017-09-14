package br.com.wisley.desafioapps.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Wisley on 12/09/17.
 */

public class Content implements Parcelable {

    private List<String> autores;
    private boolean informePublicitario;
    private String subTitulo;
    private String texto;
    private String atualizadoEm;
    private int id;
    private String publicadoEm;
    private String tipo;
    private String titulo;
    private String url;
    private String urlOriginal;
    private List<Image> imagens;
    private Section secao;


    private boolean isHeader;


    protected Content(Parcel in) {
        autores = in.createStringArrayList();
        informePublicitario = in.readByte() != 0;
        subTitulo = in.readString();
        texto = in.readString();
        atualizadoEm = in.readString();
        id = in.readInt();
        publicadoEm = in.readString();
        tipo = in.readString();
        titulo = in.readString();
        url = in.readString();
        urlOriginal = in.readString();
        imagens = in.createTypedArrayList(Image.CREATOR);
        secao = in.readParcelable(Section.class.getClassLoader());
    }

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(autores);
        parcel.writeByte((byte) (informePublicitario ? 1 : 0));
        parcel.writeString(subTitulo);
        parcel.writeString(texto);
        parcel.writeString(atualizadoEm);
        parcel.writeInt(id);
        parcel.writeString(publicadoEm);
        parcel.writeString(tipo);
        parcel.writeString(titulo);
        parcel.writeString(url);
        parcel.writeString(urlOriginal);
        parcel.writeTypedList(imagens);
        parcel.writeParcelable(secao, i);
    }

    public List<String> getAutores() {

        return autores;
    }

    public String author() {
        if (autores != null && autores.size() > 0) {
            String publisher = " ";
            for (String author : autores) {
                publisher += author;
            }
            return publisher;
        } else
            return "";
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public boolean isInformePublicitario() {
        return informePublicitario;
    }

    public void setInformePublicitario(boolean informePublicitario) {
        this.informePublicitario = informePublicitario;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(String atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublicadoEm() {
        return publicadoEm;
    }

    public void setPublicadoEm(String publicadoEm) {
        this.publicadoEm = publicadoEm;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public List<Image> getImagens() {
        return imagens;
    }

    public void setImagens(List<Image> imagens) {
        this.imagens = imagens;
    }

    public Section getSecao() {
        return secao;
    }

    public void setSecao(Section secao) {
        this.secao = secao;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }
}
