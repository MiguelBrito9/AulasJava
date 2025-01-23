package src.classesReutilizaveis;

import java.util.Map;

public class AlojamentoLocal extends Alojamento {

    public String localizacao;
    public TiposDeAlojamentoLocal tipoDeAlojamento;

    public AlojamentoLocal(Map<Integer, Quarto> quartosNoAlojamento, String nome, String localizacao, TiposDeAlojamentoLocal tipoDeAlojamento) {
        super(quartosNoAlojamento, nome);
        this.localizacao = localizacao;
        this.tipoDeAlojamento = tipoDeAlojamento;
    }

    @Override
    public String toString() {
        return "AlojamentoLocal{" +
                "localizacao='" + localizacao + '\'' +
                ", tipoDeAlojamento=" + tipoDeAlojamento +
                ", listaDeQuartos=" + listaDeQuartos +
                ", nome='" + nome + '\'' +
                '}';
    }
}
