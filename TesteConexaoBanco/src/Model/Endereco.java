package Model;

public class Endereco {
    public int IdEndereco;
    public int Numero;
    public String Bairro;
    public String Municipio;
    public String CEP;

    public int getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        IdEndereco = idEndereco;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cEP) {
        CEP = cEP;
    }

}
